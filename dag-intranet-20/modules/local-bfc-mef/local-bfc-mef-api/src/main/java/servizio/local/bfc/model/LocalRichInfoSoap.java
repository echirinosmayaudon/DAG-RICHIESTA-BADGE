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

package servizio.local.bfc.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.local.bfc.service.http.LocalRichInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.local.bfc.service.http.LocalRichInfoServiceSoap
 * @generated
 */
@ProviderType
public class LocalRichInfoSoap implements Serializable {
	public static LocalRichInfoSoap toSoapModel(LocalRichInfo model) {
		LocalRichInfoSoap soapModel = new LocalRichInfoSoap();

		soapModel.setIdStatoAttuale(model.getIdStatoAttuale());
		soapModel.setId(model.getId());
		soapModel.setId_richiesta(model.getId_richiesta());
		soapModel.setDataRichiesta(model.getDataRichiesta());
		soapModel.setEmail(model.getEmail());
		soapModel.setRifStanza(model.getRifStanza());
		soapModel.setIspettorato(model.getIspettorato());
		soapModel.setNomeRef(model.getNomeRef());
		soapModel.setTelRef(model.getTelRef());
		soapModel.setNMacchina(model.getNMacchina());
		soapModel.setNoteRich(model.getNoteRich());
		soapModel.setUfficio(model.getUfficio());
		soapModel.setNote(model.getNote());
		soapModel.setUidIns(model.getUidIns());
		soapModel.setDataIns(model.getDataIns());
		soapModel.setUidUpd(model.getUidUpd());
		soapModel.setDataUpd(model.getDataUpd());
		soapModel.setOggetto(model.getOggetto());
		soapModel.setIdSede(model.getIdSede());
		soapModel.setTelRich(model.getTelRich());
		soapModel.setStrutUff(model.getStrutUff());
		soapModel.setStrutIsp(model.getStrutIsp());
		soapModel.setCostoReale(model.getCostoReale());
		soapModel.setPreventivo(model.getPreventivo());
		soapModel.setFlagInvio(model.getFlagInvio());
		soapModel.setInStage(model.getInStage());

		return soapModel;
	}

	public static LocalRichInfoSoap[] toSoapModels(LocalRichInfo[] models) {
		LocalRichInfoSoap[] soapModels = new LocalRichInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocalRichInfoSoap[][] toSoapModels(LocalRichInfo[][] models) {
		LocalRichInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocalRichInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocalRichInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocalRichInfoSoap[] toSoapModels(List<LocalRichInfo> models) {
		List<LocalRichInfoSoap> soapModels = new ArrayList<LocalRichInfoSoap>(models.size());

		for (LocalRichInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocalRichInfoSoap[soapModels.size()]);
	}

	public LocalRichInfoSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getIdStatoAttuale() {
		return _idStatoAttuale;
	}

	public void setIdStatoAttuale(long idStatoAttuale) {
		_idStatoAttuale = idStatoAttuale;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getId_richiesta() {
		return _id_richiesta;
	}

	public void setId_richiesta(long id_richiesta) {
		_id_richiesta = id_richiesta;
	}

	public Date getDataRichiesta() {
		return _dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		_dataRichiesta = dataRichiesta;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getRifStanza() {
		return _rifStanza;
	}

	public void setRifStanza(String rifStanza) {
		_rifStanza = rifStanza;
	}

	public String getIspettorato() {
		return _ispettorato;
	}

	public void setIspettorato(String ispettorato) {
		_ispettorato = ispettorato;
	}

	public String getNomeRef() {
		return _nomeRef;
	}

	public void setNomeRef(String nomeRef) {
		_nomeRef = nomeRef;
	}

	public String getTelRef() {
		return _telRef;
	}

	public void setTelRef(String telRef) {
		_telRef = telRef;
	}

	public String getNMacchina() {
		return _nMacchina;
	}

	public void setNMacchina(String nMacchina) {
		_nMacchina = nMacchina;
	}

	public String getNoteRich() {
		return _noteRich;
	}

	public void setNoteRich(String noteRich) {
		_noteRich = noteRich;
	}

	public String getUfficio() {
		return _ufficio;
	}

	public void setUfficio(String ufficio) {
		_ufficio = ufficio;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getUidIns() {
		return _uidIns;
	}

	public void setUidIns(long uidIns) {
		_uidIns = uidIns;
	}

	public Date getDataIns() {
		return _dataIns;
	}

	public void setDataIns(Date dataIns) {
		_dataIns = dataIns;
	}

	public long getUidUpd() {
		return _uidUpd;
	}

	public void setUidUpd(long uidUpd) {
		_uidUpd = uidUpd;
	}

	public Date getDataUpd() {
		return _dataUpd;
	}

	public void setDataUpd(Date dataUpd) {
		_dataUpd = dataUpd;
	}

	public String getOggetto() {
		return _oggetto;
	}

	public void setOggetto(String oggetto) {
		_oggetto = oggetto;
	}

	public String getIdSede() {
		return _idSede;
	}

	public void setIdSede(String idSede) {
		_idSede = idSede;
	}

	public String getTelRich() {
		return _telRich;
	}

	public void setTelRich(String telRich) {
		_telRich = telRich;
	}

	public String getStrutUff() {
		return _strutUff;
	}

	public void setStrutUff(String strutUff) {
		_strutUff = strutUff;
	}

	public String getStrutIsp() {
		return _strutIsp;
	}

	public void setStrutIsp(String strutIsp) {
		_strutIsp = strutIsp;
	}

	public float getCostoReale() {
		return _costoReale;
	}

	public void setCostoReale(float costoReale) {
		_costoReale = costoReale;
	}

	public int getPreventivo() {
		return _preventivo;
	}

	public void setPreventivo(int preventivo) {
		_preventivo = preventivo;
	}

	public int getFlagInvio() {
		return _flagInvio;
	}

	public void setFlagInvio(int flagInvio) {
		_flagInvio = flagInvio;
	}

	public boolean getInStage() {
		return _inStage;
	}

	public boolean isInStage() {
		return _inStage;
	}

	public void setInStage(boolean inStage) {
		_inStage = inStage;
	}

	private long _idStatoAttuale;
	private long _id;
	private long _id_richiesta;
	private Date _dataRichiesta;
	private String _email;
	private String _rifStanza;
	private String _ispettorato;
	private String _nomeRef;
	private String _telRef;
	private String _nMacchina;
	private String _noteRich;
	private String _ufficio;
	private String _note;
	private long _uidIns;
	private Date _dataIns;
	private long _uidUpd;
	private Date _dataUpd;
	private String _oggetto;
	private String _idSede;
	private String _telRich;
	private String _strutUff;
	private String _strutIsp;
	private float _costoReale;
	private int _preventivo;
	private int _flagInvio;
	private boolean _inStage;
}