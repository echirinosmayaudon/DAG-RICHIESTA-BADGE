package mef.richieste.badge.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;

import servizio.richieste.badge.mef.model.RichiestaBadge;

public class ProrogaMailUtil {
	
	public static final String _HEADER_MAIL_PROROGA =
			"<h1><strong>RIEPILOGO BADGE DA PROROGARE</strong>" +
			"</h1><br/>"+
			"<p>Si richiede la proroga dei seguenti badge alla data: [$NEWDEADLINE$]</p>"+		
			"<br/>";	

	public static final String _HEADER_TABLE_PROROGA =	
            "<table style='width:100%; border-collapse:collapse' border=1>" +
            "<tr><th bgcolor='#DAD9DD'>Numero Badge</th><th bgcolor='#DAD9DD'>Assegnatario Badge</th><th bgcolor='#DAD9DD'>Codice Fiscale</th><th bgcolor='#DAD9DD'>Scadenza precedente</th><th bgcolor='#DAD9DD'>Tipologia Utente</th> ";
				
	public static final String _BODY_TABLE_PROROGA =								
			"<tr>" +
			"<td> [$NUMBADGE$] </td> <td> [$ASSEGNATARIO$] </td> <td> [$CODFISCALE$] </td> <td> [$SCADENZA$] </td> <td> [$TIPOUTENTE$] </td>" +
			"</tr>";

	public static final String _FOOTER_TABLE_PROROGA =								
			"</table>" ;
	
	private static final Log _log = LogFactoryUtil.getLog(ProrogaMailUtil.class);
	
	
	public boolean sendProrogaEmail(String senderName, String senderMailAddress, StringBuilder emailBody, String email_dirigente) {

		MailMessage mailMessage = new MailMessage();
		
		try {		
		    mailMessage.setFrom(new InternetAddress(senderMailAddress, senderName));
		    mailMessage.setSubject("Richiesta di proroga Badge Online");
			mailMessage.setBody(emailBody.toString());
		    mailMessage.setInReplyTo("noreply@mef.it");
		    mailMessage.setTo(new InternetAddress(email_dirigente));
			mailMessage.setHTMLFormat(true);			
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
				_log.error("Error sending proroga email: " + e);
				return false;
		}
	  	return true;
			
	}
	
	public static void _trackHeaderMailProroga(StringBuilder emailBody, String inputNuovaDataScadenzaProroga){
		String value = StringUtil.replace(
			_HEADER_MAIL_PROROGA,
			new String[] {"[$NEWDEADLINE$]"},
			new String[] {inputNuovaDataScadenzaProroga});

		emailBody.append(value);
	}
	
	public static void _trackEmailProroga(StringBuilder emailBody, RichiestaBadge richBadge, SimpleDateFormat sdf) {

			Date old_deadline = richBadge.getData_scadenza();
			String old_deadline_string = "";
			
			if(old_deadline!=null) {
				old_deadline_string = sdf.format(old_deadline);
			}
			
			String tipo_utente = "esterno";
			
			if(richBadge.getIs_internal()) {
				tipo_utente = "interno";
			}
		
		    String assegnatario = richBadge.getNome_intestatario() + " " + richBadge.getCognome_intestatario(); 
		    
			String value = StringUtil.replace(
					_BODY_TABLE_PROROGA,
				new String[] {"[$NUMBADGE$]","[$ASSEGNATARIO$]","[$CODFISCALE$]","[$SCADENZA$]","[$TIPOUTENTE$]"},
				new String[] {richBadge.getNumero_badge(), assegnatario, richBadge.getCf_intestatario(), old_deadline_string, tipo_utente});

			emailBody.append(value);

	}

	public void prepareAndSendProrogaEmail(String inputNuovaDataScadenzaProroga, List<RichiestaBadge> lista_richieste_proroga, String email_dirigente, SimpleDateFormat sdf, String senderName, String senderMailAddress){
			
			//creo l'intestazione/header della mail
			StringBuilder emailBody = new StringBuilder();
			_trackHeaderMailProroga(emailBody, inputNuovaDataScadenzaProroga);
			
			//apro l'intestazione della tabella riepilogativa
			emailBody.append(_HEADER_TABLE_PROROGA);
				
			//creo il body della tabella riepilogativa
			for(RichiestaBadge item_richiesta_proroga : lista_richieste_proroga){
				_trackEmailProroga(emailBody, item_richiesta_proroga, sdf);
			}
			
			//aggiungo la chiusura della tabella riepilogativa
			emailBody.append(_FOOTER_TABLE_PROROGA);
			
			try {
				//invio la mail al Dirigente
				sendProrogaEmail(senderName, senderMailAddress, emailBody, email_dirigente);
			} catch (Exception e) {
				_log.error(e, e);
			}
			
		}

}