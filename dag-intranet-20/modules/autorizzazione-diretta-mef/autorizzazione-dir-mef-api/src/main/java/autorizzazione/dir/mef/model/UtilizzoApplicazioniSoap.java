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

import autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link autorizzazione.dir.mef.service.http.UtilizzoApplicazioniServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see autorizzazione.dir.mef.service.http.UtilizzoApplicazioniServiceSoap
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniSoap implements Serializable {
	public static UtilizzoApplicazioniSoap toSoapModel(
		UtilizzoApplicazioni model) {
		UtilizzoApplicazioniSoap soapModel = new UtilizzoApplicazioniSoap();

		soapModel.setRowId(model.getRowId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setApplicationId(model.getApplicationId());
		soapModel.setLastUseDate(model.getLastUseDate());
		soapModel.setHitsCount(model.getHitsCount());

		return soapModel;
	}

	public static UtilizzoApplicazioniSoap[] toSoapModels(
		UtilizzoApplicazioni[] models) {
		UtilizzoApplicazioniSoap[] soapModels = new UtilizzoApplicazioniSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UtilizzoApplicazioniSoap[][] toSoapModels(
		UtilizzoApplicazioni[][] models) {
		UtilizzoApplicazioniSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UtilizzoApplicazioniSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UtilizzoApplicazioniSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UtilizzoApplicazioniSoap[] toSoapModels(
		List<UtilizzoApplicazioni> models) {
		List<UtilizzoApplicazioniSoap> soapModels = new ArrayList<UtilizzoApplicazioniSoap>(models.size());

		for (UtilizzoApplicazioni model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UtilizzoApplicazioniSoap[soapModels.size()]);
	}

	public UtilizzoApplicazioniSoap() {
	}

	public UtilizzoApplicazioniPK getPrimaryKey() {
		return new UtilizzoApplicazioniPK(_userId, _applicationId);
	}

	public void setPrimaryKey(UtilizzoApplicazioniPK pk) {
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

	public Date getLastUseDate() {
		return _lastUseDate;
	}

	public void setLastUseDate(Date lastUseDate) {
		_lastUseDate = lastUseDate;
	}

	public int getHitsCount() {
		return _hitsCount;
	}

	public void setHitsCount(int hitsCount) {
		_hitsCount = hitsCount;
	}

	private long _rowId;
	private Date _createDate;
	private long _userId;
	private long _applicationId;
	private Date _lastUseDate;
	private int _hitsCount;
}