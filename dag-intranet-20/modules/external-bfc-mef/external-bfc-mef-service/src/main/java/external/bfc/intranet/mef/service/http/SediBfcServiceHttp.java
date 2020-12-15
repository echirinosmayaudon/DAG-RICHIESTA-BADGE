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

package external.bfc.intranet.mef.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import external.bfc.intranet.mef.service.SediBfcServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link SediBfcServiceUtil} service utility. The
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
 * @see SediBfcServiceSoap
 * @see HttpPrincipal
 * @see SediBfcServiceUtil
 * @generated
 */
@ProviderType
public class SediBfcServiceHttp {
	public static java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv2AndFlagApp(
		HttpPrincipal httpPrincipal, long id_org_liv2, boolean flag_app) {
		try {
			MethodKey methodKey = new MethodKey(SediBfcServiceUtil.class,
					"getSediBfcByIdOrgLiv2AndFlagApp",
					_getSediBfcByIdOrgLiv2AndFlagAppParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					id_org_liv2, flag_app);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<external.bfc.intranet.mef.model.SediBfc>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv3AndFlagApp(
		HttpPrincipal httpPrincipal, long id_org_liv3, boolean flag_app) {
		try {
			MethodKey methodKey = new MethodKey(SediBfcServiceUtil.class,
					"getSediBfcByIdOrgLiv3AndFlagApp",
					_getSediBfcByIdOrgLiv3AndFlagAppParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					id_org_liv3, flag_app);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<external.bfc.intranet.mef.model.SediBfc>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SediBfcServiceHttp.class);
	private static final Class<?>[] _getSediBfcByIdOrgLiv2AndFlagAppParameterTypes0 =
		new Class[] { long.class, boolean.class };
	private static final Class<?>[] _getSediBfcByIdOrgLiv3AndFlagAppParameterTypes1 =
		new Class[] { long.class, boolean.class };
}