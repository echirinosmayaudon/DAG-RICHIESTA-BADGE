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

package bookmarks.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import bookmarks.model.Favourites;
import bookmarks.model.FavouritesModel;
import bookmarks.service.FavouritesLocalServiceUtil;
import bookmarks.service.base.FavouritesServiceBaseImpl;
import bookmarks.service.*;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * The implementation of the favourites remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link bookmarks.service.FavouritesService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesServiceBaseImpl
 * @see bookmarks.service.FavouritesServiceUtil
 */
@JSONWebService
@ProviderType
public class FavouritesServiceImpl extends FavouritesServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link bookmarks.service.FavouritesServiceUtil} to access the favourites remote service.
	 */
	
	@Override
	public List<bookmarks.model.Favourites> getFavouritesByUser(long user_id)  {
		
		return FavouritesLocalServiceUtil.getFavouritesByUser(user_id);

	}
	
	@Override
	public boolean setFavourite(long user_id, String title_favourite, String description_favourite, String url_favourite, String save_date) {
		
		return FavouritesLocalServiceUtil.setFavourite(user_id, title_favourite, description_favourite, url_favourite, save_date);

	}
	
	@Override
	public boolean deleteFavourite(long favourite_id) {
		
			return FavouritesLocalServiceUtil.deleteFavourite(favourite_id);
	}
	
	@Override
	public boolean checkBelongToFav(long user_id, String friendlyUrl_page) {
		return FavouritesLocalServiceUtil.checkBelongToFav(user_id, friendlyUrl_page);
	}
	
	@Override
	public long getFavByUrl(long user_id, String friendlyUrl_page) {
		return FavouritesLocalServiceUtil.getFavByUrl(user_id, friendlyUrl_page);
	}
	
}