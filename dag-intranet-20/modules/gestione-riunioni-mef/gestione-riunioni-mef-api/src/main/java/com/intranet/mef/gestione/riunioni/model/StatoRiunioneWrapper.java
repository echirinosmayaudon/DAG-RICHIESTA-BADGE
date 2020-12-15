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
 * This class is a wrapper for {@link StatoRiunione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRiunione
 * @generated
 */
@ProviderType
public class StatoRiunioneWrapper implements StatoRiunione,
	ModelWrapper<StatoRiunione> {
	public StatoRiunioneWrapper(StatoRiunione statoRiunione) {
		_statoRiunione = statoRiunione;
	}

	@Override
	public Class<?> getModelClass() {
		return StatoRiunione.class;
	}

	@Override
	public String getModelClassName() {
		return StatoRiunione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_stato_riunione", getId_stato_riunione());
		attributes.put("label", getLabel());
		attributes.put("next_stato", getNext_stato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_stato_riunione = (Long)attributes.get("id_stato_riunione");

		if (id_stato_riunione != null) {
			setId_stato_riunione(id_stato_riunione);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String next_stato = (String)attributes.get("next_stato");

		if (next_stato != null) {
			setNext_stato(next_stato);
		}
	}

	@Override
	public StatoRiunione toEscapedModel() {
		return new StatoRiunioneWrapper(_statoRiunione.toEscapedModel());
	}

	@Override
	public StatoRiunione toUnescapedModel() {
		return new StatoRiunioneWrapper(_statoRiunione.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _statoRiunione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _statoRiunione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _statoRiunione.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _statoRiunione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<StatoRiunione> toCacheModel() {
		return _statoRiunione.toCacheModel();
	}

	@Override
	public int compareTo(StatoRiunione statoRiunione) {
		return _statoRiunione.compareTo(statoRiunione);
	}

	@Override
	public int hashCode() {
		return _statoRiunione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statoRiunione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StatoRiunioneWrapper((StatoRiunione)_statoRiunione.clone());
	}

	/**
	* Returns the label of this stato riunione.
	*
	* @return the label of this stato riunione
	*/
	@Override
	public java.lang.String getLabel() {
		return _statoRiunione.getLabel();
	}

	/**
	* Returns the next_stato of this stato riunione.
	*
	* @return the next_stato of this stato riunione
	*/
	@Override
	public java.lang.String getNext_stato() {
		return _statoRiunione.getNext_stato();
	}

	@Override
	public java.lang.String toString() {
		return _statoRiunione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statoRiunione.toXmlString();
	}

	/**
	* Returns the id_stato_riunione of this stato riunione.
	*
	* @return the id_stato_riunione of this stato riunione
	*/
	@Override
	public long getId_stato_riunione() {
		return _statoRiunione.getId_stato_riunione();
	}

	/**
	* Returns the primary key of this stato riunione.
	*
	* @return the primary key of this stato riunione
	*/
	@Override
	public long getPrimaryKey() {
		return _statoRiunione.getPrimaryKey();
	}

	@Override
	public void persist() {
		_statoRiunione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statoRiunione.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_statoRiunione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_statoRiunione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_statoRiunione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_stato_riunione of this stato riunione.
	*
	* @param id_stato_riunione the id_stato_riunione of this stato riunione
	*/
	@Override
	public void setId_stato_riunione(long id_stato_riunione) {
		_statoRiunione.setId_stato_riunione(id_stato_riunione);
	}

	/**
	* Sets the label of this stato riunione.
	*
	* @param label the label of this stato riunione
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_statoRiunione.setLabel(label);
	}

	@Override
	public void setNew(boolean n) {
		_statoRiunione.setNew(n);
	}

	/**
	* Sets the next_stato of this stato riunione.
	*
	* @param next_stato the next_stato of this stato riunione
	*/
	@Override
	public void setNext_stato(java.lang.String next_stato) {
		_statoRiunione.setNext_stato(next_stato);
	}

	/**
	* Sets the primary key of this stato riunione.
	*
	* @param primaryKey the primary key of this stato riunione
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statoRiunione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_statoRiunione.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoRiunioneWrapper)) {
			return false;
		}

		StatoRiunioneWrapper statoRiunioneWrapper = (StatoRiunioneWrapper)obj;

		if (Objects.equals(_statoRiunione, statoRiunioneWrapper._statoRiunione)) {
			return true;
		}

		return false;
	}

	@Override
	public StatoRiunione getWrappedModel() {
		return _statoRiunione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _statoRiunione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _statoRiunione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_statoRiunione.resetOriginalValues();
	}

	private final StatoRiunione _statoRiunione;
}