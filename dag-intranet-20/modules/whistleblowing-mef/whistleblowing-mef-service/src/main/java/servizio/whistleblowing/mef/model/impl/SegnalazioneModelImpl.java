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

package servizio.whistleblowing.mef.model.impl;

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

import servizio.whistleblowing.mef.model.Segnalazione;
import servizio.whistleblowing.mef.model.SegnalazioneModel;
import servizio.whistleblowing.mef.model.SegnalazioneSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Segnalazione service. Represents a row in the &quot;MEFWHISTLE_Segnalazione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SegnalazioneModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SegnalazioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneImpl
 * @see Segnalazione
 * @see SegnalazioneModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SegnalazioneModelImpl extends BaseModelImpl<Segnalazione>
	implements SegnalazioneModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a segnalazione model instance should use the {@link Segnalazione} interface instead.
	 */
	public static final String TABLE_NAME = "MEFWHISTLE_Segnalazione";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_segnalazione", Types.BIGINT },
			{ "json_dati_personali", Types.VARCHAR },
			{ "luogo", Types.VARCHAR },
			{ "azioni_omissioni", Types.VARCHAR },
			{ "descrizione", Types.VARCHAR },
			{ "autore", Types.VARCHAR },
			{ "altri_testimoni", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_segnalazione", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("json_dati_personali", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("luogo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("azioni_omissioni", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("descrizione", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("autore", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("altri_testimoni", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MEFWHISTLE_Segnalazione (id_segnalazione LONG not null primary key,json_dati_personali VARCHAR(1500) null,luogo VARCHAR(500) null,azioni_omissioni VARCHAR(1500) null,descrizione VARCHAR(1000) null,autore VARCHAR(1000) null,altri_testimoni VARCHAR(1000) null)";
	public static final String TABLE_SQL_DROP = "drop table MEFWHISTLE_Segnalazione";
	public static final String ORDER_BY_JPQL = " ORDER BY segnalazione.id_segnalazione ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MEFWHISTLE_Segnalazione.id_segnalazione ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(servizio.whistleblowing.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.servizio.whistleblowing.mef.model.Segnalazione"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(servizio.whistleblowing.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.servizio.whistleblowing.mef.model.Segnalazione"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Segnalazione toModel(SegnalazioneSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Segnalazione model = new SegnalazioneImpl();

		model.setId_segnalazione(soapModel.getId_segnalazione());
		model.setJson_dati_personali(soapModel.getJson_dati_personali());
		model.setLuogo(soapModel.getLuogo());
		model.setAzioni_omissioni(soapModel.getAzioni_omissioni());
		model.setDescrizione(soapModel.getDescrizione());
		model.setAutore(soapModel.getAutore());
		model.setAltri_testimoni(soapModel.getAltri_testimoni());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Segnalazione> toModels(SegnalazioneSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Segnalazione> models = new ArrayList<Segnalazione>(soapModels.length);

		for (SegnalazioneSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(servizio.whistleblowing.mef.service.util.PropsUtil.get(
				"lock.expiration.time.servizio.whistleblowing.mef.model.Segnalazione"));

	public SegnalazioneModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id_segnalazione;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_segnalazione(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_segnalazione;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Segnalazione.class;
	}

	@Override
	public String getModelClassName() {
		return Segnalazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_segnalazione", getId_segnalazione());
		attributes.put("json_dati_personali", getJson_dati_personali());
		attributes.put("luogo", getLuogo());
		attributes.put("azioni_omissioni", getAzioni_omissioni());
		attributes.put("descrizione", getDescrizione());
		attributes.put("autore", getAutore());
		attributes.put("altri_testimoni", getAltri_testimoni());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_segnalazione = (Long)attributes.get("id_segnalazione");

		if (id_segnalazione != null) {
			setId_segnalazione(id_segnalazione);
		}

		String json_dati_personali = (String)attributes.get(
				"json_dati_personali");

		if (json_dati_personali != null) {
			setJson_dati_personali(json_dati_personali);
		}

		String luogo = (String)attributes.get("luogo");

		if (luogo != null) {
			setLuogo(luogo);
		}

		String azioni_omissioni = (String)attributes.get("azioni_omissioni");

		if (azioni_omissioni != null) {
			setAzioni_omissioni(azioni_omissioni);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String autore = (String)attributes.get("autore");

		if (autore != null) {
			setAutore(autore);
		}

		String altri_testimoni = (String)attributes.get("altri_testimoni");

		if (altri_testimoni != null) {
			setAltri_testimoni(altri_testimoni);
		}
	}

	@JSON
	@Override
	public long getId_segnalazione() {
		return _id_segnalazione;
	}

	@Override
	public void setId_segnalazione(long id_segnalazione) {
		_id_segnalazione = id_segnalazione;
	}

	@JSON
	@Override
	public String getJson_dati_personali() {
		if (_json_dati_personali == null) {
			return StringPool.BLANK;
		}
		else {
			return _json_dati_personali;
		}
	}

	@Override
	public void setJson_dati_personali(String json_dati_personali) {
		_json_dati_personali = json_dati_personali;
	}

	@JSON
	@Override
	public String getLuogo() {
		if (_luogo == null) {
			return StringPool.BLANK;
		}
		else {
			return _luogo;
		}
	}

	@Override
	public void setLuogo(String luogo) {
		_luogo = luogo;
	}

	@JSON
	@Override
	public String getAzioni_omissioni() {
		if (_azioni_omissioni == null) {
			return StringPool.BLANK;
		}
		else {
			return _azioni_omissioni;
		}
	}

	@Override
	public void setAzioni_omissioni(String azioni_omissioni) {
		_azioni_omissioni = azioni_omissioni;
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

	@JSON
	@Override
	public String getAutore() {
		if (_autore == null) {
			return StringPool.BLANK;
		}
		else {
			return _autore;
		}
	}

	@Override
	public void setAutore(String autore) {
		_autore = autore;
	}

	@JSON
	@Override
	public String getAltri_testimoni() {
		if (_altri_testimoni == null) {
			return StringPool.BLANK;
		}
		else {
			return _altri_testimoni;
		}
	}

	@Override
	public void setAltri_testimoni(String altri_testimoni) {
		_altri_testimoni = altri_testimoni;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Segnalazione.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Segnalazione toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Segnalazione)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SegnalazioneImpl segnalazioneImpl = new SegnalazioneImpl();

		segnalazioneImpl.setId_segnalazione(getId_segnalazione());
		segnalazioneImpl.setJson_dati_personali(getJson_dati_personali());
		segnalazioneImpl.setLuogo(getLuogo());
		segnalazioneImpl.setAzioni_omissioni(getAzioni_omissioni());
		segnalazioneImpl.setDescrizione(getDescrizione());
		segnalazioneImpl.setAutore(getAutore());
		segnalazioneImpl.setAltri_testimoni(getAltri_testimoni());

		segnalazioneImpl.resetOriginalValues();

		return segnalazioneImpl;
	}

	@Override
	public int compareTo(Segnalazione segnalazione) {
		long primaryKey = segnalazione.getPrimaryKey();

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

		if (!(obj instanceof Segnalazione)) {
			return false;
		}

		Segnalazione segnalazione = (Segnalazione)obj;

		long primaryKey = segnalazione.getPrimaryKey();

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
	public CacheModel<Segnalazione> toCacheModel() {
		SegnalazioneCacheModel segnalazioneCacheModel = new SegnalazioneCacheModel();

		segnalazioneCacheModel.id_segnalazione = getId_segnalazione();

		segnalazioneCacheModel.json_dati_personali = getJson_dati_personali();

		String json_dati_personali = segnalazioneCacheModel.json_dati_personali;

		if ((json_dati_personali != null) &&
				(json_dati_personali.length() == 0)) {
			segnalazioneCacheModel.json_dati_personali = null;
		}

		segnalazioneCacheModel.luogo = getLuogo();

		String luogo = segnalazioneCacheModel.luogo;

		if ((luogo != null) && (luogo.length() == 0)) {
			segnalazioneCacheModel.luogo = null;
		}

		segnalazioneCacheModel.azioni_omissioni = getAzioni_omissioni();

		String azioni_omissioni = segnalazioneCacheModel.azioni_omissioni;

		if ((azioni_omissioni != null) && (azioni_omissioni.length() == 0)) {
			segnalazioneCacheModel.azioni_omissioni = null;
		}

		segnalazioneCacheModel.descrizione = getDescrizione();

		String descrizione = segnalazioneCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			segnalazioneCacheModel.descrizione = null;
		}

		segnalazioneCacheModel.autore = getAutore();

		String autore = segnalazioneCacheModel.autore;

		if ((autore != null) && (autore.length() == 0)) {
			segnalazioneCacheModel.autore = null;
		}

		segnalazioneCacheModel.altri_testimoni = getAltri_testimoni();

		String altri_testimoni = segnalazioneCacheModel.altri_testimoni;

		if ((altri_testimoni != null) && (altri_testimoni.length() == 0)) {
			segnalazioneCacheModel.altri_testimoni = null;
		}

		return segnalazioneCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id_segnalazione=");
		sb.append(getId_segnalazione());
		sb.append(", json_dati_personali=");
		sb.append(getJson_dati_personali());
		sb.append(", luogo=");
		sb.append(getLuogo());
		sb.append(", azioni_omissioni=");
		sb.append(getAzioni_omissioni());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", autore=");
		sb.append(getAutore());
		sb.append(", altri_testimoni=");
		sb.append(getAltri_testimoni());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("servizio.whistleblowing.mef.model.Segnalazione");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_segnalazione</column-name><column-value><![CDATA[");
		sb.append(getId_segnalazione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>json_dati_personali</column-name><column-value><![CDATA[");
		sb.append(getJson_dati_personali());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>luogo</column-name><column-value><![CDATA[");
		sb.append(getLuogo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>azioni_omissioni</column-name><column-value><![CDATA[");
		sb.append(getAzioni_omissioni());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autore</column-name><column-value><![CDATA[");
		sb.append(getAutore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>altri_testimoni</column-name><column-value><![CDATA[");
		sb.append(getAltri_testimoni());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Segnalazione.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Segnalazione.class
		};
	private long _id_segnalazione;
	private String _json_dati_personali;
	private String _luogo;
	private String _azioni_omissioni;
	private String _descrizione;
	private String _autore;
	private String _altri_testimoni;
	private Segnalazione _escapedModel;
}