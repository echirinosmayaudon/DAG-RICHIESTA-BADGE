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
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.intranet.mef.assistance.model.Area;
import com.intranet.mef.assistance.model.Problem;
import com.intranet.mef.assistance.model.Servizio;
import com.intranet.mef.assistance.model.Topic;
import com.intranet.mef.assistance.service.AreaLocalServiceUtil;
import com.intranet.mef.assistance.service.ProblemLocalServiceUtil;
import com.intranet.mef.assistance.service.ServizioLocalServiceUtil;
import com.intranet.mef.assistance.service.TopicLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import it.smc.acn.mef.intranet.assistanceIntranet.web.constants.AssistanceWebPortletKeys;

/**
 * @author SMC Treviso
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AssistanceWebPortletKeys.ASSISTANCE,
			"mvc.command.name=/assistance/load"
	},
	service = MVCResourceCommand.class
)
public class AssistanceLoadMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	public void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", themeDisplay.getLocale(), getClass());
		String defaultValue = ResourceBundleUtil.getString(
				resourceBundle, "assistance-container-select-a-value");
		
		String selectedOption = ParamUtil.getString(resourceRequest,
				"selectedOption");
		String selectedLoad = ParamUtil.getString(resourceRequest,
				"selectedLoad");

		JSONArray jsonArray = _getJSONArray(selectedOption, selectedLoad,
			defaultValue);

		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			resourceResponse);

		response.setContentType(ContentTypes.APPLICATION_JSON);

		ServletResponseUtil.write(response, jsonArray.toString());

	}

	private JSONArray _getJSONArray(String selectedOption, String selectedLoad,
		String defaultValue){

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("entityId", ""); 
		jsonObject.put("entityName", defaultValue);

		jsonArray.put(jsonObject);

		_getJSONObject(selectedOption, selectedLoad, jsonArray);

		return jsonArray;
	}

	private JSONArray _getJSONObject(String selectedOption, String selectedLoad,
		JSONArray jsonArray){

		List<?> entityArray = null;

		if ("ambito".equalsIgnoreCase(selectedLoad)){
			entityArray = ServizioLocalServiceUtil.findByScopesId(selectedOption);

		}else if ("service".equalsIgnoreCase(selectedLoad)){
			entityArray = AreaLocalServiceUtil.findByServiceId(selectedOption);

		}else if ("area".equalsIgnoreCase(selectedLoad)){
			entityArray = TopicLocalServiceUtil.findByAreaId(selectedOption);

		}else if ("topic".equalsIgnoreCase(selectedLoad)){
			entityArray = ProblemLocalServiceUtil.findByTopicId(selectedOption);

		}

		for(Object object : entityArray){
			String entityId = StringPool.BLANK;
			String entityName = StringPool.BLANK;

			if (object instanceof Servizio){
				Servizio servizio =(Servizio)object;
				entityId = servizio.getAssServiceId();
				entityName = servizio.getServiceName();

			}else if (object instanceof Area){
				Area area =(Area)object;
				entityId = area.getAreaId(); 
				entityName = area.getAreaName();

			}else if (object instanceof Topic){
				Topic topic =(Topic)object;
				entityId = topic.getTopicId(); 
				entityName = topic.getTopicName();

			}else if (object instanceof Problem){
				Problem problem =(Problem)object;
				entityId = problem.getProblemId();
				entityName = problem.getProblemName();

			}
 
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("entityId", entityId); 
			jsonObject.put("entityName", entityName);
			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

}