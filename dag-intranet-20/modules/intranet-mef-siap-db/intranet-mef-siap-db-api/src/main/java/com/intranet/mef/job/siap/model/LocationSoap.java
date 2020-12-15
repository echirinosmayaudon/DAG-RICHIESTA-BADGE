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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.LocationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.LocationServiceSoap
 * @generated
 */
@ProviderType
public class LocationSoap implements Serializable {
	public static LocationSoap toSoapModel(Location model) {
		LocationSoap soapModel = new LocationSoap();

		soapModel.setLocationID(model.getLocationID());
		soapModel.setName(model.getName());
		soapModel.setStreet(model.getStreet());
		soapModel.setCity(model.getCity());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setLocationType(model.getLocationType());

		return soapModel;
	}

	public static LocationSoap[] toSoapModels(Location[] models) {
		LocationSoap[] soapModels = new LocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[][] toSoapModels(Location[][] models) {
		LocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[] toSoapModels(List<Location> models) {
		List<LocationSoap> soapModels = new ArrayList<LocationSoap>(models.size());

		for (Location model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocationSoap[soapModels.size()]);
	}

	public LocationSoap() {
	}

	public long getPrimaryKey() {
		return _locationID;
	}

	public void setPrimaryKey(long pk) {
		setLocationID(pk);
	}

	public long getLocationID() {
		return _locationID;
	}

	public void setLocationID(long locationID) {
		_locationID = locationID;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getLocationType() {
		return _locationType;
	}

	public void setLocationType(String locationType) {
		_locationType = locationType;
	}

	private long _locationID;
	private String _name;
	private String _street;
	private String _city;
	private String _postalCode;
	private String _locationType;
}