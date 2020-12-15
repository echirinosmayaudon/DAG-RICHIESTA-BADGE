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
 * Provides a wrapper for {@link TipoBeneInvService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipoBeneInvService
 * @generated
 */
@ProviderType
public class TipoBeneInvServiceWrapper implements TipoBeneInvService,
	ServiceWrapper<TipoBeneInvService> {
	public TipoBeneInvServiceWrapper(TipoBeneInvService tipoBeneInvService) {
		_tipoBeneInvService = tipoBeneInvService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipoBeneInvService.getOSGiServiceIdentifier();
	}

	@Override
	public TipoBeneInvService getWrappedService() {
		return _tipoBeneInvService;
	}

	@Override
	public void setWrappedService(TipoBeneInvService tipoBeneInvService) {
		_tipoBeneInvService = tipoBeneInvService;
	}

	private TipoBeneInvService _tipoBeneInvService;
}