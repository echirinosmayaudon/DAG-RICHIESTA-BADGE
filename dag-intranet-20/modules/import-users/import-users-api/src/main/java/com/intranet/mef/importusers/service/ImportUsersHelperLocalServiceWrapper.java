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
 * Provides a wrapper for {@link ImportUsersHelperLocalService}.
 *
 * @author Domenico Costa
 * @see ImportUsersHelperLocalService
 * @generated
 */
@ProviderType
public class ImportUsersHelperLocalServiceWrapper
	implements ImportUsersHelperLocalService,
		ServiceWrapper<ImportUsersHelperLocalService> {
	public ImportUsersHelperLocalServiceWrapper(
		ImportUsersHelperLocalService importUsersHelperLocalService) {
		_importUsersHelperLocalService = importUsersHelperLocalService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _importUsersHelperLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void importUser(long companyId,
		com.intranet.mef.job.siap.model.UserFrontierBind userFrontierBind,
		java.lang.StringBuilder emailBody) {
		_importUsersHelperLocalService.importUser(companyId, userFrontierBind,
			emailBody);
	}

	@Override
	public ImportUsersHelperLocalService getWrappedService() {
		return _importUsersHelperLocalService;
	}

	@Override
	public void setWrappedService(
		ImportUsersHelperLocalService importUsersHelperLocalService) {
		_importUsersHelperLocalService = importUsersHelperLocalService;
	}

	private ImportUsersHelperLocalService _importUsersHelperLocalService;
}