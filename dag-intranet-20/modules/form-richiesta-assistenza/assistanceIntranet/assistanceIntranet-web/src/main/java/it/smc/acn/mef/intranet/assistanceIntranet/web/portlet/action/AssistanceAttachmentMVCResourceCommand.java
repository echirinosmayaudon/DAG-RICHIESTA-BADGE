/**
 * Unpublished Copyright SMC TREVISO SRL. All rights reserved.
 *
 * The contents of this file are subject to the terms of the SMC TREVISO's
 * "CONDIZIONI GENERALI DI LICENZA D'USO DI SOFTWARE APPLICATIVO STANDARD SMC"
 * ("License"). You may not use this file except in compliance with the License.
 * You can obtain a copy of the License by contacting SMC TREVISO. See the
 * License for the limitations under the License, including but not limited to
 * distribution rights of the Software. You may not - for example - copy,
 * modify, transfer, transmit or distribute the whole file or portion of it, or
 * derived works, to a third party, except as may be permitted by SMC in a
 * written agreement.
 * To the maximum extent permitted by applicable law, this file is provided
 * "as is" without warranty of any kind, either expressed or implied, including
 * but not limited to, the implied warranty of merchantability, non infringement
 * and fitness for a particular purpose. SMC does not guarantee that the use of
 * the file will not be interrupted or error free.
 */

package it.smc.acn.mef.intranet.assistanceIntranet.web.portlet.action;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import it.smc.acn.mef.intranet.assistanceIntranet.web.configuration.AssistanceConfigurationValues;
import it.smc.acn.mef.intranet.assistanceIntranet.web.constants.AssistanceWebPortletKeys;

/**
 * @author SMC Treviso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AssistanceWebPortletKeys.ASSISTANCE,
		"mvc.command.name=/assistance/attachment"
	},
	service = MVCResourceCommand.class
)
public class AssistanceAttachmentMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	public void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException, IOException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		UploadPortletRequest uploadPortletRequest = 
 			PortalUtil.getUploadPortletRequest(resourceRequest);

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", themeDisplay.getLocale(), getClass());

		String fileNameAttachment=uploadPortletRequest.getFileName(
			"attachmentName");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		if (Validator.isNotNull(fileNameAttachment)) {
			try {
				File attachment = uploadPortletRequest.getFile("attachmentName");

				long totalSpace = attachment.length(); 	 		

				if (totalSpace >= AssistanceConfigurationValues.
						ASSISTANCE_MAX_FILE_SIZE_ATTACHMENT){
					String message = ResourceBundleUtil.getString(
						resourceBundle, 
						"assistance-error-max-file-size-attachment");
		 			jsonObject.put("messagerror", message);
					jsonObject.put("success", false);
				}else{
					fileNameAttachment+=" ("+totalSpace/1024+"Kb)";
					jsonObject.put("fileNameAttachment", fileNameAttachment);
					jsonObject.put("messagerror", StringPool.BLANK);
		 			jsonObject.put("success", true);
				}
			}
			catch (Exception e) {

				if (_log.isErrorEnabled()){
					_log.error(e);
				}

				String message = ResourceBundleUtil.getString(resourceBundle, 
					"assistance-unexpected-error-occurred-while-importing-"
					+ "your-file");
 				jsonObject.put("messagerror", message);
				jsonObject.put("success", false);
			}
		}
		else {
			String message = ResourceBundleUtil.getString(
				resourceBundle, "assistance-failed-to-import-empty-file");

			jsonObject.put("messagerror", message);
			jsonObject.put("success", false);
		}

  		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			resourceResponse);

		response.setContentType(ContentTypes.APPLICATION_JSON);

		ServletResponseUtil.write(response, jsonObject.toString());

	}

	private static final Log _log = LogFactoryUtil.getLog(
		AssistanceAttachmentMVCResourceCommand.class);
}