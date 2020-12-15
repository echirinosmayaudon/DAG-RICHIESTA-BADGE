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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link FavouritesServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesServiceSoap
 * @see HttpPrincipal
 * @see FavouritesServiceUtil
 * @generated
 */
@ProviderType
public class FavouritesServiceHttp {
	public static java.util.List<bookmarks.model.Favourites> getFavouritesByUser(
		HttpPrincipal httpPrincipal, long user_id) {
		try {
			MethodKey methodKey = new MethodKey(FavouritesServiceUtil.class,
					"getFavouritesByUser", _getFavouritesByUserParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, user_id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<bookmarks.model.Favourites>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean setFavourite(HttpPrincipal httpPrincipal,
		long user_id, java.lang.String title_favourite,
		java.lang.String description_favourite, java.lang.String url_favourite,
		java.lang.String save_date) {
		try {
			MethodKey methodKey = new MethodKey(FavouritesServiceUtil.class,
					"setFavourite", _setFavouriteParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, user_id,
					title_favourite, description_favourite, url_favourite,
					save_date);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean deleteFavourite(HttpPrincipal httpPrincipal,
		long favourite_id) {
		try {
			MethodKey methodKey = new MethodKey(FavouritesServiceUtil.class,
					"deleteFavourite", _deleteFavouriteParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					favourite_id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean checkBelongToFav(HttpPrincipal httpPrincipal,
		long user_id, java.lang.String friendlyUrl_page) {
		try {
			MethodKey methodKey = new MethodKey(FavouritesServiceUtil.class,
					"checkBelongToFav", _checkBelongToFavParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, user_id,
					friendlyUrl_page);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static long getFavByUrl(HttpPrincipal httpPrincipal, long user_id,
		java.lang.String friendlyUrl_page) {
		try {
			MethodKey methodKey = new MethodKey(FavouritesServiceUtil.class,
					"getFavByUrl", _getFavByUrlParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, user_id,
					friendlyUrl_page);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FavouritesServiceHttp.class);
	private static final Class<?>[] _getFavouritesByUserParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _setFavouriteParameterTypes1 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _deleteFavouriteParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _checkBelongToFavParameterTypes3 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _getFavByUrlParameterTypes4 = new Class[] {
			long.class, java.lang.String.class
		};
}