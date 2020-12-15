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
 * This class is a wrapper for {@link PersonalAbsence}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsence
 * @generated
 */
@ProviderType
public class PersonalAbsenceWrapper implements PersonalAbsence,
	ModelWrapper<PersonalAbsence> {
	public PersonalAbsenceWrapper(PersonalAbsence personalAbsence) {
		_personalAbsence = personalAbsence;
	}

	@Override
	public Class<?> getModelClass() {
		return PersonalAbsence.class;
	}

	@Override
	public String getModelClassName() {
		return PersonalAbsence.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("custom_key", getCustom_key());
		attributes.put("personId", getPersonId());
		attributes.put("absenceDate", getAbsenceDate());
		attributes.put("refMonth", getRefMonth());
		attributes.put("absenceCode", getAbsenceCode());
		attributes.put("completeDay", getCompleteDay());
		attributes.put("from", getFrom());
		attributes.put("to", getTo());
		attributes.put("hours", getHours());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String custom_key = (String)attributes.get("custom_key");

		if (custom_key != null) {
			setCustom_key(custom_key);
		}

		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Date absenceDate = (Date)attributes.get("absenceDate");

		if (absenceDate != null) {
			setAbsenceDate(absenceDate);
		}

		String refMonth = (String)attributes.get("refMonth");

		if (refMonth != null) {
			setRefMonth(refMonth);
		}

		String absenceCode = (String)attributes.get("absenceCode");

		if (absenceCode != null) {
			setAbsenceCode(absenceCode);
		}

		String completeDay = (String)attributes.get("completeDay");

		if (completeDay != null) {
			setCompleteDay(completeDay);
		}

		Integer from = (Integer)attributes.get("from");

		if (from != null) {
			setFrom(from);
		}

		Integer to = (Integer)attributes.get("to");

		if (to != null) {
			setTo(to);
		}

		Integer hours = (Integer)attributes.get("hours");

		if (hours != null) {
			setHours(hours);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public PersonalAbsence toEscapedModel() {
		return new PersonalAbsenceWrapper(_personalAbsence.toEscapedModel());
	}

	@Override
	public PersonalAbsence toUnescapedModel() {
		return new PersonalAbsenceWrapper(_personalAbsence.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _personalAbsence.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _personalAbsence.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _personalAbsence.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _personalAbsence.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PersonalAbsence> toCacheModel() {
		return _personalAbsence.toCacheModel();
	}

	@Override
	public int compareTo(PersonalAbsence personalAbsence) {
		return _personalAbsence.compareTo(personalAbsence);
	}

	/**
	* Returns the from of this personal absence.
	*
	* @return the from of this personal absence
	*/
	@Override
	public int getFrom() {
		return _personalAbsence.getFrom();
	}

	/**
	* Returns the hours of this personal absence.
	*
	* @return the hours of this personal absence
	*/
	@Override
	public int getHours() {
		return _personalAbsence.getHours();
	}

	/**
	* Returns the to of this personal absence.
	*
	* @return the to of this personal absence
	*/
	@Override
	public int getTo() {
		return _personalAbsence.getTo();
	}

	@Override
	public int hashCode() {
		return _personalAbsence.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _personalAbsence.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PersonalAbsenceWrapper((PersonalAbsence)_personalAbsence.clone());
	}

	/**
	* Returns the absence code of this personal absence.
	*
	* @return the absence code of this personal absence
	*/
	@Override
	public java.lang.String getAbsenceCode() {
		return _personalAbsence.getAbsenceCode();
	}

	/**
	* Returns the complete day of this personal absence.
	*
	* @return the complete day of this personal absence
	*/
	@Override
	public java.lang.String getCompleteDay() {
		return _personalAbsence.getCompleteDay();
	}

	/**
	* Returns the custom_key of this personal absence.
	*
	* @return the custom_key of this personal absence
	*/
	@Override
	public java.lang.String getCustom_key() {
		return _personalAbsence.getCustom_key();
	}

	/**
	* Returns the description of this personal absence.
	*
	* @return the description of this personal absence
	*/
	@Override
	public java.lang.String getDescription() {
		return _personalAbsence.getDescription();
	}

	/**
	* Returns the primary key of this personal absence.
	*
	* @return the primary key of this personal absence
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _personalAbsence.getPrimaryKey();
	}

	/**
	* Returns the ref month of this personal absence.
	*
	* @return the ref month of this personal absence
	*/
	@Override
	public java.lang.String getRefMonth() {
		return _personalAbsence.getRefMonth();
	}

	@Override
	public java.lang.String toString() {
		return _personalAbsence.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _personalAbsence.toXmlString();
	}

	/**
	* Returns the absence date of this personal absence.
	*
	* @return the absence date of this personal absence
	*/
	@Override
	public Date getAbsenceDate() {
		return _personalAbsence.getAbsenceDate();
	}

	/**
	* Returns the person ID of this personal absence.
	*
	* @return the person ID of this personal absence
	*/
	@Override
	public long getPersonId() {
		return _personalAbsence.getPersonId();
	}

	@Override
	public void persist() {
		_personalAbsence.persist();
	}

	/**
	* Sets the absence code of this personal absence.
	*
	* @param absenceCode the absence code of this personal absence
	*/
	@Override
	public void setAbsenceCode(java.lang.String absenceCode) {
		_personalAbsence.setAbsenceCode(absenceCode);
	}

	/**
	* Sets the absence date of this personal absence.
	*
	* @param absenceDate the absence date of this personal absence
	*/
	@Override
	public void setAbsenceDate(Date absenceDate) {
		_personalAbsence.setAbsenceDate(absenceDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_personalAbsence.setCachedModel(cachedModel);
	}

	/**
	* Sets the complete day of this personal absence.
	*
	* @param completeDay the complete day of this personal absence
	*/
	@Override
	public void setCompleteDay(java.lang.String completeDay) {
		_personalAbsence.setCompleteDay(completeDay);
	}

	/**
	* Sets the custom_key of this personal absence.
	*
	* @param custom_key the custom_key of this personal absence
	*/
	@Override
	public void setCustom_key(java.lang.String custom_key) {
		_personalAbsence.setCustom_key(custom_key);
	}

	/**
	* Sets the description of this personal absence.
	*
	* @param description the description of this personal absence
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_personalAbsence.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_personalAbsence.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_personalAbsence.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_personalAbsence.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from of this personal absence.
	*
	* @param from the from of this personal absence
	*/
	@Override
	public void setFrom(int from) {
		_personalAbsence.setFrom(from);
	}

	/**
	* Sets the hours of this personal absence.
	*
	* @param hours the hours of this personal absence
	*/
	@Override
	public void setHours(int hours) {
		_personalAbsence.setHours(hours);
	}

	@Override
	public void setNew(boolean n) {
		_personalAbsence.setNew(n);
	}

	/**
	* Sets the person ID of this personal absence.
	*
	* @param personId the person ID of this personal absence
	*/
	@Override
	public void setPersonId(long personId) {
		_personalAbsence.setPersonId(personId);
	}

	/**
	* Sets the primary key of this personal absence.
	*
	* @param primaryKey the primary key of this personal absence
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_personalAbsence.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_personalAbsence.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the ref month of this personal absence.
	*
	* @param refMonth the ref month of this personal absence
	*/
	@Override
	public void setRefMonth(java.lang.String refMonth) {
		_personalAbsence.setRefMonth(refMonth);
	}

	/**
	* Sets the to of this personal absence.
	*
	* @param to the to of this personal absence
	*/
	@Override
	public void setTo(int to) {
		_personalAbsence.setTo(to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonalAbsenceWrapper)) {
			return false;
		}

		PersonalAbsenceWrapper personalAbsenceWrapper = (PersonalAbsenceWrapper)obj;

		if (Objects.equals(_personalAbsence,
					personalAbsenceWrapper._personalAbsence)) {
			return true;
		}

		return false;
	}

	@Override
	public PersonalAbsence getWrappedModel() {
		return _personalAbsence;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _personalAbsence.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _personalAbsence.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_personalAbsence.resetOriginalValues();
	}

	private final PersonalAbsence _personalAbsence;
}