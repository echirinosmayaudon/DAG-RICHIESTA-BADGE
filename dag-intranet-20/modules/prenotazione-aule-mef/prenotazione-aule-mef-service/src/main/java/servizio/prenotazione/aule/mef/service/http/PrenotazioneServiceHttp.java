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

package servizio.prenotazione.aule.mef.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import servizio.prenotazione.aule.mef.service.PrenotazioneServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link PrenotazioneServiceUtil} service utility. The
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
 * @see PrenotazioneServiceSoap
 * @see HttpPrincipal
 * @see PrenotazioneServiceUtil
 * @generated
 */
@ProviderType
public class PrenotazioneServiceHttp {
	public static java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> getPrenotazioniByFilters(
		HttpPrincipal httpPrincipal,
		java.util.List<java.lang.Long> id_sale_list,
		java.util.Date data_inizio, java.util.Date data_fine, long id_stato) {
		try {
			MethodKey methodKey = new MethodKey(PrenotazioneServiceUtil.class,
					"getPrenotazioniByFilters",
					_getPrenotazioniByFiltersParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					id_sale_list, data_inizio, data_fine, id_stato);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione> getPrenotazioniByCodFiscale(
		HttpPrincipal httpPrincipal, java.lang.String cod_fiscale) {
		try {
			MethodKey methodKey = new MethodKey(PrenotazioneServiceUtil.class,
					"getPrenotazioniByCodFiscale",
					_getPrenotazioniByCodFiscaleParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					cod_fiscale);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<servizio.prenotazione.aule.mef.model.Prenotazione>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PrenotazioneServiceHttp.class);
	private static final Class<?>[] _getPrenotazioniByFiltersParameterTypes0 = new Class[] {
			java.util.List.class, java.util.Date.class, java.util.Date.class,
			long.class
		};
	private static final Class<?>[] _getPrenotazioniByCodFiscaleParameterTypes1 = new Class[] {
			java.lang.String.class
		};
}