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

package com.intranet.mef.assistance.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AssistanceHelper. This utility wraps
 * {@link com.intranet.mef.assistance.service.impl.AssistanceHelperLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AssistanceHelperLocalService
 * @see com.intranet.mef.assistance.service.base.AssistanceHelperLocalServiceBaseImpl
 * @see com.intranet.mef.assistance.service.impl.AssistanceHelperLocalServiceImpl
 * @generated
 */
@ProviderType
public class AssistanceHelperLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.assistance.service.impl.AssistanceHelperLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void uploadTripleteFaq(java.io.File csvTriplete,
		java.io.File csvFaq) {
		getService().uploadTripleteFaq(csvTriplete, csvFaq);
	}

	public static AssistanceHelperLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AssistanceHelperLocalService, AssistanceHelperLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AssistanceHelperLocalService.class);
}