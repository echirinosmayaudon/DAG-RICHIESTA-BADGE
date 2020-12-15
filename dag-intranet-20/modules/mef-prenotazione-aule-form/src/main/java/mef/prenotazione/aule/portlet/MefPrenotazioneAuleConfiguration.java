package mef.prenotazione.aule.portlet;

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

import mef.prenotazione.aule.portlet.MefPrenotazioneAuleConfig;

@Component(configurationPid = "mef.prenotazione.aule.portlet.MefPrenotazioneAuleConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=mef_prenotazione_aule_portlet_MefPrenotazioneAuleFormmvcportletPortlet" }, service = ConfigurationAction.class)
public class MefPrenotazioneAuleConfiguration extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			 {
		try{
	
		String sender = ParamUtil.getString(actionRequest, "sender");
		String subjectNoApprovazione = ParamUtil.getString(actionRequest, "subjectNoApprovazione");
		String subjectApprovazione = ParamUtil.getString(actionRequest, "subjectApprovazione");
		String subjectPrenotazioneAutorizzata = ParamUtil.getString(actionRequest, "subjectPrenotazioneAutorizzata");
		String subjectPrenotazioneRifiutata = ParamUtil.getString(actionRequest, "subjectPrenotazioneRifiutata");
		String subjectPrenotazioneModificata = ParamUtil.getString(actionRequest, "subjectPrenotazioneModificata");
		String subjectPrenotazioneEliminata = ParamUtil.getString(actionRequest, "subjectPrenotazioneEliminata");
		String richiestaNoApprovazioneTmpl = ParamUtil.getString(actionRequest, "richiestaNoApprovazioneTmpl");
		String richiestaApprovazioneTmpl = ParamUtil.getString(actionRequest, "richiestaApprovazioneTmpl");
		String prenotazioneAutorizzataTmpl = ParamUtil.getString(actionRequest, "prenotazioneAutorizzataTmpl");
		String prenotazioneRifiutataTmpl = ParamUtil.getString(actionRequest, "prenotazioneRifiutataTmpl");
		String prenotazioneModificataTmpl = ParamUtil.getString(actionRequest, "prenotazioneModificataTmpl");
		String prenotazioneEliminataTmpl = ParamUtil.getString(actionRequest, "prenotazioneEliminataTmpl");
		String formTitleInsertPrenotazioni = ParamUtil.getString(actionRequest, "formTitleInsertPrenotazioni");
		String formSubtitleInsertPrenotazioni = ParamUtil.getString(actionRequest, "formSubtitleInsertPrenotazioni");
		String formTitleLeTuePrenotazioni = ParamUtil.getString(actionRequest, "formTitleLeTuePrenotazioni");
		String formSubtitleLeTuePrenotazioni = ParamUtil.getString(actionRequest, "formSubtitleLeTuePrenotazioni");
		String formTitleRicercaAule = ParamUtil.getString(actionRequest, "formTitleRicercaAule");
		String formSubtitleRicercaAule = ParamUtil.getString(actionRequest, "formSubtitleRicercaAule");
		String formTitleRicercaAuleApprovatore = ParamUtil.getString(actionRequest, "formTitleRicercaAuleApprovatore");
		String formSubtitleRicercaAuleApprovatore = ParamUtil.getString(actionRequest, "formSubtitleRicercaAuleApprovatore");
		
		setPreference(actionRequest, "sender", sender);
		setPreference(actionRequest, "subjectNoApprovazione", subjectNoApprovazione);
		setPreference(actionRequest, "subjectApprovazione", subjectApprovazione);
		setPreference(actionRequest, "subjectPrenotazioneAutorizzata", subjectPrenotazioneAutorizzata);
		setPreference(actionRequest, "subjectPrenotazioneRifiutata", subjectPrenotazioneRifiutata);
		setPreference(actionRequest, "subjectPrenotazioneModificata", subjectPrenotazioneModificata);
		setPreference(actionRequest, "subjectPrenotazioneEliminata", subjectPrenotazioneEliminata);
		setPreference(actionRequest, "richiestaNoApprovazioneTmpl", richiestaNoApprovazioneTmpl);
		setPreference(actionRequest, "richiestaApprovazioneTmpl", richiestaApprovazioneTmpl);
		setPreference(actionRequest, "prenotazioneAutorizzataTmpl", prenotazioneAutorizzataTmpl);
		setPreference(actionRequest, "prenotazioneRifiutataTmpl", prenotazioneRifiutataTmpl);
		setPreference(actionRequest, "prenotazioneModificataTmpl", prenotazioneModificataTmpl);
		setPreference(actionRequest, "prenotazioneEliminataTmpl", prenotazioneEliminataTmpl);
		setPreference(actionRequest, "formTitleInsertPrenotazioni", formTitleInsertPrenotazioni);
		setPreference(actionRequest, "formSubtitleInsertPrenotazioni", formSubtitleInsertPrenotazioni);
		setPreference(actionRequest, "formTitleLeTuePrenotazioni", formTitleLeTuePrenotazioni);
		setPreference(actionRequest, "formSubtitleLeTuePrenotazioni", formSubtitleLeTuePrenotazioni);
		setPreference(actionRequest, "formTitleRicercaAule", formTitleRicercaAule);
		setPreference(actionRequest, "formSubtitleRicercaAule", formSubtitleRicercaAule);
		setPreference(actionRequest, "formTitleRicercaAuleApprovatore", formTitleRicercaAuleApprovatore);
		setPreference(actionRequest, "formSubtitleRicercaAuleApprovatore", formSubtitleRicercaAuleApprovatore);
		super.processAction(portletConfig, actionRequest, actionResponse);

			 }catch(Exception e)
			 {
				 System.out.println(e);
			 }
		
	}
	
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(MefPrenotazioneAuleConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefPrenotazioneAuleConfig.class, properties);
	}

	private volatile MefPrenotazioneAuleConfig _configuration;

	
}
