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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Scrivania. This utility wraps
 * {@link autorizzazione.dir.mef.service.impl.ScrivaniaServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaService
 * @see autorizzazione.dir.mef.service.base.ScrivaniaServiceBaseImpl
 * @see autorizzazione.dir.mef.service.impl.ScrivaniaServiceImpl
 * @generated
 */
@ProviderType
public class ScrivaniaServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link autorizzazione.dir.mef.service.impl.ScrivaniaServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean addAppToHome(long userId, long applicationId) {
		return getService().addAppToHome(userId, applicationId);
	}

	public static boolean addAppToProfile(long userId, long applicationId) {
		return getService().addAppToProfile(userId, applicationId);
	}

	public static boolean removeAppFromHome(long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getService().removeAppFromHome(userId, applicationId);
	}

	public static boolean removeAppFromProfile(long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getService().removeAppFromProfile(userId, applicationId);
	}

	public static java.lang.String getHomeApps(long userId) {
		return getService().getHomeApps(userId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String getProfileApps(long userId) {
		return getService().getProfileApps(userId);
	}

	public static ScrivaniaService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ScrivaniaService, ScrivaniaService> _serviceTracker =
		ServiceTrackerFactory.open(ScrivaniaService.class);
}