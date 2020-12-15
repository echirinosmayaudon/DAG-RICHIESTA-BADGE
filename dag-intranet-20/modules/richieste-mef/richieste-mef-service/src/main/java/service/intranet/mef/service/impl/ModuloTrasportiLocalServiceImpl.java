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

import aQute.bnd.annotation.ProviderType;
import service.intranet.mef.model.LogisticaRichieste;
import service.intranet.mef.model.ModuloTrasporti;
import service.intranet.mef.service.base.ModuloTrasportiLocalServiceBaseImpl;

/**
 * The implementation of the modulo trasporti local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.service.ModuloTrasportiLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModuloTrasportiLocalServiceBaseImpl
 * @see service.intranet.mef.service.ModuloTrasportiLocalServiceUtil
 */
@ProviderType
public class ModuloTrasportiLocalServiceImpl
	extends ModuloTrasportiLocalServiceBaseImpl {
	final Log _log = LogFactoryUtil.getLog(ModuloTrasportiLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link service.intranet.mef.service.ModuloTrasportiLocalServiceUtil} to access the modulo trasporti local service.
	 */
	@Override
	public ModuloTrasporti insertModuloTrasporti(String cognome,String nome,String codice_fiscale, String utente_inserimento,Date data_inserimento, String flag_tipospesa, String iban, String importo, Date data_titolo_annuale, String nr_titoli_mensili, String figlio_nome, String figlio_cognome, Date figlio_data_nascita, String figlio_luogo_data, String figlio_codicefiscale,String note, String flag_inviato, String telefono, String allegatoUuid){
		
		ModuloTrasporti moduloTrasporti=moduloTrasportiPersistence.create(-1);
		moduloTrasporti.setCognome(cognome);
		moduloTrasporti.setNome(nome);
		moduloTrasporti.setCodice_fiscale(codice_fiscale);
		moduloTrasporti.setUtente_inserimento(utente_inserimento);
		moduloTrasporti.setData_inserimento(data_inserimento);
		moduloTrasporti.setFlag_tipospesa(flag_tipospesa);
		moduloTrasporti.setIban(iban);
		moduloTrasporti.setImporto(importo);
		moduloTrasporti.setData_titolo_annuale(data_titolo_annuale);
		moduloTrasporti.setNr_titoli_mensili(nr_titoli_mensili);
		moduloTrasporti.setFiglio_nome(figlio_nome);
		moduloTrasporti.setFiglio_cognome(figlio_cognome);
		moduloTrasporti.setFiglio_data_nascita(figlio_data_nascita);
		moduloTrasporti.setFiglio_luogo_data(figlio_luogo_data);
		moduloTrasporti.setFiglio_codicefiscale(figlio_codicefiscale);
		moduloTrasporti.setNote(note);
		moduloTrasporti.setFlag_inviato(flag_inviato);
		moduloTrasporti.setTelefono(telefono);
		moduloTrasporti.setAllegatoUuid(allegatoUuid);
		
		ModuloTrasporti insertout=null;
		 try{
			 insertout = moduloTrasportiPersistence.updateImpl(moduloTrasporti);
			 return insertout;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return insertout;
		 }
	}
}