package mef.richieste.beni.inventariati.portlet;

import mef.richieste.beni.inventariati.bean.ExcelBean;
import mef.richieste.beni.inventariati.bean.ModuloBeneInv;
import mef.richieste.beni.inventariati.bean.Utente;
import mef.richieste.beni.inventariati.util.EmailSender;

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
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import java.io.IOException;
import java.text.ParseException;
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
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import service.intranet.mef.model.BeneInvRichiesto;
import service.intranet.mef.model.RichiestaBeneInv;
import service.intranet.mef.model.StatoRichBeneInv;
import service.intranet.mef.model.TipoBeneInv;
import service.intranet.mef.service.BeneInvRichiestoLocalServiceUtil;
import service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil;
import service.intranet.mef.service.StatoRichBeneInvLocalServiceUtil;
import service.intranet.mef.service.TipoBeneInvLocalServiceUtil;
import mef.richieste.beni.inventariati.util.ExcelWriter;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=mef-richieste-beni-inventariati-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefRichiesteBeniInventariatiPortlet extends MVCPortlet {
	private SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
	private static final Log _log = LogFactoryUtil.getLog(MefRichiesteBeniInventariatiPortlet.class);

	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";
	private final String _roledirigente = "Dirigente";

	private Utente _utente = null;

	private boolean cdcBeniInv_personale;

	private boolean cdcBeniInv_tesoro;

	private boolean cdcBeniInv_finanze;

	private boolean cdcBeniInv_rgs;

	private boolean consegnatarioBeniInv_personale;

	private boolean consegnatarioBeniInv_tesoro;

	private boolean consegnatarioBeniInv_finanze;

	private boolean consegnatarioBeniInv_rgs;

	private boolean richiedenteBeniInv;

	private boolean cdcBeniInv;

	private boolean consegnatarioBeniInv;

	private User loginUser;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute(MefRichiesteBeniInventariatiConfig.class.getName(), _configuration);

		if (renderRequest.getParameter("richiestaId") != null) {
			renderRequest.setAttribute("navigation", "navigation");
			renderRequest.setAttribute("richiestaId", renderRequest.getParameter("richiestaId"));
		}

		List<TipoBeneInv> tipo_bene_list = TipoBeneInvLocalServiceUtil.getTipoBeneInvs(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		renderRequest.setAttribute("tipoBeneList", tipo_bene_list);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		loginUser = themeDisplay.getUser();
		long companyId = themeDisplay.getCompanyId();
		List<StatoRichBeneInv> stato_rich_bene_list = StatoRichBeneInvLocalServiceUtil
				.getStatoRichBeneInvs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("statoRichBeneList", stato_rich_bene_list);

		_utente = createRichiedente(loginUser, companyId);

		renderRequest.setAttribute("utente", _utente);

		richiedenteBeniInv = false;
		consegnatarioBeniInv_personale = false;
		consegnatarioBeniInv_tesoro = false;
		consegnatarioBeniInv_finanze = false;
		consegnatarioBeniInv_rgs = false;
		cdcBeniInv_personale = false;
		cdcBeniInv_finanze = false;
		cdcBeniInv_rgs = false;
		cdcBeniInv_tesoro = false;
		cdcBeniInv = false;
		consegnatarioBeniInv = false;

		List<String> ruoli_cdc = new ArrayList<>();

		List<String> ruoli_consegnatatrio = new ArrayList<>();

		for (Role ruolo : loginUser.getRoles()) {

			// check per ruoli richiedente e consegnatario
			if (("richiedenteBeniInv").equalsIgnoreCase(ruolo.getName())) {
				richiedenteBeniInv = true;

			}
			if (("consegnatarioBeniInv_personale").equalsIgnoreCase(ruolo.getName())) {
				consegnatarioBeniInv_personale = true;
				ruoli_consegnatatrio.add("consegnatarioBeniInv_personale");
			}
			if (("consegnatarioBeniInv_tesoro").equalsIgnoreCase(ruolo.getName())) {
				consegnatarioBeniInv_tesoro = true;
				ruoli_consegnatatrio.add("consegnatarioBeniInv_tesoro");
			}
			if (("consegnatarioBeniInv_finanze").equalsIgnoreCase(ruolo.getName())) {
				consegnatarioBeniInv_finanze = true;
				ruoli_consegnatatrio.add("consegnatarioBeniInv_finanze");
			}
			if (("consegnatarioBeniInv_rgs").equalsIgnoreCase(ruolo.getName())) {
				consegnatarioBeniInv_rgs = true;
				ruoli_consegnatatrio.add("consegnatarioBeniInv_rgs");
			}

			// check per ruoli cdc dei 4 dipartimenti
			if (("cdcBeniInv_personale").equals(ruolo.getName())) {
				cdcBeniInv_personale = true;
				ruoli_cdc.add("cdcBeniInv_personale");
			}
			if (("cdcBeniInv_rgs").equals(ruolo.getName())) {
				cdcBeniInv_rgs = true;
				ruoli_cdc.add("cdcBeniInv_rgs");
			}
			if (("cdcBeniInv_tesoro").equals(ruolo.getName())) {
				cdcBeniInv_tesoro = true;
				ruoli_cdc.add("cdcBeniInv_tesoro");
			}
			if (("cdcBeniInv_finanze").equals(ruolo.getName())) {
				cdcBeniInv_finanze = true;
				ruoli_cdc.add("cdcBeniInv_finanze");
			}

		}

		if (cdcBeniInv_personale || cdcBeniInv_finanze || cdcBeniInv_rgs || cdcBeniInv_tesoro) {
			cdcBeniInv = true;
		}
		if (consegnatarioBeniInv_personale || consegnatarioBeniInv_tesoro || consegnatarioBeniInv_finanze
				|| consegnatarioBeniInv_rgs) {
			consegnatarioBeniInv = true;
		}

		renderRequest.setAttribute("richiedenteRole", richiedenteBeniInv);
		renderRequest.setAttribute("consegnatarioRole", consegnatarioBeniInv);
		renderRequest.setAttribute("responsabileCDCRole", cdcBeniInv);

		List<RichiestaBeneInv> lista_default = new ArrayList<>();

		// lista default richiedente
		if (richiedenteBeniInv) {
			lista_default = RichiestaBeneInvLocalServiceUtil
					.getRichiesteByUtente(loginUser.getScreenName().toLowerCase());

		}

		// lista default consegnatarioRole
		else if (consegnatarioBeniInv && ruoli_consegnatatrio != null && !ruoli_consegnatatrio.isEmpty()) {
			List<String> dip = new ArrayList<>();
			List<RichiestaBeneInv> notSortedList = new ArrayList<>();
			for (String role_cons_item : ruoli_consegnatatrio) {
				dip.add(getDipartimentoByCdcConsRole(role_cons_item).toLowerCase());
			}
			for (String dipartimento : dip) {
				notSortedList.addAll(
						RichiestaBeneInvLocalServiceUtil.getRichiesteByDipartimento(dipartimento.toLowerCase()));
			}
			lista_default = sortRichiesteByDate(notSortedList);
		}

		// lista default cdcRole
		else if (cdcBeniInv && ruoli_cdc != null && !ruoli_cdc.isEmpty()) {
			String acq_richiesto = "acquisto richiesto";
			List<String> dip = new ArrayList<>();
			for (String role_cdc_item : ruoli_cdc) {
				dip.add(getDipartimentoByCdcConsRole(role_cdc_item).toLowerCase());
			}
			long id_stato = StatoRichBeneInvLocalServiceUtil.getStatoRichBeneByNomeStato(acq_richiesto.toLowerCase());
			lista_default = getRichiesteResponsabileCDC(dip, id_stato);
		}
		lista_default = this.clearNote_consegn(lista_default);
		renderRequest.setAttribute("lista_default", lista_default.toString());

		super.doView(renderRequest, renderResponse);
	}

	private String getDipartimentoByCdcConsRole(String cdcCons_role) {
		String tag_dip = cdcCons_role.split("_")[1];
		String dipartimento = null;
		List<OrganizationChart> lista = OrganizationChartLocalServiceUtil.getOrganizationCharts(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		for (OrganizationChart item : lista) {
			if (item.getName().startsWith("DIP. ")) {
				if (item.getName().contains(tag_dip.toUpperCase())) {
					dipartimento = item.getName();
				}
			}
		}
		return dipartimento;
	}

	public List<RichiestaBeneInv> getRichiesteResponsabileCDC(List<String> dip, long id_stato) {
		List<RichiestaBeneInv> richieste_responsabileCDC = RichiestaBeneInvLocalServiceUtil
				.getRichiesteByDipartimentoAndStato(dip, id_stato);
		List<RichiestaBeneInv> sortedList = sortRichiesteByDate(richieste_responsabileCDC);
		return sortedList;

	}

	public List<RichiestaBeneInv> sortRichiesteByDate(List<RichiestaBeneInv> lista) {
		List<RichiestaBeneInv> sortableListaRichieste = new ArrayList<>(lista);
		Collections.sort(sortableListaRichieste, new Comparator<RichiestaBeneInv>() {
			@Override
			public int compare(RichiestaBeneInv o1, RichiestaBeneInv o2) {

				if (o2.getData().before(o1.getData()) && o2.getId_richiesta() < o1.getId_richiesta()) {
					return -1;
				}
				if (o2.getData().equals(o1.getData()) && o2.getId_richiesta() < o1.getId_richiesta()) {

					return -1;
				}
				return 1;

			}

		});

		return sortableListaRichieste;
	}

	@ProcessAction(name = "vaiANuovaRichiesta")
	public void vaiANuovaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse) {

		String navigation = "home";
		actionRequest.setAttribute("navigation", navigation);

	}

	@ProcessAction(name = "duplicaRichiesta")
	public void duplicaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse) {
		String id_rich_duplica = actionRequest.getParameter("idRichiestaDuplica");
		actionRequest.setAttribute("idRichiestaDuplica", id_rich_duplica);
		String navigation = "home";
		actionRequest.setAttribute("navigation", navigation);

	}

	@ProcessAction(name = "riepilogoDati")
	public void riepilogoDati(ActionRequest actionRequest, ActionResponse actionResponse) throws JSONException {

		Utente richiedente = new Utente();
		richiedente.setUfficioRichiedente(actionRequest.getParameter("ufficioRichiedente"));
		richiedente.setNome(actionRequest.getParameter("nome"));
		richiedente.setCognome(actionRequest.getParameter("cognome"));
		richiedente.setDipartimento(actionRequest.getParameter("dipRichiedente"));
		richiedente.setUbicazione(actionRequest.getParameter("ubicazione"));
		richiedente.setPalazzina(actionRequest.getParameter("palazzina"));
		richiedente.setPiano(actionRequest.getParameter("piano"));
		richiedente.setScala(actionRequest.getParameter("scala"));
		richiedente.setStanza(actionRequest.getParameter("stanza"));
		richiedente.setTelefono(actionRequest.getParameter("telefono"));
		richiedente.setEmailDirigente(actionRequest.getParameter("emailDirigente"));

		String jsonRichiesta = actionRequest.getParameter("saverichiesta");
		JSONObject objRichiesta = JSONFactoryUtil.createJSONObject(jsonRichiesta);
		List<ModuloBeneInv> listaRichiesteBeniInv = jsontoData(jsonRichiesta);

		actionRequest.setAttribute("richiedenteRiepilogo", richiedente);
		actionRequest.setAttribute("userScreenName", actionRequest.getParameter("screenNameUtente"));
		actionRequest.setAttribute("oggetto", objRichiesta.getString("oggetto"));
		actionRequest.setAttribute("data", objRichiesta.getString("data"));
		actionRequest.setAttribute("nomeBenef", objRichiesta.getString("nomeBenef"));
		actionRequest.setAttribute("cognomeBenef", objRichiesta.getString("cognomeBenef"));
		actionRequest.setAttribute("emailBenef", objRichiesta.getString("emailBenef"));
		actionRequest.setAttribute("destinazione", objRichiesta.getString("destinazione"));
		actionRequest.setAttribute("listRichiesteBeniInv", listaRichiesteBeniInv);
		actionRequest.setAttribute("tipoNonInElenco", objRichiesta.getString("tipoNonInElenco"));
		actionRequest.setAttribute("descNonInElenco", objRichiesta.getString("descNonInElenco"));
		actionRequest.setAttribute("quantitaNonInElenco", objRichiesta.getString("quantitaNonInElenco"));
		actionRequest.setAttribute("dettagliNonInElenco", objRichiesta.getString("dettagliNonInElenco"));
		actionRequest.setAttribute("listarichiesteJson", jsonRichiesta);
		actionRequest.setAttribute("idRich", actionRequest.getParameter("idRich"));

		String navigation = "riepilogo";
		actionRequest.setAttribute("navigation", navigation);
	}

	private List<ModuloBeneInv> jsontoData(String json) throws JSONException {

		JSONObject obj = JSONFactoryUtil.createJSONObject(json);
		JSONArray arrayRichiesteBeniInv = JSONFactoryUtil.createJSONArray(obj.getString("richieste"));
		ModuloBeneInv elencoRichiesteBeniInv;
		List<ModuloBeneInv> listBeniInv = new ArrayList<ModuloBeneInv>();

		for (int i = 0; i < arrayRichiesteBeniInv.length(); i++) {

			elencoRichiesteBeniInv = new ModuloBeneInv();
			String tipologia = arrayRichiesteBeniInv.getJSONObject(i).getString("tipologia");

			if (!("").equals(tipologia)) {
				elencoRichiesteBeniInv.setTipologia(tipologia);
			}

			String bene = arrayRichiesteBeniInv.getJSONObject(i).getString("bene");

			if (!("").equals(bene)) {
				elencoRichiesteBeniInv.setBene(bene);
			}

			String quantita = arrayRichiesteBeniInv.getJSONObject(i).getString("quantita");
			if (!("0").equals(quantita)) {
				elencoRichiesteBeniInv.setQuantita(quantita);
			}

			String dettagli = arrayRichiesteBeniInv.getJSONObject(i).getString("dettagli");

			elencoRichiesteBeniInv.setDettagli(dettagli);

			if (!("").equals(tipologia) && !("").equals(quantita)) {
				listBeniInv.add(elencoRichiesteBeniInv);
			}

		}

		return listBeniInv;

	}

	@ProcessAction(name = "insertBeneInv")
	public void insertBeneInv(ActionRequest actionRequest, ActionResponse actionResponse) {

		// set Utente bean
		Utente utente = new Utente();
		utente.setUfficioRichiedente(actionRequest.getParameter("ufficioRichiedente"));
		utente.setNome(actionRequest.getParameter("nome"));
		utente.setCognome(actionRequest.getParameter("cognome"));
		utente.setUbicazione(actionRequest.getParameter("ubicazione"));
		utente.setPalazzina(actionRequest.getParameter("palazzina"));
		utente.setPiano(actionRequest.getParameter("piano"));
		utente.setScala(actionRequest.getParameter("scala"));
		utente.setStanza(actionRequest.getParameter("stanza"));
		utente.setTelefono(actionRequest.getParameter("telefono"));
		utente.setEmailDirigente(actionRequest.getParameter("emailDirigente"));

		// set RichiestaBeneInv table
		String richieste = actionRequest.getParameter("richiesteJson");

		long idRich = Long.parseLong(actionRequest.getParameter("idRichiesta"));

		RichiestaBeneInv richiestaBeneInv;
		try {
			richiestaBeneInv = RichiestaBeneInvLocalServiceUtil.getRichiestaBeneInv(idRich);

			richiestaBeneInv.setUtente(actionRequest.getParameter("screenNameUtente").toLowerCase());
			richiestaBeneInv.setNome_rich(actionRequest.getParameter("nome").toLowerCase());
			richiestaBeneInv.setCogn_rich(actionRequest.getParameter("cognome").toLowerCase());
			richiestaBeneInv.setDip_dir(actionRequest.getParameter("dipRichiedente").toLowerCase());

			JSONObject jsonRichiedente = JSONFactoryUtil.createJSONObject();
			jsonRichiedente.put("ufficioRichiedente", actionRequest.getParameter("ufficioRichiedente"));
			jsonRichiedente.put("ubicazione", actionRequest.getParameter("ubicazione"));
			jsonRichiedente.put("palazzina", actionRequest.getParameter("palazzina"));
			jsonRichiedente.put("piano", actionRequest.getParameter("piano"));
			jsonRichiedente.put("scala", actionRequest.getParameter("scala"));
			jsonRichiedente.put("stanza", actionRequest.getParameter("stanza"));
			jsonRichiedente.put("telefono", actionRequest.getParameter("telefono"));
			jsonRichiedente.put("emailDirigente", actionRequest.getParameter("emailDirigente"));

			richiestaBeneInv.setDati_rich(jsonRichiedente.toString());

			JSONObject jsonDatiRichiesta = JSONFactoryUtil.createJSONObject(richieste);
			richiestaBeneInv.setOggetto(jsonDatiRichiesta.getString("oggetto").toLowerCase());

			Date richiestaDate = sdfDate.parse(jsonDatiRichiesta.getString("data"));
			richiestaBeneInv.setData(richiestaDate);

			JSONObject jsonBeneficiario = JSONFactoryUtil.createJSONObject();
			jsonBeneficiario.put("nomeBenef", jsonDatiRichiesta.getString("nomeBenef"));
			jsonBeneficiario.put("cognomeBenef", jsonDatiRichiesta.getString("cognomeBenef"));
			jsonBeneficiario.put("emailBenef", jsonDatiRichiesta.getString("emailBenef"));
			richiestaBeneInv.setBeneficiario(jsonBeneficiario.toString());

			richiestaBeneInv.setDestinazione(jsonDatiRichiesta.getString("destinazione"));

			String statoInsertNuovaRich = "nuova";

			richiestaBeneInv
					.setId_stato(StatoRichBeneInvLocalServiceUtil.getStatoRichBeneByNomeStato(statoInsertNuovaRich));

			RichiestaBeneInvLocalServiceUtil.updateRichiestaBeneInv(richiestaBeneInv);

			// set tabella BeneInvRichiesto

			BeneInvRichiesto beneInvRichiestoInElenco = null;
			BeneInvRichiesto beneInvRichiestoNonElenco = null;
			JSONArray jsonRichiesteBeniInv = JSONFactoryUtil.createJSONArray(jsonDatiRichiesta.getString("richieste"));
			for (int i = 0; i < jsonRichiesteBeniInv.length(); i++) {
				JSONObject jsonBeneInv = JSONFactoryUtil.createJSONObject(jsonRichiesteBeniInv.get(i).toString());
				beneInvRichiestoInElenco = BeneInvRichiestoLocalServiceUtil.insertBeneInvRichiesto(
						jsonBeneInv.getString("tipologia").toLowerCase(), jsonBeneInv.getString("bene").toLowerCase(),
						Integer.parseInt(jsonBeneInv.getString("quantita")),
						jsonBeneInv.getString("dettagli").toLowerCase(), true, idRich);
			}

			if (jsonDatiRichiesta.getString("tipoNonInElenco") != null
					&& !("").equals((jsonDatiRichiesta.getString("tipoNonInElenco")))) {

				beneInvRichiestoNonElenco = BeneInvRichiestoLocalServiceUtil.insertBeneInvRichiesto(
						jsonDatiRichiesta.getString("tipoNonInElenco").toLowerCase(),
						jsonDatiRichiesta.getString("descNonInElenco").toLowerCase(),
						Integer.parseInt(jsonDatiRichiesta.getString("quantitaNonInElenco")),
						jsonDatiRichiesta.getString("dettagliNonInElenco").toLowerCase(), false, idRich);
			}

			// send email

			// prepare data
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter("richiestaId", Long.toString(richiestaBeneInv.getPrimaryKey()));
			renderUrl.setParameter("navigation", "linkdettaglio");
			String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl",
					_configuration.nuovaRichiestaTmpl());

			String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
			String sender = actionRequest.getPreferences().getValue("sender", _configuration.nuovaRichiestaSender());
			String subject = actionRequest.getPreferences().getValue("subject", _configuration.nuovaRichiestaSubject());
			String datirichiedente = getHtmlRichiedente(utente);
			String datibeneficiario = getHtmlBeneficiario(jsonDatiRichiesta.getString("nomeBenef"),
					jsonDatiRichiesta.getString("cognomeBenef"), jsonDatiRichiesta.getString("emailBenef"));
			String datirichiesta = getHtmlRichiesta(jsonDatiRichiesta.getString("oggetto"), richiestaDate,
					jsonDatiRichiesta.getString("destinazione"), jsontoData(richieste),
					jsonDatiRichiesta.getString("tipoNonInElenco"), jsonDatiRichiesta.getString("descNonInElenco"),
					jsonDatiRichiesta.getString("quantitaNonInElenco"),
					jsonDatiRichiesta.getString("dettagliNonInElenco"));
			mailbody = StringUtil.replace(mailbody,
					new String[] { "[$DATIRICHIEDENTE$]", "[$DATIBENEFICIARIO$]", "[$DATI$]", "[$LINK$]" },
					new String[] { datirichiedente, datibeneficiario, datirichiesta, renderUrl.toString() });
			EmailSender mail = new EmailSender();

			// get consegnatario and cdc roles

			String dipartimentoName = _utente.getDipartimento().toUpperCase();
			String cdc_role = null;
			String consegnatario_role = null;

			switch (dipartimentoName) {
			case "DIP. II - RGS":
				cdc_role = "cdcBeniInv_rgs";
				consegnatario_role = "consegnatarioBeniInv_rgs";
				break;
			case "DIP. I - TESORO":
				cdc_role = "cdcBeniInv_tesoro";
				consegnatario_role = "consegnatarioBeniInv_tesoro";
				break;
			case "DIP. III - DIPARTIMENTO DELLE FINANZE":
				cdc_role = "cdcBeniInv_finanze";
				consegnatario_role = "consegnatarioBeniInv_finanze";
				break;
			case "DIP. IV - AMM. GEN. PERSONALE":
				cdc_role = "cdcBeniInv_personale";
				consegnatario_role = "consegnatarioBeniInv_personale";
				break;

			default:
				_log.error("Nessun dipartimento");
				break;
			}

			Long currentCdcRoleId = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), cdc_role).getRoleId();
			Long currentConsRoleId = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), consegnatario_role)
					.getRoleId();

			List<User> cdc_list = UserLocalServiceUtil.getRoleUsers(currentCdcRoleId);
			List<User> consegnatario_list = UserLocalServiceUtil.getRoleUsers(currentConsRoleId);

			// send email to all users consegnatari and cdc in department +
			// richiedente + beneficiario

			if (beneInvRichiestoInElenco != null || beneInvRichiestoNonElenco != null) {
				for (User u_cons : consegnatario_list) {
					mail.sendMailMessageOneReceiver(subject, mailbody, sender, smtpUser, u_cons.getEmailAddress());
				}
				for (User u_cdc : cdc_list) {
					mail.sendMailMessageOneReceiver(subject, mailbody, sender, smtpUser, u_cdc.getEmailAddress());
				}
				mail.sendMailMessageOneReceiver(subject, mailbody, sender, smtpUser,
						themeDisplay.getUser().getEmailAddress());
				mail.sendMailMessageOneReceiver(subject, mailbody, sender, smtpUser,
						jsonDatiRichiesta.getString("emailBenef"));

				PortletURL renderUrlNew = PortletURLFactoryUtil.create(actionRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrlNew.setParameter("richiestaId", String.valueOf(richiestaBeneInv.getId_richiesta()));
				actionResponse.sendRedirect(renderUrlNew.toString());

			} else {
				throw new BeniInventariatiException("inserimento non riuscito");
			}
		} catch (Exception e) {
			_log.warn(e);
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionErrors.add(actionRequest, "");
		}
	}

	@ProcessAction(name = "newRichiestaBeneInv")
	public void newRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, Exception {

		long idRich = Long.parseLong(actionRequest.getParameter("idRichiesta"));
		RichiestaBeneInvLocalServiceUtil.deleteRichiestaBeneInv(idRich);

		String navigation = "home";
		actionRequest.setAttribute("navigation", navigation);
	}

	@ProcessAction(name = "vaiARicerca")
	public void vaiARicerca(ActionRequest actionRequest, ActionResponse actionResponse) {

		String navigation = "vaiARicerca";
		actionRequest.setAttribute("navigation", navigation);
	}

	@ProcessAction(name = "modificaDati")
	public void modificaDati(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		Utente richiedente = new Utente();
		richiedente.setUfficioRichiedente(actionRequest.getParameter("ufficioRichiedente"));
		richiedente.setNome(actionRequest.getParameter("nome"));
		richiedente.setCognome(actionRequest.getParameter("cognome"));
		richiedente.setUbicazione(actionRequest.getParameter("ubicazione"));
		richiedente.setPalazzina(actionRequest.getParameter("palazzina"));
		richiedente.setPiano(actionRequest.getParameter("piano"));
		richiedente.setScala(actionRequest.getParameter("scala"));
		richiedente.setStanza(actionRequest.getParameter("stanza"));
		richiedente.setTelefono(actionRequest.getParameter("telefono"));
		richiedente.setEmailDirigente(actionRequest.getParameter("emailDirigente"));

		String richieste = actionRequest.getParameter("richiesteJson");
		List<ModuloBeneInv> listaRichiesteBeniInv = jsontoData(richieste);

		int itemsBeniInv = listaRichiesteBeniInv.size();

		actionRequest.setAttribute("richiedenteModifica", richiedente);
		actionRequest.setAttribute("oggetto", actionRequest.getParameter("oggetto"));
		actionRequest.setAttribute("nomeBenef", actionRequest.getParameter("nomeBenef"));
		actionRequest.setAttribute("cognomeBenef", actionRequest.getParameter("cognomeBenef"));
		actionRequest.setAttribute("emailBenef", actionRequest.getParameter("emailBenef"));
		actionRequest.setAttribute("destinazione", actionRequest.getParameter("destinazione"));
		actionRequest.setAttribute("listRichiesteBeniInv", listaRichiesteBeniInv);
		actionRequest.setAttribute("itemsBeniInv", itemsBeniInv);
		actionRequest.setAttribute("tipoNonInElenco", actionRequest.getParameter("tipoNonInElenco"));
		actionRequest.setAttribute("descNonInElenco", actionRequest.getParameter("descNonInElenco"));
		actionRequest.setAttribute("quantitaNonInElenco", actionRequest.getParameter("quantitaNonInElenco"));
		actionRequest.setAttribute("dettagliNonInElenco", actionRequest.getParameter("dettagliNonInElenco"));

		long idRich = Long.parseLong(actionRequest.getParameter("idRichiesta"));
		RichiestaBeneInvLocalServiceUtil.deleteRichiestaBeneInv(idRich);

		String navigation = "home";
		actionRequest.setAttribute("navigation", navigation);

	}

	@ProcessAction(name = "ricercaRichieste")
	public void ricercaRichieste(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException {

		List<String> filtriRicercaRichieste = new ArrayList<String>();

		// recupero parametri ricerca da form
		long id_richiesta = 0;
		if (!("").equals(actionRequest.getParameter("idRichiesta"))) {
			id_richiesta = Long.parseLong(actionRequest.getParameter("idRichiesta"));
			filtriRicercaRichieste.add(actionRequest.getParameter("idRichiesta"));
		}

		Date data_richiesta = null;
		if (!("").equals(actionRequest.getParameter("date-deadline"))) {
			data_richiesta = sdfDate.parse(actionRequest.getParameter("date-deadline"));
			filtriRicercaRichieste.add(actionRequest.getParameter("date-deadline"));
		}

		String nome_rich = null;
		if (actionRequest.getParameter("nomeRichiedente") != null
				&& !("").equals(actionRequest.getParameter("nomeRichiedente"))) {
			nome_rich = actionRequest.getParameter("nomeRichiedente").toLowerCase();
			filtriRicercaRichieste.add(actionRequest.getParameter("nomeRichiedente"));
		}

		String cogn_rich = null;
		if (actionRequest.getParameter("cognomeRichiedente") != null
				&& !("").equals(actionRequest.getParameter("cognomeRichiedente"))) {
			cogn_rich = actionRequest.getParameter("cognomeRichiedente").toLowerCase();
			filtriRicercaRichieste.add(actionRequest.getParameter("cognomeRichiedente"));
		}

		List<String> lista_dipartimenti = new ArrayList<>();

		if ((cdcBeniInv_finanze || cdcBeniInv_personale || cdcBeniInv_rgs || cdcBeniInv_tesoro)) {
			List<String> dipartimentiCDC = new ArrayList<>(0);
			if (cdcBeniInv_finanze && getDipartimentoByCdcConsRole("cdcBeniInv_finanze") != null
					&& !("").equals(getDipartimentoByCdcConsRole("cdcBeniInv_finanze"))) {
				dipartimentiCDC.add(getDipartimentoByCdcConsRole("cdcBeniInv_finanze").toLowerCase());
			}
			if (cdcBeniInv_personale && getDipartimentoByCdcConsRole("cdcBeniInv_personale") != null
					&& !("").equals(getDipartimentoByCdcConsRole("cdcBeniInv_personale"))) {
				dipartimentiCDC.add(getDipartimentoByCdcConsRole("cdcBeniInv_personale").toLowerCase());
			}
			if (cdcBeniInv_rgs && getDipartimentoByCdcConsRole("cdcBeniInv_rgs") != null
					&& !("").equals(getDipartimentoByCdcConsRole("cdcBeniInv_rgs"))) {
				dipartimentiCDC.add(getDipartimentoByCdcConsRole("cdcBeniInv_rgs").toLowerCase());
			}
			if (cdcBeniInv_tesoro && getDipartimentoByCdcConsRole("cdcBeniInv_tesoro") != null
					&& !("").equals(getDipartimentoByCdcConsRole("cdcBeniInv_tesoro"))) {
				dipartimentiCDC.add(getDipartimentoByCdcConsRole("cdcBeniInv_tesoro").toLowerCase());
			}

			if (actionRequest.getParameter("dipartimento") != null
					&& !("").equals(actionRequest.getParameter("dipartimento"))) {

				if (dipartimentiCDC.contains(actionRequest.getParameter("dipartimento").toLowerCase())) {
					lista_dipartimenti.add(actionRequest.getParameter("dipartimento").toLowerCase());
				} else {
					lista_dipartimenti.add("null");

				}
				filtriRicercaRichieste.add(actionRequest.getParameter("dipartimento"));
			} else {
				lista_dipartimenti.addAll(dipartimentiCDC);
			}
		}

		if (consegnatarioBeniInv_finanze && getDipartimentoByCdcConsRole("consegnatarioBeniInv_finanze") != null
				&& !("").equals(getDipartimentoByCdcConsRole("consegnatarioBeniInv_finanze"))) {
			lista_dipartimenti.add(getDipartimentoByCdcConsRole("consegnatarioBeniInv_finanze").toLowerCase());
		}
		if (consegnatarioBeniInv_personale && getDipartimentoByCdcConsRole("consegnatarioBeniInv_personale") != null
				&& !("").equals(getDipartimentoByCdcConsRole("consegnatarioBeniInv_personale"))) {
			lista_dipartimenti.add(getDipartimentoByCdcConsRole("consegnatarioBeniInv_personale").toLowerCase());
		}
		if (consegnatarioBeniInv_rgs && getDipartimentoByCdcConsRole("consegnatarioBeniInv_rgs") != null
				&& !("").equals(getDipartimentoByCdcConsRole("consegnatarioBeniInv_rgs"))) {
			lista_dipartimenti.add(getDipartimentoByCdcConsRole("consegnatarioBeniInv_rgs").toLowerCase());
		}
		if (consegnatarioBeniInv_tesoro && getDipartimentoByCdcConsRole("consegnatarioBeniInv_tesoro") != null
				&& !("").equals(getDipartimentoByCdcConsRole("consegnatarioBeniInv_tesoro"))) {
			lista_dipartimenti.add(getDipartimentoByCdcConsRole("consegnatarioBeniInv_tesoro").toLowerCase());
		}

		String tipologia = null;
		boolean in_elenco = true;
		if ((actionRequest.getParameter("check") != null)) {
			in_elenco = false;
			String fuori_contesto = "fuori contesto";
			filtriRicercaRichieste.add(fuori_contesto.toUpperCase());
		} else {
			if (!("").equals(actionRequest.getParameter("tipologia"))) {
				tipologia = actionRequest.getParameter("tipologia").toLowerCase();
				filtriRicercaRichieste.add(actionRequest.getParameter("tipologia"));
			}
		}

		List<Long> lista_stati = new ArrayList<>();

		if (actionRequest.getParameterValues("stato_richiesta") != null
				&& actionRequest.getParameterValues("stato_richiesta").length > 0) {
			for (int i = 0; i < (actionRequest.getParameterValues("stato_richiesta")).length; i++) {
				String idStatoString = (String) actionRequest.getParameterValues("stato_richiesta")[i].toLowerCase();
				long idStatoLong = Long.parseLong(idStatoString.trim());
				lista_stati.add(idStatoLong);
			}
			if (actionRequest.getParameter("arrayLabelStati") != null) {
				String arrayStatiString = (String) actionRequest.getParameter("arrayLabelStati");
				String[] arrayStati = arrayStatiString.split(",");
				for (int i = 0; i < arrayStati.length; i++) {
					filtriRicercaRichieste.add(arrayStati[i]);
				}
			}
		}

		if ((cdcBeniInv_finanze || cdcBeniInv_personale || cdcBeniInv_rgs || cdcBeniInv_tesoro)
				&& actionRequest.getParameterValues("stato_richiesta") == null) {

			String acq_richiesto = "acquisto richiesto";
			String acq_autorizzato = "acquisto autorizzato";
			String acq_respinto = "acquisto respinto";

			long id_stato_richiesto = StatoRichBeneInvLocalServiceUtil
					.getStatoRichBeneByNomeStato(acq_richiesto.toLowerCase());
			long id_stato_autorizzato = StatoRichBeneInvLocalServiceUtil
					.getStatoRichBeneByNomeStato(acq_autorizzato.toLowerCase());
			long id_stato_respinto = StatoRichBeneInvLocalServiceUtil
					.getStatoRichBeneByNomeStato(acq_respinto.toLowerCase());

			lista_stati.add(id_stato_richiesto);
			lista_stati.add(id_stato_autorizzato);
			lista_stati.add(id_stato_respinto);

		}

		List<RichiestaBeneInv> res = new ArrayList<>(0);

		if (richiedenteBeniInv) {
			String screenName = loginUser.getScreenName();
			res = RichiestaBeneInvLocalServiceUtil.getRichiesteBeniInvByFiltersRichiedente(id_richiesta, screenName,
					data_richiesta, lista_stati, tipologia, in_elenco);

		} else {

			for (String dip : lista_dipartimenti) {
				res.addAll(RichiestaBeneInvLocalServiceUtil.getRichiesteBeniInvByFilters(id_richiesta, nome_rich,
						cogn_rich, data_richiesta, dip, lista_stati, tipologia, in_elenco));
			}

		}

		List<RichiestaBeneInv> sortableResults = new ArrayList<>(res);
		Collections.sort(sortableResults, new Comparator<RichiestaBeneInv>() {
			@Override
			public int compare(RichiestaBeneInv o1, RichiestaBeneInv o2) {
				if (o2.getData().before(o1.getData()))
					return -1;
				return 1;
			}
		});

		actionRequest.setAttribute("jsonRisultati", clearNote_consegn(sortableResults).toString());
		actionRequest.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste);
		actionRequest.setAttribute("navigation", "vaiARicerca");

	}

	@ProcessAction(name = "vaiADettaglio")
	public void vaiADettaglio(ActionRequest actionRequest, ActionResponse actionResponse) {
		String id_rich = actionRequest.getParameter("id_rich");
		String navigation = "vaiADettaglio";
		actionRequest.setAttribute("richiestaId", id_rich);
		actionRequest.setAttribute("navigation", navigation);

	}

	private Utente createStubUtente() {

		Utente utente = new Utente();
		utente.setNome("");
		utente.setCognome("");
		utente.setUfficioRichiedente("");
		utente.setUbicazione("");
		utente.setPalazzina("");
		utente.setPiano("");
		utente.setScala("");
		utente.setStanza("");
		utente.setTelefono("");
		utente.setEmailDirigente("");
		utente.setEmailPersonale("");
		utente.setDipartimento("");

		return utente;

	}

	private Utente createRichiedente(User user, long companyId) {

		Utente utente = createStubUtente();
		try {
			if (user != null) {
				utente.setDipartimento(getDipartimentoFromUserLocation(user, companyId));
				utente.setEmailPersonale(user.getEmailAddress());

				utente.setNome(user.getFirstName());
				utente.setCognome(user.getLastName());

				utente.setPalazzina("");

				List<Address> listaIndirizzi = user.getAddresses();
				List<Phone> listaPhones = user.getPhones();

				if (listaIndirizzi != null && !listaIndirizzi.isEmpty()) {
					for (Address addressItem : listaIndirizzi) {
						if (("Business").equalsIgnoreCase(addressItem.getType().getName())) {
							utente.setPiano(addressItem.getStreet1());
							utente.setStanza(addressItem.getStreet2());
							utente.setScala(addressItem.getStreet3());
							break;
						}
					}
				}

				if (listaPhones != null && !listaPhones.isEmpty()) {
					for (Phone phoneItem : listaPhones) {
						if (("Business").equalsIgnoreCase(phoneItem.getType().getName())) {
							utente.setTelefono(phoneItem.getNumber());
							break;
						}
					}
				}

				boolean customField = false;

				if ((user != null) && (user.getExpandoBridge() != null)
						&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
					String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);

					// andare in tabella organigramma e tramite l'organzationId
					// ricavare il name (nome ufficio richiedente)
					if (organizationId != null && organizationId != "") {
						Long idChart = Long.parseLong(organizationId);
						OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);

						if (orgChart != null) {
							long locationId = orgChart.getLocationId();

							List<Location> locationlist = CentralInvokerLocalServiceUtil.findLocationById(locationId);

							if (locationlist != null && !locationlist.isEmpty()) {
								utente.setUbicazione(locationlist.get(0).getName());
							}

							utente.setUfficioRichiedente(orgChart.getName());

						}
					}

				} else {
					customField = true;
				}

				if ((user.getExpandoBridge() != null)
						&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)
						&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != "")) {
					String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
					User cuser = getUsertByCustomField(companyId, _customFieldUserPersonal, directorId);
					if (cuser != null) {
						utente.setEmailDirigente(cuser.getEmailAddress());
					}

				} else {

					throw new BeniInventariatiException(_customFieldUserDirector + " not defined for the user");
				}

				if (customField) {
					throw new BeniInventariatiException(_customFieldUserDirector + " not defined for the user");
				}
			}
		} catch (Exception e) {
			_log.warn(e);

		}
		return utente;
	}

	// get user fieldName = _customFieldUserPersonal fieldValue=directorId
	private User getUsertByCustomField(long companyId, String fieldName, String fieldValue) throws PortalException {

		List<ExpandoValue> values = ExpandoValueLocalServiceUtil.getColumnValues(companyId, User.class.getName(),
				ExpandoTableConstants.DEFAULT_TABLE_NAME, fieldName, fieldValue, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ExpandoValue value : values) {
			User user = UserLocalServiceUtil.getUser(value.getClassPK());
			return user;
		}

		return null;
	}

	private String getDipartimentoFromUserLocation(User user, long companyId) {

		String nomeDip = "";

		try {
			if (user != null) {

				if ((user.getExpandoBridge() != null)
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
					throw new BeniInventariatiException(
							_customFieldUserOrg + " not defined for this user: " + user.getFullName());

			} else
				throw new BeniInventariatiException("User is not defined");

		} catch (Exception e) {
			_log.warn(e);

			nomeDip = "";

		}

		return nomeDip;

	}

	public Utente richiedenteJsontoData(String json) throws JSONException {
		Utente richiedente = new Utente();
		JSONObject obj = JSONFactoryUtil.createJSONObject(json);
		richiedente.setCognome(obj.getString("cognome"));
		richiedente.setEmailDirigente(obj.getString("emailDirigente"));
		richiedente.setNome(obj.getString("nome"));
		richiedente.setPalazzina(obj.getString("palazzina"));
		richiedente.setPiano(obj.getString("piano"));
		richiedente.setScala(obj.getString("scala"));
		richiedente.setStanza(obj.getString("stanza"));
		richiedente.setTelefono(obj.getString("telefono"));
		richiedente.setUbicazione(obj.getString("ubicazione"));
		richiedente.setUfficioRichiedente(obj.getString("ufficioRichiedente"));
		return richiedente;

	}

	/*
	 * The serveResource method is used to download excel. The excel is created
	 * by calling a writeRichiesteExcel.
	 **/
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String json = resourceRequest.getParameter("json");

		JSONArray arrayRicerca;

		List<ExcelBean> excelList = new ArrayList<ExcelBean>(0);
		ExcelBean beanExcel;
		try {
			arrayRicerca = JSONFactoryUtil.createJSONArray(json);
			int sizeArray = arrayRicerca.length();

			for (int i = 0; i < sizeArray; i++) {

				beanExcel = new ExcelBean();

				String id_richiesta = arrayRicerca.getJSONObject(i).getString("id_richiesta");

				beanExcel.setId_richiesta(id_richiesta);

				String nome_richiedente = arrayRicerca.getJSONObject(i).getString("nome_rich");

				beanExcel.setNome_richiedente(HtmlUtil.extractText(nome_richiedente));

				String cognome_richiedente = arrayRicerca.getJSONObject(i).getString("cogn_rich");

				beanExcel.setCognome_richiedente(HtmlUtil.extractText(cognome_richiedente));

				String oggetto = arrayRicerca.getJSONObject(i).getString("oggetto");

				beanExcel.setOggetto(HtmlUtil.extractText(oggetto));

				String data = arrayRicerca.getJSONObject(i).getString("data");

				beanExcel.setData(data);

				String statoJson = arrayRicerca.getJSONObject(i).getString("id_stato");

				Long statoIdJson = Long.parseLong(statoJson);

				List<StatoRichBeneInv> statoList = (List<StatoRichBeneInv>) StatoRichBeneInvLocalServiceUtil
						.getStatoRichBeneInvs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				String stato = null;
				for (StatoRichBeneInv statoRichBeneInv : statoList) {

					if (statoRichBeneInv.getId() == statoIdJson) {
						stato = statoRichBeneInv.getStato();

					}

				}

				beanExcel.setStato(stato);

				excelList.add(beanExcel);

			}
		} catch (JSONException e) {
			_log.warn(e);
		}

		resourceResponse.setContentType("application/vnd.ms-excel");
		resourceResponse.setProperty("Content-Disposition",
				("attachment; ") + "filename=" + "Richiesta excel" + ".xls");

		ExcelWriter.writeRichiesteExcel(excelList, resourceResponse);

	}

	private StringBuilder getcategoryHtmlRichiesta(StringBuilder dati, List<ModuloBeneInv> lista) {
		for (ModuloBeneInv item : lista) {
			item.getTipologia();
			item.getBene();
			item.getQuantita();
			item.getDettagli();
			dati.append("<p>");
			dati.append("<b>Tipologia:</b>");
			dati.append(" ");
			dati.append(item.getTipologia().toUpperCase());
			dati.append(" ");
			dati.append("<b>Bene:</b>");
			dati.append(" ");
			dati.append(item.getBene().toUpperCase());
			dati.append(" ");
			dati.append("<b>Quantit&agrave;:</b>");
			dati.append(" ");
			dati.append(item.getQuantita());
			dati.append(" ");
			dati.append("<b>Dettagli:</b>");
			dati.append(" ");
			dati.append(item.getDettagli());
			dati.append("</p>");
			dati.append("</br>");

		}
		return dati;
	}

	private String getHtmlBeneficiario(String nomeBenef, String cognomeBenef, String emailBenef) {
		StringBuilder dati = new StringBuilder();
		createHtmlForData(dati, "Nome Beneficiario", nomeBenef.toUpperCase());
		createHtmlForData(dati, "Cognome Beneficiario", cognomeBenef.toUpperCase());
		createHtmlForData(dati, "Email Beneficiario", emailBenef);
		return dati.toString();
	}

	private String getHtmlRichiedente(Utente richiedente) {
		StringBuilder dati = new StringBuilder();
		if (richiedente != null) {
			createHtmlForData(dati, "Ufficio Richiedente", richiedente.getUfficioRichiedente().toUpperCase());
			createHtmlForData(dati, "Nome Richiedente", richiedente.getNome().toUpperCase());
			createHtmlForData(dati, "Cognome Richiedente", richiedente.getCognome().toUpperCase());
			createHtmlForData(dati, "Ubicazione Attuale", richiedente.getUbicazione().toUpperCase());
			createHtmlForData(dati, "Palazzina", richiedente.getPalazzina().toUpperCase());
			createHtmlForData(dati, "Piano", richiedente.getPiano().toUpperCase());
			createHtmlForData(dati, "Scala", richiedente.getScala().toUpperCase());
			createHtmlForData(dati, "Stanza", richiedente.getStanza().toUpperCase());
			createHtmlForData(dati, "Telefono", richiedente.getTelefono().toUpperCase());
			createHtmlForData(dati, "Email Dirigente", richiedente.getEmailDirigente());
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

	private String getHtmlRichiesta(String oggetto, Date data, String destinazione, List<ModuloBeneInv> richieste,
			String tipoNonInElenco, String descNonInElenco, String quantitaNonInElenco, String dettagliNonInElenco) {
		StringBuilder dati = new StringBuilder();
		createHtmlForData(dati, "Oggetto", oggetto.toUpperCase());
		createHtmlForData(dati, "Data inserimento", new SimpleDateFormat("dd-MM-yyyy").format(data));
		createHtmlForData(dati, "Destinazione", destinazione.toUpperCase());
		if (!richieste.isEmpty()) {
			dati.append("<p><b>Beni richiesti (in elenco):</b></p>");
			dati.append("</br>");
			getcategoryHtmlRichiesta(dati, richieste);
		}
		if (tipoNonInElenco != null && !(("").equals(tipoNonInElenco))) {
			dati.append("<p><b>Beni richiesti (non in elenco):</b></p>");
			dati.append("</br>");
			dati.append("<p>");
			dati.append("<b>Tipologia:</b>");
			dati.append(" ");
			dati.append(tipoNonInElenco.toUpperCase());
			dati.append(" ");
			dati.append("<b>Bene:</b>");
			dati.append(" ");
			dati.append(descNonInElenco.toUpperCase());
			dati.append(" ");
			dati.append("<b>Quantit&agrave;:</b>");
			dati.append(" ");
			dati.append(quantitaNonInElenco);
			dati.append(" ");
			dati.append("<b>Dettagli:</b>");
			dati.append(" ");
			dati.append(dettagliNonInElenco.toUpperCase());
			dati.append("</p>");
			dati.append("</br>");
		}
		return dati.toString();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiesteBeniInventariatiConfig.class, properties);
	}

	private volatile MefRichiesteBeniInventariatiConfig _configuration;

	@ProcessAction(name = "cambiaStatoDettaglio")
	public void cambiaStatoDettaglio(ActionRequest actionRequest, ActionResponse actionResponse) {

		long id_richiesta_corrente = Long.parseLong(actionRequest.getParameter("idRichiesta"));
		RichiestaBeneInv richiestaCorrente;
		try {
			richiestaCorrente = RichiestaBeneInvLocalServiceUtil.getRichiestaBeneInv(id_richiesta_corrente);

			long stato_richiesta_id = richiestaCorrente.getId_stato();

			String dettagliConsegnatario = richiestaCorrente.getNote_consegn();

			if (actionRequest.getParameter("CommentiConsegnatario") != null
					&& !("").equals((String) actionRequest.getParameter("CommentiConsegnatario"))) {

				dettagliConsegnatario = actionRequest.getParameter("CommentiConsegnatario");

			}

			StringBuilder noteConsegnatario = new StringBuilder();

			String[] arraySplitTextOld = dettagliConsegnatario.split("\r\n");

			for (int j = 0; j < arraySplitTextOld.length; j++) {
				noteConsegnatario.append(arraySplitTextOld[j]);
				noteConsegnatario.append("<br>");
			}

			Utente richiedente = new Utente();
			JSONObject objRichiedente = JSONFactoryUtil.createJSONObject(richiestaCorrente.getDati_rich());
			JSONObject objBeneficiario = JSONFactoryUtil.createJSONObject(richiestaCorrente.getBeneficiario());

			richiedente.setUfficioRichiedente(objRichiedente.getString("ufficioRichiedente"));
			richiedente.setNome(richiestaCorrente.getNome_rich());
			richiedente.setCognome(richiestaCorrente.getCogn_rich());
			richiedente.setUbicazione(objRichiedente.getString("ubicazione"));
			richiedente.setPalazzina(objRichiedente.getString("palazzina"));
			richiedente.setPiano(objRichiedente.getString("piano"));
			richiedente.setScala(objRichiedente.getString("scala"));
			richiedente.setStanza(objRichiedente.getString("stanza"));
			richiedente.setTelefono(objRichiedente.getString("telefono"));
			richiedente.setEmailDirigente(objRichiedente.getString("emailDirigente"));

			String datirichiedente = getHtmlRichiedente(richiedente);
			String datibeneficiario = getHtmlBeneficiario(objBeneficiario.getString("nomeBenef"),
					objBeneficiario.getString("cognomeBenef"), objBeneficiario.getString("emailBenef"));

			List<BeneInvRichiesto> listBeniInElenco = BeneInvRichiestoLocalServiceUtil
					.getListBeniByIdRichiesta(id_richiesta_corrente, true);
			List<BeneInvRichiesto> listBeniNonInElenco = BeneInvRichiestoLocalServiceUtil
					.getListBeniByIdRichiesta(id_richiesta_corrente, false);

			List<ModuloBeneInv> listBeniInElencoBean = new ArrayList<ModuloBeneInv>();
			for (BeneInvRichiesto beneInvRich : listBeniInElenco) {
				ModuloBeneInv moduloBeneInv = new ModuloBeneInv();
				moduloBeneInv.setTipologia(beneInvRich.getTipologia());
				moduloBeneInv.setBene(beneInvRich.getDescrizione());
				moduloBeneInv.setQuantita(Integer.toString(beneInvRich.getQuantita()));
				moduloBeneInv.setDettagli(beneInvRich.getDettagli());
				listBeniInElencoBean.add(moduloBeneInv);
			}
			String datirichiesta;
			if (listBeniNonInElenco != null && !listBeniNonInElenco.isEmpty()) {
				datirichiesta = getHtmlRichiesta(richiestaCorrente.getOggetto(), richiestaCorrente.getData(),
						richiestaCorrente.getDestinazione(), listBeniInElencoBean,
						listBeniNonInElenco.get(0).getTipologia(), listBeniNonInElenco.get(0).getDescrizione(),
						Integer.toString(listBeniNonInElenco.get(0).getQuantita()),
						listBeniNonInElenco.get(0).getDettagli());
			} else {
				datirichiesta = getHtmlRichiesta(richiestaCorrente.getOggetto(), richiestaCorrente.getData(),
						richiestaCorrente.getDestinazione(), listBeniInElencoBean, null, null, null, null);
			}

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			// get consegnatario and cdc roles
			String dipartimentoName = richiestaCorrente.getDip_dir().toUpperCase();
			String cdc_role = null;
			String consegnatario_role = null;

			switch (dipartimentoName) {
			case "DIP. II - RGS":
				cdc_role = "cdcBeniInv_rgs";
				consegnatario_role = "consegnatarioBeniInv_rgs";
				break;
			case "DIP. I - TESORO":
				cdc_role = "cdcBeniInv_tesoro";
				consegnatario_role = "consegnatarioBeniInv_tesoro";
				break;
			case "DIP. III - DIPARTIMENTO DELLE FINANZE":
				cdc_role = "cdcBeniInv_finanze";
				consegnatario_role = "consegnatarioBeniInv_finanze";
				break;
			case "DIP. IV - AMM. GEN. PERSONALE":
				cdc_role = "cdcBeniInv_personale";
				consegnatario_role = "consegnatarioBeniInv_personale";
				break;

			default:
				_log.error("Nessun dipartimento");
				break;
			}

			Long currentCdcRoleId = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), cdc_role).getRoleId();
			Long currentConsRoleId = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), consegnatario_role)
					.getRoleId();

			List<User> cdc_list = UserLocalServiceUtil.getRoleUsers(currentCdcRoleId);
			List<User> consegnatario_list = UserLocalServiceUtil.getRoleUsers(currentConsRoleId);

			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter("richiestaId", Long.toString(richiestaCorrente.getPrimaryKey()));
			renderUrl.setParameter("navigation", "linkdettaglio");

			String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
			EmailSender mail = new EmailSender();
			User userRichiedente = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(),
					richiestaCorrente.getUtente());

			String nuovoStato;
			if (actionRequest.getParameter("inputSelectedStatus") != null
					&& !("").equals(actionRequest.getParameter("inputSelectedStatus").toString())) {
				nuovoStato = actionRequest.getParameter("inputSelectedStatus");

				String sender = actionRequest.getPreferences().getValue("cambioStatoConsegnatarioSender",
						_configuration.cambioStatoConsegnatarioSender());
				String subject = actionRequest.getPreferences().getValue("cambioStatoConsegnatarioSubject",
						_configuration.cambioStatoConsegnatarioSubject());
				subject = StringUtil.replace(subject, new String[] { "[$IDRICHIESTA$]" },
						new String[] { actionRequest.getParameter("idRichiesta") });
				String mailbody = actionRequest.getPreferences().getValue("cambioStatoConsegnatarioTmpl",
						_configuration.cambioStatoConsegnatarioTmpl());

				mailbody = StringUtil.replace(mailbody,
						new String[] { "[$NUOVOSTATO$]", "[$DATIRICHIEDENTE$]", "[$DATIBENEFICIARIO$]", "[$DATI$]",
								"[$NOTECONSEGNATARIO$]", "[$LINK$]" },
						new String[] { nuovoStato, datirichiedente, datibeneficiario, datirichiesta,
								noteConsegnatario.toString(), renderUrl.toString() });

				if (("acquisto richiesto").equalsIgnoreCase(nuovoStato.trim())) {
					stato_richiesta_id = 7;

					mail.sendMailMessageOneListReceiverOneListCC(subject, mailbody, sender, smtpUser, cdc_list,
							consegnatario_list);

				}

				else {
					if (("accettata").equalsIgnoreCase(nuovoStato.trim())) {
						stato_richiesta_id = 2;
					}

					if (("rifiutata").equalsIgnoreCase(nuovoStato.trim())) {
						stato_richiesta_id = 3;
					}

					if (("evasa").equalsIgnoreCase(nuovoStato.trim())) {
						stato_richiesta_id = 4;
					}

					if (("non evasa").equalsIgnoreCase(nuovoStato.trim())) {
						stato_richiesta_id = 5;
					}

					if (("consegnata").equalsIgnoreCase(nuovoStato.trim())) {
						stato_richiesta_id = 6;
					}

					mail.sendMailMessageTwoReceiverOneListCC(subject, mailbody, sender, smtpUser,
							userRichiedente.getEmailAddress(), objBeneficiario.getString("emailBenef"), cdc_list);
				}
			}

			else if (actionRequest.getParameter("inputStatusCDC") != null
					&& !("").equals(actionRequest.getParameter("inputStatusCDC").toString())) {
				nuovoStato = actionRequest.getParameter("inputStatusCDC");

				String sender = actionRequest.getPreferences().getValue("cambioStatoCDCSender",
						_configuration.cambioStatoCDCSender());
				String subject = actionRequest.getPreferences().getValue("cambioStatoCDCSubject",
						_configuration.cambioStatoCDCSubject());
				subject = StringUtil.replace(subject, new String[] { "[$IDRICHIESTA$]" },
						new String[] { actionRequest.getParameter("idRichiesta") });
				String mailbody = actionRequest.getPreferences().getValue("cambioStatoCDCTmpl",
						_configuration.cambioStatoCDCTmpl());
				mailbody = StringUtil.replace(mailbody,
						new String[] { "[$NUOVOSTATO$]", "[$DATIRICHIEDENTE$]", "[$DATIBENEFICIARIO$]", "[$DATI$]",
								"[$NOTECONSEGNATARIO$]", "[$LINK$]" },
						new String[] { nuovoStato.toUpperCase(), datirichiedente, datibeneficiario, datirichiesta,
								noteConsegnatario.toString(), renderUrl.toString() });

				if (("acquisto autorizzato").equalsIgnoreCase(nuovoStato.trim())) {
					stato_richiesta_id = 8;
					mail.sendMailMessageOneListReceiverOneListCC(subject, mailbody, sender, smtpUser,
							consegnatario_list, cdc_list);
				}

				if (("acquisto respinto").equalsIgnoreCase(nuovoStato.trim())) {
					stato_richiesta_id = 9;
					mail.sendMailMessageOneListReceiverTwoCC(subject, mailbody, sender, smtpUser, consegnatario_list,
							userRichiedente.getEmailAddress(), objBeneficiario.getString("emailBenef"));
				}
			}

			richiestaCorrente.setId_stato(stato_richiesta_id);

			if (dettagliConsegnatario != null && !("").equals(dettagliConsegnatario)) {
				richiestaCorrente.setNote_consegn(dettagliConsegnatario);
			}
			RichiestaBeneInvLocalServiceUtil.updateRichiestaBeneInv(richiestaCorrente);

			PortletURL renderUrlNew = PortletURLFactoryUtil.create(actionRequest,
					themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrlNew.setParameter("richiestaId", String.valueOf(richiestaCorrente.getId_richiesta()));
			actionResponse.sendRedirect(renderUrlNew.toString());

		} catch (Exception e) {
			_log.warn(e);
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionErrors.add(actionRequest, "");

		}

	}

	private List<RichiestaBeneInv> clearNote_consegn(List<RichiestaBeneInv> lista) {
		List<RichiestaBeneInv> tmp = new ArrayList<RichiestaBeneInv>();
		for (RichiestaBeneInv richiestaBeneInv : lista) {
			richiestaBeneInv.setNote_consegn("");
			richiestaBeneInv.setOggetto(HtmlUtil.escape(richiestaBeneInv.getOggetto()));
			richiestaBeneInv.setDestinazione(HtmlUtil.escape(richiestaBeneInv.getDestinazione()));
			richiestaBeneInv.setNome_rich(HtmlUtil.escape(richiestaBeneInv.getNome_rich()));
			richiestaBeneInv.setCogn_rich(HtmlUtil.escape(richiestaBeneInv.getCogn_rich()));

			tmp.add(richiestaBeneInv);
		}

		return tmp;
	}

}
