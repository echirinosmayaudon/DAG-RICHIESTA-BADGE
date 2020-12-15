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

package mef.email.configurator.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link mef.email.configurator.service.http.EmailAppServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see mef.email.configurator.service.http.EmailAppServiceSoap
 * @generated
 */
@ProviderType
public class EmailAppSoap implements Serializable {
	public static EmailAppSoap toSoapModel(EmailApp model) {
		EmailAppSoap soapModel = new EmailAppSoap();

		soapModel.setId(model.getId());
		soapModel.setAppid(model.getAppid());
		soapModel.setStruttura(model.getStruttura());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static EmailAppSoap[] toSoapModels(EmailApp[] models) {
		EmailAppSoap[] soapModels = new EmailAppSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailAppSoap[][] toSoapModels(EmailApp[][] models) {
		EmailAppSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailAppSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailAppSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailAppSoap[] toSoapModels(List<EmailApp> models) {
		List<EmailAppSoap> soapModels = new ArrayList<EmailAppSoap>(models.size());

		for (EmailApp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailAppSoap[soapModels.size()]);
	}

	public EmailAppSoap() {
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

	public long getAppid() {
		return _appid;
	}

	public void setAppid(long appid) {
		_appid = appid;
	}

	public long getStruttura() {
		return _struttura;
	}

	public void setStruttura(long struttura) {
		_struttura = struttura;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private long _id;
	private long _appid;
	private long _struttura;
	private String _email;
}