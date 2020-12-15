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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LuogoService}.
 *
 * @author Brian Wing Shun Chan
 * @see LuogoService
 * @generated
 */
@ProviderType
public class LuogoServiceWrapper implements LuogoService,
	ServiceWrapper<LuogoService> {
	public LuogoServiceWrapper(LuogoService luogoService) {
		_luogoService = luogoService;
	}

	@Override
	public boolean setLuogo(java.lang.String nome) {
		return _luogoService.setLuogo(nome);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _luogoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.Luogo> findByKeywordLuogo(
		java.lang.String keyword) {
		return _luogoService.findByKeywordLuogo(keyword);
	}

	@Override
	public LuogoService getWrappedService() {
		return _luogoService;
	}

	@Override
	public void setWrappedService(LuogoService luogoService) {
		_luogoService = luogoService;
	}

	private LuogoService _luogoService;
}