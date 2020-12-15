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

package servizio.beni.facile.consumo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServizioMaterialeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioMaterialeService
 * @generated
 */
@ProviderType
public class ServizioMaterialeServiceWrapper implements ServizioMaterialeService,
	ServiceWrapper<ServizioMaterialeService> {
	public ServizioMaterialeServiceWrapper(
		ServizioMaterialeService servizioMaterialeService) {
		_servizioMaterialeService = servizioMaterialeService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _servizioMaterialeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getGruppi() {
		return _servizioMaterialeService.getGruppi();
	}

	@Override
	public java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getGruppiByCategoria(
		java.lang.String categoria) {
		return _servizioMaterialeService.getGruppiByCategoria(categoria);
	}

	@Override
	public ServizioMaterialeService getWrappedService() {
		return _servizioMaterialeService;
	}

	@Override
	public void setWrappedService(
		ServizioMaterialeService servizioMaterialeService) {
		_servizioMaterialeService = servizioMaterialeService;
	}

	private ServizioMaterialeService _servizioMaterialeService;
}