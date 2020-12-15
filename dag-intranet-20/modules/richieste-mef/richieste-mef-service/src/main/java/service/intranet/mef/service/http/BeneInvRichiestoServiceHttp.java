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

import service.intranet.mef.service.BeneInvRichiestoServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link BeneInvRichiestoServiceUtil} service utility. The
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
 * @see BeneInvRichiestoServiceSoap
 * @see HttpPrincipal
 * @see BeneInvRichiestoServiceUtil
 * @generated
 */
@ProviderType
public class BeneInvRichiestoServiceHttp {
	public static java.util.List<service.intranet.mef.model.BeneInvRichiesto> getListBeniByIdRichiesta(
		HttpPrincipal httpPrincipal, long id_richiesta, boolean in_elenco) {
		try {
			MethodKey methodKey = new MethodKey(BeneInvRichiestoServiceUtil.class,
					"getListBeniByIdRichiesta",
					_getListBeniByIdRichiestaParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					id_richiesta, in_elenco);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.BeneInvRichiesto>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static service.intranet.mef.model.BeneInvRichiesto insertBeneInvRichiesto(
		HttpPrincipal httpPrincipal, java.lang.String tipologia,
		java.lang.String descrizione, int quantita, java.lang.String dettagli,
		boolean in_elenco, long id_richiesta) {
		try {
			MethodKey methodKey = new MethodKey(BeneInvRichiestoServiceUtil.class,
					"insertBeneInvRichiesto",
					_insertBeneInvRichiestoParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					tipologia, descrizione, quantita, dettagli, in_elenco,
					id_richiesta);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (service.intranet.mef.model.BeneInvRichiesto)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BeneInvRichiestoServiceHttp.class);
	private static final Class<?>[] _getListBeniByIdRichiestaParameterTypes0 = new Class[] {
			long.class, boolean.class
		};
	private static final Class<?>[] _insertBeneInvRichiestoParameterTypes1 = new Class[] {
			java.lang.String.class, java.lang.String.class, int.class,
			java.lang.String.class, boolean.class, long.class
		};
}