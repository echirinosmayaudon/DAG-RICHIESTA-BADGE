
package com.accenture.mef.lavoro.agile.form.portlet;

import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;
import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRichModel;
import com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile;
import com.accenture.lavoro.agile.istanza.mef.service.EmailLocalServiceUtil;
import com.accenture.lavoro.agile.istanza.mef.service.OpzioneRichLocalServiceUtil;
import com.accenture.lavoro.agile.istanza.mef.service.RichLavAgileLocalServiceUtil;
import com.accenture.mef.lavoro.agile.form.bean.ModuloRichiesta;
import com.accenture.mef.lavoro.agile.form.bean.Opzione;
import com.accenture.mef.lavoro.agile.form.bean.OpzioniBean;
import com.accenture.mef.lavoro.agile.form.bean.Richiedente;
import com.accenture.mef.lavoro.agile.form.bean.RichiestaLavAgileExcelBean;
import com.accenture.mef.lavoro.agile.form.bean.RisultatoRicerca;
import com.accenture.mef.lavoro.agile.form.util.EmailSender;
import com.accenture.mef.lavoro.agile.form.util.ExcelWriter;
import com.intranet.mef.job.siap.model.ClassificationLevel;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
import com.intranet.mef.job.siap.service.ClassificationLevelLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import mef.dowloader.dml.DownloadDml;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=mef-lavoro-agile-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefLavoroAgileFormPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(MefLavoroAgileFormPortlet.class);

	private static final String _customFieldUserOrg = "idOrgChart";
	private static final String _customFieldUserLevel = "levelId";
	private static final String _customFieldPersonalId = "personalId";
	private static final String _customFieldUserDirector = "idDirector";

	// COSTANTI LABEL
	private static final String LABEL_DOTAZIONE = "dotazione informatica";
	private static final String LABEL_REGOLAMENTO = "regolamento";
	private static final String LABEL_LAVORATORE_PADRE_MADRE = "lavoratore padre madre";
	private static final String LABEL_FIGLI_DISABILI = "figli disabili";
	private static final String LABEL_DISABILITA = "disabilita psico-fisica";
	private static final String LABEL_MONOGENITORIALITA = "monogenitorialita";
	private static final String LABEL_CURA_FIGLI = "esigenza cura figli";
	private static final String LABEL_ASSISTENZA_FAMILIARI = "assistenza familiari";
	private static final String LABEL_DISTANZA = "distanza domicilio lavoro";
	private static final String LABEL_NO_AGEVOLAZIONI = "no agevolazioni";

	// COSTANTI NOMI DIPARTIMENTI
	private static final String DIP_DT = "DIP. I - TESORO";
	private static final String DIP_RGS = "DIP. II - RGS";
	private static final String DIP_DF = "DIP. III - DIPARTIMENTO DELLE FINANZE";
	private static final String DIP_DAG = "DIP. IV - AMM. GEN. PERSONALE";

	// TIPO OPZIONE
	private static final String _checkbox = "checkbox";
	private static final String _checkboxWithValue = "checkboxWithValue";
	private static final String _radio = "radio";

	// attachment temp path
	private static final String TEMP_PATH = "/wos1/java/products/liferay/tmp/";
	// attachment base directory
	private static final String baseDir = "/richiesteLavoroAgile";

	// COSTANTI NOMI RUOLI
	private static final String NOME_RUOLO_RICHIEDENTE_LAV_AGILE = "richiedenteLavoroAgile";
	private static final String NOME_RUOLO_SEGRETERIA_LAV_AGILE = "segreteriaLavoroAgile";
	private static final String NOME_RUOLO_RICHIEDENTE_LAV_AGILE_PLUS = "richiedenteLavoroAgilePlus";
	private static final String NOME_RUOLO_UTENTE_ACCORDO_ALLEGATO = "utenteAccordoLavoroAgilePlus";

	// COSTANTI LABEL OPT
	private static final String LABEL_OPT_LAVORATORE_PADRE_MADRE = "lavoratore padre madre";
	private static final String LABEL_OPT_FIGLI_DISABILI = "figli disabili";
	private static final String LABEL_OPT_DISABILITA_PSICO_FISICA = "disabilita psico-fisica";
	private static final String LABEL_OPT_MONOGENITORIALITA = "monogenitorialita";
	private static final String LABEL_OPT_ESIGENZA_CURA_FIGLI = "esigenza cura figli";
	private static final String LABEL_OPT_ASSISTENZA_FAMILIARI = "assistenza familiari";
	private static final String LABEL_OPT_DISTANZA_DOMICILIO_LAVORO = "distanza domicilio lavoro";
	private static final String LABEL_OPT_NO_AGEVOLAZIONI = "no agevolazioni";

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String regolamento = renderRequest.getPreferences().getValue(LABEL_REGOLAMENTO, _configuration.regolamento());
		User user = themeDisplay.getUser();
		long id_richiesta;

		renderRequest.setAttribute(MefLavoroAgileConfig.class.getName(), _configuration);

		List<RichLavAgile> listaRichUser = RichLavAgileLocalServiceUtil.getRichByScreename(user.getScreenName());
		if (!(("recap").equalsIgnoreCase((String) renderRequest.getAttribute("navigation")))
				&& !(("form").equalsIgnoreCase((String) renderRequest.getAttribute("navigation")))
				&& !(("dettaglio").equalsIgnoreCase((String) renderRequest.getAttribute("navigation")))) {

			if (listaRichUser != null && !listaRichUser.isEmpty()) {
				id_richiesta = listaRichUser.get(0).getId();
				renderRequest.setAttribute("richlavId", id_richiesta);
			}
		}

		Richiedente richiedente;
		try {
			richiedente = getRichiedente(themeDisplay);
			renderRequest.setAttribute("richiedente", richiedente);
		} catch (PortalException e) {
			_log.error(e);
		}

		// ruoli utente
		boolean booleanRichiedenteLavAgile = false;
		boolean booleanSegreteriaLavAgile = false;

		// check if role has layout view permission
		boolean booleanLayoutViewPermissionRichiedenteLavAgile = false;
		boolean booleanLayoutViewPermissionSegreteriaLavAgile = false;

		Role richiedenteLavAgile = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(),
				NOME_RUOLO_RICHIEDENTE_LAV_AGILE);
		if (richiedenteLavAgile != null) {
			booleanRichiedenteLavAgile = UserLocalServiceUtil.hasRoleUser(richiedenteLavAgile.getRoleId(),
					user.getUserId());
			try {
				booleanLayoutViewPermissionRichiedenteLavAgile = ResourcePermissionLocalServiceUtil
						.hasResourcePermission(themeDisplay.getCompanyId(), Layout.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL,
								String.valueOf(themeDisplay.getLayout().getPrimaryKey()),
								richiedenteLavAgile.getRoleId(), ActionKeys.VIEW);
			} catch (PortalException e) {
				_log.error("Error in retrieve layout view permission for " + NOME_RUOLO_RICHIEDENTE_LAV_AGILE
						+ " role: " + e);
			}
		}

		Role segreteriaLavAgile = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(),
				NOME_RUOLO_SEGRETERIA_LAV_AGILE);
		if (segreteriaLavAgile != null) {
			booleanSegreteriaLavAgile = UserLocalServiceUtil.hasRoleUser(segreteriaLavAgile.getRoleId(),
					user.getUserId());
			try {
				booleanLayoutViewPermissionSegreteriaLavAgile = ResourcePermissionLocalServiceUtil
						.hasResourcePermission(themeDisplay.getCompanyId(), Layout.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL,
								String.valueOf(themeDisplay.getLayout().getPrimaryKey()),
								segreteriaLavAgile.getRoleId(), ActionKeys.VIEW);
			} catch (PortalException e) {
				_log.error("Error in retrieve layout view permission for " + NOME_RUOLO_SEGRETERIA_LAV_AGILE + " role: "
						+ e);
			}
		}
		PortletSession sessionDoView = renderRequest.getPortletSession();
		// jsonarray lista di default per excel
		if (booleanSegreteriaLavAgile) {
			List<RichLavAgile> queryDefault = RichLavAgileLocalServiceUtil.getRichiesteOrder(StringPool.BLANK, 0L, null,
					0L, 0L, 0L);
			List<RisultatoRicerca> defaultList = populateBeanRicerca(queryDefault);

			if (sessionDoView.getAttribute("daRicerca", sessionDoView.APPLICATION_SCOPE) != null
					&& renderRequest.getParameter("daListaRicerca") != null
					&& !"".equalsIgnoreCase(renderRequest.getParameter("daListaRicerca"))) {

				renderRequest.setAttribute("listaDaRicerca", "listaDaRicerca");

			} else if (renderRequest.getAttribute("daRicerca") == null
					|| ("").equalsIgnoreCase((String) renderRequest.getAttribute("daRicerca"))) {

				// paginazione e salvataggio in sessione
				String itemsPerPage = renderRequest.getPreferences().getValue("itemsPerPage",
						(_configuration.itemsPerPage()));
				int delta = Integer.parseInt(itemsPerPage);

				List<List<RisultatoRicerca>> paginazione_res = listPaginationRes(String.valueOf(delta), defaultList);

				int pagesize = 1;
				if (paginazione_res != null && !paginazione_res.isEmpty()) {
					pagesize = paginazione_res.size();
				}

				sessionDoView.removeAttribute("paginazione_res", sessionDoView.APPLICATION_SCOPE);
				sessionDoView.removeAttribute("delta", sessionDoView.APPLICATION_SCOPE);
				sessionDoView.removeAttribute("filtriRicercaRichieste", sessionDoView.APPLICATION_SCOPE);
				sessionDoView.removeAttribute("radioOrder", sessionDoView.APPLICATION_SCOPE);
				sessionDoView.removeAttribute("daRicerca", sessionDoView.APPLICATION_SCOPE);
				sessionDoView.removeAttribute("jsonString", sessionDoView.APPLICATION_SCOPE);
				sessionDoView.removeAttribute("richiesta_lav_agile_excel_jsonarray_ricerca",
						sessionDoView.APPLICATION_SCOPE);
				sessionDoView.setAttribute("paginazione_res", paginazione_res, PortletSession.APPLICATION_SCOPE);
				sessionDoView.setAttribute("delta", String.valueOf(delta), PortletSession.APPLICATION_SCOPE);

				if (defaultList != null) {
					renderRequest.setAttribute("totalSize", defaultList.size());
				}
				if (paginazione_res != null) {
					renderRequest.setAttribute("defaultList",
							!paginazione_res.isEmpty() ? paginazione_res.get(0) : new ArrayList<RisultatoRicerca>(0));
				}
				renderRequest.setAttribute("numPage", pagesize);

			}

			if (queryDefault != null && !queryDefault.isEmpty()) {
				try {
					JSONArray richiesta_lav_agile_excel_jsonarray = createRichiestaLavAgileExcelBeanList(themeDisplay,
							queryDefault);
					renderRequest.setAttribute("richiesta_lav_agile_excel_jsonarray_default",
							richiesta_lav_agile_excel_jsonarray.toString());
				} catch (JSONException e) {
					_log.error("Error using createRichiestaLavAgileExcelBeanList method: " + e);
				}
			}
		}

		// IMEF-1780
		// check richiedenteLavAgilePlus role and layout view permission
		boolean booleanRichiedenteLavAgilePlus = false;
		boolean booleanLayoutViewPermissionRichiedenteLavAgilePlus = false;

		Role richiedenteLavAgilePlus = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(),
				NOME_RUOLO_RICHIEDENTE_LAV_AGILE_PLUS);
		if (richiedenteLavAgilePlus != null) {
			booleanRichiedenteLavAgilePlus = UserLocalServiceUtil.hasRoleUser(richiedenteLavAgilePlus.getRoleId(),
					themeDisplay.getUserId());
			try {
				booleanLayoutViewPermissionRichiedenteLavAgilePlus = ResourcePermissionLocalServiceUtil
						.hasResourcePermission(themeDisplay.getCompanyId(), Layout.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL,
								String.valueOf(themeDisplay.getLayout().getPrimaryKey()),
								richiedenteLavAgilePlus.getRoleId(), ActionKeys.VIEW);
			} catch (PortalException e) {
				_log.error("Error in retrieve layout view permission for " + NOME_RUOLO_RICHIEDENTE_LAV_AGILE_PLUS
						+ " role: " + e);
			}
		}

		boolean requestInsertConditionOK = isValidRequestInsertCondition(renderRequest, themeDisplay,
				booleanRichiedenteLavAgile, booleanLayoutViewPermissionRichiedenteLavAgile,
				booleanRichiedenteLavAgilePlus, booleanLayoutViewPermissionRichiedenteLavAgilePlus);

		renderRequest.setAttribute("booleanRichiedenteLavAgilePlus", booleanRichiedenteLavAgilePlus);
		renderRequest.setAttribute("booleanLayoutViewPermissionRichiedenteLavAgilePlus",
				booleanLayoutViewPermissionRichiedenteLavAgilePlus);
		renderRequest.setAttribute("requestInsertConditionOK", requestInsertConditionOK);
		// end IMEF-1780

		// INIZIO INSERIMENTO METODO SEZIONE AGGIUNTIVA ALLEGATO
		String resultVisibilitaAllegato = vaiASezioneAllegatoIsValid(renderRequest, themeDisplay,
				booleanRichiedenteLavAgile, booleanLayoutViewPermissionRichiedenteLavAgile,
				booleanRichiedenteLavAgilePlus, booleanLayoutViewPermissionRichiedenteLavAgilePlus);
		renderRequest.setAttribute("resultVisibilitaAllegato", resultVisibilitaAllegato);
		boolean flagDisableUpdateNuovoAllegatoOORange = disableUpdateNuovoAllegatoOORange(renderRequest, themeDisplay,
				booleanRichiedenteLavAgile, booleanLayoutViewPermissionRichiedenteLavAgile,
				booleanRichiedenteLavAgilePlus, booleanLayoutViewPermissionRichiedenteLavAgilePlus,
				booleanSegreteriaLavAgile, booleanLayoutViewPermissionSegreteriaLavAgile);
		renderRequest.setAttribute("flagDisableUpdateNuovoAllegatoOORange", flagDisableUpdateNuovoAllegatoOORange);
		// FINE INSERIMENTO METODO SEZIONE AGGIUNTIVA ALLEGATO

		renderRequest.setAttribute("booleanRichiedenteLavAgile", booleanRichiedenteLavAgile);
		renderRequest.setAttribute("booleanSegreteriaLavAgile", booleanSegreteriaLavAgile);
		renderRequest.setAttribute("booleanLayoutViewPermissionRichiedenteLavAgile",
				booleanLayoutViewPermissionRichiedenteLavAgile);
		renderRequest.setAttribute("booleanLayoutViewPermissionSegreteriaLavAgile",
				booleanLayoutViewPermissionSegreteriaLavAgile);

		renderRequest.setAttribute("regolamento", regolamento);
		renderRequest.setAttribute("opzioniBean", populateBeanopzioni());
		super.doView(renderRequest, renderResponse);
	}

	public void vaiAInserimento(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.setAttribute("navigation", "form");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	@ProcessAction(name = "invioAllegatoPlus")
	public void invioAllegatoPlus(ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long richlavId = Long.parseLong(actionRequest.getParameter("richiestaId"));

		// richiesta lavoro agile params
		long id_richiesta = 0;
		String cognome;
		String nome;
		long dipartimento;
		long direzione;
		long ufficio;
		String screename;
		String jsonRichiedente;
		String jsonRichiesta;

		// CALCOLO PESO
		int peso_tot = 0;
		String peso_plus = "false";

		String bando;
		Date data_richiesta = new Date();
		String allegato = "";
		String pdf = "";

		try {

			RichLavAgile richiesta = RichLavAgileLocalServiceUtil.getRichLavAgile(richlavId);
			cognome = richiesta.getCognome();
			nome = richiesta.getNome();
			dipartimento = richiesta.getDipartimento();
			direzione = richiesta.getDirezione();
			ufficio = richiesta.getUfficio();
			screename = richiesta.getScreename();
			jsonRichiedente = richiesta.getJson_richiedente();
			jsonRichiesta = richiesta.getJson_richiesta();
			peso_tot = richiesta.getPeso_tot();
			peso_plus = richiesta.getPeso_plus();
			bando = richiesta.getBando();
			allegato = richiesta.getAllegato();

			ModuloRichiesta moduloRichiesta = new ModuloRichiesta();

			// file creation params
			copyFileToServer(actionRequest, moduloRichiesta, themeDisplay.getUser().getScreenName(),
					"fileAttachProgIndividualePlus", "attachRealNamePlus");

			Long userId = themeDisplay.getUserId();
			File file = moduloRichiesta.getAllegato();
			Long dlFolderId = 0L;
			String folderName = "";
			String title = (String) actionRequest.getParameter("attachRealNamePlus");
			String descrizione = "";

			FileEntry fileEntry = createFileDocumentMedia(actionRequest, userId, dlFolderId, folderName, title,
					descrizione, file);

			if (fileEntry != null) {

				Role ownerRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.OWNER);
				Role siteMemberRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
						RoleConstants.SITE_MEMBER);
				Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
				Role powerUserRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
						RoleConstants.POWER_USER);

				ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
						DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
						String.valueOf(fileEntry.getFileEntryId()), ownerRole.getRoleId(), ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
						DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
						String.valueOf(fileEntry.getFileEntryId()), guestRole.getRoleId(), ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
						DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
						String.valueOf(fileEntry.getFileEntryId()), siteMemberRole.getRoleId(), ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
						DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
						String.valueOf(fileEntry.getFileEntryId()), powerUserRole.getRoleId(), ActionKeys.VIEW);

				pdf = fileEntry.getUuid();

				richlavId = RichLavAgileLocalServiceUtil.insertRichiestaAgile(id_richiesta, cognome, nome, dipartimento,
						direzione, ufficio, screename, jsonRichiedente, jsonRichiesta, peso_tot, peso_plus, bando,
						data_richiesta, allegato, pdf);
			}

		} catch (PortalException e) {
			_log.error("PortalException: " + e);
		} catch (IOException e) {
			_log.error("IOException: " + e);
		}

		// controllo esito inserimento: se avvenuto con successo, atterra nel
		// nuovo dettaglio
		if (richlavId != 0) {
			try {
				PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrl.setWindowState(LiferayWindowState.NORMAL);
				renderUrl.setPortletMode(LiferayPortletMode.VIEW);
				renderUrl.setParameter("richlavId", String.valueOf(richlavId));
				renderUrl.setParameter("navigation", "detail");
				actionResponse.sendRedirect(renderUrl.toString());
			} catch (Exception e) {
				_log.error("Error in caricamento filePlus: " + e);
			}
		}

	}

	@ProcessAction(name = "vaiADettaglio")
	public void vaiADettaglio(ActionRequest actionRequest, ActionResponse actionResponse) {

		actionRequest.setAttribute("richlavId", String.valueOf(actionRequest.getParameter("richiestaId")));
		actionRequest.setAttribute("navigation", "dettaglio");
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (resourceRequest.getParameter("idDownload") != null
				&& !"".equalsIgnoreCase(resourceRequest.getParameter("idDownload"))) {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long fileEntryId = Long.parseLong(ParamUtil.getString(resourceRequest, "idDownload"));
			DownloadDml downloadUtil = new DownloadDml();
			downloadUtil.downloadDmlFile(fileEntryId, themeDisplay, resourceResponse);

		} else {
			String json = resourceRequest.getParameter("jsonExcel");
			JSONArray arrayRicerca;
			List<RichiestaLavAgileExcelBean> excelList = new ArrayList<>(0);
			RichiestaLavAgileExcelBean beanExcel;
			try {
				arrayRicerca = JSONFactoryUtil.createJSONArray(json);
				int sizeArray = arrayRicerca.length();

				for (int i = 0; i < sizeArray; i++) {

					beanExcel = new RichiestaLavAgileExcelBean();

					beanExcel.setIstanza(arrayRicerca.getJSONObject(i).getString("istanza"));
					beanExcel.setCognome(arrayRicerca.getJSONObject(i).getString("cognome"));
					beanExcel.setNome(arrayRicerca.getJSONObject(i).getString("nome"));
					beanExcel.setCodice_fiscale(arrayRicerca.getJSONObject(i).getString("codice_fiscale"));
					beanExcel.setDip(arrayRicerca.getJSONObject(i).getString("dip"));
					beanExcel.setDir(arrayRicerca.getJSONObject(i).getString("dir"));
					beanExcel.setPriorita(arrayRicerca.getJSONObject(i).getString("priorita"));
					beanExcel.setPunteggio(arrayRicerca.getJSONObject(i).getString("punteggio"));
					beanExcel.setData_nascita(arrayRicerca.getJSONObject(i).getString("data_nascita"));
					beanExcel.setFlag_2a(arrayRicerca.getJSONObject(i).getString("flag_2a"));
					beanExcel.setFlag_2b(arrayRicerca.getJSONObject(i).getString("flag_2b"));
					beanExcel.setFlag_3a(arrayRicerca.getJSONObject(i).getString("flag_3a"));
					beanExcel.setFlag_3b(arrayRicerca.getJSONObject(i).getString("flag_3b"));
					beanExcel.setValue_3c1(arrayRicerca.getJSONObject(i).getString("value_3c1"));
					beanExcel.setValue_3c2(arrayRicerca.getJSONObject(i).getString("value_3c2"));
					beanExcel.setValue_3d(arrayRicerca.getJSONObject(i).getString("value_3d"));
					beanExcel.setValue_3e(arrayRicerca.getJSONObject(i).getString("value_3e"));
					beanExcel.setFlag_3f(arrayRicerca.getJSONObject(i).getString("flag_3f"));
					beanExcel.setAllegato(arrayRicerca.getJSONObject(i).getString("allegato"));
					beanExcel.setNote(arrayRicerca.getJSONObject(i).getString("note"));

					excelList.add(beanExcel);

				}
			} catch (JSONException e) {
				_log.warn(e);
			}

			resourceResponse.setContentType("application/vnd.ms-excel");
			resourceResponse.setProperty("Content-Disposition",
					("attachment; ") + "filename=" + "Elenco richieste" + ".xls");

			ExcelWriter.writeRichiesteExcel(excelList, resourceResponse);

		}

	}

	@ProcessAction(name = "ricerca")
	public void ricerca(ActionRequest actionRequest, ActionResponse actionResponse) {

		PortletSession session = actionRequest.getPortletSession();
		List<String> filtriRicercaRichieste = new ArrayList<String>();

		String order = StringPool.BLANK;
		long codiceIstanza = 0L;
		String cognome = StringPool.BLANK;
		long dip = 0L;
		long dir = 0L;
		long uff = 0L;

		JSONObject jsonFiltri = null;
		String jsonString = null;

		try {
			if (actionRequest.getParameter("jsonFiltri") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("jsonFiltri"))) {
				jsonString = actionRequest.getParameter("jsonFiltri");
			} else if (session.getAttribute("jsonString", session.APPLICATION_SCOPE) != null) {
				jsonString = (String) session.getAttribute("jsonString", session.APPLICATION_SCOPE);
			}
			jsonFiltri = JSONFactoryUtil.createJSONObject(jsonString);

		} catch (JSONException e) {
			_log.error("Error in creation jsonObject: " + e);
		}

		if (actionRequest.getParameter("radioOrder") != null
				&& !("").equalsIgnoreCase((String) actionRequest.getParameter("radioOrder"))) {
			order = (String) actionRequest.getParameter("radioOrder");
		} else if (session.getAttribute("radioOrder", session.APPLICATION_SCOPE) != null) {
			order = (String) session.getAttribute("radioOrder", session.APPLICATION_SCOPE);
		}

		if (actionRequest.getParameter("codiceIstanza") != null
				&& !("").equalsIgnoreCase(actionRequest.getParameter("codiceIstanza"))) {
			if (Long.parseLong((String) actionRequest.getParameter("codiceIstanza")) != 0) {
				codiceIstanza = Long.parseLong((String) actionRequest.getParameter("codiceIstanza"));
			}
		} else if (jsonFiltri != null && !("").equalsIgnoreCase(jsonFiltri.getString("codiceIstanza"))) {
			codiceIstanza = jsonFiltri.getLong("codiceIstanza");
		}

		if (actionRequest.getParameter("cognome") != null
				&& !("").equalsIgnoreCase((String) actionRequest.getParameter("cognome"))) {
			cognome = (String) actionRequest.getParameter("cognome");
		} else if (jsonFiltri != null && !("").equalsIgnoreCase(jsonFiltri.getString("cognome"))) {
			cognome = jsonFiltri.getString("cognome");
		}

		if (actionRequest.getParameter("dipartimento") != null
				&& !("").equalsIgnoreCase(actionRequest.getParameter("dipartimento"))) {
			if (Long.parseLong((String) actionRequest.getParameter("dipartimento")) != 0) {
				dip = Long.parseLong((String) actionRequest.getParameter("dipartimento"));
			}
		} else if (jsonFiltri != null && !("").equalsIgnoreCase(jsonFiltri.getString("dipartimento"))) {
			dip = jsonFiltri.getLong("dipartimento");
		}

		if (actionRequest.getParameter("direzione") != null
				&& !("").equalsIgnoreCase(actionRequest.getParameter("direzione"))) {
			if (Long.parseLong((String) actionRequest.getParameter("direzione")) != 0) {
				dir = Long.parseLong((String) actionRequest.getParameter("direzione"));
			}
		} else if (jsonFiltri != null && !("").equalsIgnoreCase(jsonFiltri.getString("direzione"))) {
			dir = jsonFiltri.getLong("direzione");
		}

		if (actionRequest.getParameter("ufficio") != null
				&& !("").equalsIgnoreCase(actionRequest.getParameter("ufficio"))) {
			if (Long.parseLong((String) actionRequest.getParameter("ufficio")) != 0) {
				uff = Long.parseLong((String) actionRequest.getParameter("ufficio"));
			}
		} else if (jsonFiltri != null && !("").equalsIgnoreCase(jsonFiltri.getString("ufficio"))) {
			uff = jsonFiltri.getLong("ufficio");
		}

		// recupero dei Filtrato per
		OrganizationChart dipartimento = null;
		OrganizationChart direzione = null;
		OrganizationChart ufficio = null;

		try {
			if (dip != 0L) {
				dipartimento = OrganizationChartLocalServiceUtil.getOrganizationChart(dip);
			}
			if (dir != 0L) {
				direzione = OrganizationChartLocalServiceUtil.getOrganizationChart(dir);
			}
			if (uff != 0L) {
				ufficio = OrganizationChartLocalServiceUtil.getOrganizationChart(uff);
			}
		} catch (PortalException e) {
			_log.error("Error retrieve dipartimento/direzione/ufficio from OrganizationChart: " + e);
		}

		if (codiceIstanza != 0L)
			filtriRicercaRichieste.add("CODICE ISTANZA: " + String.valueOf(codiceIstanza));
		if (cognome != StringPool.BLANK)
			filtriRicercaRichieste.add(cognome);
		if (dipartimento != null)
			filtriRicercaRichieste.add(dipartimento.getAcronimo());
		if (direzione != null)
			filtriRicercaRichieste.add(direzione.getAcronimo());
		if (ufficio != null)
			filtriRicercaRichieste.add(ufficio.getAcronimo());

		List<RichLavAgile> res_richieste = RichLavAgileLocalServiceUtil.getRichiesteOrder(order, codiceIstanza, cognome,
				dip, dir, uff);
		List<RisultatoRicerca> res_richiesteBean = populateBeanRicerca(res_richieste);

		// paginazione e salvataggio in sessione
		String itemsPerPage = actionRequest.getPreferences().getValue("itemsPerPage", (_configuration.itemsPerPage()));
		int delta = Integer.parseInt(itemsPerPage);

		List<List<RisultatoRicerca>> paginazione_res = listPaginationRes(String.valueOf(delta), res_richiesteBean);
		int pagesize = 1;

		if (paginazione_res != null && !paginazione_res.isEmpty()) {
			pagesize = paginazione_res.size();
		}

		// //remove session attribute
		// session.removeAttribute("paginazione_res",session.APPLICATION_SCOPE);
		// session.removeAttribute("delta", session.APPLICATION_SCOPE);
		// session.removeAttribute("filtriRicercaRichieste",
		// session.APPLICATION_SCOPE);
		// session.removeAttribute("radioOrder", session.APPLICATION_SCOPE);
		// session.removeAttribute("daRicerca", session.APPLICATION_SCOPE);
		// session.removeAttribute("jsonString", session.APPLICATION_SCOPE);
		// session.removeAttribute("richiesta_lav_agile_excel_jsonarray_ricerca",
		// session.APPLICATION_SCOPE);

		session.setAttribute("paginazione_res", paginazione_res, PortletSession.APPLICATION_SCOPE);
		session.setAttribute("delta", String.valueOf(delta), PortletSession.APPLICATION_SCOPE);

		// salavtaggio in sessione dei parametri di ricerca
		session.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste, PortletSession.APPLICATION_SCOPE);
		session.setAttribute("radioOrder", order, PortletSession.APPLICATION_SCOPE);
		session.setAttribute("daRicerca", "daRicerca", PortletSession.APPLICATION_SCOPE);
		if (jsonString != null && !(StringPool.BLANK).equalsIgnoreCase(jsonString)) {
			session.setAttribute("jsonString", jsonString, PortletSession.APPLICATION_SCOPE);
		}

		if (paginazione_res != null) {
			actionRequest.setAttribute("res",
					!paginazione_res.isEmpty() ? paginazione_res.get(0) : new ArrayList<RisultatoRicerca>(0));
		}
		actionRequest.setAttribute("page", 1);
		actionRequest.setAttribute("numPage", pagesize);

		if (res_richiesteBean != null)
			actionRequest.setAttribute("totalSize", res_richiesteBean.size());

		// jsonString = HtmlUtil.escape(jsonString);
		actionRequest.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste);
		actionRequest.setAttribute("jsonString", jsonString);
		actionRequest.setAttribute("radioOrder", order);
		actionRequest.setAttribute("navigation", "ricerca");
		actionRequest.setAttribute("daRicerca", "daRicerca");

		// jsonarray lista ricerca per excel
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (res_richieste != null && !res_richieste.isEmpty()) {
			try {
				JSONArray richiesta_lav_agile_excel_jsonarray = createRichiestaLavAgileExcelBeanList(themeDisplay,
						res_richieste);
				actionRequest.setAttribute("richiesta_lav_agile_excel_jsonarray_ricerca",
						richiesta_lav_agile_excel_jsonarray.toString());
				session.setAttribute("richiesta_lav_agile_excel_jsonarray_ricerca",
						richiesta_lav_agile_excel_jsonarray.toString(), PortletSession.APPLICATION_SCOPE);
			} catch (JSONException e) {
				_log.error("Error using createRichiestaLavAgileExcelBeanList method: " + e);
			}
		}

	}

	// metodo per la creazione della lista di liste di risultati
	private List<List<RisultatoRicerca>> listPaginationRes(String itemPerPage, List<RisultatoRicerca> set) {
		if (set == null)
			return Collections.emptyList();

		List<RisultatoRicerca> lista = new ArrayList<RisultatoRicerca>(set);
		Integer pageSize = Integer.parseInt(itemPerPage);
		if (pageSize == null || pageSize <= 0 || pageSize > lista.size() || pageSize == lista.size())
			pageSize = lista.size();
		int numpages = (int) Math.ceil((double) lista.size() / (double) pageSize);
		List<List<RisultatoRicerca>> pages = new ArrayList<List<RisultatoRicerca>>(numpages);
		for (int p = 0; p < numpages; p++) {
			pages.add(lista.subList(p * pageSize, Math.min((p + 1) * pageSize, lista.size())));
		}
		return pages;
	}

	// metodo richiamato al click sulle pagine
	@ProcessAction(name = "paginaRes")
	public void paginaRes(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

		try {
			PortletSession pSession = actionRequest.getPortletSession();

			// recupero parametri numepage e size da jsp
			String valuePage = actionRequest.getParameter("numpage");
			String size = actionRequest.getParameter("size");

			List<List<RisultatoRicerca>> pages = (List<List<RisultatoRicerca>>) pSession.getAttribute("paginazione_res",
					pSession.APPLICATION_SCOPE);
			List<String> filtriRicercaRichieste = (List<String>) pSession.getAttribute("filtriRicercaRichieste",
					pSession.APPLICATION_SCOPE);
			String radioOrder = (String) pSession.getAttribute("radioOrder", pSession.APPLICATION_SCOPE);

			if ((valuePage != null && !("").equalsIgnoreCase(valuePage)) || (pages != null && !pages.isEmpty())) {
				Integer numpage = Integer.parseInt(valuePage);

				List<RisultatoRicerca> resList = pages.get(numpage - 1);
				actionRequest.setAttribute("res", resList);
				actionRequest.setAttribute("page", numpage);
				actionRequest.setAttribute("numPage", pages.size());
			}

			actionRequest.setAttribute("navigation", "ricerca");
			actionRequest.setAttribute("totalSize", Integer.parseInt(size));
			actionRequest.setAttribute("delta", (String) pSession.getAttribute("delta", pSession.APPLICATION_SCOPE));
			actionRequest.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste);
			actionRequest.setAttribute("radioOrder", radioOrder);
			actionRequest.setAttribute("daRicerca", pSession.getAttribute("daRicerca", pSession.APPLICATION_SCOPE));
			actionRequest.setAttribute("jsonString", pSession.getAttribute("jsonString", pSession.APPLICATION_SCOPE));
			actionRequest.setAttribute("richiesta_lav_agile_excel_jsonarray_ricerca", (String) pSession
					.getAttribute("richiesta_lav_agile_excel_jsonarray_ricerca", pSession.APPLICATION_SCOPE));

		} catch (Exception e) {
			_log.warn(e);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(renderUrl.toString());
		}
	}

	// metodo per il popolamento della lista di bean risultati di ricerca
	private List<RisultatoRicerca> populateBeanRicerca(List<RichLavAgile> res_richieste) {

		List<RisultatoRicerca> resBeanRicerca = new ArrayList<>();
		for (RichLavAgile richiesta : res_richieste) {
			RisultatoRicerca risultato = new RisultatoRicerca();

			risultato.setId(richiesta.getId());
			risultato.setProgressivo(res_richieste.indexOf(richiesta) + 1);
			risultato.setCognome(richiesta.getCognome());
			risultato.setNome(richiesta.getNome());
			risultato.setPunteggio(richiesta.getPeso_tot());

			OrganizationChart dipartimento = null;
			OrganizationChart direzione = null;

			try {
				dipartimento = OrganizationChartLocalServiceUtil.getOrganizationChart(richiesta.getDipartimento());
				direzione = OrganizationChartLocalServiceUtil.getOrganizationChart(richiesta.getDirezione());
				risultato.setDip(dipartimento.getAcronimo());
				risultato.setDir(direzione.getAcronimo());
			} catch (PortalException e) {
				_log.error("Error in retrieve dipartimento/direzione from organizationchart: " + e);
			}

			risultato.setPriorita(Boolean.parseBoolean(richiesta.getPeso_plus()));
			resBeanRicerca.add(risultato);
		}

		return resBeanRicerca;

	}

	private OpzioniBean populateBeanopzioni() {

		OpzioniBean opzioniBean = new OpzioniBean();
		opzioniBean.setDichiarazione(
				OpzioneRichLocalServiceUtil.getOptionByLabel("conseguenze civili/penali").getTesto_opt());
		opzioniBean.setDotazioneInfo(OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_DOTAZIONE).getTesto_opt());

		OpzioneRich fornitaAmm = OpzioneRichLocalServiceUtil.getOptionByLabel("fornita amministrazione");
		opzioniBean.setFornitaAmm(fornitaAmm.getTesto_opt());
		opzioniBean.setFornitaAmmId(fornitaAmm.getId_opt());

		OpzioneRich propriaSpettanza = OpzioneRichLocalServiceUtil.getOptionByLabel("propria spettanza");
		opzioniBean.setPropriaSpettanza(propriaSpettanza.getTesto_opt());
		opzioniBean.setPropriaSpettanzaId(propriaSpettanza.getId_opt());

		opzioniBean.setRegolamento(OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_REGOLAMENTO).getTesto_opt());
		opzioniBean.setLavoratore_padre_madre(
				OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_LAVORATORE_PADRE_MADRE).getTesto_opt());
		opzioniBean
				.setFigli_disabili(OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_FIGLI_DISABILI).getTesto_opt());
		opzioniBean.setDisabilita(OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_DISABILITA).getTesto_opt());
		opzioniBean.setMonogenitorialita(
				OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_MONOGENITORIALITA).getTesto_opt());
		opzioniBean.setCura_figli(OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_CURA_FIGLI).getTesto_opt());
		opzioniBean.setAssistenza_familiari(
				OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_ASSISTENZA_FAMILIARI).getTesto_opt());
		opzioniBean.setDistanza_domicilio(OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_DISTANZA).getTesto_opt());

		OpzioneRich radioA = OpzioneRichLocalServiceUtil.getOptionByLabel("30 km");
		opzioniBean.setRadioA(radioA.getTesto_opt());
		opzioniBean.setRadioAId(radioA.getId_opt());

		OpzioneRich radioB = OpzioneRichLocalServiceUtil.getOptionByLabel("50 km");
		opzioniBean.setRadioB(radioB.getTesto_opt());
		opzioniBean.setRadioBId(radioB.getId_opt());

		OpzioneRich radioC = OpzioneRichLocalServiceUtil.getOptionByLabel("100 km");
		opzioniBean.setRadioC(radioC.getTesto_opt());
		opzioniBean.setRadioCId(radioC.getId_opt());

		opzioniBean.setAgevolazioni(OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_NO_AGEVOLAZIONI).getTesto_opt());

		return opzioniBean;
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

	private ModuloRichiesta initModelloRicheista(Richiedente richiedente, OpzioneRichModel opzioneRichDotazione,
			OpzioneRichModel opzioneRich1, OpzioneRichModel opzioneRich2, OpzioneRichModel opzioneRich3,
			OpzioneRichModel opzioneRich4, OpzioneRichModel opzioneRich5, OpzioneRichModel opzioneRich6,
			OpzioneRichModel opzioneRich7, OpzioneRichModel opzioneRich8, OpzioneRichModel opzioneRich9) {

		Opzione opzione;
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

		opzione = new Opzione();
		if (opzioneRichDotazione != null) {
			opzione.setId(0L);
			opzione.setIdDipendenza(opzioneRichDotazione.getId_opt());
			opzione.setTipo(_radio);
			opzione.setPeso(opzioneRichDotazione.getPeso_opt());
		}
		moduloRichiesta.setDotazione(opzione);

		opzione = new Opzione();
		if (opzioneRich1 != null) {
			opzione.setId(opzioneRich1.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkbox);
			opzione.setPeso(opzioneRich1.getPeso_opt());
		}
		moduloRichiesta.setOpzione1(opzione);

		opzione = new Opzione();
		if (opzioneRich2 != null) {
			opzione.setId(opzioneRich2.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkbox);
			opzione.setPeso(opzioneRich2.getPeso_opt());
		}
		moduloRichiesta.setOpzione2(opzione);

		opzione = new Opzione();
		if (opzioneRich3 != null) {
			opzione.setId(opzioneRich3.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkbox);
			opzione.setPeso(opzioneRich3.getPeso_opt());
		}
		moduloRichiesta.setOpzione3(opzione);

		opzione = new Opzione();
		if (opzioneRich4 != null) {
			opzione.setId(opzioneRich4.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkbox);
			opzione.setPeso(opzioneRich4.getPeso_opt());
		}
		moduloRichiesta.setOpzione4(opzione);

		opzione = new Opzione();
		if (opzioneRich5 != null) {
			opzione.setId(opzioneRich5.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkbox);
			opzione.setPeso(opzioneRich5.getPeso_opt());
		}
		moduloRichiesta.setOpzione5(opzione);

		opzione = new Opzione();
		if (opzioneRich6 != null) {
			opzione.setId(opzioneRich6.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkboxWithValue);
			opzione.setPeso(opzioneRich6.getPeso_opt());
		}
		moduloRichiesta.setOpzione6(opzione);

		opzione = new Opzione();
		if (opzioneRich7 != null) {
			opzione.setId(opzioneRich7.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkboxWithValue);
			opzione.setPeso(opzioneRich7.getPeso_opt());
		}
		moduloRichiesta.setOpzione7(opzione);

		opzione = new Opzione();
		if (opzioneRich8 != null) {
			opzione.setId(0L);
			opzione.setIdDipendenza(opzioneRich8.getId_opt());
			opzione.setTipo(_radio);
			opzione.setPeso(opzioneRich8.getPeso_opt());
		}
		moduloRichiesta.setOpzione8(opzione);

		opzione = new Opzione();
		if (opzioneRich9 != null) {
			opzione.setId(opzioneRich9.getId_opt());
			opzione.setIdDipendenza(0L);
			opzione.setTipo(_checkbox);
			opzione.setPeso(opzioneRich9.getPeso_opt());
		}
		moduloRichiesta.setOpzione9(opzione);

		return moduloRichiesta;
	}

	private volatile MefLavoroAgileConfig _configuration;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefLavoroAgileConfig.class, properties);
	}

	@ProcessAction(name = "vaiARiepilogo")
	public void vaiARiepilogo(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Richiedente richiedente = getRichiedente(themeDisplay);
		ModuloRichiesta moduloRichiesta;
		OpzioneRich opzioneRich;
		String testo_opzione;

		OpzioneRich opzioneRichDotazione = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_DOTAZIONE);
		OpzioneRich opzioneRich1 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_REGOLAMENTO);
		OpzioneRich opzioneRich2 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_LAVORATORE_PADRE_MADRE);
		OpzioneRich opzioneRich3 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_FIGLI_DISABILI);
		OpzioneRich opzioneRich4 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_DISABILITA);
		OpzioneRich opzioneRich5 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_MONOGENITORIALITA);
		OpzioneRich opzioneRich6 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_CURA_FIGLI);
		OpzioneRich opzioneRich7 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_ASSISTENZA_FAMILIARI);
		OpzioneRich opzioneRich8 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_DISTANZA);
		OpzioneRich opzioneRich9 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_NO_AGEVOLAZIONI);

		moduloRichiesta = initModelloRicheista(richiedente, opzioneRichDotazione, opzioneRich1, opzioneRich2,
				opzioneRich3, opzioneRich4, opzioneRich5, opzioneRich6, opzioneRich7, opzioneRich8, opzioneRich9);

		String _opzione_testo1 = opzioneRich1.getTesto_opt();
		String _opzione_testo2 = opzioneRich2.getTesto_opt();
		String _opzione_testo3 = opzioneRich3.getTesto_opt();
		String _opzione_testo4 = opzioneRich4.getTesto_opt();
		String _opzione_testo5 = opzioneRich5.getTesto_opt();
		String _opzione_testo6 = opzioneRich6.getTesto_opt();
		String _opzione_testo7 = opzioneRich7.getTesto_opt();
		String _opzione_testo8 = opzioneRich8.getTesto_opt();
		String _opzione_testo9 = opzioneRich9.getTesto_opt();

		String dotaz_inf;
		if (("amministrazione").equals(actionRequest.getParameter("dotaz_inf"))) {
			opzioneRich = OpzioneRichLocalServiceUtil.getOptionByLabel("fornita amministrazione");
		} else {
			opzioneRich = OpzioneRichLocalServiceUtil.getOptionByLabel("propria spettanza");
		}
		dotaz_inf = opzioneRich.getTesto_opt();
		moduloRichiesta.getDotazione().setId(opzioneRich.getId_opt());
		moduloRichiesta.getDotazione().setValore(new String[] { "true" });

		List<String> dichiarazioni_list = new ArrayList<String>();
		if (actionRequest.getParameter("dichiaraz-check1") != null) {
			if (_opzione_testo1.indexOf("<#link>") != -1) {
				_opzione_testo1 = _opzione_testo1.replace("<#link>", "");
			}
			dichiarazioni_list.add(_opzione_testo1);
			moduloRichiesta.getOpzione1().setValore(new String[] { "true" });
		} else {
			moduloRichiesta.getOpzione1().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check2") != null) {
			dichiarazioni_list.add(_opzione_testo2);
			moduloRichiesta.getOpzione2().setValore(new String[] { "true" });
		} else {
			moduloRichiesta.getOpzione2().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check3") != null) {
			dichiarazioni_list.add(_opzione_testo3);
			moduloRichiesta.getOpzione3().setValore(new String[] { "true" });
		} else {
			moduloRichiesta.getOpzione3().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check4") != null) {
			dichiarazioni_list.add(_opzione_testo4);
			moduloRichiesta.getOpzione4().setValore(new String[] { "true" });
		} else {
			moduloRichiesta.getOpzione4().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check5") != null) {
			dichiarazioni_list.add(_opzione_testo5);
			moduloRichiesta.getOpzione5().setValore(new String[] { "true" });
		} else {
			moduloRichiesta.getOpzione5().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check6") != null) {
			testo_opzione = _opzione_testo6;
			testo_opzione = testo_opzione.replaceFirst(
					testo_opzione.substring(testo_opzione.indexOf("<"), testo_opzione.indexOf(">") + 1),
					actionRequest.getParameter("figli_under13"));
			testo_opzione = testo_opzione.replace(
					testo_opzione.substring(testo_opzione.indexOf("<"), testo_opzione.indexOf(">") + 1),
					actionRequest.getParameter("figli_over13"));
			dichiarazioni_list.add(testo_opzione);

			moduloRichiesta.getOpzione6().setValore(new String[] { (String) actionRequest.getParameter("figli_under13"),
					(String) actionRequest.getParameter("figli_over13"), });
		} else {
			moduloRichiesta.getOpzione6().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check7") != null) {
			testo_opzione = _opzione_testo7;
			testo_opzione = testo_opzione.replace(
					testo_opzione.substring(testo_opzione.indexOf("<"), testo_opzione.indexOf(">") + 1),
					actionRequest.getParameter("familiari"));
			dichiarazioni_list.add(testo_opzione);
			moduloRichiesta.getOpzione7().setValore(new String[] { (String) actionRequest.getParameter("familiari") });
		} else {
			moduloRichiesta.getOpzione7().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check8") != null) {
			dichiarazioni_list.add(_opzione_testo8 + " " + actionRequest.getParameter("distance"));
			moduloRichiesta.getOpzione8().setValore(new String[] { actionRequest.getParameter("distance") });
			switch (actionRequest.getParameter("distance")) {
			case "ai 30 km":
				opzioneRich = OpzioneRichLocalServiceUtil.getOptionByLabel("30 km");
				moduloRichiesta.getOpzione8().setPeso(opzioneRich.getPeso_opt());
				moduloRichiesta.getOpzione8().setId(opzioneRich.getId_opt());
				moduloRichiesta.getOpzione8().setValore(new String[] { "true" });
				break;
			case "ai 50 km":
				opzioneRich = OpzioneRichLocalServiceUtil.getOptionByLabel("50 km");
				moduloRichiesta.getOpzione8().setPeso(opzioneRich.getPeso_opt());
				moduloRichiesta.getOpzione8().setId(opzioneRich.getId_opt());
				moduloRichiesta.getOpzione8().setValore(new String[] { "true" });
				break;
			case "ai 100 km":
				opzioneRich = OpzioneRichLocalServiceUtil.getOptionByLabel("100 km");
				moduloRichiesta.getOpzione8().setPeso(opzioneRich.getPeso_opt());
				moduloRichiesta.getOpzione8().setId(opzioneRich.getId_opt());
				moduloRichiesta.getOpzione8().setValore(new String[] { "true" });
				break;
			default:
				break;
			}
		} else {
			moduloRichiesta.getOpzione8().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("dichiaraz-check9") != null) {
			dichiarazioni_list.add(_opzione_testo9);
			moduloRichiesta.getOpzione9().setValore(new String[] { "true" });
		} else {
			moduloRichiesta.getOpzione9().setValore(new String[] { "false" });
		}

		if (actionRequest.getParameter("note") != null) {
			moduloRichiesta.setNote(actionRequest.getParameter("note"));
		} else {
			moduloRichiesta.setNote("");
		}

		// start attachment
		if (actionRequest.getParameter("vecchioAllegato") == null
				|| (("").equals(actionRequest.getParameter("vecchioAllegato"))))
			copyFileToServer(actionRequest, moduloRichiesta, themeDisplay.getUser().getScreenName(),
					"ProgettoIndividuale", "attachRealName");
		else {
			moduloRichiesta.setAllegatoNome(actionRequest.getParameter("attachRealName"));
			moduloRichiesta.setAllegatoMimeType(actionRequest.getParameter("vecchioAllegatoMimeType"));
			moduloRichiesta.setAllegato(new File(actionRequest.getParameter("vecchioAllegato")));
		}
		// end attachment

		actionRequest.setAttribute("fileCustom", actionRequest.getParameter("attachCustomName"));
		actionRequest.setAttribute("dotazione_inform", dotaz_inf);
		actionRequest.setAttribute("dichiarazioni_list", dichiarazioni_list);
		actionRequest.setAttribute("moduloRichiesta", moduloRichiesta);

		actionRequest.setAttribute("navigation", "recap");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

	}

	@ProcessAction(name = "vaiAModifica")
	public void vaiAModifica(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ModuloRichiesta moduloRichiesta = initModelloRicheista(getRichiedente(themeDisplay), null, null, null, null,
				null, null, null, null, null, null);

		JSONObject json_object_richiesta = JSONFactoryUtil
				.createJSONObject((String) actionRequest.getParameter("jsonValues"));
		JSONArray json_array_richiesta = json_object_richiesta.getJSONArray("opzioni");

		moduloRichiesta.getDotazione().setOpzioneByJSON(json_array_richiesta.getJSONObject(0));
		moduloRichiesta.getOpzione1().setOpzioneByJSON(json_array_richiesta.getJSONObject(1));
		moduloRichiesta.getOpzione2().setOpzioneByJSON(json_array_richiesta.getJSONObject(2));
		moduloRichiesta.getOpzione3().setOpzioneByJSON(json_array_richiesta.getJSONObject(3));
		moduloRichiesta.getOpzione4().setOpzioneByJSON(json_array_richiesta.getJSONObject(4));
		moduloRichiesta.getOpzione5().setOpzioneByJSON(json_array_richiesta.getJSONObject(5));
		moduloRichiesta.getOpzione6().setOpzioneByJSON(json_array_richiesta.getJSONObject(6));
		moduloRichiesta.getOpzione7().setOpzioneByJSON(json_array_richiesta.getJSONObject(7));
		moduloRichiesta.getOpzione8().setOpzioneByJSON(json_array_richiesta.getJSONObject(8));
		moduloRichiesta.getOpzione9().setOpzioneByJSON(json_array_richiesta.getJSONObject(9));

		moduloRichiesta.setAllegato(new File(actionRequest.getParameter("Allegato")));
		moduloRichiesta.setAllegatoNome(actionRequest.getParameter("AllegatoRealeNome"));
		moduloRichiesta.setAllegatoMimeType(actionRequest.getParameter("AllegatoMimeType"));

		moduloRichiesta.setNote(actionRequest.getParameter("note"));

		actionRequest.setAttribute("fileCustom", actionRequest.getParameter("attachCustomName"));
		actionRequest.setAttribute("moduloRichiesta", moduloRichiesta);
		actionRequest.setAttribute("flagModifica", true);
		actionRequest.setAttribute("navigation", "form");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	@ProcessAction(name = "invia")
	public void invia(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Richiedente richiedente = getRichiedente(themeDisplay);

		String[] note_splited;
		String note_sanitazed = "";

		String _opzione_testo6 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_CURA_FIGLI).getTesto_opt();
		String _opzione_testo7 = OpzioneRichLocalServiceUtil.getOptionByLabel(LABEL_ASSISTENZA_FAMILIARI)
				.getTesto_opt();
		int _pesoFigliOver13 = Integer
				.parseInt(_opzione_testo6.split("=")[1].substring(0, _opzione_testo6.split("=")[1].indexOf("#")));
		int _pesoFigliUnder13 = Integer
				.parseInt(_opzione_testo6.split("=")[2].substring(0, _opzione_testo6.split("=")[2].indexOf("#")));
		int _pesoFamiliari = Integer
				.parseInt(_opzione_testo7.split("=")[1].substring(0, _opzione_testo7.split("=")[1].indexOf("#")));

		ModuloRichiesta moduloRichiesta = initModelloRicheista(getRichiedente(themeDisplay), null, null, null, null,
				null, null, null, null, null, null);

		JSONObject json_object_richiesta = JSONFactoryUtil
				.createJSONObject((String) actionRequest.getParameter("jsonValues"));
		JSONArray json_array_richiesta = json_object_richiesta.getJSONArray("opzioni");

		moduloRichiesta.getDotazione().setOpzioneByJSON(json_array_richiesta.getJSONObject(0));
		moduloRichiesta.getOpzione1().setOpzioneByJSON(json_array_richiesta.getJSONObject(1));
		moduloRichiesta.getOpzione2().setOpzioneByJSON(json_array_richiesta.getJSONObject(2));
		moduloRichiesta.getOpzione3().setOpzioneByJSON(json_array_richiesta.getJSONObject(3));
		moduloRichiesta.getOpzione4().setOpzioneByJSON(json_array_richiesta.getJSONObject(4));
		moduloRichiesta.getOpzione5().setOpzioneByJSON(json_array_richiesta.getJSONObject(5));
		moduloRichiesta.getOpzione6().setOpzioneByJSON(json_array_richiesta.getJSONObject(6));
		moduloRichiesta.getOpzione7().setOpzioneByJSON(json_array_richiesta.getJSONObject(7));
		moduloRichiesta.getOpzione8().setOpzioneByJSON(json_array_richiesta.getJSONObject(8));
		moduloRichiesta.getOpzione9().setOpzioneByJSON(json_array_richiesta.getJSONObject(9));

		moduloRichiesta.setAllegato(new File((String) actionRequest.getParameter("Allegato")));
		moduloRichiesta.setAllegatoMimeType((String) actionRequest.getParameter("AllegatoMimeType"));

		// moduloRichiesta.setNote(
		// HtmlUtil.escape(actionRequest.getParameter("note")) );
		if (actionRequest.getParameter("note") != null && !"".equals(actionRequest.getParameter("note"))) {
			note_splited = HtmlUtil.escape(actionRequest.getParameter("note"))
					.split(System.getProperty("line.separator"));
			for (int i = 0; i < note_splited.length; i++) {
				note_sanitazed = note_sanitazed + note_splited[i].trim().replaceAll(Pattern.quote("\\"), "&bsol;")
						+ "\\r\\n";
			}
		}
		moduloRichiesta.setNote(note_sanitazed);

		// richiesta lavoro agile params
		long id_richiesta = 0;
		String cognome = richiedente.getCognome();
		String nome = richiedente.getNome();
		long dipartimento = richiedente.getDipartimentoId();
		long direzione = richiedente.getDirezioneId();
		long ufficio = richiedente.getUfficioId();
		String screename = richiedente.getCodiceFiscale();
		String jsonRichiedente = richiedente.toJSON();
		String jsonRichiesta = moduloRichiesta.toJSONOptions().replace("<#note>", moduloRichiesta.getNote());

		// CALCOLO PESO
		int peso_tot = moduloRichiesta.getOpzione4().getPeso() + moduloRichiesta.getOpzione5().getPeso()
				+ moduloRichiesta.getOpzione8().getPeso() + moduloRichiesta.getOpzione9().getPeso();
		if (!("false").equals(moduloRichiesta.getOpzione6().getValore()[0])) {
			peso_tot = peso_tot + Integer.parseInt(moduloRichiesta.getOpzione6().getValore()[0]) * _pesoFigliOver13
					+ Integer.parseInt(moduloRichiesta.getOpzione6().getValore()[1]) * _pesoFigliUnder13;
		}
		if (!("false").equals(moduloRichiesta.getOpzione7().getValore()[0])) {
			peso_tot = peso_tot + Integer.parseInt(moduloRichiesta.getOpzione7().getValore()[0]) * _pesoFamiliari;
		}

		String peso_plus = "false";
		if (("true").equals(moduloRichiesta.getOpzione2().getValore()[0])
				|| ("true").equals(moduloRichiesta.getOpzione3().getValore()[0])) {
			peso_plus = "true";
		}

		String bando = actionRequest.getPreferences().getValue("bando", _configuration.bando());
		Date data_richiesta = new Date();
		String allegato;
		String pdf = "";

		// file creation params
		Long userId = themeDisplay.getUserId();
		File file = moduloRichiesta.getAllegato();
		Long dlFolderId = 0L;
		String folderName = "";
		String title = moduloRichiesta.getAllegato().getName();
		String descrizione = "";
		FileEntry fileEntry = createFileDocumentMedia(actionRequest, userId, dlFolderId, folderName, title, descrizione,
				file);

		if (fileEntry != null) {

			Role ownerRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.OWNER);
			Role siteMemberRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.SITE_MEMBER);
			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
			Role powerUserRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.POWER_USER);

			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), ownerRole.getRoleId(), ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), guestRole.getRoleId(), ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), siteMemberRole.getRoleId(), ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(themeDisplay.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(fileEntry.getFileEntryId()), powerUserRole.getRoleId(), ActionKeys.VIEW);

			allegato = fileEntry.getUuid();
			long richLavAgileId = RichLavAgileLocalServiceUtil.insertRichiestaAgile(id_richiesta, cognome, nome,
					dipartimento, direzione, ufficio, screename, jsonRichiedente, jsonRichiesta, peso_tot, peso_plus,
					bando, data_richiesta, allegato, pdf);

			// controllo esito inserimento: se avvenuto con successo, allora
			// invia email
			if (richLavAgileId != 0) {
				try {
					sendMailNuovaIstanzaLavoroAgile(actionRequest, richLavAgileId, richiedente, moduloRichiesta);

					PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest,
							themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
							PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter("richlavId", String.valueOf(richLavAgileId));
					renderUrl.setParameter("navigation", "detail");
					actionResponse.sendRedirect(renderUrl.toString());

				} catch (Exception e) {
					_log.error("Error in email sending: " + e);
				}
			}

		}
	}

	public FileEntry createFileDocumentMedia(ActionRequest actionRequest, Long userId, Long fatherFolderId,
			String folderName, String title, String description, File file) throws PortalException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long repositoryId = themeDisplay.getScopeGroupId();

		long folderId = 0L;
		if (fatherFolderId != null && !("".equals(folderName) || folderName == null))
			folderId = DLFolderLocalServiceUtil
					.getFolder(themeDisplay.getLayout().getGroupId(), fatherFolderId, folderName).getFolderId();

		String titleDocument = title;
		if ("".equals(titleDocument) || titleDocument == null)
			titleDocument = file.getName();

		String regexDate = "\\([0-9][0-9]\\-[0-9][0-9]\\-[0-9][0-9][0-9][0-9] [0-9][0-9]\\-[0-9][0-9]-[0-9][0-9]\\)";
		StringBuilder titleDL = new StringBuilder();
		titleDL.append(titleDocument.substring(0, titleDocument.lastIndexOf('.')).replaceAll(regexDate, ""));
		titleDL.append(("(") + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) + ")");
		titleDL.append(titleDocument.substring(titleDocument.lastIndexOf('.')));

		String mimeType = MimeTypesUtil.getContentType(file);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);

		List<AssetCategory> asset_category_strumenti = new ArrayList<AssetCategory>(0);
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(AssetCategory.class)
				.add(PropertyFactoryUtil.forName("name").eq("strumenti"));
		try {
			asset_category_strumenti = AssetCategoryLocalServiceUtil.dynamicQuery(query, 0, 1);
		} catch (Exception e) {
			_log.error("Errore nel recupero dell'area tematica: " + e);
		}

		long[] assetCategoryIds = { asset_category_strumenti.get(0).getCategoryId() };
		serviceContext.setAssetCategoryIds(assetCategoryIds);

		FileEntry fileEntry = null;
		InputStream is = new FileInputStream(file);

		try {
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folderId, titleDL.toString(), mimeType,
					titleDL.toString(), description, "", is, file.length(), serviceContext);
		} catch (PortalException e) {
			_log.error(e);
		} finally {
			is.close();
		}

		if (fileEntry != null) {
			_log.info("INFO: - documento " + titleDL.toString() + " creato con successo");
		} else {
			_log.info("ERROR: - errore durante la creazione del documento " + titleDL.toString() + " ");
		}

		return fileEntry;
	}

	@ProcessAction(name = "eventoRichiestaLavoroAgile")
	public void eventoRichiestaLavoroAgile(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException {
		actionRequest.setAttribute("navigation", "gestioneutenti");
	}

	// metodo riepilogativo invio mail (richiamato contestualmente ad un
	// inserimento avvenuto con successo)

	private boolean sendMailNuovaIstanzaLavoroAgile(ActionRequest actionRequest, long richLavAgileId,
			Richiedente richiedente, ModuloRichiesta moduloRichiesta)
			throws PortletModeException, WindowStateException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
		String emailSubject = actionRequest.getPreferences().getValue("emailSubject", _configuration.emailSubject());
		emailSubject = StringUtil.replace(emailSubject, new String[] { "[$IDRICHIESTA$]" },
				new String[] { String.valueOf(richLavAgileId) });
		String emailBody = actionRequest.getPreferences().getValue("emailBody", _configuration.emailBody());
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setPortletMode(LiferayPortletMode.VIEW);
		renderUrl.setParameter("richlavId", String.valueOf(richLavAgileId));
		renderUrl.setParameter("navigation", "dettaglio");
		emailBody = StringUtil.replace(emailBody, new String[] { "[$IDRICHIESTA$]", "[$LINK$]" },
				new String[] { String.valueOf(richLavAgileId), renderUrl.toString() });

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
		if (logUser.getExpandoBridge() != null
				&& logUser.getExpandoBridge().getAttribute(_customFieldUserDirector) != null) {
			String directorId = (String) logUser.getExpandoBridge().getAttribute(_customFieldUserDirector);
			User director;
			try {
				director = getUserByCustomField(themeDisplay.getCompanyId(), _customFieldPersonalId, directorId);
				if (director != null)
					cc_email_list.add(director.getEmailAddress());
			} catch (PortalException e) {
				_log.error("PortalException: " + e);
			}
		}

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

	private User getUserByCustomField(long companyId, String fieldName, String fieldValue) throws PortalException {

		List<ExpandoValue> values = ExpandoValueLocalServiceUtil.getColumnValues(companyId, User.class.getName(),
				ExpandoTableConstants.DEFAULT_TABLE_NAME, fieldName, fieldValue, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ExpandoValue value : values) {
			User user = UserLocalServiceUtil.getUser(value.getClassPK());
			return user;
		}

		return null;
	}

	// going to recap, call this method to copy File Attach (Progetto
	// Individuale) to Server

	private void copyFileToServer(ActionRequest actionRequest, ModuloRichiesta moduloRichiedente, String codiceFiscale,
			String fileParameter, String fileParameterName) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try {
			File uploadedFile = uploadRequest.getFile(fileParameter);
			if (uploadedFile != null && uploadedFile.exists()
					&& !uploadedFile.equals(moduloRichiedente.getAllegato())) {
				moduloRichiedente.setAllegatoMimeType(uploadRequest.getContentType(fileParameter));
				moduloRichiedente.setAllegatoNome((String) actionRequest.getParameter(fileParameterName));
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				StringBuilder stringPath = new StringBuilder();
				stringPath.append(TEMP_PATH);
				stringPath.append("documents");
				stringPath.append(File.separator);
				stringPath.append(themeDisplay.getLayout().getGroupId());
				stringPath.append(File.separator);
				stringPath.append(baseDir);
				stringPath.append(File.separator);
				stringPath.append(codiceFiscale);
				File folder = new File(stringPath.toString());
				moduloRichiedente.setAllegato(
						new File(folder.getAbsolutePath() + File.separator + moduloRichiedente.getAllegatoNome()));
				FileUtil.copyFile(uploadedFile, moduloRichiedente.getAllegato());
			}
		} catch (Exception e) {
			_log.warn(e);
		}
	}

	public void vaiARicerca(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.setAttribute("navigation", "ricerca");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	private JSONArray createRichiestaLavAgileExcelBeanList(ThemeDisplay themeDisplay,
			List<RichLavAgile> rich_lav_agile_list) throws JSONException {

		JSONArray richiesta_lav_agile_excel_jsonarray = JSONFactoryUtil.createJSONArray();

		if (rich_lav_agile_list != null && !rich_lav_agile_list.isEmpty()) {

			for (RichLavAgile richLavAgile : rich_lav_agile_list) {

				RichiestaLavAgileExcelBean richiestaLavAgileExcelBean = new RichiestaLavAgileExcelBean();

				richiestaLavAgileExcelBean.setIstanza(String.valueOf(richLavAgile.getPrimaryKey()));
				richiestaLavAgileExcelBean.setCognome(richLavAgile.getCognome().toUpperCase());
				richiestaLavAgileExcelBean.setNome(richLavAgile.getNome().toUpperCase());
				richiestaLavAgileExcelBean.setCodice_fiscale(richLavAgile.getScreename().toUpperCase());

				String acronimoDip = "";
				try {
					OrganizationChart dipartimento = OrganizationChartLocalServiceUtil
							.getOrganizationChart(richLavAgile.getDipartimento());
					if (dipartimento != null) {
						acronimoDip = dipartimento.getAcronimo();
					}
				} catch (PortalException e) {
					_log.error("Errore nel recupero del dipartimento: " + e);
				}
				richiestaLavAgileExcelBean.setDip(acronimoDip);

				String acronimoDir = "";
				try {
					OrganizationChart direzione = OrganizationChartLocalServiceUtil
							.getOrganizationChart(richLavAgile.getDirezione());
					if (direzione != null) {
						acronimoDir = direzione.getAcronimo();
					}
				} catch (PortalException e) {
					_log.error("Errore nel recupero della direzione: " + e);
				}
				richiestaLavAgileExcelBean.setDir(acronimoDir);

				String priorita = "";
				if ("true".equalsIgnoreCase(richLavAgile.getPeso_plus())) {
					priorita = "X";
				}
				richiestaLavAgileExcelBean.setPriorita(priorita);

				richiestaLavAgileExcelBean.setPunteggio(String.valueOf(richLavAgile.getPeso_tot()));

				JSONObject json_object_richiedente = JSONFactoryUtil
						.createJSONObject(richLavAgile.getJson_richiedente());
				String data_nascita = json_object_richiedente.getString("data_nascita");
				richiestaLavAgileExcelBean.setData_nascita(data_nascita);

				String flag_2a = "";
				String flag_2b = "";
				String flag_3a = "";
				String flag_3b = "";
				String value_3c1 = "";
				String value_3c2 = "";
				String value_3d = "";
				String value_3e = "";
				String flag_3f = "";

				JSONObject json_object_richiesta = JSONFactoryUtil.createJSONObject(richLavAgile.getJson_richiesta());
				JSONArray json_array_richiesta = json_object_richiesta.getJSONArray("opzioni");

				for (int i = 0; i < json_array_richiesta.length(); i++) {
					JSONObject json_object_opzione = json_array_richiesta.getJSONObject(i);
					// CASO: checkbox semplice
					if ("checkbox".equalsIgnoreCase((json_object_opzione).getString("type"))
							&& json_object_opzione.getString("valore").contains("true")) {
						OpzioneRich opzioneSimpleCheck = OpzioneRichLocalServiceUtil
								.fetchOpzioneRich(Long.parseLong((json_object_opzione).getString("id")));
						if (opzioneSimpleCheck != null) {
							String labelOpzione = opzioneSimpleCheck.getLabel_opt();

							switch (labelOpzione) {
							case LABEL_OPT_LAVORATORE_PADRE_MADRE:
								flag_2a = "X";
								break;
							case LABEL_OPT_FIGLI_DISABILI:
								flag_2b = "X";
								break;
							case LABEL_OPT_DISABILITA_PSICO_FISICA:
								flag_3a = "X";
								break;
							case LABEL_OPT_MONOGENITORIALITA:
								flag_3b = "X";
								break;
							case LABEL_OPT_NO_AGEVOLAZIONI:
								flag_3f = "X";
								break;
							}

						}
						// CASO: radio
					} else if ("radio".equalsIgnoreCase((json_object_opzione).getString("type"))
							&& json_object_opzione.getString("valore").contains("true")) {
						OpzioneRich opzioneRadio = OpzioneRichLocalServiceUtil
								.fetchOpzioneRich(Long.parseLong((json_object_opzione).getString("id")));
						OpzioneRich opzioneDip = OpzioneRichLocalServiceUtil
								.fetchOpzioneRich(Long.parseLong((json_object_opzione).getString("id_dip")));
						if (opzioneRadio != null && opzioneDip != null) {
							String labelOpzioneDip = opzioneDip.getLabel_opt();
							if (LABEL_OPT_DISTANZA_DOMICILIO_LAVORO.equalsIgnoreCase(labelOpzioneDip)) {
								value_3e = opzioneRadio.getLabel_opt();
							}
						}
						// CASO: checkbox con input
					} else if ("checkboxWithValue".equalsIgnoreCase((json_object_opzione).getString("type"))
							&& !(json_object_opzione).getString("valore").contains("false")) {
						OpzioneRich opzioneInputCheck = OpzioneRichLocalServiceUtil
								.fetchOpzioneRich(Long.parseLong((json_object_opzione).getString("id")));
						if (opzioneInputCheck != null) {
							String labelOpzione = opzioneInputCheck.getLabel_opt();
							String[] arr = new String[json_object_opzione.getJSONArray("valore").length()];
							for (int k = 0; k < json_object_opzione.getJSONArray("valore").length(); k++) {
								arr[k] = json_object_opzione.getJSONArray("valore").getString(k);
							}
							// caso 2 input
							if (LABEL_OPT_ESIGENZA_CURA_FIGLI.equalsIgnoreCase(labelOpzione)) {
								value_3c1 = arr[0];
								value_3c2 = arr[1];
								// caso 1 input
							} else if (LABEL_OPT_ASSISTENZA_FAMILIARI.equalsIgnoreCase(labelOpzione)) {
								value_3d = arr[0];
							}
						}
					}
				}

				richiestaLavAgileExcelBean.setFlag_2a(flag_2a);
				richiestaLavAgileExcelBean.setFlag_2b(flag_2b);
				richiestaLavAgileExcelBean.setFlag_3a(flag_3a);
				richiestaLavAgileExcelBean.setFlag_3b(flag_3b);
				richiestaLavAgileExcelBean.setValue_3c1(value_3c1);
				richiestaLavAgileExcelBean.setValue_3c2(value_3c2);
				richiestaLavAgileExcelBean.setValue_3d(value_3d);
				richiestaLavAgileExcelBean.setValue_3e(value_3e);
				richiestaLavAgileExcelBean.setFlag_3f(flag_3f);

				String nomeAllegato = "";
				String uuidAllegato = richLavAgile.getAllegato();
				if (richLavAgile.getPdf() != null && !("").equals(richLavAgile.getPdf())) {
					uuidAllegato = richLavAgile.getPdf();
				}
				DLFileEntry fileEntryAllegato = DLFileEntryLocalServiceUtil
						.fetchDLFileEntryByUuidAndGroupId(uuidAllegato, themeDisplay.getLayout().getGroupId());
				if (fileEntryAllegato != null) {
					nomeAllegato = fileEntryAllegato.getFileName();
					long fileEntryAllegatoSize = (fileEntryAllegato.getSize()) / 1024;
					fileEntryAllegatoSize = Math.round((fileEntryAllegatoSize));
					StringBuilder sbNomeAllegato = new StringBuilder();
					sbNomeAllegato.append(nomeAllegato.substring(0, nomeAllegato.indexOf("(")));
					sbNomeAllegato.append(nomeAllegato.substring((nomeAllegato.lastIndexOf(")") + 1)));
					sbNomeAllegato.append(" (");
					sbNomeAllegato.append(String.valueOf(fileEntryAllegatoSize));
					sbNomeAllegato.append(" KB)");
					nomeAllegato = sbNomeAllegato.toString();
				}
				richiestaLavAgileExcelBean.setAllegato(nomeAllegato);

				String note = json_object_richiesta.getString("note");
				richiestaLavAgileExcelBean.setNote(HtmlUtil.unescape(note).replace("bsol", "\\"));

				richiesta_lav_agile_excel_jsonarray.put(richiestaLavAgileExcelBean.toJSONObject());

			}

		}

		return richiesta_lav_agile_excel_jsonarray;

	}

	// IMEF-1780: check if isValidRequestInsertCondition (current date within
	// the validity range + richiedenteLavAgilePlus role)
	private boolean isValidRequestInsertCondition(RenderRequest renderRequest, ThemeDisplay themeDisplay,
			boolean booleanRichiedenteLavAgile, boolean booleanLayoutViewPermissionRichiedenteLavAgile,
			boolean booleanRichiedenteLavAgilePlus, boolean booleanLayoutViewPermissionRichiedenteLavAgilePlus) {

		// check if the current date is within the validity range
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		String dataInizioInserimentoRichiesta = renderRequest.getPreferences()
				.getValue("dataInizioInserimentoRichiesta", _configuration.dataInizioInserimentoRichiesta());
		String oraInizioInserimentoRichiesta = renderRequest.getPreferences().getValue("oraInizioInserimentoRichiesta",
				_configuration.oraInizioInserimentoRichiesta());
		StringBuilder inizioInserimentoRichiestaSB = new StringBuilder();
		inizioInserimentoRichiestaSB.append(dataInizioInserimentoRichiesta);
		inizioInserimentoRichiestaSB.append(" ");
		inizioInserimentoRichiestaSB.append(oraInizioInserimentoRichiesta);
		String inizioInserimentoRichiestaString = inizioInserimentoRichiestaSB.toString();
		Date inizioInserimentoRichiestaDate = null;
		try {
			inizioInserimentoRichiestaDate = sdf.parse(inizioInserimentoRichiestaString);
		} catch (ParseException e) {
			_log.error("Error in parsing inizioInserimentoRichiesta date: " + e);
		}

		String dataFineInserimentoRichiesta = renderRequest.getPreferences().getValue("dataFineInserimentoRichiesta",
				_configuration.dataFineInserimentoRichiesta());
		String oraFineInserimentoRichiesta = renderRequest.getPreferences().getValue("oraFineInserimentoRichiesta",
				_configuration.oraFineInserimentoRichiesta());
		StringBuilder fineInserimentoRichiestaSB = new StringBuilder();
		fineInserimentoRichiestaSB.append(dataFineInserimentoRichiesta);
		fineInserimentoRichiestaSB.append(" ");
		fineInserimentoRichiestaSB.append(oraFineInserimentoRichiesta);
		String fineInserimentoRichiestaString = fineInserimentoRichiestaSB.toString();
		Date fineInserimentoRichiestaDate = null;
		try {
			fineInserimentoRichiestaDate = sdf.parse(fineInserimentoRichiestaString);
		} catch (ParseException e) {
			_log.error("Error in parsing fineInserimentoRichiesta date: " + e);
		}

		Date currentDate = new Date();

		boolean dateInRange = false;

		if (inizioInserimentoRichiestaDate != null && fineInserimentoRichiestaDate != null) {
			dateInRange = inizioInserimentoRichiestaDate.compareTo(currentDate)
					* currentDate.compareTo(fineInserimentoRichiestaDate) >= 0;
		}

		boolean requestInsertConditionOK = false;

		if ((booleanRichiedenteLavAgile && booleanLayoutViewPermissionRichiedenteLavAgile && dateInRange)
				|| (booleanRichiedenteLavAgilePlus && booleanLayoutViewPermissionRichiedenteLavAgilePlus)) {
			requestInsertConditionOK = true;
		}

		return requestInsertConditionOK;
	}

	private String vaiASezioneAllegatoIsValid(RenderRequest renderRequest, ThemeDisplay themeDisplay,
			boolean booleanRichiedenteLavAgile, boolean booleanLayoutViewPermissionRichiedenteLavAgile,
			boolean booleanRichiedenteLavAgilePlus, boolean booleanLayoutViewPermissionRichiedenteLavAgilePlus) {

		String dataInizioInserimentoAllegato = renderRequest.getPreferences().getValue("dataInizioInserimentoAllegato",
				_configuration.dataInizioInserimentoAllegato());
		String oraInizioInserimentoAllegato = renderRequest.getPreferences().getValue("oraInizioInserimentoAllegato",
				_configuration.oraInizioInserimentoAllegato());
		String dataFineInserimentoAllegato = renderRequest.getPreferences().getValue("dataFineInserimentoAllegato",
				_configuration.dataFineInserimentoAllegato());
		String oraFineInserimentoAllegato = renderRequest.getPreferences().getValue("oraFineInserimentoAllegato",
				_configuration.oraFineInserimentoAllegato());

		String dataOrarioInizio = dataInizioInserimentoAllegato.concat(" " + oraInizioInserimentoAllegato);
		String dataOrarioFine = dataFineInserimentoAllegato.concat(" " + oraFineInserimentoAllegato);

		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Date insertDataAllegatoInizio = null;
		try {
			insertDataAllegatoInizio = sdfDate.parse(dataOrarioInizio);
		} catch (ParseException e) {
			_log.error("Error in parsing inizioInserimentoAllegato date: " + e);
		}
		Date insertDataAllegatoFine = null;
		try {
			insertDataAllegatoFine = sdfDate.parse(dataOrarioFine);
		} catch (ParseException e) {
			_log.error("Error in parsing fineInserimentoAllegato date: " + e);
		}

		Date date = new Date();

		boolean dateInRange = false;

		if (insertDataAllegatoInizio != null && insertDataAllegatoFine != null) {
			dateInRange = insertDataAllegatoInizio.compareTo(date) * date.compareTo(insertDataAllegatoFine) >= 0;
		}

		boolean booleanUtenteAccordoAllegatoPlus = false;
		boolean booleanLayoutViewPermissionUtenteAccordoAllegatoPlus = false;

		Role utenteAccordoAllegatoPlus = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(),
				NOME_RUOLO_UTENTE_ACCORDO_ALLEGATO);

		if (utenteAccordoAllegatoPlus != null) {
			booleanUtenteAccordoAllegatoPlus = UserLocalServiceUtil.hasRoleUser(utenteAccordoAllegatoPlus.getRoleId(),
					themeDisplay.getUserId());
			try {
				booleanLayoutViewPermissionUtenteAccordoAllegatoPlus = ResourcePermissionLocalServiceUtil
						.hasResourcePermission(themeDisplay.getCompanyId(), Layout.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL,
								String.valueOf(themeDisplay.getLayout().getPrimaryKey()),
								utenteAccordoAllegatoPlus.getRoleId(), ActionKeys.VIEW);
			} catch (PortalException e) {
				_log.error("Error in retrieve layout view permission for " + NOME_RUOLO_UTENTE_ACCORDO_ALLEGATO
						+ " role: " + e);
			}
		}

		// boolean resultVisibilitaAllegato = false;
		String msgNuovoAllegato = null;
		if ((((booleanRichiedenteLavAgile && booleanLayoutViewPermissionRichiedenteLavAgile)
				|| (booleanRichiedenteLavAgilePlus && booleanLayoutViewPermissionRichiedenteLavAgilePlus))
				&& dateInRange)
				|| (booleanUtenteAccordoAllegatoPlus && booleanLayoutViewPermissionUtenteAccordoAllegatoPlus)) {

			msgNuovoAllegato = renderRequest.getPreferences().getValue("msgNuovoAllegato",
					_configuration.msgNuovoAllegato());
			msgNuovoAllegato = StringUtil.replace(msgNuovoAllegato,
					new String[] { "[$DATAFINEINSERIMENTOALLEGATO$]", "[$ORAFINEINSERIMENTOALLEGATO$]" },
					new String[] { dataFineInserimentoAllegato, oraFineInserimentoAllegato });

			// resultVisibilitaAllegato = true;
		}

		return msgNuovoAllegato;

	}

	private boolean disableUpdateNuovoAllegatoOORange(RenderRequest renderRequest, ThemeDisplay themeDisplay,
			boolean booleanRichiedenteLavAgile, boolean booleanLayoutViewPermissionRichiedenteLavAgile,
			boolean booleanRichiedenteLavAgilePlus, boolean booleanLayoutViewPermissionRichiedenteLavAgilePlus,
			boolean booleanSegreteriaLavAgile, boolean booleanLayoutViewPermissionSegreteriaLavAgile) {

		String dataInizioInserimentoAllegato = renderRequest.getPreferences().getValue("dataInizioInserimentoAllegato",
				_configuration.dataInizioInserimentoAllegato());
		String oraInizioInserimentoAllegato = renderRequest.getPreferences().getValue("oraInizioInserimentoAllegato",
				_configuration.oraInizioInserimentoAllegato());
		String dataFineInserimentoAllegato = renderRequest.getPreferences().getValue("dataFineInserimentoAllegato",
				_configuration.dataFineInserimentoAllegato());
		String oraFineInserimentoAllegato = renderRequest.getPreferences().getValue("oraFineInserimentoAllegato",
				_configuration.oraFineInserimentoAllegato());

		String dataOrarioInizio = dataInizioInserimentoAllegato.concat(" " + oraInizioInserimentoAllegato);
		String dataOrarioFine = dataFineInserimentoAllegato.concat(" " + oraFineInserimentoAllegato);

		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Date insertDataAllegatoInizio = null;
		try {
			insertDataAllegatoInizio = sdfDate.parse(dataOrarioInizio);
		} catch (ParseException e) {
			_log.error("Error in parsing insertDataAllegatoInizio date: " + e);
		}
		Date insertDataAllegatoFine = null;
		try {
			insertDataAllegatoFine = sdfDate.parse(dataOrarioFine);
		} catch (ParseException e) {
			_log.error("Error in parsing insertDataAllegatoFine date: " + e);
		}

		Date date = new Date();

		boolean dateInRange = false;

		if (insertDataAllegatoInizio != null && insertDataAllegatoFine != null) {
			dateInRange = insertDataAllegatoInizio.compareTo(date) * date.compareTo(insertDataAllegatoFine) >= 0;
		}

		boolean booleanUtenteAccordoAllegatoPlus = false;
		boolean booleanLayoutViewPermissionUtenteAccordoAllegatoPlus = false;

		Role utenteAccordoAllegatoPlus = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(),
				NOME_RUOLO_UTENTE_ACCORDO_ALLEGATO);

		if (utenteAccordoAllegatoPlus != null) {
			booleanUtenteAccordoAllegatoPlus = UserLocalServiceUtil.hasRoleUser(utenteAccordoAllegatoPlus.getRoleId(),
					themeDisplay.getUserId());
			try {
				booleanLayoutViewPermissionUtenteAccordoAllegatoPlus = ResourcePermissionLocalServiceUtil
						.hasResourcePermission(themeDisplay.getCompanyId(), Layout.class.getName(),
								ResourceConstants.SCOPE_INDIVIDUAL,
								String.valueOf(themeDisplay.getLayout().getPrimaryKey()),
								utenteAccordoAllegatoPlus.getRoleId(), ActionKeys.VIEW);
			} catch (PortalException e) {
				_log.error("Error in retrieve layout view permission for " + NOME_RUOLO_UTENTE_ACCORDO_ALLEGATO
						+ " role: " + e);
			}
		}

		boolean flagDisableUpdateNuovoAllegatoOORange = false;

		if ((!dateInRange
				&& ((booleanRichiedenteLavAgile && booleanLayoutViewPermissionRichiedenteLavAgile)
						|| (booleanRichiedenteLavAgilePlus && booleanLayoutViewPermissionRichiedenteLavAgilePlus))
				&& (!booleanUtenteAccordoAllegatoPlus && booleanLayoutViewPermissionUtenteAccordoAllegatoPlus))
				|| (booleanSegreteriaLavAgile && booleanLayoutViewPermissionSegreteriaLavAgile
						&& !booleanRichiedenteLavAgile && booleanLayoutViewPermissionRichiedenteLavAgile
						&& !booleanRichiedenteLavAgilePlus && booleanLayoutViewPermissionRichiedenteLavAgilePlus
						&& !booleanUtenteAccordoAllegatoPlus && booleanLayoutViewPermissionUtenteAccordoAllegatoPlus)) {
			flagDisableUpdateNuovoAllegatoOORange = true;
		}

		return flagDisableUpdateNuovoAllegatoOORange;

	}

}