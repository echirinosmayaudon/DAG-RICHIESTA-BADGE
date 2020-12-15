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
 * Provides the local service utility for CurrentBalanceHours. This utility wraps
 * {@link com.intranet.mef.job.siap.service.impl.CurrentBalanceHoursLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CurrentBalanceHoursLocalService
 * @see com.intranet.mef.job.siap.service.base.CurrentBalanceHoursLocalServiceBaseImpl
 * @see com.intranet.mef.job.siap.service.impl.CurrentBalanceHoursLocalServiceImpl
 * @generated
 */
@ProviderType
public class CurrentBalanceHoursLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.job.siap.service.impl.CurrentBalanceHoursLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the current balance hours to the database. Also notifies the appropriate model listeners.
	*
	* @param currentBalanceHours the current balance hours
	* @return the current balance hours that was added
	*/
	public static com.intranet.mef.job.siap.model.CurrentBalanceHours addCurrentBalanceHours(
		com.intranet.mef.job.siap.model.CurrentBalanceHours currentBalanceHours) {
		return getService().addCurrentBalanceHours(currentBalanceHours);
	}

	/**
	* Creates a new current balance hours with the primary key. Does not add the current balance hours to the database.
	*
	* @param personId the primary key for the new current balance hours
	* @return the new current balance hours
	*/
	public static com.intranet.mef.job.siap.model.CurrentBalanceHours createCurrentBalanceHours(
		long personId) {
		return getService().createCurrentBalanceHours(personId);
	}

	/**
	* Deletes the current balance hours from the database. Also notifies the appropriate model listeners.
	*
	* @param currentBalanceHours the current balance hours
	* @return the current balance hours that was removed
	*/
	public static com.intranet.mef.job.siap.model.CurrentBalanceHours deleteCurrentBalanceHours(
		com.intranet.mef.job.siap.model.CurrentBalanceHours currentBalanceHours) {
		return getService().deleteCurrentBalanceHours(currentBalanceHours);
	}

	/**
	* Deletes the current balance hours with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the current balance hours
	* @return the current balance hours that was removed
	* @throws PortalException if a current balance hours with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.CurrentBalanceHours deleteCurrentBalanceHours(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCurrentBalanceHours(personId);
	}

	public static com.intranet.mef.job.siap.model.CurrentBalanceHours fetchCurrentBalanceHours(
		long personId) {
		return getService().fetchCurrentBalanceHours(personId);
	}

	/**
	* Returns the current balance hours with the primary key.
	*
	* @param personId the primary key of the current balance hours
	* @return the current balance hours
	* @throws PortalException if a current balance hours with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.CurrentBalanceHours getCurrentBalanceHours(
		long personId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCurrentBalanceHours(personId);
	}

	/**
	* Updates the current balance hours in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param currentBalanceHours the current balance hours
	* @return the current balance hours that was updated
	*/
	public static com.intranet.mef.job.siap.model.CurrentBalanceHours updateCurrentBalanceHours(
		com.intranet.mef.job.siap.model.CurrentBalanceHours currentBalanceHours) {
		return getService().updateCurrentBalanceHours(currentBalanceHours);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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
	* Returns the number of current balance hourses.
	*
	* @return the number of current balance hourses
	*/
	public static int getCurrentBalanceHoursesCount() {
		return getService().getCurrentBalanceHoursesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the current balance hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.CurrentBalanceHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of current balance hourses
	* @param end the upper bound of the range of current balance hourses (not inclusive)
	* @return the range of current balance hourses
	*/
	public static java.util.List<com.intranet.mef.job.siap.model.CurrentBalanceHours> getCurrentBalanceHourses(
		int start, int end) {
		return getService().getCurrentBalanceHourses(start, end);
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

	public static CurrentBalanceHoursLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CurrentBalanceHoursLocalService, CurrentBalanceHoursLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CurrentBalanceHoursLocalService.class);
}