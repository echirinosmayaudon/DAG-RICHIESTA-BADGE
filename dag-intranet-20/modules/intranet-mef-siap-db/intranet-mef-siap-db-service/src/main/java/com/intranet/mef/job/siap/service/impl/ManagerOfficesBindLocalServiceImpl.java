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

import java.util.List;

import com.intranet.mef.job.siap.model.ManagerOfficesBind;
import com.intranet.mef.job.siap.service.ManagerOfficesBindLocalServiceUtil;
import com.intranet.mef.job.siap.service.base.ManagerOfficesBindLocalServiceBaseImpl;
import com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactory;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

/**
 * The implementation of the manager offices bind local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.ManagerOfficesBindLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ManagerOfficesBindLocalServiceBaseImpl
 * @see com.intranet.mef.service.ManagerOfficesBindLocalServiceUtil
 */
@ProviderType
public class ManagerOfficesBindLocalServiceImpl
	extends ManagerOfficesBindLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.ManagerOfficesBindLocalServiceUtil} to access the manager offices bind local service.
	 */
	
	public ManagerOfficesBind fetchManagerOfficesBindByP_I(
		long personId, long idOrgChart){

		ManagerOfficesBind managerOfficesBind = null;

		DynamicQuery dynamicQuery = dynamicQuery();

		Criterion criteriaPersonId =
			RestrictionsFactoryUtil.eq("primaryKey.personalId", personId);
		Criterion criteriaPersonIdAndIdOrgChart = RestrictionsFactoryUtil.and(
			criteriaPersonId,
			RestrictionsFactoryUtil.eq("primaryKey.idOrgChart", idOrgChart));

		dynamicQuery.add(criteriaPersonIdAndIdOrgChart);

		List<ManagerOfficesBind> lists = dynamicQuery(dynamicQuery);

		if (!lists.isEmpty()){
			managerOfficesBind = lists.get(0);
		}

		return managerOfficesBind;
	}
	
	@Override
	public List<ManagerOfficesBind> getManagerOfficesBindByPersonId (long personId){
		return ManagerOfficesBindUtil.findByPersonId(personId);
	}
}