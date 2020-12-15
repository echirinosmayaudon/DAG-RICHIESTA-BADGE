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

import com.intranet.mef.job.siap.exception.NoSuchManagerOfficesBindException;
import com.intranet.mef.job.siap.model.ManagerOfficesBind;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the manager offices bind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.ManagerOfficesBindPersistenceImpl
 * @see ManagerOfficesBindUtil
 * @generated
 */
@ProviderType
public interface ManagerOfficesBindPersistence extends BasePersistence<ManagerOfficesBind> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ManagerOfficesBindUtil} to access the manager offices bind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the manager offices binds where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @return the matching manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findByPersonId(long personalId);

	/**
	* Returns a range of all the manager offices binds where personalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personalId the personal ID
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @return the range of matching manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findByPersonId(long personalId,
		int start, int end);

	/**
	* Returns an ordered range of all the manager offices binds where personalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personalId the personal ID
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findByPersonId(long personalId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator);

	/**
	* Returns an ordered range of all the manager offices binds where personalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personalId the personal ID
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findByPersonId(long personalId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manager offices bind
	* @throws NoSuchManagerOfficesBindException if a matching manager offices bind could not be found
	*/
	public ManagerOfficesBind findByPersonId_First(long personalId,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws NoSuchManagerOfficesBindException;

	/**
	* Returns the first manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manager offices bind, or <code>null</code> if a matching manager offices bind could not be found
	*/
	public ManagerOfficesBind fetchByPersonId_First(long personalId,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator);

	/**
	* Returns the last manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manager offices bind
	* @throws NoSuchManagerOfficesBindException if a matching manager offices bind could not be found
	*/
	public ManagerOfficesBind findByPersonId_Last(long personalId,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws NoSuchManagerOfficesBindException;

	/**
	* Returns the last manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manager offices bind, or <code>null</code> if a matching manager offices bind could not be found
	*/
	public ManagerOfficesBind fetchByPersonId_Last(long personalId,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator);

	/**
	* Returns the manager offices binds before and after the current manager offices bind in the ordered set where personalId = &#63;.
	*
	* @param managerOfficesBindPK the primary key of the current manager offices bind
	* @param personalId the personal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manager offices bind
	* @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	*/
	public ManagerOfficesBind[] findByPersonId_PrevAndNext(
		ManagerOfficesBindPK managerOfficesBindPK, long personalId,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator)
		throws NoSuchManagerOfficesBindException;

	/**
	* Removes all the manager offices binds where personalId = &#63; from the database.
	*
	* @param personalId the personal ID
	*/
	public void removeByPersonId(long personalId);

	/**
	* Returns the number of manager offices binds where personalId = &#63;.
	*
	* @param personalId the personal ID
	* @return the number of matching manager offices binds
	*/
	public int countByPersonId(long personalId);

	/**
	* Caches the manager offices bind in the entity cache if it is enabled.
	*
	* @param managerOfficesBind the manager offices bind
	*/
	public void cacheResult(ManagerOfficesBind managerOfficesBind);

	/**
	* Caches the manager offices binds in the entity cache if it is enabled.
	*
	* @param managerOfficesBinds the manager offices binds
	*/
	public void cacheResult(
		java.util.List<ManagerOfficesBind> managerOfficesBinds);

	/**
	* Creates a new manager offices bind with the primary key. Does not add the manager offices bind to the database.
	*
	* @param managerOfficesBindPK the primary key for the new manager offices bind
	* @return the new manager offices bind
	*/
	public ManagerOfficesBind create(ManagerOfficesBindPK managerOfficesBindPK);

	/**
	* Removes the manager offices bind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind that was removed
	* @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	*/
	public ManagerOfficesBind remove(ManagerOfficesBindPK managerOfficesBindPK)
		throws NoSuchManagerOfficesBindException;

	public ManagerOfficesBind updateImpl(ManagerOfficesBind managerOfficesBind);

	/**
	* Returns the manager offices bind with the primary key or throws a {@link NoSuchManagerOfficesBindException} if it could not be found.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind
	* @throws NoSuchManagerOfficesBindException if a manager offices bind with the primary key could not be found
	*/
	public ManagerOfficesBind findByPrimaryKey(
		ManagerOfficesBindPK managerOfficesBindPK)
		throws NoSuchManagerOfficesBindException;

	/**
	* Returns the manager offices bind with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param managerOfficesBindPK the primary key of the manager offices bind
	* @return the manager offices bind, or <code>null</code> if a manager offices bind with the primary key could not be found
	*/
	public ManagerOfficesBind fetchByPrimaryKey(
		ManagerOfficesBindPK managerOfficesBindPK);

	@Override
	public java.util.Map<java.io.Serializable, ManagerOfficesBind> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the manager offices binds.
	*
	* @return the manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findAll();

	/**
	* Returns a range of all the manager offices binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @return the range of manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findAll(int start, int end);

	/**
	* Returns an ordered range of all the manager offices binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator);

	/**
	* Returns an ordered range of all the manager offices binds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ManagerOfficesBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of manager offices binds
	* @param end the upper bound of the range of manager offices binds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of manager offices binds
	*/
	public java.util.List<ManagerOfficesBind> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ManagerOfficesBind> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the manager offices binds from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of manager offices binds.
	*
	* @return the number of manager offices binds
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}