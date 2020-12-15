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

package servizio.prenotazione.aule.mef.model;

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
 * This class is a wrapper for {@link Orario}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Orario
 * @generated
 */
@ProviderType
public class OrarioWrapper implements Orario, ModelWrapper<Orario> {
	public OrarioWrapper(Orario orario) {
		_orario = orario;
	}

	@Override
	public Class<?> getModelClass() {
		return Orario.class;
	}

	@Override
	public String getModelClassName() {
		return Orario.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_ora", getId_ora());
		attributes.put("ore", getOre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_ora = (Long)attributes.get("id_ora");

		if (id_ora != null) {
			setId_ora(id_ora);
		}

		String ore = (String)attributes.get("ore");

		if (ore != null) {
			setOre(ore);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _orario.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _orario.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _orario.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _orario.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.Orario> toCacheModel() {
		return _orario.toCacheModel();
	}

	@Override
	public int compareTo(servizio.prenotazione.aule.mef.model.Orario orario) {
		return _orario.compareTo(orario);
	}

	@Override
	public int hashCode() {
		return _orario.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orario.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new OrarioWrapper((Orario)_orario.clone());
	}

	/**
	* Returns the ore of this orario.
	*
	* @return the ore of this orario
	*/
	@Override
	public java.lang.String getOre() {
		return _orario.getOre();
	}

	@Override
	public java.lang.String toString() {
		return _orario.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _orario.toXmlString();
	}

	/**
	* Returns the id_ora of this orario.
	*
	* @return the id_ora of this orario
	*/
	@Override
	public long getId_ora() {
		return _orario.getId_ora();
	}

	/**
	* Returns the primary key of this orario.
	*
	* @return the primary key of this orario
	*/
	@Override
	public long getPrimaryKey() {
		return _orario.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Orario toEscapedModel() {
		return new OrarioWrapper(_orario.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Orario toUnescapedModel() {
		return new OrarioWrapper(_orario.toUnescapedModel());
	}

	@Override
	public void persist() {
		_orario.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_orario.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_orario.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_orario.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_orario.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_ora of this orario.
	*
	* @param id_ora the id_ora of this orario
	*/
	@Override
	public void setId_ora(long id_ora) {
		_orario.setId_ora(id_ora);
	}

	@Override
	public void setNew(boolean n) {
		_orario.setNew(n);
	}

	/**
	* Sets the ore of this orario.
	*
	* @param ore the ore of this orario
	*/
	@Override
	public void setOre(java.lang.String ore) {
		_orario.setOre(ore);
	}

	/**
	* Sets the primary key of this orario.
	*
	* @param primaryKey the primary key of this orario
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_orario.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_orario.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrarioWrapper)) {
			return false;
		}

		OrarioWrapper orarioWrapper = (OrarioWrapper)obj;

		if (Objects.equals(_orario, orarioWrapper._orario)) {
			return true;
		}

		return false;
	}

	@Override
	public Orario getWrappedModel() {
		return _orario;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _orario.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _orario.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_orario.resetOriginalValues();
	}

	private final Orario _orario;
}