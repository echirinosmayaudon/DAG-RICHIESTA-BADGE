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

package com.intranet.mef.job.siap.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.model.Location;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Location in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Location
 * @generated
 */
@ProviderType
public class LocationCacheModel implements CacheModel<Location>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocationCacheModel)) {
			return false;
		}

		LocationCacheModel locationCacheModel = (LocationCacheModel)obj;

		if (locationID == locationCacheModel.locationID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, locationID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{locationID=");
		sb.append(locationID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", street=");
		sb.append(street);
		sb.append(", city=");
		sb.append(city);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", locationType=");
		sb.append(locationType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Location toEntityModel() {
		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setLocationID(locationID);

		if (name == null) {
			locationImpl.setName(StringPool.BLANK);
		}
		else {
			locationImpl.setName(name);
		}

		if (street == null) {
			locationImpl.setStreet(StringPool.BLANK);
		}
		else {
			locationImpl.setStreet(street);
		}

		if (city == null) {
			locationImpl.setCity(StringPool.BLANK);
		}
		else {
			locationImpl.setCity(city);
		}

		if (postalCode == null) {
			locationImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			locationImpl.setPostalCode(postalCode);
		}

		if (locationType == null) {
			locationImpl.setLocationType(StringPool.BLANK);
		}
		else {
			locationImpl.setLocationType(locationType);
		}

		locationImpl.resetOriginalValues();

		return locationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		locationID = objectInput.readLong();
		name = objectInput.readUTF();
		street = objectInput.readUTF();
		city = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		locationType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(locationID);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (street == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		if (locationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationType);
		}
	}

	public long locationID;
	public String name;
	public String street;
	public String city;
	public String postalCode;
	public String locationType;
}