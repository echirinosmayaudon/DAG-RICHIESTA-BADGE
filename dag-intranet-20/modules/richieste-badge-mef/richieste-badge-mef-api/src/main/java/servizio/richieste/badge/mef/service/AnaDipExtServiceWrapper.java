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
 * Provides a wrapper for {@link AnaDipExtService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnaDipExtService
 * @generated
 */
@ProviderType
public class AnaDipExtServiceWrapper implements AnaDipExtService,
	ServiceWrapper<AnaDipExtService> {
	public AnaDipExtServiceWrapper(AnaDipExtService anaDipExtService) {
		_anaDipExtService = anaDipExtService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray findSuggestionsAnaDipExtBySurname(
		java.lang.String cognome) {
		return _anaDipExtService.findSuggestionsAnaDipExtBySurname(cognome);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _anaDipExtService.getOSGiServiceIdentifier();
	}

	@Override
	public AnaDipExtService getWrappedService() {
		return _anaDipExtService;
	}

	@Override
	public void setWrappedService(AnaDipExtService anaDipExtService) {
		_anaDipExtService = anaDipExtService;
	}

	private AnaDipExtService _anaDipExtService;
}