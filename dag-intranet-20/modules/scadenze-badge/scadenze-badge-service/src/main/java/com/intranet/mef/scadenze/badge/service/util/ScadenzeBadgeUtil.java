package com.intranet.mef.scadenze.badge.service.util;


import com.liferay.petra.mail.MailEngineException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import aQute.bnd.osgi.Clazz.QUERY;
import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.model.SediEsterne;
import servizio.richieste.badge.mef.service.RichiestaBadgeLocalServiceUtil;	
import servizio.richieste.badge.mef.service.SediEsterneLocalServiceUtil;

public class ScadenzeBadgeUtil {

	
public static void prepareMaiForMantainers() throws UnsupportedEncodingException, MailEngineException{


Calendar startCal = Calendar.getInstance();
startCal.set( Calendar.AM_PM, Calendar.AM );
startCal.set(Calendar.HOUR, 00);
startCal.set(Calendar.MINUTE, 01);
Date dataStart = startCal.getTime();
_log.info("dataStart "+dataStart);

startCal.set( Calendar.AM_PM, Calendar.PM );
startCal.set(Calendar.HOUR, 11);
startCal.set(Calendar.MINUTE, 59);
Date dataEnd = startCal.getTime();
_log.info("dataEnd "+dataEnd);

boolean is_last=true;


long id_stato=2;

//gestori interni
boolean is_internal = true;

MailUtil senderMailUtil = new MailUtil();

List<RichiestaBadge> richiesteBadge = RichiestaBadgeLocalServiceUtil.findRichiestaByDataRuoloSede(dataStart, dataEnd, is_last, is_internal, id_stato,0);
List<Object[]> riepilogoRichieste = RichiestaBadgeLocalServiceUtil.findNumbersRichiestaByDataRuoloSedeforIdOggetto(dataStart, dataEnd, is_last, is_internal, id_stato, 0);

// trovo gli utenti che hanno il ruolo su gestore interno

String gestoreInternoName = "gestoreIntBadge";
long defaultCompanyId = PortalUtil.getDefaultCompanyId();

try {
	Role roleGestoreInterno = RoleLocalServiceUtil.getRole(defaultCompanyId, gestoreInternoName);
	List<User> gestoriInterni = UserLocalServiceUtil.getRoleUsers(roleGestoreInterno.getRoleId());
	//scorro gli utenti e invio le email
	if(!richiesteBadge.isEmpty())
		senderMailUtil.prepareAndSendEmail(richiesteBadge, riepilogoRichieste, gestoriInterni,is_internal);
	
} catch (PortalException e) {
	_log.error(e);
}








//gestori esterni

is_internal = false;
//parto dalla tabella delle sedi esterne e ricavo la lista di sedi esterne
List<SediEsterne> sedisiap= SediEsterneLocalServiceUtil.getSediEsternes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//scansioni sedi
for(SediEsterne sedesiap: sedisiap){
 
	
	try {
//ricavo l'utente gestore esterno mediante transcodifica	
	 StringBuilder gstsedebuilder = new StringBuilder();
     gstsedebuilder.append("gestoreExtBadge_");
     gstsedebuilder.append(sedesiap.getAcronimo_sede());
	 String gestoreExtSede = gstsedebuilder.toString();
	 Role roleGestoreEsterno = RoleLocalServiceUtil.getRole(defaultCompanyId, gestoreExtSede);	 
	 List<User> gestoriEsterni = UserLocalServiceUtil.getRoleUsers(roleGestoreEsterno.getRoleId());	
	 //ricavo la lista delle richieste degli  utenti esterni per il codice siap derivante dalla sede richiedente
	 
	
	 List<RichiestaBadge> richiesteBadgeEsterne = RichiestaBadgeLocalServiceUtil.findRichiestaByDataRuoloSede(dataStart, dataEnd, is_last, is_internal, id_stato, sedesiap.getId_sedesiap());
	 List<Object[]> riepilogoRichiesteEsterne = RichiestaBadgeLocalServiceUtil.findNumbersRichiestaByDataRuoloSedeforIdOggetto(dataStart, dataEnd, is_last, is_internal, id_stato, sedesiap.getId_sedesiap());	 
	 //ora posso mandare la mail agli utenti con il size della lista oppure i dettagli
	 if(!richiesteBadgeEsterne.isEmpty())
	  senderMailUtil.prepareAndSendEmail(richiesteBadgeEsterne, riepilogoRichiesteEsterne, gestoriEsterni,is_internal);
  
	}catch (PortalException e) {
	
		_log.error(e);
	}
}




	
}	





private static final Log _log = LogFactoryUtil.getLog(ScadenzeBadgeUtil.class);
}
