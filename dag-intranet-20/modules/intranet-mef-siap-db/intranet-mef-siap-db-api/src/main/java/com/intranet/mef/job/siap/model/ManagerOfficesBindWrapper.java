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
 * This class is a wrapper for {@link ManagerOfficesBind}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ManagerOfficesBind
 * @generated
 */
@ProviderType
public class ManagerOfficesBindWrapper implements ManagerOfficesBind,
	ModelWrapper<ManagerOfficesBind> {
	public ManagerOfficesBindWrapper(ManagerOfficesBind managerOfficesBind) {
		_managerOfficesBind = managerOfficesBind;
	}

	@Override
	public Class<?> getModelClass() {
		return ManagerOfficesBind.class;
	}

	@Override
	public String getModelClassName() {
		return ManagerOfficesBind.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personalId", getPersonalId());
		attributes.put("idOrgChart", getIdOrgChart());
		attributes.put("primary", getPrimary());
		attributes.put("regency", getRegency());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personalId = (Long)attributes.get("personalId");

		if (personalId != null) {
			setPersonalId(personalId);
		}

		Long idOrgChart = (Long)attributes.get("idOrgChart");

		if (idOrgChart != null) {
			setIdOrgChart(idOrgChart);
		}

		String primary = (String)attributes.get("primary");

		if (primary != null) {
			setPrimary(primary);
		}

		String regency = (String)attributes.get("regency");

		if (regency != null) {
			setRegency(regency);
		}
	}

	@Override
	public ManagerOfficesBind toEscapedModel() {
		return new ManagerOfficesBindWrapper(_managerOfficesBind.toEscapedModel());
	}

	@Override
	public ManagerOfficesBind toUnescapedModel() {
		return new ManagerOfficesBindWrapper(_managerOfficesBind.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _managerOfficesBind.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _managerOfficesBind.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _managerOfficesBind.isNew();
	}

	/**
	* Returns the primary key of this manager offices bind.
	*
	* @return the primary key of this manager offices bind
	*/
	@Override
	public com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK getPrimaryKey() {
		return _managerOfficesBind.getPrimaryKey();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _managerOfficesBind.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ManagerOfficesBind> toCacheModel() {
		return _managerOfficesBind.toCacheModel();
	}

	@Override
	public int compareTo(ManagerOfficesBind managerOfficesBind) {
		return _managerOfficesBind.compareTo(managerOfficesBind);
	}

	@Override
	public int hashCode() {
		return _managerOfficesBind.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _managerOfficesBind.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ManagerOfficesBindWrapper((ManagerOfficesBind)_managerOfficesBind.clone());
	}

	/**
	* Returns the primary of this manager offices bind.
	*
	* @return the primary of this manager offices bind
	*/
	@Override
	public java.lang.String getPrimary() {
		return _managerOfficesBind.getPrimary();
	}

	/**
	* Returns the regency of this manager offices bind.
	*
	* @return the regency of this manager offices bind
	*/
	@Override
	public java.lang.String getRegency() {
		return _managerOfficesBind.getRegency();
	}

	@Override
	public java.lang.String toString() {
		return _managerOfficesBind.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _managerOfficesBind.toXmlString();
	}

	/**
	* Returns the id org chart of this manager offices bind.
	*
	* @return the id org chart of this manager offices bind
	*/
	@Override
	public long getIdOrgChart() {
		return _managerOfficesBind.getIdOrgChart();
	}

	/**
	* Returns the personal ID of this manager offices bind.
	*
	* @return the personal ID of this manager offices bind
	*/
	@Override
	public long getPersonalId() {
		return _managerOfficesBind.getPersonalId();
	}

	@Override
	public void persist() {
		_managerOfficesBind.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_managerOfficesBind.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_managerOfficesBind.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_managerOfficesBind.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_managerOfficesBind.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id org chart of this manager offices bind.
	*
	* @param idOrgChart the id org chart of this manager offices bind
	*/
	@Override
	public void setIdOrgChart(long idOrgChart) {
		_managerOfficesBind.setIdOrgChart(idOrgChart);
	}

	@Override
	public void setNew(boolean n) {
		_managerOfficesBind.setNew(n);
	}

	/**
	* Sets the personal ID of this manager offices bind.
	*
	* @param personalId the personal ID of this manager offices bind
	*/
	@Override
	public void setPersonalId(long personalId) {
		_managerOfficesBind.setPersonalId(personalId);
	}

	/**
	* Sets the primary of this manager offices bind.
	*
	* @param primary the primary of this manager offices bind
	*/
	@Override
	public void setPrimary(java.lang.String primary) {
		_managerOfficesBind.setPrimary(primary);
	}

	/**
	* Sets the primary key of this manager offices bind.
	*
	* @param primaryKey the primary key of this manager offices bind
	*/
	@Override
	public void setPrimaryKey(
		com.intranet.mef.job.siap.service.persistence.ManagerOfficesBindPK primaryKey) {
		_managerOfficesBind.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_managerOfficesBind.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the regency of this manager offices bind.
	*
	* @param regency the regency of this manager offices bind
	*/
	@Override
	public void setRegency(java.lang.String regency) {
		_managerOfficesBind.setRegency(regency);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ManagerOfficesBindWrapper)) {
			return false;
		}

		ManagerOfficesBindWrapper managerOfficesBindWrapper = (ManagerOfficesBindWrapper)obj;

		if (Objects.equals(_managerOfficesBind,
					managerOfficesBindWrapper._managerOfficesBind)) {
			return true;
		}

		return false;
	}

	@Override
	public ManagerOfficesBind getWrappedModel() {
		return _managerOfficesBind;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _managerOfficesBind.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _managerOfficesBind.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_managerOfficesBind.resetOriginalValues();
	}

	private final ManagerOfficesBind _managerOfficesBind;
}