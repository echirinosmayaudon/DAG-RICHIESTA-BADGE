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

import com.intranet.mef.job.siap.model.CurrentBalanceHours;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CurrentBalanceHours in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CurrentBalanceHours
 * @generated
 */
@ProviderType
public class CurrentBalanceHoursCacheModel implements CacheModel<CurrentBalanceHours>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CurrentBalanceHoursCacheModel)) {
			return false;
		}

		CurrentBalanceHoursCacheModel currentBalanceHoursCacheModel = (CurrentBalanceHoursCacheModel)obj;

		if (personId == currentBalanceHoursCacheModel.personId) {
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
		sb.append(", balanceHoursCurDate=");
		sb.append(balanceHoursCurDate);
		sb.append(", balanceHours=");
		sb.append(balanceHours);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CurrentBalanceHours toEntityModel() {
		CurrentBalanceHoursImpl currentBalanceHoursImpl = new CurrentBalanceHoursImpl();

		currentBalanceHoursImpl.setPersonId(personId);

		if (balanceHoursCurDate == Long.MIN_VALUE) {
			currentBalanceHoursImpl.setBalanceHoursCurDate(null);
		}
		else {
			currentBalanceHoursImpl.setBalanceHoursCurDate(new Date(
					balanceHoursCurDate));
		}

		currentBalanceHoursImpl.setBalanceHours(balanceHours);

		currentBalanceHoursImpl.resetOriginalValues();

		return currentBalanceHoursImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personId = objectInput.readLong();
		balanceHoursCurDate = objectInput.readLong();

		balanceHours = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personId);
		objectOutput.writeLong(balanceHoursCurDate);

		objectOutput.writeInt(balanceHours);
	}

	public long personId;
	public long balanceHoursCurDate;
	public int balanceHours;
}