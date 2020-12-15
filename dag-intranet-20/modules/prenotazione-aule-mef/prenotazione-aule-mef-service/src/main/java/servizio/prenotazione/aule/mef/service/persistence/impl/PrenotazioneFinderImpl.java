package servizio.prenotazione.aule.mef.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import servizio.prenotazione.aule.mef.model.Prenotazione;
import servizio.prenotazione.aule.mef.service.PrenotazioneLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.persistence.PrenotazioneFinder;

public class PrenotazioneFinderImpl  extends PrenotazioneFinderBaseImpl implements PrenotazioneFinder {
	
	private static final Log _log = LogFactoryUtil.getLog(PrenotazioneFinderImpl.class);
	
	public List<Prenotazione> getPrenotazioniByFilters(List<Long> id_sale_list, Date data_inizio, Date data_fine, long id_stato){
		
		List<Prenotazione> res_prenotazioni = new ArrayList<Prenotazione>();
		
		Session session = null;
		
		try {
			
			session = openSession();
			
			DynamicQuery queryPrenotazioni = DynamicQueryFactoryUtil.forClass(Prenotazione.class,getClassLoader());
			
			if (data_inizio!=null && data_fine!=null) {
				
				Disjunction disjunctionKey=RestrictionsFactoryUtil.disjunction();
				
				Property propertyDateInizio=PropertyFactoryUtil.forName("data_inizio");	
				Property propertyDateFine=PropertyFactoryUtil.forName("data_fine");
				
				Criterion criterio1=propertyDateInizio.ge(data_inizio);
				Criterion criterio2=propertyDateFine.le(data_fine);
				Criterion junctionAnd1=RestrictionsFactoryUtil.and(criterio1, criterio2);
				
				Criterion criterio3=propertyDateInizio.le(data_fine);
				Criterion criterio4=propertyDateInizio.ge(data_inizio);
				Criterion junctionAnd2=RestrictionsFactoryUtil.and(criterio3, criterio4);
				
				Criterion criterio5=propertyDateInizio.le(data_inizio);
				Criterion criterio6=propertyDateFine.ge(data_fine);
				Criterion junctionAnd3=RestrictionsFactoryUtil.and(criterio5, criterio6);
				
				Criterion criterio7=propertyDateFine.ge(data_inizio);
				Criterion criterio8=propertyDateFine.le(data_fine);
				Criterion junctionAnd4=RestrictionsFactoryUtil.and(criterio7, criterio8);
			    
				disjunctionKey.add(junctionAnd1);
				disjunctionKey.add(junctionAnd2);
				disjunctionKey.add(junctionAnd3);
				disjunctionKey.add(junctionAnd4);
				
				queryPrenotazioni.add(disjunctionKey);
			}
			
			if(id_sale_list!=null && !id_sale_list.isEmpty()){
				if (id_sale_list.size()>1) {
					 Disjunction disjunctionKey = RestrictionsFactoryUtil.disjunction();
					 	for(long id_sala:id_sale_list){
							Property propertyStato=PropertyFactoryUtil.forName("id_sala");	
							disjunctionKey.add(propertyStato.eq(id_sala));
					 	}
					 	queryPrenotazioni.add(disjunctionKey);
				}
				
				else {
					Property propertyId=PropertyFactoryUtil.forName("id_sala");	
					queryPrenotazioni.add(propertyId.eq(id_sale_list.get(0)));
				}
				
				
			}
			
			if (id_stato!=0 && id_stato!=1) {
       		 Property propertyDate=PropertyFactoryUtil.forName("id_stato");
	             queryPrenotazioni.add(propertyDate.eq(id_stato));
			}
			
			queryPrenotazioni.addOrder(OrderFactoryUtil.asc("id_sala"));
			queryPrenotazioni.addOrder(OrderFactoryUtil.asc("data_inizio"));
			res_prenotazioni = PrenotazioneLocalServiceUtil.dynamicQuery(queryPrenotazioni);
}
		
		catch (Exception e) {
			_log.info(e);
	    }
	    
		finally {
	    	  closeSession(session);
        }
		
		return res_prenotazioni;
	}

}