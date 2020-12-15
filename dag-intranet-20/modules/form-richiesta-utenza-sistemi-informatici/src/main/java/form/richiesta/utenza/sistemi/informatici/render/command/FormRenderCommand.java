package form.richiesta.utenza.sistemi.informatici.render.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import form.richiesta.utenza.sistemi.informatici.constants.FormRichiestaUtenzaSistemiInformaticiPortletKeys;

@Component(
    immediate = true,
    property = {
    		"javax.portlet.name=" + FormRichiestaUtenzaSistemiInformaticiPortletKeys.FormRichiestaUtenzaSistemiInformatici,
    		"mvc.command.name=/form-user-req/view_form"
    },
    service = MVCRenderCommand.class
)
public class FormRenderCommand implements MVCRenderCommand {
	
	private final Log _log = LogFactoryUtil.getLog(FormRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		_log.info("#################### render START ####################");
		
		//Se non è stato già fatto durante la sessione recupera i dati del richiedente dal SIAP
		PortletSession session = renderRequest.getPortletSession();
		Object siapUserInitO = session.getAttribute("siapUserInit", PortletSession.PORTLET_SCOPE);
		if(siapUserInitO == null)
			this.getSiapUserData(session);
		
		//a questo punto ci dovrebbero essere in sessione l'attributo siapUserInit + tutti quelli settati dalla getSiapUserData
		//se non è così c'è stata un navigazione con i bottoni aventi/indietro del browser
		if(session.getAttributeMap().size() == 1){
			renderRequest.setAttribute("isRiepilogo", false);
			session.removeAttribute("siapUserInit", PortletSession.PORTLET_SCOPE);
			return "/richiesta-utenza-errore.jsp";
			
		}
		
		_log.info("#################### render END ####################");
		
		return "/view.jsp";
	}
	
	
	
	private void getSiapUserData(PortletSession session){
		
		_log.info("#################### getSiapUserData START ####################");
		
		session.setAttribute("ufficioRichiedente", "my office");
		session.setAttribute("nome", "Michelangelo");
		session.setAttribute("cognome", "Buonarroti");
		session.setAttribute("ubicazioneAttuale", "VIA CESARE VIGNATI 2");
		session.setAttribute("palazzina", "88");
		session.setAttribute("piano", "5");
		session.setAttribute("scala", "A");
		session.setAttribute("stanza", "138");
		session.setAttribute("telefono", "346 96 76 867");
		session.setAttribute("emailDirigente", "nomedirigente@mef.gov.it");
		
		session.setAttribute("siapUserInit", "true");
		
		_log.info("#################### getSiapUserData END ####################");
	}




}
