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

import java.io.IOException;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.intranet.mef.assistance.service.AreaLocalServiceUtil;
import com.intranet.mef.assistance.service.ProblemLocalServiceUtil;
import com.intranet.mef.assistance.service.ServizioLocalServiceUtil;
import com.intranet.mef.assistance.service.TopicLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.smc.acn.mef.intranet.assistanceIntranet.web.constants.AssistanceWebPortletKeys;

/**
 * @author SMC Treviso
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AssistanceWebPortletKeys.ASSISTANCE,
			"mvc.command.name=/assistance/details"
	},
	service = MVCResourceCommand.class
)
public class AssistanceDetailsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	public void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException, IOException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", themeDisplay.getLocale(), getClass());

		String fileAttachmentName = ParamUtil.getString(
			resourceRequest, "fileAttachmentName");
		if (fileAttachmentName.isEmpty()){
			fileAttachmentName = ResourceBundleUtil.getString(
				resourceBundle, 
				"assistance-no-file-attachment");
		}

		String service = ParamUtil.getString(resourceRequest, "service");
		String area = ParamUtil.getString(resourceRequest, "area");
		String topic = ParamUtil.getString(resourceRequest, "topic");
		String problem = ParamUtil.getString(resourceRequest, "problem");
		String description = ParamUtil.getString(resourceRequest, "description");
		
		String serviceDesc = ServizioLocalServiceUtil.findServiceNameByPK(
			service);

		String areaDesc = AreaLocalServiceUtil.findAreaNameByPK(area);

		String topicDesc = TopicLocalServiceUtil.findTopicNameByPK(topic);

		String problemDesc = ProblemLocalServiceUtil.findProblemNameByPK(problem);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("serviceDesc", serviceDesc);
		jsonObject.put("areaDesc", areaDesc);
		jsonObject.put("topicDesc", topicDesc);
		jsonObject.put("problemDesc", problemDesc);
		jsonObject.put("description", description);
		jsonObject.put("fileNameAttachment", fileAttachmentName);

		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			resourceResponse);

		response.setContentType(ContentTypes.APPLICATION_JSON);

		ServletResponseUtil.write(response, jsonObject.toString());

	}

}