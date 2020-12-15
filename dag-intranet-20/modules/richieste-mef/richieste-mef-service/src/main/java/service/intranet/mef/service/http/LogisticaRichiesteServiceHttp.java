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

package service.intranet.mef.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import service.intranet.mef.service.LogisticaRichiesteServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link LogisticaRichiesteServiceUtil} service utility. The
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
 * @see LogisticaRichiesteServiceSoap
 * @see HttpPrincipal
 * @see LogisticaRichiesteServiceUtil
 * @generated
 */
@ProviderType
public class LogisticaRichiesteServiceHttp {
	public static java.util.List<service.intranet.mef.model.LogisticaRichieste> getLogisticaRichiesteByUtente(
		HttpPrincipal httpPrincipal, java.lang.String utente) {
		try {
			MethodKey methodKey = new MethodKey(LogisticaRichiesteServiceUtil.class,
					"getLogisticaRichiesteByUtente",
					_getLogisticaRichiesteByUtenteParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, utente);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.LogisticaRichieste>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<service.intranet.mef.model.LogisticaRichieste> getListLogRichiesteByDip(
		HttpPrincipal httpPrincipal, java.lang.String dipartimento) {
		try {
			MethodKey methodKey = new MethodKey(LogisticaRichiesteServiceUtil.class,
					"getListLogRichiesteByDip",
					_getListLogRichiesteByDipParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					dipartimento);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.LogisticaRichieste>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LogisticaRichiesteServiceHttp.class);
	private static final Class<?>[] _getLogisticaRichiesteByUtenteParameterTypes0 =
		new Class[] { java.lang.String.class };
	private static final Class<?>[] _getListLogRichiesteByDipParameterTypes1 = new Class[] {
			java.lang.String.class
		};
}