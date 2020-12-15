package mef.richieste.beni.inventariati.portlet;


import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
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

@Component(configurationPid = "mef.richieste.beni.inventariati.portlet.MefRichiesteBeniInventariatiConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=mef_richieste_beni_inventariati_portlet_MefRichiesteBeniInventariatiPortlet" }, service = ConfigurationAction.class)
public class MefRichiesteBeniInventariatiConfiguration extends DefaultConfigurationAction{
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception  {
		String nuovaRichiestaSender = ParamUtil.getString(actionRequest, "nuovaRichiestaSender");
		String nuovaRichiestaSubject = ParamUtil.getString(actionRequest, "nuovaRichiestaSubject");
		String nuovaRichiestaTmpl = ParamUtil.getString(actionRequest, "nuovaRichiestaTmpl");
		String cambioStatoConsegnatarioSender = ParamUtil.getString(actionRequest, "cambioStatoConsegnatarioSender");
		String cambioStatoConsegnatarioSubject = ParamUtil.getString(actionRequest, "cambioStatoConsegnatarioSubject");
		String cambioStatoConsegnatarioTmpl = ParamUtil.getString(actionRequest, "cambioStatoConsegnatarioTmpl");
		String cambioStatoCDCSender = ParamUtil.getString(actionRequest, "cambioStatoCDCSender");
		String cambioStatoCDCSubject = ParamUtil.getString(actionRequest, "cambioStatoCDCSubject");
		String cambioStatoCDCTmpl = ParamUtil.getString(actionRequest, "cambioStatoCDCTmpl");
		
		setPreference(actionRequest, "nuovaRichiestaSender", nuovaRichiestaSender);
		setPreference(actionRequest, "nuovaRichiestaSubject", nuovaRichiestaSubject);
		setPreference(actionRequest, "nuovaRichiestaTmpl", nuovaRichiestaTmpl);
		setPreference(actionRequest, "cambioStatoConsegnatarioSender", cambioStatoConsegnatarioSender);
		setPreference(actionRequest, "cambioStatoConsegnatarioSubject", cambioStatoConsegnatarioSubject);
		setPreference(actionRequest, "cambioStatoConsegnatarioTmpl", cambioStatoConsegnatarioTmpl);
		setPreference(actionRequest, "cambioStatoCDCSender", cambioStatoCDCSender);
		setPreference(actionRequest, "cambioStatoCDCSubject", cambioStatoCDCSubject);
		setPreference(actionRequest, "cambioStatoCDCTmpl", cambioStatoCDCTmpl);
		
		String beniInvRicercaTitle = ParamUtil.getString(actionRequest, "beniInvRicercaTitle");
		String beniInvRicercaTxt = ParamUtil.getString(actionRequest, "beniInvRicercaTxt");
		setPreference(actionRequest, "beniInvRicercaTitle", beniInvRicercaTitle);
		setPreference(actionRequest, "beniInvRicercaTxt", beniInvRicercaTxt);
		
		String beniInvInserimentoTitle = ParamUtil.getString(actionRequest, "beniInvInserimentoTitle");
		String beniInvInserimentoTxt = ParamUtil.getString(actionRequest, "beniInvInserimentoTxt");
		setPreference(actionRequest, "beniInvInserimentoTitle", beniInvInserimentoTitle);
		setPreference(actionRequest, "beniInvInserimentoTxt", beniInvInserimentoTxt);
		
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(MefRichiesteBeniInventariatiConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiesteBeniInventariatiConfig.class, properties);
	}
	
	private volatile MefRichiesteBeniInventariatiConfig _configuration;

}
