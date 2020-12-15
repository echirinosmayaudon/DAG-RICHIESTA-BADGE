package mef.richieste.beni.facili.consumo.portlet;

import com.liferay.portal.kernel.log.Log;
import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.ManagerOfficesBind;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.ManagerOfficesBindLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import external.bfc.intranet.mef.model.Richieste;
import external.bfc.intranet.mef.model.RichiesteInfo;
import external.bfc.intranet.mef.model.RichiesteSequence;
import external.bfc.intranet.mef.model.RigheRichieste;
import external.bfc.intranet.mef.model.RigheRichiesteInfo;
import external.bfc.intranet.mef.model.SediBfc;
import external.bfc.intranet.mef.service.RichiesteLocalServiceUtil;
import external.bfc.intranet.mef.service.RichiesteInfoLocalServiceUtil;
import external.bfc.intranet.mef.service.RichiesteSequenceLocalServiceUtil;
import external.bfc.intranet.mef.service.RigheRichiesteInfoLocalServiceUtil;
import external.bfc.intranet.mef.service.RigheRichiesteLocalServiceUtil;
import external.bfc.intranet.mef.service.SediBfcLocalServiceUtil;
import external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK;
import external.bfc.intranet.mef.service.persistence.RigheRichiestePK;

import com.mef.geco.intranet.service.supportDataLocalServiceUtil;
import servizio.beni.facile.consumo.model.Stato;
import servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew;
import servizio.beni.facile.consumo.richieste.service.RigheRichBFCNewLocalServiceUtil;
import servizio.beni.facile.consumo.service.StatoLocalServiceUtil;
import servizio.local.bfc.model.LocalRich;
import servizio.local.bfc.model.LocalRichInfo;
import servizio.local.bfc.service.LocalRichInfoLocalServiceUtil;
import servizio.local.bfc.service.LocalRichLocalServiceUtil;
import geco.mef.it.MaterialeBean;
import mef.richieste.beni.facili.consumo.util.EmailSender;
import mef.richieste.beni.facili.consumo.util.UtenteUtil;
import mef.richieste.beni.facili.excel.ExcelWriter;

import servizio.beni.facile.consumo.service.CambioStatoDirigenteLocalServiceUtil;
import servizio.beni.facile.consumo.service.GestioneUtentiLocalServiceUtil;
import servizio.beni.facile.consumo.service.PeriodicitaLocalServiceUtil;
import servizio.beni.facile.consumo.model.Periodicita;

import servizio.beni.facile.consumo.service.ServizioMaterialeLocalServiceUtil;
import servizio.beni.facile.consumo.model.ServizioMateriale;

import com.mef.intranet.bean.DatiRichiestaBean;

import com.mef.beni.facili.consumo.stub.ExcelDati;
import com.mef.intranet.bean.Richiedente;
import com.mef.intranet.bean.RisultatoListaRichieste;
import com.mef.intranet.bean.RisultatoRicercaUtente;
import com.mef.intranet.bean.ServizioMaterialeBean;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=mef-richiesteBeniFaciliConsumi-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefRichiesteBeniFaciliConsumiFormPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(MefRichiesteBeniFaciliConsumiFormPortlet.class);
	public static final String ROLERICHIEDENTE = "abilitatoBfc";
	public static final String ROLECONSEGNATARIO = "consegnatarioBfc";
	private Richiedente _richiedente = null;
	private ExcelDati excelDatiStub = null;
	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";
	private final String _roledirigente = "Dirigente";
	Set<OrganizationChart> uffici_by_dirigente_list = new HashSet<OrganizationChart>(0);

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		populateStatoTable();
		populatePeriodicitaTable();
		populateServizioMaterialeTable();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Periodicita> periodicita = (List<Periodicita>) PeriodicitaLocalServiceUtil
				.getPeriodicitas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		DatiRichiestaBean datiRichiestaBean = new DatiRichiestaBean();
		String navigation = (String) renderRequest.getAttribute("navigation");
		User user = themeDisplay.getUser();
		long companyId = themeDisplay.getCompanyId();
		boolean delegato = false;
		boolean dirigente = false;
		boolean consegnatario = false;
		boolean richiedente = false;
		for (Role roles : themeDisplay.getUser().getRoles()) {
			if ("delegatoBfc".equalsIgnoreCase(roles.getName()))
				delegato = true;

			if ("dirigente".equalsIgnoreCase(roles.getName())) {

				dirigente = true;
			}
			if (ROLECONSEGNATARIO.equalsIgnoreCase(roles.getName())) {

				consegnatario = true;
			}
			if (ROLERICHIEDENTE.equalsIgnoreCase(roles.getName())) {

				richiedente = true;
			}
		}
		renderRequest.setAttribute("delegatoRole", delegato);
		renderRequest.setAttribute("dirigenteRole", dirigente);
		renderRequest.setAttribute("consegnatarioRole", consegnatario);
		renderRequest.setAttribute("richiedenteRole", richiedente);
		if (navigation == null) {
			renderRequest.setAttribute("navigation", "inserimentoRichiesta");
			_richiedente = createRichiedente(user, companyId);
			SimpleDateFormat dataOraFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String dataOraDiOggi = dataOraFormatter.format(new Date());
			datiRichiestaBean.setDataRichiesta(dataOraDiOggi);
			renderRequest.setAttribute("periodicita", periodicita);
			renderRequest.setAttribute("datiRichiestaBean", datiRichiestaBean);
			renderRequest.setAttribute("richiedente", _richiedente);
			renderRequest.setAttribute("utente", user);
			renderRequest.setAttribute("dirigente", "0");
			renderRequest.setAttribute("tipoBeni", "beniStandard");

		}

		renderRequest.setAttribute("dipartimentoUtente", getDipartimentoFromUserLocation(user));
		renderRequest.setAttribute("uffici", uffici_by_dirigente_list);

		if (dirigente || delegato) {
			String personIdDir = null;
			if (user != null) {
				if (dirigente) {
					personIdDir = (String) user.getExpandoBridge().getAttribute(_customFieldUserPersonal);
				} else if (delegato) {
					personIdDir = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
				}
			}
			if (personIdDir != null && personIdDir != "") {
				for (ManagerOfficesBind managerOfficesBind : ManagerOfficesBindLocalServiceUtil
						.getManagerOfficesBindByPersonId(Long.parseLong(personIdDir))) {

					try {
						uffici_by_dirigente_list.add(OrganizationChartLocalServiceUtil
								.getOrganizationChart(managerOfficesBind.getIdOrgChart()));
					} catch (PortalException e) {
						_log.warn("error in retrieve offices list by manager" + e);

					}
				}
			}
		}
		String idUfficio = "";
		if (user != null)
			idUfficio = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);

		List<SediBfc> sediByIdOrgChartBeniStandard = new ArrayList<SediBfc>(0);
		List<SediBfc> sediByIdOrgChartBeniInformatici = new ArrayList<SediBfc>(0);

		if (idUfficio != null && idUfficio != "") {

			try {
				OrganizationChart struttura = OrganizationChartLocalServiceUtil
						.getOrganizationChart(Long.parseLong(idUfficio));
				int level = struttura.getLevel();

				if (level >= 4) {
					long levelSedi = struttura.getLevel4();
					sediByIdOrgChartBeniStandard = SediBfcLocalServiceUtil.getSediBfcByIdOrgLiv3AndFlagApp(levelSedi,
							false);
					sediByIdOrgChartBeniInformatici = SediBfcLocalServiceUtil.getSediBfcByIdOrgLiv3AndFlagApp(levelSedi,
							true);
				} else {
					long levelSedi = struttura.getLevel3();
					sediByIdOrgChartBeniStandard = SediBfcLocalServiceUtil.getSediBfcByIdOrgLiv2AndFlagApp(levelSedi,
							false);
					sediByIdOrgChartBeniInformatici = SediBfcLocalServiceUtil.getSediBfcByIdOrgLiv2AndFlagApp(levelSedi,
							true);
				}

			} catch (NumberFormatException | PortalException e) {

				_log.error(e);

			}

		}

		renderRequest.setAttribute("sediBfcBeniStandard", sediByIdOrgChartBeniStandard);
		renderRequest.setAttribute("sediBfcBeniInformatici", sediByIdOrgChartBeniInformatici);

		String nomeDip = getDipartimentoFromUserLocation(user);

		String approvazioneRGS = renderRequest.getPreferences().getValue("approvazioneRGS",
				_configuration.approvazioneRGS());
		String approvazioneDT = renderRequest.getPreferences().getValue("approvazioneDT",
				_configuration.approvazioneDT());
		String approvazioneDF = renderRequest.getPreferences().getValue("approvazioneDF",
				_configuration.approvazioneDF());
		String approvazioneDAG = renderRequest.getPreferences().getValue("approvazioneDAG",
				_configuration.approvazioneDAG());

		boolean approvazioneFlag = ("DIP. II - RGS".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneRGS))
				|| ("DIP. I - TESORO".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneDT))
				|| ("DIP. III - DIPARTIMENTO DELLE FINANZE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDF))
				|| ("DIP. IV - AMM. GEN. PERSONALE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDAG));

		List<Stato> lista_stati = StatoLocalServiceUtil.getStatos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		if (approvazioneFlag) {
			lista_stati = lista_stati.subList(0, 6);
		}

		renderRequest.setAttribute("lista_stati", lista_stati);

		if (user != null) {
			String Idorgchart = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
			renderRequest.setAttribute("codiceUfficio", Idorgchart);
		}
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dataDiOggi = dateFormatter.format(new Date());
		renderRequest.setAttribute("dataDiOggi", dataDiOggi);
		renderRequest.setAttribute(MefRichiesteBeniFaciliConsumiConfig.class.getName(), _configuration);

		super.doView(renderRequest, renderResponse);
	}

	private ExcelDati createExcelDati(String nome, String cognome, String email, String telefono, String dipartimento,
			String direzione, String organizzazione, String ufficio, String ubicazione,
			List<DatiRichiestaBean> materiali, String stanza, String scala, String piano, String orarioRitiro,
			String orarioSostituzione, String magazzinoConsegnatario, String ubicazioneConsegnatario) {

		ExcelDati excelDati = new ExcelDati();
		StringBuilder datiHeader = new StringBuilder();
		datiHeader.append("La richiesta \u00E8 stata inoltrata al magazzino del Consegnatario della sede di");
		datiHeader.append(magazzinoConsegnatario);
		excelDati.setHeader(datiHeader.toString());
		StringBuilder datiAddress = new StringBuilder();
		datiAddress.append("L'ufficio richiedente potr\u00E0 ritirare il materiale di ");
		for (int i = 0; i < materiali.size(); i++) {
			datiAddress.append(materiali.get(i).getMaterialeDescrizione());
			if (i != materiali.size() - 1) {
				datiAddress.append(", ");
			} else {
				datiAddress.append(" ");
			}
		}
		datiAddress.append(" presso: ");
		datiAddress.append(ubicazioneConsegnatario);
		datiAddress.append(" nel seguente orario:");
		excelDati.setAddress(datiAddress.toString());
		excelDati.setRitiroTime(orarioRitiro);
		excelDati.setSostituireInformation(
				"La sostituzione dei prodotti consumabili per le apparecchiature d'ufficio sar\u00E0 effettuata a cura del personale tecnico presso l'ufficio richiedente nel seguente orari:");
		excelDati.setSostituireTime(orarioSostituzione);
		excelDati.setUfficio(ufficio);
		excelDati.setOrganizzazione(organizzazione);
		excelDati.setDipartimento(dipartimento);
		excelDati.setDirezione(direzione);
		excelDati.setNome(nome);
		excelDati.setCognome(cognome);
		excelDati.setEmail(email);
		excelDati.setTelefono(telefono);
		excelDati.setAttualeUbicazione(ubicazione);
		excelDati.setPiano(piano);
		excelDati.setScala(scala);
		excelDati.setStanza(stanza);
		excelDati.setUbicazione(ubicazioneConsegnatario);
		return excelDati;
	}

	private List<ExcelDati> createListMaterialiExcel(List<DatiRichiestaBean> materiali) {
		ExcelDati excelDati;
		List<ExcelDati> listStubDati = new ArrayList<ExcelDati>(0);
		for (DatiRichiestaBean materiale : materiali) {
			excelDati = new ExcelDati();
			excelDati.setDescrizione("");
			excelDati.setGruppo(materiale.getGruppoDescrizione());
			excelDati.setSottogruppo(materiale.getSottoGruppoDescrizione());
			excelDati.setOggetto(materiale.getCostoUnitario());
			excelDati.setQuantita(materiale.getQuantita());
			excelDati.setMateriale(materiale.getMaterialeDescrizione());
			listStubDati.add(excelDati);
		}
		return listStubDati;
	}

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
						long direzioneId = orgChart.getIdParent();

						OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil
								.getOrganizationChart(direzioneId);
						if (direzioneOrgChart != null) {
							richiedente.setOrganizzazione(direzioneOrgChart.getName());
						}
					}
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user");
			if (user != null) {
				richiedente.setNome(user.getFirstName());
				richiedente.setCognome(user.getLastName());
				richiedente.setEmailRichiedente(user.getEmailAddress());
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
				if (user.getExpandoBridge() != null
						&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
					String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
					User cuser = getUsertByCustomField(companyId, _customFieldUserPersonal, directorId);
					if (cuser != null) {
						richiedente.setEmailDirigente(cuser.getEmailAddress());
						richiedente.setNomeDirigente(cuser.getFullName(true, true));
						for (Phone phoneDirigenteItem : cuser.getPhones()) {
							if ("Business".equalsIgnoreCase(phoneDirigenteItem.getType().getName())) {
								richiedente.setTelefonoDirigente(phoneDirigenteItem.getNumber());
								break;
							}
						}

					}

				} else
					_log.warn(_customFieldUserDirector + " not defined for this user");
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

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String idUtente = ParamUtil.getString(resourceRequest, "idutente");
		String btnAction = ParamUtil.getString(resourceRequest, "btnAction");
		User utente = null;
		try {
			utente = UserLocalServiceUtil.getUser(Long.parseLong(idUtente));
		} catch (NumberFormatException e) {
			_log.warn("error in retrieve user by id" + e);

		} catch (PortalException e) {
			_log.warn("error in retrieve user by id" + e);

		}

		if (utente != null) {

			String ufficio = null;

			if (utente.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {

				ufficio = (String) utente.getExpandoBridge().getAttribute(_customFieldUserOrg);
			}

			GestioneUtentiLocalServiceUtil.insertGestioneUtenti(utente.getScreenName().toLowerCase(),
					utente.getFirstName().toLowerCase(), utente.getLastName().toLowerCase(), new Date(), ufficio,
					btnAction, utente, themeDisplay.getCompanyId());
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	public void insertRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");
		String organizzazione = actionRequest.getParameter("organizzazione");
		String sedeDescrizione = actionRequest.getParameter("sedeDescrizione");
		String nome = actionRequest.getParameter("nome");
		String cognome = actionRequest.getParameter("cognome");
		String ubicazioneAttuale = actionRequest.getParameter("ubicazione");
		String piano = actionRequest.getParameter("piano");
		String scala = actionRequest.getParameter("scala");
		String stanza = actionRequest.getParameter("stanza");
		String telefono = actionRequest.getParameter("telefono");
		String emailDirigente = actionRequest.getParameter("emailDirigente");
		String emailRichiedente = actionRequest.getParameter("emailRichiedente");
		String json = actionRequest.getParameter("json");
		String oggetto = actionRequest.getParameter("oggetto");
		String periodicita = actionRequest.getParameter("periodicita");
		String note = actionRequest.getParameter("note");
		JSONObject objdataBFC = JSONFactoryUtil.createJSONObject(json);
		String costoTotale = objdataBFC.getString("costoTotale");
		String codiceGeco = objdataBFC.getString("codiceGeco");
		String idSede = objdataBFC.getString("sede");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Date dataRichiesta = new Date();
		User user = themeDisplay.getUser();
		long companyId = themeDisplay.getCompanyId();
		Richiedente richiedente = createRichiedente(user, companyId);
		String ufficioname = null;
		String budget = "0";
		String consuntivo = "0";

		String direzioneAcronimo = getAcronimoDirezioneFromUfficioRichiedente(user);

		if ((user != null) && (user.getExpandoBridge() != null)
				&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
			String ufficioidorg = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
			if (ufficioidorg != null && ufficioidorg != "") {
				Long idChart = Long.parseLong(ufficioidorg);
				OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
				if (orgChart != null) {
					ufficioname = orgChart.getAcronimo();
				}
			}
		} else
			_log.warn(_customFieldUserOrg + " not defined for this user");

		String email = richiedente.getEmailDirigente();
		String nomeDip = getDipartimentoFromUserLocation(user);
		String direzione = getDirezioneFromUfficioRichiedente(user);
		HashMap<String, List<DatiRichiestaBean>> datirichiestaMap = jsontoData(json);
		List<DatiRichiestaBean> listaBcf = datirichiestaMap.get("listBeniStandard");
		List<DatiRichiestaBean> listaBcfInformatica = datirichiestaMap.get("listBeniInformatica");
		String tipoBeni = objdataBFC.getString("tipoBeni");
		String numeroMacchina = objdataBFC.getString("numeroInventarioMacchina");
		String orarioRitiro = actionRequest.getPreferences().getValue("orarioRitiro", _configuration.orarioRitiro());
		String orarioSostituzione = actionRequest.getPreferences().getValue("orarioSostituzione",
				_configuration.orarioSostituzione());
		String magazzinoConsegnatario = actionRequest.getPreferences().getValue("indirizzoMagazzino",
				_configuration.indirizzoMagazzino());
		String ubicazioneConsegnatario = actionRequest.getPreferences().getValue("ubicazioneMagazzino",
				_configuration.ubicazioneMagazzino());
		List<ExcelDati> excelListDati = new ArrayList<ExcelDati>(0);
		Long idResult = 0L;
		String origine = "2";
		String priodicitaReq = null;
		if ("1".equals(periodicita))
			priodicitaReq = "M";
		if ("2".equals(periodicita))
			priodicitaReq = "S";

		List<MaterialeBean> listaMateriali = null;
		if (!listaBcf.isEmpty()) {
			listaMateriali = new ArrayList<MaterialeBean>(0);
			for (DatiRichiestaBean itemBfc : listaBcf) {
				MaterialeBean materialebeanitem = new MaterialeBean();
				materialebeanitem.setSottogruppo(itemBfc.getSottoGruppo());
				materialebeanitem.setGruppo(itemBfc.getGruppo());
				materialebeanitem.setScheda(itemBfc.getMateriale());
				materialebeanitem.setQtarichiesta(itemBfc.getQuantita());
				listaMateriali.add(materialebeanitem);
			}
		}
		List<MaterialeBean> listaMaterialiInformatici = null;
		if (!listaBcfInformatica.isEmpty()) {
			listaMaterialiInformatici = new ArrayList<MaterialeBean>(0);
			for (DatiRichiestaBean itemBfcInformatici : listaBcfInformatica) {
				MaterialeBean materialebeanitem = new MaterialeBean();
				materialebeanitem.setSottogruppo(itemBfcInformatici.getSottoGruppo());
				materialebeanitem.setGruppo(itemBfcInformatici.getGruppo());
				materialebeanitem.setScheda(itemBfcInformatici.getMateriale());
				materialebeanitem.setQtarichiesta(itemBfcInformatici.getQuantita());
				listaMaterialiInformatici.add(materialebeanitem);
			}
		}
		List<RichiesteSequence> sequence = RichiesteSequenceLocalServiceUtil.getRichiesteSequences(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		long id_richiesta = sequence.get(0).getIdSeq();

		String approvazioneRGS = actionRequest.getPreferences().getValue("approvazioneRGS",
				_configuration.approvazioneRGS());
		String approvazioneDT = actionRequest.getPreferences().getValue("approvazioneDT",
				_configuration.approvazioneDT());
		String approvazioneDF = actionRequest.getPreferences().getValue("approvazioneDF",
				_configuration.approvazioneDF());
		String approvazioneDAG = actionRequest.getPreferences().getValue("approvazioneDAG",
				_configuration.approvazioneDAG());

		boolean approvazioneFlag = ("DIP. II - RGS".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneRGS))
				|| ("DIP. I - TESORO".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneDT))
				|| ("DIP. III - DIPARTIMENTO DELLE FINANZE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDF))
				|| ("DIP. IV - AMM. GEN. PERSONALE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDAG));

		String risultatoRichiesta = null;

		if (approvazioneFlag) {

			try {
				if (direzioneAcronimo != null) {
					if (direzioneAcronimo.length() < 59)
						direzioneAcronimo = direzioneAcronimo.substring(0, direzioneAcronimo.length());

					else
						direzioneAcronimo = direzioneAcronimo.substring(0, 59);
				}

				if (ufficioname != null) {
					if (ufficioname.length() < 59)
						ufficioname = ufficioname.substring(0, ufficioname.length());

					else
						ufficioname = ufficioname.substring(0, 59);
				}

				if (user != null) {
					if ("beniStandard".equalsIgnoreCase(tipoBeni) && listaMateriali != null) {
						risultatoRichiesta = insertRichiestaGeco(actionRequest, origine, String.valueOf(id_richiesta),
								user.getScreenName(), codiceGeco, emailRichiedente, direzioneAcronimo, ufficioname,
								telefono, objdataBFC.getString("stanza"), idSede, oggetto,
								objdataBFC.getString("dataRichiesta"), priodicitaReq, budget, consuntivo,
								listaMateriali, note);
					}
					if ("beniInformatica".equalsIgnoreCase(tipoBeni) && listaMaterialiInformatici != null) {
						risultatoRichiesta = insertRichiestaGeco(actionRequest, origine, String.valueOf(id_richiesta),
								user.getScreenName(), codiceGeco, emailRichiedente, direzioneAcronimo, ufficioname,
								telefono, objdataBFC.getString("stanza"), idSede, oggetto,
								objdataBFC.getString("dataRichiesta"), "S", budget, consuntivo,
								listaMaterialiInformatici, note);
					}
				}
			} catch (Exception e) {
				_log.error(e);
				actionRequest.setAttribute("catch-geco-error-label",
						"La richiesta non \u00E8 andata a buon fine per indisponibilit\u00E0 del servizio.");
				SessionErrors.add(actionRequest, "catch-geco-error");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			}

		}

		if (risultatoRichiesta == null && approvazioneFlag) {
			actionRequest.setAttribute("catch-geco-error-label",
					"La richiesta non \u00E8 andata a buon fine a causa di un errore generico.");
			SessionErrors.add(actionRequest, "catch-geco-client-generic-error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}

		if (risultatoRichiesta != null && "1".equals(risultatoRichiesta)) {
			actionRequest.setAttribute("catch-geco-error-label",
					"La richiesta non \u00E8 andata a buon fine per indisponibilit\u00E0 del servizio.");
			SessionErrors.add(actionRequest, "catch-geco-error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}

		else if ((risultatoRichiesta != null && "0".equals(risultatoRichiesta)) || !approvazioneFlag) {
			if ("beniStandard".equals(tipoBeni)) {
				Float costoReale = 0F;
				if (costoTotale != null && !costoTotale.isEmpty())
					costoReale = Float.parseFloat(costoTotale);

				Integer flagInvio = 0;
				Long idPeriodicita = Long.parseLong(periodicita);
				Long idStatoAttuale = 1L;
				Long idStatoAttualeLocal = 7L;
				String noteConsegnatario = null;
				String strutIsp = null;
				String strutIsp2 = null;
				String strutUff = null;
				Long uidIns = null;
				Long uidUpd = null;
				Integer preventivo = null;
				long counterBfc = 0;
				float importo = 0;
				Date dataUpd = null;
				if (user != null) {
					if (risultatoRichiesta != null && "0".equals(risultatoRichiesta)) {
						idResult = insertRichiestaToStage(id_richiesta, costoReale, dataRichiesta, dataRichiesta,
								dataRichiesta, user.getEmailAddress(), flagInvio, idPeriodicita, idSede, idStatoAttuale,
								direzioneAcronimo, noteConsegnatario, note, oggetto, preventivo, stanza, strutIsp,
								strutIsp2, strutUff, telefono, ufficioname, uidIns, uidUpd);
						for (DatiRichiestaBean datiRichiestaBfc : listaBcf) {
							counterBfc++;
							insertRigherichiestaToStage(id_richiesta, Long.parseLong(datiRichiestaBfc.getMateriale()),
									datiRichiestaBfc.getGruppo(), datiRichiestaBfc.getSottoGruppo(), counterBfc,
									importo, Long.parseLong(datiRichiestaBfc.getQuantita()),
									Long.parseLong(datiRichiestaBfc.getQuantita()), dataRichiesta, dataUpd, uidIns,
									uidUpd, datiRichiestaBfc.getMaterialeDescrizione());
						}
					}

					else if (!approvazioneFlag) {
						idResult = insertRichiestaToLocal(costoReale, dataRichiesta, dataRichiesta, dataRichiesta,
								user.getEmailAddress(), flagInvio, idPeriodicita, idSede, idStatoAttualeLocal,
								direzioneAcronimo, noteConsegnatario, note, oggetto, preventivo, stanza, strutIsp,
								strutIsp2, strutUff, telefono, ufficioname, uidIns, uidUpd, false);
					}
				}
				if (idResult != null) {
					RigheRichBFCNewLocalServiceUtil.insertRigheRichBFCNew(idResult, nomeDip, json);
					excelDatiStub = createExcelDati(nome, cognome, emailRichiedente, telefono, nomeDip, direzione,
							organizzazione, ufficioRichiedente, ubicazioneAttuale, listaBcf, stanza, scala, piano,
							orarioRitiro, orarioSostituzione, magazzinoConsegnatario, ubicazioneConsegnatario);
					excelListDati = createListMaterialiExcel(listaBcf);
				}
			}
			if ("beniInformatica".equals(tipoBeni)) {

				Float costoReale = 0F;
				if (costoTotale != null && !costoTotale.isEmpty())
					costoReale = Float.parseFloat(costoTotale);

				Integer flagInvio = 0;
				Long idStatoAttuale = 1L;
				Long idStatoAttualeLocal = 7L;
				String noteConsegnatario = null;
				String strutIsp = null;
				String strutUff = null;
				Long uidIns = null;
				Long uidUpd = null;
				Integer preventivo = null;
				long counterBfcInfo = 0;
				float importo = 0;
				Date dataUpd = null;
				if (user != null) {
					if (risultatoRichiesta != null && "0".equals(risultatoRichiesta)) {
						idResult = insertRichiestaInformaticaToStage(id_richiesta, costoReale, dataRichiesta,
								dataRichiesta, dataRichiesta, user.getEmailAddress(), flagInvio, numeroMacchina, idSede,
								idStatoAttuale, direzioneAcronimo, noteConsegnatario, note,
								richiedente.getNomeDirigente(), oggetto, preventivo, stanza, strutIsp, strutUff,
								telefono, richiedente.getTelefonoDirigente(), ufficioname, uidIns, uidUpd);
						for (DatiRichiestaBean datiRichiestaBfcInfo : listaBcfInformatica) {
							counterBfcInfo++;
							insertRigherichiestaInfoToStage(id_richiesta,
									Long.parseLong(datiRichiestaBfcInfo.getMateriale()),
									datiRichiestaBfcInfo.getGruppo(), datiRichiestaBfcInfo.getSottoGruppo(),
									counterBfcInfo, importo, Long.parseLong(datiRichiestaBfcInfo.getQuantita()),
									Long.parseLong(datiRichiestaBfcInfo.getQuantita()), dataRichiesta, dataUpd, uidIns,
									uidUpd, datiRichiestaBfcInfo.getMaterialeDescrizione());
						}
					}

					else if (!approvazioneFlag) {
						idResult = insertRichiestaInformaticaToLocal(costoReale, dataRichiesta, dataRichiesta,
								dataRichiesta, user.getEmailAddress(), flagInvio, numeroMacchina, idSede,
								idStatoAttualeLocal, direzioneAcronimo, noteConsegnatario, note,
								richiedente.getNomeDirigente(), oggetto, preventivo, stanza, strutIsp, strutUff,
								telefono, richiedente.getTelefonoDirigente(), ufficioname, uidIns, uidUpd, false);
					}
				}

				if (idResult != null) {
					RigheRichBFCNewLocalServiceUtil.insertRigheRichBFCNew(idResult, nomeDip, json);
					excelDatiStub = createExcelDati(nome, cognome, emailRichiedente, telefono, nomeDip, direzione,
							organizzazione, ufficioRichiedente, ubicazioneAttuale, listaBcfInformatica, stanza, scala,
							piano, orarioRitiro, orarioSostituzione, magazzinoConsegnatario, ubicazioneConsegnatario);
					excelListDati = createListMaterialiExcel(listaBcfInformatica);
				}
			}

			if (idResult != null && idResult != 0) {

				File tmpxls = FileUtil.createTempFile("Richiesta", "xls");
				ExcelWriter.writeRichiesteExcel(excelListDati, excelDatiStub, tmpxls);
				String mailbody = actionRequest.getPreferences().getValue("richiestaBeniTmpl",
						_configuration.richiestaBeniTmpl());
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String subjectTesto = actionRequest.getPreferences().getValue("subjectNuova",
						_configuration.subjectNuova());
				String subject = createSubjectEmail(Long.toString(idResult), nomeDip,
						richiedente.getUfficioRichiedente(), subjectTesto);
				String sender = actionRequest.getPreferences().getValue("senderBeni", _configuration.senderBeni());
				String emailReferente = actionRequest.getPreferences().getValue("emailReferente",
						_configuration.emailReferente());
				EmailSender mail = new EmailSender();
				String datirichiedente = getHtmlRichiedente(ufficioRichiedente, organizzazione, nome, cognome,
						ubicazioneAttuale, piano, scala, stanza, telefono, emailRichiedente, sedeDescrizione);
				String datirichiesta = null;
				if ("beniInformatica".equals(tipoBeni))
					datirichiesta = getHtmlRichiesta(oggetto, new SimpleDateFormat("dd-MM-yyyy").format(dataRichiesta),
							note, costoTotale, listaBcfInformatica, null);

				if ("beniStandard".equals(tipoBeni))
					datirichiesta = getHtmlRichiesta(oggetto, new SimpleDateFormat("dd-MM-yyyy").format(dataRichiesta),
							note, costoTotale, listaBcf, null);

				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
						new String[] { datirichiedente, datirichiesta });
				mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferente, email, emailRichiedente,
						tmpxls);

				DatiRichiestaBean datiDettaglioRichiestaBean = new DatiRichiestaBean();
				Richiedente datiDettaglioRichiedenteBean = new Richiedente();

				JSONObject jsonObjectRigheRichiestaDati = JSONFactoryUtil.createJSONObject(json);
				datiDettaglioRichiestaBean.setOggetto(jsonObjectRigheRichiestaDati.getString("oggetto"));
				datiDettaglioRichiestaBean.setDataRichiesta(jsonObjectRigheRichiestaDati.getString("dataRichiesta"));
				String noteConsegnatario = null;
				if ("beniStandard".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {

					if (risultatoRichiesta != null && "0".equals(risultatoRichiesta)) {
						Richieste richiesta = RichiesteLocalServiceUtil.getRichieste(idResult);
						datiDettaglioRichiestaBean.setStato(
								StatoLocalServiceUtil.getStato(richiesta.getIdStatoAttuale()).getDescrizione());
						noteConsegnatario = richiesta.getNote();
					}

					else if (!approvazioneFlag) {
						LocalRich locRich = LocalRichLocalServiceUtil.getRichiestebyIdRichiesta(idResult).get(0);
						datiDettaglioRichiestaBean
								.setStato(StatoLocalServiceUtil.getStato(locRich.getIdStatoAttuale()).getDescrizione());
						noteConsegnatario = locRich.getNote();
					}

					actionRequest.setAttribute("beniStandard", "Beni Standard");

				} else if ("beniInformatica".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {

					if (risultatoRichiesta != null && "0".equals(risultatoRichiesta)) {
						RichiesteInfo richiestaInfo = RichiesteInfoLocalServiceUtil.getRichiesteInfo(idResult);
						datiDettaglioRichiestaBean.setStato(
								StatoLocalServiceUtil.getStato(richiestaInfo.getIdStatoAttuale()).getDescrizione());
						noteConsegnatario = richiestaInfo.getNote();
					}

					else if (!approvazioneFlag) {
						LocalRichInfo locRichInfo = LocalRichInfoLocalServiceUtil.getRichiestebyIdRichiesta(idResult)
								.get(0);
						datiDettaglioRichiestaBean.setStato(
								StatoLocalServiceUtil.getStato(locRichInfo.getIdStatoAttuale()).getDescrizione());
						noteConsegnatario = locRichInfo.getNote();
					}

					actionRequest.setAttribute("beniInformatica", "Beni di Tipo Informatico");

				}
				SimpleDateFormat dataOraFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date dataOraRichiesta = dataOraFormatter.parse(datiDettaglioRichiestaBean.getDataRichiesta());
				SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy");
				Date dataRichiestaDettaglio = dataFormatter.parse(datiDettaglioRichiestaBean.getDataRichiesta());
				datiDettaglioRichiestaBean.setDataRichiesta(dataFormatter.format(dataRichiestaDettaglio));

				datiDettaglioRichiedenteBean.setNome(jsonObjectRigheRichiestaDati.getString("nome"));
				datiDettaglioRichiedenteBean.setCognome(jsonObjectRigheRichiestaDati.getString("cognome"));
				datiDettaglioRichiedenteBean
						.setUfficioRichiedente(jsonObjectRigheRichiestaDati.getString("ufficioRichiedente"));
				datiDettaglioRichiedenteBean
						.setOrganizzazione(jsonObjectRigheRichiestaDati.getString("organizzazione"));
				datiDettaglioRichiedenteBean.setUbicazione(jsonObjectRigheRichiestaDati.getString("ubicazione"));
				datiDettaglioRichiedenteBean.setPalazzina(jsonObjectRigheRichiestaDati.getString("palazzina"));
				datiDettaglioRichiedenteBean.setPiano(jsonObjectRigheRichiestaDati.getString("piano"));
				datiDettaglioRichiedenteBean.setScala(jsonObjectRigheRichiestaDati.getString("scala"));
				datiDettaglioRichiedenteBean.setStanza(jsonObjectRigheRichiestaDati.getString("stanza"));
				datiDettaglioRichiedenteBean.setTelefono(jsonObjectRigheRichiestaDati.getString("telefono"));
				datiDettaglioRichiedenteBean
						.setEmailRichiedente(jsonObjectRigheRichiestaDati.getString("emailRichiedente"));
				datiDettaglioRichiedenteBean.setEmailDirigente(jsonObjectRigheRichiestaDati.getString("email"));
				datiDettaglioRichiestaBean.setTipoBeni(jsonObjectRigheRichiestaDati.getString("tipoBeni"));
				datiDettaglioRichiestaBean
						.setPeriodicitaDescrizione(jsonObjectRigheRichiestaDati.getString("periodicitaDescrizione"));
				HashMap<String, List<DatiRichiestaBean>> richiestePerDettaglio = jsontoData(json);
				List<DatiRichiestaBean> beni_standard_list_dettaglio = richiestePerDettaglio.get("listBeniStandard");
				List<DatiRichiestaBean> beni_informatici_list_dettaglio = richiestePerDettaglio
						.get("listBeniInformatica");
				datiDettaglioRichiestaBean.setCostoTotale(jsonObjectRigheRichiestaDati.getString("costoTotale"));
				datiDettaglioRichiestaBean.setDescrizione(jsonObjectRigheRichiestaDati.getString("descrizione"));
				datiDettaglioRichiestaBean.setNumeroInventarioMacchina(
						jsonObjectRigheRichiestaDati.getString("numeroInventarioMacchina"));

				datiDettaglioRichiedenteBean
						.setSedeDescrizione(jsonObjectRigheRichiestaDati.getString("sedeDescrizione"));

				actionRequest.setAttribute("dataRichiesta", dataOraRichiesta);
				actionRequest.setAttribute("datiDettaglioRichiedenteBean", datiDettaglioRichiedenteBean);
				actionRequest.setAttribute("datiDettaglioRichiestaBean", datiDettaglioRichiestaBean);
				actionRequest.setAttribute("beniStandardListDettaglio", beni_standard_list_dettaglio);
				actionRequest.setAttribute("beniInformaticiListDettaglio", beni_informatici_list_dettaglio);
				actionRequest.setAttribute("beniStandardListDettaglioSize", beni_standard_list_dettaglio.size());
				actionRequest.setAttribute("beniInformaticiListDettaglioSize", beni_informatici_list_dettaglio.size());

				if (!"".equalsIgnoreCase(noteConsegnatario)) {
					actionRequest.setAttribute("noteConsegnatario", noteConsegnatario);
				}

				PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
				urlRefresh.setParameter("javax.portlet.action", "vaiADettaglio");
				urlRefresh.setParameter("richiestaId", String.valueOf(idResult));
				urlRefresh.setParameter("statoRichiesta", datiDettaglioRichiestaBean.getStato());
				actionResponse.sendRedirect(urlRefresh.toString());

			}

			else {
				SessionErrors.add(actionRequest, "Errore-durante-caricamento");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				DatiRichiestaBean datiRichiestaBean = createDatiRichiesta(json);
				actionRequest.setAttribute("ufficioRichiedente", ufficioRichiedente);
				actionRequest.setAttribute("nome", nome);
				actionRequest.setAttribute("cognome", cognome);
				actionRequest.setAttribute("ubicazione", ubicazioneAttuale);
				actionRequest.setAttribute("piano", piano);
				actionRequest.setAttribute("scala", scala);
				actionRequest.setAttribute("stanza", stanza);
				actionRequest.setAttribute("telefono", telefono);
				actionRequest.setAttribute("emailDirigente", emailDirigente);
				actionRequest.setAttribute("emailRichiedente", emailRichiedente);
				actionRequest.setAttribute("json", json);
				actionRequest.setAttribute("datiDellaRichiesta", datiRichiestaBean);
				actionRequest.setAttribute("listBeniStandard", listaBcf);
				actionRequest.setAttribute("listBeniInformatica", listaBcfInformatica);
				actionRequest.setAttribute("navigation", "riepilogo");
			}

		}

	}

	public void vaiModificaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {

			String id = actionRequest.getParameter("idRichiesta");
			String stato = actionRequest.getParameter("stato");
			long idRichiesta = Long.parseLong(id);
			List<RigheRichBFCNew> datiRichiesta = (List<RigheRichBFCNew>) RigheRichBFCNewLocalServiceUtil
					.getRigaRichiestaByIdRichiesta(idRichiesta);
			List<Periodicita> periodicita = (List<Periodicita>) PeriodicitaLocalServiceUtil
					.getPeriodicitas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<ServizioMateriale> servizioMateriale = (List<ServizioMateriale>) ServizioMaterialeLocalServiceUtil
					.getServizioMateriales(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			StringBuilder jsonCompleto = new StringBuilder();
			jsonCompleto.append(datiRichiesta.get(0).getDati1());
			jsonCompleto.append(datiRichiesta.get(0).getDati2());
			jsonCompleto.append(datiRichiesta.get(0).getDati3());
			jsonCompleto.append(datiRichiesta.get(0).getDati4());

			JSONObject obj = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
			Richiedente richiedente = new Richiedente();
			DatiRichiestaBean datiRichiedente = new DatiRichiestaBean();
			String ufficioRichiedente = obj.getString("ufficioRichiedente");
			String organizzazione = obj.getString("organizzazione");
			String nome = obj.getString("nome");
			String cognome = obj.getString("cognome");
			String ubicazione = obj.getString("ubicazione");
			String palazzina = obj.getString("palazzina");
			String piano = obj.getString("piano");
			String stanza = obj.getString("stanza");
			String scala = obj.getString("scala");
			String telefono = obj.getString("telefono");
			String emailRichiedente = obj.getString("emailRichiedente");
			String email = obj.getString("email");
			String oggetto = obj.getString("oggetto");
			String periodicitaId = obj.getString("periodicita");
			String numeroInventarioMacchina = obj.getString("numeroInventarioMacchina");
			String descrizione = obj.getString("descrizione");
			String sede = obj.getString("sede");

			String sedeDescrizione = obj.getString("sedeDescrizione");
			String costoTotale = obj.getString("costoTotale");
			String tipoBeni = obj.getString("tipoBeni");
			richiedente.setNome(nome);
			richiedente.setCognome(cognome);
			richiedente.setUfficioRichiedente(ufficioRichiedente);
			richiedente.setOrganizzazione(organizzazione);
			richiedente.setUbicazione(ubicazione);
			richiedente.setPalazzina(palazzina);
			richiedente.setPiano(piano);
			richiedente.setScala(scala);
			richiedente.setStanza(stanza);
			richiedente.setTelefono(telefono);
			richiedente.setEmailDirigente(email);
			richiedente.setEmailRichiedente(emailRichiedente);
			richiedente.setSede(sede);
			richiedente.setSedeDescrizione(sedeDescrizione);
			datiRichiedente.setCostoTotale(costoTotale);
			datiRichiedente.setDescrizione(descrizione);
			datiRichiedente.setNumeroInventarioMacchina(numeroInventarioMacchina);
			datiRichiedente.setPeriodicita(periodicitaId);
			datiRichiedente.setOggetto(oggetto);
			SimpleDateFormat dataOraFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String dataOraDiOggi = dataOraFormatter.format(new Date());
			datiRichiedente.setDataRichiesta(dataOraDiOggi);
			JSONObject jsonCompl = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
			datiRichiedente.setCodiceGeco(jsonCompl.getString("codiceGeco"));
			HashMap<String, List<DatiRichiestaBean>> mappaRichieste = jsontoData(jsonCompleto.toString());
			List<DatiRichiestaBean> listGruppoStandard = mappaRichieste.get("listBeniStandard");
			List<DatiRichiestaBean> listGruppoInformatica = mappaRichieste.get("listBeniInformatica");

			String navigation = "inserimentoRichiesta";
			actionRequest.setAttribute("dirigente", "1");
			actionRequest.setAttribute("stato", stato);
			actionRequest.setAttribute("datiRichiestaBean", datiRichiedente);
			actionRequest.setAttribute("servizioMateriale", servizioMateriale);
			actionRequest.setAttribute("json", jsonCompleto.toString());
			actionRequest.setAttribute("richiedente", richiedente);
			actionRequest.setAttribute("listGruppoStandard", listGruppoStandard);
			actionRequest.setAttribute("listGruppoInformatica", listGruppoInformatica);
			actionRequest.setAttribute("idRichiesta", id);
			actionRequest.setAttribute("periodicita", periodicita);
			actionRequest.setAttribute("tipoBeni", tipoBeni);
			actionRequest.setAttribute("navigation", navigation);
		} catch (JSONException e) {
			_log.error(e);
		}
	}

	public void approvaRifiutaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		String idrichesta = actionRequest.getParameter("idRichiesta");
		String action = actionRequest.getParameter("action");
		String motivazioneRifiuto = actionRequest.getParameter("motivazioneRifiuto");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		if (idrichesta != null) {
			List<RigheRichBFCNew> listarichieste = RigheRichBFCNewLocalServiceUtil
					.getRigaRichiestaByIdRichiesta(Long.parseLong(idrichesta));

			StringBuilder jsonCompleto = new StringBuilder();
			jsonCompleto.append(listarichieste.get(0).getDati1());
			jsonCompleto.append(listarichieste.get(0).getDati2());
			jsonCompleto.append(listarichieste.get(0).getDati3());
			jsonCompleto.append(listarichieste.get(0).getDati4());

			JSONObject objdataBFC = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
			String costoTotale = objdataBFC.getString("costoTotale");
			String budget = "0";
			String consuntivo = "0";
			String origine = "2";
			User utenteRichiedente;
			String codUtente = "";

			if (UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
					objdataBFC.getString("emailRichiedente")) != null) {
				utenteRichiedente = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
						objdataBFC.getString("emailRichiedente"));
				codUtente = utenteRichiedente.getScreenName();
			}

			String ufficio = objdataBFC.getString("ufficioRichiedente");
			String organizzazione = objdataBFC.getString("organizzazione");
			String telefono_richiedente = objdataBFC.getString("telefono");
			String riferimento_stanza = objdataBFC.getString("stanza");
			String tipobeni = objdataBFC.getString("tipoBeni");
			String email = objdataBFC.getString("email");
			String emailRich = objdataBFC.getString("emailRichiedente");
			String oggetto = objdataBFC.getString("oggetto");
			String note = objdataBFC.getString("descrizione");
			String datarichiesta = objdataBFC.getString("dataRichiesta");
			String periodicita = objdataBFC.getString("periodicita");
			String sedeDescrizione = objdataBFC.getString("sedeDescrizione");
			Integer flagInvio = 0;
			Long idStatoAttuale = 1L;
			String noteConsegnatario = null;
			Integer preventivo = null;
			String strutIsp = null;
			String strutIsp2 = null;
			String strutUff = null;
			Long uidIns = null;
			Long uidUpd = null;
			String numeroMacchina = objdataBFC.getString("numeroInventarioMacchina");
			String nomeReferente = objdataBFC.getString("nomeReferente");
			String codiceGeco = objdataBFC.getString("codiceGeco");
			String idSede = objdataBFC.getString("sede");

			String priodicitaReq = null;
			if ("1".equals(periodicita))
				priodicitaReq = "M";
			if ("2".equals(periodicita))

				priodicitaReq = "S";

			HashMap<String, List<DatiRichiestaBean>> datirichiestaMap = jsontoData(jsonCompleto.toString());
			List<DatiRichiestaBean> listaBcf = datirichiestaMap.get("listBeniStandard");
			List<DatiRichiestaBean> listaBcfInformatica = datirichiestaMap.get("listBeniInformatica");

			String emailoriginalrich = null;

			if ("beniStandard".equals(tipobeni)) {
				List<LocalRich> listrich = LocalRichLocalServiceUtil
						.getRichiestebyIdRichiesta(Long.parseLong(idrichesta));
				emailoriginalrich = listrich.get(0).getEmail();
			}
			if ("beniInformatica".equals(tipobeni)) {
				List<LocalRichInfo> listrichInfo = LocalRichInfoLocalServiceUtil
						.getRichiestebyIdRichiesta(Long.parseLong(idrichesta));
				emailoriginalrich = listrichInfo.get(0).getEmail();
			}

			User userOriginal = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
					emailoriginalrich);
			String uffAcronimo = getUfficioAcronimoFromUserLocation(userOriginal);
			String direzioneAcronimo = getAcronimoDirezioneFromUfficioRichiedente(userOriginal);

			List<MaterialeBean> listaMateriali = new ArrayList<MaterialeBean>(0);

			if (!listaBcf.isEmpty()) {
				for (DatiRichiestaBean itemBfc : listaBcf) {
					MaterialeBean materialebeanitem = new MaterialeBean();
					materialebeanitem.setSottogruppo(itemBfc.getSottoGruppo());
					materialebeanitem.setGruppo(itemBfc.getGruppo());
					materialebeanitem.setScheda(itemBfc.getMateriale());
					materialebeanitem.setQtarichiesta(itemBfc.getQuantita());
					listaMateriali.add(materialebeanitem);
				}
			}
			List<MaterialeBean> listaMaterialiInformatici = new ArrayList<MaterialeBean>(0);
			if (!listaBcfInformatica.isEmpty()) {
				for (DatiRichiestaBean itemBfcInformatici : listaBcfInformatica) {
					MaterialeBean materialebeanitem = new MaterialeBean();
					materialebeanitem.setSottogruppo(itemBfcInformatici.getSottoGruppo());
					materialebeanitem.setGruppo(itemBfcInformatici.getGruppo());
					materialebeanitem.setScheda(itemBfcInformatici.getMateriale());
					materialebeanitem.setQtarichiesta(itemBfcInformatici.getQuantita());
					listaMaterialiInformatici.add(materialebeanitem);
				}
			}
			String nome = objdataBFC.getString("nome");
			String cognome = objdataBFC.getString("cognome");
			String ubicazione = objdataBFC.getString("ubicazione");
			String piano = objdataBFC.getString("piano");
			String scala = objdataBFC.getString("scala");
			String telefono = objdataBFC.getString("telefono");

			long stato = 0L;
			if ("approva".equals(action)) {

				String risultatoRichiesta = null;

				try {
					if (direzioneAcronimo != null) {

						if (direzioneAcronimo.length() < 59)
							direzioneAcronimo = direzioneAcronimo.substring(0, direzioneAcronimo.length());
						else
							direzioneAcronimo = direzioneAcronimo.substring(0, 59);
					}
					if (uffAcronimo != null) {
						if (uffAcronimo.length() < 59)
							uffAcronimo = uffAcronimo.substring(0, uffAcronimo.length());
						else
							uffAcronimo = uffAcronimo.substring(0, 59);
					}

				} catch (Exception e) {
					_log.error(e);
				}

				try {
					if ("beniStandard".equalsIgnoreCase(tipobeni) && listaMateriali != null) {
						risultatoRichiesta = insertRichiestaGeco(actionRequest, origine, idrichesta, codUtente,
								codiceGeco, emailRich, direzioneAcronimo, uffAcronimo, telefono_richiedente,
								riferimento_stanza, idSede, oggetto, datarichiesta, priodicitaReq, budget, consuntivo,
								listaMateriali, note);
					}
					if ("beniInformatica".equalsIgnoreCase(tipobeni) && listaMaterialiInformatici != null) {
						risultatoRichiesta = insertRichiestaGeco(actionRequest, origine, idrichesta, codUtente,
								codiceGeco, emailRich, direzioneAcronimo, uffAcronimo, telefono_richiedente,
								riferimento_stanza, idSede, oggetto, datarichiesta, "S", budget, consuntivo,
								listaMaterialiInformatici, note);
					}
				} catch (Exception e) {
					_log.error(e);
					actionRequest.setAttribute("catch-geco-error-label",
							"La richiesta non \u00E8 andata a buon fine per indisponibilit\u00E0 del servizio.");
					SessionErrors.add(actionRequest, "catch-geco-error");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				}

				if (risultatoRichiesta == null) {
					actionRequest.setAttribute("catch-geco-error-label",
							"La richiesta non \u00E8 andata a buon fine a causa di un errore generico.");
					SessionErrors.add(actionRequest, "catch-geco-client-generic-error");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				}

				if (risultatoRichiesta != null && "1".equals(risultatoRichiesta)) {
					actionRequest.setAttribute("catch-geco-error-label",
							"La richiesta non \u00E8 andata a buon fine per indisponibilit\u00E0 del servizio.");
					SessionErrors.add(actionRequest, "catch-geco-error");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				}

				if (risultatoRichiesta != null && "0".equals(risultatoRichiesta)) {

					if ("beniStandard".equalsIgnoreCase(tipobeni)) {
						Long idResult = insertRichiestaToStage(Long.parseLong(idrichesta), Float.valueOf(costoTotale),
								new Date(), new Date(), new Date(), emailRich, flagInvio, Long.parseLong(periodicita),
								idSede, idStatoAttuale, direzioneAcronimo, noteConsegnatario, note, oggetto, preventivo,
								riferimento_stanza, strutIsp, strutIsp2, strutUff, telefono, uffAcronimo, uidIns,
								uidUpd);
						long counterBfc = 0;
						float importo = 0;
						Date dataUpd = null;
						for (DatiRichiestaBean datiRichiestaBfc : listaBcf) {
							counterBfc++;
							insertRigherichiestaToStage(Long.parseLong(idrichesta),
									Long.parseLong(datiRichiestaBfc.getMateriale()), datiRichiestaBfc.getGruppo(),
									datiRichiestaBfc.getSottoGruppo(), counterBfc, importo,
									Long.parseLong(datiRichiestaBfc.getQuantita()),
									Long.parseLong(datiRichiestaBfc.getQuantita()), new Date(), dataUpd, uidIns, uidUpd,
									datiRichiestaBfc.getMaterialeDescrizione());
						}

						if (idResult != null) {
							LocalRich localRich = LocalRichLocalServiceUtil
									.getRichiestebyIdRichiesta(Long.parseLong(idrichesta)).get(0);
							localRich.setIdStatoAttuale(1);
							localRich.setInStage(true);
							LocalRichLocalServiceUtil.updateLocalRich(localRich);
						}

					}

					else if ("beniInformatica".equalsIgnoreCase(tipobeni)) {

						Long idResult = insertRichiestaInformaticaToStage(Long.parseLong(idrichesta),
								Float.valueOf(costoTotale), new Date(), new Date(), new Date(), emailRich, flagInvio,
								numeroMacchina, idSede, idStatoAttuale, direzioneAcronimo, noteConsegnatario, note,
								nomeReferente, oggetto, preventivo, riferimento_stanza, strutIsp, strutIsp2, strutUff,
								telefono, uffAcronimo, uidIns, uidUpd);
						long counterBfcInfo = 0;
						float importo = 0;
						Date dataUpd = null;

						for (DatiRichiestaBean datiRichiestaBfcInfo : listaBcfInformatica) {
							counterBfcInfo++;
							insertRigherichiestaInfoToStage(Long.parseLong(idrichesta),
									Long.parseLong(datiRichiestaBfcInfo.getMateriale()),
									datiRichiestaBfcInfo.getGruppo(), datiRichiestaBfcInfo.getSottoGruppo(),
									counterBfcInfo, importo, Long.parseLong(datiRichiestaBfcInfo.getQuantita()),
									Long.parseLong(datiRichiestaBfcInfo.getQuantita()), new Date(), dataUpd, uidIns,
									uidUpd, datiRichiestaBfcInfo.getMaterialeDescrizione());
						}

						if (idResult != null) {
							LocalRichInfo localRichInfo = LocalRichInfoLocalServiceUtil
									.getRichiestebyIdRichiesta(Long.parseLong(idrichesta)).get(0);
							localRichInfo.setIdStatoAttuale(1);
							localRichInfo.setInStage(true);
							LocalRichInfoLocalServiceUtil.updateLocalRichInfo(localRichInfo);

						}
					}
					stato = 1;
					String mailbody = actionRequest.getPreferences().getValue("approvatoTmpl",
							_configuration.approvatoTmpl());
					String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
					String subject = actionRequest.getPreferences().getValue("subjectApprovazione",
							_configuration.subjectApprovazione());
					String sender = actionRequest.getPreferences().getValue("senderBeni", _configuration.senderBeni());
					EmailSender mail = new EmailSender();
					String datirichiedente = getHtmlRichiedente(ufficio, organizzazione, nome, cognome, ubicazione,
							piano, scala, riferimento_stanza, telefono, email, sedeDescrizione);
					String datirichiesta = null;
					String emailRichiedente = null;
					if ("beniInformatica".equals(tipobeni)) {
						datirichiesta = getHtmlRichiesta(oggetto, datarichiesta, note, costoTotale, listaBcfInformatica,
								null);
						RichiesteInfo richinfo = RichiesteInfoLocalServiceUtil
								.getRichiesteInfo(Long.parseLong(idrichesta));
						emailRichiedente = richinfo.getEmail();
					}
					if ("beniStandard".equals(tipobeni)) {
						datirichiesta = getHtmlRichiesta(oggetto, datarichiesta, note, costoTotale, listaBcf, null);
						Richieste rich = RichiesteLocalServiceUtil.getRichieste(Long.parseLong(idrichesta));
						emailRichiedente = rich.getEmail();
					}
					mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
							new String[] { datirichiedente, datirichiesta });
					mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRichiedente, user.getEmailAddress(),
							null);
				}

			}

			if ("rifiuta".equals(action)) {

				if ("beniStandard".equalsIgnoreCase(tipobeni)) {
					LocalRich localRich = LocalRichLocalServiceUtil
							.getRichiestebyIdRichiesta(Long.parseLong(idrichesta)).get(0);
					localRich.setIdStatoAttuale(8);
					LocalRichLocalServiceUtil.updateLocalRich(localRich);
				}

				else if ("beniInformatica".equalsIgnoreCase(tipobeni)) {
					LocalRichInfo localRichInfo = LocalRichInfoLocalServiceUtil
							.getRichiestebyIdRichiesta(Long.parseLong(idrichesta)).get(0);
					localRichInfo.setIdStatoAttuale(8);
					LocalRichInfoLocalServiceUtil.updateLocalRichInfo(localRichInfo);
				}

				stato = 8;

				// send email
				String mailbody = actionRequest.getPreferences().getValue("rifiutaTmpl", _configuration.rifiutaTmpl());
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String subject = actionRequest.getPreferences().getValue("subjectRifiuta",
						_configuration.subjectRifiuta());
				String sender = actionRequest.getPreferences().getValue("senderBeni", _configuration.senderBeni());
				EmailSender mail = new EmailSender();
				String datirichiedente = getHtmlRichiedente(ufficio, organizzazione, nome, cognome, ubicazione, piano,
						scala, riferimento_stanza, telefono, email, sedeDescrizione);
				String datirichiesta = null;
				String emailRichiedente = null;
				if ("beniInformatica".equals(tipobeni)) {
					datirichiesta = getHtmlRichiesta(oggetto, datarichiesta, note, costoTotale, listaBcfInformatica,
							motivazioneRifiuto);
					LocalRichInfo localRichInfo = LocalRichInfoLocalServiceUtil
							.getRichiestebyIdRichiesta(Long.parseLong(idrichesta)).get(0);
					emailRichiedente = localRichInfo.getEmail();
				}
				if ("beniStandard".equals(tipobeni)) {
					datirichiesta = getHtmlRichiesta(oggetto, datarichiesta, note, costoTotale, listaBcf,
							motivazioneRifiuto);
					LocalRich localRich = LocalRichLocalServiceUtil
							.getRichiestebyIdRichiesta(Long.parseLong(idrichesta)).get(0);
					emailRichiedente = localRich.getEmail();
				}
				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
						new String[] { datirichiedente, datirichiesta });
				mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRichiedente);
			}

			// set CambioStatoDirigente local table

			StringBuilder utente = new StringBuilder();
			utente.append(user.getFirstName().toLowerCase());
			utente.append(" ");
			utente.append(user.getLastName().toLowerCase());

			CambioStatoDirigenteLocalServiceUtil.insertCambioStatoDirigente(Long.parseLong(idrichesta), stato,
					new Date(), motivazioneRifiuto, utente.toString());

			PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
					themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(urlRefresh.toString());

		}
	}

	@ProcessAction(name = "vaiADettaglio")
	public void vaiADettaglio(ActionRequest request, ActionResponse response)
			throws NumberFormatException, PortalException, java.text.ParseException {

		String idRichiesta = request.getParameter("richiestaId");
		String stato = request.getParameter("statoRichiesta");

		RigheRichBFCNew rigaRichiesta = RigheRichBFCNewLocalServiceUtil
				.getRigaRichiestaByIdRichiesta(Long.parseLong(idRichiesta)).get(0);
		DatiRichiestaBean datiDettaglioRichiestaBean = new DatiRichiestaBean();
		Richiedente datiDettaglioRichiedenteBean = new Richiedente();

		StringBuilder jsonCompleto = new StringBuilder();
		jsonCompleto.append(rigaRichiesta.getDati1());
		jsonCompleto.append(rigaRichiesta.getDati2());
		jsonCompleto.append(rigaRichiesta.getDati3());
		jsonCompleto.append(rigaRichiesta.getDati4());

		JSONObject jsonObjectRigheRichiestaDati = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
		datiDettaglioRichiestaBean.setOggetto(jsonObjectRigheRichiestaDati.getString("oggetto"));
		datiDettaglioRichiestaBean.setDataRichiesta(jsonObjectRigheRichiestaDati.getString("dataRichiesta"));
		SimpleDateFormat dataOraFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dataRichiesta = dataOraFormatter.parse(datiDettaglioRichiestaBean.getDataRichiesta());
		String noteConsegnatario = null;

		if ("beniStandard".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {

			if ("in approvazione".equalsIgnoreCase(stato) || "non approvata".equalsIgnoreCase(stato)) {
				LocalRich locRich = LocalRichLocalServiceUtil.getRichiestebyIdRichiesta(rigaRichiesta.getId_rich())
						.get(0);
				datiDettaglioRichiestaBean
						.setStato(StatoLocalServiceUtil.getStato(locRich.getIdStatoAttuale()).getDescrizione());
				noteConsegnatario = locRich.getNote();

			}

			else {
				Richieste richiesta = RichiesteLocalServiceUtil.getRichieste(rigaRichiesta.getId_rich());
				datiDettaglioRichiestaBean
						.setStato(StatoLocalServiceUtil.getStato(richiesta.getIdStatoAttuale()).getDescrizione());
				noteConsegnatario = richiesta.getNote();
			}

			request.setAttribute("beniStandard", "Beni Standard");

		} else if ("beniInformatica".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {

			if ("in approvazione".equalsIgnoreCase(stato) || "non approvata".equalsIgnoreCase(stato)) {
				LocalRichInfo locRichInfo = LocalRichInfoLocalServiceUtil
						.getRichiestebyIdRichiesta(rigaRichiesta.getId_rich()).get(0);
				datiDettaglioRichiestaBean
						.setStato(StatoLocalServiceUtil.getStato(locRichInfo.getIdStatoAttuale()).getDescrizione());
				noteConsegnatario = locRichInfo.getNote();

			}

			else {
				RichiesteInfo richiestaInfo = RichiesteInfoLocalServiceUtil
						.getRichiesteInfo(rigaRichiesta.getId_rich());
				datiDettaglioRichiestaBean
						.setStato(StatoLocalServiceUtil.getStato(richiestaInfo.getIdStatoAttuale()).getDescrizione());
				noteConsegnatario = richiestaInfo.getNote();
			}

			request.setAttribute("beniInformatica", "Beni di Tipo Informatico");

		}

		SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataDettaglioRichiesta = dataFormatter.parse(datiDettaglioRichiestaBean.getDataRichiesta());
		datiDettaglioRichiestaBean.setDataRichiesta(dataFormatter.format(dataDettaglioRichiesta));

		datiDettaglioRichiedenteBean.setNome(jsonObjectRigheRichiestaDati.getString("nome"));
		datiDettaglioRichiedenteBean.setCognome(jsonObjectRigheRichiestaDati.getString("cognome"));
		datiDettaglioRichiedenteBean
				.setUfficioRichiedente(jsonObjectRigheRichiestaDati.getString("ufficioRichiedente"));
		datiDettaglioRichiedenteBean.setOrganizzazione(jsonObjectRigheRichiestaDati.getString("organizzazione"));
		datiDettaglioRichiedenteBean.setSede(jsonObjectRigheRichiestaDati.getString("sede"));
		datiDettaglioRichiedenteBean.setSedeDescrizione(jsonObjectRigheRichiestaDati.getString("sedeDescrizione"));
		datiDettaglioRichiedenteBean.setUbicazione(jsonObjectRigheRichiestaDati.getString("ubicazione"));
		datiDettaglioRichiedenteBean.setPalazzina(jsonObjectRigheRichiestaDati.getString("palazzina"));
		datiDettaglioRichiedenteBean.setPiano(jsonObjectRigheRichiestaDati.getString("piano"));
		datiDettaglioRichiedenteBean.setScala(jsonObjectRigheRichiestaDati.getString("scala"));
		datiDettaglioRichiedenteBean.setStanza(jsonObjectRigheRichiestaDati.getString("stanza"));
		datiDettaglioRichiedenteBean.setTelefono(jsonObjectRigheRichiestaDati.getString("telefono"));
		datiDettaglioRichiedenteBean.setEmailRichiedente(jsonObjectRigheRichiestaDati.getString("emailRichiedente"));
		datiDettaglioRichiedenteBean.setEmailDirigente(jsonObjectRigheRichiestaDati.getString("email"));
		datiDettaglioRichiestaBean.setTipoBeni(jsonObjectRigheRichiestaDati.getString("tipoBeni"));
		datiDettaglioRichiestaBean
				.setPeriodicitaDescrizione(jsonObjectRigheRichiestaDati.getString("periodicitaDescrizione"));
		HashMap<String, List<DatiRichiestaBean>> richiestePerDettaglio = jsontoData(jsonCompleto.toString());
		List<DatiRichiestaBean> beni_standard_list_dettaglio = richiestePerDettaglio.get("listBeniStandard");
		List<DatiRichiestaBean> beni_informatici_list_dettaglio = richiestePerDettaglio.get("listBeniInformatica");

		if ("beniStandard".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {

			if (getRigheRichiesteByRichestaId(Long.parseLong(idRichiesta)) != null
					&& !getRigheRichiesteByRichestaId(Long.parseLong(idRichiesta)).isEmpty()) {
				for (DatiRichiestaBean datiRichiestaBean : beni_standard_list_dettaglio) {
					RigheRichiestePK righeRichiestePK = new RigheRichiestePK();
					righeRichiestePK.setId(Long.parseLong(idRichiesta));
					righeRichiestePK.setGruppo(datiRichiestaBean.getGruppo());
					righeRichiestePK.setSottogruppo(datiRichiestaBean.getSottoGruppo());
					righeRichiestePK.setIdMateriale(Long.parseLong(datiRichiestaBean.getMateriale()));
					if (RigheRichiesteLocalServiceUtil.fetchRigheRichieste(righeRichiestePK) != null) {
						RigheRichieste righeRichieste = RigheRichiesteLocalServiceUtil
								.fetchRigheRichieste(righeRichiestePK);
						datiRichiestaBean.setQuantita(String.valueOf(righeRichieste.getQuantitaDisponibile()));
					}
				}
			}
		}

		else if ("beniInformatica".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {

			if (getRigheRichiesteInfoByRichestaId(Long.parseLong(idRichiesta)) != null
					&& !getRigheRichiesteInfoByRichestaId(Long.parseLong(idRichiesta)).isEmpty()) {
				for (DatiRichiestaBean datiRichiestaBean : beni_informatici_list_dettaglio) {
					RigheRichiesteInfoPK righeRichiesteInfoPK = new RigheRichiesteInfoPK();
					righeRichiesteInfoPK.setId(Long.parseLong(idRichiesta));
					righeRichiesteInfoPK.setGruppo(datiRichiestaBean.getGruppo());
					righeRichiesteInfoPK.setSottogruppo(datiRichiestaBean.getSottoGruppo());
					righeRichiesteInfoPK.setIdMateriale(Long.parseLong(datiRichiestaBean.getMateriale()));
					if (RigheRichiesteInfoLocalServiceUtil.fetchRigheRichiesteInfo(righeRichiesteInfoPK) != null) {
						RigheRichiesteInfo righeRichiesteInfo = RigheRichiesteInfoLocalServiceUtil
								.fetchRigheRichiesteInfo(righeRichiesteInfoPK);
						datiRichiestaBean.setQuantita(String.valueOf(righeRichiesteInfo.getQuantitaDisponibile()));
					}
				}
			}
		}

		datiDettaglioRichiestaBean.setCostoTotale(jsonObjectRigheRichiestaDati.getString("costoTotale"));
		datiDettaglioRichiestaBean.setDescrizione(jsonObjectRigheRichiestaDati.getString("descrizione"));
		datiDettaglioRichiestaBean
				.setNumeroInventarioMacchina(jsonObjectRigheRichiestaDati.getString("numeroInventarioMacchina"));
		request.setAttribute("idRichiesta", idRichiesta);
		request.setAttribute("dataRichiesta", dataRichiesta);
		request.setAttribute("stato", stato);
		request.setAttribute("datiDettaglioRichiedenteBean", datiDettaglioRichiedenteBean);
		request.setAttribute("datiDettaglioRichiestaBean", datiDettaglioRichiestaBean);
		if (!"".equalsIgnoreCase(noteConsegnatario)) {
			request.setAttribute("noteConsegnatario", noteConsegnatario);
		}
		request.setAttribute("beniStandardListDettaglio", beni_standard_list_dettaglio);
		request.setAttribute("beniStandardListDettaglioSize", beni_standard_list_dettaglio.size());
		request.setAttribute("beniInformaticiListDettaglio", beni_informatici_list_dettaglio);
		request.setAttribute("beniInformaticiListDettaglioSize", beni_informatici_list_dettaglio.size());
		request.setAttribute("navigation", "riepilogo");
		request.setAttribute("dettaglio", "dettaglio");
	}

	@ProcessAction(name = "vaiAInserimento")
	public void vaiAInserimento(ActionRequest request, ActionResponse response) {
		String navigation = null;
		DatiRichiestaBean datiRichiestaBean = new DatiRichiestaBean();
		List<Periodicita> periodicita = (List<Periodicita>) PeriodicitaLocalServiceUtil
				.getPeriodicitas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		SimpleDateFormat dataOraFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dataOraDiOggi = dataOraFormatter.format(new Date());
		datiRichiestaBean.setDataRichiesta(dataOraDiOggi);
		request.setAttribute("datiRichiestaBean", datiRichiestaBean);
		request.setAttribute("periodicita", periodicita);
		request.setAttribute("navigation", navigation);
	}

	@ProcessAction(name = "vaiARicerca")
	public void vaiARicerca(ActionRequest request, ActionResponse response) {

		request.setAttribute("navigation", "risultatiricercarichieste");
	}

	@ProcessAction(name = "vaiAGestioneUtenti")
	public void vaiAGestioneUtenti(ActionRequest request, ActionResponse response) {

		request.setAttribute("navigation", "gestioneutenti");
	}

	@ProcessAction(name = "getListaRichieste")
	public void getListaRichieste(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String consegnatario = actionRequest.getParameter("consegnatarioRole");
		User user = themeDisplay.getUser();
		String nomeDip = null;
		if (user != null) {
			nomeDip = getDipartimentoFromUserLocation(user);
		}
		String emailUtente = user.getEmailAddress();

		// richieste del richiedente settate in stage
		List<RichiesteInfo> richiesteinfo = RichiesteInfoLocalServiceUtil.getRichiesteInfobyEmail(emailUtente);
		List<Richieste> richieste = RichiesteLocalServiceUtil.getRichiestebyEmail(emailUtente);

		// richieste del richiedente settate in stage
		List<LocalRichInfo> richiesteinfoLocal = LocalRichInfoLocalServiceUtil.getRichiestebyEmail(false, emailUtente);
		List<LocalRich> richiesteLocal = LocalRichLocalServiceUtil.getRichiestebyEmail(false, emailUtente);

		if ("true".equalsIgnoreCase(consegnatario)) {
			List<RigheRichBFCNew> listarichieste = RigheRichBFCNewLocalServiceUtil
					.getRigheRichiestaByDipartimento(nomeDip);
			for (RigheRichBFCNew riga : listarichieste) {

				StringBuilder jsonCompleto = new StringBuilder();
				jsonCompleto.append(listarichieste.get(0).getDati1());
				jsonCompleto.append(listarichieste.get(0).getDati2());
				jsonCompleto.append(listarichieste.get(0).getDati3());
				jsonCompleto.append(listarichieste.get(0).getDati4());

				JSONObject objdataBFC = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
				String tipoBeni = objdataBFC.getString("tipoBeni");

				if ("beniStandard".equals(tipoBeni)) {
					Richieste richiesta = RichiesteLocalServiceUtil.getRichieste(riga.getId_rich());
					richieste.add(richiesta);
					if (richiesta == null) {
						LocalRich richiestaLoc = LocalRichLocalServiceUtil.getRichiestebyIdRichiesta(riga.getId_rich())
								.get(0);
						richiesteLocal.add(richiestaLoc);
					}

				}
				if ("beniInformatica".equals(tipoBeni)) {
					RichiesteInfo richiestainfo = RichiesteInfoLocalServiceUtil.getRichiesteInfo(riga.getId_rich());
					richiesteinfo.add(richiestainfo);
					if (richiestainfo == null) {
						LocalRichInfo richiestainfoLoc = LocalRichInfoLocalServiceUtil
								.getRichiestebyIdRichiesta(riga.getId_rich()).get(0);
						richiesteinfoLocal.add(richiestainfoLoc);
					}
				}
			}
		}

		String approvazioneRGS = actionRequest.getPreferences().getValue("approvazioneRGS",
				_configuration.approvazioneRGS());
		String approvazioneDT = actionRequest.getPreferences().getValue("approvazioneDT",
				_configuration.approvazioneDT());
		String approvazioneDF = actionRequest.getPreferences().getValue("approvazioneDF",
				_configuration.approvazioneDF());
		String approvazioneDAG = actionRequest.getPreferences().getValue("approvazioneDAG",
				_configuration.approvazioneDAG());

		boolean approvazioneFlag = ("DIP. II - RGS".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneRGS))
				|| ("DIP. I - TESORO".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneDT))
				|| ("DIP. III - DIPARTIMENTO DELLE FINANZE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDF))
				|| ("DIP. IV - AMM. GEN. PERSONALE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDAG));

		if (approvazioneFlag) {
			richiesteLocal = null;
			richiesteinfoLocal = null;
		}

		List<RisultatoListaRichieste> listaRisultatiRichiesta = setListaRisultatoRichiesta(richieste, richiesteinfo,
				richiesteLocal, richiesteinfoLocal, themeDisplay);
		actionRequest.setAttribute("listarichieste", listaRisultatiRichiesta);
		actionRequest.setAttribute("navigation", "listarichieste");
	}

	// metodo per il settaggio del bean richiesta e la creazione della lista
	// ordinata
	private List<RisultatoListaRichieste> setListaRisultatoRichiesta(List<Richieste> richieste,
			List<RichiesteInfo> richiesteinfo, List<LocalRich> richiesteLocal, List<LocalRichInfo> richiesteInfoLocal,
			ThemeDisplay themeDisplay) {

		List<RisultatoListaRichieste> listaRisultatiRichiesta = new ArrayList<RisultatoListaRichieste>(0);
		// ciclo le richieste standard in stage
		for (Richieste richiesteItem : richieste) {

			RisultatoListaRichieste item = new RisultatoListaRichieste();
			item.setId(richiesteItem.getId());

			// get state
			Stato stato;
			try {
				stato = StatoLocalServiceUtil.getStato(richiesteItem.getIdStatoAttuale());
				if (stato != null)
					item.setStato(stato.getDescrizione());
			} catch (PortalException e2) {
				_log.warn(e2);
			}

			item.setTipoMateriale("beniStandard");
			item.setData(richiesteItem.getDataRichiesta());

			if ((RigheRichBFCNewLocalServiceUtil.getRigaRichiestaByIdRichiesta(richiesteItem.getId()) != null
					&& (RigheRichBFCNewLocalServiceUtil.getRigaRichiestaByIdRichiesta(richiesteItem.getId())
							.size() > 0))) {

				try {
					User utente_richiedente = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
							richiesteItem.getEmail());
					item.setNome(utente_richiedente.getFirstName());
					item.setCognome(utente_richiedente.getLastName());

				} catch (PortalException e) {
					_log.warn(e);
					List<RigheRichBFCNew> list_righe = RigheRichBFCNewLocalServiceUtil
							.getRigaRichiestaByIdRichiesta(richiesteItem.getId());

					if (list_righe != null && !list_righe.isEmpty()) {
						JSONObject jsonRigaStandard;
						try {

							StringBuilder jsonCompleto = new StringBuilder();
							jsonCompleto.append(list_righe.get(0).getDati1());
							jsonCompleto.append(list_righe.get(0).getDati2());
							jsonCompleto.append(list_righe.get(0).getDati3());
							jsonCompleto.append(list_righe.get(0).getDati4());

							jsonRigaStandard = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
							item.setNome(jsonRigaStandard.getString("nome"));
							item.setCognome(jsonRigaStandard.getString("cognome"));

						} catch (JSONException e1) {
							_log.warn(e1);
						}
					}

				}
				listaRisultatiRichiesta.add(item);

			}
		}
		// ciclo le richieste info in stage
		for (RichiesteInfo richiesteInfoItem : richiesteinfo) {
			RisultatoListaRichieste item = new RisultatoListaRichieste();
			item.setId(richiesteInfoItem.getId());

			// get state
			Stato stato;
			try {
				stato = StatoLocalServiceUtil.getStato(richiesteInfoItem.getIdStatoAttuale());
				if (stato != null)
					item.setStato(stato.getDescrizione());
			} catch (PortalException e) {
				_log.warn(e);
			}

			item.setTipoMateriale("beniInformatica");
			item.setData(richiesteInfoItem.getDataRichiesta());

			if ((RigheRichBFCNewLocalServiceUtil.getRigaRichiestaByIdRichiesta(richiesteInfoItem.getId()) != null
					&& (RigheRichBFCNewLocalServiceUtil.getRigaRichiestaByIdRichiesta(richiesteInfoItem.getId())
							.size() > 0))) {

				try {
					User utente_richiedente = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(),
							richiesteInfoItem.getEmail());
					item.setNome(utente_richiedente.getFirstName());
					item.setCognome(utente_richiedente.getLastName());

				} catch (PortalException e) {
					_log.warn(e);
					List<RigheRichBFCNew> list_righe = RigheRichBFCNewLocalServiceUtil
							.getRigaRichiestaByIdRichiesta(richiesteInfoItem.getId());

					if (list_righe != null && !list_righe.isEmpty()) {

						JSONObject jsonRigaInfo;
						try {
							StringBuilder jsonCompleto = new StringBuilder();
							jsonCompleto.append(list_righe.get(0).getDati1());
							jsonCompleto.append(list_righe.get(0).getDati2());
							jsonCompleto.append(list_righe.get(0).getDati3());
							jsonCompleto.append(list_righe.get(0).getDati4());

							jsonRigaInfo = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
							item.setNome(jsonRigaInfo.getString("nome"));
							item.setCognome(jsonRigaInfo.getString("cognome"));

						} catch (JSONException e1) {
							_log.warn(e1);
						}
					}
				}

				listaRisultatiRichiesta.add(item);

			}

		}

		// ciclo le richieste standard local
		if (richiesteLocal != null && !richiesteLocal.isEmpty()) {
			for (LocalRich richiesteItem : richiesteLocal) {

				RisultatoListaRichieste item = new RisultatoListaRichieste();
				item.setId(richiesteItem.getId_richiesta());

				// get state
				Stato stato;
				try {
					stato = StatoLocalServiceUtil.getStato(richiesteItem.getIdStatoAttuale());
					if (stato != null)
						item.setStato(stato.getDescrizione());
				} catch (PortalException e2) {
					_log.warn(e2);
				}

				item.setTipoMateriale("beniStandard");
				item.setData(richiesteItem.getDataRichiesta());

				if ((RigheRichBFCNewLocalServiceUtil
						.getRigaRichiestaByIdRichiesta(richiesteItem.getId_richiesta()) != null
						&& (RigheRichBFCNewLocalServiceUtil
								.getRigaRichiestaByIdRichiesta(richiesteItem.getId_richiesta()).size() > 0))) {

					try {
						User utente_richiedente = UserLocalServiceUtil
								.getUserByEmailAddress(themeDisplay.getCompanyId(), richiesteItem.getEmail());
						item.setNome(utente_richiedente.getFirstName());
						item.setCognome(utente_richiedente.getLastName());

					} catch (PortalException e) {
						_log.warn(e);
						List<RigheRichBFCNew> list_righe = RigheRichBFCNewLocalServiceUtil
								.getRigaRichiestaByIdRichiesta(richiesteItem.getId_richiesta());

						if (list_righe != null && !list_righe.isEmpty()) {
							JSONObject jsonRigaStandard;
							try {

								StringBuilder jsonCompleto = new StringBuilder();
								jsonCompleto.append(list_righe.get(0).getDati1());
								jsonCompleto.append(list_righe.get(0).getDati2());
								jsonCompleto.append(list_righe.get(0).getDati3());
								jsonCompleto.append(list_righe.get(0).getDati4());

								jsonRigaStandard = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
								item.setNome(jsonRigaStandard.getString("nome"));
								item.setCognome(jsonRigaStandard.getString("cognome"));

							} catch (JSONException e1) {
								_log.warn(e1);
							}
						}

					}

					listaRisultatiRichiesta.add(item);

				}
			}
		}

		// ciclo le richieste info in locale
		if (richiesteInfoLocal != null && !richiesteInfoLocal.isEmpty()) {
			for (LocalRichInfo richiesteInfoItem : richiesteInfoLocal) {
				RisultatoListaRichieste item = new RisultatoListaRichieste();
				item.setId(richiesteInfoItem.getId_richiesta());

				// get state
				Stato stato;
				try {
					stato = StatoLocalServiceUtil.getStato(richiesteInfoItem.getIdStatoAttuale());
					if (stato != null)
						item.setStato(stato.getDescrizione());
				} catch (PortalException e) {
					_log.warn(e);
				}

				item.setTipoMateriale("beniInformatica");
				item.setData(richiesteInfoItem.getDataRichiesta());

				if ((RigheRichBFCNewLocalServiceUtil
						.getRigaRichiestaByIdRichiesta(richiesteInfoItem.getId_richiesta()) != null
						&& (RigheRichBFCNewLocalServiceUtil
								.getRigaRichiestaByIdRichiesta(richiesteInfoItem.getId_richiesta()).size() > 0))) {

					try {
						User utente_richiedente = UserLocalServiceUtil
								.getUserByEmailAddress(themeDisplay.getCompanyId(), richiesteInfoItem.getEmail());
						item.setNome(utente_richiedente.getFirstName());
						item.setCognome(utente_richiedente.getLastName());

					} catch (PortalException e) {
						_log.warn(e);
						List<RigheRichBFCNew> list_righe = RigheRichBFCNewLocalServiceUtil
								.getRigaRichiestaByIdRichiesta(richiesteInfoItem.getId_richiesta());

						if (list_righe != null && !list_righe.isEmpty()) {

							JSONObject jsonRigaInfo;
							try {
								StringBuilder jsonCompleto = new StringBuilder();
								jsonCompleto.append(list_righe.get(0).getDati1());
								jsonCompleto.append(list_righe.get(0).getDati2());
								jsonCompleto.append(list_righe.get(0).getDati3());
								jsonCompleto.append(list_righe.get(0).getDati4());

								jsonRigaInfo = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
								item.setNome(jsonRigaInfo.getString("nome"));
								item.setCognome(jsonRigaInfo.getString("cognome"));

							} catch (JSONException e1) {
								_log.warn(e1);
							}
						}
					}

					listaRisultatiRichiesta.add(item);

				}

			}
		}

		List<RisultatoListaRichieste> sortableListaRichieste = new ArrayList<RisultatoListaRichieste>(0);

		if (listaRisultatiRichiesta != null)
			sortableListaRichieste = new ArrayList<RisultatoListaRichieste>(listaRisultatiRichiesta);

		if (!sortableListaRichieste.isEmpty() && sortableListaRichieste.size() > 1) {
			Collections.sort(sortableListaRichieste, new Comparator<RisultatoListaRichieste>() {
				@Override
				public int compare(RisultatoListaRichieste o1, RisultatoListaRichieste o2) {
					if (o2.getData().before(o1.getData()))
						return -1;
					return 1;
				}
			});
		}

		return sortableListaRichieste;
	}

	public void newRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		actionRequest.setAttribute("navigation", null);
	}

	public void riepilogoDati(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {
		String idRichiesta = actionRequest.getParameter("idRichiesta");
		String stato = actionRequest.getParameter("stato");
		String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");
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
		String json = actionRequest.getParameter("json");
		DatiRichiestaBean datiRichiestaBean = createDatiRichiesta(json);
		HashMap<String, List<DatiRichiestaBean>> mappaRichieste = jsontoData(json);
		List<DatiRichiestaBean> listBeniStandard = mappaRichieste.get("listBeniStandard");
		List<DatiRichiestaBean> listBeniInformatica = mappaRichieste.get("listBeniInformatica");
		String navigation = "riepilogo";
		actionRequest.setAttribute("idRichiesta", idRichiesta);
		actionRequest.setAttribute("stato", stato);
		actionRequest.setAttribute("ufficioRichiedente", ufficioRichiedente);
		actionRequest.setAttribute("nome", nome);
		actionRequest.setAttribute("cognome", cognome);
		actionRequest.setAttribute("ubicazione", ubicazione);
		actionRequest.setAttribute("palazzina", palazzina);
		actionRequest.setAttribute("piano", piano);
		actionRequest.setAttribute("scala", scala);
		actionRequest.setAttribute("stanza", stanza);
		actionRequest.setAttribute("telefono", telefono);
		actionRequest.setAttribute("emailRichiedente", emailRichiedente);
		actionRequest.setAttribute("emailDirigente", emailDirigente);
		actionRequest.setAttribute("json", json);
		actionRequest.setAttribute("datiDellaRichiesta", datiRichiestaBean);
		actionRequest.setAttribute("sizeListBeniStandard", listBeniStandard.size());
		actionRequest.setAttribute("sizeListBeniInformatica", listBeniInformatica.size());
		actionRequest.setAttribute("listBeniStandard", listBeniStandard);
		actionRequest.setAttribute("listBeniInformatica", listBeniInformatica);
		actionRequest.setAttribute("navigation", navigation);
	}

	public void modificaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {

			DatiRichiestaBean datiRichiestaBean = new DatiRichiestaBean();
			Richiedente richiedente = new Richiedente();
			List<Periodicita> listPeriodicita = (List<Periodicita>) PeriodicitaLocalServiceUtil
					.getPeriodicitas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<ServizioMateriale> servizioMateriale = (List<ServizioMateriale>) ServizioMaterialeLocalServiceUtil
					.getServizioMateriales(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			String ufficioRichiedente = actionRequest.getParameter("ufficioRichiedente");
			String stato = actionRequest.getParameter("stato");
			String organizzazione = actionRequest.getParameter("organizzazione");
			String nome = actionRequest.getParameter("nome");
			String cognome = actionRequest.getParameter("cognome");
			String ubicazioneAttuale = actionRequest.getParameter("ubicazione");
			String palazzina = actionRequest.getParameter("palazzina");
			String piano = actionRequest.getParameter("piano");
			String scala = actionRequest.getParameter("scala");
			String stanza = actionRequest.getParameter("stanza");
			String telefono = actionRequest.getParameter("telefono");
			String emailRichiedente = actionRequest.getParameter("emailRichiedente");
			String emailDirigente = actionRequest.getParameter("emailDirigente");
			String json = actionRequest.getParameter("json");
			String periodicita = actionRequest.getParameter("periodicita");
			String dataRichiesta = actionRequest.getParameter("datarichiesta");
			String costoTotale = actionRequest.getParameter("costoTotale");
			String descrizione = actionRequest.getParameter("note");
			String sede = actionRequest.getParameter("sede");
			String sedeDescrizione = actionRequest.getParameter("sedeDescrizione");
			String numeroInventarioMacchina = actionRequest.getParameter("numeroInventarioMacchina");
			JSONObject jsonRichiesta = JSONFactoryUtil.createJSONObject(json);
			datiRichiestaBean.setCodiceGeco(jsonRichiesta.getString("codiceGeco"));
			datiRichiestaBean.setPeriodicita(periodicita);
			datiRichiestaBean.setNumeroInventarioMacchina(numeroInventarioMacchina);
			datiRichiestaBean.setDataRichiesta(dataRichiesta);
			datiRichiestaBean.setCostoTotale(costoTotale);
			datiRichiestaBean.setDescrizione(descrizione);
			richiedente.setUfficioRichiedente(ufficioRichiedente);
			richiedente.setOrganizzazione(organizzazione);
			richiedente.setNome(nome);
			richiedente.setCognome(cognome);
			richiedente.setUbicazione(ubicazioneAttuale);
			richiedente.setPalazzina(palazzina);
			richiedente.setPiano(piano);
			richiedente.setScala(scala);
			richiedente.setStanza(stanza);
			richiedente.setTelefono(telefono);
			richiedente.setEmailRichiedente(emailRichiedente);
			richiedente.setEmailDirigente(emailDirigente);
			richiedente.setSede(sede);
			richiedente.setSedeDescrizione(sedeDescrizione);
			JSONObject obj = JSONFactoryUtil.createJSONObject(json);
			String tipoBeni = obj.getString("tipoBeni");
			HashMap<String, List<DatiRichiestaBean>> mappaRichieste = jsontoData(json);
			List<DatiRichiestaBean> listGruppoStandard = mappaRichieste.get("listBeniStandard");
			List<DatiRichiestaBean> listGruppoInformatica = mappaRichieste.get("listBeniInformatica");
			String navigation = "inserimentoRichiesta";
			actionRequest.setAttribute("servizioMateriale", servizioMateriale);
			actionRequest.setAttribute("richiedente", richiedente);
			actionRequest.setAttribute("stato", stato);
			actionRequest.setAttribute("datiRichiestaBean", datiRichiestaBean);
			actionRequest.setAttribute("listGruppoStandard", listGruppoStandard);
			actionRequest.setAttribute("listGruppoInformatica", listGruppoInformatica);
			actionRequest.setAttribute("periodicita", listPeriodicita);
			actionRequest.setAttribute("dirigente", "0");
			actionRequest.setAttribute("tipoBeni", tipoBeni);
			actionRequest.setAttribute("navigation", navigation);

		} catch (JSONException e) {

			_log.warn(e);
		}
	}

	public void modificaRichiestaDirigente(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ParseException, java.text.ParseException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<Periodicita> periodicita = (List<Periodicita>) PeriodicitaLocalServiceUtil
					.getPeriodicitas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<ServizioMateriale> servizioMateriale = (List<ServizioMateriale>) ServizioMaterialeLocalServiceUtil
					.getServizioMateriales(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			Richiedente richiedente = new Richiedente();
			String id = actionRequest.getParameter("idRichiesta");
			String json = actionRequest.getParameter("json");
			JSONObject obj = JSONFactoryUtil.createJSONObject(json);
			String tipoBeni = obj.getString("tipoBeni");
			String ubicazioneAttuale = obj.getString("ubicazione");
			String ufficioRichiedente = obj.getString("ufficioRichiedente");
			String organizzazione = obj.getString("organizzazione");
			String nome = obj.getString("nome");
			String cognome = obj.getString("cognome");
			String piano = obj.getString("piano");
			String palazzina = obj.getString("palazzina");
			String stanza = obj.getString("stanza");
			String scala = obj.getString("scala");
			String emailDirigente = obj.getString("email");
			String emailRichiedente = obj.getString("emailRichiedente");
			String oggetto = obj.getString("oggetto");
			String telefono = obj.getString("telefono");
			String costoTotale = obj.getString("costoTotale");
			float costoReale = Float.parseFloat(costoTotale);
			String noteRichiedente = obj.getString("descrizione");
			String sedeDescrizione = obj.getString("sedeDescrizione");
			DatiRichiestaBean datiDettaglioRichiestaBean = new DatiRichiestaBean();
			long idPeriodicita = 0;
			if (!"".equals(obj.getString("periodicita"))) {
				String periodicitaid = obj.getString("periodicita");
				idPeriodicita = Long.parseLong(periodicitaid);
			}
			String numeroInventarioMacchina = null;
			if (!"".equals(obj.getString("numeroInventarioMacchina"))) {
				numeroInventarioMacchina = obj.getString("numeroInventarioMacchina");
			}
			HashMap<String, List<DatiRichiestaBean>> mappaRichieste = jsontoData(json);
			List<DatiRichiestaBean> listGruppoStandard = mappaRichieste.get("listBeniStandard");
			List<DatiRichiestaBean> listGruppoInformatica = mappaRichieste.get("listBeniInformatica");
			DatiRichiestaBean datiRichiestaBean = createDatiRichiesta(json);

			String result = updateRichiestaDirigente(tipoBeni, id, costoReale, idPeriodicita, numeroInventarioMacchina,
					noteRichiedente, json);
			if (result != null && result == "0") {
				String subjectTesto = actionRequest.getPreferences().getValue("subjectAggiorna",
						_configuration.subjectAggiorna());

				String subject = null;

				if ("beniStandard".equals(tipoBeni)) {
					LocalRich richiestaLocal = LocalRichLocalServiceUtil.getRichiestebyIdRichiesta(Long.parseLong(id))
							.get(0);
					String nomeDip = getDipartimentoFromUserLocation(UserLocalServiceUtil
							.getUserByEmailAddress(themeDisplay.getCompanyId(), richiestaLocal.getEmail()));
					datiDettaglioRichiestaBean.setStato(
							StatoLocalServiceUtil.getStato(richiestaLocal.getIdStatoAttuale()).getDescrizione());
					subject = createSubjectEmail(id, nomeDip, ufficioRichiedente, subjectTesto);

				}
				if ("beniInformatica".equals(tipoBeni)) {
					LocalRichInfo richiestaInfoLocal = LocalRichInfoLocalServiceUtil
							.getRichiestebyIdRichiesta(Long.parseLong(id)).get(0);
					String nomeDip = getDipartimentoFromUserLocation(UserLocalServiceUtil
							.getUserByEmailAddress(themeDisplay.getCompanyId(), richiestaInfoLocal.getEmail()));
					datiDettaglioRichiestaBean.setStato(
							StatoLocalServiceUtil.getStato(richiestaInfoLocal.getIdStatoAttuale()).getDescrizione());
					subject = createSubjectEmail(id, nomeDip, ufficioRichiedente, subjectTesto);
				}
				String mailbody = actionRequest.getPreferences().getValue("aggiornaTmpl",
						_configuration.aggiornaTmpl());
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);

				String sender = actionRequest.getPreferences().getValue("senderBeni", _configuration.senderBeni());
				String emailReferente = actionRequest.getPreferences().getValue("emailReferente",
						_configuration.emailReferente());
				EmailSender mail = new EmailSender();
				String datirichiedente = getHtmlRichiedente(ufficioRichiedente, organizzazione, nome, cognome,
						ubicazioneAttuale, piano, scala, stanza, telefono, emailDirigente, sedeDescrizione);
				String datirichiesta = null;
				if ("beniInformatica".equals(tipoBeni))
					datirichiesta = getHtmlRichiesta(oggetto, new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
							noteRichiedente, costoTotale, listGruppoInformatica, null);

				if ("beniStandard".equals(tipoBeni))
					datirichiesta = getHtmlRichiesta(oggetto, new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
							noteRichiedente, costoTotale, listGruppoStandard, null);

				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
						new String[] { datirichiedente, datirichiesta });
				mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferente, emailDirigente,
						themeDisplay.getUser().getEmailAddress());

				Richiedente datiDettaglioRichiedenteBean = new Richiedente();
				JSONObject jsonObjectRigheRichiestaDati = JSONFactoryUtil.createJSONObject(json);
				datiDettaglioRichiestaBean.setOggetto(jsonObjectRigheRichiestaDati.getString("oggetto"));
				datiDettaglioRichiestaBean.setDataRichiesta(jsonObjectRigheRichiestaDati.getString("dataRichiesta"));
				SimpleDateFormat dataOraFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date dataOraRichiesta = dataOraFormatter.parse(datiDettaglioRichiestaBean.getDataRichiesta());
				SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy");
				Date dataRichiestaDettaglio = dataFormatter.parse(datiDettaglioRichiestaBean.getDataRichiesta());
				datiDettaglioRichiestaBean.setDataRichiesta(dataFormatter.format(dataRichiestaDettaglio));
				datiDettaglioRichiestaBean.setCodiceGeco(jsonObjectRigheRichiestaDati.getString("codiceGeco"));
				datiDettaglioRichiedenteBean.setNome(jsonObjectRigheRichiestaDati.getString("nome"));
				datiDettaglioRichiedenteBean.setCognome(jsonObjectRigheRichiestaDati.getString("cognome"));
				datiDettaglioRichiedenteBean
						.setUfficioRichiedente(jsonObjectRigheRichiestaDati.getString("ufficioRichiedente"));
				datiDettaglioRichiedenteBean
						.setOrganizzazione(jsonObjectRigheRichiestaDati.getString("organizzazione"));
				datiDettaglioRichiedenteBean.setUbicazione(jsonObjectRigheRichiestaDati.getString("ubicazione"));
				datiDettaglioRichiedenteBean.setPalazzina(jsonObjectRigheRichiestaDati.getString("palazzina"));
				datiDettaglioRichiedenteBean.setPiano(jsonObjectRigheRichiestaDati.getString("piano"));
				datiDettaglioRichiedenteBean.setScala(jsonObjectRigheRichiestaDati.getString("scala"));
				datiDettaglioRichiedenteBean.setStanza(jsonObjectRigheRichiestaDati.getString("stanza"));
				datiDettaglioRichiedenteBean.setTelefono(jsonObjectRigheRichiestaDati.getString("telefono"));
				datiDettaglioRichiedenteBean
						.setEmailRichiedente(jsonObjectRigheRichiestaDati.getString("emailRichiedente"));
				datiDettaglioRichiedenteBean.setEmailDirigente(jsonObjectRigheRichiestaDati.getString("email"));
				datiDettaglioRichiestaBean.setTipoBeni(jsonObjectRigheRichiestaDati.getString("tipoBeni"));
				datiDettaglioRichiestaBean
						.setPeriodicitaDescrizione(jsonObjectRigheRichiestaDati.getString("periodicitaDescrizione"));
				HashMap<String, List<DatiRichiestaBean>> richiestePerDettaglio = jsontoData(json);
				List<DatiRichiestaBean> beni_standard_list_dettaglio = richiestePerDettaglio.get("listBeniStandard");
				List<DatiRichiestaBean> beni_informatici_list_dettaglio = richiestePerDettaglio
						.get("listBeniInformatica");
				datiDettaglioRichiestaBean.setCostoTotale(jsonObjectRigheRichiestaDati.getString("costoTotale"));
				datiDettaglioRichiestaBean.setDescrizione(jsonObjectRigheRichiestaDati.getString("descrizione"));
				datiDettaglioRichiestaBean.setNumeroInventarioMacchina(
						jsonObjectRigheRichiestaDati.getString("numeroInventarioMacchina"));

				datiDettaglioRichiedenteBean
						.setSedeDescrizione(jsonObjectRigheRichiestaDati.getString("sedeDescrizione"));
				actionRequest.setAttribute("dataRichiesta", dataOraRichiesta);
				actionRequest.setAttribute("idRichiesta", id);
				actionRequest.setAttribute("datiDettaglioRichiedenteBean", datiDettaglioRichiedenteBean);
				actionRequest.setAttribute("datiDettaglioRichiestaBean", datiDettaglioRichiestaBean);
				actionRequest.setAttribute("beniStandardListDettaglio", beni_standard_list_dettaglio);
				actionRequest.setAttribute("beniInformaticiListDettaglio", beni_informatici_list_dettaglio);
				actionRequest.setAttribute("beniStandardListDettaglioSize", beni_standard_list_dettaglio.size());
				actionRequest.setAttribute("beniInformaticiListDettaglioSize", beni_informatici_list_dettaglio.size());

				PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
				urlRefresh.setParameter("javax.portlet.action", "vaiADettaglio");
				urlRefresh.setParameter("richiestaId", String.valueOf(id));
				urlRefresh.setParameter("statoRichiesta", datiDettaglioRichiestaBean.getStato());
				actionResponse.sendRedirect(urlRefresh.toString());

			} else {
				SessionErrors.add(actionRequest, "Errore-durante-caricamento");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				actionRequest.setAttribute("ufficioRichiedente", ufficioRichiedente);
				actionRequest.setAttribute("nome", nome);
				actionRequest.setAttribute("cognome", cognome);
				actionRequest.setAttribute("ubicazione", ubicazioneAttuale);
				actionRequest.setAttribute("palazzina", palazzina);
				actionRequest.setAttribute("piano", piano);
				actionRequest.setAttribute("scala", scala);
				actionRequest.setAttribute("stanza", stanza);
				actionRequest.setAttribute("telefono", telefono);
				actionRequest.setAttribute("emailRichiedente", emailRichiedente);
				actionRequest.setAttribute("emailDirigente", emailDirigente);
				actionRequest.setAttribute("json", json);
				actionRequest.setAttribute("datiDellaRichiesta", datiRichiestaBean);
				actionRequest.setAttribute("richiedente", richiedente);
				actionRequest.setAttribute("servizioMateriale", servizioMateriale);
				actionRequest.setAttribute("periodicita", periodicita);
				actionRequest.setAttribute("listBeniStandard", listGruppoStandard);
				actionRequest.setAttribute("listBeniInformatica", listGruppoInformatica);
				actionRequest.setAttribute("navigation", "riepilogo");
			}

		} catch (PortalException e) {
			_log.error(e);
		}
	}

	private HashMap<String, List<DatiRichiestaBean>> jsontoData(String json) {
		HashMap<String, List<DatiRichiestaBean>> mappaListeRichieste = new HashMap<String, List<DatiRichiestaBean>>();
		try {

			JSONObject obj = JSONFactoryUtil.createJSONObject(json);
			String tipoBeni = obj.getString("tipoBeni");
			JSONArray datiRichiesta = JSONFactoryUtil.createJSONArray(obj.getString("datiRichieste"));
			List<DatiRichiestaBean> listBeniStandard = new ArrayList<>(0);
			List<DatiRichiestaBean> listBeniInformatica = new ArrayList<>(0);
			DatiRichiestaBean datiRichiestaBean;
			for (int i = 0; i < datiRichiesta.length(); i++) {

				datiRichiestaBean = new DatiRichiestaBean();
				String gruppo = datiRichiesta.getJSONObject(i).getString("gruppo");
				if (!"".equals(gruppo) && gruppo != null) {

					datiRichiestaBean.setGruppo(gruppo);
				}
				String sottoGruppo = datiRichiesta.getJSONObject(i).getString("sottoGruppo");
				if (!"".equals(sottoGruppo) && sottoGruppo != null) {

					datiRichiestaBean.setSottoGruppo(sottoGruppo);
				}
				String materiale = datiRichiesta.getJSONObject(i).getString("materiale");
				if (!"".equals(materiale) && materiale != null) {

					datiRichiestaBean.setMateriale(materiale);
				}
				String quantita = datiRichiesta.getJSONObject(i).getString("quantita");
				if (!"".equals(quantita) && quantita != null) {

					datiRichiestaBean.setQuantita(quantita);
				}
				String materialeDescrizione = datiRichiesta.getJSONObject(i).getString("materialeDescrizione");
				if (!"".equals(materialeDescrizione) && materialeDescrizione != null) {

					datiRichiestaBean.setMaterialeDescrizione(materialeDescrizione);
				}
				String gruppoDescrizione = datiRichiesta.getJSONObject(i).getString("gruppoDescrizione");
				if (!"".equals(gruppoDescrizione) && gruppoDescrizione != null) {

					datiRichiestaBean.setGruppoDescrizione(gruppoDescrizione);
				}
				String sottoGruppoDescrizione = datiRichiesta.getJSONObject(i).getString("sottoGruppoDescrizione");
				if (!"".equals(sottoGruppoDescrizione) && sottoGruppoDescrizione != null) {

					datiRichiestaBean.setSottoGruppoDescrizione(sottoGruppoDescrizione);
				}
				String costoUnitario = datiRichiesta.getJSONObject(i).getString("costoUnitario");
				if (!"".equals(costoUnitario) && costoUnitario != null) {

					datiRichiestaBean.setCostoUnitario(costoUnitario);
				}
				String inputValue = datiRichiesta.getJSONObject(i).getString("inputPrezzoMedioValue");
				if (!"".equals(inputValue) && inputValue != null) {

					datiRichiestaBean.setInputValue(inputValue);
				}
				String disponibilita = datiRichiesta.getJSONObject(i).getString("disponibilita");
				if (!"".equals(disponibilita) && disponibilita != null) {

					datiRichiestaBean.setDisponibilita(disponibilita);
				}

				if (!"".equals(gruppo) && !"".equals(gruppoDescrizione) && !"".equals(sottoGruppo)
						&& !"".equals(sottoGruppoDescrizione) && !"".equals(materiale)
						&& !"".equals(materialeDescrizione) && !"".equals(quantita) && !"".equals(inputValue)
						&& !"".equals(disponibilita)) {

					if ("beniStandard".equals(tipoBeni))
						listBeniStandard.add(datiRichiestaBean);

					if ("beniInformatica".equals(tipoBeni))
						listBeniInformatica.add(datiRichiestaBean);

				}
			}
			mappaListeRichieste.put("listBeniStandard", listBeniStandard);
			mappaListeRichieste.put("listBeniInformatica", listBeniInformatica);
		} catch (JSONException e) {

			_log.warn(e);
		}
		return mappaListeRichieste;
	}

	private String updateRichiestaDirigente(String tipobeni, String id_richiesta, Float costoReale, Long idPeriodicita,
			String nMacchina, String noteRichiedente, String json) {

		String result = null;
		LocalRich richiesteLocal = null;
		LocalRichInfo richiesteInfoLocal = null;
		RigheRichBFCNew righeRichiestaBFC = null;

		try {

			if ("beniStandard".equals(tipobeni)) {
				LocalRich richiestaLoc = LocalRichLocalServiceUtil
						.getRichiestebyIdRichiesta(Long.parseLong(id_richiesta)).get(0);
				richiestaLoc.setNoteRich(noteRichiedente);
				richiestaLoc.setCostoReale(costoReale);
				richiestaLoc.setIdPeriodicita(idPeriodicita);
				richiestaLoc.setDataUpd(new Date());
				richiesteLocal = LocalRichLocalServiceUtil.updateLocalRich(richiestaLoc);

				if (richiesteLocal != null)
					result = "0";
			}

			if ("beniInformatica".equals(tipobeni)) {
				LocalRichInfo richiestaInfoLoc = LocalRichInfoLocalServiceUtil
						.getRichiestebyIdRichiesta(Long.parseLong(id_richiesta)).get(0);
				richiestaInfoLoc.setCostoReale(costoReale);
				richiestaInfoLoc.setNMacchina(nMacchina);
				richiestaInfoLoc.setNoteRich(noteRichiedente);
				richiestaInfoLoc.setDataUpd(new Date());
				richiesteInfoLocal = LocalRichInfoLocalServiceUtil.updateLocalRichInfo(richiestaInfoLoc);

				if (richiesteInfoLocal != null)
					result = "0";
			}

			List<RigheRichBFCNew> idRigha = (List<RigheRichBFCNew>) RigheRichBFCNewLocalServiceUtil
					.getRigaRichiestaByIdRichiesta(Long.parseLong(id_richiesta));
			long id = idRigha.get(0).getId();
			RigheRichBFCNew updateRichiesta = RigheRichBFCNewLocalServiceUtil.getRigheRichBFCNew(id);

			if (json.length() <= 4000) {
				updateRichiesta.setDati1(json);
			} else if (json.length() > 4000 && json.length() <= 8000) {
				updateRichiesta.setDati1(json.substring(0, 3999));
				updateRichiesta.setDati2(json.substring(4000, json.length()));
			} else if (json.length() > 8000 && json.length() <= 12000) {
				updateRichiesta.setDati1(json.substring(0, 3999));
				updateRichiesta.setDati2(json.substring(4000, 7999));
				updateRichiesta.setDati3(json.substring(8000, json.length()));
			} else if (json.length() > 12000 && json.length() <= 16000) {
				updateRichiesta.setDati1(json.substring(0, 3999));
				updateRichiesta.setDati2(json.substring(4000, 7999));
				updateRichiesta.setDati3(json.substring(8000, 12000));
				updateRichiesta.setDati4(json.substring(12000, json.length()));
			}

			righeRichiestaBFC = RigheRichBFCNewLocalServiceUtil.updateRigheRichBFCNew(updateRichiesta);
			if (righeRichiestaBFC != null) {

				result = "0";
			}
			return result;
		} catch (Exception e) {
			_log.info("error in update richieste:" + e);
			return null;
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiesteBeniFaciliConsumiConfig.class, properties);
	}

	private volatile MefRichiesteBeniFaciliConsumiConfig _configuration;

	public String getRichiestaTmpl(Map richiestaBeniTmpl) {
		return (String) richiestaBeniTmpl.get(_configuration.richiestaBeniTmpl());
	}

	public String getApprovatoTmpl(Map approvatoTmpl) {
		return (String) approvatoTmpl.get(_configuration.approvatoTmpl());
	}

	public String getSender(Map senderBeni) {
		return (String) senderBeni.get(_configuration.senderBeni());
	}

	public String getSubjectNuova(Map subjectNuova) {
		return (String) subjectNuova.get(_configuration.subjectNuova());
	}

	public String getSubjectApprovazione(Map subjectApprovazione) {
		return (String) subjectApprovazione.get(_configuration.subjectApprovazione());
	}

	public String getEmailReferente(Map emailReferente) {
		return (String) emailReferente.get(_configuration.emailReferente());
	}

	public String getOggettoBeniStandard(Map oggettoBeniStandard) {
		return (String) oggettoBeniStandard.get(_configuration.oggettoBeniStandard());
	}

	public String getOggettoBeniInformatica(Map oggettoBeniInformatica) {
		return (String) oggettoBeniInformatica.get(_configuration.oggettoBeniInformatica());
	}

	@ProcessAction(name = "cercaUtentiDaAbilitare")
	public void cercaUtentiDaAbilitare(ActionRequest request, ActionResponse response) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> filtriRicerca = new ArrayList<String>();
		DynamicQuery queryUtentiDaAbilitare = DynamicQueryFactoryUtil.forClass(User.class);
		Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
		List<String> id_uffici_utenti_list = new ArrayList<String>(0);
		List<ExpandoValue> expando_value_list = new ArrayList<ExpandoValue>(0);
		// controllo se i dati provenienti dalla form sono stati valorizzati; se
		// si, valorizzo le variabili e aggiungo il corrispondente criterio alla
		// query sugli utenti
		if (request.getParameter("cognomeUtenteDaAbilitare") != null
				&& !"".equals(request.getParameter("cognomeUtenteDaAbilitare"))) {
			String cognomeUtente = request.getParameter("cognomeUtenteDaAbilitare");
			queryUtentiDaAbilitare.add(RestrictionsFactoryUtil.ilike("lastName", cognomeUtente));
			filtriRicerca.add(cognomeUtente);
		}
		if (request.getParameter("nomeUtenteDaAbilitare") != null
				&& !"".equals(request.getParameter("nomeUtenteDaAbilitare"))) {
			String nomeUtente = request.getParameter("nomeUtenteDaAbilitare");
			queryUtentiDaAbilitare.add(RestrictionsFactoryUtil.ilike("firstName", nomeUtente));
			filtriRicerca.add(nomeUtente);
		}
		if (request.getParameter("codFiscaleUtenteDaAbilitare") != null
				&& !"".equals(request.getParameter("codFiscaleUtenteDaAbilitare"))) {
			String codFiscaleUtente = request.getParameter("codFiscaleUtenteDaAbilitare");
			queryUtentiDaAbilitare.add(RestrictionsFactoryUtil.ilike("screenName", codFiscaleUtente));
			filtriRicerca.add(codFiscaleUtente);
		}
		if (request.getParameter("idUfficioUtenteDaAbilitare") != null
				&& !"".equals(request.getParameter("idUfficioUtenteDaAbilitare"))) {
			id_uffici_utenti_list.add(request.getParameter("idUfficioUtenteDaAbilitare"));
			expando_value_list = ExpandoValueLocalServiceUtil.getColumnValues(themeDisplay.getCompanyId(),
					ClassNameLocalServiceUtil.getClassNameId(User.class.getName()),
					ExpandoTableConstants.DEFAULT_TABLE_NAME, "idOrgChart", id_uffici_utenti_list.get(0),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			filtriRicerca.add(OrganizationChartLocalServiceUtil
					.getOrganizationChart(Long.parseLong(request.getParameter("idUfficioUtenteDaAbilitare")))
					.getName());
		} else {

			String personId = (String) themeDisplay.getUser().getExpandoBridge().getAttribute(_customFieldUserPersonal);
			for (ManagerOfficesBind managerOfficesBind : ManagerOfficesBindLocalServiceUtil
					.getManagerOfficesBindByPersonId(Long.parseLong(personId))) {
				for (ExpandoValue ev : ExpandoValueLocalServiceUtil.getColumnValues(themeDisplay.getCompanyId(),
						ClassNameLocalServiceUtil.getClassNameId(User.class.getName()),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, "idOrgChart",
						String.valueOf(managerOfficesBind.getIdOrgChart()), QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
					expando_value_list.add(ev);
				}
			}
		}
		for (ExpandoValue ev : expando_value_list) {
			Property propertyUserId = PropertyFactoryUtil.forName("userId");
			disjunctionKey.add(propertyUserId.eq(ev.getClassPK()));
		}
		queryUtentiDaAbilitare.add(disjunctionKey);
		// faccio la query sugli utenti
		List<User> res_utenti = UserLocalServiceUtil.dynamicQuery(queryUtentiDaAbilitare);
		// ricavo il set relativo agli utenti da abilitare
		Set<User> res_utenti_da_abilitare = new HashSet<User>(0);
		for (User user : res_utenti) {

			List<String> nomi_ruoli = new ArrayList<String>(0);
			for (Role userRole : user.getRoles()) {

				nomi_ruoli.add(userRole.getName());
			}
			if (!nomi_ruoli.contains("Dirigente") && !nomi_ruoli.contains("abilitatoBfc")
					&& !nomi_ruoli.contains("delegatoBfc")) {

				res_utenti_da_abilitare.add(user);
			}
		}
		JSONArray jsonArrayUtentiDaAbilitare = JSONFactoryUtil.createJSONArray();
		for (User user : res_utenti_da_abilitare) {
			RisultatoRicercaUtente risultatoRicercaUtente = new RisultatoRicercaUtente();
			risultatoRicercaUtente.setId(String.valueOf(user.getUserId()));
			risultatoRicercaUtente.setNome(user.getFirstName());
			risultatoRicercaUtente.setCognome(user.getLastName());
			if (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {

				risultatoRicercaUtente.setUfficio(OrganizationChartLocalServiceUtil
						.getOrganizationChart(
								Long.parseLong((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg)))
						.getName());
			}
			jsonArrayUtentiDaAbilitare.put(risultatoRicercaUtente.toJSONObject());
		}
		request.setAttribute("filtriRicercaRichieste", filtriRicerca);
		request.setAttribute("jsonArrayUtentiDaAbilitare", jsonArrayUtentiDaAbilitare.toString());
		request.setAttribute("navigation", "gestioneutenti");
	}

	@ProcessAction(name = "cercaUtentiAbilitati")
	public void cercaUtentiAbilitati(ActionRequest request, ActionResponse response) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> filtriRicerca = new ArrayList<String>();
		DynamicQuery queryUtentiAbilitati = DynamicQueryFactoryUtil.forClass(User.class);
		Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
		List<String> id_uffici_utenti_list = new ArrayList<String>(0);
		List<ExpandoValue> expando_value_list = new ArrayList<ExpandoValue>(0);
		// controllo se i dati provenienti dalla form sono stati valorizzati; se
		// si, valorizzo le variabili e aggiungo il corrispondente criterio alla
		// query sugli utenti
		if (request.getParameter("cognomeUtenteAbilitato") != null
				&& !"".equals(request.getParameter("cognomeUtenteAbilitato"))) {
			String cognomeUtente = request.getParameter("cognomeUtenteAbilitato");
			queryUtentiAbilitati.add(RestrictionsFactoryUtil.ilike("lastName", cognomeUtente));
			filtriRicerca.add(cognomeUtente);
		}
		if (request.getParameter("nomeUtenteAbilitato") != null
				&& !"".equals(request.getParameter("nomeUtenteAbilitato"))) {
			String nomeUtente = request.getParameter("nomeUtenteAbilitato");
			queryUtentiAbilitati.add(RestrictionsFactoryUtil.ilike("firstName", nomeUtente));
			filtriRicerca.add(nomeUtente);
		}
		if (request.getParameter("idUfficioUtenteAbilitato") != null
				&& !"".equals(request.getParameter("idUfficioUtenteAbilitato"))) {
			id_uffici_utenti_list.add(request.getParameter("idUfficioUtenteAbilitato"));
			expando_value_list = ExpandoValueLocalServiceUtil.getColumnValues(themeDisplay.getCompanyId(),
					ClassNameLocalServiceUtil.getClassNameId(User.class.getName()),
					ExpandoTableConstants.DEFAULT_TABLE_NAME, "idOrgChart", id_uffici_utenti_list.get(0),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			filtriRicerca.add(OrganizationChartLocalServiceUtil
					.getOrganizationChart(Long.parseLong(request.getParameter("idUfficioUtenteAbilitato"))).getName());
		} else {

			String personId = (String) themeDisplay.getUser().getExpandoBridge().getAttribute(_customFieldUserPersonal);
			for (ManagerOfficesBind managerOfficesBind : ManagerOfficesBindLocalServiceUtil
					.getManagerOfficesBindByPersonId(Long.parseLong(personId))) {
				for (ExpandoValue ev : ExpandoValueLocalServiceUtil.getColumnValues(themeDisplay.getCompanyId(),
						ClassNameLocalServiceUtil.getClassNameId(User.class.getName()),
						ExpandoTableConstants.DEFAULT_TABLE_NAME, "idOrgChart",
						String.valueOf(managerOfficesBind.getIdOrgChart()), QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
					expando_value_list.add(ev);
				}
			}
		}
		for (ExpandoValue ev : expando_value_list) {
			Property propertyUserId = PropertyFactoryUtil.forName("userId");
			disjunctionKey.add(propertyUserId.eq(ev.getClassPK()));
		}
		queryUtentiAbilitati.add(disjunctionKey);
		// faccio la query sugli utenti
		List<User> res_utenti = UserLocalServiceUtil.dynamicQuery(queryUtentiAbilitati);
		// ricavo 2 set: utenti abilitati e utenti delegati
		Set<User> res_utenti_abilitati = new HashSet<User>(0);
		Set<User> res_utenti_abilitati_delegati = new HashSet<User>(0);
		Set<User> res_utenti_abilitati_non_delegati = new HashSet<User>(0);
		for (User user : res_utenti) {

			List<String> nomi_ruoli = new ArrayList<String>(0);
			for (Role userRole : user.getRoles()) {

				nomi_ruoli.add(userRole.getName());
			}
			if (nomi_ruoli.contains("abilitatoBfc")) {

				res_utenti_abilitati.add(user);
			}
			if (nomi_ruoli.contains("delegatoBfc")) {

				res_utenti_abilitati_delegati.add(user);
			}
			if (nomi_ruoli.contains("abilitatoBfc") && !nomi_ruoli.contains("delegatoBfc")) {

				res_utenti_abilitati_non_delegati.add(user);
			}
		}
		JSONArray jsonArrayUtentiAbilitati = JSONFactoryUtil.createJSONArray();
		if (request.getParameter("checkBoxArray") != null) {

			if ("Yes,No".equals(request.getParameter("checkBoxArray"))
					|| "".equals(request.getParameter("checkBoxArray"))) {

				for (User user : res_utenti_abilitati) {
					RisultatoRicercaUtente risultatoRicercaUtente = new RisultatoRicercaUtente();
					risultatoRicercaUtente.setId(String.valueOf(user.getUserId()));
					risultatoRicercaUtente.setNome(user.getFirstName());
					risultatoRicercaUtente.setCognome(user.getLastName());
					if (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {

						risultatoRicercaUtente.setUfficio(OrganizationChartLocalServiceUtil
								.getOrganizationChart(Long
										.parseLong((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg)))
								.getName());
					}
					List<String> nomi_ruoli = new ArrayList<String>(0);
					for (Role userRole : user.getRoles()) {

						nomi_ruoli.add(userRole.getName());
					}
					if (nomi_ruoli.contains("delegatoBfc")) {

						risultatoRicercaUtente.setDelega(true);
					} else {

						risultatoRicercaUtente.setDelega(false);
					}
					jsonArrayUtentiAbilitati.put(risultatoRicercaUtente.toJSONObject());
				}
				if ("Yes,No".equals(request.getParameter("checkBoxArray"))) {
					filtriRicerca.add("si");
					filtriRicerca.add("no");
				}
			}
			if ("Yes".equals(request.getParameter("checkBoxArray"))) {

				for (User user : res_utenti_abilitati_delegati) {
					RisultatoRicercaUtente risultatoRicercaUtente = new RisultatoRicercaUtente();
					risultatoRicercaUtente.setId(String.valueOf(user.getUserId()));
					risultatoRicercaUtente.setNome(user.getFirstName());
					risultatoRicercaUtente.setCognome(user.getLastName());
					if (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {

						risultatoRicercaUtente.setUfficio(OrganizationChartLocalServiceUtil
								.getOrganizationChart(Long
										.parseLong((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg)))
								.getName());
					}
					risultatoRicercaUtente.setDelega(true);
					jsonArrayUtentiAbilitati.put(risultatoRicercaUtente.toJSONObject());
				}
				filtriRicerca.add("si");
			}
			if ("No".equals(request.getParameter("checkBoxArray"))) {

				for (User user : res_utenti_abilitati_non_delegati) {
					RisultatoRicercaUtente risultatoRicercaUtente = new RisultatoRicercaUtente();
					risultatoRicercaUtente.setId(String.valueOf(user.getUserId()));
					risultatoRicercaUtente.setNome(user.getFirstName());
					risultatoRicercaUtente.setCognome(user.getLastName());
					if (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {

						risultatoRicercaUtente
								.setUfficio(
										String.valueOf(
												OrganizationChartLocalServiceUtil
														.getOrganizationChart(Long.parseLong((String) user
																.getExpandoBridge().getAttribute(_customFieldUserOrg)))
														.getName()));
					}
					risultatoRicercaUtente.setDelega(false);
					jsonArrayUtentiAbilitati.put(risultatoRicercaUtente.toJSONObject());
				}
				filtriRicerca.add("no");
			}
		}
		request.setAttribute("jsonArrayUtentiAbilitati", jsonArrayUtentiAbilitati.toString());
		request.setAttribute("navigation", "gestioneutenti");
		request.setAttribute("filtriRicercaRichieste", filtriRicerca);
	}

	private String insertRichiestaGeco(ActionRequest actionRequest, String origine, String idIntranet, String codUtente,
			String codiceUfficio, String email, String ispettorato, String ufficio, String telefono_richiedente,
			String riferimento_stanza, String idSede, String oggetto, String data, String periodicita, String budget,
			String consuntivo, List<MaterialeBean> listamateriali, String note) {

		String listaUfficiGeco = actionRequest.getPreferences().getValue("listaUfficiGeco",
				_configuration.listaUfficiGeco());
		String[] listCodes = listaUfficiGeco.split(",");
		String ambiente = actionRequest.getPreferences().getValue("ambienteGecoPigreco",
				_configuration.ambienteGecoPigreco());

		if (Arrays.asList(listCodes).contains(codiceUfficio)) {
			String response = supportDataLocalServiceUtil.nuovaRichiestaBfc(origine, idIntranet, codUtente,
					codiceUfficio, email, ispettorato, ufficio, telefono_richiedente, riferimento_stanza, idSede,
					oggetto, data, periodicita, budget, consuntivo, listamateriali, note, "geco", ambiente);
			return response;
		} else {
			String response = supportDataLocalServiceUtil.nuovaRichiestaBfc(origine, idIntranet, codUtente,
					codiceUfficio, email, ispettorato, ufficio, telefono_richiedente, riferimento_stanza, idSede,
					oggetto, data, periodicita, budget, consuntivo, listamateriali, note, "pigreco", ambiente);
			return response;
		}

	}

	@ProcessAction(name = "refreshPage")
	public void refreshPage(ActionRequest request, ActionResponse response) {

		request.setAttribute("navigation", "gestioneutenti");
	}

	@ProcessAction(name = "refreshPageRicerca")
	public void refreshPageRicerca(ActionRequest request, ActionResponse response) {

		request.setAttribute("navigation", "risultatiricercarichieste");
	}

	@ProcessAction(name = "setNoteConsegnatario")
	public void setNoteConsegnatario(ActionRequest request, ActionResponse response)
			throws NumberFormatException, PortalException {

		String idRichiesta = request.getParameter("idRichiesta");
		String noteConsegnatario = request.getParameter("noteConsegnatario");
		RigheRichBFCNew rigaRichiesta = RigheRichBFCNewLocalServiceUtil
				.getRigaRichiestaByIdRichiesta(Long.parseLong(idRichiesta)).get(0);

		StringBuilder jsonCompleto = new StringBuilder();
		jsonCompleto.append(rigaRichiesta.getDati1());
		jsonCompleto.append(rigaRichiesta.getDati2());
		jsonCompleto.append(rigaRichiesta.getDati3());
		jsonCompleto.append(rigaRichiesta.getDati4());

		JSONObject jsonObjectRigheRichiestaDati = JSONFactoryUtil.createJSONObject(jsonCompleto.toString());
		if ("beniStandard".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {
			Richieste richiesta = RichiesteLocalServiceUtil.getRichieste(Long.parseLong(idRichiesta));
			richiesta.setNote(noteConsegnatario);
			RichiesteLocalServiceUtil.updateRichieste(richiesta);
		} else if ("beniInformatica".equalsIgnoreCase(jsonObjectRigheRichiestaDati.getString("tipoBeni"))) {
			RichiesteInfo richiestaInfo = RichiesteInfoLocalServiceUtil.getRichiesteInfo(Long.parseLong(idRichiesta));
			richiestaInfo.setNote(noteConsegnatario);
			RichiesteInfoLocalServiceUtil.updateRichiesteInfo(richiestaInfo);
		}
	}

	private List<RigheRichieste> getRigheRichiesteByRichestaId(long id) {
		return RigheRichiesteLocalServiceUtil.getrichiesteId(id);
	}

	private List<RigheRichiesteInfo> getRigheRichiesteInfoByRichestaId(long id) {
		return RigheRichiesteInfoLocalServiceUtil.getrichiesteInfoId(id);
	}

	private Long insertRigherichiestaToStage(long id, long idMateriale, String gruppo, String sottogruppo,
			long numeroRiga, float importo, long quantitaDisponibile, long quantitaRichiesta, Date dataIns,
			Date dataUpd, Long uidIns, Long uidUpd, String descrizione) {

		Long inserimento = null;
		RigheRichiestePK righeRichiestePK = new RigheRichiestePK();
		if (id != 0) {
			righeRichiestePK.setId(id);
		}
		if (idMateriale != 0) {
			righeRichiestePK.setIdMateriale(idMateriale);
		}
		if (gruppo != null) {
			righeRichiestePK.setGruppo(gruppo);
		}
		if (sottogruppo != null) {
			righeRichiestePK.setSottogruppo(sottogruppo);
		}
		RigheRichieste righerichieste = RigheRichiesteLocalServiceUtil.createRigheRichieste(righeRichiestePK);
		if (uidIns != null) {
			righerichieste.setUidIns(uidIns);
		}
		if (uidUpd != null) {
			righerichieste.setUidUpd(uidUpd);
		}
		if (dataIns != null) {
			righerichieste.setDataIns(dataIns);
		}
		if (dataUpd != null) {
			righerichieste.setDataUpd(dataUpd);
		}
		if (descrizione != null) {
			righerichieste.setDescrizione(descrizione);
		}
		if (numeroRiga != 0) {
			righerichieste.setNumeroRiga(numeroRiga);
		}
		if (importo >= 0) {
			righerichieste.setImporto(importo);
		}
		if (quantitaDisponibile != 0) {
			righerichieste.setQuantitaDisponibile(quantitaDisponibile);
		}
		if (quantitaRichiesta != 0) {
			righerichieste.setQuantitaRichiesta(quantitaRichiesta);
		}
		RigheRichieste insertRigherichieste = RigheRichiesteLocalServiceUtil.addRigheRichieste(righerichieste);
		if (insertRigherichieste != null) {
			inserimento = insertRigherichieste.getId();
		}
		return inserimento;
	}

	private Long insertRigherichiestaInfoToStage(long id, long idMateriale, String gruppo, String sottogruppo,
			long numeroRiga, float importo, long quantitaDisponibile, long quantitaRichiesta, Date dataIns,
			Date dataUpd, Long uidIns, Long uidUpd, String descrizione) {
		Long inserimento = null;
		RigheRichiesteInfoPK righeRichiesteInfoPK = new RigheRichiesteInfoPK();
		if (id != 0) {
			righeRichiesteInfoPK.setId(id);
		}
		if (idMateriale != 0) {
			righeRichiesteInfoPK.setIdMateriale(idMateriale);
		}
		if (gruppo != null) {
			righeRichiesteInfoPK.setGruppo(gruppo);
		}
		if (sottogruppo != null) {
			righeRichiesteInfoPK.setSottogruppo(sottogruppo);
		}
		RigheRichiesteInfo righerichiesteinfo = RigheRichiesteInfoLocalServiceUtil
				.createRigheRichiesteInfo(righeRichiesteInfoPK);
		if (uidIns != null) {
			righerichiesteinfo.setUidIns(uidIns);
		}
		if (uidUpd != null) {
			righerichiesteinfo.setUidUpd(uidUpd);
		}
		if (dataIns != null) {
			righerichiesteinfo.setDataIns(dataIns);
		}
		if (dataUpd != null) {
			righerichiesteinfo.setDataUpd(dataUpd);
		}
		if (descrizione != null) {
			righerichiesteinfo.setDescrizione(descrizione);
		}
		if (numeroRiga != 0) {
			righerichiesteinfo.setNumeroRiga(numeroRiga);
		}
		if (importo >= 0) {
			righerichiesteinfo.setImporto(importo);
		}
		if (quantitaDisponibile != 0) {
			righerichiesteinfo.setQuantitaDisponibile(quantitaDisponibile);
		}
		if (quantitaRichiesta != 0) {
			righerichiesteinfo.setQuantitaRichiesta(quantitaRichiesta);
		}
		RigheRichiesteInfo insertRigheInforichieste = RigheRichiesteInfoLocalServiceUtil
				.addRigheRichiesteInfo(righerichiesteinfo);
		if (insertRigheInforichieste != null) {
			inserimento = insertRigheInforichieste.getId();
		}
		return inserimento;
	}

	private Long insertRichiestaToStage(Long id_richiesta, Float costoReale, Date dataIns, Date dataRichiesta,
			Date dataUpd, String email, Integer flagInvio, Long idPeriodicita, String idSede, Long idStatoAttuale,
			String ispettorato, String note, String noteRichiedente, String oggetto, Integer preventivo,
			String riferimentoStanza, String strutIsp, String strutIsp2, String strutUff, String telRichiedente,
			String ufficio, Long uidIns, Long uidUpd) {
		Long inserimento = null;
		Richieste richiesta = RichiesteLocalServiceUtil.createRichieste(id_richiesta);
		// set data to load
		if (costoReale != null)
			richiesta.setCostoReale(costoReale);
		if (dataIns != null)
			richiesta.setDataIns(dataIns);
		if (dataRichiesta != null)
			richiesta.setDataRichiesta(dataRichiesta);
		if (dataUpd != null)
			richiesta.setDataUpd(dataUpd);
		if (email != null)
			richiesta.setEmail(email);
		if (flagInvio != null)
			richiesta.setFlagInvio(flagInvio);
		if (idPeriodicita != null)
			richiesta.setIdPeriodicita(idPeriodicita);
		if (idSede != null)
			richiesta.setIdSede(idSede);
		if (idStatoAttuale != null)
			richiesta.setIdStatoAttuale(idStatoAttuale);
		if (ispettorato != null)
			richiesta.setIspettorato(ispettorato);
		if (note != null)
			richiesta.setNote(note);
		if (noteRichiedente != null)
			richiesta.setNoteRichiedente(noteRichiedente);
		if (oggetto != null)
			richiesta.setOggetto(oggetto);
		if (preventivo != null)
			richiesta.setPreventivo(preventivo);
		if (riferimentoStanza != null)
			richiesta.setRiferimentoStanza(riferimentoStanza);
		if (strutIsp != null)
			richiesta.setStrutIsp(strutIsp);
		if (strutIsp2 != null)
			richiesta.setStrutIsp2(strutIsp2);
		if (strutUff != null)
			richiesta.setStrutUff(strutUff);
		if (telRichiedente != null)
			richiesta.setTelRichiedente(telRichiedente);
		if (ufficio != null)
			richiesta.setUfficio(ufficio);
		if (uidIns != null)
			richiesta.setUidIns(uidIns);
		if (uidUpd != null)
			richiesta.setUidUpd(uidUpd);

		Richieste richiesta_inserita = RichiesteLocalServiceUtil.addRichieste(richiesta);
		if (richiesta_inserita != null) {
			inserimento = richiesta_inserita.getId();
		}
		return inserimento;
	}

	private Long insertRichiestaToLocal(Float costoReale, Date dataIns, Date dataRichiesta, Date dataUpd, String email,
			Integer flagInvio, Long idPeriodicita, String idSede, Long idStatoAttuale, String ispettorato, String note,
			String noteRichiedente, String oggetto, Integer preventivo, String riferimentoStanza, String strutIsp,
			String strutIsp2, String strutUff, String telRichiedente, String ufficio, Long uidIns, Long uidUpd,
			boolean inStage) {

		Long inserimento = null;
		List<RichiesteSequence> sequence = RichiesteSequenceLocalServiceUtil.getRichiesteSequences(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		Long id_richiesta = sequence.get(0).getIdSeq();

		LocalRich richiesta_inserita = LocalRichLocalServiceUtil.insertLocalRich(id_richiesta, costoReale, dataIns,
				dataRichiesta, dataUpd, email, flagInvio, idPeriodicita, idSede, idStatoAttuale, ispettorato, note,
				noteRichiedente, oggetto, preventivo, riferimentoStanza, strutIsp, strutIsp2, strutUff, telRichiedente,
				ufficio, uidIns, uidUpd, inStage);
		if (richiesta_inserita != null) {
			inserimento = richiesta_inserita.getId_richiesta();
		}
		return inserimento;
	}

	private Long insertRichiestaInformaticaToStage(Long id_richiesta, Float costoReale, Date dataIns,
			Date dataRichiesta, Date dataUpd, String email, Integer flagInvio, String nMacchina, String idSede,
			Long idStatoAttuale, String ispettorato, String note, String noteRichiedente, String nomeReferente,
			String oggetto, Integer preventivo, String riferimentoStanza, String strutIsp, String strutUff,
			String telRichiedente, String telefonoReferente, String ufficio, Long uidIns, Long uidUpd) {
		Long inserimento = null;
		RichiesteInfo richiesta = RichiesteInfoLocalServiceUtil.createRichiesteInfo(id_richiesta);
		// set data to load
		if (costoReale != null)
			richiesta.setCostoReale(costoReale);
		if (dataIns != null)
			richiesta.setDataIns(dataIns);
		if (dataRichiesta != null)
			richiesta.setDataRichiesta(dataRichiesta);
		if (dataUpd != null)
			richiesta.setDataUpd(dataUpd);
		if (email != null)
			richiesta.setEmail(email);
		if (flagInvio != null)
			richiesta.setFlagInvio(flagInvio);
		if (nomeReferente != null)
			richiesta.setNomeReferente(nomeReferente);
		if (nMacchina != null)
			richiesta.setNMacchina(nMacchina);
		if (idSede != null)
			richiesta.setIdSede(idSede);
		if (idStatoAttuale != null)
			richiesta.setIdStatoAttuale(idStatoAttuale);
		if (ispettorato != null)
			richiesta.setIspettorato(ispettorato);
		if (note != null)
			richiesta.setNote(note);
		if (noteRichiedente != null)
			richiesta.setNoteRichiedente(noteRichiedente);
		if (oggetto != null)
			richiesta.setOggetto(oggetto);
		if (preventivo != null)
			richiesta.setPreventivo(preventivo);
		if (riferimentoStanza != null)
			richiesta.setRiferimentoStanza(riferimentoStanza);
		if (strutIsp != null)
			richiesta.setStrutIsp(strutIsp);
		if (strutUff != null)
			richiesta.setStrutUff(strutUff);
		if (telRichiedente != null)
			richiesta.setTelRichiedente(telRichiedente);
		if (telefonoReferente != null)
			richiesta.setTelefonoReferente(telefonoReferente);
		if (ufficio != null)
			richiesta.setUfficio(ufficio);
		if (uidIns != null)
			richiesta.setUidIns(uidIns);
		if (uidUpd != null)
			richiesta.setUidUpd(uidUpd);

		RichiesteInfo richiesta_inserita = RichiesteInfoLocalServiceUtil.addRichiesteInfo(richiesta);
		if (richiesta_inserita != null) {
			inserimento = richiesta_inserita.getId();
		}
		return inserimento;
	}

	private Long insertRichiestaInformaticaToLocal(Float costoReale, Date dataIns, Date dataRichiesta, Date dataUpd,
			String email, Integer flagInvio, String nMacchina, String idSede, Long idStatoAttuale, String ispettorato,
			String note, String noteRichiedente, String nomeReferente, String oggetto, Integer preventivo,
			String riferimentoStanza, String strutIsp, String strutUff, String telRichiedente, String telefonoReferente,
			String ufficio, Long uidIns, Long uidUpd, boolean inStage) {

		Long inserimento = null;
		List<RichiesteSequence> sequence = RichiesteSequenceLocalServiceUtil.getRichiesteSequences(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		long id_richiesta = sequence.get(0).getIdSeq();

		LocalRichInfo richiesta_inserita = LocalRichInfoLocalServiceUtil.insertLocalRichInfo(id_richiesta, costoReale,
				dataIns, dataRichiesta, dataUpd, email, flagInvio, nMacchina, idSede, idStatoAttuale, ispettorato, note,
				noteRichiedente, nomeReferente, oggetto, preventivo, riferimentoStanza, strutIsp, strutUff,
				telRichiedente, telefonoReferente, ufficio, uidIns, uidUpd, inStage);
		if (richiesta_inserita != null) {
			inserimento = richiesta_inserita.getId_richiesta();
		}
		return inserimento;
	}

	private String getHtmlRichiedente(String ufficioRichiedente, String organizzazione, String nome, String cognome,
			String ubicazione, String piano, String scala, String stanza, String telefono, String emailrichiedente,
			String sedeDescrizione) {
		StringBuilder dati = new StringBuilder();
		createHtmlForData(dati, "Organizzazione", organizzazione);
		createHtmlForData(dati, "Ufficio Richiedente", ufficioRichiedente);
		createHtmlForData(dati, "Nome", nome);
		createHtmlForData(dati, "Cognome", cognome);
		createHtmlForData(dati, "Ubicazione Attuale", ubicazione);
		createHtmlForData(dati, "Piano", piano);
		createHtmlForData(dati, "Scala", scala);
		createHtmlForData(dati, "Stanza", stanza);
		createHtmlForData(dati, "Telefono", telefono);
		createHtmlForData(dati, "Email Richiedente", emailrichiedente);
		createHtmlForData(dati, "Sede", sedeDescrizione);

		return dati.toString();
	}

	private String createSubjectEmail(String idRichiesta, String dipartimento, String ufficio, String testoOggetto) {
		StringBuilder subj = new StringBuilder();
		String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		subj.append(idRichiesta);
		subj.append("/");
		subj.append(year);
		subj.append("/");
		subj.append(dipartimento);
		subj.append("/");
		subj.append(ufficio);
		subj.append("/");
		subj.append(testoOggetto);
		return subj.toString();
	}

	private String getHtmlRichiesta(String oggetto, String data, String note, String costoTotale,
			List<DatiRichiestaBean> richieste, String motivazione) {
		StringBuilder dati = new StringBuilder();
		createHtmlForData(dati, "Oggetto", oggetto);
		createHtmlForData(dati, "Data inserimento", data);
		for (DatiRichiestaBean richiesta : richieste) {
			createHtmlForData(dati, "Quantit\u00E0", richiesta.getQuantita());
			createHtmlForData(dati, "Materiale", richiesta.getMaterialeDescrizione());
		}
		createHtmlForData(dati, "Costo Totale", costoTotale);
		createHtmlForData(dati, "Note", note);
		if (motivazione != null)
			createHtmlForData(dati, "Motivazione del rifiuto", motivazione);

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

	private String getDipartimentoFromUserLocation(User user) {

		String nomeDip = null;
		try {
			if ((user != null) && (user.getExpandoBridge() != null)
					&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						int livello = orgChart.getLevel();
						long direzioneId = orgChart.getIdParent();
						if (livello != 2) {
							OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil
									.getOrganizationChart(direzioneId);
							if (direzioneOrgChart != null) {
								int livelloDipartimento = direzioneOrgChart.getLevel();
								long dipartimentoId = direzioneOrgChart.getIdParent();
								if (livelloDipartimento != 2) {
									OrganizationChart dipartimentoOrgChart = OrganizationChartLocalServiceUtil
											.getOrganizationChart(dipartimentoId);
									nomeDip = dipartimentoOrgChart.getName();
								} else {
									nomeDip = direzioneOrgChart.getName();
								}
							}
						} else {
							nomeDip = orgChart.getName();
						}
					}
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user");

		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);

		}
		return nomeDip;
	}

	private String getDirezioneFromUfficioRichiedente(User user) {
		String direzione = null;
		try {

			if ((user != null) && (user.getExpandoBridge() != null)
					&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						int livello = orgChart.getLevel();
						long direzioneId = orgChart.getIdParent();
						if (livello == 3) {
							direzione = orgChart.getName();
						} else {
							OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil
									.getOrganizationChart(direzioneId);
							if (direzioneOrgChart != null) {
								direzione = direzioneOrgChart.getName();
							}
						}
					}
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user");

		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);
			return null;
		}
		return direzione;
	}

	private String getAcronimoDirezioneFromUfficioRichiedente(User user) {
		String direzione = null;
		try {

			if ((user != null) && (user.getExpandoBridge() != null)
					&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						int livello = orgChart.getLevel();
						long direzioneId = orgChart.getIdParent();
						if (livello == 3) {
							direzione = orgChart.getName();
						} else {
							OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil
									.getOrganizationChart(direzioneId);
							if (direzioneOrgChart != null) {
								direzione = direzioneOrgChart.getAcronimo();
							}
						}
					}
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user");

		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);
			return null;
		}
		return direzione;
	}

	private String getUfficioAcronimoFromUserLocation(User user) {
		String name = null;
		try {

			if ((user != null) && (user.getExpandoBridge() != null)
					&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						name = orgChart.getAcronimo();
					}
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user");

		} catch (Exception e) {
			_log.warn("error in retrieve user informations" + e);
			return null;
		}
		return name;
	}

	@ProcessAction(name = "ricercaRichieste")
	public void ricercaRichieste(ActionRequest actionRequest, ActionResponse actionResponse) {

		List<String> filtriRicercaRichieste = new ArrayList<String>();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<LocalRich> res_richiesteLocal = new ArrayList<LocalRich>(0);
		List<LocalRichInfo> res_richiesteInfoLocal = new ArrayList<LocalRichInfo>(0);
		List<Long> lista_stati = new ArrayList<>(0);
		List<String> lista_uff = new ArrayList<>(0);
		String nome_richiedente = null;
		String cogn_richiedente = null;

		String nomeDip = getDipartimentoFromUserLocation(themeDisplay.getUser());

		String approvazioneRGS = actionRequest.getPreferences().getValue("approvazioneRGS",
				_configuration.approvazioneRGS());
		String approvazioneDT = actionRequest.getPreferences().getValue("approvazioneDT",
				_configuration.approvazioneDT());
		String approvazioneDF = actionRequest.getPreferences().getValue("approvazioneDF",
				_configuration.approvazioneDF());
		String approvazioneDAG = actionRequest.getPreferences().getValue("approvazioneDAG",
				_configuration.approvazioneDAG());

		boolean approvazioneFlag = ("DIP. II - RGS".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneRGS))
				|| ("DIP. I - TESORO".equalsIgnoreCase(nomeDip) && "NO".equalsIgnoreCase(approvazioneDT))
				|| ("DIP. III - DIPARTIMENTO DELLE FINANZE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDF))
				|| ("DIP. IV - AMM. GEN. PERSONALE".equalsIgnoreCase(nomeDip)
						&& "NO".equalsIgnoreCase(approvazioneDAG));

		// recupero i parametri di ricerca dal form
		if (actionRequest.getParameter("cogn_richiedente") != null
				&& !"".equals(actionRequest.getParameter("cogn_richiedente"))) {
			cogn_richiedente = actionRequest.getParameter("cogn_richiedente");
			filtriRicercaRichieste.add(actionRequest.getParameter("cogn_richiedente"));
		}
		if (actionRequest.getParameter("nome_richiedente") != null
				&& !"".equals(actionRequest.getParameter("nome_richiedente"))) {
			nome_richiedente = actionRequest.getParameter("nome_richiedente");
			filtriRicercaRichieste.add(actionRequest.getParameter("nome_richiedente"));
		}
		if (actionRequest.getParameter("selectUff") != null && !"".equals(actionRequest.getParameter("selectUff"))) {
			lista_uff.add(actionRequest.getParameter("selectUff"));
			filtriRicercaRichieste.add(actionRequest.getParameter("selectUff"));
		} else {
			for (OrganizationChart org_uff : uffici_by_dirigente_list) {
				lista_uff.add(org_uff.getAcronimo());
			}
		}
		if (actionRequest.getParameterValues("stato_richiesta") != null
				&& actionRequest.getParameterValues("stato_richiesta").length > 0) {
			for (int i = 0; i < (actionRequest.getParameterValues("stato_richiesta")).length; i++) {
				String idStatoString = (String) actionRequest.getParameterValues("stato_richiesta")[i].toLowerCase();
				long idStatoLong = Long.parseLong(idStatoString.trim());
				lista_stati.add(idStatoLong);
			}
		}
		if (actionRequest.getParameter("arrayLabelStati") != null
				&& !"".equals(actionRequest.getParameter("arrayLabelStati"))) {
			String arrayStatiString = (String) actionRequest.getParameter("arrayLabelStati");
			String[] arrayStati = arrayStatiString.split(",");
			for (int i = 0; i < arrayStati.length; i++) {
				filtriRicercaRichieste.add(arrayStati[i]);
			}
		}
		// query su User
		List<User> res_utenti = null;

		UtenteUtil utenteUtil = new UtenteUtil();
		if ((cogn_richiedente != null && !"".equals(cogn_richiedente))
				|| (nome_richiedente != null && !"".equals(nome_richiedente))) {
			res_utenti = utenteUtil.findUser(cogn_richiedente, nome_richiedente);
		}
		boolean notinstage = Boolean.parseBoolean("0");
		if ((lista_stati.isEmpty() || lista_stati.contains(Long.parseLong(("7").trim()))
				|| lista_stati.contains(Long.parseLong(("8").trim()))) && approvazioneFlag == false) {
			// query su Richieste locali
			res_richiesteLocal = LocalRichLocalServiceUtil.findByfilters(lista_stati, lista_uff, res_utenti,
					notinstage);

			// query su Richieste Info locali
			res_richiesteInfoLocal = LocalRichInfoLocalServiceUtil.findByfilters(lista_stati, lista_uff, res_utenti,
					notinstage);

		}

		// query su Richieste
		List<Richieste> res_richieste = RichiesteLocalServiceUtil.findByfilters(lista_stati, lista_uff, res_utenti);
		// query su Richieste Info
		List<RichiesteInfo> res_richiesteInfo = RichiesteInfoLocalServiceUtil.findByfilters(lista_stati, lista_uff,
				res_utenti);

		List<RisultatoListaRichieste> listaRisultatiRichiesta = setListaRisultatoRichiesta(res_richieste,
				res_richiesteInfo, res_richiesteLocal, res_richiesteInfoLocal, themeDisplay);
		actionRequest.setAttribute("listarichieste", listaRisultatiRichiesta);
		actionRequest.setAttribute("navigation", "risultatiricercarichieste");
		actionRequest.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste);
	}

	private DatiRichiestaBean createDatiRichiesta(String json) {

		JSONObject obj = null;
		try {
			obj = JSONFactoryUtil.createJSONObject(json);
		} catch (JSONException e) {
			_log.info("cannot create JSON Object from String:" + e);
			return null;
		}
		DatiRichiestaBean datiRichiestaBean = new DatiRichiestaBean();
		String oggetto = obj.getString("oggetto");
		datiRichiestaBean.setOggetto(oggetto);
		String dataDiRichiesta = obj.getString("dataRichiesta");
		datiRichiestaBean.setDataRichiesta(dataDiRichiesta);
		String periodicita = obj.getString("periodicita");
		datiRichiestaBean.setPeriodicita(periodicita);
		String periodicitaDescrizione = obj.getString("periodicitaDescrizione");
		datiRichiestaBean.setPeriodicitaDescrizione(periodicitaDescrizione);
		String numeroInventarioMacchina = obj.getString("numeroInventarioMacchina");
		datiRichiestaBean.setNumeroInventarioMacchina(numeroInventarioMacchina);
		String tipoBeni = obj.getString("tipoBeni");
		datiRichiestaBean.setTipoBeni(tipoBeni);
		String descrizione = obj.getString("descrizione");
		datiRichiestaBean.setDescrizione(descrizione);
		String costoTotale = obj.getString("costoTotale");
		datiRichiestaBean.setCostoTotale(costoTotale);
		String organizzazione = obj.getString("organizzazione");
		datiRichiestaBean.setOrganizzazione(organizzazione);
		String sedeDescrizione = obj.getString("sedeDescrizione");
		datiRichiestaBean.setSedeDescrizione(sedeDescrizione);
		String sede = obj.getString("sede");
		datiRichiestaBean.setSede(sede);
		String codiceGeco = obj.getString("codiceGeco");
		datiRichiestaBean.setCodiceGeco(codiceGeco);
		return datiRichiestaBean;
	}

	private void populateStatoTable() {
		if (StatoLocalServiceUtil.getStatosCount() == 0) {

			List<String> stati = new ArrayList<>();
			stati.add("nuova");
			stati.add("accettata");
			stati.add("rifiutata");
			stati.add("evasa");
			stati.add("consegnata");
			stati.add("non evasa");
			stati.add("in approvazione");
			stati.add("non approvata");

			for (int i = 0; i < stati.size(); i++) {
				Stato stato = StatoLocalServiceUtil.createStato(i + 1);
				stato.setDescrizione(stati.get(i));
				StatoLocalServiceUtil.addStato(stato);
			}
		}

	}

	private void populatePeriodicitaTable() {
		if (PeriodicitaLocalServiceUtil.getPeriodicitasCount() == 0) {

			List<String> lista_periodicita = new ArrayList<>();
			lista_periodicita.add("mensile");
			lista_periodicita.add("straordinaria");
			for (int i = 0; i < lista_periodicita.size(); i++) {
				Periodicita periodicita = PeriodicitaLocalServiceUtil.createPeriodicita(i + 1);
				periodicita.setDescrizione(lista_periodicita.get(i));
				PeriodicitaLocalServiceUtil.addPeriodicita(periodicita);
			}
		}
	}

	private void populateServizioMaterialeTable() {
		if (ServizioMaterialeLocalServiceUtil.getServizioMaterialesCount() == 0) {

			List<ServizioMaterialeBean> lista_servizio_materiale_bean = new ArrayList<ServizioMaterialeBean>();
			ServizioMaterialeBean servizioMaterialeBean1 = new ServizioMaterialeBean("A",
					"cancelleria: materiale cartotecnico, etc.", "altro");
			ServizioMaterialeBean servizioMaterialeBean2 = new ServizioMaterialeBean("B",
					"stampati: modulistica varia, etc.", "altro");
			ServizioMaterialeBean servizioMaterialeBean3 = new ServizioMaterialeBean("C",
					"materiale di fotoriproduzione per stampanti, fotoripr. e fax", "altro");
			ServizioMaterialeBean servizioMaterialeBean4 = new ServizioMaterialeBean("D",
					"accessori per computers: dischi magnetici, CD-rom, etc.", "bene informatico");
			ServizioMaterialeBean servizioMaterialeBean5 = new ServizioMaterialeBean("E",
					"libri, pubblicazioni, riviste e materiale didattico", "altro");
			ServizioMaterialeBean servizioMaterialeBean6 = new ServizioMaterialeBean("F",
					"materiale elettrico e telefonico", "altro");
			ServizioMaterialeBean servizioMaterialeBean7 = new ServizioMaterialeBean("G",
					"vestiario: esclusi i magazzini di distribuzione", "altro");
			ServizioMaterialeBean servizioMaterialeBean8 = new ServizioMaterialeBean("H",
					"materiale fragile: oggetti di vetro, terracotta, etc.", "altro");
			ServizioMaterialeBean servizioMaterialeBean9 = new ServizioMaterialeBean("I",
					"materiale per servizi automobilistici e di officina", "altro");
			ServizioMaterialeBean servizioMaterialeBean10 = new ServizioMaterialeBean("L", "materiale per laboratori",
					"altro");
			ServizioMaterialeBean servizioMaterialeBean11 = new ServizioMaterialeBean("M",
					"materiale non classificabile: materiale igienico, etc.", "altro");
			ServizioMaterialeBean servizioMaterialeBean12 = new ServizioMaterialeBean("Z", "altro", "altro");
			lista_servizio_materiale_bean.add(servizioMaterialeBean1);
			lista_servizio_materiale_bean.add(servizioMaterialeBean2);
			lista_servizio_materiale_bean.add(servizioMaterialeBean3);
			lista_servizio_materiale_bean.add(servizioMaterialeBean4);
			lista_servizio_materiale_bean.add(servizioMaterialeBean5);
			lista_servizio_materiale_bean.add(servizioMaterialeBean6);
			lista_servizio_materiale_bean.add(servizioMaterialeBean7);
			lista_servizio_materiale_bean.add(servizioMaterialeBean8);
			lista_servizio_materiale_bean.add(servizioMaterialeBean9);
			lista_servizio_materiale_bean.add(servizioMaterialeBean10);
			lista_servizio_materiale_bean.add(servizioMaterialeBean11);
			lista_servizio_materiale_bean.add(servizioMaterialeBean12);

			for (ServizioMaterialeBean servizioMaterialeBean : lista_servizio_materiale_bean) {
				ServizioMateriale servizioMateriale = ServizioMaterialeLocalServiceUtil
						.createServizioMateriale(servizioMaterialeBean.getGruppo());
				servizioMateriale.setDescrizione(servizioMaterialeBean.getDescrizione());
				servizioMateriale.setCategoria(servizioMaterialeBean.getCategoria());
				ServizioMaterialeLocalServiceUtil.addServizioMateriale(servizioMateriale);
			}
		}
	}
}