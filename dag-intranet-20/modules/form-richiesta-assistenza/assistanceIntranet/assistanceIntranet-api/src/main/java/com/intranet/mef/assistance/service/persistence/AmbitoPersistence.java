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

package com.intranet.mef.assistance.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.exception.NoSuchAmbitoException;
import com.intranet.mef.assistance.model.Ambito;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the ambito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.assistance.service.persistence.impl.AmbitoPersistenceImpl
 * @see AmbitoUtil
 * @generated
 */
@ProviderType
public interface AmbitoPersistence extends BasePersistence<Ambito> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmbitoUtil} to access the ambito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ambitos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching ambitos
	*/
	public java.util.List<Ambito> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the ambitos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @return the range of matching ambitos
	*/
	public java.util.List<Ambito> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the ambitos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ambitos
	*/
	public java.util.List<Ambito> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator);

	/**
	* Returns an ordered range of all the ambitos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ambitos
	*/
	public java.util.List<Ambito> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ambito
	* @throws NoSuchAmbitoException if a matching ambito could not be found
	*/
	public Ambito findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator)
		throws NoSuchAmbitoException;

	/**
	* Returns the first ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ambito, or <code>null</code> if a matching ambito could not be found
	*/
	public Ambito fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator);

	/**
	* Returns the last ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ambito
	* @throws NoSuchAmbitoException if a matching ambito could not be found
	*/
	public Ambito findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator)
		throws NoSuchAmbitoException;

	/**
	* Returns the last ambito in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ambito, or <code>null</code> if a matching ambito could not be found
	*/
	public Ambito fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator);

	/**
	* Returns the ambitos before and after the current ambito in the ordered set where uuid = &#63;.
	*
	* @param assScopeId the primary key of the current ambito
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ambito
	* @throws NoSuchAmbitoException if a ambito with the primary key could not be found
	*/
	public Ambito[] findByUuid_PrevAndNext(java.lang.String assScopeId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator)
		throws NoSuchAmbitoException;

	/**
	* Removes all the ambitos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of ambitos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching ambitos
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the ambito in the entity cache if it is enabled.
	*
	* @param ambito the ambito
	*/
	public void cacheResult(Ambito ambito);

	/**
	* Caches the ambitos in the entity cache if it is enabled.
	*
	* @param ambitos the ambitos
	*/
	public void cacheResult(java.util.List<Ambito> ambitos);

	/**
	* Creates a new ambito with the primary key. Does not add the ambito to the database.
	*
	* @param assScopeId the primary key for the new ambito
	* @return the new ambito
	*/
	public Ambito create(java.lang.String assScopeId);

	/**
	* Removes the ambito with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assScopeId the primary key of the ambito
	* @return the ambito that was removed
	* @throws NoSuchAmbitoException if a ambito with the primary key could not be found
	*/
	public Ambito remove(java.lang.String assScopeId)
		throws NoSuchAmbitoException;

	public Ambito updateImpl(Ambito ambito);

	/**
	* Returns the ambito with the primary key or throws a {@link NoSuchAmbitoException} if it could not be found.
	*
	* @param assScopeId the primary key of the ambito
	* @return the ambito
	* @throws NoSuchAmbitoException if a ambito with the primary key could not be found
	*/
	public Ambito findByPrimaryKey(java.lang.String assScopeId)
		throws NoSuchAmbitoException;

	/**
	* Returns the ambito with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assScopeId the primary key of the ambito
	* @return the ambito, or <code>null</code> if a ambito with the primary key could not be found
	*/
	public Ambito fetchByPrimaryKey(java.lang.String assScopeId);

	@Override
	public java.util.Map<java.io.Serializable, Ambito> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ambitos.
	*
	* @return the ambitos
	*/
	public java.util.List<Ambito> findAll();

	/**
	* Returns a range of all the ambitos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @return the range of ambitos
	*/
	public java.util.List<Ambito> findAll(int start, int end);

	/**
	* Returns an ordered range of all the ambitos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ambitos
	*/
	public java.util.List<Ambito> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator);

	/**
	* Returns an ordered range of all the ambitos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmbitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ambitos
	* @param end the upper bound of the range of ambitos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ambitos
	*/
	public java.util.List<Ambito> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambito> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ambitos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ambitos.
	*
	* @return the number of ambitos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}