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

package bookmarks.service.http;

import aQute.bnd.annotation.ProviderType;

import bookmarks.service.FavouritesServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link FavouritesServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link bookmarks.model.FavouritesSoap}.
 * If the method in the service utility returns a
 * {@link bookmarks.model.Favourites}, that is translated to a
 * {@link bookmarks.model.FavouritesSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesServiceHttp
 * @see bookmarks.model.FavouritesSoap
 * @see FavouritesServiceUtil
 * @generated
 */
@ProviderType
public class FavouritesServiceSoap {
	public static bookmarks.model.FavouritesSoap[] getFavouritesByUser(
		long user_id) throws RemoteException {
		try {
			java.util.List<bookmarks.model.Favourites> returnValue = FavouritesServiceUtil.getFavouritesByUser(user_id);

			return bookmarks.model.FavouritesSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean setFavourite(long user_id,
		java.lang.String title_favourite,
		java.lang.String description_favourite, java.lang.String url_favourite,
		java.lang.String save_date) throws RemoteException {
		try {
			boolean returnValue = FavouritesServiceUtil.setFavourite(user_id,
					title_favourite, description_favourite, url_favourite,
					save_date);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean deleteFavourite(long favourite_id)
		throws RemoteException {
		try {
			boolean returnValue = FavouritesServiceUtil.deleteFavourite(favourite_id);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean checkBelongToFav(long user_id,
		java.lang.String friendlyUrl_page) throws RemoteException {
		try {
			boolean returnValue = FavouritesServiceUtil.checkBelongToFav(user_id,
					friendlyUrl_page);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getFavByUrl(long user_id,
		java.lang.String friendlyUrl_page) throws RemoteException {
		try {
			long returnValue = FavouritesServiceUtil.getFavByUrl(user_id,
					friendlyUrl_page);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FavouritesServiceSoap.class);
}