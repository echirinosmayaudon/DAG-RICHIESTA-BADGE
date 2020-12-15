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
 * This class is a wrapper for {@link Vacation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vacation
 * @generated
 */
@ProviderType
public class VacationWrapper implements Vacation, ModelWrapper<Vacation> {
	public VacationWrapper(Vacation vacation) {
		_vacation = vacation;
	}

	@Override
	public Class<?> getModelClass() {
		return Vacation.class;
	}

	@Override
	public String getModelClassName() {
		return Vacation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personId", getPersonId());
		attributes.put("vacationCurrYear", getVacationCurrYear());
		attributes.put("vacationPrevYear", getVacationPrevYear());
		attributes.put("vacationSpent", getVacationSpent());
		attributes.put("vacationRemaining", getVacationRemaining());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Integer vacationCurrYear = (Integer)attributes.get("vacationCurrYear");

		if (vacationCurrYear != null) {
			setVacationCurrYear(vacationCurrYear);
		}

		Integer vacationPrevYear = (Integer)attributes.get("vacationPrevYear");

		if (vacationPrevYear != null) {
			setVacationPrevYear(vacationPrevYear);
		}

		Integer vacationSpent = (Integer)attributes.get("vacationSpent");

		if (vacationSpent != null) {
			setVacationSpent(vacationSpent);
		}

		Integer vacationRemaining = (Integer)attributes.get("vacationRemaining");

		if (vacationRemaining != null) {
			setVacationRemaining(vacationRemaining);
		}
	}

	@Override
	public Vacation toEscapedModel() {
		return new VacationWrapper(_vacation.toEscapedModel());
	}

	@Override
	public Vacation toUnescapedModel() {
		return new VacationWrapper(_vacation.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _vacation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vacation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vacation.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vacation.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Vacation> toCacheModel() {
		return _vacation.toCacheModel();
	}

	@Override
	public int compareTo(Vacation vacation) {
		return _vacation.compareTo(vacation);
	}

	/**
	* Returns the vacation curr year of this vacation.
	*
	* @return the vacation curr year of this vacation
	*/
	@Override
	public int getVacationCurrYear() {
		return _vacation.getVacationCurrYear();
	}

	/**
	* Returns the vacation prev year of this vacation.
	*
	* @return the vacation prev year of this vacation
	*/
	@Override
	public int getVacationPrevYear() {
		return _vacation.getVacationPrevYear();
	}

	/**
	* Returns the vacation remaining of this vacation.
	*
	* @return the vacation remaining of this vacation
	*/
	@Override
	public int getVacationRemaining() {
		return _vacation.getVacationRemaining();
	}

	/**
	* Returns the vacation spent of this vacation.
	*
	* @return the vacation spent of this vacation
	*/
	@Override
	public int getVacationSpent() {
		return _vacation.getVacationSpent();
	}

	@Override
	public int hashCode() {
		return _vacation.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vacation.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new VacationWrapper((Vacation)_vacation.clone());
	}

	@Override
	public java.lang.String toString() {
		return _vacation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vacation.toXmlString();
	}

	/**
	* Returns the person ID of this vacation.
	*
	* @return the person ID of this vacation
	*/
	@Override
	public long getPersonId() {
		return _vacation.getPersonId();
	}

	/**
	* Returns the primary key of this vacation.
	*
	* @return the primary key of this vacation
	*/
	@Override
	public long getPrimaryKey() {
		return _vacation.getPrimaryKey();
	}

	@Override
	public void persist() {
		_vacation.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vacation.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vacation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_vacation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vacation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_vacation.setNew(n);
	}

	/**
	* Sets the person ID of this vacation.
	*
	* @param personId the person ID of this vacation
	*/
	@Override
	public void setPersonId(long personId) {
		_vacation.setPersonId(personId);
	}

	/**
	* Sets the primary key of this vacation.
	*
	* @param primaryKey the primary key of this vacation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vacation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vacation.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the vacation curr year of this vacation.
	*
	* @param vacationCurrYear the vacation curr year of this vacation
	*/
	@Override
	public void setVacationCurrYear(int vacationCurrYear) {
		_vacation.setVacationCurrYear(vacationCurrYear);
	}

	/**
	* Sets the vacation prev year of this vacation.
	*
	* @param vacationPrevYear the vacation prev year of this vacation
	*/
	@Override
	public void setVacationPrevYear(int vacationPrevYear) {
		_vacation.setVacationPrevYear(vacationPrevYear);
	}

	/**
	* Sets the vacation remaining of this vacation.
	*
	* @param vacationRemaining the vacation remaining of this vacation
	*/
	@Override
	public void setVacationRemaining(int vacationRemaining) {
		_vacation.setVacationRemaining(vacationRemaining);
	}

	/**
	* Sets the vacation spent of this vacation.
	*
	* @param vacationSpent the vacation spent of this vacation
	*/
	@Override
	public void setVacationSpent(int vacationSpent) {
		_vacation.setVacationSpent(vacationSpent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacationWrapper)) {
			return false;
		}

		VacationWrapper vacationWrapper = (VacationWrapper)obj;

		if (Objects.equals(_vacation, vacationWrapper._vacation)) {
			return true;
		}

		return false;
	}

	@Override
	public Vacation getWrappedModel() {
		return _vacation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vacation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vacation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vacation.resetOriginalValues();
	}

	private final Vacation _vacation;
}