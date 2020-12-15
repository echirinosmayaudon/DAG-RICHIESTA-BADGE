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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.mef.model.ServizioLog;

import java.util.List;

/**
 * The persistence utility for the servizio log service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.ServizioLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLogPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.ServizioLogPersistenceImpl
 * @generated
 */
@ProviderType
public class ServizioLogUtil {
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
	public static void clearCache(ServizioLog servizioLog) {
		getPersistence().clearCache(servizioLog);
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
	public static List<ServizioLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServizioLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServizioLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServizioLog> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServizioLog update(ServizioLog servizioLog) {
		return getPersistence().update(servizioLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServizioLog update(ServizioLog servizioLog,
		ServiceContext serviceContext) {
		return getPersistence().update(servizioLog, serviceContext);
	}

	/**
	* Returns all the servizio logs where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @return the matching servizio logs
	*/
	public static List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio) {
		return getPersistence().findByDescServizio(desc_servizio);
	}

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
	public static List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio, int start, int end) {
		return getPersistence().findByDescServizio(desc_servizio, start, end);
	}

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
	public static List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio, int start, int end,
		OrderByComparator<ServizioLog> orderByComparator) {
		return getPersistence()
				   .findByDescServizio(desc_servizio, start, end,
			orderByComparator);
	}

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
	public static List<ServizioLog> findByDescServizio(
		java.lang.String desc_servizio, int start, int end,
		OrderByComparator<ServizioLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDescServizio(desc_servizio, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio log
	* @throws NoSuchServizioLogException if a matching servizio log could not be found
	*/
	public static ServizioLog findByDescServizio_First(
		java.lang.String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchServizioLogException {
		return getPersistence()
				   .findByDescServizio_First(desc_servizio, orderByComparator);
	}

	/**
	* Returns the first servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio log, or <code>null</code> if a matching servizio log could not be found
	*/
	public static ServizioLog fetchByDescServizio_First(
		java.lang.String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator) {
		return getPersistence()
				   .fetchByDescServizio_First(desc_servizio, orderByComparator);
	}

	/**
	* Returns the last servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio log
	* @throws NoSuchServizioLogException if a matching servizio log could not be found
	*/
	public static ServizioLog findByDescServizio_Last(
		java.lang.String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchServizioLogException {
		return getPersistence()
				   .findByDescServizio_Last(desc_servizio, orderByComparator);
	}

	/**
	* Returns the last servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio log, or <code>null</code> if a matching servizio log could not be found
	*/
	public static ServizioLog fetchByDescServizio_Last(
		java.lang.String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator) {
		return getPersistence()
				   .fetchByDescServizio_Last(desc_servizio, orderByComparator);
	}

	/**
	* Returns the servizio logs before and after the current servizio log in the ordered set where desc_servizio = &#63;.
	*
	* @param id_servizio the primary key of the current servizio log
	* @param desc_servizio the desc_servizio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next servizio log
	* @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	*/
	public static ServizioLog[] findByDescServizio_PrevAndNext(
		long id_servizio, java.lang.String desc_servizio,
		OrderByComparator<ServizioLog> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchServizioLogException {
		return getPersistence()
				   .findByDescServizio_PrevAndNext(id_servizio, desc_servizio,
			orderByComparator);
	}

	/**
	* Removes all the servizio logs where desc_servizio = &#63; from the database.
	*
	* @param desc_servizio the desc_servizio
	*/
	public static void removeByDescServizio(java.lang.String desc_servizio) {
		getPersistence().removeByDescServizio(desc_servizio);
	}

	/**
	* Returns the number of servizio logs where desc_servizio = &#63;.
	*
	* @param desc_servizio the desc_servizio
	* @return the number of matching servizio logs
	*/
	public static int countByDescServizio(java.lang.String desc_servizio) {
		return getPersistence().countByDescServizio(desc_servizio);
	}

	/**
	* Caches the servizio log in the entity cache if it is enabled.
	*
	* @param servizioLog the servizio log
	*/
	public static void cacheResult(ServizioLog servizioLog) {
		getPersistence().cacheResult(servizioLog);
	}

	/**
	* Caches the servizio logs in the entity cache if it is enabled.
	*
	* @param servizioLogs the servizio logs
	*/
	public static void cacheResult(List<ServizioLog> servizioLogs) {
		getPersistence().cacheResult(servizioLogs);
	}

	/**
	* Creates a new servizio log with the primary key. Does not add the servizio log to the database.
	*
	* @param id_servizio the primary key for the new servizio log
	* @return the new servizio log
	*/
	public static ServizioLog create(long id_servizio) {
		return getPersistence().create(id_servizio);
	}

	/**
	* Removes the servizio log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log that was removed
	* @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	*/
	public static ServizioLog remove(long id_servizio)
		throws servizio.prenotazione.aule.mef.exception.NoSuchServizioLogException {
		return getPersistence().remove(id_servizio);
	}

	public static ServizioLog updateImpl(ServizioLog servizioLog) {
		return getPersistence().updateImpl(servizioLog);
	}

	/**
	* Returns the servizio log with the primary key or throws a {@link NoSuchServizioLogException} if it could not be found.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log
	* @throws NoSuchServizioLogException if a servizio log with the primary key could not be found
	*/
	public static ServizioLog findByPrimaryKey(long id_servizio)
		throws servizio.prenotazione.aule.mef.exception.NoSuchServizioLogException {
		return getPersistence().findByPrimaryKey(id_servizio);
	}

	/**
	* Returns the servizio log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log, or <code>null</code> if a servizio log with the primary key could not be found
	*/
	public static ServizioLog fetchByPrimaryKey(long id_servizio) {
		return getPersistence().fetchByPrimaryKey(id_servizio);
	}

	public static java.util.Map<java.io.Serializable, ServizioLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the servizio logs.
	*
	* @return the servizio logs
	*/
	public static List<ServizioLog> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ServizioLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ServizioLog> findAll(int start, int end,
		OrderByComparator<ServizioLog> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ServizioLog> findAll(int start, int end,
		OrderByComparator<ServizioLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the servizio logs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of servizio logs.
	*
	* @return the number of servizio logs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServizioLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServizioLogPersistence, ServizioLogPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ServizioLogPersistence.class);
}