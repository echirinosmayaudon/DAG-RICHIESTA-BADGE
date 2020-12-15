package com.intranet.mef.importusers.service.util;

import java.util.List;
import java.util.concurrent.Callable;

import it.smc.osportal.sc.commons.service.SCHelperLocalServiceUtil;

import com.intranet.mef.importusers.costants.ImportUsersDestinationNames;
import com.intranet.mef.importusers.service.ImportUsersHelperLocalServiceUtil;
import com.intranet.mef.importusers.service.configuration.ImportUsersConfigurationValues;
import com.intranet.mef.job.siap.model.UserFrontierBind;
import com.intranet.mef.job.siap.service.UserFrontierBindLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackUtil;
import com.liferay.portal.kernel.util.PortalUtil;


public class ImportUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.importusers.service.ReplicaUsersHelperLocalServiceUtil} to access the replica users helper local service.
	 */
	public static void checkImportUsers(StringBuilder emailBody){

		MailUtil._trackCompanyHeader(emailBody, "Import SIAP");

		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		Role administratorRoleTarget = null;
		try {
			administratorRoleTarget = RoleLocalServiceUtil.getRole(
				defaultCompanyId, RoleConstants.ADMINISTRATOR);
		} catch (PortalException e1) {
			_log.error(e1);
		}

		List<User> adminstratorsTarget = UserLocalServiceUtil.
			getRoleUsers(administratorRoleTarget.getRoleId());

		User master = adminstratorsTarget.get(0);

		CompanyThreadLocal.setCompanyId(defaultCompanyId);
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

//		List<UserFrontierBind> usersImport =
//			UserFrontierBindLocalServiceUtil.getUserFrontierBinds(
//				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		List<UserFrontierBind> usersImport =
				UserFrontierBindLocalServiceUtil.getUserFrontierBindsWithoutCache(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
	

		int i = 1;
		int countTotal = usersImport.size();
		
		_log.info("LF_FRONTIERA COUNT "+ countTotal);

		for (UserFrontierBind userFrontierBind : usersImport) {

			_log.info("IMPORT PROCESS COUNT: "+ i + " su " + countTotal);

			ImportUsersHelperLocalServiceUtil.importUser(
				defaultCompanyId, userFrontierBind, emailBody);

			i++;
		}

		try {
			_fireSingleReplicaUser();
		} catch (PortalException e) {
			_log.error(e);
		}

	}

	/**
	 * Regista una TransactionCommitCallback per effettuare l'allineamento
	 * degli utenti nella istanza Social Collaboration al commit; ma solo dopo il commit
	 *
	 * @param companyId
	 * @throws PortalException
	 */
	private static void _fireSingleReplicaUser() throws PortalException {

		Callable<Void> callable = new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				if (ImportUsersConfigurationValues.START_REPLICA_LISTENER){
					long[] companyIds = PortalUtil.getCompanyIds();

					for (long companyId : companyIds) {

						if (SCHelperLocalServiceUtil.
							isSocialCollaborationCompany(companyId)){

							try {
								if (_log.isInfoEnabled()) {
									_log.info("Start Replica Users ...");
								}

								//Lancio MB Replica User MAster to Slave
								String destinationName =
									ImportUsersDestinationNames.REPLICA_USER;

								if (MessageBusUtil.hasMessageListener(
										destinationName)) {

										Message message = new Message();
	
										message.setDestinationName(destinationName);
										message.put("companyId", companyId);
	
										MessageBusUtil.sendMessage(
											destinationName, message);
									
								}

							}
							catch (Exception e) {
								_log.error(e, e);
							}
						}
					}
				}else{
					//Lancio BCK user Frontiera a conclusione
					_log.info("CALL FUNCTION BCK FRONTIER");
					String logLoadBCK = UserFrontierBindLocalServiceUtil.callLoadBCK();

					if (Boolean.valueOf(logLoadBCK)){
						_log.info("CARICAMENTO BACKUP USERS FRONTIERA EFFETTUATO CON SUCCESSO !!!");
					}else{
						_log.error("CARICAMENTO BACKUP USERS FRONTIERA CALL FALSE");
					}
				}

				return null;
			}

		};

		TransactionCommitCallbackUtil.registerCallback(callable);
	}

	private static final Log _log = LogFactoryUtil.getLog(ImportUserUtil.class);
}
