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

package com.accenture.lavoro.agile.istanza.mef.model;

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
 * This class is a wrapper for {@link OpzioneRich}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRich
 * @generated
 */
@ProviderType
public class OpzioneRichWrapper implements OpzioneRich,
	ModelWrapper<OpzioneRich> {
	public OpzioneRichWrapper(OpzioneRich opzioneRich) {
		_opzioneRich = opzioneRich;
	}

	@Override
	public Class<?> getModelClass() {
		return OpzioneRich.class;
	}

	@Override
	public String getModelClassName() {
		return OpzioneRich.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_opt", getId_opt());
		attributes.put("label_opt", getLabel_opt());
		attributes.put("testo_opt", getTesto_opt());
		attributes.put("peso_opt", getPeso_opt());
		attributes.put("data_in", getData_in());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_opt = (Long)attributes.get("id_opt");

		if (id_opt != null) {
			setId_opt(id_opt);
		}

		String label_opt = (String)attributes.get("label_opt");

		if (label_opt != null) {
			setLabel_opt(label_opt);
		}

		String testo_opt = (String)attributes.get("testo_opt");

		if (testo_opt != null) {
			setTesto_opt(testo_opt);
		}

		Integer peso_opt = (Integer)attributes.get("peso_opt");

		if (peso_opt != null) {
			setPeso_opt(peso_opt);
		}

		Date data_in = (Date)attributes.get("data_in");

		if (data_in != null) {
			setData_in(data_in);
		}
	}

	@Override
	public OpzioneRich toEscapedModel() {
		return new OpzioneRichWrapper(_opzioneRich.toEscapedModel());
	}

	@Override
	public OpzioneRich toUnescapedModel() {
		return new OpzioneRichWrapper(_opzioneRich.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _opzioneRich.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _opzioneRich.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _opzioneRich.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _opzioneRich.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<OpzioneRich> toCacheModel() {
		return _opzioneRich.toCacheModel();
	}

	@Override
	public int compareTo(OpzioneRich opzioneRich) {
		return _opzioneRich.compareTo(opzioneRich);
	}

	/**
	* Returns the peso_opt of this opzione rich.
	*
	* @return the peso_opt of this opzione rich
	*/
	@Override
	public int getPeso_opt() {
		return _opzioneRich.getPeso_opt();
	}

	@Override
	public int hashCode() {
		return _opzioneRich.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _opzioneRich.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new OpzioneRichWrapper((OpzioneRich)_opzioneRich.clone());
	}

	/**
	* Returns the label_opt of this opzione rich.
	*
	* @return the label_opt of this opzione rich
	*/
	@Override
	public java.lang.String getLabel_opt() {
		return _opzioneRich.getLabel_opt();
	}

	/**
	* Returns the testo_opt of this opzione rich.
	*
	* @return the testo_opt of this opzione rich
	*/
	@Override
	public java.lang.String getTesto_opt() {
		return _opzioneRich.getTesto_opt();
	}

	@Override
	public java.lang.String toString() {
		return _opzioneRich.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _opzioneRich.toXmlString();
	}

	/**
	* Returns the data_in of this opzione rich.
	*
	* @return the data_in of this opzione rich
	*/
	@Override
	public Date getData_in() {
		return _opzioneRich.getData_in();
	}

	/**
	* Returns the id_opt of this opzione rich.
	*
	* @return the id_opt of this opzione rich
	*/
	@Override
	public long getId_opt() {
		return _opzioneRich.getId_opt();
	}

	/**
	* Returns the primary key of this opzione rich.
	*
	* @return the primary key of this opzione rich
	*/
	@Override
	public long getPrimaryKey() {
		return _opzioneRich.getPrimaryKey();
	}

	@Override
	public void persist() {
		_opzioneRich.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_opzioneRich.setCachedModel(cachedModel);
	}

	/**
	* Sets the data_in of this opzione rich.
	*
	* @param data_in the data_in of this opzione rich
	*/
	@Override
	public void setData_in(Date data_in) {
		_opzioneRich.setData_in(data_in);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_opzioneRich.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_opzioneRich.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_opzioneRich.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_opt of this opzione rich.
	*
	* @param id_opt the id_opt of this opzione rich
	*/
	@Override
	public void setId_opt(long id_opt) {
		_opzioneRich.setId_opt(id_opt);
	}

	/**
	* Sets the label_opt of this opzione rich.
	*
	* @param label_opt the label_opt of this opzione rich
	*/
	@Override
	public void setLabel_opt(java.lang.String label_opt) {
		_opzioneRich.setLabel_opt(label_opt);
	}

	@Override
	public void setNew(boolean n) {
		_opzioneRich.setNew(n);
	}

	/**
	* Sets the peso_opt of this opzione rich.
	*
	* @param peso_opt the peso_opt of this opzione rich
	*/
	@Override
	public void setPeso_opt(int peso_opt) {
		_opzioneRich.setPeso_opt(peso_opt);
	}

	/**
	* Sets the primary key of this opzione rich.
	*
	* @param primaryKey the primary key of this opzione rich
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_opzioneRich.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_opzioneRich.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the testo_opt of this opzione rich.
	*
	* @param testo_opt the testo_opt of this opzione rich
	*/
	@Override
	public void setTesto_opt(java.lang.String testo_opt) {
		_opzioneRich.setTesto_opt(testo_opt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OpzioneRichWrapper)) {
			return false;
		}

		OpzioneRichWrapper opzioneRichWrapper = (OpzioneRichWrapper)obj;

		if (Objects.equals(_opzioneRich, opzioneRichWrapper._opzioneRich)) {
			return true;
		}

		return false;
	}

	@Override
	public OpzioneRich getWrappedModel() {
		return _opzioneRich;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _opzioneRich.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _opzioneRich.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_opzioneRich.resetOriginalValues();
	}

	private final OpzioneRich _opzioneRich;
}