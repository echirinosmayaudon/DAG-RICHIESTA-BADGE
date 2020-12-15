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
 * This class is a wrapper for {@link Servizio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Servizio
 * @generated
 */
@ProviderType
public class ServizioWrapper implements Servizio, ModelWrapper<Servizio> {
	public ServizioWrapper(Servizio servizio) {
		_servizio = servizio;
	}

	@Override
	public Class<?> getModelClass() {
		return Servizio.class;
	}

	@Override
	public String getModelClassName() {
		return Servizio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("assServiceId", getAssServiceId());
		attributes.put("serviceName", getServiceName());
		attributes.put("assScopeId", getAssScopeId());
		attributes.put("levelAssistance", getLevelAssistance());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String assServiceId = (String)attributes.get("assServiceId");

		if (assServiceId != null) {
			setAssServiceId(assServiceId);
		}

		String serviceName = (String)attributes.get("serviceName");

		if (serviceName != null) {
			setServiceName(serviceName);
		}

		String assScopeId = (String)attributes.get("assScopeId");

		if (assScopeId != null) {
			setAssScopeId(assScopeId);
		}

		String levelAssistance = (String)attributes.get("levelAssistance");

		if (levelAssistance != null) {
			setLevelAssistance(levelAssistance);
		}
	}

	@Override
	public Servizio toEscapedModel() {
		return new ServizioWrapper(_servizio.toEscapedModel());
	}

	@Override
	public Servizio toUnescapedModel() {
		return new ServizioWrapper(_servizio.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _servizio.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _servizio.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _servizio.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _servizio.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Servizio> toCacheModel() {
		return _servizio.toCacheModel();
	}

	@Override
	public int compareTo(Servizio servizio) {
		return _servizio.compareTo(servizio);
	}

	@Override
	public int hashCode() {
		return _servizio.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _servizio.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ServizioWrapper((Servizio)_servizio.clone());
	}

	/**
	* Returns the ass scope ID of this servizio.
	*
	* @return the ass scope ID of this servizio
	*/
	@Override
	public java.lang.String getAssScopeId() {
		return _servizio.getAssScopeId();
	}

	/**
	* Returns the ass service ID of this servizio.
	*
	* @return the ass service ID of this servizio
	*/
	@Override
	public java.lang.String getAssServiceId() {
		return _servizio.getAssServiceId();
	}

	/**
	* Returns the level assistance of this servizio.
	*
	* @return the level assistance of this servizio
	*/
	@Override
	public java.lang.String getLevelAssistance() {
		return _servizio.getLevelAssistance();
	}

	/**
	* Returns the primary key of this servizio.
	*
	* @return the primary key of this servizio
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _servizio.getPrimaryKey();
	}

	/**
	* Returns the service name of this servizio.
	*
	* @return the service name of this servizio
	*/
	@Override
	public java.lang.String getServiceName() {
		return _servizio.getServiceName();
	}

	/**
	* Returns the uuid of this servizio.
	*
	* @return the uuid of this servizio
	*/
	@Override
	public java.lang.String getUuid() {
		return _servizio.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _servizio.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _servizio.toXmlString();
	}

	@Override
	public void persist() {
		_servizio.persist();
	}

	/**
	* Sets the ass scope ID of this servizio.
	*
	* @param assScopeId the ass scope ID of this servizio
	*/
	@Override
	public void setAssScopeId(java.lang.String assScopeId) {
		_servizio.setAssScopeId(assScopeId);
	}

	/**
	* Sets the ass service ID of this servizio.
	*
	* @param assServiceId the ass service ID of this servizio
	*/
	@Override
	public void setAssServiceId(java.lang.String assServiceId) {
		_servizio.setAssServiceId(assServiceId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_servizio.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_servizio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_servizio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_servizio.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the level assistance of this servizio.
	*
	* @param levelAssistance the level assistance of this servizio
	*/
	@Override
	public void setLevelAssistance(java.lang.String levelAssistance) {
		_servizio.setLevelAssistance(levelAssistance);
	}

	@Override
	public void setNew(boolean n) {
		_servizio.setNew(n);
	}

	/**
	* Sets the primary key of this servizio.
	*
	* @param primaryKey the primary key of this servizio
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_servizio.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_servizio.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the service name of this servizio.
	*
	* @param serviceName the service name of this servizio
	*/
	@Override
	public void setServiceName(java.lang.String serviceName) {
		_servizio.setServiceName(serviceName);
	}

	/**
	* Sets the uuid of this servizio.
	*
	* @param uuid the uuid of this servizio
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_servizio.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServizioWrapper)) {
			return false;
		}

		ServizioWrapper servizioWrapper = (ServizioWrapper)obj;

		if (Objects.equals(_servizio, servizioWrapper._servizio)) {
			return true;
		}

		return false;
	}

	@Override
	public Servizio getWrappedModel() {
		return _servizio;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _servizio.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _servizio.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_servizio.resetOriginalValues();
	}

	private final Servizio _servizio;
}