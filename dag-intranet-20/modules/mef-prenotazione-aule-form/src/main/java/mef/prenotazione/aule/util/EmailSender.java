package mef.prenotazione.aule.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import javax.mail.internet.InternetAddress;

import javax.mail.MessagingException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


public class EmailSender {

	 final Log _log = LogFactoryUtil.getLog(EmailSender.class);
	  public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress) {

       try{
             	MailMessage mailMessage=new MailMessage();
				mailMessage.setBody(mailBody);
				mailMessage.setSubject(mailSubject); 				
			    mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
			    mailMessage.setInReplyTo("noreply@mef.it");
			    mailMessage.setTo(new InternetAddress(receiverMailAddress));
				mailMessage.setHTMLFormat(true);			
				MailServiceUtil.sendEmail(mailMessage);

       }
       catch (Exception e) {
       	_log.error(e);
       	return false;
		  }
       	return true;
	  }	
	  
	  
	  
	  public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, String ccmailaddress, String otherccmailaddress) {

		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						mailMessage.setTo(new InternetAddress(receiverMailAddress));
						
						List<String> ccaddressesList= new ArrayList<String>(0);					
						if(ccmailaddress!=null)
							ccaddressesList.add(ccmailaddress);													
						if(otherccmailaddress!=null)
							ccaddressesList.add(otherccmailaddress);
						if(!ccaddressesList.isEmpty()){
							InternetAddress[] ccAdresses =new InternetAddress[ccaddressesList.size()];
							for(int i=0; i<ccaddressesList.size(); i++){
								ccAdresses[i]=new InternetAddress(ccaddressesList.get(i));
							}
							mailMessage.setCC(ccAdresses);
						}
					
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
		  }
		catch (MessagingException me) {
			_log.info(me);
			Exception e = me.getNextException();
			if (e instanceof SocketException) {
				_log.warn(e);
			} else
				_log.error(e);
			return false;
		} catch (UnsupportedEncodingException e) {

			_log.error(e);
			return false;
		}

	  return true;
	
}
	  
	  
	  
	  public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, String ccmailaddress, String otherccmailaddress, File file) {

		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						mailMessage.setTo(new InternetAddress(receiverMailAddress));
						
						List<String> ccaddressesList= new ArrayList<String>(0);					
						if(ccmailaddress!=null)
							ccaddressesList.add(ccmailaddress);													
						if(otherccmailaddress!=null)
							ccaddressesList.add(otherccmailaddress);
						if(!ccaddressesList.isEmpty()){
							InternetAddress[] ccAdresses =new InternetAddress[ccaddressesList.size()];
							for(int i=0; i<ccaddressesList.size(); i++){
								ccAdresses[i]=new InternetAddress(ccaddressesList.get(i));
							}
							mailMessage.setCC(ccAdresses);
						}
						mailMessage.setHTMLFormat(true);
						mailMessage.addFileAttachment(file, "riepilogoRichiesta.xls");
						MailServiceUtil.sendEmail(mailMessage);
		  }
		catch (MessagingException me) {
			_log.info(me);
			Exception e = me.getNextException();
			if (e instanceof SocketException) {
				_log.warn(e);
			} else
				_log.error(e);
			return false;
		} catch (UnsupportedEncodingException e) {

			_log.error(e);
			return false;
		}

	  return true;
	
}
	
	  public boolean sendMail(String mailSubject, String mailBody, String senderName, String senderMailAddress,String emailAddress) {

		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						mailMessage.setTo(new InternetAddress(emailAddress));
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
		  }
		catch (MessagingException me) {
			_log.info(me);
			Exception e = me.getNextException();
			if (e instanceof SocketException) {
				_log.warn(e);
			} else
				_log.error(e);
			return false;
		} catch (UnsupportedEncodingException e) {

			_log.error(e);
			return false;
		}

	  return true;
	
}

	 
	  
	  
	  

	
	
}
