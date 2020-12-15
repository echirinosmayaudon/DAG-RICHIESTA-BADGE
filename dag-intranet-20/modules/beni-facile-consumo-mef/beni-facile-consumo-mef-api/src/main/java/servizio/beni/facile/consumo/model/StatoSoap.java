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

package servizio.beni.facile.consumo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.beni.facile.consumo.service.http.StatoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.http.StatoServiceSoap
 * @generated
 */
@ProviderType
public class StatoSoap implements Serializable {
	public static StatoSoap toSoapModel(Stato model) {
		StatoSoap soapModel = new StatoSoap();

		soapModel.setId(model.getId());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static StatoSoap[] toSoapModels(Stato[] models) {
		StatoSoap[] soapModels = new StatoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatoSoap[][] toSoapModels(Stato[][] models) {
		StatoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatoSoap[] toSoapModels(List<Stato> models) {
		List<StatoSoap> soapModels = new ArrayList<StatoSoap>(models.size());

		for (Stato model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatoSoap[soapModels.size()]);
	}

	public StatoSoap() {
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

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id;
	private String _descrizione;
}