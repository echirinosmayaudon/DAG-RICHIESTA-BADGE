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
 * Provides the remote service utility for UtilizzoApplicazioni. This utility wraps
 * {@link autorizzazione.dir.mef.service.impl.UtilizzoApplicazioniServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioniService
 * @see autorizzazione.dir.mef.service.base.UtilizzoApplicazioniServiceBaseImpl
 * @see autorizzazione.dir.mef.service.impl.UtilizzoApplicazioniServiceImpl
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link autorizzazione.dir.mef.service.impl.UtilizzoApplicazioniServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni addNewHit(
		long userId, long applicationId) {
		return getService().addNewHit(userId, applicationId);
	}

	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni addNewMediaHit(
		long applicationId) {
		return getService().addNewMediaHit(applicationId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<autorizzazione.dir.mef.model.UtilizzoApplicazioni> fetchLastMediaHits() {
		return getService().fetchLastMediaHits();
	}

	public static UtilizzoApplicazioniService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UtilizzoApplicazioniService, UtilizzoApplicazioniService> _serviceTracker =
		ServiceTrackerFactory.open(UtilizzoApplicazioniService.class);
}