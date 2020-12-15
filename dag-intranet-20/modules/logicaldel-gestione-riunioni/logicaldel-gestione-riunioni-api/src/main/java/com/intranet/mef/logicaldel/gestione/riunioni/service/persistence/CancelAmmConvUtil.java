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

import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the cancel amm conv service. This utility wraps {@link com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.impl.CancelAmmConvPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConvPersistence
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.impl.CancelAmmConvPersistenceImpl
 * @generated
 */
@ProviderType
public class CancelAmmConvUtil {
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
	public static void clearCache(CancelAmmConv cancelAmmConv) {
		getPersistence().clearCache(cancelAmmConv);
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
	public static List<CancelAmmConv> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CancelAmmConv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CancelAmmConv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CancelAmmConv> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CancelAmmConv update(CancelAmmConv cancelAmmConv) {
		return getPersistence().update(cancelAmmConv);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CancelAmmConv update(CancelAmmConv cancelAmmConv,
		ServiceContext serviceContext) {
		return getPersistence().update(cancelAmmConv, serviceContext);
	}

	/**
	* Returns all the cancel amm convs where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the matching cancel amm convs
	*/
	public static List<CancelAmmConv> findByAmmConvList(boolean cancellato) {
		return getPersistence().findByAmmConvList(cancellato);
	}

	/**
	* Returns a range of all the cancel amm convs where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @return the range of matching cancel amm convs
	*/
	public static List<CancelAmmConv> findByAmmConvList(boolean cancellato,
		int start, int end) {
		return getPersistence().findByAmmConvList(cancellato, start, end);
	}

	/**
	* Returns an ordered range of all the cancel amm convs where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cancel amm convs
	*/
	public static List<CancelAmmConv> findByAmmConvList(boolean cancellato,
		int start, int end, OrderByComparator<CancelAmmConv> orderByComparator) {
		return getPersistence()
				   .findByAmmConvList(cancellato, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cancel amm convs where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cancel amm convs
	*/
	public static List<CancelAmmConv> findByAmmConvList(boolean cancellato,
		int start, int end, OrderByComparator<CancelAmmConv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAmmConvList(cancellato, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel amm conv
	* @throws NoSuchCancelAmmConvException if a matching cancel amm conv could not be found
	*/
	public static CancelAmmConv findByAmmConvList_First(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelAmmConvException {
		return getPersistence()
				   .findByAmmConvList_First(cancellato, orderByComparator);
	}

	/**
	* Returns the first cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel amm conv, or <code>null</code> if a matching cancel amm conv could not be found
	*/
	public static CancelAmmConv fetchByAmmConvList_First(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator) {
		return getPersistence()
				   .fetchByAmmConvList_First(cancellato, orderByComparator);
	}

	/**
	* Returns the last cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel amm conv
	* @throws NoSuchCancelAmmConvException if a matching cancel amm conv could not be found
	*/
	public static CancelAmmConv findByAmmConvList_Last(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelAmmConvException {
		return getPersistence()
				   .findByAmmConvList_Last(cancellato, orderByComparator);
	}

	/**
	* Returns the last cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel amm conv, or <code>null</code> if a matching cancel amm conv could not be found
	*/
	public static CancelAmmConv fetchByAmmConvList_Last(boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator) {
		return getPersistence()
				   .fetchByAmmConvList_Last(cancellato, orderByComparator);
	}

	/**
	* Returns the cancel amm convs before and after the current cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param id_amministrazione_convocante the primary key of the current cancel amm conv
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cancel amm conv
	* @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	*/
	public static CancelAmmConv[] findByAmmConvList_PrevAndNext(
		long id_amministrazione_convocante, boolean cancellato,
		OrderByComparator<CancelAmmConv> orderByComparator)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelAmmConvException {
		return getPersistence()
				   .findByAmmConvList_PrevAndNext(id_amministrazione_convocante,
			cancellato, orderByComparator);
	}

	/**
	* Removes all the cancel amm convs where cancellato = &#63; from the database.
	*
	* @param cancellato the cancellato
	*/
	public static void removeByAmmConvList(boolean cancellato) {
		getPersistence().removeByAmmConvList(cancellato);
	}

	/**
	* Returns the number of cancel amm convs where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the number of matching cancel amm convs
	*/
	public static int countByAmmConvList(boolean cancellato) {
		return getPersistence().countByAmmConvList(cancellato);
	}

	/**
	* Caches the cancel amm conv in the entity cache if it is enabled.
	*
	* @param cancelAmmConv the cancel amm conv
	*/
	public static void cacheResult(CancelAmmConv cancelAmmConv) {
		getPersistence().cacheResult(cancelAmmConv);
	}

	/**
	* Caches the cancel amm convs in the entity cache if it is enabled.
	*
	* @param cancelAmmConvs the cancel amm convs
	*/
	public static void cacheResult(List<CancelAmmConv> cancelAmmConvs) {
		getPersistence().cacheResult(cancelAmmConvs);
	}

	/**
	* Creates a new cancel amm conv with the primary key. Does not add the cancel amm conv to the database.
	*
	* @param id_amministrazione_convocante the primary key for the new cancel amm conv
	* @return the new cancel amm conv
	*/
	public static CancelAmmConv create(long id_amministrazione_convocante) {
		return getPersistence().create(id_amministrazione_convocante);
	}

	/**
	* Removes the cancel amm conv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv that was removed
	* @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	*/
	public static CancelAmmConv remove(long id_amministrazione_convocante)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelAmmConvException {
		return getPersistence().remove(id_amministrazione_convocante);
	}

	public static CancelAmmConv updateImpl(CancelAmmConv cancelAmmConv) {
		return getPersistence().updateImpl(cancelAmmConv);
	}

	/**
	* Returns the cancel amm conv with the primary key or throws a {@link NoSuchCancelAmmConvException} if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv
	* @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	*/
	public static CancelAmmConv findByPrimaryKey(
		long id_amministrazione_convocante)
		throws com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelAmmConvException {
		return getPersistence().findByPrimaryKey(id_amministrazione_convocante);
	}

	/**
	* Returns the cancel amm conv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv, or <code>null</code> if a cancel amm conv with the primary key could not be found
	*/
	public static CancelAmmConv fetchByPrimaryKey(
		long id_amministrazione_convocante) {
		return getPersistence().fetchByPrimaryKey(id_amministrazione_convocante);
	}

	public static java.util.Map<java.io.Serializable, CancelAmmConv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the cancel amm convs.
	*
	* @return the cancel amm convs
	*/
	public static List<CancelAmmConv> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @return the range of cancel amm convs
	*/
	public static List<CancelAmmConv> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cancel amm convs
	*/
	public static List<CancelAmmConv> findAll(int start, int end,
		OrderByComparator<CancelAmmConv> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cancel amm convs
	*/
	public static List<CancelAmmConv> findAll(int start, int end,
		OrderByComparator<CancelAmmConv> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the cancel amm convs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cancel amm convs.
	*
	* @return the number of cancel amm convs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CancelAmmConvPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CancelAmmConvPersistence, CancelAmmConvPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CancelAmmConvPersistence.class);
}