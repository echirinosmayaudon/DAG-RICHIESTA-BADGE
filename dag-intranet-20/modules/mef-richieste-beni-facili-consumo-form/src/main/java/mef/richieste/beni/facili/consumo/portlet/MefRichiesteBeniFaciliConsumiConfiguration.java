package mef.richieste.beni.facili.consumo.portlet;

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



@Component(configurationPid = "mef.richieste.beni.facili.consumo.portlet.MefRichiesteBeniFaciliConsumiConfig", configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = {
"javax.portlet.name=mef_richieste_beni_facili_consumo_portlet_MefRichiesteBeniFaciliConsumiFormPortlet" }, service = ConfigurationAction.class)
public class MefRichiesteBeniFaciliConsumiConfiguration extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String orarioSostituzione = ParamUtil.getString(actionRequest, "orarioSostituzione");
		String orarioRitiro = ParamUtil.getString(actionRequest, "orarioRitiro");
		String senderBeni = ParamUtil.getString(actionRequest, "senderBeni");
		String emailReferente = ParamUtil.getString(actionRequest, "emailReferente");
		String subjectNuova = ParamUtil.getString(actionRequest, "subjectNuova");
		String subjectApprovazione = ParamUtil.getString(actionRequest, "subjectApprovazione");
		String richiestaBeniTmpl = ParamUtil.getString(actionRequest, "richiestaBeniTmpl");
		String approvatoTmpl = ParamUtil.getString(actionRequest, "approvatoTmpl");
		String formTitle = ParamUtil.getString(actionRequest, "formTitle");
		String formSubtitle = ParamUtil.getString(actionRequest, "formSubtitle");
		String riepilogoTitle = ParamUtil.getString(actionRequest, "riepilogoTitle");
		String riepilogoSubtitle = ParamUtil.getString(actionRequest, "riepilogoSubtitle");
		String gestioneUtentiTitle = ParamUtil.getString(actionRequest, "gestioneUtentiTitle");
		String gestioneUtentiSubtitle = ParamUtil.getString(actionRequest, "gestioneUtentiSubtitle");
		String cercaRichiestaTitle = ParamUtil.getString(actionRequest, "cercaRichiestaTitle");
		String cercaRichiestaSubtitle = ParamUtil.getString(actionRequest, "cercaRichiestaSubtitle");
		String oggettoBeniStandard = ParamUtil.getString(actionRequest, "oggettoBeniStandard");
		String oggettoBeniInformatica = ParamUtil.getString(actionRequest, "oggettoBeniInformatica");
		String itemsPerPage = ParamUtil.getString(actionRequest, "itemsPerPage");
		String listaTitle = ParamUtil.getString(actionRequest, "listaTitle");
		String listaSubtitle = ParamUtil.getString(actionRequest, "listaSubtitle");
		String rifiutaTmpl = ParamUtil.getString(actionRequest, "rifiutaTmpl");
		String subjectRifiuta = ParamUtil.getString(actionRequest, "subjectRifiuta");
		String subjectAggiorna = ParamUtil.getString(actionRequest, "subjectAggiorna");
		String aggiornaTmpl = ParamUtil.getString(actionRequest, "aggiornaTmpl");
		String indirizzoMagazzino = ParamUtil.getString(actionRequest, "indirizzoMagazzino");
		String ubicazioneMagazzino = ParamUtil.getString(actionRequest, "ubicazioneMagazzino");
		String approvazioneDT = ParamUtil.getString(actionRequest, "approvazioneDT");
		String approvazioneRGS = ParamUtil.getString(actionRequest, "approvazioneRGS");
		String approvazioneDF = ParamUtil.getString(actionRequest, "approvazioneDF");
		String approvazioneDAG = ParamUtil.getString(actionRequest, "approvazioneDAG");
		String listaUfficiGeco = ParamUtil.getString(actionRequest, "listaUfficiGeco");
		String ambienteGecoPigreco = ParamUtil.getString(actionRequest, "ambienteGecoPigreco");
		
		setPreference(actionRequest, "ubicazioneMagazzino", ubicazioneMagazzino);
		setPreference(actionRequest, "indirizzoMagazzino", indirizzoMagazzino);
		setPreference(actionRequest, "orarioSostituzione", orarioSostituzione);
		setPreference(actionRequest, "orarioRitiro", orarioRitiro);
		setPreference(actionRequest, "senderBeni", senderBeni);
		setPreference(actionRequest, "emailReferente", emailReferente);
		setPreference(actionRequest, "subjectNuova", subjectNuova);
		setPreference(actionRequest, "subjectApprovazione", subjectApprovazione);
		setPreference(actionRequest, "subjectRifiuta", subjectRifiuta);
		setPreference(actionRequest, "subjectAggiorna", subjectAggiorna);
		setPreference(actionRequest, "richiestaBeniTmpl", richiestaBeniTmpl);
		setPreference(actionRequest, "approvatoTmpl", approvatoTmpl);
		setPreference(actionRequest, "rifiutaTmpl", rifiutaTmpl);
		setPreference(actionRequest, "aggiornaTmpl", aggiornaTmpl);
		setPreference(actionRequest, "formTitle", formTitle);
		setPreference(actionRequest, "formSubtitle", formSubtitle);
		setPreference(actionRequest, "riepilogoTitle", riepilogoTitle);
		setPreference(actionRequest, "riepilogoSubtitle", riepilogoSubtitle);
		setPreference(actionRequest, "gestioneUtentiTitle", gestioneUtentiTitle);
		setPreference(actionRequest, "gestioneUtentiSubtitle", gestioneUtentiSubtitle);
		setPreference(actionRequest, "cercaRichiestaTitle", cercaRichiestaTitle);
		setPreference(actionRequest, "cercaRichiestaSubtitle", cercaRichiestaSubtitle);
		setPreference(actionRequest, "oggettoBeniStandard", oggettoBeniStandard);
		setPreference(actionRequest, "oggettoBeniInformatica", oggettoBeniInformatica);
		setPreference(actionRequest, "itemsPerPage", itemsPerPage);
		setPreference(actionRequest, "listaTitle", listaTitle);
		setPreference(actionRequest, "listaSubtitle", listaSubtitle);
		setPreference(actionRequest, "approvazioneDT", approvazioneDT);
		setPreference(actionRequest, "approvazioneRGS", approvazioneRGS);
		setPreference(actionRequest, "approvazioneDF", approvazioneDF);
		setPreference(actionRequest, "approvazioneDAG", approvazioneDAG);
		setPreference(actionRequest, "listaUfficiGeco", listaUfficiGeco);
		setPreference(actionRequest, "ambienteGecoPigreco", ambienteGecoPigreco);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
				
		httpServletRequest.setAttribute(MefRichiesteBeniFaciliConsumiConfig.class.getName(), _configuration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiesteBeniFaciliConsumiConfig.class, properties);
	}

	private volatile MefRichiesteBeniFaciliConsumiConfig _configuration;
	
	
	
}
