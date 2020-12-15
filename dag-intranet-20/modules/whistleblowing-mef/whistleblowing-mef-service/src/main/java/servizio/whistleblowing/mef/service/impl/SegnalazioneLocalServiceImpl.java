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

package servizio.whistleblowing.mef.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import aQute.bnd.annotation.ProviderType;
import servizio.whistleblowing.mef.model.Segnalazione;
import servizio.whistleblowing.mef.service.base.SegnalazioneLocalServiceBaseImpl;

/**
 * The implementation of the segnalazione local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.whistleblowing.mef.service.SegnalazioneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneLocalServiceBaseImpl
 * @see servizio.whistleblowing.mef.service.SegnalazioneLocalServiceUtil
 */
@ProviderType
public class SegnalazioneLocalServiceImpl
	extends SegnalazioneLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.whistleblowing.mef.service.SegnalazioneLocalServiceUtil} to access the segnalazione local service.
	 */
	
	final Log _log = LogFactoryUtil.getLog(SegnalazioneLocalServiceImpl.class);
	
	@Override
	public boolean insertSegnalazione(String json_dati_personali, String luogo, String azioni_omissioni, String descrizione, String autore, String altri_testimoni){
		Segnalazione segnalazione = segnalazionePersistence.create(-1);
		segnalazione.setJson_dati_personali(json_dati_personali);
		segnalazione.setLuogo(luogo);
		segnalazione.setAzioni_omissioni(azioni_omissioni);
		segnalazione.setDescrizione(descrizione);
		segnalazione.setAutore(autore);
		segnalazione.setAltri_testimoni(altri_testimoni);
		 try{
			 segnalazionePersistence.updateImpl(segnalazione);
			 return true;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return false;
		 }
	}
	
}