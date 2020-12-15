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

package servizio.richieste.badge.mef.model;

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
 * This class is a wrapper for {@link SediEsterne}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediEsterne
 * @generated
 */
@ProviderType
public class SediEsterneWrapper implements SediEsterne,
	ModelWrapper<SediEsterne> {
	public SediEsterneWrapper(SediEsterne sediEsterne) {
		_sediEsterne = sediEsterne;
	}

	@Override
	public Class<?> getModelClass() {
		return SediEsterne.class;
	}

	@Override
	public String getModelClassName() {
		return SediEsterne.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_sede_esterna", getId_sede_esterna());
		attributes.put("nome_sede_esterna", getNome_sede_esterna());
		attributes.put("id_sedesiap", getId_sedesiap());
		attributes.put("acronimo_sede", getAcronimo_sede());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_sede_esterna = (Long)attributes.get("id_sede_esterna");

		if (id_sede_esterna != null) {
			setId_sede_esterna(id_sede_esterna);
		}

		String nome_sede_esterna = (String)attributes.get("nome_sede_esterna");

		if (nome_sede_esterna != null) {
			setNome_sede_esterna(nome_sede_esterna);
		}

		Long id_sedesiap = (Long)attributes.get("id_sedesiap");

		if (id_sedesiap != null) {
			setId_sedesiap(id_sedesiap);
		}

		String acronimo_sede = (String)attributes.get("acronimo_sede");

		if (acronimo_sede != null) {
			setAcronimo_sede(acronimo_sede);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _sediEsterne.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _sediEsterne.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _sediEsterne.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sediEsterne.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.richieste.badge.mef.model.SediEsterne> toCacheModel() {
		return _sediEsterne.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.richieste.badge.mef.model.SediEsterne sediEsterne) {
		return _sediEsterne.compareTo(sediEsterne);
	}

	@Override
	public int hashCode() {
		return _sediEsterne.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sediEsterne.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SediEsterneWrapper((SediEsterne)_sediEsterne.clone());
	}

	/**
	* Returns the acronimo_sede of this sedi esterne.
	*
	* @return the acronimo_sede of this sedi esterne
	*/
	@Override
	public java.lang.String getAcronimo_sede() {
		return _sediEsterne.getAcronimo_sede();
	}

	/**
	* Returns the nome_sede_esterna of this sedi esterne.
	*
	* @return the nome_sede_esterna of this sedi esterne
	*/
	@Override
	public java.lang.String getNome_sede_esterna() {
		return _sediEsterne.getNome_sede_esterna();
	}

	@Override
	public java.lang.String toString() {
		return _sediEsterne.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sediEsterne.toXmlString();
	}

	/**
	* Returns the id_sede_esterna of this sedi esterne.
	*
	* @return the id_sede_esterna of this sedi esterne
	*/
	@Override
	public long getId_sede_esterna() {
		return _sediEsterne.getId_sede_esterna();
	}

	/**
	* Returns the id_sedesiap of this sedi esterne.
	*
	* @return the id_sedesiap of this sedi esterne
	*/
	@Override
	public long getId_sedesiap() {
		return _sediEsterne.getId_sedesiap();
	}

	/**
	* Returns the primary key of this sedi esterne.
	*
	* @return the primary key of this sedi esterne
	*/
	@Override
	public long getPrimaryKey() {
		return _sediEsterne.getPrimaryKey();
	}

	@Override
	public servizio.richieste.badge.mef.model.SediEsterne toEscapedModel() {
		return new SediEsterneWrapper(_sediEsterne.toEscapedModel());
	}

	@Override
	public servizio.richieste.badge.mef.model.SediEsterne toUnescapedModel() {
		return new SediEsterneWrapper(_sediEsterne.toUnescapedModel());
	}

	@Override
	public void persist() {
		_sediEsterne.persist();
	}

	/**
	* Sets the acronimo_sede of this sedi esterne.
	*
	* @param acronimo_sede the acronimo_sede of this sedi esterne
	*/
	@Override
	public void setAcronimo_sede(java.lang.String acronimo_sede) {
		_sediEsterne.setAcronimo_sede(acronimo_sede);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sediEsterne.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sediEsterne.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_sediEsterne.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sediEsterne.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_sede_esterna of this sedi esterne.
	*
	* @param id_sede_esterna the id_sede_esterna of this sedi esterne
	*/
	@Override
	public void setId_sede_esterna(long id_sede_esterna) {
		_sediEsterne.setId_sede_esterna(id_sede_esterna);
	}

	/**
	* Sets the id_sedesiap of this sedi esterne.
	*
	* @param id_sedesiap the id_sedesiap of this sedi esterne
	*/
	@Override
	public void setId_sedesiap(long id_sedesiap) {
		_sediEsterne.setId_sedesiap(id_sedesiap);
	}

	@Override
	public void setNew(boolean n) {
		_sediEsterne.setNew(n);
	}

	/**
	* Sets the nome_sede_esterna of this sedi esterne.
	*
	* @param nome_sede_esterna the nome_sede_esterna of this sedi esterne
	*/
	@Override
	public void setNome_sede_esterna(java.lang.String nome_sede_esterna) {
		_sediEsterne.setNome_sede_esterna(nome_sede_esterna);
	}

	/**
	* Sets the primary key of this sedi esterne.
	*
	* @param primaryKey the primary key of this sedi esterne
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sediEsterne.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sediEsterne.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SediEsterneWrapper)) {
			return false;
		}

		SediEsterneWrapper sediEsterneWrapper = (SediEsterneWrapper)obj;

		if (Objects.equals(_sediEsterne, sediEsterneWrapper._sediEsterne)) {
			return true;
		}

		return false;
	}

	@Override
	public SediEsterne getWrappedModel() {
		return _sediEsterne;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sediEsterne.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sediEsterne.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sediEsterne.resetOriginalValues();
	}

	private final SediEsterne _sediEsterne;
}