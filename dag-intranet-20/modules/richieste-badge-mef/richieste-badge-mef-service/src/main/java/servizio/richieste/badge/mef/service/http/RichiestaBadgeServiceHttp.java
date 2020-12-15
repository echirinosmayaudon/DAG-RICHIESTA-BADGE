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

package servizio.richieste.badge.mef.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import servizio.richieste.badge.mef.service.RichiestaBadgeServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link RichiestaBadgeServiceUtil} service utility. The
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
 * @see RichiestaBadgeServiceSoap
 * @see HttpPrincipal
 * @see RichiestaBadgeServiceUtil
 * @generated
 */
@ProviderType
public class RichiestaBadgeServiceHttp {
	public static com.liferay.portal.kernel.json.JSONArray findSuggestionsBySurname(
		HttpPrincipal httpPrincipal, java.lang.String cognome,
		java.lang.String idOrgChart, java.lang.Long userId) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBadgeServiceUtil.class,
					"findSuggestionsBySurname",
					_findSuggestionsBySurnameParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, cognome,
					idOrgChart, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getRichiestaBadgeByFilters(
		HttpPrincipal httpPrincipal, java.lang.String cogn_intest,
		java.lang.String nome_intest, java.lang.String cf_intest,
		java.lang.String societa, java.lang.String ref_societa,
		java.lang.String motivazione_rich, java.lang.String progetto,
		java.lang.String screenName,
		java.util.List<java.lang.Long> lista_IdUffici, boolean is_last,
		java.util.List<java.lang.Long> lista_sedi,
		java.lang.String is_internal, java.util.List<java.lang.Long> lista_stati) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBadgeServiceUtil.class,
					"getRichiestaBadgeByFilters",
					_getRichiestaBadgeByFiltersParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					cogn_intest, nome_intest, cf_intest, societa, ref_societa,
					motivazione_rich, progetto, screenName, lista_IdUffici,
					is_last, lista_sedi, is_internal, lista_stati);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiestaByDipartimentoStato(
		HttpPrincipal httpPrincipal, java.lang.String dipartimento,
		java.util.List<java.lang.Long> lista_IdStato) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBadgeServiceUtil.class,
					"findRichiestaByDipartimentoStato",
					_findRichiestaByDipartimentoStatoParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					dipartimento, lista_IdStato);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RichiestaBadgeServiceHttp.class);
	private static final Class<?>[] _findSuggestionsBySurnameParameterTypes0 = new Class[] {
			java.lang.String.class, java.lang.String.class, java.lang.Long.class
		};
	private static final Class<?>[] _getRichiestaBadgeByFiltersParameterTypes1 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class, java.util.List.class,
			boolean.class, java.util.List.class, java.lang.String.class,
			java.util.List.class
		};
	private static final Class<?>[] _findRichiestaByDipartimentoStatoParameterTypes2 =
		new Class[] { java.lang.String.class, java.util.List.class };
}