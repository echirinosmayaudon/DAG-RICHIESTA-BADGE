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

import service.intranet.mef.model.RichiesteUtenza;
import service.intranet.mef.model.RichiesteUtenzaModel;
import service.intranet.mef.model.RichiesteUtenzaSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the RichiesteUtenza service. Represents a row in the &quot;MFORM_RichiesteUtenza&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link RichiesteUtenzaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RichiesteUtenzaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteUtenzaImpl
 * @see RichiesteUtenza
 * @see RichiesteUtenzaModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RichiesteUtenzaModelImpl extends BaseModelImpl<RichiesteUtenza>
	implements RichiesteUtenzaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a richieste utenza model instance should use the {@link RichiesteUtenza} interface instead.
	 */
	public static final String TABLE_NAME = "MFORM_RichiesteUtenza";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_richieste_utenza", Types.BIGINT },
			{ "utente", Types.VARCHAR },
			{ "destinatario", Types.VARCHAR },
			{ "dettaglio", Types.VARCHAR },
			{ "data_richiesta", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_richieste_utenza", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("utente", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("destinatario", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dettaglio", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("data_richiesta", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table MFORM_RichiesteUtenza (id_richieste_utenza LONG not null primary key,utente VARCHAR(200) null,destinatario VARCHAR(200) null,dettaglio VARCHAR(2500) null,data_richiesta DATE null)";
	public static final String TABLE_SQL_DROP = "drop table MFORM_RichiesteUtenza";
	public static final String ORDER_BY_JPQL = " ORDER BY richiesteUtenza.id_richieste_utenza ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MFORM_RichiesteUtenza.id_richieste_utenza ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(service.intranet.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.service.intranet.mef.model.RichiesteUtenza"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(service.intranet.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.service.intranet.mef.model.RichiesteUtenza"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static RichiesteUtenza toModel(RichiesteUtenzaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RichiesteUtenza model = new RichiesteUtenzaImpl();

		model.setId_richieste_utenza(soapModel.getId_richieste_utenza());
		model.setUtente(soapModel.getUtente());
		model.setDestinatario(soapModel.getDestinatario());
		model.setDettaglio(soapModel.getDettaglio());
		model.setData_richiesta(soapModel.getData_richiesta());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<RichiesteUtenza> toModels(
		RichiesteUtenzaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<RichiesteUtenza> models = new ArrayList<RichiesteUtenza>(soapModels.length);

		for (RichiesteUtenzaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(service.intranet.mef.service.util.PropsUtil.get(
				"lock.expiration.time.service.intranet.mef.model.RichiesteUtenza"));

	public RichiesteUtenzaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id_richieste_utenza;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_richieste_utenza(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_richieste_utenza;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RichiesteUtenza.class;
	}

	@Override
	public String getModelClassName() {
		return RichiesteUtenza.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_richieste_utenza", getId_richieste_utenza());
		attributes.put("utente", getUtente());
		attributes.put("destinatario", getDestinatario());
		attributes.put("dettaglio", getDettaglio());
		attributes.put("data_richiesta", getData_richiesta());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_richieste_utenza = (Long)attributes.get("id_richieste_utenza");

		if (id_richieste_utenza != null) {
			setId_richieste_utenza(id_richieste_utenza);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		String destinatario = (String)attributes.get("destinatario");

		if (destinatario != null) {
			setDestinatario(destinatario);
		}

		String dettaglio = (String)attributes.get("dettaglio");

		if (dettaglio != null) {
			setDettaglio(dettaglio);
		}

		Date data_richiesta = (Date)attributes.get("data_richiesta");

		if (data_richiesta != null) {
			setData_richiesta(data_richiesta);
		}
	}

	@JSON
	@Override
	public long getId_richieste_utenza() {
		return _id_richieste_utenza;
	}

	@Override
	public void setId_richieste_utenza(long id_richieste_utenza) {
		_id_richieste_utenza = id_richieste_utenza;
	}

	@JSON
	@Override
	public String getUtente() {
		if (_utente == null) {
			return StringPool.BLANK;
		}
		else {
			return _utente;
		}
	}

	@Override
	public void setUtente(String utente) {
		_utente = utente;
	}

	@JSON
	@Override
	public String getDestinatario() {
		if (_destinatario == null) {
			return StringPool.BLANK;
		}
		else {
			return _destinatario;
		}
	}

	@Override
	public void setDestinatario(String destinatario) {
		_destinatario = destinatario;
	}

	@JSON
	@Override
	public String getDettaglio() {
		if (_dettaglio == null) {
			return StringPool.BLANK;
		}
		else {
			return _dettaglio;
		}
	}

	@Override
	public void setDettaglio(String dettaglio) {
		_dettaglio = dettaglio;
	}

	@JSON
	@Override
	public Date getData_richiesta() {
		return _data_richiesta;
	}

	@Override
	public void setData_richiesta(Date data_richiesta) {
		_data_richiesta = data_richiesta;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			RichiesteUtenza.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RichiesteUtenza toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RichiesteUtenza)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RichiesteUtenzaImpl richiesteUtenzaImpl = new RichiesteUtenzaImpl();

		richiesteUtenzaImpl.setId_richieste_utenza(getId_richieste_utenza());
		richiesteUtenzaImpl.setUtente(getUtente());
		richiesteUtenzaImpl.setDestinatario(getDestinatario());
		richiesteUtenzaImpl.setDettaglio(getDettaglio());
		richiesteUtenzaImpl.setData_richiesta(getData_richiesta());

		richiesteUtenzaImpl.resetOriginalValues();

		return richiesteUtenzaImpl;
	}

	@Override
	public int compareTo(RichiesteUtenza richiesteUtenza) {
		long primaryKey = richiesteUtenza.getPrimaryKey();

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

		if (!(obj instanceof RichiesteUtenza)) {
			return false;
		}

		RichiesteUtenza richiesteUtenza = (RichiesteUtenza)obj;

		long primaryKey = richiesteUtenza.getPrimaryKey();

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
	public CacheModel<RichiesteUtenza> toCacheModel() {
		RichiesteUtenzaCacheModel richiesteUtenzaCacheModel = new RichiesteUtenzaCacheModel();

		richiesteUtenzaCacheModel.id_richieste_utenza = getId_richieste_utenza();

		richiesteUtenzaCacheModel.utente = getUtente();

		String utente = richiesteUtenzaCacheModel.utente;

		if ((utente != null) && (utente.length() == 0)) {
			richiesteUtenzaCacheModel.utente = null;
		}

		richiesteUtenzaCacheModel.destinatario = getDestinatario();

		String destinatario = richiesteUtenzaCacheModel.destinatario;

		if ((destinatario != null) && (destinatario.length() == 0)) {
			richiesteUtenzaCacheModel.destinatario = null;
		}

		richiesteUtenzaCacheModel.dettaglio = getDettaglio();

		String dettaglio = richiesteUtenzaCacheModel.dettaglio;

		if ((dettaglio != null) && (dettaglio.length() == 0)) {
			richiesteUtenzaCacheModel.dettaglio = null;
		}

		Date data_richiesta = getData_richiesta();

		if (data_richiesta != null) {
			richiesteUtenzaCacheModel.data_richiesta = data_richiesta.getTime();
		}
		else {
			richiesteUtenzaCacheModel.data_richiesta = Long.MIN_VALUE;
		}

		return richiesteUtenzaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id_richieste_utenza=");
		sb.append(getId_richieste_utenza());
		sb.append(", utente=");
		sb.append(getUtente());
		sb.append(", destinatario=");
		sb.append(getDestinatario());
		sb.append(", dettaglio=");
		sb.append(getDettaglio());
		sb.append(", data_richiesta=");
		sb.append(getData_richiesta());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("service.intranet.mef.model.RichiesteUtenza");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_richieste_utenza</column-name><column-value><![CDATA[");
		sb.append(getId_richieste_utenza());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>utente</column-name><column-value><![CDATA[");
		sb.append(getUtente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>destinatario</column-name><column-value><![CDATA[");
		sb.append(getDestinatario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dettaglio</column-name><column-value><![CDATA[");
		sb.append(getDettaglio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data_richiesta</column-name><column-value><![CDATA[");
		sb.append(getData_richiesta());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = RichiesteUtenza.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			RichiesteUtenza.class
		};
	private long _id_richieste_utenza;
	private String _utente;
	private String _destinatario;
	private String _dettaglio;
	private Date _data_richiesta;
	private RichiesteUtenza _escapedModel;
}