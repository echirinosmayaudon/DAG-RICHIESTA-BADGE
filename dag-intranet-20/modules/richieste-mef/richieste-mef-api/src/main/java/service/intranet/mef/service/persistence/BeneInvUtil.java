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

import service.intranet.mef.model.BeneInv;

import java.util.List;

/**
 * The persistence utility for the bene inv service. This utility wraps {@link service.intranet.mef.service.persistence.impl.BeneInvPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvPersistence
 * @see service.intranet.mef.service.persistence.impl.BeneInvPersistenceImpl
 * @generated
 */
@ProviderType
public class BeneInvUtil {
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
	public static void clearCache(BeneInv beneInv) {
		getPersistence().clearCache(beneInv);
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
	public static List<BeneInv> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BeneInv> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BeneInv update(BeneInv beneInv) {
		return getPersistence().update(beneInv);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BeneInv update(BeneInv beneInv, ServiceContext serviceContext) {
		return getPersistence().update(beneInv, serviceContext);
	}

	/**
	* Returns all the bene invs where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @return the matching bene invs
	*/
	public static List<BeneInv> findByTipoBeneInv(long id_tipo) {
		return getPersistence().findByTipoBeneInv(id_tipo);
	}

	/**
	* Returns a range of all the bene invs where id_tipo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_tipo the id_tipo
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @return the range of matching bene invs
	*/
	public static List<BeneInv> findByTipoBeneInv(long id_tipo, int start,
		int end) {
		return getPersistence().findByTipoBeneInv(id_tipo, start, end);
	}

	/**
	* Returns an ordered range of all the bene invs where id_tipo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_tipo the id_tipo
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bene invs
	*/
	public static List<BeneInv> findByTipoBeneInv(long id_tipo, int start,
		int end, OrderByComparator<BeneInv> orderByComparator) {
		return getPersistence()
				   .findByTipoBeneInv(id_tipo, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bene invs where id_tipo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_tipo the id_tipo
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bene invs
	*/
	public static List<BeneInv> findByTipoBeneInv(long id_tipo, int start,
		int end, OrderByComparator<BeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTipoBeneInv(id_tipo, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bene inv
	* @throws NoSuchBeneInvException if a matching bene inv could not be found
	*/
	public static BeneInv findByTipoBeneInv_First(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchBeneInvException {
		return getPersistence()
				   .findByTipoBeneInv_First(id_tipo, orderByComparator);
	}

	/**
	* Returns the first bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bene inv, or <code>null</code> if a matching bene inv could not be found
	*/
	public static BeneInv fetchByTipoBeneInv_First(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator) {
		return getPersistence()
				   .fetchByTipoBeneInv_First(id_tipo, orderByComparator);
	}

	/**
	* Returns the last bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bene inv
	* @throws NoSuchBeneInvException if a matching bene inv could not be found
	*/
	public static BeneInv findByTipoBeneInv_Last(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchBeneInvException {
		return getPersistence()
				   .findByTipoBeneInv_Last(id_tipo, orderByComparator);
	}

	/**
	* Returns the last bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bene inv, or <code>null</code> if a matching bene inv could not be found
	*/
	public static BeneInv fetchByTipoBeneInv_Last(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator) {
		return getPersistence()
				   .fetchByTipoBeneInv_Last(id_tipo, orderByComparator);
	}

	/**
	* Returns the bene invs before and after the current bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id the primary key of the current bene inv
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bene inv
	* @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	*/
	public static BeneInv[] findByTipoBeneInv_PrevAndNext(long id,
		long id_tipo, OrderByComparator<BeneInv> orderByComparator)
		throws service.intranet.mef.exception.NoSuchBeneInvException {
		return getPersistence()
				   .findByTipoBeneInv_PrevAndNext(id, id_tipo, orderByComparator);
	}

	/**
	* Removes all the bene invs where id_tipo = &#63; from the database.
	*
	* @param id_tipo the id_tipo
	*/
	public static void removeByTipoBeneInv(long id_tipo) {
		getPersistence().removeByTipoBeneInv(id_tipo);
	}

	/**
	* Returns the number of bene invs where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @return the number of matching bene invs
	*/
	public static int countByTipoBeneInv(long id_tipo) {
		return getPersistence().countByTipoBeneInv(id_tipo);
	}

	/**
	* Caches the bene inv in the entity cache if it is enabled.
	*
	* @param beneInv the bene inv
	*/
	public static void cacheResult(BeneInv beneInv) {
		getPersistence().cacheResult(beneInv);
	}

	/**
	* Caches the bene invs in the entity cache if it is enabled.
	*
	* @param beneInvs the bene invs
	*/
	public static void cacheResult(List<BeneInv> beneInvs) {
		getPersistence().cacheResult(beneInvs);
	}

	/**
	* Creates a new bene inv with the primary key. Does not add the bene inv to the database.
	*
	* @param id the primary key for the new bene inv
	* @return the new bene inv
	*/
	public static BeneInv create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv that was removed
	* @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	*/
	public static BeneInv remove(long id)
		throws service.intranet.mef.exception.NoSuchBeneInvException {
		return getPersistence().remove(id);
	}

	public static BeneInv updateImpl(BeneInv beneInv) {
		return getPersistence().updateImpl(beneInv);
	}

	/**
	* Returns the bene inv with the primary key or throws a {@link NoSuchBeneInvException} if it could not be found.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv
	* @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	*/
	public static BeneInv findByPrimaryKey(long id)
		throws service.intranet.mef.exception.NoSuchBeneInvException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv, or <code>null</code> if a bene inv with the primary key could not be found
	*/
	public static BeneInv fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, BeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the bene invs.
	*
	* @return the bene invs
	*/
	public static List<BeneInv> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @return the range of bene invs
	*/
	public static List<BeneInv> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bene invs
	*/
	public static List<BeneInv> findAll(int start, int end,
		OrderByComparator<BeneInv> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bene invs
	*/
	public static List<BeneInv> findAll(int start, int end,
		OrderByComparator<BeneInv> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the bene invs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bene invs.
	*
	* @return the number of bene invs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BeneInvPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BeneInvPersistence, BeneInvPersistence> _serviceTracker =
		ServiceTrackerFactory.open(BeneInvPersistence.class);
}