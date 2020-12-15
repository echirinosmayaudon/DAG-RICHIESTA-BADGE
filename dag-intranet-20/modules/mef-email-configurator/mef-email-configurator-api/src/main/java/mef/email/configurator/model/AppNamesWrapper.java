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

package mef.email.configurator.model;

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
 * This class is a wrapper for {@link AppNames}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppNames
 * @generated
 */
@ProviderType
public class AppNamesWrapper implements AppNames, ModelWrapper<AppNames> {
	public AppNamesWrapper(AppNames appNames) {
		_appNames = appNames;
	}

	@Override
	public Class<?> getModelClass() {
		return AppNames.class;
	}

	@Override
	public String getModelClassName() {
		return AppNames.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("appname", getAppname());
		attributes.put("appid", getAppid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String appname = (String)attributes.get("appname");

		if (appname != null) {
			setAppname(appname);
		}

		Long appid = (Long)attributes.get("appid");

		if (appid != null) {
			setAppid(appid);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _appNames.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _appNames.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _appNames.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _appNames.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<mef.email.configurator.model.AppNames> toCacheModel() {
		return _appNames.toCacheModel();
	}

	@Override
	public int compareTo(mef.email.configurator.model.AppNames appNames) {
		return _appNames.compareTo(appNames);
	}

	@Override
	public int hashCode() {
		return _appNames.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appNames.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AppNamesWrapper((AppNames)_appNames.clone());
	}

	/**
	* Returns the appname of this app names.
	*
	* @return the appname of this app names
	*/
	@Override
	public java.lang.String getAppname() {
		return _appNames.getAppname();
	}

	@Override
	public java.lang.String toString() {
		return _appNames.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _appNames.toXmlString();
	}

	/**
	* Returns the appid of this app names.
	*
	* @return the appid of this app names
	*/
	@Override
	public long getAppid() {
		return _appNames.getAppid();
	}

	/**
	* Returns the ID of this app names.
	*
	* @return the ID of this app names
	*/
	@Override
	public long getId() {
		return _appNames.getId();
	}

	/**
	* Returns the primary key of this app names.
	*
	* @return the primary key of this app names
	*/
	@Override
	public long getPrimaryKey() {
		return _appNames.getPrimaryKey();
	}

	@Override
	public mef.email.configurator.model.AppNames toEscapedModel() {
		return new AppNamesWrapper(_appNames.toEscapedModel());
	}

	@Override
	public mef.email.configurator.model.AppNames toUnescapedModel() {
		return new AppNamesWrapper(_appNames.toUnescapedModel());
	}

	@Override
	public void persist() {
		_appNames.persist();
	}

	/**
	* Sets the appid of this app names.
	*
	* @param appid the appid of this app names
	*/
	@Override
	public void setAppid(long appid) {
		_appNames.setAppid(appid);
	}

	/**
	* Sets the appname of this app names.
	*
	* @param appname the appname of this app names
	*/
	@Override
	public void setAppname(java.lang.String appname) {
		_appNames.setAppname(appname);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_appNames.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_appNames.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_appNames.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_appNames.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this app names.
	*
	* @param id the ID of this app names
	*/
	@Override
	public void setId(long id) {
		_appNames.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_appNames.setNew(n);
	}

	/**
	* Sets the primary key of this app names.
	*
	* @param primaryKey the primary key of this app names
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_appNames.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_appNames.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppNamesWrapper)) {
			return false;
		}

		AppNamesWrapper appNamesWrapper = (AppNamesWrapper)obj;

		if (Objects.equals(_appNames, appNamesWrapper._appNames)) {
			return true;
		}

		return false;
	}

	@Override
	public AppNames getWrappedModel() {
		return _appNames;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _appNames.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _appNames.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_appNames.resetOriginalValues();
	}

	private final AppNames _appNames;
}