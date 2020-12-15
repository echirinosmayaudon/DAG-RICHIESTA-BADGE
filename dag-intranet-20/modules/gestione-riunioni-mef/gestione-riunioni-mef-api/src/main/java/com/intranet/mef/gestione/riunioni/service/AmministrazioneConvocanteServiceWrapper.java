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
 * Provides a wrapper for {@link AmministrazioneConvocanteService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmministrazioneConvocanteService
 * @generated
 */
@ProviderType
public class AmministrazioneConvocanteServiceWrapper
	implements AmministrazioneConvocanteService,
		ServiceWrapper<AmministrazioneConvocanteService> {
	public AmministrazioneConvocanteServiceWrapper(
		AmministrazioneConvocanteService amministrazioneConvocanteService) {
		_amministrazioneConvocanteService = amministrazioneConvocanteService;
	}

	@Override
	public boolean setAmministrazioneConvocante(
		java.lang.String nome_amministrazione) {
		return _amministrazioneConvocanteService.setAmministrazioneConvocante(nome_amministrazione);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amministrazioneConvocanteService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante> findByKeywordAdmin(
		java.lang.String keyword) {
		return _amministrazioneConvocanteService.findByKeywordAdmin(keyword);
	}

	@Override
	public AmministrazioneConvocanteService getWrappedService() {
		return _amministrazioneConvocanteService;
	}

	@Override
	public void setWrappedService(
		AmministrazioneConvocanteService amministrazioneConvocanteService) {
		_amministrazioneConvocanteService = amministrazioneConvocanteService;
	}

	private AmministrazioneConvocanteService _amministrazioneConvocanteService;
}