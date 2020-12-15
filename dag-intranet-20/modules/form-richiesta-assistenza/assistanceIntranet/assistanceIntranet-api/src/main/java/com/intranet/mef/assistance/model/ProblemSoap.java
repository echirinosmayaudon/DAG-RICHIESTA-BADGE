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

package com.intranet.mef.assistance.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProblemSoap implements Serializable {
	public static ProblemSoap toSoapModel(Problem model) {
		ProblemSoap soapModel = new ProblemSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProblemId(model.getProblemId());
		soapModel.setProblemName(model.getProblemName());
		soapModel.setTopicId(model.getTopicId());

		return soapModel;
	}

	public static ProblemSoap[] toSoapModels(Problem[] models) {
		ProblemSoap[] soapModels = new ProblemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProblemSoap[][] toSoapModels(Problem[][] models) {
		ProblemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProblemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProblemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProblemSoap[] toSoapModels(List<Problem> models) {
		List<ProblemSoap> soapModels = new ArrayList<ProblemSoap>(models.size());

		for (Problem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProblemSoap[soapModels.size()]);
	}

	public ProblemSoap() {
	}

	public String getPrimaryKey() {
		return _problemId;
	}

	public void setPrimaryKey(String pk) {
		setProblemId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getProblemId() {
		return _problemId;
	}

	public void setProblemId(String problemId) {
		_problemId = problemId;
	}

	public String getProblemName() {
		return _problemName;
	}

	public void setProblemName(String problemName) {
		_problemName = problemName;
	}

	public String getTopicId() {
		return _topicId;
	}

	public void setTopicId(String topicId) {
		_topicId = topicId;
	}

	private String _uuid;
	private String _problemId;
	private String _problemName;
	private String _topicId;
}