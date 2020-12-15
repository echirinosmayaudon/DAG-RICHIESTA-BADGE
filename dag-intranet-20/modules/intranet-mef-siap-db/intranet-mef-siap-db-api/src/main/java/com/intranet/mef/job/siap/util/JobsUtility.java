package com.intranet.mef.job.siap.util;

import java.util.ArrayList;
import java.util.List;

import com.intranet.mef.job.siap.constants.IntranetMefConstants;
import com.intranet.mef.job.siap.model.ManagerOfficesBind;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.model.UserPosition;
import com.intranet.mef.job.siap.service.ManagerOfficesBindLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.job.siap.service.UserPositionLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleServiceUtil;
import com.liferay.portal.kernel.service.TeamLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.comparator.RoleNameComparator;
import com.liferay.portal.kernel.util.comparator.TeamNameComparator;

public class JobsUtility {

	/*
	 * Restituisce il roleId se è Dirigente altrimenti -1
	 */
	public static long getRoleIdDipendente(){
		long companyId = PortalUtil.getDefaultCompanyId();

		try {

			Role role = RoleServiceUtil.getRole(
				companyId, IntranetMefConstants.ROLE_DIPENDENTE);

			return role.getRoleId();
		} catch (PortalException e) {
			_log.error("Error get role dipendente");
			_log.error(e);
		}
		return -1;
	}
	
	public static long getRolePosGiuridica(String position) {

		long companyId = PortalUtil.getDefaultCompanyId();
		try {
			UserPosition userpos = UserPositionLocalServiceUtil.fetchUserPosition(position);
			if (Validator.isNotNull(userpos)) {
				Role role = RoleServiceUtil.getRole(companyId, userpos.getRuoloGiuridico());
				return role.getRoleId();
			}
		} catch (PortalException e) {
			_log.error("Error get role posizione giuridica");
			_log.error(e);
		}
		return -1;
	}

	
	public static long getRolePosEconomica(String position) {

		long companyId = PortalUtil.getDefaultCompanyId();
		try {
			UserPosition userpos = UserPositionLocalServiceUtil.fetchUserPosition(position);
			if (Validator.isNotNull(userpos)) {
				Role role = RoleServiceUtil.getRole(companyId, userpos.getRuoloEconomico());
				return role.getRoleId();
			}
		} catch (PortalException e) {
			_log.error("Error get role posizione economica");
			_log.error(e);
		}
		return -1;
	}	
	
	
	public static long getRoleIdDirigente(long personId, long idOrgChart){
		long companyId = PortalUtil.getDefaultCompanyId();

		try {
			ManagerOfficesBind managerOfficesBind =
				ManagerOfficesBindLocalServiceUtil.fetchManagerOfficesBindByP_I(
				personId, idOrgChart);

			if (Validator.isNotNull(managerOfficesBind)){
				Role role = RoleServiceUtil.getRole(
					companyId, IntranetMefConstants.ROLE_DIRIGENTE);
				return role.getRoleId();
			}
		} catch (PortalException e) {
			_log.error("Error get role dirigente");
			_log.error(e);
		}

		return -1;
	}

	public static Role getRoleByOrgChartId(long id){
		long companyId = PortalUtil.getDefaultCompanyId();
		String name = "";
		String description = String.valueOf(id);
		
		List<Role> roles = RoleLocalServiceUtil.search(companyId, name, description, new Integer[] {RoleConstants.TYPE_REGULAR}, QueryUtil.ALL_POS,QueryUtil.ALL_POS, new RoleNameComparator(true));
		for (Role role : roles){
			_log.info("RoleID: "+role.getRoleId()+" RoleName: "+role.getName());
		}
		if (!roles.isEmpty()){
			return roles.get(0);
		}
		return null;
	}

	/*
	 * for Id 
	 * if Sede = true pass LocationId
	 * Else pass IdOrgChart
	 * 
	 */
	
	public static List<Team> getTeamsById(long groupId, long id, boolean sede){

		String description;
		if (sede){				
			description = "sede_"+String.valueOf(id);
			
		}
		else {
			description = ""+String.valueOf(id);

		}
		
		List<Team> teams = TeamLocalServiceUtil.search(groupId, "", description, null,
			QueryUtil.ALL_POS,QueryUtil.ALL_POS, new TeamNameComparator(true));

		for (Team t : teams){
			_log.info("TeamId: "+t.getTeamId()+" TeamName: "+t.getTeamId());
		}
		
		if (Validator.isNotNull(teams) && !teams.isEmpty()){
			return teams;
		}
		else return null;
	}

	public static void setUserExpandoValue(
		User user, String attributeName, String attributeValue){

		user.getExpandoBridge().setAttribute(
			attributeName, attributeValue, false);

	}

	public static int LevelByIdChart(long id){
		OrganizationChart org = null;
		try {			
			org = OrganizationChartLocalServiceUtil.getOrganizationChart(id);
		} catch (PortalException e) {
			_log.error("Error search ID Organization Chart="+id);
			_log.error(e);
		}
		if (org!= null){
			return org.getLevel();
		}
		return -1;
		
	}
	private static Log _log = LogFactoryUtil.getLog(JobsUtility.class);	
    
}