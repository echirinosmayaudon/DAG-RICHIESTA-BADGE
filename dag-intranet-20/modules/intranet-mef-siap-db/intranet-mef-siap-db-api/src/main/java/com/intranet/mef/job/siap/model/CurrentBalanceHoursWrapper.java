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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CurrentBalanceHours}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrentBalanceHours
 * @generated
 */
@ProviderType
public class CurrentBalanceHoursWrapper implements CurrentBalanceHours,
	ModelWrapper<CurrentBalanceHours> {
	public CurrentBalanceHoursWrapper(CurrentBalanceHours currentBalanceHours) {
		_currentBalanceHours = currentBalanceHours;
	}

	@Override
	public Class<?> getModelClass() {
		return CurrentBalanceHours.class;
	}

	@Override
	public String getModelClassName() {
		return CurrentBalanceHours.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personId", getPersonId());
		attributes.put("balanceHoursCurDate", getBalanceHoursCurDate());
		attributes.put("balanceHours", getBalanceHours());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Date balanceHoursCurDate = (Date)attributes.get("balanceHoursCurDate");

		if (balanceHoursCurDate != null) {
			setBalanceHoursCurDate(balanceHoursCurDate);
		}

		Integer balanceHours = (Integer)attributes.get("balanceHours");

		if (balanceHours != null) {
			setBalanceHours(balanceHours);
		}
	}

	@Override
	public CurrentBalanceHours toEscapedModel() {
		return new CurrentBalanceHoursWrapper(_currentBalanceHours.toEscapedModel());
	}

	@Override
	public CurrentBalanceHours toUnescapedModel() {
		return new CurrentBalanceHoursWrapper(_currentBalanceHours.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _currentBalanceHours.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _currentBalanceHours.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _currentBalanceHours.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _currentBalanceHours.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CurrentBalanceHours> toCacheModel() {
		return _currentBalanceHours.toCacheModel();
	}

	@Override
	public int compareTo(CurrentBalanceHours currentBalanceHours) {
		return _currentBalanceHours.compareTo(currentBalanceHours);
	}

	/**
	* Returns the balance hours of this current balance hours.
	*
	* @return the balance hours of this current balance hours
	*/
	@Override
	public int getBalanceHours() {
		return _currentBalanceHours.getBalanceHours();
	}

	@Override
	public int hashCode() {
		return _currentBalanceHours.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _currentBalanceHours.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CurrentBalanceHoursWrapper((CurrentBalanceHours)_currentBalanceHours.clone());
	}

	@Override
	public java.lang.String toString() {
		return _currentBalanceHours.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _currentBalanceHours.toXmlString();
	}

	/**
	* Returns the balance hours cur date of this current balance hours.
	*
	* @return the balance hours cur date of this current balance hours
	*/
	@Override
	public Date getBalanceHoursCurDate() {
		return _currentBalanceHours.getBalanceHoursCurDate();
	}

	/**
	* Returns the person ID of this current balance hours.
	*
	* @return the person ID of this current balance hours
	*/
	@Override
	public long getPersonId() {
		return _currentBalanceHours.getPersonId();
	}

	/**
	* Returns the primary key of this current balance hours.
	*
	* @return the primary key of this current balance hours
	*/
	@Override
	public long getPrimaryKey() {
		return _currentBalanceHours.getPrimaryKey();
	}

	@Override
	public void persist() {
		_currentBalanceHours.persist();
	}

	/**
	* Sets the balance hours of this current balance hours.
	*
	* @param balanceHours the balance hours of this current balance hours
	*/
	@Override
	public void setBalanceHours(int balanceHours) {
		_currentBalanceHours.setBalanceHours(balanceHours);
	}

	/**
	* Sets the balance hours cur date of this current balance hours.
	*
	* @param balanceHoursCurDate the balance hours cur date of this current balance hours
	*/
	@Override
	public void setBalanceHoursCurDate(Date balanceHoursCurDate) {
		_currentBalanceHours.setBalanceHoursCurDate(balanceHoursCurDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_currentBalanceHours.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_currentBalanceHours.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_currentBalanceHours.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_currentBalanceHours.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_currentBalanceHours.setNew(n);
	}

	/**
	* Sets the person ID of this current balance hours.
	*
	* @param personId the person ID of this current balance hours
	*/
	@Override
	public void setPersonId(long personId) {
		_currentBalanceHours.setPersonId(personId);
	}

	/**
	* Sets the primary key of this current balance hours.
	*
	* @param primaryKey the primary key of this current balance hours
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_currentBalanceHours.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_currentBalanceHours.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CurrentBalanceHoursWrapper)) {
			return false;
		}

		CurrentBalanceHoursWrapper currentBalanceHoursWrapper = (CurrentBalanceHoursWrapper)obj;

		if (Objects.equals(_currentBalanceHours,
					currentBalanceHoursWrapper._currentBalanceHours)) {
			return true;
		}

		return false;
	}

	@Override
	public CurrentBalanceHours getWrappedModel() {
		return _currentBalanceHours;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _currentBalanceHours.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _currentBalanceHours.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_currentBalanceHours.resetOriginalValues();
	}

	private final CurrentBalanceHours _currentBalanceHours;
}