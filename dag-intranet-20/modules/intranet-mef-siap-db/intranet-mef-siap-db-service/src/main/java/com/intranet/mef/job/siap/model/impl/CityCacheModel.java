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

import com.intranet.mef.job.siap.model.City;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing City in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see City
 * @generated
 */
@ProviderType
public class CityCacheModel implements CacheModel<City>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CityCacheModel)) {
			return false;
		}

		CityCacheModel cityCacheModel = (CityCacheModel)obj;

		if (istatCode.equals(cityCacheModel.istatCode)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, istatCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{istatCode=");
		sb.append(istatCode);
		sb.append(", name=");
		sb.append(name);
		sb.append(", province=");
		sb.append(province);
		sb.append(", provinceName=");
		sb.append(provinceName);
		sb.append(", district=");
		sb.append(district);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public City toEntityModel() {
		CityImpl cityImpl = new CityImpl();

		if (istatCode == null) {
			cityImpl.setIstatCode(StringPool.BLANK);
		}
		else {
			cityImpl.setIstatCode(istatCode);
		}

		if (name == null) {
			cityImpl.setName(StringPool.BLANK);
		}
		else {
			cityImpl.setName(name);
		}

		if (province == null) {
			cityImpl.setProvince(StringPool.BLANK);
		}
		else {
			cityImpl.setProvince(province);
		}

		if (provinceName == null) {
			cityImpl.setProvinceName(StringPool.BLANK);
		}
		else {
			cityImpl.setProvinceName(provinceName);
		}

		if (district == null) {
			cityImpl.setDistrict(StringPool.BLANK);
		}
		else {
			cityImpl.setDistrict(district);
		}

		cityImpl.resetOriginalValues();

		return cityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		istatCode = objectInput.readUTF();
		name = objectInput.readUTF();
		province = objectInput.readUTF();
		provinceName = objectInput.readUTF();
		district = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (istatCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(istatCode);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (province == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(province);
		}

		if (provinceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(provinceName);
		}

		if (district == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(district);
		}
	}

	public String istatCode;
	public String name;
	public String province;
	public String provinceName;
	public String district;
}