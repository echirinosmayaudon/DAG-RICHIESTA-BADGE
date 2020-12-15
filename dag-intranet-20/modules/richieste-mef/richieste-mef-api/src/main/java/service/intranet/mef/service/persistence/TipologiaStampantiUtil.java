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

import service.intranet.mef.model.TipologiaStampanti;

import java.util.List;

/**
 * The persistence utility for the tipologia stampanti service. This utility wraps {@link service.intranet.mef.service.persistence.impl.TipologiaStampantiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaStampantiPersistence
 * @see service.intranet.mef.service.persistence.impl.TipologiaStampantiPersistenceImpl
 * @generated
 */
@ProviderType
public class TipologiaStampantiUtil {
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
	public static void clearCache(TipologiaStampanti tipologiaStampanti) {
		getPersistence().clearCache(tipologiaStampanti);
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
	public static List<TipologiaStampanti> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipologiaStampanti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipologiaStampanti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipologiaStampanti> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipologiaStampanti update(
		TipologiaStampanti tipologiaStampanti) {
		return getPersistence().update(tipologiaStampanti);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipologiaStampanti update(
		TipologiaStampanti tipologiaStampanti, ServiceContext serviceContext) {
		return getPersistence().update(tipologiaStampanti, serviceContext);
	}

	/**
	* Caches the tipologia stampanti in the entity cache if it is enabled.
	*
	* @param tipologiaStampanti the tipologia stampanti
	*/
	public static void cacheResult(TipologiaStampanti tipologiaStampanti) {
		getPersistence().cacheResult(tipologiaStampanti);
	}

	/**
	* Caches the tipologia stampantis in the entity cache if it is enabled.
	*
	* @param tipologiaStampantis the tipologia stampantis
	*/
	public static void cacheResult(List<TipologiaStampanti> tipologiaStampantis) {
		getPersistence().cacheResult(tipologiaStampantis);
	}

	/**
	* Creates a new tipologia stampanti with the primary key. Does not add the tipologia stampanti to the database.
	*
	* @param id_tipologia_stampanti the primary key for the new tipologia stampanti
	* @return the new tipologia stampanti
	*/
	public static TipologiaStampanti create(long id_tipologia_stampanti) {
		return getPersistence().create(id_tipologia_stampanti);
	}

	/**
	* Removes the tipologia stampanti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti that was removed
	* @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	*/
	public static TipologiaStampanti remove(long id_tipologia_stampanti)
		throws service.intranet.mef.exception.NoSuchTipologiaStampantiException {
		return getPersistence().remove(id_tipologia_stampanti);
	}

	public static TipologiaStampanti updateImpl(
		TipologiaStampanti tipologiaStampanti) {
		return getPersistence().updateImpl(tipologiaStampanti);
	}

	/**
	* Returns the tipologia stampanti with the primary key or throws a {@link NoSuchTipologiaStampantiException} if it could not be found.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti
	* @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	*/
	public static TipologiaStampanti findByPrimaryKey(
		long id_tipologia_stampanti)
		throws service.intranet.mef.exception.NoSuchTipologiaStampantiException {
		return getPersistence().findByPrimaryKey(id_tipologia_stampanti);
	}

	/**
	* Returns the tipologia stampanti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti, or <code>null</code> if a tipologia stampanti with the primary key could not be found
	*/
	public static TipologiaStampanti fetchByPrimaryKey(
		long id_tipologia_stampanti) {
		return getPersistence().fetchByPrimaryKey(id_tipologia_stampanti);
	}

	public static java.util.Map<java.io.Serializable, TipologiaStampanti> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tipologia stampantis.
	*
	* @return the tipologia stampantis
	*/
	public static List<TipologiaStampanti> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tipologia stampantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia stampantis
	* @param end the upper bound of the range of tipologia stampantis (not inclusive)
	* @return the range of tipologia stampantis
	*/
	public static List<TipologiaStampanti> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipologia stampantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia stampantis
	* @param end the upper bound of the range of tipologia stampantis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipologia stampantis
	*/
	public static List<TipologiaStampanti> findAll(int start, int end,
		OrderByComparator<TipologiaStampanti> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tipologia stampantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia stampantis
	* @param end the upper bound of the range of tipologia stampantis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipologia stampantis
	*/
	public static List<TipologiaStampanti> findAll(int start, int end,
		OrderByComparator<TipologiaStampanti> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tipologia stampantis from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipologia stampantis.
	*
	* @return the number of tipologia stampantis
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipologiaStampantiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipologiaStampantiPersistence, TipologiaStampantiPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipologiaStampantiPersistence.class);
}