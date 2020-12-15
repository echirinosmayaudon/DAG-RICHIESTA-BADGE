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

package mef.email.configurator.model;

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
 * This class is a wrapper for {@link EmailApp}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailApp
 * @generated
 */
@ProviderType
public class EmailAppWrapper implements EmailApp, ModelWrapper<EmailApp> {
	public EmailAppWrapper(EmailApp emailApp) {
		_emailApp = emailApp;
	}

	@Override
	public Class<?> getModelClass() {
		return EmailApp.class;
	}

	@Override
	public String getModelClassName() {
		return EmailApp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("appid", getAppid());
		attributes.put("struttura", getStruttura());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long appid = (Long)attributes.get("appid");

		if (appid != null) {
			setAppid(appid);
		}

		Long struttura = (Long)attributes.get("struttura");

		if (struttura != null) {
			setStruttura(struttura);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _emailApp.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _emailApp.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _emailApp.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _emailApp.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<mef.email.configurator.model.EmailApp> toCacheModel() {
		return _emailApp.toCacheModel();
	}

	@Override
	public int compareTo(mef.email.configurator.model.EmailApp emailApp) {
		return _emailApp.compareTo(emailApp);
	}

	@Override
	public int hashCode() {
		return _emailApp.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _emailApp.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EmailAppWrapper((EmailApp)_emailApp.clone());
	}

	/**
	* Returns the email of this email app.
	*
	* @return the email of this email app
	*/
	@Override
	public java.lang.String getEmail() {
		return _emailApp.getEmail();
	}

	@Override
	public java.lang.String toString() {
		return _emailApp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _emailApp.toXmlString();
	}

	/**
	* Returns the appid of this email app.
	*
	* @return the appid of this email app
	*/
	@Override
	public long getAppid() {
		return _emailApp.getAppid();
	}

	/**
	* Returns the ID of this email app.
	*
	* @return the ID of this email app
	*/
	@Override
	public long getId() {
		return _emailApp.getId();
	}

	/**
	* Returns the primary key of this email app.
	*
	* @return the primary key of this email app
	*/
	@Override
	public long getPrimaryKey() {
		return _emailApp.getPrimaryKey();
	}

	/**
	* Returns the struttura of this email app.
	*
	* @return the struttura of this email app
	*/
	@Override
	public long getStruttura() {
		return _emailApp.getStruttura();
	}

	@Override
	public mef.email.configurator.model.EmailApp toEscapedModel() {
		return new EmailAppWrapper(_emailApp.toEscapedModel());
	}

	@Override
	public mef.email.configurator.model.EmailApp toUnescapedModel() {
		return new EmailAppWrapper(_emailApp.toUnescapedModel());
	}

	@Override
	public void persist() {
		_emailApp.persist();
	}

	/**
	* Sets the appid of this email app.
	*
	* @param appid the appid of this email app
	*/
	@Override
	public void setAppid(long appid) {
		_emailApp.setAppid(appid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_emailApp.setCachedModel(cachedModel);
	}

	/**
	* Sets the email of this email app.
	*
	* @param email the email of this email app
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_emailApp.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_emailApp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_emailApp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_emailApp.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this email app.
	*
	* @param id the ID of this email app
	*/
	@Override
	public void setId(long id) {
		_emailApp.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_emailApp.setNew(n);
	}

	/**
	* Sets the primary key of this email app.
	*
	* @param primaryKey the primary key of this email app
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emailApp.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_emailApp.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the struttura of this email app.
	*
	* @param struttura the struttura of this email app
	*/
	@Override
	public void setStruttura(long struttura) {
		_emailApp.setStruttura(struttura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailAppWrapper)) {
			return false;
		}

		EmailAppWrapper emailAppWrapper = (EmailAppWrapper)obj;

		if (Objects.equals(_emailApp, emailAppWrapper._emailApp)) {
			return true;
		}

		return false;
	}

	@Override
	public EmailApp getWrappedModel() {
		return _emailApp;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _emailApp.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _emailApp.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_emailApp.resetOriginalValues();
	}

	private final EmailApp _emailApp;
}