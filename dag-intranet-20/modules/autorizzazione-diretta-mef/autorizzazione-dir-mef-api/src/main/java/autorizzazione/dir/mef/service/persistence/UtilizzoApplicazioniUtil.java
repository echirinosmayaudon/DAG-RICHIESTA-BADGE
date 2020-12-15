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

package autorizzazione.dir.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.model.UtilizzoApplicazioni;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the utilizzo applicazioni service. This utility wraps {@link autorizzazione.dir.mef.service.persistence.impl.UtilizzoApplicazioniPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioniPersistence
 * @see autorizzazione.dir.mef.service.persistence.impl.UtilizzoApplicazioniPersistenceImpl
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniUtil {
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
	public static void clearCache(UtilizzoApplicazioni utilizzoApplicazioni) {
		getPersistence().clearCache(utilizzoApplicazioni);
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
	public static List<UtilizzoApplicazioni> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UtilizzoApplicazioni> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UtilizzoApplicazioni> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UtilizzoApplicazioni update(
		UtilizzoApplicazioni utilizzoApplicazioni) {
		return getPersistence().update(utilizzoApplicazioni);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UtilizzoApplicazioni update(
		UtilizzoApplicazioni utilizzoApplicazioni, ServiceContext serviceContext) {
		return getPersistence().update(utilizzoApplicazioni, serviceContext);
	}

	/**
	* Returns all the utilizzo applicazionis where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the utilizzo applicazionis where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @return the range of matching utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findByUserId(long userId,
		int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the utilizzo applicazionis where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findByUserId(long userId,
		int start, int end,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the utilizzo applicazionis where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findByUserId(long userId,
		int start, int end,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a matching utilizzo applicazioni could not be found
	*/
	public static UtilizzoApplicazioni findByUserId_First(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchUtilizzoApplicazioniException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching utilizzo applicazioni, or <code>null</code> if a matching utilizzo applicazioni could not be found
	*/
	public static UtilizzoApplicazioni fetchByUserId_First(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a matching utilizzo applicazioni could not be found
	*/
	public static UtilizzoApplicazioni findByUserId_Last(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchUtilizzoApplicazioniException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching utilizzo applicazioni, or <code>null</code> if a matching utilizzo applicazioni could not be found
	*/
	public static UtilizzoApplicazioni fetchByUserId_Last(long userId,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the utilizzo applicazionis before and after the current utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param utilizzoApplicazioniPK the primary key of the current utilizzo applicazioni
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	*/
	public static UtilizzoApplicazioni[] findByUserId_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK,
		long userId, OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchUtilizzoApplicazioniException {
		return getPersistence()
				   .findByUserId_PrevAndNext(utilizzoApplicazioniPK, userId,
			orderByComparator);
	}

	/**
	* Removes all the utilizzo applicazionis where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of utilizzo applicazionis where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching utilizzo applicazionis
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the utilizzo applicazioni in the entity cache if it is enabled.
	*
	* @param utilizzoApplicazioni the utilizzo applicazioni
	*/
	public static void cacheResult(UtilizzoApplicazioni utilizzoApplicazioni) {
		getPersistence().cacheResult(utilizzoApplicazioni);
	}

	/**
	* Caches the utilizzo applicazionis in the entity cache if it is enabled.
	*
	* @param utilizzoApplicazionis the utilizzo applicazionis
	*/
	public static void cacheResult(
		List<UtilizzoApplicazioni> utilizzoApplicazionis) {
		getPersistence().cacheResult(utilizzoApplicazionis);
	}

	/**
	* Creates a new utilizzo applicazioni with the primary key. Does not add the utilizzo applicazioni to the database.
	*
	* @param utilizzoApplicazioniPK the primary key for the new utilizzo applicazioni
	* @return the new utilizzo applicazioni
	*/
	public static UtilizzoApplicazioni create(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK) {
		return getPersistence().create(utilizzoApplicazioniPK);
	}

	/**
	* Removes the utilizzo applicazioni with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni that was removed
	* @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	*/
	public static UtilizzoApplicazioni remove(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws autorizzazione.dir.mef.exception.NoSuchUtilizzoApplicazioniException {
		return getPersistence().remove(utilizzoApplicazioniPK);
	}

	public static UtilizzoApplicazioni updateImpl(
		UtilizzoApplicazioni utilizzoApplicazioni) {
		return getPersistence().updateImpl(utilizzoApplicazioni);
	}

	/**
	* Returns the utilizzo applicazioni with the primary key or throws a {@link NoSuchUtilizzoApplicazioniException} if it could not be found.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	*/
	public static UtilizzoApplicazioni findByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws autorizzazione.dir.mef.exception.NoSuchUtilizzoApplicazioniException {
		return getPersistence().findByPrimaryKey(utilizzoApplicazioniPK);
	}

	/**
	* Returns the utilizzo applicazioni with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni, or <code>null</code> if a utilizzo applicazioni with the primary key could not be found
	*/
	public static UtilizzoApplicazioni fetchByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK) {
		return getPersistence().fetchByPrimaryKey(utilizzoApplicazioniPK);
	}

	public static java.util.Map<java.io.Serializable, UtilizzoApplicazioni> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the utilizzo applicazionis.
	*
	* @return the utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the utilizzo applicazionis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @return the range of utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the utilizzo applicazionis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findAll(int start, int end,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the utilizzo applicazionis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of utilizzo applicazionis
	*/
	public static List<UtilizzoApplicazioni> findAll(int start, int end,
		OrderByComparator<UtilizzoApplicazioni> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the utilizzo applicazionis from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of utilizzo applicazionis.
	*
	* @return the number of utilizzo applicazionis
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UtilizzoApplicazioniPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UtilizzoApplicazioniPersistence, UtilizzoApplicazioniPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UtilizzoApplicazioniPersistence.class);
}