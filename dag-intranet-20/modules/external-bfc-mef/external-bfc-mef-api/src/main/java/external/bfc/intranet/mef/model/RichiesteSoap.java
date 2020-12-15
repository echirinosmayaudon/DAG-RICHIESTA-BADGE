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

package external.bfc.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link external.bfc.intranet.mef.service.http.RichiesteServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.http.RichiesteServiceSoap
 * @generated
 */
@ProviderType
public class RichiesteSoap implements Serializable {
	public static RichiesteSoap toSoapModel(Richieste model) {
		RichiesteSoap soapModel = new RichiesteSoap();

		soapModel.setIdStatoAttuale(model.getIdStatoAttuale());
		soapModel.setId(model.getId());
		soapModel.setDataRichiesta(model.getDataRichiesta());
		soapModel.setIdPeriodicita(model.getIdPeriodicita());
		soapModel.setEmail(model.getEmail());
		soapModel.setRiferimentoStanza(model.getRiferimentoStanza());
		soapModel.setIspettorato(model.getIspettorato());
		soapModel.setNoteRichiedente(model.getNoteRichiedente());
		soapModel.setUfficio(model.getUfficio());
		soapModel.setNote(model.getNote());
		soapModel.setUidIns(model.getUidIns());
		soapModel.setDataIns(model.getDataIns());
		soapModel.setUidUpd(model.getUidUpd());
		soapModel.setDataUpd(model.getDataUpd());
		soapModel.setOggetto(model.getOggetto());
		soapModel.setIdSede(model.getIdSede());
		soapModel.setStrutIsp(model.getStrutIsp());
		soapModel.setStrutUff(model.getStrutUff());
		soapModel.setStrutIsp2(model.getStrutIsp2());
		soapModel.setTelRichiedente(model.getTelRichiedente());
		soapModel.setCostoReale(model.getCostoReale());
		soapModel.setPreventivo(model.getPreventivo());
		soapModel.setFlagInvio(model.getFlagInvio());

		return soapModel;
	}

	public static RichiesteSoap[] toSoapModels(Richieste[] models) {
		RichiesteSoap[] soapModels = new RichiesteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiesteSoap[][] toSoapModels(Richieste[][] models) {
		RichiesteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiesteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiesteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiesteSoap[] toSoapModels(List<Richieste> models) {
		List<RichiesteSoap> soapModels = new ArrayList<RichiesteSoap>(models.size());

		for (Richieste model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiesteSoap[soapModels.size()]);
	}

	public RichiesteSoap() {
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

	public Date getDataRichiesta() {
		return _dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		_dataRichiesta = dataRichiesta;
	}

	public long getIdPeriodicita() {
		return _idPeriodicita;
	}

	public void setIdPeriodicita(long idPeriodicita) {
		_idPeriodicita = idPeriodicita;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getRiferimentoStanza() {
		return _riferimentoStanza;
	}

	public void setRiferimentoStanza(String riferimentoStanza) {
		_riferimentoStanza = riferimentoStanza;
	}

	public String getIspettorato() {
		return _ispettorato;
	}

	public void setIspettorato(String ispettorato) {
		_ispettorato = ispettorato;
	}

	public String getNoteRichiedente() {
		return _noteRichiedente;
	}

	public void setNoteRichiedente(String noteRichiedente) {
		_noteRichiedente = noteRichiedente;
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

	public String getStrutIsp() {
		return _strutIsp;
	}

	public void setStrutIsp(String strutIsp) {
		_strutIsp = strutIsp;
	}

	public String getStrutUff() {
		return _strutUff;
	}

	public void setStrutUff(String strutUff) {
		_strutUff = strutUff;
	}

	public String getStrutIsp2() {
		return _strutIsp2;
	}

	public void setStrutIsp2(String strutIsp2) {
		_strutIsp2 = strutIsp2;
	}

	public String getTelRichiedente() {
		return _telRichiedente;
	}

	public void setTelRichiedente(String telRichiedente) {
		_telRichiedente = telRichiedente;
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

	private long _idStatoAttuale;
	private long _id;
	private Date _dataRichiesta;
	private long _idPeriodicita;
	private String _email;
	private String _riferimentoStanza;
	private String _ispettorato;
	private String _noteRichiedente;
	private String _ufficio;
	private String _note;
	private long _uidIns;
	private Date _dataIns;
	private long _uidUpd;
	private Date _dataUpd;
	private String _oggetto;
	private String _idSede;
	private String _strutIsp;
	private String _strutUff;
	private String _strutIsp2;
	private String _telRichiedente;
	private float _costoReale;
	private int _preventivo;
	private int _flagInvio;
}