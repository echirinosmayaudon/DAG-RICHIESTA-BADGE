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
 * This class is a wrapper for {@link LogisticaValutazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaValutazione
 * @generated
 */
@ProviderType
public class LogisticaValutazioneWrapper implements LogisticaValutazione,
	ModelWrapper<LogisticaValutazione> {
	public LogisticaValutazioneWrapper(
		LogisticaValutazione logisticaValutazione) {
		_logisticaValutazione = logisticaValutazione;
	}

	@Override
	public Class<?> getModelClass() {
		return LogisticaValutazione.class;
	}

	@Override
	public String getModelClassName() {
		return LogisticaValutazione.class.getName();
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
		return _logisticaValutazione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _logisticaValutazione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _logisticaValutazione.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _logisticaValutazione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.LogisticaValutazione> toCacheModel() {
		return _logisticaValutazione.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.LogisticaValutazione logisticaValutazione) {
		return _logisticaValutazione.compareTo(logisticaValutazione);
	}

	@Override
	public int hashCode() {
		return _logisticaValutazione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logisticaValutazione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LogisticaValutazioneWrapper((LogisticaValutazione)_logisticaValutazione.clone());
	}

	/**
	* Returns the descrizione of this logistica valutazione.
	*
	* @return the descrizione of this logistica valutazione
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _logisticaValutazione.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _logisticaValutazione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logisticaValutazione.toXmlString();
	}

	/**
	* Returns the ID of this logistica valutazione.
	*
	* @return the ID of this logistica valutazione
	*/
	@Override
	public long getId() {
		return _logisticaValutazione.getId();
	}

	/**
	* Returns the primary key of this logistica valutazione.
	*
	* @return the primary key of this logistica valutazione
	*/
	@Override
	public long getPrimaryKey() {
		return _logisticaValutazione.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.LogisticaValutazione toEscapedModel() {
		return new LogisticaValutazioneWrapper(_logisticaValutazione.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.LogisticaValutazione toUnescapedModel() {
		return new LogisticaValutazioneWrapper(_logisticaValutazione.toUnescapedModel());
	}

	@Override
	public void persist() {
		_logisticaValutazione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logisticaValutazione.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this logistica valutazione.
	*
	* @param descrizione the descrizione of this logistica valutazione
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_logisticaValutazione.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_logisticaValutazione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_logisticaValutazione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_logisticaValutazione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this logistica valutazione.
	*
	* @param id the ID of this logistica valutazione
	*/
	@Override
	public void setId(long id) {
		_logisticaValutazione.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_logisticaValutazione.setNew(n);
	}

	/**
	* Sets the primary key of this logistica valutazione.
	*
	* @param primaryKey the primary key of this logistica valutazione
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logisticaValutazione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_logisticaValutazione.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogisticaValutazioneWrapper)) {
			return false;
		}

		LogisticaValutazioneWrapper logisticaValutazioneWrapper = (LogisticaValutazioneWrapper)obj;

		if (Objects.equals(_logisticaValutazione,
					logisticaValutazioneWrapper._logisticaValutazione)) {
			return true;
		}

		return false;
	}

	@Override
	public LogisticaValutazione getWrappedModel() {
		return _logisticaValutazione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _logisticaValutazione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _logisticaValutazione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_logisticaValutazione.resetOriginalValues();
	}

	private final LogisticaValutazione _logisticaValutazione;
}