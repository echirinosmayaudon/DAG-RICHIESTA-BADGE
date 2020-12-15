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

package com.intranet.mef.calendar.sender.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.calendar.sender.service.http.LogMailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.calendar.sender.service.http.LogMailServiceSoap
 * @generated
 */
@ProviderType
public class LogMailSoap implements Serializable {
	public static LogMailSoap toSoapModel(LogMail model) {
		LogMailSoap soapModel = new LogMailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLogMailId(model.getLogMailId());
		soapModel.setMailTo(model.getMailTo());
		soapModel.setEventTitle(model.getEventTitle());
		soapModel.setEventDescription(model.getEventDescription());
		soapModel.setDateStart(model.getDateStart());
		soapModel.setDateFinish(model.getDateFinish());

		return soapModel;
	}

	public static LogMailSoap[] toSoapModels(LogMail[] models) {
		LogMailSoap[] soapModels = new LogMailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogMailSoap[][] toSoapModels(LogMail[][] models) {
		LogMailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogMailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogMailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogMailSoap[] toSoapModels(List<LogMail> models) {
		List<LogMailSoap> soapModels = new ArrayList<LogMailSoap>(models.size());

		for (LogMail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogMailSoap[soapModels.size()]);
	}

	public LogMailSoap() {
	}

	public long getPrimaryKey() {
		return _logMailId;
	}

	public void setPrimaryKey(long pk) {
		setLogMailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLogMailId() {
		return _logMailId;
	}

	public void setLogMailId(long logMailId) {
		_logMailId = logMailId;
	}

	public String getMailTo() {
		return _mailTo;
	}

	public void setMailTo(String mailTo) {
		_mailTo = mailTo;
	}

	public String getEventTitle() {
		return _eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		_eventTitle = eventTitle;
	}

	public String getEventDescription() {
		return _eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		_eventDescription = eventDescription;
	}

	public Date getDateStart() {
		return _dateStart;
	}

	public void setDateStart(Date dateStart) {
		_dateStart = dateStart;
	}

	public Date getDateFinish() {
		return _dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		_dateFinish = dateFinish;
	}

	private String _uuid;
	private long _logMailId;
	private String _mailTo;
	private String _eventTitle;
	private String _eventDescription;
	private Date _dateStart;
	private Date _dateFinish;
}