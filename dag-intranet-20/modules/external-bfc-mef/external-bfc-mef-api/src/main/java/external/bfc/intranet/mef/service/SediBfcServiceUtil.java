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

package external.bfc.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SediBfc. This utility wraps
 * {@link external.bfc.intranet.mef.service.impl.SediBfcServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SediBfcService
 * @see external.bfc.intranet.mef.service.base.SediBfcServiceBaseImpl
 * @see external.bfc.intranet.mef.service.impl.SediBfcServiceImpl
 * @generated
 */
@ProviderType
public class SediBfcServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link external.bfc.intranet.mef.service.impl.SediBfcServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv2AndFlagApp(
		long id_org_liv2, boolean flag_app) {
		return getService()
				   .getSediBfcByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app);
	}

	public static java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv3AndFlagApp(
		long id_org_liv3, boolean flag_app) {
		return getService()
				   .getSediBfcByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app);
	}

	public static SediBfcService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SediBfcService, SediBfcService> _serviceTracker =
		ServiceTrackerFactory.open(SediBfcService.class);
}