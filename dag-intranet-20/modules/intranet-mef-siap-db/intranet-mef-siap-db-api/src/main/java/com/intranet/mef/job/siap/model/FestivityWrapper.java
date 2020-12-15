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

package com.intranet.mef.job.siap.model;

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
 * This class is a wrapper for {@link Festivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Festivity
 * @generated
 */
@ProviderType
public class FestivityWrapper implements Festivity, ModelWrapper<Festivity> {
	public FestivityWrapper(Festivity festivity) {
		_festivity = festivity;
	}

	@Override
	public Class<?> getModelClass() {
		return Festivity.class;
	}

	@Override
	public String getModelClassName() {
		return Festivity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personId", getPersonId());
		attributes.put("festivityDueCurrYear", getFestivityDueCurrYear());
		attributes.put("festivitySpentCurrYear", getFestivitySpentCurrYear());
		attributes.put("festivityRemainCurrYear", getFestivityRemainCurrYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Integer festivityDueCurrYear = (Integer)attributes.get(
				"festivityDueCurrYear");

		if (festivityDueCurrYear != null) {
			setFestivityDueCurrYear(festivityDueCurrYear);
		}

		Integer festivitySpentCurrYear = (Integer)attributes.get(
				"festivitySpentCurrYear");

		if (festivitySpentCurrYear != null) {
			setFestivitySpentCurrYear(festivitySpentCurrYear);
		}

		Integer festivityRemainCurrYear = (Integer)attributes.get(
				"festivityRemainCurrYear");

		if (festivityRemainCurrYear != null) {
			setFestivityRemainCurrYear(festivityRemainCurrYear);
		}
	}

	@Override
	public Festivity toEscapedModel() {
		return new FestivityWrapper(_festivity.toEscapedModel());
	}

	@Override
	public Festivity toUnescapedModel() {
		return new FestivityWrapper(_festivity.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _festivity.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _festivity.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _festivity.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _festivity.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Festivity> toCacheModel() {
		return _festivity.toCacheModel();
	}

	@Override
	public int compareTo(Festivity festivity) {
		return _festivity.compareTo(festivity);
	}

	/**
	* Returns the festivity due curr year of this festivity.
	*
	* @return the festivity due curr year of this festivity
	*/
	@Override
	public int getFestivityDueCurrYear() {
		return _festivity.getFestivityDueCurrYear();
	}

	/**
	* Returns the festivity remain curr year of this festivity.
	*
	* @return the festivity remain curr year of this festivity
	*/
	@Override
	public int getFestivityRemainCurrYear() {
		return _festivity.getFestivityRemainCurrYear();
	}

	/**
	* Returns the festivity spent curr year of this festivity.
	*
	* @return the festivity spent curr year of this festivity
	*/
	@Override
	public int getFestivitySpentCurrYear() {
		return _festivity.getFestivitySpentCurrYear();
	}

	@Override
	public int hashCode() {
		return _festivity.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _festivity.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FestivityWrapper((Festivity)_festivity.clone());
	}

	@Override
	public java.lang.String toString() {
		return _festivity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _festivity.toXmlString();
	}

	/**
	* Returns the person ID of this festivity.
	*
	* @return the person ID of this festivity
	*/
	@Override
	public long getPersonId() {
		return _festivity.getPersonId();
	}

	/**
	* Returns the primary key of this festivity.
	*
	* @return the primary key of this festivity
	*/
	@Override
	public long getPrimaryKey() {
		return _festivity.getPrimaryKey();
	}

	@Override
	public void persist() {
		_festivity.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_festivity.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_festivity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_festivity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_festivity.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the festivity due curr year of this festivity.
	*
	* @param festivityDueCurrYear the festivity due curr year of this festivity
	*/
	@Override
	public void setFestivityDueCurrYear(int festivityDueCurrYear) {
		_festivity.setFestivityDueCurrYear(festivityDueCurrYear);
	}

	/**
	* Sets the festivity remain curr year of this festivity.
	*
	* @param festivityRemainCurrYear the festivity remain curr year of this festivity
	*/
	@Override
	public void setFestivityRemainCurrYear(int festivityRemainCurrYear) {
		_festivity.setFestivityRemainCurrYear(festivityRemainCurrYear);
	}

	/**
	* Sets the festivity spent curr year of this festivity.
	*
	* @param festivitySpentCurrYear the festivity spent curr year of this festivity
	*/
	@Override
	public void setFestivitySpentCurrYear(int festivitySpentCurrYear) {
		_festivity.setFestivitySpentCurrYear(festivitySpentCurrYear);
	}

	@Override
	public void setNew(boolean n) {
		_festivity.setNew(n);
	}

	/**
	* Sets the person ID of this festivity.
	*
	* @param personId the person ID of this festivity
	*/
	@Override
	public void setPersonId(long personId) {
		_festivity.setPersonId(personId);
	}

	/**
	* Sets the primary key of this festivity.
	*
	* @param primaryKey the primary key of this festivity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_festivity.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_festivity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FestivityWrapper)) {
			return false;
		}

		FestivityWrapper festivityWrapper = (FestivityWrapper)obj;

		if (Objects.equals(_festivity, festivityWrapper._festivity)) {
			return true;
		}

		return false;
	}

	@Override
	public Festivity getWrappedModel() {
		return _festivity;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _festivity.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _festivity.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_festivity.resetOriginalValues();
	}

	private final Festivity _festivity;
}