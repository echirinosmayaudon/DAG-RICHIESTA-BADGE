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
 * This class is a wrapper for {@link MealTicket}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MealTicket
 * @generated
 */
@ProviderType
public class MealTicketWrapper implements MealTicket, ModelWrapper<MealTicket> {
	public MealTicketWrapper(MealTicket mealTicket) {
		_mealTicket = mealTicket;
	}

	@Override
	public Class<?> getModelClass() {
		return MealTicket.class;
	}

	@Override
	public String getModelClassName() {
		return MealTicket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("custom_key", getCustom_key());
		attributes.put("personID", getPersonID());
		attributes.put("month", getMonth());
		attributes.put("dueMeal", getDueMeal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String custom_key = (String)attributes.get("custom_key");

		if (custom_key != null) {
			setCustom_key(custom_key);
		}

		Long personID = (Long)attributes.get("personID");

		if (personID != null) {
			setPersonID(personID);
		}

		String month = (String)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer dueMeal = (Integer)attributes.get("dueMeal");

		if (dueMeal != null) {
			setDueMeal(dueMeal);
		}
	}

	@Override
	public MealTicket toEscapedModel() {
		return new MealTicketWrapper(_mealTicket.toEscapedModel());
	}

	@Override
	public MealTicket toUnescapedModel() {
		return new MealTicketWrapper(_mealTicket.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _mealTicket.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _mealTicket.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _mealTicket.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _mealTicket.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MealTicket> toCacheModel() {
		return _mealTicket.toCacheModel();
	}

	@Override
	public int compareTo(MealTicket mealTicket) {
		return _mealTicket.compareTo(mealTicket);
	}

	/**
	* Returns the due meal of this meal ticket.
	*
	* @return the due meal of this meal ticket
	*/
	@Override
	public int getDueMeal() {
		return _mealTicket.getDueMeal();
	}

	@Override
	public int hashCode() {
		return _mealTicket.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mealTicket.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new MealTicketWrapper((MealTicket)_mealTicket.clone());
	}

	/**
	* Returns the custom_key of this meal ticket.
	*
	* @return the custom_key of this meal ticket
	*/
	@Override
	public java.lang.String getCustom_key() {
		return _mealTicket.getCustom_key();
	}

	/**
	* Returns the month of this meal ticket.
	*
	* @return the month of this meal ticket
	*/
	@Override
	public java.lang.String getMonth() {
		return _mealTicket.getMonth();
	}

	/**
	* Returns the primary key of this meal ticket.
	*
	* @return the primary key of this meal ticket
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _mealTicket.getPrimaryKey();
	}

	@Override
	public java.lang.String toString() {
		return _mealTicket.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _mealTicket.toXmlString();
	}

	/**
	* Returns the person i d of this meal ticket.
	*
	* @return the person i d of this meal ticket
	*/
	@Override
	public long getPersonID() {
		return _mealTicket.getPersonID();
	}

	@Override
	public void persist() {
		_mealTicket.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mealTicket.setCachedModel(cachedModel);
	}

	/**
	* Sets the custom_key of this meal ticket.
	*
	* @param custom_key the custom_key of this meal ticket
	*/
	@Override
	public void setCustom_key(java.lang.String custom_key) {
		_mealTicket.setCustom_key(custom_key);
	}

	/**
	* Sets the due meal of this meal ticket.
	*
	* @param dueMeal the due meal of this meal ticket
	*/
	@Override
	public void setDueMeal(int dueMeal) {
		_mealTicket.setDueMeal(dueMeal);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_mealTicket.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_mealTicket.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_mealTicket.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the month of this meal ticket.
	*
	* @param month the month of this meal ticket
	*/
	@Override
	public void setMonth(java.lang.String month) {
		_mealTicket.setMonth(month);
	}

	@Override
	public void setNew(boolean n) {
		_mealTicket.setNew(n);
	}

	/**
	* Sets the person i d of this meal ticket.
	*
	* @param personID the person i d of this meal ticket
	*/
	@Override
	public void setPersonID(long personID) {
		_mealTicket.setPersonID(personID);
	}

	/**
	* Sets the primary key of this meal ticket.
	*
	* @param primaryKey the primary key of this meal ticket
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_mealTicket.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_mealTicket.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MealTicketWrapper)) {
			return false;
		}

		MealTicketWrapper mealTicketWrapper = (MealTicketWrapper)obj;

		if (Objects.equals(_mealTicket, mealTicketWrapper._mealTicket)) {
			return true;
		}

		return false;
	}

	@Override
	public MealTicket getWrappedModel() {
		return _mealTicket;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _mealTicket.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _mealTicket.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_mealTicket.resetOriginalValues();
	}

	private final MealTicket _mealTicket;
}