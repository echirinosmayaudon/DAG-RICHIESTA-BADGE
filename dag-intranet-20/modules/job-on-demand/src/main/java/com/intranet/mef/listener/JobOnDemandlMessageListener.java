package com.intranet.mef.listener;

import com.intranet.mef.job.siap.model.City;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
import com.intranet.mef.job.siap.service.LocationLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.job.siap.util.JobsUtility;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.exception.TeamNameException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.TeamLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sangiovanni Roberto
 */
@Component(
		immediate = true,
		property = {
				"destination.name=" + "job/ondemand"
		},
		service = MessageListener.class
		)
public class JobOnDemandlMessageListener extends BaseMessageListener {
	private static Log _log = LogFactoryUtil.getLog(JobOnDemandlMessageListener.class);
	private static final String IS_ARCHITECTURAL = "isArchitectural";
	private static final String DEFAULT_SITE = "/guest";

	@Override
	protected void doReceive(Message message) throws Exception {
		CacheRegistryUtil.clear();
		_log.info("******** Job Executing ********");
		_log.info("This is the configuration: "+ message.get("config-json").toString());

		String siteURL = PropsUtil.get("mef-intranet-site-url");
		if (siteURL==null || "".equals(siteURL)){
			siteURL = DEFAULT_SITE;
		}
		_log.info("siteURL: "+siteURL);
		Long companyId = CompanyThreadLocal.getCompanyId();
		long groupId = GroupLocalServiceUtil.getFriendlyURLGroup(companyId,siteURL).getGroupId(); 
		String className =  User.class.getName();  //com.liferay.portal.kernel.model.User
		String tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME; //CUSTOM_FIELDS . Here you can give any name by Default is CUSTOM_FIELDS
		
		
		ExpandoTable expandoTable = addExpandoTable(companyId, className, tableName);	
        User.class.getName();
		String classNameTeam =  Team.class.getName();  //com.liferay.portal.kernel.model.Team		
		ExpandoTable expandoTableTeam = addExpandoTable(companyId, classNameTeam, tableName);
		int typeTeam= ExpandoColumnConstants.BOOLEAN;
		Object defaultValueTeam = false;
		addExpandoColumn(companyId, classNameTeam, tableName, IS_ARCHITECTURAL, typeTeam, expandoTableTeam, defaultValueTeam);

		JSONObject config = (JSONObject) message.get("config-json");
		boolean customFieldEnabled = config.getBoolean("custom_fields_enabled");
		boolean locationEnabled = config.getBoolean("location-enabled");
		boolean rolesEnabled = config.getBoolean("teamAndRoles-enabled");

		if (customFieldEnabled){
			JSONArray customFields = config.getJSONArray("custom_fields");
			int l = customFields.length();
			for(int i=0; i<l; i++){
				JSONObject customField = customFields.getJSONObject(i);
				String name = customField.getString("name");
				String typeLabel = customField.getString("type");
				int type = 0;
				Object defaultValue = null;
				switch (typeLabel) {
				case "BOOLEAN":
					type= ExpandoColumnConstants.BOOLEAN;
					defaultValue = customField.getBoolean("defaultValue");
					break;
				case "STRING":
					type= ExpandoColumnConstants.STRING;
					defaultValue = customField.getString("defaultValue");
					break;
				case "LONG":
					type= ExpandoColumnConstants.LONG;
					defaultValue = customField.getLong("defaultValue");
					break;
				case "DATE":
					type= ExpandoColumnConstants.DATE;
					String tempDefault = customField.getString("defaultValue");
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
					try {
						defaultValue = formatter.parse(tempDefault+" 00:00");
					} catch (ParseException e) {
						_log.info(e);
					}				 
					break;
				default:
					break;
				}

				addExpandoColumn(companyId, className, tableName, name, type, expandoTable, defaultValue);

			}
			_log.info("This is the list of custom fields: "+ customFields.toString());
		}
		long userId = UserLocalServiceUtil.getDefaultUserId(companyId);
		ServiceContext sv = new ServiceContext();
		if (rolesEnabled){
					

			List<OrganizationChart> orgCharts = OrganizationChartLocalServiceUtil.getOrganizationCharts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			boolean roleCreated;

			for(OrganizationChart orgChart : orgCharts){
				int level = orgChart.getLevel();
				Location loc = null;
				City city = null;
				try{
					loc = LocationLocalServiceUtil.getLocation(orgChart.getLocationId());

				}
				catch(Exception e){
					_log.info("Location with id "+orgChart.getLocationId()+" is duplicated" + e);
				}
				try{
					if (loc!=null)
						city = CityLocalServiceUtil.getCity(loc.getCity());
				}
				catch(Exception e){
					_log.info("City with locationID "+loc.getCity()+" is not present in LF_COMUNI"+ e);			
				}

				if (city==null || loc ==null) continue;
				//dati per costruire il team o il ruolo			
				String sigProv = city.getProvince();
				String comune = city.getName();
				String orgName = orgChart.getName();
				String idOrg = ""+orgChart.getIdOrgChart();
				orgName = orgName.replaceAll(" -", "");		
				
				//creazione RUOLO			
				roleCreated = false;
				Role role=RoleLocalServiceUtil.createRole(999);
				Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
				long globalGroupId = company.getCompanyId();

				role.setCompanyId(globalGroupId);
				role.setClassNameId(PortalUtil.getClassNameId(Role.class));       
				role.setDescription(idOrg);
				role.setTitle(role.getName());
				role.setType(RoleConstants.TYPE_REGULAR);
				String nameRole;
				long roleId;
				String orgNameEsteso = orgName;
				String comuneEsteso = comune;
				switch (level){
				case 2 : 
					roleCreated = true;
					roleId=CounterLocalServiceUtil.increment(Role.class.getName());
					role.setRoleId(roleId);
					role.setClassPK(role.getRoleId());
					nameRole = "DIP_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName;
					if (nameRole.length()>75){
						nameRole = nameRole.substring(0, 75);
					}
					role.setName(nameRole);
					if (JobsUtility.getRoleByOrgChartId(orgChart.getIdOrgChart())!=null){
						_log.info("role "+nameRole+" already exists");
					}
					else {
						role=RoleLocalServiceUtil.addRole(role);
						role.getExpandoBridge().setAttribute("isArchitectural", true);
					}		        
					break;
				case 3:
					
					roleCreated = true;
					roleId=CounterLocalServiceUtil.increment(Role.class.getName());
					role.setRoleId(roleId);
					role.setClassPK(role.getRoleId());
					if (orgName.length()>28){
						orgName = orgName.substring(0,28);
					}
					if (comune.length()>25){
						comune = comune.substring(0,25);
					}
					nameRole = "DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName;
					if (nameRole.length()>75){
						nameRole = nameRole.substring(0, 75);
					}
					role.setName(nameRole);
					if (JobsUtility.getRoleByOrgChartId(orgChart.getIdOrgChart())!=null){
						_log.info("role "+nameRole+" already exists");
					}
					else {
						role=RoleLocalServiceUtil.addRole(role);
						role.getExpandoBridge().setAttribute("isArchitectural", true);
					}		        
					List<String> direzioniNames = new ArrayList<String>();
					//creazione DEI TEAM
					
					String nameDirection1 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DIPE");
					nameDirection1 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DIPE").substring(0,(nameDirection1.length()>=75)?75 : nameDirection1.length());
					
					String nameDirection2 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DRG");
					nameDirection2 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DRG").substring(0,(nameDirection2.length()>=75)?75 : nameDirection2.length());
					
					String nameDirection3 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DIPE_P");
					nameDirection3 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DIPE_P").substring(0,(nameDirection3.length()>=75)?75 : nameDirection3.length());
					
					String nameDirection4 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DIPE_C");
					nameDirection4 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DIPE_C").substring(0,(nameDirection4.length()>=75)?75 : nameDirection4.length());
					
					String nameDirection5 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DRG_P");
					nameDirection5 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DRG_P").substring(0,(nameDirection5.length()>=75)?75 : nameDirection5.length());
					
					String nameDirection6 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DRG_C");
					nameDirection6 = ("DRZ_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName+"_DRG_C").substring(0,(nameDirection6.length()>=75)?75 : nameDirection6.length());				
					
					direzioniNames.add(nameDirection1);
					direzioniNames.add(nameDirection4);
					direzioniNames.add(nameDirection3);
					direzioniNames.add(nameDirection2);
					direzioniNames.add(nameDirection6);
					direzioniNames.add(nameDirection5);
					List<Team> teams;
					if (( teams = JobsUtility.getTeamsById(groupId,orgChart.getIdOrgChart(),false))!=null){
						_log.info("Teams for DIRECTIONS already exists for orgChartId: "+orgChart.getIdOrgChart());
						int sizeTeams = teams.size();
						for (int i=0;i<sizeTeams;i++){
							//_log.info("----- name del team "+ teams.get(i).getTeamId()+": "+teams.get(i).getName()+" ------");
							teams.get(i).setName(direzioniNames.get(i));
							//teams.get(i).setDescription(direzioniNames.get(i));
							TeamLocalServiceUtil.updateTeam(teams.get(i).getTeamId(),teams.get(i).getName(),teams.get(i).getName());
						}
					}
					else{
						_log.info("Adding direction: "+nameDirection1);
						_log.info("Adding direction: "+nameDirection2);
						_log.info("Adding direction: "+nameDirection3);
						_log.info("Adding direction: "+nameDirection4);
						_log.info("Adding direction: "+nameDirection5);
						_log.info("Adding direction: "+nameDirection6);
						TeamLocalServiceUtil.addTeam(userId, groupId, nameDirection1, nameDirection1, sv).getExpandoBridge().setAttribute("isArchitectural", true);
						TeamLocalServiceUtil.addTeam(userId, groupId, nameDirection2, nameDirection2, sv).getExpandoBridge().setAttribute("isArchitectural", true);
						TeamLocalServiceUtil.addTeam(userId, groupId, nameDirection3, nameDirection3, sv).getExpandoBridge().setAttribute("isArchitectural", true);
						TeamLocalServiceUtil.addTeam(userId, groupId, nameDirection4, nameDirection4, sv).getExpandoBridge().setAttribute("isArchitectural", true);
						TeamLocalServiceUtil.addTeam(userId, groupId, nameDirection5, nameDirection5, sv).getExpandoBridge().setAttribute("isArchitectural", true);
						TeamLocalServiceUtil.addTeam(userId, groupId, nameDirection6, nameDirection6, sv).getExpandoBridge().setAttribute("isArchitectural", true);
					}
					break;
				case 4: case 5:
					//creazione DEI TEAM
					
					String nameUFF = ("UFF_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName);
					nameUFF = ("UFF_"+sigProv+"_"+comune+"_"+idOrg+"_"+orgName).substring(0,(nameUFF.length()>=75)?75 : nameUFF.length());
					List<Team> uffici;
					if ((uffici=JobsUtility.getTeamsById(groupId,orgChart.getIdOrgChart(),false))!=null){
						_log.info("Team UFF already exists for orgChartId: "+orgChart.getIdOrgChart());
						uffici.get(0).setName(nameUFF);
						TeamLocalServiceUtil.updateTeam(uffici.get(0).getTeamId(),uffici.get(0).getName(),idOrg+"_"+comuneEsteso+"_"+orgNameEsteso);
					}
					else{
						try{
							TeamLocalServiceUtil.addTeam(userId, groupId, nameUFF, idOrg+"_"+comuneEsteso+"_"+orgNameEsteso, sv).getExpandoBridge().setAttribute("isArchitectural", true);
						}
						catch(TeamNameException e){
							_log.info("Office name has wrong format: "+nameUFF+e);
						}
					}
					break;
				}
				if (roleCreated){
					ResourcePermission resourcePermission;
					resourcePermission = ResourcePermissionLocalServiceUtil.createResourcePermission(CounterLocalServiceUtil.increment());
					resourcePermission.setCompanyId(globalGroupId);
					resourcePermission.setName(Role.class.getName());
					resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
					resourcePermission.setPrimKey(String.valueOf(role.getPrimaryKey()));
					resourcePermission.setRoleId(role.getRoleId());

					ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(Role.class.getName(), ActionKeys.VIEW);
					resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
					ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
				}

			}
		}
		if (locationEnabled){
			List<Location> locations = LocationLocalServiceUtil.getLocations(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (Location location: locations){
				City c = null;
				try{
					c = CityLocalServiceUtil.getCity(location.getCity());
				}
				catch(Exception e){
					_log.info("City with locationID "+location.getCity()+" is not present in LF_COMUNI"+e);			
				}

				if (c==null) continue;
				//dati per costruire il team o il ruolo			
				String sigProv = c.getProvince();
				String comune = c.getName();
				String street = location.getStreet();
				String idLoc = ""+location.getLocationID();		
				street = street.replaceAll(" -", "");
				street = street.replaceAll(", ", "_");
				street = street.replaceAll("/","_");
				street = street.replaceAll(" ,", "_");
				String nameSede = ("SEDE_"+sigProv+"_"+comune+"_"+idLoc+"_"+street);
				nameSede = ("SEDE_"+sigProv+"_"+comune+"_"+idLoc+"_"+street).substring(0,(nameSede.length()>=75)?75 : nameSede.length());
				List<Team> sedi;
				if ((sedi = JobsUtility.getTeamsById(groupId,location.getLocationID(),true))!=null){
					_log.info("Team Sede already exists for locationID: "+location.getLocationID());
					sedi.get(0).setName(nameSede);
					TeamLocalServiceUtil.updateTeam(sedi.get(0).getTeamId(), sedi.get(0).getName(), sedi.get(0).getDescription());
				}
				else{
					try{
						TeamLocalServiceUtil.addTeam(userId, groupId, nameSede, "sede_"+idLoc, sv).getExpandoBridge().setAttribute("isArchitectural", true);
					}
					catch(TeamNameException e) {
						_log.info("Team Sede name format is wrong :"+nameSede+e);
					}
				}

			}
		}


	}
	/*
	 * This method first check that there is expandotable exist with name CUSTOM_FIELDS(for user)
	 * if present it returns otherwise add the table entry in expandotable
	 * */	
	public ExpandoTable addExpandoTable(long companyId,String className,String tableName){
		ExpandoTable expandoTable = null;
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId,className);
		} catch (NoSuchTableException e) {
			_log.error(e);
			try {
				expandoTable = ExpandoTableLocalServiceUtil.addTable(companyId,className, tableName);
			} catch (Exception e1) {
				_log.error(e1);
			}
		} catch (Exception e) {
			_log.error(e);
		} 
		return expandoTable;

	}

	/*
	 * This method first check if there is column with name columnName in User CUSTOM_FIELDS table
	 * if present it returns otherwise add column entry in expandoColumn
	 * */
	public ExpandoColumn addExpandoColumn(long companyId,String className,String tableName,String columnName, int type, ExpandoTable expandoTable, Object defaultValue){
		ExpandoColumn expandoColumn = null;
		try {
			expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className,tableName,columnName);
			if (expandoColumn ==null)
			{
				expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(),columnName,type ,defaultValue);
			}

		} catch (SystemException | PortalException e) {
			_log.error(e);
		}

		return expandoColumn;	
	}


}