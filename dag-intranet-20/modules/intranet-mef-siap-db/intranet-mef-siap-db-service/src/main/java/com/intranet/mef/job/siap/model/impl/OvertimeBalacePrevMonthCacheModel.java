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

import com.intranet.mef.job.siap.model.OvertimeBalacePrevMonth;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OvertimeBalacePrevMonth in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalacePrevMonth
 * @generated
 */
@ProviderType
public class OvertimeBalacePrevMonthCacheModel implements CacheModel<OvertimeBalacePrevMonth>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OvertimeBalacePrevMonthCacheModel)) {
			return false;
		}

		OvertimeBalacePrevMonthCacheModel overtimeBalacePrevMonthCacheModel = (OvertimeBalacePrevMonthCacheModel)obj;

		if (personId == overtimeBalacePrevMonthCacheModel.personId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, personId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{personId=");
		sb.append(personId);
		sb.append(", overtimeDueCurrMonth=");
		sb.append(overtimeDueCurrMonth);
		sb.append(", overtimeMonthPrevRif=");
		sb.append(overtimeMonthPrevRif);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OvertimeBalacePrevMonth toEntityModel() {
		OvertimeBalacePrevMonthImpl overtimeBalacePrevMonthImpl = new OvertimeBalacePrevMonthImpl();

		overtimeBalacePrevMonthImpl.setPersonId(personId);
		overtimeBalacePrevMonthImpl.setOvertimeDueCurrMonth(overtimeDueCurrMonth);

		if (overtimeMonthPrevRif == null) {
			overtimeBalacePrevMonthImpl.setOvertimeMonthPrevRif(StringPool.BLANK);
		}
		else {
			overtimeBalacePrevMonthImpl.setOvertimeMonthPrevRif(overtimeMonthPrevRif);
		}

		overtimeBalacePrevMonthImpl.resetOriginalValues();

		return overtimeBalacePrevMonthImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personId = objectInput.readLong();

		overtimeDueCurrMonth = objectInput.readInt();
		overtimeMonthPrevRif = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personId);

		objectOutput.writeInt(overtimeDueCurrMonth);

		if (overtimeMonthPrevRif == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(overtimeMonthPrevRif);
		}
	}

	public long personId;
	public int overtimeDueCurrMonth;
	public String overtimeMonthPrevRif;
}