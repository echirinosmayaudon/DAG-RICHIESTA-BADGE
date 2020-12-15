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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReplicaUsersHelperLocalService}.
 *
 * @author Domenico Costa
 * @see ReplicaUsersHelperLocalService
 * @generated
 */
@ProviderType
public class ReplicaUsersHelperLocalServiceWrapper
	implements ReplicaUsersHelperLocalService,
		ServiceWrapper<ReplicaUsersHelperLocalService> {
	public ReplicaUsersHelperLocalServiceWrapper(
		ReplicaUsersHelperLocalService replicaUsersHelperLocalService) {
		_replicaUsersHelperLocalService = replicaUsersHelperLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User addTargetUser(
		com.liferay.portal.kernel.model.User masterUser, long targetCompanyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _replicaUsersHelperLocalService.addTargetUser(masterUser,
			targetCompanyId);
	}

	@Override
	public com.liferay.portal.kernel.model.User updateTargetUser(
		com.liferay.portal.kernel.model.User masterUser,
		com.liferay.portal.kernel.model.User targetUser2)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _replicaUsersHelperLocalService.updateTargetUser(masterUser,
			targetUser2);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _replicaUsersHelperLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public ReplicaUsersHelperLocalService getWrappedService() {
		return _replicaUsersHelperLocalService;
	}

	@Override
	public void setWrappedService(
		ReplicaUsersHelperLocalService replicaUsersHelperLocalService) {
		_replicaUsersHelperLocalService = replicaUsersHelperLocalService;
	}

	private ReplicaUsersHelperLocalService _replicaUsersHelperLocalService;
}