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

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.osgi.service.component.annotations.Component;

import com.intranet.mef.assistance.model.Faq;
import com.intranet.mef.assistance.service.FaqLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;

import it.smc.acn.mef.intranet.assistanceIntranet.web.constants.AssistanceWebPortletKeys;

/**
 * @author SMC Treviso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AssistanceWebPortletKeys.ASSISTANCE,
		"mvc.command.name=/assistance/loadFaq"
	},
	service = MVCResourceCommand.class
)
public class AssistanceFaqMVCResourceCommand extends BaseMVCResourceCommand {
	public static final Log _log = LogFactoryUtil.getLog(AssistanceFaqMVCResourceCommand.class);
	@Override
	public void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException, IOException {

		String keyProblem = ParamUtil.getString(resourceRequest,
			"keyProblem");

		JSONArray jsonArray = _getJSONFaq(keyProblem);

		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			resourceResponse);

		response.setContentType(ContentTypes.APPLICATION_JSON);

		ServletResponseUtil.write(response, jsonArray.toString());
	}

	private JSONArray _getJSONFaq(String keyProblem){

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		List<Faq> entityArray = FaqLocalServiceUtil.findByProblemId(keyProblem);

		int i=0;
		for(Faq faq : entityArray){
			String question= faq.getQuestions();
			//question = StringEscapeUtils.escapeHtml4(question);
			String response = faq.getResponse();
			//response = StringEscapeUtils.escapeHtml4(response);
			//_log.info("Escaped response "+response);
			String idResponse = faq.getSiebelId().replace(StringPool.PERIOD,
				StringPool.UNDERLINE) + StringPool.UNDERLINE + i;

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("question",question ); 
			jsonObject.put("response", response);
			jsonObject.put("idResponse", idResponse);
			jsonArray.put(jsonObject);
			i++;
		}

		return jsonArray;
	}

}