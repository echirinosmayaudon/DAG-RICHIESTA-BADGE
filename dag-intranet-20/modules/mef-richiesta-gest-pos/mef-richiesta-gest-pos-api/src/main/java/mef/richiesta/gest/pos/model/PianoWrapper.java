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

package mef.richiesta.gest.pos.model;

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
 * This class is a wrapper for {@link Piano}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Piano
 * @generated
 */
@ProviderType
public class PianoWrapper implements Piano, ModelWrapper<Piano> {

	public PianoWrapper(Piano piano) {
		_piano = piano;
	}

	@Override
	public Class<?> getModelClass() {
		return Piano.class;
	}

	@Override
	public String getModelClassName() {
		return Piano.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_pk_piano", getId_pk_piano());
		attributes.put("id_piano", getId_piano());
		attributes.put("id_sede", getId_sede());
		attributes.put("cod_piano", getCod_piano());
		attributes.put("desc", getDesc());
		attributes.put("data_ins", getData_ins());
		attributes.put("data_agg", getData_agg());
		attributes.put("user_ins", getUser_ins());
		attributes.put("user_agg", getUser_agg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_pk_piano = (Long)attributes.get("id_pk_piano");

		if (id_pk_piano != null) {
			setId_pk_piano(id_pk_piano);
		}

		Long id_piano = (Long)attributes.get("id_piano");

		if (id_piano != null) {
			setId_piano(id_piano);
		}

		Long id_sede = (Long)attributes.get("id_sede");

		if (id_sede != null) {
			setId_sede(id_sede);
		}

		String cod_piano = (String)attributes.get("cod_piano");

		if (cod_piano != null) {
			setCod_piano(cod_piano);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		String data_ins = (String)attributes.get("data_ins");

		if (data_ins != null) {
			setData_ins(data_ins);
		}

		String data_agg = (String)attributes.get("data_agg");

		if (data_agg != null) {
			setData_agg(data_agg);
		}

		String user_ins = (String)attributes.get("user_ins");

		if (user_ins != null) {
			setUser_ins(user_ins);
		}

		String user_agg = (String)attributes.get("user_agg");

		if (user_agg != null) {
			setUser_agg(user_agg);
		}
	}

	@Override
	public Object clone() {
		return new PianoWrapper((Piano)_piano.clone());
	}

	@Override
	public int compareTo(mef.richiesta.gest.pos.model.Piano piano) {
		return _piano.compareTo(piano);
	}

	/**
	 * Returns the cod_piano of this piano.
	 *
	 * @return the cod_piano of this piano
	 */
	@Override
	public String getCod_piano() {
		return _piano.getCod_piano();
	}

	/**
	 * Returns the data_agg of this piano.
	 *
	 * @return the data_agg of this piano
	 */
	@Override
	public String getData_agg() {
		return _piano.getData_agg();
	}

	/**
	 * Returns the data_ins of this piano.
	 *
	 * @return the data_ins of this piano
	 */
	@Override
	public String getData_ins() {
		return _piano.getData_ins();
	}

	/**
	 * Returns the desc of this piano.
	 *
	 * @return the desc of this piano
	 */
	@Override
	public String getDesc() {
		return _piano.getDesc();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _piano.getExpandoBridge();
	}

	/**
	 * Returns the id_piano of this piano.
	 *
	 * @return the id_piano of this piano
	 */
	@Override
	public long getId_piano() {
		return _piano.getId_piano();
	}

	/**
	 * Returns the id_pk_piano of this piano.
	 *
	 * @return the id_pk_piano of this piano
	 */
	@Override
	public long getId_pk_piano() {
		return _piano.getId_pk_piano();
	}

	/**
	 * Returns the id_sede of this piano.
	 *
	 * @return the id_sede of this piano
	 */
	@Override
	public long getId_sede() {
		return _piano.getId_sede();
	}

	/**
	 * Returns the primary key of this piano.
	 *
	 * @return the primary key of this piano
	 */
	@Override
	public long getPrimaryKey() {
		return _piano.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _piano.getPrimaryKeyObj();
	}

	/**
	 * Returns the user_agg of this piano.
	 *
	 * @return the user_agg of this piano
	 */
	@Override
	public String getUser_agg() {
		return _piano.getUser_agg();
	}

	/**
	 * Returns the user_ins of this piano.
	 *
	 * @return the user_ins of this piano
	 */
	@Override
	public String getUser_ins() {
		return _piano.getUser_ins();
	}

	@Override
	public int hashCode() {
		return _piano.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _piano.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _piano.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _piano.isNew();
	}

	@Override
	public void persist() {
		_piano.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_piano.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cod_piano of this piano.
	 *
	 * @param cod_piano the cod_piano of this piano
	 */
	@Override
	public void setCod_piano(String cod_piano) {
		_piano.setCod_piano(cod_piano);
	}

	/**
	 * Sets the data_agg of this piano.
	 *
	 * @param data_agg the data_agg of this piano
	 */
	@Override
	public void setData_agg(String data_agg) {
		_piano.setData_agg(data_agg);
	}

	/**
	 * Sets the data_ins of this piano.
	 *
	 * @param data_ins the data_ins of this piano
	 */
	@Override
	public void setData_ins(String data_ins) {
		_piano.setData_ins(data_ins);
	}

	/**
	 * Sets the desc of this piano.
	 *
	 * @param desc the desc of this piano
	 */
	@Override
	public void setDesc(String desc) {
		_piano.setDesc(desc);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_piano.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_piano.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_piano.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_piano of this piano.
	 *
	 * @param id_piano the id_piano of this piano
	 */
	@Override
	public void setId_piano(long id_piano) {
		_piano.setId_piano(id_piano);
	}

	/**
	 * Sets the id_pk_piano of this piano.
	 *
	 * @param id_pk_piano the id_pk_piano of this piano
	 */
	@Override
	public void setId_pk_piano(long id_pk_piano) {
		_piano.setId_pk_piano(id_pk_piano);
	}

	/**
	 * Sets the id_sede of this piano.
	 *
	 * @param id_sede the id_sede of this piano
	 */
	@Override
	public void setId_sede(long id_sede) {
		_piano.setId_sede(id_sede);
	}

	@Override
	public void setNew(boolean n) {
		_piano.setNew(n);
	}

	/**
	 * Sets the primary key of this piano.
	 *
	 * @param primaryKey the primary key of this piano
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_piano.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_piano.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user_agg of this piano.
	 *
	 * @param user_agg the user_agg of this piano
	 */
	@Override
	public void setUser_agg(String user_agg) {
		_piano.setUser_agg(user_agg);
	}

	/**
	 * Sets the user_ins of this piano.
	 *
	 * @param user_ins the user_ins of this piano
	 */
	@Override
	public void setUser_ins(String user_ins) {
		_piano.setUser_ins(user_ins);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<mef.richiesta.gest.pos.model.Piano> toCacheModel() {

		return _piano.toCacheModel();
	}

	@Override
	public mef.richiesta.gest.pos.model.Piano toEscapedModel() {
		return new PianoWrapper(_piano.toEscapedModel());
	}

	@Override
	public String toString() {
		return _piano.toString();
	}

	@Override
	public mef.richiesta.gest.pos.model.Piano toUnescapedModel() {
		return new PianoWrapper(_piano.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _piano.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PianoWrapper)) {
			return false;
		}

		PianoWrapper pianoWrapper = (PianoWrapper)obj;

		if (Objects.equals(_piano, pianoWrapper._piano)) {
			return true;
		}

		return false;
	}

	@Override
	public Piano getWrappedModel() {
		return _piano;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _piano.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _piano.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_piano.resetOriginalValues();
	}

	private final Piano _piano;

}