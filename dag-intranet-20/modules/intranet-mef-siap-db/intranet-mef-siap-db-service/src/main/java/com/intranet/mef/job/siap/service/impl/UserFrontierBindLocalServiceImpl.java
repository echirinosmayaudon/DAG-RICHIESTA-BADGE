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

import com.intranet.mef.job.siap.service.base.UserFrontierBindLocalServiceBaseImpl;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;

import java.util.List;

import com.intranet.mef.job.siap.model.UserFrontierBind;
/**
 * The implementation of the user frontier bind local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.service.UserFrontierBindLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFrontierBindLocalServiceBaseImpl
 * @see com.intranet.mef.service.UserFrontierBindLocalServiceUtil
 */
@ProviderType
public class UserFrontierBindLocalServiceImpl
	extends UserFrontierBindLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.service.UserFrontierBindLocalServiceUtil} to access the user frontier bind local service.
	 */

	/*
	 * Function PLSQL di test
	 * 
	 */
	
	public List<UserFrontierBind> getUserFrontierBindsWithoutCache(int start, int end){
		CacheRegistryUtil.clear();	
		return this.userFrontierBindPersistence.findAll(start, end, null,false );
	}
	
	public String callDummy(){

		return userFrontierBindFinder.callDummy();
	}

	/*
	 * Function PLSQL per storicizzare i dati dalla tabella di frontiera
	 * 
	 */
	public String callLoadBCK(){

		return userFrontierBindFinder.callLoadBck();
	}

	/*
	 * Function PLSQL per identificare i cf in errore in fase di import
	 * 
	 */
	public String callErrorImport(String cf){

		return userFrontierBindFinder.callErrorImport(cf);
	}
}