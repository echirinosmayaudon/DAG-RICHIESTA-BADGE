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

package servizio.beni.facile.consumo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RigheRichiestaBFCService}.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCService
 * @generated
 */
@ProviderType
public class RigheRichiestaBFCServiceWrapper implements RigheRichiestaBFCService,
	ServiceWrapper<RigheRichiestaBFCService> {
	public RigheRichiestaBFCServiceWrapper(
		RigheRichiestaBFCService righeRichiestaBFCService) {
		_righeRichiestaBFCService = righeRichiestaBFCService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _righeRichiestaBFCService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.beni.facile.consumo.model.RigheRichiestaBFC> getRigaRichiestaByIdRichiesta(
		long id_richiesta) {
		return _righeRichiestaBFCService.getRigaRichiestaByIdRichiesta(id_richiesta);
	}

	@Override
	public java.util.List<servizio.beni.facile.consumo.model.RigheRichiestaBFC> getRigheRichiestaByDipartimento(
		java.lang.String dipartimento) {
		return _righeRichiestaBFCService.getRigheRichiestaByDipartimento(dipartimento);
	}

	@Override
	public RigheRichiestaBFCService getWrappedService() {
		return _righeRichiestaBFCService;
	}

	@Override
	public void setWrappedService(
		RigheRichiestaBFCService righeRichiestaBFCService) {
		_righeRichiestaBFCService = righeRichiestaBFCService;
	}

	private RigheRichiestaBFCService _righeRichiestaBFCService;
}