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

package servizio.local.bfc.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LocalRichService}.
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichService
 * @generated
 */
@ProviderType
public class LocalRichServiceWrapper implements LocalRichService,
	ServiceWrapper<LocalRichService> {
	public LocalRichServiceWrapper(LocalRichService localRichService) {
		_localRichService = localRichService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _localRichService.getOSGiServiceIdentifier();
	}

	@Override
	public LocalRichService getWrappedService() {
		return _localRichService;
	}

	@Override
	public void setWrappedService(LocalRichService localRichService) {
		_localRichService = localRichService;
	}

	private LocalRichService _localRichService;
}