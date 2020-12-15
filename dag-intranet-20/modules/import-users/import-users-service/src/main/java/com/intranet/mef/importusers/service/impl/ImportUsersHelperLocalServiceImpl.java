/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.intranet.mef.importusers.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.central.util.UserAddressUtil;
import com.intranet.mef.central.util.UserPhoneUtil;
import com.intranet.mef.importusers.service.base.ImportUsersHelperLocalServiceBaseImpl;
import com.intranet.mef.importusers.service.configuration.ImportUsersConfigurationValues;
import com.intranet.mef.importusers.service.util.MailUtil;
import com.intranet.mef.job.siap.constants.IntranetMefConstants;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.ManagerOfficesBind;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.model.UserFrontierBind;
import com.intranet.mef.job.siap.service.ManagerOfficesBindLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.job.siap.service.UserFrontierBindLocalServiceUtil;
import com.intranet.mef.job.siap.util.JobsUtility;
import com.liferay.announcements.kernel.model.AnnouncementsDelivery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.service.persistence.TeamUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import it.smc.osportal.sc.commons.constants.SCConstants;

/**
 * The implementation of the replica users helper local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.importusers.service.ReplicaUsersHelperLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Domenico Costa
 * @see ImportUsersHelperLocalServiceImpl
 * @see com.intranet.mef.importusers.service.ImportUsersHelperLocalServiceUtil
 */
@ProviderType
public class ImportUsersHelperLocalServiceImpl
	extends ImportUsersHelperLocalServiceBaseImpl {
	
	
	public void importUser(long companyId, UserFrontierBind userFrontierBind,
			StringBuilder emailBody){
		
		String screenName = userFrontierBind.getScreenName().toLowerCase();

		User user = userLocalService.fetchUserByScreenName(companyId, screenName);

		long groupIdIntranetMef = 0;
		String siteURL= "/guest";//guest default 
		try{
			siteURL = PropsUtil.get("mef-intranet-site-url");
		} catch (Exception e) {
			if(_log.isDebugEnabled()){
				_log.error(e);
			}
			_log.error("KEY mef-intranet-site-url non presente in portletEXT settato default /guest");
		}

		if (Validator.isNotNull(siteURL) || !siteURL.isEmpty()){

			try {
				groupIdIntranetMef = GroupLocalServiceUtil.getFriendlyURLGroup(
					companyId,siteURL).getGroupId();

			} catch (PortalException e) {
				if(_log.isDebugEnabled()){
					_log.error(e);
				}
				_log.error("SITE settato in KEY mef-intranet-site-url non trovato");
			}

		}

		if (user == null){
			//add user
			
			User checkUser = userLocalService.fetchUserByEmailAddress(
				companyId, userFrontierBind.getEmail().toLowerCase());

			if (checkUser == null) {
				User targetUser;
				try {
					MailUtil._trackUser(emailBody, screenName);

					targetUser = _addUser(companyId, userFrontierBind,
						groupIdIntranetMef, emailBody);
					MailUtil._trackCreateUser(emailBody, targetUser);

				} catch (Exception e) {
					if(_log.isDebugEnabled()){
						_log.error(e);
					}
					_log.error("IMPORT ADD USER :"+e.getMessage());
					MailUtil._trackErrorImport(
						emailBody, userFrontierBind, "Aggiungere",
						e.getMessage());

					//Lancio ERROR FUNCTION 
					_log.info("CALL FUNCTION Error for cf :"+screenName);
					String logErrorFunction = UserFrontierBindLocalServiceUtil.
						callErrorImport(screenName);

					if (Boolean.valueOf(logErrorFunction)){
						_log.info("CALL FUNCTION Error RESULT: SUCCESS");
					}else{
						_log.error("CALL FUNCTION Error RESULT: ERROR");
					}

				}

			}
			else {
				MailUtil._trackErrorUpdateEmail(emailBody, checkUser);
			}

		}else{

			try {
				MailUtil._trackUser(emailBody, screenName);
				user = _updateUser(companyId, userFrontierBind, user,
					groupIdIntranetMef, emailBody);
				MailUtil._trackUpdateUser(emailBody, user);

			} catch (Exception e) {
				
				if(_log.isDebugEnabled()){
					_log.error(e);
				}

				_log.error("IMPORT UPDATE USER :"+e.getMessage());
				MailUtil._trackErrorImport(
					emailBody, userFrontierBind, "Aggiornare", e.getMessage());

				//Lancio ERROR FUNCTION 
				_log.info("CALL FUNCTION Error for cf :"+screenName);
				String logErrorFunction = UserFrontierBindLocalServiceUtil.
					callErrorImport(screenName);

				if (Boolean.valueOf(logErrorFunction)){
					_log.info("CALL FUNCTION Error RESULT: SUCCESS");
				}else{
					_log.error("CALL FUNCTION Error RESULT: ERROR");
				}

			}

			
		}

	}

	private User _addUser(long companyId, UserFrontierBind userFrontierBind,
			long groupId, StringBuilder emailBody)
		throws PortalException{

		String screenName = userFrontierBind.getScreenName().toLowerCase(); 
		String name = userFrontierBind.getName();
		String surname = userFrontierBind.getSurName();
		boolean gender = true;
		if ("F".equalsIgnoreCase(userFrontierBind.getGender())){
			gender = false;
		}

		long idOrgChart = userFrontierBind.getIdOrgChart();
		long personId = userFrontierBind.getPersonalId();

		String email = userFrontierBind.getEmail().toLowerCase();

		_log.info("========================================");
		_log.info("Import user da Frontiera: "+userFrontierBind.toString());
		_log.info("check SCRENNAME "+screenName);
		_log.info("check MAil "+ email);
		_log.info("========================================");

		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();

		birthdayCal.setTime(userFrontierBind.getDateBirth());

		ServiceContext serviceContext = new ServiceContext();

		List<Address> addresses = _factoryAddress(companyId, userFrontierBind);
		List<EmailAddress> emailAddresses = new ArrayList<>();
		List<Phone> phones = _factoryPhone(companyId, userFrontierBind);
		List<Website> websites = new ArrayList<>();
		List<AnnouncementsDelivery> announcementsDeliveries = new ArrayList<>();
        
	
		//get user positions
		String posGiu = userFrontierBind.getGiuridicPos();
		String posEco = userFrontierBind.getEconomicPos();
		
		
		long[] groupIds = new long[]{groupId};
		long[] organizationIds = new long[]{};
		long[] roleIds = new long[]{};
		

		//add positions roles
        if(Validator.isNotNull(posGiu)){
            long roleIdPosGiu =  JobsUtility.getRolePosGiuridica(posGiu);
            if (roleIdPosGiu > 0)
                  roleIds = ArrayUtil.append(roleIds, roleIdPosGiu);
            else
            	_log.info("non esiste il ruolo POS configurato su liferay");
        }else{
        	_log.info("utente con ruolo POS_GIURIDICO nullo");
        }
		if(Validator.isNotNull(posEco)){
            long roleIdPosEco =  JobsUtility.getRolePosEconomica(posEco);
            if (roleIdPosEco > 0)
                  roleIds = ArrayUtil.append(roleIds, roleIdPosEco);
            else
            	_log.info("non esiste il ruolo POS configurato su liferay");
		}else{
        	_log.info("utente con ruolo POS_ECONOMICO nullo");
        }
		roleIds = _factoryRoles(roleIds, idOrgChart, personId, companyId, emailBody);
		long[] userGroupIds = new long[]{};

		List<ManagerOfficesBind> reggenti = ManagerOfficesBindLocalServiceUtil.
			getManagerOfficesBindByPersonId(personId);
		
		_log.info("IdOrgChart UTENTE  "+ idOrgChart);
		_log.info("Reggenze size "+ reggenti.size());
		for (ManagerOfficesBind managerOfficesBind : reggenti) {
			_log.info("Reggenze id reggenza "+ managerOfficesBind.getIdOrgChart());
			if (managerOfficesBind.getIdOrgChart() != idOrgChart){
				_log.info("ENTRO REGGENZA RUOLI "+ Arrays.toString(roleIds));
				roleIds = _factoryRoles(roleIds,
					managerOfficesBind.getIdOrgChart(), personId, companyId,
					emailBody);
				_log.info("USCITA REGGENZA RUOLI "+ Arrays.toString(roleIds));
			}
		}

		User targetUser = UserServiceUtil.addUser(
			companyId, true, StringPool.BLANK, StringPool.BLANK, false,
			screenName, email, 0L, StringPool.BLANK, LocaleUtil.ITALY, name,
			StringPool.BLANK, surname, 1L, 1L, gender,
			birthdayCal.get(Calendar.MONTH), birthdayCal.get(Calendar.DATE),
			birthdayCal.get(Calendar.YEAR), StringPool.BLANK, groupIds,
			organizationIds, roleIds, userGroupIds, addresses, emailAddresses,
			phones, websites, announcementsDeliveries, false,
			serviceContext);

		if (Validator.isNull(targetUser.getLastLoginDate())){
			userLocalService.updateLastLogin(
				targetUser.getUserId(), ImportUsersConfigurationValues.LOCAL_ADDRESS);
		}

		HashSet<Team> addTeams = new HashSet<>();
		addTeams= _factoryAssignTeam(addTeams,targetUser, idOrgChart,
			groupId, personId, emailBody);

		_factoryCustomField(targetUser, userFrontierBind);

		for (ManagerOfficesBind managerOfficesBind : reggenti) {
			_log.info("Reggenze id reggenza TEAM"+ managerOfficesBind.getIdOrgChart());
			if (managerOfficesBind.getIdOrgChart() != idOrgChart){
				_log.info("ENTRO REGGENZA TEAM "+addTeams.toString());
				addTeams =_factoryAssignTeam(addTeams, targetUser,
					managerOfficesBind.getIdOrgChart(), groupId, personId,
					emailBody);
				_log.info("ESCO REGGENZA TEAM "+addTeams.toString());
			}
		}

		for (Iterator<Team> iterator = addTeams.iterator(); iterator.hasNext();) {
			Team team =  iterator.next();

			TeamUtil.addUser(team.getTeamId(), targetUser.getUserId());
		}

		_log.info("Team user post:"+StringUtil.merge(addTeams));
		return targetUser;
	}

/*	private User _addUserTest(long companyId, UserFrontierBind userFrontierBind,
			int i, long groupId)
		throws Exception{

		String[] mails = new String[]{
				"debora.giovannoli@smc.it","dgiovannoli@gmail.com",
				"domenico.costa@smc.it", "fulvio.fazolo@smc.it",
				"salvatore.rocca@smc.it","domenico.costa2@smc.it",
				"domenico.costa@gmail.com","davide.gulli@smc.it",
				"cristian.bianco@smc.it","ivan.mascolo@accenture.com",
				"roberto.sangiovanni@accenture"
			};
		String screenName = userFrontierBind.getScreenName().toLowerCase(); 
		String name = userFrontierBind.getName();
		String surname = userFrontierBind.getSurName();
		boolean gender = true;
		if (userFrontierBind.getGender().equalsIgnoreCase("F")){
			gender = false;
		}

		long idOrgChart = userFrontierBind.getIdOrgChart();
		long personId = userFrontierBind.getPersonalId();

		String email = mails[i]; //TODOOOOOO userFrontierBind.getEmail();

		_log.info("========================================");
		_log.info("userFrontierBind "+userFrontierBind.toString());
		_log.info("check SCRENNAME "+screenName);
		_log.info("check MAil "+userFrontierBind.getEmail());
		_log.info("========================================");

		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();

		birthdayCal.setTime(userFrontierBind.getDateBirth());

		ServiceContext serviceContext = new ServiceContext();

		List<Address> addresses = _factoryAddress(companyId, userFrontierBind);
		List<EmailAddress> emailAddresses = new ArrayList<>();
		List<Phone> phones = _factoryPhone(companyId, userFrontierBind);
		List<Website> websites = new ArrayList<>();
		List<AnnouncementsDelivery> announcementsDeliveries = new ArrayList<>();

		long[] groupIds = new long[]{groupId};
		long[] organizationIds = new long[]{};
		long[] roleIds =new long[]{};
		_factoryRoles(roleIds, idOrgChart, personId, companyId);
		long[] userGroupIds = new long[]{};

		User targetUser = UserServiceUtil.addUser(
			companyId, true, StringPool.BLANK, StringPool.BLANK, false,
			screenName, email, 0L, StringPool.BLANK, LocaleUtil.ITALY, name,
			StringPool.BLANK, surname, 1L, 1L, gender,
			birthdayCal.get(Calendar.MONTH), birthdayCal.get(Calendar.DATE),
			birthdayCal.get(Calendar.YEAR), StringPool.BLANK, groupIds,
			organizationIds, roleIds, userGroupIds, addresses, emailAddresses,
			phones, websites, announcementsDeliveries, false,
			serviceContext);

		if (Validator.isNull(targetUser.getLastLoginDate())){
			userLocalService.updateLastLogin(
				targetUser.getUserId(), "127.0.0.1");
		}

		_factoryAssignTeam(targetUser, idOrgChart, groupId, personId);
		_factoryCustomField(targetUser, userFrontierBind);

		return targetUser;
	}
*/
	private HashSet<Team> _factoryAssignTeam(HashSet<Team> addTeams,
		User targetUser, long idOrgChart, long groupIdIntranetMef,
		long personId, StringBuilder emailBody) {

		long id = 0, levelOrgId =0;
		boolean isDirigente = false;

		OrganizationChart org = null;
		try {
			org = OrganizationChartLocalServiceUtil.getOrganizationChart(
				idOrgChart);
			id = org.getLocationId();
			levelOrgId = org.getLevel();
		} catch (PortalException e) {
			_log.error(e);
		}

		List<Team> teams;
		List<Team> teamsSede;
		long roleIdDirigente; 
		List<Location> locations;
		List<OrganizationChart> subOrgs;
		boolean centrale = false;

		switch ((int)levelOrgId) {
			case 2:
				_log.info("TEAM CASE 2");

				teamsSede = JobsUtility.getTeamsById(
					groupIdIntranetMef, org.getLocationId(), true);

				if (Validator.isNotNull(teamsSede)){
					addTeams.addAll(teamsSede);
				}else{
					MailUtil._trackWarning(emailBody,
						"Sede collegata all'organigramma dell'utente, o di reggenza, non trovata");
				}

				subOrgs = OrganizationChartLocalServiceUtil.getChildrenByLevelAndIdOrgChart(2, idOrgChart);
				for (OrganizationChart organizationChart : subOrgs) {
					_log.info("TEAM FIGLI "+organizationChart.getIdOrgChart()+ "level "+ organizationChart.getLevel());
					if (organizationChart.getIdOrgChart() == idOrgChart){
						continue;
					}

					teams = JobsUtility.getTeamsById(
						groupIdIntranetMef, organizationChart.getIdOrgChart(), false);

					if (organizationChart.getLevel() == 3){
						int checkTeamDrg=0;
						if (Validator.isNotNull(teams)){
							for (Team team1 : teams) {
								String nameTeam = team1.getName();
								
								if (nameTeam.endsWith("DRG")){
									addTeams.add(team1);
									checkTeamDrg++;
								}
								if (nameTeam.endsWith("DRG_C")){
									addTeams.add(team1);
									checkTeamDrg++;
								}
								if (nameTeam.endsWith("DRG_P")){
									addTeams.add(team1);
									checkTeamDrg++;
								}
							}
						}
						if (checkTeamDrg!=3){
							MailUtil._trackWarning(emailBody,
								"Direttore di Dipartimento senza team di Direzione-Ruolo per direzione:"+
								organizationChart.getName());
						}
					}else{
						if (Validator.isNotNull(teams)){
							addTeams.addAll(teams);
						}else{
							if(organizationChart.getLevel() == 4){
								MailUtil._trackWarning(emailBody,
									"Direttore di Dipartimento senza Team per gli Uffici");
							}else if (organizationChart.getLevel() == 5){
								MailUtil._trackWarning(emailBody,
									"Direttore di Dipartimento senza Team per le Segreterie");
							}
						}
					}

					teamsSede = JobsUtility.getTeamsById(
						groupIdIntranetMef, organizationChart.getLocationId(), true);

					if (Validator.isNotNull(teamsSede)){
						addTeams.addAll(teamsSede);
					}else{
						MailUtil._trackWarning(emailBody,
							"Team di sede non tovata per Organigramma: "+
								organizationChart.getIdOrgChart());
					}
				}
				break;
			case 3:
				_log.info("TEAM CASE 3");

				teams = JobsUtility.getTeamsById(
						groupIdIntranetMef, org.getIdOrgChart(), false);//DIREZ

				int checkteam3=0;
				if (Validator.isNotNull(teams)){
					for (Team team1 : teams) {
						String nameTeam = team1.getName();
						
						if (nameTeam.endsWith("DRG")){
							addTeams.add(team1);
							checkteam3++;
						}
						if (nameTeam.endsWith("DRG_C")){
							addTeams.add(team1);
							checkteam3++;
						}
						if (nameTeam.endsWith("DRG_P")){
							addTeams.add(team1);
							checkteam3++;
						}
					}
				}

				if (checkteam3!=3){
					MailUtil._trackWarning(emailBody,
						"Direttore di Direzione senza team di Direzione-Ruolo per direzione:"+
							org.getName());
				}

				teamsSede = JobsUtility.getTeamsById(
					groupIdIntranetMef, org.getLocationId(), true);

				if (Validator.isNotNull(teamsSede)){
					addTeams.addAll(teamsSede);
				}else{
					MailUtil._trackWarning(emailBody,
						"Sede collegata all'organigramma dell'utente, o di reggenza, non trovata");
				}

				subOrgs = OrganizationChartLocalServiceUtil.getChildrenByLevelAndIdOrgChart(3, idOrgChart);
				for (OrganizationChart organizationChart : subOrgs) {
					_log.info("TEAM FIGLI "+organizationChart.getIdOrgChart()+ "level "+ organizationChart.getLevel());
					if (organizationChart.getIdOrgChart() == idOrgChart){
						continue;
					}

					teams = JobsUtility.getTeamsById(
						groupIdIntranetMef, organizationChart.getIdOrgChart(), false);

					teamsSede = JobsUtility.getTeamsById(
						groupIdIntranetMef, organizationChart.getLocationId(), true);

					if (Validator.isNotNull(teams)){
						addTeams.addAll(teams);
					}else{
						if(organizationChart.getLevel() == 4){
							MailUtil._trackWarning(emailBody,
								"Direttore di Direzione senza Team per gli Uffici");
						}else if (organizationChart.getLevel() == 5){
							MailUtil._trackWarning(emailBody,
								"Direttore di Direzione senza Team per le Segreterie");
						}
					}

					if (Validator.isNotNull(teamsSede)){
						addTeams.addAll(teamsSede);
					}else{
						MailUtil._trackWarning(emailBody,
							"Team di sede non tovata per Organigramma: "+
								organizationChart.getIdOrgChart());
					}
				}
				break;
			case 4:
				_log.info("TEAM CASE 4");
				teams = JobsUtility.getTeamsById(
					groupIdIntranetMef, idOrgChart, false);

				//sede
				teamsSede = JobsUtility.getTeamsById(
					groupIdIntranetMef, id, true);

				if (Validator.isNotNull(teams)){
					addTeams.addAll(teams);
				}else{
					MailUtil._trackWarning(emailBody,
						"Team dell'Ufficio dell'utente, o di reggenza, non trovata");
				}

				if (Validator.isNotNull(teamsSede)){
					addTeams.addAll(teamsSede);
				}else{
					MailUtil._trackWarning(emailBody,
						"Sede collegata all'organigramma dell'utente, o di reggenza, non trovata");
				}

				roleIdDirigente = JobsUtility.getRoleIdDirigente
					(personId, idOrgChart);

				if (roleIdDirigente>0){
					isDirigente = true;

				}

				try {
					org = OrganizationChartLocalServiceUtil.getOrganizationChart(
						org.getIdParent());

				} catch (PortalException e) {_log.error(e);}
				
				locations = CentralInvokerLocalServiceUtil.findLocationById(id);

				if (!locations.isEmpty()){
					Location location = locations.get(0);
					centrale = "C".equalsIgnoreCase(location.getLocationType()) ? true : false;
				}

				teams = JobsUtility.getTeamsById(
						groupIdIntranetMef, org.getIdOrgChart(), false);//DIREZ

				Team teamDirCentrale = null;
				Team teamDirPeriferico =null;
				int checkTeamDrz4=0;

				if (Validator.isNotNull(teams)){
					for (Team team1 : teams) {
						String nameTeam = team1.getName();
						
						if (!isDirigente){
							if (nameTeam.endsWith("DIPE")){
								addTeams.add(team1);
								checkTeamDrz4++;
							}
							if (centrale && nameTeam.endsWith("DIPE_C")){
								addTeams.add(team1);
								checkTeamDrz4++;
							}
							if (!centrale && nameTeam.endsWith("DIPE_P")){
								addTeams.add(team1);
								checkTeamDrz4++;
							}
						}else{
							if (nameTeam.endsWith("DRG")){
								addTeams.add(team1);
								checkTeamDrz4++;
							}
							if (centrale && nameTeam.endsWith("DRG_C")){
								addTeams.add(team1);
								teamDirCentrale = team1;
								checkTeamDrz4++;
							}
							if (!centrale && nameTeam.endsWith("DRG_P")){
								addTeams.add(team1);
								teamDirPeriferico = team1;
								checkTeamDrz4++;
							}
						}
					}
				}
				if (checkTeamDrz4<2){
					MailUtil._trackWarning(emailBody,
						"Utente senza team di Direzione-Ruolo per direzione:"+
							org.getName());
				}

				if (isDirigente){
					// l'alberatura sotto
					subOrgs = OrganizationChartLocalServiceUtil.getChildrenByLevelAndIdOrgChart(4, idOrgChart);
					for (OrganizationChart organizationChart : subOrgs) {
						_log.info("TEAM FIGLI "+organizationChart.getIdOrgChart()+ "level "+ organizationChart.getLevel());
						if (organizationChart.getIdOrgChart() == idOrgChart){
							continue;
						}

						teams = JobsUtility.getTeamsById(
							groupIdIntranetMef, organizationChart.getIdOrgChart(), false);//DIREZ

						teamsSede = JobsUtility.getTeamsById(
							groupIdIntranetMef, organizationChart.getLocationId(), true);

						if (Validator.isNotNull(teams)){
							addTeams.addAll(teams);
						}else{
							MailUtil._trackWarning(emailBody,
								"Capo Ufficio senza Team per le segreterie");
						}

						if (Validator.isNotNull(teamsSede)){
							addTeams.addAll(teamsSede);
						}else{
							MailUtil._trackWarning(emailBody,
								"Team di sede non tovata per Organigramma: "+
									organizationChart.getIdOrgChart());
						}
						
						//abbi
						if (org.getLevel() == 5){
							locations = CentralInvokerLocalServiceUtil.findLocationById(organizationChart.getLocationId());

							if (!locations.isEmpty()){
								Location location = locations.get(0);
								centrale = "C".equalsIgnoreCase(location.getLocationType()) ? true : false;
							}
							if (centrale && Validator.isNotNull(teamDirCentrale)){
								addTeams.add(teamDirCentrale);
							}else{
								if (Validator.isNotNull(teamDirPeriferico)){
									addTeams.add(teamDirPeriferico);
								}
							}
						}
					}
					
				}
				break;
			case 5:
				_log.info("TEAM CASE 5");
				teams = JobsUtility.getTeamsById(
					groupIdIntranetMef, idOrgChart, false);

				//sede
				teamsSede = JobsUtility.getTeamsById(
					groupIdIntranetMef, id, true);

				if (Validator.isNotNull(teams)){
					addTeams.addAll(teams);
				}else{
					MailUtil._trackWarning(emailBody,
						"Team della segreteria dell'utente, o di reggenza, non trovata");
				}

				if (Validator.isNotNull(teamsSede)){
					addTeams.addAll(teamsSede);
				}else{
					MailUtil._trackWarning(emailBody,
						"Sede collegata all'organigramma dell'utente, o di reggenza, non trovata");
				}

				roleIdDirigente = JobsUtility.getRoleIdDirigente
					(personId, idOrgChart);
				if (roleIdDirigente>0){
					isDirigente = true;
				}

				try {
					org = OrganizationChartLocalServiceUtil.getOrganizationChart(
						org.getIdParent());

					teams = JobsUtility.getTeamsById(
						groupIdIntranetMef, org.getIdOrgChart(), false); //4
					if (Validator.isNotNull(teams)){
						addTeams.addAll(teams);
					}else{
						MailUtil._trackWarning(emailBody,
							"Team dell'Ufficio collegato alla segreteria dell'utente, o di reggenza, non trovata");
					}

					org = OrganizationChartLocalServiceUtil.getOrganizationChart(
						org.getIdParent()); //3
					
				} catch (PortalException e) {_log.error(e);}

				locations = CentralInvokerLocalServiceUtil.findLocationById(id);

				if (!locations.isEmpty()){
					Location location = locations.get(0);
					centrale ="C".equalsIgnoreCase(location.getLocationType()) ? true : false;
				}

				teams = JobsUtility.getTeamsById(
						groupIdIntranetMef, org.getIdOrgChart(), false);//DIREZ

				int checkDrz5=0;
				if (Validator.isNotNull(teams)){
					for (Team team1 : teams) {
						String nameTeam = team1.getName();
						
						if (!isDirigente){
							if (nameTeam.endsWith("DIPE")){
								addTeams.add(team1);
								checkDrz5++;
							}
							if (centrale && nameTeam.endsWith("DIPE_C")){
								addTeams.add(team1);
								checkDrz5++;
							}
							if (!centrale && nameTeam.endsWith("DIPE_P")){
								addTeams.add(team1);
								checkDrz5++;
							}
						}else{
							if (nameTeam.endsWith("DRG")){
								addTeams.add(team1);
								checkDrz5++;
							}
							if (centrale && nameTeam.endsWith("DRG_C")){
								addTeams.add(team1);
								checkDrz5++;
							}
							if (!centrale && nameTeam.endsWith("DRG_P")){
								addTeams.add(team1);
								checkDrz5++;
							}
						}
					}
				}

				if (checkDrz5<2){
					MailUtil._trackWarning(emailBody,
						"Utente senza team di Direzione-Ruolo per direzione:"+
							org.getName());
				}

				break;
			default:
				break;
		}

		return addTeams;

	}

	private List<Address> _factoryAddress(long companyId,
		UserFrontierBind userFrontierBind) {

		List<Address> addresses= new ArrayList<>();

		//INDIRIZZO OTHER NASCITA COUTNRY ITALY
		String codIstatBirth = userFrontierBind.getCodIstatBirth();

		long addressId=0;
		if (!codIstatBirth.isEmpty()){

			Address addressBirth = AddressLocalServiceUtil.createAddress(addressId);
			addressBirth.setStreet1("N/A");
			addressBirth.setZip("N/A");
			addressBirth.setCity(codIstatBirth);
			addressBirth.setTypeId(
				UserAddressUtil.getAddressTypeIdByName(UserAddressUtil.BIRTH));
			addressBirth.setMailing(false);
			addressBirth.setPrimary(false);
			addressBirth.setCompanyId(companyId);

			addresses.add(addressBirth);
		}

		//INDIRIZZO PERSONAL RESIDENZA COUTNRY ITALY
		String personalStreet = userFrontierBind.getPersonalStreet();
		String personalPostalCode = userFrontierBind.getPersonalPostalCode();
		String personalCity = userFrontierBind.getPersonalCity();

		if (!personalStreet.isEmpty() && !personalCity.isEmpty()){

			Address addressPersonal = AddressLocalServiceUtil.
				createAddress(addressId);
			addressPersonal.setStreet1(personalStreet);
			addressPersonal.setZip(personalPostalCode);
			addressPersonal.setCity(personalCity);
			addressPersonal.setTypeId(
				UserAddressUtil.getAddressTypeIdByName(UserAddressUtil.PERSONAL));	
			addressPersonal.setMailing(false);
			addressPersonal.setPrimary(false);
			addressPersonal.setCompanyId(companyId);

			addresses.add(addressPersonal);
		}

		//INDIRIZZO BUSINESS COUNTRY ITALY type
		String officeStreet1 = userFrontierBind.getOfficeStreet1();
		String officeStreet2 = userFrontierBind.getOfficeStreet2();
		String officeStreet3 = userFrontierBind.getOfficeStreet3();
		String officePostalCode = 
			userFrontierBind.getOfficePostalCode().trim().isEmpty()?
				"N/A":userFrontierBind.getOfficePostalCode();
		String officeCity = 
			userFrontierBind.getOfficeCity().trim().isEmpty()?
				"N/A":userFrontierBind.getOfficeCity();	

		if (!officeStreet1.isEmpty()){

			Address addressOffice = AddressLocalServiceUtil.
				createAddress(addressId);
			addressOffice.setStreet1(officeStreet1);
			addressOffice.setStreet2(officeStreet2);
			addressOffice.setStreet3(officeStreet3);
			addressOffice.setZip(officePostalCode);
			addressOffice.setCity(officeCity);
			addressOffice.setTypeId(
				UserAddressUtil.getAddressTypeIdByName(UserAddressUtil.BUSINESS));
			addressOffice.setMailing(true);
			addressOffice.setPrimary(true);
			addressOffice.setCompanyId(companyId);

			addresses.add(addressOffice);
		}

		return addresses;
	}

	private void _factoryCustomField(
		User targetUser, UserFrontierBind userFrontierBind) {

		//CUSTOM FIELD
		String personalId = String.valueOf(userFrontierBind.getPersonalId());
		JobsUtility.setUserExpandoValue(
			targetUser, IntranetMefConstants.CUSTOM_FIELD_PERSONAL_ID,
			personalId);

		String idOrgChart = String.valueOf(userFrontierBind.getIdOrgChart());
		JobsUtility.setUserExpandoValue(
			targetUser, IntranetMefConstants.CUSTOM_FIELD_ID_ORG_CHART,
			idOrgChart);

		String idDirector = String.valueOf(userFrontierBind.getIdDirector());
		JobsUtility.setUserExpandoValue(
			targetUser, IntranetMefConstants.CUSTOM_FIELD_ID_DIRECTOR,
			idDirector);

		Date dataCheck = userFrontierBind.getDateRecruitment();
		if (Validator.isNotNull(dataCheck)){
			String dateRecruitment = String.valueOf(dataCheck.getTime());
			JobsUtility.setUserExpandoValue(
				targetUser, IntranetMefConstants.CUSTOM_FIELD_DATE_RECRUITMENT,
				dateRecruitment);
		}

		dataCheck = userFrontierBind.getDateStartAssignOffice();
		if (Validator.isNotNull(dataCheck)){
			String dateStartAssignOffice = String.valueOf(dataCheck.getTime());
			JobsUtility.setUserExpandoValue(
				targetUser,
				IntranetMefConstants.CUSTOM_FIELD_DATE_START_ASSIGN_OFFICE,
				dateStartAssignOffice);
		}

		dataCheck = userFrontierBind.getDateStartInquadramento();
		if (Validator.isNotNull(dataCheck)){
			String dateStartInquadramento = String.valueOf(dataCheck.getTime());
			JobsUtility.setUserExpandoValue(
				targetUser,
				IntranetMefConstants.CUSTOM_FIELD_DATE_START_INQUADRAMENTO,
				dateStartInquadramento);
		}

		dataCheck = userFrontierBind.getDateStartFunction();
		if (Validator.isNotNull(dataCheck)){
			String dateStartFunction = String.valueOf(dataCheck.getTime());
			JobsUtility.setUserExpandoValue(
				targetUser,
				IntranetMefConstants.CUSTOM_FIELD_DATE_START_FUNCTION,
				dateStartFunction);
		}

		String levelId = String.valueOf(userFrontierBind.getLevelId());
		JobsUtility.setUserExpandoValue(
			targetUser, IntranetMefConstants.CUSTOM_FIELD_ID_LEVEL,
			levelId);

	}

	private List<Phone> _factoryPhone(long companyId,
		UserFrontierBind userFrontierBind) {

		List<Phone> phones= new ArrayList<>();

		//PHONE
		String personalPhone = userFrontierBind.getPersonalPhone();
		String workPhone = userFrontierBind.getWorkPhone();
		String workFax = userFrontierBind.getWorkFax();
		
		long phoneId= 0; 

		if (!personalPhone.isEmpty()){

			Phone phonePersonal = PhoneLocalServiceUtil.createPhone(phoneId);
			phonePersonal.setNumber(personalPhone);
			phonePersonal.setTypeId(
				UserPhoneUtil.getPhoneTypeIdByName(UserPhoneUtil.PERSONAL));	
			phonePersonal.setCompanyId(companyId);

			phones.add(phonePersonal);
		}

		if (!workPhone.isEmpty()){

			Phone phoneBusiness = PhoneLocalServiceUtil.createPhone(phoneId);
			phoneBusiness.setNumber(workPhone);
			phoneBusiness.setTypeId(
				UserPhoneUtil.getPhoneTypeIdByName(UserPhoneUtil.BUSINESS));
			phoneBusiness.setCompanyId(companyId);

			phones.add(phoneBusiness);
		}

		if (!workFax.isEmpty()){

			Phone phoneBusinessFax = PhoneLocalServiceUtil.createPhone(phoneId);
			phoneBusinessFax.setNumber(workFax);
			phoneBusinessFax.setTypeId(
					UserPhoneUtil.getPhoneTypeIdByName(
						UserPhoneUtil.BUSINESS_FAX));
			phoneBusinessFax.setCompanyId(companyId);

			phones.add(phoneBusinessFax);
		}

		return phones;
	}

	private long[] _factoryRoles(long[] roleIds, long idOrgChart,
		long personId, long companyId, StringBuilder emailBody) {

		
		long[] roleIdsArray =  ArrayUtil.clone(roleIds);
		
		int levelOrg = JobsUtility.LevelByIdChart(idOrgChart);
        
		if (levelOrg <2 || levelOrg>5){
			MailUtil._trackWarning(emailBody,
				"Livello Organigramma utente non gestito livello:"+levelOrg);
		}
		long roleIdDirigente = JobsUtility.getRoleIdDirigente
				(personId, idOrgChart);

		switch (levelOrg) {
			case 2:
				List<OrganizationChart> subOrgs = OrganizationChartLocalServiceUtil.
					getChildrenByLevelAndIdOrgChart(2, idOrgChart);
				int checkCount=0;
				for (OrganizationChart organizationChart : subOrgs) {
					if (organizationChart.getLevel()==3){
						Role role = JobsUtility.getRoleByOrgChartId(
							organizationChart.getIdOrgChart());
						if(Validator.isNotNull(role)){
							_log.info("Ruolo Aggiunto "+role.getName());
							roleIdsArray = ArrayUtil.append(roleIdsArray, role.getRoleId());
							checkCount++;
						}
					}
				}

				if (checkCount==0){
					MailUtil._trackWarning(emailBody,
						"Direttore di Dipartimento senza Direzioni");
				}

				if (roleIdDirigente>0){
					roleIdsArray = ArrayUtil.append(roleIdsArray, roleIdDirigente);

				}else{
					long roleIdDipendente = JobsUtility.getRoleIdDipendente();

					if (roleIdDipendente<0){
						MailUtil._trackWarning(emailBody,"Non trovato ruolo Dipendente");
					}else{
						roleIdsArray = ArrayUtil.append(roleIdsArray, roleIdDipendente);
					}

				}
				break;
				
			case 3:
			case 4:
			case 5:
				
				if (roleIdDirigente>0){
					roleIdsArray = ArrayUtil.append(roleIdsArray, roleIdDirigente);

				}else{
					long roleIdDipendente = JobsUtility.getRoleIdDipendente();

					if (roleIdDipendente<0){
						MailUtil._trackWarning(emailBody,"Non trovato ruolo Dipendente");
					}else{
						roleIdsArray = ArrayUtil.append(roleIdsArray, roleIdDipendente);
					}

				}
				break;
			default:
				break;
		}

		ArrayList<Long> parentIds = _getAllParentId(idOrgChart);

		for (Long parentId : parentIds) {
			_log.info("ParentID Org : "+parentId);
			Role role = JobsUtility.getRoleByOrgChartId(parentId);
			if(Validator.isNotNull(role)){
				_log.info("Ruolo Aggiunto "+role.getName());
				roleIdsArray = ArrayUtil.append(roleIdsArray, role.getRoleId());
			}
		}

		_log.info("Role user:"+StringUtil.merge(roleIdsArray));
		return roleIdsArray;
	}

	private ArrayList<Long> _getAllParentId(long idOrgChart) {
		ArrayList<Long> parentIDs = new ArrayList<>();

		OrganizationChart org = null;
		try {			
			org = OrganizationChartLocalServiceUtil.getOrganizationChart(idOrgChart);
			long orgParentID = org.getIdParent();
			//id MEF= 847, i dipartimenti avranno parent mef=0
			while (orgParentID > 0){

				parentIDs.add(org.getIdOrgChart());

				org = OrganizationChartLocalServiceUtil.getOrganizationChart(orgParentID);
				orgParentID = org.getIdParent();

			}

		} catch (PortalException e) {
			_log.error("Error search ID Organization Chart = "+idOrgChart);
			_log.error(e);
		}

		return parentIDs;
	}

	
/*	private void _importUserTest(long companyId, UserFrontierBind userFrontierBind,
			StringBuilder emailBody, int i){

		String screenName = userFrontierBind.getScreenName().toLowerCase();

		User user = userLocalService.fetchUserByScreenName(companyId, screenName);

		long groupIdIntranetMef = 0;
		String siteURL= "/guest";//guest default 
		try{
			siteURL = PropsUtil.get("mef-intranet-site-url");
		} catch (Exception e) {
			_log.error("KEY mef-intranet-site-url non presente in portletEXT settato default /guest");
		}

		if (Validator.isNotNull(siteURL) || !siteURL.isEmpty()){

			try {
				groupIdIntranetMef = GroupLocalServiceUtil.getFriendlyURLGroup(
					companyId,siteURL).getGroupId();

			} catch (PortalException e) {
				_log.error("SITE settato in KEY mef-intranet-site-url non trovato");
			}

		}

		if (user == null){
			//add user
			
			User checkUser = userLocalService.fetchUserByEmailAddress(
				companyId, userFrontierBind.getEmail().toLowerCase());

			if (checkUser == null) {
				User targetUser;
				try {
					targetUser = _addUserTest(companyId, userFrontierBind, i,
						groupIdIntranetMef);
					MailUtil._trackCreateUser(emailBody, targetUser);

				} catch (Exception e) {
					if(_log.isDebugEnabled()){
						e.printStackTrace();
					}
					_log.error("IMPORT ADD USER :"+e.getMessage());
					MailUtil._trackErrorImport(
						emailBody, userFrontierBind, "Aggiungere",
						e.getMessage());

				}

			}
			else {
				MailUtil._trackErrorUpdateEmail(emailBody, checkUser);
			}

		}else{

			try {
				user = _updateUser(companyId, userFrontierBind, user,
					groupIdIntranetMef);
				MailUtil._trackUpdateUser(emailBody, user);

			} catch (Exception e) {
				if(_log.isDebugEnabled()){
					e.printStackTrace();
				}
				_log.error("IMPORT UPDATE USER :"+e.getMessage());
				MailUtil._trackErrorImport(
					emailBody, userFrontierBind, "Aggiornare", e.getMessage());

			}

			
		}

	}
*/
	private User _updateUser(long companyId, UserFrontierBind userFrontierBind,
			User masterUser, long groupIdIntranetMef, StringBuilder emailBody)
		throws PortalException {

		String screenName = userFrontierBind.getScreenName().toLowerCase(); 
		String name = userFrontierBind.getName();
		String surname = userFrontierBind.getSurName();
		boolean gender = true;
		if ("F".equalsIgnoreCase(userFrontierBind.getGender())){
			gender = false;
		}

		long idOrgChart = userFrontierBind.getIdOrgChart();
		long personId = userFrontierBind.getPersonalId();

		String email = userFrontierBind.getEmail().toLowerCase();

		_log.info("========================================");
		_log.info("userFrontierBind "+userFrontierBind.toString());
		_log.info("check SCRENNAME "+screenName);
		_log.info("check MAil "+email);
		_log.info("========================================");

		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();

		birthdayCal.setTime(userFrontierBind.getDateBirth());

		ServiceContext serviceContext = new ServiceContext();

		List<Address> addresses = _factoryAddress(companyId, userFrontierBind);
		List<EmailAddress> emailAddresses = masterUser.getEmailAddresses();
		List<Phone> phones = _factoryPhone(companyId, userFrontierBind);
		List<Website> websites = masterUser.getWebsites();
		List<AnnouncementsDelivery> announcementsDeliveries =
			announcementsDeliveryLocalService.getUserDeliveries(
				masterUser.getUserId());

		long[] roleIds = masterUser.getRoleIds();
		List<Long> rolesIdArchitettural = CentralInvokerLocalServiceUtil.
			getRolesIsArchitettural(companyId);

		for (Long idRoleArchitettural : rolesIdArchitettural) {
			roleIds = ArrayUtil.remove(roleIds, idRoleArchitettural);
		}

		long[] groupIds = masterUser.getGroupIds();
		long[] organizationIds = masterUser.getOrganizationIds();

		
     
		long roleIdDirigente = JobsUtility.getRoleIdDirigente(personId, idOrgChart);

		// compare iddirector and idorgchart for employee

		if (roleIdDirigente < 0) {
			String idDirectorBefore = (String) masterUser.getExpandoBridge()
					.getAttribute(IntranetMefConstants.CUSTOM_FIELD_ID_DIRECTOR);
			
			
             _log.info("id director before change="+idDirectorBefore);
             
             
			long idDirectorAfter = userFrontierBind.getIdDirector();
			
			  _log.info("id director after change="+Long.toString(idDirectorAfter));

			if (idDirectorAfter != Long.parseLong(idDirectorBefore)) {
				// logic for delete user badge role abilitato
				
				_log.info("Enter in badge remove roles block for director change");
				
				for (Role roleitem : masterUser.getRoles()) {
					
				
					
					if ("abilitatoBadge".equalsIgnoreCase(roleitem.getName())) {
						
						_log.info("Delete abilitato role of badge for director change");
						roleIds = ArrayUtil.remove(roleIds, roleitem.getRoleId());
					}
					if ("delegatoBadge".equalsIgnoreCase(roleitem.getName())) {
						
						_log.info("Delete delegato role of badge for director change");
						roleIds = ArrayUtil.remove(roleIds, roleitem.getRoleId());
					}
				}
			}

			String IdorgchartBefore = (String) masterUser.getExpandoBridge()
					.getAttribute(IntranetMefConstants.CUSTOM_FIELD_ID_ORG_CHART);
			
			_log.info("id organization before change="+IdorgchartBefore);
			
			_log.info("id organization after change="+ Long.toString(idOrgChart));

			if (idOrgChart != Long.parseLong(IdorgchartBefore)) {
				
				_log.info("Enter in badge remove roles block for organization change");	
				
				// logic for delete user badge role abilitato
				for (Role roleitem : masterUser.getRoles()) {
					if ("abilitatoBadge".equalsIgnoreCase(roleitem.getName())) {
						_log.info("Delete abilitato role of badge for organization change");
						roleIds = ArrayUtil.remove(roleIds, roleitem.getRoleId());
					}
					if ("delegatoBadge".equalsIgnoreCase(roleitem.getName())) {
						_log.info("Delete delegato role of badge for organization change");
						roleIds = ArrayUtil.remove(roleIds, roleitem.getRoleId());
					}
				}
			}

		}
		
		//get user positions
		String posGiu = userFrontierBind.getGiuridicPos();
		String posEco = userFrontierBind.getEconomicPos();
		
		//add positions roles
		 if(Validator.isNotNull(posGiu)){
	            long roleIdPosGiu =  JobsUtility.getRolePosGiuridica(posGiu);
	            if (roleIdPosGiu > 0)
	                  roleIds = ArrayUtil.append(roleIds, roleIdPosGiu);
	            else
	            	_log.info("non esiste il ruolo POS configurato su liferay");
	        }else{
	        	_log.info("utente con ruolo POS_GIURIDICO nullo");
	        }
		if(Validator.isNotNull(posEco)){
            long roleIdPosEco =  JobsUtility.getRolePosEconomica(posEco);
            if (roleIdPosEco > 0)
                  roleIds = ArrayUtil.append(roleIds, roleIdPosEco);
            else
            	_log.info("non esiste il ruolo POS configurato su liferay");
		}else{
        	_log.info("utente con ruolo POS_ECONOMICO nullo");
        }
		
		roleIds = _factoryRoles(roleIds, idOrgChart, personId, companyId, emailBody);
		long[] userGroupIds = masterUser.getUserGroupIds();

		List<ManagerOfficesBind> reggenti = ManagerOfficesBindLocalServiceUtil.
			getManagerOfficesBindByPersonId(personId);

		_log.info("UPDATE IdOrgChart UTENTE  "+ idOrgChart);
		_log.info("Reggenze size "+ reggenti.size());
		for (ManagerOfficesBind managerOfficesBind : reggenti) {
			_log.info("Reggenze id reggenza "+ managerOfficesBind.getIdOrgChart());
			if (managerOfficesBind.getIdOrgChart() != idOrgChart){
				_log.info("ENTRO REGGENZA RUOLI "+ Arrays.toString(roleIds));
				roleIds = _factoryRoles(roleIds,
					managerOfficesBind.getIdOrgChart(), personId, companyId,
					emailBody);
				_log.info("USCITA REGGENZA RUOLI "+ Arrays.toString(roleIds));
			}
		}

		List<UserGroupRole> userGroupRoles =
			userGroupRoleLocalService.getUserGroupRoles(
				masterUser.getUserId());

		String smsSn = masterUser.getContact().getSmsSn(); 
		String facebookSn = masterUser.getContact().getFacebookSn();
		String jabberSn = masterUser.getContact().getJabberSn();
		String skypeSn = masterUser.getContact().getSkypeSn();
		String twitterSn = masterUser.getContact().getTwitterSn();

		_log.info("Update User entity");

		User targetUser = UserServiceUtil.updateUser(
			masterUser.getUserId(), StringPool.BLANK, StringPool.BLANK,
			StringPool.BLANK, false, masterUser.getReminderQueryQuestion(),
			masterUser.getReminderQueryAnswer(), screenName,
			email, masterUser.getFacebookId(), masterUser.getOpenId(), false, null,
			masterUser.getLanguageId(), masterUser.getTimeZoneId(),
			masterUser.getGreeting(), masterUser.getComments(), name,
			masterUser.getMiddleName(), surname, 1L, 1L, gender,
			birthdayCal.get(Calendar.MONTH), birthdayCal.get(Calendar.DATE),
			birthdayCal.get(Calendar.YEAR), smsSn, facebookSn, jabberSn,
			skypeSn, twitterSn, masterUser.getJobTitle(), groupIds,
			organizationIds, roleIds, userGroupRoles, userGroupIds, addresses,
			emailAddresses, phones, websites, announcementsDeliveries,
			serviceContext);

		_log.info("Assign Team User");
		HashSet<Team> addTeams = new HashSet<>();
		long[] userTeams = targetUser.getTeamIds();
		_log.info("Team user pre:"+StringUtil.merge(userTeams));
		for (int i = 0; i < userTeams.length; i++) {
			long teamId = userTeams[i];

			if (CentralInvokerLocalServiceUtil.isTeamArchitettural(teamId)){
				TeamUtil.removeUser(teamId, targetUser.getUserId());
			}
		}

		addTeams = _factoryAssignTeam(addTeams, targetUser, idOrgChart,
			groupIdIntranetMef, personId, emailBody);
		
		_log.info("Custom Field User");
		_factoryCustomField(targetUser, userFrontierBind);

		for (ManagerOfficesBind managerOfficesBind : reggenti) {
			_log.info("Reggenze id reggenza TEAM"+ managerOfficesBind.getIdOrgChart());
			if (managerOfficesBind.getIdOrgChart() != idOrgChart){
				_log.info("ENTRO REGGENZA TEAM "+addTeams.toString());
				addTeams= _factoryAssignTeam(addTeams, targetUser,
					managerOfficesBind.getIdOrgChart(), groupIdIntranetMef,
					personId, emailBody);
				_log.info("ESCO REGGENZA TEAM "+addTeams.toString());
			}
		}

		for (Iterator<Team> iterator = addTeams.iterator(); iterator.hasNext();) {
			Team team =  iterator.next();

			TeamUtil.addUser(team.getTeamId(), targetUser.getUserId());
		}

		_log.info("Team user post:"+StringUtil.merge(addTeams));
		return targetUser;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ImportUsersHelperLocalServiceImpl.class);
	
}