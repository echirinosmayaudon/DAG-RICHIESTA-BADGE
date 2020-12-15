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

import com.intranet.mef.assistance.model.Ambito;
import com.intranet.mef.assistance.model.AmbitoModel;

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
 * The base model implementation for the Ambito service. Represents a row in the &quot;Assistance_Ambito&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AmbitoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AmbitoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmbitoImpl
 * @see Ambito
 * @see AmbitoModel
 * @generated
 */
@ProviderType
public class AmbitoModelImpl extends BaseModelImpl<Ambito>
	implements AmbitoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ambito model instance should use the {@link Ambito} interface instead.
	 */
	public static final String TABLE_NAME = "Assistance_Ambito";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "assScopeId", Types.VARCHAR },
			{ "scopeName", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("assScopeId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("scopeName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Assistance_Ambito (uuid_ VARCHAR(75) null,assScopeId VARCHAR(75) not null primary key,scopeName VARCHAR(200) null)";
	public static final String TABLE_SQL_DROP = "drop table Assistance_Ambito";
	public static final String ORDER_BY_JPQL = " ORDER BY ambito.assScopeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Assistance_Ambito.assScopeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.intranet.mef.assistance.model.Ambito"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.intranet.mef.assistance.model.Ambito"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.intranet.mef.assistance.model.Ambito"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long ASSSCOPEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"lock.expiration.time.com.intranet.mef.assistance.model.Ambito"));

	public AmbitoModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _assScopeId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setAssScopeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assScopeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Ambito.class;
	}

	@Override
	public String getModelClassName() {
		return Ambito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("assScopeId", getAssScopeId());
		attributes.put("scopeName", getScopeName());

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

		String assScopeId = (String)attributes.get("assScopeId");

		if (assScopeId != null) {
			setAssScopeId(assScopeId);
		}

		String scopeName = (String)attributes.get("scopeName");

		if (scopeName != null) {
			setScopeName(scopeName);
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
	public String getAssScopeId() {
		if (_assScopeId == null) {
			return StringPool.BLANK;
		}
		else {
			return _assScopeId;
		}
	}

	@Override
	public void setAssScopeId(String assScopeId) {
		_columnBitmask = -1L;

		_assScopeId = assScopeId;
	}

	@Override
	public String getScopeName() {
		if (_scopeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _scopeName;
		}
	}

	@Override
	public void setScopeName(String scopeName) {
		_scopeName = scopeName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Ambito toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Ambito)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AmbitoImpl ambitoImpl = new AmbitoImpl();

		ambitoImpl.setUuid(getUuid());
		ambitoImpl.setAssScopeId(getAssScopeId());
		ambitoImpl.setScopeName(getScopeName());

		ambitoImpl.resetOriginalValues();

		return ambitoImpl;
	}

	@Override
	public int compareTo(Ambito ambito) {
		int value = 0;

		value = getAssScopeId().compareTo(ambito.getAssScopeId());

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

		if (!(obj instanceof Ambito)) {
			return false;
		}

		Ambito ambito = (Ambito)obj;

		String primaryKey = ambito.getPrimaryKey();

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
		AmbitoModelImpl ambitoModelImpl = this;

		ambitoModelImpl._originalUuid = ambitoModelImpl._uuid;

		ambitoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Ambito> toCacheModel() {
		AmbitoCacheModel ambitoCacheModel = new AmbitoCacheModel();

		ambitoCacheModel.uuid = getUuid();

		String uuid = ambitoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			ambitoCacheModel.uuid = null;
		}

		ambitoCacheModel.assScopeId = getAssScopeId();

		String assScopeId = ambitoCacheModel.assScopeId;

		if ((assScopeId != null) && (assScopeId.length() == 0)) {
			ambitoCacheModel.assScopeId = null;
		}

		ambitoCacheModel.scopeName = getScopeName();

		String scopeName = ambitoCacheModel.scopeName;

		if ((scopeName != null) && (scopeName.length() == 0)) {
			ambitoCacheModel.scopeName = null;
		}

		return ambitoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", assScopeId=");
		sb.append(getAssScopeId());
		sb.append(", scopeName=");
		sb.append(getScopeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.intranet.mef.assistance.model.Ambito");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assScopeId</column-name><column-value><![CDATA[");
		sb.append(getAssScopeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scopeName</column-name><column-value><![CDATA[");
		sb.append(getScopeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Ambito.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Ambito.class
		};
	private String _uuid;
	private String _originalUuid;
	private String _assScopeId;
	private String _scopeName;
	private long _columnBitmask;
	private Ambito _escapedModel;
}