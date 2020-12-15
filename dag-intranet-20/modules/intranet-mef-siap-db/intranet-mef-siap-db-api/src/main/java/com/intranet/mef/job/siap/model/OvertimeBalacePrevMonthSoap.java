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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.OvertimeBalacePrevMonthServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.OvertimeBalacePrevMonthServiceSoap
 * @generated
 */
@ProviderType
public class OvertimeBalacePrevMonthSoap implements Serializable {
	public static OvertimeBalacePrevMonthSoap toSoapModel(
		OvertimeBalacePrevMonth model) {
		OvertimeBalacePrevMonthSoap soapModel = new OvertimeBalacePrevMonthSoap();

		soapModel.setPersonId(model.getPersonId());
		soapModel.setOvertimeDueCurrMonth(model.getOvertimeDueCurrMonth());
		soapModel.setOvertimeMonthPrevRif(model.getOvertimeMonthPrevRif());

		return soapModel;
	}

	public static OvertimeBalacePrevMonthSoap[] toSoapModels(
		OvertimeBalacePrevMonth[] models) {
		OvertimeBalacePrevMonthSoap[] soapModels = new OvertimeBalacePrevMonthSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OvertimeBalacePrevMonthSoap[][] toSoapModels(
		OvertimeBalacePrevMonth[][] models) {
		OvertimeBalacePrevMonthSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OvertimeBalacePrevMonthSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OvertimeBalacePrevMonthSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OvertimeBalacePrevMonthSoap[] toSoapModels(
		List<OvertimeBalacePrevMonth> models) {
		List<OvertimeBalacePrevMonthSoap> soapModels = new ArrayList<OvertimeBalacePrevMonthSoap>(models.size());

		for (OvertimeBalacePrevMonth model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OvertimeBalacePrevMonthSoap[soapModels.size()]);
	}

	public OvertimeBalacePrevMonthSoap() {
	}

	public long getPrimaryKey() {
		return _personId;
	}

	public void setPrimaryKey(long pk) {
		setPersonId(pk);
	}

	public long getPersonId() {
		return _personId;
	}

	public void setPersonId(long personId) {
		_personId = personId;
	}

	public int getOvertimeDueCurrMonth() {
		return _overtimeDueCurrMonth;
	}

	public void setOvertimeDueCurrMonth(int overtimeDueCurrMonth) {
		_overtimeDueCurrMonth = overtimeDueCurrMonth;
	}

	public String getOvertimeMonthPrevRif() {
		return _overtimeMonthPrevRif;
	}

	public void setOvertimeMonthPrevRif(String overtimeMonthPrevRif) {
		_overtimeMonthPrevRif = overtimeMonthPrevRif;
	}

	private long _personId;
	private int _overtimeDueCurrMonth;
	private String _overtimeMonthPrevRif;
}