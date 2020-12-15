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

import com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.StoricoStatoRiunioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.StoricoStatoRiunioneServiceSoap
 * @generated
 */
@ProviderType
public class StoricoStatoRiunioneSoap implements Serializable {
	public static StoricoStatoRiunioneSoap toSoapModel(
		StoricoStatoRiunione model) {
		StoricoStatoRiunioneSoap soapModel = new StoricoStatoRiunioneSoap();

		soapModel.setId_riunione(model.getId_riunione());
		soapModel.setId_storico(model.getId_storico());
		soapModel.setData(model.getData());
		soapModel.setId_stato_riunione(model.getId_stato_riunione());

		return soapModel;
	}

	public static StoricoStatoRiunioneSoap[] toSoapModels(
		StoricoStatoRiunione[] models) {
		StoricoStatoRiunioneSoap[] soapModels = new StoricoStatoRiunioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StoricoStatoRiunioneSoap[][] toSoapModels(
		StoricoStatoRiunione[][] models) {
		StoricoStatoRiunioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StoricoStatoRiunioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StoricoStatoRiunioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StoricoStatoRiunioneSoap[] toSoapModels(
		List<StoricoStatoRiunione> models) {
		List<StoricoStatoRiunioneSoap> soapModels = new ArrayList<StoricoStatoRiunioneSoap>(models.size());

		for (StoricoStatoRiunione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StoricoStatoRiunioneSoap[soapModels.size()]);
	}

	public StoricoStatoRiunioneSoap() {
	}

	public StoricoStatoRiunionePK getPrimaryKey() {
		return new StoricoStatoRiunionePK(_id_riunione, _id_storico);
	}

	public void setPrimaryKey(StoricoStatoRiunionePK pk) {
		setId_riunione(pk.id_riunione);
		setId_storico(pk.id_storico);
	}

	public long getId_riunione() {
		return _id_riunione;
	}

	public void setId_riunione(long id_riunione) {
		_id_riunione = id_riunione;
	}

	public long getId_storico() {
		return _id_storico;
	}

	public void setId_storico(long id_storico) {
		_id_storico = id_storico;
	}

	public Date getData() {
		return _data;
	}

	public void setData(Date data) {
		_data = data;
	}

	public long getId_stato_riunione() {
		return _id_stato_riunione;
	}

	public void setId_stato_riunione(long id_stato_riunione) {
		_id_stato_riunione = id_stato_riunione;
	}

	private long _id_riunione;
	private long _id_storico;
	private Date _data;
	private long _id_stato_riunione;
}