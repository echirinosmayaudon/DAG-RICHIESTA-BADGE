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

import com.intranet.mef.job.siap.exception.NoSuchPunchingException;
import com.intranet.mef.job.siap.model.Punching;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the punching service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.PunchingPersistenceImpl
 * @see PunchingUtil
 * @generated
 */
@ProviderType
public interface PunchingPersistence extends BasePersistence<Punching> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PunchingUtil} to access the punching persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the matching punchings
	*/
	public java.util.List<Punching> findByPersonId(long personId);

	/**
	* Returns a range of all the punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @return the range of matching punchings
	*/
	public java.util.List<Punching> findByPersonId(long personId, int start,
		int end);

	/**
	* Returns an ordered range of all the punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching punchings
	*/
	public java.util.List<Punching> findByPersonId(long personId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator);

	/**
	* Returns an ordered range of all the punchings where personId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personId the person ID
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching punchings
	*/
	public java.util.List<Punching> findByPersonId(long personId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching punching
	* @throws NoSuchPunchingException if a matching punching could not be found
	*/
	public Punching findByPersonId_First(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator)
		throws NoSuchPunchingException;

	/**
	* Returns the first punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching punching, or <code>null</code> if a matching punching could not be found
	*/
	public Punching fetchByPersonId_First(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator);

	/**
	* Returns the last punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching punching
	* @throws NoSuchPunchingException if a matching punching could not be found
	*/
	public Punching findByPersonId_Last(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator)
		throws NoSuchPunchingException;

	/**
	* Returns the last punching in the ordered set where personId = &#63;.
	*
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching punching, or <code>null</code> if a matching punching could not be found
	*/
	public Punching fetchByPersonId_Last(long personId,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator);

	/**
	* Returns the punchings before and after the current punching in the ordered set where personId = &#63;.
	*
	* @param custom_key the primary key of the current punching
	* @param personId the person ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next punching
	* @throws NoSuchPunchingException if a punching with the primary key could not be found
	*/
	public Punching[] findByPersonId_PrevAndNext(java.lang.String custom_key,
		long personId,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator)
		throws NoSuchPunchingException;

	/**
	* Removes all the punchings where personId = &#63; from the database.
	*
	* @param personId the person ID
	*/
	public void removeByPersonId(long personId);

	/**
	* Returns the number of punchings where personId = &#63;.
	*
	* @param personId the person ID
	* @return the number of matching punchings
	*/
	public int countByPersonId(long personId);

	/**
	* Caches the punching in the entity cache if it is enabled.
	*
	* @param punching the punching
	*/
	public void cacheResult(Punching punching);

	/**
	* Caches the punchings in the entity cache if it is enabled.
	*
	* @param punchings the punchings
	*/
	public void cacheResult(java.util.List<Punching> punchings);

	/**
	* Creates a new punching with the primary key. Does not add the punching to the database.
	*
	* @param custom_key the primary key for the new punching
	* @return the new punching
	*/
	public Punching create(java.lang.String custom_key);

	/**
	* Removes the punching with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the punching
	* @return the punching that was removed
	* @throws NoSuchPunchingException if a punching with the primary key could not be found
	*/
	public Punching remove(java.lang.String custom_key)
		throws NoSuchPunchingException;

	public Punching updateImpl(Punching punching);

	/**
	* Returns the punching with the primary key or throws a {@link NoSuchPunchingException} if it could not be found.
	*
	* @param custom_key the primary key of the punching
	* @return the punching
	* @throws NoSuchPunchingException if a punching with the primary key could not be found
	*/
	public Punching findByPrimaryKey(java.lang.String custom_key)
		throws NoSuchPunchingException;

	/**
	* Returns the punching with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the punching
	* @return the punching, or <code>null</code> if a punching with the primary key could not be found
	*/
	public Punching fetchByPrimaryKey(java.lang.String custom_key);

	@Override
	public java.util.Map<java.io.Serializable, Punching> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the punchings.
	*
	* @return the punchings
	*/
	public java.util.List<Punching> findAll();

	/**
	* Returns a range of all the punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @return the range of punchings
	*/
	public java.util.List<Punching> findAll(int start, int end);

	/**
	* Returns an ordered range of all the punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of punchings
	*/
	public java.util.List<Punching> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator);

	/**
	* Returns an ordered range of all the punchings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PunchingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of punchings
	* @param end the upper bound of the range of punchings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of punchings
	*/
	public java.util.List<Punching> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Punching> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the punchings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of punchings.
	*
	* @return the number of punchings
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}