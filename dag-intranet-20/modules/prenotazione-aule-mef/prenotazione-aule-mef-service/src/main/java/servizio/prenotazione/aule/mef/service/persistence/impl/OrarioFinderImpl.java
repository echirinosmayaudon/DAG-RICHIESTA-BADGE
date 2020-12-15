package servizio.prenotazione.aule.mef.service.persistence.impl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import servizio.prenotazione.aule.mef.model.Orario;
import servizio.prenotazione.aule.mef.service.OrarioLocalServiceUtil;
import servizio.prenotazione.aule.mef.service.persistence.OrarioFinder;
public class OrarioFinderImpl extends  OrarioFinderBaseImpl implements OrarioFinder{
public List<Orario> findByIdOreListOre(Long idOraInizio,Long idOraFine){
	final Log _log = LogFactoryUtil.getLog(OrarioFinderImpl.class);
	Session session = null;
    List<Orario> listOre = new ArrayList<Orario>(0);
    
    try {
               session = openSession();
               DynamicQuery oraQuery = DynamicQueryFactoryUtil.forClass(Orario.class,getClassLoader())
                .add(RestrictionsFactoryUtil.between("id_ora", idOraInizio, idOraFine));
               listOre =  OrarioLocalServiceUtil.dynamicQuery(oraQuery);
               
    }
    catch (Exception e) {
            _log.warn(e);
    }
    finally {
            closeSession(session);
    }
   return listOre;              
	}
}

