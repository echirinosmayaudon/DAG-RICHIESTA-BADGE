package com.intranet.mef.portlet;

import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.intranet.mef.util.EmailSender;
import com.intranet.mef.util.BeanCreator;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.ParseException;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mef.ricercariunione.beans.RiunioneRes;
import com.mef.ricercariunione.beans.StampaReport;
import com.mef.ricercariunione.stub.Partecipante;
import com.mef.ricercariunione.stub.RiunioneBean;
import com.mef.ricercariunione.stub.Segreteria;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.model.Luogo;
import com.intranet.mef.gestione.riunioni.model.Riunione;
import com.intranet.mef.gestione.riunioni.model.StatoRiunione;
import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;
import com.intranet.mef.gestione.riunioni.model.TipoRiunione;
import com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.StoricoStatoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.portlet.GestioneRiunioniFormConfig;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelLuogo;
import com.intranet.mef.logicaldel.gestione.riunioni.service.CancelAmmConvLocalServiceUtil;
import com.intranet.mef.logicaldel.gestione.riunioni.service.CancelLuogoLocalServiceUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet", "com.liferay.portlet.instanceable=true",
	"javax.portlet.display-name=gestione-riunioni-form Portlet", "javax.portlet.init-param.template-path=/",
	"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.resource-bundle=content.Language",
	"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class GestioneRiunioniFormmvcportletPortlet extends MVCPortlet {
	
	final Log _log = LogFactoryUtil.getLog(GestioneRiunioniFormmvcportletPortlet.class);
	/** modifica invitati */
	List<Segreteria> _altreSegreterie;
	private final String _jspPageDettaglioRiunione = "/dettaglioRiunione.jsp";
	private final String _jspPagePaginaCortesiaModifica = "/paginaCortesiaModifica.jsp";
	private final String _idRiunioneAttribute = "idRiunione";
	private final String _roleCoordinatore = "coordinatore";
	private final String _roleAdministrator = "Administrator";
	private final String _roleSegreteria = "segreteria";
	private final String _statoIndetta = "indetta";
	private final String _statoRinviata = "rinviata";
	private final String _statoAnnullata = "annullata";
	private final String _customFieldUserOrg = "idOrgChart";
	SimpleDateFormat _parserOnlyDate = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat _parserOnlyHour = new SimpleDateFormat("HH:mm");
	BeanCreator _creatorBean = new BeanCreator();
	
	private PortletRequest setRenderRole(PortletRequest request) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<Role> listaRuoli = user.getRoles();
		boolean isCoordinatore = false;
		boolean isAdministrator = false;
		for (Role ruolo : listaRuoli) {
			if (_roleCoordinatore.equalsIgnoreCase(ruolo.getName())) {
				isCoordinatore = true;
				request.setAttribute("roleCoordinatore", _roleCoordinatore);
			}
			if (_roleAdministrator.equalsIgnoreCase(ruolo.getName())) {
				isAdministrator = true;
				request.setAttribute("roleAdministrator", _roleAdministrator);
			}
			if (_roleSegreteria.equalsIgnoreCase(ruolo.getName())) {
				isAdministrator = true;
				request.setAttribute(_roleSegreteria, _roleSegreteria);
				String idSegreteria = "";
				if (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null
				&& !"".equals(((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg)))) {
					idSegreteria = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				} else {
					_log.warn(_customFieldUserOrg + " not defined for this user: " + user.getFullName());
				}
				try {
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(Long.parseLong(idSegreteria));
					if (orgChart != null && orgChart.getLevel() > 3) {
						idSegreteria = String.valueOf(orgChart.getLevel3());
					}
				} catch (Exception e) {
					_log.warn(e);
				}
				request.setAttribute("idSegreteria", idSegreteria);
			}
			if (isCoordinatore && isAdministrator)
				break;
		}
		return request;
	}
	
	@Override
	public void doView(RenderRequest renderRequestPar, RenderResponse renderResponse) throws IOException, PortletException {
		RenderRequest renderRequest = renderRequestPar;
		renderRequest.setAttribute(GestioneRiunioniFormConfig.class.getName(), _configuration);
		renderRequest = (RenderRequest) setRenderRole(renderRequest);
		String nav = renderRequest.getParameter("navigation");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (renderRequest.getParameter("mod") != null) {
			renderRequest.setAttribute("mod", renderRequest.getParameter("mod"));
		}
		if (renderRequest.getParameter(_idRiunioneAttribute) != null) {
			renderRequest.setAttribute(_idRiunioneAttribute, renderRequest.getParameter(_idRiunioneAttribute));
		}
		if (nav == null)
			nav = "";
		_creatorBean.createListaStatoInvitato();
		List<TipoRiunione> tipiRiunione = _creatorBean.createListaTipiRiunione();
		List<StatoRiunione> listStati = _creatorBean.createListaStatoRiunione();
		List<Segreteria> listIsp = _creatorBean.createListaSegreterie();
		switch (nav) {
		case "confirmRiunion":
			try {
				
				if ((renderRequest.getAttribute(_roleSegreteria) == null)
				|| !_roleSegreteria.equals(renderRequest.getAttribute(_roleSegreteria))
				|| !renderRequest.getParameter("idSegreteria").equalsIgnoreCase((String) renderRequest.getAttribute("idSegreteria"))) {
					
					renderRequest.setAttribute("utenteAbilitato", "false");
					_log.warn("you need to log in with account " + _roleSegreteria);
				} else {
					boolean flagEdit = true;
					boolean flagAccettato = false;
					String noteRiunione = "";
					List<Partecipante> partecipanti = _creatorBean
					.createListaPartecipanti(Long.parseLong(renderRequest.getParameter("idSegreteria")), themeDisplay);
					List<Partecipante> partecipantiInvitati = new ArrayList<>(0);
					Riunione riunione = RiunioneLocalServiceUtil
					.getRiunione(Long.valueOf(renderRequest.getParameter(_idRiunioneAttribute)));
					if (riunione.getId_stato_riunione() == 1) {//indetta
						InvitatiRiunionePK invitatoRiunione = new InvitatiRiunionePK();
						invitatoRiunione.setId_riunione(Long.valueOf(renderRequest.getParameter(_idRiunioneAttribute)));
						invitatoRiunione.setId_segreteria(Long.valueOf(renderRequest.getParameter("idSegreteria")));
						InvitatiRiunione invitatoRiunioneDB = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunione(invitatoRiunione);
						partecipantiInvitati = _creatorBean.getListaPartecipantiJSONforForm(invitatoRiunioneDB.getPartecipanti(),
						themeDisplay);
						partecipanti.removeAll(partecipantiInvitati);
						noteRiunione = invitatoRiunioneDB.getNote();
						if (invitatoRiunioneDB.getId_stato_invitato() == 1)
							flagAccettato = true;
						
						if (invitatoRiunioneDB.getId_stato_invitato() == 2)
							flagEdit = false;
						
					} else {
						flagEdit = false;
					}
					renderRequest.setAttribute("flagEdit", flagEdit);
					renderRequest.setAttribute("flagAccettato", flagAccettato);
					renderRequest.setAttribute("noteRiunione", noteRiunione);
					renderRequest.setAttribute("utenteAbilitato", "true");
					renderRequest.setAttribute("partecipanti", partecipanti);
					renderRequest.setAttribute("partecipantiInvitati", partecipantiInvitati);
				}
			} catch (Exception e) {
				_log.warn(e);
			}
			break;
		default:
			List<AmministrazioneConvocante> amministrazioni = _creatorBean.getAmministrazioniConvocantiList();
			renderRequest.setAttribute("Amministrazioni", amministrazioni);
			List<Luogo> luoghi = _creatorBean.getLuoghiList();
			renderRequest.setAttribute("Luoghi", luoghi);
			renderRequest.setAttribute("TipiRiunione", tipiRiunione);
			renderRequest.setAttribute("listaStati", listStati);
			renderRequest.setAttribute("listaIsp", listIsp);
			List<Riunione> all_riunioni = new ArrayList<Riunione>();
			Calendar calToday = Calendar.getInstance();
            calToday.setTime(new Date());
            calToday.set(Calendar.HOUR_OF_DAY, 0);
            calToday.set(Calendar.MINUTE, 0);
            calToday.set(Calendar.SECOND, 0);
            calToday.set(Calendar.MILLISECOND, 0);
            Date today = calToday.getTime();
			Calendar c = Calendar.getInstance();
			c.setTime(today);
			//c.add(Calendar.DATE, 7);
			//modifica a 14 gg
			c.add(Calendar.DATE, 14);
			Date week = c.getTime();
			Calendar c1 = Calendar.getInstance();
			c1.setTime(today);
			c1.add(Calendar.DATE, 3);
			if ((renderRequest.getAttribute("roleCoordinatore") == null || "".equals(renderRequest.getAttribute("roleCoordinatore")))
			&& (renderRequest.getAttribute("roleAdministrator") == null || "".equals(renderRequest.getAttribute("roleAdministrator")))
			&& (renderRequest.getAttribute(_roleSegreteria) != null)
			&& _roleSegreteria.equals(renderRequest.getAttribute(_roleSegreteria))) {
				String s = (String) renderRequest.getAttribute("idSegreteria");
				if (s != null && !"".equals(s)) {
					renderRequest.setAttribute("utenteAbilitato", "true");
					all_riunioni = RiunioneLocalServiceUtil.findByFilters(today, week, 0, "", Long.parseLong(s), "", 0, 0);
				} else {
					renderRequest.setAttribute("utenteAbilitato", "false");
				}
			} else
				all_riunioni = RiunioneLocalServiceUtil.findByFilters(today, week, 0, "", 0, "", 0, 0);
			
			List<RiunioneBean> prossime_riunioni = new ArrayList<>(0);
			if (all_riunioni != null) {
				prossime_riunioni = _creatorBean.getListRiunioneBean(all_riunioni, themeDisplay);
			}
			renderRequest.setAttribute("prossime_riunioni", prossime_riunioni);
			renderRequest.setAttribute("data_oggi", today);
			renderRequest.setAttribute("data_settimana", week);
			Riunione r;
			long idRiunione = 0;
			try {
				if (renderRequest.getAttribute(_idRiunioneAttribute) != null) {
					idRiunione = Long.parseLong((String) renderRequest.getAttribute(_idRiunioneAttribute));
					r = RiunioneLocalServiceUtil.getRiunione(idRiunione);
					List<StatoRiunione> allStatiRiunione = StatoRiunioneLocalServiceUtil.getStatoRiuniones(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
					long idStatoRiunioneCorrente = r.getId_stato_riunione();
					if (idStatoRiunioneCorrente == 1) {
						List<StatoRiunione> statiRiunioneDispDaIndetta = allStatiRiunione.subList(1, allStatiRiunione.size());
						renderRequest.setAttribute("StatiRiunione", statiRiunioneDispDaIndetta);
					} else if (idStatoRiunioneCorrente == 2) {
						List<StatoRiunione> statiRiunioneDispDaRinviata = new ArrayList<>();
						statiRiunioneDispDaRinviata.add(allStatiRiunione.get(0));
						statiRiunioneDispDaRinviata.add(allStatiRiunione.get(2));
						renderRequest.setAttribute("StatiRiunione", statiRiunioneDispDaRinviata);
					}
					List<StoricoStatoRiunione> allCambioStatoR = StoricoStatoRiunioneLocalServiceUtil
					.getStoricoStatoRiunioneByIdRiunione(idRiunione);
					List<StoricoStatoRiunione> modifiableListAllCambioStatoR = new ArrayList<StoricoStatoRiunione>(allCambioStatoR);
					Collections.sort(modifiableListAllCambioStatoR, new Comparator<StoricoStatoRiunione>() {
						
						@Override
						public int compare(StoricoStatoRiunione o1, StoricoStatoRiunione o2) {
							if (o2.getData().before(o1.getData()))
								return -1;
							return 1;
						}
					});
					if (!modifiableListAllCambioStatoR.isEmpty()) {
						List<StoricoStatoRiunione> passaggiDiStatoR1 = modifiableListAllCambioStatoR.subList(0,
						modifiableListAllCambioStatoR.size() - 1);
						renderRequest.setAttribute("PassaggiDiStatoR1", passaggiDiStatoR1);
					}
				}
			} catch (PortalException e) {
				_log.warn(e);
			}
			/** modifica invitati */
			List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(idRiunione);
			List<Segreteria> _invitati = _creatorBean.updateListaSegreterie(invitati);
			/** stub di segreterie */
			_altreSegreterie = new ArrayList<>();
			_altreSegreterie = _creatorBean.createListaSegreterie();
			for (Segreteria s : _invitati) {
				if (_altreSegreterie.contains(s))
					_altreSegreterie.remove(s);
				else
					_log.warn("la segreteria non esiste: " + s);
			}
			PortletSession session = renderRequest.getPortletSession();
			session.setAttribute("invitati", _invitati, PortletSession.APPLICATION_SCOPE);
			session.setAttribute("altreSegreterie", _altreSegreterie, PortletSession.APPLICATION_SCOPE);
			/** end modifica invitati */
		}
		renderRequest.setAttribute("companyId", themeDisplay.getCompanyId());
		super.doView(renderRequest, renderResponse);
	}
	
	/* begin stampa pdf */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			
			// String image = getClass().getResource("/img/logo.PNG").getPath();
			/*
			 * BufferedImage awtImage = ImageIO.read(new File(image));
			 * PDXObjectImage ximage = new PDPixelMap(doc, awtImage);
			 */
			// float scale = 1f; // reduce this value if the image is too large
			// contentStream.drawXObject(ximage, 350, 650,
			// ximage.getWidth()*scale, ximage.getHeight()*scale);
			RiunioneRes ricercaCampi = new RiunioneRes();
			ricercaCampi.setData_da(resourceRequest.getParameter("param_da"));
			ricercaCampi.setData_a(resourceRequest.getParameter("param_a"));
			ricercaCampi.setData(resourceRequest.getParameter("param_data"));
			ricercaCampi.setStato(resourceRequest.getParameter("param_stato"));
			ricercaCampi.setIspettorato(resourceRequest.getParameter("param_isp"));
			if (resourceRequest.getParameter("param_chiave") != null
			&& !"null".equalsIgnoreCase(resourceRequest.getParameter("param_chiave")))
				ricercaCampi.setParola_chiave(resourceRequest.getParameter("param_chiave"));
			else
				ricercaCampi.setParola_chiave("");
			if (resourceRequest.getParameter("param_protocollo") != null
			&& !"null".equalsIgnoreCase(resourceRequest.getParameter("param_protocollo")))
				ricercaCampi.setProtocollo(resourceRequest.getParameter("param_protocollo"));
			else
				ricercaCampi.setProtocollo("");
			ricercaCampi.setTipologia(resourceRequest.getParameter("param_tipo"));
			ricercaCampi.setAmministrazione(resourceRequest.getParameter("param_amministrazione"));
			List<Map<StampaReport, String>> content = new ArrayList<>();
			List<Map<StampaReport, String>> contentDay = new ArrayList<>();
			String idsRiunioni = resourceRequest.getParameter("param_Ids");
			if (idsRiunioni != null && !"".equals(idsRiunioni)) {
				String[] items = idsRiunioni.split(",");
				for (int i = 0; i < items.length; i++) {
					if (items[i] != null && Long.parseLong(items[i]) != 0) {
						Riunione r = RiunioneLocalServiceUtil.getRiunione(Long.parseLong(items[i]));
						Map<StampaReport, String> firstMap = new LinkedHashMap<StampaReport, String>();
						Map<StampaReport, String> firstMapDay = new LinkedHashMap<StampaReport, String>();
						AmministrazioneConvocante am = AmministrazioneConvocanteLocalServiceUtil
						.fetchAmministrazioneConvocante(r.getId_amministrazione_convocante());
						if (am != null) {
							firstMap.put(StampaReport.CONSTANT_CONVOCANTE, am.getNome_amministrazione());
							firstMapDay.put(StampaReport.CONSTANT_CONVOCANTE, am.getNome_amministrazione());
						} else {
							firstMap.put(StampaReport.CONSTANT_CONVOCANTE, "");
							firstMapDay.put(StampaReport.CONSTANT_CONVOCANTE, "");
						}
						Luogo l = LuogoLocalServiceUtil.fetchLuogo(r.getId_luogo());
						if (l != null) {
							firstMap.put(StampaReport.CONSTANT_LUOGO, l.getNome());
							firstMapDay.put(StampaReport.CONSTANT_LUOGO, l.getNome());
						} else {
							firstMap.put(StampaReport.CONSTANT_LUOGO, "");
							firstMapDay.put(StampaReport.CONSTANT_LUOGO, "");
						}
						if (r.getData_inizio() != null) {
							String da_data = _parserOnlyDate.format(r.getData_inizio());
							String shortTimeStr = _parserOnlyHour.format(r.getData_inizio());
							firstMap.put(StampaReport.CONSTANT_GIORNO_INIZIO, da_data);
							firstMap.put(StampaReport.CONSTANT_ORA_INIZIO, shortTimeStr);
							firstMapDay.put(StampaReport.CONSTANT_GIORNO_INIZIO, da_data);
							firstMapDay.put(StampaReport.CONSTANT_ORA_INIZIO, shortTimeStr);
						} else {
							firstMap.put(StampaReport.CONSTANT_GIORNO_INIZIO, " ");
							firstMap.put(StampaReport.CONSTANT_ORA_INIZIO, " ");
							firstMapDay.put(StampaReport.CONSTANT_GIORNO_INIZIO, " ");
							firstMapDay.put(StampaReport.CONSTANT_ORA_INIZIO, " ");
						}
						if (r.getData_creazione() != null) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
							String e_room = sdf.format(r.getData_creazione());
							firstMap.put(StampaReport.CONSTANT_E_ROOM, e_room);
							firstMapDay.put(StampaReport.CONSTANT_E_ROOM, e_room);
						} else {
							firstMap.put(StampaReport.CONSTANT_E_ROOM, " ");
							firstMapDay.put(StampaReport.CONSTANT_E_ROOM, " ");
						}
						if (r.getOggetto() != null) {
							firstMap.put(StampaReport.CONSTANT_OGGETTO, r.getOggetto());
							firstMapDay.put(StampaReport.CONSTANT_OGGETTO, r.getOggetto());
						} else {
							firstMap.put(StampaReport.CONSTANT_OGGETTO, " ");
							firstMapDay.put(StampaReport.CONSTANT_OGGETTO, " ");
						}
						// aggiunta campi mancanti
						TipoRiunione tipo = TipoRiunioneLocalServiceUtil.fetchTipoRiunione(r.getId_tipo());
						if (tipo != null && tipo.getDescrizione() != null) {
							firstMap.put(StampaReport.CONSTANT_TIPO, tipo.getDescrizione());
							firstMapDay.put(StampaReport.CONSTANT_TIPO, tipo.getDescrizione());
						} else {
							firstMap.put(StampaReport.CONSTANT_TIPO, " ");
							firstMapDay.put(StampaReport.CONSTANT_TIPO, " ");
						}
						if (r.getNote() != null) {
							String noteR = r.getNote();
							//noteR = noteR.replace("\n", " ").replace("\r", " ");
							firstMap.put(StampaReport.CONSTANT_NOTE, noteR);
							String s = noteR.substring(0, (noteR.length() < 600 ? noteR.length() : 600));
							firstMapDay.put(StampaReport.CONSTANT_NOTE, s + (noteR.length() < 600 ? "" : "..."));
						} else {
							firstMap.put(StampaReport.CONSTANT_NOTE, " ");
							firstMapDay.put(StampaReport.CONSTANT_NOTE, " ");
						}
						StatoRiunione statoRiunione = StatoRiunioneLocalServiceUtil.fetchStatoRiunione(r.getId_stato_riunione());
						if (statoRiunione != null && statoRiunione.getLabel() != null) {
							firstMap.put(StampaReport.CONSTANT_STATO_RIUNIONE, statoRiunione.getLabel());
							firstMapDay.put(StampaReport.CONSTANT_STATO_RIUNIONE, statoRiunione.getLabel());
						} else {
							firstMap.put(StampaReport.CONSTANT_STATO_RIUNIONE, " ");
							firstMapDay.put(StampaReport.CONSTANT_STATO_RIUNIONE, " ");
						}
						if (r.getData_inizio() != null && r.getData_fine() != null) {
							long duration = (r.getData_fine().getTime() - r.getData_inizio().getTime());
							int ore = (int) (duration / 60000) / 60;
							int minuti = ((int) (duration / 60000)) % 60;
							firstMap.put(StampaReport.CONSTANT_DURATA_PREVISTA, ore + ":" + minuti);
							firstMapDay.put(StampaReport.CONSTANT_DURATA_PREVISTA, ore + ":" + minuti);
						} else {
							firstMap.put(StampaReport.CONSTANT_DURATA_PREVISTA, " ");
							firstMapDay.put(StampaReport.CONSTANT_DURATA_PREVISTA, " ");
						}
						if (r.getProtocollo() != null) {
							firstMap.put(StampaReport.CONSTANT_PROTOCOLLO, r.getProtocollo());
							firstMapDay.put(StampaReport.CONSTANT_PROTOCOLLO, r.getProtocollo());
						} else {
							firstMap.put(StampaReport.CONSTANT_PROTOCOLLO, " ");
							firstMapDay.put(StampaReport.CONSTANT_PROTOCOLLO, " ");
						}
						firstMap.put(StampaReport.CONSTANT_ISPETTORATO, " ");
						firstMapDay.put(StampaReport.CONSTANT_ISPETTORATO, " ");
						firstMap.put(StampaReport.CONSTANT_ID, Long.toString(r.getId_riunione()));
						firstMapDay.put(StampaReport.CONSTANT_ID, Long.toString(r.getId_riunione()));
						content.add(firstMap);
						contentDay.add(firstMapDay);
					}
				}
				boolean forceDownload = true;
				String fileName = "StampaDettagliata";
				resourceResponse.setContentType("application/pdf");
				if (resourceRequest.getParameter("detail") == null || "false".equalsIgnoreCase(resourceRequest.getParameter("detail"))) {
					// stampa giornaliera
					if (ricercaCampi.getData() != null && !"".equals(ricercaCampi.getData())) {
						fileName = "StampaGiornaliera";
						resourceResponse.setProperty("Content-Disposition",
						(forceDownload ? "attachment; " : "") + "filename=" + fileName + ".pdf");
						StampaReport.drawPDFStampaGiornaliera(contentDay, resourceResponse, ricercaCampi.getData(), themeDisplay);
					} else {
						fileName = "Stampa";
						resourceResponse.setProperty("Content-Disposition",
						(forceDownload ? "attachment; " : "") + "filename=" + fileName + ".pdf");
						StampaReport.drawPDFStampa(contentDay, resourceResponse, ricercaCampi.getData_da(), ricercaCampi.getData_a(),
						themeDisplay);
					}
				} else {
					resourceResponse.setProperty("Content-Disposition",
					(forceDownload ? "attachment; " : "") + "filename=" + fileName + ".pdf");
					StampaReport.drawPDFStampaDettagliata(resourceResponse, resourceRequest, content, ricercaCampi);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void goToConfermaInvitoUrl(ActionRequest request, ActionResponse response)
	throws ParseException, PortalException, java.text.ParseException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
		PortletRequest.RENDER_PHASE);
		try {
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter(_idRiunioneAttribute, request.getParameter("idRiunione"));
			renderUrl.setParameter("navigation", "confirmRiunion");
			renderUrl.setParameter("idSegreteria", request.getParameter("idSegreteria"));
			response.sendRedirect(renderUrl.toString());
		} catch (Exception e) {
			_log.warn(e);
		}
	}
	
	public void ricercaReport(ActionRequest requestPar, ActionResponse response)
	throws ParseException, PortalException, java.text.ParseException {
		ActionRequest request = requestPar;
		RiunioneRes ricercaCampi = new RiunioneRes();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ricercaCampi.setParola_chiave("");
		ricercaCampi.setProtocollo("");
		List<Riunione> res = null;
		try {
			if ((request.getParameter("data") != null && !"".equals(request.getParameter("data")))
			|| ((request.getParameter("StartDate") != null) && !"".equals(request.getParameter("StartDate"))
			&& ((request.getParameter("Deadline") != null) && !"".equals(request.getParameter("Deadline"))))) {
				
				if (request.getParameter("data") != null && !"".equals(request.getParameter("data"))) {
					ricercaCampi.setData_da(request.getParameter("data"));
					ricercaCampi.setData_a(request.getParameter("data"));
					ricercaCampi.setData(request.getParameter("data"));
				} else {
					ricercaCampi.setData_a(request.getParameter("Deadline"));
					ricercaCampi.setData_da(request.getParameter("StartDate"));
				}
			} else {
				throw new GestioneRiunioniException("WARNING: we've to insert default date. We'll chage them after VALIDATION component!");
			}
			if (request.getParameter("parola_chiave") != null)
				ricercaCampi.setParola_chiave(request.getParameter("parola_chiave"));
			if (request.getParameter("protocollo") != null)
				ricercaCampi.setProtocollo(request.getParameter("protocollo"));
			
			ricercaCampi.setStato(request.getParameter("stato"));
			ricercaCampi.setAmministrazione(request.getParameter("amministrazione"));
			ricercaCampi.setTipologia(request.getParameter("tipologia"));
			ricercaCampi.setIspettorato(request.getParameter("ispettorato"));
			// converto le stringhe nei tipi di dato
			SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date da_data = sdfData.parse(ricercaCampi.getData_da());
			Date a_data = sdfData.parse(ricercaCampi.getData_a());
			String _data_a = sdf.format(a_data);
			String _data_da = sdf.format(da_data);
			Date data_da = sdf.parse(_data_da);
			Date data_a = sdf.parse(_data_a);
			Calendar c = Calendar.getInstance();
			c.setTime(data_a);
			c.add(Calendar.DATE, 1);
			data_a = c.getTime();
			long st = 0;
			long isp = 0;
			long type = 0;
			long am = 0;
			if (ricercaCampi.getIspettorato() != null && !"--".equals(ricercaCampi.getIspettorato())) {
				isp = Long.parseLong(ricercaCampi.getIspettorato());
			}
			if (ricercaCampi.getStato() != null && !"--".equals(ricercaCampi.getStato())) {
				st = Long.parseLong(ricercaCampi.getStato());
			}
			if (ricercaCampi.getAmministrazione() != null && !"--".equals(ricercaCampi.getAmministrazione())) {
				am = Long.parseLong(ricercaCampi.getAmministrazione());
			}
			if (ricercaCampi.getTipologia() != null && !"--".equals(ricercaCampi.getTipologia())) {
				type = Long.parseLong(ricercaCampi.getTipologia());
			}
			res = RiunioneLocalServiceUtil.findByFilters(data_da, data_a, st, ricercaCampi.getParola_chiave(), isp,
			ricercaCampi.getProtocollo(), am, type);
		} catch (Exception e) {
			//controlla effettivamente che non si tratti di una finta ricerca	
			if (request.getParameter("companyId") != null && !"".equals(request.getParameter("companyId"))) {
				_log.error(e);
				SessionErrors.add(request, "Errore-durante-ricerca-stampa-riunione");
			}
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} finally {
			response.setRenderParameter("jspPage", "/stampa.jsp");
			String stampatitolo = request.getPreferences().getValue("stampaRiunionetitle", _configuration.stampaRiunionetitle());
			String stampasottotitolo = request.getPreferences().getValue("stampaRiunionetxt", _configuration.stampaRiunionetxt());
			request = (ActionRequest) setRenderRole(request);
			request.setAttribute("titleStampaRiunione", stampatitolo);
			request.setAttribute("subTitleStampaRiunione", stampasottotitolo);
			request.setAttribute("param_periodo", request.getParameter("periodo"));
			request.setAttribute("param_da", request.getParameter("StartDate"));
			request.setAttribute("param_a", request.getParameter("Deadline"));
			request.setAttribute("param_stato", request.getParameter("stato"));
			request.setAttribute("param_isp", request.getParameter("ispettorato"));
			request.setAttribute("param_chiave", ricercaCampi.getParola_chiave());
			request.setAttribute("param_protocollo", ricercaCampi.getProtocollo());
			request.setAttribute("param_tipo", request.getParameter("tipologia"));
			request.setAttribute("param_amministrazione", request.getParameter("amministrazione"));
			request.setAttribute("param_data", request.getParameter("data"));
			request.setAttribute("risultatiReport", res);
			request.setAttribute("companyId", themeDisplay.getCompanyId());
		}
	}
	
	public void modificaInvitati(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long riunioneId = ParamUtil.getLong(actionRequest, _idRiunioneAttribute);
		if (ParamUtil.getString(actionRequest, "buttonValue") == null || "".equals(ParamUtil.getString(actionRequest, "buttonValue"))) {
			try {
				Riunione riunionecaricata = RiunioneLocalServiceUtil.getRiunione(riunioneId);
				String json = actionRequest.getParameter("saveInvitati");
				String note = actionRequest.getParameter("Note");
				String old_note = riunionecaricata.getNote();
				
				long amministrazioneId = riunionecaricata.getId_amministrazione_convocante();
				String amministrazConvocante = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(amministrazioneId)
				.getNome_amministrazione();
				String oggetto = riunionecaricata.getOggetto();
				Date data_ini = riunionecaricata.getData_inizio();
				long id_luogo = riunionecaricata.getId_luogo();
				String luogo = LuogoLocalServiceUtil.getLuogo(id_luogo).getNome();
				StringBuilder dati = new StringBuilder();
				
				if (json != null && !"".equals(json)) {
					
					JSONObject obj = JSONFactoryUtil.createJSONObject(json);
					JSONArray arrayInvitati = JSONFactoryUtil.createJSONArray(obj.getString("invitati"));
					JSONArray arrayInvitatiPrecedenti = JSONFactoryUtil.createJSONArray(obj.getString("invitatiPrecedenti"));
					BeanCreator segrCreator = new BeanCreator();
					List<Segreteria> invitatiPrecedenti = segrCreator.getListSegreteriaFromJsonArray(arrayInvitatiPrecedenti);
					List<Segreteria> setInvitati = segrCreator.getListSegreteriaFromJsonArray(arrayInvitati);
					Collections.sort(setInvitati, new Comparator<Segreteria>() {
						
						@Override
						public int compare(Segreteria arg0, Segreteria arg1) {
							return arg0.getIndex() - arg1.getIndex();
						}
					});
					Collections.sort(invitatiPrecedenti, new Comparator<Segreteria>() {
						
						@Override
						public int compare(Segreteria arg0, Segreteria arg1) {
							return arg0.getIndex() - arg1.getIndex();
						}
					});
					boolean flagOtherInvitati = false;
					if (invitatiPrecedenti != null && setInvitati != null && setInvitati.size() == invitatiPrecedenti.size()) {
						for (Segreteria seg : setInvitati) {
							if (!invitatiPrecedenti.contains(seg)) {
								flagOtherInvitati = true;
								break;
							}
						}
					} else
						flagOtherInvitati = true;
					
					StringBuilder ispettorati = getIspettoratiHtml(setInvitati);
					// prepare text for invitato email
					//StringBuilder  dati = getHtmlMailRiunione(riunionecaricata);
					// String subject="Invito alla riunione riunione con oggetto: "+
					// riunionecaricata.getOggetto();
					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter(_idRiunioneAttribute, Long.toString(riunioneId));
					renderUrl.setParameter("navigation", "confirmRiunion");
					// lista di tutti gli invitati attualmente
					String dataIn = _parserOnlyDate.format(data_ini);
					String oraIn = _parserOnlyHour.format(data_ini);
					String subject = "";
					String sender = "";
					String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
					String body = "";
					boolean flagNewInvitati = false;
					for (Segreteria nuovoInvitato : setInvitati) {
						InvitatiRiunione invitato = InvitatiRiunioneLocalServiceUtil
						.fetchInvitatiRiunione(new InvitatiRiunionePK(nuovoInvitato.getId_segreteria(), riunioneId));
						if (invitato == null) {
							flagNewInvitati = true;
							break;
						}
					}
					boolean flagInviaEmail = true;
					for (Segreteria nuovoInvitato : setInvitati) {
						
						// _invitati
						boolean flagNuovoInvitato = false;
						InvitatiRiunione invitato = InvitatiRiunioneLocalServiceUtil
						.fetchInvitatiRiunione(new InvitatiRiunionePK(nuovoInvitato.getId_segreteria(), riunioneId));
						// controlla se la segreteria presente alla riunione
						if (invitato == null) {
							invitato = InvitatiRiunioneLocalServiceUtil
							.createInvitatiRiunione(new InvitatiRiunionePK(nuovoInvitato.getId_segreteria(), riunioneId));
							flagNuovoInvitato = true;
						}
						StringBuilder jsonCapofila = new StringBuilder();
						jsonCapofila.append("{");
						if (nuovoInvitato.isCapofila()) {
							jsonCapofila.append("\"top\"");
							jsonCapofila.append(":");
							jsonCapofila.append("true");
							jsonCapofila.append(",");
						}
						jsonCapofila.append("\"pos\"");
						jsonCapofila.append(":");
						jsonCapofila.append(nuovoInvitato.getIndex());
						if (!flagNuovoInvitato) {
							jsonCapofila.append(",");
							jsonCapofila.append("\"list\"");
							jsonCapofila.append(":");
							jsonCapofila.append(segrCreator.getListaPartecipantiJSONforDB(invitato.getPartecipanti()));
						}
						jsonCapofila.append("}");
						invitato.setPartecipanti(jsonCapofila.toString());
						// invitato.setId_stato_invitato(nuovoInvitato.getStato_invitato());
						InvitatiRiunione invitator = InvitatiRiunioneLocalServiceUtil.updateInvitatiRiunione(invitato);
						// sendmail if update are done and invitato is a new entry
						renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
						EmailSender mail = new EmailSender();
						if (flagOtherInvitati) {
							if (invitator != null && flagNuovoInvitato) {
								// send email
								if (nuovoInvitato.getEmail() != null) {
									subject = actionRequest.getPreferences().getValue("subjectInvito", _configuration.subjectInvito());
									sender = actionRequest.getPreferences().getValue("senderInvito", _configuration.senderInvito());
									body = actionRequest.getPreferences().getValue("invitoriunioneTmpl",
									_configuration.invitoriunioneTmpl());
									body = StringUtil.replace(body,
									new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
										"[$LUOGORIUNIONE$]", "[$ISPETTORATI$]", "[$LINK$]" },
									new String[] { oggetto, amministrazConvocante, dataIn, oraIn, luogo, ispettorati.toString(),
										renderUrl.toString() });
								}
							} else {
								if (flagNewInvitati) {//aggiunta di nuovi invitati
									subject = actionRequest.getPreferences().getValue("subjectAggiuntaInvitati",
									_configuration.subjectAggiuntaInvitati());
									sender = actionRequest.getPreferences().getValue("senderAggiuntaInvitati",
									_configuration.senderAggiuntaInvitati());
									body = actionRequest.getPreferences().getValue("aggiuntainvitatiriunioneTmpl",
									_configuration.aggiuntainvitatiriunioneTmpl());
									body = StringUtil.replace(body,
									new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
										"[$LUOGORIUNIONE$]", "[$ISPETTORATI$]", "[$LINK$]" },
									new String[] { oggetto, amministrazConvocante, dataIn, oraIn, luogo, ispettorati.toString(),
										renderUrl.toString() });
								} else {
									flagInviaEmail = false;
								}
							}
						} else { //stessi invitati ordinati diversamente
							subject = actionRequest.getPreferences().getValue("subjectModificaInvitati",
							_configuration.subjectModificaInvitati());
							sender = actionRequest.getPreferences().getValue("senderModificaInvitati",
							_configuration.senderModificaInvitati());
							body = actionRequest.getPreferences().getValue("modificainvitatiriunioneTmpl",
							_configuration.modificainvitatiriunioneTmpl());
							body = StringUtil.replace(body,
							new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
								"[$LUOGORIUNIONE$]", "[$ISPETTORATI$]", "[$LINK$]" },
							new String[] { oggetto, amministrazConvocante, dataIn, oraIn, luogo, ispettorati.toString(),
								renderUrl.toString() });
						}
						if (flagInviaEmail) {
							mail.sendMailMessage(subject, body, sender, smtpUser, nuovoInvitato.getEmail());
						}
					}
					// cancella eventuali invitati
					if (invitatiPrecedenti != null && !invitatiPrecedenti.isEmpty()) {
						
						subject = actionRequest.getPreferences().getValue("subjectCancellaInvito", _configuration.subjectCancellaInvito());
						sender = actionRequest.getPreferences().getValue("senderCancellaInvito", _configuration.senderCancellaInvito());
						body = actionRequest.getPreferences().getValue("cancellainvitoriunioneTmpl",
						_configuration.cancellainvitoriunioneTmpl());
						body = StringUtil.replace(body, new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]",
							"[$ORARIUNIONE$]", "[$LUOGORIUNIONE$]" },
						new String[] { oggetto, amministrazConvocante, dataIn, oraIn, luogo });
						for (Segreteria cancellaInvitato : invitatiPrecedenti) {
							
							if (!setInvitati.contains(cancellaInvitato) && InvitatiRiunioneLocalServiceUtil
							.fetchInvitatiRiunione(new InvitatiRiunionePK(cancellaInvitato.getId_segreteria(), riunioneId)) != null) {
								InvitatiRiunioneLocalServiceUtil
								.deleteInvitatiRiunione(new InvitatiRiunionePK(cancellaInvitato.getId_segreteria(), riunioneId));
								EmailSender mail = new EmailSender();
								mail.sendMailMessage(subject, body, sender, smtpUser, cancellaInvitato.getEmail());
							}
						}
					}
				}
				if (!note.equals(riunionecaricata.getNote())) {
					riunionecaricata.setNote(note);
					RiunioneLocalServiceUtil.updateRiunione(riunionecaricata);

					dati.append(this.getHtmlMailModified("Note", old_note, note));
					String subject = actionRequest.getPreferences().getValue("subjectModifica", _configuration.subjectModifica());
					String sender = actionRequest.getPreferences().getValue("senderModifica", _configuration.senderModifica());
					String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
					// create link for confirm riunione
					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter(_idRiunioneAttribute, riunioneId.toString());
					renderUrl.setParameter("navigation", "confirmRiunion");
					// get email adresses from invitati riunione
					List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
					BeanCreator segrCreator = new BeanCreator();
					for (InvitatiRiunione invitatoSegreteria : invitati) {
						
						// send mail
						Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
						if (invitato.getEmail() != null) {
							
							String dataIn = _parserOnlyDate.format(data_ini);
							String oraIn = _parserOnlyHour.format(data_ini);
							renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
							String body = actionRequest.getPreferences().getValue("modificariunioneTmpl",
							_configuration.modificariunioneTmpl());
							body = StringUtil.replace(body,
							new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
								"[$LUOGORIUNIONE$]", "[$DATI$]", "[$LINK$]" },
							new String[] { oggetto, amministrazConvocante, dataIn, oraIn, luogo, dati.toString(), renderUrl.toString() });
							EmailSender mail = new EmailSender();
							mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
						}
					}
				
				}
				if (actionRequest.getParameter("changeTab") != null && !"".equals(actionRequest.getParameter("changeTab"))) {
					actionRequest.setAttribute(_idRiunioneAttribute, String.valueOf(riunioneId));
					actionRequest.setAttribute("mod", "modifica");
					actionRequest.setAttribute("changeTab", actionRequest.getParameter("changeTab"));
				} else
					goToJspPage(actionRequest, actionResponse, _jspPagePaginaCortesiaModifica, riunioneId);
				
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "Errore-durante-modifica-riunione");
				SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				if (riunioneId != null) {
					actionRequest.setAttribute(_idRiunioneAttribute, String.valueOf(riunioneId));
					actionRequest.setAttribute("mod", "modifica");
				}
				_log.warn(e);
			}
		} else {
			goToJspPage(actionRequest, actionResponse, _jspPageDettaglioRiunione, riunioneId);
		}
	}
	
	/* end stampa pdf */
	private void goToJspPage(ActionRequest requestPar, ActionResponse response, String jspPage, long idRiunione) {
		ActionRequest request = requestPar;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
		PortletRequest.ACTION_PHASE);
		renderUrl.setParameter("javax.portlet.action", "actionRefreshJspPage");
		renderUrl.setParameter(_idRiunioneAttribute, String.valueOf(idRiunione));
		renderUrl.setParameter("jspPageRedirect", jspPage);
		try {
			response.sendRedirect(renderUrl.toString());
		} catch (IOException e) {
			_log.warn(e);
		}
	}
	
	private StringBuilder getHtmlMailModified(String title, String oldText, String newText) {
		StringBuilder dati = new StringBuilder();
		dati.append("<p><b>");
		dati.append(title);
		dati.append("</b></p>");
		dati.append("<p>");
		dati.append("<font color=red><s>");
		String[] arraySplitTextOld=oldText.split("\r\n");
		
		for(int j=0; j<arraySplitTextOld.length; j++){
			dati.append(arraySplitTextOld[j]);
			dati.append("<br>");
		} 
		
		dati.append("</p><p></s></font>");
		
		String[] arraySplitTextNew=newText.split("\r\n");
		
		for(int j=0; j<arraySplitTextNew.length; j++){
			dati.append(arraySplitTextNew[j]);
			dati.append("<br>");
		} 
		dati.append("</p>");
		dati.append("</br>");
		return dati;
	}
	
	private StringBuilder getIspettoratiHtml(List<Segreteria> setInvitati) {
		StringBuilder ispettorati = new StringBuilder();
		int count = 0;
		for (Segreteria invitatoSegreteria : setInvitati) {
			if (count == 0) {
				ispettorati.append("<strong>");
				ispettorati.append(invitatoSegreteria.getSegreteria_nome());
				ispettorati.append("</strong>");
			} else
				ispettorati.append(invitatoSegreteria.getSegreteria_nome());
			if (count < setInvitati.size() - 1) {
				ispettorati.append(", ");
			}
			count++;
		}
		return ispettorati;
	}
	
	@ProcessAction(name = "actionRefreshJspPage")
	public void actionRefreshJspPage(ActionRequest actionRequest, ActionResponse actionResponse) {
		ActionRequest request = actionRequest;
		if (request.getParameter(_idRiunioneAttribute) != null) {
			request.setAttribute(_idRiunioneAttribute, Long.parseLong(request.getParameter(_idRiunioneAttribute)));
		}
		if (request.getParameter("jspPageRedirect") != null) {
			actionResponse.setRenderParameter("jspPage", request.getParameter("jspPageRedirect"));
		}
		request = (ActionRequest) setRenderRole(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		request.setAttribute("companyId", themeDisplay.getCompanyId());
		// nascondi eventuale messaggio
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	/** metodi per invitati riunione */
	@ProcessAction(name = "modificaDatiRiunione")
	public void modificaDatiRiunione(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long riunioneId = ParamUtil.getLong(actionRequest, _idRiunioneAttribute);
		if (ParamUtil.getString(actionRequest, "buttonValue") == null || "".equals(ParamUtil.getString(actionRequest, "buttonValue"))) {
			
			try {
				String amministrazione = actionRequest.getParameter("AmministrazioneConvocante");
				long amministrazioneId = Long.parseLong(amministrazione);
				String oggetto = actionRequest.getParameter("Oggetto");
				long tipoId = 0;
				if (actionRequest.getParameter("Tipo") != null && !"".equals(actionRequest.getParameter("Tipo")))
					tipoId = Long.parseLong(actionRequest.getParameter("Tipo"));
				String protocollo = actionRequest.getParameter("Protocollo");
				String note = actionRequest.getParameter("Note");
				// retrieve modified value
				// get unmodified value
				Riunione riunione = RiunioneLocalServiceUtil.getRiunione(riunioneId);
				long tipoIdOld = riunione.getId_tipo();
				long amministrazioneIdOld = riunione.getId_amministrazione_convocante();
				String oggettoOld = riunione.getOggetto();
				String protocolloOld = riunione.getProtocollo();
				String noteOld = riunione.getNote();
				Date data_iniOld = riunione.getData_inizio();
				long id_luogoOld = riunione.getId_luogo();
				String luogoOld = LuogoLocalServiceUtil.getLuogo(id_luogoOld).getNome();
				String esito = RiunioneLocalServiceUtil.updateDatiRiunione(riunioneId, oggetto, protocollo, amministrazioneId, note,
				tipoId);
				actionRequest.setAttribute("status", esito);
				if (_statoIndetta.equalsIgnoreCase(esito)) {
					int count = 0;
					StringBuilder dati = new StringBuilder();
					// compare old with new value to write email body
					actionRequest.setAttribute(GestioneRiunioniFormConfig.class.getName(), _configuration);
					if (tipoIdOld != tipoId) {
						String oldTipo = "non specificato";
						if (tipoIdOld != 0)
							oldTipo = TipoRiunioneLocalServiceUtil.getTipoRiunione(tipoIdOld).getDescrizione();
						String newTipo = "non specificato";
						if (tipoId != 0)
							newTipo = TipoRiunioneLocalServiceUtil.getTipoRiunione(tipoId).getDescrizione();
						dati.append(this.getHtmlMailModified("Tipologia Riunione", oldTipo, newTipo));
						count++;
					}
					String oldamm = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(amministrazioneIdOld)
					.getNome_amministrazione();
					if (amministrazioneIdOld != amministrazioneId) {
						
						String newamm = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(amministrazioneId)
						.getNome_amministrazione();
						dati.append(this.getHtmlMailModified("Amministrazione Convocante", oldamm, newamm));
						count++;
					}
					if (!oggettoOld.equals(oggetto)) {
						dati.append(this.getHtmlMailModified("Oggetto", oggettoOld, oggetto));
						count++;
					}
					if (!protocolloOld.equals(protocollo)) {
						dati.append(this.getHtmlMailModified("Protocollo", protocolloOld, protocollo));
						count++;
					}
					if (!noteOld.equals(note)) {
						dati.append(this.getHtmlMailModified("Note", noteOld, note));
						count++;
					}
					if (count > 0) {
						String subject = actionRequest.getPreferences().getValue("subjectModifica", _configuration.subjectModifica());
						String sender = actionRequest.getPreferences().getValue("senderModifica", _configuration.senderModifica());
						String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
						// create link for confirm riunione
						ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
						PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
						themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
						renderUrl.setWindowState(LiferayWindowState.NORMAL);
						renderUrl.setPortletMode(LiferayPortletMode.VIEW);
						renderUrl.setParameter(_idRiunioneAttribute, riunioneId.toString());
						renderUrl.setParameter("navigation", "confirmRiunion");
						// get email adresses from invitati riunione
						List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
						BeanCreator segrCreator = new BeanCreator();
						for (InvitatiRiunione invitatoSegreteria : invitati) {
							
							// send mail
							Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
							if (invitato.getEmail() != null) {
								
								String dataIn = _parserOnlyDate.format(data_iniOld);
								String oraIn = _parserOnlyHour.format(data_iniOld);
								renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
								String body = actionRequest.getPreferences().getValue("modificariunioneTmpl",
								_configuration.modificariunioneTmpl());
								body = StringUtil.replace(body,
								new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
									"[$LUOGORIUNIONE$]", "[$DATI$]", "[$LINK$]" },
								new String[] { oggettoOld, oldamm, dataIn, oraIn, luogoOld, dati.toString(), renderUrl.toString() });
								EmailSender mail = new EmailSender();
								mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
							}
						}
						if (actionRequest.getParameter("changeTab") != null && !"".equals(actionRequest.getParameter("changeTab"))) {
							actionRequest.setAttribute(_idRiunioneAttribute, String.valueOf(riunioneId));
							actionRequest.setAttribute("mod", "modifica");
							actionRequest.setAttribute("changeTab", actionRequest.getParameter("changeTab"));
						} else
							goToJspPage(actionRequest, actionResponse, _jspPagePaginaCortesiaModifica, riunioneId);
						
					}
				} else
					throw new GestioneRiunioniException("cannot change meeting localization for meeting launched");
				
			} catch (Exception e) {
				SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				if (!(e instanceof NumberFormatException)) {
					SessionErrors.add(actionRequest, "Errore-durante-modifica-riunione");
				}
				if (riunioneId != null) {
					actionRequest.setAttribute(_idRiunioneAttribute, String.valueOf(riunioneId));
					actionRequest.setAttribute("mod", "modifica");
				}
				_log.warn(e);
			}
		} else {
			goToJspPage(actionRequest, actionResponse, _jspPageDettaglioRiunione, riunioneId);
		}
	}
	
	public void ricerca(ActionRequest request, ActionResponse response) {
		List<Riunione> _res = new ArrayList<Riunione>();
		Date data_da_out = null;
		Date data_a_out = null;
		Date a_data = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		long st = 0;
		long isp = 0;
		// I dati che vengono da form
		String data_da = "";
		if (request.getParameter("da") != null)
			data_da = request.getParameter("da");
		
		String data_a = "";
		if (request.getParameter("a") != null)
			data_a = request.getParameter("a");
		
		String stato = "";
		if (request.getParameter("statoSelected") != null)
			stato = request.getParameter("statoSelected");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String ispettorato = "0";
		if (request.getParameter("ispettorato") != null)
			ispettorato = request.getParameter("ispettorato");
		else if (request.getParameter("roleSegreteria") != null) {
			User user = themeDisplay.getUser();
			if (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null
			&& !"".equals(((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg)))) {
				
				try {
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil
					.getOrganizationChart(Long.parseLong((String) user.getExpandoBridge().getAttribute(_customFieldUserOrg)));
					if (orgChart != null && orgChart.getLevel() >= 3) {
						ispettorato = String.valueOf(orgChart.getLevel3());
					}
				} catch (Exception e) {
					_log.warn(e);
				}
			} else
				_log.warn(_customFieldUserOrg + " not defined for this user: " + user.getFullName());
			
		}
		String parola_chiave = "";
		if (request.getParameter("parola_chiave") != null)
			parola_chiave = request.getParameter("parola_chiave");
		
		String parola_chiave_lowerCase = parola_chiave.toLowerCase();
		try {
			if (data_da != null && !"".equals(data_da)) {
				Date da_data = _parserOnlyDate.parse(data_da);
				String _data_da = sdf.format(da_data);
				data_da_out = sdf.parse(_data_da);
			} else {
				throw new GestioneRiunioniException("field required empty: 'data da'");
			}
			if (data_a != null && !"".equals(data_a)) {
				a_data = _parserOnlyDate.parse(data_a);
				String _data_a = sdf.format(a_data);
				data_a_out = sdf.parse(_data_a);
			} else {
				throw new GestioneRiunioniException("field required empty: 'data a'");
			}
			if (a_data != null) {
				c.setTime(a_data);
				c.add(Calendar.DATE, 1);
				data_a_out = c.getTime();
			} else {
				c.setTime(data_a_out);
				c.add(Calendar.DATE, 1);
				data_a_out = c.getTime();
			}
			if (ispettorato != null) {
				isp = Long.parseLong(ispettorato);
			}
			if (stato != null && !"".equals(stato)) {
				st = Long.parseLong(stato);
			}
			List<RiunioneBean> riunioneList = new ArrayList<>(0);
			_res = RiunioneLocalServiceUtil.findByFilters(data_da_out, data_a_out, st, parola_chiave_lowerCase, isp, "", 0, 0);
			if (_res != null) {
				riunioneList = _creatorBean.getListRiunioneBean(_res, themeDisplay);
			}
			request.setAttribute("risultati", riunioneList);
		} catch (Exception e) {
			SessionErrors.add(request, "Errore-durante-modifica-riunione");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			_log.warn(e);
		} finally {
			request.setAttribute("param_da", data_da);
			request.setAttribute("param_a", data_a);
			request.setAttribute("param_stato", stato);
			request.setAttribute("param_isp", ispettorato);
			request.setAttribute("param_chiave", parola_chiave);
		}
	}
	
	public void modificaLuogoRiunione(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long riunioneId = ParamUtil.getLong(actionRequest, _idRiunioneAttribute);
		if (ParamUtil.getString(actionRequest, "buttonValue") == null || "".equals(ParamUtil.getString(actionRequest, "buttonValue"))) {
			
			String dIr = actionRequest.getParameter("date");
			String tIr = actionRequest.getParameter("time");
			String dI = dIr + " " + tIr;
			String note = actionRequest.getParameter("Note");
			SimpleDateFormat parserI = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				Date data_inizio = parserI.parse(dI);
				String luogo = actionRequest.getParameter("Luogo");
				long id_luogo = Long.parseLong(luogo);
				// get unmodified value
				Riunione riunione = RiunioneLocalServiceUtil.getRiunione(riunioneId);
				int count = 0;
				String old_note = riunione.getNote();
				
				Date data_iniOld = riunione.getData_inizio();
				String dataOnlyDate = _parserOnlyDate.format(data_iniOld);
				String hour = _parserOnlyHour.format(data_iniOld);
				String data_inizioOld = parserI.format(data_iniOld);
				long amministrazioneId = riunione.getId_amministrazione_convocante();
				String amministrazConvocante = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(amministrazioneId)
				.getNome_amministrazione();
				String oggetto = riunione.getOggetto();
				long id_luogoOld = riunione.getId_luogo();
				if (!note.equals(old_note)) {
					riunione.setNote(note);
					RiunioneLocalServiceUtil.updateRiunione(riunione);
					count++;

					StringBuilder dati = new StringBuilder();
					dati.append(this.getHtmlMailModified("Note", old_note, note));
					String subject = actionRequest.getPreferences().getValue("subjectModifica", _configuration.subjectModifica());
					String sender = actionRequest.getPreferences().getValue("senderModifica", _configuration.senderModifica());
					String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
					// create link for confirm riunione
					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter(_idRiunioneAttribute, riunioneId.toString());
					renderUrl.setParameter("navigation", "confirmRiunion");
					// get email adresses from invitati riunione
					List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
					BeanCreator segrCreator = new BeanCreator();
					for (InvitatiRiunione invitatoSegreteria : invitati) {
						
						// send mail
						Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
						if (invitato.getEmail() != null) {
							
							String dataIn = _parserOnlyDate.format(data_inizio);
							String oraIn = _parserOnlyHour.format(data_inizio);
							renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
							String body = actionRequest.getPreferences().getValue("modificariunioneTmpl",
							_configuration.modificariunioneTmpl());
							body = StringUtil.replace(body,
							new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
								"[$LUOGORIUNIONE$]", "[$DATI$]", "[$LINK$]" },
							new String[] { oggetto, amministrazConvocante, dataIn, oraIn, luogo, dati.toString(),
								renderUrl.toString() });
							EmailSender mail = new EmailSender();
							mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
						}
					}
				
				}
			if((data_iniOld!=null && !data_iniOld.equals(data_inizio)) || id_luogo!=id_luogoOld){
				boolean esito = RiunioneLocalServiceUtil.updateSpostaRiunione(riunioneId, data_inizio, id_luogo);
				if (esito) {
					String luogoOld = LuogoLocalServiceUtil.getLuogo(id_luogoOld).getNome();
					String nuovoLuogo = luogoOld;
					String nuovaData = dataOnlyDate;
					String nuovaOra = hour;
					// get text from configuration
					actionRequest.setAttribute(GestioneRiunioniFormConfig.class.getName(), _configuration);
					if (!dI.equals(data_inizioOld)) {
						nuovaData = _parserOnlyDate.format(data_inizio);
						nuovaOra = _parserOnlyHour.format(data_inizio);
						count++;
					}
					if (id_luogo != id_luogoOld) {
						nuovoLuogo = LuogoLocalServiceUtil.getLuogo(id_luogo).getNome();
						count++;
					}
					if (count > 0) {
						ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
						PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
						themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
						renderUrl.setWindowState(LiferayWindowState.NORMAL);
						renderUrl.setPortletMode(LiferayPortletMode.VIEW);
						renderUrl.setParameter(_idRiunioneAttribute, riunioneId.toString());
						renderUrl.setParameter("navigation", "confirmRiunion");
						String subject = actionRequest.getPreferences().getValue("subjectSposta", _configuration.subjectSposta());
						String sender = actionRequest.getPreferences().getValue("senderSposta", _configuration.senderSposta());
						String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
						// get email adresses from invitati riunione
						List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
						for (InvitatiRiunione invitatoSegreteria : invitati) {
							long stato_invitato_id = 0;
							invitatoSegreteria.setId_stato_invitato(stato_invitato_id);
							InvitatiRiunioneLocalServiceUtil.updateInvitatiRiunione(invitatoSegreteria);
							// send mail
							BeanCreator segrCreator = new BeanCreator();
							Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
							if (invitato.getEmail() != null) {
								renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
								String body = actionRequest.getPreferences().getValue("spostariunioneTmpl",
								_configuration.spostariunioneTmpl());
								body = StringUtil.replace(body,
								new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
									"[$LUOGORIUNIONE$]", "[$NUOVADATARIUNIONE$]", "[$NUOVAORARIUNIONE$]", "[$NUOVOLUOGORIUNIONE$]",
									"[$LINK$]" },
								new String[] { oggetto, amministrazConvocante, dataOnlyDate, hour, luogoOld, nuovaData, nuovaOra,
									nuovoLuogo, renderUrl.toString() });
								EmailSender mail = new EmailSender();
								mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
							}
						}
						if (actionRequest.getParameter("changeTab") != null && !"".equals(actionRequest.getParameter("changeTab"))) {
							actionRequest.setAttribute(_idRiunioneAttribute, String.valueOf(riunioneId));
							actionRequest.setAttribute("mod", "modifica");
							_log.warn("changeTab" + actionRequest.getParameter("changeTab"));
							actionRequest.setAttribute("changeTab", actionRequest.getParameter("changeTab"));
						} else
							goToJspPage(actionRequest, actionResponse, _jspPagePaginaCortesiaModifica, riunioneId);
					}
				}
				}
					
				
			} catch (Exception e) {
				actionRequest.setAttribute(_idRiunioneAttribute, ParamUtil.getString(actionRequest, _idRiunioneAttribute));
				actionRequest.setAttribute("mod", "modifica");
				SessionErrors.add(actionRequest, "Errore-durante-modifica-riunione");
				SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				_log.warn(e);
			}
		} else {
			goToJspPage(actionRequest, actionResponse, _jspPageDettaglioRiunione, riunioneId);
		}
	}
	
	/* invia un email a tutte le segreterie con lo stato cambiato */
	public void modificaStatoRiunione(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long riunioneId = ParamUtil.getLong(actionRequest, _idRiunioneAttribute);
		if (ParamUtil.getString(actionRequest, "buttonValue") == null || "".equals(ParamUtil.getString(actionRequest, "buttonValue"))) {
			try {
				Riunione riunione = RiunioneLocalServiceUtil.getRiunione(riunioneId);
				String note = actionRequest.getParameter("Note");
				String old_note = riunione.getNote();
				
				long amministrazioneId = riunione.getId_amministrazione_convocante();
				String amministrazConvocante = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(amministrazioneId)
				.getNome_amministrazione();
				String oggetto = riunione.getOggetto();
				SimpleDateFormat parserI = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date data_ini = riunione.getData_inizio();
				String dataOnlyDate = _parserOnlyDate.format(data_ini);
				String hour = _parserOnlyHour.format(data_ini);
				long id_place = riunione.getId_luogo();
				String luogo = LuogoLocalServiceUtil.getLuogo(id_place).getNome();
				String status = actionRequest.getParameter("StatoRiunione");
				if (!note.equals(old_note)) {
					riunione.setNote(note);
					riunione = RiunioneLocalServiceUtil.updateRiunione(riunione);
					StringBuilder dati = new StringBuilder();
					dati.append(this.getHtmlMailModified("Note", old_note, note));
					String subject = actionRequest.getPreferences().getValue("subjectModifica", _configuration.subjectModifica());
					String sender = actionRequest.getPreferences().getValue("senderModifica", _configuration.senderModifica());
					String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
					// create link for confirm riunione
					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter(_idRiunioneAttribute, riunioneId.toString());
					renderUrl.setParameter("navigation", "confirmRiunion");
					// get email adresses from invitati riunione
					List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
					BeanCreator segrCreator = new BeanCreator();
					for (InvitatiRiunione invitatoSegreteria : invitati) {
						
						// send mail
						Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
						if (invitato.getEmail() != null) {
							
							String dataIn = _parserOnlyDate.format(data_ini);
							String oraIn = _parserOnlyHour.format(data_ini);
							renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
							String body = actionRequest.getPreferences().getValue("modificariunioneTmpl",
							_configuration.modificariunioneTmpl());
							body = StringUtil.replace(body,
							new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
								"[$LUOGORIUNIONE$]", "[$DATI$]", "[$LINK$]" },
							new String[] { oggetto, amministrazConvocante, dataIn, oraIn, luogo, dati.toString(), renderUrl.toString() });
							EmailSender mail = new EmailSender();
							mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
						}
					}
				}
				if (status != null && !"".equals(status)) {
					long longStatus = Long.parseLong(status);
					String statoriunione = StatoRiunioneLocalServiceUtil.getStatoRiunione(longStatus).getLabel();
					Date dat = new Date();
					boolean esito = RiunioneLocalServiceUtil.modifyStatoRiunione(riunioneId, dat, longStatus);
					Date data_iniOld = riunione.getData_inizio();
					String dIr = actionRequest.getParameter("date");
					String tIr = actionRequest.getParameter("time");
					String dI = dIr + " " + tIr;
					boolean dateStartChg = dIr != null && tIr != null && !dIr.isEmpty() && !tIr.isEmpty();
					if (dateStartChg) {
						Date data_inizio = parserI.parse(dI);
						long id_luogo = riunione.getId_luogo();
						esito = RiunioneLocalServiceUtil.updateSpostaRiunione(riunioneId, data_inizio, id_luogo);
					}
					String statoriunioneold = StatoRiunioneLocalServiceUtil.getStatoRiunione(riunione.getId_stato_riunione()).getLabel();
					if (esito && !"effettuata".equalsIgnoreCase(statoriunione)) {
						
						StringBuilder dati = new StringBuilder();
						// get text from configuration
						actionRequest.setAttribute(GestioneRiunioniFormConfig.class.getName(), _configuration);
						if (!statoriunioneold.equals(statoriunione)) {
							dati.append(this.getHtmlMailModified("Stato riunione", statoriunioneold, statoriunione));
						}
						if (dateStartChg) {
							String data_inizioOld = parserI.format(data_iniOld);
							dati.append(this.getHtmlMailModified("Data Inizio", data_inizioOld, dI));
						}
						ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
						PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
						themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
						renderUrl.setWindowState(LiferayWindowState.NORMAL);
						renderUrl.setPortletMode(LiferayPortletMode.VIEW);
						renderUrl.setParameter(_idRiunioneAttribute, riunioneId.toString());
						String subject = "";
						String sender = "";
						List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
						BeanCreator segrCreator = new BeanCreator();
						StringBuilder ispettorati = getIspettoratiHtml(segrCreator.updateListaSegreterie(invitati));
						boolean flagInviaMail = true;
						String body = "";
						switch (statoriunione) {
						case _statoIndetta:
							renderUrl.setParameter("navigation", "confirmRiunion");
							subject = actionRequest.getPreferences().getValue("subjectStatoIndetta", _configuration.subjectStatoIndetta());
							sender = actionRequest.getPreferences().getValue("senderStatoIndetta", _configuration.senderStatoIndetta());
							break;
						case _statoAnnullata:
							renderUrl.setParameter("navigation", "detailRiunion");
							subject = actionRequest.getPreferences().getValue("subjectCambioStato", _configuration.subjectCambioStato());
							sender = actionRequest.getPreferences().getValue("senderCambioStato", _configuration.senderCambioStato());
							body = actionRequest.getPreferences().getValue("cambiostatoriunioneTmpl",
							_configuration.cambiostatoriunioneTmpl());
							body = StringUtil.replace(body, new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]",
								"[$ORARIUNIONE$]", "[$LUOGORIUNIONE$]" },
							new String[] { oggetto, amministrazConvocante, dataOnlyDate, hour, luogo });
							break;
						case _statoRinviata:
							renderUrl.setParameter("navigation", "detailRiunion");
							subject = actionRequest.getPreferences().getValue("subjectRiunioneRinviata",
							_configuration.subjectRiunioneRinviata());
							sender = actionRequest.getPreferences().getValue("senderRiunioneRinviata",
							_configuration.senderRiunioneRinviata());
							body = actionRequest.getPreferences().getValue("riunionerinviataTmpl",
							_configuration.cambiostatoriunioneTmpl());
							body = StringUtil.replace(body, new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]",
								"[$ORARIUNIONE$]", "[$LUOGORIUNIONE$]" },
							new String[] { oggetto, amministrazConvocante, dataOnlyDate, hour, luogo });
							break;
						default:
							flagInviaMail = false;
						}
						if (flagInviaMail) {
							String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
							// get email adresses from invitati riunione
							for (InvitatiRiunione invitatoSegreteria : invitati) {
								
								// send mail
								Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
								if (invitato.getEmail() != null) {
									if (statoriunione.equalsIgnoreCase(_statoIndetta)) {
										
										renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
										body = actionRequest.getPreferences().getValue("cambiostatoriunioneindettaTmpl",
										_configuration.cambiostatoriunioneindettaTmpl());
										body = StringUtil.replace(body,
										new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
											"[$LUOGORIUNIONE$]", "[$ISPETTORATI$]", "[$LINK$]" },
										new String[] { oggetto, amministrazConvocante, dataOnlyDate, hour, luogo, ispettorati.toString(),
											renderUrl.toString() });
									} else {
										long stato_invitato_id = 0;
										invitatoSegreteria.setId_stato_invitato(stato_invitato_id);
										InvitatiRiunioneLocalServiceUtil.updateInvitatiRiunione(invitatoSegreteria);
									}
									EmailSender mail = new EmailSender();
									mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
								}
							}
						}
					}
				} 
				if (actionRequest.getParameter("changeTab") != null && !"".equals(actionRequest.getParameter("changeTab"))) {
					actionRequest.setAttribute(_idRiunioneAttribute, String.valueOf(riunioneId));
					actionRequest.setAttribute("mod", "modifica");
					actionRequest.setAttribute("changeTab", actionRequest.getParameter("changeTab"));
				} else
					goToJspPage(actionRequest, actionResponse, _jspPagePaginaCortesiaModifica, riunioneId);
				
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "Errore-durante-modifica-riunione");
				SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				if (riunioneId != null) {
					actionRequest.setAttribute(_idRiunioneAttribute, String.valueOf(riunioneId));
					actionRequest.setAttribute("mod", "modifica");
				}
				_log.warn(e);
			}
		} else {
			goToJspPage(actionRequest, actionResponse, _jspPageDettaglioRiunione, riunioneId);
		}
	}
	
	@ProcessAction(name = "sendAlert")
	public void sendAlert(ActionRequest actionRequest, ActionResponse actionResponse)
	throws java.text.ParseException, PortalException, AddressException, IOException, PortletException {
		
		Long riunioneId = ParamUtil.getLong(actionRequest, _idRiunioneAttribute);
		// get unmodified value
		Riunione riunione = RiunioneLocalServiceUtil.getRiunione(riunioneId);
		long amministrazioneId = riunione.getId_amministrazione_convocante();
		String amministrazConvocante = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(amministrazioneId)
		.getNome_amministrazione();
		String oggetto = riunione.getOggetto();
		Date data_ini = riunione.getData_inizio();
		//String data_inizio = parserI.format(data_ini);
		long id_luogo = riunione.getId_luogo();
		String luogo = LuogoLocalServiceUtil.getLuogo(id_luogo).getNome();
		//StringBuilder dati = getHtmlMailRiunione(riunione);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
		PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setPortletMode(LiferayPortletMode.VIEW);
		renderUrl.setParameter(_idRiunioneAttribute, riunioneId.toString());
		renderUrl.setParameter("navigation", "confirmRiunion");
		String subject = actionRequest.getPreferences().getValue("subjectSollecito", _configuration.subjectSollecito());
		String sender = actionRequest.getPreferences().getValue("senderSollecito", _configuration.senderSollecito());
		String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		// get email adresses from invitati riunione
		List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneId);
		boolean statononaccettato = false;
		BeanCreator segrCreator = new BeanCreator();
		StringBuilder ispettorati = getIspettoratiHtml(segrCreator.updateListaSegreterie(invitati));
		String dataOnlyDate = _parserOnlyDate.format(data_ini);
		String hour = _parserOnlyHour.format(data_ini);
		for (InvitatiRiunione invitatoSegreteria : invitati) {
			// send mail
			if (invitatoSegreteria.getId_stato_invitato() == 0) {
				statononaccettato = true;
				Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
				if (invitato.getEmail() != null && !invitato.getEmail().isEmpty()) {
					renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
					String body = actionRequest.getPreferences().getValue("sollecitoriunioneTmpl", _configuration.sollecitoriunioneTmpl());
					body = StringUtil.replace(body,
					new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]", "[$LUOGORIUNIONE$]",
						"[$ISPETTORATI$]", "[$LINK$]" },
					new String[] { oggetto, amministrazConvocante, dataOnlyDate, hour, luogo, ispettorati.toString(),
						renderUrl.toString() });
					EmailSender mail = new EmailSender();
					mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
				}
			}
			/* todo : invia email segreteria accettato senza partecipanti */
			if (invitatoSegreteria.getId_stato_invitato() == 1
			&& (segrCreator.getSizePartecipantiJSON(invitatoSegreteria.getPartecipanti()) == 0)) {
				statononaccettato = true;
				Segreteria invitato = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
				if (invitato.getEmail() != null && !invitato.getEmail().isEmpty()) {
					subject = actionRequest.getPreferences().getValue("subjectAccettataSollecito",
					_configuration.subjectSollecitoAccettata());
					sender = actionRequest.getPreferences().getValue("senderAccettataSollecito", _configuration.senderSollecitoAccettata());
					renderUrl.setParameter("idSegreteria", Long.toString(invitato.getId_segreteria()));
					String body = actionRequest.getPreferences().getValue("sollecitoaccettatariunioneTmpl",
					_configuration.sollecitoaccettatariunioneTmpl());
					body = StringUtil.replace(body,
					new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]", "[$LUOGORIUNIONE$]",
						"[$ISPETTORATI$]", "[$LINK$]" },
					new String[] { oggetto, amministrazConvocante, dataOnlyDate, hour, luogo, ispettorati.toString(),
						renderUrl.toString() });
					EmailSender mail = new EmailSender();
					mail.sendMailMessage(subject, body, sender, smtpUser, invitato.getEmail());
				}
			}
		}
		if (statononaccettato)
			RiunioneLocalServiceUtil.updateDataSollecitoRiunione(riunioneId);
		if (actionRequest.getParameter("flagDettaglio") != null && "true".equalsIgnoreCase(actionRequest.getParameter("flagDettaglio"))) {
			goToJspPage(actionRequest, actionResponse, _jspPageDettaglioRiunione, riunioneId);
		} else {
			PortletURL render;
			if (actionRequest.getParameter("flagRicerca") != null && "true".equalsIgnoreCase(actionRequest.getParameter("flagRicerca"))) {
				render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
				PortletRequest.ACTION_PHASE);
				render.setParameter("javax.portlet.action", "ricerca");
				String da = "";
				if (actionRequest.getParameter("da") != null)
					da = actionRequest.getParameter("da");
				
				String a = "";
				if (actionRequest.getParameter("a") != null)
					a = actionRequest.getParameter("a");
				render.setParameter("da", da);
				render.setParameter("a", a);
				String statoSelected = "";
				if (actionRequest.getParameter("statoSelected") != null)
					statoSelected = actionRequest.getParameter("statoSelected");
				
				render.setParameter("statoSelected", statoSelected);
				String ispettorato = "";
				if (actionRequest.getParameter("ispettorato") != null)
					ispettorato = actionRequest.getParameter("ispettorato");
				
				render.setParameter("ispettorato", ispettorato);
				String parola_chiave = "";
				if (actionRequest.getParameter("parola_chiave") != null)
					parola_chiave = actionRequest.getParameter("parola_chiave");
				
				render.setParameter("parola_chiave", parola_chiave);
			} else {
				
				render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
			}
			render.setWindowState(LiferayWindowState.NORMAL);
			render.setPortletMode(LiferayPortletMode.VIEW);
			actionResponse.sendRedirect(render.toString());
		}
	}
	
	public void passamodifica(ActionRequest request, ActionResponse response) {
		if (ParamUtil.getString(request, _idRiunioneAttribute) != null) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);
			renderUrl.setParameter(_idRiunioneAttribute, ParamUtil.getString(request, _idRiunioneAttribute));
			renderUrl.setParameter("mod", "modifica");
			try {
				response.sendRedirect(renderUrl.toString());
			} catch (IOException e) {
				_log.warn(e);
			}
		}
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(GestioneRiunioniFormConfig.class, properties);
	}
	
	private volatile GestioneRiunioniFormConfig _configuration;
	
	public void inserisciRiunione(ActionRequest actionRequest, ActionResponse actionResponse)
	throws java.text.ParseException, PortalException, AddressException, IOException, PortletException {
		
		long sRiunione = 1;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
		PortletRequest.RENDER_PHASE);
		try {
			String a = actionRequest.getParameter("AmministrazioneConvocante");
			long longA = Long.parseLong(a);
			String dI = actionRequest.getParameter("DataInizio");
			String oI = actionRequest.getParameter("OraInizio");
			// DD/MM/AAAA
			SimpleDateFormat parserI = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date dInizio = parserI.parse(dI + " " + oI);
			Date dateToday = new Date();
			if (dateToday.after(dInizio)) {
				throw new GestioneRiunioniException("start date is before today");
			} else {
				
				Date dFine = null;
				String luogo = actionRequest.getParameter("Luogo");
				long longL = Long.parseLong(luogo);
				String oggetto = actionRequest.getParameter("Oggetto");
				String tipo = actionRequest.getParameter("Tipo");
				long longT = 0;
				if (tipo != null && !"".equalsIgnoreCase(tipo)) {
					longT = Long.parseLong(tipo);
				}
				String protocollo = actionRequest.getParameter("Protocollo");
				String note = actionRequest.getParameter("Note");
				Date dModifica = null;
				Date dCreazione = new Date();
				/** */
				String json = actionRequest.getParameter("saveInvitati");
				JSONObject obj = JSONFactoryUtil.createJSONObject(json);
				JSONArray arrayInvitati = JSONFactoryUtil.createJSONArray(obj.getString("invitati"));
				long[] listIdSegr = new long[arrayInvitati.length()];
				List<Segreteria> segreterieInvitati = new ArrayList<>(0);
				for (int i = 0; i < arrayInvitati.length(); i++) {
					listIdSegr[i] = Long.parseLong(arrayInvitati.getJSONObject(i).getString("id"));
					segreterieInvitati.add(new Segreteria(Long.parseLong(arrayInvitati.getJSONObject(i).getString("id")),
					arrayInvitati.getJSONObject(i).getString("nome"), arrayInvitati.getJSONObject(i).getString("email"),
					arrayInvitati.getJSONObject(i).getString("descrizione"),
					Long.parseLong(arrayInvitati.getJSONObject(i).getString("stato")), "",
					Boolean.parseBoolean(arrayInvitati.getJSONObject(i).getString("capofila")),
					Integer.parseInt(arrayInvitati.getJSONObject(i).getString("index"))));
				}
				long idriunione = RiunioneLocalServiceUtil.setRiunione(oggetto, dInizio, dFine, note, dModifica, dCreazione, protocollo,
				sRiunione, longT, longL, longA, listIdSegr);
				if (idriunione != 0) {
					
					Riunione riunionecaricata = RiunioneLocalServiceUtil.getRiunione(idriunione);
					long amministrazioneId = riunionecaricata.getId_amministrazione_convocante();
					String amministrazConvocante = AmministrazioneConvocanteLocalServiceUtil.getAmministrazioneConvocante(amministrazioneId)
					.getNome_amministrazione();
					oggetto = riunionecaricata.getOggetto();
					Date data_ini = riunionecaricata.getData_inizio();
					String dataOnly = _parserOnlyDate.format(data_ini);
					String ora = _parserOnlyHour.format(data_ini);
					long id_luogo = riunionecaricata.getId_luogo();
					luogo = LuogoLocalServiceUtil.getLuogo(id_luogo).getNome();
					String subject = actionRequest.getPreferences().getValue("subjectInserisci", _configuration.senderInvito());
					String sender = actionRequest.getPreferences().getValue("senderInserisci", _configuration.senderInvito());
					themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
					renderUrl.setWindowState(LiferayWindowState.NORMAL);
					renderUrl.setPortletMode(LiferayPortletMode.VIEW);
					renderUrl.setParameter(_idRiunioneAttribute, Long.toString(idriunione));
					renderUrl.setParameter("navigation", "confirmRiunion");
					BeanCreator segrCreator = new BeanCreator();
					String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
					for (int i = 0; i < listIdSegr.length; i++) {
						InvitatiRiunionePK invitatiRiunionePK = new InvitatiRiunionePK();
						invitatiRiunionePK.setId_riunione(idriunione);
						invitatiRiunionePK.setId_segreteria(listIdSegr[i]);
						InvitatiRiunione invitatoSegreteria = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunione(invitatiRiunionePK);
						StringBuilder jsonCapofila = new StringBuilder();
						jsonCapofila.append("{");
						if (segreterieInvitati.get(i).isCapofila()) {
							jsonCapofila.append("\"top\"");
							jsonCapofila.append(":");
							jsonCapofila.append("true");
							jsonCapofila.append(",");
						}
						jsonCapofila.append("\"pos\"");
						jsonCapofila.append(":");
						jsonCapofila.append(segreterieInvitati.get(i).getIndex());
						jsonCapofila.append("}");
						invitatoSegreteria.setPartecipanti(jsonCapofila.toString());
						InvitatiRiunioneLocalServiceUtil.updateInvitatiRiunione(invitatoSegreteria);
					}
					StringBuilder ispettorati = getIspettoratiHtml(
					segrCreator.updateListaSegreterie(InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(idriunione)));
					for (int i = 0; i < listIdSegr.length; i++) {
						// create the primary key of riunione
						InvitatiRiunionePK invitatiRiunionePK = new InvitatiRiunionePK();
						invitatiRiunionePK.setId_riunione(idriunione);
						invitatiRiunionePK.setId_segreteria(listIdSegr[i]);
						InvitatiRiunione invitatoSegreteria = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunione(invitatiRiunionePK);
						Segreteria invriun = segrCreator.getElementByIdSegreteria(invitatoSegreteria.getId_segreteria());
						String email = invriun.getEmail();
						if (email != null && !email.isEmpty()) {
							renderUrl.setParameter("idSegreteria", Long.toString(invriun.getId_segreteria()));
							String body = actionRequest.getPreferences().getValue("inserisciriunioneTmpl",
							_configuration.invitoriunioneTmpl());
							body = StringUtil.replace(body,
							new String[] { "[$OGGETTORIUNIONE$]", "[$CONVOCANTE$]", "[$DATARIUNIONE$]", "[$ORARIUNIONE$]",
								"[$LUOGORIUNIONE$]", "[$ISPETTORATI$]", "[$LINK$]" },
							new String[] { oggetto, amministrazConvocante, dataOnly, ora, luogo, ispettorati.toString(),
								renderUrl.toString() });
							EmailSender mail = new EmailSender();
							mail.sendMailMessage(subject, body, sender, smtpUser, email);
						} else {
							_log.warn("Non &egrave; stata spedita l'email perch&egrave; assente => FASE TEST! utente: "
							+ arrayInvitati.getJSONObject(i).getString("id"));
						}
					}
				}
				goToJspPage(actionRequest, actionResponse, _jspPageDettaglioRiunione, idriunione);
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "Errore-durante-inserimento-riunione");
			SessionMessages.add(actionRequest,
			PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionResponse.setRenderParameter("jspPage", "/inserimentoRiunione.jsp");
			String luoghititolo = actionRequest.getPreferences().getValue("luoghiRiunionetitle", _configuration.luoghiRiunionetitle());
			String luoghisottotitolo = actionRequest.getPreferences().getValue("luoghiRiunionetxt", _configuration.luoghiRiunionetxt());
			String convocantititolo = actionRequest.getPreferences().getValue("convocantiRiunionetitle",
			_configuration.convocantiRiunionetitle());
			String convocantisottotitolo = actionRequest.getPreferences().getValue("convocantiRiunionetxt",
			_configuration.convocantiRiunionetxt());
			String inseriscitititolo = actionRequest.getPreferences().getValue("creaRiunionetitle", _configuration.creaRiunionetitle());
			String inseriscisottotitolo = actionRequest.getPreferences().getValue("creaRiunionetxt", _configuration.creaRiunionetxt());
			actionRequest.setAttribute("titleLuoghiRiunione", luoghititolo);
			actionRequest.setAttribute("subTitleLuoghiRiunione", luoghisottotitolo);
			actionRequest.setAttribute("titleConvocantiRiunione", convocantititolo);
			actionRequest.setAttribute("subTitleConvocantiRiunione", convocantisottotitolo);
			actionRequest.setAttribute("titleCreaRiunione", inseriscitititolo);
			actionRequest.setAttribute("subTitleCreaRiunione", inseriscisottotitolo);
			_log.warn(e);
		}
	}
	
	public void aggiungiConvocante(ActionRequest request, ActionResponse response) {
		String nome_amministrazione = request.getParameter("Convocante");
		List<AmministrazioneConvocante> amministrazioni = AmministrazioneConvocanteLocalServiceUtil
		.getAmministrazioneConvocantes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		boolean existAmministrazione = false;
		long id_ammConv = 0;
		for (AmministrazioneConvocante amministrazione : amministrazioni) {
			if (nome_amministrazione.equalsIgnoreCase(amministrazione.getNome_amministrazione())) {
				existAmministrazione = true;
				id_ammConv = amministrazione.getId_amministrazione_convocante();
				break;
			}
		}
		if (!existAmministrazione) {
			AmministrazioneConvocanteLocalServiceUtil.setAmministrazioneConvocante(nome_amministrazione);
		} else if (CancelAmmConvLocalServiceUtil.fetchCancelAmmConv(id_ammConv) != null
		&& CancelAmmConvLocalServiceUtil.fetchCancelAmmConv(id_ammConv).getCancellato()) {
			CancelAmmConv ammConvCancellato = CancelAmmConvLocalServiceUtil.fetchCancelAmmConv(id_ammConv);
			ammConvCancellato.setCancellato(false);
			CancelAmmConvLocalServiceUtil.updateCancelAmmConv(ammConvCancellato);
		}
		String riunioneIdString = request.getParameter(_idRiunioneAttribute);
		if (request.getParameter("previousPage") != null && "inserimentoRiunione".equalsIgnoreCase(request.getParameter("previousPage"))) {
			response.setRenderParameter("jspPage", "/inserimentoRiunione.jsp");
			String luoghititolo = request.getPreferences().getValue("luoghiRiunionetitle", _configuration.luoghiRiunionetitle());
			String luoghisottotitolo = request.getPreferences().getValue("luoghiRiunionetxt", _configuration.luoghiRiunionetxt());
			String convocantititolo = request.getPreferences().getValue("convocantiRiunionetitle",
			_configuration.convocantiRiunionetitle());
			String convocantisottotitolo = request.getPreferences().getValue("convocantiRiunionetxt",
			_configuration.convocantiRiunionetxt());
			String inseriscitititolo = request.getPreferences().getValue("creaRiunionetitle", _configuration.creaRiunionetitle());
			String inseriscisottotitolo = request.getPreferences().getValue("creaRiunionetxt", _configuration.creaRiunionetxt());
			request.setAttribute("titleLuoghiRiunione", luoghititolo);
			request.setAttribute("subTitleLuoghiRiunione", luoghisottotitolo);
			request.setAttribute("titleConvocantiRiunione", convocantititolo);
			request.setAttribute("subTitleConvocantiRiunione", convocantisottotitolo);
			request.setAttribute("titleCreaRiunione", inseriscitititolo);
			request.setAttribute("subTitleCreaRiunione", inseriscisottotitolo);
		}
		if (request.getParameter("previousPage") != null && "modifyDati".equalsIgnoreCase(request.getParameter("previousPage"))) {
			request.setAttribute(_idRiunioneAttribute, riunioneIdString);
			request.setAttribute("mod", "modifica");
		}
	}
	
	public void aggiungiLuogo(ActionRequest request, ActionResponse response) {
		
		String nome = request.getParameter("Luogo");
		try {
			if ((nome != null) && (!"".equals(nome))) {
				// controlla se il luogo esista gi&agrave;
				List<Luogo> luoghi = LuogoLocalServiceUtil.getLuogos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				boolean existLuogo = false;
				long id_luogo = 0;
				for (Luogo luogo : luoghi) {
					if (nome.equalsIgnoreCase(luogo.getNome())) {
						existLuogo = true;
						id_luogo = luogo.getId_luogo();
						break;
					}
				}
				if (!existLuogo) {
					LuogoLocalServiceUtil.setLuogo(nome);
				} else if (existLuogo && CancelLuogoLocalServiceUtil.fetchCancelLuogo(id_luogo) != null
				&& CancelLuogoLocalServiceUtil.fetchCancelLuogo(id_luogo).getCancellato()) {
					CancelLuogo luogoCancellato = CancelLuogoLocalServiceUtil.fetchCancelLuogo(id_luogo);
					luogoCancellato.setCancellato(false);
					CancelLuogoLocalServiceUtil.updateCancelLuogo(luogoCancellato);
				}
				String riunioneIdString = request.getParameter(_idRiunioneAttribute);
				if (request.getParameter("previousPage") != null
				&& "inserimentoRiunione".equalsIgnoreCase(request.getParameter("previousPage"))) {
					response.setRenderParameter("jspPage", "/inserimentoRiunione.jsp");
					String luoghititolo = request.getPreferences().getValue("luoghiRiunionetitle", _configuration.luoghiRiunionetitle());
					String luoghisottotitolo = request.getPreferences().getValue("luoghiRiunionetxt", _configuration.luoghiRiunionetxt());
					String convocantititolo = request.getPreferences().getValue("convocantiRiunionetitle",
					_configuration.convocantiRiunionetitle());
					String convocantisottotitolo = request.getPreferences().getValue("convocantiRiunionetxt",
					_configuration.convocantiRiunionetxt());
					String inseriscitititolo = request.getPreferences().getValue("creaRiunionetitle", _configuration.creaRiunionetitle());
					String inseriscisottotitolo = request.getPreferences().getValue("creaRiunionetxt", _configuration.creaRiunionetxt());
					request.setAttribute("titleLuoghiRiunione", luoghititolo);
					request.setAttribute("subTitleLuoghiRiunione", luoghisottotitolo);
					request.setAttribute("titleConvocantiRiunione", convocantititolo);
					request.setAttribute("subTitleConvocantiRiunione", convocantisottotitolo);
					request.setAttribute("titleCreaRiunione", inseriscitititolo);
					request.setAttribute("subTitleCreaRiunione", inseriscisottotitolo);
				}
				if (request.getParameter("previousPage") != null && "modifyLuogo".equalsIgnoreCase(request.getParameter("previousPage"))) {
					request.setAttribute(_idRiunioneAttribute, riunioneIdString);
					request.setAttribute("mod", "modifica");
				}
			} else {
				throw new GestioneRiunioniException("luogo undefined");
			}
		} catch (Exception e) {
			_log.warn(e);
			response.setRenderParameter("jspPage", "/gestioneLuoghi.jsp");
			String luoghititolo = request.getPreferences().getValue("luoghiRiunionetitle", _configuration.luoghiRiunionetitle());
			String luoghisottotitolo = request.getPreferences().getValue("luoghiRiunionetxt", _configuration.luoghiRiunionetxt());
			String previousPage = request.getParameter("previousPage");
			request.setAttribute("titleLuoghiRiunione", luoghititolo);
			request.setAttribute("subTitleLuoghiRiunione", luoghisottotitolo);
			request.setAttribute("previousPage", previousPage);
			SessionErrors.add(request, "Errore-durante-aggiunta-luogo");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
	}
	
	public void rimuoviConvocante(ActionRequest request, ActionResponse response) {
		String id_amministrazione_convocante = request.getParameter("convocante");
		String riunioneIdString = request.getParameter(_idRiunioneAttribute);
		if (id_amministrazione_convocante != null) {
			try {
				CancelAmmConv amministrazione_logica = CancelAmmConvLocalServiceUtil
				.getCancelAmmConv(Long.parseLong(id_amministrazione_convocante));
				amministrazione_logica.setCancellato(true);
				CancelAmmConvLocalServiceUtil.updateCancelAmmConv(amministrazione_logica);
			} catch (NumberFormatException e) {
				_log
				.warn("impossibile convetire l'id dell' amministratore convocante in valore numerico nel metodo di cancellazione logica");
			} catch (PortalException e) {
				_log.warn(e);
			}
		}
		String previousPage = request.getParameter("previousPage");
		response.setRenderParameter("jspPage", "/gestioneConvocanti.jsp");
		String convocantititolo = request.getPreferences().getValue("convocantiRiunionetitle", _configuration.convocantiRiunionetitle());
		String convocantisottotitolo = request.getPreferences().getValue("convocantiRiunionetxt", _configuration.convocantiRiunionetxt());
		request.setAttribute("titleConvocantiRiunione", convocantititolo);
		request.setAttribute("subTitleConvocantiRiunione", convocantisottotitolo);
		request.setAttribute("previousPage", previousPage);
		request.setAttribute(_idRiunioneAttribute, riunioneIdString);
	}
	
	public void ricercaAmministrazioneConvocante(ActionRequest request, ActionResponse response) {
		String riunioneIdString = request.getParameter(_idRiunioneAttribute);
		String keyword = request.getParameter("Keyword");
		String keyword_lower_case = keyword.toLowerCase();
		List<AmministrazioneConvocante> _resAdm = AmministrazioneConvocanteLocalServiceUtil.findByKeywordAdmin(keyword_lower_case);
		String previousPage = request.getParameter("previousPage");
		response.setRenderParameter("jspPage", "/gestioneConvocanti.jsp");
		String convocantititolo = request.getPreferences().getValue("convocantiRiunionetitle", _configuration.convocantiRiunionetitle());
		String convocantisottotitolo = request.getPreferences().getValue("convocantiRiunionetxt", _configuration.convocantiRiunionetxt());
		request.setAttribute("titleConvocantiRiunione", convocantititolo);
		request.setAttribute("subTitleConvocantiRiunione", convocantisottotitolo);
		request.setAttribute("risultatiAdm", _resAdm);
		request.setAttribute("previousPage", previousPage);
		request.setAttribute("keywordCercato", keyword);
		request.setAttribute(_idRiunioneAttribute, riunioneIdString);
	}
	
	public void paginaPrecedente(ActionRequest request, ActionResponse response) {
		String riunioneIdString = request.getParameter(_idRiunioneAttribute);
		if (request.getParameter("previousPage") != null && "inserimentoRiunione".equalsIgnoreCase(request.getParameter("previousPage"))) {
			response.setRenderParameter("jspPage", "/inserimentoRiunione.jsp");
			String luoghititolo = request.getPreferences().getValue("luoghiRiunionetitle", _configuration.luoghiRiunionetitle());
			String luoghisottotitolo = request.getPreferences().getValue("luoghiRiunionetxt", _configuration.luoghiRiunionetxt());
			String convocantititolo = request.getPreferences().getValue("convocantiRiunionetitle",
			_configuration.convocantiRiunionetitle());
			String convocantisottotitolo = request.getPreferences().getValue("convocantiRiunionetxt",
			_configuration.convocantiRiunionetxt());
			String inseriscitititolo = request.getPreferences().getValue("creaRiunionetitle", _configuration.creaRiunionetitle());
			String inseriscisottotitolo = request.getPreferences().getValue("creaRiunionetxt", _configuration.creaRiunionetxt());
			request.setAttribute("titleLuoghiRiunione", luoghititolo);
			request.setAttribute("subTitleLuoghiRiunione", luoghisottotitolo);
			request.setAttribute("titleConvocantiRiunione", convocantititolo);
			request.setAttribute("subTitleConvocantiRiunione", convocantisottotitolo);
			request.setAttribute("titleCreaRiunione", inseriscitititolo);
			request.setAttribute("subTitleCreaRiunione", inseriscisottotitolo);
		}
		if (request.getParameter("previousPage") != null && "modifyLuogo".equalsIgnoreCase(request.getParameter("previousPage"))) {
			request.setAttribute(_idRiunioneAttribute, riunioneIdString);
			request.setAttribute("mod", "modifica");
		}
		if (request.getParameter("previousPage") != null && "modifyDati".equalsIgnoreCase(request.getParameter("previousPage"))) {
			request.setAttribute(_idRiunioneAttribute, riunioneIdString);
			request.setAttribute("mod", "modifica");
		}
	}
	
	public void rimuoviLuogo(ActionRequest request, ActionResponse response) {
		String id_luogo = request.getParameter("luogo");
		String riunioneIdString = request.getParameter(_idRiunioneAttribute);
		if (id_luogo != null) {
			try {
				CancelLuogo luogo_logica = CancelLuogoLocalServiceUtil.getCancelLuogo(Long.parseLong(id_luogo));
				luogo_logica.setCancellato(true);
				CancelLuogoLocalServiceUtil.updateCancelLuogo(luogo_logica);
			} catch (NumberFormatException e) {
				_log.warn("impossibile convetire l'id del luogo in valore numerico nel metodo di cancellazione logica");
			} catch (PortalException e) {
				_log.warn(e);
			}
		}
		String previousPage = request.getParameter("previousPage");
		response.setRenderParameter("jspPage", "/gestioneLuoghi.jsp");
		String luoghititolo = request.getPreferences().getValue("luoghiRiunionetitle", _configuration.luoghiRiunionetitle());
		String luoghisottotitolo = request.getPreferences().getValue("luoghiRiunionetxt", _configuration.luoghiRiunionetxt());
		request.setAttribute("titleLuoghiRiunione", luoghititolo);
		request.setAttribute("subTitleLuoghiRiunione", luoghisottotitolo);
		request.setAttribute("previousPage", previousPage);
		request.setAttribute(_idRiunioneAttribute, riunioneIdString);
	}
	
	public void eliminaRiunione(ActionRequest request, ActionResponse response) {
		long idRiunione = Long.parseLong(request.getParameter("idRiunione"));
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Riunione riunioneEliminata = RiunioneLocalServiceUtil.fetchRiunione(idRiunione);
		boolean flagEliminata = false;
		if (riunioneEliminata != null) {
			List<StatoRiunione> listaStati = StatoRiunioneLocalServiceUtil.findByLabel("eliminata");
			if (listaStati != null && !listaStati.isEmpty()) {
				long statoeliminata = listaStati.get(0).getId_stato_riunione();
				riunioneEliminata.setId_stato_riunione(statoeliminata);
				Riunione riunioneaggiornata = RiunioneLocalServiceUtil.updateRiunione(riunioneEliminata);
				if (riunioneaggiornata.getId_stato_riunione() != statoeliminata) {
					SessionErrors.add(request, "Errore-durante-eliminazione-riunione");
				} else {
					flagEliminata = true;
				}
			} else {
				SessionErrors.add(request, "Errore-durante-eliminazione-riunione");
			}
		} else {
			SessionErrors.add(request, "Errore-durante-eliminazione-riunione");
		}
		if (!flagEliminata) {
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
		if (request.getParameter("flagRicerca") != null && "true".equalsIgnoreCase(request.getParameter("flagRicerca"))) {
			PortletURL renderUrlAction = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
			themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
			renderUrlAction.setParameter("javax.portlet.action", "ricerca");
			String da = "";
			if (request.getParameter("da") != null)
				da = request.getParameter("da");
			
			String a = "";
			if (request.getParameter("a") != null)
				a = request.getParameter("a");
			
			renderUrlAction.setParameter("da", da);
			renderUrlAction.setParameter("a", a);
			String statoSelected = "";
			if (request.getParameter("statoSelected") != null)
				statoSelected = request.getParameter("statoSelected");
			
			renderUrlAction.setParameter("statoSelected", statoSelected);
			String ispettorato = "";
			if (request.getParameter("ispettorato") != null)
				ispettorato = request.getParameter("ispettorato");
			
			renderUrlAction.setParameter("ispettorato", ispettorato);
			String parola_chiave = "";
			if (request.getParameter("parola_chiave") != null)
				parola_chiave = request.getParameter("parola_chiave");
			
			renderUrlAction.setParameter("parola_chiave", parola_chiave);
			try {
				response.sendRedirect(renderUrlAction.toString());
			} catch (IOException e) {
				_log.warn(e);
			}
		} else {
			if (flagEliminata) {
				PortletURL renderUrlRender = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				try {
					response.sendRedirect(renderUrlRender.toString());
				} catch (IOException e) {
					_log.warn(e);
				}
			}
		}
	}
	
	public void ricercaLuogo(ActionRequest request, ActionResponse response) {
		String riunioneIdString = request.getParameter("_idRiunioneAttribute");
		String keyword = request.getParameter("Keyword");
		String keyword_lower_case = keyword.toLowerCase();
		List<Luogo> _resLuogo = LuogoLocalServiceUtil.findByKeywordLuogo(keyword_lower_case);
		String previousPage = request.getParameter("previousPage");
		response.setRenderParameter("jspPage", "/gestioneLuoghi.jsp");
		String luoghititolo = request.getPreferences().getValue("luoghiRiunionetitle", _configuration.luoghiRiunionetitle());
		String luoghisottotitolo = request.getPreferences().getValue("luoghiRiunionetxt", _configuration.luoghiRiunionetxt());
		request.setAttribute("titleLuoghiRiunione", luoghititolo);
		request.setAttribute("subTitleLuoghiRiunione", luoghisottotitolo);
		request.setAttribute("risultatiLuogo", _resLuogo);
		request.setAttribute("previousPage", previousPage);
		request.setAttribute("keywordCercato", keyword);
		request.setAttribute(_idRiunioneAttribute, riunioneIdString);
	}
	
	public void rispostaInvitoRiunione(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException, PortalException, Exception {
		
		String idRiunioneByMail = actionRequest.getParameter(_idRiunioneAttribute);
		String idSegreteriaByMail = actionRequest.getParameter("idSegreteria");
		String partecipanti = actionRequest.getParameter("savePartecipanti");
		String commenti = actionRequest.getParameter("Commenti");
		long id_riunione = Long.parseLong(idRiunioneByMail);
		long id_segreteria = Long.parseLong(idSegreteriaByMail);
		String response = actionRequest.getParameter("responseInvite");
		InvitatiRiunionePK invitatiRiunionePK = new InvitatiRiunionePK();
		invitatiRiunionePK.setId_riunione(id_riunione);
		invitatiRiunionePK.setId_segreteria(id_segreteria);
		InvitatiRiunione invriun = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunione(invitatiRiunionePK);
		long stato_invitato_id = 2;
		if ("ACCETTA".equalsIgnoreCase(response)) {
			stato_invitato_id = 1;
			invriun.setId_stato_invitato(stato_invitato_id);
		} else {
			invriun.setId_stato_invitato(stato_invitato_id);
		}
		BeanCreator segr = new BeanCreator();
		Segreteria segreteria = segr.getSegreteria(invriun);
		StringBuilder jsonCapofila = new StringBuilder();
		jsonCapofila.append("{");
		if (segreteria.isCapofila()) {
			jsonCapofila.append("\"top\"");
			jsonCapofila.append(":");
			jsonCapofila.append("true");
			jsonCapofila.append(",");
		}
		jsonCapofila.append("\"pos\"");
		jsonCapofila.append(":");
		jsonCapofila.append(segreteria.getIndex());
		jsonCapofila.append(",");
		jsonCapofila.append("\"list\"");
		jsonCapofila.append(":");
		jsonCapofila.append(segr.getListaPartecipantiJSONforDB(partecipanti));
		jsonCapofila.append("}");
		invriun.setPartecipanti(jsonCapofila.toString());
		invriun.setNote(commenti);
		InvitatiRiunioneLocalServiceUtil.updateInvitatiRiunione(invriun);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
		PortletRequest.RENDER_PHASE);
		try {
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			actionResponse.sendRedirect(renderUrl.toString());
		} catch (Exception e) {
			_log.warn(e);
		}
	}
}
