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

package mef.webcontent.config.service.impl;

import aQute.bnd.annotation.ProviderType;
import mef.webcontent.config.service.WebContentConfigLocalServiceUtil;
import mef.webcontent.config.service.base.WebContentConfigServiceBaseImpl;

/**
 * The implementation of the web content config remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link mef.webcontent.config.service.WebContentConfigService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebContentConfigServiceBaseImpl
 * @see mef.webcontent.config.service.WebContentConfigServiceUtil
 */
@ProviderType
public class WebContentConfigServiceImpl extends WebContentConfigServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link mef.webcontent.config.service.WebContentConfigServiceUtil} to access the web content config remote service.
	 */
	@Override
	public String webContentConfigurator(long groupid, String id, String html){
		return WebContentConfigLocalServiceUtil.webContentConfigurator(groupid,id, html);
	}


}