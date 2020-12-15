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
 * Provides the local service utility for ReplicaUsersHelper. This utility wraps
 * {@link com.intranet.mef.importusers.service.impl.ReplicaUsersHelperLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Domenico Costa
 * @see ReplicaUsersHelperLocalService
 * @see com.intranet.mef.importusers.service.base.ReplicaUsersHelperLocalServiceBaseImpl
 * @see com.intranet.mef.importusers.service.impl.ReplicaUsersHelperLocalServiceImpl
 * @generated
 */
@ProviderType
public class ReplicaUsersHelperLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.importusers.service.impl.ReplicaUsersHelperLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User addTargetUser(
		com.liferay.portal.kernel.model.User masterUser, long targetCompanyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addTargetUser(masterUser, targetCompanyId);
	}

	public static com.liferay.portal.kernel.model.User updateTargetUser(
		com.liferay.portal.kernel.model.User masterUser,
		com.liferay.portal.kernel.model.User targetUser2)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateTargetUser(masterUser, targetUser2);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ReplicaUsersHelperLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReplicaUsersHelperLocalService, ReplicaUsersHelperLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ReplicaUsersHelperLocalService.class);
}