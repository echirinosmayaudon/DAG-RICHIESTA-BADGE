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
 * Provides the local service utility for PersonalAbsence. This utility wraps
 * {@link com.intranet.mef.job.siap.service.impl.PersonalAbsenceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsenceLocalService
 * @see com.intranet.mef.job.siap.service.base.PersonalAbsenceLocalServiceBaseImpl
 * @see com.intranet.mef.job.siap.service.impl.PersonalAbsenceLocalServiceImpl
 * @generated
 */
@ProviderType
public class PersonalAbsenceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.job.siap.service.impl.PersonalAbsenceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the personal absence to the database. Also notifies the appropriate model listeners.
	*
	* @param personalAbsence the personal absence
	* @return the personal absence that was added
	*/
	public static com.intranet.mef.job.siap.model.PersonalAbsence addPersonalAbsence(
		com.intranet.mef.job.siap.model.PersonalAbsence personalAbsence) {
		return getService().addPersonalAbsence(personalAbsence);
	}

	/**
	* Creates a new personal absence with the primary key. Does not add the personal absence to the database.
	*
	* @param custom_key the primary key for the new personal absence
	* @return the new personal absence
	*/
	public static com.intranet.mef.job.siap.model.PersonalAbsence createPersonalAbsence(
		java.lang.String custom_key) {
		return getService().createPersonalAbsence(custom_key);
	}

	/**
	* Deletes the personal absence from the database. Also notifies the appropriate model listeners.
	*
	* @param personalAbsence the personal absence
	* @return the personal absence that was removed
	*/
	public static com.intranet.mef.job.siap.model.PersonalAbsence deletePersonalAbsence(
		com.intranet.mef.job.siap.model.PersonalAbsence personalAbsence) {
		return getService().deletePersonalAbsence(personalAbsence);
	}

	/**
	* Deletes the personal absence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence that was removed
	* @throws PortalException if a personal absence with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.PersonalAbsence deletePersonalAbsence(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersonalAbsence(custom_key);
	}

	public static com.intranet.mef.job.siap.model.PersonalAbsence fetchPersonalAbsence(
		java.lang.String custom_key) {
		return getService().fetchPersonalAbsence(custom_key);
	}

	/**
	* Returns the personal absence with the primary key.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence
	* @throws PortalException if a personal absence with the primary key could not be found
	*/
	public static com.intranet.mef.job.siap.model.PersonalAbsence getPersonalAbsence(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersonalAbsence(custom_key);
	}

	/**
	* Updates the personal absence in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param personalAbsence the personal absence
	* @return the personal absence that was updated
	*/
	public static com.intranet.mef.job.siap.model.PersonalAbsence updatePersonalAbsence(
		com.intranet.mef.job.siap.model.PersonalAbsence personalAbsence) {
		return getService().updatePersonalAbsence(personalAbsence);
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
	* Returns the number of personal absences.
	*
	* @return the number of personal absences
	*/
	public static int getPersonalAbsencesCount() {
		return getService().getPersonalAbsencesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.intranet.mef.job.siap.model.PersonalAbsence> getByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth) {
		return getService().getByPersonIdAndRefMonth(personId, refMonth);
	}

	/**
	* Returns a range of all the personal absences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @return the range of personal absences
	*/
	public static java.util.List<com.intranet.mef.job.siap.model.PersonalAbsence> getPersonalAbsences(
		int start, int end) {
		return getService().getPersonalAbsences(start, end);
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

	public static PersonalAbsenceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersonalAbsenceLocalService, PersonalAbsenceLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PersonalAbsenceLocalService.class);
}