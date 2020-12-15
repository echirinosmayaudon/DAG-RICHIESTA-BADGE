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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for BadgeRichieste. This utility wraps
 * {@link service.intranet.mef.service.impl.BadgeRichiesteServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BadgeRichiesteService
 * @see service.intranet.mef.service.base.BadgeRichiesteServiceBaseImpl
 * @see service.intranet.mef.service.impl.BadgeRichiesteServiceImpl
 * @generated
 */
@ProviderType
public class BadgeRichiesteServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.BadgeRichiesteServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONArray findSuggestionsBySurname(
		java.lang.String cognome, java.lang.String idOrgChart,
		java.lang.Long userId) {
		return getService().findSuggestionsBySurname(cognome, idOrgChart, userId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static BadgeRichiesteService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BadgeRichiesteService, BadgeRichiesteService> _serviceTracker =
		ServiceTrackerFactory.open(BadgeRichiesteService.class);
}