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

package autorizzazione.dir.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UtilizzoApplicazioniService}.
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioniService
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniServiceWrapper
	implements UtilizzoApplicazioniService,
		ServiceWrapper<UtilizzoApplicazioniService> {
	public UtilizzoApplicazioniServiceWrapper(
		UtilizzoApplicazioniService utilizzoApplicazioniService) {
		_utilizzoApplicazioniService = utilizzoApplicazioniService;
	}

	@Override
	public autorizzazione.dir.mef.model.UtilizzoApplicazioni addNewHit(
		long userId, long applicationId) {
		return _utilizzoApplicazioniService.addNewHit(userId, applicationId);
	}

	@Override
	public autorizzazione.dir.mef.model.UtilizzoApplicazioni addNewMediaHit(
		long applicationId) {
		return _utilizzoApplicazioniService.addNewMediaHit(applicationId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _utilizzoApplicazioniService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<autorizzazione.dir.mef.model.UtilizzoApplicazioni> fetchLastMediaHits() {
		return _utilizzoApplicazioniService.fetchLastMediaHits();
	}

	@Override
	public UtilizzoApplicazioniService getWrappedService() {
		return _utilizzoApplicazioniService;
	}

	@Override
	public void setWrappedService(
		UtilizzoApplicazioniService utilizzoApplicazioniService) {
		_utilizzoApplicazioniService = utilizzoApplicazioniService;
	}

	private UtilizzoApplicazioniService _utilizzoApplicazioniService;
}