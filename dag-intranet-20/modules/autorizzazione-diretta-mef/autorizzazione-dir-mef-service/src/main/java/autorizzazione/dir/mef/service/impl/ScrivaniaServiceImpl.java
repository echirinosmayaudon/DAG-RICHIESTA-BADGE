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

package autorizzazione.dir.mef.service.impl;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import autorizzazione.dir.mef.exception.NoSuchScrivaniaException;
import autorizzazione.dir.mef.service.base.ScrivaniaServiceBaseImpl;

/**
 * The implementation of the scrivania remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link autorizzazione.dir.mef.service.ScrivaniaService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaServiceBaseImpl
 * @see autorizzazione.dir.mef.service.ScrivaniaServiceUtil
 */
public class ScrivaniaServiceImpl extends ScrivaniaServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link autorizzazione.dir.mef.service.ScrivaniaServiceUtil} to access the scrivania remote service.
	 */
	
	@JSONWebService
	public boolean addAppToHome(long userId, long applicationId) {
		return scrivaniaLocalService.addAppToHome(userId, applicationId);
	}
	
	@JSONWebService
	public boolean addAppToProfile(long userId, long applicationId) {
		return scrivaniaLocalService.addAppToProfile(userId, applicationId);
	}
	
	@JSONWebService
	public boolean removeAppFromHome(long userId, long applicationId) throws NoSuchScrivaniaException {
		return scrivaniaLocalService.removeAppFromHome(userId, applicationId);
	}
	
	@JSONWebService
	public boolean removeAppFromProfile(long userId, long applicationId) throws NoSuchScrivaniaException {
		return scrivaniaLocalService.removeAppFromProfile(userId, applicationId);
	}
	
	@JSONWebService
	public String getHomeApps(long userId) {
		return scrivaniaLocalService.getHomeApps(userId);
	}
	
	@JSONWebService
	public String getProfileApps(long userId) {
		return scrivaniaLocalService.getProfileApps(userId);
	}

}