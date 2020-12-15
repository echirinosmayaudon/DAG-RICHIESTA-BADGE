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
 * This class is a wrapper for {@link ClassificationLevel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClassificationLevel
 * @generated
 */
@ProviderType
public class ClassificationLevelWrapper implements ClassificationLevel,
	ModelWrapper<ClassificationLevel> {
	public ClassificationLevelWrapper(ClassificationLevel classificationLevel) {
		_classificationLevel = classificationLevel;
	}

	@Override
	public Class<?> getModelClass() {
		return ClassificationLevel.class;
	}

	@Override
	public String getModelClassName() {
		return ClassificationLevel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("levelID", getLevelID());
		attributes.put("codLegalPos", getCodLegalPos());
		attributes.put("descLegalPos", getDescLegalPos());
		attributes.put("codEconomicPos", getCodEconomicPos());
		attributes.put("descEconomicPos", getDescEconomicPos());
		attributes.put("area", getArea());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long levelID = (Long)attributes.get("levelID");

		if (levelID != null) {
			setLevelID(levelID);
		}

		String codLegalPos = (String)attributes.get("codLegalPos");

		if (codLegalPos != null) {
			setCodLegalPos(codLegalPos);
		}

		String descLegalPos = (String)attributes.get("descLegalPos");

		if (descLegalPos != null) {
			setDescLegalPos(descLegalPos);
		}

		String codEconomicPos = (String)attributes.get("codEconomicPos");

		if (codEconomicPos != null) {
			setCodEconomicPos(codEconomicPos);
		}

		String descEconomicPos = (String)attributes.get("descEconomicPos");

		if (descEconomicPos != null) {
			setDescEconomicPos(descEconomicPos);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}
	}

	@Override
	public ClassificationLevel toEscapedModel() {
		return new ClassificationLevelWrapper(_classificationLevel.toEscapedModel());
	}

	@Override
	public ClassificationLevel toUnescapedModel() {
		return new ClassificationLevelWrapper(_classificationLevel.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _classificationLevel.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _classificationLevel.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _classificationLevel.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _classificationLevel.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ClassificationLevel> toCacheModel() {
		return _classificationLevel.toCacheModel();
	}

	@Override
	public int compareTo(ClassificationLevel classificationLevel) {
		return _classificationLevel.compareTo(classificationLevel);
	}

	@Override
	public int hashCode() {
		return _classificationLevel.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _classificationLevel.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ClassificationLevelWrapper((ClassificationLevel)_classificationLevel.clone());
	}

	/**
	* Returns the area of this classification level.
	*
	* @return the area of this classification level
	*/
	@Override
	public java.lang.String getArea() {
		return _classificationLevel.getArea();
	}

	/**
	* Returns the cod economic pos of this classification level.
	*
	* @return the cod economic pos of this classification level
	*/
	@Override
	public java.lang.String getCodEconomicPos() {
		return _classificationLevel.getCodEconomicPos();
	}

	/**
	* Returns the cod legal pos of this classification level.
	*
	* @return the cod legal pos of this classification level
	*/
	@Override
	public java.lang.String getCodLegalPos() {
		return _classificationLevel.getCodLegalPos();
	}

	/**
	* Returns the desc economic pos of this classification level.
	*
	* @return the desc economic pos of this classification level
	*/
	@Override
	public java.lang.String getDescEconomicPos() {
		return _classificationLevel.getDescEconomicPos();
	}

	/**
	* Returns the desc legal pos of this classification level.
	*
	* @return the desc legal pos of this classification level
	*/
	@Override
	public java.lang.String getDescLegalPos() {
		return _classificationLevel.getDescLegalPos();
	}

	@Override
	public java.lang.String toString() {
		return _classificationLevel.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _classificationLevel.toXmlString();
	}

	/**
	* Returns the level i d of this classification level.
	*
	* @return the level i d of this classification level
	*/
	@Override
	public long getLevelID() {
		return _classificationLevel.getLevelID();
	}

	/**
	* Returns the primary key of this classification level.
	*
	* @return the primary key of this classification level
	*/
	@Override
	public long getPrimaryKey() {
		return _classificationLevel.getPrimaryKey();
	}

	@Override
	public void persist() {
		_classificationLevel.persist();
	}

	/**
	* Sets the area of this classification level.
	*
	* @param area the area of this classification level
	*/
	@Override
	public void setArea(java.lang.String area) {
		_classificationLevel.setArea(area);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_classificationLevel.setCachedModel(cachedModel);
	}

	/**
	* Sets the cod economic pos of this classification level.
	*
	* @param codEconomicPos the cod economic pos of this classification level
	*/
	@Override
	public void setCodEconomicPos(java.lang.String codEconomicPos) {
		_classificationLevel.setCodEconomicPos(codEconomicPos);
	}

	/**
	* Sets the cod legal pos of this classification level.
	*
	* @param codLegalPos the cod legal pos of this classification level
	*/
	@Override
	public void setCodLegalPos(java.lang.String codLegalPos) {
		_classificationLevel.setCodLegalPos(codLegalPos);
	}

	/**
	* Sets the desc economic pos of this classification level.
	*
	* @param descEconomicPos the desc economic pos of this classification level
	*/
	@Override
	public void setDescEconomicPos(java.lang.String descEconomicPos) {
		_classificationLevel.setDescEconomicPos(descEconomicPos);
	}

	/**
	* Sets the desc legal pos of this classification level.
	*
	* @param descLegalPos the desc legal pos of this classification level
	*/
	@Override
	public void setDescLegalPos(java.lang.String descLegalPos) {
		_classificationLevel.setDescLegalPos(descLegalPos);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_classificationLevel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_classificationLevel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_classificationLevel.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the level i d of this classification level.
	*
	* @param levelID the level i d of this classification level
	*/
	@Override
	public void setLevelID(long levelID) {
		_classificationLevel.setLevelID(levelID);
	}

	@Override
	public void setNew(boolean n) {
		_classificationLevel.setNew(n);
	}

	/**
	* Sets the primary key of this classification level.
	*
	* @param primaryKey the primary key of this classification level
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_classificationLevel.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_classificationLevel.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClassificationLevelWrapper)) {
			return false;
		}

		ClassificationLevelWrapper classificationLevelWrapper = (ClassificationLevelWrapper)obj;

		if (Objects.equals(_classificationLevel,
					classificationLevelWrapper._classificationLevel)) {
			return true;
		}

		return false;
	}

	@Override
	public ClassificationLevel getWrappedModel() {
		return _classificationLevel;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _classificationLevel.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _classificationLevel.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_classificationLevel.resetOriginalValues();
	}

	private final ClassificationLevel _classificationLevel;
}