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
 * This class is a wrapper for {@link FuoriPorta}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FuoriPorta
 * @generated
 */
@ProviderType
public class FuoriPortaWrapper implements FuoriPorta, ModelWrapper<FuoriPorta> {

	public FuoriPortaWrapper(FuoriPorta fuoriPorta) {
		_fuoriPorta = fuoriPorta;
	}

	@Override
	public Class<?> getModelClass() {
		return FuoriPorta.class;
	}

	@Override
	public String getModelClassName() {
		return FuoriPorta.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_pk_fuoriPorta", getId_pk_fuoriPorta());
		attributes.put("id_fuoriPorta", getId_fuoriPorta());
		attributes.put("id_corridoio", getId_corridoio());
		attributes.put("cod_fuoriPorta", getCod_fuoriPorta());
		attributes.put("desc", getDesc());
		attributes.put("data_ins", getData_ins());
		attributes.put("data_agg", getData_agg());
		attributes.put("user_ins", getUser_ins());
		attributes.put("user_agg", getUser_agg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_pk_fuoriPorta = (Long)attributes.get("id_pk_fuoriPorta");

		if (id_pk_fuoriPorta != null) {
			setId_pk_fuoriPorta(id_pk_fuoriPorta);
		}

		Long id_fuoriPorta = (Long)attributes.get("id_fuoriPorta");

		if (id_fuoriPorta != null) {
			setId_fuoriPorta(id_fuoriPorta);
		}

		Long id_corridoio = (Long)attributes.get("id_corridoio");

		if (id_corridoio != null) {
			setId_corridoio(id_corridoio);
		}

		String cod_fuoriPorta = (String)attributes.get("cod_fuoriPorta");

		if (cod_fuoriPorta != null) {
			setCod_fuoriPorta(cod_fuoriPorta);
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
		return new FuoriPortaWrapper((FuoriPorta)_fuoriPorta.clone());
	}

	@Override
	public int compareTo(mef.richiesta.gest.pos.model.FuoriPorta fuoriPorta) {
		return _fuoriPorta.compareTo(fuoriPorta);
	}

	/**
	 * Returns the cod_fuori porta of this fuori porta.
	 *
	 * @return the cod_fuori porta of this fuori porta
	 */
	@Override
	public String getCod_fuoriPorta() {
		return _fuoriPorta.getCod_fuoriPorta();
	}

	/**
	 * Returns the data_agg of this fuori porta.
	 *
	 * @return the data_agg of this fuori porta
	 */
	@Override
	public String getData_agg() {
		return _fuoriPorta.getData_agg();
	}

	/**
	 * Returns the data_ins of this fuori porta.
	 *
	 * @return the data_ins of this fuori porta
	 */
	@Override
	public String getData_ins() {
		return _fuoriPorta.getData_ins();
	}

	/**
	 * Returns the desc of this fuori porta.
	 *
	 * @return the desc of this fuori porta
	 */
	@Override
	public String getDesc() {
		return _fuoriPorta.getDesc();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fuoriPorta.getExpandoBridge();
	}

	/**
	 * Returns the id_corridoio of this fuori porta.
	 *
	 * @return the id_corridoio of this fuori porta
	 */
	@Override
	public long getId_corridoio() {
		return _fuoriPorta.getId_corridoio();
	}

	/**
	 * Returns the id_fuori porta of this fuori porta.
	 *
	 * @return the id_fuori porta of this fuori porta
	 */
	@Override
	public long getId_fuoriPorta() {
		return _fuoriPorta.getId_fuoriPorta();
	}

	/**
	 * Returns the id_pk_fuori porta of this fuori porta.
	 *
	 * @return the id_pk_fuori porta of this fuori porta
	 */
	@Override
	public long getId_pk_fuoriPorta() {
		return _fuoriPorta.getId_pk_fuoriPorta();
	}

	/**
	 * Returns the primary key of this fuori porta.
	 *
	 * @return the primary key of this fuori porta
	 */
	@Override
	public long getPrimaryKey() {
		return _fuoriPorta.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fuoriPorta.getPrimaryKeyObj();
	}

	/**
	 * Returns the user_agg of this fuori porta.
	 *
	 * @return the user_agg of this fuori porta
	 */
	@Override
	public String getUser_agg() {
		return _fuoriPorta.getUser_agg();
	}

	/**
	 * Returns the user_ins of this fuori porta.
	 *
	 * @return the user_ins of this fuori porta
	 */
	@Override
	public String getUser_ins() {
		return _fuoriPorta.getUser_ins();
	}

	@Override
	public int hashCode() {
		return _fuoriPorta.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _fuoriPorta.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fuoriPorta.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fuoriPorta.isNew();
	}

	@Override
	public void persist() {
		_fuoriPorta.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fuoriPorta.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cod_fuori porta of this fuori porta.
	 *
	 * @param cod_fuoriPorta the cod_fuori porta of this fuori porta
	 */
	@Override
	public void setCod_fuoriPorta(String cod_fuoriPorta) {
		_fuoriPorta.setCod_fuoriPorta(cod_fuoriPorta);
	}

	/**
	 * Sets the data_agg of this fuori porta.
	 *
	 * @param data_agg the data_agg of this fuori porta
	 */
	@Override
	public void setData_agg(String data_agg) {
		_fuoriPorta.setData_agg(data_agg);
	}

	/**
	 * Sets the data_ins of this fuori porta.
	 *
	 * @param data_ins the data_ins of this fuori porta
	 */
	@Override
	public void setData_ins(String data_ins) {
		_fuoriPorta.setData_ins(data_ins);
	}

	/**
	 * Sets the desc of this fuori porta.
	 *
	 * @param desc the desc of this fuori porta
	 */
	@Override
	public void setDesc(String desc) {
		_fuoriPorta.setDesc(desc);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_fuoriPorta.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fuoriPorta.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fuoriPorta.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_corridoio of this fuori porta.
	 *
	 * @param id_corridoio the id_corridoio of this fuori porta
	 */
	@Override
	public void setId_corridoio(long id_corridoio) {
		_fuoriPorta.setId_corridoio(id_corridoio);
	}

	/**
	 * Sets the id_fuori porta of this fuori porta.
	 *
	 * @param id_fuoriPorta the id_fuori porta of this fuori porta
	 */
	@Override
	public void setId_fuoriPorta(long id_fuoriPorta) {
		_fuoriPorta.setId_fuoriPorta(id_fuoriPorta);
	}

	/**
	 * Sets the id_pk_fuori porta of this fuori porta.
	 *
	 * @param id_pk_fuoriPorta the id_pk_fuori porta of this fuori porta
	 */
	@Override
	public void setId_pk_fuoriPorta(long id_pk_fuoriPorta) {
		_fuoriPorta.setId_pk_fuoriPorta(id_pk_fuoriPorta);
	}

	@Override
	public void setNew(boolean n) {
		_fuoriPorta.setNew(n);
	}

	/**
	 * Sets the primary key of this fuori porta.
	 *
	 * @param primaryKey the primary key of this fuori porta
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fuoriPorta.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fuoriPorta.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user_agg of this fuori porta.
	 *
	 * @param user_agg the user_agg of this fuori porta
	 */
	@Override
	public void setUser_agg(String user_agg) {
		_fuoriPorta.setUser_agg(user_agg);
	}

	/**
	 * Sets the user_ins of this fuori porta.
	 *
	 * @param user_ins the user_ins of this fuori porta
	 */
	@Override
	public void setUser_ins(String user_ins) {
		_fuoriPorta.setUser_ins(user_ins);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<mef.richiesta.gest.pos.model.FuoriPorta> toCacheModel() {

		return _fuoriPorta.toCacheModel();
	}

	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta toEscapedModel() {
		return new FuoriPortaWrapper(_fuoriPorta.toEscapedModel());
	}

	@Override
	public String toString() {
		return _fuoriPorta.toString();
	}

	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta toUnescapedModel() {
		return new FuoriPortaWrapper(_fuoriPorta.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _fuoriPorta.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FuoriPortaWrapper)) {
			return false;
		}

		FuoriPortaWrapper fuoriPortaWrapper = (FuoriPortaWrapper)obj;

		if (Objects.equals(_fuoriPorta, fuoriPortaWrapper._fuoriPorta)) {
			return true;
		}

		return false;
	}

	@Override
	public FuoriPorta getWrappedModel() {
		return _fuoriPorta;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fuoriPorta.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fuoriPorta.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fuoriPorta.resetOriginalValues();
	}

	private final FuoriPorta _fuoriPorta;

}