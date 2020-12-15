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

@Component(configurationPid = "com.intranet.mef.portlet.RichiesteTrasportiFormConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=com_intranet_mef_portlet_RichiesteTrasportiFormmvcportletPortlet" }, service = ConfigurationAction.class)
public class RichiesteTrasportiFormConfiguration extends DefaultConfigurationAction{
	
	final Log _log = LogFactoryUtil.getLog(RichiesteTrasportiFormConfiguration.class);

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {


	

		//template email
		String richiestaRimborsoTmpl = ParamUtil.getString(actionRequest, "richiestaRimborsoTmpl");
		String subjectRichiestaRimborso = ParamUtil.getString(actionRequest, "subjectRichiestaRimborso");
		String senderRichiestaRimborso = ParamUtil.getString(actionRequest, "senderRichiestaRimborso");
		String emailReferente = ParamUtil.getString(actionRequest, "emailReferente");
		
		setPreference(actionRequest, "richiestaRimborsoTmpl", richiestaRimborsoTmpl);			
		setPreference(actionRequest, "subjectRichiestaRimborso", subjectRichiestaRimborso);
		setPreference(actionRequest, "senderRichiestaRimborso", senderRichiestaRimborso);
		setPreference(actionRequest, "emailReferente", emailReferente);


		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(RichiesteTrasportiFormConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(RichiesteTrasportiFormConfig.class, properties);
	}

	private volatile RichiesteTrasportiFormConfig _configuration;
	
	
	
	
}
