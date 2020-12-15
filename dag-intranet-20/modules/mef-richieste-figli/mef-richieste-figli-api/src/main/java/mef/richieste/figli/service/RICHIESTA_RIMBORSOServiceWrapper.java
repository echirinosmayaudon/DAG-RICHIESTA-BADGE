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

package mef.richieste.figli.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RICHIESTA_RIMBORSOService}.
 *
 * @author Brian Wing Shun Chan
 * @see RICHIESTA_RIMBORSOService
 * @generated
 */
@ProviderType
public class RICHIESTA_RIMBORSOServiceWrapper
	implements RICHIESTA_RIMBORSOService,
			   ServiceWrapper<RICHIESTA_RIMBORSOService> {

	public RICHIESTA_RIMBORSOServiceWrapper(
		RICHIESTA_RIMBORSOService richiesta_rimborsoService) {

		_richiesta_rimborsoService = richiesta_rimborsoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _richiesta_rimborsoService.getOSGiServiceIdentifier();
	}

	@Override
	public RICHIESTA_RIMBORSOService getWrappedService() {
		return _richiesta_rimborsoService;
	}

	@Override
	public void setWrappedService(
		RICHIESTA_RIMBORSOService richiesta_rimborsoService) {

		_richiesta_rimborsoService = richiesta_rimborsoService;
	}

	private RICHIESTA_RIMBORSOService _richiesta_rimborsoService;

}