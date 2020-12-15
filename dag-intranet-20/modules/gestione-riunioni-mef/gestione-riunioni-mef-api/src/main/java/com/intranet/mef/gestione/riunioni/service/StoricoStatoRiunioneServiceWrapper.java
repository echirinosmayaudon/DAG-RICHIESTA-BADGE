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

package com.intranet.mef.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StoricoStatoRiunioneService}.
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunioneService
 * @generated
 */
@ProviderType
public class StoricoStatoRiunioneServiceWrapper
	implements StoricoStatoRiunioneService,
		ServiceWrapper<StoricoStatoRiunioneService> {
	public StoricoStatoRiunioneServiceWrapper(
		StoricoStatoRiunioneService storicoStatoRiunioneService) {
		_storicoStatoRiunioneService = storicoStatoRiunioneService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _storicoStatoRiunioneService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione> getStoricoStatoRiunioneByIdRiunione(
		long idRiunione) {
		return _storicoStatoRiunioneService.getStoricoStatoRiunioneByIdRiunione(idRiunione);
	}

	@Override
	public StoricoStatoRiunioneService getWrappedService() {
		return _storicoStatoRiunioneService;
	}

	@Override
	public void setWrappedService(
		StoricoStatoRiunioneService storicoStatoRiunioneService) {
		_storicoStatoRiunioneService = storicoStatoRiunioneService;
	}

	private StoricoStatoRiunioneService _storicoStatoRiunioneService;
}