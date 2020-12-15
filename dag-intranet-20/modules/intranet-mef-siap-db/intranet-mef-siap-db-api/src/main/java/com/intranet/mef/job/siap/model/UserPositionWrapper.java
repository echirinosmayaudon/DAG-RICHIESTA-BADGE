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
 * This class is a wrapper for {@link UserPosition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPosition
 * @generated
 */
@ProviderType
public class UserPositionWrapper implements UserPosition,
	ModelWrapper<UserPosition> {
	public UserPositionWrapper(UserPosition userPosition) {
		_userPosition = userPosition;
	}

	@Override
	public Class<?> getModelClass() {
		return UserPosition.class;
	}

	@Override
	public String getModelClassName() {
		return UserPosition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pos", getPos());
		attributes.put("ruoloGiuridico", getRuoloGiuridico());
		attributes.put("ruoloEconomico", getRuoloEconomico());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String pos = (String)attributes.get("pos");

		if (pos != null) {
			setPos(pos);
		}

		String ruoloGiuridico = (String)attributes.get("ruoloGiuridico");

		if (ruoloGiuridico != null) {
			setRuoloGiuridico(ruoloGiuridico);
		}

		String ruoloEconomico = (String)attributes.get("ruoloEconomico");

		if (ruoloEconomico != null) {
			setRuoloEconomico(ruoloEconomico);
		}
	}

	@Override
	public UserPosition toEscapedModel() {
		return new UserPositionWrapper(_userPosition.toEscapedModel());
	}

	@Override
	public UserPosition toUnescapedModel() {
		return new UserPositionWrapper(_userPosition.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _userPosition.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userPosition.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userPosition.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userPosition.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserPosition> toCacheModel() {
		return _userPosition.toCacheModel();
	}

	@Override
	public int compareTo(UserPosition userPosition) {
		return _userPosition.compareTo(userPosition);
	}

	@Override
	public int hashCode() {
		return _userPosition.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userPosition.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserPositionWrapper((UserPosition)_userPosition.clone());
	}

	/**
	* Returns the pos of this user position.
	*
	* @return the pos of this user position
	*/
	@Override
	public java.lang.String getPos() {
		return _userPosition.getPos();
	}

	/**
	* Returns the primary key of this user position.
	*
	* @return the primary key of this user position
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _userPosition.getPrimaryKey();
	}

	/**
	* Returns the ruolo economico of this user position.
	*
	* @return the ruolo economico of this user position
	*/
	@Override
	public java.lang.String getRuoloEconomico() {
		return _userPosition.getRuoloEconomico();
	}

	/**
	* Returns the ruolo giuridico of this user position.
	*
	* @return the ruolo giuridico of this user position
	*/
	@Override
	public java.lang.String getRuoloGiuridico() {
		return _userPosition.getRuoloGiuridico();
	}

	@Override
	public java.lang.String toString() {
		return _userPosition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userPosition.toXmlString();
	}

	@Override
	public void persist() {
		_userPosition.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userPosition.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userPosition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userPosition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userPosition.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_userPosition.setNew(n);
	}

	/**
	* Sets the pos of this user position.
	*
	* @param pos the pos of this user position
	*/
	@Override
	public void setPos(java.lang.String pos) {
		_userPosition.setPos(pos);
	}

	/**
	* Sets the primary key of this user position.
	*
	* @param primaryKey the primary key of this user position
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_userPosition.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userPosition.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the ruolo economico of this user position.
	*
	* @param ruoloEconomico the ruolo economico of this user position
	*/
	@Override
	public void setRuoloEconomico(java.lang.String ruoloEconomico) {
		_userPosition.setRuoloEconomico(ruoloEconomico);
	}

	/**
	* Sets the ruolo giuridico of this user position.
	*
	* @param ruoloGiuridico the ruolo giuridico of this user position
	*/
	@Override
	public void setRuoloGiuridico(java.lang.String ruoloGiuridico) {
		_userPosition.setRuoloGiuridico(ruoloGiuridico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPositionWrapper)) {
			return false;
		}

		UserPositionWrapper userPositionWrapper = (UserPositionWrapper)obj;

		if (Objects.equals(_userPosition, userPositionWrapper._userPosition)) {
			return true;
		}

		return false;
	}

	@Override
	public UserPosition getWrappedModel() {
		return _userPosition;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userPosition.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userPosition.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userPosition.resetOriginalValues();
	}

	private final UserPosition _userPosition;
}