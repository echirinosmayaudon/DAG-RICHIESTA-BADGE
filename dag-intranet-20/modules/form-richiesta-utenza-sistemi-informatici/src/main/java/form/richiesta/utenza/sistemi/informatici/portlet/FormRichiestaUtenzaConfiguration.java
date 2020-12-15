package form.richiesta.utenza.sistemi.informatici.portlet;

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

import form.richiesta.utenza.sistemi.informatici.constants.FormRichiestaUtenzaSistemiInformaticiPortletKeys;


@Component(configurationPid = "form.richiesta.utenza.sistemi.informatici.portlet.FormRichiestaUtenzaConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name="+FormRichiestaUtenzaSistemiInformaticiPortletKeys.FormRichiestaUtenzaSistemiInformatici }, service = ConfigurationAction.class)
public class FormRichiestaUtenzaConfiguration extends DefaultConfigurationAction{
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String sender = ParamUtil.getString(actionRequest, "sender");
		String emailReferente = ParamUtil.getString(actionRequest, "emailReferente");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String richiestaTmpl = ParamUtil.getString(actionRequest, "richiestaTmpl");
		String formTitle = ParamUtil.getString(actionRequest, "formTitle");
		String formSubtitle = ParamUtil.getString(actionRequest, "formSubtitle");
		String recapTitle = ParamUtil.getString(actionRequest, "recapTitle");
		String recapSubtitle = ParamUtil.getString(actionRequest, "recapSubtitle");
		
		setPreference(actionRequest, "sender", sender);
		setPreference(actionRequest, "emailReferente", emailReferente);
		setPreference(actionRequest, "subject", subject);
		setPreference(actionRequest, "richiestaTmpl", richiestaTmpl);
		setPreference(actionRequest, "formTitle", formTitle);
		setPreference(actionRequest, "formSubtitle", formSubtitle);
		setPreference(actionRequest, "recapTitle", recapTitle);
		setPreference(actionRequest, "recapSubtitle", recapSubtitle);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(FormRichiestaUtenzaConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(FormRichiestaUtenzaConfig.class, properties);
	}

	private volatile FormRichiestaUtenzaConfig _configuration;
	
}
