package mef.whistleblowing.form.util;

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
			_log.error(me);
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
						mailMessage.addFileAttachment(file, "riepilogoSegnalazione.xls");
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
	  
	  
	  public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, String ccmailaddress, String otherccmailaddress, File pdf, File image,File imageOther ) {

		  try {			  
				if(receiverMailAddress!=null && !"".equals(receiverMailAddress)){

		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						mailMessage.setTo(new InternetAddress(receiverMailAddress));
						
						List<String> ccaddressesList= new ArrayList<String>(0);					
						if(ccmailaddress!=null && !"".equals(ccmailaddress))
							ccaddressesList.add(ccmailaddress);													
						if(otherccmailaddress!=null && !"".equals(otherccmailaddress))
							ccaddressesList.add(otherccmailaddress);
						if(!ccaddressesList.isEmpty()){
							InternetAddress[] ccAdresses =new InternetAddress[ccaddressesList.size()];
							for(int i=0; i<ccaddressesList.size(); i++){
								ccAdresses[i]=new InternetAddress(ccaddressesList.get(i));
							}
							mailMessage.setCC(ccAdresses);
						}
						mailMessage.setHTMLFormat(true);
						if (pdf!=null)
							mailMessage.addFileAttachment(pdf, "riepilogoSegnalazione.pdf");
						if(image!=null)
							mailMessage.addFileAttachment(image, image.getName());
						if (imageOther!=null)
							mailMessage.addFileAttachment(imageOther, imageOther.getName());

						MailServiceUtil.sendEmail(mailMessage);
				}
				//_log.error("receiver undefined");
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
	  
	  public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, File pdf, List<File> attachments) {

		  try {			  
				if(receiverMailAddress!=null && !"".equals(receiverMailAddress)){

		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						mailMessage.setTo(new InternetAddress(receiverMailAddress));
						mailMessage.setHTMLFormat(true);
						
						if (pdf!=null)
							mailMessage.addFileAttachment(pdf, "riepilogoSegnalazione.pdf");
						
						if(!attachments.isEmpty()) {
							for (File singleAttachment: attachments) {
								mailMessage.addFileAttachment(singleAttachment, new String(singleAttachment.getName().getBytes("UTF-8"), "ISO-8859-1"));
							}
						}
						
						MailServiceUtil.sendEmail(mailMessage);
						//_log.info("mail send to: " + receiverMailAddress);
				}
				//_log.error("receiver undefined");
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
