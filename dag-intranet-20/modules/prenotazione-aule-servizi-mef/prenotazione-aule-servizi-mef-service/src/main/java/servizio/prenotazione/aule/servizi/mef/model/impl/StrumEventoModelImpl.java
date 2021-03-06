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

package servizio.prenotazione.aule.servizi.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.prenotazione.aule.servizi.mef.model.StrumEvento;
import servizio.prenotazione.aule.servizi.mef.model.StrumEventoModel;
import servizio.prenotazione.aule.servizi.mef.model.StrumEventoSoap;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the StrumEvento service. Represents a row in the &quot;MEFAULESERV_StrumEvento&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StrumEventoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StrumEventoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumEventoImpl
 * @see StrumEvento
 * @see StrumEventoModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class StrumEventoModelImpl extends BaseModelImpl<StrumEvento>
	implements StrumEventoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a strum evento model instance should use the {@link StrumEvento} interface instead.
	 */
	public static final String TABLE_NAME = "MEFAULESERV_StrumEvento";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_strum", Types.BIGINT },
			{ "id_sala", Types.BIGINT },
			{ "email_ref", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_strum", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("id_sala", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("email_ref", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MEFAULESERV_StrumEvento (id_strum LONG not null,id_sala LONG not null,email_ref VARCHAR(250) null,primary key (id_strum, id_sala))";
	public static final String TABLE_SQL_DROP = "drop table MEFAULESERV_StrumEvento";
	public static final String ORDER_BY_JPQL = " ORDER BY strumEvento.id.id_strum ASC, strumEvento.id.id_sala ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MEFAULESERV_StrumEvento.id_strum ASC, MEFAULESERV_StrumEvento.id_sala ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(servizio.prenotazione.aule.servizi.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.servizio.prenotazione.aule.servizi.mef.model.StrumEvento"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(servizio.prenotazione.aule.servizi.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.servizio.prenotazione.aule.servizi.mef.model.StrumEvento"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static StrumEvento toModel(StrumEventoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		StrumEvento model = new StrumEventoImpl();

		model.setId_strum(soapModel.getId_strum());
		model.setId_sala(soapModel.getId_sala());
		model.setEmail_ref(soapModel.getEmail_ref());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<StrumEvento> toModels(StrumEventoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<StrumEvento> models = new ArrayList<StrumEvento>(soapModels.length);

		for (StrumEventoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(servizio.prenotazione.aule.servizi.mef.service.util.PropsUtil.get(
				"lock.expiration.time.servizio.prenotazione.aule.servizi.mef.model.StrumEvento"));

	public StrumEventoModelImpl() {
	}

	@Override
	public StrumEventoPK getPrimaryKey() {
		return new StrumEventoPK(_id_strum, _id_sala);
	}

	@Override
	public void setPrimaryKey(StrumEventoPK primaryKey) {
		setId_strum(primaryKey.id_strum);
		setId_sala(primaryKey.id_sala);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StrumEventoPK(_id_strum, _id_sala);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StrumEventoPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return StrumEvento.class;
	}

	@Override
	public String getModelClassName() {
		return StrumEvento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_strum", getId_strum());
		attributes.put("id_sala", getId_sala());
		attributes.put("email_ref", getEmail_ref());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_strum = (Long)attributes.get("id_strum");

		if (id_strum != null) {
			setId_strum(id_strum);
		}

		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		String email_ref = (String)attributes.get("email_ref");

		if (email_ref != null) {
			setEmail_ref(email_ref);
		}
	}

	@JSON
	@Override
	public long getId_strum() {
		return _id_strum;
	}

	@Override
	public void setId_strum(long id_strum) {
		_id_strum = id_strum;
	}

	@JSON
	@Override
	public long getId_sala() {
		return _id_sala;
	}

	@Override
	public void setId_sala(long id_sala) {
		_id_sala = id_sala;
	}

	@JSON
	@Override
	public String getEmail_ref() {
		if (_email_ref == null) {
			return StringPool.BLANK;
		}
		else {
			return _email_ref;
		}
	}

	@Override
	public void setEmail_ref(String email_ref) {
		_email_ref = email_ref;
	}

	@Override
	public StrumEvento toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StrumEvento)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StrumEventoImpl strumEventoImpl = new StrumEventoImpl();

		strumEventoImpl.setId_strum(getId_strum());
		strumEventoImpl.setId_sala(getId_sala());
		strumEventoImpl.setEmail_ref(getEmail_ref());

		strumEventoImpl.resetOriginalValues();

		return strumEventoImpl;
	}

	@Override
	public int compareTo(StrumEvento strumEvento) {
		StrumEventoPK primaryKey = strumEvento.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StrumEvento)) {
			return false;
		}

		StrumEvento strumEvento = (StrumEvento)obj;

		StrumEventoPK primaryKey = strumEvento.getPrimaryKey();

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
	}

	@Override
	public CacheModel<StrumEvento> toCacheModel() {
		StrumEventoCacheModel strumEventoCacheModel = new StrumEventoCacheModel();

		strumEventoCacheModel.strumEventoPK = getPrimaryKey();

		strumEventoCacheModel.id_strum = getId_strum();

		strumEventoCacheModel.id_sala = getId_sala();

		strumEventoCacheModel.email_ref = getEmail_ref();

		String email_ref = strumEventoCacheModel.email_ref;

		if ((email_ref != null) && (email_ref.length() == 0)) {
			strumEventoCacheModel.email_ref = null;
		}

		return strumEventoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_strum=");
		sb.append(getId_strum());
		sb.append(", id_sala=");
		sb.append(getId_sala());
		sb.append(", email_ref=");
		sb.append(getEmail_ref());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("servizio.prenotazione.aule.servizi.mef.model.StrumEvento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_strum</column-name><column-value><![CDATA[");
		sb.append(getId_strum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_sala</column-name><column-value><![CDATA[");
		sb.append(getId_sala());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email_ref</column-name><column-value><![CDATA[");
		sb.append(getEmail_ref());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = StrumEvento.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			StrumEvento.class
		};
	private long _id_strum;
	private long _id_sala;
	private String _email_ref;
	private StrumEvento _escapedModel;
}