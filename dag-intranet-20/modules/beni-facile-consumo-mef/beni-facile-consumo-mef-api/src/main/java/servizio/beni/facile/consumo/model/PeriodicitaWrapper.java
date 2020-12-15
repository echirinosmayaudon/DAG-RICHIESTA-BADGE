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
 * This class is a wrapper for {@link Periodicita}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Periodicita
 * @generated
 */
@ProviderType
public class PeriodicitaWrapper implements Periodicita,
	ModelWrapper<Periodicita> {
	public PeriodicitaWrapper(Periodicita periodicita) {
		_periodicita = periodicita;
	}

	@Override
	public Class<?> getModelClass() {
		return Periodicita.class;
	}

	@Override
	public String getModelClassName() {
		return Periodicita.class.getName();
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
		return _periodicita.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _periodicita.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _periodicita.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _periodicita.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.beni.facile.consumo.model.Periodicita> toCacheModel() {
		return _periodicita.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.beni.facile.consumo.model.Periodicita periodicita) {
		return _periodicita.compareTo(periodicita);
	}

	@Override
	public int hashCode() {
		return _periodicita.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _periodicita.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PeriodicitaWrapper((Periodicita)_periodicita.clone());
	}

	/**
	* Returns the descrizione of this periodicita.
	*
	* @return the descrizione of this periodicita
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _periodicita.getDescrizione();
	}

	@Override
	public java.lang.String toString() {
		return _periodicita.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _periodicita.toXmlString();
	}

	/**
	* Returns the ID of this periodicita.
	*
	* @return the ID of this periodicita
	*/
	@Override
	public long getId() {
		return _periodicita.getId();
	}

	/**
	* Returns the primary key of this periodicita.
	*
	* @return the primary key of this periodicita
	*/
	@Override
	public long getPrimaryKey() {
		return _periodicita.getPrimaryKey();
	}

	@Override
	public servizio.beni.facile.consumo.model.Periodicita toEscapedModel() {
		return new PeriodicitaWrapper(_periodicita.toEscapedModel());
	}

	@Override
	public servizio.beni.facile.consumo.model.Periodicita toUnescapedModel() {
		return new PeriodicitaWrapper(_periodicita.toUnescapedModel());
	}

	@Override
	public void persist() {
		_periodicita.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_periodicita.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this periodicita.
	*
	* @param descrizione the descrizione of this periodicita
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_periodicita.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_periodicita.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_periodicita.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_periodicita.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this periodicita.
	*
	* @param id the ID of this periodicita
	*/
	@Override
	public void setId(long id) {
		_periodicita.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_periodicita.setNew(n);
	}

	/**
	* Sets the primary key of this periodicita.
	*
	* @param primaryKey the primary key of this periodicita
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_periodicita.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_periodicita.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PeriodicitaWrapper)) {
			return false;
		}

		PeriodicitaWrapper periodicitaWrapper = (PeriodicitaWrapper)obj;

		if (Objects.equals(_periodicita, periodicitaWrapper._periodicita)) {
			return true;
		}

		return false;
	}

	@Override
	public Periodicita getWrappedModel() {
		return _periodicita;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _periodicita.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _periodicita.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_periodicita.resetOriginalValues();
	}

	private final Periodicita _periodicita;
}