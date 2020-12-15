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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link StoricoStatoRiunione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunione
 * @generated
 */
@ProviderType
public class StoricoStatoRiunioneWrapper implements StoricoStatoRiunione,
	ModelWrapper<StoricoStatoRiunione> {
	public StoricoStatoRiunioneWrapper(
		StoricoStatoRiunione storicoStatoRiunione) {
		_storicoStatoRiunione = storicoStatoRiunione;
	}

	@Override
	public Class<?> getModelClass() {
		return StoricoStatoRiunione.class;
	}

	@Override
	public String getModelClassName() {
		return StoricoStatoRiunione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_riunione", getId_riunione());
		attributes.put("id_storico", getId_storico());
		attributes.put("data", getData());
		attributes.put("id_stato_riunione", getId_stato_riunione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_riunione = (Long)attributes.get("id_riunione");

		if (id_riunione != null) {
			setId_riunione(id_riunione);
		}

		Long id_storico = (Long)attributes.get("id_storico");

		if (id_storico != null) {
			setId_storico(id_storico);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		Long id_stato_riunione = (Long)attributes.get("id_stato_riunione");

		if (id_stato_riunione != null) {
			setId_stato_riunione(id_stato_riunione);
		}
	}

	@Override
	public StoricoStatoRiunione toEscapedModel() {
		return new StoricoStatoRiunioneWrapper(_storicoStatoRiunione.toEscapedModel());
	}

	@Override
	public StoricoStatoRiunione toUnescapedModel() {
		return new StoricoStatoRiunioneWrapper(_storicoStatoRiunione.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _storicoStatoRiunione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _storicoStatoRiunione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _storicoStatoRiunione.isNew();
	}

	/**
	* Returns the primary key of this storico stato riunione.
	*
	* @return the primary key of this storico stato riunione
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK getPrimaryKey() {
		return _storicoStatoRiunione.getPrimaryKey();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _storicoStatoRiunione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<StoricoStatoRiunione> toCacheModel() {
		return _storicoStatoRiunione.toCacheModel();
	}

	@Override
	public int compareTo(StoricoStatoRiunione storicoStatoRiunione) {
		return _storicoStatoRiunione.compareTo(storicoStatoRiunione);
	}

	@Override
	public int hashCode() {
		return _storicoStatoRiunione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _storicoStatoRiunione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StoricoStatoRiunioneWrapper((StoricoStatoRiunione)_storicoStatoRiunione.clone());
	}

	@Override
	public java.lang.String toString() {
		return _storicoStatoRiunione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _storicoStatoRiunione.toXmlString();
	}

	/**
	* Returns the data of this storico stato riunione.
	*
	* @return the data of this storico stato riunione
	*/
	@Override
	public Date getData() {
		return _storicoStatoRiunione.getData();
	}

	/**
	* Returns the id_riunione of this storico stato riunione.
	*
	* @return the id_riunione of this storico stato riunione
	*/
	@Override
	public long getId_riunione() {
		return _storicoStatoRiunione.getId_riunione();
	}

	/**
	* Returns the id_stato_riunione of this storico stato riunione.
	*
	* @return the id_stato_riunione of this storico stato riunione
	*/
	@Override
	public long getId_stato_riunione() {
		return _storicoStatoRiunione.getId_stato_riunione();
	}

	/**
	* Returns the id_storico of this storico stato riunione.
	*
	* @return the id_storico of this storico stato riunione
	*/
	@Override
	public long getId_storico() {
		return _storicoStatoRiunione.getId_storico();
	}

	@Override
	public void persist() {
		_storicoStatoRiunione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_storicoStatoRiunione.setCachedModel(cachedModel);
	}

	/**
	* Sets the data of this storico stato riunione.
	*
	* @param data the data of this storico stato riunione
	*/
	@Override
	public void setData(Date data) {
		_storicoStatoRiunione.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_storicoStatoRiunione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_storicoStatoRiunione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_storicoStatoRiunione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_riunione of this storico stato riunione.
	*
	* @param id_riunione the id_riunione of this storico stato riunione
	*/
	@Override
	public void setId_riunione(long id_riunione) {
		_storicoStatoRiunione.setId_riunione(id_riunione);
	}

	/**
	* Sets the id_stato_riunione of this storico stato riunione.
	*
	* @param id_stato_riunione the id_stato_riunione of this storico stato riunione
	*/
	@Override
	public void setId_stato_riunione(long id_stato_riunione) {
		_storicoStatoRiunione.setId_stato_riunione(id_stato_riunione);
	}

	/**
	* Sets the id_storico of this storico stato riunione.
	*
	* @param id_storico the id_storico of this storico stato riunione
	*/
	@Override
	public void setId_storico(long id_storico) {
		_storicoStatoRiunione.setId_storico(id_storico);
	}

	@Override
	public void setNew(boolean n) {
		_storicoStatoRiunione.setNew(n);
	}

	/**
	* Sets the primary key of this storico stato riunione.
	*
	* @param primaryKey the primary key of this storico stato riunione
	*/
	@Override
	public void setPrimaryKey(
		com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK primaryKey) {
		_storicoStatoRiunione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_storicoStatoRiunione.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoricoStatoRiunioneWrapper)) {
			return false;
		}

		StoricoStatoRiunioneWrapper storicoStatoRiunioneWrapper = (StoricoStatoRiunioneWrapper)obj;

		if (Objects.equals(_storicoStatoRiunione,
					storicoStatoRiunioneWrapper._storicoStatoRiunione)) {
			return true;
		}

		return false;
	}

	@Override
	public StoricoStatoRiunione getWrappedModel() {
		return _storicoStatoRiunione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _storicoStatoRiunione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _storicoStatoRiunione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_storicoStatoRiunione.resetOriginalValues();
	}

	private final StoricoStatoRiunione _storicoStatoRiunione;
}