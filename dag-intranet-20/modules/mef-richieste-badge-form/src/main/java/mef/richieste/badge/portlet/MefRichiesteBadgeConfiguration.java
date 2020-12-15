package mef.richieste.badge.portlet;

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

@Component(configurationPid = "mef.richieste.badge.portlet.MefRichiesteBadgeConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=mef_richieste_badge_portlet_RichiesteBadgePortlet" }, service = ConfigurationAction.class)

public class MefRichiesteBadgeConfiguration extends DefaultConfigurationAction{
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String formTitle = ParamUtil.getString(actionRequest, "formTitle");
		String formSubtitle = ParamUtil.getString(actionRequest, "formSubtitle");
		String gestioneUtentiTitle = ParamUtil.getString(actionRequest, "gestioneUtentiTitle");
		String gestioneUtentiSubtitle = ParamUtil.getString(actionRequest, "gestioneUtentiSubtitle");
		String servizioProrogaTitle = ParamUtil.getString(actionRequest, "servizioProrogaTitle");
		String servizioProrogaSubtitle = ParamUtil.getString(actionRequest, "servizioProrogaSubtitle");
		String riepilogoProrogaTitle = ParamUtil.getString(actionRequest, "riepilogoProrogaTitle");
		String riepilogoProrogaSubtitle = ParamUtil.getString(actionRequest, "riepilogoProrogaSubtitle");
		String ricercaTitle = ParamUtil.getString(actionRequest, "ricercaTitle");
		String ricercaSubtitle = ParamUtil.getString(actionRequest, "ricercaSubtitle");
		String sender = ParamUtil.getString(actionRequest, "sender");
		String emailReferente = ParamUtil.getString(actionRequest, "emailReferente");
		
		
		String subjectNuova = ParamUtil.getString(actionRequest, "subjectNuova");
		String subjectRichiediModifica = ParamUtil.getString(actionRequest, "subjectRichiediModifica");
		String subjectModifica = ParamUtil.getString(actionRequest, "subjectModifica");
		String subjectApprova = ParamUtil.getString(actionRequest, "subjectApprova");
		String subjectRifiuta = ParamUtil.getString(actionRequest, "subjectRifiuta");
		
		String richiestaTmpl = ParamUtil.getString(actionRequest, "richiestaTmpl");
		
		
		String itemsPerPage = ParamUtil.getString(actionRequest, "itemsPerPage");
		
		String itemsPerPageUtenti = ParamUtil.getString(actionRequest, "itemsPerPageUtenti");
		
		
		
		setPreference(actionRequest, "formTitle", formTitle);
		setPreference(actionRequest, "formSubtitle", formSubtitle);
		setPreference(actionRequest, "gestioneUtentiTitle", gestioneUtentiTitle);
		setPreference(actionRequest, "gestioneUtentiSubtitle", gestioneUtentiSubtitle);
		setPreference(actionRequest, "servizioProrogaTitle", servizioProrogaTitle);
		setPreference(actionRequest, "servizioProrogaSubtitle", servizioProrogaSubtitle);
		setPreference(actionRequest, "riepilogoProrogaTitle", riepilogoProrogaTitle);
		setPreference(actionRequest, "riepilogoProrogaSubtitle", riepilogoProrogaSubtitle);
		setPreference(actionRequest, "ricercaTitle", ricercaTitle);
		setPreference(actionRequest, "ricercaSubtitle", ricercaSubtitle);
		setPreference(actionRequest, "sender", sender);
		setPreference(actionRequest, "emailReferente", emailReferente);
		
		setPreference(actionRequest, "subjectNuova", subjectNuova);
		setPreference(actionRequest, "subjectRichiediModifica", subjectRichiediModifica);
		setPreference(actionRequest, "subjectModifica", subjectModifica);	
		setPreference(actionRequest, "subjectApprova", subjectApprova);
		setPreference(actionRequest, "subjectRifiuta", subjectRifiuta);
		
		setPreference(actionRequest, "richiestaTmpl", richiestaTmpl);
		
		setPreference(actionRequest, "itemsPerPage", itemsPerPage);
		
		setPreference(actionRequest, "itemsPerPageUtenti", itemsPerPageUtenti);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(MefRichiesteBadgeConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiesteBadgeConfig.class, properties);
	}

	private volatile MefRichiesteBadgeConfig _configuration;
	
}
