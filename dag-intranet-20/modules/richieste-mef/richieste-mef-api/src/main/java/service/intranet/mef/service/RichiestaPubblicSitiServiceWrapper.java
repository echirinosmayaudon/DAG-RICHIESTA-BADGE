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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RichiestaPubblicSitiService}.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPubblicSitiService
 * @generated
 */
@ProviderType
public class RichiestaPubblicSitiServiceWrapper
	implements RichiestaPubblicSitiService,
		ServiceWrapper<RichiestaPubblicSitiService> {
	public RichiestaPubblicSitiServiceWrapper(
		RichiestaPubblicSitiService richiestaPubblicSitiService) {
		_richiestaPubblicSitiService = richiestaPubblicSitiService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _richiestaPubblicSitiService.getOSGiServiceIdentifier();
	}

	@Override
	public RichiestaPubblicSitiService getWrappedService() {
		return _richiestaPubblicSitiService;
	}

	@Override
	public void setWrappedService(
		RichiestaPubblicSitiService richiestaPubblicSitiService) {
		_richiestaPubblicSitiService = richiestaPubblicSitiService;
	}

	private RichiestaPubblicSitiService _richiestaPubblicSitiService;
}