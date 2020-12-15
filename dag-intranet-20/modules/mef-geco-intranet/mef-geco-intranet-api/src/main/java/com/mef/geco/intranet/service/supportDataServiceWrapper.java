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

package com.mef.geco.intranet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link supportDataService}.
 *
 * @author Brian Wing Shun Chan
 * @see supportDataService
 * @generated
 */
@ProviderType
public class supportDataServiceWrapper implements supportDataService,
	ServiceWrapper<supportDataService> {
	public supportDataServiceWrapper(supportDataService supportDataService) {
		_supportDataService = supportDataService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _supportDataService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<geco.mef.it.SchedaMaterialeBean> getListMateriali(
		java.lang.String origine, java.lang.String tipoMateriale,
		java.lang.String codiceGruppo, java.lang.String codiceSottogruppo,
		java.lang.String codiceUfficio, java.lang.String servizio,
		java.lang.String ambiente) {
		return _supportDataService.getListMateriali(origine, tipoMateriale,
			codiceGruppo, codiceSottogruppo, codiceUfficio, servizio, ambiente);
	}

	@Override
	public java.util.List<geco.mef.it.SottoGruppoBean> getListSottogruppi(
		java.lang.String origine, java.lang.String tipoMateriale,
		java.lang.String codiceGruppo, java.lang.String codiceUfficio,
		java.lang.String servizio, java.lang.String ambiente) {
		return _supportDataService.getListSottogruppi(origine, tipoMateriale,
			codiceGruppo, codiceUfficio, servizio, ambiente);
	}

	@Override
	public supportDataService getWrappedService() {
		return _supportDataService;
	}

	@Override
	public void setWrappedService(supportDataService supportDataService) {
		_supportDataService = supportDataService;
	}

	private supportDataService _supportDataService;
}