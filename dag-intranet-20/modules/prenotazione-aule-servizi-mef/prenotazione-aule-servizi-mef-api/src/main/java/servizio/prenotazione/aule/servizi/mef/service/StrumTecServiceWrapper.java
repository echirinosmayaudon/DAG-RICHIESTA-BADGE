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

package servizio.prenotazione.aule.servizi.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StrumTecService}.
 *
 * @author Brian Wing Shun Chan
 * @see StrumTecService
 * @generated
 */
@ProviderType
public class StrumTecServiceWrapper implements StrumTecService,
	ServiceWrapper<StrumTecService> {
	public StrumTecServiceWrapper(StrumTecService strumTecService) {
		_strumTecService = strumTecService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _strumTecService.getOSGiServiceIdentifier();
	}

	@Override
	public StrumTecService getWrappedService() {
		return _strumTecService;
	}

	@Override
	public void setWrappedService(StrumTecService strumTecService) {
		_strumTecService = strumTecService;
	}

	private StrumTecService _strumTecService;
}