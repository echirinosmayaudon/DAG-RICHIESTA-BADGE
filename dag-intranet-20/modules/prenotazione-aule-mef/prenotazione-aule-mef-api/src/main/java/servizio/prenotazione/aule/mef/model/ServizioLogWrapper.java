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

package servizio.prenotazione.aule.mef.model;

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
 * This class is a wrapper for {@link ServizioLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLog
 * @generated
 */
@ProviderType
public class ServizioLogWrapper implements ServizioLog,
	ModelWrapper<ServizioLog> {
	public ServizioLogWrapper(ServizioLog servizioLog) {
		_servizioLog = servizioLog;
	}

	@Override
	public Class<?> getModelClass() {
		return ServizioLog.class;
	}

	@Override
	public String getModelClassName() {
		return ServizioLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_servizio", getId_servizio());
		attributes.put("desc_servizio", getDesc_servizio());
		attributes.put("email_ref", getEmail_ref());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_servizio = (Long)attributes.get("id_servizio");

		if (id_servizio != null) {
			setId_servizio(id_servizio);
		}

		String desc_servizio = (String)attributes.get("desc_servizio");

		if (desc_servizio != null) {
			setDesc_servizio(desc_servizio);
		}

		String email_ref = (String)attributes.get("email_ref");

		if (email_ref != null) {
			setEmail_ref(email_ref);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _servizioLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _servizioLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _servizioLog.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _servizioLog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.ServizioLog> toCacheModel() {
		return _servizioLog.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.ServizioLog servizioLog) {
		return _servizioLog.compareTo(servizioLog);
	}

	@Override
	public int hashCode() {
		return _servizioLog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _servizioLog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ServizioLogWrapper((ServizioLog)_servizioLog.clone());
	}

	/**
	* Returns the desc_servizio of this servizio log.
	*
	* @return the desc_servizio of this servizio log
	*/
	@Override
	public java.lang.String getDesc_servizio() {
		return _servizioLog.getDesc_servizio();
	}

	/**
	* Returns the email_ref of this servizio log.
	*
	* @return the email_ref of this servizio log
	*/
	@Override
	public java.lang.String getEmail_ref() {
		return _servizioLog.getEmail_ref();
	}

	@Override
	public java.lang.String toString() {
		return _servizioLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _servizioLog.toXmlString();
	}

	/**
	* Returns the id_servizio of this servizio log.
	*
	* @return the id_servizio of this servizio log
	*/
	@Override
	public long getId_servizio() {
		return _servizioLog.getId_servizio();
	}

	/**
	* Returns the primary key of this servizio log.
	*
	* @return the primary key of this servizio log
	*/
	@Override
	public long getPrimaryKey() {
		return _servizioLog.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.ServizioLog toEscapedModel() {
		return new ServizioLogWrapper(_servizioLog.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.ServizioLog toUnescapedModel() {
		return new ServizioLogWrapper(_servizioLog.toUnescapedModel());
	}

	@Override
	public void persist() {
		_servizioLog.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_servizioLog.setCachedModel(cachedModel);
	}

	/**
	* Sets the desc_servizio of this servizio log.
	*
	* @param desc_servizio the desc_servizio of this servizio log
	*/
	@Override
	public void setDesc_servizio(java.lang.String desc_servizio) {
		_servizioLog.setDesc_servizio(desc_servizio);
	}

	/**
	* Sets the email_ref of this servizio log.
	*
	* @param email_ref the email_ref of this servizio log
	*/
	@Override
	public void setEmail_ref(java.lang.String email_ref) {
		_servizioLog.setEmail_ref(email_ref);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_servizioLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_servizioLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_servizioLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_servizio of this servizio log.
	*
	* @param id_servizio the id_servizio of this servizio log
	*/
	@Override
	public void setId_servizio(long id_servizio) {
		_servizioLog.setId_servizio(id_servizio);
	}

	@Override
	public void setNew(boolean n) {
		_servizioLog.setNew(n);
	}

	/**
	* Sets the primary key of this servizio log.
	*
	* @param primaryKey the primary key of this servizio log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_servizioLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_servizioLog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServizioLogWrapper)) {
			return false;
		}

		ServizioLogWrapper servizioLogWrapper = (ServizioLogWrapper)obj;

		if (Objects.equals(_servizioLog, servizioLogWrapper._servizioLog)) {
			return true;
		}

		return false;
	}

	@Override
	public ServizioLog getWrappedModel() {
		return _servizioLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _servizioLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _servizioLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_servizioLog.resetOriginalValues();
	}

	private final ServizioLog _servizioLog;
}