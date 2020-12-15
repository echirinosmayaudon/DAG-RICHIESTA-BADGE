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
 * This class is a wrapper for {@link OvertimePrevMonthPayOff}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimePrevMonthPayOff
 * @generated
 */
@ProviderType
public class OvertimePrevMonthPayOffWrapper implements OvertimePrevMonthPayOff,
	ModelWrapper<OvertimePrevMonthPayOff> {
	public OvertimePrevMonthPayOffWrapper(
		OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		_overtimePrevMonthPayOff = overtimePrevMonthPayOff;
	}

	@Override
	public Class<?> getModelClass() {
		return OvertimePrevMonthPayOff.class;
	}

	@Override
	public String getModelClassName() {
		return OvertimePrevMonthPayOff.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personId", getPersonId());
		attributes.put("overtimeHoursCurrPayOff", getOvertimeHoursCurrPayOff());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Integer overtimeHoursCurrPayOff = (Integer)attributes.get(
				"overtimeHoursCurrPayOff");

		if (overtimeHoursCurrPayOff != null) {
			setOvertimeHoursCurrPayOff(overtimeHoursCurrPayOff);
		}
	}

	@Override
	public OvertimePrevMonthPayOff toEscapedModel() {
		return new OvertimePrevMonthPayOffWrapper(_overtimePrevMonthPayOff.toEscapedModel());
	}

	@Override
	public OvertimePrevMonthPayOff toUnescapedModel() {
		return new OvertimePrevMonthPayOffWrapper(_overtimePrevMonthPayOff.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _overtimePrevMonthPayOff.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _overtimePrevMonthPayOff.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _overtimePrevMonthPayOff.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _overtimePrevMonthPayOff.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<OvertimePrevMonthPayOff> toCacheModel() {
		return _overtimePrevMonthPayOff.toCacheModel();
	}

	@Override
	public int compareTo(OvertimePrevMonthPayOff overtimePrevMonthPayOff) {
		return _overtimePrevMonthPayOff.compareTo(overtimePrevMonthPayOff);
	}

	/**
	* Returns the overtime hours curr pay off of this overtime prev month pay off.
	*
	* @return the overtime hours curr pay off of this overtime prev month pay off
	*/
	@Override
	public int getOvertimeHoursCurrPayOff() {
		return _overtimePrevMonthPayOff.getOvertimeHoursCurrPayOff();
	}

	@Override
	public int hashCode() {
		return _overtimePrevMonthPayOff.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _overtimePrevMonthPayOff.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new OvertimePrevMonthPayOffWrapper((OvertimePrevMonthPayOff)_overtimePrevMonthPayOff.clone());
	}

	@Override
	public java.lang.String toString() {
		return _overtimePrevMonthPayOff.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _overtimePrevMonthPayOff.toXmlString();
	}

	/**
	* Returns the person ID of this overtime prev month pay off.
	*
	* @return the person ID of this overtime prev month pay off
	*/
	@Override
	public long getPersonId() {
		return _overtimePrevMonthPayOff.getPersonId();
	}

	/**
	* Returns the primary key of this overtime prev month pay off.
	*
	* @return the primary key of this overtime prev month pay off
	*/
	@Override
	public long getPrimaryKey() {
		return _overtimePrevMonthPayOff.getPrimaryKey();
	}

	@Override
	public void persist() {
		_overtimePrevMonthPayOff.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_overtimePrevMonthPayOff.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_overtimePrevMonthPayOff.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_overtimePrevMonthPayOff.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_overtimePrevMonthPayOff.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_overtimePrevMonthPayOff.setNew(n);
	}

	/**
	* Sets the overtime hours curr pay off of this overtime prev month pay off.
	*
	* @param overtimeHoursCurrPayOff the overtime hours curr pay off of this overtime prev month pay off
	*/
	@Override
	public void setOvertimeHoursCurrPayOff(int overtimeHoursCurrPayOff) {
		_overtimePrevMonthPayOff.setOvertimeHoursCurrPayOff(overtimeHoursCurrPayOff);
	}

	/**
	* Sets the person ID of this overtime prev month pay off.
	*
	* @param personId the person ID of this overtime prev month pay off
	*/
	@Override
	public void setPersonId(long personId) {
		_overtimePrevMonthPayOff.setPersonId(personId);
	}

	/**
	* Sets the primary key of this overtime prev month pay off.
	*
	* @param primaryKey the primary key of this overtime prev month pay off
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_overtimePrevMonthPayOff.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_overtimePrevMonthPayOff.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OvertimePrevMonthPayOffWrapper)) {
			return false;
		}

		OvertimePrevMonthPayOffWrapper overtimePrevMonthPayOffWrapper = (OvertimePrevMonthPayOffWrapper)obj;

		if (Objects.equals(_overtimePrevMonthPayOff,
					overtimePrevMonthPayOffWrapper._overtimePrevMonthPayOff)) {
			return true;
		}

		return false;
	}

	@Override
	public OvertimePrevMonthPayOff getWrappedModel() {
		return _overtimePrevMonthPayOff;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _overtimePrevMonthPayOff.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _overtimePrevMonthPayOff.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_overtimePrevMonthPayOff.resetOriginalValues();
	}

	private final OvertimePrevMonthPayOff _overtimePrevMonthPayOff;
}