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

package com.intranet.mef.daily.punching.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.daily.punching.service.http.DailyPunchingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.daily.punching.service.http.DailyPunchingServiceSoap
 * @generated
 */
@ProviderType
public class DailyPunchingSoap implements Serializable {
	public static DailyPunchingSoap toSoapModel(DailyPunching model) {
		DailyPunchingSoap soapModel = new DailyPunchingSoap();

		soapModel.setCustom_key(model.getCustom_key());
		soapModel.setPersonId(model.getPersonId());
		soapModel.setPunchingId(model.getPunchingId());
		soapModel.setDirection(model.getDirection());
		soapModel.setVoucher(model.getVoucher());
		soapModel.setTerminal(model.getTerminal());
		soapModel.setHours(model.getHours());
		soapModel.setMinute(model.getMinute());

		return soapModel;
	}

	public static DailyPunchingSoap[] toSoapModels(DailyPunching[] models) {
		DailyPunchingSoap[] soapModels = new DailyPunchingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DailyPunchingSoap[][] toSoapModels(DailyPunching[][] models) {
		DailyPunchingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DailyPunchingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DailyPunchingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DailyPunchingSoap[] toSoapModels(List<DailyPunching> models) {
		List<DailyPunchingSoap> soapModels = new ArrayList<DailyPunchingSoap>(models.size());

		for (DailyPunching model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DailyPunchingSoap[soapModels.size()]);
	}

	public DailyPunchingSoap() {
	}

	public String getPrimaryKey() {
		return _custom_key;
	}

	public void setPrimaryKey(String pk) {
		setCustom_key(pk);
	}

	public String getCustom_key() {
		return _custom_key;
	}

	public void setCustom_key(String custom_key) {
		_custom_key = custom_key;
	}

	public long getPersonId() {
		return _personId;
	}

	public void setPersonId(long personId) {
		_personId = personId;
	}

	public int getPunchingId() {
		return _punchingId;
	}

	public void setPunchingId(int punchingId) {
		_punchingId = punchingId;
	}

	public String getDirection() {
		return _direction;
	}

	public void setDirection(String direction) {
		_direction = direction;
	}

	public String getVoucher() {
		return _voucher;
	}

	public void setVoucher(String voucher) {
		_voucher = voucher;
	}

	public String getTerminal() {
		return _terminal;
	}

	public void setTerminal(String terminal) {
		_terminal = terminal;
	}

	public int getHours() {
		return _hours;
	}

	public void setHours(int hours) {
		_hours = hours;
	}

	public String getMinute() {
		return _minute;
	}

	public void setMinute(String minute) {
		_minute = minute;
	}

	private String _custom_key;
	private long _personId;
	private int _punchingId;
	private String _direction;
	private String _voucher;
	private String _terminal;
	private int _hours;
	private String _minute;
}