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

package com.accenture.lavoro.agile.istanza.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.exception.NoSuchRichLavAgileException;
import com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the rich lav agile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.RichLavAgilePersistenceImpl
 * @see RichLavAgileUtil
 * @generated
 */
@ProviderType
public interface RichLavAgilePersistence extends BasePersistence<RichLavAgile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichLavAgileUtil} to access the rich lav agile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rich lav agiles where screename = &#63;.
	*
	* @param screename the screename
	* @return the matching rich lav agiles
	*/
	public java.util.List<RichLavAgile> findByscreename(String screename);

	/**
	* Returns a range of all the rich lav agiles where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @return the range of matching rich lav agiles
	*/
	public java.util.List<RichLavAgile> findByscreename(String screename,
		int start, int end);

	/**
	* Returns an ordered range of all the rich lav agiles where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rich lav agiles
	*/
	public java.util.List<RichLavAgile> findByscreename(String screename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator);

	/**
	* Returns an ordered range of all the rich lav agiles where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rich lav agiles
	*/
	public java.util.List<RichLavAgile> findByscreename(String screename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich lav agile
	* @throws NoSuchRichLavAgileException if a matching rich lav agile could not be found
	*/
	public RichLavAgile findByscreename_First(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator)
		throws NoSuchRichLavAgileException;

	/**
	* Returns the first rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich lav agile, or <code>null</code> if a matching rich lav agile could not be found
	*/
	public RichLavAgile fetchByscreename_First(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator);

	/**
	* Returns the last rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich lav agile
	* @throws NoSuchRichLavAgileException if a matching rich lav agile could not be found
	*/
	public RichLavAgile findByscreename_Last(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator)
		throws NoSuchRichLavAgileException;

	/**
	* Returns the last rich lav agile in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich lav agile, or <code>null</code> if a matching rich lav agile could not be found
	*/
	public RichLavAgile fetchByscreename_Last(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator);

	/**
	* Returns the rich lav agiles before and after the current rich lav agile in the ordered set where screename = &#63;.
	*
	* @param id the primary key of the current rich lav agile
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rich lav agile
	* @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	*/
	public RichLavAgile[] findByscreename_PrevAndNext(long id,
		String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator)
		throws NoSuchRichLavAgileException;

	/**
	* Removes all the rich lav agiles where screename = &#63; from the database.
	*
	* @param screename the screename
	*/
	public void removeByscreename(String screename);

	/**
	* Returns the number of rich lav agiles where screename = &#63;.
	*
	* @param screename the screename
	* @return the number of matching rich lav agiles
	*/
	public int countByscreename(String screename);

	/**
	* Caches the rich lav agile in the entity cache if it is enabled.
	*
	* @param richLavAgile the rich lav agile
	*/
	public void cacheResult(RichLavAgile richLavAgile);

	/**
	* Caches the rich lav agiles in the entity cache if it is enabled.
	*
	* @param richLavAgiles the rich lav agiles
	*/
	public void cacheResult(java.util.List<RichLavAgile> richLavAgiles);

	/**
	* Creates a new rich lav agile with the primary key. Does not add the rich lav agile to the database.
	*
	* @param id the primary key for the new rich lav agile
	* @return the new rich lav agile
	*/
	public RichLavAgile create(long id);

	/**
	* Removes the rich lav agile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile that was removed
	* @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	*/
	public RichLavAgile remove(long id) throws NoSuchRichLavAgileException;

	public RichLavAgile updateImpl(RichLavAgile richLavAgile);

	/**
	* Returns the rich lav agile with the primary key or throws a {@link NoSuchRichLavAgileException} if it could not be found.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile
	* @throws NoSuchRichLavAgileException if a rich lav agile with the primary key could not be found
	*/
	public RichLavAgile findByPrimaryKey(long id)
		throws NoSuchRichLavAgileException;

	/**
	* Returns the rich lav agile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile, or <code>null</code> if a rich lav agile with the primary key could not be found
	*/
	public RichLavAgile fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, RichLavAgile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the rich lav agiles.
	*
	* @return the rich lav agiles
	*/
	public java.util.List<RichLavAgile> findAll();

	/**
	* Returns a range of all the rich lav agiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @return the range of rich lav agiles
	*/
	public java.util.List<RichLavAgile> findAll(int start, int end);

	/**
	* Returns an ordered range of all the rich lav agiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rich lav agiles
	*/
	public java.util.List<RichLavAgile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator);

	/**
	* Returns an ordered range of all the rich lav agiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of rich lav agiles
	*/
	public java.util.List<RichLavAgile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichLavAgile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the rich lav agiles from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of rich lav agiles.
	*
	* @return the number of rich lav agiles
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}