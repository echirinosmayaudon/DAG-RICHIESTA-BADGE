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

package servizio.prenotazione.aule.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrarioService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrarioService
 * @generated
 */
@ProviderType
public class OrarioServiceWrapper implements OrarioService,
	ServiceWrapper<OrarioService> {
	public OrarioServiceWrapper(OrarioService orarioService) {
		_orarioService = orarioService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _orarioService.getOSGiServiceIdentifier();
	}

	@Override
	public OrarioService getWrappedService() {
		return _orarioService;
	}

	@Override
	public void setWrappedService(OrarioService orarioService) {
		_orarioService = orarioService;
	}

	private OrarioService _orarioService;
}