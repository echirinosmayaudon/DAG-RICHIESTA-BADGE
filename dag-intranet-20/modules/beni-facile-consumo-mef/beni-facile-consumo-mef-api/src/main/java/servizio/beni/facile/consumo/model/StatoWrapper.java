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

package servizio.beni.facile.consumo.model;

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
 * This class is a wrapper for {@link Stato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Stato
 * @generated
 */
@ProviderType
public class StatoWrapper implements Stato, ModelWrapper<Stato> {
	public StatoWrapper(Stato stato) {
		_stato = stato;
	}

	@Override
	public Class<?> getModelClass() {
		return Stato.class;
	}

	@Override
	public String getModelClassName() {
		return Stato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _stato.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _stato.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _stato.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _stato.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.beni.facile.consumo.model.Stato> toCacheModel() {
		return _stato.toCacheModel();
	}

	@Override
	public int compareTo(servizio.beni.facile.consumo.model.Stato stato) {
		return _stato.compareTo(stato);
	}

	@Override
	public int hashCode() {
		return _stato.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stato.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StatoWrapper((Stato)_stato.clone());
	}

	/**
	* Returns the descrizione of this stato.
	*
	* @return the descrizione of this stato
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _stato.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _stato.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _stato.toXmlString();
	}

	/**
	* Returns the ID of this stato.
	*
	* @return the ID of this stato
	*/
	@Override
	public long getId() {
		return _stato.getId();
	}

	/**
	* Returns the primary key of this stato.
	*
	* @return the primary key of this stato
	*/
	@Override
	public long getPrimaryKey() {
		return _stato.getPrimaryKey();
	}

	@Override
	public servizio.beni.facile.consumo.model.Stato toEscapedModel() {
		return new StatoWrapper(_stato.toEscapedModel());
	}

	@Override
	public servizio.beni.facile.consumo.model.Stato toUnescapedModel() {
		return new StatoWrapper(_stato.toUnescapedModel());
	}

	@Override
	public void persist() {
		_stato.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_stato.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this stato.
	*
	* @param descrizione the descrizione of this stato
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_stato.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_stato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_stato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_stato.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this stato.
	*
	* @param id the ID of this stato
	*/
	@Override
	public void setId(long id) {
		_stato.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_stato.setNew(n);
	}

	/**
	* Sets the primary key of this stato.
	*
	* @param primaryKey the primary key of this stato
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_stato.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_stato.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoWrapper)) {
			return false;
		}

		StatoWrapper statoWrapper = (StatoWrapper)obj;

		if (Objects.equals(_stato, statoWrapper._stato)) {
			return true;
		}

		return false;
	}

	@Override
	public Stato getWrappedModel() {
		return _stato;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _stato.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _stato.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_stato.resetOriginalValues();
	}

	private final Stato _stato;
}