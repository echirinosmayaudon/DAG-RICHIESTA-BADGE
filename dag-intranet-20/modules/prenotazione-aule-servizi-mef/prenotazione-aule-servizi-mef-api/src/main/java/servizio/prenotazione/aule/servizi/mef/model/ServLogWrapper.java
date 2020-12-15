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

package servizio.prenotazione.aule.servizi.mef.model;

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
 * This class is a wrapper for {@link ServLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServLog
 * @generated
 */
@ProviderType
public class ServLogWrapper implements ServLog, ModelWrapper<ServLog> {
	public ServLogWrapper(ServLog servLog) {
		_servLog = servLog;
	}

	@Override
	public Class<?> getModelClass() {
		return ServLog.class;
	}

	@Override
	public String getModelClassName() {
		return ServLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_serv", getId_serv());
		attributes.put("id_sala", getId_sala());
		attributes.put("email_ref", getEmail_ref());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_serv = (Long)attributes.get("id_serv");

		if (id_serv != null) {
			setId_serv(id_serv);
		}

		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		String email_ref = (String)attributes.get("email_ref");

		if (email_ref != null) {
			setEmail_ref(email_ref);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _servLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _servLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _servLog.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _servLog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.servizi.mef.model.ServLog> toCacheModel() {
		return _servLog.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.servizi.mef.model.ServLog servLog) {
		return _servLog.compareTo(servLog);
	}

	@Override
	public int hashCode() {
		return _servLog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _servLog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ServLogWrapper((ServLog)_servLog.clone());
	}

	/**
	* Returns the email_ref of this serv log.
	*
	* @return the email_ref of this serv log
	*/
	@Override
	public java.lang.String getEmail_ref() {
		return _servLog.getEmail_ref();
	}

	@Override
	public java.lang.String toString() {
		return _servLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _servLog.toXmlString();
	}

	/**
	* Returns the id_sala of this serv log.
	*
	* @return the id_sala of this serv log
	*/
	@Override
	public long getId_sala() {
		return _servLog.getId_sala();
	}

	/**
	* Returns the id_serv of this serv log.
	*
	* @return the id_serv of this serv log
	*/
	@Override
	public long getId_serv() {
		return _servLog.getId_serv();
	}

	@Override
	public servizio.prenotazione.aule.servizi.mef.model.ServLog toEscapedModel() {
		return new ServLogWrapper(_servLog.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.servizi.mef.model.ServLog toUnescapedModel() {
		return new ServLogWrapper(_servLog.toUnescapedModel());
	}

	/**
	* Returns the primary key of this serv log.
	*
	* @return the primary key of this serv log
	*/
	@Override
	public servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK getPrimaryKey() {
		return _servLog.getPrimaryKey();
	}

	@Override
	public void persist() {
		_servLog.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_servLog.setCachedModel(cachedModel);
	}

	/**
	* Sets the email_ref of this serv log.
	*
	* @param email_ref the email_ref of this serv log
	*/
	@Override
	public void setEmail_ref(java.lang.String email_ref) {
		_servLog.setEmail_ref(email_ref);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_servLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_servLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_servLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_sala of this serv log.
	*
	* @param id_sala the id_sala of this serv log
	*/
	@Override
	public void setId_sala(long id_sala) {
		_servLog.setId_sala(id_sala);
	}

	/**
	* Sets the id_serv of this serv log.
	*
	* @param id_serv the id_serv of this serv log
	*/
	@Override
	public void setId_serv(long id_serv) {
		_servLog.setId_serv(id_serv);
	}

	@Override
	public void setNew(boolean n) {
		_servLog.setNew(n);
	}

	/**
	* Sets the primary key of this serv log.
	*
	* @param primaryKey the primary key of this serv log
	*/
	@Override
	public void setPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK primaryKey) {
		_servLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_servLog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServLogWrapper)) {
			return false;
		}

		ServLogWrapper servLogWrapper = (ServLogWrapper)obj;

		if (Objects.equals(_servLog, servLogWrapper._servLog)) {
			return true;
		}

		return false;
	}

	@Override
	public ServLog getWrappedModel() {
		return _servLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _servLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _servLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_servLog.resetOriginalValues();
	}

	private final ServLog _servLog;
}