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
 * Provides a wrapper for {@link SalaService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalaService
 * @generated
 */
@ProviderType
public class SalaServiceWrapper implements SalaService,
	ServiceWrapper<SalaService> {
	public SalaServiceWrapper(SalaService salaService) {
		_salaService = salaService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salaService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Sala> getSaleBySalaStrutturaList(
		java.util.List<servizio.prenotazione.aule.mef.model.SalaStruttura> list_sala_struttura)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _salaService.getSaleBySalaStrutturaList(list_sala_struttura);
	}

	@Override
	public SalaService getWrappedService() {
		return _salaService;
	}

	@Override
	public void setWrappedService(SalaService salaService) {
		_salaService = salaService;
	}

	private SalaService _salaService;
}