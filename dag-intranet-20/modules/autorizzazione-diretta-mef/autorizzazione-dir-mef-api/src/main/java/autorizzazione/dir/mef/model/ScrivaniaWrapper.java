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

package autorizzazione.dir.mef.model;

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
 * This class is a wrapper for {@link Scrivania}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Scrivania
 * @generated
 */
@ProviderType
public class ScrivaniaWrapper implements Scrivania, ModelWrapper<Scrivania> {
	public ScrivaniaWrapper(Scrivania scrivania) {
		_scrivania = scrivania;
	}

	@Override
	public Class<?> getModelClass() {
		return Scrivania.class;
	}

	@Override
	public String getModelClassName() {
		return Scrivania.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rowId", getRowId());
		attributes.put("createDate", getCreateDate());
		attributes.put("userId", getUserId());
		attributes.put("applicationId", getApplicationId());
		attributes.put("homeFlag", getHomeFlag());
		attributes.put("profileFlag", getProfileFlag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rowId = (Long)attributes.get("rowId");

		if (rowId != null) {
			setRowId(rowId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long applicationId = (Long)attributes.get("applicationId");

		if (applicationId != null) {
			setApplicationId(applicationId);
		}

		Boolean homeFlag = (Boolean)attributes.get("homeFlag");

		if (homeFlag != null) {
			setHomeFlag(homeFlag);
		}

		Boolean profileFlag = (Boolean)attributes.get("profileFlag");

		if (profileFlag != null) {
			setProfileFlag(profileFlag);
		}
	}

	@Override
	public autorizzazione.dir.mef.model.Scrivania toEscapedModel() {
		return new ScrivaniaWrapper(_scrivania.toEscapedModel());
	}

	@Override
	public autorizzazione.dir.mef.model.Scrivania toUnescapedModel() {
		return new ScrivaniaWrapper(_scrivania.toUnescapedModel());
	}

	/**
	* Returns the primary key of this scrivania.
	*
	* @return the primary key of this scrivania
	*/
	@Override
	public autorizzazione.dir.mef.service.persistence.ScrivaniaPK getPrimaryKey() {
		return _scrivania.getPrimaryKey();
	}

	/**
	* Returns the home flag of this scrivania.
	*
	* @return the home flag of this scrivania
	*/
	@Override
	public boolean getHomeFlag() {
		return _scrivania.getHomeFlag();
	}

	/**
	* Returns the profile flag of this scrivania.
	*
	* @return the profile flag of this scrivania
	*/
	@Override
	public boolean getProfileFlag() {
		return _scrivania.getProfileFlag();
	}

	@Override
	public boolean isCachedModel() {
		return _scrivania.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _scrivania.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this scrivania is home flag.
	*
	* @return <code>true</code> if this scrivania is home flag; <code>false</code> otherwise
	*/
	@Override
	public boolean isHomeFlag() {
		return _scrivania.isHomeFlag();
	}

	@Override
	public boolean isNew() {
		return _scrivania.isNew();
	}

	/**
	* Returns <code>true</code> if this scrivania is profile flag.
	*
	* @return <code>true</code> if this scrivania is profile flag; <code>false</code> otherwise
	*/
	@Override
	public boolean isProfileFlag() {
		return _scrivania.isProfileFlag();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _scrivania.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<autorizzazione.dir.mef.model.Scrivania> toCacheModel() {
		return _scrivania.toCacheModel();
	}

	@Override
	public int compareTo(autorizzazione.dir.mef.model.Scrivania scrivania) {
		return _scrivania.compareTo(scrivania);
	}

	@Override
	public int hashCode() {
		return _scrivania.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scrivania.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ScrivaniaWrapper((Scrivania)_scrivania.clone());
	}

	/**
	* Returns the user uuid of this scrivania.
	*
	* @return the user uuid of this scrivania
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _scrivania.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _scrivania.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scrivania.toXmlString();
	}

	/**
	* Returns the create date of this scrivania.
	*
	* @return the create date of this scrivania
	*/
	@Override
	public Date getCreateDate() {
		return _scrivania.getCreateDate();
	}

	/**
	* Returns the application ID of this scrivania.
	*
	* @return the application ID of this scrivania
	*/
	@Override
	public long getApplicationId() {
		return _scrivania.getApplicationId();
	}

	/**
	* Returns the row ID of this scrivania.
	*
	* @return the row ID of this scrivania
	*/
	@Override
	public long getRowId() {
		return _scrivania.getRowId();
	}

	/**
	* Returns the user ID of this scrivania.
	*
	* @return the user ID of this scrivania
	*/
	@Override
	public long getUserId() {
		return _scrivania.getUserId();
	}

	@Override
	public void persist() {
		_scrivania.persist();
	}

	/**
	* Sets the application ID of this scrivania.
	*
	* @param applicationId the application ID of this scrivania
	*/
	@Override
	public void setApplicationId(long applicationId) {
		_scrivania.setApplicationId(applicationId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scrivania.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this scrivania.
	*
	* @param createDate the create date of this scrivania
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_scrivania.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_scrivania.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_scrivania.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_scrivania.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this scrivania is home flag.
	*
	* @param homeFlag the home flag of this scrivania
	*/
	@Override
	public void setHomeFlag(boolean homeFlag) {
		_scrivania.setHomeFlag(homeFlag);
	}

	@Override
	public void setNew(boolean n) {
		_scrivania.setNew(n);
	}

	/**
	* Sets the primary key of this scrivania.
	*
	* @param primaryKey the primary key of this scrivania
	*/
	@Override
	public void setPrimaryKey(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK primaryKey) {
		_scrivania.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_scrivania.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this scrivania is profile flag.
	*
	* @param profileFlag the profile flag of this scrivania
	*/
	@Override
	public void setProfileFlag(boolean profileFlag) {
		_scrivania.setProfileFlag(profileFlag);
	}

	/**
	* Sets the row ID of this scrivania.
	*
	* @param rowId the row ID of this scrivania
	*/
	@Override
	public void setRowId(long rowId) {
		_scrivania.setRowId(rowId);
	}

	/**
	* Sets the user ID of this scrivania.
	*
	* @param userId the user ID of this scrivania
	*/
	@Override
	public void setUserId(long userId) {
		_scrivania.setUserId(userId);
	}

	/**
	* Sets the user uuid of this scrivania.
	*
	* @param userUuid the user uuid of this scrivania
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_scrivania.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScrivaniaWrapper)) {
			return false;
		}

		ScrivaniaWrapper scrivaniaWrapper = (ScrivaniaWrapper)obj;

		if (Objects.equals(_scrivania, scrivaniaWrapper._scrivania)) {
			return true;
		}

		return false;
	}

	@Override
	public Scrivania getWrappedModel() {
		return _scrivania;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _scrivania.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _scrivania.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_scrivania.resetOriginalValues();
	}

	private final Scrivania _scrivania;
}