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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for RichiestaBeneInv. This utility wraps
 * {@link service.intranet.mef.service.impl.RichiestaBeneInvServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvService
 * @see service.intranet.mef.service.base.RichiestaBeneInvServiceBaseImpl
 * @see service.intranet.mef.service.impl.RichiestaBeneInvServiceImpl
 * @generated
 */
@ProviderType
public class RichiestaBeneInvServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.RichiestaBeneInvServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFilters(
		long id_richiesta, java.lang.String nome_rich,
		java.lang.String cogn_rich, java.util.Date data,
		java.lang.String dip_dir, java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco) {
		return getService()
				   .getRichiesteBeniInvByFilters(id_richiesta, nome_rich,
			cogn_rich, data, dip_dir, list_id_stato, tipologia, in_elenco);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(
		long id_richiesta, java.lang.String screenName, java.util.Date data,
		java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco) {
		return getService()
				   .getRichiesteBeniInvByFiltersRichiedente(id_richiesta,
			screenName, data, list_id_stato, tipologia, in_elenco);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByDipartimento(
		java.lang.String dipartimento) {
		return getService().getRichiesteByDipartimento(dipartimento);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByDipartimentoAndStato(
		java.util.List<java.lang.String> dip_dir, long id_stato) {
		return getService().getRichiesteByDipartimentoAndStato(dip_dir, id_stato);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByUtente(
		java.lang.String utente) {
		return getService().getRichiesteByUtente(utente);
	}

	public static RichiestaBeneInvService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaBeneInvService, RichiestaBeneInvService> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaBeneInvService.class);
}