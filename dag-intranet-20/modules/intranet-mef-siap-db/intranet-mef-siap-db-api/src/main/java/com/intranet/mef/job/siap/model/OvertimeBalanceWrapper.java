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
 * This class is a wrapper for {@link OvertimeBalance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalance
 * @generated
 */
@ProviderType
public class OvertimeBalanceWrapper implements OvertimeBalance,
	ModelWrapper<OvertimeBalance> {
	public OvertimeBalanceWrapper(OvertimeBalance overtimeBalance) {
		_overtimeBalance = overtimeBalance;
	}

	@Override
	public Class<?> getModelClass() {
		return OvertimeBalance.class;
	}

	@Override
	public String getModelClassName() {
		return OvertimeBalance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("overtimeMonthCurrRif", getOvertimeMonthCurrRif());
		attributes.put("personId", getPersonId());
		attributes.put("overtimeBalHourCurMonth", getOvertimeBalHourCurMonth());
		attributes.put("overtimeBalacePrevMonth", getOvertimeBalacePrevMonth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String overtimeMonthCurrRif = (String)attributes.get(
				"overtimeMonthCurrRif");

		if (overtimeMonthCurrRif != null) {
			setOvertimeMonthCurrRif(overtimeMonthCurrRif);
		}

		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Integer overtimeBalHourCurMonth = (Integer)attributes.get(
				"overtimeBalHourCurMonth");

		if (overtimeBalHourCurMonth != null) {
			setOvertimeBalHourCurMonth(overtimeBalHourCurMonth);
		}

		Integer overtimeBalacePrevMonth = (Integer)attributes.get(
				"overtimeBalacePrevMonth");

		if (overtimeBalacePrevMonth != null) {
			setOvertimeBalacePrevMonth(overtimeBalacePrevMonth);
		}
	}

	@Override
	public OvertimeBalance toEscapedModel() {
		return new OvertimeBalanceWrapper(_overtimeBalance.toEscapedModel());
	}

	@Override
	public OvertimeBalance toUnescapedModel() {
		return new OvertimeBalanceWrapper(_overtimeBalance.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _overtimeBalance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _overtimeBalance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _overtimeBalance.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _overtimeBalance.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<OvertimeBalance> toCacheModel() {
		return _overtimeBalance.toCacheModel();
	}

	@Override
	public int compareTo(OvertimeBalance overtimeBalance) {
		return _overtimeBalance.compareTo(overtimeBalance);
	}

	/**
	* Returns the overtime bal hour cur month of this overtime balance.
	*
	* @return the overtime bal hour cur month of this overtime balance
	*/
	@Override
	public int getOvertimeBalHourCurMonth() {
		return _overtimeBalance.getOvertimeBalHourCurMonth();
	}

	/**
	* Returns the overtime balace prev month of this overtime balance.
	*
	* @return the overtime balace prev month of this overtime balance
	*/
	@Override
	public int getOvertimeBalacePrevMonth() {
		return _overtimeBalance.getOvertimeBalacePrevMonth();
	}

	@Override
	public int hashCode() {
		return _overtimeBalance.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _overtimeBalance.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new OvertimeBalanceWrapper((OvertimeBalance)_overtimeBalance.clone());
	}

	/**
	* Returns the overtime month curr rif of this overtime balance.
	*
	* @return the overtime month curr rif of this overtime balance
	*/
	@Override
	public java.lang.String getOvertimeMonthCurrRif() {
		return _overtimeBalance.getOvertimeMonthCurrRif();
	}

	@Override
	public java.lang.String toString() {
		return _overtimeBalance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _overtimeBalance.toXmlString();
	}

	/**
	* Returns the person ID of this overtime balance.
	*
	* @return the person ID of this overtime balance
	*/
	@Override
	public long getPersonId() {
		return _overtimeBalance.getPersonId();
	}

	/**
	* Returns the primary key of this overtime balance.
	*
	* @return the primary key of this overtime balance
	*/
	@Override
	public long getPrimaryKey() {
		return _overtimeBalance.getPrimaryKey();
	}

	@Override
	public void persist() {
		_overtimeBalance.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_overtimeBalance.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_overtimeBalance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_overtimeBalance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_overtimeBalance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_overtimeBalance.setNew(n);
	}

	/**
	* Sets the overtime bal hour cur month of this overtime balance.
	*
	* @param overtimeBalHourCurMonth the overtime bal hour cur month of this overtime balance
	*/
	@Override
	public void setOvertimeBalHourCurMonth(int overtimeBalHourCurMonth) {
		_overtimeBalance.setOvertimeBalHourCurMonth(overtimeBalHourCurMonth);
	}

	/**
	* Sets the overtime balace prev month of this overtime balance.
	*
	* @param overtimeBalacePrevMonth the overtime balace prev month of this overtime balance
	*/
	@Override
	public void setOvertimeBalacePrevMonth(int overtimeBalacePrevMonth) {
		_overtimeBalance.setOvertimeBalacePrevMonth(overtimeBalacePrevMonth);
	}

	/**
	* Sets the overtime month curr rif of this overtime balance.
	*
	* @param overtimeMonthCurrRif the overtime month curr rif of this overtime balance
	*/
	@Override
	public void setOvertimeMonthCurrRif(java.lang.String overtimeMonthCurrRif) {
		_overtimeBalance.setOvertimeMonthCurrRif(overtimeMonthCurrRif);
	}

	/**
	* Sets the person ID of this overtime balance.
	*
	* @param personId the person ID of this overtime balance
	*/
	@Override
	public void setPersonId(long personId) {
		_overtimeBalance.setPersonId(personId);
	}

	/**
	* Sets the primary key of this overtime balance.
	*
	* @param primaryKey the primary key of this overtime balance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_overtimeBalance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_overtimeBalance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OvertimeBalanceWrapper)) {
			return false;
		}

		OvertimeBalanceWrapper overtimeBalanceWrapper = (OvertimeBalanceWrapper)obj;

		if (Objects.equals(_overtimeBalance,
					overtimeBalanceWrapper._overtimeBalance)) {
			return true;
		}

		return false;
	}

	@Override
	public OvertimeBalance getWrappedModel() {
		return _overtimeBalance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _overtimeBalance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _overtimeBalance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_overtimeBalance.resetOriginalValues();
	}

	private final OvertimeBalance _overtimeBalance;
}