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

package servizio.beni.facile.consumo.model.impl;

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

import servizio.beni.facile.consumo.model.Stato;
import servizio.beni.facile.consumo.model.StatoModel;
import servizio.beni.facile.consumo.model.StatoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Stato service. Represents a row in the &quot;MEFBFC_Stato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StatoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StatoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoImpl
 * @see Stato
 * @see StatoModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class StatoModelImpl extends BaseModelImpl<Stato> implements StatoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a stato model instance should use the {@link Stato} interface instead.
	 */
	public static final String TABLE_NAME = "MEFBFC_Stato";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "descrizione", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("descrizione", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MEFBFC_Stato (id_ LONG not null primary key,descrizione VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table MEFBFC_Stato";
	public static final String ORDER_BY_JPQL = " ORDER BY stato.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MEFBFC_Stato.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.servizio.beni.facile.consumo.model.Stato"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.servizio.beni.facile.consumo.model.Stato"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Stato toModel(StatoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Stato model = new StatoImpl();

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
	public static List<Stato> toModels(StatoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Stato> models = new ArrayList<Stato>(soapModels.length);

		for (StatoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"lock.expiration.time.servizio.beni.facile.consumo.model.Stato"));

	public StatoModelImpl() {
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
		return Stato.class;
	}

	@Override
	public String getModelClassName() {
		return Stato.class.getName();
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
			Stato.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Stato toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Stato)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StatoImpl statoImpl = new StatoImpl();

		statoImpl.setId(getId());
		statoImpl.setDescrizione(getDescrizione());

		statoImpl.resetOriginalValues();

		return statoImpl;
	}

	@Override
	public int compareTo(Stato stato) {
		long primaryKey = stato.getPrimaryKey();

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

		if (!(obj instanceof Stato)) {
			return false;
		}

		Stato stato = (Stato)obj;

		long primaryKey = stato.getPrimaryKey();

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
	public CacheModel<Stato> toCacheModel() {
		StatoCacheModel statoCacheModel = new StatoCacheModel();

		statoCacheModel.id = getId();

		statoCacheModel.descrizione = getDescrizione();

		String descrizione = statoCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			statoCacheModel.descrizione = null;
		}

		return statoCacheModel;
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
		sb.append("servizio.beni.facile.consumo.model.Stato");
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

	private static final ClassLoader _classLoader = Stato.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Stato.class
		};
	private long _id;
	private String _descrizione;
	private Stato _escapedModel;
}