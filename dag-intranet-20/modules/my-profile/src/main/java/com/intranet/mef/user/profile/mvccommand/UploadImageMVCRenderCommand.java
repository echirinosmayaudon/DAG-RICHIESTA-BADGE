/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.intranet.mef.user.profile.mvccommand;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 * @author Levente Hud??k
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=com_intranet_mef_user_profile_portlet_ProfilePortlet",
		"mvc.command.name=/image_uploader/view"
	},
	service = MVCRenderCommand.class
)
public class UploadImageMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String portraitURL="";
		
		try {
			portraitURL = themeDisplay.getUser().getPortraitURL(themeDisplay);
		} catch (PortalException e) {
			_log.error("Error : " + e);
		}
		renderRequest.setAttribute("currentLogoURL", portraitURL);
		return "/view.jsp";
	}

	private static final Log _log = LogFactoryUtil.getLog(
	UploadImageMVCRenderCommand.class);
}