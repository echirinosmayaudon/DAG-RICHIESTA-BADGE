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

package mef.email.configurator.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import aQute.bnd.annotation.ProviderType;
import mef.email.configurator.model.AppNames;
import mef.email.configurator.service.AppNamesLocalServiceUtil;
import mef.email.configurator.service.base.AppNamesLocalServiceBaseImpl;


/**
 * The implementation of the app names local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link mef.email.configurator.service.AppNamesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppNamesLocalServiceBaseImpl
 * @see mef.email.configurator.service.AppNamesLocalServiceUtil
 */
@ProviderType
public class AppNamesLocalServiceImpl extends AppNamesLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(AppNamesLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link mef.email.configurator.service.AppNamesLocalServiceUtil} to access the app names local service.
	 */
	@Override
	public List<AppNames> getAppNamesByAppName(String appName){
		return this.appNamesPersistence.findByAppname(appName);
	}
	
	@Override
	public List<AppNames> getAppNamesByAppId(long appId){
		return this.appNamesPersistence.findByAppId(appId);
	}
	
	@Override
	public boolean insertAppNames(String appName){
		AppNames appNames=appNamesPersistence.create(-1);
		appNames.setAppname(appName);
		
		DynamicQuery queryMax=DynamicQueryFactoryUtil.forClass(AppNames.class,getClassLoader());
		queryMax.setProjection(ProjectionFactoryUtil.max("appid"));
	    List<Long> listaAppNames  =	AppNamesLocalServiceUtil.dynamicQuery(queryMax);
	if(!listaAppNames.isEmpty()){
		appNames.setAppid(listaAppNames.get(0)+1);
	}
		try{
			appNamesPersistence.updateImpl(appNames);
			return true;
		}catch(Exception e){
			 _log.error(e);
			return false;
		}
	}
	
}