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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.servizi.mef.model.ServLog;

import java.util.List;

/**
 * The persistence utility for the serv log service. This utility wraps {@link servizio.prenotazione.aule.servizi.mef.service.persistence.impl.ServLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServLogPersistence
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.impl.ServLogPersistenceImpl
 * @generated
 */
@ProviderType
public class ServLogUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ServLog servLog) {
		getPersistence().clearCache(servLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServLog> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServLog> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServLog update(ServLog servLog) {
		return getPersistence().update(servLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServLog update(ServLog servLog, ServiceContext serviceContext) {
		return getPersistence().update(servLog, serviceContext);
	}

	/**
	* Caches the serv log in the entity cache if it is enabled.
	*
	* @param servLog the serv log
	*/
	public static void cacheResult(ServLog servLog) {
		getPersistence().cacheResult(servLog);
	}

	/**
	* Caches the serv logs in the entity cache if it is enabled.
	*
	* @param servLogs the serv logs
	*/
	public static void cacheResult(List<ServLog> servLogs) {
		getPersistence().cacheResult(servLogs);
	}

	/**
	* Creates a new serv log with the primary key. Does not add the serv log to the database.
	*
	* @param servLogPK the primary key for the new serv log
	* @return the new serv log
	*/
	public static ServLog create(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK) {
		return getPersistence().create(servLogPK);
	}

	/**
	* Removes the serv log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param servLogPK the primary key of the serv log
	* @return the serv log that was removed
	* @throws NoSuchServLogException if a serv log with the primary key could not be found
	*/
	public static ServLog remove(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK)
		throws servizio.prenotazione.aule.servizi.mef.exception.NoSuchServLogException {
		return getPersistence().remove(servLogPK);
	}

	public static ServLog updateImpl(ServLog servLog) {
		return getPersistence().updateImpl(servLog);
	}

	/**
	* Returns the serv log with the primary key or throws a {@link NoSuchServLogException} if it could not be found.
	*
	* @param servLogPK the primary key of the serv log
	* @return the serv log
	* @throws NoSuchServLogException if a serv log with the primary key could not be found
	*/
	public static ServLog findByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK)
		throws servizio.prenotazione.aule.servizi.mef.exception.NoSuchServLogException {
		return getPersistence().findByPrimaryKey(servLogPK);
	}

	/**
	* Returns the serv log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param servLogPK the primary key of the serv log
	* @return the serv log, or <code>null</code> if a serv log with the primary key could not be found
	*/
	public static ServLog fetchByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK servLogPK) {
		return getPersistence().fetchByPrimaryKey(servLogPK);
	}

	public static java.util.Map<java.io.Serializable, ServLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the serv logs.
	*
	* @return the serv logs
	*/
	public static List<ServLog> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ServLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ServLog> findAll(int start, int end,
		OrderByComparator<ServLog> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ServLog> findAll(int start, int end,
		OrderByComparator<ServLog> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the serv logs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of serv logs.
	*
	* @return the number of serv logs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServLogPersistence, ServLogPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ServLogPersistence.class);
}