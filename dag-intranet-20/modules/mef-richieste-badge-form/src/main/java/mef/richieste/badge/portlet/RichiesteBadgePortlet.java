package mef.richieste.badge.portlet;

import com.intranet.mef.central.service.CentralInvokerLocalServiceUtil;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.ManagerOfficesBind;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.ManagerOfficesBindLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import mef.richieste.badge.bean.ModuloRichiedente;
import mef.richieste.badge.bean.Richiedente;
import mef.richieste.badge.bean.RichiestaBadgeExcelBean;
import mef.richieste.badge.bean.RichiestaInScadenzaItemBean;
import mef.richieste.badge.bean.RisultatoRicercaUtente;
import mef.richieste.badge.util.EmailSender;
import mef.richieste.badge.util.ExcelWriter;
import mef.richieste.badge.util.ProrogaMailUtil;
import servizio.richieste.badge.mef.model.GestioneUtentiWrapper;
import servizio.richieste.badge.mef.model.OggettoRichiesta;
import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.model.SediEsterne;
import servizio.richieste.badge.mef.model.StatoRichiesta;
import servizio.richieste.badge.mef.service.AnaDipExtLocalServiceUtil;
import servizio.richieste.badge.mef.service.GestioneUtentiLocalServiceUtil;
import servizio.richieste.badge.mef.service.OggettoRichiestaLocalServiceUtil;
import servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil;
import servizio.richieste.badge.mef.service.SediEsterneLocalServiceUtil;
import servizio.richieste.badge.mef.service.StatoRichiestaLocalServiceUtil;
import mef.dowloader.dml.DownloadDml;
import mef.richiesta.gest.pos.model.Corridoio;
import mef.richiesta.gest.pos.model.FuoriPorta;
import mef.richiesta.gest.pos.model.Piano;
import mef.richiesta.gest.pos.model.Sede;
import mef.richiesta.gest.pos.service.CorridoioLocalServiceUtil;
import mef.richiesta.gest.pos.service.FuoriPortaLocalServiceUtil;
import mef.richiesta.gest.pos.service.PianoLocalServiceUtil;
import mef.richiesta.gest.pos.service.SedeLocalServiceUtil;


@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=mef-richieste-badge-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class RichiesteBadgePortlet extends MVCPortlet {

	private static final String TEMP_PATH = "/wos1/java/products/liferay/tmp/";
	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserDirector = "idDirector";
	private final String _customFieldUserPersonal = "personalId";

	private final String _roledirigente = "Dirigente";
	private final String _abilitatoBadge = "abilitatoBadge";
	private final String _delegatoBadge = "delegatoBadge";

	public static final String _gestoreInterno = "gestoreIntBadge";
	public static final String _gestoreEsterno = "gestoreExtBadge_";

	private static final Log _log = LogFactoryUtil.getLog(RichiesteBadgePortlet.class);
	private final static String baseDir = "/richieste/rimborsiTrasporti";
	private static String ROOT_FOLDER_NAME = "com.liferay.portal.kernel.util.TempFileEntryUtil";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	private Richiedente createStubRichiedente() {
		Richiedente richiedente = new Richiedente();
		richiedente.setNome("");
		richiedente.setCognome("");
		richiedente.setCodiceFiscale("");
		richiedente.setTelefono("");
		richiedente.setDirezione("");
		richiedente.setEmail("");
		richiedente.setEmailDirigente("");
		richiedente.setPalazzina("");
		richiedente.setPiano("");
		richiedente.setScala("");
		richiedente.setStanza("");
		richiedente.setUbicazione("");
		richiedente.setUfficioRichiedente("");
		return richiedente;
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		_log.info("Dentro del doview");
		
		 /* mod temp - svuota richieste badges
		List<RichiestaBadge> richiestaBadges = RichiestaBadgeLocalServiceUtil.getRichiestaBadges(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (RichiestaBadge richiestaBadge : richiestaBadges) {
			RichiestaBadgeLocalServiceUtil.deleteRichiestaBadge(richiestaBadge);
		}
		*/		
		
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String idOrgChart = (String) user.getExpandoBridge().getAttribute("idOrgChart");
		//String idOrgChart ="24992";
		Long userId = (Long) user.getUserId();
		String navigation = (String) renderRequest.getAttribute("navigation");

		String urlBasePath = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getLayout().getGroupId() + StringPool.SLASH;

		// recupero ruoli utente
		boolean dirigente = false;
		boolean abilitatoBadge = false;
		boolean delegatoBadge = false;
		boolean gestoreInterno = false;
		boolean gestoreEsterno = false;
		List<String> listaGestoriExt = new ArrayList<>();
		List<String> roles_list = getRolesFromUser(themeDisplay);
		if (roles_list.contains(_abilitatoBadge)) {
			abilitatoBadge = true;
		}
		if (roles_list.contains(_delegatoBadge)) {
			delegatoBadge = true;
		}
		if (roles_list.contains(_roledirigente)) {
			dirigente = true;
		}
		if (roles_list.contains(_gestoreInterno)) {
			gestoreInterno = true;
		}
		if (roles_list.contains(_gestoreEsterno)) {
			gestoreEsterno = true;
			listaGestoriExt = getGestoriEsterniRoles(themeDisplay);
		}

		renderRequest.setAttribute("roleDirigente", dirigente);
		renderRequest.setAttribute("roleDelegato", delegatoBadge);
		renderRequest.setAttribute("roleAbilitato", abilitatoBadge);
		renderRequest.setAttribute("roleGestoreInt", gestoreInterno);
		renderRequest.setAttribute("roleGestoreExt", gestoreEsterno);

		if (navigation == null || (navigation != null && ("inserimentobadge").equalsIgnoreCase(navigation))) {
			Richiedente richiedente = createRichiedenteByTheme(themeDisplay);
			
			
			
			/*Mod comboz temp per test in collaudo */
			richiedente.setCognome("Chirinos");
			richiedente.setNome("Edgar");
			richiedente.setDipartimento("Informatica");
			richiedente.setDirezione("Informatica");
			richiedente.setUfficioRichiedente("Casal boccone");
			
			/**/
			
			
			
			
			
			
			
			
			renderRequest.setAttribute("richiedente", richiedente);
		}

		if (gestoreInterno || gestoreEsterno) {

			boolean is_last = true;
			boolean is_internal = true;
			long id_siap_sede = 0L;

			List<Long> listaStati = new ArrayList<>();
			List<StatoRichiesta> statoRichApprovata = StatoRichiestaLocalServiceUtil
					.findStatoByDescrizione("APPROVATA DAL DIRIGENTE");

			if (statoRichApprovata != null && !statoRichApprovata.isEmpty()) {
				listaStati.add(statoRichApprovata.get(0).getId_stato());
			}
			List<RichiestaBadge> listaRichiesteGestoreInt = new ArrayList<>();
			List<RichiestaBadge> listaRichiesteGestoreExt = new ArrayList<>();

			if (gestoreInterno) {
				listaRichiesteGestoreInt = RichiestaBadgeLocalServiceUtil.findRichiestaByDataRuoloSede(null, null,
						is_last, is_internal, statoRichApprovata.get(0).getId_stato(), id_siap_sede);
				
//				_log.info("--------------------------listaRichiesteGestoreInt--------------------------------------");
//				for (Iterator iterator = listaRichiesteGestoreInt.iterator(); iterator.hasNext();) {
//					RichiestaBadge richiestaBadge = (RichiestaBadge) iterator.next();
//					_log.info("-"+richiestaBadge.getNome_intestatario()+" "+richiestaBadge.getCognome_intestatario()+" "+richiestaBadge.getId_stato());
//				}
//				_log.info("--------------------------------------------------------------------------------------");

			}

			if (gestoreEsterno) {

				if (listaGestoriExt != null && !listaGestoriExt.isEmpty()) {

					for (String gestoreRole : listaGestoriExt) {

						SediEsterne sede = null;

						if (SediEsterneLocalServiceUtil
								.getSediEsterneByAcronimoSede(gestoreRole.split("_")[1].trim()) != null
								&& !SediEsterneLocalServiceUtil.getSediEsterneByAcronimoSede(gestoreRole.split("_")[1])
										.isEmpty()) {
							sede = SediEsterneLocalServiceUtil
									.getSediEsterneByAcronimoSede(gestoreRole.split("_")[1].trim()).get(0);
						}
						if (sede != null) {
							id_siap_sede = sede.getId_sedesiap();
						}
						is_internal = false;
						
						listaRichiesteGestoreExt.addAll( RichiestaBadgeLocalServiceUtil.findRichiestaByDataRuoloSede(null,
								null, is_last, is_internal, statoRichApprovata.get(0).getId_stato(), id_siap_sede) );
					}
					
//					_log.info("--------------------------listaRichiesteGestoreExt--------------------------------------");
//					for (Iterator iterator = listaRichiesteGestoreExt.iterator(); iterator.hasNext();) {
//						RichiestaBadge richiestaBadge = (RichiestaBadge) iterator.next();
//						_log.info("-"+richiestaBadge.getNome_intestatario()+" "+richiestaBadge.getCognome_intestatario()+" "+richiestaBadge.getId_stato());
//					}
//					_log.info("--------------------------------------------------------------------------------------");
				}
			}

			PortletSession session = renderRequest.getPortletSession();
			// pagination
			String itemsPerPage = renderRequest.getPreferences().getValue("itemsPerPage",
					Integer.toString(_configuration.itemsPerPage()));

			if (renderRequest.getAttribute("daRicerca") != null) {
				
				session.setAttribute("listaRichiesteGestoreIntTot", null, PortletSession.APPLICATION_SCOPE);
				session.setAttribute("listaRichiesteGestoreExtTot", null, PortletSession.APPLICATION_SCOPE);

				renderRequest.setAttribute("listaRichiesteGestoreExt", null);
				renderRequest.setAttribute("listaRichiesteGestoreInt", null);
			} else {

				List<RichiestaBadge> listdefext = null;
				List<RichiestaBadge> listdefint = null;
				int pageRichiesteEsterne = 1;
				int numPageRichiesteEsterne = 0;
				int pageRichiesteInterne = 1;
				int numPageRichiesteInterne = 0;
				List<List<RichiestaBadge>> listPagesExt = listPaginationRichieste(itemsPerPage,
						listaRichiesteGestoreExt);
				List<List<RichiestaBadge>> listPagesInt = listPaginationRichieste(itemsPerPage,
						listaRichiesteGestoreInt);

				if (listPagesExt != null && !listPagesExt.isEmpty()) {
					numPageRichiesteEsterne = listPagesExt.size();
				}

				if (listPagesInt != null && !listPagesInt.isEmpty()) {
					numPageRichiesteInterne = listPagesInt.size();

				}

				// devo prendere dal parametro pagination settato nel metodo
				// pagina

				if (renderRequest.getAttribute("listaRichiesteGestoreExt") != null) {

					listdefext = (List<RichiestaBadge>) renderRequest.getAttribute("listaRichiesteGestoreExt");

				} else {

					if (listPagesExt != null && !listPagesExt.isEmpty()) {

						listdefext = listPagesExt.get(0);
					}

				}

				if (renderRequest.getAttribute("listaRichiesteGestoreInt") != null) {

					listdefint = (List<RichiestaBadge>) renderRequest.getAttribute("listaRichiesteGestoreInt");

				} else {

					if (listPagesInt != null && !listPagesInt.isEmpty()) {

						listdefint = listPagesInt.get(0);

					}

				}

				session.setAttribute("listaRichiesteGestoreExtTot", listPagesExt, PortletSession.APPLICATION_SCOPE);
				session.setAttribute("listaRichiesteGestoreIntTot", listPagesInt, PortletSession.APPLICATION_SCOPE);

				renderRequest.setAttribute("listaRichiesteGestoreExt", listdefext);
				renderRequest.setAttribute("listaRichiesteGestoreInt", listdefint);

				if (renderRequest.getAttribute("pageRichiesteEsterne") != null)
					pageRichiesteEsterne = (Integer) renderRequest.getAttribute("pageRichiesteEsterne");

				if (renderRequest.getAttribute("pageRichiesteInterne") != null)
					pageRichiesteInterne = (Integer) renderRequest.getAttribute("pageRichiesteInterne");

				renderRequest.setAttribute("pageRichiesteEsterne", pageRichiesteEsterne);
				renderRequest.setAttribute("numPageRichiesteEsterne", numPageRichiesteEsterne);
				renderRequest.setAttribute("pageRichiesteInterne", pageRichiesteInterne);
				renderRequest.setAttribute("numPageRichiesteInterne", numPageRichiesteInterne);
				renderRequest.setAttribute("totalSize", 0);
			}
		}

		Integer pageRichieste = (Integer) renderRequest.getAttribute("pageRichieste");
		Integer numPageRichieste = (Integer) renderRequest.getAttribute("numPageRichieste");

		if (pageRichieste != null && numPageRichieste != null) {
			renderRequest.setAttribute("pageRichieste", pageRichieste);
			renderRequest.setAttribute("numPageRichieste", numPageRichieste);
		} else {
			renderRequest.setAttribute("pageRichieste", 1);
			renderRequest.setAttribute("numPageRichieste", 1);
		}

		renderRequest.setAttribute("idOrgChart", idOrgChart);
		renderRequest.setAttribute("userId", userId);
		renderRequest.setAttribute(MefRichiesteBadgeConfig.class.getName(), _configuration);

		Set<OrganizationChart> uffici_by_dirigente_list = new HashSet<OrganizationChart>(0);

		if (dirigente || delegatoBadge) {
			String personIdDir = null;
			if (user != null) {
				if (dirigente) {
					personIdDir = (String) user.getExpandoBridge().getAttribute(_customFieldUserPersonal);
				} else if (delegatoBadge) {
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

		renderRequest.setAttribute("uffici", uffici_by_dirigente_list);

		
		
		
		
		List<OggettoRichiesta> oggettoRichiestaList = OggettoRichiestaLocalServiceUtil
				.getOggettoRichiestas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		
		

		
		List<SediEsterne> sediEsterneList = SediEsterneLocalServiceUtil.getSediEsternes(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		renderRequest.setAttribute("urlBasePath", urlBasePath);
		renderRequest.setAttribute("oggettoRichiestaList", oggettoRichiestaList);
		renderRequest.setAttribute("sediEsterneList", sediEsterneList);
		
		/*Mod comboz*/
		getListGestionePosizione(renderRequest);
		
		super.doView(renderRequest, renderResponse);

	}

	private void getListGestionePosizione(PortletRequest request) {
		
		/* Creazione dati di test
		
		List<Sede> listaSedi = SedeLocalServiceUtil.getSedes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Sede sede : listaSedi) {
			SedeLocalServiceUtil.deleteSede(sede);
		}
		
		List<Piano> listaPiani = PianoLocalServiceUtil.getPianos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Piano piano : listaPiani) {
			PianoLocalServiceUtil.deletePiano(piano);
		}
		
		List<Corridoio> listaCorridoi = CorridoioLocalServiceUtil.getCorridoios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Corridoio corridoio : listaCorridoi) {
			CorridoioLocalServiceUtil.deleteCorridoio(corridoio);
		}
		
		List<FuoriPorta> listaFuoriPorta = FuoriPortaLocalServiceUtil.getFuoriPortas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (FuoriPorta fuoriPorta : listaFuoriPorta) {
			FuoriPortaLocalServiceUtil.deleteFuoriPorta(fuoriPorta);
		}
		
		long id = CounterLocalServiceUtil.increment(Sede.class.getName());
		Sede sede = SedeLocalServiceUtil.createSede(-1);
		sede.setId_pk_sede(id);
		sede.setId_sede(id);
		sede.setCod_sede("sede_001");
		sede.setDesc("XX Settembre");
		SedeLocalServiceUtil.addSede(sede);
	
		long idP = CounterLocalServiceUtil.increment(Piano.class.getName());
		Piano piano = PianoLocalServiceUtil.createPiano(-1);
		piano.setId_pk_piano(idP);
		piano.setId_piano(idP);
		piano.setId_sede(id);
		piano.setDesc("PTE");
		PianoLocalServiceUtil.addPiano(piano);
		
		long idC = CounterLocalServiceUtil.increment(Corridoio.class.getName());
		Corridoio corridoio = CorridoioLocalServiceUtil.createCorridoio(-1);
		corridoio.setId_pk_corridoio(idC);
		corridoio.setId_corridoio(idC);
		corridoio.setId_piano(idP);
		corridoio.setDesc("1");
		CorridoioLocalServiceUtil.addCorridoio(corridoio);
		
		long idC2 = CounterLocalServiceUtil.increment(Corridoio.class.getName());
		Corridoio corridoio2 = CorridoioLocalServiceUtil.createCorridoio(-1);
		corridoio2.setId_pk_corridoio(idC2);
		corridoio2.setId_corridoio(idC2);
		corridoio2.setId_piano(idP);
		corridoio2.setDesc("2");
		CorridoioLocalServiceUtil.addCorridoio(corridoio2);
		
		long idFP = CounterLocalServiceUtil.increment(Sede.class.getName());
		FuoriPorta fuoriPorta = FuoriPortaLocalServiceUtil.createFuoriPorta(-1);
		fuoriPorta.setId_pk_fuoriPorta(idFP);
		fuoriPorta.setId_fuoriPorta(idFP);
		fuoriPorta.setId_corridoio(idC);
		fuoriPorta.setDesc("01.01");
		FuoriPortaLocalServiceUtil.addFuoriPorta(fuoriPorta);
		
		long idFP2 = CounterLocalServiceUtil.increment(Sede.class.getName());
		FuoriPorta fuoriPorta2 = FuoriPortaLocalServiceUtil.createFuoriPorta(-1);
		fuoriPorta2.setId_pk_fuoriPorta(idFP2);
		fuoriPorta2.setId_fuoriPorta(idFP2);
		fuoriPorta2.setId_corridoio(idC);
		fuoriPorta2.setDesc("01.15");
		FuoriPortaLocalServiceUtil.addFuoriPorta(fuoriPorta2);
		
		long idFP3 = CounterLocalServiceUtil.increment(Sede.class.getName());
		FuoriPorta fuoriPorta3 = FuoriPortaLocalServiceUtil.createFuoriPorta(-1);
		fuoriPorta3.setId_pk_fuoriPorta(idFP3);
		fuoriPorta3.setId_fuoriPorta(idFP3);
		fuoriPorta3.setId_corridoio(idC2);
		fuoriPorta3.setDesc("0201");
		FuoriPortaLocalServiceUtil.addFuoriPorta(fuoriPorta3);
		
	*/
		List<Sede> _listaSedi = SedeLocalServiceUtil.getSedes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Piano> _listaPiani = PianoLocalServiceUtil.getPianos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Corridoio> _listaCorridoi = CorridoioLocalServiceUtil.getCorridoios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<FuoriPorta> _listaFuoriPorta = FuoriPortaLocalServiceUtil.getFuoriPortas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		String jsonArraySedi = JSONFactoryUtil.looseSerialize(_listaSedi);
		String jsonArrayPiani = JSONFactoryUtil.looseSerialize(_listaPiani);
		String jsonArrayCorridoi = JSONFactoryUtil.looseSerialize(_listaCorridoi);
		String jsonArrayFuoriPorta = JSONFactoryUtil.looseSerialize(_listaFuoriPorta);
		
		request.setAttribute("listaSedi", jsonArraySedi);
		request.setAttribute("listaPiani", jsonArrayPiani);
		request.setAttribute("listaCorridoi", jsonArrayCorridoi);
		request.setAttribute("listaFuoriPorta", jsonArrayFuoriPorta);

	}
	
	// getRoles from user
	boolean dirigente = false;
	boolean abilitatoBadge = false;
	boolean delegatoBadge = false;
	boolean gestoreInterno = false;
	boolean gestoreEsterno = false;

	private List<String> getRolesFromUser(ThemeDisplay themeDisplay) {

		List<String> roles_list = new ArrayList<>();
		User user = themeDisplay.getUser();

		List<Role> listaRuoli = user.getRoles();

		for (Role ruolo : listaRuoli) {

			if (ruolo.getName().equalsIgnoreCase(_roledirigente)) {
				roles_list.add(_roledirigente);
			}

			if (ruolo.getName().equalsIgnoreCase(_delegatoBadge)) {
				roles_list.add(_delegatoBadge);
			}

			if (ruolo.getName().equalsIgnoreCase(_abilitatoBadge)) {
				roles_list.add(_abilitatoBadge);
			}

			if (ruolo.getName().equalsIgnoreCase(_gestoreInterno)) {
				roles_list.add(_gestoreInterno);
			}

		}

		List<String> listaGestoriExt = getGestoriEsterniRoles(themeDisplay);
		if (!listaGestoriExt.isEmpty()) {
			roles_list.add(_gestoreEsterno);
		}

		return roles_list;
	}

	// recupero gestori esterni
	private List<String> getGestoriEsterniRoles(ThemeDisplay themeDisplay) {

		List<String> listaGestoriEsterni = new ArrayList<>();
		User user = themeDisplay.getUser();
		List<Role> listaRuoli = user.getRoles();

		for (Role ruolo : listaRuoli) {
			if (ruolo.getName().startsWith(_gestoreEsterno)) {
				listaGestoriEsterni.add(ruolo.getName());
			}
		}

		return listaGestoriEsterni;

	}

	// metodo creazione richiedente da themedisplay
	private Richiedente createRichiedenteByTheme(ThemeDisplay themeDisplay) {

		User user = themeDisplay.getUser();
		long companyId = themeDisplay.getCompanyId();
		return createRichiedente(user, companyId);

	}

	// metodo creazione richiedente
	private Richiedente createRichiedente(User user, long companyId) {

		Richiedente richiedente = createStubRichiedente();
		richiedente.setCodiceFiscale(user.getScreenName());
		richiedente.setEmail(user.getEmailAddress());

		try {

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
							richiedente.setUbicazione(locationlist.get(0).getName());
						}
						richiedente.setUfficioRichiedente(orgChart.getName());
						OrganizationChart direzione = OrganizationChartLocalServiceUtil
								.getOrganizationChart(orgChart.getIdParent());
						if (direzione != null) {
							richiedente.setDirezione(direzione.getName());

							OrganizationChart dipartimento = OrganizationChartLocalServiceUtil
									.getOrganizationChart(direzione.getIdParent());
							if (dipartimento != null) {
								richiedente.setDipartimento(dipartimento.getName());
							}
						}
					}
				}
			} else
				_log.error(_customFieldUserOrg + " not defined for this user: " + user.getFullName());
			if (user != null) {
				richiedente.setNome(user.getFirstName());
				richiedente.setCognome(user.getLastName());
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
			}
			if (user != null && (user.getExpandoBridge() != null)
					&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
				String directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
				User cuser = getUsertByCustomField(companyId, _customFieldUserPersonal, directorId);
				if (cuser != null) {
					richiedente.setEmailDirigente(cuser.getEmailAddress());
				}
			} else
				_log.warn(_customFieldUserDirector + " not defined for the user");

		} catch (Exception e) {
			_log.error("error in retrieve user informations" + e);
		}
		return richiedente;

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

	private Folder getFolder(ThemeDisplay themeDisplay) {

		Folder folder = null;

		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {
			_log.error(e);
		}

		return folder;
	}

	/*
	 * indexFile = 0 --> allegato indexFile>0 --> allegato opzionale indexFile<0
	 * --> allegato generato es. PDf riepilogo richiesta
	 * 
	 */
	private FileEntry fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest, int indexFile,
			ModuloRichiedente moduloRichiedente) throws IOException {

		String fileName = moduloRichiedente.getAllegatoNome();
		String mimeType = moduloRichiedente.getAllegatoMimeType();

		File file = null;

		if (moduloRichiedente.getAllegato() != null) {
			file = new File(moduloRichiedente.getAllegato().toString());
		}

		if (indexFile > 0) {
			fileName = moduloRichiedente.getAllegatoNomeOpzionale();
			mimeType = moduloRichiedente.getAllegatoMimeTypeOpzionale();
			file = new File(moduloRichiedente.getAllegatoOpzionale().toString());
		}

		if (indexFile < 0) {
			fileName = moduloRichiedente.getAllegatoNomeGenerato();
			mimeType = moduloRichiedente.getAllegatoMimeTypeGenerato();
			file = new File(moduloRichiedente.getAllegatoGenerato().toString());
		}

		String regexDate = "\\([0-9][0-9]\\-[0-9][0-9]\\-[0-9][0-9][0-9][0-9] [0-9][0-9]\\-[0-9][0-9]-[0-9][0-9]\\)";
		StringBuilder title = new StringBuilder();
		title.append(fileName.substring(0, fileName.lastIndexOf('.')).replaceAll(regexDate, ""));
		title.append(("(") + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) + ")");
		title.append(fileName.substring(fileName.lastIndexOf('.')));

		String description = "";
		long repositoryId = themeDisplay.getScopeGroupId();
		FileEntry fileEntry = null;
		InputStream is = new FileInputStream(file);

		try {
			Folder folder = getFolder(themeDisplay);

			if (folder == null)
				throw new RichiesteBadgeException("folder not defined");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);

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

			Role ownerRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.OWNER);
			Role siteMemberRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.SITE_MEMBER);
			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
			Role powerUserRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.POWER_USER);

			if (file != null) {
				fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title.toString(),
						mimeType, title.toString(), description, "", is, file.length(), serviceContext);

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
			}

			is.close();

		} catch (Exception e) {
			_log.warn(e);
		} finally {
			is.close();
		}
		return fileEntry;

	}

	private void copyFileToServer(ActionRequest actionRequest, ModuloRichiedente moduloRichiedente, int inputType,
			File fileTmp) {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String nameInput = "allegato";

		try {

			if (inputType > 0) {
				nameInput = "allegatoOpzionale";
			}

			File uploadedFile;

			if (inputType < 0 && fileTmp != null && fileTmp.exists()) {

				nameInput = fileTmp.getName();
				uploadedFile = fileTmp;

			} else {

				uploadedFile = uploadRequest.getFile(nameInput);

			}

			if ((uploadedFile != null && uploadedFile.exists()
					&& ((inputType == 0 && !uploadedFile.equals(moduloRichiedente.getAllegato()))
							|| (inputType > 0 && !uploadedFile.equals(moduloRichiedente.getAllegatoOpzionale())))
					|| inputType < 0)) {

				if (inputType == 0) {
					moduloRichiedente.setAllegatoMimeType(uploadRequest.getContentType(nameInput));
					moduloRichiedente.setAllegatoNome(uploadRequest.getFileName(nameInput));
				}
				if (inputType > 0) {
					moduloRichiedente.setAllegatoMimeTypeOpzionale(uploadRequest.getContentType(nameInput));
					moduloRichiedente.setAllegatoNomeOpzionale(uploadRequest.getFileName(nameInput));
				}
				if (inputType < 0) {

					moduloRichiedente.setAllegatoMimeTypeGenerato("pdf");
					moduloRichiedente.setAllegatoNomeGenerato(nameInput);
				}

				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				StringBuilder stringPath = new StringBuilder();
				stringPath.append(TEMP_PATH);
				stringPath.append("documents");
				stringPath.append(File.separator);
				stringPath.append(themeDisplay.getLayout().getGroupId());
				stringPath.append(File.separator);
				stringPath.append(baseDir);
				stringPath.append(File.separator);
				stringPath.append(moduloRichiedente.getNome());
				stringPath.append(File.separator);
				stringPath.append(moduloRichiedente.getCognome());
				File folder = new File(stringPath.toString());

				if (inputType == 0) {
					String formatFile = moduloRichiedente.getAllegatoNome()
							.substring(moduloRichiedente.getAllegatoNome().lastIndexOf("."));
					if (formatFile.toLowerCase().contains("jpg") || formatFile.toLowerCase().contains("jpeg")) {
						String nameFile = moduloRichiedente.getNome() + "." + moduloRichiedente.getCognome()
								+ formatFile;
						moduloRichiedente.setAllegatoNome(nameFile);
					}
					moduloRichiedente.setAllegato(
							new File(folder.getAbsolutePath() + File.separator + moduloRichiedente.getAllegatoNome()));
					FileUtil.copyFile(uploadedFile, moduloRichiedente.getAllegato());
				}

				if (inputType > 0) {
					String formatFileOpzionale = moduloRichiedente.getAllegatoNomeOpzionale()
							.substring(moduloRichiedente.getAllegatoNomeOpzionale().lastIndexOf("."));
					if (formatFileOpzionale.toLowerCase().contains("jpg") || formatFileOpzionale.toLowerCase().contains("jpeg")) {
						String nameFileOpzionale = moduloRichiedente.getNome() + "." + moduloRichiedente.getCognome()
								+ formatFileOpzionale;
						moduloRichiedente.setAllegatoNomeOpzionale(nameFileOpzionale);
					}
					moduloRichiedente.setAllegatoOpzionale(new File(
							folder.getAbsolutePath() + File.separator + moduloRichiedente.getAllegatoNomeOpzionale()));
					FileUtil.copyFile(uploadedFile, moduloRichiedente.getAllegatoOpzionale());
				}

				if (inputType < 0) {
					moduloRichiedente.setAllegatoGenerato(new File(
							folder.getAbsolutePath() + File.separator + moduloRichiedente.getAllegatoNomeGenerato()));
					FileUtil.copyFile(uploadedFile, moduloRichiedente.getAllegatoGenerato());
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

	}

	// metodo creazione bean Richiedente da idRichiesta
	private Richiedente getRichiedenteByidRichiesta(long idRichiesta) {

		Richiedente richiedente = new Richiedente();
		JSONObject jsonRichiedente;
		RichiestaBadge richiesta = RichiestaBadgeLocalServiceUtil.fetchRichiestaBadge(idRichiesta);
		if (richiesta != null) {
			try {
				jsonRichiedente = JSONFactoryUtil.createJSONObject(richiesta.getJson_richiedente());
				if (jsonRichiedente != null) {
					richiedente.setNome(jsonRichiedente.getString("nomerichiedente"));
					richiedente.setCognome(jsonRichiedente.getString("cognomerichiedente"));
					richiedente.setDipartimento(jsonRichiedente.getString("diprichiedente"));
					richiedente.setDirezione(jsonRichiedente.getString("dirrichiedente"));
					richiedente.setUfficioRichiedente(jsonRichiedente.getString("uffrichiedente"));
					richiedente.setTelefono(jsonRichiedente.getString("telrichiedente"));
					richiedente.setEmail(jsonRichiedente.getString("emailrichiedente"));
				}
			} catch (JSONException e) {
				_log.warn(e);
			}

		}
		return richiedente;
	}

	// metodo creazione bean ModuloRichiedente da idRichiesta
	private ModuloRichiedente getModuloRichiedenteByidRichiesta(long idRichiesta, ThemeDisplay themeDisplay)
			throws JSONException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();
		RichiestaBadge richiesta = RichiestaBadgeLocalServiceUtil.fetchRichiestaBadge(idRichiesta);

		if (richiesta != null) {
			moduloRichiedente.setId_richiesta(idRichiesta);
			moduloRichiedente.setCognome(HtmlUtil.escape(richiesta.getCognome_intestatario()));
			moduloRichiedente.setNome(HtmlUtil.escape(richiesta.getNome_intestatario()));
			moduloRichiedente.setCodiceFiscale(richiesta.getCf_intestatario());
			moduloRichiedente.setLuogoNascita(HtmlUtil.escape(richiesta.getLuogonascita_intestatario()));
			moduloRichiedente.setDataNascita(sdf.format(richiesta.getDatanascita_intestatario()));

			if (richiesta.getIs_internal()) {
				moduloRichiedente.setTipo("interna");
			} else {
				moduloRichiedente.setTipo("esterna");
				JSONObject jsonRichiestaEsternaSubmit = JSONFactoryUtil
						.createJSONObject(richiesta.getJson_richiesta_external());

				moduloRichiedente
						.setDipartimento(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("dipartimento")));
				moduloRichiedente.setDirezione(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("direzione")));
				moduloRichiedente.setUfficio(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("ufficio")));
				moduloRichiedente
						.setReferenteMef(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("referentemef")));
				moduloRichiedente.setTelReferente(jsonRichiestaEsternaSubmit.getString("telreferentemef"));
				moduloRichiedente.setEmailReferente(jsonRichiestaEsternaSubmit.getString("emailreferentemef"));
				moduloRichiedente.setSocieta(HtmlUtil.escape(richiesta.getSocieta()));
				moduloRichiedente
						.setSedelegaleSocieta(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("sedesocieta")));
				moduloRichiedente
						.setIndirizzoSocieta(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("indirizzo")));
				moduloRichiedente.setTelSocieta(jsonRichiestaEsternaSubmit.getString("recapitotel"));
				moduloRichiedente.setFaxSocieta(jsonRichiestaEsternaSubmit.getString("fax"));
				moduloRichiedente.setPecSocieta(jsonRichiestaEsternaSubmit.getString("pec"));
				moduloRichiedente.setEmailSocieta(jsonRichiestaEsternaSubmit.getString("email"));
				moduloRichiedente.setRefSocieta(HtmlUtil.escape(richiesta.getReferente_societa()));
				moduloRichiedente.setEmailRefSocieta(jsonRichiestaEsternaSubmit.getString("emailrefsocieta"));
				moduloRichiedente.setTelUfficioRefSocieta(jsonRichiestaEsternaSubmit.getString("telufficio"));
				moduloRichiedente.setCellRefSocieta(jsonRichiestaEsternaSubmit.getString("cellulare"));
				moduloRichiedente.setContratto(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("contratto")));
				moduloRichiedente.setProgetto(HtmlUtil.escape(richiesta.getProgetto()));
				moduloRichiedente.setPiano(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("piano")));
				moduloRichiedente.setPostazione(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("postazione")));
				moduloRichiedente.setSediAbilitate(HtmlUtil.escape(richiesta.getArray_sedi_abilitate()));
				
				// modifica 2021
				moduloRichiedente.setSedePostazione(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("sedepos")));
				moduloRichiedente.setPianoPostazione(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("pianopos")));
				moduloRichiedente.setCorridoioPostazione(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("corridoiopos")));
				moduloRichiedente.setFuoriPortaPostazione(HtmlUtil.escape(jsonRichiestaEsternaSubmit.getString("fuoriportapos")));
				
				// fine 2021
				if (richiesta.getData_scadenza() != null) {
					moduloRichiedente.setDataScadenza(sdf.format(richiesta.getData_scadenza()));
				}

				moduloRichiedente.setMotivazione(HtmlUtil.escape(richiesta.getMotivazione()));
			}

			long id_oggetto_richiesta = richiesta.getId_oggetto();

			moduloRichiedente.setOggettoRichiestaId(String.valueOf(id_oggetto_richiesta));
			moduloRichiedente.setNumeroBadge(HtmlUtil.escape(richiesta.getNumero_badge()));

			moduloRichiedente.setNote(richiesta.getNote());

			DLFileEntry dl_file_entry_foto = null;
			DLFileEntry dl_file_entry_modulo_sostituzione = null;
			File file_foto = null;
			File file_modulo_sostituizione = null;

			String uuid_foto = richiesta.getUuid_foto();
			if (uuid_foto != null && !"".equalsIgnoreCase(uuid_foto)) {
				try {
					dl_file_entry_foto = DLFileEntryLocalServiceUtil.getDLFileEntryByUuidAndGroupId(uuid_foto,
							themeDisplay.getScopeGroupId());

					if (dl_file_entry_foto != null) {
						file_foto = DLFileEntryLocalServiceUtil.getFile(dl_file_entry_foto.getFileEntryId(),
								dl_file_entry_foto.getVersion(), false);
					}
				} catch (Exception e) {
					_log.error("Errore nel reperimento del file entry foto con uuid = " + uuid_foto + ": " + e);
				}
			}

			String uuid_modulosostituzione = richiesta.getUuid_modulosostituzione();
			if (uuid_modulosostituzione != null && !"".equalsIgnoreCase(uuid_modulosostituzione)) {
				try {
					dl_file_entry_modulo_sostituzione = DLFileEntryLocalServiceUtil
							.getDLFileEntryByUuidAndGroupId(uuid_modulosostituzione, themeDisplay.getScopeGroupId());

					if (dl_file_entry_modulo_sostituzione != null) {
						file_modulo_sostituizione = DLFileEntryLocalServiceUtil.getFile(
								dl_file_entry_modulo_sostituzione.getFileEntryId(),
								dl_file_entry_modulo_sostituzione.getVersion(), false);
					}
				} catch (Exception e) {
					_log.error("Errore nel reperimento del file entry modulo sostituzione con uuid = "
							+ uuid_modulosostituzione + ": " + e);
				}
			}

			if (dl_file_entry_foto != null) {
				if (id_oggetto_richiesta == 1 || id_oggetto_richiesta == 2) {
					moduloRichiedente.setAllegato(file_foto);
					moduloRichiedente.setAllegatoNome(dl_file_entry_foto.getFileName());
					moduloRichiedente.setAllegatoMimeType(dl_file_entry_foto.getMimeType());
				} else if (id_oggetto_richiesta == 3) {
					moduloRichiedente.setAllegatoOpzionale(file_foto);
					moduloRichiedente.setAllegatoNomeOpzionale(dl_file_entry_foto.getFileName());
					moduloRichiedente.setAllegatoMimeTypeOpzionale(dl_file_entry_foto.getMimeType());
				}
			}

			if (dl_file_entry_modulo_sostituzione != null && id_oggetto_richiesta == 3) {
				moduloRichiedente.setAllegato(file_modulo_sostituizione);
				moduloRichiedente.setAllegatoNome(dl_file_entry_modulo_sostituzione.getFileName());
				moduloRichiedente.setAllegatoMimeType(dl_file_entry_modulo_sostituzione.getMimeType());
			}

		}
		return moduloRichiedente;

	}

	@ProcessAction(name = "eventoRichiestaBadge")
	public void eventoRichiestaBadge(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ParseException, IOException, RichiesteBadgeException, PortalException {
		
		_log.info("Dentro evento richiesta badge");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		
		
		boolean dirigente = false;
		boolean delegatoBadge = false;
		boolean gestoreInterno = false;
		boolean gestoreEsterno = false;
	
		List<String> roles_list = getRolesFromUser(themeDisplay);
		
	
		if (roles_list.contains(_delegatoBadge)) {
			delegatoBadge = true;
		}
		if (roles_list.contains(_roledirigente)) {
			dirigente = true;
		}
		if (roles_list.contains(_gestoreInterno)) {
			gestoreInterno = true;
		}
		if (roles_list.contains(_gestoreEsterno)) {
			gestoreEsterno = true;
			
		}
		
		String screename_richiedente = "";
		long id_ufficio = 0L;
		long id_richiesta = 0L;

		String flagModificaPostSubmit = actionRequest.getParameter("flagModificaPostSubmit");

		if (user != null) {
			screename_richiedente = user.getScreenName();
		}


		
		
		
		
		if ((user != null) && (user.getExpandoBridge() != null)
				&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
			id_ufficio = Long.parseLong((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg));
		}

		JSONObject jsonRichiedenteSubmit = JSONFactoryUtil
				.createJSONObject(actionRequest.getParameter("DatiRichiedenteSubmit"));
		JSONObject jsonRichiestaSubmit = JSONFactoryUtil
				.createJSONObject(actionRequest.getParameter("DatiRichiestaSubmit"));

		Richiedente richiedente = createRichiedenteByTheme(themeDisplay);

		richiedente.setNome(jsonRichiedenteSubmit.getString("nomerichiedente"));
		richiedente.setCognome(jsonRichiedenteSubmit.getString("cognomerichiedente"));
		richiedente.setDipartimento(jsonRichiedenteSubmit.getString("diprichiedente"));
		richiedente.setDirezione(jsonRichiedenteSubmit.getString("dirrichiedente"));
		richiedente.setUfficioRichiedente(jsonRichiedenteSubmit.getString("uffrichiedente"));
		richiedente.setTelefono(jsonRichiedenteSubmit.getString("telrichiedente"));
		richiedente.setEmail(jsonRichiedenteSubmit.getString("emailrichiedente"));

		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();

		if (jsonRichiestaSubmit.getString("id_richiesta") != null
				&& jsonRichiestaSubmit.getString("id_richiesta") != "")
			id_richiesta = Long.parseLong(jsonRichiestaSubmit.getString("id_richiesta"));

		moduloRichiedente.setId_richiesta(id_richiesta);

		if (("interna").equalsIgnoreCase(actionRequest.getParameter("TipoRichiesta"))) {
			moduloRichiedente.setTipo("interna");
			moduloRichiedente.setCognome(jsonRichiestaSubmit.getString("cognomeint"));
			moduloRichiedente.setNome(jsonRichiestaSubmit.getString("nomeint"));
			moduloRichiedente.setCodiceFiscale(jsonRichiestaSubmit.getString("cfint"));
			moduloRichiedente.setLuogoNascita(jsonRichiestaSubmit.getString("luogonascitaint"));
			moduloRichiedente.setDataNascita(jsonRichiestaSubmit.getString("datanascitaint"));

		} else {
			_log.info("Dentro evento richiesta badge esterno");
			
			moduloRichiedente.setTipo("esterna");
			moduloRichiedente.setDipartimento(jsonRichiestaSubmit.getString("dipartimento"));
			moduloRichiedente.setDirezione(jsonRichiestaSubmit.getString("direzione"));
			moduloRichiedente.setUfficio(jsonRichiestaSubmit.getString("ufficio"));
			moduloRichiedente.setReferenteMef(jsonRichiestaSubmit.getString("referentemef"));
			moduloRichiedente.setTelReferente(jsonRichiestaSubmit.getString("telreferentemef"));
			moduloRichiedente.setEmailReferente(jsonRichiestaSubmit.getString("emailreferentemef"));
			moduloRichiedente.setCognome(jsonRichiestaSubmit.getString("cognomeest"));
			moduloRichiedente.setNome(jsonRichiestaSubmit.getString("nomeest"));
			moduloRichiedente.setCodiceFiscale(jsonRichiestaSubmit.getString("cfest"));
			moduloRichiedente.setLuogoNascita(jsonRichiestaSubmit.getString("luogonascitaest"));
			moduloRichiedente.setDataNascita(jsonRichiestaSubmit.getString("datanascitaest"));
			moduloRichiedente.setSocieta(jsonRichiestaSubmit.getString("societa"));
			moduloRichiedente.setSedelegaleSocieta(jsonRichiestaSubmit.getString("sedesocieta"));
			moduloRichiedente.setIndirizzoSocieta(jsonRichiestaSubmit.getString("indirizzo"));
			moduloRichiedente.setTelSocieta(jsonRichiestaSubmit.getString("recapitotel"));
			moduloRichiedente.setFaxSocieta(jsonRichiestaSubmit.getString("fax"));
			moduloRichiedente.setPecSocieta(jsonRichiestaSubmit.getString("pec"));
			moduloRichiedente.setEmailSocieta(jsonRichiestaSubmit.getString("email"));
			moduloRichiedente.setRefSocieta(jsonRichiestaSubmit.getString("refsocieta"));
			moduloRichiedente.setEmailRefSocieta(jsonRichiestaSubmit.getString("emailrefsocieta"));
			moduloRichiedente.setTelUfficioRefSocieta(jsonRichiestaSubmit.getString("telufficio"));
			moduloRichiedente.setCellRefSocieta(jsonRichiestaSubmit.getString("cellulare"));
			moduloRichiedente.setContratto(jsonRichiestaSubmit.getString("contratto"));
			moduloRichiedente.setProgetto(jsonRichiestaSubmit.getString("progetto"));
			moduloRichiedente.setPiano(jsonRichiestaSubmit.getString("piano"));
			moduloRichiedente.setPostazione(jsonRichiestaSubmit.getString("postazione"));
			moduloRichiedente.setSediAbilitate(jsonRichiestaSubmit.getString("sedi").replace("_", " "));
			moduloRichiedente.setDataScadenza(jsonRichiestaSubmit.getString("scadenza"));
			moduloRichiedente.setMotivazione(jsonRichiestaSubmit.getString("motivazione"));
			// modifica 2021
			moduloRichiedente.setSedePostazione(jsonRichiestaSubmit.getString("sedepos"));
			moduloRichiedente.setPianoPostazione(jsonRichiestaSubmit.getString("pianopos"));
			moduloRichiedente.setCorridoioPostazione(jsonRichiestaSubmit.getString("corridoiopos"));
			moduloRichiedente.setFuoriPortaPostazione(jsonRichiestaSubmit.getString("fuoriportapos"));
			
		}

		moduloRichiedente.setOggettoRichiestaId(jsonRichiestaSubmit.getString("oggetto"));
		moduloRichiedente.setOggettoRichiestaDescrizione(OggettoRichiestaLocalServiceUtil
				.getOggettoRichiesta(Long.parseLong(jsonRichiestaSubmit.getString("oggetto")))
				.getDescrizione_oggetto());
		moduloRichiedente.setNumeroBadge(jsonRichiestaSubmit.getString("numbadge"));
		
		
		if(dirigente || delegatoBadge)
			moduloRichiedente.setStato("APPROVATA DAL DIRIGENTE");
		else
			moduloRichiedente.setStato("NUOVA RICHIESTA");
		
		moduloRichiedente.setNote(actionRequest.getParameter("NoteRichiestaSubmit"));
		boolean is_internal = false;

		/* gestione allegati */
		moduloRichiedente.setAllegatoNome(actionRequest.getParameter("AllegatoNome"));
		moduloRichiedente.setAllegatoMimeType(actionRequest.getParameter("AllegatoMimeType"));
		moduloRichiedente.setAllegatoNomeOpzionale(actionRequest.getParameter("AllegatoOpzionaleNome"));
		moduloRichiedente.setAllegatoMimeTypeOpzionale(actionRequest.getParameter("AllegatoMimeTypeOpzionale"));

		String pathFile = actionRequest.getParameter("Allegato");
		if (pathFile != null && !"".equals(pathFile)) {
			moduloRichiedente.setAllegato(new File(pathFile));
		}

		String pathFileOpzionale = actionRequest.getParameter("AllegatoOpzionale");
		if (pathFileOpzionale != null && !"".equals(pathFileOpzionale)) {
			moduloRichiedente.setAllegatoOpzionale(new File(pathFileOpzionale));
		}

		String allegatoUuid = null;
		String allegatoOpzionaleUuid = null;
		String allegatoGeneratoUuid = null;

		if (moduloRichiedente.getAllegato() != null) {

			FileEntry fileEntry = fileUpload(themeDisplay, actionRequest, 0, moduloRichiedente);

			if (fileEntry != null) {

				allegatoUuid = fileEntry.getUuid();

				if (moduloRichiedente.getAllegatoOpzionale() != null) {

					FileEntry fileEntryOpzionale = fileUpload(themeDisplay, actionRequest, 1, moduloRichiedente);

					if (fileEntryOpzionale != null) {

						allegatoOpzionaleUuid = fileEntryOpzionale.getUuid();

					}
				}
			}
		}

		long richiestaInserita;

		String strDataNascita;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascita = null;

		long id_oggetto_richiesta = Long.parseLong(jsonRichiestaSubmit.getString("oggetto"));

		String allegato_foto_uuid = null;
		String allegato_modulo_sostituzione_uuid = null;

		if (id_oggetto_richiesta == 1 || id_oggetto_richiesta == 2) {
			allegato_foto_uuid = allegatoUuid;
		} else if (id_oggetto_richiesta == 3) {
			allegato_foto_uuid = allegatoOpzionaleUuid;
			allegato_modulo_sostituzione_uuid = allegatoUuid;
		}

		try {

			long id_statoRichiestaProroga = 0;
			long id_statoNuovaRichiesta = 0;

			for (StatoRichiesta stato : StatoRichiestaLocalServiceUtil.getStatoRichiestas(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS)) {

				if (("RICHIESTA DI PROROGA").equalsIgnoreCase(stato.getDescrizione_stato())) {
					id_statoRichiestaProroga = stato.getId_stato();
				}
								
				if(dirigente || delegatoBadge){				
					if (("APPROVATA DAL DIRIGENTE").equalsIgnoreCase(stato.getDescrizione_stato())) {
						id_statoNuovaRichiesta = stato.getId_stato();
					}				
				}else{				
					if (("NUOVA RICHIESTA").equalsIgnoreCase(stato.getDescrizione_stato())) {
						id_statoNuovaRichiesta = stato.getId_stato();
					}
				}
			}
			long idStatoNew = id_statoNuovaRichiesta;

			RichiestaBadge richiestaOld = RichiestaBadgeLocalServiceUtil.fetchRichiestaBadge(id_richiesta);
			long idRichiesta;
			if (richiestaOld != null) {
				screename_richiedente = richiestaOld.getScreename_richiedente();
				idRichiesta = richiestaOld.getId_richiesta();

				if (richiestaOld.getId_stato() != id_statoNuovaRichiesta) {
					List<RichiestaBadge> listaRichiesteById = RichiestaBadgeLocalServiceUtil
							.findRichiesteByIdRichiesta(idRichiesta);
					if (listaRichiesteById != null && !listaRichiesteById.isEmpty()) {
						for (RichiestaBadge richiesta : listaRichiesteById) {
							if (richiesta.getId_stato() == id_statoRichiestaProroga) {
								idStatoNew = id_statoRichiestaProroga;
								break;
							}

						}

					}

				}

			}

			if (("interna").equalsIgnoreCase(actionRequest.getParameter("TipoRichiesta"))) {

				is_internal = true;

				long siapId = 0L;
				OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(id_ufficio);
				if (orgChart != null) {
					siapId = orgChart.getLocationId();
				}

				strDataNascita = jsonRichiestaSubmit.getString("datanascitaint");
				if (strDataNascita != null && !"".equals(strDataNascita)) {
					dataNascita = sdf.parse(strDataNascita);
				}

				if ("modificaRichiestaBadgePostSubmit".equalsIgnoreCase(flagModificaPostSubmit)) {

					richiestaInserita = RichiestaBadgeLocalServiceUtil.aggiornaRichiestaBadge(id_richiesta,
							screename_richiedente, id_ufficio, actionRequest.getParameter("DatiRichiedenteSubmit"),
							is_internal, jsonRichiestaSubmit.getString("nomeint"),
							jsonRichiestaSubmit.getString("cognomeint"), jsonRichiestaSubmit.getString("cfint"),
							jsonRichiestaSubmit.getString("luogonascitaint"), dataNascita, id_oggetto_richiesta,
							jsonRichiestaSubmit.getString("numbadge"), allegato_foto_uuid,
							allegato_modulo_sostituzione_uuid, null, null, null, null, null, null, null,
							allegatoGeneratoUuid, new Date(), new Date(), idStatoNew, screename_richiedente,
							actionRequest.getParameter("NoteRichiestaSubmit"), true, siapId);
				} else {
					
					if(dirigente || delegatoBadge){	
						
						richiestaInserita = RichiestaBadgeLocalServiceUtil.insertRichiestaBadge(0L, screename_richiedente,
								id_ufficio, actionRequest.getParameter("DatiRichiedenteSubmit"), is_internal,
								jsonRichiestaSubmit.getString("nomeint"), jsonRichiestaSubmit.getString("cognomeint"),
								jsonRichiestaSubmit.getString("cfint"), jsonRichiestaSubmit.getString("luogonascitaint"),
								dataNascita, id_oggetto_richiesta, jsonRichiestaSubmit.getString("numbadge"),
								allegato_foto_uuid, allegato_modulo_sostituzione_uuid, null, null, null, null, null, null,
								null, allegatoGeneratoUuid, new Date(), new Date(), 2, screename_richiedente,
								actionRequest.getParameter("NoteRichiestaSubmit"), true, siapId);
					}else{
					
						richiestaInserita = RichiestaBadgeLocalServiceUtil.insertRichiestaBadge(0L, screename_richiedente,
								id_ufficio, actionRequest.getParameter("DatiRichiedenteSubmit"), is_internal,
								jsonRichiestaSubmit.getString("nomeint"), jsonRichiestaSubmit.getString("cognomeint"),
								jsonRichiestaSubmit.getString("cfint"), jsonRichiestaSubmit.getString("luogonascitaint"),
								dataNascita, id_oggetto_richiesta, jsonRichiestaSubmit.getString("numbadge"),
								allegato_foto_uuid, allegato_modulo_sostituzione_uuid, null, null, null, null, null, null,
								null, allegatoGeneratoUuid, new Date(), new Date(), 1, screename_richiedente,
								actionRequest.getParameter("NoteRichiestaSubmit"), true, siapId);
					}
				}

			} else {

				strDataNascita = jsonRichiestaSubmit.getString("datanascitaest");

				if (strDataNascita != null && !"".equals(strDataNascita)) {
					dataNascita = sdf.parse(strDataNascita);
				}

				Date dataScadenza = null;

				String strDataScadenza = jsonRichiestaSubmit.getString("scadenza");

				if (strDataScadenza != null && !"".equals(strDataScadenza)) {
					dataScadenza = sdf.parse(strDataScadenza);
				}

				JSONObject json_richiesta_external = JSONFactoryUtil.createJSONObject();
				json_richiesta_external.put("id_richiesta", jsonRichiestaSubmit.getString("id_richiesta"));
				json_richiesta_external.put("dipartimento", jsonRichiestaSubmit.getString("dipartimento"));
				json_richiesta_external.put("direzione", jsonRichiestaSubmit.getString("direzione"));
				json_richiesta_external.put("ufficio", jsonRichiestaSubmit.getString("ufficio"));
				json_richiesta_external.put("referentemef", jsonRichiestaSubmit.getString("referentemef"));
				json_richiesta_external.put("telreferentemef", jsonRichiestaSubmit.getString("telreferentemef"));
				json_richiesta_external.put("emailreferentemef", jsonRichiestaSubmit.getString("emailreferentemef"));
				json_richiesta_external.put("sedesocieta", jsonRichiestaSubmit.getString("sedesocieta"));
				json_richiesta_external.put("indirizzo", jsonRichiestaSubmit.getString("indirizzo"));
				json_richiesta_external.put("recapitotel", jsonRichiestaSubmit.getString("recapitotel"));
				json_richiesta_external.put("fax", jsonRichiestaSubmit.getString("fax"));
				json_richiesta_external.put("pec", jsonRichiestaSubmit.getString("pec"));
				json_richiesta_external.put("email", jsonRichiestaSubmit.getString("email"));
				json_richiesta_external.put("emailrefsocieta", jsonRichiestaSubmit.getString("emailrefsocieta"));
				json_richiesta_external.put("telufficio", jsonRichiestaSubmit.getString("telufficio"));
				json_richiesta_external.put("cellulare", jsonRichiestaSubmit.getString("cellulare"));
				json_richiesta_external.put("contratto", jsonRichiestaSubmit.getString("contratto"));
				json_richiesta_external.put("piano", jsonRichiestaSubmit.getString("contratto"));
				json_richiesta_external.put("postazione", jsonRichiestaSubmit.getString("postazione"));
				// modifica 2021
				json_richiesta_external.put("sedepos", jsonRichiestaSubmit.getString("sedepos"));
				json_richiesta_external.put("pianopos", jsonRichiestaSubmit.getString("pianopos"));
				json_richiesta_external.put("corridoiopos", jsonRichiestaSubmit.getString("corridoiopos"));
				json_richiesta_external.put("fuoriportapos", jsonRichiestaSubmit.getString("fuoriportapos"));
				
				
				long siapId = 0L;
				OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(id_ufficio);
				if (orgChart != null)
					siapId = orgChart.getLocationId();

				if ("modificaRichiestaBadgePostSubmit".equalsIgnoreCase(flagModificaPostSubmit)) {
					richiestaInserita = RichiestaBadgeLocalServiceUtil.aggiornaRichiestaBadge(id_richiesta,
							screename_richiedente, id_ufficio, actionRequest.getParameter("DatiRichiedenteSubmit"),
							is_internal, jsonRichiestaSubmit.getString("nomeest"),
							jsonRichiestaSubmit.getString("cognomeest"), jsonRichiestaSubmit.getString("cfest"),
							jsonRichiestaSubmit.getString("luogonascitaest"), dataNascita, id_oggetto_richiesta,
							jsonRichiestaSubmit.getString("numbadge"), allegato_foto_uuid,
							allegato_modulo_sostituzione_uuid, jsonRichiestaSubmit.getString("societa"),
							jsonRichiestaSubmit.getString("refsocieta"), jsonRichiestaSubmit.getString("progetto"),
							json_richiesta_external.toString(), jsonRichiestaSubmit.getString("sedi").replace("_", " "),
							jsonRichiestaSubmit.getString("motivazione"), dataScadenza, allegatoGeneratoUuid,
							new Date(), new Date(), idStatoNew, screename_richiedente,
							actionRequest.getParameter("NoteRichiestaSubmit"), true, siapId);
				} else {
					
					long id_stato_nuova_esterna = 1;
					
					if(dirigente || delegatoBadge){	
						id_stato_nuova_esterna = 2;
					}
					
					richiestaInserita = RichiestaBadgeLocalServiceUtil.insertRichiestaBadge(0L, screename_richiedente,
							id_ufficio, actionRequest.getParameter("DatiRichiedenteSubmit"), is_internal,
							jsonRichiestaSubmit.getString("nomeest"), jsonRichiestaSubmit.getString("cognomeest"),
							jsonRichiestaSubmit.getString("cfest"), jsonRichiestaSubmit.getString("luogonascitaest"),
							dataNascita, id_oggetto_richiesta, jsonRichiestaSubmit.getString("numbadge"),
							allegato_foto_uuid, allegato_modulo_sostituzione_uuid,
							jsonRichiestaSubmit.getString("societa"), jsonRichiestaSubmit.getString("refsocieta"),
							jsonRichiestaSubmit.getString("progetto"), json_richiesta_external.toString(),
							jsonRichiestaSubmit.getString("sedi").replace("_", " "),
							jsonRichiestaSubmit.getString("motivazione"), dataScadenza, allegatoGeneratoUuid,
							new Date(), new Date(), id_stato_nuova_esterna, screename_richiedente,
							actionRequest.getParameter("NoteRichiestaSubmit"), true, siapId);
					
				}
			}

			if (richiestaInserita == 0) {

				throw new RichiesteBadgeException("WARNING: richiesta non inserita");

			} else {
				if (is_internal == false && AnaDipExtLocalServiceUtil
						.findUtentiByCodiceFiscaleEsterno(jsonRichiestaSubmit.getString("cfest").trim().toUpperCase())
						.isEmpty()) {

					try {
						AnaDipExtLocalServiceUtil.insertAnaDipExt(jsonRichiestaSubmit.getString("nomeest"),
								jsonRichiestaSubmit.getString("cognomeest"),
								jsonRichiestaSubmit.getString("cfest").trim().toUpperCase(),
								jsonRichiestaSubmit.getString("luogonascitaest"), dataNascita);
					} catch (Exception e) {
						_log.error("errore nel salvataggio dell'utente esterno in db: " + e);
					}

				}

				long idRichiestaNew = 0;
				if (richiestaInserita != 0) {
					idRichiestaNew = RichiestaBadgeLocalServiceUtil.getRichiestaBadge(richiestaInserita)
							.getId_richiesta();
				}

				String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl",
						_configuration.richiestaTmpl());
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
				String subject;

				if ("modificaRichiestaBadgePostSubmit".equalsIgnoreCase(flagModificaPostSubmit)) {
					subject = actionRequest.getPreferences().getValue("subject", _configuration.subjectModifica());
				} else {
					subject = actionRequest.getPreferences().getValue("subject", _configuration.subjectNuova());
				}

				subject = StringUtil.replace(subject, new String[] { "[$IDRICHIESTA$]" },
						new String[] { String.valueOf(idRichiestaNew) });
				String datirichiesta = getHtmlRichiesta(moduloRichiedente);
				mailbody = StringUtil.replace(mailbody, new String[] { "[$OGGETTO$]", "[$DATI$]" },
						new String[] { subject, datirichiesta });
				EmailSender mail = new EmailSender();

				// invia email a referente badge.dag@tesoro.it (da decommentare)
				String emailReferente = actionRequest.getPreferences().getValue("emailReferente",
						_configuration.emailReferente());

				if (emailReferente != null && !("").equalsIgnoreCase(emailReferente)) {
					mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferente);
				}

				// invia email a richiedente
				mail.sendMailMessage(subject, mailbody, sender, smtpUser,
						jsonRichiedenteSubmit.getString("emailrichiedente"));

				// recupera e invia email a dirigente (se l'utente non è
				// dirigente!)
				String emailDirigente = "";
				String directorId = "";

				if (user.getExpandoBridge() != null
						&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
					directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);

					if (directorId != null && !("0").equalsIgnoreCase(directorId)
							&& !("").equalsIgnoreCase(directorId)) {
						User cuser = getUsertByCustomField(themeDisplay.getCompanyId(), _customFieldUserPersonal,
								directorId);
						if (cuser != null) {
							emailDirigente = cuser.getEmailAddress();
						}
					}
				} else {
					_log.warn(_customFieldUserDirector + " not defined for this user");
				}

				if (!emailDirigente.equalsIgnoreCase(jsonRichiedenteSubmit.getString("emailrichiedente"))) {
					mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailDirigente);
				}

				// invia email a delegati
				if (!("").equalsIgnoreCase(directorId)) {
					Role delegatoBadgeRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "delegatoBadge");
					List<User> users_list_by_delegatoBadgeRole = new ArrayList<User>(0);

					if (delegatoBadgeRole != null) {
						users_list_by_delegatoBadgeRole = UserLocalServiceUtil
								.getRoleUsers(delegatoBadgeRole.getRoleId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
					}

					if (!users_list_by_delegatoBadgeRole.isEmpty()) {
						for (User delegatoUser : users_list_by_delegatoBadgeRole) {
							if (delegatoUser.getExpandoBridge() != null
									&& (delegatoUser.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)
									&& ((String) delegatoUser.getExpandoBridge().getAttribute(_customFieldUserDirector))
											.equalsIgnoreCase(directorId)) {

								mail.sendMailMessage(subject, mailbody, sender, smtpUser,
										delegatoUser.getEmailAddress());
							}
						}
					}
				}

				
				
				// cambio redirect a seconda del ruolo utente
			
				
				
				if(gestoreInterno || gestoreEsterno){
					try {

						PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
								themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
								PortletRequest.ACTION_PHASE);
						urlRefresh.setParameter("javax.portlet.action", "vaiARicerca");
						actionResponse.sendRedirect(urlRefresh.toString());

					} catch (Exception e) {

						_log.error(e);

					}
				}else{
					
					try {

						PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
								themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
								PortletRequest.ACTION_PHASE);
						urlRefresh.setParameter("javax.portlet.action", "vaiAInserimento");
						urlRefresh.setParameter("richiestaId", Long.toString(richiestaInserita));
						actionResponse.sendRedirect(urlRefresh.toString());

					} catch (Exception e) {

						_log.error(e);

					}
					
					
					
				}
				
			

			}

		} catch (Exception e) {

			_log.error(e);
			SessionErrors.add(actionRequest, "Errore-durante-richiesta");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		}

	}

	public void richiestaBadge(ActionRequest request, ActionResponse response)
			throws NumberFormatException, PortalException {

		_log.info("Dentro richiesta badge metodo");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Richiedente richiedente = createRichiedenteByTheme(themeDisplay);
		JSONObject jsonRichiedente = JSONFactoryUtil.createJSONObject(request.getParameter("jsonRichiedente"));
		richiedente.setNome(jsonRichiedente.getString("nomerichiedente"));
		richiedente.setCognome(jsonRichiedente.getString("cognomerichiedente"));
		richiedente.setDipartimento(jsonRichiedente.getString("diprichiedente"));
		richiedente.setDirezione(jsonRichiedente.getString("dirrichiedente"));
		richiedente.setUfficioRichiedente(jsonRichiedente.getString("uffrichiedente"));
		richiedente.setTelefono(jsonRichiedente.getString("telrichiedente"));
		richiedente.setEmail(jsonRichiedente.getString("emailrichiedente"));

		request.setAttribute("jsonRichiedente", request.getParameter("jsonRichiedente"));

		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();
		String jsonRichiesta = "jsonRichiesta";
		String id_oggetto;
		String descrizione_oggetto;
		long idStato = 0;

		if (request.getParameter("jsonRichiestainterna") != null
				&& !"".equals(request.getParameter("jsonRichiestainterna"))) {

			JSONObject jsonRichiestaInterna = JSONFactoryUtil
					.createJSONObject(request.getParameter("jsonRichiestainterna"));

			moduloRichiedente.setId_richiesta(0L);
			if (jsonRichiestaInterna.getString("id_richiesta") != null
					&& jsonRichiestaInterna.getString("id_richiesta") != ""
					&& !"".equals(jsonRichiestaInterna.getString("id_richiesta")))
				moduloRichiedente.setId_richiesta(Long.parseLong(jsonRichiestaInterna.getString("id_richiesta")));

			moduloRichiedente.setTipo("interna");
			moduloRichiedente.setCognome(jsonRichiestaInterna.getString("cognomeint"));
			moduloRichiedente.setNome(jsonRichiestaInterna.getString("nomeint"));
			moduloRichiedente.setCodiceFiscale(jsonRichiestaInterna.getString("cfint"));
			moduloRichiedente.setLuogoNascita(jsonRichiestaInterna.getString("luogonascitaint"));
			moduloRichiedente.setDataNascita(jsonRichiestaInterna.getString("datanascitaint"));
			id_oggetto = jsonRichiestaInterna.getString("oggetto");
			moduloRichiedente.setOggettoRichiestaId(id_oggetto);
			moduloRichiedente.setNumeroBadge(jsonRichiestaInterna.getString("numbadge"));

			request.setAttribute(jsonRichiesta, request.getParameter("jsonRichiestainterna"));

			moduloRichiedente.setDipartimento("");
			moduloRichiedente.setDirezione("");
			moduloRichiedente.setUfficio("");
			moduloRichiedente.setReferenteMef("");
			moduloRichiedente.setTelReferente("");
			moduloRichiedente.setEmailReferente("");
			moduloRichiedente.setSocieta("");
			moduloRichiedente.setSedelegaleSocieta("");
			moduloRichiedente.setIndirizzoSocieta("");
			moduloRichiedente.setTelSocieta("");
			moduloRichiedente.setFaxSocieta("");
			moduloRichiedente.setPecSocieta("");
			moduloRichiedente.setEmailSocieta("");
			moduloRichiedente.setRefSocieta("");
			moduloRichiedente.setEmailRefSocieta("");
			moduloRichiedente.setTelUfficioRefSocieta("");
			moduloRichiedente.setCellRefSocieta("");
			moduloRichiedente.setContratto("");
			moduloRichiedente.setProgetto("");
			moduloRichiedente.setPiano("");
			moduloRichiedente.setPostazione("");
			moduloRichiedente.setSediAbilitate("");
			moduloRichiedente.setDataScadenza("");
			moduloRichiedente.setMotivazione("");
			//modifica 2021
			moduloRichiedente.setSedePostazione("");
			moduloRichiedente.setPianoPostazione("");
			moduloRichiedente.setCorridoioPostazione("");
			moduloRichiedente.setFuoriPortaPostazione("");

			RichiestaBadge richiestaDaForm = RichiestaBadgeLocalServiceUtil
					.fetchRichiestaBadge(moduloRichiedente.getId_richiesta());
			if (richiestaDaForm != null)
				idStato = richiestaDaForm.getId_stato();

		} else {

			JSONObject jsonRichiestaEsterna = JSONFactoryUtil
					.createJSONObject(request.getParameter("jsonRichiestaesterna"));
			moduloRichiedente.setId_richiesta(0L);
			if (jsonRichiestaEsterna.getString("id_richiesta") != null
					&& jsonRichiestaEsterna.getString("id_richiesta") != ""
					&& !"".equals(jsonRichiestaEsterna.getString("id_richiesta")))
				moduloRichiedente.setId_richiesta(Long.parseLong(jsonRichiestaEsterna.getString("id_richiesta")));

			moduloRichiedente.setTipo("esterna");
			moduloRichiedente.setDipartimento(jsonRichiestaEsterna.getString("dipartimento"));
			moduloRichiedente.setDirezione(jsonRichiestaEsterna.getString("direzione"));
			moduloRichiedente.setUfficio(jsonRichiestaEsterna.getString("ufficio"));
			moduloRichiedente.setReferenteMef(jsonRichiestaEsterna.getString("referentemef"));
			moduloRichiedente.setTelReferente(jsonRichiestaEsterna.getString("telreferentemef"));
			moduloRichiedente.setEmailReferente(jsonRichiestaEsterna.getString("emailreferentemef"));
			moduloRichiedente.setCognome(jsonRichiestaEsterna.getString("cognomeest"));
			moduloRichiedente.setNome(jsonRichiestaEsterna.getString("nomeest"));
			moduloRichiedente.setCodiceFiscale(jsonRichiestaEsterna.getString("cfest"));
			moduloRichiedente.setLuogoNascita(jsonRichiestaEsterna.getString("luogonascitaest"));
			moduloRichiedente.setDataNascita(jsonRichiestaEsterna.getString("datanascitaest"));
			moduloRichiedente.setSocieta(jsonRichiestaEsterna.getString("societa"));
			moduloRichiedente.setSedelegaleSocieta(jsonRichiestaEsterna.getString("sedesocieta"));
			moduloRichiedente.setIndirizzoSocieta(jsonRichiestaEsterna.getString("indirizzo"));
			moduloRichiedente.setTelSocieta(jsonRichiestaEsterna.getString("recapitotel"));
			moduloRichiedente.setFaxSocieta(jsonRichiestaEsterna.getString("fax"));
			moduloRichiedente.setPecSocieta(jsonRichiestaEsterna.getString("pec"));
			moduloRichiedente.setEmailSocieta(jsonRichiestaEsterna.getString("email"));
			moduloRichiedente.setRefSocieta(jsonRichiestaEsterna.getString("refsocieta"));
			moduloRichiedente.setEmailRefSocieta(jsonRichiestaEsterna.getString("emailrefsocieta"));
			moduloRichiedente.setTelUfficioRefSocieta(jsonRichiestaEsterna.getString("telufficio"));
			moduloRichiedente.setCellRefSocieta(jsonRichiestaEsterna.getString("cellulare"));
			moduloRichiedente.setContratto(jsonRichiestaEsterna.getString("contratto"));
			moduloRichiedente.setProgetto(jsonRichiestaEsterna.getString("progetto"));
			moduloRichiedente.setPiano(jsonRichiestaEsterna.getString("pianoext"));
			moduloRichiedente.setPostazione(jsonRichiestaEsterna.getString("postazione"));
			moduloRichiedente.setSediAbilitate(jsonRichiestaEsterna.getString("sedi").replace("_", " "));
			moduloRichiedente.setDataScadenza(jsonRichiestaEsterna.getString("scadenza"));
			moduloRichiedente.setMotivazione(jsonRichiestaEsterna.getString("motivazione"));
			
			/*Modifica 2021*/
			moduloRichiedente.setSedePostazione(jsonRichiestaEsterna.getString("sedepos"));
			moduloRichiedente.setPianoPostazione(jsonRichiestaEsterna.getString("pianopos"));
			moduloRichiedente.setCorridoioPostazione(jsonRichiestaEsterna.getString("corridoiopos"));
			moduloRichiedente.setFuoriPortaPostazione(jsonRichiestaEsterna.getString("fuoriportapos"));
			// fine 2021
			
			id_oggetto = jsonRichiestaEsterna.getString("oggetto");
			moduloRichiedente.setOggettoRichiestaId(id_oggetto);
			moduloRichiedente.setNumeroBadge(jsonRichiestaEsterna.getString("numbadge"));

			RichiestaBadge richiestaDaForm = RichiestaBadgeLocalServiceUtil
					.fetchRichiestaBadge(moduloRichiedente.getId_richiesta());
			if (richiestaDaForm != null) {
				idStato = richiestaDaForm.getId_stato();
			}

			request.setAttribute(jsonRichiesta, request.getParameter("jsonRichiestaesterna"));
		}

		File fileTmp;
		String fileName;

		if (request.getParameter("allegatoHidden") != null && request.getParameter("allegatoHidden") != "") {
			fileTmp = new File(request.getParameter("allegatoHidden"));
			moduloRichiedente.setAllegato(fileTmp);
			if (request.getParameter("allegatoNome") != null && request.getParameter("allegatoNome") != "")
				fileName = request.getParameter("allegatoNome");
			else
				fileName = fileTmp.toString().substring((fileTmp.toString().lastIndexOf('/') + 1), fileTmp.toString().length());
			moduloRichiedente.setAllegatoNome(fileName);
		} else {
			copyFileToServer(request, moduloRichiedente, 0, null);
		}

		if (request.getParameter("allegatoOptionalHidden") != null
				&& request.getParameter("allegatoOptionalHidden") != "") {
			fileTmp = new File(request.getParameter("allegatoOptionalHidden"));
			moduloRichiedente.setAllegatoOpzionale(fileTmp);
			if (request.getParameter("allegatoNomeOptional") != null && request.getParameter("allegatoNomeOptional") != "")
				fileName = request.getParameter("allegatoNomeOptional");
			else
				fileName = fileTmp.toString().substring((fileTmp.toString().lastIndexOf('/') + 1), fileTmp.toString().length());
			moduloRichiedente.setAllegatoNomeOpzionale(fileName);
		} else {
			copyFileToServer(request, moduloRichiedente, 1, null);
		}

		if (idStato != 0)
			moduloRichiedente
					.setStato(StatoRichiestaLocalServiceUtil.getStatoRichiesta(idStato).getDescrizione_stato());
		else
			moduloRichiedente.setStato("NUOVA RICHIESTA");

		descrizione_oggetto = OggettoRichiestaLocalServiceUtil.getOggettoRichiesta(Long.parseLong(id_oggetto))
				.getDescrizione_oggetto();
		moduloRichiedente.setOggettoRichiestaDescrizione(descrizione_oggetto);
		moduloRichiedente.setNote(request.getParameter("note"));

		String flagModificaPostSubmit = request.getParameter("flagModificaPostSubmit");

		if (flagModificaPostSubmit != null && !("").equalsIgnoreCase(flagModificaPostSubmit))
			request.setAttribute("modificaRichiestaBadgePostSubmit", flagModificaPostSubmit);

		request.setAttribute("note", request.getParameter("note"));
		request.setAttribute("richiedente", richiedente);
		request.setAttribute("moduloRichiedente", moduloRichiedente);
		request.setAttribute("navigation", "recap");

	}

	@ProcessAction(name = "modificaRichiestaBadge")
	public void modificaRichiestaBadge(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ParseException, IOException, RichiesteBadgeException, PortalException {

		
		Richiedente richiedente = new Richiedente();

		JSONObject jsonRichiedenteSubmit = JSONFactoryUtil
				.createJSONObject(actionRequest.getParameter("DatiRichiedenteSubmit"));
		JSONObject jsonRichiestaSubmit = JSONFactoryUtil
				.createJSONObject(actionRequest.getParameter("DatiRichiestaSubmit"));

		richiedente.setNome(jsonRichiedenteSubmit.getString("nomerichiedente"));
		richiedente.setCognome(jsonRichiedenteSubmit.getString("cognomerichiedente"));
		richiedente.setDipartimento(jsonRichiedenteSubmit.getString("diprichiedente"));
		richiedente.setDirezione(jsonRichiedenteSubmit.getString("dirrichiedente"));
		richiedente.setUfficioRichiedente(jsonRichiedenteSubmit.getString("uffrichiedente"));
		richiedente.setTelefono(jsonRichiedenteSubmit.getString("telrichiedente"));
		richiedente.setEmail(jsonRichiedenteSubmit.getString("emailrichiedente"));

		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();

		if (("interna").equalsIgnoreCase(actionRequest.getParameter("TipoRichiesta"))) {
			moduloRichiedente.setTipo("interna");
			moduloRichiedente.setCognome(HtmlUtil.escape(jsonRichiestaSubmit.getString("cognomeint")));
			moduloRichiedente.setNome(HtmlUtil.escape(jsonRichiestaSubmit.getString("nomeint")));
			moduloRichiedente.setCodiceFiscale(jsonRichiestaSubmit.getString("cfint"));
			moduloRichiedente.setLuogoNascita(jsonRichiestaSubmit.getString("luogonascitaint"));
			moduloRichiedente.setDataNascita(jsonRichiestaSubmit.getString("datanascitaint"));

		} else {
			moduloRichiedente.setTipo("esterna");
			moduloRichiedente.setDipartimento(HtmlUtil.escape(jsonRichiestaSubmit.getString("dipartimento")));
			moduloRichiedente.setDirezione(HtmlUtil.escape(jsonRichiestaSubmit.getString("direzione")));
			moduloRichiedente.setUfficio(HtmlUtil.escape(jsonRichiestaSubmit.getString("ufficio")));
			moduloRichiedente.setReferenteMef(HtmlUtil.escape(jsonRichiestaSubmit.getString("referentemef")));
			moduloRichiedente.setTelReferente(jsonRichiestaSubmit.getString("telreferentemef"));
			moduloRichiedente.setEmailReferente(jsonRichiestaSubmit.getString("emailreferentemef"));
			moduloRichiedente.setCognome(HtmlUtil.escape(jsonRichiestaSubmit.getString("cognomeest")));
			moduloRichiedente.setNome(HtmlUtil.escape(jsonRichiestaSubmit.getString("nomeest")));
			moduloRichiedente.setCodiceFiscale(jsonRichiestaSubmit.getString("cfest"));
			moduloRichiedente.setLuogoNascita(HtmlUtil.escape(jsonRichiestaSubmit.getString("luogonascitaest")));
			moduloRichiedente.setDataNascita(jsonRichiestaSubmit.getString("datanascitaest"));
			moduloRichiedente.setSocieta(HtmlUtil.escape(jsonRichiestaSubmit.getString("societa")));
			moduloRichiedente.setSedelegaleSocieta(HtmlUtil.escape(jsonRichiestaSubmit.getString("sedesocieta")));
			moduloRichiedente.setIndirizzoSocieta(HtmlUtil.escape(jsonRichiestaSubmit.getString("indirizzo")));
			moduloRichiedente.setTelSocieta(jsonRichiestaSubmit.getString("recapitotel"));
			moduloRichiedente.setFaxSocieta(jsonRichiestaSubmit.getString("fax"));
			moduloRichiedente.setPecSocieta(jsonRichiestaSubmit.getString("pec"));
			moduloRichiedente.setEmailSocieta(jsonRichiestaSubmit.getString("email"));
			moduloRichiedente.setRefSocieta(HtmlUtil.escape(jsonRichiestaSubmit.getString("refsocieta")));
			moduloRichiedente.setEmailRefSocieta(jsonRichiestaSubmit.getString("emailrefsocieta"));
			moduloRichiedente.setTelUfficioRefSocieta(jsonRichiestaSubmit.getString("telufficio"));
			moduloRichiedente.setCellRefSocieta(jsonRichiestaSubmit.getString("cellulare"));
			moduloRichiedente.setContratto(HtmlUtil.escape(jsonRichiestaSubmit.getString("contratto")));
			moduloRichiedente.setProgetto(HtmlUtil.escape(jsonRichiestaSubmit.getString("progetto")));
			moduloRichiedente.setPiano(HtmlUtil.escape(jsonRichiestaSubmit.getString("piano")));
			moduloRichiedente.setPostazione(HtmlUtil.escape(jsonRichiestaSubmit.getString("postazione")));
			moduloRichiedente.setSediAbilitate(HtmlUtil.escape(jsonRichiestaSubmit.getString("sedi")));
			moduloRichiedente.setDataScadenza(HtmlUtil.escape(jsonRichiestaSubmit.getString("scadenza")));
			moduloRichiedente.setMotivazione(HtmlUtil.escape(jsonRichiestaSubmit.getString("motivazione")));

			_log.info("Dentro modifica richiesta badge else");
			
			/*Modifica 2021*/
			moduloRichiedente.setSedePostazione(jsonRichiestaSubmit.getString("sedepos"));
			moduloRichiedente.setPianoPostazione(jsonRichiestaSubmit.getString("pianopos"));
			moduloRichiedente.setCorridoioPostazione(jsonRichiestaSubmit.getString("corridoiopos"));
			moduloRichiedente.setFuoriPortaPostazione(jsonRichiestaSubmit.getString("fuoriportapos"));
			
			_log.info("Sede: "+moduloRichiedente.getSedePostazione());
			_log.info("Piano: "+moduloRichiedente.getPianoPostazione());
			_log.info("Corridoio: "+moduloRichiedente.getCorridoioPostazione());
			_log.info("FuoriPorta: "+moduloRichiedente.getFuoriPortaPostazione());
			
			
		}

		moduloRichiedente.setOggettoRichiestaId(jsonRichiestaSubmit.getString("oggetto"));
		moduloRichiedente.setNumeroBadge(jsonRichiestaSubmit.getString("numbadge"));

		moduloRichiedente.setNote(actionRequest.getParameter("NoteRichiestaSubmit"));

		if ((String) actionRequest.getParameter("Allegato") != null
				&& (String) actionRequest.getParameter("Allegato") != "") {
			moduloRichiedente.setAllegatoNome(actionRequest.getParameter("AllegatoNome"));
			moduloRichiedente.setAllegatoMimeType(actionRequest.getParameter("AllegatoMimeType"));
			moduloRichiedente.setAllegato(new File((String) actionRequest.getParameter("Allegato")));
		}

		if ((String) actionRequest.getParameter("AllegatoOpzionale") != null
				&& (String) actionRequest.getParameter("AllegatoOpzionale") != "") {
			moduloRichiedente.setAllegatoNomeOpzionale(actionRequest.getParameter("AllegatoOpzionaleNome"));
			moduloRichiedente.setAllegatoMimeTypeOpzionale(actionRequest.getParameter("AllegatoOpzionaleMimeType"));
			moduloRichiedente.setAllegatoOpzionale(new File((String) actionRequest.getParameter("AllegatoOpzionale")));
		}

		String flagModificaPostSubmit = actionRequest.getParameter("modificaRichiestaBadgePostSubmit");
		if (flagModificaPostSubmit != null && flagModificaPostSubmit != "")
			actionRequest.setAttribute("modificaRichiestaBadgePostSubmit", "modificaRichiestaBadgePostSubmit");

		actionRequest.setAttribute("richiedente", richiedente);
		actionRequest.setAttribute("moduloRichiedente", moduloRichiedente);
		actionRequest.setAttribute("navigation", "formRichiestaBadge");
	}

	// metodo di navigazione per il ritorno al form principale al fine di
	// modificare una richiesta giàinviata
	@ProcessAction(name = "modificaRichiestaBadgePostSubmit")
	public void modificaRichiestaBadgePostSubmit(ActionRequest actionRequest, ActionResponse actionResponse)
			throws JSONException {
		
		_log.info("Dentro richiesta badge post submit");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id_richiesta_pk = 0L;

		if (actionRequest.getParameter("idRichiesta") != null
				&& !("").equalsIgnoreCase(actionRequest.getParameter("idRichiesta"))) {
			id_richiesta_pk = Long.parseLong(actionRequest.getParameter("idRichiesta"));
		}

		Richiedente richiedente = getRichiedenteByidRichiesta(id_richiesta_pk);
		ModuloRichiedente moduloRichiedente = getModuloRichiedenteByidRichiesta(id_richiesta_pk, themeDisplay);

		actionRequest.setAttribute("modificaRichiestaBadgePostSubmit", "modificaRichiestaBadgePostSubmit");
		actionRequest.setAttribute("richiedente", richiedente);
		actionRequest.setAttribute("moduloRichiedente", moduloRichiedente);
		actionRequest.setAttribute("navigation", "formRichiestaBadge");

	}

	private String getHtmlRichiesta(ModuloRichiedente richiesta) {

		StringBuilder dati = new StringBuilder();
		dati.append("<table border='0'>");
		createHtmlForData(dati, "Nome intestatario", richiesta.getNome());
		createHtmlForData(dati, "Cognome intestatario", richiesta.getCognome());
		createHtmlForData(dati, "CF intestatario", richiesta.getCodiceFiscale());

		if (("esterna").equalsIgnoreCase(richiesta.getTipo())) {
			createHtmlForData(dati, "Dipendente della societ&agrave;", richiesta.getSocieta());

			if (("DIREZIONE CENTRALE DEI SISTEMI INFORMATIVI E DELL'INNOVAZIONE")
					.equalsIgnoreCase(richiesta.getDirezione())) {
				createHtmlForData(dati, "Referente societ&agrave;", richiesta.getRefSocieta());
				createHtmlForData(dati, "Denominazione progetto", richiesta.getProgetto());
			}
			createHtmlForData(dati, "Motivazione", richiesta.getMotivazione());
		}
		dati.append("</table>");

		return dati.toString();
	}

	private StringBuilder createHtmlForData(StringBuilder strportion, String title, String data) {

		strportion.append("<tr>");
		strportion.append("<td>");
		strportion.append("<b>" + title + ":</b>");
		strportion.append("</td>");
		strportion.append("<td>");
		strportion.append(data);
		strportion.append("</td>");
		strportion.append("</tr>");
		return strportion;

	}

	@ProcessAction(name = "profiloGestore")
	public void profiloGestore(ActionRequest actionRequest, ActionResponse actionResponse) {

		String navigation = "profiloGestore";
		actionRequest.setAttribute("navigation", navigation);

	}

	@ProcessAction(name = "vaiARicerca")
	public void vaiARicerca(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession pSession = actionRequest.getPortletSession();
		String navigation = "vaiARicerca";
		actionRequest.setAttribute("navigation", navigation);
		pSession.setAttribute("jsonInputRicerca", null, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("filtriRicercaRichieste", null, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("daRicerca", null, PortletSession.APPLICATION_SCOPE);
	}

	@ProcessAction(name = "vaiADettaglio")
	public void vaiADettaglio(ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		RichiestaBadge richiestaBadge;
		Richiedente richiedente = new Richiedente();
		ModuloRichiedente moduloRichiedente = new ModuloRichiedente();

		String json_richiedente;
		JSONObject json_object_richiedente;
		JSONObject json_object_richiesta_interna;
		String json_richiesta_external;
		JSONObject json_object_richiesta_esterna;

		DLFileEntry dlFileEntryFoto;
		DLFileEntry dlFileEntryModulo;
		File fileTmp;

		String urlFoto;
		String urlModuloSostituzione;
	//	String urlBasePath = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
		//		+ themeDisplay.getLayout().getGroupId() + StringPool.SLASH;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String idPkRichiesta = actionRequest.getParameter("richiestaId");

		String navigation = "vaiADettaglio";

		if (idPkRichiesta != null) {
			try {

				richiestaBadge = RichiestaBadgeLocalServiceUtil.getRichiestaBadge(Long.parseLong(idPkRichiesta));
				moduloRichiedente.setId_richiesta(Long.parseLong(idPkRichiesta));

				if (richiestaBadge != null) {

					// richiedente
					json_richiedente = richiestaBadge.getJson_richiedente();
					if (json_richiedente != null && !"".equalsIgnoreCase(json_richiedente)) {
						json_object_richiedente = JSONFactoryUtil.createJSONObject(json_richiedente);

						if (json_object_richiedente != null) {
							actionRequest.setAttribute("jsonRichiedente", json_richiedente);

							richiedente.setNome(json_object_richiedente.getString("nomerichiedente"));
							richiedente.setCognome(json_object_richiedente.getString("cognomerichiedente"));
							richiedente.setDipartimento(json_object_richiedente.getString("diprichiedente"));
							richiedente.setDirezione(json_object_richiedente.getString("dirrichiedente"));
							richiedente.setUfficioRichiedente(json_object_richiedente.getString("uffrichiedente"));
							richiedente.setTelefono(json_object_richiedente.getString("telrichiedente"));
							richiedente.setEmail(json_object_richiedente.getString("emailrichiedente"));
						}
					}

					moduloRichiedente.setStato(StatoRichiestaLocalServiceUtil
							.getStatoRichiesta(richiestaBadge.getId_stato()).getDescrizione_stato());

					moduloRichiedente.setNome(richiestaBadge.getNome_intestatario());
					moduloRichiedente.setCognome(richiestaBadge.getCognome_intestatario());
					moduloRichiedente.setCodiceFiscale(richiestaBadge.getCf_intestatario());
					moduloRichiedente.setLuogoNascita(richiestaBadge.getLuogonascita_intestatario());
					moduloRichiedente.setDataNascita(sdf.format(richiestaBadge.getDatanascita_intestatario()));

					// note
					moduloRichiedente.setNote(richiestaBadge.getNote());

					if (richiestaBadge.getIs_internal()) {
						moduloRichiedente.setTipo("interna");
						json_object_richiesta_interna = JSONFactoryUtil.createJSONObject();
						json_object_richiesta_interna.put("cognomeint", moduloRichiedente.getCognome());
						json_object_richiesta_interna.put("nomeint", moduloRichiedente.getNome());
						json_object_richiesta_interna.put("cfint", moduloRichiedente.getCodiceFiscale());
						json_object_richiesta_interna.put("luogonascitaint", moduloRichiedente.getLuogoNascita());
						json_object_richiesta_interna.put("datanascitaint", moduloRichiedente.getDataNascita());
						json_object_richiesta_interna.put("oggetto", moduloRichiedente.getOggettoRichiestaId());
						json_object_richiesta_interna.put("numbadge", moduloRichiedente.getNumeroBadge());
						actionRequest.setAttribute("jsonRichiesta", json_object_richiesta_interna.toJSONString());

						moduloRichiedente.setSocieta("");
						moduloRichiedente.setDipartimento("");
						moduloRichiedente.setDirezione("");
						moduloRichiedente.setUfficio("");
						moduloRichiedente.setReferenteMef("");
						moduloRichiedente.setTelReferente("");
						moduloRichiedente.setEmailReferente("");
						moduloRichiedente.setSocieta("");
						moduloRichiedente.setSedelegaleSocieta("");
						moduloRichiedente.setIndirizzoSocieta("");
						moduloRichiedente.setTelSocieta("");
						moduloRichiedente.setFaxSocieta("");
						moduloRichiedente.setPecSocieta("");
						moduloRichiedente.setEmailSocieta("");
						moduloRichiedente.setRefSocieta("");
						moduloRichiedente.setEmailRefSocieta("");
						moduloRichiedente.setTelUfficioRefSocieta("");
						moduloRichiedente.setCellRefSocieta("");
						moduloRichiedente.setContratto("");
						moduloRichiedente.setProgetto("");
						moduloRichiedente.setPiano("");
						moduloRichiedente.setPostazione("");
						moduloRichiedente.setSediAbilitate("");
						moduloRichiedente.setDataScadenza("");
						moduloRichiedente.setMotivazione("");
						// modifica 2021
						moduloRichiedente.setSedePostazione("");
						moduloRichiedente.setPianoPostazione("");
						moduloRichiedente.setCorridoioPostazione("");
						moduloRichiedente.setFuoriPortaPostazione("");

					} else {
						moduloRichiedente.setTipo("esterna");

						moduloRichiedente.setSocieta(richiestaBadge.getSocieta());
						moduloRichiedente.setRefSocieta(richiestaBadge.getReferente_societa());
						moduloRichiedente.setProgetto(richiestaBadge.getProgetto());
						moduloRichiedente.setSediAbilitate(richiestaBadge.getArray_sedi_abilitate());
						moduloRichiedente.setMotivazione(richiestaBadge.getMotivazione());
						if (richiestaBadge.getData_scadenza() != null) {
							moduloRichiedente.setDataScadenza(sdf.format(richiestaBadge.getData_scadenza()));
						}
						json_richiesta_external = richiestaBadge.getJson_richiesta_external();

						if (json_richiesta_external != null && !"".equalsIgnoreCase(json_richiesta_external)) {
							json_object_richiesta_esterna = JSONFactoryUtil.createJSONObject(json_richiesta_external);
							actionRequest.setAttribute("jsonRichiesta", json_richiesta_external);

							moduloRichiedente.setDipartimento(
									HtmlUtil.escape(json_object_richiesta_esterna.getString("dipartimento")));
							moduloRichiedente.setDirezione(
									HtmlUtil.escape(json_object_richiesta_esterna.getString("direzione")));
							moduloRichiedente
									.setUfficio(HtmlUtil.escape(json_object_richiesta_esterna.getString("ufficio")));
							moduloRichiedente.setReferenteMef(
									HtmlUtil.escape(json_object_richiesta_esterna.getString("referentemef")));
							moduloRichiedente
									.setTelReferente(json_object_richiesta_esterna.getString("telreferentemef"));
							moduloRichiedente
									.setEmailReferente(json_object_richiesta_esterna.getString("emailreferentemef"));
							moduloRichiedente.setSedelegaleSocieta(
									HtmlUtil.escape(json_object_richiesta_esterna.getString("sedesocieta")));
							moduloRichiedente.setIndirizzoSocieta(
									HtmlUtil.escape(json_object_richiesta_esterna.getString("indirizzo")));
							moduloRichiedente.setTelSocieta(json_object_richiesta_esterna.getString("recapitotel"));
							moduloRichiedente.setFaxSocieta(json_object_richiesta_esterna.getString("fax"));
							moduloRichiedente.setPecSocieta(json_object_richiesta_esterna.getString("pec"));
							moduloRichiedente.setEmailSocieta(json_object_richiesta_esterna.getString("email"));
							moduloRichiedente
									.setEmailRefSocieta(json_object_richiesta_esterna.getString("emailrefsocieta"));
							moduloRichiedente
									.setTelUfficioRefSocieta(json_object_richiesta_esterna.getString("telufficio"));
							moduloRichiedente.setCellRefSocieta(json_object_richiesta_esterna.getString("cellulare"));
							moduloRichiedente.setContratto(
									HtmlUtil.escape(json_object_richiesta_esterna.getString("contratto")));
							moduloRichiedente
									.setPiano(HtmlUtil.escape(json_object_richiesta_esterna.getString("piano")));
							moduloRichiedente.setPostazione(
									HtmlUtil.escape(json_object_richiesta_esterna.getString("postazione")));
							
							// modifica 2021
							moduloRichiedente.setSedePostazione(HtmlUtil.escape(json_object_richiesta_esterna.getString("sedepos")));
							moduloRichiedente.setPianoPostazione(HtmlUtil.escape(json_object_richiesta_esterna.getString("pianopos")));
							moduloRichiedente.setCorridoioPostazione(HtmlUtil.escape(json_object_richiesta_esterna.getString("corridoiopos")));
							moduloRichiedente.setFuoriPortaPostazione(HtmlUtil.escape(json_object_richiesta_esterna.getString("fuoriportapos")));
						}
					}

					// oggetto
					moduloRichiedente.setOggettoRichiestaId(Long.toString(richiestaBadge.getId_oggetto()));
					moduloRichiedente.setOggettoRichiestaDescrizione(OggettoRichiestaLocalServiceUtil
							.getOggettoRichiesta(richiestaBadge.getId_oggetto()).getDescrizione_oggetto());
					moduloRichiedente.setNumeroBadge(richiestaBadge.getNumero_badge());

					// allegati e rispettivi Url
					if (richiestaBadge.getUuid_foto() != null && !"".equals(richiestaBadge.getUuid_foto()) ) {
						dlFileEntryFoto = DLFileEntryLocalServiceUtil.getFileEntryByUuidAndGroupId(
								richiestaBadge.getUuid_foto(), themeDisplay.getLayout().getGroupId());
						
						//FIX DOWNLOADER -- URLfoto diventa idfileEntry					
						urlFoto = Long.toString(dlFileEntryFoto.getFileEntryId());
						
						fileTmp = DLFileEntryLocalServiceUtil.getFile(dlFileEntryFoto.getFileEntryId(),
								dlFileEntryFoto.getVersion(), false);

						moduloRichiedente.setAllegato(fileTmp);
						moduloRichiedente.setAllegatoMimeType(dlFileEntryFoto.getMimeType());
						moduloRichiedente.setAllegatoNome(dlFileEntryFoto.getFileName());

						actionRequest.setAttribute("urlFoto", urlFoto);
					}
					if (richiestaBadge.getUuid_modulosostituzione() != null && !"".equals(richiestaBadge.getUuid_modulosostituzione()) ) {
						dlFileEntryModulo = DLFileEntryLocalServiceUtil.getFileEntryByUuidAndGroupId(
								richiestaBadge.getUuid_modulosostituzione(), themeDisplay.getLayout().getGroupId());
						
						//FIX DOWNLOADER -- urlModuloSostituzione diventa idfileEntry
					
						urlModuloSostituzione =  Long.toString(dlFileEntryModulo.getFileEntryId());
					
						fileTmp = DLFileEntryLocalServiceUtil.getFile(dlFileEntryModulo.getFileEntryId(),
								dlFileEntryModulo.getVersion(), false);

						moduloRichiedente.setAllegatoOpzionale(fileTmp);
						moduloRichiedente.setAllegatoMimeTypeOpzionale(dlFileEntryModulo.getMimeType());
						moduloRichiedente.setAllegatoNomeOpzionale(dlFileEntryModulo.getFileName());

						actionRequest.setAttribute("urlModuloSostituzione", urlModuloSostituzione);
					}

				}

			} catch (NumberFormatException e) {
				_log.error("ERROR: NumberFormatException ", e);

			} catch (PortalException e) {
				_log.error("ERROR: PortalException ", e);
			}
		}

		// recupero json degli input della ricerca e settaggio come attribute
		// nella request
		String jsonInputRicerca = actionRequest.getParameter("jsonInputRicerca");
		actionRequest.setAttribute("jsonInputRicerca", jsonInputRicerca);

		actionRequest.setAttribute("richiedente", richiedente);
		actionRequest.setAttribute("moduloRichiedente", moduloRichiedente);
		actionRequest.setAttribute("navigation", navigation);
		actionRequest.setAttribute("richiestaId", idPkRichiesta);
	}

	// metodo per ricerca delle richieste badge
	@ProcessAction(name = "ricercaRichieste")
	public void ricercaRichieste(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		PortletSession session = actionRequest.getPortletSession();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		String screenName = null;
		List<Long> lista_IdUffici = new ArrayList<Long>();
		List<Long> lista_sedi = new ArrayList<Long>();
		List<Long> lista_stati = new ArrayList<Long>();
		boolean is_last = true;
		String is_internal = "";

		// recupero ruoli utente
		boolean dirigente = false;
		boolean abilitatoBadge = false;
		boolean delegatoBadge = false;
		boolean gestoreInterno = false;
		boolean gestoreEsterno = false;

		List<String> listaGestoriExt = new ArrayList<>();
		List<String> roles_list = getRolesFromUser(themeDisplay);
		if (roles_list.contains(_abilitatoBadge)) {
			abilitatoBadge = true;
		}
		if (roles_list.contains(_delegatoBadge)) {
			delegatoBadge = true;
		}
		if (roles_list.contains(_roledirigente)) {
			dirigente = true;
		}
		if (roles_list.contains(_gestoreInterno)) {
			gestoreInterno = true;
		}
		if (roles_list.contains(_gestoreEsterno)) {
			gestoreEsterno = true;
			listaGestoriExt = getGestoriEsterniRoles(themeDisplay);
		}

		if (abilitatoBadge && !delegatoBadge && !dirigente) {
			screenName = user.getScreenName();
		}

		if (dirigente || delegatoBadge) {
			String personIdDir = null;
			if (user != null) {
				if (dirigente) {
					personIdDir = (String) user.getExpandoBridge().getAttribute(_customFieldUserPersonal);
				} else if (delegatoBadge) {
					personIdDir = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
				}
			}
			if (personIdDir != null && personIdDir != "") {
				for (ManagerOfficesBind managerOfficesBind : ManagerOfficesBindLocalServiceUtil
						.getManagerOfficesBindByPersonId(Long.parseLong(personIdDir))) {

					try {
						lista_IdUffici.add(managerOfficesBind.getIdOrgChart());

						Set<Long> setIdUffici = new HashSet<>();
						setIdUffici.addAll(lista_IdUffici);
						lista_IdUffici.clear();
						lista_IdUffici.addAll(setIdUffici);

					} catch (Exception e) {
						_log.warn("error in retrieve offices list by manager" + e);

					}
				}
			}

		}

		List<RichiestaBadge> listaIntRicerca;
		List<RichiestaBadge> listaExtRicerca;

		if (gestoreInterno && !gestoreEsterno) {
			is_internal = "true";
		} else if (gestoreEsterno && !gestoreInterno) {
			is_internal = "false";
		}
		
		if (gestoreEsterno) {
			SediEsterne sede;
			if (listaGestoriExt != null && !listaGestoriExt.isEmpty()) {
				for (String gestoreRole : listaGestoriExt) {
					sede = SediEsterneLocalServiceUtil.getSediEsterneByAcronimoSede(gestoreRole.split("_")[1]).get(0);
					if (sede != null)
						lista_sedi.add(sede.getId_sedesiap());
				}
			}
		}

	

		List<String> filtriRicercaRichieste = new ArrayList<String>();

		String cogn_intest = null;
		String nome_intest = null;
		String cf_intest = null;
		String societa = null;
		String ref_societa = null;
		String progetto = null;
		String motivazione = null;

		// recupero json degli input della ricerca AZIONATA DA DETTAGLIO
		// (inserimentobadge-recap.jsp)
		// e settaggio come attribute nella request (se non è nullo e se non è
		// vuoto)
		String jsonInputRicercaFromDettaglio = actionRequest.getParameter("jsonInputRicercaFromDettaglio");

		// se la ricerca è azionata da tasto Applica presente in
		// ricerca-richieste.jsp
		if (jsonInputRicercaFromDettaglio == null || "".equals(jsonInputRicercaFromDettaglio)) {

			if (actionRequest.getParameter("cogn_intest") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("cogn_intest"))) {
				cogn_intest = actionRequest.getParameter("cogn_intest");
				filtriRicercaRichieste.add(cogn_intest);
			}

			if (actionRequest.getParameter("nome_intest") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("nome_intest"))) {
				nome_intest = actionRequest.getParameter("nome_intest");
				filtriRicercaRichieste.add(nome_intest);
			}

			if (actionRequest.getParameter("cf_intest") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("cf_intest"))) {
				cf_intest = actionRequest.getParameter("cf_intest");
				filtriRicercaRichieste.add(cf_intest);
			}

			if (actionRequest.getParameter("societa") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("societa"))) {
				societa = actionRequest.getParameter("societa");
				filtriRicercaRichieste.add(societa);
			}

			if (actionRequest.getParameter("ref_societa") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("ref_societa"))) {
				ref_societa = actionRequest.getParameter("ref_societa");
				filtriRicercaRichieste.add(ref_societa);
			}

			if (actionRequest.getParameter("progetto") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("progetto"))) {
				progetto = actionRequest.getParameter("progetto");
				filtriRicercaRichieste.add(progetto);
			}

			if (actionRequest.getParameter("motivazione") != null
					&& !("").equalsIgnoreCase(actionRequest.getParameter("motivazione"))) {
				motivazione = actionRequest.getParameter("motivazione");
				filtriRicercaRichieste.add(motivazione);
			}

			if (actionRequest.getParameterValues("statiRichiesta") != null) {
				String[] arrayStati = (String[]) actionRequest.getParameterValues("statiRichiesta");
				List<String> listaStatiStr = Arrays.asList(arrayStati);
				for (String s : listaStatiStr) {
					lista_stati.add(Long.valueOf(s));
				}

				for (Long id_stato : lista_stati) {
					String descrizioneStato = StatoRichiestaLocalServiceUtil.getStatoRichiesta(id_stato)
							.getDescrizione_stato();
					filtriRicercaRichieste.add(descrizioneStato);
				}

			}

		}
		// se la ricerca è azionata da dettaglio (inserimentobadge-recap.jsp)
		else {

			JSONObject jsonObjectInputRicercafromDettaglio = JSONFactoryUtil
					.createJSONObject(jsonInputRicercaFromDettaglio);

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("cognome_int"))) {
				cogn_intest = jsonObjectInputRicercafromDettaglio.getString("cognome_int");
				filtriRicercaRichieste.add(cogn_intest);
			}

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("nome_int"))) {
				nome_intest = jsonObjectInputRicercafromDettaglio.getString("nome_int");
				filtriRicercaRichieste.add(nome_intest);
			}

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("cf_int"))) {
				cf_intest = jsonObjectInputRicercafromDettaglio.getString("cf_int");
				filtriRicercaRichieste.add(cf_intest);
			}

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("societa"))) {
				societa = jsonObjectInputRicercafromDettaglio.getString("societa");
				filtriRicercaRichieste.add(societa);
			}

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("ref_societa"))) {
				ref_societa = jsonObjectInputRicercafromDettaglio.getString("ref_societa");
				filtriRicercaRichieste.add(ref_societa);
			}

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("progetto"))) {
				progetto = jsonObjectInputRicercafromDettaglio.getString("progetto");
				filtriRicercaRichieste.add(progetto);
			}

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("motivazione"))) {
				motivazione = jsonObjectInputRicercafromDettaglio.getString("motivazione");
				filtriRicercaRichieste.add(motivazione);
			}

			if (!("").equalsIgnoreCase(jsonObjectInputRicercafromDettaglio.getString("stati"))) {

				if (jsonObjectInputRicercafromDettaglio.getString("stati").contains(",")) {

					List<String> listaStatiStr = Arrays
							.asList(jsonObjectInputRicercafromDettaglio.getString("stati").split(", "));

					for (String s : listaStatiStr) {
						lista_stati.add(Long.valueOf(s));
					}

				} else {

					lista_stati.add(Long.parseLong(jsonObjectInputRicercafromDettaglio.getString("stati")));

				}

				for (Long id_stato : lista_stati) {
					String descrizioneStato = StatoRichiestaLocalServiceUtil.getStatoRichiesta(id_stato)
							.getDescrizione_stato();
					filtriRicercaRichieste.add(descrizioneStato);
				}

			}

			actionRequest.setAttribute("jsonInputRicerca", jsonInputRicercaFromDettaglio);
			session.setAttribute("jsonInputRicerca", jsonInputRicercaFromDettaglio, PortletSession.APPLICATION_SCOPE);

		}

		// RICERCA DA ACTION
		
		List<RichiestaBadge> richieste_tot = new ArrayList<>();
		

		if(gestoreInterno && gestoreEsterno){
		
		is_internal = "true";
			richieste_tot.addAll(RichiestaBadgeLocalServiceUtil.getRichiestaBadgeByFilters(cogn_intest, nome_intest,
					cf_intest, societa, ref_societa, motivazione, progetto, screenName, lista_IdUffici, is_last, null,
					is_internal, lista_stati));
	
		is_internal = "false";
		
			richieste_tot.addAll(RichiestaBadgeLocalServiceUtil.getRichiestaBadgeByFilters(cogn_intest, nome_intest,
					cf_intest, societa, ref_societa, motivazione, progetto, screenName, lista_IdUffici, is_last, lista_sedi,
					is_internal, lista_stati));
			
		
		} else {
		
			richieste_tot.addAll(RichiestaBadgeLocalServiceUtil.getRichiestaBadgeByFilters(cogn_intest, nome_intest,
				cf_intest, societa, ref_societa, motivazione, progetto, screenName, lista_IdUffici, is_last, lista_sedi,
				is_internal, lista_stati));
		}
		
		
		
//		_log.info("--------------------------ricerca--------------------------------------");
//		for (Iterator iterator = risultato_ricerca.iterator(); iterator.hasNext();) {
//			RichiestaBadge richiestaBadge = (RichiestaBadge) iterator.next();
//			_log.info("-"+richiestaBadge.getNome_intestatario()+" "+richiestaBadge.getCognome_intestatario()+" "+richiestaBadge.getId_stato());
//		}
//		_log.info("--------------------------------------------------------------------------------------");

		// creazione bean risultati per creazione excel
		JSONArray jsonarray_risultati_excel = JSONFactoryUtil.createJSONArray();

		if (!richieste_tot.isEmpty()) {

			for (RichiestaBadge singola_richiesta : richieste_tot) {

				JSONObject json_richiedente = JSONFactoryUtil.createJSONObject(singola_richiesta.getJson_richiedente());
				JSONObject json_richiesta_external;

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				String tipo_richiesta = "esterna";

				if (singola_richiesta.getIs_internal()) {
					tipo_richiesta = "interna";
				}

				RichiestaBadgeExcelBean risultato_richiesta_bean = new RichiestaBadgeExcelBean();

				risultato_richiesta_bean.setId_richiesta_badge(String.valueOf(singola_richiesta.getId_richiesta()));
				risultato_richiesta_bean.setNome_richiedente(json_richiedente.getString("nomerichiedente"));
				risultato_richiesta_bean.setCognome_richiedente(json_richiedente.getString("cognomerichiedente"));
				risultato_richiesta_bean.setDip_richiedente(json_richiedente.getString("diprichiedente"));
				risultato_richiesta_bean.setDir_richiedente(json_richiedente.getString("dirrichiedente"));
				risultato_richiesta_bean.setUff_richiedente(json_richiedente.getString("uffrichiedente"));
				risultato_richiesta_bean.setTel_richiedente(json_richiedente.getString("telrichiedente"));
				risultato_richiesta_bean.setEmail_richiedente(json_richiedente.getString("emailrichiedente"));
				risultato_richiesta_bean.setData_richiesta(sdf.format(singola_richiesta.getData_richiesta()));
				risultato_richiesta_bean.setTipo_richiesta(tipo_richiesta);
				risultato_richiesta_bean.setStato_richiesta(StatoRichiestaLocalServiceUtil
						.getStatoRichiesta(singola_richiesta.getId_stato()).getDescrizione_stato());
				risultato_richiesta_bean.setNome_int(singola_richiesta.getNome_intestatario());
				risultato_richiesta_bean.setCognome_int(singola_richiesta.getCognome_intestatario());
				risultato_richiesta_bean.setCf_int(singola_richiesta.getCf_intestatario());
				risultato_richiesta_bean.setLuogo_nascita_int(singola_richiesta.getLuogonascita_intestatario());
				risultato_richiesta_bean
						.setData_nascita_int(sdf.format(singola_richiesta.getDatanascita_intestatario()));

				if ("esterna".equalsIgnoreCase(tipo_richiesta)) {

					json_richiesta_external = JSONFactoryUtil
							.createJSONObject(singola_richiesta.getJson_richiesta_external());

					risultato_richiesta_bean.setSocieta(singola_richiesta.getSocieta());
					risultato_richiesta_bean.setReferente_societa(singola_richiesta.getReferente_societa());
					risultato_richiesta_bean.setDipartimento(json_richiesta_external.getString("dipartimento"));
					risultato_richiesta_bean.setDirezione(json_richiesta_external.getString("direzione"));
					risultato_richiesta_bean.setUfficio(json_richiesta_external.getString("ufficio"));
					risultato_richiesta_bean.setReferente_mef(json_richiesta_external.getString("referentemef"));
					risultato_richiesta_bean.setTel_referente_mef(json_richiesta_external.getString("telreferentemef"));
					risultato_richiesta_bean
							.setEmail_referente_mef(json_richiesta_external.getString("emailreferentemef"));
					risultato_richiesta_bean.setSede_legale_societa(json_richiesta_external.getString("sedesocieta"));
					risultato_richiesta_bean.setIndirizzo(json_richiesta_external.getString("indirizzo"));
					risultato_richiesta_bean.setRecapito_tel(json_richiesta_external.getString("recapitotel"));
					risultato_richiesta_bean.setFax(json_richiesta_external.getString("fax"));
					risultato_richiesta_bean.setPec(json_richiesta_external.getString("pec"));
					risultato_richiesta_bean.setEmail(json_richiesta_external.getString("email"));
					risultato_richiesta_bean
							.setEmail_referente_societa(json_richiesta_external.getString("emailrefsocieta"));
					risultato_richiesta_bean.setTel_ufficio(json_richiesta_external.getString("telufficio"));
					risultato_richiesta_bean.setCell(json_richiesta_external.getString("cellulare"));
					risultato_richiesta_bean.setContratto(json_richiesta_external.getString("contratto"));
					risultato_richiesta_bean.setProgetto(singola_richiesta.getProgetto());
					risultato_richiesta_bean.setPiano(json_richiesta_external.getString("piano"));
					risultato_richiesta_bean.setPostazione(json_richiesta_external.getString("postazione"));
					risultato_richiesta_bean.setSedi(singola_richiesta.getArray_sedi_abilitate());
					
					// modifica 2021
					risultato_richiesta_bean.setSedePostazione(json_richiesta_external.getString("sedepos"));
					risultato_richiesta_bean.setPianoPostazione(json_richiesta_external.getString("pianopos"));
					risultato_richiesta_bean.setCorridoioPostazione(json_richiesta_external.getString("corridoiopos"));
					risultato_richiesta_bean.setFuoriPortaPostazione(json_richiesta_external.getString("fuoriportapos"));
					
					
					
					if (singola_richiesta.getData_scadenza() != null) {
						risultato_richiesta_bean
								.setData_scadenza_badge(sdf.format(singola_richiesta.getData_scadenza()));
					}

					risultato_richiesta_bean.setMotivazione(singola_richiesta.getMotivazione());

				}

				risultato_richiesta_bean.setOggetto(OggettoRichiestaLocalServiceUtil
						.getOggettoRichiesta(singola_richiesta.getId_oggetto()).getDescrizione_oggetto());
				risultato_richiesta_bean.setNumero_badge(singola_richiesta.getNumero_badge());

				DLFileEntry allegato_foto;
				DLFileEntry allegato_modulo_sostituzione;
				StringBuilder allegati = new StringBuilder();
				List<String> lista_nomi_allegati = new ArrayList<String>(0);

				if (singola_richiesta.getUuid_foto() != null
						&& !"".equalsIgnoreCase(singola_richiesta.getUuid_foto())) {
					allegato_foto = DLFileEntryLocalServiceUtil.getDLFileEntryByUuidAndGroupId(
							singola_richiesta.getUuid_foto(), themeDisplay.getLayout().getGroupId());
					lista_nomi_allegati.add(allegato_foto.getFileName());
				}

				if (singola_richiesta.getUuid_modulosostituzione() != null
						&& !"".equalsIgnoreCase(singola_richiesta.getUuid_modulosostituzione())) {
					allegato_modulo_sostituzione = DLFileEntryLocalServiceUtil.getDLFileEntryByUuidAndGroupId(
							singola_richiesta.getUuid_modulosostituzione(), themeDisplay.getLayout().getGroupId());
					lista_nomi_allegati.add(allegato_modulo_sostituzione.getFileName());
				}

				if (!lista_nomi_allegati.isEmpty()) {
					for (int i = 0; i < lista_nomi_allegati.size(); i++) {
						allegati.append(lista_nomi_allegati.get(i));
						if (i == 0 && lista_nomi_allegati.size() > 1) {
							allegati.append(", ");
						}
					}
				}

				risultato_richiesta_bean.setAllegati(allegati.toString());

				risultato_richiesta_bean.setNote(singola_richiesta.getNote());

				jsonarray_risultati_excel.put(risultato_richiesta_bean.toJSONObject());

			}

			actionRequest.setAttribute("jsonExcel", jsonarray_risultati_excel.toString());

		}

		String itemsPerPage = actionRequest.getPreferences().getValue("itemsPerPage",
				Integer.toString(_configuration.itemsPerPage()));

		if (gestoreEsterno && gestoreInterno) {
			is_internal = "true";
			listaIntRicerca = RichiestaBadgeLocalServiceUtil.getRichiestaBadgeByFilters(cogn_intest, nome_intest,
					cf_intest, societa, ref_societa, motivazione, progetto, screenName, lista_IdUffici, is_last,
					null, is_internal, lista_stati);

			is_internal = "false";
			
			listaExtRicerca = RichiestaBadgeLocalServiceUtil.getRichiestaBadgeByFilters(cogn_intest, nome_intest,
					cf_intest, societa, ref_societa, motivazione, progetto, screenName, lista_IdUffici, is_last,
					lista_sedi, is_internal, lista_stati);

			List<List<RichiestaBadge>> listpagesIntRicerca = listPaginationRichieste(itemsPerPage, listaIntRicerca);
			List<List<RichiestaBadge>> listpagesExtRicerca = listPaginationRichieste(itemsPerPage, listaExtRicerca);

			session.setAttribute("listaIntRicerca", listpagesIntRicerca, PortletSession.APPLICATION_SCOPE);
			session.setAttribute("listaExtRicerca", listpagesExtRicerca, PortletSession.APPLICATION_SCOPE);
			session.setAttribute("listaRichiesteGestoreInt", null, PortletSession.APPLICATION_SCOPE);
			session.setAttribute("listaRichiesteGestoreExt", null, PortletSession.APPLICATION_SCOPE);

			List<RichiestaBadge> listResultsInterne = null;
			List<RichiestaBadge> listResultsEsterne = null;

			int pageRichiesteInterne = 1;
			int numPageRichiesteInterne = 0;
			int pageRichiesteEsterne = 1;
			int numPageRichiesteEsterne = 0;

			if (listpagesIntRicerca != null && !listpagesIntRicerca.isEmpty()) {
				listResultsInterne = listpagesIntRicerca.get(0);
				numPageRichiesteInterne = listpagesIntRicerca.size();
			}
			if (listpagesExtRicerca != null && !listpagesExtRicerca.isEmpty()) {
				listResultsEsterne = listpagesExtRicerca.get(0);
				numPageRichiesteEsterne = listpagesExtRicerca.size();
			}
			actionRequest.setAttribute("listaIntRicerca", listResultsInterne);
			actionRequest.setAttribute("listaExtRicerca", listResultsEsterne);
			actionRequest.setAttribute("pageRichiesteInterne", pageRichiesteInterne);
			actionRequest.setAttribute("numPageRichiesteInterne", numPageRichiesteInterne);
			actionRequest.setAttribute("pageRichiesteEsterne", pageRichiesteEsterne);
			actionRequest.setAttribute("numPageRichiesteEsterne", numPageRichiesteEsterne);
			actionRequest.setAttribute("listaRichiesteGestoreInt", null);
			actionRequest.setAttribute("listaRichiesteGestoreExt", null);

//			is_internal = null;
//			int totalSize = RichiestaBadgeLocalServiceUtil
//					.getRichiestaBadgeByFilters(cogn_intest, nome_intest, cf_intest, societa, ref_societa, motivazione,
//							progetto, screenName, lista_IdUffici, is_last, null, is_internal, lista_stati)
//					.size();
			int totalSize = 0;
			if(listaIntRicerca!=null && listaExtRicerca!=null) {
				totalSize = listaIntRicerca.size() + listaExtRicerca.size();
			}
			
			actionRequest.setAttribute("totalSize", totalSize);

		} else {

			List<List<RichiestaBadge>> listpagesRicerca = listPaginationRichieste(itemsPerPage, richieste_tot);
			session.setAttribute("risultato_ricerca", listpagesRicerca, PortletSession.APPLICATION_SCOPE);

			int pageRichieste = 1;
			int numPageRichieste = 0;
			List<RichiestaBadge> listResults = null;

			if (listpagesRicerca != null && !listpagesRicerca.isEmpty()) {

				listResults = listpagesRicerca.get(0);
				numPageRichieste = listpagesRicerca.size();

			}

			actionRequest.setAttribute("risultato_ricerca", listResults);
			actionRequest.setAttribute("pageRichieste", pageRichieste);
			actionRequest.setAttribute("numPageRichieste", numPageRichieste);
			actionRequest.setAttribute("totalSize", richieste_tot.size());

		}

		// recupero json degli input della ricerca (azionata da tasto Applica in
		// ricerca-richieste.jsp) e settaggio come attribute nella request (se
		// non è nullo e se non è vuoto)
		String jsonInputRicerca = actionRequest.getParameter("jsonInputRicerca");

		if (jsonInputRicerca != null && !"".equals(jsonInputRicerca)) {
			actionRequest.setAttribute("jsonInputRicerca", jsonInputRicerca);
			session.setAttribute("jsonInputRicerca", jsonInputRicerca, PortletSession.APPLICATION_SCOPE);
		}

		actionRequest.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste);
		session.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste, PortletSession.APPLICATION_SCOPE);
		actionRequest.setAttribute("navigation", "vaiARicerca");
		actionRequest.setAttribute("daRicerca", "daRicerca");
		session.setAttribute("daRicerca", "daRicerca", PortletSession.APPLICATION_SCOPE);
	}

	// metodo per funzionalità di "richiedi modifica della richiesta"
	@ProcessAction(name = "richiediModificaRichiesta")
	public void richiediModificaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, PortletModeException, IOException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		boolean is_last = true;
		RichiestaBadge richiestaDett = null;
		long idPkRichiesta = 0L;
		long idRichiestaNew = 0L;
		String navigation = "vaiADettaglio";

		if (actionRequest.getParameter("idRichiesta") != null
				&& !("").equalsIgnoreCase(actionRequest.getParameter("idRichiesta"))) {
			idPkRichiesta = Long.parseLong(actionRequest.getParameter("idRichiesta"));
		}
		try {
			if (idPkRichiesta != 0 && RichiestaBadgeLocalServiceUtil.getRichiestaBadge(idPkRichiesta) != null) {

				richiestaDett = RichiestaBadgeLocalServiceUtil.getRichiestaBadge(idPkRichiesta);

				String note_badge = richiestaDett.getNote();
				if (actionRequest.getParameter("noteBadgeRichiediHidden") != null
						&& !("").equalsIgnoreCase(actionRequest.getParameter("noteBadgeRichiediHidden"))) {
					note_badge = actionRequest.getParameter("noteBadgeRichiediHidden");
				}

				// recupero dell'id stato relativo a Richiesta Di Modifica
				long id_stato = 0;
				List<StatoRichiesta> listaStati = StatoRichiestaLocalServiceUtil
						.findStatoByDescrizione("RICHIESTA DI MODIFICA");
				if (listaStati != null && !listaStati.isEmpty()) {
					id_stato = listaStati.get(0).getId_stato();
				}

				idRichiestaNew = RichiestaBadgeLocalServiceUtil.aggiornaRichiestaBadge(idPkRichiesta,
						richiestaDett.getScreename_richiedente(), richiestaDett.getId_ufficio(),
						richiestaDett.getJson_richiedente(), richiestaDett.getIs_internal(),
						richiestaDett.getNome_intestatario(), richiestaDett.getCognome_intestatario(),
						richiestaDett.getCf_intestatario(), richiestaDett.getLuogonascita_intestatario(),
						richiestaDett.getDatanascita_intestatario(), richiestaDett.getId_oggetto(),
						richiestaDett.getNumero_badge(), richiestaDett.getUuid_foto(),
						richiestaDett.getUuid_modulosostituzione(), richiestaDett.getSocieta(),
						richiestaDett.getReferente_societa(), richiestaDett.getProgetto(),
						richiestaDett.getJson_richiesta_external(), richiestaDett.getArray_sedi_abilitate(),
						richiestaDett.getMotivazione(), richiestaDett.getData_scadenza(),
						richiestaDett.getUuid_modulopdf(), richiestaDett.getData_richiesta(), new Date(), id_stato,
						user.getScreenName(), note_badge, is_last, richiestaDett.getId_sedesiap());
			}
			if (idRichiestaNew != 0) {

				// send email
				String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl",
						_configuration.richiestaTmpl());
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
				String subject = actionRequest.getPreferences().getValue("subjectRichiediModifica",
						_configuration.subjectRichiediModifica());
				subject = StringUtil.replace(subject, new String[] { "[$IDRICHIESTA$]" },
						new String[] { String.valueOf(richiestaDett.getId_richiesta()) });

				ModuloRichiedente moduloRichiedente = getModuloRichiedenteByidRichiesta(idRichiestaNew, themeDisplay);
				String datirichiesta = getHtmlRichiesta(moduloRichiedente);
				mailbody = StringUtil.replace(mailbody, new String[] { "[$OGGETTO$]", "[$DATI$]" },
						new String[] { subject, datirichiesta });
				EmailSender mail = new EmailSender();

				// invia email a referente
				String emailRichiedente = (UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(),
						richiestaDett.getScreename_richiedente())).getEmailAddress();
				if (emailRichiedente != null && !("").equalsIgnoreCase(emailRichiedente)) {
					mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRichiedente);
				}
			}

			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter("navigation", navigation);
			renderUrl.setParameter("richiestaId", String.valueOf(idRichiestaNew));
			actionResponse.sendRedirect(renderUrl.toString());
		} catch (Exception e) {
			_log.error("Errore durante l'inserimento della segnalazione: " + e);
			SessionErrors.add(actionRequest, "Errore-durante-inserimento-segnalazione");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}

	}

	/*
	 * metodo per andare nella pagina principale della funzionalità di proroga
	 * massiva
	 */
	@ProcessAction(name = "vaiAProrogaBadge")
	public void vaiAProrogaBadge(ActionRequest actionRequest, ActionResponse actionResponse) {

		String navigation = "vaiAProrogaBadge";
		actionRequest.setAttribute("navigation", navigation);

	}

	/*
	 * metodo per ricercare le richieste in scadenza nell'intervallo temporale
	 * selezionato
	 */
	@ProcessAction(name = "cercaRichiesteInScadenza")
	public void cercaRichiesteInScadenza(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ParseException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		String screen_name_richiedente = null;
		List<Long> id_uffici_competenza_list = new ArrayList<Long>();

		// recupero ruoli utente
		boolean dirigente = false;
		boolean abilitatoBadge = false;
		boolean delegatoBadge = false;

		List<String> roles_list = getRolesFromUser(themeDisplay);
		if (roles_list.contains(_abilitatoBadge)) {
			abilitatoBadge = true;
		}
		if (roles_list.contains(_delegatoBadge)) {
			delegatoBadge = true;
		}
		if (roles_list.contains(_roledirigente)) {
			dirigente = true;
		}

		if (abilitatoBadge && !delegatoBadge && !dirigente) {
			screen_name_richiedente = user.getScreenName();
		}

		if (dirigente || delegatoBadge) {
			String personIdDir = null;
			if (user != null) {
				if (dirigente) {
					personIdDir = (String) user.getExpandoBridge().getAttribute(_customFieldUserPersonal);
				} else if (delegatoBadge) {
					personIdDir = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
				}
			}
			if (personIdDir != null && personIdDir != "") {
				for (ManagerOfficesBind managerOfficesBind : ManagerOfficesBindLocalServiceUtil
						.getManagerOfficesBindByPersonId(Long.parseLong(personIdDir))) {

					try {
						id_uffici_competenza_list.add(managerOfficesBind.getIdOrgChart());

						Set<Long> setIdUffici = new HashSet<>();
						setIdUffici.addAll(id_uffici_competenza_list);
						id_uffici_competenza_list.clear();
						id_uffici_competenza_list.addAll(setIdUffici);

					} catch (Exception e) {
						_log.warn("error in retrieve offices list by manager" + e);

					}
				}
			}

		}

		boolean is_last = true;

		// recupera i parametri selezionati relativi alle date di inizio e fine
		// entro cui cercare le richieste in scadenza
		String filtro_data_inizio = actionRequest.getParameter("dataInizio");
		String filtro_data_fine = actionRequest.getParameter("dataFine");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date data_begin = null;
		Date data_end = null;

		if (filtro_data_inizio != null && !"".equals(filtro_data_inizio)) {
			data_begin = sdf.parse(filtro_data_inizio);
		}

		if (filtro_data_fine != null && !"".equals(filtro_data_fine)) {
			data_end = sdf.parse(filtro_data_fine);
		}

		// dynamic query per la ricerca dei badge in scadenza
		List<RichiestaBadge> richieste_in_scadenza_list = RichiestaBadgeLocalServiceUtil.findRichiesteInScadenza(
				data_begin, data_end, is_last, 4, screen_name_richiedente, id_uffici_competenza_list);

		// logica per la conversione della lista dei badge in scadenza in
		// JSONArray
		JSONArray jsonarray_risultati_scadenza = JSONFactoryUtil.createJSONArray();

		if (!richieste_in_scadenza_list.isEmpty()) {

			for (RichiestaBadge richiestaBadge : richieste_in_scadenza_list) {

				RichiestaInScadenzaItemBean richiestaInScadenzaItemBean = new RichiestaInScadenzaItemBean();
				richiestaInScadenzaItemBean.setId_pk(String.valueOf(richiestaBadge.getId_pk()));
				richiestaInScadenzaItemBean.setId_richiesta(String.valueOf(richiestaBadge.getId_richiesta()));
				richiestaInScadenzaItemBean.setNome_int(richiestaBadge.getNome_intestatario());
				richiestaInScadenzaItemBean.setCognome_int(richiestaBadge.getCognome_intestatario());
				richiestaInScadenzaItemBean.setCf_int(richiestaBadge.getCf_intestatario());
				richiestaInScadenzaItemBean.setNumero_badge(richiestaBadge.getNumero_badge());
				richiestaInScadenzaItemBean.setData_scadenza(sdf.format(richiestaBadge.getData_scadenza()));

				if (richiestaBadge.getIs_internal()) {
					richiestaInScadenzaItemBean.setTipologia_utente("Interno");
				} else {
					richiestaInScadenzaItemBean.setTipologia_utente("Esterno");
					richiestaInScadenzaItemBean.setSocieta(richiestaBadge.getSocieta());
					richiestaInScadenzaItemBean.setRef_societa(richiestaBadge.getReferente_societa());
					richiestaInScadenzaItemBean.setSedi(richiestaBadge.getArray_sedi_abilitate());
				}

				jsonarray_risultati_scadenza.put(richiestaInScadenzaItemBean.toJSONObject());
			}
		}

		actionRequest.setAttribute("jsonScadenzaSelezionata", jsonarray_risultati_scadenza.toString());
		actionRequest.setAttribute("dataInizioSelezionata", filtro_data_inizio);
		actionRequest.setAttribute("dataFineSelezionata", filtro_data_fine);
		actionRequest.setAttribute("navigation", "vaiAProrogaBadge");
	}

	/*
	 * metodo per andare nel riepilogo delle richieste selezionate da prorogare
	 */
	@ProcessAction(name = "vaiARiepilogoProroga")
	public void vaiARiepilogoProroga(ActionRequest actionRequest, ActionResponse actionResponse) {

		// recupero array degli id delle richieste selezionate
		String[] arrayIdRichiesteSelezionate = actionRequest.getParameterValues("idRichiestaSelezionata");
		List<String> listIdRichiesteSelezionate = new ArrayList<String>(0);

		// recupero parametro relativo alla nuova data di scadenza
		String nuovaDataScadenza = actionRequest.getParameter("nuovaDataScadenza");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// logica per la conversione della lista delle richieste selezionate in
		// JSONArray
		JSONArray jsonarray_lista_riepilogo_proroga = JSONFactoryUtil.createJSONArray();

		for (int i = 0; i < arrayIdRichiesteSelezionate.length; i++) {
			listIdRichiesteSelezionate.add(arrayIdRichiesteSelezionate[i].trim());
			long id_richiesta_selezionata_long = Long.parseLong(arrayIdRichiesteSelezionate[i]);
			try {
				RichiestaBadge richiesta_badge_selezionata = RichiestaBadgeLocalServiceUtil
						.getRichiestaBadge(id_richiesta_selezionata_long);

				RichiestaInScadenzaItemBean richiestaDaProrogareItemBean = new RichiestaInScadenzaItemBean();
				richiestaDaProrogareItemBean.setId_pk(String.valueOf(richiesta_badge_selezionata.getId_pk()));
				richiestaDaProrogareItemBean
						.setId_richiesta(String.valueOf(richiesta_badge_selezionata.getId_richiesta()));
				richiestaDaProrogareItemBean.setNome_int(richiesta_badge_selezionata.getNome_intestatario());
				richiestaDaProrogareItemBean.setCognome_int(richiesta_badge_selezionata.getCognome_intestatario());
				richiestaDaProrogareItemBean.setCf_int(richiesta_badge_selezionata.getCf_intestatario());
				richiestaDaProrogareItemBean.setNumero_badge(richiesta_badge_selezionata.getNumero_badge());
				richiestaDaProrogareItemBean
						.setData_scadenza(sdf.format(richiesta_badge_selezionata.getData_scadenza()));

				if (richiesta_badge_selezionata.getIs_internal()) {
					richiestaDaProrogareItemBean.setTipologia_utente("Interno");
				} else {
					richiestaDaProrogareItemBean.setTipologia_utente("Esterno");
					richiestaDaProrogareItemBean.setSocieta(richiesta_badge_selezionata.getSocieta());
					richiestaDaProrogareItemBean.setRef_societa(richiesta_badge_selezionata.getReferente_societa());
					richiestaDaProrogareItemBean.setSedi(richiesta_badge_selezionata.getArray_sedi_abilitate());
				}

				jsonarray_lista_riepilogo_proroga.put(richiestaDaProrogareItemBean.toJSONObject());

			} catch (Exception e) {
				_log.error("Errore nel recupero della richiesta con id = " + id_richiesta_selezionata_long + ": " + e);
			}
		}

		String jsonScadenzaSelezionata = actionRequest.getParameter("jsonScadenzaSelezionata");
		String dataInizioSelezionata = actionRequest.getParameter("dataInizioSelezionata");
		String dataFineSelezionata = actionRequest.getParameter("dataFineSelezionata");

		actionRequest.setAttribute("jsonListaRiepilogoProroga", jsonarray_lista_riepilogo_proroga.toString());
		actionRequest.setAttribute("nuovaDataScadenza", nuovaDataScadenza);
		actionRequest.setAttribute("jsonScadenzaSelezionata", jsonScadenzaSelezionata);
		actionRequest.setAttribute("dataInizioSelezionata", dataInizioSelezionata);
		actionRequest.setAttribute("dataFineSelezionata", dataFineSelezionata);
		actionRequest.setAttribute("listIdRichiesteSelezionate", listIdRichiesteSelezionate);
		actionRequest.setAttribute("navigation", "vaiARiepilogoProroga");

	}

	/*
	 * metodo per tornare alla landing page di proroga, per modificare la lista
	 * di badge
	 */
	@ProcessAction(name = "modificaRichiesteBadgeProroga")
	public void modificaRichiesteBadgeProroga(ActionRequest actionRequest, ActionResponse actionResponse) {

		String nuovaDataScadenza = actionRequest.getParameter("nuovaDataScadenza");
		String jsonScadenzaSelezionata = actionRequest.getParameter("jsonScadenzaSelezionata");
		String dataInizioSelezionata = actionRequest.getParameter("dataInizioSelezionata");
		String dataFineSelezionata = actionRequest.getParameter("dataFineSelezionata");
		String listIdRichiesteSelezionate = actionRequest.getParameter("listIdRichiesteSelezionate");
		listIdRichiesteSelezionate = listIdRichiesteSelezionate.substring(1, listIdRichiesteSelezionate.length() - 1);

		actionRequest.setAttribute("nuovaDataScadenzaModal", nuovaDataScadenza);
		actionRequest.setAttribute("jsonScadenzaSelezionata", jsonScadenzaSelezionata);
		actionRequest.setAttribute("dataInizioSelezionata", dataInizioSelezionata);
		actionRequest.setAttribute("dataFineSelezionata", dataFineSelezionata);
		actionRequest.setAttribute("listIdRichiesteSelezionate",
				new ArrayList<String>(Arrays.asList(listIdRichiesteSelezionate.split(","))));
		actionRequest.setAttribute("navigation", "vaiAProrogaBadge");

	}

	/*
	 * metodo per il salvataggio a db delle richieste di proroga (massiva)
	 */
	@ProcessAction(name = "prorogaRichiesteBadge")
	public void prorogaRichiesteBadge(ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		// recupero array degli id delle richieste badge da prorogare
		String[] arrayIdBadgeDaProrogare = actionRequest.getParameterValues("idBadgeDaProrogare");

		// recupero parametro relativo alla nuova data di scadenza
		String inputNuovaDataScadenzaProroga = actionRequest.getParameter("nuovaDataScadenzaProroga");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date scadenza_new_date = null;

		try {
			scadenza_new_date = sdf.parse(inputNuovaDataScadenzaProroga);
		} catch (Exception e) {
			_log.error("Error parsing date = " + inputNuovaDataScadenzaProroga + ", error: " + e);
		}

		// recupero ruoli utente
		boolean dirigente = false;
		boolean delegatoBadge = false;

		List<String> roles_list = getRolesFromUser(themeDisplay);

		if (roles_list.contains(_delegatoBadge)) {
			delegatoBadge = true;
		}
		if (roles_list.contains(_roledirigente)) {
			dirigente = true;
		}

		long id_stato_by_role = 0L;

		List<RichiestaBadge> listBadgeDaProrogare = new ArrayList<RichiestaBadge>(0);

		// logica per il tracciamento in db delle nuove richieste badge di tipo
		// proroga
		try {
			for (int i = 0; i < arrayIdBadgeDaProrogare.length; i++) {

				// setta l'id stato iniziale a 7
				id_stato_by_role = 7;
				
				// recupero dell'id_pk i-esimo
				long id_pk_richiesta_proroga_badge = Long.parseLong(arrayIdBadgeDaProrogare[i]);

				try {

					// recupero della precedente richiesta avente id_pk i-esimo
					// e aggiunta alla lista dei badge da prorogare
					RichiestaBadge richiesta_proroga_badge_old = RichiestaBadgeLocalServiceUtil
							.getRichiestaBadge(id_pk_richiesta_proroga_badge);
					listBadgeDaProrogare.add(richiesta_proroga_badge_old);

					// metodo per la produzione di una nuova richiesta, uguale
					// alla precedente (ad eccezione dal campo di validità)

					long richiesta_proroga_badge_new = RichiestaBadgeLocalServiceUtil.aggiornaRichiestaBadge(
							id_pk_richiesta_proroga_badge, richiesta_proroga_badge_old.getScreename_richiedente(),
							richiesta_proroga_badge_old.getId_ufficio(),
							richiesta_proroga_badge_old.getJson_richiedente(),
							richiesta_proroga_badge_old.getIs_internal(),
							richiesta_proroga_badge_old.getNome_intestatario(),
							richiesta_proroga_badge_old.getCognome_intestatario(),
							richiesta_proroga_badge_old.getCf_intestatario(),
							richiesta_proroga_badge_old.getLuogonascita_intestatario(),
							richiesta_proroga_badge_old.getDatanascita_intestatario(), 4,
							richiesta_proroga_badge_old.getNumero_badge(), richiesta_proroga_badge_old.getUuid_foto(),
							richiesta_proroga_badge_old.getUuid_modulosostituzione(),
							richiesta_proroga_badge_old.getSocieta(),
							richiesta_proroga_badge_old.getReferente_societa(),
							richiesta_proroga_badge_old.getProgetto(),
							richiesta_proroga_badge_old.getJson_richiesta_external(),
							richiesta_proroga_badge_old.getArray_sedi_abilitate(),
							richiesta_proroga_badge_old.getMotivazione(), scadenza_new_date,
							richiesta_proroga_badge_old.getUuid_modulopdf(), new Date(), new Date(), id_stato_by_role,
							user.getScreenName(), richiesta_proroga_badge_old.getNote(), true,
							richiesta_proroga_badge_old.getId_sedesiap());

					if (richiesta_proroga_badge_new == 0) {
						_log.error("New RichiestaBadge NOT added in DB");
					} else {
						// se sei dirigente o delegato, passa la richiesta in id stato 2
						if (dirigente || delegatoBadge) {
							id_stato_by_role = 2;
							long richiesta_proroga_badge_new2 = RichiestaBadgeLocalServiceUtil.aggiornaRichiestaBadge(
									richiesta_proroga_badge_new, richiesta_proroga_badge_old.getScreename_richiedente(),
									richiesta_proroga_badge_old.getId_ufficio(),
									richiesta_proroga_badge_old.getJson_richiedente(),
									richiesta_proroga_badge_old.getIs_internal(),
									richiesta_proroga_badge_old.getNome_intestatario(),
									richiesta_proroga_badge_old.getCognome_intestatario(),
									richiesta_proroga_badge_old.getCf_intestatario(),
									richiesta_proroga_badge_old.getLuogonascita_intestatario(),
									richiesta_proroga_badge_old.getDatanascita_intestatario(), 4,
									richiesta_proroga_badge_old.getNumero_badge(),
									richiesta_proroga_badge_old.getUuid_foto(),
									richiesta_proroga_badge_old.getUuid_modulosostituzione(),
									richiesta_proroga_badge_old.getSocieta(),
									richiesta_proroga_badge_old.getReferente_societa(),
									richiesta_proroga_badge_old.getProgetto(),
									richiesta_proroga_badge_old.getJson_richiesta_external(),
									richiesta_proroga_badge_old.getArray_sedi_abilitate(),
									richiesta_proroga_badge_old.getMotivazione(), scadenza_new_date,
									richiesta_proroga_badge_old.getUuid_modulopdf(), new Date(), new Date(),
									id_stato_by_role, user.getScreenName(), richiesta_proroga_badge_old.getNote(), true,
									richiesta_proroga_badge_old.getId_sedesiap());

							if (richiesta_proroga_badge_new2 == 0) {
								_log.error("New RichiestaBadge NOT added in DB");
							}

						}
					}

				} catch (Exception e) {
					_log.error("Error: " + e);
				}
			}

			// invio unica email riepilogativa
			String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
			String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
			ProrogaMailUtil prorogaMailUtil = new ProrogaMailUtil();

			// recupero e invio email al referente
			String emailReferente = actionRequest.getPreferences().getValue("emailReferente",
					_configuration.emailReferente());

			if (emailReferente != null && !("").equalsIgnoreCase(emailReferente)) {
				prorogaMailUtil.prepareAndSendProrogaEmail(inputNuovaDataScadenzaProroga, listBadgeDaProrogare,
						emailReferente, sdf, sender, smtpUser);
			}

			// invio email al richiedente
			prorogaMailUtil.prepareAndSendProrogaEmail(inputNuovaDataScadenzaProroga, listBadgeDaProrogare,
					user.getEmailAddress(), sdf, sender, smtpUser);

			// recupero e invio email al dirigente (se l'utente corrente non è
			// già dirigente)
			String emailDirigente = "";
			String directorId = "";
			if (user.getExpandoBridge() != null
					&& (user.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
				directorId = (String) user.getExpandoBridge().getAttribute(_customFieldUserDirector);
				if (directorId != null && !("0").equalsIgnoreCase(directorId) && !("").equalsIgnoreCase(directorId)) {
					User cuser = getUsertByCustomField(themeDisplay.getCompanyId(), _customFieldUserPersonal,
							directorId);
					if (cuser != null) {
						emailDirigente = cuser.getEmailAddress();
					}
				}
			} else {
				_log.warn(_customFieldUserDirector + " not defined for this user");
			}

			if (!dirigente) {
				if (emailDirigente != null && !"".equals(emailDirigente)) {
					prorogaMailUtil.prepareAndSendProrogaEmail(inputNuovaDataScadenzaProroga, listBadgeDaProrogare,
							emailDirigente, sdf, sender, smtpUser);
				}
			}

			// recupero e invio email ai delegati
			if (!("").equalsIgnoreCase(directorId)) {
				Role delegatoBadgeRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "delegatoBadge");
				List<User> users_list_by_delegatoBadgeRole = new ArrayList<User>(0);

				if (delegatoBadgeRole != null) {
					users_list_by_delegatoBadgeRole = UserLocalServiceUtil.getRoleUsers(delegatoBadgeRole.getRoleId(),
							QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				}

				if (!users_list_by_delegatoBadgeRole.isEmpty()) {
					for (User delegatoUser : users_list_by_delegatoBadgeRole) {
						if (delegatoUser.getExpandoBridge() != null
								&& (delegatoUser.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)
								&& ((String) delegatoUser.getExpandoBridge().getAttribute(_customFieldUserDirector))
										.equalsIgnoreCase(directorId)) {
							prorogaMailUtil.prepareAndSendProrogaEmail(inputNuovaDataScadenzaProroga,
									listBadgeDaProrogare, delegatoUser.getEmailAddress(), sdf, sender, smtpUser);
						}
					}
				}
			}

		} catch (Exception e) {
			_log.error("Error: " + e);
		}

		PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		try {
			portletURL.setWindowState(LiferayWindowState.NORMAL);
			portletURL.setPortletMode(LiferayPortletMode.VIEW);
			portletURL.setParameter("navigation", "vaiAProrogaBadge");
			actionResponse.sendRedirect(portletURL.toString());
		} catch (Exception e) {
			_log.error("Error setting portletURL = " + portletURL + ", error: " + e);
		}

	}

	// metodo per funzionalità "approva/rifiuta"
	@ProcessAction(name = "approvaRifiutaRichiesta")
	public void approvaRifiutaRichiesta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ParseException, PortalException {

		// recupero ruolo utente loggato
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		User user = themeDisplay.getUser();

		// recupero ruoli utente
		boolean dirigente = false;
		boolean delegatoBadge = false;
		boolean gestoreInterno = false;
		boolean gestoreEsterno = false;

		List<String> roles_list = getRolesFromUser(themeDisplay);
		if (roles_list.contains(_abilitatoBadge)) {
			abilitatoBadge = true;
		}
		if (roles_list.contains(_delegatoBadge)) {
			delegatoBadge = true;
		}
		if (roles_list.contains(_roledirigente)) {
			dirigente = true;
		}
		if (roles_list.contains(_gestoreInterno)) {
			gestoreInterno = true;
		}
		if (roles_list.contains(_gestoreEsterno)) {
			gestoreEsterno = true;
		}

		boolean approva = false;
		boolean rifiuta = false;
		long idRichiestaPK = 0L;
		long idRichiestaPKNew = 0L;
		boolean is_last = true;
		User utenteRichiedente = null;

		String emailRichiedente;
		String emailDirigente = null;
		String subject = null;

		RichiestaBadge richiestaDett = null;

		if (actionRequest.getParameter("idRichiesta") != null
				&& !("").equalsIgnoreCase(actionRequest.getParameter("idRichiesta"))) {
			idRichiestaPK = Long.parseLong(actionRequest.getParameter("idRichiesta"));
		}

		if (actionRequest.getParameter("approvazione") != null
				&& ("approvazione").equalsIgnoreCase(actionRequest.getParameter("approvazione"))) {
			approva = true;
		} else {
			rifiuta = true;
		}
		try {
			if (idRichiestaPK != 0) {
				richiestaDett = RichiestaBadgeLocalServiceUtil.getRichiestaBadge(idRichiestaPK);
				long id_stato_nuovo = 0L;
				String numero_badge = richiestaDett.getNumero_badge();
				Date data_scadenza_badge = richiestaDett.getData_scadenza();
				String note_badge = richiestaDett.getNote();
				// RECUPERO LE NOTE
				if (actionRequest.getParameter("noteBadgeHidden") != null
						&& !("").equalsIgnoreCase(actionRequest.getParameter("noteBadgeHidden"))) {
					note_badge = actionRequest.getParameter("noteBadgeHidden");
				}

				if (richiestaDett != null) {
					utenteRichiedente = UserLocalServiceUtil.getUserByScreenName(companyId,
							richiestaDett.getScreename_richiedente());

					// APPROVAZIONE
					if (approva) {
						subject = actionRequest.getPreferences().getValue("subjectApprova",
								_configuration.subjectApprovazione());
						if (dirigente || delegatoBadge) {
							List<StatoRichiesta> lista_stati = StatoRichiestaLocalServiceUtil
									.findStatoByDescrizione("APPROVATA DAL DIRIGENTE");
							if (lista_stati != null && !lista_stati.isEmpty()) {
								id_stato_nuovo = lista_stati.get(0).getId_stato();
							}
						} else if (gestoreEsterno || gestoreInterno) {
							if (actionRequest.getParameter("numBadgeHidden") != null
									&& !("").equalsIgnoreCase(actionRequest.getParameter("numBadgeHidden")))
								numero_badge = actionRequest.getParameter("numBadgeHidden");
							if (actionRequest.getParameter("dataScadenzaHidden") != null
									&& !("").equalsIgnoreCase(actionRequest.getParameter("dataScadenzaHidden"))) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								data_scadenza_badge = sdf.parse(actionRequest.getParameter("dataScadenzaHidden"));
							}

							List<StatoRichiesta> lista_stati = StatoRichiestaLocalServiceUtil
									.findStatoByDescrizione("APPROVATA DAL GESTORE");
							if (lista_stati != null && !lista_stati.isEmpty()) {
								id_stato_nuovo = lista_stati.get(0).getId_stato();
							}
						}

						// RIFIUTO
					} else if (rifiuta) {
						subject = actionRequest.getPreferences().getValue("subjectRifiuta",
								_configuration.subjectRifiuta());
						if (dirigente || delegatoBadge) {
							List<StatoRichiesta> lista_stati = StatoRichiestaLocalServiceUtil
									.findStatoByDescrizione("RIFIUTATA DAL DIRIGENTE");
							if (lista_stati != null && !lista_stati.isEmpty()) {
								id_stato_nuovo = lista_stati.get(0).getId_stato();
							}
						}

						else if (gestoreEsterno || gestoreInterno) {
							if (actionRequest.getParameter("numBadgeHidden") != null
									&& !("").equalsIgnoreCase(actionRequest.getParameter("numBadgeHidden")))
								numero_badge = actionRequest.getParameter("numBadgeHidden");
							if (actionRequest.getParameter("dataScadenzaHidden") != null
									&& !("").equalsIgnoreCase(actionRequest.getParameter("dataScadenzaHidden"))) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								data_scadenza_badge = sdf.parse(actionRequest.getParameter("dataScadenzaHidden"));
							}

							List<StatoRichiesta> lista_stati = StatoRichiestaLocalServiceUtil
									.findStatoByDescrizione("RIFIUTATA DAL GESTORE");
							if (lista_stati != null && !lista_stati.isEmpty()) {
								id_stato_nuovo = lista_stati.get(0).getId_stato();
							}
						}

					}

					idRichiestaPKNew = RichiestaBadgeLocalServiceUtil.aggiornaRichiestaBadge(idRichiestaPK,
							richiestaDett.getScreename_richiedente(), richiestaDett.getId_ufficio(),
							richiestaDett.getJson_richiedente(), richiestaDett.getIs_internal(),
							richiestaDett.getNome_intestatario(), richiestaDett.getCognome_intestatario(),
							richiestaDett.getCf_intestatario(), richiestaDett.getLuogonascita_intestatario(),
							richiestaDett.getDatanascita_intestatario(), richiestaDett.getId_oggetto(), numero_badge,
							richiestaDett.getUuid_foto(), richiestaDett.getUuid_modulosostituzione(),
							richiestaDett.getSocieta(), richiestaDett.getReferente_societa(),
							richiestaDett.getProgetto(), richiestaDett.getJson_richiesta_external(),
							richiestaDett.getArray_sedi_abilitate(), richiestaDett.getMotivazione(),
							data_scadenza_badge, richiestaDett.getUuid_modulopdf(), richiestaDett.getData_richiesta(),
							new Date(), id_stato_nuovo, user.getScreenName(), note_badge, is_last,
							richiestaDett.getId_sedesiap());

				}
			}

			if (idRichiestaPKNew != 0) {

				// send mail
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String sender = actionRequest.getPreferences().getValue("sender", _configuration.sender());
				String mailbody = actionRequest.getPreferences().getValue("richiestaTmpl",
						_configuration.richiestaTmpl());
				ModuloRichiedente moduloRichiedente = getModuloRichiedenteByidRichiesta(idRichiestaPKNew, themeDisplay);
				String datirichiesta = getHtmlRichiesta(moduloRichiedente);
				subject = StringUtil.replace(subject, new String[] { "[$IDRICHIESTA$]" },
						new String[] { String.valueOf(richiestaDett.getId_richiesta()) });

				mailbody = StringUtil.replace(mailbody, new String[] { "[$OGGETTO$]", "[$DATI$]" },
						new String[] { subject, datirichiesta });
				EmailSender mail = new EmailSender();
				emailRichiedente = utenteRichiedente.getEmailAddress();

				if (gestoreEsterno || gestoreInterno) {
					if (utenteRichiedente != null && (utenteRichiedente.getExpandoBridge() != null)
							&& (utenteRichiedente.getExpandoBridge().getAttribute(_customFieldUserDirector) != null)) {
						String directorId = (String) utenteRichiedente.getExpandoBridge()
								.getAttribute(_customFieldUserDirector);
						User cuser = getUsertByCustomField(companyId, _customFieldUserPersonal, directorId);
						if (cuser != null) {
							emailDirigente = cuser.getEmailAddress();
						}
					} else
						_log.warn(_customFieldUserDirector + " not defined for the user");
				}

				// recupero gestori per la lista approvata/rifiutata
				long idRuoloGest = 0;
				List<String> listaEmailGestoriRichiesta = new ArrayList<>();

				if (richiestaDett.isIs_internal()) {
					idRuoloGest = RoleLocalServiceUtil.getRole(companyId, _gestoreInterno).getRoleId();

				} else {
					List<SediEsterne> sediRichiesta = SediEsterneLocalServiceUtil
							.getSediEsterneByIdSiap(richiestaDett.getId_sedesiap());
					if (sediRichiesta != null && !sediRichiesta.isEmpty()) {
						idRuoloGest = RoleLocalServiceUtil
								.getRole(companyId, _gestoreEsterno + sediRichiesta.get(0).getAcronimo_sede())
								.getRoleId();
					}
				}

				for (User gest : UserLocalServiceUtil.getRoleUsers(idRuoloGest, QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
					listaEmailGestoriRichiesta.add(gest.getEmailAddress());
				}

				// invio email alle liste in base al ruolo utente
				List<String> emailsDirApprova = new ArrayList<>();
				List<String> emailsGestore = new ArrayList<>();

				if (emailRichiedente != null && !("").equalsIgnoreCase(emailRichiedente)) {
					emailsDirApprova.add(emailRichiedente);
					emailsGestore.add(emailRichiedente);
				}
				if (emailDirigente != null && !("").equalsIgnoreCase(emailDirigente)) {
					emailsGestore.add(emailDirigente);
				}
				if (listaEmailGestoriRichiesta != null && !listaEmailGestoriRichiesta.isEmpty()) {
					emailsDirApprova.addAll(listaEmailGestoriRichiesta);
				}

				if (dirigente || delegatoBadge) {
					if (approva) {
						for (String mailAddress : emailsDirApprova) {
							mail.sendMailMessage(subject, mailbody, sender, smtpUser, mailAddress);

						}
					} else {
						mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRichiedente);
					}
				}
				if (gestoreEsterno || gestoreInterno) {
					for (String mailAddress : emailsGestore) {
						mail.sendMailMessage(subject, mailbody, sender, smtpUser, mailAddress);

					}
				}
			}

			// recupero json degli input della ricerca e settaggio nella url
			//String jsonInputRicerca = actionRequest.getParameter("jsonInputRicerca");
			
			
			
			if(gestoreInterno || gestoreEsterno){
				try {

					PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
							themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
							PortletRequest.ACTION_PHASE);
					urlRefresh.setParameter("javax.portlet.action", "vaiARicerca");
					actionResponse.sendRedirect(urlRefresh.toString());

				} catch (Exception e) {

					_log.error(e);

				}
			}else{
				
				try {

					PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
							themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
							PortletRequest.ACTION_PHASE);
					urlRefresh.setParameter("javax.portlet.action", "vaiAInserimento");
				
					actionResponse.sendRedirect(urlRefresh.toString());

				} catch (Exception e) {

					_log.error(e);

				}
				
				
				
			}
			
			
			

//			try {
//
//				PortletURL urlRefresh = PortletURLFactoryUtil.create(actionRequest,
//						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
//				urlRefresh.setParameter("javax.portlet.action", "vaiADettaglio");
//				urlRefresh.setParameter("richiestaId", Long.toString(idRichiestaPKNew));
//				urlRefresh.setParameter("jsonInputRicerca", jsonInputRicerca);
//				actionResponse.sendRedirect(urlRefresh.toString());
//
//			} catch (Exception e) {
//
//				_log.error(e);
//
//			}

		} catch (Exception e) {
			_log.error("Errore durante l'inserimento della segnalazione: " + e);
			SessionErrors.add(actionRequest, "Errore-durante-inserimento-segnalazione");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}

	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		
		
	
		
		
		
		if (ParamUtil.getString(resourceRequest, "btnAction") != null
				&& !"".equalsIgnoreCase(ParamUtil.getString(resourceRequest, "btnAction"))) {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User utente_dirigente = themeDisplay.getUser();
			String screename_dirigente = "";

			if (utente_dirigente != null) {
				screename_dirigente = utente_dirigente.getScreenName();
			}

			String idUtente = ParamUtil.getString(resourceRequest, "idutente");
			String btnAction = ParamUtil.getString(resourceRequest, "btnAction");
			User utente = null;

			try {
				utente = UserLocalServiceUtil.getUser(Long.parseLong(idUtente));
			} catch (Exception e) {
				_log.warn("error in retrieve user by id" + e);
			}

			if (utente != null) {

				long id_ufficio = 0;

				if (utente.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {
					id_ufficio = Long.parseLong((String) utente.getExpandoBridge().getAttribute(_customFieldUserOrg));
				}

				GestioneUtentiLocalServiceUtil.insertGestioneUtenti(new Date(), screename_dirigente,
						utente.getScreenName(), id_ufficio, btnAction, utente, themeDisplay.getCompanyId());
			}

			super.serveResource(resourceRequest, resourceResponse);

		} else	if (resourceRequest.getParameter("idDownload") != null
				&& !"".equalsIgnoreCase(resourceRequest.getParameter("idDownload"))) {
		
			
		
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long fileEntryId = Long.parseLong(ParamUtil.getString(resourceRequest, "idDownload"));
			
			DownloadDml downloadUtil = new DownloadDml();
			 
			downloadUtil.downloadDmlFile(fileEntryId, themeDisplay, resourceResponse);
			
		
			
			
		}	else {

			String json = resourceRequest.getParameter("jsonExcel");

			JSONArray arrayRicerca;

			List<RichiestaBadgeExcelBean> excelList = new ArrayList<RichiestaBadgeExcelBean>(0);

			RichiestaBadgeExcelBean beanExcel;

			try {

				arrayRicerca = JSONFactoryUtil.createJSONArray(json);

				int sizeArray = arrayRicerca.length();

				for (int i = 0; i < sizeArray; i++) {

					beanExcel = new RichiestaBadgeExcelBean();

					beanExcel.setId_richiesta_badge(arrayRicerca.getJSONObject(i).getString("id_richiesta_badge"));
					beanExcel.setNome_richiedente(arrayRicerca.getJSONObject(i).getString("nome_richiedente"));
					beanExcel.setCognome_richiedente(arrayRicerca.getJSONObject(i).getString("cognome_richiedente"));
					beanExcel.setDip_richiedente(arrayRicerca.getJSONObject(i).getString("dip_richiedente"));
					beanExcel.setDir_richiedente(arrayRicerca.getJSONObject(i).getString("dir_richiedente"));
					beanExcel.setUff_richiedente(arrayRicerca.getJSONObject(i).getString("uff_richiedente"));
					beanExcel.setTel_richiedente(arrayRicerca.getJSONObject(i).getString("tel_richiedente"));
					beanExcel.setEmail_richiedente(arrayRicerca.getJSONObject(i).getString("email_richiedente"));
					beanExcel.setData_richiesta(arrayRicerca.getJSONObject(i).getString("data_richiesta"));
					beanExcel.setTipo_richiesta(arrayRicerca.getJSONObject(i).getString("tipo_richiesta"));
					beanExcel.setStato_richiesta(arrayRicerca.getJSONObject(i).getString("stato_richiesta"));
					beanExcel.setDipartimento(arrayRicerca.getJSONObject(i).getString("dipartimento"));
					beanExcel.setDirezione(arrayRicerca.getJSONObject(i).getString("direzione"));
					beanExcel.setUfficio(arrayRicerca.getJSONObject(i).getString("ufficio"));
					beanExcel.setReferente_mef(arrayRicerca.getJSONObject(i).getString("referente_mef"));
					beanExcel.setTel_referente_mef(arrayRicerca.getJSONObject(i).getString("tel_referente_mef"));
					beanExcel.setEmail_referente_mef(arrayRicerca.getJSONObject(i).getString("email_referente_mef"));
					beanExcel.setNome_int(arrayRicerca.getJSONObject(i).getString("nome_int"));
					beanExcel.setCognome_int(arrayRicerca.getJSONObject(i).getString("cognome_int"));
					beanExcel.setCf_int(arrayRicerca.getJSONObject(i).getString("cf_int"));
					beanExcel.setLuogo_nascita_int(arrayRicerca.getJSONObject(i).getString("luogo_nascita_int"));
					beanExcel.setData_nascita_int(arrayRicerca.getJSONObject(i).getString("data_nascita_int"));
					beanExcel.setSocieta(arrayRicerca.getJSONObject(i).getString("societa"));
					beanExcel.setSede_legale_societa(arrayRicerca.getJSONObject(i).getString("sede_legale_societa"));
					beanExcel.setIndirizzo(arrayRicerca.getJSONObject(i).getString("indirizzo"));
					beanExcel.setRecapito_tel(arrayRicerca.getJSONObject(i).getString("recapito_tel"));
					beanExcel.setFax(arrayRicerca.getJSONObject(i).getString("fax"));
					beanExcel.setPec(arrayRicerca.getJSONObject(i).getString("pec"));
					beanExcel.setEmail(arrayRicerca.getJSONObject(i).getString("email"));
					beanExcel.setReferente_societa(arrayRicerca.getJSONObject(i).getString("referente_societa"));
					beanExcel.setEmail_referente_societa(
							arrayRicerca.getJSONObject(i).getString("email_referente_societa"));
					beanExcel.setTel_ufficio(arrayRicerca.getJSONObject(i).getString("tel_ufficio"));
					beanExcel.setCell(arrayRicerca.getJSONObject(i).getString("cell"));
					beanExcel.setContratto(arrayRicerca.getJSONObject(i).getString("contratto"));
					beanExcel.setProgetto(arrayRicerca.getJSONObject(i).getString("progetto"));
					beanExcel.setPiano(arrayRicerca.getJSONObject(i).getString("piano"));
					beanExcel.setPostazione(arrayRicerca.getJSONObject(i).getString("postazione"));
					beanExcel.setSedi(arrayRicerca.getJSONObject(i).getString("sedi"));
					beanExcel.setData_scadenza_badge(arrayRicerca.getJSONObject(i).getString("data_scadenza_badge"));
					beanExcel.setMotivazione(arrayRicerca.getJSONObject(i).getString("motivazione"));
					beanExcel.setOggetto(arrayRicerca.getJSONObject(i).getString("oggetto"));
					beanExcel.setNumero_badge(arrayRicerca.getJSONObject(i).getString("numero_badge"));
					beanExcel.setAllegati(arrayRicerca.getJSONObject(i).getString("allegati"));
					beanExcel.setNote(arrayRicerca.getJSONObject(i).getString("note"));
					// modifica 2021
					beanExcel.setSedePostazione(arrayRicerca.getJSONObject(i).getString("sedepos"));
					beanExcel.setPianoPostazione(arrayRicerca.getJSONObject(i).getString("pianopos"));
					beanExcel.setCorridoioPostazione(arrayRicerca.getJSONObject(i).getString("corridoiopos"));
					beanExcel.setFuoriPortaPostazione(arrayRicerca.getJSONObject(i).getString("fuoriporta"));
					

					excelList.add(beanExcel);

				}
			} catch (JSONException e) {
				_log.warn(e);
			}

			resourceResponse.setContentType("application/vnd.ms-excel");
			resourceResponse.setProperty("Content-Disposition",
					("attachment; ") + "filename=" + "Excel richieste badge" + ".xls");

			ExcelWriter.writeRichiesteExcel(excelList, resourceResponse);

		}
	}

	@ProcessAction(name = "vaiAInserimento")
	public void vaiAInserimento(ActionRequest request, ActionResponse response) {
		request.setAttribute("navigation", "inserimentobadge");
	}

	@ProcessAction(name = "vaiAGestioneUtenti")
	public void vaiAGestioneUtenti(ActionRequest request, ActionResponse response) {
		PortletSession pSession = request.getPortletSession();
		pSession.setAttribute("filtriRicerca", null, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("checkBoxArray", null, PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("typeList", null, PortletSession.APPLICATION_SCOPE);
		request.setAttribute("page", 1);
		request.setAttribute("numPage", 1);
		request.setAttribute("navigation", "gestioneutenti");
	
	}

	@ProcessAction(name = "cercaUtentiDaAbilitare")
	public void cercaUtentiDaAbilitare(ActionRequest request, ActionResponse response) throws Exception {
		PortletSession session = request.getPortletSession();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> filtriRicerca = new ArrayList<String>();
		DynamicQuery queryUtentiDaAbilitare = DynamicQueryFactoryUtil.forClass(User.class);
		Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
		List<String> id_uffici_utenti_list = new ArrayList<String>(0);
		List<ExpandoValue> expando_value_list = new ArrayList<ExpandoValue>(0);
		boolean hasCriteria = false;
		
		
		session.setAttribute("typeList", "daAbilitare", PortletSession.APPLICATION_SCOPE);
		// controllo se i dati provenienti dalla form sono stati valorizzati; se
		// si, valorizzo le variabili e aggiungo il corrispondente criterio alla
		// query sugli utenti
		if (request.getParameter("cognomeUtenteDaAbilitare") != null
				&& !"".equals(request.getParameter("cognomeUtenteDaAbilitare"))) {
			String cognomeUtente = request.getParameter("cognomeUtenteDaAbilitare");
			queryUtentiDaAbilitare.add(RestrictionsFactoryUtil.ilike("lastName", cognomeUtente));
			hasCriteria = true;
			filtriRicerca.add(cognomeUtente);
		}
		if (request.getParameter("nomeUtenteDaAbilitare") != null
				&& !"".equals(request.getParameter("nomeUtenteDaAbilitare"))) {
			String nomeUtente = request.getParameter("nomeUtenteDaAbilitare");
			queryUtentiDaAbilitare.add(RestrictionsFactoryUtil.ilike("firstName", nomeUtente));
			hasCriteria = true;
			filtriRicerca.add(nomeUtente);
		}
		if (request.getParameter("codFiscaleUtenteDaAbilitare") != null
				&& !"".equals(request.getParameter("codFiscaleUtenteDaAbilitare"))) {
			String codFiscaleUtente = request.getParameter("codFiscaleUtenteDaAbilitare");
			queryUtentiDaAbilitare.add(RestrictionsFactoryUtil.ilike("screenName", codFiscaleUtente));
			hasCriteria = true;
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
		
		
		if(expando_value_list!=null && !expando_value_list.isEmpty()){
		for (ExpandoValue ev : expando_value_list) {
			Property propertyUserId = PropertyFactoryUtil.forName("userId");
			disjunctionKey.add(propertyUserId.eq(ev.getClassPK()));
			
		}
		queryUtentiDaAbilitare.add(disjunctionKey);
		hasCriteria = true;
		}
		// faccio la query sugli utenti
		List<User> res_utenti = new ArrayList<User>();
		if(hasCriteria){
			res_utenti = UserLocalServiceUtil.dynamicQuery(queryUtentiDaAbilitare);
		}
		// ricavo il set relativo agli utenti da abilitare
		Set<User> res_utenti_da_abilitare = new HashSet<User>(0);
		for (User user : res_utenti) {

			List<String> nomi_ruoli = new ArrayList<String>(0);
			for (Role userRole : user.getRoles()) {

				nomi_ruoli.add(userRole.getName());
			}
			if (!nomi_ruoli.contains("Dirigente") && !nomi_ruoli.contains("abilitatoBadge")
					&& !nomi_ruoli.contains("delegatoBadge")) {

				res_utenti_da_abilitare.add(user);
			}
		}
		
		
		String itemsPerPageUtenti = request.getPreferences().getValue("itemsPerPageUtenti",
				Integer.toString(_configuration.itemsPerPageUtenti()));
		int totalsize = res_utenti_da_abilitare.size();
		//PAGINAZIONE -> genero la lista delle pagine e la salvo in sessione
		List<List<User>> paginazione_utenti_da_abilitare = listPaginationUtenti(itemsPerPageUtenti, res_utenti_da_abilitare);
		int pagesize=1;
		if(paginazione_utenti_da_abilitare!=null && !paginazione_utenti_da_abilitare.isEmpty()){
			pagesize = paginazione_utenti_da_abilitare.size();
		}
		session.setAttribute("paginazioneUtentiDaAbilitare", paginazione_utenti_da_abilitare, PortletSession.APPLICATION_SCOPE);
		
		//genero il json dalla lista delle pagine e prendo laprima pagina con indice 0
		JSONArray jsonArrayUtentiDaAbilitare = createJSONListDaAbilitarePageFromIndexNumber(0, paginazione_utenti_da_abilitare);
		
		request.setAttribute("filtriRicercaRichieste", filtriRicerca);
		session.setAttribute("filtriRicerca", filtriRicerca, PortletSession.APPLICATION_SCOPE);
		request.setAttribute("jsonArrayUtentiDaAbilitare", jsonArrayUtentiDaAbilitare.toString());
		request.setAttribute("navigation", "gestioneutenti");
		request.setAttribute("page", 1);
		request.setAttribute("numPage", pagesize );
		request.setAttribute("totalSize", totalsize);
	}

	@ProcessAction(name = "cercaUtentiAbilitati")
	public void cercaUtentiAbilitati(ActionRequest request, ActionResponse response) throws Exception {
		PortletSession session = request.getPortletSession();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> filtriRicerca = new ArrayList<String>();
		DynamicQuery queryUtentiAbilitati = DynamicQueryFactoryUtil.forClass(User.class);
		Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
		List<String> id_uffici_utenti_list = new ArrayList<String>(0);
		List<ExpandoValue> expando_value_list = new ArrayList<ExpandoValue>(0);
		boolean hasCriteria = false;
		
		int pagesize=1;
		int numpage=1;
		session.setAttribute("typeList", "abilitati", PortletSession.APPLICATION_SCOPE);
		// controllo se i dati provenienti dalla form sono stati valorizzati; se
		// si, valorizzo le variabili e aggiungo il corrispondente criterio alla
		// query sugli utenti
		if (request.getParameter("cognomeUtenteAbilitato") != null
				&& !"".equals(request.getParameter("cognomeUtenteAbilitato"))) {
			String cognomeUtente = request.getParameter("cognomeUtenteAbilitato");
			queryUtentiAbilitati.add(RestrictionsFactoryUtil.ilike("lastName", cognomeUtente));
			hasCriteria = true;
			filtriRicerca.add(cognomeUtente);
		}
		if (request.getParameter("nomeUtenteAbilitato") != null
				&& !"".equals(request.getParameter("nomeUtenteAbilitato"))) {
			String nomeUtente = request.getParameter("nomeUtenteAbilitato");
			queryUtentiAbilitati.add(RestrictionsFactoryUtil.ilike("firstName", nomeUtente));
			hasCriteria = true;
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
		if(expando_value_list!=null && !expando_value_list.isEmpty()){
		for (ExpandoValue ev : expando_value_list) {
			Property propertyUserId = PropertyFactoryUtil.forName("userId");
			disjunctionKey.add(propertyUserId.eq(ev.getClassPK()));
		}
		queryUtentiAbilitati.add(disjunctionKey);
		hasCriteria = true;
		}
		// faccio la query sugli utenti
		List<User> res_utenti = new ArrayList<>();
		if(hasCriteria){
			res_utenti = UserLocalServiceUtil.dynamicQuery(queryUtentiAbilitati);
		}
		
		// ricavo 2 set: utenti abilitati e utenti delegati
		Set<User> res_utenti_abilitati = new HashSet<User>(0);
		Set<User> res_utenti_abilitati_delegati = new HashSet<User>(0);
		Set<User> res_utenti_abilitati_non_delegati = new HashSet<User>(0);
		

		for (User user : res_utenti) {

			List<String> nomi_ruoli = new ArrayList<String>(0);
			for (Role userRole : user.getRoles()) {

				nomi_ruoli.add(userRole.getName());
			}
			if (nomi_ruoli.contains("abilitatoBadge")) {

				res_utenti_abilitati.add(user);
			}
			if (nomi_ruoli.contains("delegatoBadge")) {

				res_utenti_abilitati_delegati.add(user);
			}
			if (nomi_ruoli.contains("abilitatoBadge") && !nomi_ruoli.contains("delegatoBadge")) {

				res_utenti_abilitati_non_delegati.add(user);
			}
		}
			
		
		
		
		String itemsPerPageUtenti = request.getPreferences().getValue("itemsPerPageUtenti",
				Integer.toString(_configuration.itemsPerPageUtenti()));
		
		List<List<User>> paginazione_utenti_abilitati = listPaginationUtenti(itemsPerPageUtenti, res_utenti_abilitati);
		session.setAttribute("paginazioneUtentiAbilitati", paginazione_utenti_abilitati, PortletSession.APPLICATION_SCOPE);
		
		List<List<User>> paginazione_utenti_abilitati_delegati = listPaginationUtenti(itemsPerPageUtenti,res_utenti_abilitati_delegati);
		session.setAttribute("paginazioneUtentiAbilitatiDelegati", paginazione_utenti_abilitati_delegati, PortletSession.APPLICATION_SCOPE);
		
		List<List<User>> paginazione_utenti_abilitati_non_delegati = listPaginationUtenti(itemsPerPageUtenti,res_utenti_abilitati_non_delegati);
		session.setAttribute("paginazioneUtentiAbilitatiNonDelegati", paginazione_utenti_abilitati_non_delegati, PortletSession.APPLICATION_SCOPE);
		
		String checkBoxArrayParam = request.getParameter("checkBoxArray");
		
		JSONArray jsonArrayUtentiAbilitati = JSONFactoryUtil.createJSONArray();
		int totalSize = 0;
		if (checkBoxArrayParam != null) {
			
			session.setAttribute("checkBoxArray", checkBoxArrayParam, PortletSession.APPLICATION_SCOPE);
			
			
			//PAGINAZIONE --> richiamo metodo generale per la creazione della lista JSON in base alle liste paginate e ai valori della checkbox, in questo caso voglio la prima pagina come risultato della ricerca
			
			jsonArrayUtentiAbilitati = createJSONListAbilitatiPageFromIndexNumber(checkBoxArrayParam,filtriRicerca,0,paginazione_utenti_abilitati,paginazione_utenti_abilitati_delegati,paginazione_utenti_abilitati_non_delegati);
		
			
			if (("Yes,No".equals(checkBoxArrayParam)|| "".equals(checkBoxArrayParam))&& paginazione_utenti_abilitati!=null && !paginazione_utenti_abilitati.isEmpty()){
				pagesize = paginazione_utenti_abilitati.size();
				totalSize = res_utenti_abilitati.size();
			}
			if("Yes".equals(checkBoxArrayParam)&& paginazione_utenti_abilitati_delegati!=null && !paginazione_utenti_abilitati_delegati.isEmpty()){
				pagesize = paginazione_utenti_abilitati_delegati.size();
				totalSize = res_utenti_abilitati_delegati.size();
			}
            if("No".equals(checkBoxArrayParam)&& paginazione_utenti_abilitati_non_delegati!=null && !paginazione_utenti_abilitati_non_delegati.isEmpty()){
				pagesize = paginazione_utenti_abilitati_non_delegati.size();
				totalSize = res_utenti_abilitati_non_delegati.size();
            }
			
		}
		request.setAttribute("jsonArrayUtentiAbilitati", jsonArrayUtentiAbilitati.toString());
		request.setAttribute("navigation", "gestioneutenti");
		request.setAttribute("filtriRicercaRichieste", filtriRicerca);
		session.setAttribute("filtriRicerca", filtriRicerca, PortletSession.APPLICATION_SCOPE);
		request.setAttribute("page", numpage);
		request.setAttribute("numPage", pagesize);
		request.setAttribute("totalSize", totalSize);
	}

	
	private JSONArray createJSONListDaAbilitarePageFromIndexNumber(int index, List<List<User>> paginazione_utenti_da_abilitare){
		JSONArray jsonArrayUtentiDaAbilitare = JSONFactoryUtil.createJSONArray();
		try{
			
			if(paginazione_utenti_da_abilitare!= null && !paginazione_utenti_da_abilitare.isEmpty()){
			for (User user : paginazione_utenti_da_abilitare.get(index)) {
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
			}
			return jsonArrayUtentiDaAbilitare;
		}catch(Exception e){
			_log.info(e);
			return JSONFactoryUtil.createJSONArray();
		}
	}
	
	
	
	private JSONArray createJSONListAbilitatiPageFromIndexNumber(String checkBoxArray, List<String> filtriRicerca, int index, List<List<User>> paginazione_utenti_abilitati, List<List<User>> paginazione_utenti_abilitati_delegati, List<List<User>> paginazione_utenti_abilitati_non_delegati){
		
		JSONArray jsonArrayUtentiAbilitati = JSONFactoryUtil.createJSONArray();
		try{
		
		
		if ("Yes,No".equals(checkBoxArray)
				|| "".equals(checkBoxArray)) {
			if(paginazione_utenti_abilitati!=null && !paginazione_utenti_abilitati.isEmpty()){
			for (User user : paginazione_utenti_abilitati.get(index)) {
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
				if (nomi_ruoli.contains("delegatoBadge")) {

					risultatoRicercaUtente.setDelega(true);
				} else {

					risultatoRicercaUtente.setDelega(false);
				}
				jsonArrayUtentiAbilitati.put(risultatoRicercaUtente.toJSONObject());
			}
			}
			
			if ("Yes,No".equals(checkBoxArray)) {
				if(!filtriRicerca.contains("si")){
					filtriRicerca.add("si");
				}
				
				if(!filtriRicerca.contains("no")){
					filtriRicerca.add("no");
				}
			}
		}
		if ("Yes".equals(checkBoxArray)) {
			
		
			if(paginazione_utenti_abilitati_delegati!=null && !paginazione_utenti_abilitati_delegati.isEmpty()){
			for (User user : paginazione_utenti_abilitati_delegati.get(index)) {
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
			
		}
			if(!filtriRicerca.contains("si"))
			filtriRicerca.add("si");
		}
		if ("No".equals(checkBoxArray)) {

		if(paginazione_utenti_abilitati_non_delegati!=null && !paginazione_utenti_abilitati_non_delegati.isEmpty()){
			
			for (User user : paginazione_utenti_abilitati_non_delegati.get(index)) {
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
		}
			if(!filtriRicerca.contains("no"))
			filtriRicerca.add("no");
		}
	
		
		return jsonArrayUtentiAbilitati;
		}catch(Exception e){
			_log.info(e);
			return JSONFactoryUtil.createJSONArray();
		}
		
	}
	 
	private List<List<User>> listPaginationUtenti(String itemPerPage, Set<User> set) {
		
		
		if (set == null)
			return Collections.emptyList();
		
		List<User> lista = new ArrayList<User>(set);	
		Integer pageSize = Integer.parseInt(itemPerPage);
		if (pageSize == null || pageSize <= 0 || pageSize > lista.size() || pageSize == lista.size())
			pageSize = lista.size();
		int numpages = (int) Math.ceil((double) lista.size() / (double) pageSize);
		List<List<User>> pages = new ArrayList<List<User>>(numpages);
		for (int p = 0; p < numpages; p++) {
			pages.add(lista.subList(p * pageSize, Math.min((p + 1) * pageSize, lista.size())));
		}
		return pages;
	}	
	
	
	
	private List<List<RichiestaBadge>> listPaginationRichieste(String itemPerPage, List<RichiestaBadge> lista) {
		if (lista == null)
			return Collections.emptyList();
		Integer pageSize = Integer.parseInt(itemPerPage);
		if (pageSize == null || pageSize <= 0 || pageSize > lista.size() || pageSize == lista.size())
			pageSize = lista.size();
		int numpages = (int) Math.ceil((double) lista.size() / (double) pageSize);
		List<List<RichiestaBadge>> pages = new ArrayList<List<RichiestaBadge>>(numpages);
		for (int p = 0; p < numpages; p++) {
			pages.add(lista.subList(p * pageSize, Math.min((p + 1) * pageSize, lista.size())));
		}
		return pages;
	}

	
	
	
	@ProcessAction(name = "paginaUtenti")
	public void paginaUtenti(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

		try {
			PortletSession pSession = actionRequest.getPortletSession();
			// recupero da sessione i filtri della richiesta
			List<String>  filtriRicerca = (List<String>)  pSession.getAttribute("filtriRicerca", pSession.APPLICATION_SCOPE);
			String valuePage = actionRequest.getParameter("numpage");

			

			// recupero lista da parametro in jsp typelist
			String typeList =  (String) pSession.getAttribute("typeList",pSession.APPLICATION_SCOPE);
			
			String size = actionRequest.getParameter("size");
			
			
			

			if ("daAbilitare".equals(typeList)) {
				
				
				List<List<User>> pages = (List<List<User>>) pSession.getAttribute("paginazioneUtentiDaAbilitare",
						pSession.APPLICATION_SCOPE);
				
				if (valuePage != null || (pages != null && !pages.isEmpty())) {
					Integer numpage = Integer.parseInt(valuePage);
					
					JSONArray jsonList = createJSONListDaAbilitarePageFromIndexNumber(numpage - 1, pages);
					
					actionRequest.setAttribute("jsonArrayUtentiDaAbilitare", jsonList.toString());
					actionRequest.setAttribute("page", numpage);
					if(pages != null){
						actionRequest.setAttribute("numPage", pages.size());
					}
				
				}
			}
			if ("abilitati".equals(typeList)) {
				

				List<List<User>> 	pagesAbilitati = (List<List<User>>) pSession.getAttribute("paginazioneUtentiAbilitati",
						pSession.APPLICATION_SCOPE);
				
				List<List<User>> pagesAbilitatiDelegati = (List<List<User>>) pSession.getAttribute("paginazioneUtentiAbilitatiDelegati",
						pSession.APPLICATION_SCOPE);
				
				List<List<User>> pagesAbilitatiNonDelegati = (List<List<User>>) pSession.getAttribute("paginazioneUtentiAbilitatiNonDelegati",
						pSession.APPLICATION_SCOPE);
				
				
			
					Integer numpage = Integer.parseInt(valuePage);
					
				
					String checkBoxArrayParam =  (String) pSession.getAttribute("checkBoxArray",pSession.APPLICATION_SCOPE);
					
					int pagesize = 1;
					
					JSONArray jsonList = createJSONListAbilitatiPageFromIndexNumber(checkBoxArrayParam, filtriRicerca, numpage - 1, pagesAbilitati, pagesAbilitatiDelegati, pagesAbilitatiNonDelegati);
					
				
					if (("Yes,No".equals(checkBoxArrayParam)|| "".equals(checkBoxArrayParam)) && pagesAbilitati!=null && !pagesAbilitati.isEmpty() )
						pagesize = pagesAbilitati.size();
					if("Yes".equals(checkBoxArrayParam)&& pagesAbilitatiDelegati!=null && !pagesAbilitatiDelegati.isEmpty())
						pagesize = pagesAbilitatiDelegati.size();
                    if("No".equals(checkBoxArrayParam)&& pagesAbilitatiNonDelegati!=null && !pagesAbilitatiNonDelegati.isEmpty())
						pagesize = pagesAbilitatiNonDelegati.size();


					actionRequest.setAttribute("jsonArrayUtentiAbilitati", jsonList.toString());
					actionRequest.setAttribute("page", numpage);
					actionRequest.setAttribute("numPage", pagesize);
				

			

			}

			actionRequest.setAttribute("filtriRicercaRichieste", filtriRicerca);
			actionRequest.setAttribute("totalSize", Integer.parseInt(size));
			actionRequest.setAttribute("navigation", "gestioneutenti");

		} catch (Exception e) {
			_log.warn(e);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(renderUrl.toString());
		}

	}
	
	
	
	
	
	
	
	@ProcessAction(name = "paginaRichieste")
	public void paginaRichieste(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

		try {
			PortletSession pSession = actionRequest.getPortletSession();
			// recupero da sessione i filtri della richiesta
			String jsonInputRicerca = (String) pSession.getAttribute("jsonInputRicerca", pSession.APPLICATION_SCOPE);

			List<String> filtriRicercaRichieste = (List<String>) pSession.getAttribute("filtriRicercaRichieste",
					pSession.APPLICATION_SCOPE);

			// recupero il parametro da ricerca dalla sessione
			String daRicerca = (String) pSession.getAttribute("daRicerca", pSession.APPLICATION_SCOPE);

			String valuePage = actionRequest.getParameter("numpage");

			List<List<RichiestaBadge>> pages;

			// recupero lista da parametro in jsp typelist
			String typeList = actionRequest.getParameter("typeList");
			String size = actionRequest.getParameter("size");

			if ("listarich".equals(typeList)) {
				pages = (List<List<RichiestaBadge>>) pSession.getAttribute("risultato_ricerca",
						pSession.APPLICATION_SCOPE);
				if (valuePage != null || (pages != null && !pages.isEmpty())) {
					Integer numpage = Integer.parseInt(valuePage);
					actionRequest.setAttribute("risultato_ricerca", pages.get(numpage - 1));
					actionRequest.setAttribute("pageRichieste", numpage);
					actionRequest.setAttribute("numPageRichieste", pages.size());
				}
			}
			if ("listarichInt".equals(typeList) && daRicerca != null) {
				pages = (List<List<RichiestaBadge>>) pSession.getAttribute("listaIntRicerca",
						pSession.APPLICATION_SCOPE);

				if (valuePage != null || (pages != null && !pages.isEmpty())) {
					Integer numpageInterna = Integer.parseInt(valuePage);
					actionRequest.setAttribute("listaIntRicerca", pages.get(numpageInterna - 1));
					actionRequest.setAttribute("pageRichiesteInterne", numpageInterna);
					actionRequest.setAttribute("numPageRichiesteInterne", pages.size());
				}

				List<List<RichiestaBadge>> pagesEsterne = (List<List<RichiestaBadge>>) pSession
						.getAttribute("listaExtRicerca", pSession.APPLICATION_SCOPE);
				if (pagesEsterne != null && !pagesEsterne.isEmpty()) {
					actionRequest.setAttribute("listaExtRicerca", pagesEsterne.get(0));
					actionRequest.setAttribute("pageRichiesteEsterne", 1);
					actionRequest.setAttribute("numPageRichiesteEsterne", pagesEsterne.size());
				}
				actionRequest.setAttribute("fromPage", "interna");

			}

			if ("listarichInt".equals(typeList) && daRicerca == null) {
				pages = (List<List<RichiestaBadge>>) pSession.getAttribute("listaRichiesteGestoreIntTot",
						pSession.APPLICATION_SCOPE);
				if (valuePage != null || (pages != null && !pages.isEmpty())) {
					Integer numpageInterna = Integer.parseInt(valuePage);
					actionRequest.setAttribute("listaRichiesteGestoreInt", pages.get(numpageInterna - 1));
					actionRequest.setAttribute("pageRichiesteInterne", numpageInterna);
					actionRequest.setAttribute("numPageRichiesteInterne", pages.size());

				}
				actionRequest.setAttribute("fromPage", "interna");

			}

			if ("listarichExt".equals(typeList) && daRicerca != null) {
				pages = (List<List<RichiestaBadge>>) pSession.getAttribute("listaExtRicerca",
						pSession.APPLICATION_SCOPE);

				if (valuePage != null || (pages != null && !pages.isEmpty())) {
					Integer numpageEsterna = Integer.parseInt(valuePage);
					actionRequest.setAttribute("listaExtRicerca", pages.get(numpageEsterna - 1));
					actionRequest.setAttribute("pageRichiesteEsterne", numpageEsterna);
					actionRequest.setAttribute("numPageRichiesteEsterne", pages.size());

				}

				List<List<RichiestaBadge>> pagesInterne = (List<List<RichiestaBadge>>) pSession
						.getAttribute("listaIntRicerca", pSession.APPLICATION_SCOPE);
				if (pagesInterne != null && !pagesInterne.isEmpty()) {
					actionRequest.setAttribute("listaIntRicerca", pagesInterne.get(0));
					actionRequest.setAttribute("pageRichiesteInterne", 1);
					actionRequest.setAttribute("numPageRichiesteInterne", pagesInterne.size());
				}
				actionRequest.setAttribute("fromPage", "esterna");

			}

			if ("listarichExt".equals(typeList) && daRicerca == null) {
				pages = (List<List<RichiestaBadge>>) pSession.getAttribute("listaRichiesteGestoreExtTot",
						pSession.APPLICATION_SCOPE);

				if (valuePage != null || (pages != null && !pages.isEmpty())) {
					Integer numpageEsterna = Integer.parseInt(valuePage);
					actionRequest.setAttribute("listaRichiesteGestoreExt", pages.get(numpageEsterna - 1));
					actionRequest.setAttribute("pageRichiesteEsterne", numpageEsterna);
					actionRequest.setAttribute("numPageRichiesteEsterne", pages.size());
				}
				actionRequest.setAttribute("fromPage", "esterna");

			}
			actionRequest.setAttribute("jsonInputRicerca", jsonInputRicerca);
			actionRequest.setAttribute("filtriRicercaRichieste", filtriRicercaRichieste);
			actionRequest.setAttribute("totalSize", Integer.parseInt(size));
			actionRequest.setAttribute("daRicerca", daRicerca);
			actionRequest.setAttribute("navigation", "vaiARicerca");

		} catch (Exception e) {
			_log.warn(e);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(renderUrl.toString());
		}

	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRichiesteBadgeConfig.class, properties);
	}

	private volatile MefRichiesteBadgeConfig _configuration;

	public String getRichiestaTmpl(Map richiestaTmpl) {
		return (String) richiestaTmpl.get(_configuration.richiestaTmpl());
	}

	public String getSender(Map sender) {
		return (String) sender.get(_configuration.sender());
	}

	public String getSubjectNuova(Map subject) {
		return (String) subject.get(_configuration.subjectNuova());
	}

	public String getSubjectModifica(Map subject) {
		return (String) subject.get(_configuration.subjectModifica());
	}

	public String getSubjectRichiediModifica(Map subject) {
		return (String) subject.get(_configuration.subjectRichiediModifica());
	}

	public String getSubjectApprovazione(Map subject) {
		return (String) subject.get(_configuration.subjectApprovazione());
	}

	public String getSubjectRifiuta(Map subject) {
		return (String) subject.get(_configuration.subjectRifiuta());
	}

	public String getEmailReferente(Map emailReferente) {
		return (String) emailReferente.get(_configuration.emailReferente());
	}
}
