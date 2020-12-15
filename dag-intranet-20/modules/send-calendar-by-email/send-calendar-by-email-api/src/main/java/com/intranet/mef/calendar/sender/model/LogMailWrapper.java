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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link LogMail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogMail
 * @generated
 */
@ProviderType
public class LogMailWrapper implements LogMail, ModelWrapper<LogMail> {
	public LogMailWrapper(LogMail logMail) {
		_logMail = logMail;
	}

	@Override
	public Class<?> getModelClass() {
		return LogMail.class;
	}

	@Override
	public String getModelClassName() {
		return LogMail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("logMailId", getLogMailId());
		attributes.put("mailTo", getMailTo());
		attributes.put("eventTitle", getEventTitle());
		attributes.put("eventDescription", getEventDescription());
		attributes.put("dateStart", getDateStart());
		attributes.put("dateFinish", getDateFinish());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long logMailId = (Long)attributes.get("logMailId");

		if (logMailId != null) {
			setLogMailId(logMailId);
		}

		String mailTo = (String)attributes.get("mailTo");

		if (mailTo != null) {
			setMailTo(mailTo);
		}

		String eventTitle = (String)attributes.get("eventTitle");

		if (eventTitle != null) {
			setEventTitle(eventTitle);
		}

		String eventDescription = (String)attributes.get("eventDescription");

		if (eventDescription != null) {
			setEventDescription(eventDescription);
		}

		Date dateStart = (Date)attributes.get("dateStart");

		if (dateStart != null) {
			setDateStart(dateStart);
		}

		Date dateFinish = (Date)attributes.get("dateFinish");

		if (dateFinish != null) {
			setDateFinish(dateFinish);
		}
	}

	@Override
	public LogMail toEscapedModel() {
		return new LogMailWrapper(_logMail.toEscapedModel());
	}

	@Override
	public LogMail toUnescapedModel() {
		return new LogMailWrapper(_logMail.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _logMail.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _logMail.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _logMail.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _logMail.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LogMail> toCacheModel() {
		return _logMail.toCacheModel();
	}

	@Override
	public int compareTo(LogMail logMail) {
		return _logMail.compareTo(logMail);
	}

	@Override
	public int hashCode() {
		return _logMail.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logMail.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LogMailWrapper((LogMail)_logMail.clone());
	}

	/**
	* Returns the event description of this log mail.
	*
	* @return the event description of this log mail
	*/
	@Override
	public java.lang.String getEventDescription() {
		return _logMail.getEventDescription();
	}

	/**
	* Returns the event title of this log mail.
	*
	* @return the event title of this log mail
	*/
	@Override
	public java.lang.String getEventTitle() {
		return _logMail.getEventTitle();
	}

	/**
	* Returns the mail to of this log mail.
	*
	* @return the mail to of this log mail
	*/
	@Override
	public java.lang.String getMailTo() {
		return _logMail.getMailTo();
	}

	/**
	* Returns the uuid of this log mail.
	*
	* @return the uuid of this log mail
	*/
	@Override
	public java.lang.String getUuid() {
		return _logMail.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _logMail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logMail.toXmlString();
	}

	/**
	* Returns the date finish of this log mail.
	*
	* @return the date finish of this log mail
	*/
	@Override
	public Date getDateFinish() {
		return _logMail.getDateFinish();
	}

	/**
	* Returns the date start of this log mail.
	*
	* @return the date start of this log mail
	*/
	@Override
	public Date getDateStart() {
		return _logMail.getDateStart();
	}

	/**
	* Returns the log mail ID of this log mail.
	*
	* @return the log mail ID of this log mail
	*/
	@Override
	public long getLogMailId() {
		return _logMail.getLogMailId();
	}

	/**
	* Returns the primary key of this log mail.
	*
	* @return the primary key of this log mail
	*/
	@Override
	public long getPrimaryKey() {
		return _logMail.getPrimaryKey();
	}

	@Override
	public void persist() {
		_logMail.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logMail.setCachedModel(cachedModel);
	}

	/**
	* Sets the date finish of this log mail.
	*
	* @param dateFinish the date finish of this log mail
	*/
	@Override
	public void setDateFinish(Date dateFinish) {
		_logMail.setDateFinish(dateFinish);
	}

	/**
	* Sets the date start of this log mail.
	*
	* @param dateStart the date start of this log mail
	*/
	@Override
	public void setDateStart(Date dateStart) {
		_logMail.setDateStart(dateStart);
	}

	/**
	* Sets the event description of this log mail.
	*
	* @param eventDescription the event description of this log mail
	*/
	@Override
	public void setEventDescription(java.lang.String eventDescription) {
		_logMail.setEventDescription(eventDescription);
	}

	/**
	* Sets the event title of this log mail.
	*
	* @param eventTitle the event title of this log mail
	*/
	@Override
	public void setEventTitle(java.lang.String eventTitle) {
		_logMail.setEventTitle(eventTitle);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_logMail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_logMail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_logMail.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the log mail ID of this log mail.
	*
	* @param logMailId the log mail ID of this log mail
	*/
	@Override
	public void setLogMailId(long logMailId) {
		_logMail.setLogMailId(logMailId);
	}

	/**
	* Sets the mail to of this log mail.
	*
	* @param mailTo the mail to of this log mail
	*/
	@Override
	public void setMailTo(java.lang.String mailTo) {
		_logMail.setMailTo(mailTo);
	}

	@Override
	public void setNew(boolean n) {
		_logMail.setNew(n);
	}

	/**
	* Sets the primary key of this log mail.
	*
	* @param primaryKey the primary key of this log mail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logMail.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_logMail.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this log mail.
	*
	* @param uuid the uuid of this log mail
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_logMail.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogMailWrapper)) {
			return false;
		}

		LogMailWrapper logMailWrapper = (LogMailWrapper)obj;

		if (Objects.equals(_logMail, logMailWrapper._logMail)) {
			return true;
		}

		return false;
	}

	@Override
	public LogMail getWrappedModel() {
		return _logMail;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _logMail.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _logMail.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_logMail.resetOriginalValues();
	}

	private final LogMail _logMail;
}