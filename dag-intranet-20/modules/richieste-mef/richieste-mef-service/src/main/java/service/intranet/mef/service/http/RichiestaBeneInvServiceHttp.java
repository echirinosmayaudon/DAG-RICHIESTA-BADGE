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

import service.intranet.mef.service.RichiestaBeneInvServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link RichiestaBeneInvServiceUtil} service utility. The
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
 * @see RichiestaBeneInvServiceSoap
 * @see HttpPrincipal
 * @see RichiestaBeneInvServiceUtil
 * @generated
 */
@ProviderType
public class RichiestaBeneInvServiceHttp {
	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFilters(
		HttpPrincipal httpPrincipal, long id_richiesta,
		java.lang.String nome_rich, java.lang.String cogn_rich,
		java.util.Date data, java.lang.String dip_dir,
		java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBeneInvServiceUtil.class,
					"getRichiesteBeniInvByFilters",
					_getRichiesteBeniInvByFiltersParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					id_richiesta, nome_rich, cogn_rich, data, dip_dir,
					list_id_stato, tipologia, in_elenco);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.RichiestaBeneInv>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(
		HttpPrincipal httpPrincipal, long id_richiesta,
		java.lang.String screenName, java.util.Date data,
		java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBeneInvServiceUtil.class,
					"getRichiesteBeniInvByFiltersRichiedente",
					_getRichiesteBeniInvByFiltersRichiedenteParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					id_richiesta, screenName, data, list_id_stato, tipologia,
					in_elenco);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.RichiestaBeneInv>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByUtente(
		HttpPrincipal httpPrincipal, java.lang.String utente) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBeneInvServiceUtil.class,
					"getRichiesteByUtente", _getRichiesteByUtenteParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, utente);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.RichiestaBeneInv>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByDipartimento(
		HttpPrincipal httpPrincipal, java.lang.String dipartimento) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBeneInvServiceUtil.class,
					"getRichiesteByDipartimento",
					_getRichiesteByDipartimentoParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					dipartimento);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.RichiestaBeneInv>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByDipartimentoAndStato(
		HttpPrincipal httpPrincipal, java.util.List<java.lang.String> dip_dir,
		long id_stato) {
		try {
			MethodKey methodKey = new MethodKey(RichiestaBeneInvServiceUtil.class,
					"getRichiesteByDipartimentoAndStato",
					_getRichiesteByDipartimentoAndStatoParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, dip_dir,
					id_stato);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<service.intranet.mef.model.RichiestaBeneInv>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RichiestaBeneInvServiceHttp.class);
	private static final Class<?>[] _getRichiesteBeniInvByFiltersParameterTypes0 =
		new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			java.util.Date.class, java.lang.String.class, java.util.List.class,
			java.lang.String.class, boolean.class
		};
	private static final Class<?>[] _getRichiesteBeniInvByFiltersRichiedenteParameterTypes1 =
		new Class[] {
			long.class, java.lang.String.class, java.util.Date.class,
			java.util.List.class, java.lang.String.class, boolean.class
		};
	private static final Class<?>[] _getRichiesteByUtenteParameterTypes2 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getRichiesteByDipartimentoParameterTypes3 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getRichiesteByDipartimentoAndStatoParameterTypes4 =
		new Class[] { java.util.List.class, long.class };
}