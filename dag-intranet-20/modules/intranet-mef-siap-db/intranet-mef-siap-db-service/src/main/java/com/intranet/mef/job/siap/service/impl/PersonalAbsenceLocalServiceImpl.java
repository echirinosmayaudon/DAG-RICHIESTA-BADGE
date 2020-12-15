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

import com.intranet.mef.job.siap.model.PersonalAbsence;
import com.intranet.mef.job.siap.service.PersonalAbsenceLocalServiceUtil;
import com.intranet.mef.job.siap.service.base.PersonalAbsenceLocalServiceBaseImpl;
import com.intranet.mef.job.siap.service.persistence.PersonalAbsenceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the personal absence local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.job.siap.service.PersonalAbsenceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsenceLocalServiceBaseImpl
 * @see com.intranet.mef.job.siap.service.PersonalAbsenceLocalServiceUtil
 */
@ProviderType
public class PersonalAbsenceLocalServiceImpl
	extends PersonalAbsenceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.job.siap.service.PersonalAbsenceLocalServiceUtil} to access the personal absence local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(PersonalAbsenceLocalServiceImpl.class);
	@Override	
	public List<PersonalAbsence> getByPersonIdAndRefMonth(long personId, String refMonth){
		DynamicQuery personalAbsenceQuery = PersonalAbsenceLocalServiceUtil.dynamicQuery();
		personalAbsenceQuery.add(PropertyFactoryUtil.forName("personId").eq(personId));
		personalAbsenceQuery.add(PropertyFactoryUtil.forName("refMonth").eq(refMonth));
		personalAbsenceQuery.addOrder(OrderFactoryUtil.asc("absenceDate"));
		personalAbsenceQuery.addOrder(OrderFactoryUtil.asc("from"));
        List<PersonalAbsence> entries = PersonalAbsenceLocalServiceUtil.dynamicQuery(personalAbsenceQuery);
		
//        Collections.sort(entries, new Comparator<PersonalAbsence>() {
//            public int compare(PersonalAbsence m1, PersonalAbsence m2) {
//                return m1.getAbsenceDate().compareTo(m2.getAbsenceDate());
//            }
//        });
//        for (PersonalAbsence absence: entries){
//			_log.info("Absence Info: RefMonth:"+absence.getRefMonth()+", Date:"+absence.getAbsenceDate()+", From:"+absence.getFrom()+", Hours:"+absence.getHours()+", Description:"+absence.getDescription());
//		}
        return entries;
		
		//return PersonalAbsenceUtil.findByPersonIdAndRefMonth(personId, refMonth);
	}
}