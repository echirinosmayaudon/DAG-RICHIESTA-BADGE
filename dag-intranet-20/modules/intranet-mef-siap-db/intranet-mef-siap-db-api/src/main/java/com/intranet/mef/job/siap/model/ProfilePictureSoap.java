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

package com.intranet.mef.job.siap.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.ProfilePictureServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.ProfilePictureServiceSoap
 * @generated
 */
@ProviderType
public class ProfilePictureSoap implements Serializable {
	public static ProfilePictureSoap toSoapModel(ProfilePicture model) {
		ProfilePictureSoap soapModel = new ProfilePictureSoap();

		soapModel.setPersonID(model.getPersonID());
		soapModel.setFile(model.getFile());

		return soapModel;
	}

	public static ProfilePictureSoap[] toSoapModels(ProfilePicture[] models) {
		ProfilePictureSoap[] soapModels = new ProfilePictureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfilePictureSoap[][] toSoapModels(ProfilePicture[][] models) {
		ProfilePictureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProfilePictureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfilePictureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfilePictureSoap[] toSoapModels(List<ProfilePicture> models) {
		List<ProfilePictureSoap> soapModels = new ArrayList<ProfilePictureSoap>(models.size());

		for (ProfilePicture model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProfilePictureSoap[soapModels.size()]);
	}

	public ProfilePictureSoap() {
	}

	public long getPrimaryKey() {
		return _personID;
	}

	public void setPrimaryKey(long pk) {
		setPersonID(pk);
	}

	public long getPersonID() {
		return _personID;
	}

	public void setPersonID(long personID) {
		_personID = personID;
	}

	public Blob getFile() {
		return _file;
	}

	public void setFile(Blob file) {
		_file = file;
	}

	private long _personID;
	private Blob _file;
}