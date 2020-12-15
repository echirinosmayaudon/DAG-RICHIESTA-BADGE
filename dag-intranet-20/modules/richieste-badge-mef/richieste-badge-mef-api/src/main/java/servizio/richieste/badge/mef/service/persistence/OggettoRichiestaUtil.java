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

import servizio.richieste.badge.mef.model.OggettoRichiesta;

import java.util.List;

/**
 * The persistence utility for the oggetto richiesta service. This utility wraps {@link servizio.richieste.badge.mef.service.persistence.impl.OggettoRichiestaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OggettoRichiestaPersistence
 * @see servizio.richieste.badge.mef.service.persistence.impl.OggettoRichiestaPersistenceImpl
 * @generated
 */
@ProviderType
public class OggettoRichiestaUtil {
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
	public static void clearCache(OggettoRichiesta oggettoRichiesta) {
		getPersistence().clearCache(oggettoRichiesta);
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
	public static List<OggettoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OggettoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OggettoRichiesta> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OggettoRichiesta> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OggettoRichiesta update(OggettoRichiesta oggettoRichiesta) {
		return getPersistence().update(oggettoRichiesta);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OggettoRichiesta update(OggettoRichiesta oggettoRichiesta,
		ServiceContext serviceContext) {
		return getPersistence().update(oggettoRichiesta, serviceContext);
	}

	/**
	* Caches the oggetto richiesta in the entity cache if it is enabled.
	*
	* @param oggettoRichiesta the oggetto richiesta
	*/
	public static void cacheResult(OggettoRichiesta oggettoRichiesta) {
		getPersistence().cacheResult(oggettoRichiesta);
	}

	/**
	* Caches the oggetto richiestas in the entity cache if it is enabled.
	*
	* @param oggettoRichiestas the oggetto richiestas
	*/
	public static void cacheResult(List<OggettoRichiesta> oggettoRichiestas) {
		getPersistence().cacheResult(oggettoRichiestas);
	}

	/**
	* Creates a new oggetto richiesta with the primary key. Does not add the oggetto richiesta to the database.
	*
	* @param id_oggetto the primary key for the new oggetto richiesta
	* @return the new oggetto richiesta
	*/
	public static OggettoRichiesta create(long id_oggetto) {
		return getPersistence().create(id_oggetto);
	}

	/**
	* Removes the oggetto richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta that was removed
	* @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	*/
	public static OggettoRichiesta remove(long id_oggetto)
		throws servizio.richieste.badge.mef.exception.NoSuchOggettoRichiestaException {
		return getPersistence().remove(id_oggetto);
	}

	public static OggettoRichiesta updateImpl(OggettoRichiesta oggettoRichiesta) {
		return getPersistence().updateImpl(oggettoRichiesta);
	}

	/**
	* Returns the oggetto richiesta with the primary key or throws a {@link NoSuchOggettoRichiestaException} if it could not be found.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta
	* @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	*/
	public static OggettoRichiesta findByPrimaryKey(long id_oggetto)
		throws servizio.richieste.badge.mef.exception.NoSuchOggettoRichiestaException {
		return getPersistence().findByPrimaryKey(id_oggetto);
	}

	/**
	* Returns the oggetto richiesta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta, or <code>null</code> if a oggetto richiesta with the primary key could not be found
	*/
	public static OggettoRichiesta fetchByPrimaryKey(long id_oggetto) {
		return getPersistence().fetchByPrimaryKey(id_oggetto);
	}

	public static java.util.Map<java.io.Serializable, OggettoRichiesta> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the oggetto richiestas.
	*
	* @return the oggetto richiestas
	*/
	public static List<OggettoRichiesta> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @return the range of oggetto richiestas
	*/
	public static List<OggettoRichiesta> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of oggetto richiestas
	*/
	public static List<OggettoRichiesta> findAll(int start, int end,
		OrderByComparator<OggettoRichiesta> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of oggetto richiestas
	*/
	public static List<OggettoRichiesta> findAll(int start, int end,
		OrderByComparator<OggettoRichiesta> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the oggetto richiestas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of oggetto richiestas.
	*
	* @return the number of oggetto richiestas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OggettoRichiestaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OggettoRichiestaPersistence, OggettoRichiestaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(OggettoRichiestaPersistence.class);
}