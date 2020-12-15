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
 * This class is a wrapper for {@link Area}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
@ProviderType
public class AreaWrapper implements Area, ModelWrapper<Area> {
	public AreaWrapper(Area area) {
		_area = area;
	}

	@Override
	public Class<?> getModelClass() {
		return Area.class;
	}

	@Override
	public String getModelClassName() {
		return Area.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("areaId", getAreaId());
		attributes.put("areaName", getAreaName());
		attributes.put("assServiceId", getAssServiceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String areaId = (String)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}

		String areaName = (String)attributes.get("areaName");

		if (areaName != null) {
			setAreaName(areaName);
		}

		String assServiceId = (String)attributes.get("assServiceId");

		if (assServiceId != null) {
			setAssServiceId(assServiceId);
		}
	}

	@Override
	public Area toEscapedModel() {
		return new AreaWrapper(_area.toEscapedModel());
	}

	@Override
	public Area toUnescapedModel() {
		return new AreaWrapper(_area.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _area.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _area.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _area.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _area.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Area> toCacheModel() {
		return _area.toCacheModel();
	}

	@Override
	public int compareTo(Area area) {
		return _area.compareTo(area);
	}

	@Override
	public int hashCode() {
		return _area.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _area.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AreaWrapper((Area)_area.clone());
	}

	/**
	* Returns the area ID of this area.
	*
	* @return the area ID of this area
	*/
	@Override
	public java.lang.String getAreaId() {
		return _area.getAreaId();
	}

	/**
	* Returns the area name of this area.
	*
	* @return the area name of this area
	*/
	@Override
	public java.lang.String getAreaName() {
		return _area.getAreaName();
	}

	/**
	* Returns the ass service ID of this area.
	*
	* @return the ass service ID of this area
	*/
	@Override
	public java.lang.String getAssServiceId() {
		return _area.getAssServiceId();
	}

	/**
	* Returns the primary key of this area.
	*
	* @return the primary key of this area
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _area.getPrimaryKey();
	}

	/**
	* Returns the uuid of this area.
	*
	* @return the uuid of this area
	*/
	@Override
	public java.lang.String getUuid() {
		return _area.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _area.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _area.toXmlString();
	}

	@Override
	public void persist() {
		_area.persist();
	}

	/**
	* Sets the area ID of this area.
	*
	* @param areaId the area ID of this area
	*/
	@Override
	public void setAreaId(java.lang.String areaId) {
		_area.setAreaId(areaId);
	}

	/**
	* Sets the area name of this area.
	*
	* @param areaName the area name of this area
	*/
	@Override
	public void setAreaName(java.lang.String areaName) {
		_area.setAreaName(areaName);
	}

	/**
	* Sets the ass service ID of this area.
	*
	* @param assServiceId the ass service ID of this area
	*/
	@Override
	public void setAssServiceId(java.lang.String assServiceId) {
		_area.setAssServiceId(assServiceId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_area.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_area.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_area.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_area.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_area.setNew(n);
	}

	/**
	* Sets the primary key of this area.
	*
	* @param primaryKey the primary key of this area
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_area.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_area.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this area.
	*
	* @param uuid the uuid of this area
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_area.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AreaWrapper)) {
			return false;
		}

		AreaWrapper areaWrapper = (AreaWrapper)obj;

		if (Objects.equals(_area, areaWrapper._area)) {
			return true;
		}

		return false;
	}

	@Override
	public Area getWrappedModel() {
		return _area;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _area.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _area.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_area.resetOriginalValues();
	}

	private final Area _area;
}