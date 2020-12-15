package com.intranet.mef.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

@Component(configurationPid = "com.intranet.mef.portlet.RichiesteServiziLogisticiConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=com_intranet_mef_portlet_RichiesteServiziLogisticiFormmvcportletPortlet" }, service = ConfigurationAction.class)
public class RichiesteServiziLogisticiConfiguration extends DefaultConfigurationAction{
	
	final Log _log = LogFactoryUtil.getLog(RichiesteServiziLogisticiConfiguration.class);

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String sender = ParamUtil.getString(actionRequest, "sender");
		String emailGestore = ParamUtil.getString(actionRequest, "emailGestore");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String richiestaTmpl = ParamUtil.getString(actionRequest, "richiestaTmpl");
		String cambioStatosender = ParamUtil.getString(actionRequest, "cambioStatosender");
		String cambioStatosubject = ParamUtil.getString(actionRequest, "cambioStatosubject");
		String cambioStatoTmpl = ParamUtil.getString(actionRequest, "cambioStatoTmpl");
		String itemsPerPage = ParamUtil.getString(actionRequest, "itemsPerPage");
		
		setPreference(actionRequest, "sender", sender);
		setPreference(actionRequest, "emailGestore", emailGestore);
		setPreference(actionRequest, "subject", subject);
		setPreference(actionRequest, "richiestaTmpl", richiestaTmpl);
		setPreference(actionRequest, "cambioStatosender", cambioStatosender);
		setPreference(actionRequest, "cambioStatosubject", cambioStatosubject);
		setPreference(actionRequest, "cambioStatoTmpl", cambioStatoTmpl);
		setPreference(actionRequest, "itemsPerPage", itemsPerPage);
		
		//layout header page
		String serviziLogisticitxt = ParamUtil.getString(actionRequest, "serviziLogisticitxt");
		String serviziLogisticititle = ParamUtil.getString(actionRequest, "serviziLogisticititle");
		setPreference(actionRequest, "serviziLogisticitxt", serviziLogisticitxt);
		setPreference(actionRequest, "serviziLogisticititle", serviziLogisticititle);
		
		String serviziLogisticiDettagliotxt = ParamUtil.getString(actionRequest, "serviziLogisticiDettagliotxt");
		String serviziLogisticiDettagliotitle = ParamUtil.getString(actionRequest, "serviziLogisticiDettagliotitle");
		setPreference(actionRequest, "serviziLogisticiDettagliotxt", serviziLogisticiDettagliotxt);
		setPreference(actionRequest, "serviziLogisticiDettagliotitle", serviziLogisticiDettagliotitle);
		
		String serviziLogisticiElencotxt = ParamUtil.getString(actionRequest, "serviziLogisticiElencotxt");
		String serviziLogisticiElencotitle = ParamUtil.getString(actionRequest, "serviziLogisticiElencotitle");
		setPreference(actionRequest, "serviziLogisticiElencotxt", serviziLogisticiElencotxt);
		setPreference(actionRequest, "serviziLogisticiElencotitle", serviziLogisticiElencotitle);
		
		

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(RichiesteServiziLogisticiConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(RichiesteServiziLogisticiConfig.class, properties);
	}

	private volatile RichiesteServiziLogisticiConfig _configuration;
	
	
	
	
}
