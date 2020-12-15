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
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.ClassificationLevelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.ClassificationLevelServiceSoap
 * @generated
 */
@ProviderType
public class ClassificationLevelSoap implements Serializable {
	public static ClassificationLevelSoap toSoapModel(ClassificationLevel model) {
		ClassificationLevelSoap soapModel = new ClassificationLevelSoap();

		soapModel.setLevelID(model.getLevelID());
		soapModel.setCodLegalPos(model.getCodLegalPos());
		soapModel.setDescLegalPos(model.getDescLegalPos());
		soapModel.setCodEconomicPos(model.getCodEconomicPos());
		soapModel.setDescEconomicPos(model.getDescEconomicPos());
		soapModel.setArea(model.getArea());

		return soapModel;
	}

	public static ClassificationLevelSoap[] toSoapModels(
		ClassificationLevel[] models) {
		ClassificationLevelSoap[] soapModels = new ClassificationLevelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClassificationLevelSoap[][] toSoapModels(
		ClassificationLevel[][] models) {
		ClassificationLevelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClassificationLevelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClassificationLevelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClassificationLevelSoap[] toSoapModels(
		List<ClassificationLevel> models) {
		List<ClassificationLevelSoap> soapModels = new ArrayList<ClassificationLevelSoap>(models.size());

		for (ClassificationLevel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClassificationLevelSoap[soapModels.size()]);
	}

	public ClassificationLevelSoap() {
	}

	public long getPrimaryKey() {
		return _levelID;
	}

	public void setPrimaryKey(long pk) {
		setLevelID(pk);
	}

	public long getLevelID() {
		return _levelID;
	}

	public void setLevelID(long levelID) {
		_levelID = levelID;
	}

	public String getCodLegalPos() {
		return _codLegalPos;
	}

	public void setCodLegalPos(String codLegalPos) {
		_codLegalPos = codLegalPos;
	}

	public String getDescLegalPos() {
		return _descLegalPos;
	}

	public void setDescLegalPos(String descLegalPos) {
		_descLegalPos = descLegalPos;
	}

	public String getCodEconomicPos() {
		return _codEconomicPos;
	}

	public void setCodEconomicPos(String codEconomicPos) {
		_codEconomicPos = codEconomicPos;
	}

	public String getDescEconomicPos() {
		return _descEconomicPos;
	}

	public void setDescEconomicPos(String descEconomicPos) {
		_descEconomicPos = descEconomicPos;
	}

	public String getArea() {
		return _area;
	}

	public void setArea(String area) {
		_area = area;
	}

	private long _levelID;
	private String _codLegalPos;
	private String _descLegalPos;
	private String _codEconomicPos;
	private String _descEconomicPos;
	private String _area;
}