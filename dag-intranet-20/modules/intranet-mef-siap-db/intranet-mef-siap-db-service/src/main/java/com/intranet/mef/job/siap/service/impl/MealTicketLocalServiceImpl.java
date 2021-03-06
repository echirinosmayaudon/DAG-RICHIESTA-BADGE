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

import com.intranet.mef.job.siap.model.MealTicket;
import com.intranet.mef.job.siap.model.PersonalAbsence;
import com.intranet.mef.job.siap.service.PersonalAbsenceLocalServiceUtil;
import com.intranet.mef.job.siap.service.base.MealTicketLocalServiceBaseImpl;
import com.intranet.mef.job.siap.service.persistence.MealTicketUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import java.util.List;

/**
 * The implementation of the meal ticket local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.job.siap.service.MealTicketLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MealTicketLocalServiceBaseImpl
 * @see com.intranet.mef.job.siap.service.MealTicketLocalServiceUtil
 */
@ProviderType
public class MealTicketLocalServiceImpl extends MealTicketLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.job.siap.service.MealTicketLocalServiceUtil} to access the meal ticket local service.
	 */
	
	@Override	
	public List<MealTicket> getMealTicketByPersonId(long personId){
		
		return MealTicketUtil.findByPersonId(personId);
	}
	
}