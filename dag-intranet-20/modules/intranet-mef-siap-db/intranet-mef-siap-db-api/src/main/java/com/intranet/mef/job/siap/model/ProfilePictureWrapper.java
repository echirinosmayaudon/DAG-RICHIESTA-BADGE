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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.sql.Blob;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ProfilePicture}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfilePicture
 * @generated
 */
@ProviderType
public class ProfilePictureWrapper implements ProfilePicture,
	ModelWrapper<ProfilePicture> {
	public ProfilePictureWrapper(ProfilePicture profilePicture) {
		_profilePicture = profilePicture;
	}

	@Override
	public Class<?> getModelClass() {
		return ProfilePicture.class;
	}

	@Override
	public String getModelClassName() {
		return ProfilePicture.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personID", getPersonID());
		attributes.put("file", getFile());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personID = (Long)attributes.get("personID");

		if (personID != null) {
			setPersonID(personID);
		}

		Blob file = (Blob)attributes.get("file");

		if (file != null) {
			setFile(file);
		}
	}

	@Override
	public ProfilePicture toEscapedModel() {
		return new ProfilePictureWrapper(_profilePicture.toEscapedModel());
	}

	@Override
	public ProfilePicture toUnescapedModel() {
		return new ProfilePictureWrapper(_profilePicture.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _profilePicture.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _profilePicture.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _profilePicture.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _profilePicture.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProfilePicture> toCacheModel() {
		return _profilePicture.toCacheModel();
	}

	@Override
	public int compareTo(ProfilePicture profilePicture) {
		return _profilePicture.compareTo(profilePicture);
	}

	@Override
	public int hashCode() {
		return _profilePicture.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _profilePicture.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProfilePictureWrapper((ProfilePicture)_profilePicture.clone());
	}

	@Override
	public java.lang.String toString() {
		return _profilePicture.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _profilePicture.toXmlString();
	}

	/**
	* Returns the file of this profile picture.
	*
	* @return the file of this profile picture
	*/
	@Override
	public Blob getFile() {
		return _profilePicture.getFile();
	}

	/**
	* Returns the person i d of this profile picture.
	*
	* @return the person i d of this profile picture
	*/
	@Override
	public long getPersonID() {
		return _profilePicture.getPersonID();
	}

	/**
	* Returns the primary key of this profile picture.
	*
	* @return the primary key of this profile picture
	*/
	@Override
	public long getPrimaryKey() {
		return _profilePicture.getPrimaryKey();
	}

	@Override
	public void persist() {
		_profilePicture.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_profilePicture.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_profilePicture.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_profilePicture.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_profilePicture.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file of this profile picture.
	*
	* @param file the file of this profile picture
	*/
	@Override
	public void setFile(Blob file) {
		_profilePicture.setFile(file);
	}

	@Override
	public void setNew(boolean n) {
		_profilePicture.setNew(n);
	}

	/**
	* Sets the person i d of this profile picture.
	*
	* @param personID the person i d of this profile picture
	*/
	@Override
	public void setPersonID(long personID) {
		_profilePicture.setPersonID(personID);
	}

	/**
	* Sets the primary key of this profile picture.
	*
	* @param primaryKey the primary key of this profile picture
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_profilePicture.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_profilePicture.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProfilePictureWrapper)) {
			return false;
		}

		ProfilePictureWrapper profilePictureWrapper = (ProfilePictureWrapper)obj;

		if (Objects.equals(_profilePicture,
					profilePictureWrapper._profilePicture)) {
			return true;
		}

		return false;
	}

	@Override
	public ProfilePicture getWrappedModel() {
		return _profilePicture;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _profilePicture.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _profilePicture.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_profilePicture.resetOriginalValues();
	}

	private final ProfilePicture _profilePicture;
}