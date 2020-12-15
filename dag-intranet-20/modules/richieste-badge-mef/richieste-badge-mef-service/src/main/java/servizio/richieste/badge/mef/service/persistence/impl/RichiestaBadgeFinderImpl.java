package servizio.richieste.badge.mef.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil;
import servizio.richieste.badge.mef.service.persistence.RichiestaBadgeFinder;


public class RichiestaBadgeFinderImpl extends RichiestaBadgeFinderBaseImpl implements RichiestaBadgeFinder{
	
	
	private static final Log _log = LogFactoryUtil.getLog(RichiestaBadgeFinderImpl.class);
	
	
	public List<RichiestaBadge> getRichiestaBadgeByFilters(String cogn_intest, String nome_intest, String cf_intest, String societa, String ref_societa, String motivazione_rich, String progetto, String screenName, List<Long> lista_idUffici, boolean is_last, List<Long> lista_sedi, String is_internal, List<Long> lista_stati){		
		List<RichiestaBadge> res_richieste= new ArrayList<RichiestaBadge>();	
		
		Session session =  null;
		
		try{
			 session = openSession();
			 DynamicQuery queryRichieste = DynamicQueryFactoryUtil.forClass(RichiestaBadge.class,getClassLoader());
			 
			 if(cogn_intest!=null && !("").equals(cogn_intest)) {
				 queryRichieste.add(RestrictionsFactoryUtil.ilike("cognome_intestatario", cogn_intest));        
			 }
			 
			 if(nome_intest!=null && !("").equals(nome_intest)) {
				 queryRichieste.add(RestrictionsFactoryUtil.ilike("nome_intestatario", nome_intest));   			
			 }
			 
			 if(cf_intest!=null && !("").equals(cf_intest)) {
				 queryRichieste.add(RestrictionsFactoryUtil.ilike("cf_intestatario", cf_intest)); 
			 }
			 
			 if(societa!=null && !("").equals(societa)) {
				 
				 Disjunction disjunctionSocieta = RestrictionsFactoryUtil.disjunction();
				 String[] societa_split= societa.split(" ");
				 for (int i=0; i< societa_split.length; i++){
					 String value = (new StringBuilder("%")).append(societa_split[i]).append("%").toString();
					 disjunctionSocieta.add(RestrictionsFactoryUtil.ilike("societa", value));
				 }
				 queryRichieste.add(disjunctionSocieta);			  
			 }
			 
			 if(ref_societa!=null && !("").equals(ref_societa)) {
				 
				 Disjunction disjunctionReferente = RestrictionsFactoryUtil.disjunction();
				 String[] ref_split= ref_societa.split(" ");
				 for (int i=0; i< ref_split.length; i++){
					 String value = (new StringBuilder("%")).append(ref_split[i]).append("%").toString();
					 disjunctionReferente.add(RestrictionsFactoryUtil.ilike("referente_societa", value));
				 }
				 queryRichieste.add(disjunctionReferente);		
			 }
			 
			 if(progetto!=null && !("").equals(progetto)) {
				
				 Disjunction disjunctionProgetto = RestrictionsFactoryUtil.disjunction();
				 String[] prog_split = progetto.split(" ");
				 for (int i=0; i< prog_split.length; i++){
					 String value = (new StringBuilder("%")).append(prog_split[i]).append("%").toString();
					 disjunctionProgetto.add(RestrictionsFactoryUtil.ilike("progetto", value));
				 }
				 queryRichieste.add(disjunctionProgetto);		
			 }
			 
			 if(motivazione_rich!=null && !("").equals(motivazione_rich)) {
					
				 Disjunction disjunctionMotivazione = RestrictionsFactoryUtil.disjunction();
				 String[] motiv_split = motivazione_rich.split(" ");
				 for (int i=0; i< motiv_split.length; i++){
					 String value = (new StringBuilder("%")).append(motiv_split[i]).append("%").toString();
					 disjunctionMotivazione.add(RestrictionsFactoryUtil.ilike("motivazione", value));
				 }
				 queryRichieste.add(disjunctionMotivazione);		
			 }
			 
			 if(screenName!=null && !("").equals(screenName)) {			 
				 Property propertyScreenName=PropertyFactoryUtil.forName("screename_richiedente");	
		         queryRichieste.add(propertyScreenName.eq(screenName));   
			 }
			 
			 if(lista_idUffici!=null && !lista_idUffici.isEmpty()){
				 Disjunction disjunctionUffici = RestrictionsFactoryUtil.disjunction();
				 for(long id_ufficio:lista_idUffici){
						Property propertyUfficio=PropertyFactoryUtil.forName("id_ufficio");	
						disjunctionUffici.add(propertyUfficio.eq(id_ufficio));						
				 }
				 queryRichieste.add(disjunctionUffici);
			 }
			 
			 if(lista_sedi!=null && !lista_sedi.isEmpty()){
				 Disjunction disjunctionSedi = RestrictionsFactoryUtil.disjunction();
				 for(long idsede:lista_sedi){
					 Property propertysedi=PropertyFactoryUtil.forName("id_sedesiap");	
					 disjunctionSedi.add(propertysedi.eq(idsede));		
				 }
				 queryRichieste.add(disjunctionSedi);
			 }
			 
		
			if (lista_stati != null && !lista_stati.isEmpty()) {
				Disjunction disjunctionStati = RestrictionsFactoryUtil.disjunction();
				for (long id_stato : lista_stati) {
					Property propertyStato = PropertyFactoryUtil.forName("id_stato");
					disjunctionStati.add(propertyStato.eq(id_stato));
				}
				queryRichieste.add(disjunctionStati);
			}
			 
			 
			if (is_internal != null && !("").equalsIgnoreCase(is_internal)) {
				boolean internal = false;
				if ("true".equalsIgnoreCase(is_internal)) {
					internal = true;
				}

				Property propertyIsInternal = PropertyFactoryUtil.forName("is_internal");
				queryRichieste.add(propertyIsInternal.eq(internal));
			}
			 
			
			
			Property propertyIsLast = PropertyFactoryUtil.forName("is_last");
			queryRichieste.add(propertyIsLast.eq(is_last));
			
		     queryRichieste.addOrder(OrderFactoryUtil.desc("data_modifica"));	
			 res_richieste = RichiestaBadgeLocalServiceUtil.dynamicQuery(queryRichieste);			
			 
			 
		}
		catch (Exception e) {
			_log.info(e);
	    }
	    finally {
	    	  closeSession(session);  
         }
		return res_richieste;	
	}
	
	
	
	public List<RichiestaBadge> findRichiestaByDipartimentoStato(String dipartimento,List<Long>  lista_IdStato ){	
		List<RichiestaBadge> res_richiesteGest= new ArrayList<RichiestaBadge>();	
		
        Session session = null;
		
		try{
			session = openSession();
			 DynamicQuery queryRichieste = DynamicQueryFactoryUtil.forClass(RichiestaBadge.class,getClassLoader());
			
			 if(dipartimento!=null && !("").equals(dipartimento)) {
				 
				 String value = (new StringBuilder("%")).append(dipartimento).append("%").toString(); 
				 queryRichieste.add(RestrictionsFactoryUtil.ilike("json_richiedente", value));  
			 } 
			 if(lista_IdStato!= null && !lista_IdStato.isEmpty()) {
				 
				 Disjunction disjunctionStati = RestrictionsFactoryUtil.disjunction();
				 for(long id_stato:lista_IdStato){
						Property propertyStato=PropertyFactoryUtil.forName("id_stato");	
						disjunctionStati.add(propertyStato.eq(id_stato));						
				 }
				 queryRichieste.add(disjunctionStati);
			 }
			 
			 queryRichieste.addOrder(OrderFactoryUtil.desc("data_modifica"));
			 res_richiesteGest = RichiestaBadgeLocalServiceUtil.dynamicQuery(queryRichieste);		
			 
		}
		catch (Exception e) {
			_log.info(e);
	    }
	    finally {
	    	  closeSession(session);  
         }
		return res_richiesteGest;
	}

	
	
	public List<RichiestaBadge> findRichiestaByDataRuoloSede(Date dataStart, Date dataEnd, boolean is_last, boolean is_internal, long id_stato, long id_sedesiap  ){	
		List<RichiestaBadge> res_richiesteGest= new ArrayList<RichiestaBadge>();	
		
        Session session = null;
		
		try{
			session = openSession();
			 DynamicQuery queryRichieste = DynamicQueryFactoryUtil.forClass(RichiestaBadge.class,getClassLoader());
			 queryRichieste.add(RestrictionsFactoryUtil.eq("is_last", is_last));
			 queryRichieste.add(RestrictionsFactoryUtil.eq("is_internal", is_internal));
			 queryRichieste.add(RestrictionsFactoryUtil.eq("id_stato", id_stato));
			 if(id_sedesiap!=0){
				 queryRichieste.add(RestrictionsFactoryUtil.eq("id_sedesiap", id_sedesiap));
			 }
			 
			 if(dataStart!=null && dataEnd!=null){
			 queryRichieste.add(RestrictionsFactoryUtil.between("data_modifica", dataStart, dataEnd));
			 }
			 
			 queryRichieste.addOrder(OrderFactoryUtil.desc("data_richiesta"));
			 res_richiesteGest = RichiestaBadgeLocalServiceUtil.dynamicQuery(queryRichieste);					 
		}
		catch (Exception e) {
			_log.info(e);
	    }
	    finally {
	    	  closeSession(session);  
         }
		return res_richiesteGest;
	}
	
	public List<RichiestaBadge> findRichiesteInScadenza(Date data_begin, Date data_end, boolean is_last, long id_stato, String screen_name_richiedente, List<Long> id_uffici_competenza_list){	
		
		List<RichiestaBadge> richieste_in_scadenza_list =  new ArrayList<RichiestaBadge>(0);	
		
        Session session = null;
		
		try{
			
			 session = openSession();
			 
			 DynamicQuery query_richieste_in_scadenza = DynamicQueryFactoryUtil.forClass(RichiestaBadge.class,getClassLoader());
			 
			 query_richieste_in_scadenza.add(RestrictionsFactoryUtil.eq("is_last", is_last));
			 query_richieste_in_scadenza.add(RestrictionsFactoryUtil.eq("id_stato", id_stato));
			 
			 if (screen_name_richiedente != null && !("").equals(screen_name_richiedente)) {	
				 Property property_screen_name = PropertyFactoryUtil.forName("screename_richiedente");	
				 query_richieste_in_scadenza.add(property_screen_name.eq(screen_name_richiedente));   
			 }
			 
			 if (id_uffici_competenza_list != null && !id_uffici_competenza_list.isEmpty()){
				 Disjunction disjunction_uffici = RestrictionsFactoryUtil.disjunction();
				 
				 for(long id_ufficio : id_uffici_competenza_list){
					 
						Property property_ufficio = PropertyFactoryUtil.forName("id_ufficio");	
						disjunction_uffici.add(property_ufficio.eq(id_ufficio));	
						
				 }
				 
				 query_richieste_in_scadenza.add(disjunction_uffici);
			 }
			 
			 if (data_begin != null && data_end != null){
				 query_richieste_in_scadenza.add(RestrictionsFactoryUtil.between("data_scadenza", data_begin, data_end));
			 }
			 
			 query_richieste_in_scadenza.addOrder(OrderFactoryUtil.asc("data_scadenza"));	
			 richieste_in_scadenza_list = RichiestaBadgeLocalServiceUtil.dynamicQuery(query_richieste_in_scadenza);				
			 
		}
		catch (Exception e) {
			_log.info(e);
	    }
	    finally {
	    	  closeSession(session);  
         }
		
		return richieste_in_scadenza_list;
		
	}
	
	
	
	public List<Object[]> findNumbersRichiestaByDataRuoloSedeforIdOggetto(Date dataStart, Date dataEnd, boolean is_last, boolean is_internal, long id_stato, long id_sedesiap  ){	
		List<Object[]> res_richiesteGest= new ArrayList<Object[]>();	
		
        Session session = null;
		
		try{
			session = openSession();
			 DynamicQuery queryRichieste = DynamicQueryFactoryUtil.forClass(RichiestaBadge.class,getClassLoader());
			 queryRichieste.add(RestrictionsFactoryUtil.eq("is_last", is_last));
			 queryRichieste.add(RestrictionsFactoryUtil.eq("is_internal", is_internal));
			 queryRichieste.add(RestrictionsFactoryUtil.eq("id_stato", id_stato));
			 if(id_sedesiap!=0){
				 queryRichieste.add(RestrictionsFactoryUtil.eq("id_sedesiap", id_sedesiap));
			 }
			 
			 if(dataStart!=null && dataEnd!=null){
			 queryRichieste.add(RestrictionsFactoryUtil.between("data_modifica", dataStart, dataEnd));
			 }
			 
			 //addprojection
			 ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			 projectionList.add(ProjectionFactoryUtil.groupProperty("id_oggetto"));
			 projectionList.add(ProjectionFactoryUtil.rowCount());
			 queryRichieste.setProjection(projectionList);
			 
			 res_richiesteGest = RichiestaBadgeLocalServiceUtil.dynamicQuery(queryRichieste);					 
		}
		catch (Exception e) {
			_log.info(e);
	    }
	    finally {
	    	  closeSession(session);  
         }
		return res_richiesteGest;
	}
	
	
	
	
	
	
	
}