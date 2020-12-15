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

package mef.email.configurator.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import mef.email.configurator.model.AppNames;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AppNames in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AppNames
 * @generated
 */
@ProviderType
public class AppNamesCacheModel implements CacheModel<AppNames>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppNamesCacheModel)) {
			return false;
		}

		AppNamesCacheModel appNamesCacheModel = (AppNamesCacheModel)obj;

		if (id == appNamesCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", appname=");
		sb.append(appname);
		sb.append(", appid=");
		sb.append(appid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppNames toEntityModel() {
		AppNamesImpl appNamesImpl = new AppNamesImpl();

		appNamesImpl.setId(id);

		if (appname == null) {
			appNamesImpl.setAppname(StringPool.BLANK);
		}
		else {
			appNamesImpl.setAppname(appname);
		}

		appNamesImpl.setAppid(appid);

		appNamesImpl.resetOriginalValues();

		return appNamesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		appname = objectInput.readUTF();

		appid = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (appname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(appname);
		}

		objectOutput.writeLong(appid);
	}

	public long id;
	public String appname;
	public long appid;
}