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

package com.mef.intranet.rubrica.model;

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
 * This class is a wrapper for {@link SearchData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchData
 * @generated
 */
@ProviderType
public class SearchDataWrapper implements SearchData, ModelWrapper<SearchData> {
	public SearchDataWrapper(SearchData searchData) {
		_searchData = searchData;
	}

	@Override
	public Class<?> getModelClass() {
		return SearchData.class;
	}

	@Override
	public String getModelClassName() {
		return SearchData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("searchId", getSearchId());
		attributes.put("searchData", getSearchData());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long searchId = (Long)attributes.get("searchId");

		if (searchId != null) {
			setSearchId(searchId);
		}

		String searchData = (String)attributes.get("searchData");

		if (searchData != null) {
			setSearchData(searchData);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public SearchData toEscapedModel() {
		return new SearchDataWrapper(_searchData.toEscapedModel());
	}

	@Override
	public SearchData toUnescapedModel() {
		return new SearchDataWrapper(_searchData.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _searchData.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _searchData.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _searchData.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _searchData.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SearchData> toCacheModel() {
		return _searchData.toCacheModel();
	}

	@Override
	public int compareTo(SearchData searchData) {
		return _searchData.compareTo(searchData);
	}

	@Override
	public int hashCode() {
		return _searchData.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _searchData.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SearchDataWrapper((SearchData)_searchData.clone());
	}

	/**
	* Returns the search data of this search data.
	*
	* @return the search data of this search data
	*/
	@Override
	public java.lang.String getSearchData() {
		return _searchData.getSearchData();
	}

	/**
	* Returns the uuid of this search data.
	*
	* @return the uuid of this search data
	*/
	@Override
	public java.lang.String getUuid() {
		return _searchData.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _searchData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _searchData.toXmlString();
	}

	/**
	* Returns the create date of this search data.
	*
	* @return the create date of this search data
	*/
	@Override
	public Date getCreateDate() {
		return _searchData.getCreateDate();
	}

	/**
	* Returns the primary key of this search data.
	*
	* @return the primary key of this search data
	*/
	@Override
	public long getPrimaryKey() {
		return _searchData.getPrimaryKey();
	}

	/**
	* Returns the search ID of this search data.
	*
	* @return the search ID of this search data
	*/
	@Override
	public long getSearchId() {
		return _searchData.getSearchId();
	}

	@Override
	public void persist() {
		_searchData.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_searchData.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this search data.
	*
	* @param createDate the create date of this search data
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_searchData.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_searchData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_searchData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_searchData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_searchData.setNew(n);
	}

	/**
	* Sets the primary key of this search data.
	*
	* @param primaryKey the primary key of this search data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_searchData.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_searchData.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the search data of this search data.
	*
	* @param searchData the search data of this search data
	*/
	@Override
	public void setSearchData(java.lang.String searchData) {
		_searchData.setSearchData(searchData);
	}

	/**
	* Sets the search ID of this search data.
	*
	* @param searchId the search ID of this search data
	*/
	@Override
	public void setSearchId(long searchId) {
		_searchData.setSearchId(searchId);
	}

	/**
	* Sets the uuid of this search data.
	*
	* @param uuid the uuid of this search data
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_searchData.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchDataWrapper)) {
			return false;
		}

		SearchDataWrapper searchDataWrapper = (SearchDataWrapper)obj;

		if (Objects.equals(_searchData, searchDataWrapper._searchData)) {
			return true;
		}

		return false;
	}

	@Override
	public SearchData getWrappedModel() {
		return _searchData;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _searchData.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _searchData.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_searchData.resetOriginalValues();
	}

	private final SearchData _searchData;
}