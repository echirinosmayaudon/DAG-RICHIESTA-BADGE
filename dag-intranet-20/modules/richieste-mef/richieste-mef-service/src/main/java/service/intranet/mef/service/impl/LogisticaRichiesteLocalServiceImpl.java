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

package service.intranet.mef.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.LogisticaRichieste;
import service.intranet.mef.model.RichiestaInterventi;
import service.intranet.mef.service.base.LogisticaRichiesteLocalServiceBaseImpl;

/**
 * The implementation of the logistica richieste local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.LogisticaRichiesteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichiesteLocalServiceBaseImpl
 * @see service.intranet.mef.service.LogisticaRichiesteLocalServiceUtil
 */
@ProviderType
public class LogisticaRichiesteLocalServiceImpl
	extends LogisticaRichiesteLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(LogisticaRichiesteLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.LogisticaRichiesteLocalServiceUtil} to access the logistica richieste local service.
	 */
	@Override
	public List<LogisticaRichieste> getLogisticaRichiesteByUtente(String utente){
		return this.logisticaRichiestePersistence.findByUtente(utente);
	} 
	
	@Override
	public List<LogisticaRichieste> getListLogRichiesteByDip(String dipartimento){
		return this.logisticaRichiestePersistence.findByDipartimento(dipartimento);
	} 
	
	
	
	@Override
	public LogisticaRichieste insertRichiestaLogistici(String oggetto,String utente,String dipartimento,Date data_richiesta, String dettaglio_richiedente, String dettaglio_richieste, String note_gestore, long id_valutazione,long id_stato,String note ){
		LogisticaRichieste richiestaLogi=logisticaRichiestePersistence.create(-1);
		richiestaLogi.setOggetto(oggetto);
		richiestaLogi.setUtente(utente);
		richiestaLogi.setDipartimento(dipartimento);
		richiestaLogi.setData_richiesta(data_richiesta);
		richiestaLogi.setDettaglio_richiedente(dettaglio_richiedente);
		richiestaLogi.setDettaglio_richieste(dettaglio_richieste);
		richiestaLogi.setNote_gestore(note_gestore);
		richiestaLogi.setId_valutazione(id_valutazione);
		richiestaLogi.setId_stato(id_stato);
		richiestaLogi.setNote(note);
		LogisticaRichieste insertout=null;
		 try{
			 insertout = logisticaRichiestePersistence.updateImpl(richiestaLogi);
			 return insertout;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return insertout;
		 }
	}
	
}