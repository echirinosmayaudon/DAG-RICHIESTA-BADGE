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

package com.intranet.mef.calendar.sender.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogMailService}.
 *
 * @author Brian Wing Shun Chan
 * @see LogMailService
 * @generated
 */
@ProviderType
public class LogMailServiceWrapper implements LogMailService,
	ServiceWrapper<LogMailService> {
	public LogMailServiceWrapper(LogMailService logMailService) {
		_logMailService = logMailService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _logMailService.getOSGiServiceIdentifier();
	}

	@Override
	public void sendMailWithAttachment(java.lang.String mailTo,
		java.lang.Long timeStart, java.lang.Long timeFinish,
		java.lang.String eventTitle, java.lang.String eventDescription,
		java.lang.String icsDescription) throws java.io.IOException {
		_logMailService.sendMailWithAttachment(mailTo, timeStart, timeFinish,
			eventTitle, eventDescription, icsDescription);
	}

	@Override
	public LogMailService getWrappedService() {
		return _logMailService;
	}

	@Override
	public void setWrappedService(LogMailService logMailService) {
		_logMailService = logMailService;
	}

	private LogMailService _logMailService;
}