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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.OvertimePrevMonthPayOffServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.OvertimePrevMonthPayOffServiceSoap
 * @generated
 */
@ProviderType
public class OvertimePrevMonthPayOffSoap implements Serializable {
	public static OvertimePrevMonthPayOffSoap toSoapModel(
		OvertimePrevMonthPayOff model) {
		OvertimePrevMonthPayOffSoap soapModel = new OvertimePrevMonthPayOffSoap();

		soapModel.setPersonId(model.getPersonId());
		soapModel.setOvertimeHoursCurrPayOff(model.getOvertimeHoursCurrPayOff());

		return soapModel;
	}

	public static OvertimePrevMonthPayOffSoap[] toSoapModels(
		OvertimePrevMonthPayOff[] models) {
		OvertimePrevMonthPayOffSoap[] soapModels = new OvertimePrevMonthPayOffSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OvertimePrevMonthPayOffSoap[][] toSoapModels(
		OvertimePrevMonthPayOff[][] models) {
		OvertimePrevMonthPayOffSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OvertimePrevMonthPayOffSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OvertimePrevMonthPayOffSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OvertimePrevMonthPayOffSoap[] toSoapModels(
		List<OvertimePrevMonthPayOff> models) {
		List<OvertimePrevMonthPayOffSoap> soapModels = new ArrayList<OvertimePrevMonthPayOffSoap>(models.size());

		for (OvertimePrevMonthPayOff model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OvertimePrevMonthPayOffSoap[soapModels.size()]);
	}

	public OvertimePrevMonthPayOffSoap() {
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

	public int getOvertimeHoursCurrPayOff() {
		return _overtimeHoursCurrPayOff;
	}

	public void setOvertimeHoursCurrPayOff(int overtimeHoursCurrPayOff) {
		_overtimeHoursCurrPayOff = overtimeHoursCurrPayOff;
	}

	private long _personId;
	private int _overtimeHoursCurrPayOff;
}