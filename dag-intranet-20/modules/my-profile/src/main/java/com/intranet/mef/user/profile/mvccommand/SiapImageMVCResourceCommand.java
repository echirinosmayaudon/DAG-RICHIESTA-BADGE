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

import com.intranet.mef.job.siap.service.ProfilePictureLocalServiceUtil;
import com.liferay.document.library.kernel.exception.NoSuchFileEntryException;

import com.liferay.portal.kernel.flash.FlashMagicBytesUtil;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.imageio.ImageIO;
import javax.portlet.MimeResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Peter Fellwock
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=com_intranet_mef_user_profile_portlet_ProfilePortlet",
		"mvc.command.name=/image_uploader/siapImageURL"
	},
	service = MVCResourceCommand.class
)
public class SiapImageMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String personalId = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("personalId");
			Blob image=ProfilePictureLocalServiceUtil.getProfilePicture(Long.parseLong(personalId)).getFile();
			
			byte[ ] imgData = image.getBytes(1,(int)image.length());
			
			resourceResponse.setProperty("Cache-Control", "private,no-cache,no-store");
			resourceResponse.setContentType("image/png");
			
			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(imgData);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			OutputStream o = resourceResponse.getPortletOutputStream();
			ImageIO.write(bImageFromConvert, "png", o);
			
			o.flush();
			o.close();		
		}
		catch (Exception e) {
			_log.error("Image not found: "+e);
			PrintWriter out = resourceResponse.getWriter();
			out.println("/o/intranet-mef-theme/images/siap-empty.jpg");
			out.flush();
			out.close();
		}
	}



	private static final Log _log = LogFactoryUtil.getLog(
		SiapImageMVCResourceCommand.class);

}