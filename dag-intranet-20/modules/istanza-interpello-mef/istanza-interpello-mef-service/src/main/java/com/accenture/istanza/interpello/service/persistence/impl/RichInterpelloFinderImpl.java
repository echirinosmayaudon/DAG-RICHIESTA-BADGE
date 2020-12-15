package com.accenture.istanza.interpello.service.persistence.impl;

import com.accenture.istanza.interpello.model.RichInterpello;
import com.accenture.istanza.interpello.model.impl.RichInterpelloImpl;
import com.accenture.istanza.interpello.service.persistence.RichInterpelloFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class RichInterpelloFinderImpl extends RichInterpelloFinderBaseImpl implements RichInterpelloFinder {

private static final Log _log = LogFactoryUtil.getLog(RichInterpelloFinderImpl.class);
	
	public  List<RichInterpello> getRichiesteOrder(String order, long codiceIstanza, String cognome, long dip, long dir, long uff){
		
		Session session = null;
	    try {
			session = openSession();
			
			List<RichInterpello> results = new ArrayList<>();
			String sql = CustomSQLUtil.get(getClass(), GET_RICHIESTE_ORDER);
		
			sql = CustomSQLUtil.removeOrderBy(sql);
			
			//FILTRI
			if (codiceIstanza != 0) {
				sql = sql.concat("AND MEFISTAGILE_RICHLAVAGILE.ID_RICHIESTA = "+codiceIstanza+"");
			}
			if (cognome != null && !("").equalsIgnoreCase(cognome)) {
				sql = sql.concat( "AND upper (MEFISTAGILE_RICHLAVAGILE.COGNOME) = upper ('"+cognome+"')");
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
			query.addEntity("RichLavAgile", RichInterpelloImpl.class);

	         results = (List<RichInterpello>) QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	         
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
	
  private static final String GET_RICHIESTE = RichInterpelloFinder.class.getName() +".getRichieste";
  private static final String GET_RICHIESTE_ORDER = RichInterpelloFinder.class.getName() +".getRichiesteOrder";
	
}
