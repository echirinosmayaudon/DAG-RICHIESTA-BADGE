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
 * Provides a wrapper for {@link ApprovatoreService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApprovatoreService
 * @generated
 */
@ProviderType
public class ApprovatoreServiceWrapper implements ApprovatoreService,
	ServiceWrapper<ApprovatoreService> {
	public ApprovatoreServiceWrapper(ApprovatoreService approvatoreService) {
		_approvatoreService = approvatoreService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _approvatoreService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Approvatore> getApprovatoriListByIdSala(
		long id_sala) {
		return _approvatoreService.getApprovatoriListByIdSala(id_sala);
	}

	@Override
	public ApprovatoreService getWrappedService() {
		return _approvatoreService;
	}

	@Override
	public void setWrappedService(ApprovatoreService approvatoreService) {
		_approvatoreService = approvatoreService;
	}

	private ApprovatoreService _approvatoreService;
}