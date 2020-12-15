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

package servizio.prenotazione.aule.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.PrenotazioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.PrenotazioneServiceSoap
 * @generated
 */
@ProviderType
public class PrenotazioneSoap implements Serializable {
	public static PrenotazioneSoap toSoapModel(Prenotazione model) {
		PrenotazioneSoap soapModel = new PrenotazioneSoap();

		soapModel.setId_prenota(model.getId_prenota());
		soapModel.setId_sala(model.getId_sala());
		soapModel.setCod_fiscale(model.getCod_fiscale());
		soapModel.setData_prenota(model.getData_prenota());
		soapModel.setData_inizio(model.getData_inizio());
		soapModel.setData_fine(model.getData_fine());
		soapModel.setPartecipanti(model.getPartecipanti());
		soapModel.setId_evento(model.getId_evento());
		soapModel.setAttivita(model.getAttivita());
		soapModel.setNote(model.getNote());
		soapModel.setId_stato(model.getId_stato());
		soapModel.setDati_rich(model.getDati_rich());
		soapModel.setServizi(model.getServizi());

		return soapModel;
	}

	public static PrenotazioneSoap[] toSoapModels(Prenotazione[] models) {
		PrenotazioneSoap[] soapModels = new PrenotazioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PrenotazioneSoap[][] toSoapModels(Prenotazione[][] models) {
		PrenotazioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PrenotazioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PrenotazioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PrenotazioneSoap[] toSoapModels(List<Prenotazione> models) {
		List<PrenotazioneSoap> soapModels = new ArrayList<PrenotazioneSoap>(models.size());

		for (Prenotazione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PrenotazioneSoap[soapModels.size()]);
	}

	public PrenotazioneSoap() {
	}

	public long getPrimaryKey() {
		return _id_prenota;
	}

	public void setPrimaryKey(long pk) {
		setId_prenota(pk);
	}

	public long getId_prenota() {
		return _id_prenota;
	}

	public void setId_prenota(long id_prenota) {
		_id_prenota = id_prenota;
	}

	public long getId_sala() {
		return _id_sala;
	}

	public void setId_sala(long id_sala) {
		_id_sala = id_sala;
	}

	public String getCod_fiscale() {
		return _cod_fiscale;
	}

	public void setCod_fiscale(String cod_fiscale) {
		_cod_fiscale = cod_fiscale;
	}

	public Date getData_prenota() {
		return _data_prenota;
	}

	public void setData_prenota(Date data_prenota) {
		_data_prenota = data_prenota;
	}

	public Date getData_inizio() {
		return _data_inizio;
	}

	public void setData_inizio(Date data_inizio) {
		_data_inizio = data_inizio;
	}

	public Date getData_fine() {
		return _data_fine;
	}

	public void setData_fine(Date data_fine) {
		_data_fine = data_fine;
	}

	public int getPartecipanti() {
		return _partecipanti;
	}

	public void setPartecipanti(int partecipanti) {
		_partecipanti = partecipanti;
	}

	public long getId_evento() {
		return _id_evento;
	}

	public void setId_evento(long id_evento) {
		_id_evento = id_evento;
	}

	public String getAttivita() {
		return _attivita;
	}

	public void setAttivita(String attivita) {
		_attivita = attivita;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getId_stato() {
		return _id_stato;
	}

	public void setId_stato(long id_stato) {
		_id_stato = id_stato;
	}

	public String getDati_rich() {
		return _dati_rich;
	}

	public void setDati_rich(String dati_rich) {
		_dati_rich = dati_rich;
	}

	public String getServizi() {
		return _servizi;
	}

	public void setServizi(String servizi) {
		_servizi = servizi;
	}

	private long _id_prenota;
	private long _id_sala;
	private String _cod_fiscale;
	private Date _data_prenota;
	private Date _data_inizio;
	private Date _data_fine;
	private int _partecipanti;
	private long _id_evento;
	private String _attivita;
	private String _note;
	private long _id_stato;
	private String _dati_rich;
	private String _servizi;
}