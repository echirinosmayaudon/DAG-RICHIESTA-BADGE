package mef.prenotazione.aule.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
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
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import mef.prenotazione.aule.bean.LaTuaPrenotazioneBean;
import mef.prenotazione.aule.bean.ModuloPrenotazioneBean;
import mef.prenotazione.aule.bean.OrarioBean;
import mef.prenotazione.aule.bean.SalaBean;
import mef.prenotazione.aule.bean.SalaStrutturaBean;
import mef.prenotazione.aule.util.EmailSender;
import servizio.prenotazione.aule.mef.model.Approvatore;
import servizio.prenotazione.aule.mef.model.Orario;
import servizio.prenotazione.aule.mef.model.Prenotazione;
import servizio.prenotazione.aule.mef.model.Sala;
import servizio.prenotazione.aule.mef.model.SalaStruttura;
import servizio.prenotazione.aule.mef.model.ServizioLog;
import servizio.prenotazione.aule.mef.model.StatoAula;
import servizio.prenotazione.aule.mef.model.StrumentoEvento;
import servizio.prenotazione.aule.mef.model.StrumentoTec;
import servizio.prenotazione.aule.mef.model.TipoEvento;
import servizio.prenotazione.aule.mef.service.ApprovatoreLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.OrarioLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.PrenotazioneLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.SalaLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.SalaStrutturaLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.ServizioLogLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.StatoAulaLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.StrumentoEventoLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.StrumentoTecLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.TipoEventoLocalServiceUtil;
import servizio.prenotazione.aule.servizi.mef.model.ServLog;
import servizio.prenotazione.aule.servizi.mef.model.StrumEvento;
import servizio.prenotazione.aule.servizi.mef.model.StrumTec;
import servizio.prenotazione.aule.servizi.mef.service.ServLogLocalServiceUtil;
import servizio.prenotazione.aule.servizi.mef.service.StrumEventoLocalServiceUtil;
import servizio.prenotazione.aule.servizi.mef.service.StrumTecLocalServiceUtil;
import servizio.prenotazione.aule.servizi.mef.service.persistence.ServLogPK;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK;

import org.apache.commons.lang3.time.DateUtils;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=mef-prenotazione-aule-form Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class MefPrenotazioneAuleFormmvcportletPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(MefPrenotazioneAuleFormmvcportletPortlet.class);
	static final long ONE_MINUTE_IN_MILLIS = 60000;
	private User loginUser;
	private String loginUserEmail;
	private final String _customFieldUserOrg = "idOrgChart";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		populateOrarioTable();
		populateServizioLogTable();
		populateStrumentoEventoTable();
		populateStrumentoTecTable();
		populateTipoEventoTable();
		populateStatoAulaTable();

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		loginUser = themeDisplay.getUser();

		try {

			long id_ufficio;

			List<Sala> sale_list = new ArrayList<Sala>(0);
			
//				
			if (loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {
			
			id_ufficio = Long.parseLong((String) loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg));
				
			sale_list = SalaLocalServiceUtil.getSaleBySalaStrutturaList(SalaStrutturaLocalServiceUtil.getSaleListByIdStruttura(id_ufficio));
			}

			renderRequest.setAttribute("saleList", sale_list);

			boolean autorizzazione = false;

			for (Sala sala : sale_list) {
				if (sala.isAutorizzazione()) {
					autorizzazione = true;
					break;
				}
			}

			renderRequest.setAttribute("autorizzazione", autorizzazione);

			List<Orario> ore_list = OrarioLocalServiceUtil.getOrarios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			renderRequest.setAttribute("oreListInizio", ore_list.subList(0, ore_list.size() - 1));
			renderRequest.setAttribute("oreListFine", ore_list.subList(1, ore_list.size()));

			List<StatoAula> stati_list = StatoAulaLocalServiceUtil.getStatoAulas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			renderRequest.setAttribute("statiList", stati_list);

			boolean userApprovatore = false;

			for (Role role : themeDisplay.getUser().getRoles()) {
				if (("approvatoreSale").equalsIgnoreCase(role.getName())) {
					userApprovatore = true;
				}
			}

			renderRequest.setAttribute("approvatore", userApprovatore);

			if (renderRequest.getParameter("prenotazione_Id") != null
					&& renderRequest.getParameter("navigation") != null
					&& ("dettaglioPrenotazione").equals((String) renderRequest.getParameter("navigation"))) {
				renderRequest.setAttribute("prenotazione_Id",
						Long.parseLong((String) renderRequest.getParameter("prenotazione_Id")));
			}

		} catch (Exception e) {
			_log.warn(e);
		}

		renderRequest.setAttribute(MefPrenotazioneAuleConfig.class.getName(), _configuration);
		super.doView(renderRequest, renderResponse);

	}

	@ProcessAction(name = "ricercaAule")
	public void ricercaAula(ActionRequest request, ActionResponse response)
			throws PortalException, ParseException, java.text.ParseException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		loginUser = themeDisplay.getUser();
		long id_ufficio;
		List<Long> lista_id_sale_selezionate = new ArrayList<Long>(0);
		List<String> filtriRicerca = new ArrayList<String>(0);

		if (loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {
			if (request.getParameter("sala-select") != null && ("").equals(request.getParameter("sala-select"))) {
				id_ufficio = Long.parseLong((String) loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg));
				for (Sala sala : SalaLocalServiceUtil.getSaleBySalaStrutturaList(
						SalaStrutturaLocalServiceUtil.getSaleListByIdStruttura(id_ufficio))) {
					lista_id_sale_selezionate.add(sala.getId_sala());
				}
				filtriRicerca.add("tutte");
			} else if (request.getParameter("sala-select") != null
					&& !("").equals(request.getParameter("sala-select"))) {
				lista_id_sale_selezionate.add(Long.parseLong(request.getParameter("sala-select")));
				filtriRicerca.add(SalaLocalServiceUtil.getSala(Long.parseLong(request.getParameter("sala-select")))
						.getDesc_sala());
			}
		}

		String data = null;
		if (request.getParameter("data-input") != null) {
			data = request.getParameter("data-input");
			filtriRicerca.add(request.getParameter("data-input"));
		}

		String ora_inizio = "07:00";
		if (request.getParameter("ora-inizio-select") != null
				&& !("").equals(request.getParameter("ora-inizio-select"))) {
			ora_inizio = request.getParameter("ora-inizio-select");
			filtriRicerca.add(request.getParameter("ora-inizio-select"));
		}

		String ora_fine = "20:00";
		if (request.getParameter("ora-fine-select") != null && !("").equals(request.getParameter("ora-fine-select"))) {
			ora_fine = request.getParameter("ora-fine-select");
			filtriRicerca.add(request.getParameter("ora-fine-select"));
		}

		SimpleDateFormat parserData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		StringBuilder data_ora_inizio = new StringBuilder();
		data_ora_inizio.append(data);
		data_ora_inizio.append(" ");
		data_ora_inizio.append(ora_inizio);
		StringBuilder data_ora_fine = new StringBuilder();
		data_ora_fine.append(data);
		data_ora_fine.append(" ");
		data_ora_fine.append(ora_fine);

		Date dInizio = new Date();
		Date dFine = new Date();
		StringBuilder formatDate = null;
		if (data != null) {
			dInizio = parserData.parse(data_ora_inizio.toString());
			dFine = parserData.parse(data_ora_fine.toString());
			int minutiCorretti = dFine.getMinutes() - 1;
			dFine.setMinutes(minutiCorretti);
			formatDate = new StringBuilder(data);
			formatDate.setCharAt(2, '.');
			formatDate.setCharAt(5, '.');
		}

		long id_stato = 0;
		if (request.getParameter("stato_richiesta") != null) {
			id_stato = Long.parseLong(request.getParameter("stato_richiesta").trim());
			filtriRicerca.add(StatoAulaLocalServiceUtil.getStatoAula(id_stato).getDesc_stato());
		}

		List<Prenotazione> risultati_prenotazioni = PrenotazioneLocalServiceUtil
				.getPrenotazioniByFilters(lista_id_sale_selezionate, dInizio, dFine, id_stato);

		JSONArray jsonArrayItems = getJSONArrayOfResults(risultati_prenotazioni, lista_id_sale_selezionate, formatDate,
				dInizio, dFine, id_stato, themeDisplay);

		request.setAttribute("filtriRicercaRichieste", filtriRicerca);
		request.setAttribute("jsonRisultati", jsonArrayItems.toString());
	}

	public JSONArray getJSONArrayOfResults(List<Prenotazione> lista_prenotazioni_totale,
			List<Long> lista_id_sale_selezionate, StringBuilder formatDate, Date dInizio, Date dFine, long id_stato,
			ThemeDisplay themeDisplay) throws PortalException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		SimpleDateFormat parserOrario = new SimpleDateFormat("HH:mm");
		Map<Long, List<Prenotazione>> prenotazioniMap = new HashMap<Long, List<Prenotazione>>();
		List<Long> lista_id_sale_prenotate = new ArrayList<Long>(0);
		List<Sala> lista_sale_libere = new ArrayList<Sala>(0);
		List<Sala> lista_sale_selezionate = new ArrayList<Sala>(0);

		for (Prenotazione prenotazione : lista_prenotazioni_totale) {
			if (!lista_id_sale_prenotate.contains(prenotazione.getId_sala())) {
				lista_id_sale_prenotate.add(prenotazione.getId_sala());
			}
			List<Prenotazione> id_sala = prenotazioniMap.get(prenotazione.getId_sala());

			if (id_sala == null) {
				id_sala = new ArrayList<Prenotazione>(0);
				prenotazioniMap.put(prenotazione.getId_sala(), id_sala);
			}
			id_sala.add(prenotazione);
		}

		if ((id_stato == 0 || id_stato == 1) && lista_id_sale_selezionate.size() > 1) {

			for (Long id_sala_selezionata : lista_id_sale_selezionate) {
				lista_sale_selezionate.add(SalaLocalServiceUtil.getSala(id_sala_selezionata));
			}
			for (Sala sala_selezionata : lista_sale_selezionate) {
				if (!lista_id_sale_prenotate.contains(sala_selezionata.getId_sala())) {
					lista_sale_libere.add(sala_selezionata);
				}

			}

			if (!lista_sale_libere.isEmpty()) {
				for (Sala sala_libera : lista_sale_libere) {
					JSONObject jsonItemSalaDisponibile = JSONFactoryUtil.createJSONObject();
					jsonItemSalaDisponibile.put("data", formatDate);
					StringBuilder rangeOrarioDisponibile = new StringBuilder();
					rangeOrarioDisponibile.append(parserOrario.format(dInizio.getTime()));
					rangeOrarioDisponibile.append(" - ");
					rangeOrarioDisponibile.append(parserOrario.format(dFine.getTime() + ONE_MINUTE_IN_MILLIS));
					jsonItemSalaDisponibile.put("rangeorario", rangeOrarioDisponibile.toString());
					jsonItemSalaDisponibile.put("nome", sala_libera.getDesc_sala());
					StringBuilder indirizzoSala = new StringBuilder();
					indirizzoSala.append(sala_libera.getIndirizzo() + ",");
					indirizzoSala.append(" ");
					indirizzoSala.append("Piano");
					indirizzoSala.append(" ");
					indirizzoSala.append(sala_libera.getPiano() + ",");
					indirizzoSala.append(" ");
					indirizzoSala.append("Stanza " + sala_libera.getStanza());
					jsonItemSalaDisponibile.put("sede", indirizzoSala.toString());
					jsonItemSalaDisponibile.put("numeroposti", sala_libera.getPosti());
					jsonItemSalaDisponibile.put("stato", "disponibile");
					jsonArray.put(jsonItemSalaDisponibile);
				}
			}

		}

		if ((id_stato == 0 || id_stato == 1) && lista_id_sale_selezionate.size() == 1) {
			if (!lista_id_sale_prenotate.contains(lista_id_sale_selezionate.get(0))) {
				lista_sale_libere.add(SalaLocalServiceUtil.getSala(lista_id_sale_selezionate.get(0)));
			}
			if (!lista_sale_libere.isEmpty()) {
				for (Sala sala_libera : lista_sale_libere) {
					JSONObject jsonItemSalaDisponibile = JSONFactoryUtil.createJSONObject();
					jsonItemSalaDisponibile.put("data", formatDate);
					StringBuilder rangeOrarioDisponibile = new StringBuilder();
					rangeOrarioDisponibile.append(parserOrario.format(dInizio.getTime()));
					rangeOrarioDisponibile.append(" - ");
					rangeOrarioDisponibile.append(parserOrario.format(dFine.getTime() + ONE_MINUTE_IN_MILLIS));
					jsonItemSalaDisponibile.put("rangeorario", rangeOrarioDisponibile.toString());
					jsonItemSalaDisponibile.put("nome", sala_libera.getDesc_sala());
					StringBuilder indirizzoSala = new StringBuilder();
					indirizzoSala.append(sala_libera.getIndirizzo() + ",");
					indirizzoSala.append(" ");
					indirizzoSala.append("Piano");
					indirizzoSala.append(" ");
					indirizzoSala.append(sala_libera.getPiano() + ",");
					indirizzoSala.append(" ");
					indirizzoSala.append("Stanza " + sala_libera.getStanza());
					jsonItemSalaDisponibile.put("sede", indirizzoSala.toString());
					jsonItemSalaDisponibile.put("numeroposti", sala_libera.getPosti());
					jsonItemSalaDisponibile.put("stato", "disponibile");
					jsonArray.put(jsonItemSalaDisponibile);
				}
			}

		}

		for (Entry<Long, List<Prenotazione>> key : prenotazioniMap.entrySet()) {
			if (!key.getValue().isEmpty()) {
				for (int i = 0; i < key.getValue().size(); i++) {
					Prenotazione prenotazione = key.getValue().get(i);
					if (prenotazione.getId_stato() != 4) {
						if (id_stato == 0 || id_stato == 1) {

							if (key.getValue().size() == 1
									&& prenotazione.getData_inizio().getTime() > dInizio.getTime()) {
								JSONObject jsonItemSalaDisponibile = JSONFactoryUtil.createJSONObject();
								jsonItemSalaDisponibile.put("data", formatDate);
								StringBuilder rangeOrarioDisponibile = new StringBuilder();
								rangeOrarioDisponibile.append(parserOrario.format(dInizio.getTime()));
								rangeOrarioDisponibile.append(" - ");
								rangeOrarioDisponibile
										.append(parserOrario.format(prenotazione.getData_inizio().getTime()));
								jsonItemSalaDisponibile.put("rangeorario", rangeOrarioDisponibile.toString());
								jsonItemSalaDisponibile.put("nome",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getDesc_sala());
								StringBuilder indirizzoSala = new StringBuilder();
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getIndirizzo() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Piano");
								indirizzoSala.append(" ");
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPiano() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Stanza "
										+ SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getStanza());
								jsonItemSalaDisponibile.put("sede", indirizzoSala.toString());
								jsonItemSalaDisponibile.put("numeroposti",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPosti());
								jsonItemSalaDisponibile.put("stato", "disponibile");
								jsonArray.put(jsonItemSalaDisponibile);
							}

							if (key.getValue().size() > 1 && i == 0
									&& prenotazione.getData_inizio().getTime() > dInizio.getTime()
									&& prenotazione.getData_fine().getTime() < dFine.getTime() - ONE_MINUTE_IN_MILLIS) {
								JSONObject jsonItemSalaDisponibile = JSONFactoryUtil.createJSONObject();
								jsonItemSalaDisponibile.put("data", formatDate);
								StringBuilder rangeOrarioDisponibile = new StringBuilder();
								rangeOrarioDisponibile.append(parserOrario.format(dInizio.getTime()));
								rangeOrarioDisponibile.append(" - ");
								rangeOrarioDisponibile
										.append(parserOrario.format(prenotazione.getData_inizio().getTime()));
								jsonItemSalaDisponibile.put("rangeorario", rangeOrarioDisponibile.toString());
								jsonItemSalaDisponibile.put("nome",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getDesc_sala());
								StringBuilder indirizzoSala = new StringBuilder();
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getIndirizzo() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Piano");
								indirizzoSala.append(" ");
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPiano() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Stanza "
										+ SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getStanza());
								jsonItemSalaDisponibile.put("sede", indirizzoSala.toString());
								jsonItemSalaDisponibile.put("numeroposti",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPosti());
								jsonItemSalaDisponibile.put("stato", "disponibile");
								jsonArray.put(jsonItemSalaDisponibile);
							}
						}

						if (id_stato != 1) {

							JSONObject jsonItemSalaOccupata = JSONFactoryUtil.createJSONObject();
							jsonItemSalaOccupata.put("data", formatDate);
							StringBuilder rangeOrario = new StringBuilder();
							if (prenotazione.getData_inizio().getTime() < dInizio.getTime()) {
								rangeOrario.append(parserOrario.format(dInizio.getTime()));
							} else {
								rangeOrario.append(parserOrario.format(prenotazione.getData_inizio().getTime()));
							}
							rangeOrario.append(" - ");
							if (prenotazione.getData_fine().getTime() > dFine.getTime()) {
								rangeOrario.append(parserOrario.format(dFine.getTime() + ONE_MINUTE_IN_MILLIS));
							} else {
								rangeOrario.append(parserOrario
										.format(prenotazione.getData_fine().getTime() + ONE_MINUTE_IN_MILLIS));
							}
							jsonItemSalaOccupata.put("rangeorario", rangeOrario.toString());
							jsonItemSalaOccupata.put("nome",
									SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getDesc_sala());
							StringBuilder indirizzoSala = new StringBuilder();
							indirizzoSala.append(
									SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getIndirizzo() + ",");
							indirizzoSala.append(" ");
							indirizzoSala.append("Piano");
							indirizzoSala.append(" ");
							indirizzoSala
									.append(SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPiano() + ",");
							indirizzoSala.append(" ");
							indirizzoSala.append(
									"Stanza " + SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getStanza());
							jsonItemSalaOccupata.put("sede", indirizzoSala.toString());
							jsonItemSalaOccupata.put("numeroposti",
									SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPosti());
							jsonItemSalaOccupata.put("stato",
									StatoAulaLocalServiceUtil.getStatoAula(prenotazione.getId_stato()).getDesc_stato());
							if (("prenotata").equalsIgnoreCase(StatoAulaLocalServiceUtil
									.getStatoAula(prenotazione.getId_stato()).getDesc_stato().toString())) {
								JSONObject jsonDatiRichiedente = JSONFactoryUtil
										.createJSONObject(prenotazione.getDati_rich());
								jsonItemSalaOccupata.put("utenterichiedente",
										jsonDatiRichiedente.getString("utenterichiedente"));
								jsonItemSalaOccupata.put("utenteemailrichiedente",
										jsonDatiRichiedente.getString("utenteemailrichiedente"));
								jsonItemSalaOccupata.put("telefonorichiedente",
										jsonDatiRichiedente.getString("telefonorichiedente"));
							}
							jsonArray.put(jsonItemSalaOccupata);
						}

						if (id_stato == 0 || id_stato == 1) {

							if (key.getValue().size() > 1 && i < key.getValue().size() - 1 && prenotazione
									.getData_fine().getTime() + ONE_MINUTE_IN_MILLIS < key.getValue().get(i + 1).getData_inizio().getTime()) {
								JSONObject jsonItemSalaDisponibile = JSONFactoryUtil.createJSONObject();
								jsonItemSalaDisponibile.put("data", formatDate);
								StringBuilder rangeOrarioDisponibile = new StringBuilder();
								rangeOrarioDisponibile.append(parserOrario
										.format(prenotazione.getData_fine().getTime() + ONE_MINUTE_IN_MILLIS));
								rangeOrarioDisponibile.append(" - ");
								rangeOrarioDisponibile.append(
										parserOrario.format(key.getValue().get(i + 1).getData_inizio().getTime()));
								jsonItemSalaDisponibile.put("rangeorario", rangeOrarioDisponibile.toString());
								jsonItemSalaDisponibile.put("nome",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getDesc_sala());
								StringBuilder indirizzoSala = new StringBuilder();
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getIndirizzo() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Piano");
								indirizzoSala.append(" ");
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPiano() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Stanza "
										+ SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getStanza());
								jsonItemSalaDisponibile.put("sede", indirizzoSala.toString());
								jsonItemSalaDisponibile.put("numeroposti",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPosti());
								jsonItemSalaDisponibile.put("stato", "disponibile");
								jsonArray.put(jsonItemSalaDisponibile);
							}

							if (key.getValue().size() > 1 && i == key.getValue().size() - 1
									&& prenotazione.getData_fine().getTime() + ONE_MINUTE_IN_MILLIS < dFine.getTime()
									&& prenotazione.getData_inizio().getTime() > dInizio.getTime()) {
								JSONObject jsonItemSalaDisponibile = JSONFactoryUtil.createJSONObject();
								jsonItemSalaDisponibile.put("data", formatDate);
								StringBuilder rangeOrarioDisponibile = new StringBuilder();
								rangeOrarioDisponibile.append(parserOrario
										.format(prenotazione.getData_fine().getTime() + ONE_MINUTE_IN_MILLIS));
								rangeOrarioDisponibile.append(" - ");
								rangeOrarioDisponibile
										.append(parserOrario.format(dFine.getTime() + ONE_MINUTE_IN_MILLIS));
								jsonItemSalaDisponibile.put("rangeorario", rangeOrarioDisponibile.toString());
								jsonItemSalaDisponibile.put("nome",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getDesc_sala());
								StringBuilder indirizzoSala = new StringBuilder();
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getIndirizzo() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Piano");
								indirizzoSala.append(" ");
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPiano() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Stanza "
										+ SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getStanza());
								jsonItemSalaDisponibile.put("sede", indirizzoSala.toString());
								jsonItemSalaDisponibile.put("numeroposti",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPosti());
								jsonItemSalaDisponibile.put("stato", "disponibile");
								jsonArray.put(jsonItemSalaDisponibile);
							}

							if (key.getValue().size() == 1
									&& prenotazione.getData_fine().getTime() + ONE_MINUTE_IN_MILLIS < dFine.getTime()) {
								JSONObject jsonItemSalaDisponibile = JSONFactoryUtil.createJSONObject();
								jsonItemSalaDisponibile.put("data", formatDate);
								StringBuilder rangeOrarioDisponibile = new StringBuilder();
								rangeOrarioDisponibile.append(parserOrario
										.format(prenotazione.getData_fine().getTime() + ONE_MINUTE_IN_MILLIS));
								rangeOrarioDisponibile.append(" - ");
								rangeOrarioDisponibile
										.append(parserOrario.format(dFine.getTime() + ONE_MINUTE_IN_MILLIS));
								jsonItemSalaDisponibile.put("rangeorario", rangeOrarioDisponibile.toString());
								jsonItemSalaDisponibile.put("nome",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getDesc_sala());
								StringBuilder indirizzoSala = new StringBuilder();
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getIndirizzo() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Piano");
								indirizzoSala.append(" ");
								indirizzoSala.append(
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPiano() + ",");
								indirizzoSala.append(" ");
								indirizzoSala.append("Stanza "
										+ SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getStanza());
								jsonItemSalaDisponibile.put("sede", indirizzoSala.toString());
								jsonItemSalaDisponibile.put("numeroposti",
										SalaLocalServiceUtil.getSala(prenotazione.getId_sala()).getPosti());
								jsonItemSalaDisponibile.put("stato", "disponibile");
								jsonArray.put(jsonItemSalaDisponibile);

							}
						}
					}
				}
			}
		}

		return jsonArray;

	}

	public void insertPrenotazione(ActionRequest request, ActionResponse response) throws WindowStateException,
			PortletModeException, PortalException, ParseException, java.text.ParseException, IOException {

		List<ServizioLog> servizioLogistici = (List<ServizioLog>) ServizioLogLocalServiceUtil
				.getServizioLogs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoEvento> servizioEventi = (List<StrumentoEvento>) StrumentoEventoLocalServiceUtil
				.getStrumentoEventos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoTec> servizioTec = (List<StrumentoTec>) StrumentoTecLocalServiceUtil
				.getStrumentoTecs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<TipoEvento> tipoEvento = (List<TipoEvento>) TipoEventoLocalServiceUtil.getTipoEventos(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		String dataDiPrenotazione = request.getParameter("dataDiPrenotazione");
		String data = request.getParameter("data");
		String oraInizio = request.getParameter("oraInizio");
		String oraFine = request.getParameter("oraFine");
		String salaRiunione = request.getParameter("salaRiunione");
		String IdTipoEvento = request.getParameter("tipoEvent");
		String oggetto = request.getParameter("oggetto");
		String numeroPartecipanti = request.getParameter("numeroPartecipanti");
		String ufficioRichiedente = request.getParameter("ufficioRichidente");
		String ufficioDirigente = request.getParameter("ufficioDirigente");
		String utenteRichiedente = request.getParameter("nomeUtenteRichiedente");
		String telefonoRichiedente = request.getParameter("telefonoRichiedente");
		String utenteReferente = request.getParameter("utenteReferente");
		String telefonoReferente = request.getParameter("telefonoReferente");
		String[] serviziLogistici = request.getParameterValues("serviziLogistici");
		String[] strumentazioneEventi = request.getParameterValues("strumentazioneEventi");
		String idSala = request.getParameter("idSala");
		String jsonDatiRichiedenti = request.getParameter("jsonRichiedente");
		String[] servizitec = request.getParameterValues("strumentazioneTecnici");
		String note = null;

		if (request.getParameter("note") != null) {
			note = request.getParameter("note");
		}

		long oraInizioSalaPrenota = Long.parseLong(oraInizio);
		long oraFineSalaPrenota = Long.parseLong(oraFine);
		int id_Sala = Integer.parseInt(idSala);
		int id_TipoEvento = Integer.parseInt(IdTipoEvento);
		int numero_Partecipanti = Integer.parseInt(numeroPartecipanti);

		oraInizio = OrarioLocalServiceUtil.getOrario(oraInizioSalaPrenota).getOre();
		oraFine = OrarioLocalServiceUtil.getOrario(oraFineSalaPrenota).getOre();
		SimpleDateFormat parserOraFine = new SimpleDateFormat("HH:mm");
		Date dataOraFine = parserOraFine.parse(oraFine);
		int minutiCorretti = dataOraFine.getMinutes() - 1;
		dataOraFine.setMinutes(minutiCorretti);
		oraFine = parserOraFine.format(dataOraFine);
		Date dataOraFineEmail = parserOraFine.parse(oraFine);
		int minutiCorrettiEmail = dataOraFineEmail.getMinutes() + 1;
		dataOraFineEmail.setMinutes(minutiCorrettiEmail);
		String oraFineEmail = parserOraFine.format(dataOraFineEmail);

		StringBuilder dataOraInizioPrenotazione = new StringBuilder();
		dataOraInizioPrenotazione.append(data);
		dataOraInizioPrenotazione.append(" ");
		dataOraInizioPrenotazione.append(oraInizio);

		StringBuilder dataOraFinePrenotazione = new StringBuilder();
		dataOraFinePrenotazione.append(data);
		dataOraFinePrenotazione.append(" ");
		dataOraFinePrenotazione.append(oraFine);

		StringBuilder oraInizioFinePrenotazione = new StringBuilder();
		oraInizioFinePrenotazione.append(oraInizio);
		oraInizioFinePrenotazione.append(" - ");
		oraInizioFinePrenotazione.append(oraFineEmail);

		String oraInizioFinePerEmail = oraInizioFinePrenotazione.toString();

		SimpleDateFormat parserDataOraInizio = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dataInizioOraInizioPrenotazione = parserDataOraInizio.parse(dataOraInizioPrenotazione.toString());
		SimpleDateFormat parserDataOraFine = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date dataFineOraFinePrenotazione = parserDataOraFine.parse(dataOraFinePrenotazione.toString());

		List<String> listServiziTecnici = new ArrayList<String>(0);
		List<Long> listServiziTecniciId = new ArrayList<Long>(0);
		List<String> listNomeServizioTecnici = new ArrayList<String>(0);

		List<String> listServiziEventi = new ArrayList<String>(0);
		List<Long> listServiziEventiId = new ArrayList<Long>(0);
		List<String> listNomeServizioEventi = new ArrayList<String>(0);

		List<String> listServiziLogistici = new ArrayList<String>(0);
		List<Long> listServiziLogisticiId = new ArrayList<Long>(0);
		List<String> listNomeServizioLogistici = new ArrayList<String>(0);

		if (servizitec != null && servizitec.length > 0) {
			listServiziTecnici = Arrays.asList(servizitec);
		}

		if (strumentazioneEventi != null && strumentazioneEventi.length > 0) {
			listServiziEventi = Arrays.asList(strumentazioneEventi);
		}

		if (serviziLogistici != null && serviziLogistici.length > 0) {
			listServiziLogistici = Arrays.asList(serviziLogistici);
		}

		if (listServiziTecnici != null && !listServiziTecnici.isEmpty()) {
			/*
			 * creating list of name of technical services and id of each
			 * service
			 */
			for (int i = 0; i < listServiziTecnici.size(); i++) {
				listServiziTecniciId.add(Long.parseLong(listServiziTecnici.get(i)));
				listNomeServizioTecnici.add(StrumentoTecLocalServiceUtil
						.getStrumentoTec(Long.parseLong(listServiziTecnici.get(i))).getDesc_strumento().toLowerCase());
			}
		}

		if (listServiziEventi != null && !listServiziEventi.isEmpty()) {
			/*
			 * creating list of name of instruments for event services and id of
			 * each service
			 */
			for (int indexListServiziEventi = 0; indexListServiziEventi < listServiziEventi
					.size(); indexListServiziEventi++) {
				listServiziEventiId.add(Long.parseLong(listServiziEventi.get(indexListServiziEventi)));
				listNomeServizioEventi.add(StrumentoEventoLocalServiceUtil
						.getStrumentoEvento(Long.parseLong(listServiziEventi.get(indexListServiziEventi)))
						.getDesc_strumento().toLowerCase());
			}
		}

		if (listServiziLogistici != null && !listServiziLogistici.isEmpty()) {
			/*
			 * creating list of name of logistic services and id of each service
			 */
			for (int i = 0; i < listServiziLogistici.size(); i++) {
				listServiziLogisticiId.add(Long.parseLong(listServiziLogistici.get(i)));
				listNomeServizioLogistici.add(ServizioLogLocalServiceUtil
						.getServizioLog(Long.parseLong(listServiziLogistici.get(i))).getDesc_servizio().toLowerCase());
			}
		}

		JSONObject jsonServizi = JSONFactoryUtil.createJSONObject();

		jsonServizi.put("strumentazionetecnica", listNomeServizioTecnici);
		jsonServizi.put("strumentazionetecnicaevento", listNomeServizioEventi);
		jsonServizi.put("servizilogistici", listNomeServizioLogistici);

		String jsonServiziAggiuntivi = jsonServizi.toString();

		ModuloPrenotazioneBean modulePrenotazioneBean = new ModuloPrenotazioneBean();

		String tipoEventoPerEmail = TipoEventoLocalServiceUtil.getTipoEvento(id_TipoEvento).getDesc_evento();
		Sala autorizzazione = SalaLocalServiceUtil.getSala(id_Sala);

		String nomeSalaPerEmail = autorizzazione.getDesc_sala();
		String indirizzoSalaPerEmail = autorizzazione.getIndirizzo();

		StringBuilder nomeIndirizzoSalaPerEmail = new StringBuilder();
		nomeIndirizzoSalaPerEmail.append(nomeSalaPerEmail);
		nomeIndirizzoSalaPerEmail.append(" - ");
		nomeIndirizzoSalaPerEmail.append(indirizzoSalaPerEmail);

		String informazioneSalaPerEmail = nomeIndirizzoSalaPerEmail.toString();

		boolean autorizzazioneSala = autorizzazione.getAutorizzazione();
		int autorizzazioneSale = (autorizzazioneSala) ? 1 : 0;

		String datiRichiedente = getHtmlDatiMailRichiedente(ufficioRichiedente, ufficioDirigente, utenteRichiedente,
				telefonoRichiedente, utenteReferente, telefonoReferente);
		String datiRichieste = getHtmlDatiMailRichiesta(informazioneSalaPerEmail, tipoEventoPerEmail, data,
				oraInizioFinePerEmail, numeroPartecipanti, oggetto, note, listNomeServizioTecnici,
				listNomeServizioEventi, listNomeServizioLogistici);

		Prenotazione prenotazione = PrenotazioneLocalServiceUtil.insertPrenotazione();

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		loginUserEmail = themeDisplay.getUser().getEmailAddress();
		PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setPortletMode(LiferayPortletMode.VIEW);
		renderUrl.setParameter("prenotazioneId", Long.toString(prenotazione.getId_prenota()));
		renderUrl.setParameter("navigation", "linkdettaglio");
		String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		String sender = request.getPreferences().getValue("sender", _configuration.sender());
		EmailSender mail = new EmailSender();

		List<Long> lista_id_sale_selezionate = new ArrayList<Long>(0);
		lista_id_sale_selezionate.add((long) id_Sala);
		List<Prenotazione> prenotazioni = PrenotazioneLocalServiceUtil.getPrenotazioniByFilters(
				lista_id_sale_selezionate, dataInizioOraInizioPrenotazione, dataFineOraFinePrenotazione, 0);

		boolean resultEmail = false;
		String subject;
		String mailbody;

		/*
		 * creating list of referent people email addresses (of sala and
		 * services)
		 */
		List<String> referentiEmailList = getReferentiEmailList(listServiziTecnici, listServiziEventi,
				listServiziLogistici, idSala);

		if (prenotazioni.isEmpty()) {

			if (autorizzazioneSale == 1) {

				subject = request.getPreferences().getValue("subject", _configuration.subjectApprovazione());
				mailbody = request.getPreferences().getValue("richiestaApprovazioneTmpl",
						_configuration.richiestaApprovazioneTmpl());
				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]", "[$LINK$]" },
						new String[] { datiRichiedente, datiRichieste, renderUrl.toString() });

				List<Approvatore> listEmailApprovatori = (List<Approvatore>) ApprovatoreLocalServiceUtil
						.getApprovatoriListByIdSala(id_Sala);

				Set<String> listEmailApprovatoriSala = new HashSet<String>(0);

				for (Approvatore approvatore : listEmailApprovatori) {
					listEmailApprovatoriSala.add(approvatore.getEmail_approvatore());
				}

				// Send email to listEmailApprovatoriSala
				for (String approvatore : listEmailApprovatoriSala) {
					if (!mail.sendMailMessage(subject, mailbody, sender, smtpUser, approvatore) && resultEmail) {
						resultEmail = true;
					}
				}

				// Send email to applicant (richiedente)
				resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, loginUserEmail);

				// Send email to referentiEmailList
				if (referentiEmailList != null && !referentiEmailList.isEmpty()) {
					for (String emailReferenteAddress : referentiEmailList) {
						resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferenteAddress);
					}
				}

			} else {

				subject = request.getPreferences().getValue("subject", _configuration.subjectNoApprovazione());
				mailbody = request.getPreferences().getValue("richiestaNoApprovazioneTmpl",
						_configuration.richiestaNoApprovazioneTmpl());
				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]", "[$LINK$]" },
						new String[] { datiRichiedente, datiRichieste, renderUrl.toString() });

				resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, loginUserEmail);

				if (referentiEmailList != null && !referentiEmailList.isEmpty()) {
					for (String emailReferenteAddress : referentiEmailList) {
						resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferenteAddress);
					}
				}
			}
		}

		if (resultEmail == true) {

			User user = themeDisplay.getUser();
			String screenName = user.getScreenName();
			Date insertDate = new Date();
			prenotazione.setId_sala(id_Sala);
			prenotazione.setCod_fiscale(screenName.toLowerCase());
			prenotazione.setData_prenota(insertDate);
			prenotazione.setData_inizio(dataInizioOraInizioPrenotazione);
			prenotazione.setData_fine(dataFineOraFinePrenotazione);
			prenotazione.setPartecipanti(numero_Partecipanti);
			prenotazione.setId_evento(id_TipoEvento);
			prenotazione.setAttivita(oggetto);
			prenotazione.setNote(note);

			if (autorizzazioneSale == 0) {
				prenotazione.setId_stato(2);
			} else {
				prenotazione.setId_stato(3);
			}

			prenotazione.setDati_rich(jsonDatiRichiedenti.toLowerCase());
			prenotazione.setServizi(jsonServiziAggiuntivi);
			PrenotazioneLocalServiceUtil.updatePrenotazione(prenotazione);
			String navigation = "dettaglioPrenotazione";
			PortletURL urlRefresh = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			urlRefresh.setParameter("prenotazione_Id", String.valueOf(prenotazione.getId_prenota()));
			urlRefresh.setParameter("navigation", navigation);
			response.sendRedirect(urlRefresh.toString());

		} else {

			SessionErrors.add(request, "Errore-durante-invio-email");
			SessionMessages.add(request,
					PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

			List<Orario> orarioList = (List<Orario>) OrarioLocalServiceUtil.findByIdOreListOre(oraInizioSalaPrenota,
					oraFineSalaPrenota);
			List<OrarioBean> orariBean = new ArrayList<OrarioBean>(0);

			for (Orario ora : orarioList) {
				orariBean.add(new OrarioBean(Long.toString(ora.getId_ora()), ora.getOre()));
			}

			modulePrenotazioneBean.setUfficioRichiedente(ufficioRichiedente);
			modulePrenotazioneBean.setDataDiPrenotazione(dataDiPrenotazione);
			modulePrenotazioneBean.setData(data);
			modulePrenotazioneBean.setSala(salaRiunione);
			modulePrenotazioneBean.setNote(note);
			modulePrenotazioneBean.setAttivita_OggettoPrenotazione(oggetto);
			modulePrenotazioneBean.setNumeroPartecipanti(numeroPartecipanti);
			modulePrenotazioneBean.setDirigenteUfficio(ufficioDirigente);
			modulePrenotazioneBean.setUtenteReferente(utenteReferente);
			modulePrenotazioneBean.setUtenteRichiedente(utenteRichiedente);
			modulePrenotazioneBean.setTelefonoReferente(telefonoReferente);
			modulePrenotazioneBean.setTelefonoRichiedente(telefonoRichiedente);
			modulePrenotazioneBean.setServizioLogistici(servizioLogistici);
			modulePrenotazioneBean.setStrumentazioneEventi(servizioEventi);
			modulePrenotazioneBean.setStrumentazioneTecnica(servizioTec);
			modulePrenotazioneBean.setTipologiaEvento(tipoEvento);
			modulePrenotazioneBean.setOrari(orariBean);

			request.setAttribute("oraInizioSalaPrenota", oraInizioSalaPrenota);
			request.setAttribute("oraFineSalaPrenota", oraFineSalaPrenota);
			request.setAttribute("id_TipoEvento", id_TipoEvento);
			request.setAttribute("currentUserEmail", loginUserEmail);
			request.setAttribute("listServiziLogisticiId", listServiziLogisticiId);
			request.setAttribute("listServiziEventiId", listServiziEventiId);
			request.setAttribute("idSala", idSala);
			request.setAttribute("listServiziTecniciId", listServiziTecniciId);
			request.setAttribute("moduloPrenotazioneBean", modulePrenotazioneBean);
			request.setAttribute("navigation", "prenotaAula");
			request.setAttribute("errormessage", "errormessage");
		}
	}

	public void updatePrenotazione(ActionRequest request, ActionResponse response) throws IOException {

		List<ServizioLog> servizioLogistici = (List<ServizioLog>) ServizioLogLocalServiceUtil
				.getServizioLogs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoEvento> servizioEventi = (List<StrumentoEvento>) StrumentoEventoLocalServiceUtil
				.getStrumentoEventos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoTec> servizioTec = (List<StrumentoTec>) StrumentoTecLocalServiceUtil
				.getStrumentoTecs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<TipoEvento> tipoEvento = (List<TipoEvento>) TipoEventoLocalServiceUtil.getTipoEventos(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		try {

			String idPrenotazione = request.getParameter("idPrenotazione");
			String dataDiPrenotazione = request.getParameter("dataDiPrenotazione");
			String data = request.getParameter("data");
			String oraInizio = request.getParameter("oraInizio");
			String oraFine = request.getParameter("oraFine");
			String IdTipoEvento = request.getParameter("tipoEvent");
			String oggetto = request.getParameter("oggetto");
			String numeroPartecipanti = request.getParameter("numeroPartecipanti");
			String ufficioRichiedente = request.getParameter("ufficioRichidente");
			String ufficioDirigente = request.getParameter("ufficioDirigente");
			String utenteRichiedente = request.getParameter("nomeUtenteRichiedente");
			String telefonoRichiedente = request.getParameter("telefonoRichiedente");
			String utenteReferente = request.getParameter("utenteReferente");
			String telefonoReferente = request.getParameter("telefonoReferente");
			String[] servizitec = request.getParameterValues("strumentazioneTecnici");
			String[] strumentazioneEventi = request.getParameterValues("strumentazioneEventi");
			String[] serviziLogistici = request.getParameterValues("serviziLogistici");
			String idSala = request.getParameter("SalaId");
			String jsonDatiRichiedenti = request.getParameter("jsonRichiedente");

			String note = null;

			if (request.getParameter("note") != null) {
				note = request.getParameter("note");
			}

			long oraInizioSalaPrenota = Long.parseLong(oraInizio);
			long oraFineSalaPrenota = Long.parseLong(oraFine);
			long id_Prenotazione = Long.parseLong(idPrenotazione);

			int id_Sala = Integer.parseInt(idSala);
			int id_TipoEvento = Integer.parseInt(IdTipoEvento);
			int numero_Partecipanti = Integer.parseInt(numeroPartecipanti);

			oraInizio = OrarioLocalServiceUtil.getOrario(oraInizioSalaPrenota).getOre();
			oraFine = OrarioLocalServiceUtil.getOrario(oraFineSalaPrenota).getOre();
			SimpleDateFormat parserOraFine = new SimpleDateFormat("HH:mm");
			Date dataOraFine = parserOraFine.parse(oraFine);
			int minutiCorretti = dataOraFine.getMinutes() - 1;
			dataOraFine.setMinutes(minutiCorretti);
			oraFine = parserOraFine.format(dataOraFine);
			Date dataOraFineEmail = parserOraFine.parse(oraFine);
			int minutiCorrettiEmail = dataOraFineEmail.getMinutes() + 1;
			dataOraFineEmail.setMinutes(minutiCorrettiEmail);
			String oraFineEmail = parserOraFine.format(dataOraFineEmail);

			StringBuilder dataOraInizioPrenotazione = new StringBuilder();
			dataOraInizioPrenotazione.append(data);
			dataOraInizioPrenotazione.append(" ");
			dataOraInizioPrenotazione.append(oraInizio);

			StringBuilder dataOraFinePrenotazione = new StringBuilder();
			dataOraFinePrenotazione.append(data);
			dataOraFinePrenotazione.append(" ");
			dataOraFinePrenotazione.append(oraFine);

			SimpleDateFormat parserDataOraInizio = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date dataInizioOraInizioPrenotazione = parserDataOraInizio.parse(dataOraInizioPrenotazione.toString());
			SimpleDateFormat parserDataOraFine = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date dataFineOraFinePrenotazione = parserDataOraFine.parse(dataOraFinePrenotazione.toString());

			List<String> listServiziTecnici = new ArrayList<String>(0);
			List<Long> listServiziTecniciId = new ArrayList<Long>(0);
			List<String> listNomeServizioTecnici = new ArrayList<String>(0);

			List<String> listServiziEventi = new ArrayList<String>(0);
			List<Long> listServiziEventiId = new ArrayList<Long>(0);
			List<String> listNomeServizioEventi = new ArrayList<String>(0);

			List<String> listServiziLogistici = new ArrayList<String>(0);
			List<Long> listServiziLogisticiId = new ArrayList<Long>(0);
			List<String> listNomeServizioLogistici = new ArrayList<String>(0);

			if (servizitec != null && servizitec.length > 0) {
				listServiziTecnici = Arrays.asList(servizitec);
			}

			if (serviziLogistici != null && serviziLogistici.length > 0) {
				listServiziLogistici = Arrays.asList(serviziLogistici);
			}

			if (strumentazioneEventi != null && strumentazioneEventi.length > 0) {
				listServiziEventi = Arrays.asList(strumentazioneEventi);
			}

			if (listServiziTecnici != null && !listServiziTecnici.isEmpty()) {
				/*
				 * creating list of name of technical services and id of each
				 * service
				 */
				for (int i = 0; i < listServiziTecnici.size(); i++) {
					listServiziTecniciId.add(Long.parseLong(listServiziTecnici.get(i)));
					listNomeServizioTecnici
							.add(StrumentoTecLocalServiceUtil.getStrumentoTec(Long.parseLong(listServiziTecnici.get(i)))
									.getDesc_strumento().toLowerCase());
				}
			}

			if (listServiziEventi != null && !listServiziEventi.isEmpty()) {
				/*
				 * creating list of name of instruments for event services and
				 * id of each service
				 */
				for (int indexListServiziEventi = 0; indexListServiziEventi < listServiziEventi
						.size(); indexListServiziEventi++) {
					listServiziEventiId.add(Long.parseLong(listServiziEventi.get(indexListServiziEventi)));
					listNomeServizioEventi.add(StrumentoEventoLocalServiceUtil
							.getStrumentoEvento(Long.parseLong(listServiziEventi.get(indexListServiziEventi)))
							.getDesc_strumento().toLowerCase());
				}
			}

			if (listServiziLogistici != null && !listServiziLogistici.isEmpty()) {
				/*
				 * creating list of name of logistic services and id of each
				 * service
				 */
				for (int i = 0; i < listServiziLogistici.size(); i++) {
					listServiziLogisticiId.add(Long.parseLong(listServiziLogistici.get(i)));
					listNomeServizioLogistici
							.add(ServizioLogLocalServiceUtil.getServizioLog(Long.parseLong(listServiziLogistici.get(i)))
									.getDesc_servizio().toLowerCase());
				}
			}

			JSONObject jsonServizi = JSONFactoryUtil.createJSONObject();

			jsonServizi.put("strumentazionetecnica", listNomeServizioTecnici);
			jsonServizi.put("strumentazionetecnicaevento", listNomeServizioEventi);
			jsonServizi.put("servizilogistici", listNomeServizioLogistici);

			String jsonServiziAggiuntivi = jsonServizi.toString();

			Sala sala = SalaLocalServiceUtil.getSala(id_Sala);

			String nomeSalaPerEmail = sala.getDesc_sala();
			String indirizzoSalaPerEmail = sala.getIndirizzo();

			StringBuilder nomeIndirizzoSalaPerEmail = new StringBuilder();
			nomeIndirizzoSalaPerEmail.append(nomeSalaPerEmail);
			nomeIndirizzoSalaPerEmail.append(" - ");
			nomeIndirizzoSalaPerEmail.append(indirizzoSalaPerEmail);

			String informazioneSalaPerEmail = nomeIndirizzoSalaPerEmail.toString();

			StringBuilder oraInizioFinePrenotazione = new StringBuilder();
			oraInizioFinePrenotazione.append(oraInizio);
			oraInizioFinePrenotazione.append(" - ");
			oraInizioFinePrenotazione.append(oraFineEmail);

			String oraInizioFinePerEmail = oraInizioFinePrenotazione.toString();

			String tipoEventoPerEmail = TipoEventoLocalServiceUtil.getTipoEvento(id_TipoEvento).getDesc_evento();

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			String datiRichiedente = getHtmlDatiMailRichiedente(ufficioRichiedente, ufficioDirigente, utenteRichiedente,
					telefonoRichiedente, utenteReferente, telefonoReferente);

			String datiRichieste = getHtmlDatiMailRichiesta(informazioneSalaPerEmail, tipoEventoPerEmail, data,
					oraInizioFinePerEmail, numeroPartecipanti, oggetto, note, listNomeServizioTecnici,
					listNomeServizioEventi, listNomeServizioLogistici);

			PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter("prenotazioneId", Long.toString(id_Prenotazione));
			renderUrl.setParameter("navigation", "linkdettaglio");

			String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
			String sender = request.getPreferences().getValue("sender", _configuration.sender());

			EmailSender mail = new EmailSender();

			List<Long> lista_id_sale_selezionate = new ArrayList<Long>(0);
			lista_id_sale_selezionate.add((long) id_Sala);
			List<Prenotazione> prenotazioni = PrenotazioneLocalServiceUtil.getPrenotazioniByFilters(
					lista_id_sale_selezionate, dataInizioOraInizioPrenotazione, dataFineOraFinePrenotazione, 0);

			int indiceLog = 1;

			for (Prenotazione p : prenotazioni) {
				_log.debug("listaPrenotazioniEsistenti[" + indiceLog + "].idPrenotazione: " + p.getId_prenota());
				_log.debug("listaPrenotazioniEsistenti[" + indiceLog + "].sala: " + p.getId_sala());
				_log.debug("listaPrenotazioniEsistenti[" + indiceLog + "].dataPrenotazione: " + p.getData_prenota());
				_log.debug(
						"listaPrenotazioniEsistenti[" + indiceLog + "].dataInizioPrenotazione: " + p.getData_inizio());
				_log.debug("listaPrenotazioniEsistenti[" + indiceLog + "].dataFinePrenotazione: " + p.getData_fine());
				indiceLog++;
			}

			String subject;
			String mailbody;

			boolean resultEmail = false;

			loginUserEmail = themeDisplay.getUser().getEmailAddress();

			Prenotazione updatePrenotazione = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione);

			if (prenotazioni != null && prenotazioni.size() == 1) {
				_log.debug("Prenotazione modificata: " + updatePrenotazione.getId_prenota());
				_log.debug("Prenotazione già presente: " + prenotazioni.get(0).getId_prenota());
			}

			/*
			 * creating list of referent people email addresses (of sala and
			 * services)
			 */
			List<String> referentiEmailList = getReferentiEmailList(listServiziTecnici, listServiziEventi,
					listServiziLogistici, idSala);

			if (prenotazioni == null || prenotazioni.isEmpty() || (prenotazioni.size() == 1
					&& updatePrenotazione.getId_prenota() == prenotazioni.get(0).getId_prenota()
					&& updatePrenotazione.getCod_fiscale().equalsIgnoreCase(themeDisplay.getUser().getScreenName()))) {

				// Update prenotazione
				User user = themeDisplay.getUser();
				String screenName = user.getScreenName();
				Date insertDate = new Date();
				boolean autorizzazioneSala = sala.getAutorizzazione();
				int autorizzazioneSale = (autorizzazioneSala) ? 1 : 0;

				updatePrenotazione.setId_sala(id_Sala);
				updatePrenotazione.setCod_fiscale(screenName.toLowerCase());
				updatePrenotazione.setData_prenota(insertDate);
				updatePrenotazione.setData_inizio(dataInizioOraInizioPrenotazione);
				updatePrenotazione.setData_fine(dataFineOraFinePrenotazione);
				updatePrenotazione.setPartecipanti(numero_Partecipanti);
				updatePrenotazione.setId_evento(id_TipoEvento);
				updatePrenotazione.setAttivita(oggetto);
				updatePrenotazione.setNote(note);

				if (autorizzazioneSale == 0) {
					updatePrenotazione.setId_stato(2);
				} else {
					updatePrenotazione.setId_stato(3);
				}

				updatePrenotazione.setDati_rich(jsonDatiRichiedenti.toLowerCase());
				updatePrenotazione.setServizi(jsonServiziAggiuntivi);

				PrenotazioneLocalServiceUtil.updatePrenotazione(updatePrenotazione);

				// Send Email
				subject = request.getPreferences().getValue("subjectPrenotazioneModificata",
						_configuration.subjectPrenotazioneModificata());

				mailbody = request.getPreferences().getValue("prenotazioneModificataTmpl",
						_configuration.prenotazioneModificataTmpl());

				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]", "[$LINK$]" },
						new String[] { datiRichiedente, datiRichieste, renderUrl.toString() });

				// Send email to applicant (richiedente)
				resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, loginUserEmail);

				// Send email to referentiEmailList
				if (referentiEmailList != null && !referentiEmailList.isEmpty()) {
					for (String emailReferenteAddress : referentiEmailList) {
						resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferenteAddress);
					}
				}

				String navigation = "dettaglioPrenotazione";
				PortletURL urlRefresh = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
						themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				urlRefresh.setParameter("prenotazione_Id", idPrenotazione);
				urlRefresh.setParameter("navigation", navigation);
				response.sendRedirect(urlRefresh.toString());
				renderUrl.setWindowState(LiferayWindowState.NORMAL);
				renderUrl.setPortletMode(LiferayPortletMode.VIEW);

			} else {

				ModuloPrenotazioneBean modulePrenotazioneBean = new ModuloPrenotazioneBean();
				List<OrarioBean> orariBean = new ArrayList<OrarioBean>(0);
				long id_ufficio;
				List<Sala> sale_list = new ArrayList<Sala>(0);

				request.setAttribute("errormessage", "errormessage");
				request.setAttribute("id_sala", idSala);

				for (Orario ora : OrarioLocalServiceUtil.getOrarios(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
					orariBean.add(new OrarioBean(Long.toString(ora.getId_ora()), ora.getOre()));
				}

				if (loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {
					id_ufficio = Long
							.parseLong((String) loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg));

					sale_list = SalaLocalServiceUtil.getSaleBySalaStrutturaList(
							SalaStrutturaLocalServiceUtil.getSaleListByIdStruttura(id_ufficio));
				}

				List<Orario> orarioList = (List<Orario>) OrarioLocalServiceUtil.findByIdOreListOre(oraInizioSalaPrenota,
						oraFineSalaPrenota);

				List<OrarioBean> orariBeans = new ArrayList<OrarioBean>(0);

				for (Orario ora : orarioList) {
					orariBeans.add(new OrarioBean(Long.toString(ora.getId_ora()), ora.getOre()));
				}

				modulePrenotazioneBean.setUfficioRichiedente(ufficioRichiedente);
				modulePrenotazioneBean.setDataDiPrenotazione(dataDiPrenotazione);
				modulePrenotazioneBean.setData(data);
				modulePrenotazioneBean.setNote(note);
				modulePrenotazioneBean.setAttivita_OggettoPrenotazione(oggetto);
				modulePrenotazioneBean.setNumeroPartecipanti(numeroPartecipanti);
				modulePrenotazioneBean.setDirigenteUfficio(ufficioDirigente);
				modulePrenotazioneBean.setUtenteReferente(utenteReferente);
				modulePrenotazioneBean.setUtenteRichiedente(utenteRichiedente);
				modulePrenotazioneBean.setTelefonoReferente(telefonoReferente);
				modulePrenotazioneBean.setTelefonoRichiedente(telefonoRichiedente);
				modulePrenotazioneBean.setServizioLogistici(servizioLogistici);
				modulePrenotazioneBean.setStrumentazioneEventi(servizioEventi);
				modulePrenotazioneBean.setStrumentazioneTecnica(servizioTec);
				modulePrenotazioneBean.setTipologiaEvento(tipoEvento);
				modulePrenotazioneBean.setOrari(orariBean);
				modulePrenotazioneBean.setListSala(sale_list);

				request.setAttribute("oraInizioSalaPrenota", oraInizioSalaPrenota);
				request.setAttribute("oraFineSalaPrenota", oraFineSalaPrenota);
				request.setAttribute("id_TipoEvento", id_TipoEvento);
				request.setAttribute("listServiziLogisticiId", listServiziLogisticiId);
				request.setAttribute("listServiziEventiId", listServiziEventiId);
				request.setAttribute("idSala", idSala);
				request.setAttribute("listServiziTecniciId", listServiziTecniciId);
				request.setAttribute("moduloPrenotazioneBean", modulePrenotazioneBean);
				request.setAttribute("navigation", "prenotaAula");
				request.setAttribute("idPrenotazione", idPrenotazione);
				request.setAttribute("currentUserEmail", loginUserEmail);

			}

			if (!resultEmail) {
				SessionErrors.add(request, "Errore-durante-invio-email");
				SessionMessages.add(request,
						PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			}

		} catch (PortalException e) {
			_log.warn(e);
		} catch (WindowStateException e) {
			_log.warn(e);
		} catch (java.text.ParseException e) {
			_log.warn(e);
		} catch (PortletModeException e) {
			_log.warn(e);
		}
	}

	public void eliminaPrenotazione(ActionRequest request, ActionResponse response)
			throws PortalException, java.text.ParseException, IOException {

		String idPrenotazione = request.getParameter("idPrenotazione");

		long id_Prenotazione = Long.parseLong(idPrenotazione);
		long idSala = 0;

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		loginUserEmail = themeDisplay.getUser().getEmailAddress();

		List<ServizioLog> servizioLogistici = (List<ServizioLog>) ServizioLogLocalServiceUtil
				.getServizioLogs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoEvento> servizioEventi = (List<StrumentoEvento>) StrumentoEventoLocalServiceUtil
				.getStrumentoEventos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoTec> servizioTec = (List<StrumentoTec>) StrumentoTecLocalServiceUtil
				.getStrumentoTecs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<TipoEvento> tipoEvento = (List<TipoEvento>) TipoEventoLocalServiceUtil.getTipoEventos(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		try {

			id_Prenotazione = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getId_prenota();

			idSala = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getId_sala();

			Date dataInizio = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getData_inizio();
			Date dataFine = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getData_fine();
			SimpleDateFormat parserDataInizio = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat parserOraInizio = new SimpleDateFormat("HH:mm");
			String oraInizioPrenotazione = parserOraInizio.format(dataInizio);
			SimpleDateFormat parserFineInizio = new SimpleDateFormat("HH:mm");
			int minutiCorrettiEmail = dataFine.getMinutes() + 1;
			dataFine.setMinutes(minutiCorrettiEmail);
			String oraFineEmail = parserFineInizio.format(dataFine);

			String datiUtenteRichiedente = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getDati_rich();
			String datiServiziAggiuntivi = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getServizi();

			JSONObject jsonDatiUtenteRichiedente = (JSONObject) JSONFactoryUtil.createJSONObject(datiUtenteRichiedente);
			JSONObject jsonDatiServiziAggiuntivi = (JSONObject) JSONFactoryUtil.createJSONObject(datiServiziAggiuntivi);

			JSONArray arrayServizioLogistico = jsonDatiServiziAggiuntivi.getJSONArray("servizilogistici");

			List<Long> listServiziLogisticoId = new ArrayList<Long>(0);

			for (int indexServizioLogistico = 0; indexServizioLogistico < arrayServizioLogistico
					.length(); indexServizioLogistico++) {
				for (ServizioLog serviceLog : servizioLogistici) {
					if (serviceLog.getDesc_servizio()
							.equalsIgnoreCase(arrayServizioLogistico.getString(indexServizioLogistico))) {
						listServiziLogisticoId.add(serviceLog.getId_servizio());
					}
				}
			}

			JSONArray arrayServizioEvento = jsonDatiServiziAggiuntivi.getJSONArray("strumentazionetecnicaevento");

			List<Long> listServiziEventoId = new ArrayList<Long>(0);

			for (int indexServizioEvento = 0; indexServizioEvento < arrayServizioEvento
					.length(); indexServizioEvento++) {
				for (StrumentoEvento serviceEvent : servizioEventi) {
					if (serviceEvent.getDesc_strumento()
							.equalsIgnoreCase(arrayServizioEvento.getString(indexServizioEvento))) {
						listServiziEventoId.add(serviceEvent.getId_strumento());
					}
				}
			}

			JSONArray arrayDatiServiziAggiuntivi = jsonDatiServiziAggiuntivi.getJSONArray("strumentazionetecnica");

			List<Long> listServiziTecniciId = new ArrayList<Long>(0);

			for (int i = 0; i < arrayDatiServiziAggiuntivi.length(); i++) {
				for (StrumentoTec serviziTec : servizioTec) {
					if (serviziTec.getDesc_strumento().equalsIgnoreCase(arrayDatiServiziAggiuntivi.getString(i))) {
						listServiziTecniciId.add(serviziTec.getId_strumento());
					}
				}
			}

			long id_TipoEvento = 0;

			for (TipoEvento typeEvent : tipoEvento) {
				if (typeEvent.getId_evento() == PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione)
						.getId_evento()) {
					id_TipoEvento = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getId_evento();
				}
			}

			String note = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getNote();
			String oggetto = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getAttivita();

			int numeroPartecipanti = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getPartecipanti();

			Sala sala = SalaLocalServiceUtil.getSala(idSala);

			String nomeSalaPerEmail = sala.getDesc_sala();
			String indirizzoSalaPerEmail = sala.getIndirizzo();

			StringBuilder nomeIndirizzoSalaPerEmail = new StringBuilder();
			nomeIndirizzoSalaPerEmail.append(nomeSalaPerEmail);
			nomeIndirizzoSalaPerEmail.append(" - ");
			nomeIndirizzoSalaPerEmail.append(indirizzoSalaPerEmail);

			String informazioneSalaPerEmail = nomeIndirizzoSalaPerEmail.toString();

			StringBuilder oraInizioFinePrenotazione = new StringBuilder();
			oraInizioFinePrenotazione.append(oraInizioPrenotazione);
			oraInizioFinePrenotazione.append(" - ");
			oraInizioFinePrenotazione.append(oraFineEmail);

			String oraInizioFinePerEmail = oraInizioFinePrenotazione.toString();
			String tipoEventoPerEmail = TipoEventoLocalServiceUtil.getTipoEvento(id_TipoEvento).getDesc_evento();

			JSONObject serviziJsonObj = JSONFactoryUtil
					.createJSONObject(PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getServizi());

			List<String> strumentazioneTecnicaList = new ArrayList<String>(0);
			JSONArray strumentazione_tecnica = (JSONArray) serviziJsonObj.getJSONArray("strumentazionetecnica");

			if (strumentazione_tecnica != null) {
				for (int j = 0; j < strumentazione_tecnica.length(); j++) {
					strumentazioneTecnicaList.add((String) strumentazione_tecnica.getString(j));
				}
			}

			List<String> strumentazioneEventoList = new ArrayList<String>(0);
			JSONArray strumentazione_evento = (JSONArray) serviziJsonObj.getJSONArray("strumentazionetecnicaevento");

			if (strumentazione_evento != null) {
				for (int indexStrumentazione_evento = 0; indexStrumentazione_evento < strumentazione_evento
						.length(); indexStrumentazione_evento++) {
					strumentazioneEventoList.add((String) strumentazione_evento.getString(indexStrumentazione_evento));
				}
			}

			List<String> logisticiList = new ArrayList<String>(0);
			JSONArray logistici = (JSONArray) serviziJsonObj.getJSONArray("servizilogistici");

			if (logistici != null) {
				for (int indexlogistici = 0; indexlogistici < logistici.length(); indexlogistici++) {
					logisticiList.add((String) logistici.getString(indexlogistici));
				}
			}

			String datiRichiedente = getHtmlDatiMailRichiedente(
					jsonDatiUtenteRichiedente.getString("ufficiorichiedente"),
					jsonDatiUtenteRichiedente.getString("dirigenteufficio"),
					jsonDatiUtenteRichiedente.getString("utenterichiedente"),
					jsonDatiUtenteRichiedente.getString("telefonorichiedente"),
					jsonDatiUtenteRichiedente.getString("referente"),
					jsonDatiUtenteRichiedente.getString("telefonoreferente"));

			String datiRichieste = getHtmlDatiMailRichiesta(informazioneSalaPerEmail, tipoEventoPerEmail,
					parserDataInizio.format(dataInizio), oraInizioFinePerEmail, String.valueOf(numeroPartecipanti),
					oggetto, note, strumentazioneTecnicaList, strumentazioneEventoList, logisticiList);

			String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
			String sender = request.getPreferences().getValue("sender", _configuration.sender());

			EmailSender mail = new EmailSender();

			String subject;
			String mailbody;

			boolean autorizzazioneSala = sala.getAutorizzazione();
			int autorizzazioneSale = (autorizzazioneSala) ? 1 : 0;

			List<String> listServiziTecnici = new ArrayList<String>(0);
			List<String> listServiziEventi = new ArrayList<String>(0);
			List<String> listServiziLogistici = new ArrayList<String>(0);

			if (listServiziTecniciId != null && !listServiziTecniciId.isEmpty()) {
				for (Long idServizioTecnico : listServiziTecniciId) {
					listServiziTecnici.add(String.valueOf(idServizioTecnico));
				}
			}

			if (listServiziEventoId != null && !listServiziEventoId.isEmpty()) {
				for (Long idServizioEvento : listServiziEventoId) {
					listServiziEventi.add(String.valueOf(idServizioEvento));
				}
			}

			if (listServiziLogisticoId != null && !listServiziLogisticoId.isEmpty()) {
				for (Long idServizioLogistico : listServiziLogisticoId) {
					listServiziLogistici.add(String.valueOf(idServizioLogistico));
				}
			}

			/*
			 * creating list of referent people email addresses (of sala and
			 * services)
			 */
			List<String> referentiEmailList = getReferentiEmailList(listServiziTecnici, listServiziEventi,
					listServiziLogistici, String.valueOf(idSala));

			List<String> listNomeServizioTecnici = new ArrayList<String>(0);

			for (int i = 0; i < listNomeServizioTecnici.size(); i++) {
				for (StrumentoTec st : StrumentoTecLocalServiceUtil.getStrumentoTecs(QueryUtil.ALL_POS,
						QueryUtil.ALL_POS)) {
					if (st.getDesc_strumento().equalsIgnoreCase(strumentazioneTecnicaList.get(i))) {
						listNomeServizioTecnici.add(st.getDesc_strumento().toLowerCase());
					}
				}
			}

			List<String> listNomeServizioEventi = new ArrayList<String>(0);

			for (int i = 0; i < strumentazioneEventoList.size(); i++) {
				for (StrumentoEvento seriviziEvent : StrumentoEventoLocalServiceUtil
						.getStrumentoEventos(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
					if (seriviziEvent.getDesc_strumento().equalsIgnoreCase(strumentazioneEventoList.get(i))) {
						listNomeServizioEventi.add(seriviziEvent.getDesc_strumento().toLowerCase());
					}
				}
			}

			List<String> listNomeServizioLogistici = new ArrayList<String>(0);

			for (int indexLogisticiList = 0; indexLogisticiList < logisticiList.size(); indexLogisticiList++) {
				for (ServizioLog ServizioLogistico : ServizioLogLocalServiceUtil.getServizioLogs(QueryUtil.ALL_POS,
						QueryUtil.ALL_POS)) {
					if (ServizioLogistico.getDesc_servizio().equalsIgnoreCase(logisticiList.get(indexLogisticiList))) {
						listNomeServizioLogistici.add(ServizioLogistico.getDesc_servizio().toLowerCase());
					}
				}
			}

			subject = request.getPreferences().getValue("subjectPrenotazioneEliminata",
					_configuration.subjectPrenotazioneEliminata());

			mailbody = request.getPreferences().getValue("prenotazioneEliminataTmpl",
					_configuration.prenotazioneEliminataTmpl());

			mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
					new String[] { datiRichiedente, datiRichieste });

			if (autorizzazioneSale == 1) {

				List<Approvatore> listEmailApprovatori = (List<Approvatore>) ApprovatoreLocalServiceUtil
						.getApprovatoriListByIdSala(idSala);

				List<String> listEmailApprovatoriSala = new ArrayList<String>(0);

				for (Approvatore approvatore : listEmailApprovatori) {
					listEmailApprovatoriSala.add(approvatore.getEmail_approvatore());
				}

				int listEmailApprovatoriSalaSize = listEmailApprovatoriSala.size();

				// Send email to listEmailApprovatoriSala
				for (int i = 0; i < listEmailApprovatoriSalaSize; i++) {
					String emailApprovatoriSala = listEmailApprovatoriSala.get(i);
					mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailApprovatoriSala);
				}
			}

			// Send email to applicant (richiedente)
			mail.sendMailMessage(subject, mailbody, sender, smtpUser, loginUserEmail);

			// Send email to referentiEmailList
			if (referentiEmailList != null && !referentiEmailList.isEmpty()) {
				for (String emailReferenteAddress : referentiEmailList) {
					mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferenteAddress);
				}
			}

		} catch (PortalException e) {
			_log.warn(e);
		}

		PrenotazioneLocalServiceUtil.deletePrenotazione(id_Prenotazione);
		PortletURL urlRefresh = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		response.sendRedirect(urlRefresh.toString());
	}

	public void modificaPrenotazione(ActionRequest request, ActionResponse response) {

		String idPrenotazione = request.getParameter("idPrenotazione");

		long id_Prenotazione = Long.parseLong(idPrenotazione);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		loginUserEmail = themeDisplay.getUser().getEmailAddress();

		List<ServizioLog> servizioLogistici = (List<ServizioLog>) ServizioLogLocalServiceUtil
				.getServizioLogs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoEvento> servizioEventi = (List<StrumentoEvento>) StrumentoEventoLocalServiceUtil
				.getStrumentoEventos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoTec> servizioTec = (List<StrumentoTec>) StrumentoTecLocalServiceUtil
				.getStrumentoTecs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<TipoEvento> tipoEvento = (List<TipoEvento>) TipoEventoLocalServiceUtil.getTipoEventos(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		List<Orario> listorari = (List<Orario>) OrarioLocalServiceUtil.getOrarios(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		long id_ufficio = 0;
		long idSala = 0;

		List<Sala> sale_list = new ArrayList<Sala>(0);

		try {

			if (loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg) != null) {
				id_ufficio = Long.parseLong((String) loginUser.getExpandoBridge().getAttribute(_customFieldUserOrg));
				sale_list = SalaLocalServiceUtil
						.getSaleBySalaStrutturaList(SalaStrutturaLocalServiceUtil.getSaleListByIdStruttura(id_ufficio));
			}

			id_Prenotazione = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getId_prenota();
			idSala = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getId_sala();

			Date dataInizio = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getData_inizio();
			Date dataFine = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getData_fine();

			SimpleDateFormat parserDataInizio = new SimpleDateFormat("dd/MM/yyyy");
			String dataInizioPrenotazione = parserDataInizio.format(dataInizio);
			SimpleDateFormat parserOraInizio = new SimpleDateFormat("HH:mm");
			String OraInizioPrenotazione = parserOraInizio.format(dataInizio);

			long idOraInizioPrenotazione = 0;

			int minuticorretti = dataFine.getMinutes() + 1;
			dataFine.setMinutes(minuticorretti);

			SimpleDateFormat parserFineInizio = new SimpleDateFormat("HH:mm");
			String OraFinePrenotazione = parserFineInizio.format(dataFine);

			long idOraFinePrenotazione = 0;

			for (Orario ore : listorari) {
				if (ore.getOre().equals(OraInizioPrenotazione)) {
					idOraInizioPrenotazione = ore.getId_ora();
				}

				if (ore.getOre().equals(OraFinePrenotazione)) {
					idOraFinePrenotazione = ore.getId_ora();
				}
			}

			String datiUtenteRichiedente = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getDati_rich();
			String datiServiziAggiuntivi = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getServizi();

			JSONObject jsonDatiUtenteRichiedente = (JSONObject) JSONFactoryUtil.createJSONObject(datiUtenteRichiedente);

			JSONObject jsonDatiServiziAggiuntivi = (JSONObject) JSONFactoryUtil.createJSONObject(datiServiziAggiuntivi);

			JSONArray arrayServizioLogistico = jsonDatiServiziAggiuntivi.getJSONArray("servizilogistici");
			List<Long> listServiziLogisticiId = new ArrayList<Long>(0);

			for (int i = 0; i < arrayServizioLogistico.length(); i++) {
				for (ServizioLog servizilog : servizioLogistici) {
					if (servizilog.getDesc_servizio().equalsIgnoreCase(arrayServizioLogistico.getString(i))) {
						listServiziLogisticiId.add(servizilog.getId_servizio());
					}
				}
			}

			JSONArray arrayServizioEvento = jsonDatiServiziAggiuntivi.getJSONArray("strumentazionetecnicaevento");
			List<Long> listServiziEventiId = new ArrayList<Long>(0);

			for (int i = 0; i < arrayServizioEvento.length(); i++) {
				for (StrumentoEvento serviceEvent : servizioEventi) {
					if (serviceEvent.getDesc_strumento().equalsIgnoreCase(arrayServizioEvento.getString(i))) {
						listServiziEventiId.add(serviceEvent.getId_strumento());
					}
				}
			}

			JSONArray arrayDatiServiziAggiuntivi = jsonDatiServiziAggiuntivi.getJSONArray("strumentazionetecnica");
			List<Long> listServiziTecniciId = new ArrayList<Long>(0);

			for (int i = 0; i < arrayDatiServiziAggiuntivi.length(); i++) {
				for (StrumentoTec serviziTec : servizioTec) {
					if (serviziTec.getDesc_strumento().equalsIgnoreCase(arrayDatiServiziAggiuntivi.getString(i))) {
						listServiziTecniciId.add(serviziTec.getId_strumento());
					}
				}
			}

			long id_TipoEvento = 0;

			for (TipoEvento typeEvent : tipoEvento) {
				if (typeEvent.getId_evento() == PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione)
						.getId_evento()) {
					id_TipoEvento = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getId_evento();
				}
			}

			String note = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getNote();

			String oggetto = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getAttivita();

			int numeroPartecipanti = PrenotazioneLocalServiceUtil.getPrenotazione(id_Prenotazione).getPartecipanti();

			ModuloPrenotazioneBean moduloPrenotazioneBean = new ModuloPrenotazioneBean();
			moduloPrenotazioneBean.setData(dataInizioPrenotazione);
			moduloPrenotazioneBean.setOraInizio(OraInizioPrenotazione);
			moduloPrenotazioneBean.setOraFine(OraFinePrenotazione);
			moduloPrenotazioneBean.setUtenteRichiedente(jsonDatiUtenteRichiedente.getString("utenterichiedente"));
			moduloPrenotazioneBean.setUfficioRichiedente(jsonDatiUtenteRichiedente.getString("ufficiorichiedente"));
			moduloPrenotazioneBean.setTelefonoRichiedente(jsonDatiUtenteRichiedente.getString("telefonorichiedente"));
			moduloPrenotazioneBean.setDirigenteUfficio(jsonDatiUtenteRichiedente.getString("dirigenteufficio"));
			moduloPrenotazioneBean.setUtenteReferente(jsonDatiUtenteRichiedente.getString("referente"));
			moduloPrenotazioneBean.setTelefonoReferente(jsonDatiUtenteRichiedente.getString("telefonoreferente"));
			moduloPrenotazioneBean.setNote(note);
			moduloPrenotazioneBean.setAttivita_OggettoPrenotazione(oggetto);
			moduloPrenotazioneBean.setNumeroPartecipanti(Integer.toString(numeroPartecipanti));
			moduloPrenotazioneBean.setIdSala(Long.toString(idSala));

			List<OrarioBean> orariBean = new ArrayList<OrarioBean>(0);

			for (Orario ora : OrarioLocalServiceUtil.getOrarios(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
				orariBean.add(new OrarioBean(Long.toString(ora.getId_ora()), ora.getOre()));
			}

			moduloPrenotazioneBean.setOrari(orariBean);
			moduloPrenotazioneBean.setTipologiaEvento(tipoEvento);
			moduloPrenotazioneBean.setStrumentazioneEventi(servizioEventi);
			moduloPrenotazioneBean.setServizioLogistici(servizioLogistici);
			moduloPrenotazioneBean.setStrumentazioneTecnica(servizioTec);
			moduloPrenotazioneBean.setListSala(sale_list);
			moduloPrenotazioneBean.setIdPrenotazione(idPrenotazione);

			int modificaPrenota = 1;

			request.setAttribute("listServiziTecniciId", listServiziTecniciId);
			request.setAttribute("listServiziLogisticiId", listServiziLogisticiId);
			request.setAttribute("listServiziEventiId", listServiziEventiId);
			request.setAttribute("id_TipoEvento", id_TipoEvento);
			request.setAttribute("oraInizioSalaPrenota", idOraInizioPrenotazione);
			request.setAttribute("oraFineSalaPrenota", idOraFinePrenotazione);
			request.setAttribute("modifica", modificaPrenota);
			request.setAttribute("moduloPrenotazioneBean", moduloPrenotazioneBean);
			request.setAttribute("navigation", "prenotaAula");
			request.setAttribute("currentUserEmail", loginUserEmail);

		} catch (Exception e) {
			_log.warn(e);
		}
	}

	@ProcessAction(name = "vaiALeTuePrenotazioni")
	public void vaiALeTuePrenotazioni(ActionRequest request, ActionResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		loginUser = themeDisplay.getUser();

		String userScreenName = themeDisplay.getUser().getScreenName();

		List<Prenotazione> leTuePrenotazione = PrenotazioneLocalServiceUtil.getPrenotazioniByCodFiscale(userScreenName);
		LaTuaPrenotazioneBean laTuaPrenotazione;
		List<LaTuaPrenotazioneBean> listLeTuePrenotazione = new ArrayList<LaTuaPrenotazioneBean>(0);

		List<Prenotazione> prenotazioniOdierneFuture = new ArrayList<Prenotazione>(0);

		for (Prenotazione prenotazione : leTuePrenotazione) {
			if (prenotazione.getData_inizio().getTime() >= new Date().getTime()) {
				prenotazioniOdierneFuture.add(prenotazione);
			}
		}

		Collections.sort(prenotazioniOdierneFuture, new Comparator<Prenotazione>() {
			@Override
			public int compare(Prenotazione p1, Prenotazione p2) {
				if (p2.getData_inizio().before(p1.getData_inizio())) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		for (Prenotazione prenotazione : prenotazioniOdierneFuture) {

			laTuaPrenotazione = new LaTuaPrenotazioneBean();

			Sala informazioneSala;
			try {
				informazioneSala = SalaLocalServiceUtil.getSala(prenotazione.getId_sala());
				laTuaPrenotazione.setNomeSalaRiunione(informazioneSala.getDesc_sala());
				laTuaPrenotazione.setIdSala(Long.toString(informazioneSala.getId_sala()));
				laTuaPrenotazione.setPostiInSala(Long.toString(informazioneSala.getPosti()));

				boolean autorizzazioneSala = informazioneSala.getAutorizzazione();

				int autorizzazioneSale = (autorizzazioneSala) ? 1 : 0;

				laTuaPrenotazione.setIdAutorizzazione(autorizzazioneSale);

				StringBuilder indirizzoSala = new StringBuilder();
				indirizzoSala.append(informazioneSala.getIndirizzo() + ",");
				indirizzoSala.append(" ");
				indirizzoSala.append("Piano");
				indirizzoSala.append(" ");
				indirizzoSala.append(informazioneSala.getPiano() + ",");
				indirizzoSala.append(" ");
				indirizzoSala.append("Stanza " + informazioneSala.getStanza());
				laTuaPrenotazione.setIndirizzo(indirizzoSala.toString());

				StatoAula informazioneStatoAula = StatoAulaLocalServiceUtil.getStatoAula(prenotazione.getId_stato());
				laTuaPrenotazione.setStato(informazioneStatoAula.getDesc_stato());
			} catch (PortalException e) {
				_log.warn(e);
			}

			Date dataPrenotazione = prenotazione.getData_inizio();

			DateFormat InizioOra = new SimpleDateFormat("HH:mm");
			DateFormat FineOra = new SimpleDateFormat("HH:mm");
			DateFormat PrenotazioneData = new SimpleDateFormat("dd.MM.yyyy");

			String DataPrenotazioneSala = PrenotazioneData.format(dataPrenotazione);

			laTuaPrenotazione.setDataPrenotazione(DataPrenotazioneSala);

			String oraDiInizioPrenotazione = InizioOra.format(dataPrenotazione);

			dataPrenotazione = prenotazione.getData_fine();
			int minutiCorretti = dataPrenotazione.getMinutes() + 1;
			dataPrenotazione.setMinutes(minutiCorretti);

			String oraDiFinePrenotazione = FineOra.format(dataPrenotazione);

			StringBuilder orariPrenotazione = new StringBuilder();
			orariPrenotazione.append(oraDiInizioPrenotazione);
			orariPrenotazione.append(" ");
			orariPrenotazione.append("-");
			orariPrenotazione.append(" ");
			orariPrenotazione.append(oraDiFinePrenotazione);

			laTuaPrenotazione.setOrario(orariPrenotazione.toString());
			laTuaPrenotazione.setIdPrenotazione(Long.toString(prenotazione.getId_prenota()));

			listLeTuePrenotazione.add(laTuaPrenotazione);

		}

		int listLeTuePrenotazioneSize = listLeTuePrenotazione.size();

		request.setAttribute("listLeTuePrenotazioneSize", listLeTuePrenotazioneSize);
		request.setAttribute("listLeTuePrenotazione", listLeTuePrenotazione);

		String navigation = "leTuePrenotazioni";
		request.setAttribute("navigation", navigation);

		boolean listaPrenotazioni = true;
		request.setAttribute("listaPrenotazioni", listaPrenotazioni);

	}

	@ProcessAction(name = "requestForApproval")
	public void requestForApproval(ActionRequest request, ActionResponse response) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String emailApprovatore = null;

		boolean currentUserApprovatore = false;

		List<LaTuaPrenotazioneBean> listLePrenotazioniInAttessaApprovazione = new ArrayList<LaTuaPrenotazioneBean>(0);

		List<Long> listIdSala = new ArrayList<Long>(0);

		List<Prenotazione> lePrenotazioniApprovazione = (List<Prenotazione>) PrenotazioneLocalServiceUtil
				.getPrenotaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<Prenotazione> prenotazioniOdierneFuture = new ArrayList<Prenotazione>(0);

		for (Prenotazione prenotazione : lePrenotazioniApprovazione) {
			if (prenotazione.getData_inizio() != null
					&& prenotazione.getData_inizio().getTime() >= new Date().getTime()) {
				prenotazioniOdierneFuture.add(prenotazione);
			}
		}

		Collections.sort(prenotazioniOdierneFuture, new Comparator<Prenotazione>() {
			@Override
			public int compare(Prenotazione p1, Prenotazione p2) {
				if (p2.getData_inizio().before(p1.getData_inizio())) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		List<Role> role = (List<Role>) themeDisplay.getUser().getRoles();

		for (Role roles : role) {
			if (("approvatoreSale").equalsIgnoreCase(roles.getName())) {

				currentUserApprovatore = true;

				emailApprovatore = themeDisplay.getUser().getEmailAddress();
			}
		}

		for (Approvatore approvatore : ApprovatoreLocalServiceUtil.getApprovatores(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS)) {

			if (approvatore.getEmail_approvatore().equalsIgnoreCase(emailApprovatore)) {
				listIdSala.add(approvatore.getId_sala());
			}
		}

		for (int i = 0; i < listIdSala.size(); i++) {

			long idSala = listIdSala.get(i);

			for (Prenotazione prenotazione : prenotazioniOdierneFuture) {

				long prenotazioneIdSala = prenotazione.getId_sala();

				if (prenotazioneIdSala == idSala && prenotazione.getId_stato() == 3)

				{

					LaTuaPrenotazioneBean lePrenotazioni = new LaTuaPrenotazioneBean();

					Sala informazioneSala = SalaLocalServiceUtil.getSala(prenotazioneIdSala);

					lePrenotazioni.setNomeSalaRiunione(informazioneSala.getDesc_sala());

					lePrenotazioni.setIdSala(Long.toString(informazioneSala.getId_sala()));

					lePrenotazioni.setPostiInSala(Long.toString(informazioneSala.getPosti()));

					StringBuilder indirizzoSala = new StringBuilder();

					indirizzoSala.append(informazioneSala.getIndirizzo() + ",");

					indirizzoSala.append(" ");

					indirizzoSala.append("Piano ");

					indirizzoSala.append(informazioneSala.getPiano() + ",");

					indirizzoSala.append(" ");

					indirizzoSala.append("Stanza " + informazioneSala.getStanza());

					lePrenotazioni.setIndirizzo(indirizzoSala.toString());

					StatoAula informazioneStatoAula = StatoAulaLocalServiceUtil
							.getStatoAula(prenotazione.getId_stato());

					lePrenotazioni.setStato(informazioneStatoAula.getDesc_stato());

					Date dataPrenotazione = prenotazione.getData_inizio();

					DateFormat InizioOra = new SimpleDateFormat("HH:mm");

					DateFormat FineOra = new SimpleDateFormat("HH:mm");

					DateFormat PrenotazioneData = new SimpleDateFormat("dd.MM.yyyy");

					String DataPrenotazioneSala = PrenotazioneData.format(dataPrenotazione);

					lePrenotazioni.setDataPrenotazione(DataPrenotazioneSala);

					String oraDiInizioPrenotazione = InizioOra.format(dataPrenotazione);

					dataPrenotazione = prenotazione.getData_fine();

					dataPrenotazione = DateUtils.addMinutes(dataPrenotazione, 1);

					String oraDiFinePrenotazione = FineOra.format(dataPrenotazione);

					StringBuilder orariPrenotazione = new StringBuilder();

					orariPrenotazione.append(oraDiInizioPrenotazione);

					orariPrenotazione.append(" ");

					orariPrenotazione.append("-");

					orariPrenotazione.append(" ");

					orariPrenotazione.append(oraDiFinePrenotazione);

					lePrenotazioni.setOrario(orariPrenotazione.toString());

					lePrenotazioni.setIdPrenotazione(Long.toString(prenotazione.getId_prenota()));

					boolean toAdd = true;
					for (LaTuaPrenotazioneBean laTuaprenotazione : listLePrenotazioniInAttessaApprovazione) {
						if (laTuaprenotazione.getIdPrenotazione() != null
								&& laTuaprenotazione.getIdPrenotazione().equals(lePrenotazioni.getIdPrenotazione())) {
							toAdd = false;
						}
					}
					if (toAdd) {
						listLePrenotazioniInAttessaApprovazione.add(lePrenotazioni);
					}

				}

			}

		}

		request.setAttribute("listSize", listLePrenotazioniInAttessaApprovazione.size());

		request.setAttribute("listLePrenotazioniInAttessaApprovazione", listLePrenotazioniInAttessaApprovazione);

		request.setAttribute("approvatore", currentUserApprovatore);

		String navigation = "leTuePrenotazioni";

		request.setAttribute("navigation", navigation);

		boolean listaApprovazioni = true;

		request.setAttribute("listaApprovazioni", listaApprovazioni);

	}

	@ProcessAction(name = "vaiAInserimento")
	public void vaiAInserimento(ActionRequest request, ActionResponse response) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		loginUserEmail = themeDisplay.getUser().getEmailAddress();

		ModuloPrenotazioneBean moduloPrenotazioneBean = new ModuloPrenotazioneBean();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date dateobj = new Date();

		String dataDiPrenotazione = dateFormat.format(dateobj);

		String dataDisponibile = null;

		if (request.getParameter("dataDisponibile") != null) {
			dataDisponibile = request.getParameter("dataDisponibile").replace(".", "/");
		}

		String rangeOrarioDisponibile;
		String[] parts;
		String oraInizio = null;
		String oraFine = null;

		long idOraInizio = 0;
		long idOraFine = 0;

		if (request.getParameter("rangeOrarioDisponibile") != null) {

			rangeOrarioDisponibile = request.getParameter("rangeOrarioDisponibile");
			parts = rangeOrarioDisponibile.split(" - ");
			oraInizio = parts[0];
			oraFine = parts[1];
		}

		for (Orario orario : OrarioLocalServiceUtil.getOrarios(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {

			if (orario.getOre().equalsIgnoreCase(oraInizio)) {
				idOraInizio = orario.getId_ora();
			} else if (orario.getOre().equalsIgnoreCase(oraFine)) {
				idOraFine = orario.getId_ora();
			}
		}

		List<Orario> lista_orari_disponibili = new ArrayList<Orario>(0);

		if (idOraInizio != 0 && idOraFine != 0) {
			lista_orari_disponibili = OrarioLocalServiceUtil.findByIdOreListOre(idOraInizio, idOraFine);
		}

		List<OrarioBean> orariBean = new ArrayList<OrarioBean>(0);

		for (Orario ora : lista_orari_disponibili) {
			orariBean.add(new OrarioBean(Long.toString(ora.getId_ora()), ora.getOre()));
		}

		String salaDisponibile = null;

		long idSalaDisponibile = 0;

		if (request.getParameter("salaDisponibile") != null) {
			salaDisponibile = request.getParameter("salaDisponibile");
		}

		for (Sala sala : SalaLocalServiceUtil.getSalas(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {

			if (sala.getDesc_sala().equalsIgnoreCase(salaDisponibile)) {
				idSalaDisponibile = sala.getId_sala();
			}
		}

		List<ServizioLog> servizioLogistici = (List<ServizioLog>) ServizioLogLocalServiceUtil
				.getServizioLogs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoEvento> strumentazioneEventi = (List<StrumentoEvento>) StrumentoEventoLocalServiceUtil
				.getStrumentoEventos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StrumentoTec> strumentazioneTecnica = (List<StrumentoTec>) StrumentoTecLocalServiceUtil
				.getStrumentoTecs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<TipoEvento> tipoEvento = (List<TipoEvento>) TipoEventoLocalServiceUtil.getTipoEventos(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		String utenteRichiedente = themeDisplay.getUser().getFullName();

		List<Phone> listPhoneNumber = (List<Phone>) themeDisplay.getUser().getPhones();

		String telefonoRichiedente = "";
		for (Phone phone : listPhoneNumber) {
			if (("Business").equalsIgnoreCase(phone.getType().getName())) {
				if (phone.getNumber() != null)
					telefonoRichiedente = phone.getNumber();
				break;
			}
		}

		moduloPrenotazioneBean.setDataDiPrenotazione(dataDiPrenotazione);
		moduloPrenotazioneBean.setData(dataDisponibile);
		moduloPrenotazioneBean.setOrari(orariBean);
		moduloPrenotazioneBean.setSala(salaDisponibile);
		moduloPrenotazioneBean.setIdSala(String.valueOf(idSalaDisponibile));
		moduloPrenotazioneBean.setTipologiaEvento(tipoEvento);
		moduloPrenotazioneBean.setStrumentazioneEventi(strumentazioneEventi);
		moduloPrenotazioneBean.setServizioLogistici(servizioLogistici);
		moduloPrenotazioneBean.setStrumentazioneTecnica(strumentazioneTecnica);
		moduloPrenotazioneBean.setUtenteRichiedente(utenteRichiedente);
		moduloPrenotazioneBean.setTelefonoRichiedente(telefonoRichiedente);
		int modificaPrenota = 0;

		String navigation = "prenotaAula";

		request.setAttribute("modificaPrenota", modificaPrenota);
		request.setAttribute("navigation", navigation);
		request.setAttribute("currentUserEmail", loginUserEmail);
		request.setAttribute("moduloPrenotazioneBean", moduloPrenotazioneBean);

	}

	public void vaiPaginaRicerca(ActionRequest request, ActionResponse response) throws PortalException {

		String navigation;
		boolean approvatore = false;

		if (request.getParameter("approvatore") != null
				&& ("true").equalsIgnoreCase(request.getParameter("approvatore"))) {
			approvatore = true;
		}

		if (request.getParameter("dettaglio") == null) {

			navigation = "home";

			request.setAttribute("navigation", navigation);
		} else if (request.getParameter("dettaglio") != null) {

			String idPrenotazione = request.getParameter("idPrenotazione");

			long prenotazioneId = Long.parseLong(idPrenotazione);

			navigation = "dettaglioPrenotazione";

			request.setAttribute("prenotazione_Id", prenotazioneId);

			request.setAttribute("navigation", navigation);

			request.setAttribute("approvatore", approvatore);
		} else {

			navigation = "prenotaAula";

			request.setAttribute("navigation", navigation);
		}

	}

	private String getHtmlDatiMailRichiedente(String uffRichiedente, String ufficioDirigente,
			String nomeUtenteRichiedente, String telefonoRichiedente, String utenteReferente,
			String telefonoReferente) {

		StringBuilder dati = new StringBuilder();

		dati.append("<p><b>Ufficio Richiedente:</b>");
		dati.append(" ");
		dati.append(uffRichiedente.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");

		dati.append("<p><b>Dirigente Ufficio:</b>");
		dati.append(" ");
		dati.append(ufficioDirigente.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");

		dati.append("<p><b>Utente Richiedente:</b>");
		dati.append(" ");
		dati.append(nomeUtenteRichiedente.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");

		dati.append("<p><b>Telefono Richiedente:</b>");
		dati.append(" ");
		dati.append(telefonoRichiedente);
		dati.append("</p>");
		dati.append("</br>");

		dati.append("<p><b>Utente Referente:</b>");
		dati.append(" ");
		dati.append(utenteReferente.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");

		dati.append("<p><b>Telefono Referente:</b>");
		dati.append(" ");
		dati.append(telefonoReferente);
		dati.append("</p>");
		dati.append("</br>");

		return dati.toString();
	}

	private String getHtmlDatiMailRichiesta(String informazioneSala, String tipoEvento, String dataPerEmail,
			String oraInizioFinePerEmail, String numeroPartecipanti, String oggetto, String note,
			List<String> listServiziTechnici, List<String> listServiziEvent, List<String> listServiziLogistici) {

		StringBuilder dati = new StringBuilder();

		dati.append("<p><b>Sala:</b>");
		dati.append(" ");
		dati.append(informazioneSala.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");
		dati.append(" ");

		dati.append("<p><b>Tipologia Evento:</b>");
		dati.append(" ");
		dati.append(tipoEvento.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");
		dati.append(" ");

		dati.append("<p><b>Data:</b>");
		dati.append(" ");
		dati.append(dataPerEmail.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");
		dati.append(" ");

		dati.append("<p><b>Ora inizio e ora fine:</b>");
		dati.append(" ");
		dati.append(oraInizioFinePerEmail.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");
		dati.append(" ");

		dati.append("<p><b>Numero partecipanti:</b>");
		dati.append(" ");
		dati.append(numeroPartecipanti.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");
		dati.append(" ");

		dati.append("<p><b>Attivit&agrave; / Oggetto Riunione:</b>");
		dati.append(" ");
		dati.append(oggetto.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");
		dati.append(" ");

		dati.append("<p><b>Note:</b>");
		dati.append(" ");
		dati.append(note.toUpperCase());
		dati.append("</p>");
		dati.append("</br>");
		dati.append(" ");
		if (listServiziTechnici != null && !listServiziTechnici.isEmpty()) {
			dati.append("<p><b>Lista Strumentazione Tecnica:</b>");
			dati.append(" ");
			int sizeListServiziTechnici;
			sizeListServiziTechnici = listServiziTechnici.size();
			for (int i = 0; i < sizeListServiziTechnici; i++) {
				dati.append(listServiziTechnici.get(i).toUpperCase());
				if (i < sizeListServiziTechnici - 1) {
					dati.append(" , ");
				}
			}
			dati.append("</p>");
			dati.append("</br>");
			dati.append(" ");
		}

		if (listServiziEvent != null && !listServiziEvent.isEmpty()) {
			dati.append("<p><b>Strumentazione Tecnica per Eventi:</b>");
			dati.append(" ");
			for (int i = 0; i < listServiziEvent.size(); i++) {
				dati.append(listServiziEvent.get(i).toUpperCase());
				if (i < listServiziEvent.size() - 1) {
					dati.append(" , ");
				}
			}
			dati.append("</p>");
			dati.append("</br>");
			dati.append(" ");
		}

		if (listServiziLogistici != null && !listServiziLogistici.isEmpty()) {
			dati.append("<p><b>Servizi Logistici:</b>");
			dati.append(" ");
			for (int i = 0; i < listServiziLogistici.size(); i++) {
				dati.append(listServiziLogistici.get(i).toUpperCase());
				if (i < listServiziLogistici.size() - 1) {
					dati.append(" , ");
				}
			}
			dati.append("</p>");
			dati.append("</br>");
			dati.append(" ");
		}

		return dati.toString();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefPrenotazioneAuleConfig.class, properties);
	}

	private volatile MefPrenotazioneAuleConfig _configuration;

	public String getRichiestaNoApprovazioneTmpl(Map richiestaNoApprovazioneTmpl) {
		return (String) richiestaNoApprovazioneTmpl.get(_configuration.richiestaNoApprovazioneTmpl());
	}

	public String getRichiestaApprovazioneTmpl(Map richiestaApprovazioneTmpl) {
		return (String) richiestaApprovazioneTmpl.get(_configuration.richiestaApprovazioneTmpl());
	}

	public String getPrenotazioneAutorizzataTmpl(Map prenotazioneAutorizzataTmpl) {
		return (String) prenotazioneAutorizzataTmpl.get(_configuration.prenotazioneAutorizzataTmpl());
	}

	public String getPrenotazioneRifiutataTmpl(Map prenotazioneRifiutataTmpl) {
		return (String) prenotazioneRifiutataTmpl.get(_configuration.prenotazioneRifiutataTmpl());
	}

	public String getPrenotazioneModificataTmpl(Map prenotazioneModificataTmpl) {
		return (String) prenotazioneModificataTmpl.get(_configuration.prenotazioneModificataTmpl());
	}

	public String getPrenotazioneEliminataTmpl(Map prenotazioneEliminataTmpl) {
		return (String) prenotazioneEliminataTmpl.get(_configuration.prenotazioneEliminataTmpl());
	}

	public String getSender(Map sender) {
		return (String) sender.get(_configuration.sender());
	}

	public String getSubjectNoApprovazione(Map subjectNoApprovazione) {
		return (String) subjectNoApprovazione.get(_configuration.subjectNoApprovazione());
	}

	public String getSubjectApprovazione(Map subjectApprovazione) {
		return (String) subjectApprovazione.get(_configuration.subjectApprovazione());
	}

	public String getSubjectPrenotazioneAutorizzata(Map subjectPrenotazioneAutorizzata) {
		return (String) subjectPrenotazioneAutorizzata.get(_configuration.subjectPrenotazioneAutorizzata());
	}

	public String getSubjectPrenotazioneRifiutata(Map subjectPrenotazioneRifiutata) {
		return (String) subjectPrenotazioneRifiutata.get(_configuration.subjectPrenotazioneRifiutata());
	}

	public String getSubjectPrenotazioneModificata(Map subjectPrenotazioneModificata) {
		return (String) subjectPrenotazioneModificata.get(_configuration.subjectPrenotazioneModificata());
	}

	public String getSubjectPrenotazioneEliminata(Map subjectPrenotazioneEliminata) {
		return (String) subjectPrenotazioneEliminata.get(_configuration.subjectPrenotazioneEliminata());
	}

	@ProcessAction(name = "rifiutaPrenotazione")
	public void rifiutaPrenotazione(ActionRequest request, ActionResponse response)
			throws PortalException, ParseException, java.text.ParseException, IOException {

		try {

			String id_prenota = null;

			if (request.getParameter("id_prenota") != null) {
				id_prenota = request.getParameter("id_prenota");
			}

			HttpServletRequest httpServletrequest = PortalUtil.getHttpServletRequest(request);

			long companyId = PortalUtil.getCompanyId(httpServletrequest);

			boolean resultEmail;

			if (id_prenota != null && !("0").equals(id_prenota)) {

				Prenotazione prenotazione = PrenotazioneLocalServiceUtil.getPrenotazione(Long.parseLong(id_prenota));

				String emailRichiedente;
				String emailApprover;

				List<String> strumentazioneTecnicaList = new ArrayList<String>(0);
				List<String> listServiziTecnici = new ArrayList<String>(0);

				List<String> strumentazioneEventoList = new ArrayList<String>(0);
				List<String> listServiziEventi = new ArrayList<String>(0);

				List<String> strumentazioneLogisticiList = new ArrayList<String>(0);
				List<String> listServiziLogistici = new ArrayList<String>(0);

				EmailSender mail = new EmailSender();

				prenotazione.setId_stato(4);

				PrenotazioneLocalServiceUtil.updatePrenotazione(prenotazione);

				User utenteRichiedente = UserLocalServiceUtil.getUserByScreenName(companyId,
						prenotazione.getCod_fiscale());

				emailRichiedente = utenteRichiedente.getEmailAddress();

				User approverUser = PortalUtil.getUser(request);

				emailApprover = approverUser.getEmailAddress();

				// Retrieve attendant's data for request mail body
				JSONObject richiedenteJsonObj = JSONFactoryUtil.createJSONObject(prenotazione.getDati_rich());
				String ufficioRichiedente = (String) richiedenteJsonObj.get("ufficiorichiedente");
				String ufficioDirigente = (String) richiedenteJsonObj.get("dirigenteufficio");
				String utenteRichiedenteJson = (String) richiedenteJsonObj.get("utenterichiedente");
				String telefonoRichiedente = (String) richiedenteJsonObj.get("telefonorichiedente");
				String utenteReferente = (String) richiedenteJsonObj.get("referente");
				String telefonoReferente = (String) richiedenteJsonObj.get("telefonoreferente");

				long id_sala = prenotazione.getId_sala();
				Sala sala = SalaLocalServiceUtil.getSala(id_sala);
				String descSala = sala.getDesc_sala();
				String indirizzoSala = sala.getIndirizzo();

				StringBuilder descIndirizzoSala = new StringBuilder();
				descIndirizzoSala.append(descSala);
				descIndirizzoSala.append(" - ");
				descIndirizzoSala.append(indirizzoSala);
				String informazioneSala = descIndirizzoSala.toString();

				long id_TipoEvento = prenotazione.getId_evento();
				String descEvento = TipoEventoLocalServiceUtil.getTipoEvento(id_TipoEvento).getDesc_evento();

				Date dataInizio = prenotazione.getData_inizio();
				Date dataFine = prenotazione.getData_fine();

				SimpleDateFormat parserOraInizio = new SimpleDateFormat("HH:mm");
				String oraInizioPrenotazione = parserOraInizio.format(dataInizio);

				SimpleDateFormat parserFineInizio = new SimpleDateFormat("HH:mm");

				int minutiCorretti = dataFine.getMinutes() + 1;
				dataFine.setMinutes(minutiCorretti);

				String oraFineEmail = parserFineInizio.format(dataFine);

				StringBuilder oraInizioFinePrenotazione = new StringBuilder();
				oraInizioFinePrenotazione.append(oraInizioPrenotazione);
				oraInizioFinePrenotazione.append(" - ");
				oraInizioFinePrenotazione.append(oraFineEmail);

				String oraInizioFine = oraInizioFinePrenotazione.toString();

				int numeroPartecipanti = prenotazione.getPartecipanti();
				String oggetto = prenotazione.getAttivita();
				String note = prenotazione.getNote();

				JSONObject serviziJsonObj = JSONFactoryUtil.createJSONObject(prenotazione.getServizi());

				JSONArray strumentazione_tecnica = (JSONArray) serviziJsonObj.getJSONArray("strumentazionetecnica");

				if (strumentazione_tecnica != null) {
					for (int j = 0; j < strumentazione_tecnica.length(); j++) {
						strumentazioneTecnicaList.add((String) strumentazione_tecnica.getString(j));
					}
				}

				if (!strumentazioneTecnicaList.isEmpty()) {
					for (String strumentazione : strumentazioneTecnicaList) {
						if (StrumentoTecLocalServiceUtil.getStrumentoTecListByDescStrumento(strumentazione) != null) {
							for (StrumentoTec st : StrumentoTecLocalServiceUtil
									.getStrumentoTecListByDescStrumento(strumentazione)) {
								listServiziTecnici.add(String.valueOf(st.getId_strumento()));
							}
						}
					}
				}

				JSONArray strumentazioneEvento = (JSONArray) serviziJsonObj.getJSONArray("strumentazionetecnicaevento");

				if (strumentazioneEvento != null) {
					for (int j = 0; j < strumentazioneEvento.length(); j++) {
						strumentazioneEventoList.add((String) strumentazioneEvento.getString(j));
					}
				}

				if (!strumentazioneEventoList.isEmpty()) {
					for (String strumentazioneEvent : strumentazioneEventoList) {
						if (StrumentoEventoLocalServiceUtil
								.getStrumentoEventoListByDescStrumento(strumentazioneEvent) != null) {
							for (StrumentoEvento stEvento : StrumentoEventoLocalServiceUtil
									.getStrumentoEventoListByDescStrumento(strumentazioneEvent)) {
								listServiziEventi.add(String.valueOf(stEvento.getId_strumento()));
							}
						}
					}
				}

				JSONArray logistici = (JSONArray) serviziJsonObj.getJSONArray("servizilogistici");

				if (logistici != null) {
					for (int j = 0; j < logistici.length(); j++) {
						strumentazioneLogisticiList.add((String) logistici.getString(j));
					}
				}

				if (!strumentazioneLogisticiList.isEmpty()) {
					for (String strumentazioneLogistici : strumentazioneLogisticiList) {
						if (ServizioLogLocalServiceUtil
								.getServizioLogListByDescServizio(strumentazioneLogistici) != null) {
							for (ServizioLog servizioLog : ServizioLogLocalServiceUtil
									.getServizioLogListByDescServizio(strumentazioneLogistici)) {
								listServiziLogistici.add(String.valueOf(servizioLog.getId_servizio()));
							}
						}
					}
				}

				/*
				 * creating list of referent people email addresses (of sala and
				 * services)
				 */
				List<String> referentiEmailList = getReferentiEmailList(listServiziTecnici, listServiziEventi,
						listServiziLogistici, String.valueOf(id_sala));

				String datiRichiedente = getHtmlDatiMailRichiedente(ufficioRichiedente, ufficioDirigente,
						utenteRichiedenteJson, telefonoRichiedente, utenteReferente, telefonoReferente);
				String datiRichieste = getHtmlDatiMailRichiesta(informazioneSala, descEvento,
						new SimpleDateFormat("dd/MM/yyyy").format(dataInizio), oraInizioFine,
						String.valueOf(numeroPartecipanti), oggetto, note, strumentazioneTecnicaList,
						strumentazioneEventoList, strumentazioneLogisticiList);
				String subject = request.getPreferences().getValue("subjectPrenotazioneRifiutata",
						_configuration.subjectPrenotazioneRifiutata());
				String mailbody = request.getPreferences().getValue("prenotazioneRifiutataTmpl",
						_configuration.prenotazioneRifiutataTmpl());
				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]" },
						new String[] { datiRichiedente, datiRichieste });
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String sender = request.getPreferences().getValue("sender", _configuration.sender());

				// Send email to listEmailApprovatoriSala
				if (emailApprover != null && !"".equals(emailApprover)) {
					resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailApprover, null, null);
					if (resultEmail) {
						_log.debug("Email inviata correttamente all'indirizzo " + emailApprover);
					} else {
						_log.debug("Errore durante l'invio della mail all'indirizzo " + emailApprover);
					}
				}

				// Send email to applicant (richiedente)
				if (emailRichiedente != null && !"".equals(emailRichiedente)) {
					resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRichiedente, null,
							null);
					if (resultEmail) {
						_log.debug("Email inviata correttamente all'indirizzo " + emailRichiedente);
					} else {
						_log.debug("Errore durante l'invio della mail all'indirizzo " + emailRichiedente);
					}
				}

				// Send email to referentiEmailList
				if (referentiEmailList != null && !referentiEmailList.isEmpty()) {
					for (String emailReferenteAddress : referentiEmailList) {
						resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferenteAddress,
								null, null);
						if (resultEmail) {
							_log.debug("Email inviata correttamente all'indirizzo " + emailReferenteAddress);
						} else {
							_log.debug("Errore durante l'invio della mail all'indirizzo " + emailReferenteAddress);
						}
					}
				}
			}

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL urlRefresh = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			response.sendRedirect(urlRefresh.toString());

		} catch (NoSuchUserException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}
	}

	@ProcessAction(name = "accettaPrenotazione")
	public void accettaPrenotazione(ActionRequest request, ActionResponse response) throws PortalException,
			ParseException, java.text.ParseException, WindowStateException, PortletModeException, IOException {

		try {

			String id_prenota = null;

			if (request.getParameter("id_prenota") != null) {
				id_prenota = request.getParameter("id_prenota");
			}

			HttpServletRequest httpServletrequest = PortalUtil.getHttpServletRequest(request);

			long companyId = PortalUtil.getCompanyId(httpServletrequest);

			boolean resultEmail;

			if (id_prenota != null && !("0").equals(id_prenota)) {

				Prenotazione prenotazione = PrenotazioneLocalServiceUtil.getPrenotazione(Long.parseLong(id_prenota));

				String emailRichiedente;
				String emailApprover;

				List<String> strumentazioneTecnicaList = new ArrayList<String>();
				List<String> listServiziTecnici = new ArrayList<String>(0);

				List<String> strumentazioneEventoList = new ArrayList<String>();
				List<String> listServiziEventi = new ArrayList<String>(0);

				List<String> strumentazioneLogisticiList = new ArrayList<String>();
				List<String> listServiziLogistici = new ArrayList<String>(0);

				EmailSender mail = new EmailSender();

				prenotazione.setId_stato(2);

				PrenotazioneLocalServiceUtil.updatePrenotazione(prenotazione);

				User utenteRichiedente = UserLocalServiceUtil.getUserByScreenName(companyId,
						prenotazione.getCod_fiscale());

				emailRichiedente = utenteRichiedente.getEmailAddress();

				User approverUser = PortalUtil.getUser(request);

				emailApprover = approverUser.getEmailAddress();

				// Retrieve attendant's data for request mail body
				JSONObject richiedenteJsonObj = JSONFactoryUtil.createJSONObject(prenotazione.getDati_rich());
				String ufficioRichiedente = (String) richiedenteJsonObj.get("ufficiorichiedente");
				String ufficioDirigente = (String) richiedenteJsonObj.get("dirigenteufficio");
				String utenteRichiedenteJson = (String) richiedenteJsonObj.get("utenterichiedente");
				String telefonoRichiedente = (String) richiedenteJsonObj.get("telefonorichiedente");
				String utenteReferente = (String) richiedenteJsonObj.get("referente");
				String telefonoReferente = (String) richiedenteJsonObj.get("telefonoreferente");

				long id_sala = prenotazione.getId_sala();
				Sala sala = SalaLocalServiceUtil.getSala(id_sala);
				String descSala = sala.getDesc_sala();
				String indirizzoSala = sala.getIndirizzo();

				StringBuilder descIndirizzoSala = new StringBuilder();
				descIndirizzoSala.append(descSala);
				descIndirizzoSala.append(" - ");
				descIndirizzoSala.append(indirizzoSala);

				String informazioneSala = descIndirizzoSala.toString();

				long id_TipoEvento = prenotazione.getId_evento();
				String descEvento = TipoEventoLocalServiceUtil.getTipoEvento(id_TipoEvento).getDesc_evento();

				Date dataInizio = prenotazione.getData_inizio();
				Date dataFine = prenotazione.getData_fine();

				SimpleDateFormat parserOraInizio = new SimpleDateFormat("HH:mm");
				String oraInizioPrenotazione = parserOraInizio.format(dataInizio);

				SimpleDateFormat parserFineInizio = new SimpleDateFormat("HH:mm");

				int minutiCorretti = dataFine.getMinutes() + 1;
				dataFine.setMinutes(minutiCorretti);

				String oraFineEmail = parserFineInizio.format(dataFine);

				StringBuilder oraInizioFinePrenotazione = new StringBuilder();
				oraInizioFinePrenotazione.append(oraInizioPrenotazione);
				oraInizioFinePrenotazione.append(" - ");
				oraInizioFinePrenotazione.append(oraFineEmail);

				String oraInizioFine = oraInizioFinePrenotazione.toString();

				int numeroPartecipanti = prenotazione.getPartecipanti();
				String oggetto = prenotazione.getAttivita();
				String note = prenotazione.getNote();

				JSONObject serviziJsonObj = JSONFactoryUtil.createJSONObject(prenotazione.getServizi());

				JSONArray strumentazione_tecnica = (JSONArray) serviziJsonObj.getJSONArray("strumentazionetecnica");

				if (strumentazione_tecnica != null) {
					for (int j = 0; j < strumentazione_tecnica.length(); j++) {
						strumentazioneTecnicaList.add((String) strumentazione_tecnica.getString(j));
					}
				}

				if (!strumentazioneTecnicaList.isEmpty()) {
					for (String strumentazione : strumentazioneTecnicaList) {
						if (StrumentoTecLocalServiceUtil.getStrumentoTecListByDescStrumento(strumentazione) != null) {
							for (StrumentoTec st : StrumentoTecLocalServiceUtil
									.getStrumentoTecListByDescStrumento(strumentazione)) {
								listServiziTecnici.add(String.valueOf(st.getId_strumento()));
							}
						}
					}
				}

				JSONArray strumentazioneEvento = (JSONArray) serviziJsonObj.getJSONArray("strumentazionetecnicaevento");

				if (strumentazioneEvento != null) {
					for (int j = 0; j < strumentazioneEvento.length(); j++) {
						strumentazioneEventoList.add((String) strumentazioneEvento.getString(j));
					}
				}

				if (!strumentazioneEventoList.isEmpty()) {
					for (String strumentazioneEvent : strumentazioneEventoList) {
						if (StrumentoEventoLocalServiceUtil
								.getStrumentoEventoListByDescStrumento(strumentazioneEvent) != null) {
							for (StrumentoEvento stEvento : StrumentoEventoLocalServiceUtil
									.getStrumentoEventoListByDescStrumento(strumentazioneEvent)) {
								listServiziEventi.add(String.valueOf(stEvento.getId_strumento()));
							}
						}
					}
				}

				JSONArray logisitici = (JSONArray) serviziJsonObj.getJSONArray("servizilogistici");

				if (logisitici != null) {
					for (int j = 0; j < logisitici.length(); j++) {
						strumentazioneLogisticiList.add((String) logisitici.getString(j));
					}
				}

				if (!strumentazioneLogisticiList.isEmpty()) {
					for (String strumentazioneLogistici : strumentazioneLogisticiList) {
						if (ServizioLogLocalServiceUtil
								.getServizioLogListByDescServizio(strumentazioneLogistici) != null) {
							for (ServizioLog servizioLog : ServizioLogLocalServiceUtil
									.getServizioLogListByDescServizio(strumentazioneLogistici)) {
								listServiziLogistici.add(String.valueOf(servizioLog.getId_servizio()));
							}
						}
					}
				}

				/*
				 * creating list of referent people email addresses (of sala and
				 * services)
				 */
				List<String> referentiEmailList = getReferentiEmailList(listServiziTecnici, listServiziEventi,
						listServiziLogistici, String.valueOf(id_sala));

				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
						themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrl.setWindowState(LiferayWindowState.NORMAL);
				renderUrl.setPortletMode(LiferayPortletMode.VIEW);
				renderUrl.setParameter("prenotazioneId", Long.toString(prenotazione.getId_prenota()));
				renderUrl.setParameter("navigation", "linkdettaglio");
				String datiRichiedente = getHtmlDatiMailRichiedente(ufficioRichiedente, ufficioDirigente,
						utenteRichiedenteJson, telefonoRichiedente, utenteReferente, telefonoReferente);
				String datiRichieste = getHtmlDatiMailRichiesta(informazioneSala, descEvento,
						new SimpleDateFormat("dd/MM/yyyy").format(dataInizio), oraInizioFine,
						String.valueOf(numeroPartecipanti), oggetto, note, strumentazioneTecnicaList,
						strumentazioneEventoList, strumentazioneLogisticiList);
				String subject = request.getPreferences().getValue("subjectPrenotazioneAutorizzata",
						_configuration.subjectPrenotazioneAutorizzata());
				String mailbody = request.getPreferences().getValue("prenotazioneAutorizzataTmpl",
						_configuration.prenotazioneAutorizzataTmpl());
				mailbody = StringUtil.replace(mailbody, new String[] { "[$DATIRICHIEDENTE$]", "[$DATI$]", "[$LINK$]" },
						new String[] { datiRichiedente, datiRichieste, renderUrl.toString() });
				String smtpUser = PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
				String sender = request.getPreferences().getValue("sender", _configuration.sender());

				// Send email to listEmailApprovatoriSala
				if (emailApprover != null && !"".equals(emailApprover)) {
					resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailApprover, null, null);
					if (resultEmail) {
						_log.debug("Email inviata correttamente all'indirizzo " + emailApprover);
					} else {
						_log.debug("Errore durante l'invio della mail all'indirizzo " + emailApprover);
					}
				}

				// Send email to applicant (richiedente)
				if (emailRichiedente != null && !"".equals(emailRichiedente)) {
					resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailRichiedente, null,
							null);
					if (resultEmail) {
						_log.debug("Email inviata correttamente all'indirizzo " + emailRichiedente);
					} else {
						_log.debug("Errore durante l'invio della mail all'indirizzo " + emailRichiedente);
					}
				}

				// Send email to referentiEmailList
				if (referentiEmailList != null && !referentiEmailList.isEmpty()) {
					for (String emailReferenteAddress : referentiEmailList) {
						resultEmail = mail.sendMailMessage(subject, mailbody, sender, smtpUser, emailReferenteAddress,
								null, null);
						if (resultEmail) {
							_log.debug("Email inviata correttamente all'indirizzo " + emailReferenteAddress);
						} else {
							_log.debug("Errore durante l'invio della mail all'indirizzo " + emailReferenteAddress);
						}
					}
				}

				PortletURL urlRefresh = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
						themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				response.sendRedirect(urlRefresh.toString());

			}
		} catch (NoSuchUserException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		}
	}

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

	private List<String> getReferentiEmailList(List<String> listServiziTecnici, List<String> listServiziEventi,
			List<String> listServiziLogistici, String idSala) throws NumberFormatException, PortalException {

		List<String> allReferentiEmailAddressesList = new ArrayList<String>(0);
		Set<String> allReferentiEmailAddressesSet = new HashSet<String>(0);

		if (listServiziTecnici != null && !listServiziTecnici.isEmpty()) {
			for (int i = 0; i < listServiziTecnici.size(); i++) {

				StrumTecPK strumTecPK = new StrumTecPK();
				strumTecPK.setId_sala(Long.parseLong(idSala));
				strumTecPK.setId_strum(Long.parseLong(listServiziTecnici.get(i)));
				String emailReferentiServiziTecnici = "";
				StrumTec strumTec = StrumTecLocalServiceUtil.fetchStrumTec(strumTecPK);

				if (strumTec != null) {
					emailReferentiServiziTecnici = strumTec.getEmail_ref();
				}

				if (emailReferentiServiziTecnici != null && !("").equals(emailReferentiServiziTecnici)) {

					List<String> emailReferentiServiziTecniciList = getListEmail(emailReferentiServiziTecnici);

					for (String emailReferenteServizioTecnico : emailReferentiServiziTecniciList) {
						allReferentiEmailAddressesList.add(emailReferenteServizioTecnico.trim());
					}
				}
			}
		}

		if (listServiziEventi != null && !listServiziEventi.isEmpty()) {
			for (int i = 0; i < listServiziEventi.size(); i++) {

				StrumEventoPK strumEventoPK = new StrumEventoPK();
				strumEventoPK.setId_sala(Long.parseLong(idSala));
				strumEventoPK.setId_strum(Long.parseLong(listServiziEventi.get(i)));
				String emailReferentiServiziEventi = "";
				StrumEvento strumEvento = StrumEventoLocalServiceUtil.fetchStrumEvento(strumEventoPK);

				if (strumEvento != null) {
					emailReferentiServiziEventi = strumEvento.getEmail_ref();
				}

				if (emailReferentiServiziEventi != null && !("").equals(emailReferentiServiziEventi)) {

					List<String> emailReferentiServiziEventiList = getListEmail(emailReferentiServiziEventi);

					for (String emailReferenteServizioEvento : emailReferentiServiziEventiList) {
						allReferentiEmailAddressesList.add(emailReferenteServizioEvento.trim());
					}
				}
			}
		}

		if (listServiziLogistici != null && !listServiziLogistici.isEmpty()) {
			for (int i = 0; i < listServiziLogistici.size(); i++) {

				ServLogPK servLogPK = new ServLogPK();
				servLogPK.setId_sala(Long.parseLong(idSala));
				servLogPK.setId_serv(Long.parseLong(listServiziLogistici.get(i)));
				String emailReferentiServiziLogistici = "";
				ServLog servLog = ServLogLocalServiceUtil.fetchServLog(servLogPK);

				if (servLog != null) {
					emailReferentiServiziLogistici = servLog.getEmail_ref();
				}

				if (emailReferentiServiziLogistici != null && !("").equals(emailReferentiServiziLogistici)) {

					List<String> emailReferentiServiziLogisticiList = getListEmail(emailReferentiServiziLogistici);

					for (String emailReferenteServizioLogistico : emailReferentiServiziLogisticiList) {
						allReferentiEmailAddressesList.add(emailReferenteServizioLogistico.trim());
					}
				}
			}
		}

		String emailReferentiSala = SalaLocalServiceUtil.getSala(Long.parseLong(idSala)).getEmail_ref();

		if (emailReferentiSala != null && !("").equals(emailReferentiSala)) {

			List<String> emailReferentiSalaList = getListEmail(emailReferentiSala);

			for (String emailReferenteSala : emailReferentiSalaList) {
				allReferentiEmailAddressesList.add(emailReferenteSala.trim());
			}
		}

		allReferentiEmailAddressesSet.addAll(allReferentiEmailAddressesList);
		allReferentiEmailAddressesList.clear();
		allReferentiEmailAddressesList.addAll(allReferentiEmailAddressesSet);

		return allReferentiEmailAddressesList;

	}

	private void populateOrarioTable() {
		if (OrarioLocalServiceUtil.getOrariosCount() == 0) {

			List<String> orari = new ArrayList<String>(0);
			orari.add("07:00");
			orari.add("07:30");
			orari.add("08:00");
			orari.add("08:30");
			orari.add("09:00");
			orari.add("09:30");
			orari.add("10:00");
			orari.add("10:30");
			orari.add("11:00");
			orari.add("11:30");
			orari.add("12:00");
			orari.add("12:30");
			orari.add("13:00");
			orari.add("13:30");
			orari.add("14:00");
			orari.add("14:30");
			orari.add("15:00");
			orari.add("15:30");
			orari.add("16:00");
			orari.add("16:30");
			orari.add("17:00");
			orari.add("17:30");
			orari.add("18:00");
			orari.add("18:30");
			orari.add("19:00");
			orari.add("19:30");
			orari.add("20:00");

			for (int indexOrari = 0; indexOrari < orari.size(); indexOrari++) {
				Orario orario = OrarioLocalServiceUtil.createOrario(indexOrari + 1);
				orario.setOre(orari.get(indexOrari));
				OrarioLocalServiceUtil.addOrario(orario);
			}
		}
	}

	private void populateServizioLogTable() {
		if (ServizioLogLocalServiceUtil.getServizioLogsCount() == 0) {

			List<String> servizi = new ArrayList<String>(0);
			servizi.add("allestimento sala polivalente");
			servizi.add("servizio di accoglienza");
			servizi.add("servizio di interpretariato");
			servizi.add("servizio di riproduzione materiale");
			servizi.add("predisposizione, stampa e recapito di inviti");
			String email_ref = "";
			for (int indexServizi = 0; indexServizi < servizi.size(); indexServizi++) {
				ServizioLog servizioLog = ServizioLogLocalServiceUtil.createServizioLog(indexServizi + 1);
				servizioLog.setDesc_servizio(servizi.get(indexServizi));
				servizioLog.setEmail_ref(email_ref);
				ServizioLogLocalServiceUtil.addServizioLog(servizioLog);
			}
		}
	}

	private void populateStrumentoEventoTable() {
		if (StrumentoEventoLocalServiceUtil.getStrumentoEventosCount() == 0) {

			List<String> strumentievento = new ArrayList<String>(0);
			strumentievento.add("cabina di regia (2gg)");
			strumentievento.add("videconferenza (9gg)");
			strumentievento.add("caricamento slide su supporto informatico");
			strumentievento.add("assistenza utilizzo di strumentazione tecnica");
			strumentievento.add("ripresa evento");
			strumentievento.add("riprese fotografiche");
			strumentievento.add("registrazione evento");
			strumentievento.add("montaggio/editing");
			strumentievento.add("realizzazione dvd");
			strumentievento.add("pubblicazione sul sito");
			String email_ref = "";
			for (int indexStrumentievento = 0; indexStrumentievento < strumentievento.size(); indexStrumentievento++) {
				StrumentoEvento strumentoEvento = StrumentoEventoLocalServiceUtil
						.createStrumentoEvento(indexStrumentievento + 1);
				strumentoEvento.setDesc_strumento(strumentievento.get(indexStrumentievento));
				strumentoEvento.setEmail_ref(email_ref);
				StrumentoEventoLocalServiceUtil.addStrumentoEvento(strumentoEvento);
			}
		}
	}

	private void populateStrumentoTecTable() {
		if (StrumentoTecLocalServiceUtil.getStrumentoTecsCount() == 0) {

			List<String> strumentitec = new ArrayList<String>(0);
			strumentitec.add("personal computer portatile");
			strumentitec.add("connessione internet/intranet");
			strumentitec.add("proiettore slide");
			strumentitec.add("microfoni a cono");
			String email_ref = "";
			for (int indexStrumentitec = 0; indexStrumentitec < strumentitec.size(); indexStrumentitec++) {
				StrumentoTec strumentoTec = StrumentoTecLocalServiceUtil.createStrumentoTec(indexStrumentitec + 1);
				strumentoTec.setDesc_strumento(strumentitec.get(indexStrumentitec));
				strumentoTec.setEmail_ref(email_ref);
				StrumentoTecLocalServiceUtil.addStrumentoTec(strumentoTec);
			}
		}
	}

	private void populateTipoEventoTable() {
		if (TipoEventoLocalServiceUtil.getTipoEventosCount() == 0) {

			List<String> tipievento = new ArrayList<String>(0);
			tipievento.add("riunione / gruppo di lavoro /  presentazione");
			tipievento.add("convegno / seminario");
			tipievento.add("incontro con delegazioni estere");
			tipievento.add("conferenza stampa");

			for (int indexTipievento = 0; indexTipievento < tipievento.size(); indexTipievento++) {
				TipoEvento tipoEvento = TipoEventoLocalServiceUtil.createTipoEvento(indexTipievento + 1);
				tipoEvento.setDesc_evento(tipievento.get(indexTipievento));
				TipoEventoLocalServiceUtil.addTipoEvento(tipoEvento);
			}
		}
	}

	private void populateStatoAulaTable() {
		if (StatoAulaLocalServiceUtil.getStatoAulasCount() == 0) {

			List<String> statiaula = new ArrayList<String>(0);
			statiaula.add("disponibile");
			statiaula.add("prenotata");
			statiaula.add("da approvare");
			statiaula.add("rifiutata");
			for (int indexStatoAula = 0; indexStatoAula < statiaula.size(); indexStatoAula++) {
				StatoAula statoAula = StatoAulaLocalServiceUtil.createStatoAula(indexStatoAula + 1);
				statoAula.setDesc_stato(statiaula.get(indexStatoAula));
				StatoAulaLocalServiceUtil.addStatoAula(statoAula);
			}
		}
	}
}