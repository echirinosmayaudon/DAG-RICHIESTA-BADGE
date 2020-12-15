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

package com.intranet.mef.job.siap.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.UserPositionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.UserPositionServiceSoap
 * @generated
 */
@ProviderType
public class UserPositionSoap implements Serializable {
	public static UserPositionSoap toSoapModel(UserPosition model) {
		UserPositionSoap soapModel = new UserPositionSoap();

		soapModel.setPos(model.getPos());
		soapModel.setRuoloGiuridico(model.getRuoloGiuridico());
		soapModel.setRuoloEconomico(model.getRuoloEconomico());

		return soapModel;
	}

	public static UserPositionSoap[] toSoapModels(UserPosition[] models) {
		UserPositionSoap[] soapModels = new UserPositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserPositionSoap[][] toSoapModels(UserPosition[][] models) {
		UserPositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserPositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserPositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserPositionSoap[] toSoapModels(List<UserPosition> models) {
		List<UserPositionSoap> soapModels = new ArrayList<UserPositionSoap>(models.size());

		for (UserPosition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserPositionSoap[soapModels.size()]);
	}

	public UserPositionSoap() {
	}

	public String getPrimaryKey() {
		return _pos;
	}

	public void setPrimaryKey(String pk) {
		setPos(pk);
	}

	public String getPos() {
		return _pos;
	}

	public void setPos(String pos) {
		_pos = pos;
	}

	public String getRuoloGiuridico() {
		return _ruoloGiuridico;
	}

	public void setRuoloGiuridico(String ruoloGiuridico) {
		_ruoloGiuridico = ruoloGiuridico;
	}

	public String getRuoloEconomico() {
		return _ruoloEconomico;
	}

	public void setRuoloEconomico(String ruoloEconomico) {
		_ruoloEconomico = ruoloEconomico;
	}

	private String _pos;
	private String _ruoloGiuridico;
	private String _ruoloEconomico;
}