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

package servizio.prenotazione.aule.mef.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.prenotazione.aule.mef.model.Approvatore;
import servizio.prenotazione.aule.mef.model.Prenotazione;
import servizio.prenotazione.aule.mef.service.base.PrenotazioneLocalServiceBaseImpl;

/**
 * The implementation of the prenotazione local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.prenotazione.aule.mef.service.PrenotazioneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneLocalServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.PrenotazioneLocalServiceUtil
 */
@ProviderType
public class PrenotazioneLocalServiceImpl
	extends PrenotazioneLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.prenotazione.aule.mef.service.PrenotazioneLocalServiceUtil} to access the prenotazione local service.
	 */
	final Log _log = LogFactoryUtil.getLog(PrenotazioneLocalServiceImpl.class);
	@Override
	public List<Prenotazione> getPrenotazioniByFilters(List<Long> id_sale_list, Date data_inizio, Date data_fine, long id_stato){
		    return prenotazioneFinder.getPrenotazioniByFilters(id_sale_list, data_inizio, data_fine, id_stato);
		}
	
	@Override
	public List<Prenotazione> getPrenotazioniByCodFiscale(String cod_fiscale){
		return this.prenotazionePersistence.findByCodFiscale(cod_fiscale);
		       
		}
	
	@Override 
	public Prenotazione insertPrenotazione(){
		Prenotazione prenotazione = prenotazionePersistence.create(-1);
		Prenotazione prenotout = null;
		try{
			prenotout = prenotazionePersistence.updateImpl(prenotazione);
			return prenotout;
		}catch(Exception e){
			_log.error(e);
			return prenotout;
		}
	}
	
}