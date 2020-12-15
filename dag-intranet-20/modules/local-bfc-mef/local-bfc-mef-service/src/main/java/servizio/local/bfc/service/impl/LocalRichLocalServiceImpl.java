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

package servizio.local.bfc.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.List;

import aQute.bnd.annotation.ProviderType;
import servizio.local.bfc.model.LocalRich;
import servizio.local.bfc.service.base.LocalRichLocalServiceBaseImpl;

/**
 * The implementation of the local rich local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.local.bfc.service.LocalRichLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichLocalServiceBaseImpl
 * @see servizio.local.bfc.service.LocalRichLocalServiceUtil
 */
@ProviderType
public class LocalRichLocalServiceImpl extends LocalRichLocalServiceBaseImpl {
	
	final Log _log = LogFactoryUtil.getLog(LocalRichInfoLocalServiceImpl.class);
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.local.bfc.service.LocalRichLocalServiceUtil} to access the local rich local service.
	 */
	@Override
	public List<LocalRich> findByfilters(List<Long> lista_stati, List<String> ufficio, List<User> lista_utenti,boolean instage){
	 return localRichFinder.findByStati_Ufficio_Utenti(lista_stati, ufficio, lista_utenti,instage);
	}
	
	@Override
	public List<LocalRich> getRichiestebyEmail(boolean instage,String email){
		return localRichPersistence.findByemailReqBfc(instage,email);
	}
	
	@Override
	public List<LocalRich> getRichiestebyIdRichiesta(long id_richiesta){
		return localRichPersistence.findByIdRichiesta(id_richiesta);
	}
	
	@Override
	public LocalRich insertLocalRich(Long id_richiesta, Float costoReale, Date dataIns, Date dataRichiesta, Date dataUpd, String email,
			Integer flagInvio, Long idPeriodicita, String idSede, Long idStatoAttuale, String ispettorato, String note,
			String noteRichiedente, String oggetto, Integer preventivo, String riferimentoStanza, String strutIsp,
			String strutIsp2, String strutUff, String telRichiedente, String ufficio, Long uidIns, Long uidUpd,
			boolean inStage){
		
		LocalRich richiesta = localRichPersistence.create(-1);
		
		richiesta.setId_richiesta(id_richiesta);
		// set data to load
		if (costoReale != null)
			richiesta.setCostoReale(costoReale);
		if (dataIns != null)
			richiesta.setDataIns(dataIns);
		if (dataRichiesta != null)
			richiesta.setDataRichiesta(dataRichiesta);
		if (dataUpd != null)
			richiesta.setDataUpd(dataUpd);
		if (email != null)
			richiesta.setEmail(email);
		if (flagInvio != null)
			richiesta.setFlagInvio(flagInvio);
		if (idPeriodicita != null)
			richiesta.setIdPeriodicita(idPeriodicita);
		if (idSede != null)
			richiesta.setIdSede(idSede);
		if (idStatoAttuale != null)
			richiesta.setIdStatoAttuale(idStatoAttuale);
		if (ispettorato != null)
			richiesta.setIspettorato(ispettorato);
		if (note != null)
			richiesta.setNote(note);
		if (noteRichiedente != null)
			richiesta.setNoteRich(noteRichiedente);
		if (oggetto != null)
			richiesta.setOggetto(oggetto);
		if (preventivo != null)
			richiesta.setPreventivo(preventivo);
		if (riferimentoStanza != null)
			richiesta.setRifStanza(riferimentoStanza);
		if (strutIsp != null)
			richiesta.setStrutIsp(strutIsp);
		if (strutIsp2 != null)
			richiesta.setStrutIsp2(strutIsp2);
		if (strutUff != null)
			richiesta.setStrutUff(strutUff);
		if (telRichiedente != null)
			richiesta.setTelRich(telRichiedente);
		if (ufficio != null)
			richiesta.setUfficio(ufficio);
		if (uidIns != null)
			richiesta.setUidIns(uidIns);
		if (uidUpd != null)
			richiesta.setUidUpd(uidUpd);

		richiesta.setInStage(inStage);
		
		LocalRich richiestaout = null;
		
		try{
			richiestaout = localRichPersistence.updateImpl(richiesta);
			return richiestaout;
		}catch(Exception e){
			_log.error(e);
			return richiestaout;
		}
	}
}