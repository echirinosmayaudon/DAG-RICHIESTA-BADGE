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

package servizio.prenotazione.aule.servizi.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.prenotazione.aule.servizi.mef.exception.NoSuchServLogException;
import servizio.prenotazione.aule.servizi.mef.model.ServLog;

/**
 * The persistence interface for the serv log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.impl.ServLogPersistenceImpl
 * @see ServLogUtil
 * @generated
 */
@ProviderType
public interface ServLogPersistence extends BasePersistence<ServLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServLogUtil} to access the serv log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the serv log in the entity cache if it is enabled.
	*
	* @param servLog the serv log
	*/
	public void cacheResult(ServLog servLog);

	/**
	* Caches the serv logs in the entity cache if it is enabled.
	*
	* @param servLogs the serv logs
	*/
	public void cacheResult(java.util.List<ServLog> servLogs);

	/**
	* Creates a new serv log with the primary key. Does not add the serv log to the database.
	*
	* @param servLogPK the primary key for the new serv log
	* @return the new serv log
	*/
	public ServLog create(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK);

	/**
	* Removes the serv log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param servLogPK the primary key of the serv log
	* @return the serv log that was removed
	* @throws NoSuchServLogException if a serv log with the primary key could not be found
	*/
	public ServLog remove(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK)
		throws NoSuchServLogException;

	public ServLog updateImpl(ServLog servLog);

	/**
	* Returns the serv log with the primary key or throws a {@link NoSuchServLogException} if it could not be found.
	*
	* @param servLogPK the primary key of the serv log
	* @return the serv log
	* @throws NoSuchServLogException if a serv log with the primary key could not be found
	*/
	public ServLog findByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK)
		throws NoSuchServLogException;

	/**
	* Returns the serv log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param servLogPK the primary key of the serv log
	* @return the serv log, or <code>null</code> if a serv log with the primary key could not be found
	*/
	public ServLog fetchByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK);

	@Override
	public java.util.Map<java.io.Serializable, ServLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the serv logs.
	*
	* @return the serv logs
	*/
	public java.util.List<ServLog> findAll();

	/**
	* Returns a range of all the serv logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of serv logs
	* @param end the upper bound of the range of serv logs (not inclusive)
	* @return the range of serv logs
	*/
	public java.util.List<ServLog> findAll(int start, int end);

	/**
	* Returns an ordered range of all the serv logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of serv logs
	* @param end the upper bound of the range of serv logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of serv logs
	*/
	public java.util.List<ServLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServLog> orderByComparator);

	/**
	* Returns an ordered range of all the serv logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of serv logs
	* @param end the upper bound of the range of serv logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of serv logs
	*/
	public java.util.List<ServLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the serv logs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of serv logs.
	*
	* @return the number of serv logs
	*/
	public int countAll();
}