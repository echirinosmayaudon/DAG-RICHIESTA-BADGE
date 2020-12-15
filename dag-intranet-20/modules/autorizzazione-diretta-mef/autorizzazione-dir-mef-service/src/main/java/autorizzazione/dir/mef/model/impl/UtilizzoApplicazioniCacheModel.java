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

import autorizzazione.dir.mef.model.UtilizzoApplicazioni;
import autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UtilizzoApplicazioni in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioni
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniCacheModel implements CacheModel<UtilizzoApplicazioni>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UtilizzoApplicazioniCacheModel)) {
			return false;
		}

		UtilizzoApplicazioniCacheModel utilizzoApplicazioniCacheModel = (UtilizzoApplicazioniCacheModel)obj;

		if (utilizzoApplicazioniPK.equals(
					utilizzoApplicazioniCacheModel.utilizzoApplicazioniPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, utilizzoApplicazioniPK);
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
		sb.append(", lastUseDate=");
		sb.append(lastUseDate);
		sb.append(", hitsCount=");
		sb.append(hitsCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UtilizzoApplicazioni toEntityModel() {
		UtilizzoApplicazioniImpl utilizzoApplicazioniImpl = new UtilizzoApplicazioniImpl();

		utilizzoApplicazioniImpl.setRowId(rowId);

		if (createDate == Long.MIN_VALUE) {
			utilizzoApplicazioniImpl.setCreateDate(null);
		}
		else {
			utilizzoApplicazioniImpl.setCreateDate(new Date(createDate));
		}

		utilizzoApplicazioniImpl.setUserId(userId);
		utilizzoApplicazioniImpl.setApplicationId(applicationId);

		if (lastUseDate == Long.MIN_VALUE) {
			utilizzoApplicazioniImpl.setLastUseDate(null);
		}
		else {
			utilizzoApplicazioniImpl.setLastUseDate(new Date(lastUseDate));
		}

		utilizzoApplicazioniImpl.setHitsCount(hitsCount);

		utilizzoApplicazioniImpl.resetOriginalValues();

		return utilizzoApplicazioniImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rowId = objectInput.readLong();
		createDate = objectInput.readLong();

		userId = objectInput.readLong();

		applicationId = objectInput.readLong();
		lastUseDate = objectInput.readLong();

		hitsCount = objectInput.readInt();

		utilizzoApplicazioniPK = new UtilizzoApplicazioniPK(userId,
				applicationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(rowId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(applicationId);
		objectOutput.writeLong(lastUseDate);

		objectOutput.writeInt(hitsCount);
	}

	public long rowId;
	public long createDate;
	public long userId;
	public long applicationId;
	public long lastUseDate;
	public int hitsCount;
	public transient UtilizzoApplicazioniPK utilizzoApplicazioniPK;
}