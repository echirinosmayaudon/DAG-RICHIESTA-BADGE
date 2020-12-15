package mef.whistleblowing.form.portlet;

import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import mef.whistleblowing.form.util.EmailSender;
import mef.whistleblowing.form.util.ModuloPdf;
import mef.whistleblowing.form.beans.Allegato;
import mef.whistleblowing.form.beans.Richiedente;
import mef.whistleblowing.form.beans.Segnalazione;
import servizio.whistleblowing.mef.service.SegnalazioneLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=mef-whistleblowing-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefWhistleBlowingPortlet extends MVCPortlet {

	private static final String TEMP_PATH = "/wos1/java/products/liferay/tmp/";
	private final static String baseDir = "/richieste/whistleblowing";
	private List<Allegato> attachFiles = null;
	private List<File> allegati_file_list = null;
	private Richiedente _richiedente = null;
	private final String _customFieldUserOrg = "idOrgChart";
	private static final Log _log = LogFactoryUtil.getLog(MefWhistleBlowingPortlet.class);

	private Richiedente createRichiedente(User user, long companyId) {
		Richiedente richiedente = new Richiedente();
		try {

			if ((user != null) && (user.getExpandoBridge() != null)
					&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
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
			if (user != null) {
				richiedente.setNome(user.getFirstName());
				richiedente.setCognome(user.getLastName());
				richiedente.setEmail(user.getEmailAddress());
				List<Phone> listaPhones = user.getPhones();
				for (Phone phoneItem : listaPhones) {
					if ("Business".equalsIgnoreCase(phoneItem.getType().getName())) {
						richiedente.setTelefono(phoneItem.getNumber());
						break;
					}
				}
			}
			richiedente.setQualifica("dipendente");
			if (user!=null) {
			for (Role roles : user.getRoles()) {
				if ("dirigente".equalsIgnoreCase(roles.getName())) {
					richiedente.setQualifica("dirigente");
					break;
				}
			}
			}

		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);

		}
		return richiedente;
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String navigation = (String) renderRequest.getAttribute("navigation");
		if (navigation == null) {
			renderRequest.setAttribute("navigation", "inserimento");
			User user = themeDisplay.getUser();
			long companyId = themeDisplay.getCompanyId();
			_richiedente = createRichiedente(user, companyId);
			renderRequest.setAttribute("richiedente", _richiedente);

		}
		renderRequest.setAttribute(MefWhistleBlowingConfig.class.getName(), _configuration);
		super.doView(renderRequest, renderResponse);
	}

	private Richiedente createRichiedenteByTheme(ThemeDisplay themeDisplay) {

		User user = themeDisplay.getUser();
		long companyId = themeDisplay.getCompanyId();
		return createRichiedente(user, companyId);

	}

	private void copyFileToServer(ActionRequest actionRequest, int indexAttachFile) {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		try {
			String indexFile = Integer.toString(indexAttachFile);
			StringBuilder builder = new StringBuilder();
			builder.append("allegato");
			builder.append(indexFile);
			builder.append("Input");
			File uploadedFile = uploadRequest.getFile(builder.toString());

			if (uploadedFile != null && uploadedFile.exists()) {
				Allegato fileTemp = new Allegato();
				fileTemp.setAllegatoMimeType(uploadRequest.getContentType(builder.toString()));
				String fileTempName = (uploadRequest.getFileName(builder.toString()));
				fileTemp.setAllegatoNome(fileTempName);
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				StringBuilder stringPath = new StringBuilder();
				stringPath.append(TEMP_PATH);
				stringPath.append("documents");
				stringPath.append(File.separator);
				stringPath.append(themeDisplay.getLayout().getGroupId());
				stringPath.append(File.separator);
				stringPath.append(baseDir);
				File folder = new File(stringPath.toString());
				fileTemp.setAllegato(new File(folder.getAbsolutePath() + File.separator + fileTempName));
				FileUtil.copyFile(uploadedFile, fileTemp.getAllegato());

				attachFiles.add(fileTemp);
			} else {
				_log.debug("il file non esiste: " + builder.toString());
			}
		} catch (Exception e) {
			_log.warn(e);
		}
	}

	// metodo per andare dall'inserimento al riepilogo della segnalazione
	public void riepilogoDati(ActionRequest request, ActionResponse response)
			throws NumberFormatException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Richiedente segnalante = createRichiedenteByTheme(themeDisplay);

		JSONObject jsonSegnalante = JSONFactoryUtil.createJSONObject(request.getParameter("jsonSegnalante"));

		segnalante.setNome_cognome(jsonSegnalante.getString("nome_cognome"));
		segnalante.setQualifica(jsonSegnalante.getString("qualifica"));
		segnalante.setUfficioRichiedente(jsonSegnalante.getString("struttura"));
		segnalante.setTelefono(jsonSegnalante.getString("telefono"));
		segnalante.setEmail(jsonSegnalante.getString("email"));
		segnalante.setData_fatto(jsonSegnalante.getString("dataFatto"));

		request.setAttribute("jsonSegnalante", request.getParameter("jsonSegnalante"));

		Segnalazione moduloSegnalazione = new Segnalazione();

		moduloSegnalazione.setUfficio(request.getParameter("luogoUfficio").trim());
		request.setAttribute("luogoUfficio", request.getParameter("luogoUfficio").trim());

		moduloSegnalazione.setUfficio_esterno(request.getParameter("luogoEsterno").trim());
		request.setAttribute("luogoEsterno", request.getParameter("luogoEsterno").trim());

		List<String> azioni_omissioni_list = new ArrayList<String>(0);

		if (request.getParameter("azioni_omissioni") != null
				&& !"".equalsIgnoreCase(request.getParameter("azioni_omissioni").trim())) {
			azioni_omissioni_list = Arrays.asList((request.getParameter("azioni_omissioni").split(",")));
		}

		moduloSegnalazione.setCheck(azioni_omissioni_list);
		request.setAttribute("azioni_omissioni", request.getParameter("azioni_omissioni").trim());

		moduloSegnalazione.setAltro(request.getParameter("input_altro_specificare").trim());
		request.setAttribute("input_altro_specificare", request.getParameter("input_altro_specificare").trim());

		moduloSegnalazione.setDescrizione(request.getParameter("descrizione").replaceAll("\r\n|\r|\n", " "));
		request.setAttribute("descrizione", request.getParameter("descrizione").replaceAll("\r\n|\r|\n", " "));

		moduloSegnalazione.setAutore(request.getParameter("autore").replaceAll("\r\n|\r|\n", " "));
		request.setAttribute("autore", request.getParameter("autore").replaceAll("\r\n|\r|\n", " "));

		moduloSegnalazione.setAltri_soggetti(request.getParameter("altri_testimoni").replaceAll("\r\n|\r|\n", " "));
		request.setAttribute("altri_testimoni", request.getParameter("altri_testimoni").replaceAll("\r\n|\r|\n", " "));

		// gestione allegati
		attachFiles = new ArrayList<Allegato>(0);

		int count_allegati = Integer.parseInt(request.getParameter("count_allegati"));
		
		if (count_allegati > 0) {
			
			for (int i = 1; i <= 5; i++) {
				
				copyFileToServer(request, i);

				Allegato allegato = new Allegato();

				if (request.getParameter("allegato" + i + "HiddenInput") != null
						&& !"".equalsIgnoreCase(request.getParameter("allegato" + i + "HiddenInput"))) {
					File fileAllegato = new File(request.getParameter("allegato" + i + "HiddenInput"));
					allegati_file_list.add(fileAllegato);
					allegato.setAllegato(fileAllegato);
					allegato.setAllegatoNome(fileAllegato.getName());
					allegato.setAllegatoMimeType("");

				attachFiles.add(allegato);

				}
				
				
				
			}
		}
		
		moduloSegnalazione.setAllegati(attachFiles);

		request.setAttribute("richiedente", segnalante);
		request.setAttribute("moduloSegnalazione", moduloSegnalazione);
		request.setAttribute("navigation", "riepilogo");

	}

	// metodo per l'inserimento e il salvataggio della segnalazione in db (se richiesto da parametro in config), +
	// gestione allegati, pdf ed email
	public void inserisciSegnalazione(ActionRequest request, ActionResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String luogo = "";

		if (request.getParameter("Ufficio") != null && !"".equalsIgnoreCase(request.getParameter("Ufficio"))) {
			luogo = request.getParameter("Ufficio");
		} else if (request.getParameter("LuogoEsterno") != null
				&& !"".equalsIgnoreCase(request.getParameter("LuogoEsterno"))) {
			luogo = request.getParameter("LuogoEsterno");
		}

		String altro = "";

		if (request.getParameter("Altro") != null && !"".equalsIgnoreCase(request.getParameter("Altro"))) {
			altro = request.getParameter("Altro");
		}
		
		String salvataggioDB = request.getPreferences().getValue("salvataggioDB",
				_configuration.salvataggioDB());
		
		boolean segnalazioneInserita = false;

		try {
			
			Richiedente segnalante = createRichiedenteByTheme(themeDisplay);

			JSONObject jsonSegnalante = JSONFactoryUtil
					.createJSONObject(request.getParameter("DatiSegnalanteSubmit"));

			segnalante.setNome_cognome(jsonSegnalante.getString("nome_cognome"));
			segnalante.setQualifica(jsonSegnalante.getString("qualifica"));
			segnalante.setUfficioRichiedente(jsonSegnalante.getString("struttura"));
			segnalante.setTelefono(jsonSegnalante.getString("telefono"));
			segnalante.setEmail(jsonSegnalante.getString("email"));
			segnalante.setData_fatto(jsonSegnalante.getString("dataFatto"));

			Segnalazione moduloSegnalazione = new Segnalazione();

			if (request.getParameter("Ufficio") != null && !"".equalsIgnoreCase(request.getParameter("Ufficio"))) {
				moduloSegnalazione.setUfficio(luogo);
			} else if (request.getParameter("LuogoEsterno") != null
					&& !"".equalsIgnoreCase(request.getParameter("LuogoEsterno"))) {
				moduloSegnalazione.setUfficio_esterno(luogo);
			}

			List<String> azioni_omissioni_list = new ArrayList<String>(0);

			if (request.getParameter("AzioniOmissioni") != null
					&& !"".equalsIgnoreCase(request.getParameter("AzioniOmissioni"))) {
				azioni_omissioni_list = Arrays.asList((request.getParameter("AzioniOmissioni").split(",")));
			}

			moduloSegnalazione.setCheck(azioni_omissioni_list);

			moduloSegnalazione.setAltro(request.getParameter("Altro"));

			moduloSegnalazione.setDescrizione(HtmlUtil.unescape(request.getParameter("Descrizione")));

			moduloSegnalazione.setAutore(HtmlUtil.unescape(request.getParameter("Autore")));

			moduloSegnalazione.setAltri_soggetti(HtmlUtil.unescape(request.getParameter("AltriTestimoni")));

			// gestione allegati
			allegati_file_list = new ArrayList<File>(0);
			attachFiles = new ArrayList<Allegato>(0);

			int count_allegati = Integer.parseInt(request.getParameter("NumeroDiAllegati"));

			if (count_allegati > 0) {

				for (int i = 1; i <= 5; i++) {

					Allegato allegato = new Allegato();

					if (request.getParameter("allegato" + i) != null
							&& !"".equalsIgnoreCase(request.getParameter("allegato" + i))) {
						File fileAllegato = new File(request.getParameter("allegato" + i));
						allegati_file_list.add(fileAllegato);
						allegato.setAllegato(fileAllegato);
					}

					if (request.getParameter("allegatoNome" + i) != null
							&& !"".equalsIgnoreCase(request.getParameter("allegatoNome" + i))) {
						allegato.setAllegatoNome(request.getParameter("allegatoNome" + i));
					}

					if (request.getParameter("allegatoMimeType" + i) != null
							&& !"".equalsIgnoreCase(request.getParameter("allegatoMimeType" + i))) {
						allegato.setAllegatoMimeType(request.getParameter("allegatoMimeType" + i));
					}

					attachFiles.add(allegato);

				}

			}

			moduloSegnalazione.setAllegati(attachFiles);

			ModuloPdf moduloPdf = new ModuloPdf(segnalante, moduloSegnalazione);

			File filePdf = FileUtil.createTempFile("modulo_segnalazione", "pdf");

			filePdf = moduloPdf.drawPDFModulo(filePdf);

			// send email
			String mailbody = request.getPreferences().getValue("segnalazioneTmpl",
					_configuration.segnalazioneTmpl());
			String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
			String sender = request.getPreferences().getValue("sender", _configuration.sender());
			String subject = request.getPreferences().getValue("subject", _configuration.subject());
			EmailSender mail = new EmailSender();

			// invia email a referente
			String emailReferente = request.getPreferences().getValue("emailReferente",
					_configuration.emailReferente());
			boolean esitoEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferente, filePdf, allegati_file_list);

			if (esitoEmail && "SI".equalsIgnoreCase(salvataggioDB)) {
				
				segnalazioneInserita = SegnalazioneLocalServiceUtil.insertSegnalazione(
						request.getParameter("DatiSegnalanteSubmit"), luogo,
						request.getParameter("AzioniOmissioni") + " " + altro, HtmlUtil.unescape(request.getParameter("Descrizione")),
						HtmlUtil.unescape(request.getParameter("Autore")), HtmlUtil.unescape(request.getParameter("AltriTestimoni")));

				if (segnalazioneInserita == false) {

					throw new WhistleBlowingException("WARNING: segnalazione non inserita");

				}
				
			}
			
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			response.sendRedirect(renderUrl.toString());

		} catch (Exception e) {

			_log.error("Errore durante l'inserimento della segnalazione: " + e);
			SessionErrors.add(request, "Errore-durante-inserimento-segnalazione");
			SessionMessages.add(request,
					PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		}

	}

	// metodo per tornare al form della segnalazione al fine di modificarla
	public void modificaSegnalazione(ActionRequest request, ActionResponse response) throws JSONException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String luogo = "";

		if (request.getParameter("Ufficio") != null && !"".equalsIgnoreCase(request.getParameter("Ufficio"))) {
			luogo = request.getParameter("Ufficio");
		} else if (request.getParameter("LuogoEsterno") != null
				&& !"".equalsIgnoreCase(request.getParameter("LuogoEsterno"))) {
			luogo = request.getParameter("LuogoEsterno");
		}
		
		Richiedente segnalante = createRichiedenteByTheme(themeDisplay);

		JSONObject jsonSegnalante = JSONFactoryUtil.createJSONObject(request.getParameter("DatiSegnalanteSubmit"));

		segnalante.setNome_cognome(jsonSegnalante.getString("nome_cognome"));
		segnalante.setQualifica(jsonSegnalante.getString("qualifica"));
		segnalante.setUfficioRichiedente(jsonSegnalante.getString("struttura"));
		segnalante.setTelefono(jsonSegnalante.getString("telefono"));
		segnalante.setEmail(jsonSegnalante.getString("email"));
		segnalante.setData_fatto(jsonSegnalante.getString("dataFatto"));

		Segnalazione moduloSegnalazione = new Segnalazione();

		if (request.getParameter("Ufficio") != null && !"".equalsIgnoreCase(request.getParameter("Ufficio"))) {
			moduloSegnalazione.setUfficio(luogo);
		} else if (request.getParameter("LuogoEsterno") != null
				&& !"".equalsIgnoreCase(request.getParameter("LuogoEsterno"))) {
			moduloSegnalazione.setUfficio_esterno(luogo);
		}

		List<String> azioni_omissioni_list = new ArrayList<String>(0);

		if (request.getParameter("AzioniOmissioni") != null
				&& !"".equalsIgnoreCase(request.getParameter("AzioniOmissioni"))) {
			azioni_omissioni_list = Arrays.asList((request.getParameter("AzioniOmissioni").split(",")));
		}

		moduloSegnalazione.setCheck(azioni_omissioni_list);
		
		moduloSegnalazione.setAltro(request.getParameter("Altro"));

		moduloSegnalazione.setDescrizione(request.getParameter("Descrizione"));

		moduloSegnalazione.setAutore(request.getParameter("Autore"));

		moduloSegnalazione.setAltri_soggetti(request.getParameter("AltriTestimoni"));

		// gestione allegati
		allegati_file_list = new ArrayList<File>(0);
		attachFiles = new ArrayList<Allegato>(0);

		int count_allegati = Integer.parseInt(request.getParameter("NumeroDiAllegati"));

		if (count_allegati > 0) {

			for (int i = 1; i <= 5; i++) {

				Allegato allegato = new Allegato();

				if (request.getParameter("allegato" + i) != null
						&& !"".equalsIgnoreCase(request.getParameter("allegato" + i))) {
					File fileAllegato = new File(request.getParameter("allegato" + i));
					allegati_file_list.add(fileAllegato);
					allegato.setAllegato(fileAllegato);
				}

				if (request.getParameter("allegatoNome" + i) != null
						&& !"".equalsIgnoreCase(request.getParameter("allegatoNome" + i))) {
					allegato.setAllegatoNome(request.getParameter("allegatoNome" + i));
				}

				if (request.getParameter("allegatoMimeType" + i) != null
						&& !"".equalsIgnoreCase(request.getParameter("allegatoMimeType" + i))) {
					allegato.setAllegatoMimeType(request.getParameter("allegatoMimeType" + i));
				}

				attachFiles.add(allegato);

			}

		}

		moduloSegnalazione.setAllegati(attachFiles);

		request.setAttribute("count_allegati", String.valueOf(count_allegati)); 
		request.setAttribute("richiedente", segnalante);
		request.setAttribute("moduloSegnalazione", moduloSegnalazione);
		request.setAttribute("navigation", "inserimento");

	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefWhistleBlowingConfig.class, properties);
	}

	private volatile MefWhistleBlowingConfig _configuration;

}