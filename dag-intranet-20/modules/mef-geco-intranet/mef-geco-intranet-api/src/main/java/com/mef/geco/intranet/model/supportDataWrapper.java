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

package com.mef.geco.intranet.model;

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
 * This class is a wrapper for {@link supportData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see supportData
 * @generated
 */
@ProviderType
public class supportDataWrapper implements supportData,
	ModelWrapper<supportData> {
	public supportDataWrapper(supportData supportData) {
		_supportData = supportData;
	}

	@Override
	public Class<?> getModelClass() {
		return supportData.class;
	}

	@Override
	public String getModelClassName() {
		return supportData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _supportData.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _supportData.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _supportData.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _supportData.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.mef.geco.intranet.model.supportData> toCacheModel() {
		return _supportData.toCacheModel();
	}

	@Override
	public com.mef.geco.intranet.model.supportData toEscapedModel() {
		return new supportDataWrapper(_supportData.toEscapedModel());
	}

	@Override
	public com.mef.geco.intranet.model.supportData toUnescapedModel() {
		return new supportDataWrapper(_supportData.toUnescapedModel());
	}

	@Override
	public int compareTo(com.mef.geco.intranet.model.supportData supportData) {
		return _supportData.compareTo(supportData);
	}

	@Override
	public int hashCode() {
		return _supportData.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supportData.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new supportDataWrapper((supportData)_supportData.clone());
	}

	/**
	* Returns the data of this support data.
	*
	* @return the data of this support data
	*/
	@Override
	public java.lang.String getData() {
		return _supportData.getData();
	}

	/**
	* Returns the uuid of this support data.
	*
	* @return the uuid of this support data
	*/
	@Override
	public java.lang.String getUuid() {
		return _supportData.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _supportData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _supportData.toXmlString();
	}

	/**
	* Returns the ID of this support data.
	*
	* @return the ID of this support data
	*/
	@Override
	public long getId() {
		return _supportData.getId();
	}

	/**
	* Returns the primary key of this support data.
	*
	* @return the primary key of this support data
	*/
	@Override
	public long getPrimaryKey() {
		return _supportData.getPrimaryKey();
	}

	@Override
	public void persist() {
		_supportData.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_supportData.setCachedModel(cachedModel);
	}

	/**
	* Sets the data of this support data.
	*
	* @param data the data of this support data
	*/
	@Override
	public void setData(java.lang.String data) {
		_supportData.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_supportData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_supportData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_supportData.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this support data.
	*
	* @param id the ID of this support data
	*/
	@Override
	public void setId(long id) {
		_supportData.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_supportData.setNew(n);
	}

	/**
	* Sets the primary key of this support data.
	*
	* @param primaryKey the primary key of this support data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_supportData.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_supportData.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this support data.
	*
	* @param uuid the uuid of this support data
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_supportData.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof supportDataWrapper)) {
			return false;
		}

		supportDataWrapper supportDataWrapper = (supportDataWrapper)obj;

		if (Objects.equals(_supportData, supportDataWrapper._supportData)) {
			return true;
		}

		return false;
	}

	@Override
	public supportData getWrappedModel() {
		return _supportData;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _supportData.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _supportData.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_supportData.resetOriginalValues();
	}

	private final supportData _supportData;
}