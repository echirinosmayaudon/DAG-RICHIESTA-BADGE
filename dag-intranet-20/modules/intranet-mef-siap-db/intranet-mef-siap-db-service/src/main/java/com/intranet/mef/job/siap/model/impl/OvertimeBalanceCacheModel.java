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

import com.intranet.mef.job.siap.model.OvertimeBalance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OvertimeBalance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalance
 * @generated
 */
@ProviderType
public class OvertimeBalanceCacheModel implements CacheModel<OvertimeBalance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OvertimeBalanceCacheModel)) {
			return false;
		}

		OvertimeBalanceCacheModel overtimeBalanceCacheModel = (OvertimeBalanceCacheModel)obj;

		if (personId == overtimeBalanceCacheModel.personId) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{overtimeMonthCurrRif=");
		sb.append(overtimeMonthCurrRif);
		sb.append(", personId=");
		sb.append(personId);
		sb.append(", overtimeBalHourCurMonth=");
		sb.append(overtimeBalHourCurMonth);
		sb.append(", overtimeBalacePrevMonth=");
		sb.append(overtimeBalacePrevMonth);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OvertimeBalance toEntityModel() {
		OvertimeBalanceImpl overtimeBalanceImpl = new OvertimeBalanceImpl();

		if (overtimeMonthCurrRif == null) {
			overtimeBalanceImpl.setOvertimeMonthCurrRif(StringPool.BLANK);
		}
		else {
			overtimeBalanceImpl.setOvertimeMonthCurrRif(overtimeMonthCurrRif);
		}

		overtimeBalanceImpl.setPersonId(personId);
		overtimeBalanceImpl.setOvertimeBalHourCurMonth(overtimeBalHourCurMonth);
		overtimeBalanceImpl.setOvertimeBalacePrevMonth(overtimeBalacePrevMonth);

		overtimeBalanceImpl.resetOriginalValues();

		return overtimeBalanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		overtimeMonthCurrRif = objectInput.readUTF();

		personId = objectInput.readLong();

		overtimeBalHourCurMonth = objectInput.readInt();

		overtimeBalacePrevMonth = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (overtimeMonthCurrRif == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(overtimeMonthCurrRif);
		}

		objectOutput.writeLong(personId);

		objectOutput.writeInt(overtimeBalHourCurMonth);

		objectOutput.writeInt(overtimeBalacePrevMonth);
	}

	public String overtimeMonthCurrRif;
	public long personId;
	public int overtimeBalHourCurMonth;
	public int overtimeBalacePrevMonth;
}