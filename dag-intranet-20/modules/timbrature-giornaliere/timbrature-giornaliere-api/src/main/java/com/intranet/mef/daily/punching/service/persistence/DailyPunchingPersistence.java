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

package com.intranet.mef.daily.punching.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.daily.punching.exception.NoSuchDailyPunchingException;
import com.intranet.mef.daily.punching.model.DailyPunching;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the daily punching service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.daily.punching.service.persistence.impl.DailyPunchingPersistenceImpl
 * @see DailyPunchingUtil
 * @generated
 */
@ProviderType
public interface DailyPunchingPersistence extends BasePersistence<DailyPunching> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DailyPunchingUtil} to access the daily punching persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the daily punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the matching daily punchings
	*/
	public java.util.List<DailyPunching> findByPersonId(long personId);

	/**
	* Returns a range of all the daily punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @return the range of matching daily punchings
	*/
	public java.util.List<DailyPunching> findByPersonId(long personId,
		int start, int end);

	/**
	* Returns an ordered range of all the daily punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching daily punchings
	*/
	public java.util.List<DailyPunching> findByPersonId(long personId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator);

	/**
	* Returns an ordered range of all the daily punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching daily punchings
	*/
	public java.util.List<DailyPunching> findByPersonId(long personId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching daily punching
	* @throws NoSuchDailyPunchingException if a matching daily punching could not be found
	*/
	public DailyPunching findByPersonId_First(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator)
		throws NoSuchDailyPunchingException;

	/**
	* Returns the first daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching daily punching, or <code>null</code> if a matching daily punching could not be found
	*/
	public DailyPunching fetchByPersonId_First(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator);

	/**
	* Returns the last daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching daily punching
	* @throws NoSuchDailyPunchingException if a matching daily punching could not be found
	*/
	public DailyPunching findByPersonId_Last(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator)
		throws NoSuchDailyPunchingException;

	/**
	* Returns the last daily punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching daily punching, or <code>null</code> if a matching daily punching could not be found
	*/
	public DailyPunching fetchByPersonId_Last(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator);

	/**
	* Returns the daily punchings before and after the current daily punching in the ordered set where personId = &#63;.
	*
	* @param custom_key the primary key of the current daily punching
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next daily punching
	* @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	*/
	public DailyPunching[] findByPersonId_PrevAndNext(
		java.lang.String custom_key, long personId,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator)
		throws NoSuchDailyPunchingException;

	/**
	* Removes all the daily punchings where personId = &#63; from the database.
	*
	* @param personId the person ID
	*/
	public void removeByPersonId(long personId);

	/**
	* Returns the number of daily punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the number of matching daily punchings
	*/
	public int countByPersonId(long personId);

	/**
	* Caches the daily punching in the entity cache if it is enabled.
	*
	* @param dailyPunching the daily punching
	*/
	public void cacheResult(DailyPunching dailyPunching);

	/**
	* Caches the daily punchings in the entity cache if it is enabled.
	*
	* @param dailyPunchings the daily punchings
	*/
	public void cacheResult(java.util.List<DailyPunching> dailyPunchings);

	/**
	* Creates a new daily punching with the primary key. Does not add the daily punching to the database.
	*
	* @param custom_key the primary key for the new daily punching
	* @return the new daily punching
	*/
	public DailyPunching create(java.lang.String custom_key);

	/**
	* Removes the daily punching with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching that was removed
	* @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	*/
	public DailyPunching remove(java.lang.String custom_key)
		throws NoSuchDailyPunchingException;

	public DailyPunching updateImpl(DailyPunching dailyPunching);

	/**
	* Returns the daily punching with the primary key or throws a {@link NoSuchDailyPunchingException} if it could not be found.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching
	* @throws NoSuchDailyPunchingException if a daily punching with the primary key could not be found
	*/
	public DailyPunching findByPrimaryKey(java.lang.String custom_key)
		throws NoSuchDailyPunchingException;

	/**
	* Returns the daily punching with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the daily punching
	* @return the daily punching, or <code>null</code> if a daily punching with the primary key could not be found
	*/
	public DailyPunching fetchByPrimaryKey(java.lang.String custom_key);

	@Override
	public java.util.Map<java.io.Serializable, DailyPunching> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the daily punchings.
	*
	* @return the daily punchings
	*/
	public java.util.List<DailyPunching> findAll();

	/**
	* Returns a range of all the daily punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @return the range of daily punchings
	*/
	public java.util.List<DailyPunching> findAll(int start, int end);

	/**
	* Returns an ordered range of all the daily punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of daily punchings
	*/
	public java.util.List<DailyPunching> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator);

	/**
	* Returns an ordered range of all the daily punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DailyPunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of daily punchings
	* @param end the upper bound of the range of daily punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of daily punchings
	*/
	public java.util.List<DailyPunching> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DailyPunching> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the daily punchings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of daily punchings.
	*
	* @return the number of daily punchings
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}