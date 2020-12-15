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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SediBfcService}.
 *
 * @author Brian Wing Shun Chan
 * @see SediBfcService
 * @generated
 */
@ProviderType
public class SediBfcServiceWrapper implements SediBfcService,
	ServiceWrapper<SediBfcService> {
	public SediBfcServiceWrapper(SediBfcService sediBfcService) {
		_sediBfcService = sediBfcService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _sediBfcService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv2AndFlagApp(
		long id_org_liv2, boolean flag_app) {
		return _sediBfcService.getSediBfcByIdOrgLiv2AndFlagApp(id_org_liv2,
			flag_app);
	}

	@Override
	public java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv3AndFlagApp(
		long id_org_liv3, boolean flag_app) {
		return _sediBfcService.getSediBfcByIdOrgLiv3AndFlagApp(id_org_liv3,
			flag_app);
	}

	@Override
	public SediBfcService getWrappedService() {
		return _sediBfcService;
	}

	@Override
	public void setWrappedService(SediBfcService sediBfcService) {
		_sediBfcService = sediBfcService;
	}

	private SediBfcService _sediBfcService;
}