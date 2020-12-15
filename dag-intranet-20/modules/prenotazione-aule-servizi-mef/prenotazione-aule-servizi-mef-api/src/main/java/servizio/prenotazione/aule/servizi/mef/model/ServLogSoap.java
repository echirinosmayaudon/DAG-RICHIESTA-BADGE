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

package servizio.prenotazione.aule.servizi.mef.model;

import aQute.bnd.annotation.ProviderType;

import servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.servizi.mef.service.http.ServLogServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.servizi.mef.service.http.ServLogServiceSoap
 * @generated
 */
@ProviderType
public class ServLogSoap implements Serializable {
	public static ServLogSoap toSoapModel(ServLog model) {
		ServLogSoap soapModel = new ServLogSoap();

		soapModel.setId_serv(model.getId_serv());
		soapModel.setId_sala(model.getId_sala());
		soapModel.setEmail_ref(model.getEmail_ref());

		return soapModel;
	}

	public static ServLogSoap[] toSoapModels(ServLog[] models) {
		ServLogSoap[] soapModels = new ServLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServLogSoap[][] toSoapModels(ServLog[][] models) {
		ServLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServLogSoap[] toSoapModels(List<ServLog> models) {
		List<ServLogSoap> soapModels = new ArrayList<ServLogSoap>(models.size());

		for (ServLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServLogSoap[soapModels.size()]);
	}

	public ServLogSoap() {
	}

	public ServLogPK getPrimaryKey() {
		return new ServLogPK(_id_serv, _id_sala);
	}

	public void setPrimaryKey(ServLogPK pk) {
		setId_serv(pk.id_serv);
		setId_sala(pk.id_sala);
	}

	public long getId_serv() {
		return _id_serv;
	}

	public void setId_serv(long id_serv) {
		_id_serv = id_serv;
	}

	public long getId_sala() {
		return _id_sala;
	}

	public void setId_sala(long id_sala) {
		_id_sala = id_sala;
	}

	public String getEmail_ref() {
		return _email_ref;
	}

	public void setEmail_ref(String email_ref) {
		_email_ref = email_ref;
	}

	private long _id_serv;
	private long _id_sala;
	private String _email_ref;
}