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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.VacationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.VacationServiceSoap
 * @generated
 */
@ProviderType
public class VacationSoap implements Serializable {
	public static VacationSoap toSoapModel(Vacation model) {
		VacationSoap soapModel = new VacationSoap();

		soapModel.setPersonId(model.getPersonId());
		soapModel.setVacationCurrYear(model.getVacationCurrYear());
		soapModel.setVacationPrevYear(model.getVacationPrevYear());
		soapModel.setVacationSpent(model.getVacationSpent());
		soapModel.setVacationRemaining(model.getVacationRemaining());

		return soapModel;
	}

	public static VacationSoap[] toSoapModels(Vacation[] models) {
		VacationSoap[] soapModels = new VacationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VacationSoap[][] toSoapModels(Vacation[][] models) {
		VacationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VacationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VacationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VacationSoap[] toSoapModels(List<Vacation> models) {
		List<VacationSoap> soapModels = new ArrayList<VacationSoap>(models.size());

		for (Vacation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VacationSoap[soapModels.size()]);
	}

	public VacationSoap() {
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

	public int getVacationCurrYear() {
		return _vacationCurrYear;
	}

	public void setVacationCurrYear(int vacationCurrYear) {
		_vacationCurrYear = vacationCurrYear;
	}

	public int getVacationPrevYear() {
		return _vacationPrevYear;
	}

	public void setVacationPrevYear(int vacationPrevYear) {
		_vacationPrevYear = vacationPrevYear;
	}

	public int getVacationSpent() {
		return _vacationSpent;
	}

	public void setVacationSpent(int vacationSpent) {
		_vacationSpent = vacationSpent;
	}

	public int getVacationRemaining() {
		return _vacationRemaining;
	}

	public void setVacationRemaining(int vacationRemaining) {
		_vacationRemaining = vacationRemaining;
	}

	private long _personId;
	private int _vacationCurrYear;
	private int _vacationPrevYear;
	private int _vacationSpent;
	private int _vacationRemaining;
}