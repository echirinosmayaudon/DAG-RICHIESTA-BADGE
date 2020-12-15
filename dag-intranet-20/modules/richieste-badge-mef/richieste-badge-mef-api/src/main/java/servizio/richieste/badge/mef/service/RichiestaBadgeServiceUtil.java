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

package servizio.richieste.badge.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for RichiestaBadge. This utility wraps
 * {@link servizio.richieste.badge.mef.service.impl.RichiestaBadgeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgeService
 * @see servizio.richieste.badge.mef.service.base.RichiestaBadgeServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.impl.RichiestaBadgeServiceImpl
 * @generated
 */
@ProviderType
public class RichiestaBadgeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.richieste.badge.mef.service.impl.RichiestaBadgeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONArray findSuggestionsBySurname(
		java.lang.String cognome, java.lang.String idOrgChart,
		java.lang.Long userId) {
		return getService().findSuggestionsBySurname(cognome, idOrgChart, userId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiestaByDipartimentoStato(
		java.lang.String dipartimento,
		java.util.List<java.lang.Long> lista_IdStato) {
		return getService()
				   .findRichiestaByDipartimentoStato(dipartimento, lista_IdStato);
	}

	public static java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getRichiestaBadgeByFilters(
		java.lang.String cogn_intest, java.lang.String nome_intest,
		java.lang.String cf_intest, java.lang.String societa,
		java.lang.String ref_societa, java.lang.String motivazione_rich,
		java.lang.String progetto, java.lang.String screenName,
		java.util.List<java.lang.Long> lista_IdUffici, boolean is_last,
		java.util.List<java.lang.Long> lista_sedi,
		java.lang.String is_internal, java.util.List<java.lang.Long> lista_stati) {
		return getService()
				   .getRichiestaBadgeByFilters(cogn_intest, nome_intest,
			cf_intest, societa, ref_societa, motivazione_rich, progetto,
			screenName, lista_IdUffici, is_last, lista_sedi, is_internal,
			lista_stati);
	}

	public static RichiestaBadgeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaBadgeService, RichiestaBadgeService> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaBadgeService.class);
}