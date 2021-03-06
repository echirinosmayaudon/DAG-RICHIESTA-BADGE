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

package servizio.beni.facile.consumo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatoService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatoService
 * @generated
 */
@ProviderType
public class StatoServiceWrapper implements StatoService,
	ServiceWrapper<StatoService> {
	public StatoServiceWrapper(StatoService statoService) {
		_statoService = statoService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _statoService.getOSGiServiceIdentifier();
	}

	@Override
	public StatoService getWrappedService() {
		return _statoService;
	}

	@Override
	public void setWrappedService(StatoService statoService) {
		_statoService = statoService;
	}

	private StatoService _statoService;
}