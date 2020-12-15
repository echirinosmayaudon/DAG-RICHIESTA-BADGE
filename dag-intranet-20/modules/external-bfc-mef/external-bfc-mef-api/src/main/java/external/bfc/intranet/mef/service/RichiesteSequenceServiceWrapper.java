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
 * Provides a wrapper for {@link RichiesteSequenceService}.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequenceService
 * @generated
 */
@ProviderType
public class RichiesteSequenceServiceWrapper implements RichiesteSequenceService,
	ServiceWrapper<RichiesteSequenceService> {
	public RichiesteSequenceServiceWrapper(
		RichiesteSequenceService richiesteSequenceService) {
		_richiesteSequenceService = richiesteSequenceService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _richiesteSequenceService.getOSGiServiceIdentifier();
	}

	@Override
	public RichiesteSequenceService getWrappedService() {
		return _richiesteSequenceService;
	}

	@Override
	public void setWrappedService(
		RichiesteSequenceService richiesteSequenceService) {
		_richiesteSequenceService = richiesteSequenceService;
	}

	private RichiesteSequenceService _richiesteSequenceService;
}