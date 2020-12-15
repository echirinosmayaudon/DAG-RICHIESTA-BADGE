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

package com.intranet.mef.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AmministrazioneConvocante. This utility wraps
 * {@link com.intranet.mef.gestione.riunioni.service.impl.AmministrazioneConvocanteServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AmministrazioneConvocanteService
 * @see com.intranet.mef.gestione.riunioni.service.base.AmministrazioneConvocanteServiceBaseImpl
 * @see com.intranet.mef.gestione.riunioni.service.impl.AmministrazioneConvocanteServiceImpl
 * @generated
 */
@ProviderType
public class AmministrazioneConvocanteServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.gestione.riunioni.service.impl.AmministrazioneConvocanteServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean setAmministrazioneConvocante(
		java.lang.String nome_amministrazione) {
		return getService().setAmministrazioneConvocante(nome_amministrazione);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante> findByKeywordAdmin(
		java.lang.String keyword) {
		return getService().findByKeywordAdmin(keyword);
	}

	public static AmministrazioneConvocanteService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmministrazioneConvocanteService, AmministrazioneConvocanteService> _serviceTracker =
		ServiceTrackerFactory.open(AmministrazioneConvocanteService.class);
}