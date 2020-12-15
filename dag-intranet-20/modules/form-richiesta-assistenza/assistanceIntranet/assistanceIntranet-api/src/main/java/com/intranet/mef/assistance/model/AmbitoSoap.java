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

package com.intranet.mef.assistance.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AmbitoSoap implements Serializable {
	public static AmbitoSoap toSoapModel(Ambito model) {
		AmbitoSoap soapModel = new AmbitoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAssScopeId(model.getAssScopeId());
		soapModel.setScopeName(model.getScopeName());

		return soapModel;
	}

	public static AmbitoSoap[] toSoapModels(Ambito[] models) {
		AmbitoSoap[] soapModels = new AmbitoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AmbitoSoap[][] toSoapModels(Ambito[][] models) {
		AmbitoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AmbitoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AmbitoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AmbitoSoap[] toSoapModels(List<Ambito> models) {
		List<AmbitoSoap> soapModels = new ArrayList<AmbitoSoap>(models.size());

		for (Ambito model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AmbitoSoap[soapModels.size()]);
	}

	public AmbitoSoap() {
	}

	public String getPrimaryKey() {
		return _assScopeId;
	}

	public void setPrimaryKey(String pk) {
		setAssScopeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getAssScopeId() {
		return _assScopeId;
	}

	public void setAssScopeId(String assScopeId) {
		_assScopeId = assScopeId;
	}

	public String getScopeName() {
		return _scopeName;
	}

	public void setScopeName(String scopeName) {
		_scopeName = scopeName;
	}

	private String _uuid;
	private String _assScopeId;
	private String _scopeName;
}