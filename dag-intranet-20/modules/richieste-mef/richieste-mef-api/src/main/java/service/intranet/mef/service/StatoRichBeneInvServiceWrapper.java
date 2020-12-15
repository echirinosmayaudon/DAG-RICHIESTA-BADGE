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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatoRichBeneInvService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichBeneInvService
 * @generated
 */
@ProviderType
public class StatoRichBeneInvServiceWrapper implements StatoRichBeneInvService,
	ServiceWrapper<StatoRichBeneInvService> {
	public StatoRichBeneInvServiceWrapper(
		StatoRichBeneInvService statoRichBeneInvService) {
		_statoRichBeneInvService = statoRichBeneInvService;
	}

	@Override
	public java.lang.Long getStatoRichBeneByNomeStato(
		java.lang.String nomeStato) {
		return _statoRichBeneInvService.getStatoRichBeneByNomeStato(nomeStato);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _statoRichBeneInvService.getOSGiServiceIdentifier();
	}

	@Override
	public StatoRichBeneInvService getWrappedService() {
		return _statoRichBeneInvService;
	}

	@Override
	public void setWrappedService(
		StatoRichBeneInvService statoRichBeneInvService) {
		_statoRichBeneInvService = statoRichBeneInvService;
	}

	private StatoRichBeneInvService _statoRichBeneInvService;
}