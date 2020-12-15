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

import com.intranet.mef.job.siap.exception.NoSuchProfilePictureException;
import com.intranet.mef.job.siap.model.ProfilePicture;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the profile picture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.ProfilePicturePersistenceImpl
 * @see ProfilePictureUtil
 * @generated
 */
@ProviderType
public interface ProfilePicturePersistence extends BasePersistence<ProfilePicture> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfilePictureUtil} to access the profile picture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the profile picture in the entity cache if it is enabled.
	*
	* @param profilePicture the profile picture
	*/
	public void cacheResult(ProfilePicture profilePicture);

	/**
	* Caches the profile pictures in the entity cache if it is enabled.
	*
	* @param profilePictures the profile pictures
	*/
	public void cacheResult(java.util.List<ProfilePicture> profilePictures);

	/**
	* Creates a new profile picture with the primary key. Does not add the profile picture to the database.
	*
	* @param personID the primary key for the new profile picture
	* @return the new profile picture
	*/
	public ProfilePicture create(long personID);

	/**
	* Removes the profile picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture that was removed
	* @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	*/
	public ProfilePicture remove(long personID)
		throws NoSuchProfilePictureException;

	public ProfilePicture updateImpl(ProfilePicture profilePicture);

	/**
	* Returns the profile picture with the primary key or throws a {@link NoSuchProfilePictureException} if it could not be found.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture
	* @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	*/
	public ProfilePicture findByPrimaryKey(long personID)
		throws NoSuchProfilePictureException;

	/**
	* Returns the profile picture with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture, or <code>null</code> if a profile picture with the primary key could not be found
	*/
	public ProfilePicture fetchByPrimaryKey(long personID);

	@Override
	public java.util.Map<java.io.Serializable, ProfilePicture> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the profile pictures.
	*
	* @return the profile pictures
	*/
	public java.util.List<ProfilePicture> findAll();

	/**
	* Returns a range of all the profile pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile pictures
	* @param end the upper bound of the range of profile pictures (not inclusive)
	* @return the range of profile pictures
	*/
	public java.util.List<ProfilePicture> findAll(int start, int end);

	/**
	* Returns an ordered range of all the profile pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile pictures
	* @param end the upper bound of the range of profile pictures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of profile pictures
	*/
	public java.util.List<ProfilePicture> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfilePicture> orderByComparator);

	/**
	* Returns an ordered range of all the profile pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile pictures
	* @param end the upper bound of the range of profile pictures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of profile pictures
	*/
	public java.util.List<ProfilePicture> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfilePicture> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the profile pictures from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of profile pictures.
	*
	* @return the number of profile pictures
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}