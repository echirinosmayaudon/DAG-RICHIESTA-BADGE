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

package servizio.prenotazione.aule.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.prenotazione.aule.mef.exception.NoSuchServizioLogException;
import servizio.prenotazione.aule.mef.model.ServizioLog;

/**
 * The persistence interface for the servizio log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.ServizioLogPersistenceImpl
 * @see ServizioLogUtil
 * @generated
 */
@ProviderType
public interface ServizioLogPersistence extends BasePersistence<ServizioLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServizioLogUtil} to access the servizio log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the servizio logs where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @return the matching servizio logs
	*/
	public java.util.List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio);

	/**
	* Returns a range of all the servizio logs where desc_servizio = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_servizio the desc_servizio
	* @param start the lower bound of the range of servizio logs
	* @param end the upper bound of the range of servizio logs (not inclusive)
	* @return the range of matching servizio logs
	*/
	public java.util.List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio, int start, int end);

	/**
	* Returns an ordered range of all the servizio logs where desc_servizio = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_servizio the desc_servizio
	* @param start the lower bound of the range of servizio logs
	* @param end the upper bound of the range of servizio logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servizio logs
	*/
	public java.util.List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator);

	/**
	* Returns an ordered range of all the servizio logs where desc_servizio = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_servizio the desc_servizio
	* @param start the lower bound of the range of servizio logs
	* @param end the upper bound of the range of servizio logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servizio logs
	*/
	public java.util.List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio log
	* @throws NoSuchServizioLogException if a matching servizio log could not be found
	*/
	public ServizioLog findByDescServizio_First(
		java.lang.String desc_servizio,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator)
		throws NoSuchServizioLogException;

	/**
	* Returns the first servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio log, or <code>null</code> if a matching servizio log could not be found
	*/
	public ServizioLog fetchByDescServizio_First(
		java.lang.String desc_servizio,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator);

	/**
	* Returns the last servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio log
	* @throws NoSuchServizioLogException if a matching servizio log could not be found
	*/
	public ServizioLog findByDescServizio_Last(java.lang.String desc_servizio,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator)
		throws NoSuchServizioLogException;

	/**
	* Returns the last servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio log, or <code>null</code> if a matching servizio log could not be found
	*/
	public ServizioLog fetchByDescServizio_Last(
		java.lang.String desc_servizio,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator);

	/**
	* Returns the servizio logs before and after the current servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param id_servizio the primary key of the current servizio log
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next servizio log
	* @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	*/
	public ServizioLog[] findByDescServizio_PrevAndNext(long id_servizio,
		java.lang.String desc_servizio,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator)
		throws NoSuchServizioLogException;

	/**
	* Removes all the servizio logs where desc_servizio = &#63; from the database.
	*
	* @param desc_servizio the desc_servizio
	*/
	public void removeByDescServizio(java.lang.String desc_servizio);

	/**
	* Returns the number of servizio logs where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @return the number of matching servizio logs
	*/
	public int countByDescServizio(java.lang.String desc_servizio);

	/**
	* Caches the servizio log in the entity cache if it is enabled.
	*
	* @param servizioLog the servizio log
	*/
	public void cacheResult(ServizioLog servizioLog);

	/**
	* Caches the servizio logs in the entity cache if it is enabled.
	*
	* @param servizioLogs the servizio logs
	*/
	public void cacheResult(java.util.List<ServizioLog> servizioLogs);

	/**
	* Creates a new servizio log with the primary key. Does not add the servizio log to the database.
	*
	* @param id_servizio the primary key for the new servizio log
	* @return the new servizio log
	*/
	public ServizioLog create(long id_servizio);

	/**
	* Removes the servizio log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log that was removed
	* @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	*/
	public ServizioLog remove(long id_servizio)
		throws NoSuchServizioLogException;

	public ServizioLog updateImpl(ServizioLog servizioLog);

	/**
	* Returns the servizio log with the primary key or throws a {@link NoSuchServizioLogException} if it could not be found.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log
	* @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	*/
	public ServizioLog findByPrimaryKey(long id_servizio)
		throws NoSuchServizioLogException;

	/**
	* Returns the servizio log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log, or <code>null</code> if a servizio log with the primary key could not be found
	*/
	public ServizioLog fetchByPrimaryKey(long id_servizio);

	@Override
	public java.util.Map<java.io.Serializable, ServizioLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the servizio logs.
	*
	* @return the servizio logs
	*/
	public java.util.List<ServizioLog> findAll();

	/**
	* Returns a range of all the servizio logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio logs
	* @param end the upper bound of the range of servizio logs (not inclusive)
	* @return the range of servizio logs
	*/
	public java.util.List<ServizioLog> findAll(int start, int end);

	/**
	* Returns an ordered range of all the servizio logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio logs
	* @param end the upper bound of the range of servizio logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of servizio logs
	*/
	public java.util.List<ServizioLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator);

	/**
	* Returns an ordered range of all the servizio logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio logs
	* @param end the upper bound of the range of servizio logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of servizio logs
	*/
	public java.util.List<ServizioLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the servizio logs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of servizio logs.
	*
	* @return the number of servizio logs
	*/
	public int countAll();
}