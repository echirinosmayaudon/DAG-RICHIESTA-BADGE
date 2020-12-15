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

package com.cacheportlet.mef.model;

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
 * This class is a wrapper for {@link CachePortlet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CachePortlet
 * @generated
 */
@ProviderType
public class CachePortletWrapper implements CachePortlet,
	ModelWrapper<CachePortlet> {
	public CachePortletWrapper(CachePortlet cachePortlet) {
		_cachePortlet = cachePortlet;
	}

	@Override
	public Class<?> getModelClass() {
		return CachePortlet.class;
	}

	@Override
	public String getModelClassName() {
		return CachePortlet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portletId", getPortletId());
		attributes.put("jsonData", getJsonData());
		attributes.put("timestamp", getTimestamp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String jsonData = (String)attributes.get("jsonData");

		if (jsonData != null) {
			setJsonData(jsonData);
		}

		String timestamp = (String)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}
	}

	@Override
	public CachePortlet toEscapedModel() {
		return new CachePortletWrapper(_cachePortlet.toEscapedModel());
	}

	@Override
	public CachePortlet toUnescapedModel() {
		return new CachePortletWrapper(_cachePortlet.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _cachePortlet.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cachePortlet.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cachePortlet.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cachePortlet.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CachePortlet> toCacheModel() {
		return _cachePortlet.toCacheModel();
	}

	@Override
	public int compareTo(CachePortlet cachePortlet) {
		return _cachePortlet.compareTo(cachePortlet);
	}

	@Override
	public int hashCode() {
		return _cachePortlet.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cachePortlet.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CachePortletWrapper((CachePortlet)_cachePortlet.clone());
	}

	/**
	* Returns the json data of this cache portlet.
	*
	* @return the json data of this cache portlet
	*/
	@Override
	public java.lang.String getJsonData() {
		return _cachePortlet.getJsonData();
	}

	/**
	* Returns the portlet ID of this cache portlet.
	*
	* @return the portlet ID of this cache portlet
	*/
	@Override
	public java.lang.String getPortletId() {
		return _cachePortlet.getPortletId();
	}

	/**
	* Returns the primary key of this cache portlet.
	*
	* @return the primary key of this cache portlet
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _cachePortlet.getPrimaryKey();
	}

	/**
	* Returns the timestamp of this cache portlet.
	*
	* @return the timestamp of this cache portlet
	*/
	@Override
	public java.lang.String getTimestamp() {
		return _cachePortlet.getTimestamp();
	}

	/**
	* Returns the uuid of this cache portlet.
	*
	* @return the uuid of this cache portlet
	*/
	@Override
	public java.lang.String getUuid() {
		return _cachePortlet.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _cachePortlet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cachePortlet.toXmlString();
	}

	@Override
	public void persist() {
		_cachePortlet.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cachePortlet.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cachePortlet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cachePortlet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cachePortlet.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the json data of this cache portlet.
	*
	* @param jsonData the json data of this cache portlet
	*/
	@Override
	public void setJsonData(java.lang.String jsonData) {
		_cachePortlet.setJsonData(jsonData);
	}

	@Override
	public void setNew(boolean n) {
		_cachePortlet.setNew(n);
	}

	/**
	* Sets the portlet ID of this cache portlet.
	*
	* @param portletId the portlet ID of this cache portlet
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_cachePortlet.setPortletId(portletId);
	}

	/**
	* Sets the primary key of this cache portlet.
	*
	* @param primaryKey the primary key of this cache portlet
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_cachePortlet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cachePortlet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the timestamp of this cache portlet.
	*
	* @param timestamp the timestamp of this cache portlet
	*/
	@Override
	public void setTimestamp(java.lang.String timestamp) {
		_cachePortlet.setTimestamp(timestamp);
	}

	/**
	* Sets the uuid of this cache portlet.
	*
	* @param uuid the uuid of this cache portlet
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_cachePortlet.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CachePortletWrapper)) {
			return false;
		}

		CachePortletWrapper cachePortletWrapper = (CachePortletWrapper)obj;

		if (Objects.equals(_cachePortlet, cachePortletWrapper._cachePortlet)) {
			return true;
		}

		return false;
	}

	@Override
	public CachePortlet getWrappedModel() {
		return _cachePortlet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cachePortlet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cachePortlet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cachePortlet.resetOriginalValues();
	}

	private final CachePortlet _cachePortlet;
}