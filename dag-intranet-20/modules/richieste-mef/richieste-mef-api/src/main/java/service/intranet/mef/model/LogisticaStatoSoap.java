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
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.LogisticaStatoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.LogisticaStatoServiceSoap
 * @generated
 */
@ProviderType
public class LogisticaStatoSoap implements Serializable {
	public static LogisticaStatoSoap toSoapModel(LogisticaStato model) {
		LogisticaStatoSoap soapModel = new LogisticaStatoSoap();

		soapModel.setId(model.getId());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setUtente(model.getUtente());

		return soapModel;
	}

	public static LogisticaStatoSoap[] toSoapModels(LogisticaStato[] models) {
		LogisticaStatoSoap[] soapModels = new LogisticaStatoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogisticaStatoSoap[][] toSoapModels(LogisticaStato[][] models) {
		LogisticaStatoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogisticaStatoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogisticaStatoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogisticaStatoSoap[] toSoapModels(List<LogisticaStato> models) {
		List<LogisticaStatoSoap> soapModels = new ArrayList<LogisticaStatoSoap>(models.size());

		for (LogisticaStato model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogisticaStatoSoap[soapModels.size()]);
	}

	public LogisticaStatoSoap() {
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

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	private long _id;
	private String _descrizione;
	private String _utente;
}