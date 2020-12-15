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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.FestivityServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.FestivityServiceSoap
 * @generated
 */
@ProviderType
public class FestivitySoap implements Serializable {
	public static FestivitySoap toSoapModel(Festivity model) {
		FestivitySoap soapModel = new FestivitySoap();

		soapModel.setPersonId(model.getPersonId());
		soapModel.setFestivityDueCurrYear(model.getFestivityDueCurrYear());
		soapModel.setFestivitySpentCurrYear(model.getFestivitySpentCurrYear());
		soapModel.setFestivityRemainCurrYear(model.getFestivityRemainCurrYear());

		return soapModel;
	}

	public static FestivitySoap[] toSoapModels(Festivity[] models) {
		FestivitySoap[] soapModels = new FestivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FestivitySoap[][] toSoapModels(Festivity[][] models) {
		FestivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FestivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FestivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FestivitySoap[] toSoapModels(List<Festivity> models) {
		List<FestivitySoap> soapModels = new ArrayList<FestivitySoap>(models.size());

		for (Festivity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FestivitySoap[soapModels.size()]);
	}

	public FestivitySoap() {
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

	public int getFestivityDueCurrYear() {
		return _festivityDueCurrYear;
	}

	public void setFestivityDueCurrYear(int festivityDueCurrYear) {
		_festivityDueCurrYear = festivityDueCurrYear;
	}

	public int getFestivitySpentCurrYear() {
		return _festivitySpentCurrYear;
	}

	public void setFestivitySpentCurrYear(int festivitySpentCurrYear) {
		_festivitySpentCurrYear = festivitySpentCurrYear;
	}

	public int getFestivityRemainCurrYear() {
		return _festivityRemainCurrYear;
	}

	public void setFestivityRemainCurrYear(int festivityRemainCurrYear) {
		_festivityRemainCurrYear = festivityRemainCurrYear;
	}

	private long _personId;
	private int _festivityDueCurrYear;
	private int _festivitySpentCurrYear;
	private int _festivityRemainCurrYear;
}