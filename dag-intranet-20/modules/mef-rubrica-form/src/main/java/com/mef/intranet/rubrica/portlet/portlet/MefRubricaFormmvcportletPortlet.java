package com.mef.intranet.rubrica.portlet.portlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mef.intranet.rubrica.model.SearchData;
import com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil;
import com.mef.intranet.rubrica.stub.AnagraficaVOBean;
import com.mef.intranet.rubrica.stub.Qualifica;
import com.mef.intranet.rubrica.stub.Struttura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO;
import it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO;
import it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO;
import it.intranetdag.rubrica.services.vo.xsd.TagVO;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=mef-rubrica-form Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MefRubricaFormmvcportletPortlet extends MVCPortlet {
	
final Log _log = LogFactoryUtil.getLog(MefRubricaFormmvcportletPortlet.class); 
	
User utente;
	
@Override
	public void doView(RenderRequest request,RenderResponse response) throws IOException, PortletException {
		
		request.setAttribute(MefRubricaFormConfig.class.getName(), _configuration); 
	    String lastResearch=_configuration.lastResearch();
		
		List<Qualifica> list_qualifiche = loadQualifiche();
		request.setAttribute("listaQualifiche", list_qualifiche);
		
		List<Struttura> list_strutture = loadStruttureMadri();
		request.setAttribute("listaStrutture", list_strutture);
				
		List<TagVO> listNuvola=new ArrayList<>();
		List<SearchData> last_results=new ArrayList<>();
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			utente=themeDisplay.getUser();
			String screenNameUser=utente.getScreenName();
		
			last_results=SearchDataLocalServiceUtil.getLastResult(Integer.parseInt(lastResearch),screenNameUser.toLowerCase());
	      //  last_results=SearchDataLocalServiceUtil.getLastResult(Integer.parseInt(lastResearch));	
			request.setAttribute("ultime_ricerche", last_results);
			SearchDataLocalServiceUtil.getAlfabetoTag();
		    listNuvola=SearchDataLocalServiceUtil.getNuvolaTag(10);
		
		} catch (Exception e) {
			_log.warn(e);
		}
		request.setAttribute("nuvolaTag", listNuvola);
		super.doView(request, response);
}
	
	private String replaceWithApostrophe(String s) {
		if (s != null)
			return s.replaceAll("'", "&#39;");
		return s;
	}
	
	@ProcessAction(name = "ricercaPersone")
	public void ricercaPersone(ActionRequest request, ActionResponse response) throws Exception {
		
		try {
			
			List<String> filtriRicercaPersone = new ArrayList<String>(0);
			// Dati che provengono dal form ricerca persone
			String cognome = null;
			if (request.getParameter("surname") != null && !("").equals(request.getParameter("surname").toString())) {
				cognome = request.getParameter("surname").toString();
				filtriRicercaPersone.add(cognome.toUpperCase());
			}
			String nome = null;
			if (request.getParameter("name") != null && !("").equals(request.getParameter("name").toString())) {
				nome = request.getParameter("name").toString();
				filtriRicercaPersone.add(nome.toUpperCase());
			}
			String qualifica = null;
			if (request.getParameter("qualification") != null && !("0").equals(request.getParameter("qualification").toString())) {
				qualifica = request.getParameter("qualification").toString();
			}
			String descQualifica = null;
			if (qualifica != null && !("").equals(qualifica)) {
				if (("DIR01F").equals(qualifica)) {
					descQualifica = "DIRIG. I FASCIA";
				} else if (("DIR02F").equals(qualifica)) {
					descQualifica = "DIRIG. II FASCIA";
				} else {
					descQualifica = qualifica;
				}
				filtriRicercaPersone.add(descQualifica);
			}
			String struttura = null;
			if (request.getParameter("structure") != null && !("0").equals(request.getParameter("structure").toString())) {
				struttura = request.getParameter("structure").toString();
			}
			String strutturaMadre = null;
			if (struttura != null && !("").equals(struttura)) {
				if (("847").equals(struttura)) {
					strutturaMadre = "MEF";
				} else if (("CONSIP").equals(struttura)) {
					strutturaMadre = "CONSIP";
				} else if (("SOGEI").equals(struttura)) {
					strutturaMadre = "SOGEI";
				}
				filtriRicercaPersone.add(strutturaMadre);
			}
			String strutturaUnoId = null;
			String strutturaUnoDesc = null;
			if (request.getParameter("structure-one") != null && !("").equals(request.getParameter("structure-one").toString())) {
				strutturaUnoId = request.getParameter("structure-one").toString();
				strutturaUnoDesc = (SearchDataLocalServiceUtil.servDettagliUfficio(strutturaUnoId)).get(0).getAcronimo().getValue();
				filtriRicercaPersone.add(strutturaUnoDesc);
			}
			String strutturaDueId = null;
			String strutturaDueDesc = null;
			if (request.getParameter("structure-two") != null && !("").equals(request.getParameter("structure-two").toString())) {
				strutturaDueId = request.getParameter("structure-two").toString();
				strutturaDueDesc = (SearchDataLocalServiceUtil.servDettagliUfficio(strutturaDueId)).get(0).getDescrizione().getValue();
				filtriRicercaPersone.add(strutturaDueDesc);
			}
			String strutturaTreId = null;
			String strutturaTreDesc = null;
			if (request.getParameter("structure-three") != null && !("").equals(request.getParameter("structure-three").toString())) {
				strutturaTreId = request.getParameter("structure-three").toString();
				strutturaTreDesc = (SearchDataLocalServiceUtil.servDettagliUfficio(strutturaTreId)).get(0).getDescrizione().getValue();
				filtriRicercaPersone.add(strutturaTreDesc);
			}
			String strutturaQuattroId = null;
			String strutturaQuattroDesc = null;
			if (request.getParameter("structure-four") != null && !("").equals(request.getParameter("structure-four").toString())) {
				strutturaQuattroId = request.getParameter("structure-four").toString();
				strutturaQuattroDesc = (SearchDataLocalServiceUtil.servDettagliUfficio(strutturaQuattroId)).get(0).getDescrizione()
				.getValue();
				filtriRicercaPersone.add(strutturaQuattroDesc);
			}
			//save filtropersone in session
			PortletSession session = request.getPortletSession();
			session.setAttribute("filtroPersone", filtriRicercaPersone, PortletSession.APPLICATION_SCOPE);
			List<AnagraficaVO> risultatiPersone = SearchDataLocalServiceUtil.getListPersone(strutturaUnoId, strutturaDueId, nome, qualifica,
			cognome, struttura, strutturaQuattroId, strutturaTreId);
			List<AnagraficaVOBean> listAnagraficaVOBean = new ArrayList<>(0);
			
			String arrJsonPersone = "";
			ObjectMapper mapper = new ObjectMapper();

			List<List<AnagraficaVOBean>> listAnagraficaBean = new ArrayList<List<AnagraficaVOBean>>();
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			if (!risultatiPersone.isEmpty()) {
			

				for (AnagraficaVO anagraficaVO : risultatiPersone) {
					AnagraficaVOBean anagraficaVOBean = new AnagraficaVOBean();
					anagraficaVOBean.setAcronimo(replaceWithApostrophe(anagraficaVO.getAcronimo().getValue()));
					anagraficaVOBean.setCellulare(anagraficaVO.getCellulare().getValue());
					anagraficaVOBean.setEmailAddress(anagraficaVO.getEmailAddress().getValue());
					anagraficaVOBean.setFax(anagraficaVO.getFax().getValue());
					anagraficaVOBean.setFaxUff(anagraficaVO.getFaxUff().getValue());
					anagraficaVOBean.setFirstName(replaceWithApostrophe(anagraficaVO.getFirstName().getValue()));
					anagraficaVOBean.setIncarico(replaceWithApostrophe(anagraficaVO.getIncarico().getValue()));
					anagraficaVOBean.setLastName(replaceWithApostrophe(anagraficaVO.getLastName().getValue()));
					anagraficaVOBean.setLiv1(anagraficaVO.getLiv1().getValue());
					anagraficaVOBean.setLiv2(anagraficaVO.getLiv2().getValue());
					anagraficaVOBean.setLiv3(anagraficaVO.getLiv3().getValue());
					anagraficaVOBean.setLiv4(anagraficaVO.getLiv4().getValue());
					anagraficaVOBean.setLivello1(replaceWithApostrophe(anagraficaVO.getLivello1().getValue()));
					anagraficaVOBean.setLivello2(replaceWithApostrophe(anagraficaVO.getLivello2().getValue()));
					anagraficaVOBean.setPosizione(anagraficaVO.getPosizione().getValue());
					anagraficaVOBean.setSede(replaceWithApostrophe(anagraficaVO.getSede().getValue()));
					anagraficaVOBean.setTelUffi1(anagraficaVO.getTelUffi1().getValue());
					anagraficaVOBean.setTelUffi2(anagraficaVO.getTelUffi2().getValue());
					anagraficaVOBean.setUbicazione(replaceWithApostrophe(anagraficaVO.getUbicazione().getValue()));
					anagraficaVOBean.setComandato(anagraficaVO.getComandato().getValue());
					anagraficaVOBean.setComandatoUffDestinazione(replaceWithApostrophe(anagraficaVO.getComandatoUffDestinazione().getValue()));
					User utente = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), anagraficaVO.getEmailAddress().getValue());
                	String avatar = themeDisplay.getPathImage()+"/user_male_portrait?img_id=0";
					if (utente!=null) {
						avatar = utente.getPortraitURL(themeDisplay);
					}
					anagraficaVOBean.setUrlImage(avatar);
					listAnagraficaVOBean.add(anagraficaVOBean);
				}
				Collections.sort(listAnagraficaVOBean, new Comparator<AnagraficaVOBean>() {
					@Override
					public int compare(AnagraficaVOBean p1, AnagraficaVOBean p2) {
						int res = p1.getLastName().compareToIgnoreCase(p2.getLastName());
						if (res != 0)
							return res;
						return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
					}
				});
				//pagination		
				String itemsperPage = request.getPreferences().getValue("itemsPerPage",Integer.toString(_configuration.itemsPerPage()));
				
				//save pages in session  
				listAnagraficaBean = currentPaginationAnagraficaBean(itemsperPage, listAnagraficaVOBean);
				session.setAttribute("pages", listAnagraficaBean, PortletSession.APPLICATION_SCOPE);
				
				arrJsonPersone = mapper.writeValueAsString(listAnagraficaBean.get(0));
			}
			if (!risultatiPersone.isEmpty() && !filtriRicercaPersone.isEmpty()) {
				
				JSONObject json = JSONFactoryUtil.createJSONObject();
				if (request.getParameter("name") != null && !("").equals(request.getParameter("name").toString())) {
					json.put("name", (String) request.getParameter("name"));
				}
				if (request.getParameter("surname") != null && !("").equals(request.getParameter("surname").toString())) {
					json.put("surname", (String) request.getParameter("surname"));
				}
				if (request.getParameter("qualification") != null && !("").equals(request.getParameter("qualification").toString())) {
					JSONObject jsonQualifica = JSONFactoryUtil.createJSONObject();
					jsonQualifica.put("id", (String) request.getParameter("qualification"));
					jsonQualifica.put("nomeQ", descQualifica);
					json.put("qualification", jsonQualifica);
				}
				if (request.getParameter("structure") != null && !("").equals(request.getParameter("structure").toString())) {
					JSONObject jsonStruttMadre = JSONFactoryUtil.createJSONObject();
					jsonStruttMadre.put("id", (String) request.getParameter("structure"));
					jsonStruttMadre.put("nomeS", strutturaMadre);
					json.put("structure", jsonStruttMadre);
				}
				if (request.getParameter("structure-one") != null && !("").equals(request.getParameter("structure-one").toString())) {
					JSONObject jsonStrutt1 = JSONFactoryUtil.createJSONObject();
					jsonStrutt1.put("id", (String) request.getParameter("structure-one"));
					jsonStrutt1.put("nomeS", strutturaUnoDesc);
					json.put("structure-one", jsonStrutt1);
				}
				if (request.getParameter("structure-two") != null && !("").equals(request.getParameter("structure-two").toString())) {
					JSONObject jsonStrutt2 = JSONFactoryUtil.createJSONObject();
					jsonStrutt2.put("id", (String) request.getParameter("structure-two"));
					jsonStrutt2.put("nomeS", strutturaDueDesc);
					json.put("structure-two", jsonStrutt2);
				}
				if (request.getParameter("structure-three") != null && !("").equals(request.getParameter("structure-three").toString())) {
					JSONObject jsonStrutt3 = JSONFactoryUtil.createJSONObject();
					jsonStrutt3.put("id", (String) request.getParameter("structure-three"));
					jsonStrutt3.put("nomeS", strutturaTreDesc);
					json.put("structure-three", jsonStrutt3);
				}
				if (request.getParameter("structure-four") != null && !("").equals(request.getParameter("structure-four").toString())) {
					JSONObject jsonStrutt4 = JSONFactoryUtil.createJSONObject();
					jsonStrutt4.put("id", (String) request.getParameter("structure-four"));
					jsonStrutt4.put("nomeS", strutturaQuattroDesc);
					json.put("structure-four", jsonStrutt4);
				}
				utente=themeDisplay.getUser();
				json.put("screenNameUser", utente.getScreenName().toLowerCase());
				setRicerca(json.toString());
			}
			//save count in session
			session.setAttribute("countRisultatiPersone", listAnagraficaVOBean.size(), PortletSession.APPLICATION_SCOPE);
			request.setAttribute("filtriRicercaPersone", filtriRicercaPersone);
			request.setAttribute("jsonArrayPersone", arrJsonPersone);
			request.setAttribute("page", 1);
			request.setAttribute("numPage", listAnagraficaBean.size() );
			request.setAttribute("countRisultatiPersone", risultatiPersone.size());
			
		
		} catch (Exception e) {

			SessionErrors.add(request, "Errore-durante-ricerca-persone");
			SessionMessages.add(request,
					PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			
		_log.warn(e);
		
		} 
		
}
      public void setRicerca(String jsonData){
          Date today=new Date();
          SearchDataLocalServiceUtil.insertSearchData(jsonData, today);
      }


   @ProcessAction(name = "cercaUffici")
	public void cercaUffici(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
	   String chiave = null ;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<String> id_uffici = new ArrayList<String>();
			List<AnagraficaUfficioVO> dettaglio_uffici = new ArrayList<AnagraficaUfficioVO>();
			if (actionRequest.getParameter("parolaChiave") != null && actionRequest.getParameter("parolaChiave") != "") {
				
				chiave = actionRequest.getParameter("parolaChiave");
				actionRequest.setAttribute("textSearch", chiave);
			} else if (actionRequest.getParameter("tagNuvola") != null) {
				
				chiave = actionRequest.getParameter("tagNuvola");
				actionRequest.setAttribute("textSearch", chiave);
			} else if (actionRequest.getParameter("tagChiave") != null) {
				String chiaveISO = actionRequest.getParameter("tagChiave");
				chiave = new String(chiaveISO.getBytes("ISO-8859-1"), "UTF-8");
				actionRequest.setAttribute("textSearch", chiave);
			}
			//save filtroUfficio in session
			PortletSession session = actionRequest.getPortletSession();
			session.setAttribute("textSearch", chiave, PortletSession.APPLICATION_SCOPE);
			int tipoRicerca = 0;
			if (chiave != null) {
				List<AnagraficaUfficioSmartVO> risultati_uffici = SearchDataLocalServiceUtil.servElencoAnagraficheUffici(chiave,
				tipoRicerca);
				for (AnagraficaUfficioSmartVO ris_ufficio : risultati_uffici) {
					id_uffici.add(ris_ufficio.getIdUfficio().getValue());
				}
				for (String idUfficio : id_uffici) {
					List<AnagraficaUfficioVO> dettaglio_singolo_ufficio = SearchDataLocalServiceUtil.servDettagliUfficio(idUfficio);
					dettaglio_uffici.add(dettaglio_singolo_ufficio.get(0));
				}
				Collections.sort(dettaglio_uffici, new Comparator<AnagraficaUfficioVO>() {
					@Override
					public int compare(AnagraficaUfficioVO u1, AnagraficaUfficioVO u2) {
						return u1.getAcronimo().getValue().compareToIgnoreCase(u2.getAcronimo().getValue());
					}
				});
				//pagination		
				String itemsperPage = actionRequest.getPreferences().getValue("itemsPerPage", Integer.toString(_configuration.itemsPerPage()));
				List<List<AnagraficaUfficioVO>> pages = currentPaginationUffici(itemsperPage, dettaglio_uffici);
				
				session.setAttribute("pagesUffici", pages, PortletSession.APPLICATION_SCOPE);
				ObjectMapper mapper = new ObjectMapper();
				String arrJsonUffici = "";
				//TODO ;: cambiare similie a lista persone
				if (!pages.isEmpty()) {
					arrJsonUffici = mapper.writeValueAsString(pages.get(0));
				}
				if (!dettaglio_uffici.isEmpty() && chiave != null && chiave != "" && chiave != "null") {
					
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("parolaChiave", chiave);
					utente=themeDisplay.getUser();
					json.put("screenNameUser", utente.getScreenName().toLowerCase());
					setRicerca(json.toString());
				}
				session.setAttribute("countRisultatiUffici", dettaglio_uffici.size(), PortletSession.APPLICATION_SCOPE);
				actionRequest.setAttribute("pageUffici", 1);
				actionRequest.setAttribute("numPageUffici", pages.size());
				actionRequest.setAttribute("dettaglioUffici", arrJsonUffici);
				actionRequest.setAttribute("countRisultatiUffici", dettaglio_uffici.size());
			}
		} catch (Exception e) {
			_log.warn(e);
			SessionErrors.add(actionRequest, "Errore-durante-ricerca-uffici");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			
		}
	}
	
	@ProcessAction(name = "paginaPersone")
	public void paginaPersone(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		try {
	
			//get numpage parameter
			String valuePage = actionRequest.getParameter("numpage");
			//get list from session
			PortletSession pSession = actionRequest.getPortletSession();
			List<List<AnagraficaVOBean>> pages = (List<List<AnagraficaVOBean>>) pSession.getAttribute("pages", pSession.APPLICATION_SCOPE);
			List<String> filtriRicercaPersone = (List<String>) pSession.getAttribute("filtroPersone", pSession.APPLICATION_SCOPE);
			Integer countlist = (Integer) pSession.getAttribute("countRisultatiPersone", pSession.APPLICATION_SCOPE);
			if (valuePage != null || (pages != null && !pages.isEmpty())) {
				ObjectMapper mapper = new ObjectMapper();
				Integer numpage = Integer.parseInt(valuePage);
				String arrJsonPersone = mapper.writeValueAsString(pages.get(numpage-1));
				actionRequest.setAttribute("jsonArrayPersone", arrJsonPersone);
				actionRequest.setAttribute("page", numpage);
				actionRequest.setAttribute("numPage", pages.size());
				if (filtriRicercaPersone != null)
					actionRequest.setAttribute("filtriRicercaPersone", filtriRicercaPersone);
				
		
				
				actionRequest.setAttribute("countRisultatiPersone", countlist);
			}
		} catch (Exception e) {
			_log.warn(e);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(renderUrl.toString());
		}
	}
	
	@ProcessAction(name = "paginaUffici")
	public void paginaUffici(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException { //get numpage parameter
		try {
			String valuePage = actionRequest.getParameter("numpage");
			//get list from session
			PortletSession pSession = actionRequest.getPortletSession();
			List<List<AnagraficaUfficioVO>> pages = (List<List<AnagraficaUfficioVO>>) pSession.getAttribute("pagesUffici", pSession.APPLICATION_SCOPE);
			Integer countlist = (Integer) pSession.getAttribute("countRisultatiUffici", pSession.APPLICATION_SCOPE);
			String textSearch = (String) pSession.getAttribute("textSearch", pSession.APPLICATION_SCOPE);
			if (valuePage != null || (pages != null && !pages.isEmpty())) {
				ObjectMapper mapper = new ObjectMapper();
				Integer numpage = Integer.parseInt(valuePage);
				String arrJsonUffici= mapper.writeValueAsString(pages.get(numpage-1));
				actionRequest.setAttribute("textSearch", textSearch);
				actionRequest.setAttribute("dettaglioUffici", arrJsonUffici);
				actionRequest.setAttribute("pageUffici", numpage);
				actionRequest.setAttribute("numPageUffici", pages.size());
				actionRequest.setAttribute("countRisultatiUffici", countlist);
			}
		} catch (Exception e) {
			_log.warn(e);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(renderUrl.toString());
		}
	}
	
	private int numberPagesResult(List<AnagraficaVOBean> lista, int pageSize) {
		return (int) Math.ceil((double) lista.size() / (double) pageSize);
	}
	
	private List<List<AnagraficaVOBean>> currentPaginationAnagraficaBean(String itemPerPage, List<AnagraficaVOBean> lista) {
		if (lista == null)
			return Collections.emptyList();
		Integer pageSize = Integer.parseInt(itemPerPage);
		if (pageSize == null || pageSize <= 0 || pageSize > lista.size() || pageSize == lista.size())
			pageSize = lista.size();
		int numberPage = numberPagesResult(lista,pageSize);
		
		List<List<AnagraficaVOBean>> pages = new ArrayList<List<AnagraficaVOBean>>(numberPage);
		for (int p = 0; p < numberPage; p++) {
			pages.add(lista.subList(p * pageSize, Math.min((p + 1) * pageSize, lista.size())));
		}
		
		return pages;
	}
	

	private List<List<AnagraficaUfficioVO>> currentPaginationUffici(String itemPerPage, List<AnagraficaUfficioVO> lista) {
		if (lista == null)
			return Collections.emptyList();
		Integer pageSize = Integer.parseInt(itemPerPage);
		if (pageSize == null || pageSize <= 0 || pageSize > lista.size() || pageSize == lista.size())
			pageSize = lista.size();
		int numpages = (int) Math.ceil((double) lista.size() / (double) pageSize);
		List<List<AnagraficaUfficioVO>> pages = new ArrayList<List<AnagraficaUfficioVO>>(numpages);
		for (int p = 0; p < numpages; p++) {
			pages.add(lista.subList(p * pageSize, Math.min((p + 1) * pageSize, lista.size())));
		}
		return pages;
	}
	
	public List<Qualifica> loadQualifiche() {
		List<Qualifica> qualifiche_list = new ArrayList<Qualifica>();
		Qualifica q1 = new Qualifica("1F1", "1F1");
		Qualifica q2 = new Qualifica("1F2", "1F2");
		Qualifica q3 = new Qualifica("1F3", "1F3");
		Qualifica q4 = new Qualifica("2F1", "2F1");
		Qualifica q5 = new Qualifica("2F2", "2F2");
		Qualifica q6 = new Qualifica("2F3", "2F3");
		Qualifica q7 = new Qualifica("2F4", "2F4");
		Qualifica q8 = new Qualifica("2F5", "2F5");
		Qualifica q9 = new Qualifica("2F6", "2F6");
		Qualifica q10 = new Qualifica("3F1", "3F1");
		Qualifica q11 = new Qualifica("3F2", "3F2");
		Qualifica q12 = new Qualifica("3F3", "3F3");
		Qualifica q13 = new Qualifica("3F4", "3F4");
		Qualifica q14 = new Qualifica("3F5", "3F5");
		Qualifica q15 = new Qualifica("3F6", "3F6");
		Qualifica q16 = new Qualifica("3F7", "3F7");
		Qualifica q17 = new Qualifica("C1", "C1");
		Qualifica q18 = new Qualifica("DIR01F", "DIRIG. I FASCIA");
		Qualifica q19 = new Qualifica("DIR02F", "DIRIG. II FASCIA");
		qualifiche_list.add(q1);
		qualifiche_list.add(q2);
		qualifiche_list.add(q3);
		qualifiche_list.add(q4);
		qualifiche_list.add(q5);
		qualifiche_list.add(q6);
		qualifiche_list.add(q7);
		qualifiche_list.add(q8);
		qualifiche_list.add(q9);
		qualifiche_list.add(q10);
		qualifiche_list.add(q11);
		qualifiche_list.add(q12);
		qualifiche_list.add(q13);
		qualifiche_list.add(q14);
		qualifiche_list.add(q15);
		qualifiche_list.add(q16);
		qualifiche_list.add(q17);
		qualifiche_list.add(q18);
		qualifiche_list.add(q19);
		return qualifiche_list;
	}
	
	public List<Struttura> loadStruttureMadri(){
        List<Struttura> strutture_list = new ArrayList<Struttura>();
        Struttura s1=new Struttura("847","MEF");
        Struttura s2=new Struttura("CONSIP","CONSIP");
        Struttura s3=new Struttura("SOGEI","SOGEI");
        strutture_list.add(s1);
        strutture_list.add(s2);
        strutture_list.add(s3);
        
        return strutture_list;       
  }
	
	@ProcessAction(name = "gestioneTag")
	public void gestioneTag(ActionRequest request, ActionResponse response) {
		
		String buttonVal = null;
		String tag = null;
		String codStruttura = null;
		
		try {
		
			if(request.getParameter("codStruttura")!=null && request.getParameter("codStruttura")!=""){
				codStruttura=request.getParameter("codStruttura");
			}
			
			//controllo se il button cliccato è aggiungi o associa
			if(request.getParameter("recButtonOnClick")!=null && request.getParameter("recButtonOnClick")!="") {
					
				buttonVal=request.getParameter("recButtonOnClick");
			}
			
			if(request.getParameter("searchTag")!=null && request.getParameter("searchTag")!=""){
    			tag=request.getParameter("searchTag");
    			
    			//se il valore del button cliccato è associa, invoca il metodo getListTagForChar per ottenere il nome del tag corretto
    			if(buttonVal!=null && ("ASSOCIA").equals(buttonVal)) {
    		    	tag=SearchDataLocalServiceUtil.getListTagForChar(tag).get(0).getTagName().getValue();
    		    }
    			
    			//se il valore del button cliccato è aggiungi, inserisci il tag prima di associarlo all'ufficio
    			else if (buttonVal!=null && ("AGGIUNGI").equals(buttonVal)) {
    				//controlla se il tag inserito esiste già
    				if(!tag.equalsIgnoreCase(SearchDataLocalServiceUtil.getListTagForChar(tag).get(0).getTagName().getValue())) {
					SearchDataLocalServiceUtil.inserisciTag(tag);
    				}
				}
    			
    		}
	
				SearchDataLocalServiceUtil.associaTag(codStruttura, tag);
        		request.setAttribute("codStruttura", codStruttura);
        		response.setRenderParameter("jspPage","/rubrica_scheda_uffici.jsp");
			
		}

		catch(Exception e){
			SessionErrors.add(request, "Errore-durante-associazione-tag");
			SessionMessages.add(request,
					PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			
			_log.warn(e);
		
		} 
}
	
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefRubricaFormConfig.class, properties);
	}
	private volatile MefRubricaFormConfig _configuration;
}
