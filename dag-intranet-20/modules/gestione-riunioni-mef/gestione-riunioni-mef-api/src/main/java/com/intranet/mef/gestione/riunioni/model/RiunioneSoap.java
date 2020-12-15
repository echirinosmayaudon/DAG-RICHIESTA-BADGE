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

package com.intranet.mef.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.RiunioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.RiunioneServiceSoap
 * @generated
 */
@ProviderType
public class RiunioneSoap implements Serializable {
	public static RiunioneSoap toSoapModel(Riunione model) {
		RiunioneSoap soapModel = new RiunioneSoap();

		soapModel.setId_riunione(model.getId_riunione());
		soapModel.setOggetto(model.getOggetto());
		soapModel.setData_inizio(model.getData_inizio());
		soapModel.setData_fine(model.getData_fine());
		soapModel.setNote(model.getNote());
		soapModel.setData_modifica(model.getData_modifica());
		soapModel.setData_creazione(model.getData_creazione());
		soapModel.setProtocollo(model.getProtocollo());
		soapModel.setId_stato_riunione(model.getId_stato_riunione());
		soapModel.setId_tipo(model.getId_tipo());
		soapModel.setId_luogo(model.getId_luogo());
		soapModel.setId_amministrazione_convocante(model.getId_amministrazione_convocante());
		soapModel.setData_ultimo_sollecito(model.getData_ultimo_sollecito());

		return soapModel;
	}

	public static RiunioneSoap[] toSoapModels(Riunione[] models) {
		RiunioneSoap[] soapModels = new RiunioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RiunioneSoap[][] toSoapModels(Riunione[][] models) {
		RiunioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RiunioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RiunioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RiunioneSoap[] toSoapModels(List<Riunione> models) {
		List<RiunioneSoap> soapModels = new ArrayList<RiunioneSoap>(models.size());

		for (Riunione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RiunioneSoap[soapModels.size()]);
	}

	public RiunioneSoap() {
	}

	public long getPrimaryKey() {
		return _id_riunione;
	}

	public void setPrimaryKey(long pk) {
		setId_riunione(pk);
	}

	public long getId_riunione() {
		return _id_riunione;
	}

	public void setId_riunione(long id_riunione) {
		_id_riunione = id_riunione;
	}

	public String getOggetto() {
		return _oggetto;
	}

	public void setOggetto(String oggetto) {
		_oggetto = oggetto;
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

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public Date getData_modifica() {
		return _data_modifica;
	}

	public void setData_modifica(Date data_modifica) {
		_data_modifica = data_modifica;
	}

	public Date getData_creazione() {
		return _data_creazione;
	}

	public void setData_creazione(Date data_creazione) {
		_data_creazione = data_creazione;
	}

	public String getProtocollo() {
		return _protocollo;
	}

	public void setProtocollo(String protocollo) {
		_protocollo = protocollo;
	}

	public long getId_stato_riunione() {
		return _id_stato_riunione;
	}

	public void setId_stato_riunione(long id_stato_riunione) {
		_id_stato_riunione = id_stato_riunione;
	}

	public long getId_tipo() {
		return _id_tipo;
	}

	public void setId_tipo(long id_tipo) {
		_id_tipo = id_tipo;
	}

	public long getId_luogo() {
		return _id_luogo;
	}

	public void setId_luogo(long id_luogo) {
		_id_luogo = id_luogo;
	}

	public long getId_amministrazione_convocante() {
		return _id_amministrazione_convocante;
	}

	public void setId_amministrazione_convocante(
		long id_amministrazione_convocante) {
		_id_amministrazione_convocante = id_amministrazione_convocante;
	}

	public Date getData_ultimo_sollecito() {
		return _data_ultimo_sollecito;
	}

	public void setData_ultimo_sollecito(Date data_ultimo_sollecito) {
		_data_ultimo_sollecito = data_ultimo_sollecito;
	}

	private long _id_riunione;
	private String _oggetto;
	private Date _data_inizio;
	private Date _data_fine;
	private String _note;
	private Date _data_modifica;
	private Date _data_creazione;
	private String _protocollo;
	private long _id_stato_riunione;
	private long _id_tipo;
	private long _id_luogo;
	private long _id_amministrazione_convocante;
	private Date _data_ultimo_sollecito;
}