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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.CurrentBalanceHoursServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.CurrentBalanceHoursServiceSoap
 * @generated
 */
@ProviderType
public class CurrentBalanceHoursSoap implements Serializable {
	public static CurrentBalanceHoursSoap toSoapModel(CurrentBalanceHours model) {
		CurrentBalanceHoursSoap soapModel = new CurrentBalanceHoursSoap();

		soapModel.setPersonId(model.getPersonId());
		soapModel.setBalanceHoursCurDate(model.getBalanceHoursCurDate());
		soapModel.setBalanceHours(model.getBalanceHours());

		return soapModel;
	}

	public static CurrentBalanceHoursSoap[] toSoapModels(
		CurrentBalanceHours[] models) {
		CurrentBalanceHoursSoap[] soapModels = new CurrentBalanceHoursSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CurrentBalanceHoursSoap[][] toSoapModels(
		CurrentBalanceHours[][] models) {
		CurrentBalanceHoursSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CurrentBalanceHoursSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CurrentBalanceHoursSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CurrentBalanceHoursSoap[] toSoapModels(
		List<CurrentBalanceHours> models) {
		List<CurrentBalanceHoursSoap> soapModels = new ArrayList<CurrentBalanceHoursSoap>(models.size());

		for (CurrentBalanceHours model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CurrentBalanceHoursSoap[soapModels.size()]);
	}

	public CurrentBalanceHoursSoap() {
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

	public Date getBalanceHoursCurDate() {
		return _balanceHoursCurDate;
	}

	public void setBalanceHoursCurDate(Date balanceHoursCurDate) {
		_balanceHoursCurDate = balanceHoursCurDate;
	}

	public int getBalanceHours() {
		return _balanceHours;
	}

	public void setBalanceHours(int balanceHours) {
		_balanceHours = balanceHours;
	}

	private long _personId;
	private Date _balanceHoursCurDate;
	private int _balanceHours;
}