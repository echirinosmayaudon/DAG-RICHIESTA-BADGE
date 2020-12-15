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

package servizio.richieste.badge.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.richieste.badge.mef.model.StatoRichiesta;

import java.util.List;

/**
 * The persistence utility for the stato richiesta service. This utility wraps {@link servizio.richieste.badge.mef.service.persistence.impl.StatoRichiestaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichiestaPersistence
 * @see servizio.richieste.badge.mef.service.persistence.impl.StatoRichiestaPersistenceImpl
 * @generated
 */
@ProviderType
public class StatoRichiestaUtil {
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
	public static void clearCache(StatoRichiesta statoRichiesta) {
		getPersistence().clearCache(statoRichiesta);
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
	public static List<StatoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatoRichiesta update(StatoRichiesta statoRichiesta) {
		return getPersistence().update(statoRichiesta);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatoRichiesta update(StatoRichiesta statoRichiesta,
		ServiceContext serviceContext) {
		return getPersistence().update(statoRichiesta, serviceContext);
	}

	/**
	* Returns all the stato richiestas where descrizione_stato = &#63;.
	*
	* @param descrizione_stato the descrizione_stato
	* @return the matching stato richiestas
	*/
	public static List<StatoRichiesta> findBydescrizione(
		java.lang.String descrizione_stato) {
		return getPersistence().findBydescrizione(descrizione_stato);
	}

	/**
	* Returns a range of all the stato richiestas where descrizione_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param descrizione_stato the descrizione_stato
	* @param start the lower bound of the range of stato richiestas
	* @param end the upper bound of the range of stato richiestas (not inclusive)
	* @return the range of matching stato richiestas
	*/
	public static List<StatoRichiesta> findBydescrizione(
		java.lang.String descrizione_stato, int start, int end) {
		return getPersistence().findBydescrizione(descrizione_stato, start, end);
	}

	/**
	* Returns an ordered range of all the stato richiestas where descrizione_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param descrizione_stato the descrizione_stato
	* @param start the lower bound of the range of stato richiestas
	* @param end the upper bound of the range of stato richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stato richiestas
	*/
	public static List<StatoRichiesta> findBydescrizione(
		java.lang.String descrizione_stato, int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		return getPersistence()
				   .findBydescrizione(descrizione_stato, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato richiestas where descrizione_stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param descrizione_stato the descrizione_stato
	* @param start the lower bound of the range of stato richiestas
	* @param end the upper bound of the range of stato richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stato richiestas
	*/
	public static List<StatoRichiesta> findBydescrizione(
		java.lang.String descrizione_stato, int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydescrizione(descrizione_stato, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first stato richiesta in the ordered set where descrizione_stato = &#63;.
	*
	* @param descrizione_stato the descrizione_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato richiesta
	* @throws NoSuchStatoRichiestaException if a matching stato richiesta could not be found
	*/
	public static StatoRichiesta findBydescrizione_First(
		java.lang.String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchStatoRichiestaException {
		return getPersistence()
				   .findBydescrizione_First(descrizione_stato, orderByComparator);
	}

	/**
	* Returns the first stato richiesta in the ordered set where descrizione_stato = &#63;.
	*
	* @param descrizione_stato the descrizione_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato richiesta, or <code>null</code> if a matching stato richiesta could not be found
	*/
	public static StatoRichiesta fetchBydescrizione_First(
		java.lang.String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		return getPersistence()
				   .fetchBydescrizione_First(descrizione_stato,
			orderByComparator);
	}

	/**
	* Returns the last stato richiesta in the ordered set where descrizione_stato = &#63;.
	*
	* @param descrizione_stato the descrizione_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato richiesta
	* @throws NoSuchStatoRichiestaException if a matching stato richiesta could not be found
	*/
	public static StatoRichiesta findBydescrizione_Last(
		java.lang.String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchStatoRichiestaException {
		return getPersistence()
				   .findBydescrizione_Last(descrizione_stato, orderByComparator);
	}

	/**
	* Returns the last stato richiesta in the ordered set where descrizione_stato = &#63;.
	*
	* @param descrizione_stato the descrizione_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato richiesta, or <code>null</code> if a matching stato richiesta could not be found
	*/
	public static StatoRichiesta fetchBydescrizione_Last(
		java.lang.String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		return getPersistence()
				   .fetchBydescrizione_Last(descrizione_stato, orderByComparator);
	}

	/**
	* Returns the stato richiestas before and after the current stato richiesta in the ordered set where descrizione_stato = &#63;.
	*
	* @param id_stato the primary key of the current stato richiesta
	* @param descrizione_stato the descrizione_stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stato richiesta
	* @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	*/
	public static StatoRichiesta[] findBydescrizione_PrevAndNext(
		long id_stato, java.lang.String descrizione_stato,
		OrderByComparator<StatoRichiesta> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchStatoRichiestaException {
		return getPersistence()
				   .findBydescrizione_PrevAndNext(id_stato, descrizione_stato,
			orderByComparator);
	}

	/**
	* Removes all the stato richiestas where descrizione_stato = &#63; from the database.
	*
	* @param descrizione_stato the descrizione_stato
	*/
	public static void removeBydescrizione(java.lang.String descrizione_stato) {
		getPersistence().removeBydescrizione(descrizione_stato);
	}

	/**
	* Returns the number of stato richiestas where descrizione_stato = &#63;.
	*
	* @param descrizione_stato the descrizione_stato
	* @return the number of matching stato richiestas
	*/
	public static int countBydescrizione(java.lang.String descrizione_stato) {
		return getPersistence().countBydescrizione(descrizione_stato);
	}

	/**
	* Caches the stato richiesta in the entity cache if it is enabled.
	*
	* @param statoRichiesta the stato richiesta
	*/
	public static void cacheResult(StatoRichiesta statoRichiesta) {
		getPersistence().cacheResult(statoRichiesta);
	}

	/**
	* Caches the stato richiestas in the entity cache if it is enabled.
	*
	* @param statoRichiestas the stato richiestas
	*/
	public static void cacheResult(List<StatoRichiesta> statoRichiestas) {
		getPersistence().cacheResult(statoRichiestas);
	}

	/**
	* Creates a new stato richiesta with the primary key. Does not add the stato richiesta to the database.
	*
	* @param id_stato the primary key for the new stato richiesta
	* @return the new stato richiesta
	*/
	public static StatoRichiesta create(long id_stato) {
		return getPersistence().create(id_stato);
	}

	/**
	* Removes the stato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato the primary key of the stato richiesta
	* @return the stato richiesta that was removed
	* @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	*/
	public static StatoRichiesta remove(long id_stato)
		throws servizio.richieste.badge.mef.exception.NoSuchStatoRichiestaException {
		return getPersistence().remove(id_stato);
	}

	public static StatoRichiesta updateImpl(StatoRichiesta statoRichiesta) {
		return getPersistence().updateImpl(statoRichiesta);
	}

	/**
	* Returns the stato richiesta with the primary key or throws a {@link NoSuchStatoRichiestaException} if it could not be found.
	*
	* @param id_stato the primary key of the stato richiesta
	* @return the stato richiesta
	* @throws NoSuchStatoRichiestaException if a stato richiesta with the primary key could not be found
	*/
	public static StatoRichiesta findByPrimaryKey(long id_stato)
		throws servizio.richieste.badge.mef.exception.NoSuchStatoRichiestaException {
		return getPersistence().findByPrimaryKey(id_stato);
	}

	/**
	* Returns the stato richiesta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_stato the primary key of the stato richiesta
	* @return the stato richiesta, or <code>null</code> if a stato richiesta with the primary key could not be found
	*/
	public static StatoRichiesta fetchByPrimaryKey(long id_stato) {
		return getPersistence().fetchByPrimaryKey(id_stato);
	}

	public static java.util.Map<java.io.Serializable, StatoRichiesta> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the stato richiestas.
	*
	* @return the stato richiestas
	*/
	public static List<StatoRichiesta> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stato richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato richiestas
	* @param end the upper bound of the range of stato richiestas (not inclusive)
	* @return the range of stato richiestas
	*/
	public static List<StatoRichiesta> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stato richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato richiestas
	* @param end the upper bound of the range of stato richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato richiestas
	*/
	public static List<StatoRichiesta> findAll(int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato richiestas
	* @param end the upper bound of the range of stato richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato richiestas
	*/
	public static List<StatoRichiesta> findAll(int start, int end,
		OrderByComparator<StatoRichiesta> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the stato richiestas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stato richiestas.
	*
	* @return the number of stato richiestas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatoRichiestaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatoRichiestaPersistence, StatoRichiestaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StatoRichiestaPersistence.class);
}