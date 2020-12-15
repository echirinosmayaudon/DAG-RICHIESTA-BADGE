package form.contributo.solidarieta.mef.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import form.contributo.solidarieta.mef.constants.FormContributoSolidarietaMefPortletKeys;
import form.service.contributo.solidarieta.model.Donatore;
import form.service.contributo.solidarieta.service.DonatoreLocalService;
import form.service.contributo.solidarieta.service.DonatoreLocalServiceUtil;
import form.service.contributo.solidarieta.service.persistence.DonatorePersistence;

/**
 * @author S.Faina
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FormContributoSolidarietaMef",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/presentazione.jsp",
		"javax.portlet.name=" + FormContributoSolidarietaMefPortletKeys.FORMCONTRIBUTOSOLIDARIETAMEF,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FormContributoSolidarietaMefPortlet extends MVCPortlet {
	Log _log=LogFactoryUtil.getLog(this.getClass());
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.info("sono nel do view");
		try {
			User utenteCorrente = PortalUtil.getUser(renderRequest);
			_log.info("recuperato userr " + utenteCorrente);
			renderRequest.setAttribute("utente", utenteCorrente);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			User utente = PortalUtil.getUser(renderRequest);
			renderRequest.setAttribute("utente", utente);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	public void donate (ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		_log.info("sono nell metodo action ");
		User utenteLoggato = PortalUtil.getUser(actionRequest);
		_log.info("utente donatore : " + utenteLoggato);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		String data_inserimento = dtf.format(now).toString();
		_log.info("data inserimento: "+ data_inserimento);
		//RECUPERO MESE
		hiddenDefaultMessage(actionRequest);
		DateTimeFormatter dtfMese = DateTimeFormatter.ofPattern("MMMM", Locale.ITALY);
		String mese = dtfMese.format(now).toString();
		_log.info("MESE: " + mese);
		
		String importo = "";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest,"altroImporto"))){
			importo = ParamUtil.getString(actionRequest,"altroImporto");
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest,"importoContributo"))){
			importo = ParamUtil.getString(actionRequest,"importoContributo");
		}
		
		if(Validator.isNull(importo)) {
			actionRequest.setAttribute("utente", utenteLoggato);
			_log.error("non è stato inserito nessun importo");
			
			SessionErrors.add(actionRequest, "mef.no.param");
            actionResponse.setRenderParameter("jspPage", "/view.jsp");
			
		}else {
		try {
		
		
		 Donatore donatore =_donatoreLocalService.creaDonatore(utenteLoggato.getFirstName(), utenteLoggato.getLastName(), 
				utenteLoggato.getEmailAddress(), utenteLoggato.getScreenName(), importo, data_inserimento);
		_log.info("donatore creato correttamente : " + donatore);
	
		actionRequest.setAttribute("donatore", donatore);
		actionRequest.setAttribute("mese", mese);
		actionResponse.setRenderParameter("jspPage", "/ringraziamento.jsp");
		_log.info("donazione avvenuta con successo per l'utente: " + utenteLoggato.getScreenName());
		
		}catch(Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, "mef.ko");
			actionResponse.setRenderParameter("jspPage", "/view.jsp");
		}
		}
	}
	
	private void hiddenDefaultMessage(PortletRequest portletRequest) {
		SessionMessages.add(portletRequest,PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(portletRequest,PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	private DonatoreLocalService _donatoreLocalService;

    @Reference(unbind = "-")
    protected void setGroupLocalService(DonatoreLocalService _donatoreLocalService) {
        _log.info("_donatoreLocalService: "+_donatoreLocalService);
        this._donatoreLocalService = _donatoreLocalService;
    }
}