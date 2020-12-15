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

package com.intranet.mef.job.siap.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PersonalAbsencePK implements Comparable<PersonalAbsencePK>,
	Serializable {
	public long personId;
	public Date absenceDate;

	public PersonalAbsencePK() {
	}

	public PersonalAbsencePK(long personId, Date absenceDate) {
		this.personId = personId;
		this.absenceDate = absenceDate;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public Date getAbsenceDate() {
		return absenceDate;
	}

	public void setAbsenceDate(Date absenceDate) {
		this.absenceDate = absenceDate;
	}

	@Override
	public int compareTo(PersonalAbsencePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (personId < pk.personId) {
			value = -1;
		}
		else if (personId > pk.personId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(absenceDate, pk.absenceDate);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonalAbsencePK)) {
			return false;
		}

		PersonalAbsencePK pk = (PersonalAbsencePK)obj;

		if ((personId == pk.personId) && (absenceDate.equals(pk.absenceDate))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, personId);
		hashCode = HashUtil.hash(hashCode, absenceDate);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("personId");
		sb.append(StringPool.EQUAL);
		sb.append(personId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("absenceDate");
		sb.append(StringPool.EQUAL);
		sb.append(absenceDate);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}