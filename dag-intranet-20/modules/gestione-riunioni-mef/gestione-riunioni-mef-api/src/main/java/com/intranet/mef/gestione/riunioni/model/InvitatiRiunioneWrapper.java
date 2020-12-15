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
 * This class is a wrapper for {@link InvitatiRiunione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitatiRiunione
 * @generated
 */
@ProviderType
public class InvitatiRiunioneWrapper implements InvitatiRiunione,
	ModelWrapper<InvitatiRiunione> {
	public InvitatiRiunioneWrapper(InvitatiRiunione invitatiRiunione) {
		_invitatiRiunione = invitatiRiunione;
	}

	@Override
	public Class<?> getModelClass() {
		return InvitatiRiunione.class;
	}

	@Override
	public String getModelClassName() {
		return InvitatiRiunione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_segreteria", getId_segreteria());
		attributes.put("note", getNote());
		attributes.put("partecipanti", getPartecipanti());
		attributes.put("id_stato_invitato", getId_stato_invitato());
		attributes.put("id_riunione", getId_riunione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_segreteria = (Long)attributes.get("id_segreteria");

		if (id_segreteria != null) {
			setId_segreteria(id_segreteria);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String partecipanti = (String)attributes.get("partecipanti");

		if (partecipanti != null) {
			setPartecipanti(partecipanti);
		}

		Long id_stato_invitato = (Long)attributes.get("id_stato_invitato");

		if (id_stato_invitato != null) {
			setId_stato_invitato(id_stato_invitato);
		}

		Long id_riunione = (Long)attributes.get("id_riunione");

		if (id_riunione != null) {
			setId_riunione(id_riunione);
		}
	}

	@Override
	public InvitatiRiunione toEscapedModel() {
		return new InvitatiRiunioneWrapper(_invitatiRiunione.toEscapedModel());
	}

	@Override
	public InvitatiRiunione toUnescapedModel() {
		return new InvitatiRiunioneWrapper(_invitatiRiunione.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _invitatiRiunione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _invitatiRiunione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _invitatiRiunione.isNew();
	}

	/**
	* Returns the primary key of this invitati riunione.
	*
	* @return the primary key of this invitati riunione
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK getPrimaryKey() {
		return _invitatiRiunione.getPrimaryKey();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _invitatiRiunione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<InvitatiRiunione> toCacheModel() {
		return _invitatiRiunione.toCacheModel();
	}

	@Override
	public int compareTo(InvitatiRiunione invitatiRiunione) {
		return _invitatiRiunione.compareTo(invitatiRiunione);
	}

	@Override
	public int hashCode() {
		return _invitatiRiunione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _invitatiRiunione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new InvitatiRiunioneWrapper((InvitatiRiunione)_invitatiRiunione.clone());
	}

	/**
	* Returns the note of this invitati riunione.
	*
	* @return the note of this invitati riunione
	*/
	@Override
	public java.lang.String getNote() {
		return _invitatiRiunione.getNote();
	}

	/**
	* Returns the partecipanti of this invitati riunione.
	*
	* @return the partecipanti of this invitati riunione
	*/
	@Override
	public java.lang.String getPartecipanti() {
		return _invitatiRiunione.getPartecipanti();
	}

	@Override
	public java.lang.String toString() {
		return _invitatiRiunione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _invitatiRiunione.toXmlString();
	}

	/**
	* Returns the id_riunione of this invitati riunione.
	*
	* @return the id_riunione of this invitati riunione
	*/
	@Override
	public long getId_riunione() {
		return _invitatiRiunione.getId_riunione();
	}

	/**
	* Returns the id_segreteria of this invitati riunione.
	*
	* @return the id_segreteria of this invitati riunione
	*/
	@Override
	public long getId_segreteria() {
		return _invitatiRiunione.getId_segreteria();
	}

	/**
	* Returns the id_stato_invitato of this invitati riunione.
	*
	* @return the id_stato_invitato of this invitati riunione
	*/
	@Override
	public long getId_stato_invitato() {
		return _invitatiRiunione.getId_stato_invitato();
	}

	@Override
	public void persist() {
		_invitatiRiunione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_invitatiRiunione.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_invitatiRiunione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_invitatiRiunione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_invitatiRiunione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_riunione of this invitati riunione.
	*
	* @param id_riunione the id_riunione of this invitati riunione
	*/
	@Override
	public void setId_riunione(long id_riunione) {
		_invitatiRiunione.setId_riunione(id_riunione);
	}

	/**
	* Sets the id_segreteria of this invitati riunione.
	*
	* @param id_segreteria the id_segreteria of this invitati riunione
	*/
	@Override
	public void setId_segreteria(long id_segreteria) {
		_invitatiRiunione.setId_segreteria(id_segreteria);
	}

	/**
	* Sets the id_stato_invitato of this invitati riunione.
	*
	* @param id_stato_invitato the id_stato_invitato of this invitati riunione
	*/
	@Override
	public void setId_stato_invitato(long id_stato_invitato) {
		_invitatiRiunione.setId_stato_invitato(id_stato_invitato);
	}

	@Override
	public void setNew(boolean n) {
		_invitatiRiunione.setNew(n);
	}

	/**
	* Sets the note of this invitati riunione.
	*
	* @param note the note of this invitati riunione
	*/
	@Override
	public void setNote(java.lang.String note) {
		_invitatiRiunione.setNote(note);
	}

	/**
	* Sets the partecipanti of this invitati riunione.
	*
	* @param partecipanti the partecipanti of this invitati riunione
	*/
	@Override
	public void setPartecipanti(java.lang.String partecipanti) {
		_invitatiRiunione.setPartecipanti(partecipanti);
	}

	/**
	* Sets the primary key of this invitati riunione.
	*
	* @param primaryKey the primary key of this invitati riunione
	*/
	@Override
	public void setPrimaryKey(
		com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK primaryKey) {
		_invitatiRiunione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_invitatiRiunione.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InvitatiRiunioneWrapper)) {
			return false;
		}

		InvitatiRiunioneWrapper invitatiRiunioneWrapper = (InvitatiRiunioneWrapper)obj;

		if (Objects.equals(_invitatiRiunione,
					invitatiRiunioneWrapper._invitatiRiunione)) {
			return true;
		}

		return false;
	}

	@Override
	public InvitatiRiunione getWrappedModel() {
		return _invitatiRiunione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _invitatiRiunione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _invitatiRiunione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_invitatiRiunione.resetOriginalValues();
	}

	private final InvitatiRiunione _invitatiRiunione;
}