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

package com.accenture.istanza.interpello.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.accenture.istanza.interpello.exception.NoSuchRichInterpelloException;
import com.accenture.istanza.interpello.model.RichInterpello;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the rich interpello service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.istanza.interpello.service.persistence.impl.RichInterpelloPersistenceImpl
 * @see RichInterpelloUtil
 * @generated
 */
@ProviderType
public interface RichInterpelloPersistence extends BasePersistence<RichInterpello> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichInterpelloUtil} to access the rich interpello persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rich interpellos where screename = &#63;.
	*
	* @param screename the screename
	* @return the matching rich interpellos
	*/
	public java.util.List<RichInterpello> findByscreename(String screename);

	/**
	* Returns a range of all the rich interpellos where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @return the range of matching rich interpellos
	*/
	public java.util.List<RichInterpello> findByscreename(String screename,
		int start, int end);

	/**
	* Returns an ordered range of all the rich interpellos where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rich interpellos
	*/
	public java.util.List<RichInterpello> findByscreename(String screename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator);

	/**
	* Returns an ordered range of all the rich interpellos where screename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param screename the screename
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rich interpellos
	*/
	public java.util.List<RichInterpello> findByscreename(String screename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich interpello
	* @throws NoSuchRichInterpelloException if a matching rich interpello could not be found
	*/
	public RichInterpello findByscreename_First(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator)
		throws NoSuchRichInterpelloException;

	/**
	* Returns the first rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rich interpello, or <code>null</code> if a matching rich interpello could not be found
	*/
	public RichInterpello fetchByscreename_First(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator);

	/**
	* Returns the last rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich interpello
	* @throws NoSuchRichInterpelloException if a matching rich interpello could not be found
	*/
	public RichInterpello findByscreename_Last(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator)
		throws NoSuchRichInterpelloException;

	/**
	* Returns the last rich interpello in the ordered set where screename = &#63;.
	*
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rich interpello, or <code>null</code> if a matching rich interpello could not be found
	*/
	public RichInterpello fetchByscreename_Last(String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator);

	/**
	* Returns the rich interpellos before and after the current rich interpello in the ordered set where screename = &#63;.
	*
	* @param id the primary key of the current rich interpello
	* @param screename the screename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rich interpello
	* @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	*/
	public RichInterpello[] findByscreename_PrevAndNext(long id,
		String screename,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator)
		throws NoSuchRichInterpelloException;

	/**
	* Removes all the rich interpellos where screename = &#63; from the database.
	*
	* @param screename the screename
	*/
	public void removeByscreename(String screename);

	/**
	* Returns the number of rich interpellos where screename = &#63;.
	*
	* @param screename the screename
	* @return the number of matching rich interpellos
	*/
	public int countByscreename(String screename);

	/**
	* Caches the rich interpello in the entity cache if it is enabled.
	*
	* @param richInterpello the rich interpello
	*/
	public void cacheResult(RichInterpello richInterpello);

	/**
	* Caches the rich interpellos in the entity cache if it is enabled.
	*
	* @param richInterpellos the rich interpellos
	*/
	public void cacheResult(java.util.List<RichInterpello> richInterpellos);

	/**
	* Creates a new rich interpello with the primary key. Does not add the rich interpello to the database.
	*
	* @param id the primary key for the new rich interpello
	* @return the new rich interpello
	*/
	public RichInterpello create(long id);

	/**
	* Removes the rich interpello with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello that was removed
	* @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	*/
	public RichInterpello remove(long id) throws NoSuchRichInterpelloException;

	public RichInterpello updateImpl(RichInterpello richInterpello);

	/**
	* Returns the rich interpello with the primary key or throws a {@link NoSuchRichInterpelloException} if it could not be found.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello
	* @throws NoSuchRichInterpelloException if a rich interpello with the primary key could not be found
	*/
	public RichInterpello findByPrimaryKey(long id)
		throws NoSuchRichInterpelloException;

	/**
	* Returns the rich interpello with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello, or <code>null</code> if a rich interpello with the primary key could not be found
	*/
	public RichInterpello fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, RichInterpello> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the rich interpellos.
	*
	* @return the rich interpellos
	*/
	public java.util.List<RichInterpello> findAll();

	/**
	* Returns a range of all the rich interpellos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @return the range of rich interpellos
	*/
	public java.util.List<RichInterpello> findAll(int start, int end);

	/**
	* Returns an ordered range of all the rich interpellos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rich interpellos
	*/
	public java.util.List<RichInterpello> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator);

	/**
	* Returns an ordered range of all the rich interpellos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of rich interpellos
	*/
	public java.util.List<RichInterpello> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichInterpello> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the rich interpellos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of rich interpellos.
	*
	* @return the number of rich interpellos
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}