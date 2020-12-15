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

package servizio.local.bfc.model.impl;

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

import servizio.local.bfc.model.LocalRich;
import servizio.local.bfc.model.LocalRichModel;
import servizio.local.bfc.model.LocalRichSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LocalRich service. Represents a row in the &quot;LOCBFC_LocalRich&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LocalRichModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LocalRichImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichImpl
 * @see LocalRich
 * @see LocalRichModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class LocalRichModelImpl extends BaseModelImpl<LocalRich>
	implements LocalRichModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a local rich model instance should use the {@link LocalRich} interface instead.
	 */
	public static final String TABLE_NAME = "LOCBFC_LocalRich";
	public static final Object[][] TABLE_COLUMNS = {
			{ "idStatoAttuale", Types.BIGINT },
			{ "id_", Types.BIGINT },
			{ "id_richiesta", Types.BIGINT },
			{ "dataRichiesta", Types.TIMESTAMP },
			{ "idPeriodicita", Types.BIGINT },
			{ "email", Types.VARCHAR },
			{ "rifStanza", Types.VARCHAR },
			{ "ispettorato", Types.VARCHAR },
			{ "noteRich", Types.VARCHAR },
			{ "ufficio", Types.VARCHAR },
			{ "note", Types.VARCHAR },
			{ "uidIns", Types.BIGINT },
			{ "dataIns", Types.TIMESTAMP },
			{ "uidUpd", Types.BIGINT },
			{ "dataUpd", Types.TIMESTAMP },
			{ "oggetto", Types.VARCHAR },
			{ "idSede", Types.VARCHAR },
			{ "strutIsp", Types.VARCHAR },
			{ "strutUff", Types.VARCHAR },
			{ "strutIsp2", Types.VARCHAR },
			{ "telRich", Types.VARCHAR },
			{ "costoReale", Types.FLOAT },
			{ "preventivo", Types.INTEGER },
			{ "flagInvio", Types.INTEGER },
			{ "inStage", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("idStatoAttuale", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("id_richiesta", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dataRichiesta", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("idPeriodicita", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("rifStanza", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ispettorato", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("noteRich", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ufficio", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("note", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("uidIns", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dataIns", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("uidUpd", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dataUpd", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("oggetto", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("idSede", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("strutIsp", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("strutUff", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("strutIsp2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("telRich", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("costoReale", Types.FLOAT);
		TABLE_COLUMNS_MAP.put("preventivo", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("flagInvio", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("inStage", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table LOCBFC_LocalRich (idStatoAttuale LONG,id_ LONG not null primary key,id_richiesta LONG,dataRichiesta DATE null,idPeriodicita LONG,email VARCHAR(100) null,rifStanza VARCHAR(50) null,ispettorato VARCHAR(100) null,noteRich STRING null,ufficio VARCHAR(100) null,note STRING null,uidIns LONG,dataIns DATE null,uidUpd LONG,dataUpd DATE null,oggetto VARCHAR(100) null,idSede VARCHAR(50) null,strutIsp VARCHAR(10) null,strutUff VARCHAR(10) null,strutIsp2 VARCHAR(10) null,telRich VARCHAR(20) null,costoReale DOUBLE,preventivo INTEGER,flagInvio INTEGER,inStage BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table LOCBFC_LocalRich";
	public static final String ORDER_BY_JPQL = " ORDER BY localRich.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LOCBFC_LocalRich.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.example.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.servizio.local.bfc.model.LocalRich"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.example.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.servizio.local.bfc.model.LocalRich"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.example.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.servizio.local.bfc.model.LocalRich"),
			true);
	public static final long EMAIL_COLUMN_BITMASK = 1L;
	public static final long ID_RICHIESTA_COLUMN_BITMASK = 2L;
	public static final long INSTAGE_COLUMN_BITMASK = 4L;
	public static final long ID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LocalRich toModel(LocalRichSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LocalRich model = new LocalRichImpl();

		model.setIdStatoAttuale(soapModel.getIdStatoAttuale());
		model.setId(soapModel.getId());
		model.setId_richiesta(soapModel.getId_richiesta());
		model.setDataRichiesta(soapModel.getDataRichiesta());
		model.setIdPeriodicita(soapModel.getIdPeriodicita());
		model.setEmail(soapModel.getEmail());
		model.setRifStanza(soapModel.getRifStanza());
		model.setIspettorato(soapModel.getIspettorato());
		model.setNoteRich(soapModel.getNoteRich());
		model.setUfficio(soapModel.getUfficio());
		model.setNote(soapModel.getNote());
		model.setUidIns(soapModel.getUidIns());
		model.setDataIns(soapModel.getDataIns());
		model.setUidUpd(soapModel.getUidUpd());
		model.setDataUpd(soapModel.getDataUpd());
		model.setOggetto(soapModel.getOggetto());
		model.setIdSede(soapModel.getIdSede());
		model.setStrutIsp(soapModel.getStrutIsp());
		model.setStrutUff(soapModel.getStrutUff());
		model.setStrutIsp2(soapModel.getStrutIsp2());
		model.setTelRich(soapModel.getTelRich());
		model.setCostoReale(soapModel.getCostoReale());
		model.setPreventivo(soapModel.getPreventivo());
		model.setFlagInvio(soapModel.getFlagInvio());
		model.setInStage(soapModel.getInStage());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LocalRich> toModels(LocalRichSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LocalRich> models = new ArrayList<LocalRich>(soapModels.length);

		for (LocalRichSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.example.service.util.PropsUtil.get(
				"lock.expiration.time.servizio.local.bfc.model.LocalRich"));

	public LocalRichModelImpl() {
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
		return LocalRich.class;
	}

	@Override
	public String getModelClassName() {
		return LocalRich.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idStatoAttuale", getIdStatoAttuale());
		attributes.put("id", getId());
		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("dataRichiesta", getDataRichiesta());
		attributes.put("idPeriodicita", getIdPeriodicita());
		attributes.put("email", getEmail());
		attributes.put("rifStanza", getRifStanza());
		attributes.put("ispettorato", getIspettorato());
		attributes.put("noteRich", getNoteRich());
		attributes.put("ufficio", getUfficio());
		attributes.put("note", getNote());
		attributes.put("uidIns", getUidIns());
		attributes.put("dataIns", getDataIns());
		attributes.put("uidUpd", getUidUpd());
		attributes.put("dataUpd", getDataUpd());
		attributes.put("oggetto", getOggetto());
		attributes.put("idSede", getIdSede());
		attributes.put("strutIsp", getStrutIsp());
		attributes.put("strutUff", getStrutUff());
		attributes.put("strutIsp2", getStrutIsp2());
		attributes.put("telRich", getTelRich());
		attributes.put("costoReale", getCostoReale());
		attributes.put("preventivo", getPreventivo());
		attributes.put("flagInvio", getFlagInvio());
		attributes.put("inStage", getInStage());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idStatoAttuale = (Long)attributes.get("idStatoAttuale");

		if (idStatoAttuale != null) {
			setIdStatoAttuale(idStatoAttuale);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long id_richiesta = (Long)attributes.get("id_richiesta");

		if (id_richiesta != null) {
			setId_richiesta(id_richiesta);
		}

		Date dataRichiesta = (Date)attributes.get("dataRichiesta");

		if (dataRichiesta != null) {
			setDataRichiesta(dataRichiesta);
		}

		Long idPeriodicita = (Long)attributes.get("idPeriodicita");

		if (idPeriodicita != null) {
			setIdPeriodicita(idPeriodicita);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String rifStanza = (String)attributes.get("rifStanza");

		if (rifStanza != null) {
			setRifStanza(rifStanza);
		}

		String ispettorato = (String)attributes.get("ispettorato");

		if (ispettorato != null) {
			setIspettorato(ispettorato);
		}

		String noteRich = (String)attributes.get("noteRich");

		if (noteRich != null) {
			setNoteRich(noteRich);
		}

		String ufficio = (String)attributes.get("ufficio");

		if (ufficio != null) {
			setUfficio(ufficio);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long uidIns = (Long)attributes.get("uidIns");

		if (uidIns != null) {
			setUidIns(uidIns);
		}

		Date dataIns = (Date)attributes.get("dataIns");

		if (dataIns != null) {
			setDataIns(dataIns);
		}

		Long uidUpd = (Long)attributes.get("uidUpd");

		if (uidUpd != null) {
			setUidUpd(uidUpd);
		}

		Date dataUpd = (Date)attributes.get("dataUpd");

		if (dataUpd != null) {
			setDataUpd(dataUpd);
		}

		String oggetto = (String)attributes.get("oggetto");

		if (oggetto != null) {
			setOggetto(oggetto);
		}

		String idSede = (String)attributes.get("idSede");

		if (idSede != null) {
			setIdSede(idSede);
		}

		String strutIsp = (String)attributes.get("strutIsp");

		if (strutIsp != null) {
			setStrutIsp(strutIsp);
		}

		String strutUff = (String)attributes.get("strutUff");

		if (strutUff != null) {
			setStrutUff(strutUff);
		}

		String strutIsp2 = (String)attributes.get("strutIsp2");

		if (strutIsp2 != null) {
			setStrutIsp2(strutIsp2);
		}

		String telRich = (String)attributes.get("telRich");

		if (telRich != null) {
			setTelRich(telRich);
		}

		Float costoReale = (Float)attributes.get("costoReale");

		if (costoReale != null) {
			setCostoReale(costoReale);
		}

		Integer preventivo = (Integer)attributes.get("preventivo");

		if (preventivo != null) {
			setPreventivo(preventivo);
		}

		Integer flagInvio = (Integer)attributes.get("flagInvio");

		if (flagInvio != null) {
			setFlagInvio(flagInvio);
		}

		Boolean inStage = (Boolean)attributes.get("inStage");

		if (inStage != null) {
			setInStage(inStage);
		}
	}

	@JSON
	@Override
	public long getIdStatoAttuale() {
		return _idStatoAttuale;
	}

	@Override
	public void setIdStatoAttuale(long idStatoAttuale) {
		_idStatoAttuale = idStatoAttuale;
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
	public long getId_richiesta() {
		return _id_richiesta;
	}

	@Override
	public void setId_richiesta(long id_richiesta) {
		_columnBitmask |= ID_RICHIESTA_COLUMN_BITMASK;

		if (!_setOriginalId_richiesta) {
			_setOriginalId_richiesta = true;

			_originalId_richiesta = _id_richiesta;
		}

		_id_richiesta = id_richiesta;
	}

	public long getOriginalId_richiesta() {
		return _originalId_richiesta;
	}

	@JSON
	@Override
	public Date getDataRichiesta() {
		return _dataRichiesta;
	}

	@Override
	public void setDataRichiesta(Date dataRichiesta) {
		_dataRichiesta = dataRichiesta;
	}

	@JSON
	@Override
	public long getIdPeriodicita() {
		return _idPeriodicita;
	}

	@Override
	public void setIdPeriodicita(long idPeriodicita) {
		_idPeriodicita = idPeriodicita;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_columnBitmask |= EMAIL_COLUMN_BITMASK;

		if (_originalEmail == null) {
			_originalEmail = _email;
		}

		_email = email;
	}

	public String getOriginalEmail() {
		return GetterUtil.getString(_originalEmail);
	}

	@JSON
	@Override
	public String getRifStanza() {
		if (_rifStanza == null) {
			return StringPool.BLANK;
		}
		else {
			return _rifStanza;
		}
	}

	@Override
	public void setRifStanza(String rifStanza) {
		_rifStanza = rifStanza;
	}

	@JSON
	@Override
	public String getIspettorato() {
		if (_ispettorato == null) {
			return StringPool.BLANK;
		}
		else {
			return _ispettorato;
		}
	}

	@Override
	public void setIspettorato(String ispettorato) {
		_ispettorato = ispettorato;
	}

	@JSON
	@Override
	public String getNoteRich() {
		if (_noteRich == null) {
			return StringPool.BLANK;
		}
		else {
			return _noteRich;
		}
	}

	@Override
	public void setNoteRich(String noteRich) {
		_noteRich = noteRich;
	}

	@JSON
	@Override
	public String getUfficio() {
		if (_ufficio == null) {
			return StringPool.BLANK;
		}
		else {
			return _ufficio;
		}
	}

	@Override
	public void setUfficio(String ufficio) {
		_ufficio = ufficio;
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
	public long getUidIns() {
		return _uidIns;
	}

	@Override
	public void setUidIns(long uidIns) {
		_uidIns = uidIns;
	}

	@JSON
	@Override
	public Date getDataIns() {
		return _dataIns;
	}

	@Override
	public void setDataIns(Date dataIns) {
		_dataIns = dataIns;
	}

	@JSON
	@Override
	public long getUidUpd() {
		return _uidUpd;
	}

	@Override
	public void setUidUpd(long uidUpd) {
		_uidUpd = uidUpd;
	}

	@JSON
	@Override
	public Date getDataUpd() {
		return _dataUpd;
	}

	@Override
	public void setDataUpd(Date dataUpd) {
		_dataUpd = dataUpd;
	}

	@JSON
	@Override
	public String getOggetto() {
		if (_oggetto == null) {
			return StringPool.BLANK;
		}
		else {
			return _oggetto;
		}
	}

	@Override
	public void setOggetto(String oggetto) {
		_oggetto = oggetto;
	}

	@JSON
	@Override
	public String getIdSede() {
		if (_idSede == null) {
			return StringPool.BLANK;
		}
		else {
			return _idSede;
		}
	}

	@Override
	public void setIdSede(String idSede) {
		_idSede = idSede;
	}

	@JSON
	@Override
	public String getStrutIsp() {
		if (_strutIsp == null) {
			return StringPool.BLANK;
		}
		else {
			return _strutIsp;
		}
	}

	@Override
	public void setStrutIsp(String strutIsp) {
		_strutIsp = strutIsp;
	}

	@JSON
	@Override
	public String getStrutUff() {
		if (_strutUff == null) {
			return StringPool.BLANK;
		}
		else {
			return _strutUff;
		}
	}

	@Override
	public void setStrutUff(String strutUff) {
		_strutUff = strutUff;
	}

	@JSON
	@Override
	public String getStrutIsp2() {
		if (_strutIsp2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _strutIsp2;
		}
	}

	@Override
	public void setStrutIsp2(String strutIsp2) {
		_strutIsp2 = strutIsp2;
	}

	@JSON
	@Override
	public String getTelRich() {
		if (_telRich == null) {
			return StringPool.BLANK;
		}
		else {
			return _telRich;
		}
	}

	@Override
	public void setTelRich(String telRich) {
		_telRich = telRich;
	}

	@JSON
	@Override
	public float getCostoReale() {
		return _costoReale;
	}

	@Override
	public void setCostoReale(float costoReale) {
		_costoReale = costoReale;
	}

	@JSON
	@Override
	public int getPreventivo() {
		return _preventivo;
	}

	@Override
	public void setPreventivo(int preventivo) {
		_preventivo = preventivo;
	}

	@JSON
	@Override
	public int getFlagInvio() {
		return _flagInvio;
	}

	@Override
	public void setFlagInvio(int flagInvio) {
		_flagInvio = flagInvio;
	}

	@JSON
	@Override
	public boolean getInStage() {
		return _inStage;
	}

	@JSON
	@Override
	public boolean isInStage() {
		return _inStage;
	}

	@Override
	public void setInStage(boolean inStage) {
		_columnBitmask |= INSTAGE_COLUMN_BITMASK;

		if (!_setOriginalInStage) {
			_setOriginalInStage = true;

			_originalInStage = _inStage;
		}

		_inStage = inStage;
	}

	public boolean getOriginalInStage() {
		return _originalInStage;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			LocalRich.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LocalRich toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LocalRich)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LocalRichImpl localRichImpl = new LocalRichImpl();

		localRichImpl.setIdStatoAttuale(getIdStatoAttuale());
		localRichImpl.setId(getId());
		localRichImpl.setId_richiesta(getId_richiesta());
		localRichImpl.setDataRichiesta(getDataRichiesta());
		localRichImpl.setIdPeriodicita(getIdPeriodicita());
		localRichImpl.setEmail(getEmail());
		localRichImpl.setRifStanza(getRifStanza());
		localRichImpl.setIspettorato(getIspettorato());
		localRichImpl.setNoteRich(getNoteRich());
		localRichImpl.setUfficio(getUfficio());
		localRichImpl.setNote(getNote());
		localRichImpl.setUidIns(getUidIns());
		localRichImpl.setDataIns(getDataIns());
		localRichImpl.setUidUpd(getUidUpd());
		localRichImpl.setDataUpd(getDataUpd());
		localRichImpl.setOggetto(getOggetto());
		localRichImpl.setIdSede(getIdSede());
		localRichImpl.setStrutIsp(getStrutIsp());
		localRichImpl.setStrutUff(getStrutUff());
		localRichImpl.setStrutIsp2(getStrutIsp2());
		localRichImpl.setTelRich(getTelRich());
		localRichImpl.setCostoReale(getCostoReale());
		localRichImpl.setPreventivo(getPreventivo());
		localRichImpl.setFlagInvio(getFlagInvio());
		localRichImpl.setInStage(getInStage());

		localRichImpl.resetOriginalValues();

		return localRichImpl;
	}

	@Override
	public int compareTo(LocalRich localRich) {
		long primaryKey = localRich.getPrimaryKey();

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

		if (!(obj instanceof LocalRich)) {
			return false;
		}

		LocalRich localRich = (LocalRich)obj;

		long primaryKey = localRich.getPrimaryKey();

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
		LocalRichModelImpl localRichModelImpl = this;

		localRichModelImpl._originalId_richiesta = localRichModelImpl._id_richiesta;

		localRichModelImpl._setOriginalId_richiesta = false;

		localRichModelImpl._originalEmail = localRichModelImpl._email;

		localRichModelImpl._originalInStage = localRichModelImpl._inStage;

		localRichModelImpl._setOriginalInStage = false;

		localRichModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LocalRich> toCacheModel() {
		LocalRichCacheModel localRichCacheModel = new LocalRichCacheModel();

		localRichCacheModel.idStatoAttuale = getIdStatoAttuale();

		localRichCacheModel.id = getId();

		localRichCacheModel.id_richiesta = getId_richiesta();

		Date dataRichiesta = getDataRichiesta();

		if (dataRichiesta != null) {
			localRichCacheModel.dataRichiesta = dataRichiesta.getTime();
		}
		else {
			localRichCacheModel.dataRichiesta = Long.MIN_VALUE;
		}

		localRichCacheModel.idPeriodicita = getIdPeriodicita();

		localRichCacheModel.email = getEmail();

		String email = localRichCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			localRichCacheModel.email = null;
		}

		localRichCacheModel.rifStanza = getRifStanza();

		String rifStanza = localRichCacheModel.rifStanza;

		if ((rifStanza != null) && (rifStanza.length() == 0)) {
			localRichCacheModel.rifStanza = null;
		}

		localRichCacheModel.ispettorato = getIspettorato();

		String ispettorato = localRichCacheModel.ispettorato;

		if ((ispettorato != null) && (ispettorato.length() == 0)) {
			localRichCacheModel.ispettorato = null;
		}

		localRichCacheModel.noteRich = getNoteRich();

		String noteRich = localRichCacheModel.noteRich;

		if ((noteRich != null) && (noteRich.length() == 0)) {
			localRichCacheModel.noteRich = null;
		}

		localRichCacheModel.ufficio = getUfficio();

		String ufficio = localRichCacheModel.ufficio;

		if ((ufficio != null) && (ufficio.length() == 0)) {
			localRichCacheModel.ufficio = null;
		}

		localRichCacheModel.note = getNote();

		String note = localRichCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			localRichCacheModel.note = null;
		}

		localRichCacheModel.uidIns = getUidIns();

		Date dataIns = getDataIns();

		if (dataIns != null) {
			localRichCacheModel.dataIns = dataIns.getTime();
		}
		else {
			localRichCacheModel.dataIns = Long.MIN_VALUE;
		}

		localRichCacheModel.uidUpd = getUidUpd();

		Date dataUpd = getDataUpd();

		if (dataUpd != null) {
			localRichCacheModel.dataUpd = dataUpd.getTime();
		}
		else {
			localRichCacheModel.dataUpd = Long.MIN_VALUE;
		}

		localRichCacheModel.oggetto = getOggetto();

		String oggetto = localRichCacheModel.oggetto;

		if ((oggetto != null) && (oggetto.length() == 0)) {
			localRichCacheModel.oggetto = null;
		}

		localRichCacheModel.idSede = getIdSede();

		String idSede = localRichCacheModel.idSede;

		if ((idSede != null) && (idSede.length() == 0)) {
			localRichCacheModel.idSede = null;
		}

		localRichCacheModel.strutIsp = getStrutIsp();

		String strutIsp = localRichCacheModel.strutIsp;

		if ((strutIsp != null) && (strutIsp.length() == 0)) {
			localRichCacheModel.strutIsp = null;
		}

		localRichCacheModel.strutUff = getStrutUff();

		String strutUff = localRichCacheModel.strutUff;

		if ((strutUff != null) && (strutUff.length() == 0)) {
			localRichCacheModel.strutUff = null;
		}

		localRichCacheModel.strutIsp2 = getStrutIsp2();

		String strutIsp2 = localRichCacheModel.strutIsp2;

		if ((strutIsp2 != null) && (strutIsp2.length() == 0)) {
			localRichCacheModel.strutIsp2 = null;
		}

		localRichCacheModel.telRich = getTelRich();

		String telRich = localRichCacheModel.telRich;

		if ((telRich != null) && (telRich.length() == 0)) {
			localRichCacheModel.telRich = null;
		}

		localRichCacheModel.costoReale = getCostoReale();

		localRichCacheModel.preventivo = getPreventivo();

		localRichCacheModel.flagInvio = getFlagInvio();

		localRichCacheModel.inStage = getInStage();

		return localRichCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{idStatoAttuale=");
		sb.append(getIdStatoAttuale());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", id_richiesta=");
		sb.append(getId_richiesta());
		sb.append(", dataRichiesta=");
		sb.append(getDataRichiesta());
		sb.append(", idPeriodicita=");
		sb.append(getIdPeriodicita());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", rifStanza=");
		sb.append(getRifStanza());
		sb.append(", ispettorato=");
		sb.append(getIspettorato());
		sb.append(", noteRich=");
		sb.append(getNoteRich());
		sb.append(", ufficio=");
		sb.append(getUfficio());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", uidIns=");
		sb.append(getUidIns());
		sb.append(", dataIns=");
		sb.append(getDataIns());
		sb.append(", uidUpd=");
		sb.append(getUidUpd());
		sb.append(", dataUpd=");
		sb.append(getDataUpd());
		sb.append(", oggetto=");
		sb.append(getOggetto());
		sb.append(", idSede=");
		sb.append(getIdSede());
		sb.append(", strutIsp=");
		sb.append(getStrutIsp());
		sb.append(", strutUff=");
		sb.append(getStrutUff());
		sb.append(", strutIsp2=");
		sb.append(getStrutIsp2());
		sb.append(", telRich=");
		sb.append(getTelRich());
		sb.append(", costoReale=");
		sb.append(getCostoReale());
		sb.append(", preventivo=");
		sb.append(getPreventivo());
		sb.append(", flagInvio=");
		sb.append(getFlagInvio());
		sb.append(", inStage=");
		sb.append(getInStage());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("servizio.local.bfc.model.LocalRich");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idStatoAttuale</column-name><column-value><![CDATA[");
		sb.append(getIdStatoAttuale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_richiesta</column-name><column-value><![CDATA[");
		sb.append(getId_richiesta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataRichiesta</column-name><column-value><![CDATA[");
		sb.append(getDataRichiesta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idPeriodicita</column-name><column-value><![CDATA[");
		sb.append(getIdPeriodicita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rifStanza</column-name><column-value><![CDATA[");
		sb.append(getRifStanza());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ispettorato</column-name><column-value><![CDATA[");
		sb.append(getIspettorato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noteRich</column-name><column-value><![CDATA[");
		sb.append(getNoteRich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ufficio</column-name><column-value><![CDATA[");
		sb.append(getUfficio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uidIns</column-name><column-value><![CDATA[");
		sb.append(getUidIns());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataIns</column-name><column-value><![CDATA[");
		sb.append(getDataIns());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uidUpd</column-name><column-value><![CDATA[");
		sb.append(getUidUpd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataUpd</column-name><column-value><![CDATA[");
		sb.append(getDataUpd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oggetto</column-name><column-value><![CDATA[");
		sb.append(getOggetto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSede</column-name><column-value><![CDATA[");
		sb.append(getIdSede());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>strutIsp</column-name><column-value><![CDATA[");
		sb.append(getStrutIsp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>strutUff</column-name><column-value><![CDATA[");
		sb.append(getStrutUff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>strutIsp2</column-name><column-value><![CDATA[");
		sb.append(getStrutIsp2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telRich</column-name><column-value><![CDATA[");
		sb.append(getTelRich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costoReale</column-name><column-value><![CDATA[");
		sb.append(getCostoReale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preventivo</column-name><column-value><![CDATA[");
		sb.append(getPreventivo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flagInvio</column-name><column-value><![CDATA[");
		sb.append(getFlagInvio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inStage</column-name><column-value><![CDATA[");
		sb.append(getInStage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = LocalRich.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LocalRich.class
		};
	private long _idStatoAttuale;
	private long _id;
	private long _id_richiesta;
	private long _originalId_richiesta;
	private boolean _setOriginalId_richiesta;
	private Date _dataRichiesta;
	private long _idPeriodicita;
	private String _email;
	private String _originalEmail;
	private String _rifStanza;
	private String _ispettorato;
	private String _noteRich;
	private String _ufficio;
	private String _note;
	private long _uidIns;
	private Date _dataIns;
	private long _uidUpd;
	private Date _dataUpd;
	private String _oggetto;
	private String _idSede;
	private String _strutIsp;
	private String _strutUff;
	private String _strutIsp2;
	private String _telRich;
	private float _costoReale;
	private int _preventivo;
	private int _flagInvio;
	private boolean _inStage;
	private boolean _originalInStage;
	private boolean _setOriginalInStage;
	private long _columnBitmask;
	private LocalRich _escapedModel;
}