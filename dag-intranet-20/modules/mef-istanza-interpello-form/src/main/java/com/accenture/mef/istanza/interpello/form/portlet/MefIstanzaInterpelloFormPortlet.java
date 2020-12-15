package com.accenture.mef.istanza.interpello.form.portlet;

import com.accenture.istanza.interpello.model.RichInterpello;
import com.accenture.istanza.interpello.model.TextRich;
import com.accenture.istanza.interpello.model.TextRichModel;
import com.accenture.istanza.interpello.service.EmailLocalServiceUtil;
import com.accenture.istanza.interpello.service.RichInterpelloLocalServiceUtil;
import com.accenture.istanza.interpello.service.TextRichLocalServiceUtil;
import com.accenture.mef.istanza.interpello.form.bean.ModuloRichiesta;
import com.accenture.mef.istanza.interpello.form.bean.Opzione;
import com.accenture.mef.istanza.interpello.form.bean.Richiedente;
import com.accenture.mef.istanza.interpello.form.util.EmailSender;
import com.intranet.mef.job.siap.model.ClassificationLevel;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
import com.intranet.mef.job.siap.service.ClassificationLevelLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

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

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=mef-istanza-interpello-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefIstanzaInterpelloFormPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(MefIstanzaInterpelloFormPortlet.class);

	// USER CUSTOM FIELDS
	private static final String _customFieldUserOrg = "idOrgChart";
	private static final String _customFieldUserLevel = "levelId";
	private static final String _customFieldPersonalId = "personalId";
	private static final String _customFieldUserDirector = "idDirector";

	// COSTANTI LABEL TEXT
	private static final String LABEL_TEXT_CONSEGUENZE_CIVILI_PENALI = "conseguenze civili/penali";
	private static final String LABEL_TEXT_DICHIARAZIONE = "dichiarazione";
	private static final String LABEL_TEXT_REQUISITI = "requisiti";
	private static final String LABEL_TEXT_FUNZIONI_DIRIGENZIALI = "funzioni dirigenziali";

	// COSTANTI NOMI DIPARTIMENTI
	private static final String DIP_DT = "DIP. I - TESORO";
	private static final String DIP_RGS = "DIP. II - RGS";
	private static final String DIP_DF = "DIP. III - DIPARTIMENTO DELLE FINANZE";
	private static final String DIP_DAG = "DIP. IV - AMM. GEN. PERSONALE";

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		renderRequest.setAttribute(MefIstanzaInterpelloConfig.class.getName(), _configuration);

		Richiedente richiedente;
		try {
			richiedente = getRichiedente(themeDisplay);
			renderRequest.setAttribute("richiedente", richiedente);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		long id_richiesta_esistente;
		List<RichInterpello> richiestaUserEsistente = RichInterpelloLocalServiceUtil.getRichByScreename(user.getScreenName());
		if (!(("recap").equalsIgnoreCase((String) renderRequest.getAttribute("navigation")))
				&& !(("form").equalsIgnoreCase((String) renderRequest.getAttribute("navigation")))  
				&& !(("detail").equalsIgnoreCase((String) renderRequest.getAttribute("navigation")))) {
			if (richiestaUserEsistente != null && !richiestaUserEsistente.isEmpty()) {
				id_richiesta_esistente = richiestaUserEsistente.get(0).getId();
				renderRequest.setAttribute("richIstInterpelloId", id_richiesta_esistente);
			}
		}

		super.doView(renderRequest, renderResponse);
	}

	private Richiedente getRichiedente(ThemeDisplay themeDisplay) throws PortalException {

		Richiedente richiedente = new Richiedente();

		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		User user = themeDisplay.getUser();
		richiedente.setNome(user.getFirstName());
		richiedente.setCognome(user.getLastName());
		richiedente.setCodiceFiscale(user.getScreenName());
		richiedente.setDataNascita(formatDate.format(user.getBirthday()));
		richiedente.setResidenzaCitta("");
		richiedente.setResidenzaIndirizzo("");
		richiedente.setArea("");
		richiedente.setFasciaRetributiva("");
		richiedente.setLuogoNascita("");

		// Residenza e Luogo Nascita
		List<Address> listaIndirizzi = user.getAddresses();
		for (Address addressItem : listaIndirizzi) {
			if (("Personal").equalsIgnoreCase(addressItem.getType().getName())) {
				try {
					if (CityLocalServiceUtil.getCity(addressItem.getCity()) != null)
						if (CityLocalServiceUtil.getCity(addressItem.getCity()).getName() != null) {
							richiedente
									.setResidenzaCitta(CityLocalServiceUtil.getCity(addressItem.getCity()).getName());
							richiedente.setResidenzaIndirizzo(addressItem.getStreet1());
						}
				} catch (Exception e) {
					_log.error(e);
				}
			} else if (("Other").equalsIgnoreCase(addressItem.getType().getName())) {
				try {
					if (CityLocalServiceUtil.getCity(addressItem.getCity()) != null)
						if (CityLocalServiceUtil.getCity(addressItem.getCity()).getName() != null)
							richiedente.setLuogoNascita(CityLocalServiceUtil.getCity(addressItem.getCity()).getName());
				} catch (Exception e) {
					_log.error(e);
				}
			}
		}

		// Area appartenenza e fascia economica
		if (user.getExpandoBridge().hasAttribute(_customFieldUserLevel)
				&& user.getExpandoBridge().getAttribute(_customFieldUserLevel) != null
				&& !("").equalsIgnoreCase(((String) user.getExpandoBridge().getAttribute(_customFieldUserLevel)))) {
			String levelId = (String) user.getExpandoBridge().getAttribute(_customFieldUserLevel);
			if (levelId != null && !("").equals(levelId)) {
				ClassificationLevel areaFascia = ClassificationLevelLocalServiceUtil
						.getClassificationLevel(Long.parseLong(levelId));
				if (areaFascia != null) {
					if (areaFascia.getArea() != null) {
						richiedente.setArea(areaFascia.getArea());
						richiedente.setFasciaRetributiva(areaFascia.getCodEconomicPos());
					}
				}
			}
		}

		// Dipartimento, Direzione e Ufficio
		richiedente.setDipartimento("N/A");
		richiedente.setDirezione("N/A");
		richiedente.setUfficio("N/A");

		if (user.getExpandoBridge().hasAttribute(_customFieldUserOrg)
				&& user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null
				&& !("").equalsIgnoreCase((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg))) {

			long userOrgId = Long.parseLong((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg));
			OrganizationChart organizationChart = OrganizationChartLocalServiceUtil.getOrganizationChart(userOrgId);
			if (organizationChart.getLevel() == 2) {
				richiedente.setDipartimento(organizationChart.getName());
				richiedente.setDipartimentoId(organizationChart.getIdOrgChart());
			}
			if (organizationChart.getLevel() == 3) {
				richiedente.setDirezione(organizationChart.getName());
				richiedente.setDirezioneId(organizationChart.getIdOrgChart());
				OrganizationChart dipartimento = OrganizationChartLocalServiceUtil
						.getOrganizationChart(organizationChart.getIdParent());
				richiedente.setDipartimento(dipartimento.getName());
				richiedente.setDipartimentoId(dipartimento.getIdOrgChart());
			}
			if (organizationChart.getLevel() == 4) {
				richiedente.setUfficio(organizationChart.getName());
				richiedente.setUfficioId(organizationChart.getIdOrgChart());
				OrganizationChart direzione = OrganizationChartLocalServiceUtil
						.getOrganizationChart(organizationChart.getIdParent());
				richiedente.setDirezione(direzione.getName());
				richiedente.setDirezioneId(direzione.getIdOrgChart());
				OrganizationChart dipartimento = OrganizationChartLocalServiceUtil
						.getOrganizationChart(direzione.getIdParent());
				richiedente.setDipartimento(dipartimento.getName());
				richiedente.setDipartimentoId(dipartimento.getIdOrgChart());
			}
		}

		richiedente.setMail(user.getEmailAddress());

		return richiedente;
	}

	private ModuloRichiesta initModelloRichiesta(Richiedente richiedente, TextRichModel textRichConseguenzeCiviliPenali,
			TextRichModel textRichDichiarazione, TextRichModel textRichRequisiti,
			TextRichModel textRichFunzioniDirigenziale) {

		ModuloRichiesta moduloRichiesta = new ModuloRichiesta();

		moduloRichiesta.setNome(richiedente.getNome());
		moduloRichiesta.setCognome(richiedente.getCognome());
		moduloRichiesta.setCodiceFiscale(richiedente.getCodiceFiscale());
		moduloRichiesta.setLuogoNascita(richiedente.getLuogoNascita());
		moduloRichiesta.setDataNascita(richiedente.getDataNascita());
		moduloRichiesta.setResidenzaCitta(richiedente.getResidenzaCitta());
		moduloRichiesta.setResidenzaVia(richiedente.getResidenzaIndirizzo());

		moduloRichiesta.setDataAssunzione(richiedente.getDataAssunzione());
		moduloRichiesta.setDipartimento(richiedente.getDipartimento());
		moduloRichiesta.setDirezione(richiedente.getDirezione());
		moduloRichiesta.setUfficio(richiedente.getUfficio());
		moduloRichiesta.setEmail(richiedente.getMail());
		moduloRichiesta.setAreaAppartenenza(richiedente.getArea());
		moduloRichiesta.setFasciaRetributiva(richiedente.getFasciaRetributiva());

		Opzione testoConfig = new Opzione();
		if (textRichConseguenzeCiviliPenali != null) {
			testoConfig.setId(textRichConseguenzeCiviliPenali.getId_text());
			testoConfig.setTestoOpzione(textRichConseguenzeCiviliPenali.getTesto_text());
		}
		moduloRichiesta.setConseguenzeCiviliPenali(testoConfig);

		testoConfig = new Opzione();
		if (textRichDichiarazione != null) {
			testoConfig.setId(textRichDichiarazione.getId_text());
			testoConfig.setTestoOpzione(textRichDichiarazione.getTesto_text());
		}
		moduloRichiesta.setDichiarazione(testoConfig);

		testoConfig = new Opzione();
		if (textRichRequisiti != null) {
			testoConfig.setId(textRichRequisiti.getId_text());
			testoConfig.setTestoOpzione(textRichRequisiti.getTesto_text());
		}
		moduloRichiesta.setRequisiti(testoConfig);

		testoConfig = new Opzione();
		if (textRichFunzioniDirigenziale != null) {
			testoConfig.setId(textRichFunzioniDirigenziale.getId_text());
			testoConfig.setTestoOpzione(textRichFunzioniDirigenziale.getTesto_text());
		}
		moduloRichiesta.setFunzioniDirigenziali(testoConfig);

		return moduloRichiesta;
	}

	@ProcessAction(name = "vaiARiepilogo")
	public void vaiARiepilogo(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Richiedente richiedente = getRichiedente(themeDisplay);

		TextRich textRich1 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_CONSEGUENZE_CIVILI_PENALI);
		TextRich textRich2 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_DICHIARAZIONE);
		TextRich textRich3 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_REQUISITI);
		TextRich textRich4 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_FUNZIONI_DIRIGENZIALI);

		ModuloRichiesta moduloRichiesta = initModelloRichiesta(richiedente, textRich1, textRich2, textRich3, textRich4);

		actionRequest.setAttribute("moduloRichiesta", moduloRichiesta);

		actionRequest.setAttribute("navigation", "recap");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

	}

	@ProcessAction(name = "vaiAdAnnulla")
	public void vaiAdAnnulla(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.setAttribute("navigation", "form");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	@ProcessAction(name = "invia")
	public void invia(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Richiedente richiedente = getRichiedente(themeDisplay);

		// richiesta istanza interpello params
		long id_richiesta = 0;
		String cognome = richiedente.getCognome();
		String nome = richiedente.getNome();
		long dipartimento = richiedente.getDipartimentoId();
		long direzione = richiedente.getDirezioneId();
		long ufficio = richiedente.getUfficioId();
		String screename = richiedente.getCodiceFiscale();
		String jsonRichiedente = richiedente.toJSON();
		String jsonRichiesta = (String) actionRequest.getParameter("jsonValues");
		Date data_richiesta = new Date();

		TextRich textRich1 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_CONSEGUENZE_CIVILI_PENALI);
		TextRich textRich2 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_DICHIARAZIONE);
		TextRich textRich3 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_REQUISITI);
		TextRich textRich4 = TextRichLocalServiceUtil.getTextByLabel(LABEL_TEXT_FUNZIONI_DIRIGENZIALI);

		ModuloRichiesta moduloRichiesta = initModelloRichiesta(richiedente, textRich1, textRich2, textRich3, textRich4);

		long richIstInterpelloId = RichInterpelloLocalServiceUtil.insertRichiestaInterpello(id_richiesta, cognome, nome,
				dipartimento, direzione, ufficio, screename, jsonRichiedente, jsonRichiesta, null, data_richiesta, null,
				null, null);

		// controllo esito inserimento: se avvenuto con successo, allora invia
		// email
		if (richIstInterpelloId != 0) {
			try {
				sendMailNuovaIstanzaInterpello(actionRequest, richIstInterpelloId, richiedente, moduloRichiesta);

				PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrl.setWindowState(LiferayWindowState.NORMAL);
				renderUrl.setPortletMode(LiferayPortletMode.VIEW);
				renderUrl.setParameter("richIstInterpelloId", String.valueOf(richIstInterpelloId));
				renderUrl.setParameter("navigation", "detail");
				actionResponse.sendRedirect(renderUrl.toString());

			} catch (Exception e) {
				_log.error("Error in email sending: " + e);
			}
		}

	}

	private User getUserByCustomField(long companyId, String fieldName, String fieldValue) throws PortalException {

		List<ExpandoValue> values = ExpandoValueLocalServiceUtil.getColumnValues(companyId, User.class.getName(),
				ExpandoTableConstants.DEFAULT_TABLE_NAME, fieldName, fieldValue, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ExpandoValue value : values) {
			User user = UserLocalServiceUtil.getUser(value.getClassPK());
			return user;
		}

		return null;
	}

	// metodo riepilogativo invio mail (richiamato contestualmente ad un
	// inserimento avvenuto con successo)
	private boolean sendMailNuovaIstanzaInterpello(ActionRequest actionRequest, long richIstInterpelloId,
			Richiedente richiedente, ModuloRichiesta moduloRichiesta)
			throws PortletModeException, WindowStateException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
		String emailSubject = actionRequest.getPreferences().getValue("emailSubject", _configuration.emailSubject());
		emailSubject = StringUtil.replace(emailSubject, new String[] { "[$IDRICHIESTA$]" },
				new String[] { String.valueOf(richIstInterpelloId) });
		String emailBody = actionRequest.getPreferences().getValue("emailBody", _configuration.emailBody());
		emailBody = StringUtil.replace(emailBody,
				new String[] { "[$IDRICHIESTA$]", "[$NOME$]", "[$COGNOME$]", "[$CONSEGUENZECIVILIPENALI$]",
						"[$DICHIARAZIONE$]", "[$REQUISITI$]", "[$FUNZIONIDIRIGENZIALI$]" },
				new String[] { String.valueOf(richIstInterpelloId), richiedente.getNome().toUpperCase(),
						richiedente.getCognome().toUpperCase(),
						moduloRichiesta.getConseguenzeCiviliPenali().getTestoOpzione(),
						moduloRichiesta.getDichiarazione().getTestoOpzione(),
						getHtmlRequisiti(moduloRichiesta.getRequisiti().getTestoOpzione()),
						moduloRichiesta.getFunzioniDirigenziali().getTestoOpzione() });

		EmailSender mail = new EmailSender();

		String dipAppartenenza = richiedente.getDipartimento();

		// recupero lista email dei destinatari da configurazioni della portlet
		List<String> destinatari_email_list_by_dip = new ArrayList<>(0);

		switch (dipAppartenenza) {
		case DIP_DT:
			String emailToDipDT = actionRequest.getPreferences().getValue("emailToDipDT",
					_configuration.emailToDipDT());
			if (emailToDipDT != null && !"".equals(emailToDipDT))
				destinatari_email_list_by_dip = Arrays.asList(emailToDipDT.split(","));
			break;
		case DIP_RGS:
			String emailToDipRGS = actionRequest.getPreferences().getValue("emailToDipRGS",
					_configuration.emailToDipRGS());
			if (emailToDipRGS != null && !"".equals(emailToDipRGS))
				destinatari_email_list_by_dip = Arrays.asList(emailToDipRGS.split(","));
			break;
		case DIP_DF:
			String emailToDipDF = actionRequest.getPreferences().getValue("emailToDipDF",
					_configuration.emailToDipDF());
			if (emailToDipDF != null && !"".equals(emailToDipDF))
				destinatari_email_list_by_dip = Arrays.asList(emailToDipDF.split(","));
			break;
		case DIP_DAG:
			String emailToDipDAG = actionRequest.getPreferences().getValue("emailToDipDAG",
					_configuration.emailToDipDAG());
			if (emailToDipDAG != null && !"".equals(emailToDipDAG))
				destinatari_email_list_by_dip = Arrays.asList(emailToDipDAG.split(","));
			break;
		default:
			destinatari_email_list_by_dip = new ArrayList<>(0);
			break;
		}

		// creazione lista indirizzi email in copia conoscenza
		List<String> cc_email_list = new ArrayList<>(0);

		// primo indirizzo cc: richiedente
		User logUser = themeDisplay.getUser();
		String logUserEmail = logUser.getEmailAddress();
		cc_email_list.add(logUserEmail);

		// secondo indirizzo cc: dirigente da SIAP
		// if (logUser.getExpandoBridge()!=null &&
		// logUser.getExpandoBridge().getAttribute(_customFieldUserDirector)!=null){
		// String directorId = (String)
		// logUser.getExpandoBridge().getAttribute(_customFieldUserDirector);
		// User director;
		// try {
		// director = getUserByCustomField(themeDisplay.getCompanyId(),
		// _customFieldPersonalId, directorId);
		// if(director!=null)
		// cc_email_list.add(director.getEmailAddress());
		// } catch (PortalException e) {
		// _log.error("PortalException: " + e);
		// }
		// }

		// recupero eventuali altri indirizzi in cc da tabella
		if (logUser.getExpandoBridge() != null
				&& logUser.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {
			String orgId = (String) logUser.getExpandoBridge().getAttribute(_customFieldUserOrg);
			List<String> ccEmailListByIdStruttura = EmailLocalServiceUtil
					.getCcEmailListByIdStruttura(Long.parseLong(orgId));
			if (ccEmailListByIdStruttura != null && !ccEmailListByIdStruttura.isEmpty()) {
				cc_email_list.addAll(ccEmailListByIdStruttura);
			}
		}

		Set<String> cc_email_list_not_duplicate = new HashSet<>(0);
		cc_email_list_not_duplicate.addAll(cc_email_list);
		cc_email_list.clear();
		cc_email_list.addAll(cc_email_list_not_duplicate);

		// lista allegati
		List<File> fileAllegatiList = new ArrayList<>(0);
		fileAllegatiList.add(moduloRichiesta.getAllegato());

		// invia mail
		boolean esitoInvioMail = mail.sendMailMessage(emailSubject, emailBody, sender, smtpUser,
				destinatari_email_list_by_dip, cc_email_list, fileAllegatiList);

		_log.info("esitoInvioMail: " + esitoInvioMail);

		return esitoInvioMail;
	}

	private String getHtmlRequisiti(String requisiti) {

		String[] requisitiList = requisiti.split(Pattern.quote("|"));
		StringBuilder requisitiSB = new StringBuilder();

		for (String req : requisitiList) {
			requisitiSB.append("<p>");
			requisitiSB.append(req);
			requisitiSB.append("</p>");
		}

		return requisitiSB.toString();
	}

	private volatile MefIstanzaInterpelloConfig _configuration;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefIstanzaInterpelloConfig.class, properties);
	}

}