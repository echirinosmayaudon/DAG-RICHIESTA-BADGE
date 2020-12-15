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

import com.intranet.mef.job.siap.exception.NoSuchPersonalAbsenceException;
import com.intranet.mef.job.siap.model.PersonalAbsence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the personal absence service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.PersonalAbsencePersistenceImpl
 * @see PersonalAbsenceUtil
 * @generated
 */
@ProviderType
public interface PersonalAbsencePersistence extends BasePersistence<PersonalAbsence> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonalAbsenceUtil} to access the personal absence persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the personal absences where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @return the matching personal absences
	*/
	public java.util.List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth);

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
	public java.util.List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth, int start, int end);

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
	public java.util.List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator);

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
	public java.util.List<PersonalAbsence> findByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching personal absence
	* @throws NoSuchPersonalAbsenceException if a matching personal absence could not be found
	*/
	public PersonalAbsence findByPersonIdAndRefMonth_First(long personId,
		java.lang.String refMonth,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator)
		throws NoSuchPersonalAbsenceException;

	/**
	* Returns the first personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching personal absence, or <code>null</code> if a matching personal absence could not be found
	*/
	public PersonalAbsence fetchByPersonIdAndRefMonth_First(long personId,
		java.lang.String refMonth,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator);

	/**
	* Returns the last personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching personal absence
	* @throws NoSuchPersonalAbsenceException if a matching personal absence could not be found
	*/
	public PersonalAbsence findByPersonIdAndRefMonth_Last(long personId,
		java.lang.String refMonth,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator)
		throws NoSuchPersonalAbsenceException;

	/**
	* Returns the last personal absence in the ordered set where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching personal absence, or <code>null</code> if a matching personal absence could not be found
	*/
	public PersonalAbsence fetchByPersonIdAndRefMonth_Last(long personId,
		java.lang.String refMonth,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator);

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
	public PersonalAbsence[] findByPersonIdAndRefMonth_PrevAndNext(
		java.lang.String custom_key, long personId, java.lang.String refMonth,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator)
		throws NoSuchPersonalAbsenceException;

	/**
	* Removes all the personal absences where personId = &#63; and refMonth = &#63; from the database.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	*/
	public void removeByPersonIdAndRefMonth(long personId,
		java.lang.String refMonth);

	/**
	* Returns the number of personal absences where personId = &#63; and refMonth = &#63;.
	*
	* @param personId the person ID
	* @param refMonth the ref month
	* @return the number of matching personal absences
	*/
	public int countByPersonIdAndRefMonth(long personId,
		java.lang.String refMonth);

	/**
	* Caches the personal absence in the entity cache if it is enabled.
	*
	* @param personalAbsence the personal absence
	*/
	public void cacheResult(PersonalAbsence personalAbsence);

	/**
	* Caches the personal absences in the entity cache if it is enabled.
	*
	* @param personalAbsences the personal absences
	*/
	public void cacheResult(java.util.List<PersonalAbsence> personalAbsences);

	/**
	* Creates a new personal absence with the primary key. Does not add the personal absence to the database.
	*
	* @param custom_key the primary key for the new personal absence
	* @return the new personal absence
	*/
	public PersonalAbsence create(java.lang.String custom_key);

	/**
	* Removes the personal absence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence that was removed
	* @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	*/
	public PersonalAbsence remove(java.lang.String custom_key)
		throws NoSuchPersonalAbsenceException;

	public PersonalAbsence updateImpl(PersonalAbsence personalAbsence);

	/**
	* Returns the personal absence with the primary key or throws a {@link NoSuchPersonalAbsenceException} if it could not be found.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence
	* @throws NoSuchPersonalAbsenceException if a personal absence with the primary key could not be found
	*/
	public PersonalAbsence findByPrimaryKey(java.lang.String custom_key)
		throws NoSuchPersonalAbsenceException;

	/**
	* Returns the personal absence with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence, or <code>null</code> if a personal absence with the primary key could not be found
	*/
	public PersonalAbsence fetchByPrimaryKey(java.lang.String custom_key);

	@Override
	public java.util.Map<java.io.Serializable, PersonalAbsence> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the personal absences.
	*
	* @return the personal absences
	*/
	public java.util.List<PersonalAbsence> findAll();

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
	public java.util.List<PersonalAbsence> findAll(int start, int end);

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
	public java.util.List<PersonalAbsence> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator);

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
	public java.util.List<PersonalAbsence> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalAbsence> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the personal absences from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of personal absences.
	*
	* @return the number of personal absences
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}