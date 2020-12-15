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
 * Provides the local service utility for MealTicket. This utility wraps
 * {@link com.intranet.mef.job.siap.service.impl.MealTicketLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MealTicketLocalService
 * @see com.intranet.mef.job.siap.service.base.MealTicketLocalServiceBaseImpl
 * @see com.intranet.mef.job.siap.service.impl.MealTicketLocalServiceImpl
 * @generated
 */
@ProviderType
public class MealTicketLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.job.siap.service.impl.MealTicketLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the meal ticket to the database. Also notifies the appropriate model listeners.
	*
	* @param mealTicket the meal ticket
	* @return the meal ticket that was added
	*/
	public static com.intranet.mef.job.siap.model.MealTicket addMealTicket(
		com.intranet.mef.job.siap.model.MealTicket mealTicket) {
		return getService().addMealTicket(mealTicket);
	}

	/**
	* Creates a new meal ticket with the primary key. Does not add the meal ticket to the database.
	*
	* @param custom_key the primary key for the new meal ticket
	* @return the new meal ticket
	*/
	public static com.intranet.mef.job.siap.model.MealTicket createMealTicket(
		java.lang.String custom_key) {
		return getService().createMealTicket(custom_key);
	}

	/**
	* Deletes the meal ticket from the database. Also notifies the appropriate model listeners.
	*
	* @param mealTicket the meal ticket
	* @return the meal ticket that was removed
	*/
	public static com.intranet.mef.job.siap.model.MealTicket deleteMealTicket(
		com.intranet.mef.job.siap.model.MealTicket mealTicket) {
		return getService().deleteMealTicket(mealTicket);
	}

	/**
	* Deletes the meal ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket that was removed
	* @throws PortalException if a meal ticket with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.MealTicket deleteMealTicket(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMealTicket(custom_key);
	}

	public static com.intranet.mef.job.siap.model.MealTicket fetchMealTicket(
		java.lang.String custom_key) {
		return getService().fetchMealTicket(custom_key);
	}

	/**
	* Returns the meal ticket with the primary key.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket
	* @throws PortalException if a meal ticket with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.MealTicket getMealTicket(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMealTicket(custom_key);
	}

	/**
	* Updates the meal ticket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mealTicket the meal ticket
	* @return the meal ticket that was updated
	*/
	public static com.intranet.mef.job.siap.model.MealTicket updateMealTicket(
		com.intranet.mef.job.siap.model.MealTicket mealTicket) {
		return getService().updateMealTicket(mealTicket);
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
	* Returns the number of meal tickets.
	*
	* @return the number of meal tickets
	*/
	public static int getMealTicketsCount() {
		return getService().getMealTicketsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.intranet.mef.job.siap.model.MealTicket> getMealTicketByPersonId(
		long personId) {
		return getService().getMealTicketByPersonId(personId);
	}

	/**
	* Returns a range of all the meal tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @return the range of meal tickets
	*/
	public static java.util.List<com.intranet.mef.job.siap.model.MealTicket> getMealTickets(
		int start, int end) {
		return getService().getMealTickets(start, end);
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

	public static MealTicketLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MealTicketLocalService, MealTicketLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MealTicketLocalService.class);
}