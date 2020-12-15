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

package com.intranet.mef.central.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CentralInvokerService}.
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvokerService
 * @generated
 */
@ProviderType
public class CentralInvokerServiceWrapper implements CentralInvokerService,
	ServiceWrapper<CentralInvokerService> {
	public CentralInvokerServiceWrapper(
		CentralInvokerService centralInvokerService) {
		_centralInvokerService = centralInvokerService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _centralInvokerService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.intranet.mef.job.siap.model.Location> findLocationById(
		long id) {
		return _centralInvokerService.findLocationById(id);
	}

	@Override
	public CentralInvokerService getWrappedService() {
		return _centralInvokerService;
	}

	@Override
	public void setWrappedService(CentralInvokerService centralInvokerService) {
		_centralInvokerService = centralInvokerService;
	}

	private CentralInvokerService _centralInvokerService;
}