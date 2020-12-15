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

package com.intranet.mef.assistance.model;

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
 * This class is a wrapper for {@link Faq}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Faq
 * @generated
 */
@ProviderType
public class FaqWrapper implements Faq, ModelWrapper<Faq> {
	public FaqWrapper(Faq faq) {
		_faq = faq;
	}

	@Override
	public Class<?> getModelClass() {
		return Faq.class;
	}

	@Override
	public String getModelClassName() {
		return Faq.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("faqId", getFaqId());
		attributes.put("siebelId", getSiebelId());
		attributes.put("questions", getQuestions());
		attributes.put("response", getResponse());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String faqId = (String)attributes.get("faqId");

		if (faqId != null) {
			setFaqId(faqId);
		}

		String siebelId = (String)attributes.get("siebelId");

		if (siebelId != null) {
			setSiebelId(siebelId);
		}

		String questions = (String)attributes.get("questions");

		if (questions != null) {
			setQuestions(questions);
		}

		String response = (String)attributes.get("response");

		if (response != null) {
			setResponse(response);
		}
	}

	@Override
	public Faq toEscapedModel() {
		return new FaqWrapper(_faq.toEscapedModel());
	}

	@Override
	public Faq toUnescapedModel() {
		return new FaqWrapper(_faq.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _faq.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _faq.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _faq.isNew();
	}

	/**
	* Returns the primary key of this faq.
	*
	* @return the primary key of this faq
	*/
	@Override
	public com.intranet.mef.assistance.service.persistence.FaqPK getPrimaryKey() {
		return _faq.getPrimaryKey();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _faq.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Faq> toCacheModel() {
		return _faq.toCacheModel();
	}

	@Override
	public int compareTo(Faq faq) {
		return _faq.compareTo(faq);
	}

	@Override
	public int hashCode() {
		return _faq.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _faq.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FaqWrapper((Faq)_faq.clone());
	}

	/**
	* Returns the faq ID of this faq.
	*
	* @return the faq ID of this faq
	*/
	@Override
	public java.lang.String getFaqId() {
		return _faq.getFaqId();
	}

	/**
	* Returns the questions of this faq.
	*
	* @return the questions of this faq
	*/
	@Override
	public java.lang.String getQuestions() {
		return _faq.getQuestions();
	}

	/**
	* Returns the response of this faq.
	*
	* @return the response of this faq
	*/
	@Override
	public java.lang.String getResponse() {
		return _faq.getResponse();
	}

	/**
	* Returns the siebel ID of this faq.
	*
	* @return the siebel ID of this faq
	*/
	@Override
	public java.lang.String getSiebelId() {
		return _faq.getSiebelId();
	}

	/**
	* Returns the uuid of this faq.
	*
	* @return the uuid of this faq
	*/
	@Override
	public java.lang.String getUuid() {
		return _faq.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _faq.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _faq.toXmlString();
	}

	@Override
	public void persist() {
		_faq.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_faq.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_faq.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_faq.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_faq.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the faq ID of this faq.
	*
	* @param faqId the faq ID of this faq
	*/
	@Override
	public void setFaqId(java.lang.String faqId) {
		_faq.setFaqId(faqId);
	}

	@Override
	public void setNew(boolean n) {
		_faq.setNew(n);
	}

	/**
	* Sets the primary key of this faq.
	*
	* @param primaryKey the primary key of this faq
	*/
	@Override
	public void setPrimaryKey(
		com.intranet.mef.assistance.service.persistence.FaqPK primaryKey) {
		_faq.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_faq.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the questions of this faq.
	*
	* @param questions the questions of this faq
	*/
	@Override
	public void setQuestions(java.lang.String questions) {
		_faq.setQuestions(questions);
	}

	/**
	* Sets the response of this faq.
	*
	* @param response the response of this faq
	*/
	@Override
	public void setResponse(java.lang.String response) {
		_faq.setResponse(response);
	}

	/**
	* Sets the siebel ID of this faq.
	*
	* @param siebelId the siebel ID of this faq
	*/
	@Override
	public void setSiebelId(java.lang.String siebelId) {
		_faq.setSiebelId(siebelId);
	}

	/**
	* Sets the uuid of this faq.
	*
	* @param uuid the uuid of this faq
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_faq.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FaqWrapper)) {
			return false;
		}

		FaqWrapper faqWrapper = (FaqWrapper)obj;

		if (Objects.equals(_faq, faqWrapper._faq)) {
			return true;
		}

		return false;
	}

	@Override
	public Faq getWrappedModel() {
		return _faq;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _faq.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _faq.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_faq.resetOriginalValues();
	}

	private final Faq _faq;
}