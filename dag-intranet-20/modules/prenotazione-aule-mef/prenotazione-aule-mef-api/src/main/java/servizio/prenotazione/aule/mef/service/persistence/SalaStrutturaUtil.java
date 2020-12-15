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

import servizio.prenotazione.aule.mef.model.SalaStruttura;

import java.util.List;

/**
 * The persistence utility for the sala struttura service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.SalaStrutturaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaStrutturaPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.SalaStrutturaPersistenceImpl
 * @generated
 */
@ProviderType
public class SalaStrutturaUtil {
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
	public static void clearCache(SalaStruttura salaStruttura) {
		getPersistence().clearCache(salaStruttura);
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
	public static List<SalaStruttura> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalaStruttura> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalaStruttura> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SalaStruttura> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SalaStruttura update(SalaStruttura salaStruttura) {
		return getPersistence().update(salaStruttura);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SalaStruttura update(SalaStruttura salaStruttura,
		ServiceContext serviceContext) {
		return getPersistence().update(salaStruttura, serviceContext);
	}

	/**
	* Returns all the sala strutturas where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @return the matching sala strutturas
	*/
	public static List<SalaStruttura> findByIdStruttura(long id_struttura) {
		return getPersistence().findByIdStruttura(id_struttura);
	}

	/**
	* Returns a range of all the sala strutturas where id_struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_struttura the id_struttura
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @return the range of matching sala strutturas
	*/
	public static List<SalaStruttura> findByIdStruttura(long id_struttura,
		int start, int end) {
		return getPersistence().findByIdStruttura(id_struttura, start, end);
	}

	/**
	* Returns an ordered range of all the sala strutturas where id_struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_struttura the id_struttura
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sala strutturas
	*/
	public static List<SalaStruttura> findByIdStruttura(long id_struttura,
		int start, int end, OrderByComparator<SalaStruttura> orderByComparator) {
		return getPersistence()
				   .findByIdStruttura(id_struttura, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the sala strutturas where id_struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_struttura the id_struttura
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sala strutturas
	*/
	public static List<SalaStruttura> findByIdStruttura(long id_struttura,
		int start, int end, OrderByComparator<SalaStruttura> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdStruttura(id_struttura, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sala struttura
	* @throws NoSuchSalaStrutturaException if a matching sala struttura could not be found
	*/
	public static SalaStruttura findByIdStruttura_First(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchSalaStrutturaException {
		return getPersistence()
				   .findByIdStruttura_First(id_struttura, orderByComparator);
	}

	/**
	* Returns the first sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sala struttura, or <code>null</code> if a matching sala struttura could not be found
	*/
	public static SalaStruttura fetchByIdStruttura_First(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator) {
		return getPersistence()
				   .fetchByIdStruttura_First(id_struttura, orderByComparator);
	}

	/**
	* Returns the last sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sala struttura
	* @throws NoSuchSalaStrutturaException if a matching sala struttura could not be found
	*/
	public static SalaStruttura findByIdStruttura_Last(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchSalaStrutturaException {
		return getPersistence()
				   .findByIdStruttura_Last(id_struttura, orderByComparator);
	}

	/**
	* Returns the last sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sala struttura, or <code>null</code> if a matching sala struttura could not be found
	*/
	public static SalaStruttura fetchByIdStruttura_Last(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator) {
		return getPersistence()
				   .fetchByIdStruttura_Last(id_struttura, orderByComparator);
	}

	/**
	* Returns the sala strutturas before and after the current sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id the primary key of the current sala struttura
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sala struttura
	* @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	*/
	public static SalaStruttura[] findByIdStruttura_PrevAndNext(long id,
		long id_struttura, OrderByComparator<SalaStruttura> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchSalaStrutturaException {
		return getPersistence()
				   .findByIdStruttura_PrevAndNext(id, id_struttura,
			orderByComparator);
	}

	/**
	* Removes all the sala strutturas where id_struttura = &#63; from the database.
	*
	* @param id_struttura the id_struttura
	*/
	public static void removeByIdStruttura(long id_struttura) {
		getPersistence().removeByIdStruttura(id_struttura);
	}

	/**
	* Returns the number of sala strutturas where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @return the number of matching sala strutturas
	*/
	public static int countByIdStruttura(long id_struttura) {
		return getPersistence().countByIdStruttura(id_struttura);
	}

	/**
	* Caches the sala struttura in the entity cache if it is enabled.
	*
	* @param salaStruttura the sala struttura
	*/
	public static void cacheResult(SalaStruttura salaStruttura) {
		getPersistence().cacheResult(salaStruttura);
	}

	/**
	* Caches the sala strutturas in the entity cache if it is enabled.
	*
	* @param salaStrutturas the sala strutturas
	*/
	public static void cacheResult(List<SalaStruttura> salaStrutturas) {
		getPersistence().cacheResult(salaStrutturas);
	}

	/**
	* Creates a new sala struttura with the primary key. Does not add the sala struttura to the database.
	*
	* @param id the primary key for the new sala struttura
	* @return the new sala struttura
	*/
	public static SalaStruttura create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the sala struttura with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura that was removed
	* @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	*/
	public static SalaStruttura remove(long id)
		throws servizio.prenotazione.aule.mef.exception.NoSuchSalaStrutturaException {
		return getPersistence().remove(id);
	}

	public static SalaStruttura updateImpl(SalaStruttura salaStruttura) {
		return getPersistence().updateImpl(salaStruttura);
	}

	/**
	* Returns the sala struttura with the primary key or throws a {@link NoSuchSalaStrutturaException} if it could not be found.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura
	* @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	*/
	public static SalaStruttura findByPrimaryKey(long id)
		throws servizio.prenotazione.aule.mef.exception.NoSuchSalaStrutturaException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the sala struttura with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura, or <code>null</code> if a sala struttura with the primary key could not be found
	*/
	public static SalaStruttura fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, SalaStruttura> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the sala strutturas.
	*
	* @return the sala strutturas
	*/
	public static List<SalaStruttura> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sala strutturas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @return the range of sala strutturas
	*/
	public static List<SalaStruttura> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sala strutturas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sala strutturas
	*/
	public static List<SalaStruttura> findAll(int start, int end,
		OrderByComparator<SalaStruttura> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the sala strutturas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sala strutturas
	*/
	public static List<SalaStruttura> findAll(int start, int end,
		OrderByComparator<SalaStruttura> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the sala strutturas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sala strutturas.
	*
	* @return the number of sala strutturas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SalaStrutturaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalaStrutturaPersistence, SalaStrutturaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SalaStrutturaPersistence.class);
}