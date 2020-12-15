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

import com.intranet.mef.job.siap.model.ProfilePicture;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the profile picture service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.ProfilePicturePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfilePicturePersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.ProfilePicturePersistenceImpl
 * @generated
 */
@ProviderType
public class ProfilePictureUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProfilePicture profilePicture) {
		getPersistence().clearCache(profilePicture);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfilePicture> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfilePicture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfilePicture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProfilePicture> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProfilePicture update(ProfilePicture profilePicture) {
		return getPersistence().update(profilePicture);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProfilePicture update(ProfilePicture profilePicture,
		ServiceContext serviceContext) {
		return getPersistence().update(profilePicture, serviceContext);
	}

	/**
	* Caches the profile picture in the entity cache if it is enabled.
	*
	* @param profilePicture the profile picture
	*/
	public static void cacheResult(ProfilePicture profilePicture) {
		getPersistence().cacheResult(profilePicture);
	}

	/**
	* Caches the profile pictures in the entity cache if it is enabled.
	*
	* @param profilePictures the profile pictures
	*/
	public static void cacheResult(List<ProfilePicture> profilePictures) {
		getPersistence().cacheResult(profilePictures);
	}

	/**
	* Creates a new profile picture with the primary key. Does not add the profile picture to the database.
	*
	* @param personID the primary key for the new profile picture
	* @return the new profile picture
	*/
	public static ProfilePicture create(long personID) {
		return getPersistence().create(personID);
	}

	/**
	* Removes the profile picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture that was removed
	* @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	*/
	public static ProfilePicture remove(long personID)
		throws com.intranet.mef.job.siap.exception.NoSuchProfilePictureException {
		return getPersistence().remove(personID);
	}

	public static ProfilePicture updateImpl(ProfilePicture profilePicture) {
		return getPersistence().updateImpl(profilePicture);
	}

	/**
	* Returns the profile picture with the primary key or throws a {@link NoSuchProfilePictureException} if it could not be found.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture
	* @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	*/
	public static ProfilePicture findByPrimaryKey(long personID)
		throws com.intranet.mef.job.siap.exception.NoSuchProfilePictureException {
		return getPersistence().findByPrimaryKey(personID);
	}

	/**
	* Returns the profile picture with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personID the primary key of the profile picture
	* @return the profile picture, or <code>null</code> if a profile picture with the primary key could not be found
	*/
	public static ProfilePicture fetchByPrimaryKey(long personID) {
		return getPersistence().fetchByPrimaryKey(personID);
	}

	public static java.util.Map<java.io.Serializable, ProfilePicture> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the profile pictures.
	*
	* @return the profile pictures
	*/
	public static List<ProfilePicture> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProfilePicture> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProfilePicture> findAll(int start, int end,
		OrderByComparator<ProfilePicture> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProfilePicture> findAll(int start, int end,
		OrderByComparator<ProfilePicture> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the profile pictures from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of profile pictures.
	*
	* @return the number of profile pictures
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProfilePicturePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProfilePicturePersistence, ProfilePicturePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ProfilePicturePersistence.class);
}