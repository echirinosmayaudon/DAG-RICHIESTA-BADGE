package form.richiesta.utenza.sistemi.informatici.portlet;

import form.richiesta.utenza.sistemi.informatici.beans.RichiestaUtenzaBean;
import form.richiesta.utenza.sistemi.informatici.constants.FormRichiestaUtenzaSistemiInformaticiPortletKeys;
import form.richiesta.utenza.sistemi.informatici.portlet.FormRichiestaUtenzaConfig;
import form.richiesta.utenza.sistemi.informatici.util.EmailSender;
import form.richiesta.utenza.sistemi.informatici.util.ExcelWriter;
import mef.email.configurator.model.AppNames;
import mef.email.configurator.model.EmailApp;
import mef.email.configurator.service.AppNamesLocalServiceUtil;
import mef.email.configurator.service.EmailAppLocalServiceUtil;
import service.intranet.mef.model.RichiesteUtenza;
import service.intranet.mef.service.RichiesteUtenzaLocalServiceUtil;

import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

/**
 * @author daniele.zirpoli
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet", "com.liferay.portlet.instanceable=true",
	"javax.portlet.display-name=form-richiesta-utenza-sistemi-informatici Portlet", "javax.portlet.init-param.template-path=/",
	"javax.portlet.init-param.view-template=/view.jsp",
	"javax.portlet.name=" + FormRichiestaUtenzaSistemiInformaticiPortletKeys.FormRichiestaUtenzaSistemiInformatici,
	"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FormRichiestaUtenzaSistemiInformaticiPortlet extends MVCPortlet {
	
	private final Log _log = LogFactoryUtil.getLog(FormRichiestaUtenzaSistemiInformaticiPortlet.class);
	private RichiestaUtenzaBean _richiedente = null;
	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";
	private final String _roledirigente = "Dirigente";
	private final String _appName = "form.richiesta.utenza.sistemi.informatici";
	
	private List<String> getListEmail(String email) {
		String CheckEmail = email;
		List<String> listEmail = new ArrayList<String>(0);
		if (CheckEmail != null && CheckEmail.length() > 0) {
			if (CheckEmail.charAt(email.length() - 1) == ';') {
				CheckEmail = CheckEmail.substring(0, CheckEmail.length() - 1);
			}
			if (CheckEmail.contains(";")) {
				String[] emailArray = CheckEmail.split(";");
				listEmail = Arrays.asList(emailArray);
			} else {
				listEmail.add(CheckEmail);
			}
		}
		return listEmail;
	}
	
	private String getEmailForUser(User user, ActionRequest actionRequest) {
		
		String emailreferente = actionRequest.getPreferences().getValue("emailReferente", _configuration.emailReferente());
		String email = "";
		List<AppNames> appNameObj = AppNamesLocalServiceUtil.getAppNamesByAppName(_appName);
		try {
			if ((user != null) && (user.getExpandoBridge() != null)
			&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						if (appNameObj != null && !appNameObj.isEmpty()) {
							long appId = appNameObj.get(0).getAppid();
							int actualLevel = orgChart.getLevel();
							long level2 = orgChart.getLevel2();
							long level3 = orgChart.getLevel3();
							long level4 = orgChart.getLevel4();
						
							switch (actualLevel) {
							// DIPARTIMENTO
							case 2:
								List<EmailApp> emailAppDipartimento = EmailAppLocalServiceUtil.getEmailByAppIdAndStructureId(appId, level2);
								if (emailAppDipartimento != null && !emailAppDipartimento.isEmpty()) {
									email = emailAppDipartimento.get(0).getEmail();
								} else {
									email = emailreferente;
								}
								break;
							// DIREZIONE
							case 3:
								List<EmailApp> emailAppDirezione  = EmailAppLocalServiceUtil.getEmailByAppIdAndStructureId(appId, level3);
								if (emailAppDirezione != null && !emailAppDirezione.isEmpty()) {
									email = emailAppDirezione.get(0).getEmail();
								} else {
									emailAppDipartimento = EmailAppLocalServiceUtil.getEmailByAppIdAndStructureId(appId, level2);
									if (emailAppDipartimento != null && !emailAppDipartimento.isEmpty()) {
										email = emailAppDipartimento.get(0).getEmail();
									} else {
										email = emailreferente;
									}
								}
								break;
							
							// UFFICIO
							case 4:
								List<EmailApp> emailAppUfficio = EmailAppLocalServiceUtil.getEmailByAppIdAndStructureId(appId, level4);
								if (emailAppUfficio != null && !emailAppUfficio.isEmpty()) {
									email = emailAppUfficio.get(0).getEmail();
								} else {
									emailAppDirezione  = EmailAppLocalServiceUtil.getEmailByAppIdAndStructureId(appId, level3);
									if (emailAppDirezione != null && !emailAppDirezione.isEmpty()) {
										email = emailAppDirezione.get(0).getEmail();
									} else {
										emailAppDipartimento = EmailAppLocalServiceUtil.getEmailByAppIdAndStructureId(appId, level2);
										if (emailAppDipartimento != null && !emailAppDipartimento.isEmpty()) {
											email = emailAppDipartimento.get(0).getEmail();
										} else {
											email = emailreferente;
										}
									}
								}
								break;
							
							default:
								email = emailreferente;
								break;
							}
						}
					}
				}
			} else
				_log.error(_customFieldUserOrg +" not defined for the user");
			
		} catch (Exception e) {
			_log.error("error in retrieve user informations" + e);
		}
		return email;
	}
	
	private RichiestaUtenzaBean createRichiedente(User user, long companyId) {
		RichiestaUtenzaBean richiedente = new RichiestaUtenzaBean();
		try {
			if ((user != null) && (user.getExpandoBridge() != null)
			&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				//andare in tabella organigramma e tramite l'organzationId ricavare il name (nome ufficio richiedente)
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						long locationId = orgChart.getLocationId();
						List<Location> locationlist = CentralInvokerLocalServiceUtil.findLocationById(locationId);
						if (locationlist != null && !locationlist.isEmpty()) {
							richiedente.setUbicazione(locationlist.get(0).getName());
						}
						richiedente.setUfficioRichiedente(orgChart.getName());
					}
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user");
			if(user!=null){
				richiedente.setCodFiscale(user.getScreenName());
				richiedente.setNome(user.getFirstName());
				richiedente.setCognome(user.getLastName());
				richiedente.setPalazzina("");
				List<Address> listaIndirizzi = user.getAddresses();
				List<Phone> listaPhones = user.getPhones();
				for (Address addressItem : listaIndirizzi) {
					if ("Business".equalsIgnoreCase(addressItem.getType().getName())) {
						richiedente.setPiano(addressItem.getStreet1());
						richiedente.setStanza(addressItem.getStreet2());
						richiedente.setScala(addressItem.getStreet3());
						break;
					}
				}
				for (Phone phoneItem : listaPhones) {
					if ("Business".equalsIgnoreCase(phoneItem.getType().getName())) {
						richiedente.setTelefono(phoneItem.getNumber());
						break;
					}
				}
				if ((user.getExpandoBridge() != null)
				&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
					String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
					User cuser=getUsertByCustomField(companyId,_customFieldUserPersonal,directorId);
					if(cuser!=null)
						richiedente.setEmailDirigente(cuser.getEmailAddress());
				} else
					_log.warn(_customFieldUserDirector + " not defined for this user ");
			}	
		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);
		}
		return richiedente;
	}
	
	
	//get user  fieldName = _customFieldUserPersonal  fieldValue=directorId
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
	
	
	private String getEmailDirigente(User user, long companyId) {
		String email = "";
		try{
		if ((user != null) && (user.getExpandoBridge() != null)
		&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
			String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
			User cuser=getUsertByCustomField(companyId,_customFieldUserPersonal,directorId);
			if(cuser!=null)
				email = cuser.getEmailAddress();
		} else
			_log.warn(_customFieldUserDirector + " not defined for the user");
		}catch(Exception e){
			_log.warn("error in retrieve user informations" + e);
		}
		return email;
	}
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		
		populateAppNamesTable();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String navigation = (String) renderRequest.getAttribute("navigation");
		if (navigation == null) {
			renderRequest.setAttribute("navigation", "inserimento");
			User user = themeDisplay.getUser();
			long companyId = themeDisplay.getCompanyId();
			_richiedente = createRichiedente(user, companyId);
			String utenza = "1";
			renderRequest.setAttribute("utenza", utenza);
			renderRequest.setAttribute("richiedente", _richiedente);
		}
		renderRequest.setAttribute(FormRichiestaUtenzaConfig.class.getName(), _configuration);
		super.doView(renderRequest, renderResponse);
	}
	
	private void populateAppNamesTable() {
		List<AppNames> checkRecordAppNames =  AppNamesLocalServiceUtil.getAppNamesByAppName(_appName);
		if(checkRecordAppNames == null || checkRecordAppNames.isEmpty()){
			AppNamesLocalServiceUtil.insertAppNames(_appName);

		}
	}
	
	public void recapRichiestaUtenza(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		
		actionRequest.setAttribute("ufficioRichiedente", actionRequest.getParameter("ufficioRichiedente"));
		actionRequest.setAttribute("nome", actionRequest.getParameter("nome"));
		actionRequest.setAttribute("cognome", actionRequest.getParameter("cognome"));
		actionRequest.setAttribute("ubicazioneAttuale", actionRequest.getParameter("ubicazioneAttuale"));
		actionRequest.setAttribute("palazzina", actionRequest.getParameter("palazzina"));
		actionRequest.setAttribute("piano", actionRequest.getParameter("piano"));
		actionRequest.setAttribute("scala", actionRequest.getParameter("scala"));
		actionRequest.setAttribute("stanza", actionRequest.getParameter("stanza"));
		actionRequest.setAttribute("telefono", actionRequest.getParameter("telefono"));
		actionRequest.setAttribute("emailDirigente", actionRequest.getParameter("emailDirigente"));
		actionRequest.setAttribute("assetPc", actionRequest.getParameter("assetPc"));
		actionRequest.setAttribute("applicazione", actionRequest.getParameter("applicazione"));
		actionRequest.setAttribute("codiceFiscale", actionRequest.getParameter("codiceFiscale"));
		actionRequest.setAttribute("utenza", actionRequest.getParameter("utenza"));
		actionRequest.setAttribute("cambioUfficio", actionRequest.getParameter("cambioUfficio"));
		actionRequest.setAttribute("resetPassword", actionRequest.getParameter("resetPassword"));
		actionRequest.setAttribute("navigation", "riepilogo");
		actionRequest.setAttribute("isRecapPage", true);
	}
	
	public void gotoRichiestaUtenza(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		
		actionRequest.setAttribute("navigation", null);
	}
	
	public void gotoModifRichiesta(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		
		RichiestaUtenzaBean richiedente = new RichiestaUtenzaBean();
		richiedente.setUfficioRichiedente(actionRequest.getParameter("ufficioRichiedente"));
		richiedente.setNome(actionRequest.getParameter("nome"));
		richiedente.setCognome(actionRequest.getParameter("cognome"));
		richiedente.setUbicazione(actionRequest.getParameter("ubicazioneAttuale"));
		richiedente.setPalazzina(actionRequest.getParameter("palazzina"));
		richiedente.setPiano(actionRequest.getParameter("piano"));
		richiedente.setScala(actionRequest.getParameter("scala"));
		richiedente.setStanza(actionRequest.getParameter("stanza"));
		richiedente.setTelefono(actionRequest.getParameter("telefono"));
		richiedente.setEmailDirigente(actionRequest.getParameter("emailDirigente"));
		richiedente.setCodFiscale(actionRequest.getParameter("codiceFiscale"));
		actionRequest.setAttribute("assetPc", actionRequest.getParameter("assetPc"));
		actionRequest.setAttribute("applicazione", actionRequest.getParameter("applicazione"));
		actionRequest.setAttribute("utenza", actionRequest.getParameter("utenza"));
		actionRequest.setAttribute("cambioUfficio", actionRequest.getParameter("cambioUfficio"));
		actionRequest.setAttribute("resetPassword", actionRequest.getParameter("resetPassword"));
		actionRequest.setAttribute("richiedente", richiedente);
		actionRequest.setAttribute("navigation", "inserimento");
	}
	
	public void invioRichiestaUtenza(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		
		String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");
		String nome = actionRequest.getParameter("nome");
		String cognome = actionRequest.getParameter("cognome");
		String ubicazioneAttuale = actionRequest.getParameter("ubicazioneAttuale");
		String palazzina = actionRequest.getParameter("palazzina");
		String piano = actionRequest.getParameter("piano");
		String scala = actionRequest.getParameter("scala");
		String stanza = actionRequest.getParameter("stanza");
		String telefono = actionRequest.getParameter("telefono");
		String emailDirigente = actionRequest.getParameter("emailDirigente");
		String assetPc = actionRequest.getParameter("assetPc");
		String applicazione = actionRequest.getParameter("applicazione");
		String codiceFiscale = actionRequest.getParameter("codiceFiscale");
		String utenza = actionRequest.getParameter("utenza");
		String cambioUfficio = actionRequest.getParameter("cambioUfficio");
		String resetPassword = actionRequest.getParameter("resetPassword");
		RichiestaUtenzaBean richiestautenza = new RichiestaUtenzaBean();
		richiestautenza.setUfficioRichiedente(ufficioRichiedente);
		richiestautenza.setNome(nome);
		richiestautenza.setCognome(cognome);
		richiestautenza.setUbicazione(ubicazioneAttuale);
		richiestautenza.setPalazzina(palazzina);
		richiestautenza.setPiano(piano);
		richiestautenza.setScala(scala);
		richiestautenza.setStanza(stanza);
		richiestautenza.setTelefono(telefono);
		richiestautenza.setEmailDirigente(emailDirigente);
		richiestautenza.setAssetPc(assetPc);
		richiestautenza.setApplicazione(applicazione);
		richiestautenza.setCodFiscale(codiceFiscale);
		String strUtenza = "Nuova";
		if ("2".equals(utenza))
			strUtenza = "Disabilita";
		richiestautenza.setUtenza(strUtenza);
		richiestautenza.setCambioUfficio(cambioUfficio);
		richiestautenza.setResetPassword(resetPassword);
		//write file excel to attach in email
		File tmpxls = FileUtil.createTempFile("Richiesta", "xls");
		ExcelWriter.writeRichiesteExcel(richiestautenza, tmpxls);
		String datiRichiedente = getHtmlRichiedente(richiestautenza);
		String datiRichiesta = getHtmlRichiesta(richiestautenza);
		String subject = actionRequest.getPreferences().getValue("subject", _configuration.subject());
		String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl", _configuration.richiestaTmpl());
		mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
		new String[] { datiRichiedente, datiRichiesta });
		String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		//email stubbata da ricavare dai dati utente della email dirigente
		long companyId = themeDisplay.getCompanyId();
		String emailDirigenteOriginale = getEmailDirigente(user, companyId);
		boolean resultEmail = false;
		String emailReferente = getEmailForUser(user, actionRequest);
		List<String> emailReferenti = getListEmail(emailReferente);
		if (!emailReferenti.isEmpty()) {
			if (emailDirigente.equals(emailDirigenteOriginale)) {
				for (String emailRef : emailReferenti) {
					EmailSender mail = new EmailSender();
					resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRef, emailDirigente, null, tmpxls);
				}
			} else {
				for (String emailRef : emailReferenti) {
					EmailSender mail = new EmailSender();
					resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRef, emailDirigente,
					emailDirigenteOriginale, tmpxls);
				}
			}
		}
		if (resultEmail && user!=null) {
			
			String screenName = user.getScreenName();
			Date insertDate = new Date();
			
			//insert trace to db
			boolean richiestaInserita=RichiesteUtenzaLocalServiceUtil.insertRichiestaUtenze(screenName, emailReferente, richiestautenza.toJSON(), insertDate);
			
			if(richiestaInserita!=true){
				SessionErrors.add(actionRequest, "errore-durante-inserimento-richiesta");
				SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				actionRequest.setAttribute("sessionError", "inserimento");
			}
			PortletURL render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			try {
				render.setWindowState(LiferayWindowState.NORMAL);
				render.setPortletMode(LiferayPortletMode.VIEW);
				actionResponse.sendRedirect(render.toString());
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			SessionErrors.add(actionRequest, "errore-durante-invio-email");
			SessionMessages.add(actionRequest,
			PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionRequest.setAttribute("sessionError", "email");
			actionRequest.setAttribute("ufficioRichiedente", ufficioRichiedente);
			actionRequest.setAttribute("nome", nome);
			actionRequest.setAttribute("cognome", cognome);
			actionRequest.setAttribute("ubicazioneAttuale", ubicazioneAttuale);
			actionRequest.setAttribute("palazzina", palazzina);
			actionRequest.setAttribute("piano", piano);
			actionRequest.setAttribute("scala", scala);
			actionRequest.setAttribute("stanza", stanza);
			actionRequest.setAttribute("telefono", telefono);
			actionRequest.setAttribute("emailDirigente", emailDirigente);
			actionRequest.setAttribute("assetPc", assetPc);
			actionRequest.setAttribute("applicazione", applicazione);
			actionRequest.setAttribute("codiceFiscale", codiceFiscale);
			actionRequest.setAttribute("utenza", utenza);
			actionRequest.setAttribute("cambioUfficio", cambioUfficio);
			actionRequest.setAttribute("resetPassword", resetPassword);
			actionRequest.setAttribute("navigation", "riepilogo");
		}
	}
	
	private String getHtmlRichiedente(RichiestaUtenzaBean richiesta) {
		StringBuilder dati = new StringBuilder();
		if (richiesta != null) {
			createHtmlForData(dati, "Ufficio Richiedente", richiesta.getUfficioRichiedente());
			createHtmlForData(dati, "Nome", richiesta.getNome());
			createHtmlForData(dati, "Cognome", richiesta.getCognome());
			createHtmlForData(dati, "Ubicazione Attuale", richiesta.getUbicazione());
			createHtmlForData(dati, "Palazzina", richiesta.getPalazzina());
			createHtmlForData(dati, "Piano", richiesta.getPiano());
			createHtmlForData(dati, "Scala", richiesta.getScala());
			createHtmlForData(dati, "Stanza", richiesta.getStanza());
			createHtmlForData(dati, "Telefono", richiesta.getTelefono());
			createHtmlForData(dati, "Email Dirigente", richiesta.getEmailDirigente());
		}
		return dati.toString();
	}
	
	private String getHtmlRichiesta(RichiestaUtenzaBean richiesta) {
		StringBuilder dati = new StringBuilder();
		if (richiesta != null) {
			createHtmlForData(dati, "Asset Computer", richiesta.getAssetPc());
			createHtmlForData(dati, "Applicazione", richiesta.getApplicazione());
			createHtmlForData(dati, "Codice Fiscale", richiesta.getCodFiscale());
			createHtmlForData(dati, "Utenza", richiesta.getUtenza());
			if (richiesta.getCambioUfficio() != null)
				createHtmlForData(dati, "Cambio Ufficio", richiesta.getCambioUfficio());
			if (richiesta.getResetPassword() != null)
				createHtmlForData(dati, "Reset Password", richiesta.getResetPassword());
			
		}
		return dati.toString();
	}
	
	private StringBuilder createHtmlForData(StringBuilder strportion, String title, String data) {
		strportion.append("</br>");
		strportion.append("<p>");
		strportion.append("<b>" + title + ":</b>");
		strportion.append(" ");
		strportion.append(data);
		strportion.append("</p> ");
		strportion.append("</br>");
		return strportion;
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(FormRichiestaUtenzaConfig.class, properties);
	}
	
	private volatile FormRichiestaUtenzaConfig _configuration;
}