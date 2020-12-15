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

import com.intranet.mef.job.siap.model.Vacation;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Vacation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Vacation
 * @generated
 */
@ProviderType
public class VacationCacheModel implements CacheModel<Vacation>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacationCacheModel)) {
			return false;
		}

		VacationCacheModel vacationCacheModel = (VacationCacheModel)obj;

		if (personId == vacationCacheModel.personId) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{personId=");
		sb.append(personId);
		sb.append(", vacationCurrYear=");
		sb.append(vacationCurrYear);
		sb.append(", vacationPrevYear=");
		sb.append(vacationPrevYear);
		sb.append(", vacationSpent=");
		sb.append(vacationSpent);
		sb.append(", vacationRemaining=");
		sb.append(vacationRemaining);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vacation toEntityModel() {
		VacationImpl vacationImpl = new VacationImpl();

		vacationImpl.setPersonId(personId);
		vacationImpl.setVacationCurrYear(vacationCurrYear);
		vacationImpl.setVacationPrevYear(vacationPrevYear);
		vacationImpl.setVacationSpent(vacationSpent);
		vacationImpl.setVacationRemaining(vacationRemaining);

		vacationImpl.resetOriginalValues();

		return vacationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personId = objectInput.readLong();

		vacationCurrYear = objectInput.readInt();

		vacationPrevYear = objectInput.readInt();

		vacationSpent = objectInput.readInt();

		vacationRemaining = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personId);

		objectOutput.writeInt(vacationCurrYear);

		objectOutput.writeInt(vacationPrevYear);

		objectOutput.writeInt(vacationSpent);

		objectOutput.writeInt(vacationRemaining);
	}

	public long personId;
	public int vacationCurrYear;
	public int vacationPrevYear;
	public int vacationSpent;
	public int vacationRemaining;
}