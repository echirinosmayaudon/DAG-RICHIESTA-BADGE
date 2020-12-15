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

package service.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import service.intranet.mef.model.LogisticaValutazione;

import java.util.List;

/**
 * The persistence utility for the logistica valutazione service. This utility wraps {@link service.intranet.mef.service.persistence.impl.LogisticaValutazionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaValutazionePersistence
 * @see service.intranet.mef.service.persistence.impl.LogisticaValutazionePersistenceImpl
 * @generated
 */
@ProviderType
public class LogisticaValutazioneUtil {
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
	public static void clearCache(LogisticaValutazione logisticaValutazione) {
		getPersistence().clearCache(logisticaValutazione);
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
	public static List<LogisticaValutazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogisticaValutazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogisticaValutazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LogisticaValutazione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LogisticaValutazione update(
		LogisticaValutazione logisticaValutazione) {
		return getPersistence().update(logisticaValutazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LogisticaValutazione update(
		LogisticaValutazione logisticaValutazione, ServiceContext serviceContext) {
		return getPersistence().update(logisticaValutazione, serviceContext);
	}

	/**
	* Caches the logistica valutazione in the entity cache if it is enabled.
	*
	* @param logisticaValutazione the logistica valutazione
	*/
	public static void cacheResult(LogisticaValutazione logisticaValutazione) {
		getPersistence().cacheResult(logisticaValutazione);
	}

	/**
	* Caches the logistica valutaziones in the entity cache if it is enabled.
	*
	* @param logisticaValutaziones the logistica valutaziones
	*/
	public static void cacheResult(
		List<LogisticaValutazione> logisticaValutaziones) {
		getPersistence().cacheResult(logisticaValutaziones);
	}

	/**
	* Creates a new logistica valutazione with the primary key. Does not add the logistica valutazione to the database.
	*
	* @param id the primary key for the new logistica valutazione
	* @return the new logistica valutazione
	*/
	public static LogisticaValutazione create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the logistica valutazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione that was removed
	* @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	*/
	public static LogisticaValutazione remove(long id)
		throws service.intranet.mef.exception.NoSuchLogisticaValutazioneException {
		return getPersistence().remove(id);
	}

	public static LogisticaValutazione updateImpl(
		LogisticaValutazione logisticaValutazione) {
		return getPersistence().updateImpl(logisticaValutazione);
	}

	/**
	* Returns the logistica valutazione with the primary key or throws a {@link NoSuchLogisticaValutazioneException} if it could not be found.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione
	* @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	*/
	public static LogisticaValutazione findByPrimaryKey(long id)
		throws service.intranet.mef.exception.NoSuchLogisticaValutazioneException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the logistica valutazione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione, or <code>null</code> if a logistica valutazione with the primary key could not be found
	*/
	public static LogisticaValutazione fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, LogisticaValutazione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the logistica valutaziones.
	*
	* @return the logistica valutaziones
	*/
	public static List<LogisticaValutazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the logistica valutaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica valutaziones
	* @param end the upper bound of the range of logistica valutaziones (not inclusive)
	* @return the range of logistica valutaziones
	*/
	public static List<LogisticaValutazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the logistica valutaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica valutaziones
	* @param end the upper bound of the range of logistica valutaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of logistica valutaziones
	*/
	public static List<LogisticaValutazione> findAll(int start, int end,
		OrderByComparator<LogisticaValutazione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the logistica valutaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica valutaziones
	* @param end the upper bound of the range of logistica valutaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of logistica valutaziones
	*/
	public static List<LogisticaValutazione> findAll(int start, int end,
		OrderByComparator<LogisticaValutazione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the logistica valutaziones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of logistica valutaziones.
	*
	* @return the number of logistica valutaziones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LogisticaValutazionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LogisticaValutazionePersistence, LogisticaValutazionePersistence> _serviceTracker =
		ServiceTrackerFactory.open(LogisticaValutazionePersistence.class);
}