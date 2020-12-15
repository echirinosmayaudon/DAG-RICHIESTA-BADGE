package mef.richieste.pub.siti.internet.portlet;

import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import mef.richieste.pub.siti.internet.bean.FileCustom;
import mef.richieste.pub.siti.internet.bean.Richiedente;
import mef.richieste.pub.siti.internet.util.EmailSender;
import service.intranet.mef.model.PeriodicitaRichPubblic;
import service.intranet.mef.model.TipologiaRichPubblic;
import service.intranet.mef.service.PeriodicitaRichPubblicLocalServiceUtil;
import service.intranet.mef.service.TipologiaRichPubblicLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=mef-richieste-pub-siti-internet-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class MefRichiestePubSitiInternetFormmvcportletPortlet extends MVCPortlet {
	final Log _log = LogFactoryUtil.getLog(MefRichiestePubSitiInternetFormmvcportletPortlet.class);
	private static final String TEMP_PATH = "/wos1/java/products/liferay/tmp/";
	private final static String baseDir = "/richieste/pubblicazioni";

	private List<FileCustom> attachFiles = null;
	private boolean ruoloRichiedenteLiferay = false;
	private String ruoloRichiedenteLiferayName = "DIP_RM_ROMA_620_DIP. II RGS";
	private Richiedente _richiedente = null;
	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";

	private Richiedente retriveIspettoratoUfficioRichiedente(User user, long companyId) {
		Richiedente richiedente = new Richiedente();
		try {
			if ((user != null)) {
				richiedente.setNome(user.getFirstName());
				richiedente.setCognome(user.getLastName());
				richiedente.setEmail(user.getEmailAddress());

				List<Phone> listaPhones = user.getPhones();

				for (Phone phone : listaPhones) {
					if (("Business").equalsIgnoreCase(phone.getType().getName())) {
						richiedente.setTelefonoInterno(phone.getNumber());
						break;
					}
				}

				if ((user.getExpandoBridge() != null)
						&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
					String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
					if (organizationId != null && organizationId != "") {
						Long idChart = Long.parseLong(organizationId);
						OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
						if (orgChart != null) {
							int livello = orgChart.getLevel();

							if (livello == 4)
								richiedente.setUfficio(orgChart.getName());

							long direzioneId = orgChart.getIdParent();
							if (livello == 3) {
								richiedente.setIspettorato(orgChart.getName());
							} else {
								OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil
										.getOrganizationChart(direzioneId);
								if (direzioneOrgChart != null) {
									richiedente.setIspettorato(direzioneOrgChart.getName());
								}
							}
						}
					}

				} else
					_log.warn(_customFieldUserOrg + " not defined for this user: " + user.getFullName());

				if (user.getExpandoBridge() != null
						&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
					String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
					User cuser = getUsertByCustomField(companyId, _customFieldUserPersonal, directorId);
					if (cuser != null) {
						richiedente.setNomeDirigente(cuser.getFirstName());
						richiedente.setCognomeDirigente(cuser.getLastName());
						richiedente.setEmailDirigente(cuser.getEmailAddress());
					}

				} else
					_log.warn(_customFieldUserDirector + " not defined for the user");

			}

		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);
		}
		return richiedente;
	}

	private User getUsertByCustomField(long companyId, String fieldName, String fieldValue) throws PortalException {

		List<ExpandoValue> values = ExpandoValueLocalServiceUtil.getColumnValues(companyId, User.class.getName(),
				ExpandoTableConstants.DEFAULT_TABLE_NAME, fieldName, fieldValue, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ExpandoValue value : values) {
			User user = UserLocalServiceUtil.getUser(value.getClassPK());
			return user;
		}

		return null;
	}

	private String getEmailDirigente(User user, long companyId) {
		String email = "";
		try {
			if ((user != null) && (user.getExpandoBridge() != null)
					&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
				String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
				User cuser = getUsertByCustomField(companyId, _customFieldUserPersonal, directorId);
				if (cuser != null)
					email = cuser.getEmailAddress();
			} else
				_log.warn(_customFieldUserDirector + " not defined for the user");
		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);
		}
		return email;
	}

	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		request.setAttribute(MefRichiestePubblicConfig.class.getName(), _configuration);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User utente = themeDisplay.getUser();
		for (Role ruolo : utente.getRoles()) {
			if (ruolo.getName().equalsIgnoreCase(ruoloRichiedenteLiferayName)) {
				ruoloRichiedenteLiferay = true;
			} else
				ruoloRichiedenteLiferay = true;
		}

		if (ruoloRichiedenteLiferay == true) {
			createListaPeriodicitaRichPubblic();
			createListaTipologiaRichPubblic();

			User user = themeDisplay.getUser();
			long companyId = themeDisplay.getCompanyId();

			_richiedente = retriveIspettoratoUfficioRichiedente(user, companyId);

			request.setAttribute("richiedente", _richiedente);

			List<TipologiaRichPubblic> lista_tipologia = TipologiaRichPubblicLocalServiceUtil
					.getTipologiaRichPubblics(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			request.setAttribute("lista_tipologia", lista_tipologia);

			List<PeriodicitaRichPubblic> lista_periodicita = PeriodicitaRichPubblicLocalServiceUtil
					.getPeriodicitaRichPubblics(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			request.setAttribute("lista_periodicita", lista_periodicita);
		}

		super.doView(request, response);
	}

	private void createListaPeriodicitaRichPubblic() {
		if (PeriodicitaRichPubblicLocalServiceUtil.getPeriodicitaRichPubblicsCount() == 0) {

			List<String> tipiPeriodicita = new ArrayList<>();
			tipiPeriodicita.add("annuale");
			tipiPeriodicita.add("tecnica");
			tipiPeriodicita.add("bimestrale");
			tipiPeriodicita.add("mensile");
			tipiPeriodicita.add("non specificata");
			tipiPeriodicita.add("quadrimestrale");
			tipiPeriodicita.add("semestrale");
			tipiPeriodicita.add("trimestrale");

			for (String descrizione : tipiPeriodicita) {
				PeriodicitaRichPubblic periodicita = PeriodicitaRichPubblicLocalServiceUtil
						.createPeriodicitaRichPubblic(
								CounterLocalServiceUtil.increment(PeriodicitaRichPubblic.class.getName()));
				periodicita.setPeriodicita(descrizione);
				PeriodicitaRichPubblicLocalServiceUtil.addPeriodicitaRichPubblic(periodicita);
			}
		}
	}

	private void createListaTipologiaRichPubblic() {
		if (TipologiaRichPubblicLocalServiceUtil.getTipologiaRichPubblicsCount() == 0) {

			List<String> tipologiaList = new ArrayList<>();
			tipologiaList.add("circolare");
			tipologiaList.add("evento/workshop/seminario");
			tipologiaList.add("faq");
			tipologiaList.add("novita");
			tipologiaList.add("altro");

			for (String descrizione : tipologiaList) {
				TipologiaRichPubblic tipologia = TipologiaRichPubblicLocalServiceUtil.createTipologiaRichPubblic(
						CounterLocalServiceUtil.increment(TipologiaRichPubblic.class.getName()));
				tipologia.setTipologia(descrizione);
				TipologiaRichPubblicLocalServiceUtil.addTipologiaRichPubblic(tipologia);
			}
		}
	}

	// add richiesta
	@ProcessAction(name = "addRichiestaAction")
	public void addRichiestaAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletModeException, WindowStateException, JSONException {
		try {
			String jsonObjectRichiesta = actionRequest.getParameter("jsonRichiesta");
			String countAllegati = actionRequest.getParameter("countAllegati");
			int sizeAllegati = Integer.parseInt(countAllegati);
			
			attachFiles = new ArrayList<>(0);
			for (int i = 1; i <= sizeAllegati; i++) {
				copyFileToServer(actionRequest, i);
			}

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);

			User user = themeDisplay.getUser();
			long companyId = themeDisplay.getCompanyId();

			String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl",
					_configuration.pubblicazioneSitiTmpl());
			String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
			String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
			String subject = actionRequest.getPreferences().getValue("subject", _configuration.subject());

			JSONObject objRichiestaDetails = JSONFactoryUtil.createJSONObject(jsonObjectRichiesta);

			String datiRichiesta = getHtmlJsonDetails(objRichiestaDetails);
			mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]" },
					new String[] { datiRichiesta });

			EmailSender mail = new EmailSender();

			List<String> toList = new ArrayList<String>(0);

			String emailDirigenteOriginale = getEmailDirigente(user, companyId);
			toList.add(emailDirigenteOriginale);

			String emailReferente = actionRequest.getPreferences().getValue("emailReferente",
					_configuration.emailReferente());
			toList.add(emailReferente);

			if (objRichiestaDetails != null) {
				String emailDirigente = objRichiestaDetails.getString("emailDirigente");
				String emailRichiedente = objRichiestaDetails.getString("email");

				if (!emailDirigenteOriginale.equals(emailDirigente))
					toList.add(emailDirigente);
				toList.add(emailRichiedente);

			}
			
			for (String toAddress : toList) {
				if (!mail.sendMailMessage(subject, mailbody, sender, smtpUser, toAddress, attachFiles))
					_log.warn("Messaggio non inviato a: " + toAddress);
			}

			PortletURL render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(render.toString());

		}

		catch (Exception e) {
			_log.warn(e);
			SessionErrors.add(actionRequest, "Errore-durante-invio-richiesta-pubblicazione-sito");

			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
	}

	private String getHtmlJsonDetails(JSONObject jsonObject) {
		StringBuilder dati = new StringBuilder();

		if (jsonObject != null) {
			if (!("").equals(jsonObject.getString("ispettorato"))) {
				createHtmlForData(dati, "Ispettorato", jsonObject.getString("ispettorato"));
			}
			if (!("").equals(jsonObject.getString("ufficio"))) {
				createHtmlForData(dati, "Ufficio", jsonObject.getString("ufficio"));
			}
			if (!("").equals(jsonObject.getString("primoReferente"))) {
				createHtmlForData(dati, "Richiedente", jsonObject.getString("primoReferente"));
			}
			if (!("").equals(jsonObject.getString("secondoReferente"))) {
				createHtmlForData(dati, "Dirigente", jsonObject.getString("secondoReferente"));
			}
			if (!("").equals(jsonObject.getString("email"))) {
				createHtmlForData(dati, "Email Richiedente", jsonObject.getString("email"));
			}
			if (!("").equals(jsonObject.getString("emailDirigente"))) {
				createHtmlForData(dati, "Email Dirigente", jsonObject.getString("emailDirigente"));
			}
			if (!("").equals(jsonObject.getString("telefonoInterno"))) {
				createHtmlForData(dati, "Telefono Richiedente", jsonObject.getString("telefonoInterno"));
			}
			if (!("").equals(jsonObject.getString("tipologia"))) {
				createHtmlForData(dati, "Tipologia", jsonObject.getString("tipologia"));
			}
			if (!("").equals(jsonObject.getString("titolo"))) {
				createHtmlForData(dati, "Titolo", jsonObject.getString("titolo"));
			}
			if (!("").equals(jsonObject.getString("sottotitolo"))) {
				createHtmlForData(dati, "Sottotitolo", jsonObject.getString("sottotitolo"));
			}
			if (!("").equals(jsonObject.getString("novita"))) {
				createHtmlForData(dati, "Novit&agrave;, abstract o sintesi dei punti qualificanti del documento",
						jsonObject.getString("novita"));
			}
			if (!("").equals(jsonObject.getString("collocazione"))) {
				createHtmlForData(dati, "Collocazione", jsonObject.getString("collocazione"));
			}
			if (!("").equals(jsonObject.getString("periodicita"))) {
				createHtmlForData(dati, "Periodicit&agrave;", jsonObject.getString("periodicita"));
			}
			if (!("").equals(jsonObject.getString("dataCompetenza"))) {
				createHtmlForData(dati, "Data Competenza", jsonObject.getString("dataCompetenza"));
			}
			if (!("").equals(jsonObject.getString("dataEvento"))) {
				createHtmlForData(dati, "Data evento", jsonObject.getString("dataEvento"));
			}
			if (!("").equals(jsonObject.getString("luogoEvento"))) {
				createHtmlForData(dati, "Luogo evento", jsonObject.getString("luogoEvento"));
			}
			if (!("").equals(jsonObject.getString("nota"))) {
				createHtmlForData(dati, "Nota e riferimenti bibliografici / normative / approfondimenti",
						jsonObject.getString("nota"));
			}
			if (!("").equals(jsonObject.getString("stampaCartacea"))
					&& !("0").equals(jsonObject.getString("stampaCartacea"))) {
				createHtmlForData(dati, "Stampa cartacea", jsonObject.getString("stampaCartacea"));
				if (!("").equals(jsonObject.getString("trattamento"))) {
					createHtmlForData(dati, "Trattamento", jsonObject.getString("trattamento"));
				}
				if (!("").equals(jsonObject.getString("opzioneColori"))) {
					createHtmlForData(dati, "Opzione colori", jsonObject.getString("opzioneColori"));
				}
				if (!("").equals(jsonObject.getString("opzioniStampa"))) {
					createHtmlForData(dati, "Opzioni Stampa", jsonObject.getString("opzioniStampa"));
				}

				if (!("").equals(jsonObject.getString("totaleFotocopie"))) {
					createHtmlForData(dati, "Totale fotocopie", jsonObject.getString("totaleFotocopie"));
				}
			}
			if (!("").equals(jsonObject.getString("produzioneCd"))
					&& !("0").equals(jsonObject.getString("produzioneCd"))) {
				createHtmlForData(dati, "Produzione Cd", jsonObject.getString("produzioneCd"));

			}
			if (!("").equals(jsonObject.getString("produzioneDvd"))
					&& !("0").equals(jsonObject.getString("produzioneDvd"))) {
				createHtmlForData(dati, "Produzione Dvd", jsonObject.getString("produzioneDvd"));
			}
			if (!("").equals(jsonObject.getString("produzionePdf"))) {
				createHtmlForData(dati, "Produzione Pdf", jsonObject.getString("produzionePdf"));
			}
			if (!("").equals(jsonObject.getString("protocollo"))) {
				createHtmlForData(dati, "Protocollo", jsonObject.getString("protocollo"));
			}
			if (!("").equals(jsonObject.getString("date"))) {
				createHtmlForData(dati, "Data", jsonObject.getString("date"));
			}
			if (!("").equals(jsonObject.getString("note"))) {
				createHtmlForData(dati, "Note", jsonObject.getString("note"));
			}
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
		_configuration = ConfigurableUtil.createConfigurable(MefRichiestePubblicConfig.class, properties);
	}

	private volatile MefRichiestePubblicConfig _configuration;

	private void copyFileToServer(ActionRequest actionRequest, int indexAttachFile) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		try {
			String indexFile = Integer.toString(indexAttachFile);
			StringBuilder builder = new StringBuilder();
			builder.append("allegato");
			builder.append(indexFile);
			File uploadedFile = uploadRequest.getFile(builder.toString());
			
			if (uploadedFile != null && uploadedFile.exists()) {
				FileCustom fileTemp = new FileCustom();
				fileTemp.setMimeType(uploadRequest.getContentType(builder.toString()));
				String fileTempName = (uploadRequest.getFileName(builder.toString()));
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				StringBuilder stringPath = new StringBuilder();
				stringPath.append(TEMP_PATH);
				stringPath.append("documents");
				stringPath.append(File.separator);
				stringPath.append(themeDisplay.getLayout().getGroupId());
				stringPath.append(File.separator);
				stringPath.append(baseDir);
				File folder = new File(stringPath.toString());
				fileTemp.setFile(new File(folder.getAbsolutePath() + File.separator + fileTempName)); 
				FileUtil.copyFile(uploadedFile, fileTemp.getFile());
				
				attachFiles.add(fileTemp);
			}
		} catch (Exception e) {
			_log.warn(e);
		}
	}
}