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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import bookmarks.model.Favourites;
import bookmarks.service.base.FavouritesLocalServiceBaseImpl;

/**
 * The implementation of the favourites local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link bookmarks.service.FavouritesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesLocalServiceBaseImpl
 * @see bookmarks.service.FavouritesLocalServiceUtil
 */
@ProviderType
public class FavouritesLocalServiceImpl extends FavouritesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link bookmarks.service.FavouritesLocalServiceUtil} to access the favourites local service.
	 */
	final Log _log = LogFactoryUtil.getLog(FavouritesLocalServiceImpl.class);
	
	@Override
    public List<Favourites> getFavouritesByUser(long user_id) {
		return this.favouritesPersistence.findByFavourites(user_id);
	}
	
	@Override
	public boolean setFavourite(long user_id, String title_favourite, String description_favourite, String url_favourite, String save_date) {
		
		//Long favourite_id = CounterLocalServiceUtil.increment(Favourites.class.getName());
		//_log.info("*********************Bookmark id : "+favourite_id);
//		Favourites fav = FavouritesPersistenceImpl.createFavourites(favourite_id);
		Favourites fav = favouritesPersistence.create(-1);
		//_log.info("create with : "+fav.getFavourite_id());
		fav.setUser_id(user_id);
		fav.setTitle_favourite(title_favourite);
		fav.setDescription_favourite(description_favourite);
		fav.setUrl_favourite(url_favourite);
		fav.setSave_date(save_date);
		
		if (getFavByUrl(user_id, url_favourite) == -1) {
//			FavouritesLocalServiceUtil.addFavourites(fav);
			//_log.info("Created "+fav.toString());
			favouritesPersistence.updateImpl(fav);
			//_log.info("Add");
			return true;
		}else {
			return false;
		} 
	}
	
	@Override
	public boolean deleteFavourite(long favourite_id) {
		
//		int favNumFirst = FavouritesLocalServiceUtil.getFavouritesesCount();
		int favNumFirst = favouritesPersistence.countAll();
		try {
//			FavouritesLocalServiceUtil.deleteFavourites(favourite_id);
			favouritesPersistence.remove(favourite_id);
		} catch (Exception e) {
			_log.warn(e);
		}
		
//		int favNumAfter = FavouritesLocalServiceUtil.getFavouritesesCount();
		int favNumAfter = favouritesPersistence.countAll();
		
		if (favNumAfter<favNumFirst) {
			return true;
		}else {
			return false;
		}		
	}
	
	@Override
	public boolean checkBelongToFav(long user_id, String friendlyUrl_page) {
//		List<Favourites> f = FavouritesLocalServiceUtil.getFavouritesByUser(user_id);
		List<Favourites> f = favouritesPersistence.findByFavourites(user_id);
		
		boolean r = false;
		for (Favourites j: f) {
			if (j.getUrl_favourite().equals(friendlyUrl_page)) {
				r = true;
			}
		}
		return r;
	}
	
	@Override
	public long getFavByUrl(long user_id, String friendlyUrl_page) {
//		List<Favourites> f = FavouritesLocalServiceUtil.getFavouritesByUser(user_id);
		List<Favourites> f = favouritesPersistence.findByFavourites(user_id);
		
		long favourite_id = -1; 
		
		for (Favourites j: f) {
			
			if (j.getUrl_favourite().equals(friendlyUrl_page)) {
				return j.getFavourite_id();
			}
		}
		return favourite_id;
	}

	
	
}

