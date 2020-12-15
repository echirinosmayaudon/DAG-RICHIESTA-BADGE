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


@Component(configurationPid = "com.intranet.mef.portlet.GestioneRiunioniFormConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=com_intranet_mef_portlet_GestioneRiunioniFormmvcportletPortlet" }, service = ConfigurationAction.class)
public class GestioneRiunioniFormConfiguration extends DefaultConfigurationAction{
	
	final Log _log = LogFactoryUtil.getLog(GestioneRiunioniFormConfiguration.class);

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		

		String itemsPerPage = ParamUtil.getString(actionRequest, "itemsPerPage");
		
		String modificariunioneTmpl = ParamUtil.getString(actionRequest, "modificariunioneTmpl");
		
		
		String sollecitoriunioneTmpl = ParamUtil.getString(actionRequest, "sollecitoriunioneTmpl");
		
		String sollecitoaccettatariunioneTmpl = ParamUtil.getString(actionRequest, "sollecitoaccettatariunioneTmpl");

		String modificainvitatiriunioneTmpl = ParamUtil.getString(actionRequest, "modificainvitatiriunioneTmpl");
		String aggiuntainvitatiriunioneTmpl=ParamUtil.getString(actionRequest, "aggiuntainvitatiriunioneTmpl");
		String senderModificaInvitati = ParamUtil.getString(actionRequest, "senderModificaInvitati");
		String subjectModificaInvitati = ParamUtil.getString(actionRequest, "subjectModificaInvitati");
		String senderAggiuntaInvitati = ParamUtil.getString(actionRequest, "senderAggiuntaInvitati");
		String subjectAggiuntaInvitati = ParamUtil.getString(actionRequest, "subjectAggiuntaInvitati");

		setPreference(actionRequest, "modificainvitatiriunioneTmpl", modificainvitatiriunioneTmpl);
		setPreference(actionRequest, "aggiuntainvitatiriunioneTmpl", aggiuntainvitatiriunioneTmpl);
		setPreference(actionRequest, "senderModificaInvitati", senderModificaInvitati);
		setPreference(actionRequest, "subjectModificaInvitati", subjectModificaInvitati);
		setPreference(actionRequest, "senderAggiuntaInvitati", senderAggiuntaInvitati);
		setPreference(actionRequest, "subjectAggiuntaInvitati", subjectAggiuntaInvitati);

		String cancellainvitoriunioneTmpl =  ParamUtil.getString(actionRequest, "cancellainvitoriunioneTmpl");
		
		String invitoriunioneTmpl = ParamUtil.getString(actionRequest, "invitoriunioneTmpl");
		
		
		String spostariunioneTmpl = ParamUtil.getString(actionRequest, "spostariunioneTmpl");
		
		String cambiostatoriunioneTmpl = ParamUtil.getString(actionRequest, "cambiostatoriunioneTmpl");
		
		String cambiostatoriunioneindettaTmpl = ParamUtil.getString(actionRequest, "cambiostatoriunioneindettaTmpl");
		
		String senderModifica = ParamUtil.getString(actionRequest, "senderModifica");
		
		String subjectModifica = ParamUtil.getString(actionRequest, "subjectModifica");
		
		String riunionerinviataTmpl = ParamUtil.getString(actionRequest, "riunionerinviataTmpl");
		setPreference(actionRequest, "riunionerinviataTmpl", riunionerinviataTmpl);

		String senderRiunioneRinviata = ParamUtil.getString(actionRequest, "senderRiunioneRinviata");
		setPreference(actionRequest, "senderRiunioneRinviata", senderRiunioneRinviata);

		String subjectRiunioneRinviata = ParamUtil.getString(actionRequest, "subjectRiunioneRinviata");
		setPreference(actionRequest, "subjectRiunioneRinviata", subjectRiunioneRinviata);
		String senderSollecito = ParamUtil.getString(actionRequest, "senderSollecito");
		
		String subjectSollecito = ParamUtil.getString(actionRequest, "subjectSollecito");
		
		String senderSollecitoAccettata = ParamUtil.getString(actionRequest, "senderSollecitoAccettata");
		
		String subjectSollecitoAccettata = ParamUtil.getString(actionRequest, "subjectSollecitoAccettata");
		
		String senderInvito = ParamUtil.getString(actionRequest, "senderInvito");
		
		String subjectInvito = ParamUtil.getString(actionRequest, "subjectInvito");
		
		String senderCancellaInvito = ParamUtil.getString(actionRequest, "senderCancellaInvito");
		
		String subjectCancellaInvito = ParamUtil.getString(actionRequest, "subjectCancellaInvito");
		
		String senderSposta = ParamUtil.getString(actionRequest, "senderSposta");
		
		String subjectSposta = ParamUtil.getString(actionRequest, "subjectSposta");
		
		String senderCambioStato = ParamUtil.getString(actionRequest, "senderCambioStato");
		
		String subjectCambioStato = ParamUtil.getString(actionRequest, "subjectCambioStato");
		
		String senderStatoIndetta = ParamUtil.getString(actionRequest, "senderStatoIndetta");
		
		String subjectStatoIndetta = ParamUtil.getString(actionRequest, "subjectStatoIndetta");
				
		String ricercaRiunionetxt = ParamUtil.getString(actionRequest, "ricercaRiunionetxt");
		
		String ricercaRiunionetitle = ParamUtil.getString(actionRequest, "ricercaRiunionetitle");
		
		String creaRiunionetxt = ParamUtil.getString(actionRequest, "creaRiunionetxt");
		
		String creaRiunionetitle = ParamUtil.getString(actionRequest, "creaRiunionetitle");
		
		String luoghiRiunionetxt = ParamUtil.getString(actionRequest, "luoghiRiunionetxt");
		
		String luoghiRiunionetitle = ParamUtil.getString(actionRequest, "luoghiRiunionetitle");
		
		String convocantiRiunionetxt = ParamUtil.getString(actionRequest, "convocantiRiunionetxt");
		
		String convocantiRiunionetitle = ParamUtil.getString(actionRequest, "convocantiRiunionetitle");
		
		String modificaRiunionetxt = ParamUtil.getString(actionRequest, "modificaRiunionetxt");
		
		String modificaRiunionetitle = ParamUtil.getString(actionRequest, "modificaRiunionetitle");
		
		String stampaRiunionetxt = ParamUtil.getString(actionRequest, "stampaRiunionetxt");
		
		String stampaRiunionetitle = ParamUtil.getString(actionRequest, "stampaRiunionetitle");
		
		String accettaRiunionetxt = ParamUtil.getString(actionRequest, "accettaRiunionetxt");
		
		String accettaRiunionetitle = ParamUtil.getString(actionRequest, "accettaRiunionetitle");
		
		setPreference(actionRequest, "itemsPerPage", itemsPerPage);
		
		setPreference(actionRequest, "modificariunioneTmpl", modificariunioneTmpl);
		
		
		setPreference(actionRequest, "sollecitoriunioneTmpl", sollecitoriunioneTmpl);

		setPreference(actionRequest, "sollecitoaccettatariunioneTmpl", sollecitoaccettatariunioneTmpl);
		
		setPreference(actionRequest, "invitoriunioneTmpl", invitoriunioneTmpl);
		
		
		setPreference(actionRequest, "cancellainvitoriunioneTmpl", cancellainvitoriunioneTmpl);
		
		setPreference(actionRequest, "spostariunioneTmpl", spostariunioneTmpl);
		
		setPreference(actionRequest, "cambiostatoriunioneTmpl", cambiostatoriunioneTmpl);
		
		setPreference(actionRequest, "cambiostatoriunioneindettaTmpl", cambiostatoriunioneindettaTmpl);
		
		setPreference(actionRequest, "senderModifica", senderModifica);
		
		setPreference(actionRequest, "subjectModifica", subjectModifica);
		
		setPreference(actionRequest, "senderSollecito", senderSollecito);
		
		setPreference(actionRequest, "subjectSollecito", subjectSollecito);
		
		setPreference(actionRequest, "senderSollecitoAccettata", senderSollecitoAccettata);
		
		setPreference(actionRequest, "subjectSollecitoAccettata", subjectSollecitoAccettata);
		
		setPreference(actionRequest, "senderInvito", senderInvito);
		
		setPreference(actionRequest, "subjectInvito", subjectInvito);
		
		setPreference(actionRequest, "senderCancellaInvito", senderCancellaInvito);
		
		setPreference(actionRequest, "subjectCancellaInvito", subjectCancellaInvito);
		
		setPreference(actionRequest, "senderSposta", senderSposta);
		
		setPreference(actionRequest, "subjectSposta", subjectSposta);
		
		setPreference(actionRequest, "senderCambioStato", senderCambioStato);
		
		setPreference(actionRequest, "subjectCambioStato", subjectCambioStato);
		
		setPreference(actionRequest, "senderStatoIndetta", senderStatoIndetta);
		
		setPreference(actionRequest, "subjectStatoIndetta", subjectStatoIndetta);
		
		setPreference(actionRequest, "ricercaRiunionetxt", ricercaRiunionetxt);
		
		setPreference(actionRequest, "ricercaRiunionetitle", ricercaRiunionetitle);
		
		setPreference(actionRequest, "creaRiunionetxt", creaRiunionetxt);
		
		setPreference(actionRequest, "creaRiunionetitle", creaRiunionetitle);
		
		setPreference(actionRequest, "luoghiRiunionetxt", luoghiRiunionetxt);
		
		setPreference(actionRequest, "luoghiRiunionetitle", luoghiRiunionetitle);
		
		setPreference(actionRequest, "convocantiRiunionetxt", convocantiRiunionetxt);
		
		setPreference(actionRequest, "convocantiRiunionetitle", convocantiRiunionetitle);
		
		setPreference(actionRequest, "modificaRiunionetxt", modificaRiunionetxt);
		
		setPreference(actionRequest, "modificaRiunionetitle", modificaRiunionetitle);
		
		setPreference(actionRequest, "stampaRiunionetxt", stampaRiunionetxt);
		
		setPreference(actionRequest, "stampaRiunionetitle", stampaRiunionetitle);
		
		setPreference(actionRequest, "accettaRiunionetxt", accettaRiunionetxt);
		
		setPreference(actionRequest, "accettaRiunionetitle", accettaRiunionetitle);
		
		
		
//		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "inserisciRiunione");
//		LocalizationUtil.setLocalizedPreferencesValues(actionRequest, preferences, "modificaRiunione");
//		
//		 preferences.store();
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(GestioneRiunioniFormConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(GestioneRiunioniFormConfig.class, properties);
	}

	private volatile GestioneRiunioniFormConfig _configuration;
	
	
	
	
}
