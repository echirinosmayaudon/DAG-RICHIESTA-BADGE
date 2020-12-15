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
 * This class is a wrapper for {@link Approvatore}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Approvatore
 * @generated
 */
@ProviderType
public class ApprovatoreWrapper implements Approvatore,
	ModelWrapper<Approvatore> {
	public ApprovatoreWrapper(Approvatore approvatore) {
		_approvatore = approvatore;
	}

	@Override
	public Class<?> getModelClass() {
		return Approvatore.class;
	}

	@Override
	public String getModelClassName() {
		return Approvatore.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_approvatore", getId_approvatore());
		attributes.put("id_sala", getId_sala());
		attributes.put("email_approvatore", getEmail_approvatore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_approvatore = (Long)attributes.get("id_approvatore");

		if (id_approvatore != null) {
			setId_approvatore(id_approvatore);
		}

		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		String email_approvatore = (String)attributes.get("email_approvatore");

		if (email_approvatore != null) {
			setEmail_approvatore(email_approvatore);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _approvatore.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _approvatore.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _approvatore.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _approvatore.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.Approvatore> toCacheModel() {
		return _approvatore.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.Approvatore approvatore) {
		return _approvatore.compareTo(approvatore);
	}

	@Override
	public int hashCode() {
		return _approvatore.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _approvatore.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ApprovatoreWrapper((Approvatore)_approvatore.clone());
	}

	/**
	* Returns the email_approvatore of this approvatore.
	*
	* @return the email_approvatore of this approvatore
	*/
	@Override
	public java.lang.String getEmail_approvatore() {
		return _approvatore.getEmail_approvatore();
	}

	@Override
	public java.lang.String toString() {
		return _approvatore.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _approvatore.toXmlString();
	}

	/**
	* Returns the id_approvatore of this approvatore.
	*
	* @return the id_approvatore of this approvatore
	*/
	@Override
	public long getId_approvatore() {
		return _approvatore.getId_approvatore();
	}

	/**
	* Returns the id_sala of this approvatore.
	*
	* @return the id_sala of this approvatore
	*/
	@Override
	public long getId_sala() {
		return _approvatore.getId_sala();
	}

	/**
	* Returns the primary key of this approvatore.
	*
	* @return the primary key of this approvatore
	*/
	@Override
	public long getPrimaryKey() {
		return _approvatore.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore toEscapedModel() {
		return new ApprovatoreWrapper(_approvatore.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore toUnescapedModel() {
		return new ApprovatoreWrapper(_approvatore.toUnescapedModel());
	}

	@Override
	public void persist() {
		_approvatore.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_approvatore.setCachedModel(cachedModel);
	}

	/**
	* Sets the email_approvatore of this approvatore.
	*
	* @param email_approvatore the email_approvatore of this approvatore
	*/
	@Override
	public void setEmail_approvatore(java.lang.String email_approvatore) {
		_approvatore.setEmail_approvatore(email_approvatore);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_approvatore.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_approvatore.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_approvatore.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_approvatore of this approvatore.
	*
	* @param id_approvatore the id_approvatore of this approvatore
	*/
	@Override
	public void setId_approvatore(long id_approvatore) {
		_approvatore.setId_approvatore(id_approvatore);
	}

	/**
	* Sets the id_sala of this approvatore.
	*
	* @param id_sala the id_sala of this approvatore
	*/
	@Override
	public void setId_sala(long id_sala) {
		_approvatore.setId_sala(id_sala);
	}

	@Override
	public void setNew(boolean n) {
		_approvatore.setNew(n);
	}

	/**
	* Sets the primary key of this approvatore.
	*
	* @param primaryKey the primary key of this approvatore
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_approvatore.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_approvatore.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApprovatoreWrapper)) {
			return false;
		}

		ApprovatoreWrapper approvatoreWrapper = (ApprovatoreWrapper)obj;

		if (Objects.equals(_approvatore, approvatoreWrapper._approvatore)) {
			return true;
		}

		return false;
	}

	@Override
	public Approvatore getWrappedModel() {
		return _approvatore;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _approvatore.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _approvatore.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_approvatore.resetOriginalValues();
	}

	private final Approvatore _approvatore;
}