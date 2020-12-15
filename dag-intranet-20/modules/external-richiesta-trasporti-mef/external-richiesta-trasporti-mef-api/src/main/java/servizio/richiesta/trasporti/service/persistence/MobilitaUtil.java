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

package servizio.richiesta.trasporti.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.richiesta.trasporti.model.Mobilita;

import java.util.List;

/**
 * The persistence utility for the mobilita service. This utility wraps {@link servizio.richiesta.trasporti.service.persistence.impl.MobilitaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MobilitaPersistence
 * @see servizio.richiesta.trasporti.service.persistence.impl.MobilitaPersistenceImpl
 * @generated
 */
@ProviderType
public class MobilitaUtil {
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
	public static void clearCache(Mobilita mobilita) {
		getPersistence().clearCache(mobilita);
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
	public static List<Mobilita> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Mobilita> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Mobilita> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Mobilita> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Mobilita update(Mobilita mobilita) {
		return getPersistence().update(mobilita);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Mobilita update(Mobilita mobilita,
		ServiceContext serviceContext) {
		return getPersistence().update(mobilita, serviceContext);
	}

	/**
	* Returns all the mobilitas where person_id = &#63;.
	*
	* @param person_id the person_id
	* @return the matching mobilitas
	*/
	public static List<Mobilita> findByPersonId(long person_id) {
		return getPersistence().findByPersonId(person_id);
	}

	/**
	* Returns a range of all the mobilitas where person_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param person_id the person_id
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @return the range of matching mobilitas
	*/
	public static List<Mobilita> findByPersonId(long person_id, int start,
		int end) {
		return getPersistence().findByPersonId(person_id, start, end);
	}

	/**
	* Returns an ordered range of all the mobilitas where person_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param person_id the person_id
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching mobilitas
	*/
	public static List<Mobilita> findByPersonId(long person_id, int start,
		int end, OrderByComparator<Mobilita> orderByComparator) {
		return getPersistence()
				   .findByPersonId(person_id, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the mobilitas where person_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param person_id the person_id
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching mobilitas
	*/
	public static List<Mobilita> findByPersonId(long person_id, int start,
		int end, OrderByComparator<Mobilita> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPersonId(person_id, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mobilita
	* @throws NoSuchMobilitaException if a matching mobilita could not be found
	*/
	public static Mobilita findByPersonId_First(long person_id,
		OrderByComparator<Mobilita> orderByComparator)
		throws servizio.richiesta.trasporti.exception.NoSuchMobilitaException {
		return getPersistence()
				   .findByPersonId_First(person_id, orderByComparator);
	}

	/**
	* Returns the first mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mobilita, or <code>null</code> if a matching mobilita could not be found
	*/
	public static Mobilita fetchByPersonId_First(long person_id,
		OrderByComparator<Mobilita> orderByComparator) {
		return getPersistence()
				   .fetchByPersonId_First(person_id, orderByComparator);
	}

	/**
	* Returns the last mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mobilita
	* @throws NoSuchMobilitaException if a matching mobilita could not be found
	*/
	public static Mobilita findByPersonId_Last(long person_id,
		OrderByComparator<Mobilita> orderByComparator)
		throws servizio.richiesta.trasporti.exception.NoSuchMobilitaException {
		return getPersistence().findByPersonId_Last(person_id, orderByComparator);
	}

	/**
	* Returns the last mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mobilita, or <code>null</code> if a matching mobilita could not be found
	*/
	public static Mobilita fetchByPersonId_Last(long person_id,
		OrderByComparator<Mobilita> orderByComparator) {
		return getPersistence()
				   .fetchByPersonId_Last(person_id, orderByComparator);
	}

	/**
	* Returns the mobilitas before and after the current mobilita in the ordered set where person_id = &#63;.
	*
	* @param custom_key the primary key of the current mobilita
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next mobilita
	* @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	*/
	public static Mobilita[] findByPersonId_PrevAndNext(
		java.lang.String custom_key, long person_id,
		OrderByComparator<Mobilita> orderByComparator)
		throws servizio.richiesta.trasporti.exception.NoSuchMobilitaException {
		return getPersistence()
				   .findByPersonId_PrevAndNext(custom_key, person_id,
			orderByComparator);
	}

	/**
	* Removes all the mobilitas where person_id = &#63; from the database.
	*
	* @param person_id the person_id
	*/
	public static void removeByPersonId(long person_id) {
		getPersistence().removeByPersonId(person_id);
	}

	/**
	* Returns the number of mobilitas where person_id = &#63;.
	*
	* @param person_id the person_id
	* @return the number of matching mobilitas
	*/
	public static int countByPersonId(long person_id) {
		return getPersistence().countByPersonId(person_id);
	}

	/**
	* Caches the mobilita in the entity cache if it is enabled.
	*
	* @param mobilita the mobilita
	*/
	public static void cacheResult(Mobilita mobilita) {
		getPersistence().cacheResult(mobilita);
	}

	/**
	* Caches the mobilitas in the entity cache if it is enabled.
	*
	* @param mobilitas the mobilitas
	*/
	public static void cacheResult(List<Mobilita> mobilitas) {
		getPersistence().cacheResult(mobilitas);
	}

	/**
	* Creates a new mobilita with the primary key. Does not add the mobilita to the database.
	*
	* @param custom_key the primary key for the new mobilita
	* @return the new mobilita
	*/
	public static Mobilita create(java.lang.String custom_key) {
		return getPersistence().create(custom_key);
	}

	/**
	* Removes the mobilita with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita that was removed
	* @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	*/
	public static Mobilita remove(java.lang.String custom_key)
		throws servizio.richiesta.trasporti.exception.NoSuchMobilitaException {
		return getPersistence().remove(custom_key);
	}

	public static Mobilita updateImpl(Mobilita mobilita) {
		return getPersistence().updateImpl(mobilita);
	}

	/**
	* Returns the mobilita with the primary key or throws a {@link NoSuchMobilitaException} if it could not be found.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita
	* @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	*/
	public static Mobilita findByPrimaryKey(java.lang.String custom_key)
		throws servizio.richiesta.trasporti.exception.NoSuchMobilitaException {
		return getPersistence().findByPrimaryKey(custom_key);
	}

	/**
	* Returns the mobilita with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita, or <code>null</code> if a mobilita with the primary key could not be found
	*/
	public static Mobilita fetchByPrimaryKey(java.lang.String custom_key) {
		return getPersistence().fetchByPrimaryKey(custom_key);
	}

	public static java.util.Map<java.io.Serializable, Mobilita> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the mobilitas.
	*
	* @return the mobilitas
	*/
	public static List<Mobilita> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the mobilitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @return the range of mobilitas
	*/
	public static List<Mobilita> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the mobilitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of mobilitas
	*/
	public static List<Mobilita> findAll(int start, int end,
		OrderByComparator<Mobilita> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the mobilitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of mobilitas
	*/
	public static List<Mobilita> findAll(int start, int end,
		OrderByComparator<Mobilita> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the mobilitas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of mobilitas.
	*
	* @return the number of mobilitas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MobilitaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MobilitaPersistence, MobilitaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MobilitaPersistence.class);
}