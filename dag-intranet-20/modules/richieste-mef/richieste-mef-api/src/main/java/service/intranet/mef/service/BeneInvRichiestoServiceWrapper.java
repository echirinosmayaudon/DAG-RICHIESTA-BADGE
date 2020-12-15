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
 * Provides a wrapper for {@link BeneInvRichiestoService}.
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvRichiestoService
 * @generated
 */
@ProviderType
public class BeneInvRichiestoServiceWrapper implements BeneInvRichiestoService,
	ServiceWrapper<BeneInvRichiestoService> {
	public BeneInvRichiestoServiceWrapper(
		BeneInvRichiestoService beneInvRichiestoService) {
		_beneInvRichiestoService = beneInvRichiestoService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _beneInvRichiestoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<service.intranet.mef.model.BeneInvRichiesto> getListBeniByIdRichiesta(
		long id_richiesta, boolean in_elenco) {
		return _beneInvRichiestoService.getListBeniByIdRichiesta(id_richiesta,
			in_elenco);
	}

	@Override
	public BeneInvRichiestoService getWrappedService() {
		return _beneInvRichiestoService;
	}

	@Override
	public void setWrappedService(
		BeneInvRichiestoService beneInvRichiestoService) {
		_beneInvRichiestoService = beneInvRichiestoService;
	}

	private BeneInvRichiestoService _beneInvRichiestoService;
}