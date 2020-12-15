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

package com.intranet.mef.central.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.intranet.mef.job.siap.constants.IntranetMefConstants;
import com.intranet.mef.central.service.base.CentralInvokerLocalServiceBaseImpl;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.service.LocationLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;


/**
 * The implementation of the central invoker local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.central.service.CentralInvokerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvokerLocalServiceBaseImpl
 * @see com.intranet.mef.central.service.CentralInvokerLocalServiceUtil
 */
@ProviderType
public class CentralInvokerLocalServiceImpl
	extends CentralInvokerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.central.service.CentralInvokerLocalServiceUtil} to access the central invoker local service.
	 */
	
	/**
	 * Return all roles id of type Architettural
	 *
	 * @param companyId
	 * @return List<Role>
	 *
	 */
	public List<Long> getRolesIsArchitettural(Long companyId){

		List<Role> roles = RoleLocalServiceUtil.getRoles(companyId);

		List<Long> architetturalRoles = new ArrayList<Long>();

		for (Role role : roles){
			boolean isArchitettural = (Boolean) role.getExpandoBridge()
				.getAttribute(
					IntranetMefConstants.CUSTOM_FIELD_IS_ARCHITECTURAL, false);

			if (isArchitettural){
				architetturalRoles.add(role.getRoleId());
			}
		}

		return architetturalRoles;
	}

	/**
	 * Return all roles id of type Architettural
	 *
	 * @param companyId
	 * @return List<Role>
	 *
	 */
	public boolean isTeamArchitettural(Long teamId){

		boolean isArchitettural = false;
		try {
			Team team = teamLocalService.getTeam(teamId);
			isArchitettural = (Boolean) team.getExpandoBridge()
				.getAttribute(
					IntranetMefConstants.CUSTOM_FIELD_IS_ARCHITECTURAL, false);
		} catch (PortalException e) {
			_log.error("Error: " + e);
		}

		return isArchitettural;
	}
	
	@Override
	public List<Location> findLocationById(long id) {
		List<Location> entries= new ArrayList<Location>(0);
		try{		
			//  DynamicQuery queryLocation = DynamicQueryFactoryUtil.forClass(Location.class, Location.class.getClassLoader());
			DynamicQuery queryLocation = LocationLocalServiceUtil.dynamicQuery();
		        queryLocation.add(PropertyFactoryUtil.forName("locationID").eq(id));
		        entries = LocationLocalServiceUtil.dynamicQuery(queryLocation);
				
		} catch (Exception e) {
			_log.error("Error: " + e);
	    }

		return entries;
      
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CentralInvokerLocalServiceImpl.class);
	
}