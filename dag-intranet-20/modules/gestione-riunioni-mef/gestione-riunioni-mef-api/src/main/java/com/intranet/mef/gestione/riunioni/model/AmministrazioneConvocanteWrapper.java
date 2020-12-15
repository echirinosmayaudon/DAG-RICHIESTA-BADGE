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
 * This class is a wrapper for {@link AmministrazioneConvocante}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmministrazioneConvocante
 * @generated
 */
@ProviderType
public class AmministrazioneConvocanteWrapper
	implements AmministrazioneConvocante,
		ModelWrapper<AmministrazioneConvocante> {
	public AmministrazioneConvocanteWrapper(
		AmministrazioneConvocante amministrazioneConvocante) {
		_amministrazioneConvocante = amministrazioneConvocante;
	}

	@Override
	public Class<?> getModelClass() {
		return AmministrazioneConvocante.class;
	}

	@Override
	public String getModelClassName() {
		return AmministrazioneConvocante.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_amministrazione_convocante",
			getId_amministrazione_convocante());
		attributes.put("nome_amministrazione", getNome_amministrazione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_amministrazione_convocante = (Long)attributes.get(
				"id_amministrazione_convocante");

		if (id_amministrazione_convocante != null) {
			setId_amministrazione_convocante(id_amministrazione_convocante);
		}

		String nome_amministrazione = (String)attributes.get(
				"nome_amministrazione");

		if (nome_amministrazione != null) {
			setNome_amministrazione(nome_amministrazione);
		}
	}

	@Override
	public AmministrazioneConvocante toEscapedModel() {
		return new AmministrazioneConvocanteWrapper(_amministrazioneConvocante.toEscapedModel());
	}

	@Override
	public AmministrazioneConvocante toUnescapedModel() {
		return new AmministrazioneConvocanteWrapper(_amministrazioneConvocante.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _amministrazioneConvocante.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _amministrazioneConvocante.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _amministrazioneConvocante.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _amministrazioneConvocante.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AmministrazioneConvocante> toCacheModel() {
		return _amministrazioneConvocante.toCacheModel();
	}

	@Override
	public int compareTo(AmministrazioneConvocante amministrazioneConvocante) {
		return _amministrazioneConvocante.compareTo(amministrazioneConvocante);
	}

	@Override
	public int hashCode() {
		return _amministrazioneConvocante.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amministrazioneConvocante.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AmministrazioneConvocanteWrapper((AmministrazioneConvocante)_amministrazioneConvocante.clone());
	}

	/**
	* Returns the nome_amministrazione of this amministrazione convocante.
	*
	* @return the nome_amministrazione of this amministrazione convocante
	*/
	@Override
	public java.lang.String getNome_amministrazione() {
		return _amministrazioneConvocante.getNome_amministrazione();
	}

	@Override
	public java.lang.String toString() {
		return _amministrazioneConvocante.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _amministrazioneConvocante.toXmlString();
	}

	/**
	* Returns the id_amministrazione_convocante of this amministrazione convocante.
	*
	* @return the id_amministrazione_convocante of this amministrazione convocante
	*/
	@Override
	public long getId_amministrazione_convocante() {
		return _amministrazioneConvocante.getId_amministrazione_convocante();
	}

	/**
	* Returns the primary key of this amministrazione convocante.
	*
	* @return the primary key of this amministrazione convocante
	*/
	@Override
	public long getPrimaryKey() {
		return _amministrazioneConvocante.getPrimaryKey();
	}

	@Override
	public void persist() {
		_amministrazioneConvocante.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_amministrazioneConvocante.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_amministrazioneConvocante.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_amministrazioneConvocante.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_amministrazioneConvocante.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_amministrazione_convocante of this amministrazione convocante.
	*
	* @param id_amministrazione_convocante the id_amministrazione_convocante of this amministrazione convocante
	*/
	@Override
	public void setId_amministrazione_convocante(
		long id_amministrazione_convocante) {
		_amministrazioneConvocante.setId_amministrazione_convocante(id_amministrazione_convocante);
	}

	@Override
	public void setNew(boolean n) {
		_amministrazioneConvocante.setNew(n);
	}

	/**
	* Sets the nome_amministrazione of this amministrazione convocante.
	*
	* @param nome_amministrazione the nome_amministrazione of this amministrazione convocante
	*/
	@Override
	public void setNome_amministrazione(java.lang.String nome_amministrazione) {
		_amministrazioneConvocante.setNome_amministrazione(nome_amministrazione);
	}

	/**
	* Sets the primary key of this amministrazione convocante.
	*
	* @param primaryKey the primary key of this amministrazione convocante
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_amministrazioneConvocante.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_amministrazioneConvocante.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AmministrazioneConvocanteWrapper)) {
			return false;
		}

		AmministrazioneConvocanteWrapper amministrazioneConvocanteWrapper = (AmministrazioneConvocanteWrapper)obj;

		if (Objects.equals(_amministrazioneConvocante,
					amministrazioneConvocanteWrapper._amministrazioneConvocante)) {
			return true;
		}

		return false;
	}

	@Override
	public AmministrazioneConvocante getWrappedModel() {
		return _amministrazioneConvocante;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _amministrazioneConvocante.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _amministrazioneConvocante.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_amministrazioneConvocante.resetOriginalValues();
	}

	private final AmministrazioneConvocante _amministrazioneConvocante;
}