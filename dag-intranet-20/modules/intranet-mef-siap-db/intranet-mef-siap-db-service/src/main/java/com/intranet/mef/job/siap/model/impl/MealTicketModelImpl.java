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

package com.intranet.mef.job.siap.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.model.MealTicket;
import com.intranet.mef.job.siap.model.MealTicketModel;
import com.intranet.mef.job.siap.model.MealTicketSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MealTicket service. Represents a row in the &quot;LF_BUONI_PASTO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link MealTicketModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MealTicketImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MealTicketImpl
 * @see MealTicket
 * @see MealTicketModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class MealTicketModelImpl extends BaseModelImpl<MealTicket>
	implements MealTicketModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a meal ticket model instance should use the {@link MealTicket} interface instead.
	 */
	public static final String TABLE_NAME = "LF_BUONI_PASTO";
	public static final Object[][] TABLE_COLUMNS = {
			{ "CUSTOM_KEY", Types.VARCHAR },
			{ "PERSON_ID", Types.BIGINT },
			{ "MESE", Types.VARCHAR },
			{ "BUONI_MATURATI", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CUSTOM_KEY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PERSON_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("MESE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("BUONI_MATURATI", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table LF_BUONI_PASTO (CUSTOM_KEY VARCHAR(75) not null primary key,PERSON_ID LONG,MESE VARCHAR(75) null,BUONI_MATURATI INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table LF_BUONI_PASTO";
	public static final String ORDER_BY_JPQL = " ORDER BY mealTicket.custom_key ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LF_BUONI_PASTO.CUSTOM_KEY ASC";
	public static final String DATA_SOURCE = "stage";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.intranet.mef.job.siap.model.MealTicket"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.intranet.mef.job.siap.model.MealTicket"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.intranet.mef.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.intranet.mef.job.siap.model.MealTicket"),
			true);
	public static final long PERSONID_COLUMN_BITMASK = 1L;
	public static final long CUSTOM_KEY_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MealTicket toModel(MealTicketSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MealTicket model = new MealTicketImpl();

		model.setCustom_key(soapModel.getCustom_key());
		model.setPersonID(soapModel.getPersonID());
		model.setMonth(soapModel.getMonth());
		model.setDueMeal(soapModel.getDueMeal());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MealTicket> toModels(MealTicketSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MealTicket> models = new ArrayList<MealTicket>(soapModels.length);

		for (MealTicketSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.intranet.mef.service.util.PropsUtil.get(
				"lock.expiration.time.com.intranet.mef.job.siap.model.MealTicket"));

	public MealTicketModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _custom_key;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCustom_key(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_key;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return MealTicket.class;
	}

	@Override
	public String getModelClassName() {
		return MealTicket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("custom_key", getCustom_key());
		attributes.put("personID", getPersonID());
		attributes.put("month", getMonth());
		attributes.put("dueMeal", getDueMeal());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String custom_key = (String)attributes.get("custom_key");

		if (custom_key != null) {
			setCustom_key(custom_key);
		}

		Long personID = (Long)attributes.get("personID");

		if (personID != null) {
			setPersonID(personID);
		}

		String month = (String)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer dueMeal = (Integer)attributes.get("dueMeal");

		if (dueMeal != null) {
			setDueMeal(dueMeal);
		}
	}

	@JSON
	@Override
	public String getCustom_key() {
		if (_custom_key == null) {
			return StringPool.BLANK;
		}
		else {
			return _custom_key;
		}
	}

	@Override
	public void setCustom_key(String custom_key) {
		_custom_key = custom_key;
	}

	@JSON
	@Override
	public long getPersonID() {
		return _personID;
	}

	@Override
	public void setPersonID(long personID) {
		_columnBitmask |= PERSONID_COLUMN_BITMASK;

		if (!_setOriginalPersonID) {
			_setOriginalPersonID = true;

			_originalPersonID = _personID;
		}

		_personID = personID;
	}

	public long getOriginalPersonID() {
		return _originalPersonID;
	}

	@JSON
	@Override
	public String getMonth() {
		if (_month == null) {
			return StringPool.BLANK;
		}
		else {
			return _month;
		}
	}

	@Override
	public void setMonth(String month) {
		_month = month;
	}

	@JSON
	@Override
	public int getDueMeal() {
		return _dueMeal;
	}

	@Override
	public void setDueMeal(int dueMeal) {
		_dueMeal = dueMeal;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public MealTicket toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MealTicket)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MealTicketImpl mealTicketImpl = new MealTicketImpl();

		mealTicketImpl.setCustom_key(getCustom_key());
		mealTicketImpl.setPersonID(getPersonID());
		mealTicketImpl.setMonth(getMonth());
		mealTicketImpl.setDueMeal(getDueMeal());

		mealTicketImpl.resetOriginalValues();

		return mealTicketImpl;
	}

	@Override
	public int compareTo(MealTicket mealTicket) {
		String primaryKey = mealTicket.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MealTicket)) {
			return false;
		}

		MealTicket mealTicket = (MealTicket)obj;

		String primaryKey = mealTicket.getPrimaryKey();

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
		MealTicketModelImpl mealTicketModelImpl = this;

		mealTicketModelImpl._originalPersonID = mealTicketModelImpl._personID;

		mealTicketModelImpl._setOriginalPersonID = false;

		mealTicketModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MealTicket> toCacheModel() {
		MealTicketCacheModel mealTicketCacheModel = new MealTicketCacheModel();

		mealTicketCacheModel.custom_key = getCustom_key();

		String custom_key = mealTicketCacheModel.custom_key;

		if ((custom_key != null) && (custom_key.length() == 0)) {
			mealTicketCacheModel.custom_key = null;
		}

		mealTicketCacheModel.personID = getPersonID();

		mealTicketCacheModel.month = getMonth();

		String month = mealTicketCacheModel.month;

		if ((month != null) && (month.length() == 0)) {
			mealTicketCacheModel.month = null;
		}

		mealTicketCacheModel.dueMeal = getDueMeal();

		return mealTicketCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{custom_key=");
		sb.append(getCustom_key());
		sb.append(", personID=");
		sb.append(getPersonID());
		sb.append(", month=");
		sb.append(getMonth());
		sb.append(", dueMeal=");
		sb.append(getDueMeal());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.intranet.mef.job.siap.model.MealTicket");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>custom_key</column-name><column-value><![CDATA[");
		sb.append(getCustom_key());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personID</column-name><column-value><![CDATA[");
		sb.append(getPersonID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>month</column-name><column-value><![CDATA[");
		sb.append(getMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueMeal</column-name><column-value><![CDATA[");
		sb.append(getDueMeal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = MealTicket.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			MealTicket.class
		};
	private String _custom_key;
	private long _personID;
	private long _originalPersonID;
	private boolean _setOriginalPersonID;
	private String _month;
	private int _dueMeal;
	private long _columnBitmask;
	private MealTicket _escapedModel;
}