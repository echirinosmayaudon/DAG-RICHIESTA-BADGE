package mef.richieste.figli.form.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import mef.richieste.figli.form.bean.Email;


public class EmailSender {
	
	final Log _log = LogFactoryUtil.getLog(EmailSender.class);
	
	
	public boolean sendEmailMessage(MailMessage mailMessage) {
		
		try {
			
			MailServiceUtil.sendEmail(mailMessage);
		
		} catch (Exception e) {
			
			_log.error("Errore invio email");
			
			return false;
		}
			return true;
	}
	
	public boolean sendEmailMessage(Email emailMessage) throws UnsupportedEncodingException, AddressException{
		
		MailMessage mailToSend = new MailMessage();
		
		mailToSend.setBody(emailMessage.getMailBody());
		
		mailToSend.setSubject(emailMessage.getMailSubject()); 
		
		mailToSend.setFrom(new InternetAddress(emailMessage.getSenderMailAddress(),emailMessage.getSenderName()));
		
		mailToSend.setInReplyTo("gabriele.vanacore@live.it");
		
		mailToSend.setTo(new InternetAddress(emailMessage.getReceiverMailAddress()));
		
		mailToSend.setHTMLFormat(true);
		
		
		if(emailMessage.getFile()!=null && emailMessage.getFile().exists()) {
			
			mailToSend.addFileAttachment(emailMessage.getFile(), emailMessage.getNameFile());
			
			
		}
		
		if(emailMessage.getFileAllegato()!=null && emailMessage.getFile()!=null && emailMessage.getFile().exists()) {
			
			mailToSend.addFileAttachment(emailMessage.getFileAllegato(), emailMessage.getFileAllegato().getName());
			
		}
		
		return sendEmailMessage(mailToSend);
	}
	
	
	 public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress, String receiverMailAddress, File file, String nameFile,File fileAllegato) {
		  try {			  
		              	MailMessage mailMessage=new MailMessage();
						mailMessage.setBody(mailBody);
						mailMessage.setSubject(mailSubject); 
						mailMessage.setFrom(new InternetAddress(senderMailAddress,senderName));
						_log.info("Email sender che cazzo stampo?: "+ senderMailAddress);
						_log.info("Email sender che cazzo stampo?: "+ senderName);
						mailMessage.setInReplyTo("gabriele.vanacore@outlook.it");
						mailMessage.setTo(new InternetAddress(receiverMailAddress));
						_log.info("Email sender che cazzo stampo?: "+ receiverMailAddress);

						mailMessage.setHTMLFormat(true);
						if(file!=null && file.exists())
							mailMessage.addFileAttachment(file, nameFile);
						if(fileAllegato!=null && file!=null && file.exists())
							mailMessage.addFileAttachment(fileAllegato, fileAllegato.getName());
						return sendEmailMessage(mailMessage);

					
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
