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

package servizio.richieste.badge.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GestioneUtentiService}.
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtentiService
 * @generated
 */
@ProviderType
public class GestioneUtentiServiceWrapper implements GestioneUtentiService,
	ServiceWrapper<GestioneUtentiService> {
	public GestioneUtentiServiceWrapper(
		GestioneUtentiService gestioneUtentiService) {
		_gestioneUtentiService = gestioneUtentiService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _gestioneUtentiService.getOSGiServiceIdentifier();
	}

	@Override
	public GestioneUtentiService getWrappedService() {
		return _gestioneUtentiService;
	}

	@Override
	public void setWrappedService(GestioneUtentiService gestioneUtentiService) {
		_gestioneUtentiService = gestioneUtentiService;
	}

	private GestioneUtentiService _gestioneUtentiService;
}