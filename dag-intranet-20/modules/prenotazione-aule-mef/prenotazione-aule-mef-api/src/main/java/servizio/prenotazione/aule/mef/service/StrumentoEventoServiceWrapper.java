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
 * Provides a wrapper for {@link StrumentoEventoService}.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoEventoService
 * @generated
 */
@ProviderType
public class StrumentoEventoServiceWrapper implements StrumentoEventoService,
	ServiceWrapper<StrumentoEventoService> {
	public StrumentoEventoServiceWrapper(
		StrumentoEventoService strumentoEventoService) {
		_strumentoEventoService = strumentoEventoService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _strumentoEventoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.StrumentoEvento> getStrumentoEventoListByDescStrumento(
		java.lang.String desc_strumento) {
		return _strumentoEventoService.getStrumentoEventoListByDescStrumento(desc_strumento);
	}

	@Override
	public StrumentoEventoService getWrappedService() {
		return _strumentoEventoService;
	}

	@Override
	public void setWrappedService(StrumentoEventoService strumentoEventoService) {
		_strumentoEventoService = strumentoEventoService;
	}

	private StrumentoEventoService _strumentoEventoService;
}