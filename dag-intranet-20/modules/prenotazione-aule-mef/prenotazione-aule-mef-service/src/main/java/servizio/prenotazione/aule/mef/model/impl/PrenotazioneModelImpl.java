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

package servizio.prenotazione.aule.mef.model.impl;

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

import servizio.prenotazione.aule.mef.model.Prenotazione;
import servizio.prenotazione.aule.mef.model.PrenotazioneModel;
import servizio.prenotazione.aule.mef.model.PrenotazioneSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Prenotazione service. Represents a row in the &quot;MEFAULE_Prenotazione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PrenotazioneModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PrenotazioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazioneImpl
 * @see Prenotazione
 * @see PrenotazioneModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PrenotazioneModelImpl extends BaseModelImpl<Prenotazione>
	implements PrenotazioneModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a prenotazione model instance should use the {@link Prenotazione} interface instead.
	 */
	public static final String TABLE_NAME = "MEFAULE_Prenotazione";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_prenota", Types.BIGINT },
			{ "id_sala", Types.BIGINT },
			{ "cod_fiscale", Types.VARCHAR },
			{ "data_prenota", Types.TIMESTAMP },
			{ "data_inizio", Types.TIMESTAMP },
			{ "data_fine", Types.TIMESTAMP },
			{ "partecipanti", Types.INTEGER },
			{ "id_evento", Types.BIGINT },
			{ "attivita", Types.VARCHAR },
			{ "note", Types.VARCHAR },
			{ "id_stato", Types.BIGINT },
			{ "dati_rich", Types.VARCHAR },
			{ "servizi", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_prenota", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("id_sala", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cod_fiscale", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("data_prenota", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("data_inizio", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("data_fine", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("partecipanti", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("id_evento", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("attivita", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("note", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_stato", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dati_rich", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("servizi", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MEFAULE_Prenotazione (id_prenota LONG not null primary key,id_sala LONG,cod_fiscale VARCHAR(16) null,data_prenota DATE null,data_inizio DATE null,data_fine DATE null,partecipanti INTEGER,id_evento LONG,attivita VARCHAR(100) null,note VARCHAR(500) null,id_stato LONG,dati_rich VARCHAR(1500) null,servizi VARCHAR(1500) null)";
	public static final String TABLE_SQL_DROP = "drop table MEFAULE_Prenotazione";
	public static final String ORDER_BY_JPQL = " ORDER BY prenotazione.id_prenota ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MEFAULE_Prenotazione.id_prenota ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(servizio.prenotazione.aule.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.servizio.prenotazione.aule.mef.model.Prenotazione"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(servizio.prenotazione.aule.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.servizio.prenotazione.aule.mef.model.Prenotazione"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(servizio.prenotazione.aule.mef.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.servizio.prenotazione.aule.mef.model.Prenotazione"),
			true);
	public static final long COD_FISCALE_COLUMN_BITMASK = 1L;
	public static final long ID_PRENOTA_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Prenotazione toModel(PrenotazioneSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Prenotazione model = new PrenotazioneImpl();

		model.setId_prenota(soapModel.getId_prenota());
		model.setId_sala(soapModel.getId_sala());
		model.setCod_fiscale(soapModel.getCod_fiscale());
		model.setData_prenota(soapModel.getData_prenota());
		model.setData_inizio(soapModel.getData_inizio());
		model.setData_fine(soapModel.getData_fine());
		model.setPartecipanti(soapModel.getPartecipanti());
		model.setId_evento(soapModel.getId_evento());
		model.setAttivita(soapModel.getAttivita());
		model.setNote(soapModel.getNote());
		model.setId_stato(soapModel.getId_stato());
		model.setDati_rich(soapModel.getDati_rich());
		model.setServizi(soapModel.getServizi());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Prenotazione> toModels(PrenotazioneSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Prenotazione> models = new ArrayList<Prenotazione>(soapModels.length);

		for (PrenotazioneSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(servizio.prenotazione.aule.mef.service.util.PropsUtil.get(
				"lock.expiration.time.servizio.prenotazione.aule.mef.model.Prenotazione"));

	public PrenotazioneModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id_prenota;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_prenota(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_prenota;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Prenotazione.class;
	}

	@Override
	public String getModelClassName() {
		return Prenotazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_prenota", getId_prenota());
		attributes.put("id_sala", getId_sala());
		attributes.put("cod_fiscale", getCod_fiscale());
		attributes.put("data_prenota", getData_prenota());
		attributes.put("data_inizio", getData_inizio());
		attributes.put("data_fine", getData_fine());
		attributes.put("partecipanti", getPartecipanti());
		attributes.put("id_evento", getId_evento());
		attributes.put("attivita", getAttivita());
		attributes.put("note", getNote());
		attributes.put("id_stato", getId_stato());
		attributes.put("dati_rich", getDati_rich());
		attributes.put("servizi", getServizi());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_prenota = (Long)attributes.get("id_prenota");

		if (id_prenota != null) {
			setId_prenota(id_prenota);
		}

		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		String cod_fiscale = (String)attributes.get("cod_fiscale");

		if (cod_fiscale != null) {
			setCod_fiscale(cod_fiscale);
		}

		Date data_prenota = (Date)attributes.get("data_prenota");

		if (data_prenota != null) {
			setData_prenota(data_prenota);
		}

		Date data_inizio = (Date)attributes.get("data_inizio");

		if (data_inizio != null) {
			setData_inizio(data_inizio);
		}

		Date data_fine = (Date)attributes.get("data_fine");

		if (data_fine != null) {
			setData_fine(data_fine);
		}

		Integer partecipanti = (Integer)attributes.get("partecipanti");

		if (partecipanti != null) {
			setPartecipanti(partecipanti);
		}

		Long id_evento = (Long)attributes.get("id_evento");

		if (id_evento != null) {
			setId_evento(id_evento);
		}

		String attivita = (String)attributes.get("attivita");

		if (attivita != null) {
			setAttivita(attivita);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long id_stato = (Long)attributes.get("id_stato");

		if (id_stato != null) {
			setId_stato(id_stato);
		}

		String dati_rich = (String)attributes.get("dati_rich");

		if (dati_rich != null) {
			setDati_rich(dati_rich);
		}

		String servizi = (String)attributes.get("servizi");

		if (servizi != null) {
			setServizi(servizi);
		}
	}

	@JSON
	@Override
	public long getId_prenota() {
		return _id_prenota;
	}

	@Override
	public void setId_prenota(long id_prenota) {
		_id_prenota = id_prenota;
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
	public String getCod_fiscale() {
		if (_cod_fiscale == null) {
			return StringPool.BLANK;
		}
		else {
			return _cod_fiscale;
		}
	}

	@Override
	public void setCod_fiscale(String cod_fiscale) {
		_columnBitmask |= COD_FISCALE_COLUMN_BITMASK;

		if (_originalCod_fiscale == null) {
			_originalCod_fiscale = _cod_fiscale;
		}

		_cod_fiscale = cod_fiscale;
	}

	public String getOriginalCod_fiscale() {
		return GetterUtil.getString(_originalCod_fiscale);
	}

	@JSON
	@Override
	public Date getData_prenota() {
		return _data_prenota;
	}

	@Override
	public void setData_prenota(Date data_prenota) {
		_data_prenota = data_prenota;
	}

	@JSON
	@Override
	public Date getData_inizio() {
		return _data_inizio;
	}

	@Override
	public void setData_inizio(Date data_inizio) {
		_data_inizio = data_inizio;
	}

	@JSON
	@Override
	public Date getData_fine() {
		return _data_fine;
	}

	@Override
	public void setData_fine(Date data_fine) {
		_data_fine = data_fine;
	}

	@JSON
	@Override
	public int getPartecipanti() {
		return _partecipanti;
	}

	@Override
	public void setPartecipanti(int partecipanti) {
		_partecipanti = partecipanti;
	}

	@JSON
	@Override
	public long getId_evento() {
		return _id_evento;
	}

	@Override
	public void setId_evento(long id_evento) {
		_id_evento = id_evento;
	}

	@JSON
	@Override
	public String getAttivita() {
		if (_attivita == null) {
			return StringPool.BLANK;
		}
		else {
			return _attivita;
		}
	}

	@Override
	public void setAttivita(String attivita) {
		_attivita = attivita;
	}

	@JSON
	@Override
	public String getNote() {
		if (_note == null) {
			return StringPool.BLANK;
		}
		else {
			return _note;
		}
	}

	@Override
	public void setNote(String note) {
		_note = note;
	}

	@JSON
	@Override
	public long getId_stato() {
		return _id_stato;
	}

	@Override
	public void setId_stato(long id_stato) {
		_id_stato = id_stato;
	}

	@JSON
	@Override
	public String getDati_rich() {
		if (_dati_rich == null) {
			return StringPool.BLANK;
		}
		else {
			return _dati_rich;
		}
	}

	@Override
	public void setDati_rich(String dati_rich) {
		_dati_rich = dati_rich;
	}

	@JSON
	@Override
	public String getServizi() {
		if (_servizi == null) {
			return StringPool.BLANK;
		}
		else {
			return _servizi;
		}
	}

	@Override
	public void setServizi(String servizi) {
		_servizi = servizi;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Prenotazione.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Prenotazione toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Prenotazione)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PrenotazioneImpl prenotazioneImpl = new PrenotazioneImpl();

		prenotazioneImpl.setId_prenota(getId_prenota());
		prenotazioneImpl.setId_sala(getId_sala());
		prenotazioneImpl.setCod_fiscale(getCod_fiscale());
		prenotazioneImpl.setData_prenota(getData_prenota());
		prenotazioneImpl.setData_inizio(getData_inizio());
		prenotazioneImpl.setData_fine(getData_fine());
		prenotazioneImpl.setPartecipanti(getPartecipanti());
		prenotazioneImpl.setId_evento(getId_evento());
		prenotazioneImpl.setAttivita(getAttivita());
		prenotazioneImpl.setNote(getNote());
		prenotazioneImpl.setId_stato(getId_stato());
		prenotazioneImpl.setDati_rich(getDati_rich());
		prenotazioneImpl.setServizi(getServizi());

		prenotazioneImpl.resetOriginalValues();

		return prenotazioneImpl;
	}

	@Override
	public int compareTo(Prenotazione prenotazione) {
		long primaryKey = prenotazione.getPrimaryKey();

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

		if (!(obj instanceof Prenotazione)) {
			return false;
		}

		Prenotazione prenotazione = (Prenotazione)obj;

		long primaryKey = prenotazione.getPrimaryKey();

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
		PrenotazioneModelImpl prenotazioneModelImpl = this;

		prenotazioneModelImpl._originalCod_fiscale = prenotazioneModelImpl._cod_fiscale;

		prenotazioneModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Prenotazione> toCacheModel() {
		PrenotazioneCacheModel prenotazioneCacheModel = new PrenotazioneCacheModel();

		prenotazioneCacheModel.id_prenota = getId_prenota();

		prenotazioneCacheModel.id_sala = getId_sala();

		prenotazioneCacheModel.cod_fiscale = getCod_fiscale();

		String cod_fiscale = prenotazioneCacheModel.cod_fiscale;

		if ((cod_fiscale != null) && (cod_fiscale.length() == 0)) {
			prenotazioneCacheModel.cod_fiscale = null;
		}

		Date data_prenota = getData_prenota();

		if (data_prenota != null) {
			prenotazioneCacheModel.data_prenota = data_prenota.getTime();
		}
		else {
			prenotazioneCacheModel.data_prenota = Long.MIN_VALUE;
		}

		Date data_inizio = getData_inizio();

		if (data_inizio != null) {
			prenotazioneCacheModel.data_inizio = data_inizio.getTime();
		}
		else {
			prenotazioneCacheModel.data_inizio = Long.MIN_VALUE;
		}

		Date data_fine = getData_fine();

		if (data_fine != null) {
			prenotazioneCacheModel.data_fine = data_fine.getTime();
		}
		else {
			prenotazioneCacheModel.data_fine = Long.MIN_VALUE;
		}

		prenotazioneCacheModel.partecipanti = getPartecipanti();

		prenotazioneCacheModel.id_evento = getId_evento();

		prenotazioneCacheModel.attivita = getAttivita();

		String attivita = prenotazioneCacheModel.attivita;

		if ((attivita != null) && (attivita.length() == 0)) {
			prenotazioneCacheModel.attivita = null;
		}

		prenotazioneCacheModel.note = getNote();

		String note = prenotazioneCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			prenotazioneCacheModel.note = null;
		}

		prenotazioneCacheModel.id_stato = getId_stato();

		prenotazioneCacheModel.dati_rich = getDati_rich();

		String dati_rich = prenotazioneCacheModel.dati_rich;

		if ((dati_rich != null) && (dati_rich.length() == 0)) {
			prenotazioneCacheModel.dati_rich = null;
		}

		prenotazioneCacheModel.servizi = getServizi();

		String servizi = prenotazioneCacheModel.servizi;

		if ((servizi != null) && (servizi.length() == 0)) {
			prenotazioneCacheModel.servizi = null;
		}

		return prenotazioneCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id_prenota=");
		sb.append(getId_prenota());
		sb.append(", id_sala=");
		sb.append(getId_sala());
		sb.append(", cod_fiscale=");
		sb.append(getCod_fiscale());
		sb.append(", data_prenota=");
		sb.append(getData_prenota());
		sb.append(", data_inizio=");
		sb.append(getData_inizio());
		sb.append(", data_fine=");
		sb.append(getData_fine());
		sb.append(", partecipanti=");
		sb.append(getPartecipanti());
		sb.append(", id_evento=");
		sb.append(getId_evento());
		sb.append(", attivita=");
		sb.append(getAttivita());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", id_stato=");
		sb.append(getId_stato());
		sb.append(", dati_rich=");
		sb.append(getDati_rich());
		sb.append(", servizi=");
		sb.append(getServizi());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("servizio.prenotazione.aule.mef.model.Prenotazione");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_prenota</column-name><column-value><![CDATA[");
		sb.append(getId_prenota());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_sala</column-name><column-value><![CDATA[");
		sb.append(getId_sala());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cod_fiscale</column-name><column-value><![CDATA[");
		sb.append(getCod_fiscale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data_prenota</column-name><column-value><![CDATA[");
		sb.append(getData_prenota());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data_inizio</column-name><column-value><![CDATA[");
		sb.append(getData_inizio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data_fine</column-name><column-value><![CDATA[");
		sb.append(getData_fine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partecipanti</column-name><column-value><![CDATA[");
		sb.append(getPartecipanti());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_evento</column-name><column-value><![CDATA[");
		sb.append(getId_evento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attivita</column-name><column-value><![CDATA[");
		sb.append(getAttivita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_stato</column-name><column-value><![CDATA[");
		sb.append(getId_stato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dati_rich</column-name><column-value><![CDATA[");
		sb.append(getDati_rich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>servizi</column-name><column-value><![CDATA[");
		sb.append(getServizi());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Prenotazione.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Prenotazione.class
		};
	private long _id_prenota;
	private long _id_sala;
	private String _cod_fiscale;
	private String _originalCod_fiscale;
	private Date _data_prenota;
	private Date _data_inizio;
	private Date _data_fine;
	private int _partecipanti;
	private long _id_evento;
	private String _attivita;
	private String _note;
	private long _id_stato;
	private String _dati_rich;
	private String _servizi;
	private long _columnBitmask;
	private Prenotazione _escapedModel;
}