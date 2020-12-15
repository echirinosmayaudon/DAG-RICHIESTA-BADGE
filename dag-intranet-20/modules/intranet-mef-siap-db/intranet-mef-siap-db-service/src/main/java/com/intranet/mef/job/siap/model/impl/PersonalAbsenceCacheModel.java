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

import com.intranet.mef.job.siap.model.PersonalAbsence;

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
 * The cache model class for representing PersonalAbsence in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsence
 * @generated
 */
@ProviderType
public class PersonalAbsenceCacheModel implements CacheModel<PersonalAbsence>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonalAbsenceCacheModel)) {
			return false;
		}

		PersonalAbsenceCacheModel personalAbsenceCacheModel = (PersonalAbsenceCacheModel)obj;

		if (custom_key.equals(personalAbsenceCacheModel.custom_key)) {
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
		sb.append(", absenceDate=");
		sb.append(absenceDate);
		sb.append(", refMonth=");
		sb.append(refMonth);
		sb.append(", absenceCode=");
		sb.append(absenceCode);
		sb.append(", completeDay=");
		sb.append(completeDay);
		sb.append(", from=");
		sb.append(from);
		sb.append(", to=");
		sb.append(to);
		sb.append(", hours=");
		sb.append(hours);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersonalAbsence toEntityModel() {
		PersonalAbsenceImpl personalAbsenceImpl = new PersonalAbsenceImpl();

		if (custom_key == null) {
			personalAbsenceImpl.setCustom_key(StringPool.BLANK);
		}
		else {
			personalAbsenceImpl.setCustom_key(custom_key);
		}

		personalAbsenceImpl.setPersonId(personId);

		if (absenceDate == Long.MIN_VALUE) {
			personalAbsenceImpl.setAbsenceDate(null);
		}
		else {
			personalAbsenceImpl.setAbsenceDate(new Date(absenceDate));
		}

		if (refMonth == null) {
			personalAbsenceImpl.setRefMonth(StringPool.BLANK);
		}
		else {
			personalAbsenceImpl.setRefMonth(refMonth);
		}

		if (absenceCode == null) {
			personalAbsenceImpl.setAbsenceCode(StringPool.BLANK);
		}
		else {
			personalAbsenceImpl.setAbsenceCode(absenceCode);
		}

		if (completeDay == null) {
			personalAbsenceImpl.setCompleteDay(StringPool.BLANK);
		}
		else {
			personalAbsenceImpl.setCompleteDay(completeDay);
		}

		personalAbsenceImpl.setFrom(from);
		personalAbsenceImpl.setTo(to);
		personalAbsenceImpl.setHours(hours);

		if (description == null) {
			personalAbsenceImpl.setDescription(StringPool.BLANK);
		}
		else {
			personalAbsenceImpl.setDescription(description);
		}

		personalAbsenceImpl.resetOriginalValues();

		return personalAbsenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		custom_key = objectInput.readUTF();

		personId = objectInput.readLong();
		absenceDate = objectInput.readLong();
		refMonth = objectInput.readUTF();
		absenceCode = objectInput.readUTF();
		completeDay = objectInput.readUTF();

		from = objectInput.readInt();

		to = objectInput.readInt();

		hours = objectInput.readInt();
		description = objectInput.readUTF();
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
		objectOutput.writeLong(absenceDate);

		if (refMonth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(refMonth);
		}

		if (absenceCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(absenceCode);
		}

		if (completeDay == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(completeDay);
		}

		objectOutput.writeInt(from);

		objectOutput.writeInt(to);

		objectOutput.writeInt(hours);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String custom_key;
	public long personId;
	public long absenceDate;
	public String refMonth;
	public String absenceCode;
	public String completeDay;
	public int from;
	public int to;
	public int hours;
	public String description;
}