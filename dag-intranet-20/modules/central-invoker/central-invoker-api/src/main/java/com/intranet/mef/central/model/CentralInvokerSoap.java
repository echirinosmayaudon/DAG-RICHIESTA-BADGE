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

package com.intranet.mef.central.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.central.service.http.CentralInvokerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.central.service.http.CentralInvokerServiceSoap
 * @generated
 */
@ProviderType
public class CentralInvokerSoap implements Serializable {
	public static CentralInvokerSoap toSoapModel(CentralInvoker model) {
		CentralInvokerSoap soapModel = new CentralInvokerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIdRecord(model.getIdRecord());
		soapModel.setSecretaryId(model.getSecretaryId());

		return soapModel;
	}

	public static CentralInvokerSoap[] toSoapModels(CentralInvoker[] models) {
		CentralInvokerSoap[] soapModels = new CentralInvokerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CentralInvokerSoap[][] toSoapModels(CentralInvoker[][] models) {
		CentralInvokerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CentralInvokerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CentralInvokerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CentralInvokerSoap[] toSoapModels(List<CentralInvoker> models) {
		List<CentralInvokerSoap> soapModels = new ArrayList<CentralInvokerSoap>(models.size());

		for (CentralInvoker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CentralInvokerSoap[soapModels.size()]);
	}

	public CentralInvokerSoap() {
	}

	public long getPrimaryKey() {
		return _idRecord;
	}

	public void setPrimaryKey(long pk) {
		setIdRecord(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIdRecord() {
		return _idRecord;
	}

	public void setIdRecord(long idRecord) {
		_idRecord = idRecord;
	}

	public long getSecretaryId() {
		return _secretaryId;
	}

	public void setSecretaryId(long secretaryId) {
		_secretaryId = secretaryId;
	}

	private String _uuid;
	private long _idRecord;
	private long _secretaryId;
}