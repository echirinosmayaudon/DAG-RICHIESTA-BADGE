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

import servizio.beni.facile.consumo.model.RigheRichiestaBFC;
import servizio.beni.facile.consumo.model.RigheRichiestaBFCModel;
import servizio.beni.facile.consumo.model.RigheRichiestaBFCSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the RigheRichiestaBFC service. Represents a row in the &quot;MEFBFC_RigheRichiestaBFC&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link RigheRichiestaBFCModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RigheRichiestaBFCImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCImpl
 * @see RigheRichiestaBFC
 * @see RigheRichiestaBFCModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RigheRichiestaBFCModelImpl extends BaseModelImpl<RigheRichiestaBFC>
	implements RigheRichiestaBFCModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a righe richiesta b f c model instance should use the {@link RigheRichiestaBFC} interface instead.
	 */
	public static final String TABLE_NAME = "MEFBFC_RigheRichiestaBFC";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "id_richiesta", Types.BIGINT },
			{ "dipartimento", Types.VARCHAR },
			{ "dati", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("id_richiesta", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dipartimento", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dati", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table MEFBFC_RigheRichiestaBFC (id_ LONG not null primary key,id_richiesta LONG,dipartimento VARCHAR(75) null,dati STRING null)";
	public static final String TABLE_SQL_DROP = "drop table MEFBFC_RigheRichiestaBFC";
	public static final String ORDER_BY_JPQL = " ORDER BY righeRichiestaBFC.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MEFBFC_RigheRichiestaBFC.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.servizio.beni.facile.consumo.model.RigheRichiestaBFC"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.servizio.beni.facile.consumo.model.RigheRichiestaBFC"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.servizio.beni.facile.consumo.model.RigheRichiestaBFC"),
			true);
	public static final long DIPARTIMENTO_COLUMN_BITMASK = 1L;
	public static final long ID_RICHIESTA_COLUMN_BITMASK = 2L;
	public static final long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static RigheRichiestaBFC toModel(RigheRichiestaBFCSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RigheRichiestaBFC model = new RigheRichiestaBFCImpl();

		model.setId(soapModel.getId());
		model.setId_richiesta(soapModel.getId_richiesta());
		model.setDipartimento(soapModel.getDipartimento());
		model.setDati(soapModel.getDati());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<RigheRichiestaBFC> toModels(
		RigheRichiestaBFCSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<RigheRichiestaBFC> models = new ArrayList<RigheRichiestaBFC>(soapModels.length);

		for (RigheRichiestaBFCSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(servizio.beni.facile.consumo.service.util.PropsUtil.get(
				"lock.expiration.time.servizio.beni.facile.consumo.model.RigheRichiestaBFC"));

	public RigheRichiestaBFCModelImpl() {
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
		return RigheRichiestaBFC.class;
	}

	@Override
	public String getModelClassName() {
		return RigheRichiestaBFC.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("dipartimento", getDipartimento());
		attributes.put("dati", getDati());

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

		Long id_richiesta = (Long)attributes.get("id_richiesta");

		if (id_richiesta != null) {
			setId_richiesta(id_richiesta);
		}

		String dipartimento = (String)attributes.get("dipartimento");

		if (dipartimento != null) {
			setDipartimento(dipartimento);
		}

		String dati = (String)attributes.get("dati");

		if (dati != null) {
			setDati(dati);
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
	public String getDipartimento() {
		if (_dipartimento == null) {
			return StringPool.BLANK;
		}
		else {
			return _dipartimento;
		}
	}

	@Override
	public void setDipartimento(String dipartimento) {
		_columnBitmask |= DIPARTIMENTO_COLUMN_BITMASK;

		if (_originalDipartimento == null) {
			_originalDipartimento = _dipartimento;
		}

		_dipartimento = dipartimento;
	}

	public String getOriginalDipartimento() {
		return GetterUtil.getString(_originalDipartimento);
	}

	@JSON
	@Override
	public String getDati() {
		if (_dati == null) {
			return StringPool.BLANK;
		}
		else {
			return _dati;
		}
	}

	@Override
	public void setDati(String dati) {
		_dati = dati;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			RigheRichiestaBFC.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RigheRichiestaBFC toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RigheRichiestaBFC)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RigheRichiestaBFCImpl righeRichiestaBFCImpl = new RigheRichiestaBFCImpl();

		righeRichiestaBFCImpl.setId(getId());
		righeRichiestaBFCImpl.setId_richiesta(getId_richiesta());
		righeRichiestaBFCImpl.setDipartimento(getDipartimento());
		righeRichiestaBFCImpl.setDati(getDati());

		righeRichiestaBFCImpl.resetOriginalValues();

		return righeRichiestaBFCImpl;
	}

	@Override
	public int compareTo(RigheRichiestaBFC righeRichiestaBFC) {
		long primaryKey = righeRichiestaBFC.getPrimaryKey();

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

		if (!(obj instanceof RigheRichiestaBFC)) {
			return false;
		}

		RigheRichiestaBFC righeRichiestaBFC = (RigheRichiestaBFC)obj;

		long primaryKey = righeRichiestaBFC.getPrimaryKey();

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
		RigheRichiestaBFCModelImpl righeRichiestaBFCModelImpl = this;

		righeRichiestaBFCModelImpl._originalId_richiesta = righeRichiestaBFCModelImpl._id_richiesta;

		righeRichiestaBFCModelImpl._setOriginalId_richiesta = false;

		righeRichiestaBFCModelImpl._originalDipartimento = righeRichiestaBFCModelImpl._dipartimento;

		righeRichiestaBFCModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RigheRichiestaBFC> toCacheModel() {
		RigheRichiestaBFCCacheModel righeRichiestaBFCCacheModel = new RigheRichiestaBFCCacheModel();

		righeRichiestaBFCCacheModel.id = getId();

		righeRichiestaBFCCacheModel.id_richiesta = getId_richiesta();

		righeRichiestaBFCCacheModel.dipartimento = getDipartimento();

		String dipartimento = righeRichiestaBFCCacheModel.dipartimento;

		if ((dipartimento != null) && (dipartimento.length() == 0)) {
			righeRichiestaBFCCacheModel.dipartimento = null;
		}

		righeRichiestaBFCCacheModel.dati = getDati();

		String dati = righeRichiestaBFCCacheModel.dati;

		if ((dati != null) && (dati.length() == 0)) {
			righeRichiestaBFCCacheModel.dati = null;
		}

		return righeRichiestaBFCCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", id_richiesta=");
		sb.append(getId_richiesta());
		sb.append(", dipartimento=");
		sb.append(getDipartimento());
		sb.append(", dati=");
		sb.append(getDati());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("servizio.beni.facile.consumo.model.RigheRichiestaBFC");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_richiesta</column-name><column-value><![CDATA[");
		sb.append(getId_richiesta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dipartimento</column-name><column-value><![CDATA[");
		sb.append(getDipartimento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dati</column-name><column-value><![CDATA[");
		sb.append(getDati());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = RigheRichiestaBFC.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			RigheRichiestaBFC.class
		};
	private long _id;
	private long _id_richiesta;
	private long _originalId_richiesta;
	private boolean _setOriginalId_richiesta;
	private String _dipartimento;
	private String _originalDipartimento;
	private String _dati;
	private long _columnBitmask;
	private RigheRichiestaBFC _escapedModel;
}