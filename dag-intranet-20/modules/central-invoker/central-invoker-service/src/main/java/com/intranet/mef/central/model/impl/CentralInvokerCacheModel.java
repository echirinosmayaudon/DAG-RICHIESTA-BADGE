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

package com.intranet.mef.central.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.central.model.CentralInvoker;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CentralInvoker in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvoker
 * @generated
 */
@ProviderType
public class CentralInvokerCacheModel implements CacheModel<CentralInvoker>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CentralInvokerCacheModel)) {
			return false;
		}

		CentralInvokerCacheModel centralInvokerCacheModel = (CentralInvokerCacheModel)obj;

		if (idRecord == centralInvokerCacheModel.idRecord) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idRecord);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", idRecord=");
		sb.append(idRecord);
		sb.append(", secretaryId=");
		sb.append(secretaryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CentralInvoker toEntityModel() {
		CentralInvokerImpl centralInvokerImpl = new CentralInvokerImpl();

		if (uuid == null) {
			centralInvokerImpl.setUuid(StringPool.BLANK);
		}
		else {
			centralInvokerImpl.setUuid(uuid);
		}

		centralInvokerImpl.setIdRecord(idRecord);
		centralInvokerImpl.setSecretaryId(secretaryId);

		centralInvokerImpl.resetOriginalValues();

		return centralInvokerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		idRecord = objectInput.readLong();

		secretaryId = objectInput.readLong();
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

		objectOutput.writeLong(idRecord);

		objectOutput.writeLong(secretaryId);
	}

	public String uuid;
	public long idRecord;
	public long secretaryId;
}