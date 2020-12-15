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

package com.intranet.mef.daily.punching.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.daily.punching.model.DailyPunching;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DailyPunching in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DailyPunching
 * @generated
 */
@ProviderType
public class DailyPunchingCacheModel implements CacheModel<DailyPunching>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DailyPunchingCacheModel)) {
			return false;
		}

		DailyPunchingCacheModel dailyPunchingCacheModel = (DailyPunchingCacheModel)obj;

		if (custom_key.equals(dailyPunchingCacheModel.custom_key)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, custom_key);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{custom_key=");
		sb.append(custom_key);
		sb.append(", personId=");
		sb.append(personId);
		sb.append(", punchingId=");
		sb.append(punchingId);
		sb.append(", direction=");
		sb.append(direction);
		sb.append(", voucher=");
		sb.append(voucher);
		sb.append(", terminal=");
		sb.append(terminal);
		sb.append(", hours=");
		sb.append(hours);
		sb.append(", minute=");
		sb.append(minute);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DailyPunching toEntityModel() {
		DailyPunchingImpl dailyPunchingImpl = new DailyPunchingImpl();

		if (custom_key == null) {
			dailyPunchingImpl.setCustom_key(StringPool.BLANK);
		}
		else {
			dailyPunchingImpl.setCustom_key(custom_key);
		}

		dailyPunchingImpl.setPersonId(personId);
		dailyPunchingImpl.setPunchingId(punchingId);

		if (direction == null) {
			dailyPunchingImpl.setDirection(StringPool.BLANK);
		}
		else {
			dailyPunchingImpl.setDirection(direction);
		}

		if (voucher == null) {
			dailyPunchingImpl.setVoucher(StringPool.BLANK);
		}
		else {
			dailyPunchingImpl.setVoucher(voucher);
		}

		if (terminal == null) {
			dailyPunchingImpl.setTerminal(StringPool.BLANK);
		}
		else {
			dailyPunchingImpl.setTerminal(terminal);
		}

		dailyPunchingImpl.setHours(hours);

		if (minute == null) {
			dailyPunchingImpl.setMinute(StringPool.BLANK);
		}
		else {
			dailyPunchingImpl.setMinute(minute);
		}

		dailyPunchingImpl.resetOriginalValues();

		return dailyPunchingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		custom_key = objectInput.readUTF();

		personId = objectInput.readLong();

		punchingId = objectInput.readInt();
		direction = objectInput.readUTF();
		voucher = objectInput.readUTF();
		terminal = objectInput.readUTF();

		hours = objectInput.readInt();
		minute = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (custom_key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(custom_key);
		}

		objectOutput.writeLong(personId);

		objectOutput.writeInt(punchingId);

		if (direction == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(direction);
		}

		if (voucher == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(voucher);
		}

		if (terminal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(terminal);
		}

		objectOutput.writeInt(hours);

		if (minute == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(minute);
		}
	}

	public String custom_key;
	public long personId;
	public int punchingId;
	public String direction;
	public String voucher;
	public String terminal;
	public int hours;
	public String minute;
}