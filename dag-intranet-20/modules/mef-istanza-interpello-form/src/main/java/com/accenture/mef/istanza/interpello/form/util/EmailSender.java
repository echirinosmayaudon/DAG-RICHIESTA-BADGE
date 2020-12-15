package com.accenture.mef.istanza.interpello.form.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

public class EmailSender {

	final Log _log = LogFactoryUtil.getLog(EmailSender.class);

	public boolean sendMailMessage(MailMessage mailMessage) {
		try {
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			_log.error(e);
			return false;
		}
		return true;
	}

	public boolean sendMailMessage(String mailSubject, String mailBody, String senderName, String senderMailAddress,
			List<String> receiverMailAddressList, List<String> ccMailAddressList, List<File> fileAllegatiList) {
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody);
			mailMessage.setSubject(mailSubject);
			mailMessage.setFrom(new InternetAddress(senderMailAddress, senderName));
			mailMessage.setInReplyTo("noreply@mef.it");

			if (receiverMailAddressList != null && !receiverMailAddressList.isEmpty()) {
				InternetAddress[] receiverMailAddressArray = new InternetAddress[receiverMailAddressList.size()];
				for (int i = 0; i < receiverMailAddressList.size(); i++) {
					receiverMailAddressArray[i] = new InternetAddress(receiverMailAddressList.get(i));
				}
				mailMessage.setTo(receiverMailAddressArray);
			}

			if (ccMailAddressList != null && !ccMailAddressList.isEmpty()) {
				InternetAddress[] ccMailAddressArray = new InternetAddress[ccMailAddressList.size()];
				for (int i = 0; i < ccMailAddressList.size(); i++) {
					ccMailAddressArray[i] = new InternetAddress(ccMailAddressList.get(i));
				}
				mailMessage.setCC(ccMailAddressArray);
			}

			mailMessage.setHTMLFormat(true);

			if (fileAllegatiList != null && !fileAllegatiList.isEmpty()) {
				for (File file : fileAllegatiList) {
					if (file != null && file.exists()) {
						mailMessage.addFileAttachment(file, file.getName());
					}
				}
			}
			return sendMailMessage(mailMessage);
		} catch (MessagingException me) {
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