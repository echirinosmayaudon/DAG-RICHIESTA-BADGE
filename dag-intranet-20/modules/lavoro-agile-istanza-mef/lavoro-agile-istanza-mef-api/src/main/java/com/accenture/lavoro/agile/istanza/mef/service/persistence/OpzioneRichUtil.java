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

package com.accenture.lavoro.agile.istanza.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the opzione rich service. This utility wraps {@link com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.OpzioneRichPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRichPersistence
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.OpzioneRichPersistenceImpl
 * @generated
 */
@ProviderType
public class OpzioneRichUtil {
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
	public static void clearCache(OpzioneRich opzioneRich) {
		getPersistence().clearCache(opzioneRich);
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
	public static List<OpzioneRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OpzioneRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OpzioneRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OpzioneRich> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OpzioneRich update(OpzioneRich opzioneRich) {
		return getPersistence().update(opzioneRich);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OpzioneRich update(OpzioneRich opzioneRich,
		ServiceContext serviceContext) {
		return getPersistence().update(opzioneRich, serviceContext);
	}

	/**
	* Returns all the opzione richs where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @return the matching opzione richs
	*/
	public static List<OpzioneRich> findBylabel_opt(String label_opt) {
		return getPersistence().findBylabel_opt(label_opt);
	}

	/**
	* Returns a range of all the opzione richs where label_opt = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_opt the label_opt
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @return the range of matching opzione richs
	*/
	public static List<OpzioneRich> findBylabel_opt(String label_opt,
		int start, int end) {
		return getPersistence().findBylabel_opt(label_opt, start, end);
	}

	/**
	* Returns an ordered range of all the opzione richs where label_opt = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_opt the label_opt
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching opzione richs
	*/
	public static List<OpzioneRich> findBylabel_opt(String label_opt,
		int start, int end, OrderByComparator<OpzioneRich> orderByComparator) {
		return getPersistence()
				   .findBylabel_opt(label_opt, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the opzione richs where label_opt = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_opt the label_opt
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching opzione richs
	*/
	public static List<OpzioneRich> findBylabel_opt(String label_opt,
		int start, int end, OrderByComparator<OpzioneRich> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBylabel_opt(label_opt, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching opzione rich
	* @throws NoSuchOpzioneRichException if a matching opzione rich could not be found
	*/
	public static OpzioneRich findBylabel_opt_First(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchOpzioneRichException {
		return getPersistence()
				   .findBylabel_opt_First(label_opt, orderByComparator);
	}

	/**
	* Returns the first opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching opzione rich, or <code>null</code> if a matching opzione rich could not be found
	*/
	public static OpzioneRich fetchBylabel_opt_First(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator) {
		return getPersistence()
				   .fetchBylabel_opt_First(label_opt, orderByComparator);
	}

	/**
	* Returns the last opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching opzione rich
	* @throws NoSuchOpzioneRichException if a matching opzione rich could not be found
	*/
	public static OpzioneRich findBylabel_opt_Last(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchOpzioneRichException {
		return getPersistence()
				   .findBylabel_opt_Last(label_opt, orderByComparator);
	}

	/**
	* Returns the last opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching opzione rich, or <code>null</code> if a matching opzione rich could not be found
	*/
	public static OpzioneRich fetchBylabel_opt_Last(String label_opt,
		OrderByComparator<OpzioneRich> orderByComparator) {
		return getPersistence()
				   .fetchBylabel_opt_Last(label_opt, orderByComparator);
	}

	/**
	* Returns the opzione richs before and after the current opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param id_opt the primary key of the current opzione rich
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next opzione rich
	* @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	*/
	public static OpzioneRich[] findBylabel_opt_PrevAndNext(long id_opt,
		String label_opt, OrderByComparator<OpzioneRich> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchOpzioneRichException {
		return getPersistence()
				   .findBylabel_opt_PrevAndNext(id_opt, label_opt,
			orderByComparator);
	}

	/**
	* Removes all the opzione richs where label_opt = &#63; from the database.
	*
	* @param label_opt the label_opt
	*/
	public static void removeBylabel_opt(String label_opt) {
		getPersistence().removeBylabel_opt(label_opt);
	}

	/**
	* Returns the number of opzione richs where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @return the number of matching opzione richs
	*/
	public static int countBylabel_opt(String label_opt) {
		return getPersistence().countBylabel_opt(label_opt);
	}

	/**
	* Caches the opzione rich in the entity cache if it is enabled.
	*
	* @param opzioneRich the opzione rich
	*/
	public static void cacheResult(OpzioneRich opzioneRich) {
		getPersistence().cacheResult(opzioneRich);
	}

	/**
	* Caches the opzione richs in the entity cache if it is enabled.
	*
	* @param opzioneRichs the opzione richs
	*/
	public static void cacheResult(List<OpzioneRich> opzioneRichs) {
		getPersistence().cacheResult(opzioneRichs);
	}

	/**
	* Creates a new opzione rich with the primary key. Does not add the opzione rich to the database.
	*
	* @param id_opt the primary key for the new opzione rich
	* @return the new opzione rich
	*/
	public static OpzioneRich create(long id_opt) {
		return getPersistence().create(id_opt);
	}

	/**
	* Removes the opzione rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich that was removed
	* @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	*/
	public static OpzioneRich remove(long id_opt)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchOpzioneRichException {
		return getPersistence().remove(id_opt);
	}

	public static OpzioneRich updateImpl(OpzioneRich opzioneRich) {
		return getPersistence().updateImpl(opzioneRich);
	}

	/**
	* Returns the opzione rich with the primary key or throws a {@link NoSuchOpzioneRichException} if it could not be found.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich
	* @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	*/
	public static OpzioneRich findByPrimaryKey(long id_opt)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchOpzioneRichException {
		return getPersistence().findByPrimaryKey(id_opt);
	}

	/**
	* Returns the opzione rich with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich, or <code>null</code> if a opzione rich with the primary key could not be found
	*/
	public static OpzioneRich fetchByPrimaryKey(long id_opt) {
		return getPersistence().fetchByPrimaryKey(id_opt);
	}

	public static java.util.Map<java.io.Serializable, OpzioneRich> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the opzione richs.
	*
	* @return the opzione richs
	*/
	public static List<OpzioneRich> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the opzione richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @return the range of opzione richs
	*/
	public static List<OpzioneRich> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the opzione richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of opzione richs
	*/
	public static List<OpzioneRich> findAll(int start, int end,
		OrderByComparator<OpzioneRich> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the opzione richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of opzione richs
	*/
	public static List<OpzioneRich> findAll(int start, int end,
		OrderByComparator<OpzioneRich> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the opzione richs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of opzione richs.
	*
	* @return the number of opzione richs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OpzioneRichPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OpzioneRichPersistence, OpzioneRichPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OpzioneRichPersistence.class);

		ServiceTracker<OpzioneRichPersistence, OpzioneRichPersistence> serviceTracker =
			new ServiceTracker<OpzioneRichPersistence, OpzioneRichPersistence>(bundle.getBundleContext(),
				OpzioneRichPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}