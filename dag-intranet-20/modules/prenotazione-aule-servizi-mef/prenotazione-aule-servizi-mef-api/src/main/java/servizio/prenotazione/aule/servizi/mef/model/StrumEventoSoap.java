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

import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.servizi.mef.service.http.StrumEventoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.servizi.mef.service.http.StrumEventoServiceSoap
 * @generated
 */
@ProviderType
public class StrumEventoSoap implements Serializable {
	public static StrumEventoSoap toSoapModel(StrumEvento model) {
		StrumEventoSoap soapModel = new StrumEventoSoap();

		soapModel.setId_strum(model.getId_strum());
		soapModel.setId_sala(model.getId_sala());
		soapModel.setEmail_ref(model.getEmail_ref());

		return soapModel;
	}

	public static StrumEventoSoap[] toSoapModels(StrumEvento[] models) {
		StrumEventoSoap[] soapModels = new StrumEventoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StrumEventoSoap[][] toSoapModels(StrumEvento[][] models) {
		StrumEventoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StrumEventoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StrumEventoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StrumEventoSoap[] toSoapModels(List<StrumEvento> models) {
		List<StrumEventoSoap> soapModels = new ArrayList<StrumEventoSoap>(models.size());

		for (StrumEvento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StrumEventoSoap[soapModels.size()]);
	}

	public StrumEventoSoap() {
	}

	public StrumEventoPK getPrimaryKey() {
		return new StrumEventoPK(_id_strum, _id_sala);
	}

	public void setPrimaryKey(StrumEventoPK pk) {
		setId_strum(pk.id_strum);
		setId_sala(pk.id_sala);
	}

	public long getId_strum() {
		return _id_strum;
	}

	public void setId_strum(long id_strum) {
		_id_strum = id_strum;
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

	private long _id_strum;
	private long _id_sala;
	private String _email_ref;
}