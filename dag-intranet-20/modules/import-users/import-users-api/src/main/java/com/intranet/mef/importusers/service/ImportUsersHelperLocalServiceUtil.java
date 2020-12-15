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

package com.intranet.mef.importusers.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ImportUsersHelper. This utility wraps
 * {@link com.intranet.mef.importusers.service.impl.ImportUsersHelperLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Domenico Costa
 * @see ImportUsersHelperLocalService
 * @see com.intranet.mef.importusers.service.base.ImportUsersHelperLocalServiceBaseImpl
 * @see com.intranet.mef.importusers.service.impl.ImportUsersHelperLocalServiceImpl
 * @generated
 */
@ProviderType
public class ImportUsersHelperLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.importusers.service.impl.ImportUsersHelperLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void importUser(long companyId,
		com.intranet.mef.job.siap.model.UserFrontierBind userFrontierBind,
		java.lang.StringBuilder emailBody) {
		getService().importUser(companyId, userFrontierBind, emailBody);
	}

	public static ImportUsersHelperLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImportUsersHelperLocalService, ImportUsersHelperLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ImportUsersHelperLocalService.class);
}