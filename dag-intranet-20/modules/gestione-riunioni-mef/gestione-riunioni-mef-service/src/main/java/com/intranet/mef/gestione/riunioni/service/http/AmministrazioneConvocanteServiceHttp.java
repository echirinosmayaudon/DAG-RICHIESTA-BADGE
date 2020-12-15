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

package com.intranet.mef.gestione.riunioni.service.http;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link AmministrazioneConvocanteServiceUtil} service utility. The
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
 * @see AmministrazioneConvocanteServiceSoap
 * @see HttpPrincipal
 * @see AmministrazioneConvocanteServiceUtil
 * @generated
 */
@ProviderType
public class AmministrazioneConvocanteServiceHttp {
	public static boolean setAmministrazioneConvocante(
		HttpPrincipal httpPrincipal, java.lang.String nome_amministrazione) {
		try {
			MethodKey methodKey = new MethodKey(AmministrazioneConvocanteServiceUtil.class,
					"setAmministrazioneConvocante",
					_setAmministrazioneConvocanteParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					nome_amministrazione);

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

	public static java.util.List<com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante> findByKeywordAdmin(
		HttpPrincipal httpPrincipal, java.lang.String keyword) {
		try {
			MethodKey methodKey = new MethodKey(AmministrazioneConvocanteServiceUtil.class,
					"findByKeywordAdmin", _findByKeywordAdminParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, keyword);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AmministrazioneConvocanteServiceHttp.class);
	private static final Class<?>[] _setAmministrazioneConvocanteParameterTypes0 =
		new Class[] { java.lang.String.class };
	private static final Class<?>[] _findByKeywordAdminParameterTypes1 = new Class[] {
			java.lang.String.class
		};
}