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

package com.intranet.mef.central.model;

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
 * This class is a wrapper for {@link CentralInvoker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvoker
 * @generated
 */
@ProviderType
public class CentralInvokerWrapper implements CentralInvoker,
	ModelWrapper<CentralInvoker> {
	public CentralInvokerWrapper(CentralInvoker centralInvoker) {
		_centralInvoker = centralInvoker;
	}

	@Override
	public Class<?> getModelClass() {
		return CentralInvoker.class;
	}

	@Override
	public String getModelClassName() {
		return CentralInvoker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idRecord", getIdRecord());
		attributes.put("secretaryId", getSecretaryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long idRecord = (Long)attributes.get("idRecord");

		if (idRecord != null) {
			setIdRecord(idRecord);
		}

		Long secretaryId = (Long)attributes.get("secretaryId");

		if (secretaryId != null) {
			setSecretaryId(secretaryId);
		}
	}

	@Override
	public CentralInvoker toEscapedModel() {
		return new CentralInvokerWrapper(_centralInvoker.toEscapedModel());
	}

	@Override
	public CentralInvoker toUnescapedModel() {
		return new CentralInvokerWrapper(_centralInvoker.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _centralInvoker.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _centralInvoker.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _centralInvoker.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _centralInvoker.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CentralInvoker> toCacheModel() {
		return _centralInvoker.toCacheModel();
	}

	@Override
	public int compareTo(CentralInvoker centralInvoker) {
		return _centralInvoker.compareTo(centralInvoker);
	}

	@Override
	public int hashCode() {
		return _centralInvoker.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _centralInvoker.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CentralInvokerWrapper((CentralInvoker)_centralInvoker.clone());
	}

	/**
	* Returns the uuid of this central invoker.
	*
	* @return the uuid of this central invoker
	*/
	@Override
	public java.lang.String getUuid() {
		return _centralInvoker.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _centralInvoker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _centralInvoker.toXmlString();
	}

	/**
	* Returns the id record of this central invoker.
	*
	* @return the id record of this central invoker
	*/
	@Override
	public long getIdRecord() {
		return _centralInvoker.getIdRecord();
	}

	/**
	* Returns the primary key of this central invoker.
	*
	* @return the primary key of this central invoker
	*/
	@Override
	public long getPrimaryKey() {
		return _centralInvoker.getPrimaryKey();
	}

	/**
	* Returns the secretary ID of this central invoker.
	*
	* @return the secretary ID of this central invoker
	*/
	@Override
	public long getSecretaryId() {
		return _centralInvoker.getSecretaryId();
	}

	@Override
	public void persist() {
		_centralInvoker.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_centralInvoker.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_centralInvoker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_centralInvoker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_centralInvoker.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id record of this central invoker.
	*
	* @param idRecord the id record of this central invoker
	*/
	@Override
	public void setIdRecord(long idRecord) {
		_centralInvoker.setIdRecord(idRecord);
	}

	@Override
	public void setNew(boolean n) {
		_centralInvoker.setNew(n);
	}

	/**
	* Sets the primary key of this central invoker.
	*
	* @param primaryKey the primary key of this central invoker
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_centralInvoker.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_centralInvoker.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the secretary ID of this central invoker.
	*
	* @param secretaryId the secretary ID of this central invoker
	*/
	@Override
	public void setSecretaryId(long secretaryId) {
		_centralInvoker.setSecretaryId(secretaryId);
	}

	/**
	* Sets the uuid of this central invoker.
	*
	* @param uuid the uuid of this central invoker
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_centralInvoker.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CentralInvokerWrapper)) {
			return false;
		}

		CentralInvokerWrapper centralInvokerWrapper = (CentralInvokerWrapper)obj;

		if (Objects.equals(_centralInvoker,
					centralInvokerWrapper._centralInvoker)) {
			return true;
		}

		return false;
	}

	@Override
	public CentralInvoker getWrappedModel() {
		return _centralInvoker;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _centralInvoker.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _centralInvoker.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_centralInvoker.resetOriginalValues();
	}

	private final CentralInvoker _centralInvoker;
}