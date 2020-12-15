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
import servizio.local.bfc.model.LocalRichInfo;
import servizio.local.bfc.service.base.LocalRichInfoLocalServiceBaseImpl;

/**
 * The implementation of the local rich info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link servizio.local.bfc.service.LocalRichInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichInfoLocalServiceBaseImpl
 * @see servizio.local.bfc.service.LocalRichInfoLocalServiceUtil
 */
@ProviderType
public class LocalRichInfoLocalServiceImpl
	extends LocalRichInfoLocalServiceBaseImpl {
	
	final Log _log = LogFactoryUtil.getLog(LocalRichInfoLocalServiceImpl.class);
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link servizio.local.bfc.service.LocalRichInfoLocalServiceUtil} to access the local rich info local service.
	 */
	@Override
	public List<LocalRichInfo> findByfilters(List<Long> lista_stati, List<String> ufficio, List<User> lista_utenti,boolean instage){
	 return localRichInfoFinder.findByStati_Ufficio_Utenti(lista_stati, ufficio, lista_utenti,instage);
	}
	
	@Override
	public List<LocalRichInfo> getRichiestebyEmail(boolean instage,String email){
		return localRichInfoPersistence.findByemailReqBfcInfo(instage,email);
	}
	
	@Override
	public List<LocalRichInfo> getRichiestebyIdRichiesta(long id_richiesta){
		return localRichInfoPersistence.findByIdRichiesta(id_richiesta);
	}

	@Override
	public LocalRichInfo insertLocalRichInfo(Long id_richiesta, Float costoReale, Date dataIns, Date dataRichiesta, Date dataUpd,
			String email, Integer flagInvio, String nMacchina, String idSede, Long idStatoAttuale, String ispettorato,
			String note, String noteRichiedente, String nomeReferente, String oggetto, Integer preventivo,
			String riferimentoStanza, String strutIsp, String strutUff, String telRichiedente, String telefonoReferente,
			String ufficio, Long uidIns, Long uidUpd, boolean inStage){
		
		LocalRichInfo richiesta = localRichInfoPersistence.create(-1);
		
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
		if (nomeReferente != null)
			richiesta.setNomeRef(nomeReferente);
		if (nMacchina != null)
			richiesta.setNMacchina(nMacchina);
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
		if (strutUff != null)
			richiesta.setStrutUff(strutUff);
		if (telRichiedente != null)
			richiesta.setTelRich(telRichiedente);
		if (telefonoReferente != null)
			richiesta.setTelRef(telefonoReferente);
		if (ufficio != null)
			richiesta.setUfficio(ufficio);
		if (uidIns != null)
			richiesta.setUidIns(uidIns);
		if (uidUpd != null)
			richiesta.setUidUpd(uidUpd);

		richiesta.setInStage(inStage);
		
		LocalRichInfo richiestaout = null;
		
		try{
			richiestaout = localRichInfoPersistence.updateImpl(richiesta);
			return richiestaout;
		}catch(Exception e){
			_log.error(e);
			return richiestaout;
		}
	}
}