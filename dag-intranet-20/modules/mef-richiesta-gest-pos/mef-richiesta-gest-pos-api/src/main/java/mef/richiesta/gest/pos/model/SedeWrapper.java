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
 * This class is a wrapper for {@link Sede}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Sede
 * @generated
 */
@ProviderType
public class SedeWrapper implements Sede, ModelWrapper<Sede> {

	public SedeWrapper(Sede sede) {
		_sede = sede;
	}

	@Override
	public Class<?> getModelClass() {
		return Sede.class;
	}

	@Override
	public String getModelClassName() {
		return Sede.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_pk_sede", getId_pk_sede());
		attributes.put("id_sede", getId_sede());
		attributes.put("cod_sede", getCod_sede());
		attributes.put("desc", getDesc());
		attributes.put("data_ins", getData_ins());
		attributes.put("data_agg", getData_agg());
		attributes.put("user_ins", getUser_ins());
		attributes.put("user_agg", getUser_agg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_pk_sede = (Long)attributes.get("id_pk_sede");

		if (id_pk_sede != null) {
			setId_pk_sede(id_pk_sede);
		}

		Long id_sede = (Long)attributes.get("id_sede");

		if (id_sede != null) {
			setId_sede(id_sede);
		}

		String cod_sede = (String)attributes.get("cod_sede");

		if (cod_sede != null) {
			setCod_sede(cod_sede);
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
		return new SedeWrapper((Sede)_sede.clone());
	}

	@Override
	public int compareTo(mef.richiesta.gest.pos.model.Sede sede) {
		return _sede.compareTo(sede);
	}

	/**
	 * Returns the cod_sede of this sede.
	 *
	 * @return the cod_sede of this sede
	 */
	@Override
	public String getCod_sede() {
		return _sede.getCod_sede();
	}

	/**
	 * Returns the data_agg of this sede.
	 *
	 * @return the data_agg of this sede
	 */
	@Override
	public String getData_agg() {
		return _sede.getData_agg();
	}

	/**
	 * Returns the data_ins of this sede.
	 *
	 * @return the data_ins of this sede
	 */
	@Override
	public String getData_ins() {
		return _sede.getData_ins();
	}

	/**
	 * Returns the desc of this sede.
	 *
	 * @return the desc of this sede
	 */
	@Override
	public String getDesc() {
		return _sede.getDesc();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sede.getExpandoBridge();
	}

	/**
	 * Returns the id_pk_sede of this sede.
	 *
	 * @return the id_pk_sede of this sede
	 */
	@Override
	public long getId_pk_sede() {
		return _sede.getId_pk_sede();
	}

	/**
	 * Returns the id_sede of this sede.
	 *
	 * @return the id_sede of this sede
	 */
	@Override
	public long getId_sede() {
		return _sede.getId_sede();
	}

	/**
	 * Returns the primary key of this sede.
	 *
	 * @return the primary key of this sede
	 */
	@Override
	public long getPrimaryKey() {
		return _sede.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sede.getPrimaryKeyObj();
	}

	/**
	 * Returns the user_agg of this sede.
	 *
	 * @return the user_agg of this sede
	 */
	@Override
	public String getUser_agg() {
		return _sede.getUser_agg();
	}

	/**
	 * Returns the user_ins of this sede.
	 *
	 * @return the user_ins of this sede
	 */
	@Override
	public String getUser_ins() {
		return _sede.getUser_ins();
	}

	@Override
	public int hashCode() {
		return _sede.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _sede.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _sede.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _sede.isNew();
	}

	@Override
	public void persist() {
		_sede.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sede.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cod_sede of this sede.
	 *
	 * @param cod_sede the cod_sede of this sede
	 */
	@Override
	public void setCod_sede(String cod_sede) {
		_sede.setCod_sede(cod_sede);
	}

	/**
	 * Sets the data_agg of this sede.
	 *
	 * @param data_agg the data_agg of this sede
	 */
	@Override
	public void setData_agg(String data_agg) {
		_sede.setData_agg(data_agg);
	}

	/**
	 * Sets the data_ins of this sede.
	 *
	 * @param data_ins the data_ins of this sede
	 */
	@Override
	public void setData_ins(String data_ins) {
		_sede.setData_ins(data_ins);
	}

	/**
	 * Sets the desc of this sede.
	 *
	 * @param desc the desc of this sede
	 */
	@Override
	public void setDesc(String desc) {
		_sede.setDesc(desc);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_sede.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sede.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sede.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_pk_sede of this sede.
	 *
	 * @param id_pk_sede the id_pk_sede of this sede
	 */
	@Override
	public void setId_pk_sede(long id_pk_sede) {
		_sede.setId_pk_sede(id_pk_sede);
	}

	/**
	 * Sets the id_sede of this sede.
	 *
	 * @param id_sede the id_sede of this sede
	 */
	@Override
	public void setId_sede(long id_sede) {
		_sede.setId_sede(id_sede);
	}

	@Override
	public void setNew(boolean n) {
		_sede.setNew(n);
	}

	/**
	 * Sets the primary key of this sede.
	 *
	 * @param primaryKey the primary key of this sede
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sede.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sede.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user_agg of this sede.
	 *
	 * @param user_agg the user_agg of this sede
	 */
	@Override
	public void setUser_agg(String user_agg) {
		_sede.setUser_agg(user_agg);
	}

	/**
	 * Sets the user_ins of this sede.
	 *
	 * @param user_ins the user_ins of this sede
	 */
	@Override
	public void setUser_ins(String user_ins) {
		_sede.setUser_ins(user_ins);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<mef.richiesta.gest.pos.model.Sede> toCacheModel() {

		return _sede.toCacheModel();
	}

	@Override
	public mef.richiesta.gest.pos.model.Sede toEscapedModel() {
		return new SedeWrapper(_sede.toEscapedModel());
	}

	@Override
	public String toString() {
		return _sede.toString();
	}

	@Override
	public mef.richiesta.gest.pos.model.Sede toUnescapedModel() {
		return new SedeWrapper(_sede.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _sede.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SedeWrapper)) {
			return false;
		}

		SedeWrapper sedeWrapper = (SedeWrapper)obj;

		if (Objects.equals(_sede, sedeWrapper._sede)) {
			return true;
		}

		return false;
	}

	@Override
	public Sede getWrappedModel() {
		return _sede;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sede.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sede.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sede.resetOriginalValues();
	}

	private final Sede _sede;

}