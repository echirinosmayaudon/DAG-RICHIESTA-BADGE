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
 * Provides a wrapper for {@link ServizioLogService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLogService
 * @generated
 */
@ProviderType
public class ServizioLogServiceWrapper implements ServizioLogService,
	ServiceWrapper<ServizioLogService> {
	public ServizioLogServiceWrapper(ServizioLogService servizioLogService) {
		_servizioLogService = servizioLogService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _servizioLogService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.ServizioLog> getServizioLogListByDescServizio(
		java.lang.String desc_servizio) {
		return _servizioLogService.getServizioLogListByDescServizio(desc_servizio);
	}

	@Override
	public ServizioLogService getWrappedService() {
		return _servizioLogService;
	}

	@Override
	public void setWrappedService(ServizioLogService servizioLogService) {
		_servizioLogService = servizioLogService;
	}

	private ServizioLogService _servizioLogService;
}