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

package bookmarks.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Favourites. This utility wraps
 * {@link bookmarks.service.impl.FavouritesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesLocalService
 * @see bookmarks.service.base.FavouritesLocalServiceBaseImpl
 * @see bookmarks.service.impl.FavouritesLocalServiceImpl
 * @generated
 */
@ProviderType
public class FavouritesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link bookmarks.service.impl.FavouritesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the favourites to the database. Also notifies the appropriate model listeners.
	*
	* @param favourites the favourites
	* @return the favourites that was added
	*/
	public static bookmarks.model.Favourites addFavourites(
		bookmarks.model.Favourites favourites) {
		return getService().addFavourites(favourites);
	}

	/**
	* Creates a new favourites with the primary key. Does not add the favourites to the database.
	*
	* @param favourite_id the primary key for the new favourites
	* @return the new favourites
	*/
	public static bookmarks.model.Favourites createFavourites(long favourite_id) {
		return getService().createFavourites(favourite_id);
	}

	/**
	* Deletes the favourites from the database. Also notifies the appropriate model listeners.
	*
	* @param favourites the favourites
	* @return the favourites that was removed
	*/
	public static bookmarks.model.Favourites deleteFavourites(
		bookmarks.model.Favourites favourites) {
		return getService().deleteFavourites(favourites);
	}

	/**
	* Deletes the favourites with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites that was removed
	* @throws PortalException if a favourites with the primary key could not be found
	*/
	public static bookmarks.model.Favourites deleteFavourites(long favourite_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFavourites(favourite_id);
	}

	public static bookmarks.model.Favourites fetchFavourites(long favourite_id) {
		return getService().fetchFavourites(favourite_id);
	}

	/**
	* Returns the favourites with the primary key.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites
	* @throws PortalException if a favourites with the primary key could not be found
	*/
	public static bookmarks.model.Favourites getFavourites(long favourite_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFavourites(favourite_id);
	}

	/**
	* Updates the favourites in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param favourites the favourites
	* @return the favourites that was updated
	*/
	public static bookmarks.model.Favourites updateFavourites(
		bookmarks.model.Favourites favourites) {
		return getService().updateFavourites(favourites);
	}

	public static boolean checkBelongToFav(long user_id,
		java.lang.String friendlyUrl_page) {
		return getService().checkBelongToFav(user_id, friendlyUrl_page);
	}

	public static boolean deleteFavourite(long favourite_id) {
		return getService().deleteFavourite(favourite_id);
	}

	public static boolean setFavourite(long user_id,
		java.lang.String title_favourite,
		java.lang.String description_favourite, java.lang.String url_favourite,
		java.lang.String save_date) {
		return getService()
				   .setFavourite(user_id, title_favourite,
			description_favourite, url_favourite, save_date);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of favouriteses.
	*
	* @return the number of favouriteses
	*/
	public static int getFavouritesesCount() {
		return getService().getFavouritesesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bookmarks.model.impl.FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bookmarks.model.impl.FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<bookmarks.model.Favourites> getFavouritesByUser(
		long user_id) {
		return getService().getFavouritesByUser(user_id);
	}

	/**
	* Returns a range of all the favouriteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link bookmarks.model.impl.FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @return the range of favouriteses
	*/
	public static java.util.List<bookmarks.model.Favourites> getFavouriteses(
		int start, int end) {
		return getService().getFavouriteses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static long getFavByUrl(long user_id,
		java.lang.String friendlyUrl_page) {
		return getService().getFavByUrl(user_id, friendlyUrl_page);
	}

	public static FavouritesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FavouritesLocalService, FavouritesLocalService> _serviceTracker =
		ServiceTrackerFactory.open(FavouritesLocalService.class);
}