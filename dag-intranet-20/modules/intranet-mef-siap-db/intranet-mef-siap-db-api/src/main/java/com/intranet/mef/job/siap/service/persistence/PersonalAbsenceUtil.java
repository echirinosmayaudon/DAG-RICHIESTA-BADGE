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

import com.intranet.mef.job.siap.model.PersonalAbsence;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the personal absence service. This utility wraps {@link com.intranet.mef.job.siap.service.persistence.impl.PersonalAbsencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsencePersistence
 * @see com.intranet.mef.job.siap.service.persistence.impl.PersonalAbsencePersistenceImpl
 * @generated
 */
@ProviderType
public class PersonalAbsenceUtil {
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
	public static void clearCache(PersonalAbsence personalAbsence) {
		getPersistence().clearCache(personalAbsence);
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
	public static List<PersonalAbsence> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersonalAbsence> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersonalAbsence> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersonalAbsence update(PersonalAbsence personalAbsence) {
		return getPersistence().update(personalAbsence);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersonalAbsence update(PersonalAbsence personalAbsence,
		ServiceContext serviceContext) {
		return getPersistence().update(personalAbsence, serviceContext);
	}

	/**
	* Returns all the personal absences where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @return the matching personal absences
	*/
	public static List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth) {
		return getPersistence().findByPersonIdAndRefMonth(personId, refMonth);
	}

	/**
	* Returns a range of all the personal absences where personId = &#63; and refMonth = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @return the range of matching personal absences
	*/
	public static List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth, int start, int end) {
		return getPersistence()
				   .findByPersonIdAndRefMonth(personId, refMonth, start, end);
	}

	/**
	* Returns an ordered range of all the personal absences where personId = &#63; and refMonth = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching personal absences
	*/
	public static List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth, int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator) {
		return getPersistence()
				   .findByPersonIdAndRefMonth(personId, refMonth, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the personal absences where personId = &#63; and refMonth = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching personal absences
	*/
	public static List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth, int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPersonIdAndRefMonth(personId, refMonth, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching personal absence
	* @throws NoSuchPersonalAbsenceException if a matching personal absence could not be found
	*/
	public static PersonalAbsence findByPersonIdAndRefMonth_First(
		long personId, java.lang.String refMonth,
		OrderByComparator<PersonalAbsence> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchPersonalAbsenceException {
		return getPersistence()
				   .findByPersonIdAndRefMonth_First(personId, refMonth,
			orderByComparator);
	}

	/**
	* Returns the first personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching personal absence, or <code>null</code> if a matching personal absence could not be found
	*/
	public static PersonalAbsence fetchByPersonIdAndRefMonth_First(
		long personId, java.lang.String refMonth,
		OrderByComparator<PersonalAbsence> orderByComparator) {
		return getPersistence()
				   .fetchByPersonIdAndRefMonth_First(personId, refMonth,
			orderByComparator);
	}

	/**
	* Returns the last personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching personal absence
	* @throws NoSuchPersonalAbsenceException if a matching personal absence could not be found
	*/
	public static PersonalAbsence findByPersonIdAndRefMonth_Last(
		long personId, java.lang.String refMonth,
		OrderByComparator<PersonalAbsence> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchPersonalAbsenceException {
		return getPersistence()
				   .findByPersonIdAndRefMonth_Last(personId, refMonth,
			orderByComparator);
	}

	/**
	* Returns the last personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching personal absence, or <code>null</code> if a matching personal absence could not be found
	*/
	public static PersonalAbsence fetchByPersonIdAndRefMonth_Last(
		long personId, java.lang.String refMonth,
		OrderByComparator<PersonalAbsence> orderByComparator) {
		return getPersistence()
				   .fetchByPersonIdAndRefMonth_Last(personId, refMonth,
			orderByComparator);
	}

	/**
	* Returns the personal absences before and after the current personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param custom_key the primary key of the current personal absence
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next personal absence
	* @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	*/
	public static PersonalAbsence[] findByPersonIdAndRefMonth_PrevAndNext(
		java.lang.String custom_key, long personId, java.lang.String refMonth,
		OrderByComparator<PersonalAbsence> orderByComparator)
		throws com.intranet.mef.job.siap.exception.NoSuchPersonalAbsenceException {
		return getPersistence()
				   .findByPersonIdAndRefMonth_PrevAndNext(custom_key, personId,
			refMonth, orderByComparator);
	}

	/**
	* Removes all the personal absences where personId = &#63; and refMonth = &#63; from the database.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	*/
	public static void removeByPersonIdAndRefMonth(long personId,
		java.lang.String refMonth) {
		getPersistence().removeByPersonIdAndRefMonth(personId, refMonth);
	}

	/**
	* Returns the number of personal absences where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @return the number of matching personal absences
	*/
	public static int countByPersonIdAndRefMonth(long personId,
		java.lang.String refMonth) {
		return getPersistence().countByPersonIdAndRefMonth(personId, refMonth);
	}

	/**
	* Caches the personal absence in the entity cache if it is enabled.
	*
	* @param personalAbsence the personal absence
	*/
	public static void cacheResult(PersonalAbsence personalAbsence) {
		getPersistence().cacheResult(personalAbsence);
	}

	/**
	* Caches the personal absences in the entity cache if it is enabled.
	*
	* @param personalAbsences the personal absences
	*/
	public static void cacheResult(List<PersonalAbsence> personalAbsences) {
		getPersistence().cacheResult(personalAbsences);
	}

	/**
	* Creates a new personal absence with the primary key. Does not add the personal absence to the database.
	*
	* @param custom_key the primary key for the new personal absence
	* @return the new personal absence
	*/
	public static PersonalAbsence create(java.lang.String custom_key) {
		return getPersistence().create(custom_key);
	}

	/**
	* Removes the personal absence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence that was removed
	* @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	*/
	public static PersonalAbsence remove(java.lang.String custom_key)
		throws com.intranet.mef.job.siap.exception.NoSuchPersonalAbsenceException {
		return getPersistence().remove(custom_key);
	}

	public static PersonalAbsence updateImpl(PersonalAbsence personalAbsence) {
		return getPersistence().updateImpl(personalAbsence);
	}

	/**
	* Returns the personal absence with the primary key or throws a {@link NoSuchPersonalAbsenceException} if it could not be found.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence
	* @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	*/
	public static PersonalAbsence findByPrimaryKey(java.lang.String custom_key)
		throws com.intranet.mef.job.siap.exception.NoSuchPersonalAbsenceException {
		return getPersistence().findByPrimaryKey(custom_key);
	}

	/**
	* Returns the personal absence with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence, or <code>null</code> if a personal absence with the primary key could not be found
	*/
	public static PersonalAbsence fetchByPrimaryKey(java.lang.String custom_key) {
		return getPersistence().fetchByPrimaryKey(custom_key);
	}

	public static java.util.Map<java.io.Serializable, PersonalAbsence> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the personal absences.
	*
	* @return the personal absences
	*/
	public static List<PersonalAbsence> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the personal absences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @return the range of personal absences
	*/
	public static List<PersonalAbsence> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the personal absences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of personal absences
	*/
	public static List<PersonalAbsence> findAll(int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the personal absences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of personal absences
	*/
	public static List<PersonalAbsence> findAll(int start, int end,
		OrderByComparator<PersonalAbsence> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the personal absences from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of personal absences.
	*
	* @return the number of personal absences
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PersonalAbsencePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersonalAbsencePersistence, PersonalAbsencePersistence> _serviceTracker =
		ServiceTrackerFactory.open(PersonalAbsencePersistence.class);
}