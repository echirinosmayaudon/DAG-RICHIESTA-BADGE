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

package service.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.LogisticaRichiesteServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.LogisticaRichiesteServiceSoap
 * @generated
 */
@ProviderType
public class LogisticaRichiesteSoap implements Serializable {
	public static LogisticaRichiesteSoap toSoapModel(LogisticaRichieste model) {
		LogisticaRichiesteSoap soapModel = new LogisticaRichiesteSoap();

		soapModel.setId(model.getId());
		soapModel.setOggetto(model.getOggetto());
		soapModel.setUtente(model.getUtente());
		soapModel.setDipartimento(model.getDipartimento());
		soapModel.setData_richiesta(model.getData_richiesta());
		soapModel.setDettaglio_richiedente(model.getDettaglio_richiedente());
		soapModel.setDettaglio_richieste(model.getDettaglio_richieste());
		soapModel.setNote_gestore(model.getNote_gestore());
		soapModel.setId_valutazione(model.getId_valutazione());
		soapModel.setId_stato(model.getId_stato());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static LogisticaRichiesteSoap[] toSoapModels(
		LogisticaRichieste[] models) {
		LogisticaRichiesteSoap[] soapModels = new LogisticaRichiesteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogisticaRichiesteSoap[][] toSoapModels(
		LogisticaRichieste[][] models) {
		LogisticaRichiesteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogisticaRichiesteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogisticaRichiesteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogisticaRichiesteSoap[] toSoapModels(
		List<LogisticaRichieste> models) {
		List<LogisticaRichiesteSoap> soapModels = new ArrayList<LogisticaRichiesteSoap>(models.size());

		for (LogisticaRichieste model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogisticaRichiesteSoap[soapModels.size()]);
	}

	public LogisticaRichiesteSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getOggetto() {
		return _oggetto;
	}

	public void setOggetto(String oggetto) {
		_oggetto = oggetto;
	}

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public String getDipartimento() {
		return _dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		_dipartimento = dipartimento;
	}

	public Date getData_richiesta() {
		return _data_richiesta;
	}

	public void setData_richiesta(Date data_richiesta) {
		_data_richiesta = data_richiesta;
	}

	public String getDettaglio_richiedente() {
		return _dettaglio_richiedente;
	}

	public void setDettaglio_richiedente(String dettaglio_richiedente) {
		_dettaglio_richiedente = dettaglio_richiedente;
	}

	public String getDettaglio_richieste() {
		return _dettaglio_richieste;
	}

	public void setDettaglio_richieste(String dettaglio_richieste) {
		_dettaglio_richieste = dettaglio_richieste;
	}

	public String getNote_gestore() {
		return _note_gestore;
	}

	public void setNote_gestore(String note_gestore) {
		_note_gestore = note_gestore;
	}

	public long getId_valutazione() {
		return _id_valutazione;
	}

	public void setId_valutazione(long id_valutazione) {
		_id_valutazione = id_valutazione;
	}

	public long getId_stato() {
		return _id_stato;
	}

	public void setId_stato(long id_stato) {
		_id_stato = id_stato;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _id;
	private String _oggetto;
	private String _utente;
	private String _dipartimento;
	private Date _data_richiesta;
	private String _dettaglio_richiedente;
	private String _dettaglio_richieste;
	private String _note_gestore;
	private long _id_valutazione;
	private long _id_stato;
	private String _note;
}