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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FavouritesService}.
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesService
 * @generated
 */
@ProviderType
public class FavouritesServiceWrapper implements FavouritesService,
	ServiceWrapper<FavouritesService> {
	public FavouritesServiceWrapper(FavouritesService favouritesService) {
		_favouritesService = favouritesService;
	}

	@Override
	public boolean checkBelongToFav(long user_id,
		java.lang.String friendlyUrl_page) {
		return _favouritesService.checkBelongToFav(user_id, friendlyUrl_page);
	}

	@Override
	public boolean deleteFavourite(long favourite_id) {
		return _favouritesService.deleteFavourite(favourite_id);
	}

	@Override
	public boolean setFavourite(long user_id, java.lang.String title_favourite,
		java.lang.String description_favourite, java.lang.String url_favourite,
		java.lang.String save_date) {
		return _favouritesService.setFavourite(user_id, title_favourite,
			description_favourite, url_favourite, save_date);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _favouritesService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<bookmarks.model.Favourites> getFavouritesByUser(
		long user_id) {
		return _favouritesService.getFavouritesByUser(user_id);
	}

	@Override
	public long getFavByUrl(long user_id, java.lang.String friendlyUrl_page) {
		return _favouritesService.getFavByUrl(user_id, friendlyUrl_page);
	}

	@Override
	public FavouritesService getWrappedService() {
		return _favouritesService;
	}

	@Override
	public void setWrappedService(FavouritesService favouritesService) {
		_favouritesService = favouritesService;
	}

	private FavouritesService _favouritesService;
}