package com.intranet.mef.importusers.service.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.intranet.mef.importusers.service.ReplicaUsersHelperLocalServiceUtil;
import com.intranet.mef.importusers.service.configuration.ImportUsersConfigurationValues;
import com.intranet.mef.job.siap.model.UserFrontierBind;
import com.intranet.mef.job.siap.service.UserFrontierBindLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import it.smc.osportal.sc.commons.service.SCHelperLocalServiceUtil;
import it.smc.osportal.sc.dashboard.constants.DashboardDestinationNames;
import it.smc.osportal.sc.dashboard.service.DashboardHelperLocalServiceUtil;

public class ReplyUserUtil {

	public static void checkReplicaUsers(long companyId, StringBuilder emailBody)
		throws PortalException {

		MailUtil._trackCompanyHeader(emailBody, "Replica");

		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		if (defaultCompanyId == companyId) {
			_log.info("Skip default Company");

			return;
		}

		Role administratorRoleTarget = RoleLocalServiceUtil.getRole(
			companyId, RoleConstants.ADMINISTRATOR);

		List<User> adminstratorsTarget = UserLocalServiceUtil.
			getRoleUsers(administratorRoleTarget.getRoleId());

		User master = adminstratorsTarget.get(0);

		CompanyThreadLocal.setCompanyId(companyId);
		LocaleThreadLocal.setDefaultLocale(LocaleUtil.ITALY);
		PrincipalThreadLocal.setName(master.getUserId());

		PermissionChecker permissionChecker;
		try {
			permissionChecker = PermissionCheckerFactoryUtil.create(master);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);	
		} catch (Exception e) {
			if(_log.isDebugEnabled()){
				_log.error(e);
			}
			_log.error("No PermissionChecker "+ e.getStackTrace());

		}

		Company targetCompany = CompanyLocalServiceUtil.getCompany(companyId);

		Role userRoleMaster = RoleLocalServiceUtil.getRole(
			defaultCompanyId, RoleConstants.USER);

		Role userRoleTarget = RoleLocalServiceUtil.getRole(
			companyId, RoleConstants.USER);

		// Verifico che tutti gli utenti presenti nell'istanza
		// Master siamo presenti e corretti nell'istanza Target.
		// Gli utenti sono identificati per ScreenName

		List<String> masterScreenNames = _checkMasterInstanceUsers (
			emailBody, targetCompany, userRoleMaster, userRoleTarget);

		//Calculate Quota Collector
		String destinationName =
				DashboardDestinationNames.QUOTA_COLLECTOR;

		if (MessageBusUtil.hasMessageListener(destinationName)) {
			Message message = new Message();

			message.setDestinationName(destinationName);
			message.put("companyId", companyId);
			message.put("fullMode", false);

			if (_log.isDebugEnabled()) {
				_log.debug("send " + message);
			}

			MessageBusUtil.sendMessage(destinationName, message);
		}

		// Rimuovo nell'istanza Target gli utenti Instance non presenti
		// nell'istanza Master

		_checkTargetInstanceUsers(
			emailBody, targetCompany, masterScreenNames,
			userRoleTarget);

	}

	private static void _addMembership(User targetUser,
		List<UserGroup> userGroupsService, Role roleContributor) {

		boolean isUserActive = targetUser.isActive();
		long[] userGroupIds = targetUser.getUserGroupIds();
		boolean hasUserGroupService = false;
		for (UserGroup userGroup : userGroupsService) {
			if (ArrayUtil.contains(userGroupIds, userGroup.getUserGroupId())){
				hasUserGroupService = true;
				break;
			}
		}

		//Recupero membership
		String[] addMembershipUser = ImportUsersConfigurationValues.
			ADD_MEMBERSHIP_IN_INSTANCE_SC;
		
		//Recupero Membership & Role Contributor
		String[] addMembershipAndRoleContributor = ImportUsersConfigurationValues.
				ADD_MEMBERSHIP_AND_CONTRIBUTOR_ROLE_IN_INSTANCE_SC;
		
		// add membership ai soli utenti con usergroup di tipo Service
		if (isUserActive && hasUserGroupService){

			//ADD Membership
			for (String grouIdMembership : addMembershipUser) {
				Group groupMembership = GroupLocalServiceUtil.fetchGroup(
					Long.valueOf(grouIdMembership));
				if (Validator.isNotNull(groupMembership)){
					UserLocalServiceUtil.addGroupUser(
						groupMembership.getGroupId(), targetUser.getUserId());
				}
			}

			//ADD Membership & Role Contributor
			for (String grouIdMembership : addMembershipAndRoleContributor) {
				Group groupMembership = GroupLocalServiceUtil.fetchGroup(
					Long.valueOf(grouIdMembership));
				if (Validator.isNotNull(groupMembership)){
					UserLocalServiceUtil.addGroupUser(
						groupMembership.getGroupId(), targetUser.getUserId());
					if (Validator.isNotNull(roleContributor)){
						UserGroupRoleLocalServiceUtil.addUserGroupRoles(
							targetUser.getUserId(), groupMembership.getGroupId(),
							new long[]{roleContributor.getRoleId()});
					}
				}
			}
		}	
	}

	private static void _checkTargetInstanceUsers(
			StringBuilder emailBody, Company targetCompany,
			List<String> masterScreenNames, Role userRoleTarget)
		throws PortalException{

		String roleContributorName = "Space Contributor";
		//Recupero Role Contributor
		Role roleContributor = RoleLocalServiceUtil.fetchRole(
			targetCompany.getCompanyId(), roleContributorName);

		// Recupero gli utenti nell'istanza Target collegati al ruolo
		// "USER"

		List<User> targetUsers = UserLocalServiceUtil.getRoleUsers(
			userRoleTarget.getRoleId());

		List<UserGroup> userGroupsService =
			SCHelperLocalServiceUtil.getServiceUserGroups(
					targetCompany.getCompanyId());

		for (User targetUser : targetUsers) {

			// Se l'utente e' presente nella lista significa che non lo devo
			// cancellare

			boolean found = masterScreenNames.contains(
				targetUser.getScreenName().toLowerCase());

			if (found) {
				if (ImportUsersConfigurationValues.ADD_MEMBERSHIP_ENABLE){
					_addMembership(targetUser, userGroupsService, roleContributor);
				}
				continue;
			}

			// Non posso cancellare l'utente Administrator di default di Liferay

			boolean isDefaultAdmin =
				targetUser.getScreenName().equalsIgnoreCase(
					PropsUtil.get(PropsKeys.DEFAULT_ADMIN_SCREEN_NAME))
				|| SCHelperLocalServiceUtil.isCompanySupervisor(targetUser);

			if (isDefaultAdmin) {
				MailUtil._trackImpossibileDeleteUser(emailBody, targetUser);

				continue;
			}

			// Lo posso cancellare

			UserLocalServiceUtil.deleteUser(targetUser.getUserId());

			MailUtil._trackDeleteUser(emailBody, targetUser);
		}
	}

	private static List<String> _checkMasterInstanceUsers(
			StringBuilder emailBody, Company targetCompany,
			Role userRoleMaster, Role userRoleTarget)
		throws PortalException {

		long targetCompanyId = targetCompany.getCompanyId();

		List <String> screenNames = new ArrayList<String>();

		// Recupero gli utenti nell'istanza master collegati al ruolo
		// "User"

		List<User> masterUsers = UserLocalServiceUtil.getRoleUsers(
			userRoleMaster.getRoleId());

		//REcupero gli user da frontiera
		Set<String> screenNameUserFrontier = new HashSet<>();
		boolean updateOnlyUsersFrontier =
			ImportUsersConfigurationValues.REPLICA_ONLY_USERS_FRONTIERS;

		int countTotal = masterUsers.size();

		if (updateOnlyUsersFrontier){
			List<UserFrontierBind> usersFrontiers =
				UserFrontierBindLocalServiceUtil.getUserFrontierBinds(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (Iterator<UserFrontierBind> iterator = usersFrontiers.iterator(); iterator.hasNext();) {
				UserFrontierBind userFrontierBind = iterator.next();
				screenNameUserFrontier.add(userFrontierBind.getScreenName().
					toLowerCase());
			}

			countTotal = screenNameUserFrontier.size();
		}

		int i = 1, master=1;

		_log.info("======================");
		_log.info("REPLICA PROCESS COUNT [TOTALE MASTER:"+masterUsers.size()+"]"+
			" DA REPLICARE "+countTotal);
		_log.info("======================");

		for (User masterUser : masterUsers) {

			// Recupero, per screenName, l'utente nell'istanza che sto
			// processando
			_log.info("CICLO: "+ master + " su " + masterUsers.size());
			master++;

			User targetUser = UserLocalServiceUtil.fetchUserByScreenName(
				targetCompanyId, masterUser.getScreenName().toLowerCase());

			// Salto aggiornamento perche' e' attiva la properties per aggiornamento
			// dei soli users in frontiera
			if(updateOnlyUsersFrontier && 
				(screenNameUserFrontier.isEmpty() ||
				!screenNameUserFrontier.contains(
					masterUser.getScreenName().toLowerCase()))){

				screenNames.add(masterUser.getScreenName().toLowerCase());
				_log.info("CICLO SALTO "+masterUser.getScreenName().toLowerCase());
				continue;
			}

			_log.info("REPLICA CICLO: "+ i + " su " + countTotal);
			i++;

			boolean updateTargetSite = ImportUsersConfigurationValues.
				REPLICA_USERS_UPDATE_SITE_TARGET;

			if (targetUser != null) {
				//effettuo update
 
				boolean isDefaultAdmin =
					targetUser.getScreenName().equalsIgnoreCase(
						PropsUtil.get(PropsKeys.DEFAULT_ADMIN_SCREEN_NAME));

				if (isDefaultAdmin){
					continue;
				}

				
				try{
					targetUser =  ReplicaUsersHelperLocalServiceUtil.updateTargetUser(
							masterUser, targetUser);

						MailUtil._trackUpdateUser(emailBody, targetUser);
					}catch(Exception e){
						if(_log.isDebugEnabled()){
							_log.error(e);
						}
						
						MailUtil._trackErrorReplica(
								emailBody, masterUser, "Replicare",
								e.getMessage());
								
					}
				
			}else{
				// add utente
				// Verifico non esista gia' un utente con la stessa email

				User checkUser = UserLocalServiceUtil.fetchUserByEmailAddress(
					targetCompanyId, masterUser.getEmailAddress());

				if (checkUser == null) {
					try{
					targetUser = ReplicaUsersHelperLocalServiceUtil.addTargetUser(
						masterUser, targetCompanyId);
					updateTargetSite = true;
					MailUtil._trackCreateUser(emailBody, targetUser);
					}catch(Exception e){
						if(_log.isDebugEnabled()){
							_log.error(e);
						}
						
						MailUtil._trackErrorReplica(
								emailBody, masterUser, "Replicare",
								e.getMessage());
								
					}

					
				}
				else {
					MailUtil._trackErrorUpdateEmail(emailBody, masterUser);
				}
			}	

			// Create site target User
			if (updateTargetSite){
				try {
					_log.info("CREO / AGGIORNO SITO TARGET");

					DashboardHelperLocalServiceUtil.checkUserTargetSite(
						targetUser);
				}
				catch (Exception e) {
					_log.error(e);
					MailUtil._trackErrorCreateSiteTargetUser(
						emailBody, targetUser, targetCompany);
				}
			}

			//Save screenname in temp list

			screenNames.add(masterUser.getScreenName().toLowerCase());
		}

		return screenNames;
	}

	private static final Log _log = LogFactoryUtil.getLog(ReplyUserUtil.class);
}
