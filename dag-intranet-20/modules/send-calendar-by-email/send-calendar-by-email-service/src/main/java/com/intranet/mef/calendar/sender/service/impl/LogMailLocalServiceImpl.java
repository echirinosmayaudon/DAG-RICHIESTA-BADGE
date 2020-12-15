/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.intranet.mef.calendar.sender.service.impl;

import com.intranet.mef.calendar.sender.service.base.LogMailLocalServiceBaseImpl;
import com.intranet.mef.calendar.sender.service.configuration.LogMailConfigurationValues;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.petra.mail.MailEngine;
import com.liferay.petra.mail.MailEngineException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.text.ParseException;

import javax.mail.event.MailEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import aQute.bnd.annotation.ProviderType;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;
/**
 * The implementation of the log mail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.calendar.sender.service.LogMailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogMailLocalServiceBaseImpl
 * @see com.intranet.mef.calendar.sender.service.LogMailLocalServiceUtil
 */
@ProviderType
public class LogMailLocalServiceImpl extends LogMailLocalServiceBaseImpl {
	private static Log _log = LogFactoryUtil.getLog(LogMailLocalServiceImpl.class);	
	private static final String TEMP_PATH = "/wos1/java/products/liferay/tmp/";
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.calendar.sender.service.LogMailLocalServiceUtil} to access the log mail local service.
	 */

	@Override
	public void sendMailWithAttachment(String mailTo, Long timeStart, Long timeFinish,String eventTitle, String eventDescription, String icsDescription) throws IOException {

		InternetAddress fromAddress;
		InternetAddress toAddress;
		File file = new File(TEMP_PATH+"evento.ics");
		String fileName;
		if (file.createNewFile()){
			fileName = "evento.ics";
		}else{
			fileName = file.getName();
		}



		//ICS MANAGEMENT
		CalendarOutputter outputter = new CalendarOutputter();
		Calendar calendar = new Calendar();

		calendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);

		String timeZoneCF = "Europe/Rome";

		// Create a TimeZone
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone(timeZoneCF);
		VTimeZone tz = timezone.getVTimeZone();


		//DateTime start = new DateTime(timeStart-(1000*60*60*2));
		//start.setHours(start.getHours()-2);
		DateTime start = new DateTime(timeStart);
		DateTime end = new DateTime(timeFinish);
		//DateTime end = new DateTime(timeFinish-(1000*60*60*2));
		//end.setHours(start.getHours()-2);
		VEvent meeting = new VEvent(start, end, eventTitle);
		meeting.getProperties().add(tz.getTimeZoneId());

		meeting.getProperties().add(new Description());
		try {
			meeting.getProperties().getProperty(Property.DESCRIPTION).setValue(icsDescription);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			_log.error(e1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			_log.error(e1);
		}

		UidGenerator ug = new UidGenerator("uidGen");
		Uid uid = ug.generateUid();
		meeting.getProperties().add(uid);

		calendar.getComponents().add(meeting);
		//OutputStream out = resourceResponse.getPortletOutputStream();
		OutputStream o = null;
		try {
			o = new FileOutputStream(file);
			outputter.output(calendar, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		finally{
			if (o != null){
				o.close();
			}
		}


		//FINISH ICS MANAGEMENT    

		//Sending Mail with ics attachment
		try {
			fromAddress = new InternetAddress(LogMailConfigurationValues.LOG_MAIL_RESULT_EMAIL_FROM_ADDRESS,LogMailConfigurationValues.LOG_MAIL_RESULT_EMAIL_FROM_NAME);
			//System.out.println("---------MAILSERVICE--------");
			//System.out.println("fromAddress: "+fromAddress);
			toAddress = new InternetAddress(mailTo);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject("Evento - "+eventTitle);
			mailMessage.setBody(eventDescription);
			mailMessage.addFileAttachment(file, fileName);
			mailMessage.setHTMLFormat(true);
			try {
				MailEngine.send(mailMessage);
			} catch (MailEngineException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
			_log.info("Mail with Attachment was successfully sent");
		} catch (AddressException e) {
			_log.error(e);
		}
	}
	

	public File generateIcsFile(Long timeStart, Long timeFinish, String eventTitle, String eventDescription, String icsDescription) throws IOException {

		File file = new File(TEMP_PATH+"evento.ics");
		String fileName;
		if (file.createNewFile()){
			fileName = "evento.ics";
		}else{
			fileName = file.getName();
		}
		
		//ICS MANAGEMENT
		CalendarOutputter outputter = new CalendarOutputter();
		Calendar calendar = new Calendar();

		calendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);

		String timeZoneCF = "Europe/Rome";

		// Create a TimeZone
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone(timeZoneCF);
		VTimeZone tz = timezone.getVTimeZone();


		//DateTime start = new DateTime(timeStart-(1000*60*60*2));
		//start.setHours(start.getHours()-2);
		DateTime start = new DateTime(timeStart);
		DateTime end = new DateTime(timeFinish);
		//DateTime end = new DateTime(timeFinish-(1000*60*60*2));
		//end.setHours(start.getHours()-2);
		VEvent meeting = new VEvent(start, end, eventTitle);
		meeting.getProperties().add(tz.getTimeZoneId());

		meeting.getProperties().add(new Description());
		try {
			meeting.getProperties().getProperty(Property.DESCRIPTION).setValue(icsDescription);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			_log.error(e1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			_log.error(e1);
		}

		UidGenerator ug = new UidGenerator("uidGen");
		Uid uid = ug.generateUid();
		meeting.getProperties().add(uid);

		calendar.getComponents().add(meeting);
		//OutputStream out = resourceResponse.getPortletOutputStream();
		OutputStream o = null;
		try {
			o = new FileOutputStream(file);
			outputter.output(calendar, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		finally{
			if (o != null){
				o.close();
			}
		}
		
		//FINISH ICS MANAGEMENT    
		return file;
	}
	
	
	
	
}