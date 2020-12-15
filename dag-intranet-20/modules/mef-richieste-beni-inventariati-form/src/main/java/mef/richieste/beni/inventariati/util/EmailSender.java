package mef.richieste.beni.inventariati.util;


import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import java.io.File;
import java.io.UnsupportedEncodingException;
import javax.mail.internet.InternetAddress;
import javax.mail.MessagingException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class EmailSender {

	  final Log _log = LogFactoryUtil.getLog(EmailSender.class);
	  public boolean sendMailMessageOneReceiver(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress) {

        try{
              	MailMessage mailMessage=new MailMessage();
				mailMessage.setBody(mailBody);
				mailMessage.setSubject(mailSubject); 				
			    mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
			    mailMessage.setTo(new InternetAddress(receiverMailAddress)); 
			    mailMessage.setInReplyTo("noreply@mef.it");
				mailMessage.setHTMLFormat(true);			
				MailServiceUtil.sendEmail(mailMessage);
 
        }
        catch (Exception e) {
        	_log.error(e);
        	return false;
		  }
        	return true;
	  }	
	  
	  public boolean sendMailMessageOneReceiverTwoCC(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, String ccmailaddress, String otherccmailaddress) {

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
			_log.warn(me);
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
	  
	  
	  public boolean sendMailMessageOneListReceiverTwoCC(String mailSubject, String mailBody, String senderName, String senderMailAddress, List<User> receiverMailUsers, String ccmailaddress, String otherccmailaddress) {

		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");			
						if(receiverMailUsers!=null && !receiverMailUsers.isEmpty()){
							InternetAddress[] toAdresses =new InternetAddress[receiverMailUsers.size()];
							for(int i=0; i<receiverMailUsers.size(); i++){
								toAdresses[i]=new InternetAddress(receiverMailUsers.get(i).getEmailAddress());
							}
							mailMessage.setTo(toAdresses);
						} 
						
						
						
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
			_log.warn(me);
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
	  
	  
	  public boolean sendMailMessageTwoReceiverOneCC(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, String otherReceiverMailAddress, String ccmailaddress) {

		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						
						List<String> receiveraddressesList= new ArrayList<String>(0);					
						if(receiverMailAddress!=null)
							receiveraddressesList.add(receiverMailAddress);													
						if(otherReceiverMailAddress!=null)
							receiveraddressesList.add(otherReceiverMailAddress);
						if(!receiveraddressesList.isEmpty()){
							InternetAddress[] receiverAdresses =new InternetAddress[receiveraddressesList.size()];
							for(int i=0; i<receiveraddressesList.size(); i++){
								receiverAdresses[i]=new InternetAddress(receiveraddressesList.get(i));
							}
							mailMessage.setTo(receiverAdresses);
						}
						
						mailMessage.setCC(new InternetAddress(ccmailaddress));
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
		  }
		catch (MessagingException me) {
			_log.warn(me);
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
	  
	  public boolean sendMailMessageTwoReceiverOneListCC(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, String otherReceiverMailAddress, List<User> ccmailUsers) {

		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						
						List<String> receiveraddressesList= new ArrayList<String>(0);					
						if(receiverMailAddress!=null)
							receiveraddressesList.add(receiverMailAddress);													
						if(otherReceiverMailAddress!=null)
							receiveraddressesList.add(otherReceiverMailAddress);
						if(!receiveraddressesList.isEmpty()){
							InternetAddress[] receiverAdresses =new InternetAddress[receiveraddressesList.size()];
							for(int i=0; i<receiveraddressesList.size(); i++){
								receiverAdresses[i]=new InternetAddress(receiveraddressesList.get(i));
							}
							mailMessage.setTo(receiverAdresses);
						}
						
						if(ccmailUsers!=null && !ccmailUsers.isEmpty()){
							InternetAddress[] ccAdresses =new InternetAddress[ccmailUsers.size()];
							for(int i=0; i<ccmailUsers.size(); i++){
								ccAdresses[i]=new InternetAddress(ccmailUsers.get(i).getEmailAddress());
							}
							mailMessage.setCC(ccAdresses);
						} 
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
		  }
		catch (MessagingException me) {
			_log.warn(me);
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
	  
	  public boolean sendMailMessageOneReceiverOneCC(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, String ccmailaddress) {

		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						mailMessage.setTo(new InternetAddress(receiverMailAddress));
						if(ccmailaddress!=null){
						mailMessage.setCC(new InternetAddress(ccmailaddress));}
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
		  }
		catch (MessagingException me) {
			_log.warn(me);
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
	  
	  public boolean sendMailMessageOneListReceiverOneListCC(String mailSubject, String mailBody, String senderName, String senderMailAddress,List<User> receiverMailUsers, List<User> ccmailUsers) {

		  try {			
			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						if(receiverMailUsers!=null && !receiverMailUsers.isEmpty()){
							InternetAddress[] toAdresses =new InternetAddress[receiverMailUsers.size()];
						for(int i=0; i<receiverMailUsers.size(); i++){
							toAdresses[i]=new InternetAddress(receiverMailUsers.get(i).getEmailAddress());
						}
		  
						mailMessage.setTo(toAdresses);
		  }
						if(ccmailUsers!=null && !ccmailUsers.isEmpty()){
							InternetAddress[] ccAdresses =new InternetAddress[ccmailUsers.size()];
						for(int i=0; i<ccmailUsers.size(); i++){
							ccAdresses[i]=new InternetAddress(ccmailUsers.get(i).getEmailAddress());
						}
		  
						mailMessage.setCC(ccAdresses);
		  }
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
		  }
		catch (MessagingException me) {
			_log.warn(me);
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
