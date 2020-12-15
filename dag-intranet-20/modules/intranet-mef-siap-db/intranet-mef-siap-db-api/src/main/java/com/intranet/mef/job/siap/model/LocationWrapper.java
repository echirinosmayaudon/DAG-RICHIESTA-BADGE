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
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Location
 * @generated
 */
@ProviderType
public class LocationWrapper implements Location, ModelWrapper<Location> {
	public LocationWrapper(Location location) {
		_location = location;
	}

	@Override
	public Class<?> getModelClass() {
		return Location.class;
	}

	@Override
	public String getModelClassName() {
		return Location.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationID", getLocationID());
		attributes.put("name", getName());
		attributes.put("street", getStreet());
		attributes.put("city", getCity());
		attributes.put("postalCode", getPostalCode());
		attributes.put("locationType", getLocationType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationID = (Long)attributes.get("locationID");

		if (locationID != null) {
			setLocationID(locationID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String locationType = (String)attributes.get("locationType");

		if (locationType != null) {
			setLocationType(locationType);
		}
	}

	@Override
	public Location toEscapedModel() {
		return new LocationWrapper(_location.toEscapedModel());
	}

	@Override
	public Location toUnescapedModel() {
		return new LocationWrapper(_location.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _location.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _location.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _location.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _location.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Location> toCacheModel() {
		return _location.toCacheModel();
	}

	@Override
	public int compareTo(Location location) {
		return _location.compareTo(location);
	}

	@Override
	public int hashCode() {
		return _location.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _location.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LocationWrapper((Location)_location.clone());
	}

	/**
	* Returns the city of this location.
	*
	* @return the city of this location
	*/
	@Override
	public java.lang.String getCity() {
		return _location.getCity();
	}

	/**
	* Returns the location type of this location.
	*
	* @return the location type of this location
	*/
	@Override
	public java.lang.String getLocationType() {
		return _location.getLocationType();
	}

	/**
	* Returns the name of this location.
	*
	* @return the name of this location
	*/
	@Override
	public java.lang.String getName() {
		return _location.getName();
	}

	/**
	* Returns the postal code of this location.
	*
	* @return the postal code of this location
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _location.getPostalCode();
	}

	/**
	* Returns the street of this location.
	*
	* @return the street of this location
	*/
	@Override
	public java.lang.String getStreet() {
		return _location.getStreet();
	}

	@Override
	public java.lang.String toString() {
		return _location.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _location.toXmlString();
	}

	/**
	* Returns the location i d of this location.
	*
	* @return the location i d of this location
	*/
	@Override
	public long getLocationID() {
		return _location.getLocationID();
	}

	/**
	* Returns the primary key of this location.
	*
	* @return the primary key of this location
	*/
	@Override
	public long getPrimaryKey() {
		return _location.getPrimaryKey();
	}

	@Override
	public void persist() {
		_location.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_location.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this location.
	*
	* @param city the city of this location
	*/
	@Override
	public void setCity(java.lang.String city) {
		_location.setCity(city);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_location.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_location.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_location.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the location i d of this location.
	*
	* @param locationID the location i d of this location
	*/
	@Override
	public void setLocationID(long locationID) {
		_location.setLocationID(locationID);
	}

	/**
	* Sets the location type of this location.
	*
	* @param locationType the location type of this location
	*/
	@Override
	public void setLocationType(java.lang.String locationType) {
		_location.setLocationType(locationType);
	}

	/**
	* Sets the name of this location.
	*
	* @param name the name of this location
	*/
	@Override
	public void setName(java.lang.String name) {
		_location.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_location.setNew(n);
	}

	/**
	* Sets the postal code of this location.
	*
	* @param postalCode the postal code of this location
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_location.setPostalCode(postalCode);
	}

	/**
	* Sets the primary key of this location.
	*
	* @param primaryKey the primary key of this location
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_location.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_location.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the street of this location.
	*
	* @param street the street of this location
	*/
	@Override
	public void setStreet(java.lang.String street) {
		_location.setStreet(street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocationWrapper)) {
			return false;
		}

		LocationWrapper locationWrapper = (LocationWrapper)obj;

		if (Objects.equals(_location, locationWrapper._location)) {
			return true;
		}

		return false;
	}

	@Override
	public Location getWrappedModel() {
		return _location;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _location.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _location.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_location.resetOriginalValues();
	}

	private final Location _location;
}