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
 * This class is a wrapper for {@link LogisticaStato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaStato
 * @generated
 */
@ProviderType
public class LogisticaStatoWrapper implements LogisticaStato,
	ModelWrapper<LogisticaStato> {
	public LogisticaStatoWrapper(LogisticaStato logisticaStato) {
		_logisticaStato = logisticaStato;
	}

	@Override
	public Class<?> getModelClass() {
		return LogisticaStato.class;
	}

	@Override
	public String getModelClassName() {
		return LogisticaStato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descrizione", getDescrizione());
		attributes.put("utente", getUtente());

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

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _logisticaStato.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _logisticaStato.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _logisticaStato.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _logisticaStato.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.LogisticaStato> toCacheModel() {
		return _logisticaStato.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.LogisticaStato logisticaStato) {
		return _logisticaStato.compareTo(logisticaStato);
	}

	@Override
	public int hashCode() {
		return _logisticaStato.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logisticaStato.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LogisticaStatoWrapper((LogisticaStato)_logisticaStato.clone());
	}

	/**
	* Returns the descrizione of this logistica stato.
	*
	* @return the descrizione of this logistica stato
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _logisticaStato.getDescrizione();
	}

	/**
	* Returns the utente of this logistica stato.
	*
	* @return the utente of this logistica stato
	*/
	@Override
	public java.lang.String getUtente() {
		return _logisticaStato.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _logisticaStato.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logisticaStato.toXmlString();
	}

	/**
	* Returns the ID of this logistica stato.
	*
	* @return the ID of this logistica stato
	*/
	@Override
	public long getId() {
		return _logisticaStato.getId();
	}

	/**
	* Returns the primary key of this logistica stato.
	*
	* @return the primary key of this logistica stato
	*/
	@Override
	public long getPrimaryKey() {
		return _logisticaStato.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.LogisticaStato toEscapedModel() {
		return new LogisticaStatoWrapper(_logisticaStato.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.LogisticaStato toUnescapedModel() {
		return new LogisticaStatoWrapper(_logisticaStato.toUnescapedModel());
	}

	@Override
	public void persist() {
		_logisticaStato.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logisticaStato.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this logistica stato.
	*
	* @param descrizione the descrizione of this logistica stato
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_logisticaStato.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_logisticaStato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_logisticaStato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_logisticaStato.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this logistica stato.
	*
	* @param id the ID of this logistica stato
	*/
	@Override
	public void setId(long id) {
		_logisticaStato.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_logisticaStato.setNew(n);
	}

	/**
	* Sets the primary key of this logistica stato.
	*
	* @param primaryKey the primary key of this logistica stato
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logisticaStato.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_logisticaStato.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the utente of this logistica stato.
	*
	* @param utente the utente of this logistica stato
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_logisticaStato.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogisticaStatoWrapper)) {
			return false;
		}

		LogisticaStatoWrapper logisticaStatoWrapper = (LogisticaStatoWrapper)obj;

		if (Objects.equals(_logisticaStato,
					logisticaStatoWrapper._logisticaStato)) {
			return true;
		}

		return false;
	}

	@Override
	public LogisticaStato getWrappedModel() {
		return _logisticaStato;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _logisticaStato.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _logisticaStato.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_logisticaStato.resetOriginalValues();
	}

	private final LogisticaStato _logisticaStato;
}