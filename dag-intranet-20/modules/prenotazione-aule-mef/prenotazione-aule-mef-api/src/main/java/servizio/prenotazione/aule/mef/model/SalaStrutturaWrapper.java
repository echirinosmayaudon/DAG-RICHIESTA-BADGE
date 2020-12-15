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
 * This class is a wrapper for {@link SalaStruttura}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaStruttura
 * @generated
 */
@ProviderType
public class SalaStrutturaWrapper implements SalaStruttura,
	ModelWrapper<SalaStruttura> {
	public SalaStrutturaWrapper(SalaStruttura salaStruttura) {
		_salaStruttura = salaStruttura;
	}

	@Override
	public Class<?> getModelClass() {
		return SalaStruttura.class;
	}

	@Override
	public String getModelClassName() {
		return SalaStruttura.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("id_sala", getId_sala());
		attributes.put("id_struttura", getId_struttura());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		Long id_struttura = (Long)attributes.get("id_struttura");

		if (id_struttura != null) {
			setId_struttura(id_struttura);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _salaStruttura.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _salaStruttura.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _salaStruttura.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _salaStruttura.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.SalaStruttura> toCacheModel() {
		return _salaStruttura.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.SalaStruttura salaStruttura) {
		return _salaStruttura.compareTo(salaStruttura);
	}

	@Override
	public int hashCode() {
		return _salaStruttura.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _salaStruttura.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SalaStrutturaWrapper((SalaStruttura)_salaStruttura.clone());
	}

	@Override
	public java.lang.String toString() {
		return _salaStruttura.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _salaStruttura.toXmlString();
	}

	/**
	* Returns the ID of this sala struttura.
	*
	* @return the ID of this sala struttura
	*/
	@Override
	public long getId() {
		return _salaStruttura.getId();
	}

	/**
	* Returns the id_sala of this sala struttura.
	*
	* @return the id_sala of this sala struttura
	*/
	@Override
	public long getId_sala() {
		return _salaStruttura.getId_sala();
	}

	/**
	* Returns the id_struttura of this sala struttura.
	*
	* @return the id_struttura of this sala struttura
	*/
	@Override
	public long getId_struttura() {
		return _salaStruttura.getId_struttura();
	}

	/**
	* Returns the primary key of this sala struttura.
	*
	* @return the primary key of this sala struttura
	*/
	@Override
	public long getPrimaryKey() {
		return _salaStruttura.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.SalaStruttura toEscapedModel() {
		return new SalaStrutturaWrapper(_salaStruttura.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.SalaStruttura toUnescapedModel() {
		return new SalaStrutturaWrapper(_salaStruttura.toUnescapedModel());
	}

	@Override
	public void persist() {
		_salaStruttura.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_salaStruttura.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_salaStruttura.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_salaStruttura.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_salaStruttura.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this sala struttura.
	*
	* @param id the ID of this sala struttura
	*/
	@Override
	public void setId(long id) {
		_salaStruttura.setId(id);
	}

	/**
	* Sets the id_sala of this sala struttura.
	*
	* @param id_sala the id_sala of this sala struttura
	*/
	@Override
	public void setId_sala(long id_sala) {
		_salaStruttura.setId_sala(id_sala);
	}

	/**
	* Sets the id_struttura of this sala struttura.
	*
	* @param id_struttura the id_struttura of this sala struttura
	*/
	@Override
	public void setId_struttura(long id_struttura) {
		_salaStruttura.setId_struttura(id_struttura);
	}

	@Override
	public void setNew(boolean n) {
		_salaStruttura.setNew(n);
	}

	/**
	* Sets the primary key of this sala struttura.
	*
	* @param primaryKey the primary key of this sala struttura
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_salaStruttura.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_salaStruttura.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SalaStrutturaWrapper)) {
			return false;
		}

		SalaStrutturaWrapper salaStrutturaWrapper = (SalaStrutturaWrapper)obj;

		if (Objects.equals(_salaStruttura, salaStrutturaWrapper._salaStruttura)) {
			return true;
		}

		return false;
	}

	@Override
	public SalaStruttura getWrappedModel() {
		return _salaStruttura;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _salaStruttura.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _salaStruttura.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_salaStruttura.resetOriginalValues();
	}

	private final SalaStruttura _salaStruttura;
}