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

package servizio.beni.facile.consumo.richieste.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for RigheRichBFCNew. This utility wraps
 * {@link servizio.beni.facile.consumo.richieste.service.impl.RigheRichBFCNewServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichBFCNewService
 * @see servizio.beni.facile.consumo.richieste.service.base.RigheRichBFCNewServiceBaseImpl
 * @see servizio.beni.facile.consumo.richieste.service.impl.RigheRichBFCNewServiceImpl
 * @generated
 */
@ProviderType
public class RigheRichBFCNewServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.beni.facile.consumo.richieste.service.impl.RigheRichBFCNewServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew> getRigaRichiestaByIdRichiesta(
		long id_richiesta) {
		return getService().getRigaRichiestaByIdRichiesta(id_richiesta);
	}

	public static java.util.List<servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew> getRigheRichiestaByDipartimento(
		java.lang.String dipartimento) {
		return getService().getRigheRichiestaByDipartimento(dipartimento);
	}

	public static RigheRichBFCNewService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RigheRichBFCNewService, RigheRichBFCNewService> _serviceTracker =
		ServiceTrackerFactory.open(RigheRichBFCNewService.class);
}