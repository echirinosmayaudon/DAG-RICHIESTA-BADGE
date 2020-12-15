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
 * This class is a wrapper for {@link OvertimeBalacePrevMonth}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalacePrevMonth
 * @generated
 */
@ProviderType
public class OvertimeBalacePrevMonthWrapper implements OvertimeBalacePrevMonth,
	ModelWrapper<OvertimeBalacePrevMonth> {
	public OvertimeBalacePrevMonthWrapper(
		OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		_overtimeBalacePrevMonth = overtimeBalacePrevMonth;
	}

	@Override
	public Class<?> getModelClass() {
		return OvertimeBalacePrevMonth.class;
	}

	@Override
	public String getModelClassName() {
		return OvertimeBalacePrevMonth.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personId", getPersonId());
		attributes.put("overtimeDueCurrMonth", getOvertimeDueCurrMonth());
		attributes.put("overtimeMonthPrevRif", getOvertimeMonthPrevRif());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Integer overtimeDueCurrMonth = (Integer)attributes.get(
				"overtimeDueCurrMonth");

		if (overtimeDueCurrMonth != null) {
			setOvertimeDueCurrMonth(overtimeDueCurrMonth);
		}

		String overtimeMonthPrevRif = (String)attributes.get(
				"overtimeMonthPrevRif");

		if (overtimeMonthPrevRif != null) {
			setOvertimeMonthPrevRif(overtimeMonthPrevRif);
		}
	}

	@Override
	public OvertimeBalacePrevMonth toEscapedModel() {
		return new OvertimeBalacePrevMonthWrapper(_overtimeBalacePrevMonth.toEscapedModel());
	}

	@Override
	public OvertimeBalacePrevMonth toUnescapedModel() {
		return new OvertimeBalacePrevMonthWrapper(_overtimeBalacePrevMonth.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _overtimeBalacePrevMonth.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _overtimeBalacePrevMonth.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _overtimeBalacePrevMonth.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _overtimeBalacePrevMonth.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<OvertimeBalacePrevMonth> toCacheModel() {
		return _overtimeBalacePrevMonth.toCacheModel();
	}

	@Override
	public int compareTo(OvertimeBalacePrevMonth overtimeBalacePrevMonth) {
		return _overtimeBalacePrevMonth.compareTo(overtimeBalacePrevMonth);
	}

	/**
	* Returns the overtime due curr month of this overtime balace prev month.
	*
	* @return the overtime due curr month of this overtime balace prev month
	*/
	@Override
	public int getOvertimeDueCurrMonth() {
		return _overtimeBalacePrevMonth.getOvertimeDueCurrMonth();
	}

	@Override
	public int hashCode() {
		return _overtimeBalacePrevMonth.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _overtimeBalacePrevMonth.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new OvertimeBalacePrevMonthWrapper((OvertimeBalacePrevMonth)_overtimeBalacePrevMonth.clone());
	}

	/**
	* Returns the overtime month prev rif of this overtime balace prev month.
	*
	* @return the overtime month prev rif of this overtime balace prev month
	*/
	@Override
	public java.lang.String getOvertimeMonthPrevRif() {
		return _overtimeBalacePrevMonth.getOvertimeMonthPrevRif();
	}

	@Override
	public java.lang.String toString() {
		return _overtimeBalacePrevMonth.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _overtimeBalacePrevMonth.toXmlString();
	}

	/**
	* Returns the person ID of this overtime balace prev month.
	*
	* @return the person ID of this overtime balace prev month
	*/
	@Override
	public long getPersonId() {
		return _overtimeBalacePrevMonth.getPersonId();
	}

	/**
	* Returns the primary key of this overtime balace prev month.
	*
	* @return the primary key of this overtime balace prev month
	*/
	@Override
	public long getPrimaryKey() {
		return _overtimeBalacePrevMonth.getPrimaryKey();
	}

	@Override
	public void persist() {
		_overtimeBalacePrevMonth.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_overtimeBalacePrevMonth.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_overtimeBalacePrevMonth.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_overtimeBalacePrevMonth.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_overtimeBalacePrevMonth.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_overtimeBalacePrevMonth.setNew(n);
	}

	/**
	* Sets the overtime due curr month of this overtime balace prev month.
	*
	* @param overtimeDueCurrMonth the overtime due curr month of this overtime balace prev month
	*/
	@Override
	public void setOvertimeDueCurrMonth(int overtimeDueCurrMonth) {
		_overtimeBalacePrevMonth.setOvertimeDueCurrMonth(overtimeDueCurrMonth);
	}

	/**
	* Sets the overtime month prev rif of this overtime balace prev month.
	*
	* @param overtimeMonthPrevRif the overtime month prev rif of this overtime balace prev month
	*/
	@Override
	public void setOvertimeMonthPrevRif(java.lang.String overtimeMonthPrevRif) {
		_overtimeBalacePrevMonth.setOvertimeMonthPrevRif(overtimeMonthPrevRif);
	}

	/**
	* Sets the person ID of this overtime balace prev month.
	*
	* @param personId the person ID of this overtime balace prev month
	*/
	@Override
	public void setPersonId(long personId) {
		_overtimeBalacePrevMonth.setPersonId(personId);
	}

	/**
	* Sets the primary key of this overtime balace prev month.
	*
	* @param primaryKey the primary key of this overtime balace prev month
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_overtimeBalacePrevMonth.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_overtimeBalacePrevMonth.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OvertimeBalacePrevMonthWrapper)) {
			return false;
		}

		OvertimeBalacePrevMonthWrapper overtimeBalacePrevMonthWrapper = (OvertimeBalacePrevMonthWrapper)obj;

		if (Objects.equals(_overtimeBalacePrevMonth,
					overtimeBalacePrevMonthWrapper._overtimeBalacePrevMonth)) {
			return true;
		}

		return false;
	}

	@Override
	public OvertimeBalacePrevMonth getWrappedModel() {
		return _overtimeBalacePrevMonth;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _overtimeBalacePrevMonth.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _overtimeBalacePrevMonth.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_overtimeBalacePrevMonth.resetOriginalValues();
	}

	private final OvertimeBalacePrevMonth _overtimeBalacePrevMonth;
}