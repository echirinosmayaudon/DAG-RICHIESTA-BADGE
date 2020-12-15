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

package servizio.prenotazione.aule.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.prenotazione.aule.mef.model.StrumentoTec;

import java.util.List;

/**
 * The persistence utility for the strumento tec service. This utility wraps {@link servizio.prenotazione.aule.mef.service.persistence.impl.StrumentoTecPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTecPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.StrumentoTecPersistenceImpl
 * @generated
 */
@ProviderType
public class StrumentoTecUtil {
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
	public static void clearCache(StrumentoTec strumentoTec) {
		getPersistence().clearCache(strumentoTec);
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
	public static List<StrumentoTec> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StrumentoTec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StrumentoTec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StrumentoTec> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StrumentoTec update(StrumentoTec strumentoTec) {
		return getPersistence().update(strumentoTec);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StrumentoTec update(StrumentoTec strumentoTec,
		ServiceContext serviceContext) {
		return getPersistence().update(strumentoTec, serviceContext);
	}

	/**
	* Returns all the strumento tecs where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the matching strumento tecs
	*/
	public static List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento) {
		return getPersistence().findByDescStrumento(desc_strumento);
	}

	/**
	* Returns a range of all the strumento tecs where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @return the range of matching strumento tecs
	*/
	public static List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end) {
		return getPersistence().findByDescStrumento(desc_strumento, start, end);
	}

	/**
	* Returns an ordered range of all the strumento tecs where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching strumento tecs
	*/
	public static List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		OrderByComparator<StrumentoTec> orderByComparator) {
		return getPersistence()
				   .findByDescStrumento(desc_strumento, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the strumento tecs where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching strumento tecs
	*/
	public static List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		OrderByComparator<StrumentoTec> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDescStrumento(desc_strumento, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento tec
	* @throws NoSuchStrumentoTecException if a matching strumento tec could not be found
	*/
	public static StrumentoTec findByDescStrumento_First(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoTecException {
		return getPersistence()
				   .findByDescStrumento_First(desc_strumento, orderByComparator);
	}

	/**
	* Returns the first strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento tec, or <code>null</code> if a matching strumento tec could not be found
	*/
	public static StrumentoTec fetchByDescStrumento_First(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator) {
		return getPersistence()
				   .fetchByDescStrumento_First(desc_strumento, orderByComparator);
	}

	/**
	* Returns the last strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento tec
	* @throws NoSuchStrumentoTecException if a matching strumento tec could not be found
	*/
	public static StrumentoTec findByDescStrumento_Last(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoTecException {
		return getPersistence()
				   .findByDescStrumento_Last(desc_strumento, orderByComparator);
	}

	/**
	* Returns the last strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento tec, or <code>null</code> if a matching strumento tec could not be found
	*/
	public static StrumentoTec fetchByDescStrumento_Last(
		java.lang.String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator) {
		return getPersistence()
				   .fetchByDescStrumento_Last(desc_strumento, orderByComparator);
	}

	/**
	* Returns the strumento tecs before and after the current strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param id_strumento the primary key of the current strumento tec
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next strumento tec
	* @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	*/
	public static StrumentoTec[] findByDescStrumento_PrevAndNext(
		long id_strumento, java.lang.String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoTecException {
		return getPersistence()
				   .findByDescStrumento_PrevAndNext(id_strumento,
			desc_strumento, orderByComparator);
	}

	/**
	* Removes all the strumento tecs where desc_strumento = &#63; from the database.
	*
	* @param desc_strumento the desc_strumento
	*/
	public static void removeByDescStrumento(java.lang.String desc_strumento) {
		getPersistence().removeByDescStrumento(desc_strumento);
	}

	/**
	* Returns the number of strumento tecs where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the number of matching strumento tecs
	*/
	public static int countByDescStrumento(java.lang.String desc_strumento) {
		return getPersistence().countByDescStrumento(desc_strumento);
	}

	/**
	* Caches the strumento tec in the entity cache if it is enabled.
	*
	* @param strumentoTec the strumento tec
	*/
	public static void cacheResult(StrumentoTec strumentoTec) {
		getPersistence().cacheResult(strumentoTec);
	}

	/**
	* Caches the strumento tecs in the entity cache if it is enabled.
	*
	* @param strumentoTecs the strumento tecs
	*/
	public static void cacheResult(List<StrumentoTec> strumentoTecs) {
		getPersistence().cacheResult(strumentoTecs);
	}

	/**
	* Creates a new strumento tec with the primary key. Does not add the strumento tec to the database.
	*
	* @param id_strumento the primary key for the new strumento tec
	* @return the new strumento tec
	*/
	public static StrumentoTec create(long id_strumento) {
		return getPersistence().create(id_strumento);
	}

	/**
	* Removes the strumento tec with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec that was removed
	* @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	*/
	public static StrumentoTec remove(long id_strumento)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoTecException {
		return getPersistence().remove(id_strumento);
	}

	public static StrumentoTec updateImpl(StrumentoTec strumentoTec) {
		return getPersistence().updateImpl(strumentoTec);
	}

	/**
	* Returns the strumento tec with the primary key or throws a {@link NoSuchStrumentoTecException} if it could not be found.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec
	* @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	*/
	public static StrumentoTec findByPrimaryKey(long id_strumento)
		throws servizio.prenotazione.aule.mef.exception.NoSuchStrumentoTecException {
		return getPersistence().findByPrimaryKey(id_strumento);
	}

	/**
	* Returns the strumento tec with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec, or <code>null</code> if a strumento tec with the primary key could not be found
	*/
	public static StrumentoTec fetchByPrimaryKey(long id_strumento) {
		return getPersistence().fetchByPrimaryKey(id_strumento);
	}

	public static java.util.Map<java.io.Serializable, StrumentoTec> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the strumento tecs.
	*
	* @return the strumento tecs
	*/
	public static List<StrumentoTec> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the strumento tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @return the range of strumento tecs
	*/
	public static List<StrumentoTec> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the strumento tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strumento tecs
	*/
	public static List<StrumentoTec> findAll(int start, int end,
		OrderByComparator<StrumentoTec> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the strumento tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strumento tecs
	*/
	public static List<StrumentoTec> findAll(int start, int end,
		OrderByComparator<StrumentoTec> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the strumento tecs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of strumento tecs.
	*
	* @return the number of strumento tecs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StrumentoTecPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StrumentoTecPersistence, StrumentoTecPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StrumentoTecPersistence.class);
}