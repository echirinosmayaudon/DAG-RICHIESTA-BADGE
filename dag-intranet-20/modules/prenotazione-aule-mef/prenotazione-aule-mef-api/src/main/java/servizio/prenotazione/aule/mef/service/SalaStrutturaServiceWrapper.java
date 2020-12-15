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
 * Provides a wrapper for {@link SalaStrutturaService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalaStrutturaService
 * @generated
 */
@ProviderType
public class SalaStrutturaServiceWrapper implements SalaStrutturaService,
	ServiceWrapper<SalaStrutturaService> {
	public SalaStrutturaServiceWrapper(
		SalaStrutturaService salaStrutturaService) {
		_salaStrutturaService = salaStrutturaService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _salaStrutturaService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.SalaStruttura> getSaleListByIdStruttura(
		long id_struttura) {
		return _salaStrutturaService.getSaleListByIdStruttura(id_struttura);
	}

	@Override
	public SalaStrutturaService getWrappedService() {
		return _salaStrutturaService;
	}

	@Override
	public void setWrappedService(SalaStrutturaService salaStrutturaService) {
		_salaStrutturaService = salaStrutturaService;
	}

	private SalaStrutturaService _salaStrutturaService;
}