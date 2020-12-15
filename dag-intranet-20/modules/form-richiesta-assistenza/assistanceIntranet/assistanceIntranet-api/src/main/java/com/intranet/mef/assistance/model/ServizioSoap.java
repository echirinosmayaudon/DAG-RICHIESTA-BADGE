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
public class ServizioSoap implements Serializable {
	public static ServizioSoap toSoapModel(Servizio model) {
		ServizioSoap soapModel = new ServizioSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAssServiceId(model.getAssServiceId());
		soapModel.setServiceName(model.getServiceName());
		soapModel.setAssScopeId(model.getAssScopeId());
		soapModel.setLevelAssistance(model.getLevelAssistance());

		return soapModel;
	}

	public static ServizioSoap[] toSoapModels(Servizio[] models) {
		ServizioSoap[] soapModels = new ServizioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServizioSoap[][] toSoapModels(Servizio[][] models) {
		ServizioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServizioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServizioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServizioSoap[] toSoapModels(List<Servizio> models) {
		List<ServizioSoap> soapModels = new ArrayList<ServizioSoap>(models.size());

		for (Servizio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServizioSoap[soapModels.size()]);
	}

	public ServizioSoap() {
	}

	public String getPrimaryKey() {
		return _assServiceId;
	}

	public void setPrimaryKey(String pk) {
		setAssServiceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getAssServiceId() {
		return _assServiceId;
	}

	public void setAssServiceId(String assServiceId) {
		_assServiceId = assServiceId;
	}

	public String getServiceName() {
		return _serviceName;
	}

	public void setServiceName(String serviceName) {
		_serviceName = serviceName;
	}

	public String getAssScopeId() {
		return _assScopeId;
	}

	public void setAssScopeId(String assScopeId) {
		_assScopeId = assScopeId;
	}

	public String getLevelAssistance() {
		return _levelAssistance;
	}

	public void setLevelAssistance(String levelAssistance) {
		_levelAssistance = levelAssistance;
	}

	private String _uuid;
	private String _assServiceId;
	private String _serviceName;
	private String _assScopeId;
	private String _levelAssistance;
}