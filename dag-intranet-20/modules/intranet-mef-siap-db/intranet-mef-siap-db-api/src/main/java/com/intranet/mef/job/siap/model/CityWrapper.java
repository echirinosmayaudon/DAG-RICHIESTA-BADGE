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
 * This class is a wrapper for {@link City}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see City
 * @generated
 */
@ProviderType
public class CityWrapper implements City, ModelWrapper<City> {
	public CityWrapper(City city) {
		_city = city;
	}

	@Override
	public Class<?> getModelClass() {
		return City.class;
	}

	@Override
	public String getModelClassName() {
		return City.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("istatCode", getIstatCode());
		attributes.put("name", getName());
		attributes.put("province", getProvince());
		attributes.put("provinceName", getProvinceName());
		attributes.put("district", getDistrict());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String istatCode = (String)attributes.get("istatCode");

		if (istatCode != null) {
			setIstatCode(istatCode);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String province = (String)attributes.get("province");

		if (province != null) {
			setProvince(province);
		}

		String provinceName = (String)attributes.get("provinceName");

		if (provinceName != null) {
			setProvinceName(provinceName);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}
	}

	@Override
	public City toEscapedModel() {
		return new CityWrapper(_city.toEscapedModel());
	}

	@Override
	public City toUnescapedModel() {
		return new CityWrapper(_city.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _city.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _city.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _city.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _city.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<City> toCacheModel() {
		return _city.toCacheModel();
	}

	@Override
	public int compareTo(City city) {
		return _city.compareTo(city);
	}

	@Override
	public int hashCode() {
		return _city.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _city.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CityWrapper((City)_city.clone());
	}

	/**
	* Returns the district of this city.
	*
	* @return the district of this city
	*/
	@Override
	public java.lang.String getDistrict() {
		return _city.getDistrict();
	}

	/**
	* Returns the istat code of this city.
	*
	* @return the istat code of this city
	*/
	@Override
	public java.lang.String getIstatCode() {
		return _city.getIstatCode();
	}

	/**
	* Returns the name of this city.
	*
	* @return the name of this city
	*/
	@Override
	public java.lang.String getName() {
		return _city.getName();
	}

	/**
	* Returns the primary key of this city.
	*
	* @return the primary key of this city
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _city.getPrimaryKey();
	}

	/**
	* Returns the province of this city.
	*
	* @return the province of this city
	*/
	@Override
	public java.lang.String getProvince() {
		return _city.getProvince();
	}

	/**
	* Returns the province name of this city.
	*
	* @return the province name of this city
	*/
	@Override
	public java.lang.String getProvinceName() {
		return _city.getProvinceName();
	}

	@Override
	public java.lang.String toString() {
		return _city.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _city.toXmlString();
	}

	@Override
	public void persist() {
		_city.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_city.setCachedModel(cachedModel);
	}

	/**
	* Sets the district of this city.
	*
	* @param district the district of this city
	*/
	@Override
	public void setDistrict(java.lang.String district) {
		_city.setDistrict(district);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_city.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_city.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_city.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the istat code of this city.
	*
	* @param istatCode the istat code of this city
	*/
	@Override
	public void setIstatCode(java.lang.String istatCode) {
		_city.setIstatCode(istatCode);
	}

	/**
	* Sets the name of this city.
	*
	* @param name the name of this city
	*/
	@Override
	public void setName(java.lang.String name) {
		_city.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_city.setNew(n);
	}

	/**
	* Sets the primary key of this city.
	*
	* @param primaryKey the primary key of this city
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_city.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_city.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the province of this city.
	*
	* @param province the province of this city
	*/
	@Override
	public void setProvince(java.lang.String province) {
		_city.setProvince(province);
	}

	/**
	* Sets the province name of this city.
	*
	* @param provinceName the province name of this city
	*/
	@Override
	public void setProvinceName(java.lang.String provinceName) {
		_city.setProvinceName(provinceName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CityWrapper)) {
			return false;
		}

		CityWrapper cityWrapper = (CityWrapper)obj;

		if (Objects.equals(_city, cityWrapper._city)) {
			return true;
		}

		return false;
	}

	@Override
	public City getWrappedModel() {
		return _city;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _city.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _city.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_city.resetOriginalValues();
	}

	private final City _city;
}