package mef.richieste.interventi.portlet;

import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
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

import service.intranet.mef.service.AssetLocalServiceUtil;
import service.intranet.mef.service.HardwareTecniciLocalServiceUtil;
import service.intranet.mef.service.RichiestaInterventiLocalServiceUtil;

import service.intranet.mef.model.Asset;
import service.intranet.mef.model.HardwareTecnici;
import service.intranet.mef.model.RichiestaInterventi;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import mef.email.configurator.model.AppNames;
import mef.email.configurator.model.EmailApp;
import mef.email.configurator.service.AppNamesLocalServiceUtil;
import mef.email.configurator.service.EmailAppLocalServiceUtil;
import mef.richieste.interventi.beans.Richiedente;
import mef.richieste.interventi.beans.RichiestaInterventiBean;
import mef.richieste.interventi.portlet.MefRichiesteInterventiConfig;
import mef.richieste.interventi.util.ExcelWriter;
import mef.richieste.interventi.util.EmailSender;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=mef-richieste-interventi-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefRichiesteInterventiportletPortlet extends MVCPortlet {

    private static final Log _log = LogFactoryUtil.getLog(MefRichiesteInterventiportletPortlet.class);

    private final String _appName = "mef.richieste.interventi.form";
    private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";
	private final String _roledirigente = "Dirigente";
	
	
private List<String> getListEmail(String email){
		String checkEmail = email;
		List<String> listEmail = new ArrayList<String>(0);
		if (checkEmail != null && checkEmail.length() > 0) {					
			 if( checkEmail.charAt(checkEmail.length() - 1) == ';'){			
				 checkEmail = checkEmail.substring(0, checkEmail.length() - 1);
			 }
	  		
		if(checkEmail.contains(";")){
		 String[] emailArray = checkEmail.split(";");
		 listEmail=Arrays.asList(emailArray);
		}else{
		   listEmail.add(checkEmail);
		}
		  }
		return listEmail;
	}
	
	private String getEmailForUser(User user, ActionRequest actionRequest) {
		
		String emailreferente = actionRequest.getPreferences().getValue("emailReferente",_configuration.emailReferente());
		String email= "";
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

								List<EmailApp> emailAppDipartimento = EmailAppLocalServiceUtil
										.getEmailByAppIdAndStructureId(appId, level2);
								if (emailAppDipartimento != null && !emailAppDipartimento.isEmpty()) {
									email = emailAppDipartimento.get(0).getEmail();
								} else {
									email = emailreferente;
								}

								break;
							// DIREZIONE
							case 3:

								List<EmailApp> emailAppDirezione = EmailAppLocalServiceUtil
										.getEmailByAppIdAndStructureId(appId, level3);
								if (emailAppDirezione != null && !emailAppDirezione.isEmpty()) {
									email = emailAppDirezione.get(0).getEmail();
								} else {
									 emailAppDipartimento = EmailAppLocalServiceUtil
											.getEmailByAppIdAndStructureId(appId, level2);
									if (emailAppDipartimento != null && !emailAppDipartimento.isEmpty()) {
										email = emailAppDipartimento.get(0).getEmail();
									} else {
										email = emailreferente;
									}

								}

								break;

							// UFFICIO
							case 4:  
								List<EmailApp> emailAppUfficio = EmailAppLocalServiceUtil
										.getEmailByAppIdAndStructureId(appId, level4);
									if (emailAppUfficio != null && !emailAppUfficio.isEmpty()) {								
										email = emailAppUfficio.get(0).getEmail();										
									} else {
										emailAppDirezione = EmailAppLocalServiceUtil
												.getEmailByAppIdAndStructureId(appId, level3);
										if (emailAppDirezione != null && !emailAppDirezione.isEmpty()) {
											email = emailAppDirezione.get(0).getEmail();
										}else{
											emailAppDipartimento = EmailAppLocalServiceUtil
													.getEmailByAppIdAndStructureId(appId, level2);
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
				_log.error(_customFieldUserOrg + " not defined for the user");

		} catch (Exception e) {
			_log.error("error in retrieve user informations" + e);
		}
       
		return email;
	}
	
	private Richiedente createRichiedente(User user, long companyId) {
		Richiedente richiedente = new Richiedente();
		try{
			if ((user!=null) && (user.getExpandoBridge()!=null) && (user.getExpandoBridge().getAttribute(_customFieldUserOrg)!=null)){
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
					}
				}

			}else
				_log.warn(_customFieldUserOrg + " not defined for the user");
		if(user!=null){
			richiedente.setNome(user.getFirstName());
			richiedente.setCognome(user.getLastName());
			richiedente.setPalazzina("");
			List<Address> listaIndirizzi = user.getAddresses();
			List<Phone> listaPhones =user.getPhones();
			
			for (Address addressItem: listaIndirizzi){
				if("Business".equalsIgnoreCase(addressItem.getType().getName())){
					richiedente.setPiano(addressItem.getStreet1());
					richiedente.setScala(addressItem.getStreet2());
					richiedente.setStanza(addressItem.getStreet3());
					break;
				}
			}
			
			for (Phone phoneItem: listaPhones){
				if( "Business".equalsIgnoreCase(phoneItem.getType().getName())){	
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
			_log.error("error in retrieve user informations"+e);
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

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		populateAppNamesTable();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);		
		User user = themeDisplay.getUser();
		
		long companyId=themeDisplay.getCompanyId();
			
		String navigation = (String) renderRequest.getAttribute("navigation");

		if (navigation == null) {
			renderRequest.setAttribute("navigation", "inserimentoRichiesteInterventi");

			List<Asset> assetItemList = AssetLocalServiceUtil.getAssets(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<HardwareTecnici> hardwareItemList = HardwareTecniciLocalServiceUtil
					.getHardwareTecnicis(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			renderRequest.setAttribute("assetSelectItemList", assetItemList);
			renderRequest.setAttribute("hardwareSelectItemList", hardwareItemList);

			renderRequest.setAttribute("richiedente", createRichiedente(user,companyId));
		}
		


		renderRequest.setAttribute(MefRichiesteInterventiConfig.class.getName(), _configuration);
		super.doView(renderRequest, renderResponse);
	}

	public void insertRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		String json = actionRequest.getParameter("richiesteJson");

		HashMap<String, List<RichiestaInterventiBean>> mappaRichieste = jsontoData(json);
		List<RichiestaInterventiBean> listAssetPc = mappaRichieste.get("listAssetPc");

		List<RichiestaInterventiBean> listSoftware = mappaRichieste.get("listSoftware");
		List<RichiestaInterventiBean> listHardware = mappaRichieste.get("listHardware");
		List<RichiestaInterventiBean> listPostaElectronica = mappaRichieste.get("listPostaElectronica");
		List<RichiestaInterventiBean> listCondivisioneStampanti = mappaRichieste.get("listCondivisioneStampanti");
		List<RichiestaInterventiBean> listCondivisioneDati = mappaRichieste.get("listCondivisioneDati");
		List<RichiestaInterventiBean> listAltro = mappaRichieste.get("listAltro");
		List<RichiestaInterventiBean> listRichiesta = mappaRichieste.get("listRichiesta");

		// write file excel to attach in email
		File tmpxls = FileUtil.createTempFile("Richiesta", "xls");
		ExcelWriter.writeRichiesteExcel(listAssetPc, listSoftware, listHardware, listPostaElectronica,
				listCondivisioneStampanti, listCondivisioneDati, listAltro, listRichiesta, tmpxls);
		
		Richiedente richiedente = new Richiedente();
		
		richiedente.setNome(actionRequest.getParameter("nome"));
		richiedente.setCognome(actionRequest.getParameter("cognome"));
		richiedente.setUbicazione(actionRequest.getParameter("ubicazione"));
		richiedente.setPalazzina(actionRequest.getParameter("palazzina"));
		richiedente.setPiano(actionRequest.getParameter("piano"));
		richiedente.setStanza(actionRequest.getParameter("stanza"));
		richiedente.setTelefono(actionRequest.getParameter("telefono"));
		richiedente.setEmailDirigente(actionRequest.getParameter("emailDirigente"));
		richiedente.setUfficioRichiedente(actionRequest.getParameter("ufficioRichiedente"));

		
		String datiRichiedente = getHtmlDatiMailRichiedente(richiedente);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long companyId= themeDisplay.getCompanyId();
		
		String emailDirigenteOriginale= getEmailDirigente(user,companyId);
		
		String datiRichieste = getHtmlDatiMailRichiesta(listAssetPc, listSoftware, listHardware, listPostaElectronica,
				listCondivisioneStampanti, listCondivisioneDati, listAltro, listRichiesta);

		String subject = actionRequest.getPreferences().getValue("subject", _configuration.subject());
		
		String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl", _configuration.richiestaTmpl());
		mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
				new String[] { datiRichiedente, datiRichieste });

		String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
		//String emailReferente = actionRequest.getPreferences().getValue("emailReferente",_configuration.emailReferente());

		
		String emailReferente = getEmailForUser(user, actionRequest);
		List<String> emailReferenti=getListEmail(emailReferente);

		boolean resultEmail = false;
		if(richiedente.getEmailDirigente()!=null && emailDirigenteOriginale!= null) {
			if (richiedente.getEmailDirigente().equals(emailDirigenteOriginale)){
				for(String ReferenteEmail: emailReferenti){
				EmailSender mail = new EmailSender();
				resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, ReferenteEmail, richiedente.getEmailDirigente(),
						null, tmpxls);
				}
			}
			else{
				for(String ReferenteEmail: emailReferenti){
				EmailSender mail = new EmailSender();
				resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, ReferenteEmail, richiedente.getEmailDirigente(),
						emailDirigenteOriginale, tmpxls);
				}
		     }
		}

		if (resultEmail) {
			// delete temp file
			//
			// FileUtil.delete(tmpxls);
			String screenName = "";
			if(user != null)
			{
				screenName = user.getScreenName();
			}
			Date insertDate = new Date();
		
			// insert trace to db
			boolean richiestaInserita=RichiestaInterventiLocalServiceUtil.insertRichiestaInterventi(screenName, json, insertDate);
			
			if(richiestaInserita!=true){
				SessionErrors.add(actionRequest, "errore-durante-inserimento-richiesta");
				SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				actionRequest.setAttribute("sessionError", "inserimento");
			}
			
			PortletURL render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);
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
			actionRequest.setAttribute("ufficioRichiedente", richiedente.getUfficioRichiedente());
			actionRequest.setAttribute("nome", richiedente.getNome());
			actionRequest.setAttribute("cognome", richiedente.getCognome());
			actionRequest.setAttribute("ubicazione", richiedente.getUbicazione());
			actionRequest.setAttribute("palazzina", richiedente.getPalazzina());
			actionRequest.setAttribute("piano", richiedente.getPiano());
			actionRequest.setAttribute("stanza",richiedente.getStanza());
			actionRequest.setAttribute("telefono", richiedente.getTelefono());
			actionRequest.setAttribute("emailDirigente", richiedente.getEmailDirigente());
			actionRequest.setAttribute("listAssetPc", listAssetPc);
			actionRequest.setAttribute("listSoftware", listSoftware);
			actionRequest.setAttribute("listHardware", listHardware);
			actionRequest.setAttribute("listPostaElectronica", listPostaElectronica);
			actionRequest.setAttribute("listCondivisioneStampanti", listCondivisioneStampanti);
			actionRequest.setAttribute("listCondivisioneDati", listCondivisioneDati);
			actionRequest.setAttribute("listAltro", listAltro);
			actionRequest.setAttribute("listRichiesta", listRichiesta);
			actionRequest.setAttribute("richiedente", richiedente);

			actionRequest.setAttribute("navigation", "riepilogo");
		}
		
	}

	public void newRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		actionRequest.setAttribute("navigation", null);

	}

	public void riepilogoDati(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		Richiedente richiedente = new Richiedente();
		
		richiedente.setNome(actionRequest.getParameter("nome"));
		richiedente.setCognome(actionRequest.getParameter("cognome"));
		richiedente.setUbicazione(actionRequest.getParameter("ubicazione"));
		richiedente.setPalazzina(actionRequest.getParameter("palazzina"));
		richiedente.setPiano(actionRequest.getParameter("piano"));
		richiedente.setStanza(actionRequest.getParameter("stanza"));
		richiedente.setTelefono(actionRequest.getParameter("telefono"));
		richiedente.setEmailDirigente(actionRequest.getParameter("emailDirigente"));
		richiedente.setUfficioRichiedente(actionRequest.getParameter("ufficioRichiedente"));
		
		String json = actionRequest.getParameter("json");

		HashMap<String, List<RichiestaInterventiBean>> mappaRichieste = jsontoData(json);
		List<RichiestaInterventiBean> listAssetPc = mappaRichieste.get("listAssetPc");
		List<RichiestaInterventiBean> listSoftware = mappaRichieste.get("listSoftware");
		List<RichiestaInterventiBean> listHardware = mappaRichieste.get("listHardware");
		List<RichiestaInterventiBean> listPostaElectronica = mappaRichieste.get("listPostaElectronica");
		List<RichiestaInterventiBean> listCondivisioneStampanti = mappaRichieste.get("listCondivisioneStampanti");
		List<RichiestaInterventiBean> listCondivisioneDati = mappaRichieste.get("listCondivisioneDati");
		List<RichiestaInterventiBean> listAltro = mappaRichieste.get("listAltro");
		List<RichiestaInterventiBean> listRichiesta = mappaRichieste.get("listRichiesta");

		actionRequest.setAttribute("richiedente", richiedente);
		actionRequest.setAttribute("ufficioRichiedente", richiedente.getUfficioRichiedente());
		actionRequest.setAttribute("nome", richiedente.getNome());
		actionRequest.setAttribute("cognome", richiedente.getCognome());
		actionRequest.setAttribute("ubicazione", richiedente.getUbicazione());
		actionRequest.setAttribute("palazzina", richiedente.getPalazzina());
		actionRequest.setAttribute("piano", richiedente.getPiano());
		actionRequest.setAttribute("scala", richiedente.getScala());
		actionRequest.setAttribute("stanza",richiedente.getStanza());
		actionRequest.setAttribute("telefono", richiedente.getTelefono());
		actionRequest.setAttribute("emailDirigente", richiedente.getEmailDirigente());
		
		actionRequest.setAttribute("listAssetPc", listAssetPc);
		actionRequest.setAttribute("listSoftware", listSoftware);
		actionRequest.setAttribute("listHardware", listHardware);
		actionRequest.setAttribute("listPostaElectronica", listPostaElectronica);
		actionRequest.setAttribute("listCondivisioneStampanti", listCondivisioneStampanti);
		actionRequest.setAttribute("listCondivisioneDati", listCondivisioneDati);
		actionRequest.setAttribute("listAltro", listAltro);
		actionRequest.setAttribute("listRichiesta", listRichiesta);

		actionRequest.setAttribute("json", json);

		actionRequest.setAttribute("navigation", "riepilogo");

	}

	private HashMap<String, List<RichiestaInterventiBean>> jsontoData(String json) throws JSONException {

		JSONObject obj = JSONFactoryUtil.createJSONObject(json);
		JSONArray arrayHardware = JSONFactoryUtil.createJSONArray(obj.getString("richieste"));
		RichiestaInterventiBean elencoRichiestaInterventiBean;
		
		HashMap<String, List<RichiestaInterventiBean>> mappaListeRichieste = new HashMap<String, List<RichiestaInterventiBean>>();
		List<RichiestaInterventiBean> listAssetPc = new ArrayList<RichiestaInterventiBean>(0);
		List<RichiestaInterventiBean> listSoftware = new ArrayList<RichiestaInterventiBean>(0);
		List<RichiestaInterventiBean> listHardware = new ArrayList<RichiestaInterventiBean>(0);
		List<RichiestaInterventiBean> listPostaElectronica = new ArrayList<RichiestaInterventiBean>(0);
		List<RichiestaInterventiBean> listCondivisioneStampanti = new ArrayList<RichiestaInterventiBean>(0);
		List<RichiestaInterventiBean> listCondivisioneDati = new ArrayList<RichiestaInterventiBean>(0);
		List<RichiestaInterventiBean> listAltro = new ArrayList<RichiestaInterventiBean>(0);
		List<RichiestaInterventiBean> listRichiesta = new ArrayList<RichiestaInterventiBean>(0);

		for (int i = 0; i < arrayHardware.length(); i++) {

			String selezione = arrayHardware.getJSONObject(i).getString("seleziona");

			if ("asset".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String assetPc = arrayHardware.getJSONObject(i).getString("assetPc");

				if (!"".equals(assetPc)) {
					elencoRichiestaInterventiBean.setAssetPc(assetPc);
				}
				String tipologiaHarwareAssetPc = arrayHardware.getJSONObject(i).getString("tipologiaAssetHardware");

				elencoRichiestaInterventiBean.setTipologiaHardware(tipologiaHarwareAssetPc);
		
				String marca = arrayHardware.getJSONObject(i).getString("marca");
				if (!"".equals(marca)) {
					elencoRichiestaInterventiBean.setMarca(marca);
				}
				String model = arrayHardware.getJSONObject(i).getString("model");
				if (!"".equals(model)) {
					elencoRichiestaInterventiBean.setModello(model);
				}
				
				if (!"".equals(assetPc)) {
					listAssetPc.add(elencoRichiestaInterventiBean);
				}
			}

			if ("software".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String descrizioneSoftware = arrayHardware.getJSONObject(i).getString("descrizione");

				if (!"".equals(descrizioneSoftware)) {
					elencoRichiestaInterventiBean.setDescrizione(descrizioneSoftware);
					listSoftware.add(elencoRichiestaInterventiBean);
				}

			}

			if ("hardware".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String tipologiaHardware = arrayHardware.getJSONObject(i).getString("tipologiaHardware");

				if (!"".equals(tipologiaHardware)) {
					elencoRichiestaInterventiBean.setTipologiaHardware(tipologiaHardware);
				}

				String tipoAttivita = arrayHardware.getJSONObject(i).getString("tipoAttivita");

				elencoRichiestaInterventiBean.setTipoAttivita(tipoAttivita);
				
				String marcaModelloNumeroSerieHw = arrayHardware.getJSONObject(i).getString("marcaModelloNumeroSerieHw");
				
				if (!"".equals(marcaModelloNumeroSerieHw)) {
					elencoRichiestaInterventiBean.setMarcaModelloNumeroSerieHw(marcaModelloNumeroSerieHw);
				}
				

				if (!"".equals(tipologiaHardware) && !"".equals(marcaModelloNumeroSerieHw) ) {
					listHardware.add(elencoRichiestaInterventiBean);
				}

			}

			if ("postaElectronica".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String codiceFiscale = arrayHardware.getJSONObject(i).getString("codiceFiscale");

				String tipoAttivitaPostaElectronica = arrayHardware.getJSONObject(i).getString("tipoAttivita");

				elencoRichiestaInterventiBean.setTipoAttivita(tipoAttivitaPostaElectronica);
				if (!"".equals(codiceFiscale)) {
					elencoRichiestaInterventiBean.setCodiceFiscale(codiceFiscale);
					listPostaElectronica.add(elencoRichiestaInterventiBean);
				}

			}

			if ("condivisioneStampanti".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String diReteAssetStampanti = arrayHardware.getJSONObject(i).getString("diReteAssetStampanti");

				if (!"".equals(diReteAssetStampanti)) {
					elencoRichiestaInterventiBean.setDiReteAssetStampante(diReteAssetStampanti);
				}

				String localAssetPc = arrayHardware.getJSONObject(i).getString("localAssetPc");
				if (!"".equals(localAssetPc)) {
					elencoRichiestaInterventiBean.setLocalAssetPc(localAssetPc);
				}

				String marcaModelloNumeroSerie = arrayHardware.getJSONObject(i).getString("marcaModelloNumeroSerie");
				if (!"".equals(marcaModelloNumeroSerie)) {
					elencoRichiestaInterventiBean.setMarcaModelloNumeroSerie(marcaModelloNumeroSerie);
				}

				String ubicazione = arrayHardware.getJSONObject(i).getString("ubicazione");
				if (!"".equals(ubicazione)) {
					elencoRichiestaInterventiBean.setUbicazione(ubicazione);
				}

				if (!"".equals(diReteAssetStampanti) || !"".equals(localAssetPc) || !"".equals(marcaModelloNumeroSerie)
						|| !"".equals(ubicazione)) {
					listCondivisioneStampanti.add(elencoRichiestaInterventiBean);
				}

			}

			if ("condivisioneDati".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String creazioneCartella = arrayHardware.getJSONObject(i).getString("creazioneCartella");

				if (!"".equals(creazioneCartella)) {
					elencoRichiestaInterventiBean.setCreazioneCartella(creazioneCartella);
				}

				String condivisioneCartella = arrayHardware.getJSONObject(i).getString("condivisioneCartella");
				if (!"".equals(condivisioneCartella)) {
					elencoRichiestaInterventiBean.setCondivisioneCartella(condivisioneCartella);
				}

				String utentiAbilitareLettura = arrayHardware.getJSONObject(i).getString("utentiAbilitareLettura");
				if (!"".equals(utentiAbilitareLettura)) {
					elencoRichiestaInterventiBean.setAbilitareUtenteLettura(utentiAbilitareLettura);
				}

				String utentiAbilitareScrittura = arrayHardware.getJSONObject(i).getString("utentiAbilitareScrittura");
				if (!"".equals(utentiAbilitareScrittura)) {
					elencoRichiestaInterventiBean.setAbilitareUtenteScrittura(utentiAbilitareScrittura);
				}

				if (!"".equals(creazioneCartella) || !"".equals(condivisioneCartella)
						|| !"".equals(utentiAbilitareLettura) || !"".equals(utentiAbilitareScrittura)) {
					listCondivisioneDati.add(elencoRichiestaInterventiBean);
				}

			}

			if ("altro".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String spostamentoApparecchiatura = arrayHardware.getJSONObject(i)
						.getString("spostamentoApparecchiatura");

				if (!"".equals(spostamentoApparecchiatura)) {
					elencoRichiestaInterventiBean.setSpostamentoApparecchiatura(spostamentoApparecchiatura);
				}

				String ritiroApparecchiatura = arrayHardware.getJSONObject(i).getString("ritiroApparecchiatura");
				if (!"".equals(ritiroApparecchiatura)) {
					elencoRichiestaInterventiBean.setRitiroApparecchiatura(ritiroApparecchiatura);
				}

				String abilitazionePresaRete = arrayHardware.getJSONObject(i).getString("abilitazionePresaRete");
				if (!"".equals(abilitazionePresaRete)) {
					elencoRichiestaInterventiBean.setAbilitazionePresaRete(abilitazionePresaRete);
				}

				if (!"".equals(spostamentoApparecchiatura) || !"".equals(ritiroApparecchiatura)
						|| !"".equals(abilitazionePresaRete)) {
					listAltro.add(elencoRichiestaInterventiBean);
				}

			}
			if ("richiesta".equals(selezione)) {

				elencoRichiestaInterventiBean = new RichiestaInterventiBean();
				String descrizioneRichiesta = arrayHardware.getJSONObject(i).getString("descrizioneRichiesta");

				if (!"".equals(descrizioneRichiesta)) {
					elencoRichiestaInterventiBean.setDescrizione(descrizioneRichiesta);
					listRichiesta.add(elencoRichiestaInterventiBean);
				}

			}
		}

		mappaListeRichieste.put("listAssetPc", listAssetPc);

		mappaListeRichieste.put("listSoftware", listSoftware);

		mappaListeRichieste.put("listHardware", listHardware);

		mappaListeRichieste.put("listPostaElectronica", listPostaElectronica);

		mappaListeRichieste.put("listCondivisioneStampanti", listCondivisioneStampanti);
		mappaListeRichieste.put("listCondivisioneDati", listCondivisioneDati);
		mappaListeRichieste.put("listAltro", listAltro);
		mappaListeRichieste.put("listRichiesta", listRichiesta);

		return mappaListeRichieste;

	}

	public void modificaDati(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {
		
		Richiedente richiedente = new Richiedente();
		
		richiedente.setNome(actionRequest.getParameter("nome"));
		richiedente.setCognome(actionRequest.getParameter("cognome"));
		richiedente.setUbicazione(actionRequest.getParameter("ubicazione"));
		richiedente.setPalazzina(actionRequest.getParameter("palazzina"));
		richiedente.setPiano(actionRequest.getParameter("piano"));
		richiedente.setStanza(actionRequest.getParameter("stanza"));
		richiedente.setTelefono(actionRequest.getParameter("telefono"));
		richiedente.setEmailDirigente(actionRequest.getParameter("emailDirigente"));
		richiedente.setUfficioRichiedente(actionRequest.getParameter("ufficioRichiedente"));

		String json = actionRequest.getParameter("richiesteJson");

		HashMap<String, List<RichiestaInterventiBean>> mappaListeRichieste = jsontoData(json);
		List<RichiestaInterventiBean> listAssetPc = mappaListeRichieste.get("listAssetPc");

		List<RichiestaInterventiBean> listSoftware = mappaListeRichieste.get("listSoftware");

		List<RichiestaInterventiBean> listHardware = mappaListeRichieste.get("listHardware");
		List<RichiestaInterventiBean> listPostaElectronica = mappaListeRichieste.get("listPostaElectronica");
		List<RichiestaInterventiBean> listCondivisioneStampanti = mappaListeRichieste.get("listCondivisioneStampanti");
		List<RichiestaInterventiBean> listCondivisioneDati = mappaListeRichieste.get("listCondivisioneDati");
		List<RichiestaInterventiBean> listAltro = mappaListeRichieste.get("listAltro");
		List<RichiestaInterventiBean> listRichiesta = mappaListeRichieste.get("listRichiesta");

		int itemsAssetPc = listAssetPc.size();
		int itemsSoftware = listSoftware.size();
		int itemsHardware = listHardware.size();
		int itemsPostaElectronica = listPostaElectronica.size();
		int itemsCondivisioneStampanti = listCondivisioneStampanti.size();
		int itemsCondivisioneDati = listCondivisioneDati.size();
		int itemsAltro = listAltro.size();
		int itemsRichiesta = listRichiesta.size();

		List<Asset> assetItemList = AssetLocalServiceUtil.getAssets(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<HardwareTecnici> hardwareItemList = HardwareTecniciLocalServiceUtil.getHardwareTecnicis(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		actionRequest.setAttribute("assetSelectItemList", assetItemList);
		actionRequest.setAttribute("hardwareSelectItemList", hardwareItemList);

		actionRequest.setAttribute("richiedente", richiedente);

		actionRequest.setAttribute("listAssetPc", listAssetPc);
		actionRequest.setAttribute("listSoftware", listSoftware);
		actionRequest.setAttribute("listHardware", listHardware);
		actionRequest.setAttribute("listPostaElectronica", listPostaElectronica);
		actionRequest.setAttribute("listCondivisioneStampanti", listCondivisioneStampanti);
		actionRequest.setAttribute("listCondivisioneDati", listCondivisioneDati);
		actionRequest.setAttribute("listAltro", listAltro);
		actionRequest.setAttribute("listRichiesta", listRichiesta);

		actionRequest.setAttribute("itemsAssetPc", itemsAssetPc);
		actionRequest.setAttribute("itemsSoftware", itemsSoftware);
		actionRequest.setAttribute("itemsHardware", itemsHardware);
		actionRequest.setAttribute("itemsPostaElectronica", itemsPostaElectronica);
		actionRequest.setAttribute("itemsCondivisioneStampanti", itemsCondivisioneStampanti);
		actionRequest.setAttribute("itemsCondivisioneDati", itemsCondivisioneDati);
		actionRequest.setAttribute("itemsAltro", itemsAltro);
		actionRequest.setAttribute("itemsRichiesta", itemsRichiesta);
		actionRequest.setAttribute("json", json);
		actionRequest.setAttribute("navigation", "inserimentoRichiesteInterventi");

	}

	private String getHtmlDatiMailRichiedente(Richiedente _richiedente) {
		
		StringBuilder dati = new StringBuilder();
		
		dati.append("<p><b>Ufficio richiedente:</b>");
		dati.append(" ");
		if(_richiedente.getUfficioRichiedente() != null)
		{
			dati.append(_richiedente.getUfficioRichiedente());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Nome Richiedente:</b>");
		dati.append(" ");
		if(_richiedente.getNome() != null)
		{
			dati.append(_richiedente.getNome());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Cognome richiedente:</b>");
		dati.append(" ");
		if(_richiedente.getCognome() != null)
		{
			dati.append(_richiedente.getCognome());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Ubicazione:</b>");
		dati.append(" ");
		if(_richiedente.getUbicazione() != null)
		{
			dati.append(_richiedente.getUbicazione());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Piano:</b>");
		dati.append(" ");
		if(_richiedente.getPiano() != null)
		{
			dati.append(_richiedente.getPiano());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Scala:</b>");
		dati.append(" ");
		if(_richiedente.getPiano() != null)
		{
			dati.append(_richiedente.getPiano());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Stanza:</b>");
		dati.append(" ");
		if(_richiedente.getStanza() != null)
		{
		dati.append(_richiedente.getStanza());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Telefono:</b>");
		dati.append(" ");
		if(_richiedente.getTelefono() != null)
		{
			dati.append(_richiedente.getTelefono());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		dati.append("<p><b>Email dirigente:</b>");
		dati.append(" ");
		if(_richiedente.getEmailDirigente() != null)
		{
		dati.append(_richiedente.getEmailDirigente());
		}
		dati.append("</p>");
		dati.append("</br>");
		
		return dati.toString();
	}

	private StringBuilder getcategoryHtmlRichiesta(StringBuilder dati, List<RichiestaInterventiBean> lista,
			String nomeLista) {
		for (RichiestaInterventiBean item : lista) {
			if ("assetPc".equals(nomeLista)) {
			
				dati.append("<p>");
				dati.append(" ");
				dati.append("<b>Asset Pc:</b>");
				dati.append(" ");
				dati.append(item.getAssetPc());
				dati.append(" ");
				dati.append("<b>Tipologia hardware asset pc:</b>");
				dati.append(" ");
				dati.append(item.getTipologiaHardware());
				dati.append(" ");
				dati.append("<b>Marca:</b>");
				dati.append(" ");
				if(item.getMarca()!= null){
					dati.append(item.getMarca());
					dati.append(" ");
				}
				dati.append("<b>Modello:</b>");
				dati.append(" ");
				if(item.getModello()!= null){
					dati.append(item.getModello());
					dati.append(" ");
				}
				dati.append("</p>");
				dati.append("</br>");

			}

			if ("software".equals(nomeLista)) {
			
				dati.append("<p>");
				dati.append(" ");
				dati.append("<b>La tua richiesta:</b>");
				dati.append(" ");
				dati.append(item.getDescrizione());
				dati.append(" ");
				dati.append("</p>");
				dati.append("</br>");

			}

			if ("hardware".equals(nomeLista)) {
				
				item.getModello();
				dati.append("<p>");
				dati.append(" ");
				dati.append("<b>Tipo attivit&agrave;:</b>");
				dati.append(" ");
				dati.append(item.getTipoAttivita());
				dati.append(" ");
				dati.append("<b>Tipologia hardware:</b>");
				dati.append(" ");
				dati.append(item.getTipologiaHardware());
				dati.append(" ");
				dati.append("<b>Marca / Modello / Numero di serie:</b>");
				dati.append(" ");
				dati.append(item.getMarcaModelloNumeroSerieHw());
				dati.append(" ");
				dati.append("</p>");
				dati.append("</br>");

			}

			if ("postaElectronica".equals(nomeLista)) {
				
				dati.append("<p>");
				dati.append(" ");
				dati.append("<b>Codice fiscale :</b>");
				dati.append(" ");
				dati.append(item.getCodiceFiscale());
				dati.append(" ");
				dati.append("<b>Tipo attivit&agrave;:</b>");
				dati.append(" ");
				dati.append(item.getTipoAttivita());
				dati.append(" ");
				dati.append("</p>");
				dati.append("</br>");

			}

			if ("condivisioneStampanti".equals(nomeLista)) {
			
				dati.append("<p>");
				dati.append(" ");
				
				if(item.getDiReteAssetStampante()!= null){
				dati.append("<b>Di rete -asset stampante:</b>");
				dati.append(" ");
				dati.append(item.getDiReteAssetStampante());
				dati.append(" ");
				}
		
				if(item.getLocalAssetPc()!= null){
				dati.append("<b>Local - asset pc:</b>");
				dati.append(" ");
				dati.append(item.getLocalAssetPc());
				dati.append(" ");
				}
				
				if(item.getMarcaModelloNumeroSerie()!= null){
				dati.append("<b>Marca / Modello / Numero di serie:</b>");
				dati.append(" ");
				dati.append(item.getMarcaModelloNumeroSerie());
				dati.append(" ");
			}
				if(item.getUbicazione()!= null){
				dati.append("<b>Ubicazione:</b>");
				dati.append(" ");
				dati.append(item.getUbicazione());
				dati.append(" ");
			}
				dati.append("</p>");
				dati.append("</br>");
			}

			if ("condivisioneDati".equals(nomeLista)) {
			
				dati.append("<p>");
				dati.append(" ");
				if(item.getCreazioneCartella() != null){
				dati.append("<b>Creazione nuova cartella condivisa sul server:</b>");
				dati.append(" ");
				dati.append(item.getCreazioneCartella());
				dati.append(" ");
			}
				if(item.getCondivisioneCartella()!= null){
				dati.append("<b>Condivisione cartella (Gi&agrave; esistente) sul server:</b>");
				dati.append(" ");
				dati.append(item.getCondivisioneCartella());
				dati.append(" ");
			}
				if(item.getAbilitareUtenteLettura()!= null){
				dati.append("<b>Utenti da abilitare in lettura:</b>");
				dati.append(" ");
				dati.append(item.getAbilitareUtenteLettura());
				dati.append(" ");
			}
				if(item.getAbilitareUtenteScrittura()!= null){
				dati.append("<b>Utenti da abilitare in scrittura:</b>");
				dati.append(" ");
				dati.append(item.getAbilitareUtenteScrittura());
				dati.append(" ");
				}
				dati.append("</p>");
				dati.append("</br>");
			}

			if ("altro".equals(nomeLista)) {
			
				dati.append("<p>");
				dati.append(" ");
				if(item.getSpostamentoApparecchiatura()!= null){
				dati.append("<b>Spostamento apparecchiatura:</b>");
				dati.append(" ");
				dati.append(item.getSpostamentoApparecchiatura());
				dati.append(" ");
				}
				if(item.getRitiroApparecchiatura()!= null){
				dati.append("<b>Ritiro apparecchiatura:</b>");
				dati.append(" ");
				dati.append(item.getRitiroApparecchiatura());
				dati.append(" ");
				}
				if(item.getAbilitazionePresaRete()!= null){
				dati.append("<b>Abilitazione presa di rete:</b>");
				dati.append(" ");
				dati.append(item.getAbilitazionePresaRete());
				dati.append(" ");
			}
				dati.append("</p>");
				dati.append("</br>");
			}

			if ("richiesta".equals(nomeLista)) {
			
				dati.append("<p>");
				dati.append("<b>La tua richiesta:</b>");
				dati.append(" ");
				dati.append(item.getDescrizione());
				dati.append(" ");
				dati.append("</p>");
				dati.append("</br>");

			}

			dati.append("</br>");

		}
		return dati;
	}

	private String getHtmlDatiMailRichiesta(List<RichiestaInterventiBean> assetPc,
			List<RichiestaInterventiBean> software, List<RichiestaInterventiBean> hardware,
			List<RichiestaInterventiBean> postaElectronica, List<RichiestaInterventiBean> condivisioneStampanti,
			List<RichiestaInterventiBean> condivisioneDati, List<RichiestaInterventiBean> altro,
			List<RichiestaInterventiBean> richiesta) {
		StringBuilder dati = new StringBuilder();

		if (!assetPc.isEmpty()) {
			dati.append("<p><b>Lista asset pc selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, assetPc, "assetPc");
		}
		if (!software.isEmpty()) {
			dati.append("<p><b>Lista software selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, software, "software");
		}
		if (!hardware.isEmpty()) {
			dati.append("<p><b>Lista hardware selezionate:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, hardware, "hardware");
		}
		if (!postaElectronica.isEmpty()) {
			dati.append("<p><b>Lista posta electronica selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, postaElectronica, "postaElectronica");
		}

		if (!condivisioneStampanti.isEmpty()) {
			dati.append("<p><b>Lista condivisione stampanti selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, condivisioneStampanti, "condivisioneStampanti");
		}
		if (!condivisioneDati.isEmpty()) {
			dati.append("<p><b>Lista condivisione dati selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, condivisioneDati, "condivisioneDati");
		}
		if (!altro.isEmpty()) {
			dati.append("<p><b>Lista altro selezionate:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, altro, "altro");
		}
		if (!richiesta.isEmpty()) {
			dati.append("<p><b>Lista richiesta selezionati:</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, richiesta, "richiesta");
		}

		return dati.toString();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiesteInterventiConfig.class, properties);
	}

	private volatile MefRichiesteInterventiConfig _configuration;

	private void populateAppNamesTable() {
			List<AppNames> checkRecordAppNames =  AppNamesLocalServiceUtil.getAppNamesByAppName(_appName);
			if(checkRecordAppNames == null || checkRecordAppNames.isEmpty()){
				AppNamesLocalServiceUtil.insertAppNames(_appName);

			}
	}
}
