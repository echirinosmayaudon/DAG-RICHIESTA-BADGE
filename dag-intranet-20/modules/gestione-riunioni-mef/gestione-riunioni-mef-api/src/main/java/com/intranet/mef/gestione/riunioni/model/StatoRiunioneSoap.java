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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.StatoRiunioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.StatoRiunioneServiceSoap
 * @generated
 */
@ProviderType
public class StatoRiunioneSoap implements Serializable {
	public static StatoRiunioneSoap toSoapModel(StatoRiunione model) {
		StatoRiunioneSoap soapModel = new StatoRiunioneSoap();

		soapModel.setId_stato_riunione(model.getId_stato_riunione());
		soapModel.setLabel(model.getLabel());
		soapModel.setNext_stato(model.getNext_stato());

		return soapModel;
	}

	public static StatoRiunioneSoap[] toSoapModels(StatoRiunione[] models) {
		StatoRiunioneSoap[] soapModels = new StatoRiunioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatoRiunioneSoap[][] toSoapModels(StatoRiunione[][] models) {
		StatoRiunioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatoRiunioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatoRiunioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatoRiunioneSoap[] toSoapModels(List<StatoRiunione> models) {
		List<StatoRiunioneSoap> soapModels = new ArrayList<StatoRiunioneSoap>(models.size());

		for (StatoRiunione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatoRiunioneSoap[soapModels.size()]);
	}

	public StatoRiunioneSoap() {
	}

	public long getPrimaryKey() {
		return _id_stato_riunione;
	}

	public void setPrimaryKey(long pk) {
		setId_stato_riunione(pk);
	}

	public long getId_stato_riunione() {
		return _id_stato_riunione;
	}

	public void setId_stato_riunione(long id_stato_riunione) {
		_id_stato_riunione = id_stato_riunione;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public String getNext_stato() {
		return _next_stato;
	}

	public void setNext_stato(String next_stato) {
		_next_stato = next_stato;
	}

	private long _id_stato_riunione;
	private String _label;
	private String _next_stato;
}