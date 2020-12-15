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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Topic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Topic
 * @generated
 */
@ProviderType
public class TopicWrapper implements Topic, ModelWrapper<Topic> {
	public TopicWrapper(Topic topic) {
		_topic = topic;
	}

	@Override
	public Class<?> getModelClass() {
		return Topic.class;
	}

	@Override
	public String getModelClassName() {
		return Topic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("topicId", getTopicId());
		attributes.put("topicName", getTopicName());
		attributes.put("areaId", getAreaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String topicId = (String)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
		}

		String topicName = (String)attributes.get("topicName");

		if (topicName != null) {
			setTopicName(topicName);
		}

		String areaId = (String)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}
	}

	@Override
	public Topic toEscapedModel() {
		return new TopicWrapper(_topic.toEscapedModel());
	}

	@Override
	public Topic toUnescapedModel() {
		return new TopicWrapper(_topic.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _topic.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _topic.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _topic.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _topic.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Topic> toCacheModel() {
		return _topic.toCacheModel();
	}

	@Override
	public int compareTo(Topic topic) {
		return _topic.compareTo(topic);
	}

	@Override
	public int hashCode() {
		return _topic.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _topic.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TopicWrapper((Topic)_topic.clone());
	}

	/**
	* Returns the area ID of this topic.
	*
	* @return the area ID of this topic
	*/
	@Override
	public java.lang.String getAreaId() {
		return _topic.getAreaId();
	}

	/**
	* Returns the primary key of this topic.
	*
	* @return the primary key of this topic
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _topic.getPrimaryKey();
	}

	/**
	* Returns the topic ID of this topic.
	*
	* @return the topic ID of this topic
	*/
	@Override
	public java.lang.String getTopicId() {
		return _topic.getTopicId();
	}

	/**
	* Returns the topic name of this topic.
	*
	* @return the topic name of this topic
	*/
	@Override
	public java.lang.String getTopicName() {
		return _topic.getTopicName();
	}

	/**
	* Returns the uuid of this topic.
	*
	* @return the uuid of this topic
	*/
	@Override
	public java.lang.String getUuid() {
		return _topic.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _topic.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _topic.toXmlString();
	}

	@Override
	public void persist() {
		_topic.persist();
	}

	/**
	* Sets the area ID of this topic.
	*
	* @param areaId the area ID of this topic
	*/
	@Override
	public void setAreaId(java.lang.String areaId) {
		_topic.setAreaId(areaId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_topic.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_topic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_topic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_topic.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_topic.setNew(n);
	}

	/**
	* Sets the primary key of this topic.
	*
	* @param primaryKey the primary key of this topic
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_topic.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_topic.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the topic ID of this topic.
	*
	* @param topicId the topic ID of this topic
	*/
	@Override
	public void setTopicId(java.lang.String topicId) {
		_topic.setTopicId(topicId);
	}

	/**
	* Sets the topic name of this topic.
	*
	* @param topicName the topic name of this topic
	*/
	@Override
	public void setTopicName(java.lang.String topicName) {
		_topic.setTopicName(topicName);
	}

	/**
	* Sets the uuid of this topic.
	*
	* @param uuid the uuid of this topic
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_topic.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicWrapper)) {
			return false;
		}

		TopicWrapper topicWrapper = (TopicWrapper)obj;

		if (Objects.equals(_topic, topicWrapper._topic)) {
			return true;
		}

		return false;
	}

	@Override
	public Topic getWrappedModel() {
		return _topic;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _topic.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _topic.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_topic.resetOriginalValues();
	}

	private final Topic _topic;
}