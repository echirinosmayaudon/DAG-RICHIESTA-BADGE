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

package com.intranet.mef.assistance.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Area;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Area in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
@ProviderType
public class AreaCacheModel implements CacheModel<Area>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AreaCacheModel)) {
			return false;
		}

		AreaCacheModel areaCacheModel = (AreaCacheModel)obj;

		if (areaId.equals(areaCacheModel.areaId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, areaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", areaId=");
		sb.append(areaId);
		sb.append(", areaName=");
		sb.append(areaName);
		sb.append(", assServiceId=");
		sb.append(assServiceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Area toEntityModel() {
		AreaImpl areaImpl = new AreaImpl();

		if (uuid == null) {
			areaImpl.setUuid(StringPool.BLANK);
		}
		else {
			areaImpl.setUuid(uuid);
		}

		if (areaId == null) {
			areaImpl.setAreaId(StringPool.BLANK);
		}
		else {
			areaImpl.setAreaId(areaId);
		}

		if (areaName == null) {
			areaImpl.setAreaName(StringPool.BLANK);
		}
		else {
			areaImpl.setAreaName(areaName);
		}

		if (assServiceId == null) {
			areaImpl.setAssServiceId(StringPool.BLANK);
		}
		else {
			areaImpl.setAssServiceId(assServiceId);
		}

		areaImpl.resetOriginalValues();

		return areaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		areaId = objectInput.readUTF();
		areaName = objectInput.readUTF();
		assServiceId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (areaId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaId);
		}

		if (areaName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaName);
		}

		if (assServiceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assServiceId);
		}
	}

	public String uuid;
	public String areaId;
	public String areaName;
	public String assServiceId;
}