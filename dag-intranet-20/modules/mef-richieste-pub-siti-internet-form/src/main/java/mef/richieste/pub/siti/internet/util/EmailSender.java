package mef.richieste.pub.siti.internet.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import mef.richieste.pub.siti.internet.bean.FileCustom;

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
			Exception e = me.getNextException();
			if (e instanceof SocketException) {
				_log.warn(e);
			} else
				_log.error(me);
			return false;
		} catch (UnsupportedEncodingException e) {

			_log.error(e);
			return false;
		}

	  return true;
	
	  }
	  
	  public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, List<FileCustom> files) {
		  
		  String fileName;
		  
		  try {			
          
  			MailMessage mailMessage=new MailMessage();
			mailMessage.setBody(mailBody);
			mailMessage.setSubject(mailSubject); 
			mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
			mailMessage.setInReplyTo("noreply@mef.it");
			mailMessage.setTo(new InternetAddress(receiverMailAddress));
			mailMessage.setHTMLFormat(true);
			
			for(FileCustom file: files) {
				fileName = new String(file.getFile().getName().getBytes("UTF-8"), "ISO-8859-1");
				mailMessage.addFileAttachment(file.getFile(), fileName);
			}
			
			return sendMailMessage(mailMessage);

		  }
		catch (MessagingException me) {
			Exception e = me.getNextException();
			if (e instanceof SocketException) {
				_log.warn(e);
			} else
				_log.error(me);
			return false;
		} catch (UnsupportedEncodingException e) {
			_log.error(e);
			return false;
		}
	
}
	  public boolean sendMailMessage(MailMessage mailMessage) {
	       try{
	             MailServiceUtil.sendEmail(mailMessage);

	       }
	       catch (Exception e) {
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
			Exception e = me.getNextException();
			if (e instanceof SocketException) {
				_log.warn(e);
			} else
				_log.error(me);
			return false;
		} catch (UnsupportedEncodingException e) {

			_log.error(e);
			return false;
		}

	  return true;
	
}
}
