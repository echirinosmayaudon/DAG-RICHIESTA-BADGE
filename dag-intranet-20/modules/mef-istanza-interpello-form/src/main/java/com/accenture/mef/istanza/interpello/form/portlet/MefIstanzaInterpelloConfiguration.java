package com.accenture.mef.istanza.interpello.form.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
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

@Component(configurationPid = "com.accenture.mef.lavoro.agile.form.portlet.MefIstanzaInterpelloConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
		"javax.portlet.name=com_accenture_mef_istanza_interpello_form_portlet_MefIstanzaInterpelloFormPortlet" }, service = ConfigurationAction.class)
public class MefIstanzaInterpelloConfiguration extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String formTitle = ParamUtil.getString(actionRequest, "formTitle");

		String formSubTitle = ParamUtil.getString(actionRequest, "formSubTitle");

		String formTitleRecap = ParamUtil.getString(actionRequest, "formTitleRecap");

		String formSubTitleRecap = ParamUtil.getString(actionRequest, "formSubTitleRecap");

		String formTitleDettaglio = ParamUtil.getString(actionRequest, "formTitleDettaglio");

		String formSubTitleDettaglio = ParamUtil.getString(actionRequest, "formSubTitleDettaglio");

		String sender = ParamUtil.getString(actionRequest, "sender");

		String emailSubject = ParamUtil.getString(actionRequest, "emailSubject");

		String emailToDipDT = ParamUtil.getString(actionRequest, "emailToDipDT");

		String emailToDipRGS = ParamUtil.getString(actionRequest, "emailToDipRGS");

		String emailToDipDF = ParamUtil.getString(actionRequest, "emailToDipDF");

		String emailToDipDAG = ParamUtil.getString(actionRequest, "emailToDipDAG");

		String emailBody = ParamUtil.getString(actionRequest, "emailBody");

		setPreference(actionRequest, "formTitle", formTitle);

		setPreference(actionRequest, "formSubTitle", formSubTitle);

		setPreference(actionRequest, "formTitleRecap", formTitleRecap);

		setPreference(actionRequest, "formSubTitleRecap", formSubTitleRecap);

		setPreference(actionRequest, "formTitleDettaglio", formTitleDettaglio);

		setPreference(actionRequest, "formSubTitleDettaglio", formSubTitleDettaglio);

		setPreference(actionRequest, "sender", sender);

		setPreference(actionRequest, "emailSubject", emailSubject);

		setPreference(actionRequest, "emailToDipDT", emailToDipDT);

		setPreference(actionRequest, "emailToDipRGS", emailToDipRGS);

		setPreference(actionRequest, "emailToDipDF", emailToDipDF);

		setPreference(actionRequest, "emailToDipDAG", emailToDipDAG);

		setPreference(actionRequest, "emailBody", emailBody);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(MefIstanzaInterpelloConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefIstanzaInterpelloConfig.class, properties);
	}

	private volatile MefIstanzaInterpelloConfig _configuration;

}