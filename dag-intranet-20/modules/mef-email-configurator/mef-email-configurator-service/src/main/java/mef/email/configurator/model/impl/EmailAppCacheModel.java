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

import mef.email.configurator.model.EmailApp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmailApp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EmailApp
 * @generated
 */
@ProviderType
public class EmailAppCacheModel implements CacheModel<EmailApp>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailAppCacheModel)) {
			return false;
		}

		EmailAppCacheModel emailAppCacheModel = (EmailAppCacheModel)obj;

		if (id == emailAppCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", appid=");
		sb.append(appid);
		sb.append(", struttura=");
		sb.append(struttura);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmailApp toEntityModel() {
		EmailAppImpl emailAppImpl = new EmailAppImpl();

		emailAppImpl.setId(id);
		emailAppImpl.setAppid(appid);
		emailAppImpl.setStruttura(struttura);

		if (email == null) {
			emailAppImpl.setEmail(StringPool.BLANK);
		}
		else {
			emailAppImpl.setEmail(email);
		}

		emailAppImpl.resetOriginalValues();

		return emailAppImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		appid = objectInput.readLong();

		struttura = objectInput.readLong();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(appid);

		objectOutput.writeLong(struttura);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public long id;
	public long appid;
	public long struttura;
	public String email;
}