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

import service.intranet.mef.model.LogisticaStato;

import java.util.List;

/**
 * The persistence utility for the logistica stato service. This utility wraps {@link service.intranet.mef.service.persistence.impl.LogisticaStatoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaStatoPersistence
 * @see service.intranet.mef.service.persistence.impl.LogisticaStatoPersistenceImpl
 * @generated
 */
@ProviderType
public class LogisticaStatoUtil {
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
	public static void clearCache(LogisticaStato logisticaStato) {
		getPersistence().clearCache(logisticaStato);
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
	public static List<LogisticaStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogisticaStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogisticaStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LogisticaStato update(LogisticaStato logisticaStato) {
		return getPersistence().update(logisticaStato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LogisticaStato update(LogisticaStato logisticaStato,
		ServiceContext serviceContext) {
		return getPersistence().update(logisticaStato, serviceContext);
	}

	/**
	* Returns all the logistica statos where utente = &#63;.
	*
	* @param utente the utente
	* @return the matching logistica statos
	*/
	public static List<LogisticaStato> findByUtente(java.lang.String utente) {
		return getPersistence().findByUtente(utente);
	}

	/**
	* Returns a range of all the logistica statos where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @return the range of matching logistica statos
	*/
	public static List<LogisticaStato> findByUtente(java.lang.String utente,
		int start, int end) {
		return getPersistence().findByUtente(utente, start, end);
	}

	/**
	* Returns an ordered range of all the logistica statos where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching logistica statos
	*/
	public static List<LogisticaStato> findByUtente(java.lang.String utente,
		int start, int end, OrderByComparator<LogisticaStato> orderByComparator) {
		return getPersistence()
				   .findByUtente(utente, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the logistica statos where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching logistica statos
	*/
	public static List<LogisticaStato> findByUtente(java.lang.String utente,
		int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUtente(utente, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica stato
	* @throws NoSuchLogisticaStatoException if a matching logistica stato could not be found
	*/
	public static LogisticaStato findByUtente_First(java.lang.String utente,
		OrderByComparator<LogisticaStato> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaStatoException {
		return getPersistence().findByUtente_First(utente, orderByComparator);
	}

	/**
	* Returns the first logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica stato, or <code>null</code> if a matching logistica stato could not be found
	*/
	public static LogisticaStato fetchByUtente_First(java.lang.String utente,
		OrderByComparator<LogisticaStato> orderByComparator) {
		return getPersistence().fetchByUtente_First(utente, orderByComparator);
	}

	/**
	* Returns the last logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica stato
	* @throws NoSuchLogisticaStatoException if a matching logistica stato could not be found
	*/
	public static LogisticaStato findByUtente_Last(java.lang.String utente,
		OrderByComparator<LogisticaStato> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaStatoException {
		return getPersistence().findByUtente_Last(utente, orderByComparator);
	}

	/**
	* Returns the last logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica stato, or <code>null</code> if a matching logistica stato could not be found
	*/
	public static LogisticaStato fetchByUtente_Last(java.lang.String utente,
		OrderByComparator<LogisticaStato> orderByComparator) {
		return getPersistence().fetchByUtente_Last(utente, orderByComparator);
	}

	/**
	* Returns the logistica statos before and after the current logistica stato in the ordered set where utente = &#63;.
	*
	* @param id the primary key of the current logistica stato
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next logistica stato
	* @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	*/
	public static LogisticaStato[] findByUtente_PrevAndNext(long id,
		java.lang.String utente,
		OrderByComparator<LogisticaStato> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaStatoException {
		return getPersistence()
				   .findByUtente_PrevAndNext(id, utente, orderByComparator);
	}

	/**
	* Removes all the logistica statos where utente = &#63; from the database.
	*
	* @param utente the utente
	*/
	public static void removeByUtente(java.lang.String utente) {
		getPersistence().removeByUtente(utente);
	}

	/**
	* Returns the number of logistica statos where utente = &#63;.
	*
	* @param utente the utente
	* @return the number of matching logistica statos
	*/
	public static int countByUtente(java.lang.String utente) {
		return getPersistence().countByUtente(utente);
	}

	/**
	* Caches the logistica stato in the entity cache if it is enabled.
	*
	* @param logisticaStato the logistica stato
	*/
	public static void cacheResult(LogisticaStato logisticaStato) {
		getPersistence().cacheResult(logisticaStato);
	}

	/**
	* Caches the logistica statos in the entity cache if it is enabled.
	*
	* @param logisticaStatos the logistica statos
	*/
	public static void cacheResult(List<LogisticaStato> logisticaStatos) {
		getPersistence().cacheResult(logisticaStatos);
	}

	/**
	* Creates a new logistica stato with the primary key. Does not add the logistica stato to the database.
	*
	* @param id the primary key for the new logistica stato
	* @return the new logistica stato
	*/
	public static LogisticaStato create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the logistica stato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica stato
	* @return the logistica stato that was removed
	* @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	*/
	public static LogisticaStato remove(long id)
		throws service.intranet.mef.exception.NoSuchLogisticaStatoException {
		return getPersistence().remove(id);
	}

	public static LogisticaStato updateImpl(LogisticaStato logisticaStato) {
		return getPersistence().updateImpl(logisticaStato);
	}

	/**
	* Returns the logistica stato with the primary key or throws a {@link NoSuchLogisticaStatoException} if it could not be found.
	*
	* @param id the primary key of the logistica stato
	* @return the logistica stato
	* @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	*/
	public static LogisticaStato findByPrimaryKey(long id)
		throws service.intranet.mef.exception.NoSuchLogisticaStatoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the logistica stato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the logistica stato
	* @return the logistica stato, or <code>null</code> if a logistica stato with the primary key could not be found
	*/
	public static LogisticaStato fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, LogisticaStato> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the logistica statos.
	*
	* @return the logistica statos
	*/
	public static List<LogisticaStato> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the logistica statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @return the range of logistica statos
	*/
	public static List<LogisticaStato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the logistica statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of logistica statos
	*/
	public static List<LogisticaStato> findAll(int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the logistica statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of logistica statos
	*/
	public static List<LogisticaStato> findAll(int start, int end,
		OrderByComparator<LogisticaStato> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the logistica statos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of logistica statos.
	*
	* @return the number of logistica statos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LogisticaStatoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LogisticaStatoPersistence, LogisticaStatoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LogisticaStatoPersistence.class);
}