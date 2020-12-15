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
import com.liferay.portal.kernel.util.ListUtil;

import servizio.richieste.badge.mef.service.RichiestaBadgeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link RichiestaBadgeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link servizio.richieste.badge.mef.model.RichiestaBadgeSoap}.
 * If the method in the service utility returns a
 * {@link servizio.richieste.badge.mef.model.RichiestaBadge}, that is translated to a
 * {@link servizio.richieste.badge.mef.model.RichiestaBadgeSoap}. Methods that SOAP cannot
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
 * @see RichiestaBadgeServiceHttp
 * @see servizio.richieste.badge.mef.model.RichiestaBadgeSoap
 * @see RichiestaBadgeServiceUtil
 * @generated
 */
@ProviderType
public class RichiestaBadgeServiceSoap {
	public static java.lang.String findSuggestionsBySurname(
		java.lang.String cognome, java.lang.String idOrgChart,
		java.lang.Long userId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = RichiestaBadgeServiceUtil.findSuggestionsBySurname(cognome,
					idOrgChart, userId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static servizio.richieste.badge.mef.model.RichiestaBadgeSoap[] getRichiestaBadgeByFilters(
		java.lang.String cogn_intest, java.lang.String nome_intest,
		java.lang.String cf_intest, java.lang.String societa,
		java.lang.String ref_societa, java.lang.String motivazione_rich,
		java.lang.String progetto, java.lang.String screenName,
		Long[] lista_IdUffici, boolean is_last, Long[] lista_sedi,
		java.lang.String is_internal, Long[] lista_stati)
		throws RemoteException {
		try {
			java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> returnValue =
				RichiestaBadgeServiceUtil.getRichiestaBadgeByFilters(cogn_intest,
					nome_intest, cf_intest, societa, ref_societa,
					motivazione_rich, progetto, screenName,
					ListUtil.toList(lista_IdUffici), is_last,
					ListUtil.toList(lista_sedi), is_internal,
					ListUtil.toList(lista_stati));

			return servizio.richieste.badge.mef.model.RichiestaBadgeSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static servizio.richieste.badge.mef.model.RichiestaBadgeSoap[] findRichiestaByDipartimentoStato(
		java.lang.String dipartimento, Long[] lista_IdStato)
		throws RemoteException {
		try {
			java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> returnValue =
				RichiestaBadgeServiceUtil.findRichiestaByDipartimentoStato(dipartimento,
					ListUtil.toList(lista_IdStato));

			return servizio.richieste.badge.mef.model.RichiestaBadgeSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RichiestaBadgeServiceSoap.class);
}