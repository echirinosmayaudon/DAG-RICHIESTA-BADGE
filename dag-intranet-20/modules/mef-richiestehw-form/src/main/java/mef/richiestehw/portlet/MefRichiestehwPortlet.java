package mef.richiestehw.portlet;

import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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
import java.util.HashMap;
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

import mef.richiestehw.beans.Richiedente;
import mef.richiestehw.beans.RichiestaHwBean;
import mef.richiestehw.util.EmailSender;
import mef.richiestehw.util.ExcelWriter;
import service.intranet.mef.service.RichiesteHWLocalServiceUtil;
import service.intranet.mef.service.TipologiaComputerLocalServiceUtil;
import service.intranet.mef.service.TipologiaStampantiLocalServiceUtil;
import service.intranet.mef.service.TipologiaDispositiviLocalServiceUtil;
import service.intranet.mef.model.TipologiaComputer;
import service.intranet.mef.model.TipologiaStampanti;
import service.intranet.mef.model.TipologiaDispositivi;
import service.intranet.mef.model.RichiesteHW;
import mef.email.configurator.model.AppNames;
import mef.email.configurator.model.EmailApp;
import mef.email.configurator.service.AppNamesLocalServiceUtil;
import mef.email.configurator.service.EmailAppLocalServiceUtil;


@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet", "com.liferay.portlet.instanceable=true",
	"javax.portlet.display-name=mef-richiestehw-form Portlet", "javax.portlet.init-param.template-path=/",
	"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.resource-bundle=content.Language",
	"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefRichiestehwPortlet extends MVCPortlet {
	
	private Richiedente _richiedente = null;
	private final String _appName = "mef.richiestehw.form";
	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";
	private static final Log _log = LogFactoryUtil.getLog(MefRichiestehwPortlet.class);
	
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
	
	private Richiedente createRichiedente(User user, long companyId) {
		Richiedente richiedente = new Richiedente();
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
				_log.warn(_customFieldUserOrg + " not defined for the user");
			if(user!=null){
				richiedente.setNome(user.getFirstName());
				richiedente.setCognome(user.getLastName());
				richiedente.setPalazzina("");
				//Contact userContact = user.getContact();
				//List<Address> listaIndirizzi = AddressLocalServiceUtil.getAddresses(companyId, Contact.class.getName(), userContact.getContactId()) ;
				List<Address> listaIndirizzi = user.getAddresses();
				//List<Phone> listaPhones = PhoneLocalServiceUtil.getPhones(companyId, Contact.class.getName(), userContact.getContactId());
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
				if (user.getExpandoBridge() != null
				&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
					String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
					User cuser=getUsertByCustomField(companyId,_customFieldUserPersonal,directorId);
					if(cuser!=null)
						richiedente.setEmailDirigente(cuser.getEmailAddress());
					
				} else
					_log.warn(_customFieldUserDirector + " not defined for the user");
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
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		populateAppNamesTable();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String navigation = (String) renderRequest.getAttribute("navigation");
		if (navigation == null) {
			renderRequest.setAttribute("navigation", "inserimentohw");
			User user = themeDisplay.getUser();
			long companyId = themeDisplay.getCompanyId();
			_richiedente = createRichiedente(user, companyId);
			renderRequest.setAttribute("richiedente", _richiedente);
			List<TipologiaComputer> computerList = TipologiaComputerLocalServiceUtil.getTipologiaComputers(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
			List<TipologiaStampanti> stampantiList = TipologiaStampantiLocalServiceUtil.getTipologiaStampantis(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
			List<TipologiaDispositivi> dispositiviList = TipologiaDispositiviLocalServiceUtil.getTipologiaDispositivis(QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
			renderRequest.setAttribute("listaSelectComputer", computerList);
			renderRequest.setAttribute("listaSelectStampanti", stampantiList);
			renderRequest.setAttribute("listaSelectDispositivi", dispositiviList);
		}
		renderRequest.setAttribute(MefRichiestehwConfig.class.getName(), _configuration);
		super.doView(renderRequest, renderResponse);
	}
	
	public void newRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException, PortalException, Exception {
		
		actionRequest.setAttribute("navigation", null);
	}
	
	public void insertHardware(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException, PortalException, Exception {
		
		String richieste = actionRequest.getParameter("richiesteJson");
		String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");
		String nome = actionRequest.getParameter("nome");
		String cognome = actionRequest.getParameter("cognome");
		String ubicazione = actionRequest.getParameter("ubicazione");
		String palazzina = actionRequest.getParameter("palazzina");
		String piano = actionRequest.getParameter("piano");
		String scala = actionRequest.getParameter("scala");
		String stanza = actionRequest.getParameter("stanza");
		String telefono = actionRequest.getParameter("telefono");
		String emailDirigente = actionRequest.getParameter("emailDirigente");
		HashMap<String, List<RichiestaHwBean>> mappaRichieste = jsontoData(richieste);
		List<RichiestaHwBean> listComputer = mappaRichieste.get("listaComputer");
		List<RichiestaHwBean> listStampanti = mappaRichieste.get("listaStampanti");
		List<RichiestaHwBean> listAltrePeriferiche = mappaRichieste.get("listaPeriferiche");
		List<RichiestaHwBean> listSoftware = mappaRichieste.get("listaSoftware");
		//write file excel to attach in email
		File tmpxls = FileUtil.createTempFile("Richiesta", "xls");
		ExcelWriter.writeRichiesteExcel(listComputer, listStampanti, listAltrePeriferiche, listSoftware, tmpxls);
		//prepare email body
		String datiRichiedente = getHtmlDatiMailRichiedente(ufficioRichiedente, nome, cognome, ubicazione, palazzina, piano, scala, stanza,
		telefono, emailDirigente);
		String datiRichieste = getHtmlDatiMailRichiesta(listComputer, listStampanti, listAltrePeriferiche, listSoftware);
		String subject = actionRequest.getPreferences().getValue("subject", _configuration.subject());
		String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl", _configuration.richiestaTmpl());
		mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
		new String[] { datiRichiedente, datiRichieste });
		String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long companyId = themeDisplay.getCompanyId();
		String emailReferente = getEmailForUser(user, actionRequest);
		List<String> emailReferenti = getListEmail(emailReferente);
		String emailDirigenteOriginale = getEmailDirigente(user, companyId);
		boolean resultEmail = false;
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
		//prepare data for new trace
		if (resultEmail) {
			//delete temp file
			// FileUtil.delete(tmpxls);
			String screenName = null;
		
		if(user != null){
			screenName = user.getScreenName();
		}
			
			Date insertDate = new Date();
			
			//insert trace to db
			boolean richiestaInserita=RichiesteHWLocalServiceUtil.insertRichiestaHw(screenName, richieste, insertDate);
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
			SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionRequest.setAttribute("sessionError", "email");
			actionRequest.setAttribute("ufficioRichiedente", ufficioRichiedente);
			actionRequest.setAttribute("nome", nome);
			actionRequest.setAttribute("cognome", cognome);
			actionRequest.setAttribute("ubicazione", ubicazione);
			actionRequest.setAttribute("palazzina", palazzina);
			actionRequest.setAttribute("piano", piano);
			actionRequest.setAttribute("scala", scala);
			actionRequest.setAttribute("stanza", stanza);
			actionRequest.setAttribute("telefono", telefono);
			actionRequest.setAttribute("emailDirigente", emailDirigente);
			actionRequest.setAttribute("listComputer", listComputer);
			actionRequest.setAttribute("listStampanti", listStampanti);
			actionRequest.setAttribute("listAltrePeriferiche", listAltrePeriferiche);
			actionRequest.setAttribute("listSoftware", listSoftware);
			actionRequest.setAttribute("listarichiesteJson", richieste);
			actionRequest.setAttribute("navigation", "riepilogo");
		}
	}
	
	public void riepilogoDati(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException, PortalException, Exception {
		
		// user data
		String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");
		String nome = actionRequest.getParameter("nome");
		String cognome = actionRequest.getParameter("cognome");
		String ubicazione = actionRequest.getParameter("ubicazione");
		String palazzina = actionRequest.getParameter("palazzina");
		String piano = actionRequest.getParameter("piano");
		String scala = actionRequest.getParameter("scala");
		String stanza = actionRequest.getParameter("stanza");
		String telefono = actionRequest.getParameter("telefono");
		String emailDirigente = actionRequest.getParameter("emailDirigente");
		String json = actionRequest.getParameter("saverichiesta");
		HashMap<String, List<RichiestaHwBean>> mappaRichieste = jsontoData(json);
		List<RichiestaHwBean> listComputer = mappaRichieste.get("listaComputer");
		List<RichiestaHwBean> listStampanti = mappaRichieste.get("listaStampanti");
		List<RichiestaHwBean> listAltrePeriferiche = mappaRichieste.get("listaPeriferiche");
		List<RichiestaHwBean> listSoftware = mappaRichieste.get("listaSoftware");
		actionRequest.setAttribute("ufficioRichiedente", ufficioRichiedente);
		actionRequest.setAttribute("nome", nome);
		actionRequest.setAttribute("cognome", cognome);
		actionRequest.setAttribute("ubicazione", ubicazione);
		actionRequest.setAttribute("palazzina", palazzina);
		actionRequest.setAttribute("piano", piano);
		actionRequest.setAttribute("scala", scala);
		actionRequest.setAttribute("stanza", stanza);
		actionRequest.setAttribute("telefono", telefono);
		actionRequest.setAttribute("emailDirigente", emailDirigente);
		actionRequest.setAttribute("listComputer", listComputer);
		actionRequest.setAttribute("listStampanti", listStampanti);
		actionRequest.setAttribute("listAltrePeriferiche", listAltrePeriferiche);
		actionRequest.setAttribute("listSoftware", listSoftware);
		actionRequest.setAttribute("listarichiesteJson", json);
		actionRequest.setAttribute("navigation", "riepilogo");
	}
	
	private HashMap<String, List<RichiestaHwBean>> jsontoData(String json) throws JSONException {
		
		JSONObject obj = JSONFactoryUtil.createJSONObject(json);
		JSONArray arrayHardware = JSONFactoryUtil.createJSONArray(obj.getString("richieste"));
		RichiestaHwBean elencoRichiesteHwBean;
		
		HashMap<String, List<RichiestaHwBean>> mappaListeRichieste = new HashMap<String, List<RichiestaHwBean>>();
		List<RichiestaHwBean> listComputer = new ArrayList<RichiestaHwBean>(0);
		List<RichiestaHwBean> listStampanti = new ArrayList<RichiestaHwBean>(0);
		List<RichiestaHwBean> listAltrePeriferiche = new ArrayList<RichiestaHwBean>(0);
		List<RichiestaHwBean> listSoftware = new ArrayList<RichiestaHwBean>(0);
		for (int i = 0; i < arrayHardware.length(); i++) {
			
		String selezione = arrayHardware.getJSONObject(i).getString("seleziona");
			if ("personalComputer".equals(selezione)) {
				
				elencoRichiesteHwBean = new RichiestaHwBean();
				String tipologia = arrayHardware.getJSONObject(i).getString("tipologia");
				if (!"".equals(tipologia)) {
					elencoRichiesteHwBean.setTipologia(tipologia);
				}
				String quantita = arrayHardware.getJSONObject(i).getString("quantita");
				if (!"0".equals(quantita)) {
					elencoRichiesteHwBean.setQuantita(quantita);
				}
				String note = arrayHardware.getJSONObject(i).getString("note");
				elencoRichiesteHwBean.setNote(note);
				if (!"".equals(tipologia) && !"0".equals(quantita)) {
					listComputer.add(elencoRichiesteHwBean);
				}
			}
			if ("stampanti".equals(selezione)) {
				
				elencoRichiesteHwBean = new RichiestaHwBean();
				String tipologia = arrayHardware.getJSONObject(i).getString("tipologia");
				if (!"".equals(tipologia)) {
					elencoRichiesteHwBean.setTipologia(tipologia);
				}
				String quantita = arrayHardware.getJSONObject(i).getString("quantita");
				if (!"0".equals(quantita)) {
					elencoRichiesteHwBean.setQuantita(quantita);
				}
				String note = arrayHardware.getJSONObject(i).getString("note");
				elencoRichiesteHwBean.setNote(note);
				if (!"".equals(tipologia) && !"0".equals(quantita)) {
					listStampanti.add(elencoRichiesteHwBean);
				}
			}
			if ("altrePeriferiche".equals(selezione)) {
				
				elencoRichiesteHwBean = new RichiestaHwBean();
				String tipologia = arrayHardware.getJSONObject(i).getString("tipologia");
				if (!"".equals(tipologia)) {
					elencoRichiesteHwBean.setTipologia(tipologia);
				}
				String quantita = arrayHardware.getJSONObject(i).getString("quantita");
				if (!"0".equals(quantita)) {
					elencoRichiesteHwBean.setQuantita(quantita);
				}
				String note = arrayHardware.getJSONObject(i).getString("note");
				elencoRichiesteHwBean.setNote(note);
				if (!"".equals(tipologia) && !"0".equals(quantita)) {
					listAltrePeriferiche.add(elencoRichiesteHwBean);
				}
			}
			if ("software".equals(selezione)) {
				
				elencoRichiesteHwBean = new RichiestaHwBean();
				String tipologia = arrayHardware.getJSONObject(i).getString("tipologia");
				if (!"".equals(tipologia)) {
					elencoRichiesteHwBean.setTipologia(tipologia);
				}
				String quantita = arrayHardware.getJSONObject(i).getString("quantita");
				if (!"0".equals(quantita)) {
					elencoRichiesteHwBean.setQuantita(quantita);
				}
				String note = arrayHardware.getJSONObject(i).getString("note");
				elencoRichiesteHwBean.setNote(note);
				if (!"".equals(tipologia) && !"0".equals(quantita)) {
					listSoftware.add(elencoRichiesteHwBean);
				}
			}
		}
		mappaListeRichieste.put("listaComputer", listComputer);
		mappaListeRichieste.put("listaStampanti", listStampanti);
		mappaListeRichieste.put("listaPeriferiche", listAltrePeriferiche);
		mappaListeRichieste.put("listaSoftware", listSoftware);
		return mappaListeRichieste;
	}
	
	public void modificaDati(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException, PortalException, Exception {
		
		Richiedente richiedente = new Richiedente();
		String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");
		richiedente.setUfficioRichiedente(ufficioRichiedente);
		String nome = actionRequest.getParameter("nome");
		richiedente.setNome(nome);
		String cognome = actionRequest.getParameter("cognome");
		richiedente.setCognome(cognome);
		String ubicazione = actionRequest.getParameter("ubicazione");
		richiedente.setUbicazione(ubicazione);
		String palazzina = actionRequest.getParameter("palazzina");
		richiedente.setPalazzina(palazzina);
		String piano = actionRequest.getParameter("piano");
		richiedente.setPiano(piano);
		String scala = actionRequest.getParameter("scala");
		richiedente.setScala(scala);
		String stanza = actionRequest.getParameter("stanza");
		richiedente.setStanza(stanza);
		String telefono = actionRequest.getParameter("telefono");
		richiedente.setTelefono(telefono);
		String emailDirigente = actionRequest.getParameter("emailDirigente");
		richiedente.setEmailDirigente(emailDirigente);
		String json = actionRequest.getParameter("richiesteJson");
		HashMap<String, List<RichiestaHwBean>> mappaRichieste = jsontoData(json);
		List<RichiestaHwBean> listComputer = mappaRichieste.get("listaComputer");
		List<RichiestaHwBean> listStampanti = mappaRichieste.get("listaStampanti");
		List<RichiestaHwBean> listAltrePeriferiche = mappaRichieste.get("listaPeriferiche");
		List<RichiestaHwBean> listSoftware = mappaRichieste.get("listaSoftware");
		List<TipologiaComputer> computerList = TipologiaComputerLocalServiceUtil.getTipologiaComputers(QueryUtil.ALL_POS,
		QueryUtil.ALL_POS);
		List<TipologiaStampanti> stampantiList = TipologiaStampantiLocalServiceUtil.getTipologiaStampantis(QueryUtil.ALL_POS,
		QueryUtil.ALL_POS);
		List<TipologiaDispositivi> dispositiviList = TipologiaDispositiviLocalServiceUtil.getTipologiaDispositivis(QueryUtil.ALL_POS,
		QueryUtil.ALL_POS);
		actionRequest.setAttribute("listaSelectComputer", computerList);
		actionRequest.setAttribute("listaSelectStampanti", stampantiList);
		actionRequest.setAttribute("listaSelectDispositivi", dispositiviList);
		int itemsComputers = listComputer.size();
		int itemsStampanti = listStampanti.size();
		int itemsAltrePeriferiche = listAltrePeriferiche.size();
		int itemsSoftware = listSoftware.size();
		actionRequest.setAttribute("richiedente", richiedente);
		actionRequest.setAttribute("listComputer", listComputer);
		actionRequest.setAttribute("listStampanti", listStampanti);
		actionRequest.setAttribute("listAltrePeriferiche", listAltrePeriferiche);
		actionRequest.setAttribute("listSoftware", listSoftware);
		actionRequest.setAttribute("itemsComputers", itemsComputers);
		actionRequest.setAttribute("itemsStampanti", itemsStampanti);
		actionRequest.setAttribute("itemsAltrePeriferiche", itemsAltrePeriferiche);
		actionRequest.setAttribute("itemsSoftware", itemsSoftware);
		actionRequest.setAttribute("json", json);
		actionRequest.setAttribute("navigation", "inserimentohw");
	}
	
	private String getHtmlDatiMailRichiedente(String uffRichiedente, String nome, String cognome, String ubicazione, String palazzina,
		String piano, String scala, String stanza, String telefono, String emailDirigente) {
		StringBuilder dati = new StringBuilder();
		dati.append("<p><b>Ufficio richiedente:</b>");
		dati.append(" ");
		dati.append(uffRichiedente);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Nome:</b>");
		dati.append(" ");
		dati.append(nome);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Cognome:</b>");
		dati.append(" ");
		dati.append(cognome);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Ubicazione:</b>");
		dati.append(" ");
		dati.append(ubicazione);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Palazzina:</b>");
		dati.append(" ");
		dati.append(palazzina);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Piano:</b>");
		dati.append(" ");
		dati.append(piano);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Scala:</b>");
		dati.append(" ");
		dati.append(scala);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Stanza:</b>");
		dati.append(" ");
		dati.append(stanza);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>Telefono:</b>");
		dati.append(" ");
		dati.append(telefono);
		dati.append("</p>");
		dati.append("</br>");
		dati.append("<p><b>email dirigente:</b>");
		dati.append(" ");
		dati.append(emailDirigente);
		dati.append("</p>");
		dati.append("</br>");
		return dati.toString();
	}
	
	private StringBuilder getcategoryHtmlRichiesta(StringBuilder dati, List<RichiestaHwBean> lista) {
		for (RichiestaHwBean item : lista) {
			item.getTipologia();
			item.getQuantita();
			item.getNote();
			dati.append("<p>");
			dati.append("<b>Tipologia:</b>");
			dati.append(" ");
			dati.append(item.getTipologia());
			dati.append(" ");
			dati.append("<b>Quantit&agrave;:</b>");
			dati.append(" ");
			dati.append(item.getQuantita());
			dati.append(" ");
			dati.append("<b>Note:</b>");
			dati.append(" ");
			dati.append(item.getNote());
			dati.append("</p>");
			dati.append("</br>");
		}
		return dati;
	}
	
	private String getHtmlDatiMailRichiesta(List<RichiestaHwBean> listComputer, List<RichiestaHwBean> listStampanti,
		List<RichiestaHwBean> listAltrePeriferiche, List<RichiestaHwBean> listSoftware) {
		StringBuilder dati = new StringBuilder();
		if (!listComputer.isEmpty()) {
			dati.append("<p><b>Lista computer selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, listComputer);
		}
		if (!listStampanti.isEmpty()) {
			dati.append("<p><b>Lista stampanti selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, listStampanti);
		}
		if (!listAltrePeriferiche.isEmpty()) {
			dati.append("<p><b>Lista periferiche selezionate:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, listAltrePeriferiche);
		}
		if (!listSoftware.isEmpty()) {
			dati.append("<p><b>Lista software selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, listSoftware);
		}
		return dati.toString();
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiestehwConfig.class, properties);
	}
	
	private volatile MefRichiestehwConfig _configuration;
	
	private void populateAppNamesTable() {
		List<AppNames> checkRecordAppNames =  AppNamesLocalServiceUtil.getAppNamesByAppName(_appName);
		if(checkRecordAppNames == null || checkRecordAppNames.isEmpty()){
			AppNamesLocalServiceUtil.insertAppNames(_appName);
		}
	}
}