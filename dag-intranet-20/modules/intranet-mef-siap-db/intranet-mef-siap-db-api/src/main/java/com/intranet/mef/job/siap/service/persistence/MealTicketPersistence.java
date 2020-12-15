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

import com.intranet.mef.job.siap.exception.NoSuchMealTicketException;
import com.intranet.mef.job.siap.model.MealTicket;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the meal ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.MealTicketPersistenceImpl
 * @see MealTicketUtil
 * @generated
 */
@ProviderType
public interface MealTicketPersistence extends BasePersistence<MealTicket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MealTicketUtil} to access the meal ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the meal tickets where personID = &#63;.
	*
	* @param personID the person i d
	* @return the matching meal tickets
	*/
	public java.util.List<MealTicket> findByPersonId(long personID);

	/**
	* Returns a range of all the meal tickets where personID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @return the range of matching meal tickets
	*/
	public java.util.List<MealTicket> findByPersonId(long personID, int start,
		int end);

	/**
	* Returns an ordered range of all the meal tickets where personID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching meal tickets
	*/
	public java.util.List<MealTicket> findByPersonId(long personID, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator);

	/**
	* Returns an ordered range of all the meal tickets where personID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching meal tickets
	*/
	public java.util.List<MealTicket> findByPersonId(long personID, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching meal ticket
	* @throws NoSuchMealTicketException if a matching meal ticket could not be found
	*/
	public MealTicket findByPersonId_First(long personID,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator)
		throws NoSuchMealTicketException;

	/**
	* Returns the first meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching meal ticket, or <code>null</code> if a matching meal ticket could not be found
	*/
	public MealTicket fetchByPersonId_First(long personID,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator);

	/**
	* Returns the last meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching meal ticket
	* @throws NoSuchMealTicketException if a matching meal ticket could not be found
	*/
	public MealTicket findByPersonId_Last(long personID,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator)
		throws NoSuchMealTicketException;

	/**
	* Returns the last meal ticket in the ordered set where personID = &#63;.
	*
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching meal ticket, or <code>null</code> if a matching meal ticket could not be found
	*/
	public MealTicket fetchByPersonId_Last(long personID,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator);

	/**
	* Returns the meal tickets before and after the current meal ticket in the ordered set where personID = &#63;.
	*
	* @param custom_key the primary key of the current meal ticket
	* @param personID the person i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next meal ticket
	* @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	*/
	public MealTicket[] findByPersonId_PrevAndNext(
		java.lang.String custom_key, long personID,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator)
		throws NoSuchMealTicketException;

	/**
	* Removes all the meal tickets where personID = &#63; from the database.
	*
	* @param personID the person i d
	*/
	public void removeByPersonId(long personID);

	/**
	* Returns the number of meal tickets where personID = &#63;.
	*
	* @param personID the person i d
	* @return the number of matching meal tickets
	*/
	public int countByPersonId(long personID);

	/**
	* Caches the meal ticket in the entity cache if it is enabled.
	*
	* @param mealTicket the meal ticket
	*/
	public void cacheResult(MealTicket mealTicket);

	/**
	* Caches the meal tickets in the entity cache if it is enabled.
	*
	* @param mealTickets the meal tickets
	*/
	public void cacheResult(java.util.List<MealTicket> mealTickets);

	/**
	* Creates a new meal ticket with the primary key. Does not add the meal ticket to the database.
	*
	* @param custom_key the primary key for the new meal ticket
	* @return the new meal ticket
	*/
	public MealTicket create(java.lang.String custom_key);

	/**
	* Removes the meal ticket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket that was removed
	* @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	*/
	public MealTicket remove(java.lang.String custom_key)
		throws NoSuchMealTicketException;

	public MealTicket updateImpl(MealTicket mealTicket);

	/**
	* Returns the meal ticket with the primary key or throws a {@link NoSuchMealTicketException} if it could not be found.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket
	* @throws NoSuchMealTicketException if a meal ticket with the primary key could not be found
	*/
	public MealTicket findByPrimaryKey(java.lang.String custom_key)
		throws NoSuchMealTicketException;

	/**
	* Returns the meal ticket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the meal ticket
	* @return the meal ticket, or <code>null</code> if a meal ticket with the primary key could not be found
	*/
	public MealTicket fetchByPrimaryKey(java.lang.String custom_key);

	@Override
	public java.util.Map<java.io.Serializable, MealTicket> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the meal tickets.
	*
	* @return the meal tickets
	*/
	public java.util.List<MealTicket> findAll();

	/**
	* Returns a range of all the meal tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @return the range of meal tickets
	*/
	public java.util.List<MealTicket> findAll(int start, int end);

	/**
	* Returns an ordered range of all the meal tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of meal tickets
	*/
	public java.util.List<MealTicket> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator);

	/**
	* Returns an ordered range of all the meal tickets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MealTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of meal tickets
	* @param end the upper bound of the range of meal tickets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of meal tickets
	*/
	public java.util.List<MealTicket> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MealTicket> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the meal tickets from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of meal tickets.
	*
	* @return the number of meal tickets
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}