package com.intranet.mef.portlet;

import com.intranet.mef.constants.JobOnDemandPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SubscriptionSender;

import java.io.IOException;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.layout-cacheable=true",
			"com.liferay.portlet.private-request-attributes=false",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.render-weight=50",
			"com.liferay.portlet.use-default-template=true",
			"javax.portlet.display-name=Job On Demand Portlet",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + JobOnDemandPortletKeys.JOB_ON_DEMAND,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class JobOnDemandPortlet extends MVCPortlet {
	Log _log = LogFactoryUtil.getLog(JobOnDemandPortlet.class);

	public void invokeJob(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		Message message = new Message();
		JSONObject config = JSONFactoryUtil.createJSONObject();
		config.put("custom_fields_enabled", ParamUtil.getBoolean(actionRequest, "cf-enabled"));
		config.put("location-enabled", ParamUtil.getBoolean(actionRequest, "location-enabled"));
		config.put("teamAndRoles-enabled", ParamUtil.getBoolean(actionRequest, "teamAndRoles-enabled"));
		JSONArray custom_fields = JSONFactoryUtil.createJSONArray();
		try {
			 custom_fields = JSONFactoryUtil.createJSONArray(ParamUtil.getString(actionRequest, "cf-json"));
		}
		catch (JSONException e){
			_log.error("Errore nel parsing del JSON dei custom_fields :"+e);
		}
		config.put("custom_fields",custom_fields);
		message.put("config-json", config);
		
		message.setResponseId("1");
		message.setResponseDestinationName("job/ondemand");

//		try {
//		    String testResponse = (String) MessageBusUtil.sendSynchronousMessage(
//		        "job/ondemand", message, 10000);
//		}catch(MessageBusException e){
//			_log.info(e.getMessage());
//		}
		_log.info("job configuration processed");
	}
	
}