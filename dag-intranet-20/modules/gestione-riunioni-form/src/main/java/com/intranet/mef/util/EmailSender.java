package com.intranet.mef.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

public class EmailSender {
	final Log _log = LogFactoryUtil.getLog(EmailSender.class);

	public void sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress,
			String receiverMailAddress) throws IOException, PortletException, AddressException {

		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody);
			mailMessage.setSubject(mailSubject);
			mailMessage.setFrom(new InternetAddress(senderMailAddress, senderName));
			mailMessage.setInReplyTo("noreply@mef.it");
			mailMessage.setTo(new InternetAddress(receiverMailAddress));
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			//e.printStackTrace();
			_log.warn(e);
		}

	}

}
