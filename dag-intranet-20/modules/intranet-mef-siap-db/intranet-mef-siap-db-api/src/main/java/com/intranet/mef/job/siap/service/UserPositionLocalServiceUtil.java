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

package com.intranet.mef.job.siap.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserPosition. This utility wraps
 * {@link com.intranet.mef.job.siap.service.impl.UserPositionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserPositionLocalService
 * @see com.intranet.mef.job.siap.service.base.UserPositionLocalServiceBaseImpl
 * @see com.intranet.mef.job.siap.service.impl.UserPositionLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserPositionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.job.siap.service.impl.UserPositionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user position to the database. Also notifies the appropriate model listeners.
	*
	* @param userPosition the user position
	* @return the user position that was added
	*/
	public static com.intranet.mef.job.siap.model.UserPosition addUserPosition(
		com.intranet.mef.job.siap.model.UserPosition userPosition) {
		return getService().addUserPosition(userPosition);
	}

	/**
	* Creates a new user position with the primary key. Does not add the user position to the database.
	*
	* @param pos the primary key for the new user position
	* @return the new user position
	*/
	public static com.intranet.mef.job.siap.model.UserPosition createUserPosition(
		java.lang.String pos) {
		return getService().createUserPosition(pos);
	}

	/**
	* Deletes the user position from the database. Also notifies the appropriate model listeners.
	*
	* @param userPosition the user position
	* @return the user position that was removed
	*/
	public static com.intranet.mef.job.siap.model.UserPosition deleteUserPosition(
		com.intranet.mef.job.siap.model.UserPosition userPosition) {
		return getService().deleteUserPosition(userPosition);
	}

	/**
	* Deletes the user position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pos the primary key of the user position
	* @return the user position that was removed
	* @throws PortalException if a user position with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.UserPosition deleteUserPosition(
		java.lang.String pos)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserPosition(pos);
	}

	public static com.intranet.mef.job.siap.model.UserPosition fetchUserPosition(
		java.lang.String pos) {
		return getService().fetchUserPosition(pos);
	}

	/**
	* Returns the user position with the primary key.
	*
	* @param pos the primary key of the user position
	* @return the user position
	* @throws PortalException if a user position with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.UserPosition getUserPosition(
		java.lang.String pos)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserPosition(pos);
	}

	/**
	* Updates the user position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userPosition the user position
	* @return the user position that was updated
	*/
	public static com.intranet.mef.job.siap.model.UserPosition updateUserPosition(
		com.intranet.mef.job.siap.model.UserPosition userPosition) {
		return getService().updateUserPosition(userPosition);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of user positions.
	*
	* @return the number of user positions
	*/
	public static int getUserPositionsCount() {
		return getService().getUserPositionsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the user positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.UserPositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user positions
	* @param end the upper bound of the range of user positions (not inclusive)
	* @return the range of user positions
	*/
	public static java.util.List<com.intranet.mef.job.siap.model.UserPosition> getUserPositions(
		int start, int end) {
		return getService().getUserPositions(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static UserPositionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserPositionLocalService, UserPositionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserPositionLocalService.class);
}