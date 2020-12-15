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

package com.intranet.mef.daily.punching.model;

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
 * This class is a wrapper for {@link DailyPunching}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DailyPunching
 * @generated
 */
@ProviderType
public class DailyPunchingWrapper implements DailyPunching,
	ModelWrapper<DailyPunching> {
	public DailyPunchingWrapper(DailyPunching dailyPunching) {
		_dailyPunching = dailyPunching;
	}

	@Override
	public Class<?> getModelClass() {
		return DailyPunching.class;
	}

	@Override
	public String getModelClassName() {
		return DailyPunching.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("custom_key", getCustom_key());
		attributes.put("personId", getPersonId());
		attributes.put("punchingId", getPunchingId());
		attributes.put("direction", getDirection());
		attributes.put("voucher", getVoucher());
		attributes.put("terminal", getTerminal());
		attributes.put("hours", getHours());
		attributes.put("minute", getMinute());

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

		Integer punchingId = (Integer)attributes.get("punchingId");

		if (punchingId != null) {
			setPunchingId(punchingId);
		}

		String direction = (String)attributes.get("direction");

		if (direction != null) {
			setDirection(direction);
		}

		String voucher = (String)attributes.get("voucher");

		if (voucher != null) {
			setVoucher(voucher);
		}

		String terminal = (String)attributes.get("terminal");

		if (terminal != null) {
			setTerminal(terminal);
		}

		Integer hours = (Integer)attributes.get("hours");

		if (hours != null) {
			setHours(hours);
		}

		String minute = (String)attributes.get("minute");

		if (minute != null) {
			setMinute(minute);
		}
	}

	@Override
	public DailyPunching toEscapedModel() {
		return new DailyPunchingWrapper(_dailyPunching.toEscapedModel());
	}

	@Override
	public DailyPunching toUnescapedModel() {
		return new DailyPunchingWrapper(_dailyPunching.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _dailyPunching.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dailyPunching.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dailyPunching.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dailyPunching.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DailyPunching> toCacheModel() {
		return _dailyPunching.toCacheModel();
	}

	@Override
	public int compareTo(DailyPunching dailyPunching) {
		return _dailyPunching.compareTo(dailyPunching);
	}

	/**
	* Returns the hours of this daily punching.
	*
	* @return the hours of this daily punching
	*/
	@Override
	public int getHours() {
		return _dailyPunching.getHours();
	}

	/**
	* Returns the punching ID of this daily punching.
	*
	* @return the punching ID of this daily punching
	*/
	@Override
	public int getPunchingId() {
		return _dailyPunching.getPunchingId();
	}

	@Override
	public int hashCode() {
		return _dailyPunching.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dailyPunching.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DailyPunchingWrapper((DailyPunching)_dailyPunching.clone());
	}

	/**
	* Returns the custom_key of this daily punching.
	*
	* @return the custom_key of this daily punching
	*/
	@Override
	public java.lang.String getCustom_key() {
		return _dailyPunching.getCustom_key();
	}

	/**
	* Returns the direction of this daily punching.
	*
	* @return the direction of this daily punching
	*/
	@Override
	public java.lang.String getDirection() {
		return _dailyPunching.getDirection();
	}

	/**
	* Returns the minute of this daily punching.
	*
	* @return the minute of this daily punching
	*/
	@Override
	public java.lang.String getMinute() {
		return _dailyPunching.getMinute();
	}

	/**
	* Returns the primary key of this daily punching.
	*
	* @return the primary key of this daily punching
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _dailyPunching.getPrimaryKey();
	}

	/**
	* Returns the terminal of this daily punching.
	*
	* @return the terminal of this daily punching
	*/
	@Override
	public java.lang.String getTerminal() {
		return _dailyPunching.getTerminal();
	}

	/**
	* Returns the voucher of this daily punching.
	*
	* @return the voucher of this daily punching
	*/
	@Override
	public java.lang.String getVoucher() {
		return _dailyPunching.getVoucher();
	}

	@Override
	public java.lang.String toString() {
		return _dailyPunching.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dailyPunching.toXmlString();
	}

	/**
	* Returns the person ID of this daily punching.
	*
	* @return the person ID of this daily punching
	*/
	@Override
	public long getPersonId() {
		return _dailyPunching.getPersonId();
	}

	@Override
	public void persist() {
		_dailyPunching.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dailyPunching.setCachedModel(cachedModel);
	}

	/**
	* Sets the custom_key of this daily punching.
	*
	* @param custom_key the custom_key of this daily punching
	*/
	@Override
	public void setCustom_key(java.lang.String custom_key) {
		_dailyPunching.setCustom_key(custom_key);
	}

	/**
	* Sets the direction of this daily punching.
	*
	* @param direction the direction of this daily punching
	*/
	@Override
	public void setDirection(java.lang.String direction) {
		_dailyPunching.setDirection(direction);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dailyPunching.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dailyPunching.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dailyPunching.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hours of this daily punching.
	*
	* @param hours the hours of this daily punching
	*/
	@Override
	public void setHours(int hours) {
		_dailyPunching.setHours(hours);
	}

	/**
	* Sets the minute of this daily punching.
	*
	* @param minute the minute of this daily punching
	*/
	@Override
	public void setMinute(java.lang.String minute) {
		_dailyPunching.setMinute(minute);
	}

	@Override
	public void setNew(boolean n) {
		_dailyPunching.setNew(n);
	}

	/**
	* Sets the person ID of this daily punching.
	*
	* @param personId the person ID of this daily punching
	*/
	@Override
	public void setPersonId(long personId) {
		_dailyPunching.setPersonId(personId);
	}

	/**
	* Sets the primary key of this daily punching.
	*
	* @param primaryKey the primary key of this daily punching
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_dailyPunching.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dailyPunching.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the punching ID of this daily punching.
	*
	* @param punchingId the punching ID of this daily punching
	*/
	@Override
	public void setPunchingId(int punchingId) {
		_dailyPunching.setPunchingId(punchingId);
	}

	/**
	* Sets the terminal of this daily punching.
	*
	* @param terminal the terminal of this daily punching
	*/
	@Override
	public void setTerminal(java.lang.String terminal) {
		_dailyPunching.setTerminal(terminal);
	}

	/**
	* Sets the voucher of this daily punching.
	*
	* @param voucher the voucher of this daily punching
	*/
	@Override
	public void setVoucher(java.lang.String voucher) {
		_dailyPunching.setVoucher(voucher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DailyPunchingWrapper)) {
			return false;
		}

		DailyPunchingWrapper dailyPunchingWrapper = (DailyPunchingWrapper)obj;

		if (Objects.equals(_dailyPunching, dailyPunchingWrapper._dailyPunching)) {
			return true;
		}

		return false;
	}

	@Override
	public DailyPunching getWrappedModel() {
		return _dailyPunching;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dailyPunching.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dailyPunching.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dailyPunching.resetOriginalValues();
	}

	private final DailyPunching _dailyPunching;
}