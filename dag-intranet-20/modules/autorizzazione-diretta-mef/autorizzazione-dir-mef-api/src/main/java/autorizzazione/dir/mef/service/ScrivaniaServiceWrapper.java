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

package autorizzazione.dir.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScrivaniaService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaService
 * @generated
 */
@ProviderType
public class ScrivaniaServiceWrapper implements ScrivaniaService,
	ServiceWrapper<ScrivaniaService> {
	public ScrivaniaServiceWrapper(ScrivaniaService scrivaniaService) {
		_scrivaniaService = scrivaniaService;
	}

	@Override
	public boolean addAppToHome(long userId, long applicationId) {
		return _scrivaniaService.addAppToHome(userId, applicationId);
	}

	@Override
	public boolean addAppToProfile(long userId, long applicationId) {
		return _scrivaniaService.addAppToProfile(userId, applicationId);
	}

	@Override
	public boolean removeAppFromHome(long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return _scrivaniaService.removeAppFromHome(userId, applicationId);
	}

	@Override
	public boolean removeAppFromProfile(long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return _scrivaniaService.removeAppFromProfile(userId, applicationId);
	}

	@Override
	public java.lang.String getHomeApps(long userId) {
		return _scrivaniaService.getHomeApps(userId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _scrivaniaService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getProfileApps(long userId) {
		return _scrivaniaService.getProfileApps(userId);
	}

	@Override
	public ScrivaniaService getWrappedService() {
		return _scrivaniaService;
	}

	@Override
	public void setWrappedService(ScrivaniaService scrivaniaService) {
		_scrivaniaService = scrivaniaService;
	}

	private ScrivaniaService _scrivaniaService;
}