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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the file column in ProfilePicture.
 *
 * @author Brian Wing Shun Chan
 * @see ProfilePicture
 * @generated
 */
@ProviderType
public class ProfilePictureFileBlobModel {
	public ProfilePictureFileBlobModel() {
	}

	public ProfilePictureFileBlobModel(long personID) {
		_personID = personID;
	}

	public ProfilePictureFileBlobModel(long personID, Blob fileBlob) {
		_personID = personID;
		_fileBlob = fileBlob;
	}

	public long getPersonID() {
		return _personID;
	}

	public void setPersonID(long personID) {
		_personID = personID;
	}

	public Blob getFileBlob() {
		return _fileBlob;
	}

	public void setFileBlob(Blob fileBlob) {
		_fileBlob = fileBlob;
	}

	private long _personID;
	private Blob _fileBlob;
}