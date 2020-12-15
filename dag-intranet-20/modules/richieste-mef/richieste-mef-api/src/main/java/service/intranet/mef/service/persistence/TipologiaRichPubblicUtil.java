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

import service.intranet.mef.model.TipologiaRichPubblic;

import java.util.List;

/**
 * The persistence utility for the tipologia rich pubblic service. This utility wraps {@link service.intranet.mef.service.persistence.impl.TipologiaRichPubblicPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaRichPubblicPersistence
 * @see service.intranet.mef.service.persistence.impl.TipologiaRichPubblicPersistenceImpl
 * @generated
 */
@ProviderType
public class TipologiaRichPubblicUtil {
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
	public static void clearCache(TipologiaRichPubblic tipologiaRichPubblic) {
		getPersistence().clearCache(tipologiaRichPubblic);
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
	public static List<TipologiaRichPubblic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipologiaRichPubblic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipologiaRichPubblic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipologiaRichPubblic> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipologiaRichPubblic update(
		TipologiaRichPubblic tipologiaRichPubblic) {
		return getPersistence().update(tipologiaRichPubblic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipologiaRichPubblic update(
		TipologiaRichPubblic tipologiaRichPubblic, ServiceContext serviceContext) {
		return getPersistence().update(tipologiaRichPubblic, serviceContext);
	}

	/**
	* Caches the tipologia rich pubblic in the entity cache if it is enabled.
	*
	* @param tipologiaRichPubblic the tipologia rich pubblic
	*/
	public static void cacheResult(TipologiaRichPubblic tipologiaRichPubblic) {
		getPersistence().cacheResult(tipologiaRichPubblic);
	}

	/**
	* Caches the tipologia rich pubblics in the entity cache if it is enabled.
	*
	* @param tipologiaRichPubblics the tipologia rich pubblics
	*/
	public static void cacheResult(
		List<TipologiaRichPubblic> tipologiaRichPubblics) {
		getPersistence().cacheResult(tipologiaRichPubblics);
	}

	/**
	* Creates a new tipologia rich pubblic with the primary key. Does not add the tipologia rich pubblic to the database.
	*
	* @param id the primary key for the new tipologia rich pubblic
	* @return the new tipologia rich pubblic
	*/
	public static TipologiaRichPubblic create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tipologia rich pubblic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tipologia rich pubblic
	* @return the tipologia rich pubblic that was removed
	* @throws NoSuchTipologiaRichPubblicException if a tipologia rich pubblic with the primary key could not be found
	*/
	public static TipologiaRichPubblic remove(long id)
		throws service.intranet.mef.exception.NoSuchTipologiaRichPubblicException {
		return getPersistence().remove(id);
	}

	public static TipologiaRichPubblic updateImpl(
		TipologiaRichPubblic tipologiaRichPubblic) {
		return getPersistence().updateImpl(tipologiaRichPubblic);
	}

	/**
	* Returns the tipologia rich pubblic with the primary key or throws a {@link NoSuchTipologiaRichPubblicException} if it could not be found.
	*
	* @param id the primary key of the tipologia rich pubblic
	* @return the tipologia rich pubblic
	* @throws NoSuchTipologiaRichPubblicException if a tipologia rich pubblic with the primary key could not be found
	*/
	public static TipologiaRichPubblic findByPrimaryKey(long id)
		throws service.intranet.mef.exception.NoSuchTipologiaRichPubblicException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tipologia rich pubblic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tipologia rich pubblic
	* @return the tipologia rich pubblic, or <code>null</code> if a tipologia rich pubblic with the primary key could not be found
	*/
	public static TipologiaRichPubblic fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, TipologiaRichPubblic> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tipologia rich pubblics.
	*
	* @return the tipologia rich pubblics
	*/
	public static List<TipologiaRichPubblic> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tipologia rich pubblics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia rich pubblics
	* @param end the upper bound of the range of tipologia rich pubblics (not inclusive)
	* @return the range of tipologia rich pubblics
	*/
	public static List<TipologiaRichPubblic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipologia rich pubblics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia rich pubblics
	* @param end the upper bound of the range of tipologia rich pubblics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipologia rich pubblics
	*/
	public static List<TipologiaRichPubblic> findAll(int start, int end,
		OrderByComparator<TipologiaRichPubblic> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tipologia rich pubblics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia rich pubblics
	* @param end the upper bound of the range of tipologia rich pubblics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipologia rich pubblics
	*/
	public static List<TipologiaRichPubblic> findAll(int start, int end,
		OrderByComparator<TipologiaRichPubblic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tipologia rich pubblics from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipologia rich pubblics.
	*
	* @return the number of tipologia rich pubblics
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TipologiaRichPubblicPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipologiaRichPubblicPersistence, TipologiaRichPubblicPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TipologiaRichPubblicPersistence.class);
}