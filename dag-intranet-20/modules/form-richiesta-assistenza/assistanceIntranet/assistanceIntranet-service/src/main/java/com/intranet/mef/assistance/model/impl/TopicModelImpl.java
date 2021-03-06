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

package com.intranet.mef.assistance.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Topic;
import com.intranet.mef.assistance.model.TopicModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Topic service. Represents a row in the &quot;Assistance_Topic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TopicModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TopicImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicImpl
 * @see Topic
 * @see TopicModel
 * @generated
 */
@ProviderType
public class TopicModelImpl extends BaseModelImpl<Topic> implements TopicModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a topic model instance should use the {@link Topic} interface instead.
	 */
	public static final String TABLE_NAME = "Assistance_Topic";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "topicId", Types.VARCHAR },
			{ "topicName", Types.VARCHAR },
			{ "areaId", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("topicId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("topicName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("areaId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Assistance_Topic (uuid_ VARCHAR(75) null,topicId VARCHAR(75) not null primary key,topicName VARCHAR(200) null,areaId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Assistance_Topic";
	public static final String ORDER_BY_JPQL = " ORDER BY topic.topicId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Assistance_Topic.topicId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.intranet.mef.assistance.model.Topic"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.intranet.mef.assistance.model.Topic"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.intranet.mef.assistance.model.Topic"),
			true);
	public static final long AREAID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long TOPICID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"lock.expiration.time.com.intranet.mef.assistance.model.Topic"));

	public TopicModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _topicId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setTopicId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _topicId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Topic.class;
	}

	@Override
	public String getModelClassName() {
		return Topic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("topicId", getTopicId());
		attributes.put("topicName", getTopicName());
		attributes.put("areaId", getAreaId());

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

		String topicId = (String)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
		}

		String topicName = (String)attributes.get("topicName");

		if (topicName != null) {
			setTopicName(topicName);
		}

		String areaId = (String)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}
	}

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

	@Override
	public String getTopicId() {
		if (_topicId == null) {
			return StringPool.BLANK;
		}
		else {
			return _topicId;
		}
	}

	@Override
	public void setTopicId(String topicId) {
		_columnBitmask = -1L;

		_topicId = topicId;
	}

	@Override
	public String getTopicName() {
		if (_topicName == null) {
			return StringPool.BLANK;
		}
		else {
			return _topicName;
		}
	}

	@Override
	public void setTopicName(String topicName) {
		_topicName = topicName;
	}

	@Override
	public String getAreaId() {
		if (_areaId == null) {
			return StringPool.BLANK;
		}
		else {
			return _areaId;
		}
	}

	@Override
	public void setAreaId(String areaId) {
		_columnBitmask |= AREAID_COLUMN_BITMASK;

		if (_originalAreaId == null) {
			_originalAreaId = _areaId;
		}

		_areaId = areaId;
	}

	public String getOriginalAreaId() {
		return GetterUtil.getString(_originalAreaId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Topic toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Topic)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TopicImpl topicImpl = new TopicImpl();

		topicImpl.setUuid(getUuid());
		topicImpl.setTopicId(getTopicId());
		topicImpl.setTopicName(getTopicName());
		topicImpl.setAreaId(getAreaId());

		topicImpl.resetOriginalValues();

		return topicImpl;
	}

	@Override
	public int compareTo(Topic topic) {
		int value = 0;

		value = getTopicId().compareTo(topic.getTopicId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Topic)) {
			return false;
		}

		Topic topic = (Topic)obj;

		String primaryKey = topic.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		TopicModelImpl topicModelImpl = this;

		topicModelImpl._originalUuid = topicModelImpl._uuid;

		topicModelImpl._originalAreaId = topicModelImpl._areaId;

		topicModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Topic> toCacheModel() {
		TopicCacheModel topicCacheModel = new TopicCacheModel();

		topicCacheModel.uuid = getUuid();

		String uuid = topicCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			topicCacheModel.uuid = null;
		}

		topicCacheModel.topicId = getTopicId();

		String topicId = topicCacheModel.topicId;

		if ((topicId != null) && (topicId.length() == 0)) {
			topicCacheModel.topicId = null;
		}

		topicCacheModel.topicName = getTopicName();

		String topicName = topicCacheModel.topicName;

		if ((topicName != null) && (topicName.length() == 0)) {
			topicCacheModel.topicName = null;
		}

		topicCacheModel.areaId = getAreaId();

		String areaId = topicCacheModel.areaId;

		if ((areaId != null) && (areaId.length() == 0)) {
			topicCacheModel.areaId = null;
		}

		return topicCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", topicId=");
		sb.append(getTopicId());
		sb.append(", topicName=");
		sb.append(getTopicName());
		sb.append(", areaId=");
		sb.append(getAreaId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.intranet.mef.assistance.model.Topic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topicId</column-name><column-value><![CDATA[");
		sb.append(getTopicId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topicName</column-name><column-value><![CDATA[");
		sb.append(getTopicName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaId</column-name><column-value><![CDATA[");
		sb.append(getAreaId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Topic.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Topic.class
		};
	private String _uuid;
	private String _originalUuid;
	private String _topicId;
	private String _topicName;
	private String _areaId;
	private String _originalAreaId;
	private long _columnBitmask;
	private Topic _escapedModel;
}