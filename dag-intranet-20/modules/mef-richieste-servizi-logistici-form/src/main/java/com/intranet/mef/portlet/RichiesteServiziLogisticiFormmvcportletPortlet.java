package com.intranet.mef.portlet;

import com.intranet.mef.bean.Richiedente;
import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.util.EmailSender;
import com.intranet.mef.util.ServiziLogisticiDataUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import service.intranet.mef.model.LogisticaRichieste;
import service.intranet.mef.service.LogisticaRichiesteLocalServiceUtil;

import service.intranet.mef.service.LogisticaServizioLocalServiceUtil;
import service.intranet.mef.model.LogisticaServizio;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Mef richieste servizi logistici form",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RichiesteServiziLogisticiFormmvcportletPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(RichiesteServiziLogisticiFormmvcportletPortlet.class);
	
	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";
	
	public static final String RICHIEDENTE = "richiedentelogistici";
	
	public static final String GESTORE_DT = "gestoredt";
	public static final String GESTORE_RGS = "gestorergs";
	public static final String GESTORE_DF = "gestoredf";
	public static final String GESTORE_DAG = "gestoredag";
	
	private final String _navigation = "navigation";
	
	private Richiedente _richiedente = null;

	private User getUsertByCustomField(long companyId,String fieldName, String fieldValue)
		throws PortalException {
	
		List<ExpandoValue> values = ExpandoValueLocalServiceUtil.getColumnValues(
			companyId, User.class.getName(),
			ExpandoTableConstants.DEFAULT_TABLE_NAME, fieldName, fieldValue,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
		for (ExpandoValue value : values) {
			User  user = UserLocalServiceUtil.getUser(value.getClassPK());
				return user;		
		}
	
		return null;
	} 
	
	private Richiedente createRichiedente(User user, long companyId) {
		Richiedente richiedente = new Richiedente();
	try{
		
		if(user!=null){
		if ((user.getExpandoBridge()!=null) && (user.getExpandoBridge().getAttribute(_customFieldUserOrg)!=null)){
			String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
			if(organizationId!=null && organizationId!=""){
				Long idChart = Long.parseLong(organizationId);
				OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
				
				if(orgChart!=null){
					long locationId = orgChart.getLocationId();
					List<Location> locationlist=CentralInvokerLocalServiceUtil.findLocationById(locationId);
			
					if(locationlist!=null && !locationlist.isEmpty()){
						richiedente.setUbicazione(locationlist.get(0).getName());
					}
						
					richiedente.setUfficioRichiedente(orgChart.getName());
					long direzioneId= orgChart.getIdParent();

					OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(direzioneId);
					if(direzioneOrgChart!=null){
						richiedente.setOrganizzazione(direzioneOrgChart.getName());
					}
					
				}
			}

		}else
			_log.warn(_customFieldUserOrg + " not defined for the user");
		
				richiedente.setNome(user.getFirstName());
				richiedente.setCognome(user.getLastName());
				richiedente.setPalazzina("");
				richiedente.setEmailRichiedente(user.getEmailAddress());

				List<Address> listaIndirizzi = user.getAddresses();
				List<Phone> listaPhones =user.getPhones();
				
				for (Address addressItem: listaIndirizzi){
					if(("Business").equalsIgnoreCase(addressItem.getType().getName())){
						richiedente.setPiano(addressItem.getStreet1());
						richiedente.setScala(addressItem.getStreet2());
						richiedente.setStanza(addressItem.getStreet3());
						break;
					}
				}
				
				for (Phone phoneItem: listaPhones){
					if(("Business").equalsIgnoreCase(phoneItem.getType().getName())){	
						richiedente.setTelefono(phoneItem.getNumber());
						break;
					}
				}
			
				if ((user.getExpandoBridge()!=null) && (user.getExpandoBridge().getAttribute(_customFieldUserDirector)!=null)){
					String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
					User cuser=getUsertByCustomField(companyId,_customFieldUserPersonal,directorId);
					if(cuser!=null)
						richiedente.setEmailDirigente(cuser.getEmailAddress());
				}else
					_log.warn(_customFieldUserDirector + " not defined for the user");
				
				
		}
	}catch(Exception e){
		_log.warn("error in retrieve user informations"+e);
		_log.warn(e);
	}
	return richiedente;
	}
	
   
	private String getEmailUfficio(User user, long companyId){
		String email= "";
		try{			
			if ((user!=null) && (user.getExpandoBridge()!=null) && (user.getExpandoBridge().getAttribute(_customFieldUserOrg)!=null)){
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if(organizationId!=null && !"".equals(organizationId)){
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if(orgChart!=null){
					 email= orgChart.getEmailOffice();
					}
				}

			}else
				_log.warn(_customFieldUserOrg + " not defined for this user: ");
		
		}catch(Exception e){
			_log.warn("error in retrieve user informations"+e);
			_log.warn(e);
		}
		
		return email;
		
	}
	
	private String getDipartimentoFromUserLocation(User user, long companyId) {
		
	    String nomeDip="";
		
		try{			
			if ((user!=null) && (user.getExpandoBridge()!=null) && (user.getExpandoBridge().getAttribute(_customFieldUserOrg)!=null)){
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if(organizationId!=null && !"".equals(organizationId)){
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if(orgChart!=null){
						int livello = orgChart.getLevel();
						long direzioneId= orgChart.getIdParent();
						if(livello !=2){
							OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(direzioneId);
							if(direzioneOrgChart!=null){
								int livelloDipartimento = direzioneOrgChart.getLevel();
								long dipartimentoId= direzioneOrgChart.getIdParent();
								if(livelloDipartimento != 2){
									OrganizationChart dipartimentoOrgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(dipartimentoId);
									nomeDip=dipartimentoOrgChart.getName();
								}else{
									nomeDip=direzioneOrgChart.getName();
								}
							}
						}else{
							nomeDip=orgChart.getName();
						}
					}
				}

			}else
				_log.warn(_customFieldUserOrg + " not defined for this user: ");
		
		}catch(Exception e){
			_log.warn("error in retrieve user informations"+e);
			_log.warn(e);
		}
		
		return nomeDip;
		
	}
	
	private String getDipartimentoFromGestore(String role){
		String department;
		switch (role) {
		case GESTORE_DT:
			department = "DIP. I - TESORO";
			break;
		case GESTORE_RGS:
			department = "DIP. II - RGS";
			break;
		case GESTORE_DF:
			department = "DIP. III - DIPARTIMENTO DELLE FINANZE";
			break;				
		case GESTORE_DAG:
			department = "DIP. IV - AMM. GEN. PERSONALE";
			break;

		default:
			department = "";
			break;
		}
		return department;
	}
	
	
	private String getRoleForDipartimento(User user, long companyId){
		
		    String role;
		    String nomeDip= getDipartimentoFromUserLocation(user,companyId);
		    
			switch (nomeDip) {
			case "DIP. I - TESORO":
				role = GESTORE_DT;
				break;
			case "DIP. II - RGS":
				role = GESTORE_RGS;
				break;
			case "DIP. III - DIPARTIMENTO DELLE FINANZE":
				role = GESTORE_DF;
				break;				
			case "DIP. IV - AMM. GEN. PERSONALE":
				role = GESTORE_DAG;
				break;

			default:
				role="";
				break;
			}

		return role;
	}
	
@Override
public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
	renderRequest.setAttribute(RichiesteServiziLogisticiConfig.class.getName(), _configuration);
	
	if(renderRequest.getParameter("role")!=null){
		renderRequest.setAttribute("role", "richiedente" );
	
	}
	if(renderRequest.getParameter("richiestaId")!=null){
		
		LogisticaRichieste richiestaUpdated = LogisticaRichiesteLocalServiceUtil.fetchLogisticaRichieste(Long.parseLong(renderRequest.getParameter("richiestaId")));
		renderRequest.setAttribute("richiesta", richiestaUpdated );
		
	}
	if(renderRequest.getParameter("navigation")!=null){
		renderRequest.setAttribute("navigation", "dettaglio");

	}
	ServiziLogisticiDataUtil.createTablesLogistica();
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	String navigation = (String) renderRequest.getAttribute("navigation");
	if (navigation == null) {
		User user = themeDisplay.getUser();
		//String screenName = user.getScreenName();	
		long companyId=themeDisplay.getCompanyId();
		List<Role> listaRuoli=user.getRoles();
		boolean gestore= false;
		boolean  richiedente = false;
		String gestoreRole = "";
		for(Role ruolo: listaRuoli){
			if(ruolo.getName().equalsIgnoreCase(GESTORE_DT) || ruolo.getName().equalsIgnoreCase(GESTORE_RGS) || ruolo.getName().equalsIgnoreCase(GESTORE_DF) || ruolo.getName().equalsIgnoreCase(GESTORE_DAG)){
				gestore=true;
				gestoreRole=ruolo.getName();
			    break;
			}
			if(ruolo.getName().equalsIgnoreCase(RICHIEDENTE)){
				richiedente=true;
			    break;
			}	
			
		}
	
	if(gestore){
		List<LogisticaRichieste> sortableListaRichieste = getSortesdListRichiesteForDipartimento(getDipartimentoFromGestore(gestoreRole));		
		renderRequest.setAttribute("listarichieste", sortableListaRichieste);			 
		renderRequest.setAttribute(_navigation, "elenco");
	}else if(richiedente){	
		_richiedente = createRichiedente(user,companyId);
		
		List<LogisticaServizio> servizi = LogisticaServizioLocalServiceUtil.getLogisticaServizios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);		

		renderRequest.setAttribute("servizi", servizi);
		renderRequest.setAttribute("richiedente", _richiedente);
		renderRequest.setAttribute(_navigation, "inserimento");
	}else{
		renderRequest.setAttribute(_navigation, "forbidden");
	}
	}
	super.doView(renderRequest, renderResponse);
}


public void insertServizio(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, PortalException, Exception {
	 String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");	
	 String organizzazione = actionRequest.getParameter("organizzazione");			
	 String nome = actionRequest.getParameter("nome");		
	 String cognome = actionRequest.getParameter("cognome");	
	 String ubicazione = actionRequest.getParameter("ubicazione");
	 String palazzina = actionRequest.getParameter("palazzina");		
	 String piano = actionRequest.getParameter("piano");	
	 String scala = actionRequest.getParameter("scala");	
	 String stanza = actionRequest.getParameter("stanza");
	 String telefono = actionRequest.getParameter("telefono");
	 String emailRichiedente = actionRequest.getParameter("emailRichiedente");
	 String emailDirigente = actionRequest.getParameter("emailDirigente");

	 String oggettoRichiesta = actionRequest.getParameter("oggettoRichiesta");
	 Date dataRichiesta = new Date();
	 String note = actionRequest.getParameter("note");
	 String richiesteJson = actionRequest.getParameter("richiesteJson");

	 Richiedente richiedente = new Richiedente();
	 richiedente.setOrganizzazione(organizzazione);
	 richiedente.setUfficioRichiedente(ufficioRichiedente);
	 richiedente.setNome(nome);
	 richiedente.setCognome(cognome);
	 richiedente.setUbicazione(ubicazione);
	 richiedente.setPalazzina(palazzina);
	 richiedente.setPiano(piano);
	 richiedente.setScala(scala);
	 richiedente.setStanza(stanza);
	 richiedente.setTelefono(telefono);
	 richiedente.setEmailRichiedente(emailRichiedente);
	 richiedente.setEmailDirigente(emailDirigente);

	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	 User user = themeDisplay.getUser();
	 String screenName = user.getScreenName();
	 long companyId = themeDisplay.getCompanyId();
	 
	 try{ 
		     //insert db
		 
		     String departmentName = getDipartimentoFromUserLocation(user,companyId);
		     LogisticaRichieste richiestaLog=LogisticaRichiesteLocalServiceUtil.insertRichiestaLogistici(oggettoRichiesta, screenName, departmentName, dataRichiesta, richiedente.toJSON(), richiesteJson, null, 0, 1, note);
 
			 //send email
			 
			 //prepare data
		     if(richiestaLog!=null){
		    	 ServiziLogisticiDataUtil datautil = new ServiziLogisticiDataUtil();		 			 
				 PortletURL renderUrl =  PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			     renderUrl.setWindowState(LiferayWindowState.NORMAL);
			     renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			     renderUrl.setParameter("richiestaId", Long.toString(richiestaLog.getId()));
			     renderUrl.setParameter("roleuser", "gestore");
			     String mailbody =actionRequest.getPreferences().getValue("richiestaTmpl", _configuration.richiestaTmpl());
	       	  	 String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER); 
	       	  	 String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
	             String subject = actionRequest.getPreferences().getValue("subject", _configuration.subject());
				 String datirichiedente = getHtmlRichiedente(richiedente);
				 String datirichiesta = getHtmlRichiesta(oggettoRichiesta,dataRichiesta,note, datautil.richiestaJsontoData(richiesteJson));
			     mailbody = StringUtil.replace(mailbody, new String[] {"[$DATIRICHIEDENTE$]","[$DATI$]","[$LINK$]"}, new String[] {datirichiedente,datirichiesta,renderUrl.toString()});  
			     EmailSender mail= new EmailSender();

			    Long rolegestoretoreid=0L;	                  
	            List<Role> roles=RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
	               for(Role role:roles)      {
	                   if(role.getName().equalsIgnoreCase(getRoleForDipartimento(user,companyId))){
	                	   rolegestoretoreid=role.getRoleId();
	                	   break;
	                   }
	            	  
	               }
	               
			    List<User> users = UserLocalServiceUtil.getRoleUsers(rolegestoretoreid);
			    String emailDirigenteOriginale = createRichiedente(user,companyId).getEmailDirigente();

				for(User utentegestore: users){
						 mail.sendMailMessage(subject, mailbody, sender, smtpUser,utentegestore.getEmailAddress(),emailDirigenteOriginale,null );
				}
				
				PortletURL refreshUrl=  PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				actionResponse.sendRedirect(refreshUrl.toString()); 
		     }
		     else{
		    	 SessionErrors.add(actionRequest, "Errore-durante-inserimento-dati");
		    	 SessionMessages.add(actionRequest,
							PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);	
					actionRequest.setAttribute(_navigation, null);
		     }
			
		} catch (Exception e) {
			_log.warn(e);
			SessionErrors.add(actionRequest, "Errore-durante-inserimento-dati");

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		
			actionRequest.setAttribute(_navigation, null);

		}	
}

public void detailRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, PortalException, Exception {
	
	String idRichiesta = actionRequest.getParameter("richiestaId");
	LogisticaRichieste richiesta=LogisticaRichiesteLocalServiceUtil.getLogisticaRichieste(Long.parseLong(idRichiesta));
	
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
	User user = themeDisplay.getUser();
	List<Role> listaRuoli=user.getRoles();
	boolean gestore= false;
	for(Role ruolo: listaRuoli){
		if(ruolo.getName().equalsIgnoreCase(GESTORE_DT) || ruolo.getName().equalsIgnoreCase(GESTORE_RGS) || ruolo.getName().equalsIgnoreCase(GESTORE_DF) || ruolo.getName().equalsIgnoreCase(GESTORE_DAG)){
			gestore=true;
		    break;
	}
	}
	
	if(gestore)
		actionRequest.setAttribute("role", "gestore" );
	else
		actionRequest.setAttribute("role", "richiedente" );
	
	actionRequest.setAttribute("richiesta", richiesta );
	actionRequest.setAttribute("navigation", "dettaglio");

}


public void evadiValutaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, PortalException, Exception {
	String idRichiesta = actionRequest.getParameter("richiestaId");
	String stato =  actionRequest.getParameter("idstato");
	String valutazione=  actionRequest.getParameter("valutazione");
	LogisticaRichieste richiesta=LogisticaRichiesteLocalServiceUtil.getLogisticaRichieste(Long.parseLong(idRichiesta));
	
	if(("nonevasa").equals(stato)){
		richiesta.setId_stato(5);
	}
	
	if (("evasa").equals(stato)) {
			richiesta.setId_stato(4);
			
			switch (valutazione) {
			case "buono":
				richiesta.setId_valutazione(1);
				break;
			case "scarso":
				richiesta.setId_valutazione(3);
				break;
			case "sufficiente":
			default:
				richiesta.setId_valutazione(2);
				break;
			}

		}
	
	LogisticaRichieste richiestaupdated = LogisticaRichiesteLocalServiceUtil.updateLogisticaRichieste(richiesta);

	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

	
	PortletURL refreshUrl=  PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	refreshUrl.setParameter("role", "richiedente" );
	refreshUrl.setParameter("richiestaId", Long.toString(richiestaupdated.getId()));
	refreshUrl.setParameter("navigation", "dettaglio");
	actionResponse.sendRedirect(refreshUrl.toString());
}


public void accettaRifiutaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, PortalException, Exception {
	
	String idRichiesta = actionRequest.getParameter("richiestaId");
	String stato =  actionRequest.getParameter("idstato");
	LogisticaRichieste richiesta=LogisticaRichiesteLocalServiceUtil.getLogisticaRichieste(Long.parseLong(idRichiesta));
	ServiziLogisticiDataUtil datautil = new ServiziLogisticiDataUtil();
	String mailbody =actionRequest.getPreferences().getValue("cambioStatoTmpl", _configuration.cambioStatoTmpl());
	String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER); 
	String sender = actionRequest.getPreferences().getValue("cambioStatosender", _configuration.cambioStatosender());
	String subject = actionRequest.getPreferences().getValue("cambioStatosubject", _configuration.cambioStatosubject());
    Richiedente richiedente = datautil.richiedenteJsontoData(richiesta.getDettaglio_richiedente());      
	String datirichiedente = getHtmlRichiedente(richiedente);
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);        
    User userRichiedente = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), richiesta.getUtente());	        
    EmailSender mail = new EmailSender();
    String emailRichiedenteUtente = null;
    
    if(richiedente!=null) {
	    if (richiedente.getEmailRichiedente()!=null && userRichiedente!=null && !richiedente.getEmailRichiedente().equals(userRichiedente.getEmailAddress())){
	        emailRichiedenteUtente = userRichiedente.getEmailAddress();
	    }
    

    if(("accetta").equals(stato)){
		richiesta.setId_stato(2);
		 String datirichiesta = getHtmlAccettaRifiuta(richiesta.getOggetto(),richiesta.getData_richiesta(),richiesta.getNote(), datautil.richiestaJsontoData(richiesta.getDettaglio_richieste()),"accettata");
	        mailbody = StringUtil.replace(mailbody, new String[] {"[$DATIRICHIEDENTE$]","[$DATI$]"}, new String[] {datirichiedente,datirichiesta});
	        
	        User userDirigente = themeDisplay.getUser();
	        long companyId= themeDisplay.getCompanyId();
	        String 	emailUfficioPreposto=getEmailUfficio(userDirigente,companyId);
	        if(emailUfficioPreposto!=null && !"".equals(emailUfficioPreposto))
	        	mail.sendMailMessage(subject, mailbody, sender, smtpUser, richiedente.getEmailRichiedente(),emailUfficioPreposto,emailRichiedenteUtente);
	        else
	        	mail.sendMailMessage(subject, mailbody, sender, smtpUser, richiedente.getEmailRichiedente(),emailRichiedenteUtente,null);	       		
	}
	
	if(("rifiuta").equals(stato)){
		richiesta.setId_stato(3);
		 String datirichiesta = getHtmlAccettaRifiuta(richiesta.getOggetto(),richiesta.getData_richiesta(),richiesta.getNote(), datautil.richiestaJsontoData(richiesta.getDettaglio_richieste()),"rifiutata");
	        mailbody = StringUtil.replace(mailbody, new String[] {"[$DATIRICHIEDENTE$]","[$DATI$]"}, new String[] {datirichiedente,datirichiesta});  
	               
	        mail.sendMailMessage(subject, mailbody, sender, smtpUser, richiedente.getEmailRichiedente(),emailRichiedenteUtente,null);
	}
    }
	LogisticaRichieste richiestaupdated = LogisticaRichiesteLocalServiceUtil.updateLogisticaRichieste(richiesta);
	PortletURL refreshUrl=  PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	refreshUrl.setParameter("role", "gestore" );
	refreshUrl.setParameter("richiestaId", Long.toString(richiestaupdated.getId()));
	refreshUrl.setParameter("navigation", "dettaglio");
	actionResponse.sendRedirect(refreshUrl.toString());
	


}

public void gotoElenco(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, PortalException, Exception {
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	User user = themeDisplay.getUser();
	String screenName = user.getScreenName();
	
	List<Role> listaRuoli=user.getRoles();
	boolean gestore= false;
	String roleName= "";
	for(Role ruolo: listaRuoli){
		if(ruolo.getName().equalsIgnoreCase(GESTORE_DT) || ruolo.getName().equalsIgnoreCase(GESTORE_RGS) || ruolo.getName().equalsIgnoreCase(GESTORE_DF) || ruolo.getName().equalsIgnoreCase(GESTORE_DAG)){
			gestore=true;
			roleName=ruolo.getName();
		    break;
		}
	}
	List<LogisticaRichieste> sortableListaRichieste;
	if(gestore){
		sortableListaRichieste = getSortesdListRichiesteForDipartimento(getDipartimentoFromGestore(roleName));	
	}else{
		sortableListaRichieste = getSortesdListRichieste(screenName);		
	}
	
	actionRequest.setAttribute("listarichieste", sortableListaRichieste);			 
	actionRequest.setAttribute(_navigation, "elenco");

}

public void gotoRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, PortalException, Exception {
	     actionRequest.setAttribute(_navigation, null);

}

private List<LogisticaRichieste> getSortesdListRichieste(String screenName){
	 List<LogisticaRichieste> listaRichieste = LogisticaRichiesteLocalServiceUtil.getLogisticaRichiesteByUtente(screenName);
	    List<LogisticaRichieste> sortableListaRichieste = new ArrayList<LogisticaRichieste>(listaRichieste);
	    
	    if(!sortableListaRichieste.isEmpty() && sortableListaRichieste.size()>1){
	    	Collections.sort(sortableListaRichieste, new Comparator<LogisticaRichieste>() {
			@Override
			public int compare(LogisticaRichieste o1, LogisticaRichieste o2) {
				if (o2.getData_richiesta().before(o1.getData_richiesta()))
					return -1;
				return 1;
			}
		});
	    }
	    return sortableListaRichieste;
}

private List<LogisticaRichieste> getSortesdListRichiesteForDipartimento(String dipartimento){
	
	
     List<LogisticaRichieste> listaRichieste = LogisticaRichiesteLocalServiceUtil.getListLogRichiesteByDip(dipartimento);

	 List<LogisticaRichieste> sortableListaRichieste = null;
	 
	    if(listaRichieste!=null)
	    	sortableListaRichieste = new ArrayList<LogisticaRichieste>(listaRichieste);
	    
	    if(sortableListaRichieste!=null && !sortableListaRichieste.isEmpty() && sortableListaRichieste.size()>1){
		Collections.sort(sortableListaRichieste, new Comparator<LogisticaRichieste>() {
			@Override
			public int compare(LogisticaRichieste o1, LogisticaRichieste o2) {
				if (o2.getData_richiesta().before(o1.getData_richiesta()))
					return -1;
				return 1;
			}
		});
	    }
	    return sortableListaRichieste;
}

private String getHtmlRichiedente(Richiedente richiesta){
	StringBuilder dati = new StringBuilder();
	if(richiesta!=null){
		createHtmlForData(dati,"Organizzazione",richiesta.getOrganizzazione());
		createHtmlForData(dati,"Ufficio Richiedente",richiesta.getUfficioRichiedente());
		createHtmlForData(dati,"Nome",richiesta.getNome());
		createHtmlForData(dati,"Cognome",richiesta.getCognome());
		createHtmlForData(dati,"Ubicazione Attuale",richiesta.getUbicazione());
		createHtmlForData(dati,"Palazzina",richiesta.getPalazzina());
		createHtmlForData(dati,"Piano",richiesta.getPiano());
		createHtmlForData(dati,"Scala",richiesta.getScala());
		createHtmlForData(dati,"Stanza",richiesta.getStanza());
		createHtmlForData(dati,"Telefono",richiesta.getTelefono());
		createHtmlForData(dati,"Email Dirigente",richiesta.getEmailDirigente());
		createHtmlForData(dati,"Email Richiedente",richiesta.getEmailRichiedente());
	}
	return dati.toString();
}

private String getHtmlRichiesta(String oggetto,Date data,String note, List<String> richieste){	
	StringBuilder dati = new StringBuilder();
		createHtmlForData(dati,"Oggetto",oggetto);
		createHtmlForData(dati,"Data inserimento", new SimpleDateFormat("dd-MM-yyyy").format(data));
		for(String richiesta :richieste){
			createHtmlForData(dati,"Servizio",richiesta);
		}
		createHtmlForData(dati,"Note",note);

	return dati.toString();
}

private String getHtmlAccettaRifiuta(String oggetto,Date data,String note, List<String> richieste, String esitorichiesta){	
	StringBuilder dati = new StringBuilder();
		createHtmlForData(dati,"Oggetto",oggetto);
		createHtmlForData(dati,"Data inserimento", new SimpleDateFormat("dd-MM-yyyy").format(data));
		for(String richiesta :richieste){
			createHtmlForData(dati,"Servizio",richiesta);
		}
		createHtmlForData(dati,"Note",note);
		createHtmlForData(dati,"la richiesta \u00E8 stata",esitorichiesta);
		
	return dati.toString();
}

private StringBuilder createHtmlForData(StringBuilder strportion, String title, String data){
	strportion.append("</br>");				
	strportion.append("<p>");
	strportion.append("<b>"+title+":</b>");
	strportion.append(" ");
	if(data!=null)
		strportion.append(data);
	else
		strportion.append("");
	strportion.append("</p> ");
	strportion.append("</br>");
	return strportion;
}

@Activate
@Modified
protected void activate(Map<String, Object> properties) {
	_configuration = ConfigurableUtil.createConfigurable(RichiesteServiziLogisticiConfig.class, properties);
}

private volatile RichiesteServiziLogisticiConfig _configuration;
}