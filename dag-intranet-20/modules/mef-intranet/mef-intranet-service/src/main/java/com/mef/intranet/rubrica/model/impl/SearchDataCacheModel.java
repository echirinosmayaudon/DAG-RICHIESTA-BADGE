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

package com.mef.intranet.rubrica.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.mef.intranet.rubrica.model.SearchData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SearchData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SearchData
 * @generated
 */
@ProviderType
public class SearchDataCacheModel implements CacheModel<SearchData>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchDataCacheModel)) {
			return false;
		}

		SearchDataCacheModel searchDataCacheModel = (SearchDataCacheModel)obj;

		if (searchId == searchDataCacheModel.searchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, searchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", searchId=");
		sb.append(searchId);
		sb.append(", searchData=");
		sb.append(searchData);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SearchData toEntityModel() {
		SearchDataImpl searchDataImpl = new SearchDataImpl();

		if (uuid == null) {
			searchDataImpl.setUuid(StringPool.BLANK);
		}
		else {
			searchDataImpl.setUuid(uuid);
		}

		searchDataImpl.setSearchId(searchId);

		if (searchData == null) {
			searchDataImpl.setSearchData(StringPool.BLANK);
		}
		else {
			searchDataImpl.setSearchData(searchData);
		}

		if (createDate == Long.MIN_VALUE) {
			searchDataImpl.setCreateDate(null);
		}
		else {
			searchDataImpl.setCreateDate(new Date(createDate));
		}

		searchDataImpl.resetOriginalValues();

		return searchDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		searchId = objectInput.readLong();
		searchData = objectInput.readUTF();
		createDate = objectInput.readLong();
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

		objectOutput.writeLong(searchId);

		if (searchData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchData);
		}

		objectOutput.writeLong(createDate);
	}

	public String uuid;
	public long searchId;
	public String searchData;
	public long createDate;
}