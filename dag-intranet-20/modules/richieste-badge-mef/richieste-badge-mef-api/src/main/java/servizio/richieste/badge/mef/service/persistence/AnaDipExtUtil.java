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

package servizio.richieste.badge.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import servizio.richieste.badge.mef.model.AnaDipExt;

import java.util.List;

/**
 * The persistence utility for the ana dip ext service. This utility wraps {@link servizio.richieste.badge.mef.service.persistence.impl.AnaDipExtPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnaDipExtPersistence
 * @see servizio.richieste.badge.mef.service.persistence.impl.AnaDipExtPersistenceImpl
 * @generated
 */
@ProviderType
public class AnaDipExtUtil {
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
	public static void clearCache(AnaDipExt anaDipExt) {
		getPersistence().clearCache(anaDipExt);
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
	public static List<AnaDipExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnaDipExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnaDipExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnaDipExt> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnaDipExt update(AnaDipExt anaDipExt) {
		return getPersistence().update(anaDipExt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnaDipExt update(AnaDipExt anaDipExt,
		ServiceContext serviceContext) {
		return getPersistence().update(anaDipExt, serviceContext);
	}

	/**
	* Returns all the ana dip exts where cf_dip_ext = &#63;.
	*
	* @param cf_dip_ext the cf_dip_ext
	* @return the matching ana dip exts
	*/
	public static List<AnaDipExt> findByCodiceFiscaleEsterno(
		java.lang.String cf_dip_ext) {
		return getPersistence().findByCodiceFiscaleEsterno(cf_dip_ext);
	}

	/**
	* Returns a range of all the ana dip exts where cf_dip_ext = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cf_dip_ext the cf_dip_ext
	* @param start the lower bound of the range of ana dip exts
	* @param end the upper bound of the range of ana dip exts (not inclusive)
	* @return the range of matching ana dip exts
	*/
	public static List<AnaDipExt> findByCodiceFiscaleEsterno(
		java.lang.String cf_dip_ext, int start, int end) {
		return getPersistence()
				   .findByCodiceFiscaleEsterno(cf_dip_ext, start, end);
	}

	/**
	* Returns an ordered range of all the ana dip exts where cf_dip_ext = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cf_dip_ext the cf_dip_ext
	* @param start the lower bound of the range of ana dip exts
	* @param end the upper bound of the range of ana dip exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ana dip exts
	*/
	public static List<AnaDipExt> findByCodiceFiscaleEsterno(
		java.lang.String cf_dip_ext, int start, int end,
		OrderByComparator<AnaDipExt> orderByComparator) {
		return getPersistence()
				   .findByCodiceFiscaleEsterno(cf_dip_ext, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the ana dip exts where cf_dip_ext = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cf_dip_ext the cf_dip_ext
	* @param start the lower bound of the range of ana dip exts
	* @param end the upper bound of the range of ana dip exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ana dip exts
	*/
	public static List<AnaDipExt> findByCodiceFiscaleEsterno(
		java.lang.String cf_dip_ext, int start, int end,
		OrderByComparator<AnaDipExt> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCodiceFiscaleEsterno(cf_dip_ext, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ana dip ext in the ordered set where cf_dip_ext = &#63;.
	*
	* @param cf_dip_ext the cf_dip_ext
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ana dip ext
	* @throws NoSuchAnaDipExtException if a matching ana dip ext could not be found
	*/
	public static AnaDipExt findByCodiceFiscaleEsterno_First(
		java.lang.String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchAnaDipExtException {
		return getPersistence()
				   .findByCodiceFiscaleEsterno_First(cf_dip_ext,
			orderByComparator);
	}

	/**
	* Returns the first ana dip ext in the ordered set where cf_dip_ext = &#63;.
	*
	* @param cf_dip_ext the cf_dip_ext
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ana dip ext, or <code>null</code> if a matching ana dip ext could not be found
	*/
	public static AnaDipExt fetchByCodiceFiscaleEsterno_First(
		java.lang.String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator) {
		return getPersistence()
				   .fetchByCodiceFiscaleEsterno_First(cf_dip_ext,
			orderByComparator);
	}

	/**
	* Returns the last ana dip ext in the ordered set where cf_dip_ext = &#63;.
	*
	* @param cf_dip_ext the cf_dip_ext
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ana dip ext
	* @throws NoSuchAnaDipExtException if a matching ana dip ext could not be found
	*/
	public static AnaDipExt findByCodiceFiscaleEsterno_Last(
		java.lang.String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchAnaDipExtException {
		return getPersistence()
				   .findByCodiceFiscaleEsterno_Last(cf_dip_ext,
			orderByComparator);
	}

	/**
	* Returns the last ana dip ext in the ordered set where cf_dip_ext = &#63;.
	*
	* @param cf_dip_ext the cf_dip_ext
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ana dip ext, or <code>null</code> if a matching ana dip ext could not be found
	*/
	public static AnaDipExt fetchByCodiceFiscaleEsterno_Last(
		java.lang.String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator) {
		return getPersistence()
				   .fetchByCodiceFiscaleEsterno_Last(cf_dip_ext,
			orderByComparator);
	}

	/**
	* Returns the ana dip exts before and after the current ana dip ext in the ordered set where cf_dip_ext = &#63;.
	*
	* @param id_dip_ext the primary key of the current ana dip ext
	* @param cf_dip_ext the cf_dip_ext
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ana dip ext
	* @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	*/
	public static AnaDipExt[] findByCodiceFiscaleEsterno_PrevAndNext(
		long id_dip_ext, java.lang.String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator)
		throws servizio.richieste.badge.mef.exception.NoSuchAnaDipExtException {
		return getPersistence()
				   .findByCodiceFiscaleEsterno_PrevAndNext(id_dip_ext,
			cf_dip_ext, orderByComparator);
	}

	/**
	* Removes all the ana dip exts where cf_dip_ext = &#63; from the database.
	*
	* @param cf_dip_ext the cf_dip_ext
	*/
	public static void removeByCodiceFiscaleEsterno(java.lang.String cf_dip_ext) {
		getPersistence().removeByCodiceFiscaleEsterno(cf_dip_ext);
	}

	/**
	* Returns the number of ana dip exts where cf_dip_ext = &#63;.
	*
	* @param cf_dip_ext the cf_dip_ext
	* @return the number of matching ana dip exts
	*/
	public static int countByCodiceFiscaleEsterno(java.lang.String cf_dip_ext) {
		return getPersistence().countByCodiceFiscaleEsterno(cf_dip_ext);
	}

	/**
	* Caches the ana dip ext in the entity cache if it is enabled.
	*
	* @param anaDipExt the ana dip ext
	*/
	public static void cacheResult(AnaDipExt anaDipExt) {
		getPersistence().cacheResult(anaDipExt);
	}

	/**
	* Caches the ana dip exts in the entity cache if it is enabled.
	*
	* @param anaDipExts the ana dip exts
	*/
	public static void cacheResult(List<AnaDipExt> anaDipExts) {
		getPersistence().cacheResult(anaDipExts);
	}

	/**
	* Creates a new ana dip ext with the primary key. Does not add the ana dip ext to the database.
	*
	* @param id_dip_ext the primary key for the new ana dip ext
	* @return the new ana dip ext
	*/
	public static AnaDipExt create(long id_dip_ext) {
		return getPersistence().create(id_dip_ext);
	}

	/**
	* Removes the ana dip ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_dip_ext the primary key of the ana dip ext
	* @return the ana dip ext that was removed
	* @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	*/
	public static AnaDipExt remove(long id_dip_ext)
		throws servizio.richieste.badge.mef.exception.NoSuchAnaDipExtException {
		return getPersistence().remove(id_dip_ext);
	}

	public static AnaDipExt updateImpl(AnaDipExt anaDipExt) {
		return getPersistence().updateImpl(anaDipExt);
	}

	/**
	* Returns the ana dip ext with the primary key or throws a {@link NoSuchAnaDipExtException} if it could not be found.
	*
	* @param id_dip_ext the primary key of the ana dip ext
	* @return the ana dip ext
	* @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	*/
	public static AnaDipExt findByPrimaryKey(long id_dip_ext)
		throws servizio.richieste.badge.mef.exception.NoSuchAnaDipExtException {
		return getPersistence().findByPrimaryKey(id_dip_ext);
	}

	/**
	* Returns the ana dip ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_dip_ext the primary key of the ana dip ext
	* @return the ana dip ext, or <code>null</code> if a ana dip ext with the primary key could not be found
	*/
	public static AnaDipExt fetchByPrimaryKey(long id_dip_ext) {
		return getPersistence().fetchByPrimaryKey(id_dip_ext);
	}

	public static java.util.Map<java.io.Serializable, AnaDipExt> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ana dip exts.
	*
	* @return the ana dip exts
	*/
	public static List<AnaDipExt> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ana dip exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ana dip exts
	* @param end the upper bound of the range of ana dip exts (not inclusive)
	* @return the range of ana dip exts
	*/
	public static List<AnaDipExt> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ana dip exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ana dip exts
	* @param end the upper bound of the range of ana dip exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ana dip exts
	*/
	public static List<AnaDipExt> findAll(int start, int end,
		OrderByComparator<AnaDipExt> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ana dip exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ana dip exts
	* @param end the upper bound of the range of ana dip exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ana dip exts
	*/
	public static List<AnaDipExt> findAll(int start, int end,
		OrderByComparator<AnaDipExt> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ana dip exts from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ana dip exts.
	*
	* @return the number of ana dip exts
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnaDipExtPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnaDipExtPersistence, AnaDipExtPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AnaDipExtPersistence.class);
}