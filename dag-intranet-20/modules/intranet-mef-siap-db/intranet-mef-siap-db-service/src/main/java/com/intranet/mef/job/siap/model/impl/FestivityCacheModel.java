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

import com.intranet.mef.job.siap.model.Festivity;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Festivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Festivity
 * @generated
 */
@ProviderType
public class FestivityCacheModel implements CacheModel<Festivity>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FestivityCacheModel)) {
			return false;
		}

		FestivityCacheModel festivityCacheModel = (FestivityCacheModel)obj;

		if (personId == festivityCacheModel.personId) {
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

		sb.append("{personId=");
		sb.append(personId);
		sb.append(", festivityDueCurrYear=");
		sb.append(festivityDueCurrYear);
		sb.append(", festivitySpentCurrYear=");
		sb.append(festivitySpentCurrYear);
		sb.append(", festivityRemainCurrYear=");
		sb.append(festivityRemainCurrYear);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Festivity toEntityModel() {
		FestivityImpl festivityImpl = new FestivityImpl();

		festivityImpl.setPersonId(personId);
		festivityImpl.setFestivityDueCurrYear(festivityDueCurrYear);
		festivityImpl.setFestivitySpentCurrYear(festivitySpentCurrYear);
		festivityImpl.setFestivityRemainCurrYear(festivityRemainCurrYear);

		festivityImpl.resetOriginalValues();

		return festivityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personId = objectInput.readLong();

		festivityDueCurrYear = objectInput.readInt();

		festivitySpentCurrYear = objectInput.readInt();

		festivityRemainCurrYear = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personId);

		objectOutput.writeInt(festivityDueCurrYear);

		objectOutput.writeInt(festivitySpentCurrYear);

		objectOutput.writeInt(festivityRemainCurrYear);
	}

	public long personId;
	public int festivityDueCurrYear;
	public int festivitySpentCurrYear;
	public int festivityRemainCurrYear;
}