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
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.ServizioLogServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.ServizioLogServiceSoap
 * @generated
 */
@ProviderType
public class ServizioLogSoap implements Serializable {
	public static ServizioLogSoap toSoapModel(ServizioLog model) {
		ServizioLogSoap soapModel = new ServizioLogSoap();

		soapModel.setId_servizio(model.getId_servizio());
		soapModel.setDesc_servizio(model.getDesc_servizio());
		soapModel.setEmail_ref(model.getEmail_ref());

		return soapModel;
	}

	public static ServizioLogSoap[] toSoapModels(ServizioLog[] models) {
		ServizioLogSoap[] soapModels = new ServizioLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServizioLogSoap[][] toSoapModels(ServizioLog[][] models) {
		ServizioLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServizioLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServizioLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServizioLogSoap[] toSoapModels(List<ServizioLog> models) {
		List<ServizioLogSoap> soapModels = new ArrayList<ServizioLogSoap>(models.size());

		for (ServizioLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServizioLogSoap[soapModels.size()]);
	}

	public ServizioLogSoap() {
	}

	public long getPrimaryKey() {
		return _id_servizio;
	}

	public void setPrimaryKey(long pk) {
		setId_servizio(pk);
	}

	public long getId_servizio() {
		return _id_servizio;
	}

	public void setId_servizio(long id_servizio) {
		_id_servizio = id_servizio;
	}

	public String getDesc_servizio() {
		return _desc_servizio;
	}

	public void setDesc_servizio(String desc_servizio) {
		_desc_servizio = desc_servizio;
	}

	public String getEmail_ref() {
		return _email_ref;
	}

	public void setEmail_ref(String email_ref) {
		_email_ref = email_ref;
	}

	private long _id_servizio;
	private String _desc_servizio;
	private String _email_ref;
}