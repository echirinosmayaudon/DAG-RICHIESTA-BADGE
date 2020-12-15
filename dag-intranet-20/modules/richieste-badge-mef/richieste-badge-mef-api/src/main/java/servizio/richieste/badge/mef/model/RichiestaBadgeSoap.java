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

package servizio.richieste.badge.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.richieste.badge.mef.service.http.RichiestaBadgeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.http.RichiestaBadgeServiceSoap
 * @generated
 */
@ProviderType
public class RichiestaBadgeSoap implements Serializable {
	public static RichiestaBadgeSoap toSoapModel(RichiestaBadge model) {
		RichiestaBadgeSoap soapModel = new RichiestaBadgeSoap();

		soapModel.setId_pk(model.getId_pk());
		soapModel.setId_richiesta(model.getId_richiesta());
		soapModel.setScreename_richiedente(model.getScreename_richiedente());
		soapModel.setId_ufficio(model.getId_ufficio());
		soapModel.setId_sedesiap(model.getId_sedesiap());
		soapModel.setJson_richiedente(model.getJson_richiedente());
		soapModel.setIs_internal(model.getIs_internal());
		soapModel.setNome_intestatario(model.getNome_intestatario());
		soapModel.setCognome_intestatario(model.getCognome_intestatario());
		soapModel.setCf_intestatario(model.getCf_intestatario());
		soapModel.setLuogonascita_intestatario(model.getLuogonascita_intestatario());
		soapModel.setDatanascita_intestatario(model.getDatanascita_intestatario());
		soapModel.setId_oggetto(model.getId_oggetto());
		soapModel.setNumero_badge(model.getNumero_badge());
		soapModel.setUuid_foto(model.getUuid_foto());
		soapModel.setUuid_modulosostituzione(model.getUuid_modulosostituzione());
		soapModel.setSocieta(model.getSocieta());
		soapModel.setReferente_societa(model.getReferente_societa());
		soapModel.setProgetto(model.getProgetto());
		soapModel.setJson_richiesta_external(model.getJson_richiesta_external());
		soapModel.setArray_sedi_abilitate(model.getArray_sedi_abilitate());
		soapModel.setMotivazione(model.getMotivazione());
		soapModel.setData_scadenza(model.getData_scadenza());
		soapModel.setUuid_modulopdf(model.getUuid_modulopdf());
		soapModel.setData_richiesta(model.getData_richiesta());
		soapModel.setData_modifica(model.getData_modifica());
		soapModel.setId_stato(model.getId_stato());
		soapModel.setUtente_cambio_stato(model.getUtente_cambio_stato());
		soapModel.setNote(model.getNote());
		soapModel.setIs_last(model.getIs_last());

		return soapModel;
	}

	public static RichiestaBadgeSoap[] toSoapModels(RichiestaBadge[] models) {
		RichiestaBadgeSoap[] soapModels = new RichiestaBadgeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiestaBadgeSoap[][] toSoapModels(RichiestaBadge[][] models) {
		RichiestaBadgeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiestaBadgeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiestaBadgeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiestaBadgeSoap[] toSoapModels(List<RichiestaBadge> models) {
		List<RichiestaBadgeSoap> soapModels = new ArrayList<RichiestaBadgeSoap>(models.size());

		for (RichiestaBadge model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiestaBadgeSoap[soapModels.size()]);
	}

	public RichiestaBadgeSoap() {
	}

	public long getPrimaryKey() {
		return _id_pk;
	}

	public void setPrimaryKey(long pk) {
		setId_pk(pk);
	}

	public long getId_pk() {
		return _id_pk;
	}

	public void setId_pk(long id_pk) {
		_id_pk = id_pk;
	}

	public long getId_richiesta() {
		return _id_richiesta;
	}

	public void setId_richiesta(long id_richiesta) {
		_id_richiesta = id_richiesta;
	}

	public String getScreename_richiedente() {
		return _screename_richiedente;
	}

	public void setScreename_richiedente(String screename_richiedente) {
		_screename_richiedente = screename_richiedente;
	}

	public long getId_ufficio() {
		return _id_ufficio;
	}

	public void setId_ufficio(long id_ufficio) {
		_id_ufficio = id_ufficio;
	}

	public long getId_sedesiap() {
		return _id_sedesiap;
	}

	public void setId_sedesiap(long id_sedesiap) {
		_id_sedesiap = id_sedesiap;
	}

	public String getJson_richiedente() {
		return _json_richiedente;
	}

	public void setJson_richiedente(String json_richiedente) {
		_json_richiedente = json_richiedente;
	}

	public boolean getIs_internal() {
		return _is_internal;
	}

	public boolean isIs_internal() {
		return _is_internal;
	}

	public void setIs_internal(boolean is_internal) {
		_is_internal = is_internal;
	}

	public String getNome_intestatario() {
		return _nome_intestatario;
	}

	public void setNome_intestatario(String nome_intestatario) {
		_nome_intestatario = nome_intestatario;
	}

	public String getCognome_intestatario() {
		return _cognome_intestatario;
	}

	public void setCognome_intestatario(String cognome_intestatario) {
		_cognome_intestatario = cognome_intestatario;
	}

	public String getCf_intestatario() {
		return _cf_intestatario;
	}

	public void setCf_intestatario(String cf_intestatario) {
		_cf_intestatario = cf_intestatario;
	}

	public String getLuogonascita_intestatario() {
		return _luogonascita_intestatario;
	}

	public void setLuogonascita_intestatario(String luogonascita_intestatario) {
		_luogonascita_intestatario = luogonascita_intestatario;
	}

	public Date getDatanascita_intestatario() {
		return _datanascita_intestatario;
	}

	public void setDatanascita_intestatario(Date datanascita_intestatario) {
		_datanascita_intestatario = datanascita_intestatario;
	}

	public long getId_oggetto() {
		return _id_oggetto;
	}

	public void setId_oggetto(long id_oggetto) {
		_id_oggetto = id_oggetto;
	}

	public String getNumero_badge() {
		return _numero_badge;
	}

	public void setNumero_badge(String numero_badge) {
		_numero_badge = numero_badge;
	}

	public String getUuid_foto() {
		return _uuid_foto;
	}

	public void setUuid_foto(String uuid_foto) {
		_uuid_foto = uuid_foto;
	}

	public String getUuid_modulosostituzione() {
		return _uuid_modulosostituzione;
	}

	public void setUuid_modulosostituzione(String uuid_modulosostituzione) {
		_uuid_modulosostituzione = uuid_modulosostituzione;
	}

	public String getSocieta() {
		return _societa;
	}

	public void setSocieta(String societa) {
		_societa = societa;
	}

	public String getReferente_societa() {
		return _referente_societa;
	}

	public void setReferente_societa(String referente_societa) {
		_referente_societa = referente_societa;
	}

	public String getProgetto() {
		return _progetto;
	}

	public void setProgetto(String progetto) {
		_progetto = progetto;
	}

	public String getJson_richiesta_external() {
		return _json_richiesta_external;
	}

	public void setJson_richiesta_external(String json_richiesta_external) {
		_json_richiesta_external = json_richiesta_external;
	}

	public String getArray_sedi_abilitate() {
		return _array_sedi_abilitate;
	}

	public void setArray_sedi_abilitate(String array_sedi_abilitate) {
		_array_sedi_abilitate = array_sedi_abilitate;
	}

	public String getMotivazione() {
		return _motivazione;
	}

	public void setMotivazione(String motivazione) {
		_motivazione = motivazione;
	}

	public Date getData_scadenza() {
		return _data_scadenza;
	}

	public void setData_scadenza(Date data_scadenza) {
		_data_scadenza = data_scadenza;
	}

	public String getUuid_modulopdf() {
		return _uuid_modulopdf;
	}

	public void setUuid_modulopdf(String uuid_modulopdf) {
		_uuid_modulopdf = uuid_modulopdf;
	}

	public Date getData_richiesta() {
		return _data_richiesta;
	}

	public void setData_richiesta(Date data_richiesta) {
		_data_richiesta = data_richiesta;
	}

	public Date getData_modifica() {
		return _data_modifica;
	}

	public void setData_modifica(Date data_modifica) {
		_data_modifica = data_modifica;
	}

	public long getId_stato() {
		return _id_stato;
	}

	public void setId_stato(long id_stato) {
		_id_stato = id_stato;
	}

	public String getUtente_cambio_stato() {
		return _utente_cambio_stato;
	}

	public void setUtente_cambio_stato(String utente_cambio_stato) {
		_utente_cambio_stato = utente_cambio_stato;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public boolean getIs_last() {
		return _is_last;
	}

	public boolean isIs_last() {
		return _is_last;
	}

	public void setIs_last(boolean is_last) {
		_is_last = is_last;
	}

	private long _id_pk;
	private long _id_richiesta;
	private String _screename_richiedente;
	private long _id_ufficio;
	private long _id_sedesiap;
	private String _json_richiedente;
	private boolean _is_internal;
	private String _nome_intestatario;
	private String _cognome_intestatario;
	private String _cf_intestatario;
	private String _luogonascita_intestatario;
	private Date _datanascita_intestatario;
	private long _id_oggetto;
	private String _numero_badge;
	private String _uuid_foto;
	private String _uuid_modulosostituzione;
	private String _societa;
	private String _referente_societa;
	private String _progetto;
	private String _json_richiesta_external;
	private String _array_sedi_abilitate;
	private String _motivazione;
	private Date _data_scadenza;
	private String _uuid_modulopdf;
	private Date _data_richiesta;
	private Date _data_modifica;
	private long _id_stato;
	private String _utente_cambio_stato;
	private String _note;
	private boolean _is_last;
}