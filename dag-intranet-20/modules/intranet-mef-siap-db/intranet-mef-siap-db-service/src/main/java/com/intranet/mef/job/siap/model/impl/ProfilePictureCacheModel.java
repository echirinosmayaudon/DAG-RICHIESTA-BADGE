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

import com.intranet.mef.job.siap.model.ProfilePicture;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProfilePicture in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProfilePicture
 * @generated
 */
@ProviderType
public class ProfilePictureCacheModel implements CacheModel<ProfilePicture>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProfilePictureCacheModel)) {
			return false;
		}

		ProfilePictureCacheModel profilePictureCacheModel = (ProfilePictureCacheModel)obj;

		if (personID == profilePictureCacheModel.personID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, personID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{personID=");
		sb.append(personID);

		return sb.toString();
	}

	@Override
	public ProfilePicture toEntityModel() {
		ProfilePictureImpl profilePictureImpl = new ProfilePictureImpl();

		profilePictureImpl.setPersonID(personID);

		profilePictureImpl.resetOriginalValues();

		return profilePictureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personID = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personID);
	}

	public long personID;
}