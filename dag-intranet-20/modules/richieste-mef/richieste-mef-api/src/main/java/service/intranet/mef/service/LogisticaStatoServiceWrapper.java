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
 * Provides a wrapper for {@link LogisticaStatoService}.
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaStatoService
 * @generated
 */
@ProviderType
public class LogisticaStatoServiceWrapper implements LogisticaStatoService,
	ServiceWrapper<LogisticaStatoService> {
	public LogisticaStatoServiceWrapper(
		LogisticaStatoService logisticaStatoService) {
		_logisticaStatoService = logisticaStatoService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _logisticaStatoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<service.intranet.mef.model.LogisticaStato> getLogisticaStatoByUtente(
		java.lang.String utente) {
		return _logisticaStatoService.getLogisticaStatoByUtente(utente);
	}

	@Override
	public LogisticaStatoService getWrappedService() {
		return _logisticaStatoService;
	}

	@Override
	public void setWrappedService(LogisticaStatoService logisticaStatoService) {
		_logisticaStatoService = logisticaStatoService;
	}

	private LogisticaStatoService _logisticaStatoService;
}