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

package com.cacheportlet.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cacheportlet.mef.service.http.CachePortletServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.cacheportlet.mef.service.http.CachePortletServiceSoap
 * @generated
 */
@ProviderType
public class CachePortletSoap implements Serializable {
	public static CachePortletSoap toSoapModel(CachePortlet model) {
		CachePortletSoap soapModel = new CachePortletSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setJsonData(model.getJsonData());
		soapModel.setTimestamp(model.getTimestamp());

		return soapModel;
	}

	public static CachePortletSoap[] toSoapModels(CachePortlet[] models) {
		CachePortletSoap[] soapModels = new CachePortletSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CachePortletSoap[][] toSoapModels(CachePortlet[][] models) {
		CachePortletSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CachePortletSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CachePortletSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CachePortletSoap[] toSoapModels(List<CachePortlet> models) {
		List<CachePortletSoap> soapModels = new ArrayList<CachePortletSoap>(models.size());

		for (CachePortlet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CachePortletSoap[soapModels.size()]);
	}

	public CachePortletSoap() {
	}

	public String getPrimaryKey() {
		return _portletId;
	}

	public void setPrimaryKey(String pk) {
		setPortletId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public String getJsonData() {
		return _jsonData;
	}

	public void setJsonData(String jsonData) {
		_jsonData = jsonData;
	}

	public String getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(String timestamp) {
		_timestamp = timestamp;
	}

	private String _uuid;
	private String _portletId;
	private String _jsonData;
	private String _timestamp;
}