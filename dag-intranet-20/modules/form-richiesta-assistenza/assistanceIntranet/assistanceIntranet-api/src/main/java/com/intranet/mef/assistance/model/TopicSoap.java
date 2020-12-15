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
public class TopicSoap implements Serializable {
	public static TopicSoap toSoapModel(Topic model) {
		TopicSoap soapModel = new TopicSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTopicId(model.getTopicId());
		soapModel.setTopicName(model.getTopicName());
		soapModel.setAreaId(model.getAreaId());

		return soapModel;
	}

	public static TopicSoap[] toSoapModels(Topic[] models) {
		TopicSoap[] soapModels = new TopicSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TopicSoap[][] toSoapModels(Topic[][] models) {
		TopicSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TopicSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TopicSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TopicSoap[] toSoapModels(List<Topic> models) {
		List<TopicSoap> soapModels = new ArrayList<TopicSoap>(models.size());

		for (Topic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TopicSoap[soapModels.size()]);
	}

	public TopicSoap() {
	}

	public String getPrimaryKey() {
		return _topicId;
	}

	public void setPrimaryKey(String pk) {
		setTopicId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getTopicId() {
		return _topicId;
	}

	public void setTopicId(String topicId) {
		_topicId = topicId;
	}

	public String getTopicName() {
		return _topicName;
	}

	public void setTopicName(String topicName) {
		_topicName = topicName;
	}

	public String getAreaId() {
		return _areaId;
	}

	public void setAreaId(String areaId) {
		_areaId = areaId;
	}

	private String _uuid;
	private String _topicId;
	private String _topicName;
	private String _areaId;
}