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

package com.intranet.mef.central.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.central.exception.NoSuchCentralInvokerException;
import com.intranet.mef.central.model.CentralInvoker;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the central invoker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.central.service.persistence.impl.CentralInvokerPersistenceImpl
 * @see CentralInvokerUtil
 * @generated
 */
@ProviderType
public interface CentralInvokerPersistence extends BasePersistence<CentralInvoker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CentralInvokerUtil} to access the central invoker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the central invokers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching central invokers
	*/
	public java.util.List<CentralInvoker> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the central invokers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @return the range of matching central invokers
	*/
	public java.util.List<CentralInvoker> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the central invokers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching central invokers
	*/
	public java.util.List<CentralInvoker> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator);

	/**
	* Returns an ordered range of all the central invokers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching central invokers
	*/
	public java.util.List<CentralInvoker> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching central invoker
	* @throws NoSuchCentralInvokerException if a matching central invoker could not be found
	*/
	public CentralInvoker findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator)
		throws NoSuchCentralInvokerException;

	/**
	* Returns the first central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching central invoker, or <code>null</code> if a matching central invoker could not be found
	*/
	public CentralInvoker fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator);

	/**
	* Returns the last central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching central invoker
	* @throws NoSuchCentralInvokerException if a matching central invoker could not be found
	*/
	public CentralInvoker findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator)
		throws NoSuchCentralInvokerException;

	/**
	* Returns the last central invoker in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching central invoker, or <code>null</code> if a matching central invoker could not be found
	*/
	public CentralInvoker fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator);

	/**
	* Returns the central invokers before and after the current central invoker in the ordered set where uuid = &#63;.
	*
	* @param idRecord the primary key of the current central invoker
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next central invoker
	* @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	*/
	public CentralInvoker[] findByUuid_PrevAndNext(long idRecord,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator)
		throws NoSuchCentralInvokerException;

	/**
	* Removes all the central invokers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of central invokers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching central invokers
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the central invoker in the entity cache if it is enabled.
	*
	* @param centralInvoker the central invoker
	*/
	public void cacheResult(CentralInvoker centralInvoker);

	/**
	* Caches the central invokers in the entity cache if it is enabled.
	*
	* @param centralInvokers the central invokers
	*/
	public void cacheResult(java.util.List<CentralInvoker> centralInvokers);

	/**
	* Creates a new central invoker with the primary key. Does not add the central invoker to the database.
	*
	* @param idRecord the primary key for the new central invoker
	* @return the new central invoker
	*/
	public CentralInvoker create(long idRecord);

	/**
	* Removes the central invoker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker that was removed
	* @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	*/
	public CentralInvoker remove(long idRecord)
		throws NoSuchCentralInvokerException;

	public CentralInvoker updateImpl(CentralInvoker centralInvoker);

	/**
	* Returns the central invoker with the primary key or throws a {@link NoSuchCentralInvokerException} if it could not be found.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker
	* @throws NoSuchCentralInvokerException if a central invoker with the primary key could not be found
	*/
	public CentralInvoker findByPrimaryKey(long idRecord)
		throws NoSuchCentralInvokerException;

	/**
	* Returns the central invoker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker, or <code>null</code> if a central invoker with the primary key could not be found
	*/
	public CentralInvoker fetchByPrimaryKey(long idRecord);

	@Override
	public java.util.Map<java.io.Serializable, CentralInvoker> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the central invokers.
	*
	* @return the central invokers
	*/
	public java.util.List<CentralInvoker> findAll();

	/**
	* Returns a range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @return the range of central invokers
	*/
	public java.util.List<CentralInvoker> findAll(int start, int end);

	/**
	* Returns an ordered range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of central invokers
	*/
	public java.util.List<CentralInvoker> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator);

	/**
	* Returns an ordered range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of central invokers
	*/
	public java.util.List<CentralInvoker> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CentralInvoker> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the central invokers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of central invokers.
	*
	* @return the number of central invokers
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}