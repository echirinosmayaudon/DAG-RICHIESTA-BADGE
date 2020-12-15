package com.intranet.mef.scadenze.badge.service.util;


import com.intranet.mef.scadenze.badge.service.configuration.ScadenzeBadgeConfigurationValues;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.petra.mail.MailEngine;
import com.liferay.petra.mail.MailEngineException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

import servizio.richieste.badge.mef.model.OggettoRichiesta;
import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.service.OggettoRichiestaLocalServiceUtil;

public class MailUtil {
	
	
	// terzo passo invio email
	public void sendEmail(StringBuilder emailBody, String[] emailAdresses)
			throws UnsupportedEncodingException, MailEngineException {

			InternetAddress fromAddress = new InternetAddress(
				ScadenzeBadgeConfigurationValues.
					SCADENZE_BADGE_RESULT_EMAIL_FROM_ADDRESS,
				ScadenzeBadgeConfigurationValues.
					SCADENZE_BADGE_RESULT_EMAIL_FROM_NAME);

			InternetAddress[] toAddresses = _toInternetAddresses(emailAdresses);

			MailMessage mailMessage = new MailMessage();

			mailMessage.setTo(toAddresses);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject("Riepilogo richieste badge");
			mailMessage.setBody(emailBody.toString());
			mailMessage.setHTMLFormat(true);

			MailEngine.send(mailMessage);
		}
		
	

		
	public void prepareAndSendEmail(List<RichiestaBadge> listarichieste,List<Object[]> riepilogoRichieste, List<User> gestori, boolean is_internal){
			
			List<String> emailAddressList = new ArrayList<String>(0);
			for(User gestoreInterno : gestori){
				emailAddressList.add(gestoreInterno.getEmailAddress());
			}
			String[] emailAddressArray = emailAddressList.toArray(new String[0]); 
			
			//creo l'header
			StringBuilder emailBody = new StringBuilder();
			 
			_trackHeader(emailBody,is_internal);
				
			//creo la lista riepilogativa numerata delle richieste	
			for(Object[] riepilogoRichiesta : riepilogoRichieste ){	
			_trackHeaderRiepilogo(emailBody, riepilogoRichiesta);
			}
			
			// aggiungo la chiusura della lista e l'apertura della tabella
			emailBody.append(_HEADER_FOOTER);
				
			//creo il body
			for(RichiestaBadge richiesta :listarichieste){
				_trackEmailGestori(emailBody,richiesta);
			}
			
			//aggiungo la chiusura della tabella
			emailBody.append(GEST_EMAIL_FOOTER);
			
			try {
				// invio le email
				
				sendEmail(emailBody, emailAddressArray);
			} catch (Exception e) {
				_log.error(e, e);
			}
			
		}
		
		
		private InternetAddress[] _toInternetAddresses(String[] emailAddresses) {
			List<InternetAddress> addresses = new ArrayList<InternetAddress>();

			for (String emailAddress : emailAddresses) {
				try {
					InternetAddress address = new InternetAddress(emailAddress);
					addresses.add(address);
				}
				catch (Exception e) {
					_log.error(e);
				}
			}

			InternetAddress[] result = new InternetAddress[addresses.size()];

			for (int x = 0; x < addresses.size(); x++) {
				result[x] = addresses.get(x);
			}

			return result;
		}

		//primo passo inserisco l'header
		
		public static void _trackHeader(StringBuilder emailBody, boolean is_internal){
			String type = "esterni";
			if(is_internal)
				type = "interni";
			String value = StringUtil.replace(
				_HEADER_MAIL,
				new String[] {"[$VAR$]"},
				new String[] {type});

			emailBody.append(value);
		}


		//secondo passo, nel ciclo inserisco il body con la richiesta (nel ciclo scansione richieste)

		public static void _trackEmailGestori(
			StringBuilder emailBody, RichiestaBadge richBadge) {

				OggettoRichiesta oggettorichiestaobj =null;
				try {
					oggettorichiestaobj = OggettoRichiestaLocalServiceUtil.getOggettoRichiesta(richBadge.getId_oggetto());
				} catch (PortalException e) {
				_log.error(e);
				}
				
				String oggettoRichiesta = new String();
				if(oggettorichiestaobj != null){
					oggettoRichiesta = oggettorichiestaobj.getDescrizione_oggetto();
				}
		    String intestatario = richBadge.getNome_intestatario() + " " + richBadge.getCognome_intestatario(); 
			String value = StringUtil.replace(
					GEST_EMAIL_BODY,
				new String[] {"[$IDRICHIESTA$]","[$INTESTATARIO$]" , "[$OGGETTO$]"},
				new String[] {
					Long.toString(richBadge.getId_richiesta()),intestatario, oggettoRichiesta });

			emailBody.append(value);
		

		}

		public static void _trackHeaderRiepilogo(
				StringBuilder emailBody, Object[] riepilogoRichiesta) {

					OggettoRichiesta oggettorichiestaobj =null;
					try {
						oggettorichiestaobj = OggettoRichiestaLocalServiceUtil.getOggettoRichiesta(Long.parseLong(String.valueOf(riepilogoRichiesta[0])));
					} catch (PortalException e) {
					_log.error(e);
					}
					
					String oggettoRichiesta = new String();
					if(oggettorichiestaobj != null){
						oggettoRichiesta = oggettorichiestaobj.getDescrizione_oggetto();
					}
					
				String value = StringUtil.replace(
						_HEADER_LIST,
					new String[] {"[$OGGETTORICHIESTA$]", "[$NUMERORICHIESTE$]"},
					new String[] {oggettoRichiesta, String.valueOf(riepilogoRichiesta[1])});

				emailBody.append(value);
			

			}


		public static final String _HEADER_MAIL =
			"<h1><strong> Riepilogo Richieste in lavorazione Gestori [$VAR$]</strong>" +
			"</h1><br/>"+
			"<p>Di seguito viene riportato il numero delle richieste da lavorare divise per tipologia:</p>"+		
			"<ul>";		


		public static final String _HEADER_LIST =			
	            "<li>"+
	            "[$OGGETTORICHIESTA$]  ([$NUMERORICHIESTE$])  "+
	            "</li>";
		
		
		public static final String _HEADER_FOOTER=			
	            "</ul><br/>"+
	            "<table style='width:100%; border-collapse:collapse' border=1>" +
	            "<tr><th bgcolor='#DAD9DD'>Id richiesta</th><th bgcolor='#DAD9DD'>Intestatario Badge</th><th bgcolor='#DAD9DD'>Tipologia</th> ";
 		
		
		
		public static final String GEST_EMAIL_BODY =								
			"<tr>" +
			"<td> [$IDRICHIESTA$] </td> <td> [$INTESTATARIO$] </td>  <td> [$OGGETTO$] </td>" +
			"</tr>";

		public static final String GEST_EMAIL_FOOTER =								
			"</table>" ;

		private static final Log _log = LogFactoryUtil.getLog(
			MailUtil.class);
}
