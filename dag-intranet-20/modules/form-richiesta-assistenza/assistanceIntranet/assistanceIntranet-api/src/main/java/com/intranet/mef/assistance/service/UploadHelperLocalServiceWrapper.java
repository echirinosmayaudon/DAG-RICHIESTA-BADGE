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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UploadHelperLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UploadHelperLocalService
 * @generated
 */
@ProviderType
public class UploadHelperLocalServiceWrapper implements UploadHelperLocalService,
	ServiceWrapper<UploadHelperLocalService> {
	public UploadHelperLocalServiceWrapper(
		UploadHelperLocalService uploadHelperLocalService) {
		_uploadHelperLocalService = uploadHelperLocalService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _uploadHelperLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void uploadTripleteFaq(java.io.File csvTriplete, java.io.File csvFaq) {
		_uploadHelperLocalService.uploadTripleteFaq(csvTriplete, csvFaq);
	}

	@Override
	public UploadHelperLocalService getWrappedService() {
		return _uploadHelperLocalService;
	}

	@Override
	public void setWrappedService(
		UploadHelperLocalService uploadHelperLocalService) {
		_uploadHelperLocalService = uploadHelperLocalService;
	}

	private UploadHelperLocalService _uploadHelperLocalService;
}