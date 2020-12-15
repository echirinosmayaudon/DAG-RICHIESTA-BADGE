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
 * This class is a wrapper for {@link Corridoio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Corridoio
 * @generated
 */
@ProviderType
public class CorridoioWrapper implements Corridoio, ModelWrapper<Corridoio> {

	public CorridoioWrapper(Corridoio corridoio) {
		_corridoio = corridoio;
	}

	@Override
	public Class<?> getModelClass() {
		return Corridoio.class;
	}

	@Override
	public String getModelClassName() {
		return Corridoio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_pk_corridoio", getId_pk_corridoio());
		attributes.put("id_corridoio", getId_corridoio());
		attributes.put("id_piano", getId_piano());
		attributes.put("cod_corridoio", getCod_corridoio());
		attributes.put("desc", getDesc());
		attributes.put("data_ins", getData_ins());
		attributes.put("data_agg", getData_agg());
		attributes.put("user_ins", getUser_ins());
		attributes.put("user_agg", getUser_agg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_pk_corridoio = (Long)attributes.get("id_pk_corridoio");

		if (id_pk_corridoio != null) {
			setId_pk_corridoio(id_pk_corridoio);
		}

		Long id_corridoio = (Long)attributes.get("id_corridoio");

		if (id_corridoio != null) {
			setId_corridoio(id_corridoio);
		}

		Long id_piano = (Long)attributes.get("id_piano");

		if (id_piano != null) {
			setId_piano(id_piano);
		}

		String cod_corridoio = (String)attributes.get("cod_corridoio");

		if (cod_corridoio != null) {
			setCod_corridoio(cod_corridoio);
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
		return new CorridoioWrapper((Corridoio)_corridoio.clone());
	}

	@Override
	public int compareTo(mef.richiesta.gest.pos.model.Corridoio corridoio) {
		return _corridoio.compareTo(corridoio);
	}

	/**
	 * Returns the cod_corridoio of this corridoio.
	 *
	 * @return the cod_corridoio of this corridoio
	 */
	@Override
	public String getCod_corridoio() {
		return _corridoio.getCod_corridoio();
	}

	/**
	 * Returns the data_agg of this corridoio.
	 *
	 * @return the data_agg of this corridoio
	 */
	@Override
	public String getData_agg() {
		return _corridoio.getData_agg();
	}

	/**
	 * Returns the data_ins of this corridoio.
	 *
	 * @return the data_ins of this corridoio
	 */
	@Override
	public String getData_ins() {
		return _corridoio.getData_ins();
	}

	/**
	 * Returns the desc of this corridoio.
	 *
	 * @return the desc of this corridoio
	 */
	@Override
	public String getDesc() {
		return _corridoio.getDesc();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _corridoio.getExpandoBridge();
	}

	/**
	 * Returns the id_corridoio of this corridoio.
	 *
	 * @return the id_corridoio of this corridoio
	 */
	@Override
	public long getId_corridoio() {
		return _corridoio.getId_corridoio();
	}

	/**
	 * Returns the id_piano of this corridoio.
	 *
	 * @return the id_piano of this corridoio
	 */
	@Override
	public long getId_piano() {
		return _corridoio.getId_piano();
	}

	/**
	 * Returns the id_pk_corridoio of this corridoio.
	 *
	 * @return the id_pk_corridoio of this corridoio
	 */
	@Override
	public long getId_pk_corridoio() {
		return _corridoio.getId_pk_corridoio();
	}

	/**
	 * Returns the primary key of this corridoio.
	 *
	 * @return the primary key of this corridoio
	 */
	@Override
	public long getPrimaryKey() {
		return _corridoio.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _corridoio.getPrimaryKeyObj();
	}

	/**
	 * Returns the user_agg of this corridoio.
	 *
	 * @return the user_agg of this corridoio
	 */
	@Override
	public String getUser_agg() {
		return _corridoio.getUser_agg();
	}

	/**
	 * Returns the user_ins of this corridoio.
	 *
	 * @return the user_ins of this corridoio
	 */
	@Override
	public String getUser_ins() {
		return _corridoio.getUser_ins();
	}

	@Override
	public int hashCode() {
		return _corridoio.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _corridoio.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _corridoio.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _corridoio.isNew();
	}

	@Override
	public void persist() {
		_corridoio.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_corridoio.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cod_corridoio of this corridoio.
	 *
	 * @param cod_corridoio the cod_corridoio of this corridoio
	 */
	@Override
	public void setCod_corridoio(String cod_corridoio) {
		_corridoio.setCod_corridoio(cod_corridoio);
	}

	/**
	 * Sets the data_agg of this corridoio.
	 *
	 * @param data_agg the data_agg of this corridoio
	 */
	@Override
	public void setData_agg(String data_agg) {
		_corridoio.setData_agg(data_agg);
	}

	/**
	 * Sets the data_ins of this corridoio.
	 *
	 * @param data_ins the data_ins of this corridoio
	 */
	@Override
	public void setData_ins(String data_ins) {
		_corridoio.setData_ins(data_ins);
	}

	/**
	 * Sets the desc of this corridoio.
	 *
	 * @param desc the desc of this corridoio
	 */
	@Override
	public void setDesc(String desc) {
		_corridoio.setDesc(desc);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_corridoio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_corridoio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_corridoio.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_corridoio of this corridoio.
	 *
	 * @param id_corridoio the id_corridoio of this corridoio
	 */
	@Override
	public void setId_corridoio(long id_corridoio) {
		_corridoio.setId_corridoio(id_corridoio);
	}

	/**
	 * Sets the id_piano of this corridoio.
	 *
	 * @param id_piano the id_piano of this corridoio
	 */
	@Override
	public void setId_piano(long id_piano) {
		_corridoio.setId_piano(id_piano);
	}

	/**
	 * Sets the id_pk_corridoio of this corridoio.
	 *
	 * @param id_pk_corridoio the id_pk_corridoio of this corridoio
	 */
	@Override
	public void setId_pk_corridoio(long id_pk_corridoio) {
		_corridoio.setId_pk_corridoio(id_pk_corridoio);
	}

	@Override
	public void setNew(boolean n) {
		_corridoio.setNew(n);
	}

	/**
	 * Sets the primary key of this corridoio.
	 *
	 * @param primaryKey the primary key of this corridoio
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_corridoio.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_corridoio.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user_agg of this corridoio.
	 *
	 * @param user_agg the user_agg of this corridoio
	 */
	@Override
	public void setUser_agg(String user_agg) {
		_corridoio.setUser_agg(user_agg);
	}

	/**
	 * Sets the user_ins of this corridoio.
	 *
	 * @param user_ins the user_ins of this corridoio
	 */
	@Override
	public void setUser_ins(String user_ins) {
		_corridoio.setUser_ins(user_ins);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<mef.richiesta.gest.pos.model.Corridoio> toCacheModel() {

		return _corridoio.toCacheModel();
	}

	@Override
	public mef.richiesta.gest.pos.model.Corridoio toEscapedModel() {
		return new CorridoioWrapper(_corridoio.toEscapedModel());
	}

	@Override
	public String toString() {
		return _corridoio.toString();
	}

	@Override
	public mef.richiesta.gest.pos.model.Corridoio toUnescapedModel() {
		return new CorridoioWrapper(_corridoio.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _corridoio.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CorridoioWrapper)) {
			return false;
		}

		CorridoioWrapper corridoioWrapper = (CorridoioWrapper)obj;

		if (Objects.equals(_corridoio, corridoioWrapper._corridoio)) {
			return true;
		}

		return false;
	}

	@Override
	public Corridoio getWrappedModel() {
		return _corridoio;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _corridoio.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _corridoio.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_corridoio.resetOriginalValues();
	}

	private final Corridoio _corridoio;

}