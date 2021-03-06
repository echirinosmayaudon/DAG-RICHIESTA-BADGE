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

package com.mef.intranet.search.context.internal.display.context;

import com.liferay.portal.kernel.portlet.PortletURLUtil;

import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author André de Oliveira
 */
public class PortletURLFactoryImpl implements PortletURLFactory {

	@Override
	public PortletURL getPortletURL(
			PortletRequest portletRequest, MimeResponse mimeResponse)
		throws PortletException {

		PortletURL portletURL = PortletURLUtil.getCurrent(
			portletRequest, mimeResponse);

		return PortletURLUtil.clone(portletURL, mimeResponse);
	}

}