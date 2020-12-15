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

package com.intranet.mef.gestione.riunioni.model;

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
 * This class is a wrapper for {@link TipoRiunione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoRiunione
 * @generated
 */
@ProviderType
public class TipoRiunioneWrapper implements TipoRiunione,
	ModelWrapper<TipoRiunione> {
	public TipoRiunioneWrapper(TipoRiunione tipoRiunione) {
		_tipoRiunione = tipoRiunione;
	}

	@Override
	public Class<?> getModelClass() {
		return TipoRiunione.class;
	}

	@Override
	public String getModelClassName() {
		return TipoRiunione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_tipo", getId_tipo());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_tipo = (Long)attributes.get("id_tipo");

		if (id_tipo != null) {
			setId_tipo(id_tipo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public TipoRiunione toEscapedModel() {
		return new TipoRiunioneWrapper(_tipoRiunione.toEscapedModel());
	}

	@Override
	public TipoRiunione toUnescapedModel() {
		return new TipoRiunioneWrapper(_tipoRiunione.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _tipoRiunione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipoRiunione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipoRiunione.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipoRiunione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TipoRiunione> toCacheModel() {
		return _tipoRiunione.toCacheModel();
	}

	@Override
	public int compareTo(TipoRiunione tipoRiunione) {
		return _tipoRiunione.compareTo(tipoRiunione);
	}

	@Override
	public int hashCode() {
		return _tipoRiunione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipoRiunione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TipoRiunioneWrapper((TipoRiunione)_tipoRiunione.clone());
	}

	/**
	* Returns the descrizione of this tipo riunione.
	*
	* @return the descrizione of this tipo riunione
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _tipoRiunione.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _tipoRiunione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tipoRiunione.toXmlString();
	}

	/**
	* Returns the id_tipo of this tipo riunione.
	*
	* @return the id_tipo of this tipo riunione
	*/
	@Override
	public long getId_tipo() {
		return _tipoRiunione.getId_tipo();
	}

	/**
	* Returns the primary key of this tipo riunione.
	*
	* @return the primary key of this tipo riunione
	*/
	@Override
	public long getPrimaryKey() {
		return _tipoRiunione.getPrimaryKey();
	}

	@Override
	public void persist() {
		_tipoRiunione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipoRiunione.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this tipo riunione.
	*
	* @param descrizione the descrizione of this tipo riunione
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_tipoRiunione.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipoRiunione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipoRiunione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipoRiunione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_tipo of this tipo riunione.
	*
	* @param id_tipo the id_tipo of this tipo riunione
	*/
	@Override
	public void setId_tipo(long id_tipo) {
		_tipoRiunione.setId_tipo(id_tipo);
	}

	@Override
	public void setNew(boolean n) {
		_tipoRiunione.setNew(n);
	}

	/**
	* Sets the primary key of this tipo riunione.
	*
	* @param primaryKey the primary key of this tipo riunione
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipoRiunione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipoRiunione.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoRiunioneWrapper)) {
			return false;
		}

		TipoRiunioneWrapper tipoRiunioneWrapper = (TipoRiunioneWrapper)obj;

		if (Objects.equals(_tipoRiunione, tipoRiunioneWrapper._tipoRiunione)) {
			return true;
		}

		return false;
	}

	@Override
	public TipoRiunione getWrappedModel() {
		return _tipoRiunione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipoRiunione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipoRiunione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipoRiunione.resetOriginalValues();
	}

	private final TipoRiunione _tipoRiunione;
}