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

package mef.email.configurator.model.impl;

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

import mef.email.configurator.model.AppNames;
import mef.email.configurator.model.AppNamesModel;
import mef.email.configurator.model.AppNamesSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AppNames service. Represents a row in the &quot;MEFEMAILC_AppNames&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AppNamesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AppNamesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppNamesImpl
 * @see AppNames
 * @see AppNamesModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AppNamesModelImpl extends BaseModelImpl<AppNames>
	implements AppNamesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a app names model instance should use the {@link AppNames} interface instead.
	 */
	public static final String TABLE_NAME = "MEFEMAILC_AppNames";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "appname", Types.VARCHAR },
			{ "appid", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("appname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("appid", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table MEFEMAILC_AppNames (id_ LONG not null primary key,appname VARCHAR(75) null,appid LONG)";
	public static final String TABLE_SQL_DROP = "drop table MEFEMAILC_AppNames";
	public static final String ORDER_BY_JPQL = " ORDER BY appNames.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MEFEMAILC_AppNames.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(mef.email.configurator.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.mef.email.configurator.model.AppNames"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(mef.email.configurator.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.mef.email.configurator.model.AppNames"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(mef.email.configurator.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.mef.email.configurator.model.AppNames"),
			true);
	public static final long APPID_COLUMN_BITMASK = 1L;
	public static final long APPNAME_COLUMN_BITMASK = 2L;
	public static final long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AppNames toModel(AppNamesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AppNames model = new AppNamesImpl();

		model.setId(soapModel.getId());
		model.setAppname(soapModel.getAppname());
		model.setAppid(soapModel.getAppid());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AppNames> toModels(AppNamesSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AppNames> models = new ArrayList<AppNames>(soapModels.length);

		for (AppNamesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(mef.email.configurator.service.util.PropsUtil.get(
				"lock.expiration.time.mef.email.configurator.model.AppNames"));

	public AppNamesModelImpl() {
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
		return AppNames.class;
	}

	@Override
	public String getModelClassName() {
		return AppNames.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("appname", getAppname());
		attributes.put("appid", getAppid());

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

		String appname = (String)attributes.get("appname");

		if (appname != null) {
			setAppname(appname);
		}

		Long appid = (Long)attributes.get("appid");

		if (appid != null) {
			setAppid(appid);
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
	public String getAppname() {
		if (_appname == null) {
			return StringPool.BLANK;
		}
		else {
			return _appname;
		}
	}

	@Override
	public void setAppname(String appname) {
		_columnBitmask |= APPNAME_COLUMN_BITMASK;

		if (_originalAppname == null) {
			_originalAppname = _appname;
		}

		_appname = appname;
	}

	public String getOriginalAppname() {
		return GetterUtil.getString(_originalAppname);
	}

	@JSON
	@Override
	public long getAppid() {
		return _appid;
	}

	@Override
	public void setAppid(long appid) {
		_columnBitmask |= APPID_COLUMN_BITMASK;

		if (!_setOriginalAppid) {
			_setOriginalAppid = true;

			_originalAppid = _appid;
		}

		_appid = appid;
	}

	public long getOriginalAppid() {
		return _originalAppid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			AppNames.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AppNames toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AppNames)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AppNamesImpl appNamesImpl = new AppNamesImpl();

		appNamesImpl.setId(getId());
		appNamesImpl.setAppname(getAppname());
		appNamesImpl.setAppid(getAppid());

		appNamesImpl.resetOriginalValues();

		return appNamesImpl;
	}

	@Override
	public int compareTo(AppNames appNames) {
		long primaryKey = appNames.getPrimaryKey();

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

		if (!(obj instanceof AppNames)) {
			return false;
		}

		AppNames appNames = (AppNames)obj;

		long primaryKey = appNames.getPrimaryKey();

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
		AppNamesModelImpl appNamesModelImpl = this;

		appNamesModelImpl._originalAppname = appNamesModelImpl._appname;

		appNamesModelImpl._originalAppid = appNamesModelImpl._appid;

		appNamesModelImpl._setOriginalAppid = false;

		appNamesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AppNames> toCacheModel() {
		AppNamesCacheModel appNamesCacheModel = new AppNamesCacheModel();

		appNamesCacheModel.id = getId();

		appNamesCacheModel.appname = getAppname();

		String appname = appNamesCacheModel.appname;

		if ((appname != null) && (appname.length() == 0)) {
			appNamesCacheModel.appname = null;
		}

		appNamesCacheModel.appid = getAppid();

		return appNamesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", appname=");
		sb.append(getAppname());
		sb.append(", appid=");
		sb.append(getAppid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("mef.email.configurator.model.AppNames");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appname</column-name><column-value><![CDATA[");
		sb.append(getAppname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appid</column-name><column-value><![CDATA[");
		sb.append(getAppid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AppNames.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AppNames.class
		};
	private long _id;
	private String _appname;
	private String _originalAppname;
	private long _appid;
	private long _originalAppid;
	private boolean _setOriginalAppid;
	private long _columnBitmask;
	private AppNames _escapedModel;
}