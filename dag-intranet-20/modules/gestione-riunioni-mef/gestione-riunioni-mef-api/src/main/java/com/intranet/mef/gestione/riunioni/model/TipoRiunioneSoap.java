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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.gestione.riunioni.service.http.TipoRiunioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.http.TipoRiunioneServiceSoap
 * @generated
 */
@ProviderType
public class TipoRiunioneSoap implements Serializable {
	public static TipoRiunioneSoap toSoapModel(TipoRiunione model) {
		TipoRiunioneSoap soapModel = new TipoRiunioneSoap();

		soapModel.setId_tipo(model.getId_tipo());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static TipoRiunioneSoap[] toSoapModels(TipoRiunione[] models) {
		TipoRiunioneSoap[] soapModels = new TipoRiunioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipoRiunioneSoap[][] toSoapModels(TipoRiunione[][] models) {
		TipoRiunioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipoRiunioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipoRiunioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipoRiunioneSoap[] toSoapModels(List<TipoRiunione> models) {
		List<TipoRiunioneSoap> soapModels = new ArrayList<TipoRiunioneSoap>(models.size());

		for (TipoRiunione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipoRiunioneSoap[soapModels.size()]);
	}

	public TipoRiunioneSoap() {
	}

	public long getPrimaryKey() {
		return _id_tipo;
	}

	public void setPrimaryKey(long pk) {
		setId_tipo(pk);
	}

	public long getId_tipo() {
		return _id_tipo;
	}

	public void setId_tipo(long id_tipo) {
		_id_tipo = id_tipo;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id_tipo;
	private String _descrizione;
}