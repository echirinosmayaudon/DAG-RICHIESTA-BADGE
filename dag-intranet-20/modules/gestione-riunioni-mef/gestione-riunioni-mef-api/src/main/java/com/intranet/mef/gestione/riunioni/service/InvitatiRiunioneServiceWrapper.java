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

package com.intranet.mef.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvitatiRiunioneService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunioneService
 * @generated
 */
@ProviderType
public class InvitatiRiunioneServiceWrapper implements InvitatiRiunioneService,
	ServiceWrapper<InvitatiRiunioneService> {
	public InvitatiRiunioneServiceWrapper(
		InvitatiRiunioneService invitatiRiunioneService) {
		_invitatiRiunioneService = invitatiRiunioneService;
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.InvitatiRiunione getInvitatiRiunioneByPK(
		long id_segreteria, long id_riunione) {
		return _invitatiRiunioneService.getInvitatiRiunioneByPK(id_segreteria,
			id_riunione);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _invitatiRiunioneService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.InvitatiRiunione> getInvitatiRiunioneByIdRiunione(
		long idRiunione) {
		return _invitatiRiunioneService.getInvitatiRiunioneByIdRiunione(idRiunione);
	}

	@Override
	public InvitatiRiunioneService getWrappedService() {
		return _invitatiRiunioneService;
	}

	@Override
	public void setWrappedService(
		InvitatiRiunioneService invitatiRiunioneService) {
		_invitatiRiunioneService = invitatiRiunioneService;
	}

	private InvitatiRiunioneService _invitatiRiunioneService;
}