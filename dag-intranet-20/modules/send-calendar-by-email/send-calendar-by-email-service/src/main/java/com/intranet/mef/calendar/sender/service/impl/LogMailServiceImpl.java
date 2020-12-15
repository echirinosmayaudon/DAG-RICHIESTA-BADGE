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

package com.intranet.mef.calendar.sender.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.calendar.sender.service.LogMailLocalServiceUtil;
import com.intranet.mef.calendar.sender.service.base.LogMailServiceBaseImpl;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import java.io.IOException;

/**
 * The implementation of the log mail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.calendar.sender.service.LogMailService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogMailServiceBaseImpl
 * @see com.intranet.mef.calendar.sender.service.LogMailServiceUtil
 */
@JSONWebService
@ProviderType
public class LogMailServiceImpl extends LogMailServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.calendar.sender.service.LogMailServiceUtil} to access the log mail remote service.
	 */
	
	
	@Override
	public void sendMailWithAttachment(String mailTo, Long timeStart, Long timeFinish,String eventTitle, String eventDescription, String icsDescription) throws IOException {
		LogMailLocalServiceUtil.sendMailWithAttachment(mailTo, timeStart, timeFinish, eventTitle, eventDescription,icsDescription);
	}
}