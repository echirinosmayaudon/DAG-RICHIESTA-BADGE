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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.SalaStrutturaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.SalaStrutturaServiceSoap
 * @generated
 */
@ProviderType
public class SalaStrutturaSoap implements Serializable {
	public static SalaStrutturaSoap toSoapModel(SalaStruttura model) {
		SalaStrutturaSoap soapModel = new SalaStrutturaSoap();

		soapModel.setId(model.getId());
		soapModel.setId_sala(model.getId_sala());
		soapModel.setId_struttura(model.getId_struttura());

		return soapModel;
	}

	public static SalaStrutturaSoap[] toSoapModels(SalaStruttura[] models) {
		SalaStrutturaSoap[] soapModels = new SalaStrutturaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SalaStrutturaSoap[][] toSoapModels(SalaStruttura[][] models) {
		SalaStrutturaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SalaStrutturaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SalaStrutturaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SalaStrutturaSoap[] toSoapModels(List<SalaStruttura> models) {
		List<SalaStrutturaSoap> soapModels = new ArrayList<SalaStrutturaSoap>(models.size());

		for (SalaStruttura model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SalaStrutturaSoap[soapModels.size()]);
	}

	public SalaStrutturaSoap() {
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

	public long getId_sala() {
		return _id_sala;
	}

	public void setId_sala(long id_sala) {
		_id_sala = id_sala;
	}

	public long getId_struttura() {
		return _id_struttura;
	}

	public void setId_struttura(long id_struttura) {
		_id_struttura = id_struttura;
	}

	private long _id;
	private long _id_sala;
	private long _id_struttura;
}