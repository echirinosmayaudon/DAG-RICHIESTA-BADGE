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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.beni.facile.consumo.model.ServizioMateriale;
import servizio.beni.facile.consumo.model.ServizioMaterialeModel;
import servizio.beni.facile.consumo.model.ServizioMaterialeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ServizioMateriale service. Represents a row in the &quot;MEFBFC_ServizioMateriale&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ServizioMaterialeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServizioMaterialeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioMaterialeImpl
 * @see ServizioMateriale
 * @see ServizioMaterialeModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ServizioMaterialeModelImpl extends BaseModelImpl<ServizioMateriale>
	implements ServizioMaterialeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a servizio materiale model instance should use the {@link ServizioMateriale} interface instead.
	 */
	public static final String TABLE_NAME = "MEFBFC_ServizioMateriale";
	public static final Object[][] TABLE_COLUMNS = {
			{ "gruppo", Types.VARCHAR },
			{ "descrizione", Types.VARCHAR },
			{ "categoria", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("gruppo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("descrizione", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("categoria", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MEFBFC_ServizioMateriale (gruppo VARCHAR(75) not null primary key,descrizione VARCHAR(75) null,categoria VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table MEFBFC_ServizioMateriale";
	public static final String ORDER_BY_JPQL = " ORDER BY servizioMateriale.gruppo ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MEFBFC_ServizioMateriale.gruppo ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.servizio.beni.facile.consumo.model.ServizioMateriale"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.servizio.beni.facile.consumo.model.ServizioMateriale"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.servizio.beni.facile.consumo.model.ServizioMateriale"),
			true);
	public static final long CATEGORIA_COLUMN_BITMASK = 1L;
	public static final long GRUPPO_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ServizioMateriale toModel(ServizioMaterialeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ServizioMateriale model = new ServizioMaterialeImpl();

		model.setGruppo(soapModel.getGruppo());
		model.setDescrizione(soapModel.getDescrizione());
		model.setCategoria(soapModel.getCategoria());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ServizioMateriale> toModels(
		ServizioMaterialeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ServizioMateriale> models = new ArrayList<ServizioMateriale>(soapModels.length);

		for (ServizioMaterialeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"lock.expiration.time.servizio.beni.facile.consumo.model.ServizioMateriale"));

	public ServizioMaterialeModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _gruppo;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setGruppo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gruppo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ServizioMateriale.class;
	}

	@Override
	public String getModelClassName() {
		return ServizioMateriale.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gruppo", getGruppo());
		attributes.put("descrizione", getDescrizione());
		attributes.put("categoria", getCategoria());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String gruppo = (String)attributes.get("gruppo");

		if (gruppo != null) {
			setGruppo(gruppo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String categoria = (String)attributes.get("categoria");

		if (categoria != null) {
			setCategoria(categoria);
		}
	}

	@JSON
	@Override
	public String getGruppo() {
		if (_gruppo == null) {
			return StringPool.BLANK;
		}
		else {
			return _gruppo;
		}
	}

	@Override
	public void setGruppo(String gruppo) {
		_gruppo = gruppo;
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
	public String getCategoria() {
		if (_categoria == null) {
			return StringPool.BLANK;
		}
		else {
			return _categoria;
		}
	}

	@Override
	public void setCategoria(String categoria) {
		_columnBitmask |= CATEGORIA_COLUMN_BITMASK;

		if (_originalCategoria == null) {
			_originalCategoria = _categoria;
		}

		_categoria = categoria;
	}

	public String getOriginalCategoria() {
		return GetterUtil.getString(_originalCategoria);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ServizioMateriale toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ServizioMateriale)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ServizioMaterialeImpl servizioMaterialeImpl = new ServizioMaterialeImpl();

		servizioMaterialeImpl.setGruppo(getGruppo());
		servizioMaterialeImpl.setDescrizione(getDescrizione());
		servizioMaterialeImpl.setCategoria(getCategoria());

		servizioMaterialeImpl.resetOriginalValues();

		return servizioMaterialeImpl;
	}

	@Override
	public int compareTo(ServizioMateriale servizioMateriale) {
		String primaryKey = servizioMateriale.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServizioMateriale)) {
			return false;
		}

		ServizioMateriale servizioMateriale = (ServizioMateriale)obj;

		String primaryKey = servizioMateriale.getPrimaryKey();

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
		ServizioMaterialeModelImpl servizioMaterialeModelImpl = this;

		servizioMaterialeModelImpl._originalCategoria = servizioMaterialeModelImpl._categoria;

		servizioMaterialeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServizioMateriale> toCacheModel() {
		ServizioMaterialeCacheModel servizioMaterialeCacheModel = new ServizioMaterialeCacheModel();

		servizioMaterialeCacheModel.gruppo = getGruppo();

		String gruppo = servizioMaterialeCacheModel.gruppo;

		if ((gruppo != null) && (gruppo.length() == 0)) {
			servizioMaterialeCacheModel.gruppo = null;
		}

		servizioMaterialeCacheModel.descrizione = getDescrizione();

		String descrizione = servizioMaterialeCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			servizioMaterialeCacheModel.descrizione = null;
		}

		servizioMaterialeCacheModel.categoria = getCategoria();

		String categoria = servizioMaterialeCacheModel.categoria;

		if ((categoria != null) && (categoria.length() == 0)) {
			servizioMaterialeCacheModel.categoria = null;
		}

		return servizioMaterialeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{gruppo=");
		sb.append(getGruppo());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", categoria=");
		sb.append(getCategoria());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("servizio.beni.facile.consumo.model.ServizioMateriale");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>gruppo</column-name><column-value><![CDATA[");
		sb.append(getGruppo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoria</column-name><column-value><![CDATA[");
		sb.append(getCategoria());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ServizioMateriale.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ServizioMateriale.class
		};
	private String _gruppo;
	private String _descrizione;
	private String _categoria;
	private String _originalCategoria;
	private long _columnBitmask;
	private ServizioMateriale _escapedModel;
}