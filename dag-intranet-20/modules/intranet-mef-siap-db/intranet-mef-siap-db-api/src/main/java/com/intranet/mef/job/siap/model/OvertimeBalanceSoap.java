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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.OvertimeBalanceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.OvertimeBalanceServiceSoap
 * @generated
 */
@ProviderType
public class OvertimeBalanceSoap implements Serializable {
	public static OvertimeBalanceSoap toSoapModel(OvertimeBalance model) {
		OvertimeBalanceSoap soapModel = new OvertimeBalanceSoap();

		soapModel.setOvertimeMonthCurrRif(model.getOvertimeMonthCurrRif());
		soapModel.setPersonId(model.getPersonId());
		soapModel.setOvertimeBalHourCurMonth(model.getOvertimeBalHourCurMonth());
		soapModel.setOvertimeBalacePrevMonth(model.getOvertimeBalacePrevMonth());

		return soapModel;
	}

	public static OvertimeBalanceSoap[] toSoapModels(OvertimeBalance[] models) {
		OvertimeBalanceSoap[] soapModels = new OvertimeBalanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OvertimeBalanceSoap[][] toSoapModels(
		OvertimeBalance[][] models) {
		OvertimeBalanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OvertimeBalanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OvertimeBalanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OvertimeBalanceSoap[] toSoapModels(
		List<OvertimeBalance> models) {
		List<OvertimeBalanceSoap> soapModels = new ArrayList<OvertimeBalanceSoap>(models.size());

		for (OvertimeBalance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OvertimeBalanceSoap[soapModels.size()]);
	}

	public OvertimeBalanceSoap() {
	}

	public long getPrimaryKey() {
		return _personId;
	}

	public void setPrimaryKey(long pk) {
		setPersonId(pk);
	}

	public String getOvertimeMonthCurrRif() {
		return _overtimeMonthCurrRif;
	}

	public void setOvertimeMonthCurrRif(String overtimeMonthCurrRif) {
		_overtimeMonthCurrRif = overtimeMonthCurrRif;
	}

	public long getPersonId() {
		return _personId;
	}

	public void setPersonId(long personId) {
		_personId = personId;
	}

	public int getOvertimeBalHourCurMonth() {
		return _overtimeBalHourCurMonth;
	}

	public void setOvertimeBalHourCurMonth(int overtimeBalHourCurMonth) {
		_overtimeBalHourCurMonth = overtimeBalHourCurMonth;
	}

	public int getOvertimeBalacePrevMonth() {
		return _overtimeBalacePrevMonth;
	}

	public void setOvertimeBalacePrevMonth(int overtimeBalacePrevMonth) {
		_overtimeBalacePrevMonth = overtimeBalacePrevMonth;
	}

	private String _overtimeMonthCurrRif;
	private long _personId;
	private int _overtimeBalHourCurMonth;
	private int _overtimeBalacePrevMonth;
}