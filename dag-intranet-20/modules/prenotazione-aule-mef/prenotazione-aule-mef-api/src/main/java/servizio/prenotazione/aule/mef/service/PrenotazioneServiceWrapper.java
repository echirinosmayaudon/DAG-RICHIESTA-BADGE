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
 * Provides a wrapper for {@link PrenotazioneService}.
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneService
 * @generated
 */
@ProviderType
public class PrenotazioneServiceWrapper implements PrenotazioneService,
	ServiceWrapper<PrenotazioneService> {
	public PrenotazioneServiceWrapper(PrenotazioneService prenotazioneService) {
		_prenotazioneService = prenotazioneService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _prenotazioneService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> getPrenotazioniByCodFiscale(
		java.lang.String cod_fiscale) {
		return _prenotazioneService.getPrenotazioniByCodFiscale(cod_fiscale);
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> getPrenotazioniByFilters(
		java.util.List<java.lang.Long> id_sale_list,
		java.util.Date data_inizio, java.util.Date data_fine, long id_stato) {
		return _prenotazioneService.getPrenotazioniByFilters(id_sale_list,
			data_inizio, data_fine, id_stato);
	}

	@Override
	public PrenotazioneService getWrappedService() {
		return _prenotazioneService;
	}

	@Override
	public void setWrappedService(PrenotazioneService prenotazioneService) {
		_prenotazioneService = prenotazioneService;
	}

	private PrenotazioneService _prenotazioneService;
}