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

package com.intranet.mef.job.siap.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.base.OrganizationChartLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the organization chart local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.job.siap.service.OrganizationChartLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationChartLocalServiceBaseImpl
 * @see com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil
 */
@ProviderType
public class OrganizationChartLocalServiceImpl
	extends OrganizationChartLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(OrganizationChartLocalServiceImpl.class); 
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil} to access the organization chart local service.
	 */
	
	
	@Override
	public List<OrganizationChart> getChildrenByLevelAndIdOrgChart(int level, long idOrgChart){
		List<OrganizationChart> results = new ArrayList<OrganizationChart>();
		try {
			DynamicQuery query = OrganizationChartLocalServiceUtil.dynamicQuery();
		            query.add(PropertyFactoryUtil.forName("level"+level).eq(idOrgChart));		      
			results = OrganizationChartLocalServiceUtil.dynamicQuery(query);
		}catch (Exception e){
			_log.error(e);
		}
		return results;
	}
}