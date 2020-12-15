package com.intranet.mef.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;

import javax.mail.internet.InternetAddress;
import javax.mail.MessagingException;

public class EmailSender {
	
	
	
	 final Log _log = LogFactoryUtil.getLog(EmailSender.class);
	  
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
	  
	
	
	  public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, File file, String nameFile,File fileAllegato) {
		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						mailMessage.setInReplyTo("noreply@mef.it");
						mailMessage.setTo(new InternetAddress(receiverMailAddress));
						mailMessage.setHTMLFormat(true);
						if(file!=null && file.exists())
							mailMessage.addFileAttachment(file, nameFile);
						if(fileAllegato!=null && file!=null && file.exists())
							mailMessage.addFileAttachment(fileAllegato, fileAllegato.getName());
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
}
