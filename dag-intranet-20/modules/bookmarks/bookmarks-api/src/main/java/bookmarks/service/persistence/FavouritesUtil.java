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

package bookmarks.service.persistence;

import aQute.bnd.annotation.ProviderType;

import bookmarks.model.Favourites;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the favourites service. This utility wraps {@link bookmarks.service.persistence.impl.FavouritesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesPersistence
 * @see bookmarks.service.persistence.impl.FavouritesPersistenceImpl
 * @generated
 */
@ProviderType
public class FavouritesUtil {
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
	public static void clearCache(Favourites favourites) {
		getPersistence().clearCache(favourites);
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
	public static List<Favourites> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Favourites> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Favourites> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Favourites> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Favourites update(Favourites favourites) {
		return getPersistence().update(favourites);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Favourites update(Favourites favourites,
		ServiceContext serviceContext) {
		return getPersistence().update(favourites, serviceContext);
	}

	/**
	* Returns all the favouriteses where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching favouriteses
	*/
	public static List<Favourites> findByFavourites(long user_id) {
		return getPersistence().findByFavourites(user_id);
	}

	/**
	* Returns a range of all the favouriteses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @return the range of matching favouriteses
	*/
	public static List<Favourites> findByFavourites(long user_id, int start,
		int end) {
		return getPersistence().findByFavourites(user_id, start, end);
	}

	/**
	* Returns an ordered range of all the favouriteses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching favouriteses
	*/
	public static List<Favourites> findByFavourites(long user_id, int start,
		int end, OrderByComparator<Favourites> orderByComparator) {
		return getPersistence()
				   .findByFavourites(user_id, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the favouriteses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching favouriteses
	*/
	public static List<Favourites> findByFavourites(long user_id, int start,
		int end, OrderByComparator<Favourites> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFavourites(user_id, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favourites
	* @throws NoSuchFavouritesException if a matching favourites could not be found
	*/
	public static Favourites findByFavourites_First(long user_id,
		OrderByComparator<Favourites> orderByComparator)
		throws bookmarks.exception.NoSuchFavouritesException {
		return getPersistence()
				   .findByFavourites_First(user_id, orderByComparator);
	}

	/**
	* Returns the first favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favourites, or <code>null</code> if a matching favourites could not be found
	*/
	public static Favourites fetchByFavourites_First(long user_id,
		OrderByComparator<Favourites> orderByComparator) {
		return getPersistence()
				   .fetchByFavourites_First(user_id, orderByComparator);
	}

	/**
	* Returns the last favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favourites
	* @throws NoSuchFavouritesException if a matching favourites could not be found
	*/
	public static Favourites findByFavourites_Last(long user_id,
		OrderByComparator<Favourites> orderByComparator)
		throws bookmarks.exception.NoSuchFavouritesException {
		return getPersistence().findByFavourites_Last(user_id, orderByComparator);
	}

	/**
	* Returns the last favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favourites, or <code>null</code> if a matching favourites could not be found
	*/
	public static Favourites fetchByFavourites_Last(long user_id,
		OrderByComparator<Favourites> orderByComparator) {
		return getPersistence()
				   .fetchByFavourites_Last(user_id, orderByComparator);
	}

	/**
	* Returns the favouriteses before and after the current favourites in the ordered set where user_id = &#63;.
	*
	* @param favourite_id the primary key of the current favourites
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next favourites
	* @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	*/
	public static Favourites[] findByFavourites_PrevAndNext(long favourite_id,
		long user_id, OrderByComparator<Favourites> orderByComparator)
		throws bookmarks.exception.NoSuchFavouritesException {
		return getPersistence()
				   .findByFavourites_PrevAndNext(favourite_id, user_id,
			orderByComparator);
	}

	/**
	* Removes all the favouriteses where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	*/
	public static void removeByFavourites(long user_id) {
		getPersistence().removeByFavourites(user_id);
	}

	/**
	* Returns the number of favouriteses where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching favouriteses
	*/
	public static int countByFavourites(long user_id) {
		return getPersistence().countByFavourites(user_id);
	}

	/**
	* Caches the favourites in the entity cache if it is enabled.
	*
	* @param favourites the favourites
	*/
	public static void cacheResult(Favourites favourites) {
		getPersistence().cacheResult(favourites);
	}

	/**
	* Caches the favouriteses in the entity cache if it is enabled.
	*
	* @param favouriteses the favouriteses
	*/
	public static void cacheResult(List<Favourites> favouriteses) {
		getPersistence().cacheResult(favouriteses);
	}

	/**
	* Creates a new favourites with the primary key. Does not add the favourites to the database.
	*
	* @param favourite_id the primary key for the new favourites
	* @return the new favourites
	*/
	public static Favourites create(long favourite_id) {
		return getPersistence().create(favourite_id);
	}

	/**
	* Removes the favourites with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites that was removed
	* @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	*/
	public static Favourites remove(long favourite_id)
		throws bookmarks.exception.NoSuchFavouritesException {
		return getPersistence().remove(favourite_id);
	}

	public static Favourites updateImpl(Favourites favourites) {
		return getPersistence().updateImpl(favourites);
	}

	/**
	* Returns the favourites with the primary key or throws a {@link NoSuchFavouritesException} if it could not be found.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites
	* @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	*/
	public static Favourites findByPrimaryKey(long favourite_id)
		throws bookmarks.exception.NoSuchFavouritesException {
		return getPersistence().findByPrimaryKey(favourite_id);
	}

	/**
	* Returns the favourites with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites, or <code>null</code> if a favourites with the primary key could not be found
	*/
	public static Favourites fetchByPrimaryKey(long favourite_id) {
		return getPersistence().fetchByPrimaryKey(favourite_id);
	}

	public static java.util.Map<java.io.Serializable, Favourites> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the favouriteses.
	*
	* @return the favouriteses
	*/
	public static List<Favourites> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the favouriteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @return the range of favouriteses
	*/
	public static List<Favourites> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the favouriteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of favouriteses
	*/
	public static List<Favourites> findAll(int start, int end,
		OrderByComparator<Favourites> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the favouriteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of favouriteses
	*/
	public static List<Favourites> findAll(int start, int end,
		OrderByComparator<Favourites> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the favouriteses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of favouriteses.
	*
	* @return the number of favouriteses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FavouritesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FavouritesPersistence, FavouritesPersistence> _serviceTracker =
		ServiceTrackerFactory.open(FavouritesPersistence.class);
}