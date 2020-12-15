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

import com.intranet.mef.job.siap.model.MealTicket;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MealTicket in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MealTicket
 * @generated
 */
@ProviderType
public class MealTicketCacheModel implements CacheModel<MealTicket>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MealTicketCacheModel)) {
			return false;
		}

		MealTicketCacheModel mealTicketCacheModel = (MealTicketCacheModel)obj;

		if (custom_key.equals(mealTicketCacheModel.custom_key)) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{custom_key=");
		sb.append(custom_key);
		sb.append(", personID=");
		sb.append(personID);
		sb.append(", month=");
		sb.append(month);
		sb.append(", dueMeal=");
		sb.append(dueMeal);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MealTicket toEntityModel() {
		MealTicketImpl mealTicketImpl = new MealTicketImpl();

		if (custom_key == null) {
			mealTicketImpl.setCustom_key(StringPool.BLANK);
		}
		else {
			mealTicketImpl.setCustom_key(custom_key);
		}

		mealTicketImpl.setPersonID(personID);

		if (month == null) {
			mealTicketImpl.setMonth(StringPool.BLANK);
		}
		else {
			mealTicketImpl.setMonth(month);
		}

		mealTicketImpl.setDueMeal(dueMeal);

		mealTicketImpl.resetOriginalValues();

		return mealTicketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		custom_key = objectInput.readUTF();

		personID = objectInput.readLong();
		month = objectInput.readUTF();

		dueMeal = objectInput.readInt();
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

		objectOutput.writeLong(personID);

		if (month == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(month);
		}

		objectOutput.writeInt(dueMeal);
	}

	public String custom_key;
	public long personID;
	public String month;
	public int dueMeal;
}