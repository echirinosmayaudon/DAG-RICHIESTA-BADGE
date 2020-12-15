package com.intranet.mef.util;
import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.model.InvitatiRiunione;
import com.intranet.mef.gestione.riunioni.model.Luogo;
import com.intranet.mef.gestione.riunioni.model.Riunione;
import com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.InvitatiRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.RiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.SegreteriaLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.TipoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.persistence.InvitatiRiunionePK;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelLuogo;
import com.intranet.mef.logicaldel.gestione.riunioni.service.CancelAmmConvLocalServiceUtil;
import com.intranet.mef.logicaldel.gestione.riunioni.service.CancelLuogoLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.StatoRiunioneLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.StatoInvitatoLocalServiceUtil;

import com.intranet.mef.gestione.riunioni.model.TipoRiunione;
import com.intranet.mef.gestione.riunioni.model.StatoRiunione;
import com.intranet.mef.gestione.riunioni.model.StatoInvitato;



import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil;
import com.mef.ricercariunione.stub.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO;

public class BeanCreator {



	static final Log _log = LogFactoryUtil.getLog(BeanCreator.class);


	public List<TipoRiunione> createListaTipiRiunione(){
		List<TipoRiunione> tipiRiunioneDB = TipoRiunioneLocalServiceUtil.getTipoRiuniones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(tipiRiunioneDB==null || tipiRiunioneDB.isEmpty()){
			List<String> tipiRiunione = new ArrayList<>(0);
			
			tipiRiunione.add("tecnica");
			tipiRiunione.add("lavoro");
			tipiRiunione.add("di verifica");
			tipiRiunione.add("qualit&agrave;");
			tipiRiunione.add("*");
			tipiRiunione.add("coordinamento");

			for(int i=0;i<tipiRiunione.size();i++){
				TipoRiunione tipoRiunioneDB = TipoRiunioneLocalServiceUtil.createTipoRiunione(i+1);
				tipoRiunioneDB.setDescrizione(tipiRiunione.get(i));
				if(TipoRiunioneLocalServiceUtil.fetchTipoRiunione(i+1)== null)
				TipoRiunioneLocalServiceUtil.addTipoRiunione(tipoRiunioneDB);
			}
			
			tipiRiunioneDB = TipoRiunioneLocalServiceUtil.getTipoRiuniones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		}
		
		return tipiRiunioneDB;
	}

	public List<StatoRiunione> createListaStatoRiunione(){
		if(StatoRiunioneLocalServiceUtil.getStatoRiunionesCount()==0){
			List<String> statoRiunioni = new ArrayList<>(0);
			
			statoRiunioni.add("indetta");
			statoRiunioni.add("rinviata");
			statoRiunioni.add("annullata");
			statoRiunioni.add("effettuata");
			statoRiunioni.add("eliminata");

			for(int i=0;i<statoRiunioni.size();i++){
				StatoRiunione statoRiunioneDB = StatoRiunioneLocalServiceUtil.createStatoRiunione(i+1);
				statoRiunioneDB.setLabel(statoRiunioni.get(i));
				if(StatoRiunioneLocalServiceUtil.fetchStatoRiunione(i+1)==null)
				StatoRiunioneLocalServiceUtil.addStatoRiunione(statoRiunioneDB);
			}
			
		}
		
		else if(StatoRiunioneLocalServiceUtil.getStatoRiunionesCount()<5){
			StatoRiunione statoRiunioneDBdelete = StatoRiunioneLocalServiceUtil.createStatoRiunione(StatoRiunioneLocalServiceUtil.getStatoRiunionesCount()+1);
			statoRiunioneDBdelete.setLabel("eliminata");
			if(StatoRiunioneLocalServiceUtil.fetchStatoRiunione(StatoRiunioneLocalServiceUtil.getStatoRiunionesCount()+1)==null)
			StatoRiunioneLocalServiceUtil.addStatoRiunione(statoRiunioneDBdelete);		
		}
		
		return StatoRiunioneLocalServiceUtil.getStatoRiuniones(0,StatoRiunioneLocalServiceUtil.getStatoRiunionesCount()-1);
	}
	
	/*
	INSERT INTO mefportal.mef_statoinvitato (`id_stato_invitato`,`nome_stato`) VALUES (1,'accettata');
    INSERT INTO mefportal.mef_statoinvitato (`id_stato_invitato`,`nome_stato`) VALUES (2,'rifiutata');*/
	public List<StatoInvitato> createListaStatoInvitato(){
		List<StatoInvitato> statoInvitatiDB =StatoInvitatoLocalServiceUtil.getStatoInvitatos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(statoInvitatiDB==null || statoInvitatiDB.isEmpty()){
			List<String> statoInvitato = new ArrayList<>(0);
			
			statoInvitato.add("accettata");
			statoInvitato.add("rifiutata");
			
			for(int i=0;i<statoInvitato.size();i++){
				StatoInvitato statoInvitatoDB = StatoInvitatoLocalServiceUtil.createStatoInvitato(i+1);
				statoInvitatoDB.setNome_stato(statoInvitato.get(i));
				if(StatoInvitatoLocalServiceUtil.fetchStatoInvitato(i+1)==null)
				StatoInvitatoLocalServiceUtil.addStatoInvitato(statoInvitatoDB);
			}
			
			statoInvitatiDB = StatoInvitatoLocalServiceUtil.getStatoInvitatos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		}
		
		return statoInvitatiDB;
	}
	
	
	public List<Partecipante> createListaPartecipanti(Long idOrgChart, ThemeDisplay themeDisplay){
		List<Partecipante> listPartecipanti = new ArrayList<Partecipante>(0);
		try {
	
			OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idOrgChart);
			if(orgChart!=null && orgChart.getLevel()==3){
				long organizzazioneId=orgChart.getLevel1();
				long dipartimentoId=orgChart.getLevel2();
				
				List<AnagraficaVO> risultati_persone = SearchDataLocalServiceUtil.getListPersone(String.valueOf(dipartimentoId),String.valueOf( idOrgChart), null, null, null,String.valueOf( organizzazioneId), null, null);
		    	Collections.sort(risultati_persone, new Comparator<AnagraficaVO>() {
						@Override
						public int compare(AnagraficaVO p1, AnagraficaVO p2) {
			                int res =  p1.getLastName().getValue().compareToIgnoreCase(p2.getLastName().getValue());
			                if (res != 0)
			                    return res;
			                return p1.getFirstName().getValue().compareToIgnoreCase(p2.getFirstName().getValue());
			            }
					}); 
					
					for(AnagraficaVO userVO: risultati_persone){
						User user = UserLocalServiceUtil.fetchUserByScreenName(themeDisplay.getCompanyId(), userVO.getCodiceFiscale().getValue());
						if (user!=null)
							listPartecipanti.add(new Partecipante(user.getUserId(), user.getScreenName(), user.getFirstName(), user.getLastName(),user.getEmailAddress(), user.getPortraitURL(themeDisplay)));
						else {
							_log.warn("l'utente "+userVO.getFirstName().getValue()+" "+ userVO.getLastName().getValue()+ " non è presente");
						}
					}
					
			}
			
			
			
		} catch (Exception e1) {
			_log.warn(e1);
		
		}
	
		
		
		return listPartecipanti;
	}
	
	
	public ArrayList<Segreteria> createListaSegreterie(){
		ArrayList<Segreteria> listSegreteria = new ArrayList<Segreteria>(0);		
		List<com.intranet.mef.gestione.riunioni.model.Segreteria> segreterieDB = SegreteriaLocalServiceUtil.getSegreterias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for(com.intranet.mef.gestione.riunioni.model.Segreteria segreteriaDB : segreterieDB){
			listSegreteria.add( new Segreteria(segreteriaDB.getId_segreteria(), segreteriaDB.getAcronimo(), segreteriaDB.getEmail(), segreteriaDB.getDescrizione(),0,"",false,0));
		}
		return listSegreteria;
	}
	
	

	public Segreteria getElementByIdSegreteria(Long idSegreteria){
		
		com.intranet.mef.gestione.riunioni.model.Segreteria segreteriaDB;
		Segreteria segreteria =null;
		try {
			segreteriaDB = SegreteriaLocalServiceUtil.getSegreteria(idSegreteria);
			segreteria = new Segreteria(segreteriaDB.getId_segreteria(), segreteriaDB.getAcronimo(), segreteriaDB.getEmail(),segreteriaDB.getDescrizione(), 0,"",false,0);
		} catch (PortalException e) {
			_log.warn(e);

		}
		//return getSegreteriaFromList(idSegreteria, createListaSegreterie());
			return segreteria;
	}
	
	public ArrayList<Segreteria> updateListaSegreterieWithPartecipanti(List<InvitatiRiunione> invitati, ThemeDisplay theme){
		ArrayList<Segreteria> listSegreteria = new ArrayList<Segreteria>(0);	
		if(invitati!=null){
			for(InvitatiRiunione invitato : invitati){
				listSegreteria.add( this.getSegreteriaWithPartecipanti(invitato,theme));
			}
			if(listSegreteria.size()>1){
				Collections.sort(listSegreteria,new Comparator<Segreteria>() {
	          
					@Override
					public int compare(Segreteria arg0, Segreteria arg1) {
						return arg0.getIndex()-arg1.getIndex();
					}
	        	});
			}
		}
		
		return listSegreteria;
	}
	
	public ArrayList<Segreteria> updateListaSegreterie(List<InvitatiRiunione> invitati){
		ArrayList<Segreteria> listSegreteria = new ArrayList<Segreteria>(0);	
		if(invitati!=null){
			for(InvitatiRiunione invitato : invitati){
				listSegreteria.add( this.getSegreteria(invitato));
			}
			if(listSegreteria.size()>1){
				Collections.sort(listSegreteria,new Comparator<Segreteria>() {
	          
					@Override
					public int compare(Segreteria arg0, Segreteria arg1) {
						return arg0.getIndex()-arg1.getIndex();
					}
	        	});
			}
		}
		
		return listSegreteria;
	}

	
	public int  getSizePartecipantiJSON(String partecipanti) {
		int size = 0;
		if(partecipanti!=null){
			JSONObject obj;
			try {
				obj = JSONFactoryUtil.createJSONObject(partecipanti);
				
				JSONArray arrayInvitati = JSONFactoryUtil.createJSONArray(obj.getString("list"));
				if(obj.getString("list")==null || "".equals(obj.getString("list"))){
					arrayInvitati = JSONFactoryUtil.createJSONArray(obj.getString("partecipantiBox"));
				}
				
				size= arrayInvitati.length();
			} catch (Exception e) {
				_log.warn(e);
			}

			
		}
		
		return size;

	}
	
	public RiunioneBean getRiunioneBean(Riunione riunioneDB, ThemeDisplay theme){
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE,3);
		Date endDate = calendar.getTime();
		RiunioneBean riunione = new RiunioneBean();
		riunione.setData_inizio(riunioneDB.getData_inizio());
		riunione.setId_riunione(riunioneDB.getId_riunione());
		List<InvitatiRiunione> invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(riunioneDB.getId_riunione());
		
		riunione.setListSegreteria(this.updateListaSegreterieWithPartecipanti(invitati,theme));
		riunione.setProtocollo(riunioneDB.getProtocollo());
		String tipologia ="";
		if(riunioneDB.getId_tipo()!=0){
			TipoRiunione tipoRiunione = TipoRiunioneLocalServiceUtil.fetchTipoRiunione(riunioneDB.getId_tipo());
			if(tipoRiunione!=null)
				tipologia=tipoRiunione.getDescrizione();
				
		}
		riunione.setTipoRiunione(tipologia);
		
		String statoTxt="";
		if(riunioneDB.getId_stato_riunione()!=0){
			StatoRiunione statoRiunione = StatoRiunioneLocalServiceUtil.fetchStatoRiunione(riunioneDB.getId_stato_riunione());
			if(statoRiunione!=null)
				statoTxt=statoRiunione.getLabel();
		}
		riunione.setId_stato_riunione(riunioneDB.getId_stato_riunione());
		riunione.setStatoRiunione(statoTxt);

		
		String luogoTxt="";
		if(riunioneDB.getId_luogo()!=0){
			Luogo luogoRiunione = LuogoLocalServiceUtil.fetchLuogo(riunioneDB.getId_luogo());
			if(luogoRiunione!=null)
				luogoTxt=luogoRiunione.getNome();
		}
		riunione.setLuogo(luogoTxt);
		
		String convocanteTxt="";
		if(riunioneDB.getId_luogo()!=0){
			AmministrazioneConvocante convocanteRiunione = AmministrazioneConvocanteLocalServiceUtil.fetchAmministrazioneConvocante(riunioneDB.getId_amministrazione_convocante());
			if(convocanteRiunione!=null)
				convocanteTxt=convocanteRiunione.getNome_amministrazione();
		}
		riunione.setConvocante(convocanteTxt);
		
		riunione.setOggetto(riunioneDB.getOggetto());
		riunione.setFlagSollecita(this.sollecitaInvitati(riunioneDB.getId_riunione(), today, endDate));
		riunione.setData_ultimo_sollecito(riunioneDB.getData_ultimo_sollecito());
		
		
		return riunione;
	}
	
	
	
	public RiunioneBean getRiunioneBean(long idRiunione, ThemeDisplay theme){
		if (RiunioneLocalServiceUtil.fetchRiunione(idRiunione)!=null){
			Riunione riunioneDB = RiunioneLocalServiceUtil.fetchRiunione(idRiunione);
			return this.getRiunioneBean(riunioneDB, theme);
		}
		
		return null;
	}
	
	
	public List<RiunioneBean> getListRiunioneBean(List<Riunione> riunioniDB, ThemeDisplay theme){
		List<RiunioneBean> riunioneList = new ArrayList<>(0);		
		for(Riunione riunioneDB: riunioniDB){
			riunioneList.add(this.getRiunioneBean(riunioneDB,theme));
			
		}
		return riunioneList;
	}
	
	
	
/* recupera la lista degli invitati dalla string partecipanti */
	public List<Partecipante>  getListaPartecipantiJSONforForm(String partecipanti,ThemeDisplay themeDisplay) {
		List<Partecipante> listaPartecipante = new ArrayList<Partecipante>(0);	

		if(partecipanti!=null){
			JSONObject obj;
			try {
				String other = partecipanti;
				obj = JSONFactoryUtil.createJSONObject(other);
				JSONArray arrayInvitati  = JSONFactoryUtil.createJSONArray(obj.getString("list"));
				if(obj.getString("list")==null || "".equals(obj.getString("list"))){
					arrayInvitati = JSONFactoryUtil.createJSONArray(obj.getString("partecipantiBox"));
				}
					
				
				if(arrayInvitati!=null){
					for (int j = 0; j < arrayInvitati.length(); j++) {
						
						String codiceFiscale = arrayInvitati.getJSONObject(j).getString("cf");
						if (codiceFiscale==null || "".equals(codiceFiscale)){
							codiceFiscale = arrayInvitati.getJSONObject(j).getString("codiceFiscale");
						}
						if (codiceFiscale!=null && !"".equals(codiceFiscale)){
							User user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), codiceFiscale);
							if (user!=null)
								listaPartecipante.add(new Partecipante(user.getUserId(), user.getScreenName(), user.getFirstName(), user.getLastName(),user.getEmailAddress(), user.getPortraitURL(themeDisplay)));
							else
								_log.warn("user " + codiceFiscale + " not found");
						}
					}
				}
					
			} catch (Exception e) {
				_log.warn(e);
			}

			
		}
		
		return listaPartecipante;
		
		
	}
	
	
	public String getListaPartecipantiJSONforDB(String partecipanti) {
		StringBuilder partecipantiBox = new StringBuilder();
		partecipantiBox.append("[");	
		if(partecipanti!=null){
			JSONObject obj;
			try {
				obj = JSONFactoryUtil.createJSONObject(partecipanti);
				JSONArray arrayInvitati  = JSONFactoryUtil.createJSONArray(obj.getString("list"));
				if(obj.getString("list")==null || "".equals(obj.getString("list"))){
					arrayInvitati = JSONFactoryUtil.createJSONArray(obj.getString("partecipantiBox"));
				}
					
				
				if(arrayInvitati!=null){
					for (int j = 0; j < arrayInvitati.length(); j++) {
						
						String codiceFiscale = arrayInvitati.getJSONObject(j).getString("cf");
						if (codiceFiscale==null || "".equals(codiceFiscale)){
							codiceFiscale = arrayInvitati.getJSONObject(j).getString("codiceFiscale");
						}
						if (codiceFiscale!=null && !"".equals(codiceFiscale)){
							if (j>0)
								partecipantiBox.append(",");	
							partecipantiBox.append("{");	
							partecipantiBox.append("\"cf\":");	
							partecipantiBox.append("\"");	
							partecipantiBox.append(codiceFiscale);	
							partecipantiBox.append("\"");	
							partecipantiBox.append("}");	
						}
					}
				}

			} catch (Exception e) {
				_log.warn(e);
				partecipantiBox.append("]");	
				return partecipantiBox.toString();

			}
		}
		partecipantiBox.append("]");	

		return partecipantiBox.toString();
	}
	
	public Boolean sollecitaInvitati(long idRiunione, Date from, Date to){
		
		try {
			Riunione riunione = RiunioneLocalServiceUtil.getRiunione(idRiunione);
			
			if(riunione.getData_inizio().after(from) && riunione.getData_inizio().before(to)){
			
				StatoRiunione statoRiunione = StatoRiunioneLocalServiceUtil.getStatoRiunione(riunione.getId_stato_riunione());
				if (!"indetta".equalsIgnoreCase(statoRiunione.getLabel()))
					return false;
				
				
				List<InvitatiRiunione> invitatiList = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunioneByIdRiunione(idRiunione);
				for(InvitatiRiunione invitato :invitatiList){
					InvitatiRiunionePK invitatiPk = new InvitatiRiunionePK();
					invitatiPk.setId_riunione(idRiunione);
					invitatiPk.setId_segreteria(invitato.getId_segreteria());
						InvitatiRiunione invitati = InvitatiRiunioneLocalServiceUtil.getInvitatiRiunione(invitatiPk);
						if (invitati.getId_stato_invitato()==0 || (invitati.getId_stato_invitato()==1 && (getSizePartecipantiJSON(invitati.getPartecipanti())==0))){	
							return true;
						}
				}
			}
			else
				return false;
		} catch (PortalException e) {
			_log.warn(e);
			return false;
		}
		return false;
		
		
	}
	
	
	public Segreteria getSegreteriaWithPartecipanti(InvitatiRiunione invriun,ThemeDisplay theme) {
		Segreteria seg = getSegreteria(invriun);
		seg.setListPartecipante(this.getListaPartecipantiJSONforForm(invriun.getPartecipanti(),theme));
		return seg;
	}
	
	public Segreteria getSegreteria(InvitatiRiunione invriun) {
		Segreteria seg = null;
		try {
			com.intranet.mef.gestione.riunioni.model.Segreteria segreteriaDB = SegreteriaLocalServiceUtil.getSegreteria(invriun.getId_segreteria());
			
			String other = invriun.getPartecipanti();
			//other = other.replace("\"partecipantiBox\":}", "\"partecipantiBox\":[]}");
			//other = other.replace(",,",",");
			JSONObject obj = JSONFactoryUtil.createJSONObject(other);
			int index = 0;
			boolean capofila =false;  
			
			
			if(obj!=null && !"".equals(obj)){
				if(obj.getString("index")!=null && !"".equals(obj.getString("index"))){
					index = Integer.parseInt(obj.getString("index"));
				}
				else
					if(obj.getString("pos")!=null && !"".equals(obj.getString("pos"))){
						index = Integer.parseInt(obj.getString("pos"));
					}
				
				if(obj.getString("capofila")!=null&& !"".equals(obj.getString("capofila"))){
					capofila =  Boolean.parseBoolean(obj.getString("capofila"));
				}else
					if(obj.getString("top")!=null && !"".equals(obj.getString("top"))){
						capofila = Boolean.parseBoolean(obj.getString("top"));
					}
			}
			

			seg = new Segreteria(segreteriaDB.getId_segreteria(), segreteriaDB.getAcronimo(),segreteriaDB.getEmail(),segreteriaDB.getDescrizione(),  invriun.getId_stato_invitato(), invriun.getNote(),capofila,index);
			String statoInviatoTxt="";
			if (seg.getStato()!=0){
				StatoInvitato statoInvitato = StatoInvitatoLocalServiceUtil.fetchStatoInvitato(seg.getStato());
				if(statoInvitato!=null){
					statoInviatoTxt = statoInvitato.getNome_stato();
				}
			}
			seg.setNome_stato(statoInviatoTxt);
		} catch (PortalException e) {
			_log.warn(e);
			return seg;
		}
		return seg;
	}
	
	
	
	public List<Segreteria> getListSegreteriaFromJsonArray(JSONArray jsonArr){
		List<Segreteria> segreterie = new ArrayList<>(0);
		for (int i = 0; i < jsonArr.length(); i++) {
			segreterie.add(new Segreteria(Long.parseLong(
			jsonArr.getJSONObject(i).getString("id")),
			jsonArr.getJSONObject(i).getString("nome"), 
			jsonArr.getJSONObject(i).getString("email"), 
			jsonArr.getJSONObject(i).getString("descrizione"),
			Long.parseLong(jsonArr.getJSONObject(i).getString("stato")),
			"",
			Boolean.parseBoolean(jsonArr.getJSONObject(i).getString("capofila")),
			Integer.parseInt(jsonArr.getJSONObject(i).getString("index"))));
		}
		Collections.sort(segreterie,new Comparator<Segreteria>() {
	          
			@Override
			public int compare(Segreteria arg0, Segreteria arg1) {
				return arg0.getIndex()-arg1.getIndex();
			}
        });
		return segreterie;
	}
	
	public List<Luogo> getLuoghiList() {

		if (LuogoLocalServiceUtil.getLuogosCount() > CancelLuogoLocalServiceUtil.getCancelLuogosCount()) {
			for (Luogo luogo : LuogoLocalServiceUtil.getLuogos(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
				if (CancelLuogoLocalServiceUtil.fetchCancelLuogo(luogo.getId_luogo()) == null) {
					CancelLuogo cancelLuogo = CancelLuogoLocalServiceUtil.createCancelLuogo(luogo.getId_luogo());
					cancelLuogo.setCancellato(false);
					CancelLuogoLocalServiceUtil.addCancelLuogo(cancelLuogo);
				}
			}
		}

		List<Luogo> luoghiResultList = new ArrayList<Luogo>(0);
		List<Luogo> allLuoghi = LuogoLocalServiceUtil.getLuogos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<CancelLuogo> notCancLuoghiList = CancelLuogoLocalServiceUtil.getLuogoByCancStatus(false);

		for (Luogo luogo : allLuoghi) {
			for (CancelLuogo luogoNonCancellato : notCancLuoghiList) {
				if (luogo.getId_luogo() == luogoNonCancellato.getId_luogo()) {
					luoghiResultList.add(luogo);
					break;
				}
			}
		}

		Collections.sort(luoghiResultList, new Comparator<Luogo>() {
			@Override
			public int compare(Luogo o1, Luogo o2) {
				return (o1.getNome().trim().toUpperCase().compareTo(o2.getNome().trim().toUpperCase()));
			}
		});

		return luoghiResultList;

	}
	
	public List<AmministrazioneConvocante> getAmministrazioniConvocantiList() {

		if (AmministrazioneConvocanteLocalServiceUtil
				.getAmministrazioneConvocantesCount() > CancelAmmConvLocalServiceUtil.getCancelAmmConvsCount()) {
			for (AmministrazioneConvocante amministrazioneConv : AmministrazioneConvocanteLocalServiceUtil
					.getAmministrazioneConvocantes(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
				if (CancelAmmConvLocalServiceUtil
						.fetchCancelAmmConv(amministrazioneConv.getId_amministrazione_convocante()) == null) {
					CancelAmmConv cancelAmm = CancelAmmConvLocalServiceUtil
							.createCancelAmmConv(amministrazioneConv.getId_amministrazione_convocante());
					cancelAmm.setCancellato(false);
					CancelAmmConvLocalServiceUtil.addCancelAmmConv(cancelAmm);
				}
			}
		}

		List<AmministrazioneConvocante> ammConvocantiResultList = new ArrayList<AmministrazioneConvocante>(0);
		List<AmministrazioneConvocante> allAmmConvocanti = AmministrazioneConvocanteLocalServiceUtil
				.getAmministrazioneConvocantes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<CancelAmmConv> notCancAmmConvocantiList = CancelAmmConvLocalServiceUtil.getAmmConvByCancStatus(false);

		for (AmministrazioneConvocante amministrazione : allAmmConvocanti) {

			for (CancelAmmConv amministrazioneNonCancellata : notCancAmmConvocantiList) {
				if (amministrazione.getId_amministrazione_convocante() == amministrazioneNonCancellata
						.getId_amministrazione_convocante()) {
					ammConvocantiResultList.add(amministrazione);
					break;
				}
			}

		}

		Collections.sort(ammConvocantiResultList, new Comparator<AmministrazioneConvocante>() {
			@Override
			public int compare(AmministrazioneConvocante o1, AmministrazioneConvocante o2) {
				return (o1.getNome_amministrazione().trim().toUpperCase()
						.compareTo(o2.getNome_amministrazione().trim().toUpperCase()));
			}
		});

		return ammConvocantiResultList;

	}
	
}
