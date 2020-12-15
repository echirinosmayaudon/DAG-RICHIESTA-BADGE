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
 * This class is a wrapper for {@link Punching}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Punching
 * @generated
 */
@ProviderType
public class PunchingWrapper implements Punching, ModelWrapper<Punching> {
	public PunchingWrapper(Punching punching) {
		_punching = punching;
	}

	@Override
	public Class<?> getModelClass() {
		return Punching.class;
	}

	@Override
	public String getModelClassName() {
		return Punching.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("custom_key", getCustom_key());
		attributes.put("personId", getPersonId());
		attributes.put("punchingId", getPunchingId());
		attributes.put("direction", getDirection());
		attributes.put("hours", getHours());
		attributes.put("minute", getMinute());
		attributes.put("voucher", getVoucher());
		attributes.put("terminal", getTerminal());
		attributes.put("accountingDate", getAccountingDate());
		attributes.put("punchingDate", getPunchingDate());

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

		Integer hours = (Integer)attributes.get("hours");

		if (hours != null) {
			setHours(hours);
		}

		String minute = (String)attributes.get("minute");

		if (minute != null) {
			setMinute(minute);
		}

		String voucher = (String)attributes.get("voucher");

		if (voucher != null) {
			setVoucher(voucher);
		}

		String terminal = (String)attributes.get("terminal");

		if (terminal != null) {
			setTerminal(terminal);
		}

		Date accountingDate = (Date)attributes.get("accountingDate");

		if (accountingDate != null) {
			setAccountingDate(accountingDate);
		}

		Date punchingDate = (Date)attributes.get("punchingDate");

		if (punchingDate != null) {
			setPunchingDate(punchingDate);
		}
	}

	@Override
	public Punching toEscapedModel() {
		return new PunchingWrapper(_punching.toEscapedModel());
	}

	@Override
	public Punching toUnescapedModel() {
		return new PunchingWrapper(_punching.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _punching.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _punching.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _punching.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _punching.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Punching> toCacheModel() {
		return _punching.toCacheModel();
	}

	@Override
	public int compareTo(Punching punching) {
		return _punching.compareTo(punching);
	}

	/**
	* Returns the hours of this punching.
	*
	* @return the hours of this punching
	*/
	@Override
	public int getHours() {
		return _punching.getHours();
	}

	/**
	* Returns the punching ID of this punching.
	*
	* @return the punching ID of this punching
	*/
	@Override
	public int getPunchingId() {
		return _punching.getPunchingId();
	}

	@Override
	public int hashCode() {
		return _punching.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _punching.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PunchingWrapper((Punching)_punching.clone());
	}

	/**
	* Returns the custom_key of this punching.
	*
	* @return the custom_key of this punching
	*/
	@Override
	public java.lang.String getCustom_key() {
		return _punching.getCustom_key();
	}

	/**
	* Returns the direction of this punching.
	*
	* @return the direction of this punching
	*/
	@Override
	public java.lang.String getDirection() {
		return _punching.getDirection();
	}

	/**
	* Returns the minute of this punching.
	*
	* @return the minute of this punching
	*/
	@Override
	public java.lang.String getMinute() {
		return _punching.getMinute();
	}

	/**
	* Returns the primary key of this punching.
	*
	* @return the primary key of this punching
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _punching.getPrimaryKey();
	}

	/**
	* Returns the terminal of this punching.
	*
	* @return the terminal of this punching
	*/
	@Override
	public java.lang.String getTerminal() {
		return _punching.getTerminal();
	}

	/**
	* Returns the voucher of this punching.
	*
	* @return the voucher of this punching
	*/
	@Override
	public java.lang.String getVoucher() {
		return _punching.getVoucher();
	}

	@Override
	public java.lang.String toString() {
		return _punching.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _punching.toXmlString();
	}

	/**
	* Returns the accounting date of this punching.
	*
	* @return the accounting date of this punching
	*/
	@Override
	public Date getAccountingDate() {
		return _punching.getAccountingDate();
	}

	/**
	* Returns the punching date of this punching.
	*
	* @return the punching date of this punching
	*/
	@Override
	public Date getPunchingDate() {
		return _punching.getPunchingDate();
	}

	/**
	* Returns the person ID of this punching.
	*
	* @return the person ID of this punching
	*/
	@Override
	public long getPersonId() {
		return _punching.getPersonId();
	}

	@Override
	public void persist() {
		_punching.persist();
	}

	/**
	* Sets the accounting date of this punching.
	*
	* @param accountingDate the accounting date of this punching
	*/
	@Override
	public void setAccountingDate(Date accountingDate) {
		_punching.setAccountingDate(accountingDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_punching.setCachedModel(cachedModel);
	}

	/**
	* Sets the custom_key of this punching.
	*
	* @param custom_key the custom_key of this punching
	*/
	@Override
	public void setCustom_key(java.lang.String custom_key) {
		_punching.setCustom_key(custom_key);
	}

	/**
	* Sets the direction of this punching.
	*
	* @param direction the direction of this punching
	*/
	@Override
	public void setDirection(java.lang.String direction) {
		_punching.setDirection(direction);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_punching.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_punching.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_punching.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hours of this punching.
	*
	* @param hours the hours of this punching
	*/
	@Override
	public void setHours(int hours) {
		_punching.setHours(hours);
	}

	/**
	* Sets the minute of this punching.
	*
	* @param minute the minute of this punching
	*/
	@Override
	public void setMinute(java.lang.String minute) {
		_punching.setMinute(minute);
	}

	@Override
	public void setNew(boolean n) {
		_punching.setNew(n);
	}

	/**
	* Sets the person ID of this punching.
	*
	* @param personId the person ID of this punching
	*/
	@Override
	public void setPersonId(long personId) {
		_punching.setPersonId(personId);
	}

	/**
	* Sets the primary key of this punching.
	*
	* @param primaryKey the primary key of this punching
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_punching.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_punching.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the punching date of this punching.
	*
	* @param punchingDate the punching date of this punching
	*/
	@Override
	public void setPunchingDate(Date punchingDate) {
		_punching.setPunchingDate(punchingDate);
	}

	/**
	* Sets the punching ID of this punching.
	*
	* @param punchingId the punching ID of this punching
	*/
	@Override
	public void setPunchingId(int punchingId) {
		_punching.setPunchingId(punchingId);
	}

	/**
	* Sets the terminal of this punching.
	*
	* @param terminal the terminal of this punching
	*/
	@Override
	public void setTerminal(java.lang.String terminal) {
		_punching.setTerminal(terminal);
	}

	/**
	* Sets the voucher of this punching.
	*
	* @param voucher the voucher of this punching
	*/
	@Override
	public void setVoucher(java.lang.String voucher) {
		_punching.setVoucher(voucher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PunchingWrapper)) {
			return false;
		}

		PunchingWrapper punchingWrapper = (PunchingWrapper)obj;

		if (Objects.equals(_punching, punchingWrapper._punching)) {
			return true;
		}

		return false;
	}

	@Override
	public Punching getWrappedModel() {
		return _punching;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _punching.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _punching.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_punching.resetOriginalValues();
	}

	private final Punching _punching;
}