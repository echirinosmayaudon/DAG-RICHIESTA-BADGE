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
 * This class is a wrapper for {@link StatoInvitato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoInvitato
 * @generated
 */
@ProviderType
public class StatoInvitatoWrapper implements StatoInvitato,
	ModelWrapper<StatoInvitato> {
	public StatoInvitatoWrapper(StatoInvitato statoInvitato) {
		_statoInvitato = statoInvitato;
	}

	@Override
	public Class<?> getModelClass() {
		return StatoInvitato.class;
	}

	@Override
	public String getModelClassName() {
		return StatoInvitato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_stato_invitato", getId_stato_invitato());
		attributes.put("nome_stato", getNome_stato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_stato_invitato = (Long)attributes.get("id_stato_invitato");

		if (id_stato_invitato != null) {
			setId_stato_invitato(id_stato_invitato);
		}

		String nome_stato = (String)attributes.get("nome_stato");

		if (nome_stato != null) {
			setNome_stato(nome_stato);
		}
	}

	@Override
	public StatoInvitato toEscapedModel() {
		return new StatoInvitatoWrapper(_statoInvitato.toEscapedModel());
	}

	@Override
	public StatoInvitato toUnescapedModel() {
		return new StatoInvitatoWrapper(_statoInvitato.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _statoInvitato.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _statoInvitato.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _statoInvitato.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _statoInvitato.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<StatoInvitato> toCacheModel() {
		return _statoInvitato.toCacheModel();
	}

	@Override
	public int compareTo(StatoInvitato statoInvitato) {
		return _statoInvitato.compareTo(statoInvitato);
	}

	@Override
	public int hashCode() {
		return _statoInvitato.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statoInvitato.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StatoInvitatoWrapper((StatoInvitato)_statoInvitato.clone());
	}

	/**
	* Returns the nome_stato of this stato invitato.
	*
	* @return the nome_stato of this stato invitato
	*/
	@Override
	public java.lang.String getNome_stato() {
		return _statoInvitato.getNome_stato();
	}

	@Override
	public java.lang.String toString() {
		return _statoInvitato.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statoInvitato.toXmlString();
	}

	/**
	* Returns the id_stato_invitato of this stato invitato.
	*
	* @return the id_stato_invitato of this stato invitato
	*/
	@Override
	public long getId_stato_invitato() {
		return _statoInvitato.getId_stato_invitato();
	}

	/**
	* Returns the primary key of this stato invitato.
	*
	* @return the primary key of this stato invitato
	*/
	@Override
	public long getPrimaryKey() {
		return _statoInvitato.getPrimaryKey();
	}

	@Override
	public void persist() {
		_statoInvitato.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statoInvitato.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_statoInvitato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_statoInvitato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_statoInvitato.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_stato_invitato of this stato invitato.
	*
	* @param id_stato_invitato the id_stato_invitato of this stato invitato
	*/
	@Override
	public void setId_stato_invitato(long id_stato_invitato) {
		_statoInvitato.setId_stato_invitato(id_stato_invitato);
	}

	@Override
	public void setNew(boolean n) {
		_statoInvitato.setNew(n);
	}

	/**
	* Sets the nome_stato of this stato invitato.
	*
	* @param nome_stato the nome_stato of this stato invitato
	*/
	@Override
	public void setNome_stato(java.lang.String nome_stato) {
		_statoInvitato.setNome_stato(nome_stato);
	}

	/**
	* Sets the primary key of this stato invitato.
	*
	* @param primaryKey the primary key of this stato invitato
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statoInvitato.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_statoInvitato.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoInvitatoWrapper)) {
			return false;
		}

		StatoInvitatoWrapper statoInvitatoWrapper = (StatoInvitatoWrapper)obj;

		if (Objects.equals(_statoInvitato, statoInvitatoWrapper._statoInvitato)) {
			return true;
		}

		return false;
	}

	@Override
	public StatoInvitato getWrappedModel() {
		return _statoInvitato;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _statoInvitato.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _statoInvitato.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_statoInvitato.resetOriginalValues();
	}

	private final StatoInvitato _statoInvitato;
}