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

package com.intranet.mef.calendar.sender.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.calendar.sender.model.LogMail;
import com.intranet.mef.calendar.sender.model.LogMailModel;
import com.intranet.mef.calendar.sender.model.LogMailSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LogMail service. Represents a row in the &quot;SENDCALENDAR_LogMail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LogMailModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LogMailImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogMailImpl
 * @see LogMail
 * @see LogMailModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class LogMailModelImpl extends BaseModelImpl<LogMail>
	implements LogMailModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a log mail model instance should use the {@link LogMail} interface instead.
	 */
	public static final String TABLE_NAME = "SENDCALENDAR_LogMail";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "logMailId", Types.BIGINT },
			{ "mailTo", Types.VARCHAR },
			{ "eventTitle", Types.VARCHAR },
			{ "eventDescription", Types.VARCHAR },
			{ "dateStart", Types.TIMESTAMP },
			{ "dateFinish", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("logMailId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mailTo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dateStart", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dateFinish", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table SENDCALENDAR_LogMail (uuid_ VARCHAR(75) null,logMailId LONG not null primary key,mailTo VARCHAR(75) null,eventTitle VARCHAR(75) null,eventDescription VARCHAR(75) null,dateStart DATE null,dateFinish DATE null)";
	public static final String TABLE_SQL_DROP = "drop table SENDCALENDAR_LogMail";
	public static final String ORDER_BY_JPQL = " ORDER BY logMail.logMailId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SENDCALENDAR_LogMail.logMailId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.calendar.sender.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.intranet.mef.calendar.sender.model.LogMail"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.calendar.sender.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.intranet.mef.calendar.sender.model.LogMail"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.intranet.mef.calendar.sender.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.intranet.mef.calendar.sender.model.LogMail"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long LOGMAILID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LogMail toModel(LogMailSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LogMail model = new LogMailImpl();

		model.setUuid(soapModel.getUuid());
		model.setLogMailId(soapModel.getLogMailId());
		model.setMailTo(soapModel.getMailTo());
		model.setEventTitle(soapModel.getEventTitle());
		model.setEventDescription(soapModel.getEventDescription());
		model.setDateStart(soapModel.getDateStart());
		model.setDateFinish(soapModel.getDateFinish());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LogMail> toModels(LogMailSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LogMail> models = new ArrayList<LogMail>(soapModels.length);

		for (LogMailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.intranet.mef.calendar.sender.service.util.PropsUtil.get(
				"lock.expiration.time.com.intranet.mef.calendar.sender.model.LogMail"));

	public LogMailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _logMailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLogMailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logMailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getLogMailId() {
		return _logMailId;
	}

	@Override
	public void setLogMailId(long logMailId) {
		_logMailId = logMailId;
	}

	@JSON
	@Override
	public String getMailTo() {
		if (_mailTo == null) {
			return StringPool.BLANK;
		}
		else {
			return _mailTo;
		}
	}

	@Override
	public void setMailTo(String mailTo) {
		_mailTo = mailTo;
	}

	@JSON
	@Override
	public String getEventTitle() {
		if (_eventTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventTitle;
		}
	}

	@Override
	public void setEventTitle(String eventTitle) {
		_eventTitle = eventTitle;
	}

	@JSON
	@Override
	public String getEventDescription() {
		if (_eventDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventDescription;
		}
	}

	@Override
	public void setEventDescription(String eventDescription) {
		_eventDescription = eventDescription;
	}

	@JSON
	@Override
	public Date getDateStart() {
		return _dateStart;
	}

	@Override
	public void setDateStart(Date dateStart) {
		_dateStart = dateStart;
	}

	@JSON
	@Override
	public Date getDateFinish() {
		return _dateFinish;
	}

	@Override
	public void setDateFinish(Date dateFinish) {
		_dateFinish = dateFinish;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			LogMail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LogMail toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LogMail)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LogMailImpl logMailImpl = new LogMailImpl();

		logMailImpl.setUuid(getUuid());
		logMailImpl.setLogMailId(getLogMailId());
		logMailImpl.setMailTo(getMailTo());
		logMailImpl.setEventTitle(getEventTitle());
		logMailImpl.setEventDescription(getEventDescription());
		logMailImpl.setDateStart(getDateStart());
		logMailImpl.setDateFinish(getDateFinish());

		logMailImpl.resetOriginalValues();

		return logMailImpl;
	}

	@Override
	public int compareTo(LogMail logMail) {
		long primaryKey = logMail.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogMail)) {
			return false;
		}

		LogMail logMail = (LogMail)obj;

		long primaryKey = logMail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		LogMailModelImpl logMailModelImpl = this;

		logMailModelImpl._originalUuid = logMailModelImpl._uuid;

		logMailModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LogMail> toCacheModel() {
		LogMailCacheModel logMailCacheModel = new LogMailCacheModel();

		logMailCacheModel.uuid = getUuid();

		String uuid = logMailCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			logMailCacheModel.uuid = null;
		}

		logMailCacheModel.logMailId = getLogMailId();

		logMailCacheModel.mailTo = getMailTo();

		String mailTo = logMailCacheModel.mailTo;

		if ((mailTo != null) && (mailTo.length() == 0)) {
			logMailCacheModel.mailTo = null;
		}

		logMailCacheModel.eventTitle = getEventTitle();

		String eventTitle = logMailCacheModel.eventTitle;

		if ((eventTitle != null) && (eventTitle.length() == 0)) {
			logMailCacheModel.eventTitle = null;
		}

		logMailCacheModel.eventDescription = getEventDescription();

		String eventDescription = logMailCacheModel.eventDescription;

		if ((eventDescription != null) && (eventDescription.length() == 0)) {
			logMailCacheModel.eventDescription = null;
		}

		Date dateStart = getDateStart();

		if (dateStart != null) {
			logMailCacheModel.dateStart = dateStart.getTime();
		}
		else {
			logMailCacheModel.dateStart = Long.MIN_VALUE;
		}

		Date dateFinish = getDateFinish();

		if (dateFinish != null) {
			logMailCacheModel.dateFinish = dateFinish.getTime();
		}
		else {
			logMailCacheModel.dateFinish = Long.MIN_VALUE;
		}

		return logMailCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", logMailId=");
		sb.append(getLogMailId());
		sb.append(", mailTo=");
		sb.append(getMailTo());
		sb.append(", eventTitle=");
		sb.append(getEventTitle());
		sb.append(", eventDescription=");
		sb.append(getEventDescription());
		sb.append(", dateStart=");
		sb.append(getDateStart());
		sb.append(", dateFinish=");
		sb.append(getDateFinish());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.intranet.mef.calendar.sender.model.LogMail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logMailId</column-name><column-value><![CDATA[");
		sb.append(getLogMailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mailTo</column-name><column-value><![CDATA[");
		sb.append(getMailTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTitle</column-name><column-value><![CDATA[");
		sb.append(getEventTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDescription</column-name><column-value><![CDATA[");
		sb.append(getEventDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateStart</column-name><column-value><![CDATA[");
		sb.append(getDateStart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateFinish</column-name><column-value><![CDATA[");
		sb.append(getDateFinish());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = LogMail.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LogMail.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _logMailId;
	private String _mailTo;
	private String _eventTitle;
	private String _eventDescription;
	private Date _dateStart;
	private Date _dateFinish;
	private long _columnBitmask;
	private LogMail _escapedModel;
}