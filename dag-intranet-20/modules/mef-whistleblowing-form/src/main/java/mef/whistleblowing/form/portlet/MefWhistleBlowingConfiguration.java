package mef.whistleblowing.form.portlet;

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





@Component(configurationPid = "mef.whistleblowing.form.portlet.MefWhistleBlowingConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=mef_whistleblowing_form_portlet_MefWhistleBlowingPortlet" }, service = ConfigurationAction.class)
public class MefWhistleBlowingConfiguration  extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		String formTitle = ParamUtil.getString(actionRequest, "formTitle");
		String formSubtitle = ParamUtil.getString(actionRequest, "formSubtitle");
		String recapTitle = ParamUtil.getString(actionRequest, "recapTitle");
		String recapSubtitle = ParamUtil.getString(actionRequest, "recapSubtitle");
		String emailReferente = ParamUtil.getString(actionRequest, "emailReferente");
		String sender = ParamUtil.getString(actionRequest, "sender");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String segnalazioneTmpl = ParamUtil.getString(actionRequest, "segnalazioneTmpl");
		String salvataggioDB = ParamUtil.getString(actionRequest, "salvataggioDB");
		
		setPreference(actionRequest, "formTitle", formTitle);
		setPreference(actionRequest, "formSubtitle", formSubtitle);
		setPreference(actionRequest, "recapTitle", recapTitle);
		setPreference(actionRequest, "recapSubtitle", recapSubtitle);
		setPreference(actionRequest, "emailReferente", emailReferente);		
		setPreference(actionRequest, "sender", sender);
		setPreference(actionRequest, "subject", subject);
		setPreference(actionRequest, "segnalazioneTmpl", segnalazioneTmpl);
		setPreference(actionRequest, "salvataggioDB", salvataggioDB);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(MefWhistleBlowingConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefWhistleBlowingConfig.class, properties);
	}
	
	private volatile MefWhistleBlowingConfig _configuration;
}