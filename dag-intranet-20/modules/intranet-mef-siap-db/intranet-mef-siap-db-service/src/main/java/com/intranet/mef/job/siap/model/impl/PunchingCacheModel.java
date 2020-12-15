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

import com.intranet.mef.job.siap.model.Punching;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Punching in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Punching
 * @generated
 */
@ProviderType
public class PunchingCacheModel implements CacheModel<Punching>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PunchingCacheModel)) {
			return false;
		}

		PunchingCacheModel punchingCacheModel = (PunchingCacheModel)obj;

		if (custom_key.equals(punchingCacheModel.custom_key)) {
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
		StringBundler sb = new StringBundler(21);

		sb.append("{custom_key=");
		sb.append(custom_key);
		sb.append(", personId=");
		sb.append(personId);
		sb.append(", punchingId=");
		sb.append(punchingId);
		sb.append(", direction=");
		sb.append(direction);
		sb.append(", hours=");
		sb.append(hours);
		sb.append(", minute=");
		sb.append(minute);
		sb.append(", voucher=");
		sb.append(voucher);
		sb.append(", terminal=");
		sb.append(terminal);
		sb.append(", accountingDate=");
		sb.append(accountingDate);
		sb.append(", punchingDate=");
		sb.append(punchingDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Punching toEntityModel() {
		PunchingImpl punchingImpl = new PunchingImpl();

		if (custom_key == null) {
			punchingImpl.setCustom_key(StringPool.BLANK);
		}
		else {
			punchingImpl.setCustom_key(custom_key);
		}

		punchingImpl.setPersonId(personId);
		punchingImpl.setPunchingId(punchingId);

		if (direction == null) {
			punchingImpl.setDirection(StringPool.BLANK);
		}
		else {
			punchingImpl.setDirection(direction);
		}

		punchingImpl.setHours(hours);

		if (minute == null) {
			punchingImpl.setMinute(StringPool.BLANK);
		}
		else {
			punchingImpl.setMinute(minute);
		}

		if (voucher == null) {
			punchingImpl.setVoucher(StringPool.BLANK);
		}
		else {
			punchingImpl.setVoucher(voucher);
		}

		if (terminal == null) {
			punchingImpl.setTerminal(StringPool.BLANK);
		}
		else {
			punchingImpl.setTerminal(terminal);
		}

		if (accountingDate == Long.MIN_VALUE) {
			punchingImpl.setAccountingDate(null);
		}
		else {
			punchingImpl.setAccountingDate(new Date(accountingDate));
		}

		if (punchingDate == Long.MIN_VALUE) {
			punchingImpl.setPunchingDate(null);
		}
		else {
			punchingImpl.setPunchingDate(new Date(punchingDate));
		}

		punchingImpl.resetOriginalValues();

		return punchingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		custom_key = objectInput.readUTF();

		personId = objectInput.readLong();

		punchingId = objectInput.readInt();
		direction = objectInput.readUTF();

		hours = objectInput.readInt();
		minute = objectInput.readUTF();
		voucher = objectInput.readUTF();
		terminal = objectInput.readUTF();
		accountingDate = objectInput.readLong();
		punchingDate = objectInput.readLong();
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

		objectOutput.writeInt(hours);

		if (minute == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(minute);
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

		objectOutput.writeLong(accountingDate);
		objectOutput.writeLong(punchingDate);
	}

	public String custom_key;
	public long personId;
	public int punchingId;
	public String direction;
	public int hours;
	public String minute;
	public String voucher;
	public String terminal;
	public long accountingDate;
	public long punchingDate;
}