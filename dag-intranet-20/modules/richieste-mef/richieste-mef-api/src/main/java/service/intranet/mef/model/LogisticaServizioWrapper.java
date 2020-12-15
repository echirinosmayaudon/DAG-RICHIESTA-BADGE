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

package service.intranet.mef.model;

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
 * This class is a wrapper for {@link LogisticaServizio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaServizio
 * @generated
 */
@ProviderType
public class LogisticaServizioWrapper implements LogisticaServizio,
	ModelWrapper<LogisticaServizio> {
	public LogisticaServizioWrapper(LogisticaServizio logisticaServizio) {
		_logisticaServizio = logisticaServizio;
	}

	@Override
	public Class<?> getModelClass() {
		return LogisticaServizio.class;
	}

	@Override
	public String getModelClassName() {
		return LogisticaServizio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _logisticaServizio.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _logisticaServizio.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _logisticaServizio.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _logisticaServizio.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.LogisticaServizio> toCacheModel() {
		return _logisticaServizio.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.LogisticaServizio logisticaServizio) {
		return _logisticaServizio.compareTo(logisticaServizio);
	}

	@Override
	public int hashCode() {
		return _logisticaServizio.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logisticaServizio.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LogisticaServizioWrapper((LogisticaServizio)_logisticaServizio.clone());
	}

	/**
	* Returns the descrizione of this logistica servizio.
	*
	* @return the descrizione of this logistica servizio
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _logisticaServizio.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _logisticaServizio.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logisticaServizio.toXmlString();
	}

	/**
	* Returns the ID of this logistica servizio.
	*
	* @return the ID of this logistica servizio
	*/
	@Override
	public long getId() {
		return _logisticaServizio.getId();
	}

	/**
	* Returns the primary key of this logistica servizio.
	*
	* @return the primary key of this logistica servizio
	*/
	@Override
	public long getPrimaryKey() {
		return _logisticaServizio.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.LogisticaServizio toEscapedModel() {
		return new LogisticaServizioWrapper(_logisticaServizio.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.LogisticaServizio toUnescapedModel() {
		return new LogisticaServizioWrapper(_logisticaServizio.toUnescapedModel());
	}

	@Override
	public void persist() {
		_logisticaServizio.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logisticaServizio.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this logistica servizio.
	*
	* @param descrizione the descrizione of this logistica servizio
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_logisticaServizio.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_logisticaServizio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_logisticaServizio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_logisticaServizio.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this logistica servizio.
	*
	* @param id the ID of this logistica servizio
	*/
	@Override
	public void setId(long id) {
		_logisticaServizio.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_logisticaServizio.setNew(n);
	}

	/**
	* Sets the primary key of this logistica servizio.
	*
	* @param primaryKey the primary key of this logistica servizio
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logisticaServizio.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_logisticaServizio.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogisticaServizioWrapper)) {
			return false;
		}

		LogisticaServizioWrapper logisticaServizioWrapper = (LogisticaServizioWrapper)obj;

		if (Objects.equals(_logisticaServizio,
					logisticaServizioWrapper._logisticaServizio)) {
			return true;
		}

		return false;
	}

	@Override
	public LogisticaServizio getWrappedModel() {
		return _logisticaServizio;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _logisticaServizio.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _logisticaServizio.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_logisticaServizio.resetOriginalValues();
	}

	private final LogisticaServizio _logisticaServizio;
}