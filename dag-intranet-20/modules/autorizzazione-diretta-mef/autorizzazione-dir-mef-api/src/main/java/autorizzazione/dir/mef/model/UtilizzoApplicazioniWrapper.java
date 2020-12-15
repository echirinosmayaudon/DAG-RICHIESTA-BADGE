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
 * This class is a wrapper for {@link UtilizzoApplicazioni}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioni
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniWrapper implements UtilizzoApplicazioni,
	ModelWrapper<UtilizzoApplicazioni> {
	public UtilizzoApplicazioniWrapper(
		UtilizzoApplicazioni utilizzoApplicazioni) {
		_utilizzoApplicazioni = utilizzoApplicazioni;
	}

	@Override
	public Class<?> getModelClass() {
		return UtilizzoApplicazioni.class;
	}

	@Override
	public String getModelClassName() {
		return UtilizzoApplicazioni.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rowId", getRowId());
		attributes.put("createDate", getCreateDate());
		attributes.put("userId", getUserId());
		attributes.put("applicationId", getApplicationId());
		attributes.put("lastUseDate", getLastUseDate());
		attributes.put("hitsCount", getHitsCount());

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

		Date lastUseDate = (Date)attributes.get("lastUseDate");

		if (lastUseDate != null) {
			setLastUseDate(lastUseDate);
		}

		Integer hitsCount = (Integer)attributes.get("hitsCount");

		if (hitsCount != null) {
			setHitsCount(hitsCount);
		}
	}

	@Override
	public autorizzazione.dir.mef.model.UtilizzoApplicazioni toEscapedModel() {
		return new UtilizzoApplicazioniWrapper(_utilizzoApplicazioni.toEscapedModel());
	}

	@Override
	public autorizzazione.dir.mef.model.UtilizzoApplicazioni toUnescapedModel() {
		return new UtilizzoApplicazioniWrapper(_utilizzoApplicazioni.toUnescapedModel());
	}

	/**
	* Returns the primary key of this utilizzo applicazioni.
	*
	* @return the primary key of this utilizzo applicazioni
	*/
	@Override
	public autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK getPrimaryKey() {
		return _utilizzoApplicazioni.getPrimaryKey();
	}

	@Override
	public boolean isCachedModel() {
		return _utilizzoApplicazioni.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _utilizzoApplicazioni.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _utilizzoApplicazioni.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _utilizzoApplicazioni.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<autorizzazione.dir.mef.model.UtilizzoApplicazioni> toCacheModel() {
		return _utilizzoApplicazioni.toCacheModel();
	}

	@Override
	public int compareTo(
		autorizzazione.dir.mef.model.UtilizzoApplicazioni utilizzoApplicazioni) {
		return _utilizzoApplicazioni.compareTo(utilizzoApplicazioni);
	}

	/**
	* Returns the hits count of this utilizzo applicazioni.
	*
	* @return the hits count of this utilizzo applicazioni
	*/
	@Override
	public int getHitsCount() {
		return _utilizzoApplicazioni.getHitsCount();
	}

	@Override
	public int hashCode() {
		return _utilizzoApplicazioni.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _utilizzoApplicazioni.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UtilizzoApplicazioniWrapper((UtilizzoApplicazioni)_utilizzoApplicazioni.clone());
	}

	/**
	* Returns the user uuid of this utilizzo applicazioni.
	*
	* @return the user uuid of this utilizzo applicazioni
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _utilizzoApplicazioni.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _utilizzoApplicazioni.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _utilizzoApplicazioni.toXmlString();
	}

	/**
	* Returns the create date of this utilizzo applicazioni.
	*
	* @return the create date of this utilizzo applicazioni
	*/
	@Override
	public Date getCreateDate() {
		return _utilizzoApplicazioni.getCreateDate();
	}

	/**
	* Returns the last use date of this utilizzo applicazioni.
	*
	* @return the last use date of this utilizzo applicazioni
	*/
	@Override
	public Date getLastUseDate() {
		return _utilizzoApplicazioni.getLastUseDate();
	}

	/**
	* Returns the application ID of this utilizzo applicazioni.
	*
	* @return the application ID of this utilizzo applicazioni
	*/
	@Override
	public long getApplicationId() {
		return _utilizzoApplicazioni.getApplicationId();
	}

	/**
	* Returns the row ID of this utilizzo applicazioni.
	*
	* @return the row ID of this utilizzo applicazioni
	*/
	@Override
	public long getRowId() {
		return _utilizzoApplicazioni.getRowId();
	}

	/**
	* Returns the user ID of this utilizzo applicazioni.
	*
	* @return the user ID of this utilizzo applicazioni
	*/
	@Override
	public long getUserId() {
		return _utilizzoApplicazioni.getUserId();
	}

	@Override
	public void persist() {
		_utilizzoApplicazioni.persist();
	}

	/**
	* Sets the application ID of this utilizzo applicazioni.
	*
	* @param applicationId the application ID of this utilizzo applicazioni
	*/
	@Override
	public void setApplicationId(long applicationId) {
		_utilizzoApplicazioni.setApplicationId(applicationId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_utilizzoApplicazioni.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this utilizzo applicazioni.
	*
	* @param createDate the create date of this utilizzo applicazioni
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_utilizzoApplicazioni.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_utilizzoApplicazioni.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_utilizzoApplicazioni.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_utilizzoApplicazioni.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hits count of this utilizzo applicazioni.
	*
	* @param hitsCount the hits count of this utilizzo applicazioni
	*/
	@Override
	public void setHitsCount(int hitsCount) {
		_utilizzoApplicazioni.setHitsCount(hitsCount);
	}

	/**
	* Sets the last use date of this utilizzo applicazioni.
	*
	* @param lastUseDate the last use date of this utilizzo applicazioni
	*/
	@Override
	public void setLastUseDate(Date lastUseDate) {
		_utilizzoApplicazioni.setLastUseDate(lastUseDate);
	}

	@Override
	public void setNew(boolean n) {
		_utilizzoApplicazioni.setNew(n);
	}

	/**
	* Sets the primary key of this utilizzo applicazioni.
	*
	* @param primaryKey the primary key of this utilizzo applicazioni
	*/
	@Override
	public void setPrimaryKey(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK primaryKey) {
		_utilizzoApplicazioni.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_utilizzoApplicazioni.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the row ID of this utilizzo applicazioni.
	*
	* @param rowId the row ID of this utilizzo applicazioni
	*/
	@Override
	public void setRowId(long rowId) {
		_utilizzoApplicazioni.setRowId(rowId);
	}

	/**
	* Sets the user ID of this utilizzo applicazioni.
	*
	* @param userId the user ID of this utilizzo applicazioni
	*/
	@Override
	public void setUserId(long userId) {
		_utilizzoApplicazioni.setUserId(userId);
	}

	/**
	* Sets the user uuid of this utilizzo applicazioni.
	*
	* @param userUuid the user uuid of this utilizzo applicazioni
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_utilizzoApplicazioni.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UtilizzoApplicazioniWrapper)) {
			return false;
		}

		UtilizzoApplicazioniWrapper utilizzoApplicazioniWrapper = (UtilizzoApplicazioniWrapper)obj;

		if (Objects.equals(_utilizzoApplicazioni,
					utilizzoApplicazioniWrapper._utilizzoApplicazioni)) {
			return true;
		}

		return false;
	}

	@Override
	public UtilizzoApplicazioni getWrappedModel() {
		return _utilizzoApplicazioni;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _utilizzoApplicazioni.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _utilizzoApplicazioni.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_utilizzoApplicazioni.resetOriginalValues();
	}

	private final UtilizzoApplicazioni _utilizzoApplicazioni;
}