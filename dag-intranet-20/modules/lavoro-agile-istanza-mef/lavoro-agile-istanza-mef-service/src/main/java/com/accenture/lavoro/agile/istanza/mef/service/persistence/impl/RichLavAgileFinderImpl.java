package com.accenture.lavoro.agile.istanza.mef.service.persistence.impl;

import com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile;
import com.accenture.lavoro.agile.istanza.mef.model.impl.RichLavAgileImpl;
import com.accenture.lavoro.agile.istanza.mef.service.persistence.RichLavAgileFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class RichLavAgileFinderImpl  extends RichLavAgileFinderBaseImpl implements RichLavAgileFinder {
	
	private static final Log _log = LogFactoryUtil.getLog(RichLavAgileFinderImpl.class);


	
	public  List<RichLavAgile> getRichiesteOrder(String order, long codiceIstanza, String cognome, long dip, long dir, long uff){
		
		Session session = null;
	    try {
			session = openSession();
			
			List<RichLavAgile> results = new ArrayList<>();
			String sql = CustomSQLUtil.get(getClass(), GET_RICHIESTE_ORDER);
			
		
		 
			sql = CustomSQLUtil.removeOrderBy(sql);
			
			//FILTRI
			if (codiceIstanza != 0) {
				sql = sql.concat("AND MEFISTAGILE_RICHLAVAGILE.ID_RICHIESTA = "+codiceIstanza+"");
			}
			if (cognome != null && !("").equalsIgnoreCase(cognome)) {
			//	cognome = HtmlUtil.unescape(cognome);
				String cognomeNewReplace = cognome;
				if(cognome.indexOf("'")!=-1){
					 cognomeNewReplace =cognome.replaceAll("'", "''");
				}else if(cognome.indexOf("&#39;")!=-1){
					 cognomeNewReplace =cognome.replaceAll("&#39;", "''");
				}
				
				
				sql = sql.concat( "AND upper (MEFISTAGILE_RICHLAVAGILE.COGNOME) LIKE upper ('%"+cognomeNewReplace+"%')");
				
			}
			if (dip != 0) {
				sql = sql.concat("AND MEFISTAGILE_RICHLAVAGILE.DIPARTIMENTO = "+dip+"");
			}
			if (dir != 0) {
				sql = sql.concat( "AND MEFISTAGILE_RICHLAVAGILE.DIREZIONE = "+dir+"");
			}
			if (uff != 0) {
				sql = sql.concat("AND MEFISTAGILE_RICHLAVAGILE.UFFICIO = "+uff+"");
			}
			
			//ORDER BY
			switch (order) {
			case "cognome":
				sql = sql.concat("ORDER BY COGNOME,NOME ASC");
				break;
			case "punteggio":
				sql = sql.concat("ORDER BY PESO_TOT DESC");
				break;
			case "priorita":
				sql = sql.concat("ORDER BY PESO_PLUS DESC, PESO_TOT DESC");
				break;
			default:
				sql = sql.concat("ORDER BY COGNOME,NOME ASC");
			}

			
			
			SQLQuery query = session.createSQLQuery(sql);
			
			

			query.setCacheable(false);
			query.addEntity("RichLavAgile", RichLavAgileImpl.class);

	         results = (List<RichLavAgile>) QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	           
	        

	         
			return results;
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	           _log.error(se);
	        }
	    }
	    finally {
	        closeSession(session);
	    }
		return null;
		
		
	}
	
//	public List<RichLavAgile> getRichieste(String order, String cognome, long dip, long dir, long uff){
//		return this.prepareQuery(GET_RICHIESTE, order, cognome, dip, dir, uff);
//	}

	
  private static final String GET_RICHIESTE = RichLavAgileFinder.class.getName() +".getRichieste";
  private static final String GET_RICHIESTE_ORDER = RichLavAgileFinder.class.getName() +".getRichiesteOrder";



	

	
	
	
}
