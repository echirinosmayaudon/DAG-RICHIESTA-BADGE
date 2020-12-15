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

package com.mef.geco.intranet.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mef.geco.intranet.service.http.supportDataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.mef.geco.intranet.service.http.supportDataServiceSoap
 * @generated
 */
@ProviderType
public class supportDataSoap implements Serializable {
	public static supportDataSoap toSoapModel(supportData model) {
		supportDataSoap soapModel = new supportDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static supportDataSoap[] toSoapModels(supportData[] models) {
		supportDataSoap[] soapModels = new supportDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static supportDataSoap[][] toSoapModels(supportData[][] models) {
		supportDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new supportDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new supportDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static supportDataSoap[] toSoapModels(List<supportData> models) {
		List<supportDataSoap> soapModels = new ArrayList<supportDataSoap>(models.size());

		for (supportData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new supportDataSoap[soapModels.size()]);
	}

	public supportDataSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private String _uuid;
	private long _id;
	private String _data;
}