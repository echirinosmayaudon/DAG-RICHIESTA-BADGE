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

package com.accenture.lavoro.agile.istanza.mef.model;

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
 * This class is a wrapper for {@link Email}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Email
 * @generated
 */
@ProviderType
public class EmailWrapper implements Email, ModelWrapper<Email> {
	public EmailWrapper(Email email) {
		_email = email;
	}

	@Override
	public Class<?> getModelClass() {
		return Email.class;
	}

	@Override
	public String getModelClassName() {
		return Email.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idStruttura", getIdStruttura());
		attributes.put("mailCC", getMailCC());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idStruttura = (Long)attributes.get("idStruttura");

		if (idStruttura != null) {
			setIdStruttura(idStruttura);
		}

		String mailCC = (String)attributes.get("mailCC");

		if (mailCC != null) {
			setMailCC(mailCC);
		}
	}

	@Override
	public Email toEscapedModel() {
		return new EmailWrapper(_email.toEscapedModel());
	}

	@Override
	public Email toUnescapedModel() {
		return new EmailWrapper(_email.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _email.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _email.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _email.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _email.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Email> toCacheModel() {
		return _email.toCacheModel();
	}

	@Override
	public int compareTo(Email email) {
		return _email.compareTo(email);
	}

	@Override
	public int hashCode() {
		return _email.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _email.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EmailWrapper((Email)_email.clone());
	}

	/**
	* Returns the mail c c of this email.
	*
	* @return the mail c c of this email
	*/
	@Override
	public java.lang.String getMailCC() {
		return _email.getMailCC();
	}

	@Override
	public java.lang.String toString() {
		return _email.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _email.toXmlString();
	}

	/**
	* Returns the ID of this email.
	*
	* @return the ID of this email
	*/
	@Override
	public long getId() {
		return _email.getId();
	}

	/**
	* Returns the id struttura of this email.
	*
	* @return the id struttura of this email
	*/
	@Override
	public long getIdStruttura() {
		return _email.getIdStruttura();
	}

	/**
	* Returns the primary key of this email.
	*
	* @return the primary key of this email
	*/
	@Override
	public long getPrimaryKey() {
		return _email.getPrimaryKey();
	}

	@Override
	public void persist() {
		_email.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_email.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_email.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_email.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_email.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this email.
	*
	* @param id the ID of this email
	*/
	@Override
	public void setId(long id) {
		_email.setId(id);
	}

	/**
	* Sets the id struttura of this email.
	*
	* @param idStruttura the id struttura of this email
	*/
	@Override
	public void setIdStruttura(long idStruttura) {
		_email.setIdStruttura(idStruttura);
	}

	/**
	* Sets the mail c c of this email.
	*
	* @param mailCC the mail c c of this email
	*/
	@Override
	public void setMailCC(java.lang.String mailCC) {
		_email.setMailCC(mailCC);
	}

	@Override
	public void setNew(boolean n) {
		_email.setNew(n);
	}

	/**
	* Sets the primary key of this email.
	*
	* @param primaryKey the primary key of this email
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_email.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_email.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailWrapper)) {
			return false;
		}

		EmailWrapper emailWrapper = (EmailWrapper)obj;

		if (Objects.equals(_email, emailWrapper._email)) {
			return true;
		}

		return false;
	}

	@Override
	public Email getWrappedModel() {
		return _email;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _email.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _email.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_email.resetOriginalValues();
	}

	private final Email _email;
}