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
 * Provides a wrapper for {@link LogisticaRichiesteService}.
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichiesteService
 * @generated
 */
@ProviderType
public class LogisticaRichiesteServiceWrapper
	implements LogisticaRichiesteService,
		ServiceWrapper<LogisticaRichiesteService> {
	public LogisticaRichiesteServiceWrapper(
		LogisticaRichiesteService logisticaRichiesteService) {
		_logisticaRichiesteService = logisticaRichiesteService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _logisticaRichiesteService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<service.intranet.mef.model.LogisticaRichieste> getListLogRichiesteByDip(
		java.lang.String dipartimento) {
		return _logisticaRichiesteService.getListLogRichiesteByDip(dipartimento);
	}

	@Override
	public java.util.List<service.intranet.mef.model.LogisticaRichieste> getLogisticaRichiesteByUtente(
		java.lang.String utente) {
		return _logisticaRichiesteService.getLogisticaRichiesteByUtente(utente);
	}

	@Override
	public LogisticaRichiesteService getWrappedService() {
		return _logisticaRichiesteService;
	}

	@Override
	public void setWrappedService(
		LogisticaRichiesteService logisticaRichiesteService) {
		_logisticaRichiesteService = logisticaRichiesteService;
	}

	private LogisticaRichiesteService _logisticaRichiesteService;
}