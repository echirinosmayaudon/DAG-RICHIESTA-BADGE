package com.intranet.mef.central.util;

import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.job.siap.model.City;
import com.intranet.mef.job.siap.model.ClassificationLevel;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
import com.intranet.mef.job.siap.service.ClassificationLevelLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;


public class UserInfoUtil {
	private static final String ROLE_DIPENDENTE = "Dipendente";
	private static final String ROLE_DIRIGENTE = "Dirigente";
	private static final Log _log = LogFactoryUtil.getLog(UserInfoUtil.class);
	
	public static JSONObject getUserInfo(User user) throws PortalException{
	   JSONObject userInfo = JSONFactoryUtil.createJSONObject();
	   long companyId = PortalUtil.getDefaultCompanyId();
	   userInfo.put("dipartimento", "");
	   userInfo.put("direzione", "");
	   userInfo.put("centralePeriferico", "");
	   userInfo.put("ufficio", "");
	   userInfo.put("qualifica", "");
	   long roleIdDipendente = -1L;
	   long roleIdDirigente = -1L;
	   try {
			Role roleDip = RoleLocalServiceUtil.getRole(companyId, ROLE_DIPENDENTE);
			roleIdDipendente = roleDip.getRoleId();
			Role roleDir = RoleLocalServiceUtil.getRole(companyId, ROLE_DIRIGENTE);
			roleIdDirigente = roleDir.getRoleId();
	   } catch (PortalException e) {
			_log.error("Error get role Ids");
			_log.error(e);
	   }
	   
	   Long businessAddrTypeId = UserAddressUtil.getAddressTypeIdByName(UserAddressUtil.BUSINESS);
	   Long otherAddrTypeId = UserAddressUtil.getAddressTypeIdByName(UserAddressUtil.BIRTH);
	   List<Address> userAddresses = user.getAddresses();
	   userInfo.put("indirizzo","");
	   
	   String scala = "-";
	   String piano = "-";
	   String stanza = "-";
	   String provincia = "-";
	   
	   for (Address address: userAddresses){
		   if (address.getTypeId() == businessAddrTypeId){
			   scala = "".equals(address.getStreet3())?"-":address.getStreet3();
			   piano = "".equals(address.getStreet1())?"-":address.getStreet1();
			   stanza = "".equals(address.getStreet2())?"-":address.getStreet2();
		   }
		   
		   if (address.getTypeId() == otherAddrTypeId){
			   if (address.getCity()!= null && !"".equals(address.getCity()) && !"N/A".equals(address.getCity())){
				   String codiceComune = address.getCity();
				   try{
					   City city = CityLocalServiceUtil.getCity(codiceComune);
					   provincia = city.getProvinceName();
				   }catch(PortalException e){
					   provincia = "-";
					   _log.error(e);
				   }
				   
			   }
		   }
				  
	   }
	   
	   userInfo.put("indirizzo", "SCALA "+scala+" PIANO "+piano+" STANZA "+stanza+", "+provincia);
	   String sesso = user.isFemale() ? "F": "M";
	   userInfo.put("sesso", sesso);
	   
	   long[] roleIds = user.getRoleIds();
	   int roleIdsLength = roleIds.length;
	   userInfo.put("posizione", "");
	   for (int i=0; i<roleIdsLength;i++){
		   if (roleIds[i] == roleIdDipendente){
			   userInfo.put("posizione", ROLE_DIPENDENTE);
			   break;
		   }
		   if (roleIds[i] == roleIdDirigente){
			   userInfo.put("posizione", ROLE_DIRIGENTE);
			   break;
		   }
	   }
	   
	   String idOrgChart = (String) user.getExpandoBridge().getAttribute("idOrgChart");
	   if (idOrgChart != null && !"".equals(idOrgChart)){
		   OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(Long.parseLong(idOrgChart));
		   int level = orgChart.getLevel();
		   switch (level){
			   case 2: userInfo.put("dipartimento", ""+orgChart.getName());
				   	   break;
			   case 3: userInfo.put("direzione", ""+orgChart.getName());
			   		   
			   		   userInfo.put("dipartimento", ""+OrganizationChartLocalServiceUtil.getOrganizationChart(orgChart.getIdParent()).getName());
				   	   break;
			   case 4: userInfo.put("ufficio", ""+orgChart.getName());
			   		   OrganizationChart orgParent = OrganizationChartLocalServiceUtil.getOrganizationChart(orgChart.getIdParent());
	   		   		   userInfo.put("direzione", ""+orgParent.getName());
	   		   		   
	   		   		   userInfo.put("dipartimento", ""+OrganizationChartLocalServiceUtil.getOrganizationChart(orgParent.getIdParent()).getName());
	   		   		   break;
		   }
		   String levelId = (String) user.getExpandoBridge().getAttribute("levelId");
		   if (levelId != null && !"".equals(levelId) && !"0".equals(levelId)){
			   ClassificationLevel classificationLevel = ClassificationLevelLocalServiceUtil.getClassificationLevel(Long.parseLong(levelId));  
			   userInfo.put("qualifica", ""+classificationLevel.getCodEconomicPos());
		   }
		   else{
			   userInfo.put("qualifica", "");
		   }
		   orgChart.getLocationId();
		   List<Location> locations = CentralInvokerLocalServiceUtil.findLocationById(orgChart.getLocationId());
		   String locationType = locations.get(0).getLocationType();
		   userInfo.put("centralePeriferico", locationType);
	   }else{		   
		   userInfo.put("dipartimento", "");
		   userInfo.put("direzione", "");
		   userInfo.put("centralePeriferico", "");
		   userInfo.put("ufficio", "");
		   userInfo.put("qualifica", "");
	   }
	   return userInfo;
	   
	}
}
