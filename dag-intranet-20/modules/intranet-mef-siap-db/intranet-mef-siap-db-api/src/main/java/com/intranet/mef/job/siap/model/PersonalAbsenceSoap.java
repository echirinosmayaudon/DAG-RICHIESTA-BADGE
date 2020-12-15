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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.PersonalAbsenceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.PersonalAbsenceServiceSoap
 * @generated
 */
@ProviderType
public class PersonalAbsenceSoap implements Serializable {
	public static PersonalAbsenceSoap toSoapModel(PersonalAbsence model) {
		PersonalAbsenceSoap soapModel = new PersonalAbsenceSoap();

		soapModel.setCustom_key(model.getCustom_key());
		soapModel.setPersonId(model.getPersonId());
		soapModel.setAbsenceDate(model.getAbsenceDate());
		soapModel.setRefMonth(model.getRefMonth());
		soapModel.setAbsenceCode(model.getAbsenceCode());
		soapModel.setCompleteDay(model.getCompleteDay());
		soapModel.setFrom(model.getFrom());
		soapModel.setTo(model.getTo());
		soapModel.setHours(model.getHours());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static PersonalAbsenceSoap[] toSoapModels(PersonalAbsence[] models) {
		PersonalAbsenceSoap[] soapModels = new PersonalAbsenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonalAbsenceSoap[][] toSoapModels(
		PersonalAbsence[][] models) {
		PersonalAbsenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonalAbsenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonalAbsenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonalAbsenceSoap[] toSoapModels(
		List<PersonalAbsence> models) {
		List<PersonalAbsenceSoap> soapModels = new ArrayList<PersonalAbsenceSoap>(models.size());

		for (PersonalAbsence model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonalAbsenceSoap[soapModels.size()]);
	}

	public PersonalAbsenceSoap() {
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

	public Date getAbsenceDate() {
		return _absenceDate;
	}

	public void setAbsenceDate(Date absenceDate) {
		_absenceDate = absenceDate;
	}

	public String getRefMonth() {
		return _refMonth;
	}

	public void setRefMonth(String refMonth) {
		_refMonth = refMonth;
	}

	public String getAbsenceCode() {
		return _absenceCode;
	}

	public void setAbsenceCode(String absenceCode) {
		_absenceCode = absenceCode;
	}

	public String getCompleteDay() {
		return _completeDay;
	}

	public void setCompleteDay(String completeDay) {
		_completeDay = completeDay;
	}

	public int getFrom() {
		return _from;
	}

	public void setFrom(int from) {
		_from = from;
	}

	public int getTo() {
		return _to;
	}

	public void setTo(int to) {
		_to = to;
	}

	public int getHours() {
		return _hours;
	}

	public void setHours(int hours) {
		_hours = hours;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _custom_key;
	private long _personId;
	private Date _absenceDate;
	private String _refMonth;
	private String _absenceCode;
	private String _completeDay;
	private int _from;
	private int _to;
	private int _hours;
	private String _description;
}