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
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.StrumentoTecServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.StrumentoTecServiceSoap
 * @generated
 */
@ProviderType
public class StrumentoTecSoap implements Serializable {
	public static StrumentoTecSoap toSoapModel(StrumentoTec model) {
		StrumentoTecSoap soapModel = new StrumentoTecSoap();

		soapModel.setId_strumento(model.getId_strumento());
		soapModel.setDesc_strumento(model.getDesc_strumento());
		soapModel.setEmail_ref(model.getEmail_ref());

		return soapModel;
	}

	public static StrumentoTecSoap[] toSoapModels(StrumentoTec[] models) {
		StrumentoTecSoap[] soapModels = new StrumentoTecSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StrumentoTecSoap[][] toSoapModels(StrumentoTec[][] models) {
		StrumentoTecSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StrumentoTecSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StrumentoTecSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StrumentoTecSoap[] toSoapModels(List<StrumentoTec> models) {
		List<StrumentoTecSoap> soapModels = new ArrayList<StrumentoTecSoap>(models.size());

		for (StrumentoTec model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StrumentoTecSoap[soapModels.size()]);
	}

	public StrumentoTecSoap() {
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