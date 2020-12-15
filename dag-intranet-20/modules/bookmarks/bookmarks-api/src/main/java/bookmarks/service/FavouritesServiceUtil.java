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
 * Provides the remote service utility for Favourites. This utility wraps
 * {@link bookmarks.service.impl.FavouritesServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesService
 * @see bookmarks.service.base.FavouritesServiceBaseImpl
 * @see bookmarks.service.impl.FavouritesServiceImpl
 * @generated
 */
@ProviderType
public class FavouritesServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link bookmarks.service.impl.FavouritesServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
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

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<bookmarks.model.Favourites> getFavouritesByUser(
		long user_id) {
		return getService().getFavouritesByUser(user_id);
	}

	public static long getFavByUrl(long user_id,
		java.lang.String friendlyUrl_page) {
		return getService().getFavByUrl(user_id, friendlyUrl_page);
	}

	public static FavouritesService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FavouritesService, FavouritesService> _serviceTracker =
		ServiceTrackerFactory.open(FavouritesService.class);
}