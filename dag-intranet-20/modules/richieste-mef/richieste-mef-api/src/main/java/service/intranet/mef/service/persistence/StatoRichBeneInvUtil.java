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

import service.intranet.mef.model.StatoRichBeneInv;

import java.util.List;

/**
 * The persistence utility for the stato rich bene inv service. This utility wraps {@link service.intranet.mef.service.persistence.impl.StatoRichBeneInvPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichBeneInvPersistence
 * @see service.intranet.mef.service.persistence.impl.StatoRichBeneInvPersistenceImpl
 * @generated
 */
@ProviderType
public class StatoRichBeneInvUtil {
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
	public static void clearCache(StatoRichBeneInv statoRichBeneInv) {
		getPersistence().clearCache(statoRichBeneInv);
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
	public static List<StatoRichBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatoRichBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatoRichBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatoRichBeneInv update(StatoRichBeneInv statoRichBeneInv) {
		return getPersistence().update(statoRichBeneInv);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatoRichBeneInv update(StatoRichBeneInv statoRichBeneInv,
		ServiceContext serviceContext) {
		return getPersistence().update(statoRichBeneInv, serviceContext);
	}

	/**
	* Returns all the stato rich bene invs where stato = &#63;.
	*
	* @param stato the stato
	* @return the matching stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findByNomeStato(java.lang.String stato) {
		return getPersistence().findByNomeStato(stato);
	}

	/**
	* Returns a range of all the stato rich bene invs where stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stato the stato
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @return the range of matching stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findByNomeStato(
		java.lang.String stato, int start, int end) {
		return getPersistence().findByNomeStato(stato, start, end);
	}

	/**
	* Returns an ordered range of all the stato rich bene invs where stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stato the stato
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findByNomeStato(
		java.lang.String stato, int start, int end,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		return getPersistence()
				   .findByNomeStato(stato, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato rich bene invs where stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stato the stato
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findByNomeStato(
		java.lang.String stato, int start, int end,
		OrderByComparator<StatoRichBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByNomeStato(stato, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a matching stato rich bene inv could not be found
	*/
	public static StatoRichBeneInv findByNomeStato_First(
		java.lang.String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchStatoRichBeneInvException {
		return getPersistence().findByNomeStato_First(stato, orderByComparator);
	}

	/**
	* Returns the first stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato rich bene inv, or <code>null</code> if a matching stato rich bene inv could not be found
	*/
	public static StatoRichBeneInv fetchByNomeStato_First(
		java.lang.String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		return getPersistence().fetchByNomeStato_First(stato, orderByComparator);
	}

	/**
	* Returns the last stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a matching stato rich bene inv could not be found
	*/
	public static StatoRichBeneInv findByNomeStato_Last(
		java.lang.String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchStatoRichBeneInvException {
		return getPersistence().findByNomeStato_Last(stato, orderByComparator);
	}

	/**
	* Returns the last stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato rich bene inv, or <code>null</code> if a matching stato rich bene inv could not be found
	*/
	public static StatoRichBeneInv fetchByNomeStato_Last(
		java.lang.String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		return getPersistence().fetchByNomeStato_Last(stato, orderByComparator);
	}

	/**
	* Returns the stato rich bene invs before and after the current stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param id the primary key of the current stato rich bene inv
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	*/
	public static StatoRichBeneInv[] findByNomeStato_PrevAndNext(long id,
		java.lang.String stato,
		OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchStatoRichBeneInvException {
		return getPersistence()
				   .findByNomeStato_PrevAndNext(id, stato, orderByComparator);
	}

	/**
	* Removes all the stato rich bene invs where stato = &#63; from the database.
	*
	* @param stato the stato
	*/
	public static void removeByNomeStato(java.lang.String stato) {
		getPersistence().removeByNomeStato(stato);
	}

	/**
	* Returns the number of stato rich bene invs where stato = &#63;.
	*
	* @param stato the stato
	* @return the number of matching stato rich bene invs
	*/
	public static int countByNomeStato(java.lang.String stato) {
		return getPersistence().countByNomeStato(stato);
	}

	/**
	* Caches the stato rich bene inv in the entity cache if it is enabled.
	*
	* @param statoRichBeneInv the stato rich bene inv
	*/
	public static void cacheResult(StatoRichBeneInv statoRichBeneInv) {
		getPersistence().cacheResult(statoRichBeneInv);
	}

	/**
	* Caches the stato rich bene invs in the entity cache if it is enabled.
	*
	* @param statoRichBeneInvs the stato rich bene invs
	*/
	public static void cacheResult(List<StatoRichBeneInv> statoRichBeneInvs) {
		getPersistence().cacheResult(statoRichBeneInvs);
	}

	/**
	* Creates a new stato rich bene inv with the primary key. Does not add the stato rich bene inv to the database.
	*
	* @param id the primary key for the new stato rich bene inv
	* @return the new stato rich bene inv
	*/
	public static StatoRichBeneInv create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the stato rich bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stato rich bene inv
	* @return the stato rich bene inv that was removed
	* @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	*/
	public static StatoRichBeneInv remove(long id)
		throws service.intranet.mef.exception.NoSuchStatoRichBeneInvException {
		return getPersistence().remove(id);
	}

	public static StatoRichBeneInv updateImpl(StatoRichBeneInv statoRichBeneInv) {
		return getPersistence().updateImpl(statoRichBeneInv);
	}

	/**
	* Returns the stato rich bene inv with the primary key or throws a {@link NoSuchStatoRichBeneInvException} if it could not be found.
	*
	* @param id the primary key of the stato rich bene inv
	* @return the stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	*/
	public static StatoRichBeneInv findByPrimaryKey(long id)
		throws service.intranet.mef.exception.NoSuchStatoRichBeneInvException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the stato rich bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stato rich bene inv
	* @return the stato rich bene inv, or <code>null</code> if a stato rich bene inv with the primary key could not be found
	*/
	public static StatoRichBeneInv fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, StatoRichBeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the stato rich bene invs.
	*
	* @return the stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stato rich bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @return the range of stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stato rich bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findAll(int start, int end,
		OrderByComparator<StatoRichBeneInv> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato rich bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato rich bene invs
	*/
	public static List<StatoRichBeneInv> findAll(int start, int end,
		OrderByComparator<StatoRichBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the stato rich bene invs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stato rich bene invs.
	*
	* @return the number of stato rich bene invs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static StatoRichBeneInvPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatoRichBeneInvPersistence, StatoRichBeneInvPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StatoRichBeneInvPersistence.class);
}