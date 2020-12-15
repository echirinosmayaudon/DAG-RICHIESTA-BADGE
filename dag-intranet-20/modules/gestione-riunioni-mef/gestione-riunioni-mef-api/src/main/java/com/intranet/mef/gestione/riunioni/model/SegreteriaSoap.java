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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.SegreteriaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.SegreteriaServiceSoap
 * @generated
 */
@ProviderType
public class SegreteriaSoap implements Serializable {
	public static SegreteriaSoap toSoapModel(Segreteria model) {
		SegreteriaSoap soapModel = new SegreteriaSoap();

		soapModel.setId_segreteria(model.getId_segreteria());
		soapModel.setEmail(model.getEmail());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setAcronimo(model.getAcronimo());
		soapModel.setLivello_gerarchia(model.getLivello_gerarchia());
		soapModel.setCod_padre(model.getCod_padre());
		soapModel.setData_fine_esistenza(model.getData_fine_esistenza());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setCap(model.getCap());
		soapModel.setCod_istat_citta(model.getCod_istat_citta());

		return soapModel;
	}

	public static SegreteriaSoap[] toSoapModels(Segreteria[] models) {
		SegreteriaSoap[] soapModels = new SegreteriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SegreteriaSoap[][] toSoapModels(Segreteria[][] models) {
		SegreteriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SegreteriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SegreteriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SegreteriaSoap[] toSoapModels(List<Segreteria> models) {
		List<SegreteriaSoap> soapModels = new ArrayList<SegreteriaSoap>(models.size());

		for (Segreteria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SegreteriaSoap[soapModels.size()]);
	}

	public SegreteriaSoap() {
	}

	public long getPrimaryKey() {
		return _id_segreteria;
	}

	public void setPrimaryKey(long pk) {
		setId_segreteria(pk);
	}

	public long getId_segreteria() {
		return _id_segreteria;
	}

	public void setId_segreteria(long id_segreteria) {
		_id_segreteria = id_segreteria;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getAcronimo() {
		return _acronimo;
	}

	public void setAcronimo(String acronimo) {
		_acronimo = acronimo;
	}

	public long getLivello_gerarchia() {
		return _livello_gerarchia;
	}

	public void setLivello_gerarchia(long livello_gerarchia) {
		_livello_gerarchia = livello_gerarchia;
	}

	public long getCod_padre() {
		return _cod_padre;
	}

	public void setCod_padre(long cod_padre) {
		_cod_padre = cod_padre;
	}

	public Date getData_fine_esistenza() {
		return _data_fine_esistenza;
	}

	public void setData_fine_esistenza(Date data_fine_esistenza) {
		_data_fine_esistenza = data_fine_esistenza;
	}

	public String getIndirizzo() {
		return _indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
	}

	public String getCap() {
		return _cap;
	}

	public void setCap(String cap) {
		_cap = cap;
	}

	public long getCod_istat_citta() {
		return _cod_istat_citta;
	}

	public void setCod_istat_citta(long cod_istat_citta) {
		_cod_istat_citta = cod_istat_citta;
	}

	private long _id_segreteria;
	private String _email;
	private String _descrizione;
	private String _acronimo;
	private long _livello_gerarchia;
	private long _cod_padre;
	private Date _data_fine_esistenza;
	private String _indirizzo;
	private String _cap;
	private long _cod_istat_citta;
}