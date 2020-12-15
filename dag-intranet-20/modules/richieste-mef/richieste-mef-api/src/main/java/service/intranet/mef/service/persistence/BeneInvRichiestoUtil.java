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

import service.intranet.mef.model.BeneInvRichiesto;

import java.util.List;

/**
 * The persistence utility for the bene inv richiesto service. This utility wraps {@link service.intranet.mef.service.persistence.impl.BeneInvRichiestoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvRichiestoPersistence
 * @see service.intranet.mef.service.persistence.impl.BeneInvRichiestoPersistenceImpl
 * @generated
 */
@ProviderType
public class BeneInvRichiestoUtil {
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
	public static void clearCache(BeneInvRichiesto beneInvRichiesto) {
		getPersistence().clearCache(beneInvRichiesto);
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
	public static List<BeneInvRichiesto> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BeneInvRichiesto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BeneInvRichiesto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BeneInvRichiesto update(BeneInvRichiesto beneInvRichiesto) {
		return getPersistence().update(beneInvRichiesto);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BeneInvRichiesto update(BeneInvRichiesto beneInvRichiesto,
		ServiceContext serviceContext) {
		return getPersistence().update(beneInvRichiesto, serviceContext);
	}

	/**
	* Returns all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @return the matching bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco) {
		return getPersistence()
				   .findByBeniInvRichiestiList(id_richiesta, in_elenco);
	}

	/**
	* Returns a range of all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param start the lower bound of the range of bene inv richiestos
	* @param end the upper bound of the range of bene inv richiestos (not inclusive)
	* @return the range of matching bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco, int start, int end) {
		return getPersistence()
				   .findByBeniInvRichiestiList(id_richiesta, in_elenco, start,
			end);
	}

	/**
	* Returns an ordered range of all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param start the lower bound of the range of bene inv richiestos
	* @param end the upper bound of the range of bene inv richiestos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco, int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		return getPersistence()
				   .findByBeniInvRichiestiList(id_richiesta, in_elenco, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param start the lower bound of the range of bene inv richiestos
	* @param end the upper bound of the range of bene inv richiestos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findByBeniInvRichiestiList(
		long id_richiesta, boolean in_elenco, int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByBeniInvRichiestiList(id_richiesta, in_elenco, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bene inv richiesto
	* @throws NoSuchBeneInvRichiestoException if a matching bene inv richiesto could not be found
	*/
	public static BeneInvRichiesto findByBeniInvRichiestiList_First(
		long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator)
		throws service.intranet.mef.exception.NoSuchBeneInvRichiestoException {
		return getPersistence()
				   .findByBeniInvRichiestiList_First(id_richiesta, in_elenco,
			orderByComparator);
	}

	/**
	* Returns the first bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bene inv richiesto, or <code>null</code> if a matching bene inv richiesto could not be found
	*/
	public static BeneInvRichiesto fetchByBeniInvRichiestiList_First(
		long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		return getPersistence()
				   .fetchByBeniInvRichiestiList_First(id_richiesta, in_elenco,
			orderByComparator);
	}

	/**
	* Returns the last bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bene inv richiesto
	* @throws NoSuchBeneInvRichiestoException if a matching bene inv richiesto could not be found
	*/
	public static BeneInvRichiesto findByBeniInvRichiestiList_Last(
		long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator)
		throws service.intranet.mef.exception.NoSuchBeneInvRichiestoException {
		return getPersistence()
				   .findByBeniInvRichiestiList_Last(id_richiesta, in_elenco,
			orderByComparator);
	}

	/**
	* Returns the last bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bene inv richiesto, or <code>null</code> if a matching bene inv richiesto could not be found
	*/
	public static BeneInvRichiesto fetchByBeniInvRichiestiList_Last(
		long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		return getPersistence()
				   .fetchByBeniInvRichiestiList_Last(id_richiesta, in_elenco,
			orderByComparator);
	}

	/**
	* Returns the bene inv richiestos before and after the current bene inv richiesto in the ordered set where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* @param id_bene_rich the primary key of the current bene inv richiesto
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bene inv richiesto
	* @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	*/
	public static BeneInvRichiesto[] findByBeniInvRichiestiList_PrevAndNext(
		long id_bene_rich, long id_richiesta, boolean in_elenco,
		OrderByComparator<BeneInvRichiesto> orderByComparator)
		throws service.intranet.mef.exception.NoSuchBeneInvRichiestoException {
		return getPersistence()
				   .findByBeniInvRichiestiList_PrevAndNext(id_bene_rich,
			id_richiesta, in_elenco, orderByComparator);
	}

	/**
	* Removes all the bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	*/
	public static void removeByBeniInvRichiestiList(long id_richiesta,
		boolean in_elenco) {
		getPersistence().removeByBeniInvRichiestiList(id_richiesta, in_elenco);
	}

	/**
	* Returns the number of bene inv richiestos where id_richiesta = &#63; and in_elenco = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param in_elenco the in_elenco
	* @return the number of matching bene inv richiestos
	*/
	public static int countByBeniInvRichiestiList(long id_richiesta,
		boolean in_elenco) {
		return getPersistence()
				   .countByBeniInvRichiestiList(id_richiesta, in_elenco);
	}

	/**
	* Caches the bene inv richiesto in the entity cache if it is enabled.
	*
	* @param beneInvRichiesto the bene inv richiesto
	*/
	public static void cacheResult(BeneInvRichiesto beneInvRichiesto) {
		getPersistence().cacheResult(beneInvRichiesto);
	}

	/**
	* Caches the bene inv richiestos in the entity cache if it is enabled.
	*
	* @param beneInvRichiestos the bene inv richiestos
	*/
	public static void cacheResult(List<BeneInvRichiesto> beneInvRichiestos) {
		getPersistence().cacheResult(beneInvRichiestos);
	}

	/**
	* Creates a new bene inv richiesto with the primary key. Does not add the bene inv richiesto to the database.
	*
	* @param id_bene_rich the primary key for the new bene inv richiesto
	* @return the new bene inv richiesto
	*/
	public static BeneInvRichiesto create(long id_bene_rich) {
		return getPersistence().create(id_bene_rich);
	}

	/**
	* Removes the bene inv richiesto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_bene_rich the primary key of the bene inv richiesto
	* @return the bene inv richiesto that was removed
	* @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	*/
	public static BeneInvRichiesto remove(long id_bene_rich)
		throws service.intranet.mef.exception.NoSuchBeneInvRichiestoException {
		return getPersistence().remove(id_bene_rich);
	}

	public static BeneInvRichiesto updateImpl(BeneInvRichiesto beneInvRichiesto) {
		return getPersistence().updateImpl(beneInvRichiesto);
	}

	/**
	* Returns the bene inv richiesto with the primary key or throws a {@link NoSuchBeneInvRichiestoException} if it could not be found.
	*
	* @param id_bene_rich the primary key of the bene inv richiesto
	* @return the bene inv richiesto
	* @throws NoSuchBeneInvRichiestoException if a bene inv richiesto with the primary key could not be found
	*/
	public static BeneInvRichiesto findByPrimaryKey(long id_bene_rich)
		throws service.intranet.mef.exception.NoSuchBeneInvRichiestoException {
		return getPersistence().findByPrimaryKey(id_bene_rich);
	}

	/**
	* Returns the bene inv richiesto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_bene_rich the primary key of the bene inv richiesto
	* @return the bene inv richiesto, or <code>null</code> if a bene inv richiesto with the primary key could not be found
	*/
	public static BeneInvRichiesto fetchByPrimaryKey(long id_bene_rich) {
		return getPersistence().fetchByPrimaryKey(id_bene_rich);
	}

	public static java.util.Map<java.io.Serializable, BeneInvRichiesto> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the bene inv richiestos.
	*
	* @return the bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bene inv richiestos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene inv richiestos
	* @param end the upper bound of the range of bene inv richiestos (not inclusive)
	* @return the range of bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bene inv richiestos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene inv richiestos
	* @param end the upper bound of the range of bene inv richiestos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findAll(int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bene inv richiestos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvRichiestoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene inv richiestos
	* @param end the upper bound of the range of bene inv richiestos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bene inv richiestos
	*/
	public static List<BeneInvRichiesto> findAll(int start, int end,
		OrderByComparator<BeneInvRichiesto> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the bene inv richiestos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bene inv richiestos.
	*
	* @return the number of bene inv richiestos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BeneInvRichiestoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BeneInvRichiestoPersistence, BeneInvRichiestoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(BeneInvRichiestoPersistence.class);
}