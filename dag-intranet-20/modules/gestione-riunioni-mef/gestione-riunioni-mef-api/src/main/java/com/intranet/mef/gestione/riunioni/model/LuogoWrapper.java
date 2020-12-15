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
 * This class is a wrapper for {@link Luogo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Luogo
 * @generated
 */
@ProviderType
public class LuogoWrapper implements Luogo, ModelWrapper<Luogo> {
	public LuogoWrapper(Luogo luogo) {
		_luogo = luogo;
	}

	@Override
	public Class<?> getModelClass() {
		return Luogo.class;
	}

	@Override
	public String getModelClassName() {
		return Luogo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_luogo", getId_luogo());
		attributes.put("nome", getNome());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_luogo = (Long)attributes.get("id_luogo");

		if (id_luogo != null) {
			setId_luogo(id_luogo);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}
	}

	@Override
	public Luogo toEscapedModel() {
		return new LuogoWrapper(_luogo.toEscapedModel());
	}

	@Override
	public Luogo toUnescapedModel() {
		return new LuogoWrapper(_luogo.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _luogo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _luogo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _luogo.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _luogo.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Luogo> toCacheModel() {
		return _luogo.toCacheModel();
	}

	@Override
	public int compareTo(Luogo luogo) {
		return _luogo.compareTo(luogo);
	}

	@Override
	public int hashCode() {
		return _luogo.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _luogo.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LuogoWrapper((Luogo)_luogo.clone());
	}

	/**
	* Returns the nome of this luogo.
	*
	* @return the nome of this luogo
	*/
	@Override
	public java.lang.String getNome() {
		return _luogo.getNome();
	}

	@Override
	public java.lang.String toString() {
		return _luogo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _luogo.toXmlString();
	}

	/**
	* Returns the id_luogo of this luogo.
	*
	* @return the id_luogo of this luogo
	*/
	@Override
	public long getId_luogo() {
		return _luogo.getId_luogo();
	}

	/**
	* Returns the primary key of this luogo.
	*
	* @return the primary key of this luogo
	*/
	@Override
	public long getPrimaryKey() {
		return _luogo.getPrimaryKey();
	}

	@Override
	public void persist() {
		_luogo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_luogo.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_luogo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_luogo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_luogo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_luogo of this luogo.
	*
	* @param id_luogo the id_luogo of this luogo
	*/
	@Override
	public void setId_luogo(long id_luogo) {
		_luogo.setId_luogo(id_luogo);
	}

	@Override
	public void setNew(boolean n) {
		_luogo.setNew(n);
	}

	/**
	* Sets the nome of this luogo.
	*
	* @param nome the nome of this luogo
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_luogo.setNome(nome);
	}

	/**
	* Sets the primary key of this luogo.
	*
	* @param primaryKey the primary key of this luogo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_luogo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_luogo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LuogoWrapper)) {
			return false;
		}

		LuogoWrapper luogoWrapper = (LuogoWrapper)obj;

		if (Objects.equals(_luogo, luogoWrapper._luogo)) {
			return true;
		}

		return false;
	}

	@Override
	public Luogo getWrappedModel() {
		return _luogo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _luogo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _luogo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_luogo.resetOriginalValues();
	}

	private final Luogo _luogo;
}