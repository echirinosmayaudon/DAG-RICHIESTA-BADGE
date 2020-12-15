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

package autorizzazione.dir.mef.service.http;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.service.ScrivaniaServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link ScrivaniaServiceUtil} service utility. The
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
 * @see ScrivaniaServiceSoap
 * @see HttpPrincipal
 * @see ScrivaniaServiceUtil
 * @generated
 */
@ProviderType
public class ScrivaniaServiceHttp {
	public static boolean addAppToHome(HttpPrincipal httpPrincipal,
		long userId, long applicationId) {
		try {
			MethodKey methodKey = new MethodKey(ScrivaniaServiceUtil.class,
					"addAppToHome", _addAppToHomeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					applicationId);

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

	public static boolean addAppToProfile(HttpPrincipal httpPrincipal,
		long userId, long applicationId) {
		try {
			MethodKey methodKey = new MethodKey(ScrivaniaServiceUtil.class,
					"addAppToProfile", _addAppToProfileParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					applicationId);

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

	public static boolean removeAppFromHome(HttpPrincipal httpPrincipal,
		long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		try {
			MethodKey methodKey = new MethodKey(ScrivaniaServiceUtil.class,
					"removeAppFromHome", _removeAppFromHomeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					applicationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof autorizzazione.dir.mef.exception.NoSuchScrivaniaException) {
					throw (autorizzazione.dir.mef.exception.NoSuchScrivaniaException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean removeAppFromProfile(HttpPrincipal httpPrincipal,
		long userId, long applicationId)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		try {
			MethodKey methodKey = new MethodKey(ScrivaniaServiceUtil.class,
					"removeAppFromProfile", _removeAppFromProfileParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					applicationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof autorizzazione.dir.mef.exception.NoSuchScrivaniaException) {
					throw (autorizzazione.dir.mef.exception.NoSuchScrivaniaException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getHomeApps(HttpPrincipal httpPrincipal,
		long userId) {
		try {
			MethodKey methodKey = new MethodKey(ScrivaniaServiceUtil.class,
					"getHomeApps", _getHomeAppsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getProfileApps(HttpPrincipal httpPrincipal,
		long userId) {
		try {
			MethodKey methodKey = new MethodKey(ScrivaniaServiceUtil.class,
					"getProfileApps", _getProfileAppsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ScrivaniaServiceHttp.class);
	private static final Class<?>[] _addAppToHomeParameterTypes0 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _addAppToProfileParameterTypes1 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _removeAppFromHomeParameterTypes2 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _removeAppFromProfileParameterTypes3 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getHomeAppsParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getProfileAppsParameterTypes5 = new Class[] {
			long.class
		};
}