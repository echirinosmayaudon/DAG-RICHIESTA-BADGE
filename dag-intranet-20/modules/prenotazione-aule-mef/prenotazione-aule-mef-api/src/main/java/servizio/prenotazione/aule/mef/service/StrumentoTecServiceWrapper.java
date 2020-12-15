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
 * Provides a wrapper for {@link StrumentoTecService}.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTecService
 * @generated
 */
@ProviderType
public class StrumentoTecServiceWrapper implements StrumentoTecService,
	ServiceWrapper<StrumentoTecService> {
	public StrumentoTecServiceWrapper(StrumentoTecService strumentoTecService) {
		_strumentoTecService = strumentoTecService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _strumentoTecService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.StrumentoTec> getStrumentoTecListByDescStrumento(
		java.lang.String desc_strumento) {
		return _strumentoTecService.getStrumentoTecListByDescStrumento(desc_strumento);
	}

	@Override
	public StrumentoTecService getWrappedService() {
		return _strumentoTecService;
	}

	@Override
	public void setWrappedService(StrumentoTecService strumentoTecService) {
		_strumentoTecService = strumentoTecService;
	}

	private StrumentoTecService _strumentoTecService;
}