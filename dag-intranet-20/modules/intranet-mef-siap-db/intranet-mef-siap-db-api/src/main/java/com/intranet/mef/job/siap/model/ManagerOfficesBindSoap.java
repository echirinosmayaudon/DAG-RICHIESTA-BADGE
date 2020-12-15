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

import com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.ManagerOfficesBindServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.ManagerOfficesBindServiceSoap
 * @generated
 */
@ProviderType
public class ManagerOfficesBindSoap implements Serializable {
	public static ManagerOfficesBindSoap toSoapModel(ManagerOfficesBind model) {
		ManagerOfficesBindSoap soapModel = new ManagerOfficesBindSoap();

		soapModel.setPersonalId(model.getPersonalId());
		soapModel.setIdOrgChart(model.getIdOrgChart());
		soapModel.setPrimary(model.getPrimary());
		soapModel.setRegency(model.getRegency());

		return soapModel;
	}

	public static ManagerOfficesBindSoap[] toSoapModels(
		ManagerOfficesBind[] models) {
		ManagerOfficesBindSoap[] soapModels = new ManagerOfficesBindSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ManagerOfficesBindSoap[][] toSoapModels(
		ManagerOfficesBind[][] models) {
		ManagerOfficesBindSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ManagerOfficesBindSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ManagerOfficesBindSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ManagerOfficesBindSoap[] toSoapModels(
		List<ManagerOfficesBind> models) {
		List<ManagerOfficesBindSoap> soapModels = new ArrayList<ManagerOfficesBindSoap>(models.size());

		for (ManagerOfficesBind model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ManagerOfficesBindSoap[soapModels.size()]);
	}

	public ManagerOfficesBindSoap() {
	}

	public ManagerOfficesBindPK getPrimaryKey() {
		return new ManagerOfficesBindPK(_personalId, _idOrgChart);
	}

	public void setPrimaryKey(ManagerOfficesBindPK pk) {
		setPersonalId(pk.personalId);
		setIdOrgChart(pk.idOrgChart);
	}

	public long getPersonalId() {
		return _personalId;
	}

	public void setPersonalId(long personalId) {
		_personalId = personalId;
	}

	public long getIdOrgChart() {
		return _idOrgChart;
	}

	public void setIdOrgChart(long idOrgChart) {
		_idOrgChart = idOrgChart;
	}

	public String getPrimary() {
		return _primary;
	}

	public void setPrimary(String primary) {
		_primary = primary;
	}

	public String getRegency() {
		return _regency;
	}

	public void setRegency(String regency) {
		_regency = regency;
	}

	private long _personalId;
	private long _idOrgChart;
	private String _primary;
	private String _regency;
}