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
public class AreaSoap implements Serializable {
	public static AreaSoap toSoapModel(Area model) {
		AreaSoap soapModel = new AreaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAreaId(model.getAreaId());
		soapModel.setAreaName(model.getAreaName());
		soapModel.setAssServiceId(model.getAssServiceId());

		return soapModel;
	}

	public static AreaSoap[] toSoapModels(Area[] models) {
		AreaSoap[] soapModels = new AreaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AreaSoap[][] toSoapModels(Area[][] models) {
		AreaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AreaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AreaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AreaSoap[] toSoapModels(List<Area> models) {
		List<AreaSoap> soapModels = new ArrayList<AreaSoap>(models.size());

		for (Area model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AreaSoap[soapModels.size()]);
	}

	public AreaSoap() {
	}

	public String getPrimaryKey() {
		return _areaId;
	}

	public void setPrimaryKey(String pk) {
		setAreaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getAreaId() {
		return _areaId;
	}

	public void setAreaId(String areaId) {
		_areaId = areaId;
	}

	public String getAreaName() {
		return _areaName;
	}

	public void setAreaName(String areaName) {
		_areaName = areaName;
	}

	public String getAssServiceId() {
		return _assServiceId;
	}

	public void setAssServiceId(String assServiceId) {
		_assServiceId = assServiceId;
	}

	private String _uuid;
	private String _areaId;
	private String _areaName;
	private String _assServiceId;
}