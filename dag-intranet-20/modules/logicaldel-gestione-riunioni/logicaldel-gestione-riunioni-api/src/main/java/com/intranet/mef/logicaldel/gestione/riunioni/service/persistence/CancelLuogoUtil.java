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

package com.intranet.mef.logicaldel.gestione.riunioni.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelLuogo;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the cancel luogo service. This utility wraps {@link com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.impl.CancelLuogoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CancelLuogoPersistence
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.impl.CancelLuogoPersistenceImpl
 * @generated
 */
@ProviderType
public class CancelLuogoUtil {
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
	public static void clearCache(CancelLuogo cancelLuogo) {
		getPersistence().clearCache(cancelLuogo);
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
	public static List<CancelLuogo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CancelLuogo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CancelLuogo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CancelLuogo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CancelLuogo update(CancelLuogo cancelLuogo) {
		return getPersistence().update(cancelLuogo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CancelLuogo update(CancelLuogo cancelLuogo,
		ServiceContext serviceContext) {
		return getPersistence().update(cancelLuogo, serviceContext);
	}

	/**
	* Returns all the cancel luogos where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the matching cancel luogos
	*/
	public static List<CancelLuogo> findByLuoghiList(boolean cancellato) {
		return getPersistence().findByLuoghiList(cancellato);
	}

	/**
	* Returns a range of all the cancel luogos where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @return the range of matching cancel luogos
	*/
	public static List<CancelLuogo> findByLuoghiList(boolean cancellato,
		int start, int end) {
		return getPersistence().findByLuoghiList(cancellato, start, end);
	}

	/**
	* Returns an ordered range of all the cancel luogos where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cancel luogos
	*/
	public static List<CancelLuogo> findByLuoghiList(boolean cancellato,
		int start, int end, OrderByComparator<CancelLuogo> orderByComparator) {
		return getPersistence()
				   .findByLuoghiList(cancellato, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cancel luogos where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cancel luogos
	*/
	public static List<CancelLuogo> findByLuoghiList(boolean cancellato,
		int start, int end, OrderByComparator<CancelLuogo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLuoghiList(cancellato, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel luogo
	* @throws NoSuchCancelLuogoException if a matching cancel luogo could not be found
	*/
	public static CancelLuogo findByLuoghiList_First(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelLuogoException {
		return getPersistence()
				   .findByLuoghiList_First(cancellato, orderByComparator);
	}

	/**
	* Returns the first cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel luogo, or <code>null</code> if a matching cancel luogo could not be found
	*/
	public static CancelLuogo fetchByLuoghiList_First(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator) {
		return getPersistence()
				   .fetchByLuoghiList_First(cancellato, orderByComparator);
	}

	/**
	* Returns the last cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel luogo
	* @throws NoSuchCancelLuogoException if a matching cancel luogo could not be found
	*/
	public static CancelLuogo findByLuoghiList_Last(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelLuogoException {
		return getPersistence()
				   .findByLuoghiList_Last(cancellato, orderByComparator);
	}

	/**
	* Returns the last cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel luogo, or <code>null</code> if a matching cancel luogo could not be found
	*/
	public static CancelLuogo fetchByLuoghiList_Last(boolean cancellato,
		OrderByComparator<CancelLuogo> orderByComparator) {
		return getPersistence()
				   .fetchByLuoghiList_Last(cancellato, orderByComparator);
	}

	/**
	* Returns the cancel luogos before and after the current cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param id_luogo the primary key of the current cancel luogo
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cancel luogo
	* @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	*/
	public static CancelLuogo[] findByLuoghiList_PrevAndNext(long id_luogo,
		boolean cancellato, OrderByComparator<CancelLuogo> orderByComparator)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelLuogoException {
		return getPersistence()
				   .findByLuoghiList_PrevAndNext(id_luogo, cancellato,
			orderByComparator);
	}

	/**
	* Removes all the cancel luogos where cancellato = &#63; from the database.
	*
	* @param cancellato the cancellato
	*/
	public static void removeByLuoghiList(boolean cancellato) {
		getPersistence().removeByLuoghiList(cancellato);
	}

	/**
	* Returns the number of cancel luogos where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the number of matching cancel luogos
	*/
	public static int countByLuoghiList(boolean cancellato) {
		return getPersistence().countByLuoghiList(cancellato);
	}

	/**
	* Caches the cancel luogo in the entity cache if it is enabled.
	*
	* @param cancelLuogo the cancel luogo
	*/
	public static void cacheResult(CancelLuogo cancelLuogo) {
		getPersistence().cacheResult(cancelLuogo);
	}

	/**
	* Caches the cancel luogos in the entity cache if it is enabled.
	*
	* @param cancelLuogos the cancel luogos
	*/
	public static void cacheResult(List<CancelLuogo> cancelLuogos) {
		getPersistence().cacheResult(cancelLuogos);
	}

	/**
	* Creates a new cancel luogo with the primary key. Does not add the cancel luogo to the database.
	*
	* @param id_luogo the primary key for the new cancel luogo
	* @return the new cancel luogo
	*/
	public static CancelLuogo create(long id_luogo) {
		return getPersistence().create(id_luogo);
	}

	/**
	* Removes the cancel luogo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_luogo the primary key of the cancel luogo
	* @return the cancel luogo that was removed
	* @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	*/
	public static CancelLuogo remove(long id_luogo)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelLuogoException {
		return getPersistence().remove(id_luogo);
	}

	public static CancelLuogo updateImpl(CancelLuogo cancelLuogo) {
		return getPersistence().updateImpl(cancelLuogo);
	}

	/**
	* Returns the cancel luogo with the primary key or throws a {@link NoSuchCancelLuogoException} if it could not be found.
	*
	* @param id_luogo the primary key of the cancel luogo
	* @return the cancel luogo
	* @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	*/
	public static CancelLuogo findByPrimaryKey(long id_luogo)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelLuogoException {
		return getPersistence().findByPrimaryKey(id_luogo);
	}

	/**
	* Returns the cancel luogo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_luogo the primary key of the cancel luogo
	* @return the cancel luogo, or <code>null</code> if a cancel luogo with the primary key could not be found
	*/
	public static CancelLuogo fetchByPrimaryKey(long id_luogo) {
		return getPersistence().fetchByPrimaryKey(id_luogo);
	}

	public static java.util.Map<java.io.Serializable, CancelLuogo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the cancel luogos.
	*
	* @return the cancel luogos
	*/
	public static List<CancelLuogo> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cancel luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @return the range of cancel luogos
	*/
	public static List<CancelLuogo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cancel luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cancel luogos
	*/
	public static List<CancelLuogo> findAll(int start, int end,
		OrderByComparator<CancelLuogo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cancel luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cancel luogos
	*/
	public static List<CancelLuogo> findAll(int start, int end,
		OrderByComparator<CancelLuogo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the cancel luogos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cancel luogos.
	*
	* @return the number of cancel luogos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CancelLuogoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CancelLuogoPersistence, CancelLuogoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CancelLuogoPersistence.class);
}