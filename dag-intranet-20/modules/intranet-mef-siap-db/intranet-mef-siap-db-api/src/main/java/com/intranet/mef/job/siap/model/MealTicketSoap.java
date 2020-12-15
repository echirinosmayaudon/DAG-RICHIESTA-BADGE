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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.MealTicketServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.MealTicketServiceSoap
 * @generated
 */
@ProviderType
public class MealTicketSoap implements Serializable {
	public static MealTicketSoap toSoapModel(MealTicket model) {
		MealTicketSoap soapModel = new MealTicketSoap();

		soapModel.setCustom_key(model.getCustom_key());
		soapModel.setPersonID(model.getPersonID());
		soapModel.setMonth(model.getMonth());
		soapModel.setDueMeal(model.getDueMeal());

		return soapModel;
	}

	public static MealTicketSoap[] toSoapModels(MealTicket[] models) {
		MealTicketSoap[] soapModels = new MealTicketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MealTicketSoap[][] toSoapModels(MealTicket[][] models) {
		MealTicketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MealTicketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MealTicketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MealTicketSoap[] toSoapModels(List<MealTicket> models) {
		List<MealTicketSoap> soapModels = new ArrayList<MealTicketSoap>(models.size());

		for (MealTicket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MealTicketSoap[soapModels.size()]);
	}

	public MealTicketSoap() {
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

	public long getPersonID() {
		return _personID;
	}

	public void setPersonID(long personID) {
		_personID = personID;
	}

	public String getMonth() {
		return _month;
	}

	public void setMonth(String month) {
		_month = month;
	}

	public int getDueMeal() {
		return _dueMeal;
	}

	public void setDueMeal(int dueMeal) {
		_dueMeal = dueMeal;
	}

	private String _custom_key;
	private long _personID;
	private String _month;
	private int _dueMeal;
}