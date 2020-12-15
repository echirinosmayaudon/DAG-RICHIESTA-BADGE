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

package autorizzazione.dir.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.model.Scrivania;
import autorizzazione.dir.mef.service.persistence.ScrivaniaPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Scrivania in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Scrivania
 * @generated
 */
@ProviderType
public class ScrivaniaCacheModel implements CacheModel<Scrivania>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScrivaniaCacheModel)) {
			return false;
		}

		ScrivaniaCacheModel scrivaniaCacheModel = (ScrivaniaCacheModel)obj;

		if (scrivaniaPK.equals(scrivaniaCacheModel.scrivaniaPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, scrivaniaPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{rowId=");
		sb.append(rowId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", applicationId=");
		sb.append(applicationId);
		sb.append(", homeFlag=");
		sb.append(homeFlag);
		sb.append(", profileFlag=");
		sb.append(profileFlag);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Scrivania toEntityModel() {
		ScrivaniaImpl scrivaniaImpl = new ScrivaniaImpl();

		scrivaniaImpl.setRowId(rowId);

		if (createDate == Long.MIN_VALUE) {
			scrivaniaImpl.setCreateDate(null);
		}
		else {
			scrivaniaImpl.setCreateDate(new Date(createDate));
		}

		scrivaniaImpl.setUserId(userId);
		scrivaniaImpl.setApplicationId(applicationId);
		scrivaniaImpl.setHomeFlag(homeFlag);
		scrivaniaImpl.setProfileFlag(profileFlag);

		scrivaniaImpl.resetOriginalValues();

		return scrivaniaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rowId = objectInput.readLong();
		createDate = objectInput.readLong();

		userId = objectInput.readLong();

		applicationId = objectInput.readLong();

		homeFlag = objectInput.readBoolean();

		profileFlag = objectInput.readBoolean();

		scrivaniaPK = new ScrivaniaPK(userId, applicationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(rowId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(applicationId);

		objectOutput.writeBoolean(homeFlag);

		objectOutput.writeBoolean(profileFlag);
	}

	public long rowId;
	public long createDate;
	public long userId;
	public long applicationId;
	public boolean homeFlag;
	public boolean profileFlag;
	public transient ScrivaniaPK scrivaniaPK;
}