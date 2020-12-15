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

import service.intranet.mef.model.TipoBeneInv;

import java.util.List;

/**
 * The persistence utility for the tipo bene inv service. This utility wraps {@link service.intranet.mef.service.persistence.impl.TipoBeneInvPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoBeneInvPersistence
 * @see service.intranet.mef.service.persistence.impl.TipoBeneInvPersistenceImpl
 * @generated
 */
@ProviderType
public class TipoBeneInvUtil {
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
	public static void clearCache(TipoBeneInv tipoBeneInv) {
		getPersistence().clearCache(tipoBeneInv);
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
	public static List<TipoBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipoBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipoBeneInv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipoBeneInv> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipoBeneInv update(TipoBeneInv tipoBeneInv) {
		return getPersistence().update(tipoBeneInv);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipoBeneInv update(TipoBeneInv tipoBeneInv,
		ServiceContext serviceContext) {
		return getPersistence().update(tipoBeneInv, serviceContext);
	}

	/**
	* Caches the tipo bene inv in the entity cache if it is enabled.
	*
	* @param tipoBeneInv the tipo bene inv
	*/
	public static void cacheResult(TipoBeneInv tipoBeneInv) {
		getPersistence().cacheResult(tipoBeneInv);
	}

	/**
	* Caches the tipo bene invs in the entity cache if it is enabled.
	*
	* @param tipoBeneInvs the tipo bene invs
	*/
	public static void cacheResult(List<TipoBeneInv> tipoBeneInvs) {
		getPersistence().cacheResult(tipoBeneInvs);
	}

	/**
	* Creates a new tipo bene inv with the primary key. Does not add the tipo bene inv to the database.
	*
	* @param id the primary key for the new tipo bene inv
	* @return the new tipo bene inv
	*/
	public static TipoBeneInv create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tipo bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tipo bene inv
	* @return the tipo bene inv that was removed
	* @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	*/
	public static TipoBeneInv remove(long id)
		throws service.intranet.mef.exception.NoSuchTipoBeneInvException {
		return getPersistence().remove(id);
	}

	public static TipoBeneInv updateImpl(TipoBeneInv tipoBeneInv) {
		return getPersistence().updateImpl(tipoBeneInv);
	}

	/**
	* Returns the tipo bene inv with the primary key or throws a {@link NoSuchTipoBeneInvException} if it could not be found.
	*
	* @param id the primary key of the tipo bene inv
	* @return the tipo bene inv
	* @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	*/
	public static TipoBeneInv findByPrimaryKey(long id)
		throws service.intranet.mef.exception.NoSuchTipoBeneInvException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tipo bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tipo bene inv
	* @return the tipo bene inv, or <code>null</code> if a tipo bene inv with the primary key could not be found
	*/
	public static TipoBeneInv fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, TipoBeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tipo bene invs.
	*
	* @return the tipo bene invs
	*/
	public static List<TipoBeneInv> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tipo bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo bene invs
	* @param end the upper bound of the range of tipo bene invs (not inclusive)
	* @return the range of tipo bene invs
	*/
	public static List<TipoBeneInv> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipo bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo bene invs
	* @param end the upper bound of the range of tipo bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo bene invs
	*/
	public static List<TipoBeneInv> findAll(int start, int end,
		OrderByComparator<TipoBeneInv> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tipo bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo bene invs
	* @param end the upper bound of the range of tipo bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipo bene invs
	*/
	public static List<TipoBeneInv> findAll(int start, int end,
		OrderByComparator<TipoBeneInv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tipo bene invs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipo bene invs.
	*
	* @return the number of tipo bene invs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TipoBeneInvPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipoBeneInvPersistence, TipoBeneInvPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipoBeneInvPersistence.class);
}