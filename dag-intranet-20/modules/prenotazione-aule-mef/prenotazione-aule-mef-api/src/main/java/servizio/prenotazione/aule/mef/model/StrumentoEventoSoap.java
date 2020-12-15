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
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.StrumentoEventoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.StrumentoEventoServiceSoap
 * @generated
 */
@ProviderType
public class StrumentoEventoSoap implements Serializable {
	public static StrumentoEventoSoap toSoapModel(StrumentoEvento model) {
		StrumentoEventoSoap soapModel = new StrumentoEventoSoap();

		soapModel.setId_strumento(model.getId_strumento());
		soapModel.setDesc_strumento(model.getDesc_strumento());
		soapModel.setEmail_ref(model.getEmail_ref());

		return soapModel;
	}

	public static StrumentoEventoSoap[] toSoapModels(StrumentoEvento[] models) {
		StrumentoEventoSoap[] soapModels = new StrumentoEventoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StrumentoEventoSoap[][] toSoapModels(
		StrumentoEvento[][] models) {
		StrumentoEventoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StrumentoEventoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StrumentoEventoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StrumentoEventoSoap[] toSoapModels(
		List<StrumentoEvento> models) {
		List<StrumentoEventoSoap> soapModels = new ArrayList<StrumentoEventoSoap>(models.size());

		for (StrumentoEvento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StrumentoEventoSoap[soapModels.size()]);
	}

	public StrumentoEventoSoap() {
	}

	public long getPrimaryKey() {
		return _id_strumento;
	}

	public void setPrimaryKey(long pk) {
		setId_strumento(pk);
	}

	public long getId_strumento() {
		return _id_strumento;
	}

	public void setId_strumento(long id_strumento) {
		_id_strumento = id_strumento;
	}

	public String getDesc_strumento() {
		return _desc_strumento;
	}

	public void setDesc_strumento(String desc_strumento) {
		_desc_strumento = desc_strumento;
	}

	public String getEmail_ref() {
		return _email_ref;
	}

	public void setEmail_ref(String email_ref) {
		_email_ref = email_ref;
	}

	private long _id_strumento;
	private String _desc_strumento;
	private String _email_ref;
}