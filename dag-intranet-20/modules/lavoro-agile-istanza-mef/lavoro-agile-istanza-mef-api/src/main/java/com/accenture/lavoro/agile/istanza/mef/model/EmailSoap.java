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

package com.accenture.lavoro.agile.istanza.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.accenture.lavoro.agile.istanza.mef.service.http.EmailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.lavoro.agile.istanza.mef.service.http.EmailServiceSoap
 * @generated
 */
@ProviderType
public class EmailSoap implements Serializable {
	public static EmailSoap toSoapModel(Email model) {
		EmailSoap soapModel = new EmailSoap();

		soapModel.setId(model.getId());
		soapModel.setIdStruttura(model.getIdStruttura());
		soapModel.setMailCC(model.getMailCC());

		return soapModel;
	}

	public static EmailSoap[] toSoapModels(Email[] models) {
		EmailSoap[] soapModels = new EmailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailSoap[][] toSoapModels(Email[][] models) {
		EmailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailSoap[] toSoapModels(List<Email> models) {
		List<EmailSoap> soapModels = new ArrayList<EmailSoap>(models.size());

		for (Email model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailSoap[soapModels.size()]);
	}

	public EmailSoap() {
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

	public long getIdStruttura() {
		return _idStruttura;
	}

	public void setIdStruttura(long idStruttura) {
		_idStruttura = idStruttura;
	}

	public String getMailCC() {
		return _mailCC;
	}

	public void setMailCC(String mailCC) {
		_mailCC = mailCC;
	}

	private long _id;
	private long _idStruttura;
	private String _mailCC;
}