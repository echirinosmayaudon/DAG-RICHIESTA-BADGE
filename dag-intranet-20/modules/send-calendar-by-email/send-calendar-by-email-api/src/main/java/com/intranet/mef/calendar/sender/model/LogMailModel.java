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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LogMail service. Represents a row in the &quot;SENDCALENDAR_LogMail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.calendar.sender.model.impl.LogMailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.calendar.sender.model.impl.LogMailImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogMail
 * @see com.intranet.mef.calendar.sender.model.impl.LogMailImpl
 * @see com.intranet.mef.calendar.sender.model.impl.LogMailModelImpl
 * @generated
 */
@ProviderType
public interface LogMailModel extends BaseModel<LogMail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a log mail model instance should use the {@link LogMail} interface instead.
	 */

	/**
	 * Returns the primary key of this log mail.
	 *
	 * @return the primary key of this log mail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this log mail.
	 *
	 * @param primaryKey the primary key of this log mail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this log mail.
	 *
	 * @return the uuid of this log mail
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this log mail.
	 *
	 * @param uuid the uuid of this log mail
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the log mail ID of this log mail.
	 *
	 * @return the log mail ID of this log mail
	 */
	public long getLogMailId();

	/**
	 * Sets the log mail ID of this log mail.
	 *
	 * @param logMailId the log mail ID of this log mail
	 */
	public void setLogMailId(long logMailId);

	/**
	 * Returns the mail to of this log mail.
	 *
	 * @return the mail to of this log mail
	 */
	@AutoEscape
	public String getMailTo();

	/**
	 * Sets the mail to of this log mail.
	 *
	 * @param mailTo the mail to of this log mail
	 */
	public void setMailTo(String mailTo);

	/**
	 * Returns the event title of this log mail.
	 *
	 * @return the event title of this log mail
	 */
	@AutoEscape
	public String getEventTitle();

	/**
	 * Sets the event title of this log mail.
	 *
	 * @param eventTitle the event title of this log mail
	 */
	public void setEventTitle(String eventTitle);

	/**
	 * Returns the event description of this log mail.
	 *
	 * @return the event description of this log mail
	 */
	@AutoEscape
	public String getEventDescription();

	/**
	 * Sets the event description of this log mail.
	 *
	 * @param eventDescription the event description of this log mail
	 */
	public void setEventDescription(String eventDescription);

	/**
	 * Returns the date start of this log mail.
	 *
	 * @return the date start of this log mail
	 */
	public Date getDateStart();

	/**
	 * Sets the date start of this log mail.
	 *
	 * @param dateStart the date start of this log mail
	 */
	public void setDateStart(Date dateStart);

	/**
	 * Returns the date finish of this log mail.
	 *
	 * @return the date finish of this log mail
	 */
	public Date getDateFinish();

	/**
	 * Sets the date finish of this log mail.
	 *
	 * @param dateFinish the date finish of this log mail
	 */
	public void setDateFinish(Date dateFinish);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(LogMail logMail);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LogMail> toCacheModel();

	@Override
	public LogMail toEscapedModel();

	@Override
	public LogMail toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}