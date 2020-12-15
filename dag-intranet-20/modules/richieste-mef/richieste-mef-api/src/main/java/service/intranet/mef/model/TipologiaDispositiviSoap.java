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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.TipologiaDispositiviServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.TipologiaDispositiviServiceSoap
 * @generated
 */
@ProviderType
public class TipologiaDispositiviSoap implements Serializable {
	public static TipologiaDispositiviSoap toSoapModel(
		TipologiaDispositivi model) {
		TipologiaDispositiviSoap soapModel = new TipologiaDispositiviSoap();

		soapModel.setId_tipologia_dispositivi(model.getId_tipologia_dispositivi());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static TipologiaDispositiviSoap[] toSoapModels(
		TipologiaDispositivi[] models) {
		TipologiaDispositiviSoap[] soapModels = new TipologiaDispositiviSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipologiaDispositiviSoap[][] toSoapModels(
		TipologiaDispositivi[][] models) {
		TipologiaDispositiviSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipologiaDispositiviSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipologiaDispositiviSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipologiaDispositiviSoap[] toSoapModels(
		List<TipologiaDispositivi> models) {
		List<TipologiaDispositiviSoap> soapModels = new ArrayList<TipologiaDispositiviSoap>(models.size());

		for (TipologiaDispositivi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipologiaDispositiviSoap[soapModels.size()]);
	}

	public TipologiaDispositiviSoap() {
	}

	public long getPrimaryKey() {
		return _id_tipologia_dispositivi;
	}

	public void setPrimaryKey(long pk) {
		setId_tipologia_dispositivi(pk);
	}

	public long getId_tipologia_dispositivi() {
		return _id_tipologia_dispositivi;
	}

	public void setId_tipologia_dispositivi(long id_tipologia_dispositivi) {
		_id_tipologia_dispositivi = id_tipologia_dispositivi;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id_tipologia_dispositivi;
	private String _descrizione;
}