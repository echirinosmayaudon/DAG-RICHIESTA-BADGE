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

package com.cacheportlet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.cacheportlet.mef.model.CachePortlet;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CachePortlet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CachePortlet
 * @generated
 */
@ProviderType
public class CachePortletCacheModel implements CacheModel<CachePortlet>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CachePortletCacheModel)) {
			return false;
		}

		CachePortletCacheModel cachePortletCacheModel = (CachePortletCacheModel)obj;

		if (portletId.equals(cachePortletCacheModel.portletId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, portletId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", jsonData=");
		sb.append(jsonData);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CachePortlet toEntityModel() {
		CachePortletImpl cachePortletImpl = new CachePortletImpl();

		if (uuid == null) {
			cachePortletImpl.setUuid(StringPool.BLANK);
		}
		else {
			cachePortletImpl.setUuid(uuid);
		}

		if (portletId == null) {
			cachePortletImpl.setPortletId(StringPool.BLANK);
		}
		else {
			cachePortletImpl.setPortletId(portletId);
		}

		if (jsonData == null) {
			cachePortletImpl.setJsonData(StringPool.BLANK);
		}
		else {
			cachePortletImpl.setJsonData(jsonData);
		}

		if (timestamp == null) {
			cachePortletImpl.setTimestamp(StringPool.BLANK);
		}
		else {
			cachePortletImpl.setTimestamp(timestamp);
		}

		cachePortletImpl.resetOriginalValues();

		return cachePortletImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		portletId = objectInput.readUTF();
		jsonData = objectInput.readUTF();
		timestamp = objectInput.readUTF();
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

		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		if (jsonData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsonData);
		}

		if (timestamp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timestamp);
		}
	}

	public String uuid;
	public String portletId;
	public String jsonData;
	public String timestamp;
}