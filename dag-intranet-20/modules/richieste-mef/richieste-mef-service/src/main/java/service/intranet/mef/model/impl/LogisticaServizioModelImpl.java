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

package service.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

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

import service.intranet.mef.model.LogisticaServizio;
import service.intranet.mef.model.LogisticaServizioModel;
import service.intranet.mef.model.LogisticaServizioSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LogisticaServizio service. Represents a row in the &quot;MFORM_LogisticaServizio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LogisticaServizioModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LogisticaServizioImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaServizioImpl
 * @see LogisticaServizio
 * @see LogisticaServizioModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class LogisticaServizioModelImpl extends BaseModelImpl<LogisticaServizio>
	implements LogisticaServizioModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a logistica servizio model instance should use the {@link LogisticaServizio} interface instead.
	 */
	public static final String TABLE_NAME = "MFORM_LogisticaServizio";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "descrizione", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("descrizione", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MFORM_LogisticaServizio (id_ LONG not null primary key,descrizione VARCHAR(500) null)";
	public static final String TABLE_SQL_DROP = "drop table MFORM_LogisticaServizio";
	public static final String ORDER_BY_JPQL = " ORDER BY logisticaServizio.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MFORM_LogisticaServizio.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(service.intranet.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.service.intranet.mef.model.LogisticaServizio"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(service.intranet.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.service.intranet.mef.model.LogisticaServizio"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LogisticaServizio toModel(LogisticaServizioSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LogisticaServizio model = new LogisticaServizioImpl();

		model.setId(soapModel.getId());
		model.setDescrizione(soapModel.getDescrizione());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LogisticaServizio> toModels(
		LogisticaServizioSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LogisticaServizio> models = new ArrayList<LogisticaServizio>(soapModels.length);

		for (LogisticaServizioSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(service.intranet.mef.service.util.PropsUtil.get(
				"lock.expiration.time.service.intranet.mef.model.LogisticaServizio"));

	public LogisticaServizioModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LogisticaServizio.class;
	}

	@Override
	public String getModelClassName() {
		return LogisticaServizio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descrizione", getDescrizione());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public String getDescrizione() {
		if (_descrizione == null) {
			return StringPool.BLANK;
		}
		else {
			return _descrizione;
		}
	}

	@Override
	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			LogisticaServizio.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LogisticaServizio toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LogisticaServizio)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LogisticaServizioImpl logisticaServizioImpl = new LogisticaServizioImpl();

		logisticaServizioImpl.setId(getId());
		logisticaServizioImpl.setDescrizione(getDescrizione());

		logisticaServizioImpl.resetOriginalValues();

		return logisticaServizioImpl;
	}

	@Override
	public int compareTo(LogisticaServizio logisticaServizio) {
		long primaryKey = logisticaServizio.getPrimaryKey();

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

		if (!(obj instanceof LogisticaServizio)) {
			return false;
		}

		LogisticaServizio logisticaServizio = (LogisticaServizio)obj;

		long primaryKey = logisticaServizio.getPrimaryKey();

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
	}

	@Override
	public CacheModel<LogisticaServizio> toCacheModel() {
		LogisticaServizioCacheModel logisticaServizioCacheModel = new LogisticaServizioCacheModel();

		logisticaServizioCacheModel.id = getId();

		logisticaServizioCacheModel.descrizione = getDescrizione();

		String descrizione = logisticaServizioCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			logisticaServizioCacheModel.descrizione = null;
		}

		return logisticaServizioCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("service.intranet.mef.model.LogisticaServizio");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = LogisticaServizio.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LogisticaServizio.class
		};
	private long _id;
	private String _descrizione;
	private LogisticaServizio _escapedModel;
}