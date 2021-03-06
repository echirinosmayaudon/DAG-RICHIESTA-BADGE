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

import service.intranet.mef.model.TipologiaRichPubblic;
import service.intranet.mef.model.TipologiaRichPubblicModel;
import service.intranet.mef.model.TipologiaRichPubblicSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TipologiaRichPubblic service. Represents a row in the &quot;MFORM_TipologiaRichPubblic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TipologiaRichPubblicModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipologiaRichPubblicImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaRichPubblicImpl
 * @see TipologiaRichPubblic
 * @see TipologiaRichPubblicModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TipologiaRichPubblicModelImpl extends BaseModelImpl<TipologiaRichPubblic>
	implements TipologiaRichPubblicModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tipologia rich pubblic model instance should use the {@link TipologiaRichPubblic} interface instead.
	 */
	public static final String TABLE_NAME = "MFORM_TipologiaRichPubblic";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "tipologia", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tipologia", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MFORM_TipologiaRichPubblic (id_ LONG not null primary key,tipologia VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table MFORM_TipologiaRichPubblic";
	public static final String ORDER_BY_JPQL = " ORDER BY tipologiaRichPubblic.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MFORM_TipologiaRichPubblic.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(service.intranet.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.service.intranet.mef.model.TipologiaRichPubblic"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(service.intranet.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.service.intranet.mef.model.TipologiaRichPubblic"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TipologiaRichPubblic toModel(
		TipologiaRichPubblicSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TipologiaRichPubblic model = new TipologiaRichPubblicImpl();

		model.setId(soapModel.getId());
		model.setTipologia(soapModel.getTipologia());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TipologiaRichPubblic> toModels(
		TipologiaRichPubblicSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TipologiaRichPubblic> models = new ArrayList<TipologiaRichPubblic>(soapModels.length);

		for (TipologiaRichPubblicSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(service.intranet.mef.service.util.PropsUtil.get(
				"lock.expiration.time.service.intranet.mef.model.TipologiaRichPubblic"));

	public TipologiaRichPubblicModelImpl() {
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
		return TipologiaRichPubblic.class;
	}

	@Override
	public String getModelClassName() {
		return TipologiaRichPubblic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipologia", getTipologia());

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

		String tipologia = (String)attributes.get("tipologia");

		if (tipologia != null) {
			setTipologia(tipologia);
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
	public String getTipologia() {
		if (_tipologia == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipologia;
		}
	}

	@Override
	public void setTipologia(String tipologia) {
		_tipologia = tipologia;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TipologiaRichPubblic.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TipologiaRichPubblic toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TipologiaRichPubblic)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TipologiaRichPubblicImpl tipologiaRichPubblicImpl = new TipologiaRichPubblicImpl();

		tipologiaRichPubblicImpl.setId(getId());
		tipologiaRichPubblicImpl.setTipologia(getTipologia());

		tipologiaRichPubblicImpl.resetOriginalValues();

		return tipologiaRichPubblicImpl;
	}

	@Override
	public int compareTo(TipologiaRichPubblic tipologiaRichPubblic) {
		long primaryKey = tipologiaRichPubblic.getPrimaryKey();

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

		if (!(obj instanceof TipologiaRichPubblic)) {
			return false;
		}

		TipologiaRichPubblic tipologiaRichPubblic = (TipologiaRichPubblic)obj;

		long primaryKey = tipologiaRichPubblic.getPrimaryKey();

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
	public CacheModel<TipologiaRichPubblic> toCacheModel() {
		TipologiaRichPubblicCacheModel tipologiaRichPubblicCacheModel = new TipologiaRichPubblicCacheModel();

		tipologiaRichPubblicCacheModel.id = getId();

		tipologiaRichPubblicCacheModel.tipologia = getTipologia();

		String tipologia = tipologiaRichPubblicCacheModel.tipologia;

		if ((tipologia != null) && (tipologia.length() == 0)) {
			tipologiaRichPubblicCacheModel.tipologia = null;
		}

		return tipologiaRichPubblicCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tipologia=");
		sb.append(getTipologia());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("service.intranet.mef.model.TipologiaRichPubblic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipologia</column-name><column-value><![CDATA[");
		sb.append(getTipologia());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TipologiaRichPubblic.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TipologiaRichPubblic.class
		};
	private long _id;
	private String _tipologia;
	private TipologiaRichPubblic _escapedModel;
}