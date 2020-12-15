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

package autorizzazione.dir.mef.model;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.service.persistence.ScrivaniaPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link autorizzazione.dir.mef.service.http.ScrivaniaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see autorizzazione.dir.mef.service.http.ScrivaniaServiceSoap
 * @generated
 */
@ProviderType
public class ScrivaniaSoap implements Serializable {
	public static ScrivaniaSoap toSoapModel(Scrivania model) {
		ScrivaniaSoap soapModel = new ScrivaniaSoap();

		soapModel.setRowId(model.getRowId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setApplicationId(model.getApplicationId());
		soapModel.setHomeFlag(model.getHomeFlag());
		soapModel.setProfileFlag(model.getProfileFlag());

		return soapModel;
	}

	public static ScrivaniaSoap[] toSoapModels(Scrivania[] models) {
		ScrivaniaSoap[] soapModels = new ScrivaniaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScrivaniaSoap[][] toSoapModels(Scrivania[][] models) {
		ScrivaniaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScrivaniaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScrivaniaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScrivaniaSoap[] toSoapModels(List<Scrivania> models) {
		List<ScrivaniaSoap> soapModels = new ArrayList<ScrivaniaSoap>(models.size());

		for (Scrivania model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScrivaniaSoap[soapModels.size()]);
	}

	public ScrivaniaSoap() {
	}

	public ScrivaniaPK getPrimaryKey() {
		return new ScrivaniaPK(_userId, _applicationId);
	}

	public void setPrimaryKey(ScrivaniaPK pk) {
		setUserId(pk.userId);
		setApplicationId(pk.applicationId);
	}

	public long getRowId() {
		return _rowId;
	}

	public void setRowId(long rowId) {
		_rowId = rowId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getApplicationId() {
		return _applicationId;
	}

	public void setApplicationId(long applicationId) {
		_applicationId = applicationId;
	}

	public boolean getHomeFlag() {
		return _homeFlag;
	}

	public boolean isHomeFlag() {
		return _homeFlag;
	}

	public void setHomeFlag(boolean homeFlag) {
		_homeFlag = homeFlag;
	}

	public boolean getProfileFlag() {
		return _profileFlag;
	}

	public boolean isProfileFlag() {
		return _profileFlag;
	}

	public void setProfileFlag(boolean profileFlag) {
		_profileFlag = profileFlag;
	}

	private long _rowId;
	private Date _createDate;
	private long _userId;
	private long _applicationId;
	private boolean _homeFlag;
	private boolean _profileFlag;
}