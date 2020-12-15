package service.intranet.mef.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.intranet.mef.model.BeneInvRichiesto;
import service.intranet.mef.model.RichiestaBeneInv;
import service.intranet.mef.service.RichiestaBeneInvLocalServiceUtil;
import service.intranet.mef.service.persistence.RichiestaBeneInvFinder;

public class RichiestaBeneInvFinderImpl extends RichiestaBeneInvFinderBaseImpl implements RichiestaBeneInvFinder  {
	
	private static final Log _log = LogFactoryUtil.getLog(RichiestaBeneInvFinderImpl.class);
	
	public List<RichiestaBeneInv> getRichiesteBeniInvByFilters(long id_richiesta, String nome_rich, String cogn_rich, Date data, String dip_dir, List<Long> list_id_stato, String tipologia, boolean in_elenco){
		List<RichiestaBeneInv> res_richieste=new ArrayList<RichiestaBeneInv>();	
		Session session = null;
		try{
			 session = openSession();
			 
			 DynamicQuery queryRichieste=
					 
					    DynamicQueryFactoryUtil.forClass(RichiestaBeneInv.class,getClassLoader());
			 
			 if( id_richiesta!=0){
						Property propertyId=PropertyFactoryUtil.forName("id_richiesta");	
			            queryRichieste.add(propertyId.eq(id_richiesta));
			 }     
			 if(nome_rich!=null){
			            Property propertyNome=PropertyFactoryUtil.forName("nome_rich");	
			            queryRichieste.add(propertyNome.eq(nome_rich));
		     }   	
			 if(cogn_rich!=null){
			        	Property propertyCognome=PropertyFactoryUtil.forName("cogn_rich");	
			        	queryRichieste.add(propertyCognome.eq(cogn_rich));
			 }   
			 if(data!=null){
			        	Property propertyDate=PropertyFactoryUtil.forName("data");	
			        	queryRichieste.add(propertyDate.eq(data));
			 }
			 if(dip_dir!=null){
			        	Property propertyDip=PropertyFactoryUtil.forName("dip_dir");	
			        	queryRichieste.add(propertyDip.eq(dip_dir));
			 }   
			 if(list_id_stato!=null && !list_id_stato.isEmpty()){
				 Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
				 for(long id_stato:list_id_stato){
						Property propertyStato=PropertyFactoryUtil.forName("id_stato");	
						disjunctionKey.add(propertyStato.eq(id_stato));
						
				 }
				 queryRichieste.add(disjunctionKey);
			 }
			 
			 DynamicQuery queryBeniRichiesti=
					 DynamicQueryFactoryUtil.forClass(BeneInvRichiesto.class,getClassLoader());
			 if(tipologia!=null){
					Property propertyTipologia=PropertyFactoryUtil.forName("tipologia");	
					queryBeniRichiesti.add(propertyTipologia.eq(tipologia));
		     }     
		    
		            Property propertyIn_elenco=PropertyFactoryUtil.forName("in_elenco");	
		            queryBeniRichiesti.add(propertyIn_elenco.eq(in_elenco));
		            
		            queryBeniRichiesti.setProjection(ProjectionFactoryUtil.property("id_richiesta"));
  
		            queryRichieste.add(PropertyFactoryUtil.forName("id_richiesta").in(queryBeniRichiesti));
	 
		            res_richieste=RichiestaBeneInvLocalServiceUtil.dynamicQuery(queryRichieste);			
	 
		}
		catch (Exception e) {
			_log.info(e);
	    }
	    finally {
	    	  closeSession(session);
	       
         }
	return res_richieste;
	}
	
	
	
	public List<RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(long id_richiesta, String screenName, Date data, List<Long> list_id_stato, String tipologia, boolean in_elenco){
		List<RichiestaBeneInv> res_richiesteRichiedente=new ArrayList<RichiestaBeneInv>();	
		Session session = null;
		try{
			 session = openSession();
			 
			 DynamicQuery queryRichiesteRichiedente=
					 
					    DynamicQueryFactoryUtil.forClass(RichiestaBeneInv.class,getClassLoader());
						
			 if(screenName!=null){
			            Property propertyScreenName=PropertyFactoryUtil.forName("utente");	
			            queryRichiesteRichiedente.add(propertyScreenName.eq(screenName));
		     }   
			 if( id_richiesta!=0){
						Property propertyId=PropertyFactoryUtil.forName("id_richiesta");	
						queryRichiesteRichiedente.add(propertyId.eq(id_richiesta));
			 }       
			 if(data!=null){
			        	Property propertyDate=PropertyFactoryUtil.forName("data");	
			        	queryRichiesteRichiedente.add(propertyDate.eq(data));
			 }
			  
			 if(list_id_stato!=null && !list_id_stato.isEmpty()){
				 Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
				 for(long id_stato:list_id_stato){
						Property propertyStato=PropertyFactoryUtil.forName("id_stato");	
						disjunctionKey.add(propertyStato.eq(id_stato));
						
				 }
				 queryRichiesteRichiedente.add(disjunctionKey);
			 }
			 
			 DynamicQuery queryBeniRichiesti=
					 DynamicQueryFactoryUtil.forClass(BeneInvRichiesto.class,getClassLoader());
			 if(tipologia!=null){
					Property propertyTipologia=PropertyFactoryUtil.forName("tipologia");	
					queryBeniRichiesti.add(propertyTipologia.eq(tipologia));
		     }     
		    
		            Property propertyIn_elenco=PropertyFactoryUtil.forName("in_elenco");	
		            queryBeniRichiesti.add(propertyIn_elenco.eq(in_elenco));
		            
		            queryBeniRichiesti.setProjection(ProjectionFactoryUtil.property("id_richiesta"));
  
		            queryRichiesteRichiedente.add(PropertyFactoryUtil.forName("id_richiesta").in(queryBeniRichiesti));
	 
		            res_richiesteRichiedente=RichiestaBeneInvLocalServiceUtil.dynamicQuery(queryRichiesteRichiedente);			
	 
		}
		catch (Exception e) {
			_log.info(e);
	    }
	    finally {
	    	  closeSession(session);
	       
         }
	return res_richiesteRichiedente;
	}

}