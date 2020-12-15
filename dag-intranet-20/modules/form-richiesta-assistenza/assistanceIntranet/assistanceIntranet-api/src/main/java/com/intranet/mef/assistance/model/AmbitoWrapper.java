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
 * This class is a wrapper for {@link Ambito}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ambito
 * @generated
 */
@ProviderType
public class AmbitoWrapper implements Ambito, ModelWrapper<Ambito> {
	public AmbitoWrapper(Ambito ambito) {
		_ambito = ambito;
	}

	@Override
	public Class<?> getModelClass() {
		return Ambito.class;
	}

	@Override
	public String getModelClassName() {
		return Ambito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("assScopeId", getAssScopeId());
		attributes.put("scopeName", getScopeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String assScopeId = (String)attributes.get("assScopeId");

		if (assScopeId != null) {
			setAssScopeId(assScopeId);
		}

		String scopeName = (String)attributes.get("scopeName");

		if (scopeName != null) {
			setScopeName(scopeName);
		}
	}

	@Override
	public Ambito toEscapedModel() {
		return new AmbitoWrapper(_ambito.toEscapedModel());
	}

	@Override
	public Ambito toUnescapedModel() {
		return new AmbitoWrapper(_ambito.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _ambito.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ambito.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ambito.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ambito.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Ambito> toCacheModel() {
		return _ambito.toCacheModel();
	}

	@Override
	public int compareTo(Ambito ambito) {
		return _ambito.compareTo(ambito);
	}

	@Override
	public int hashCode() {
		return _ambito.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ambito.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AmbitoWrapper((Ambito)_ambito.clone());
	}

	/**
	* Returns the ass scope ID of this ambito.
	*
	* @return the ass scope ID of this ambito
	*/
	@Override
	public java.lang.String getAssScopeId() {
		return _ambito.getAssScopeId();
	}

	/**
	* Returns the primary key of this ambito.
	*
	* @return the primary key of this ambito
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _ambito.getPrimaryKey();
	}

	/**
	* Returns the scope name of this ambito.
	*
	* @return the scope name of this ambito
	*/
	@Override
	public java.lang.String getScopeName() {
		return _ambito.getScopeName();
	}

	/**
	* Returns the uuid of this ambito.
	*
	* @return the uuid of this ambito
	*/
	@Override
	public java.lang.String getUuid() {
		return _ambito.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _ambito.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ambito.toXmlString();
	}

	@Override
	public void persist() {
		_ambito.persist();
	}

	/**
	* Sets the ass scope ID of this ambito.
	*
	* @param assScopeId the ass scope ID of this ambito
	*/
	@Override
	public void setAssScopeId(java.lang.String assScopeId) {
		_ambito.setAssScopeId(assScopeId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ambito.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ambito.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ambito.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ambito.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_ambito.setNew(n);
	}

	/**
	* Sets the primary key of this ambito.
	*
	* @param primaryKey the primary key of this ambito
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_ambito.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ambito.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the scope name of this ambito.
	*
	* @param scopeName the scope name of this ambito
	*/
	@Override
	public void setScopeName(java.lang.String scopeName) {
		_ambito.setScopeName(scopeName);
	}

	/**
	* Sets the uuid of this ambito.
	*
	* @param uuid the uuid of this ambito
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ambito.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmbitoWrapper)) {
			return false;
		}

		AmbitoWrapper ambitoWrapper = (AmbitoWrapper)obj;

		if (Objects.equals(_ambito, ambitoWrapper._ambito)) {
			return true;
		}

		return false;
	}

	@Override
	public Ambito getWrappedModel() {
		return _ambito;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ambito.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ambito.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ambito.resetOriginalValues();
	}

	private final Ambito _ambito;
}