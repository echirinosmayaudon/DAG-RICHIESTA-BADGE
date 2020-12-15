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

import com.intranet.mef.job.siap.model.OvertimeBalance;
import com.intranet.mef.job.siap.model.OvertimeBalanceModel;
import com.intranet.mef.job.siap.model.OvertimeBalanceSoap;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the OvertimeBalance service. Represents a row in the &quot;LF_VIEW_SALDO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link OvertimeBalanceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OvertimeBalanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OvertimeBalanceImpl
 * @see OvertimeBalance
 * @see OvertimeBalanceModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class OvertimeBalanceModelImpl extends BaseModelImpl<OvertimeBalance>
	implements OvertimeBalanceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a overtime balance model instance should use the {@link OvertimeBalance} interface instead.
	 */
	public static final String TABLE_NAME = "LF_VIEW_SALDO";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STR_MESE_RIF_CORR", Types.VARCHAR },
			{ "PERSON_ID", Types.BIGINT },
			{ "STR_SALDO_ORE_MESE_CORR", Types.INTEGER },
			{ "STR_SALDO_ORE_MESE_PREC", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("STR_MESE_RIF_CORR", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PERSON_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("STR_SALDO_ORE_MESE_CORR", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("STR_SALDO_ORE_MESE_PREC", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table LF_VIEW_SALDO (STR_MESE_RIF_CORR VARCHAR(75) null,PERSON_ID LONG not null primary key,STR_SALDO_ORE_MESE_CORR INTEGER,STR_SALDO_ORE_MESE_PREC INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table LF_VIEW_SALDO";
	public static final String ORDER_BY_JPQL = " ORDER BY overtimeBalance.personId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LF_VIEW_SALDO.PERSON_ID ASC";
	public static final String DATA_SOURCE = "stage";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.intranet.mef.job.siap.model.OvertimeBalance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.intranet.mef.job.siap.model.OvertimeBalance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static OvertimeBalance toModel(OvertimeBalanceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		OvertimeBalance model = new OvertimeBalanceImpl();

		model.setOvertimeMonthCurrRif(soapModel.getOvertimeMonthCurrRif());
		model.setPersonId(soapModel.getPersonId());
		model.setOvertimeBalHourCurMonth(soapModel.getOvertimeBalHourCurMonth());
		model.setOvertimeBalacePrevMonth(soapModel.getOvertimeBalacePrevMonth());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<OvertimeBalance> toModels(
		OvertimeBalanceSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<OvertimeBalance> models = new ArrayList<OvertimeBalance>(soapModels.length);

		for (OvertimeBalanceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.intranet.mef.service.util.PropsUtil.get(
				"lock.expiration.time.com.intranet.mef.job.siap.model.OvertimeBalance"));

	public OvertimeBalanceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _personId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPersonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _personId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OvertimeBalance.class;
	}

	@Override
	public String getModelClassName() {
		return OvertimeBalance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("overtimeMonthCurrRif", getOvertimeMonthCurrRif());
		attributes.put("personId", getPersonId());
		attributes.put("overtimeBalHourCurMonth", getOvertimeBalHourCurMonth());
		attributes.put("overtimeBalacePrevMonth", getOvertimeBalacePrevMonth());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String overtimeMonthCurrRif = (String)attributes.get(
				"overtimeMonthCurrRif");

		if (overtimeMonthCurrRif != null) {
			setOvertimeMonthCurrRif(overtimeMonthCurrRif);
		}

		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Integer overtimeBalHourCurMonth = (Integer)attributes.get(
				"overtimeBalHourCurMonth");

		if (overtimeBalHourCurMonth != null) {
			setOvertimeBalHourCurMonth(overtimeBalHourCurMonth);
		}

		Integer overtimeBalacePrevMonth = (Integer)attributes.get(
				"overtimeBalacePrevMonth");

		if (overtimeBalacePrevMonth != null) {
			setOvertimeBalacePrevMonth(overtimeBalacePrevMonth);
		}
	}

	@JSON
	@Override
	public String getOvertimeMonthCurrRif() {
		if (_overtimeMonthCurrRif == null) {
			return StringPool.BLANK;
		}
		else {
			return _overtimeMonthCurrRif;
		}
	}

	@Override
	public void setOvertimeMonthCurrRif(String overtimeMonthCurrRif) {
		_overtimeMonthCurrRif = overtimeMonthCurrRif;
	}

	@JSON
	@Override
	public long getPersonId() {
		return _personId;
	}

	@Override
	public void setPersonId(long personId) {
		_personId = personId;
	}

	@JSON
	@Override
	public int getOvertimeBalHourCurMonth() {
		return _overtimeBalHourCurMonth;
	}

	@Override
	public void setOvertimeBalHourCurMonth(int overtimeBalHourCurMonth) {
		_overtimeBalHourCurMonth = overtimeBalHourCurMonth;
	}

	@JSON
	@Override
	public int getOvertimeBalacePrevMonth() {
		return _overtimeBalacePrevMonth;
	}

	@Override
	public void setOvertimeBalacePrevMonth(int overtimeBalacePrevMonth) {
		_overtimeBalacePrevMonth = overtimeBalacePrevMonth;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			OvertimeBalance.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OvertimeBalance toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OvertimeBalance)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OvertimeBalanceImpl overtimeBalanceImpl = new OvertimeBalanceImpl();

		overtimeBalanceImpl.setOvertimeMonthCurrRif(getOvertimeMonthCurrRif());
		overtimeBalanceImpl.setPersonId(getPersonId());
		overtimeBalanceImpl.setOvertimeBalHourCurMonth(getOvertimeBalHourCurMonth());
		overtimeBalanceImpl.setOvertimeBalacePrevMonth(getOvertimeBalacePrevMonth());

		overtimeBalanceImpl.resetOriginalValues();

		return overtimeBalanceImpl;
	}

	@Override
	public int compareTo(OvertimeBalance overtimeBalance) {
		long primaryKey = overtimeBalance.getPrimaryKey();

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

		if (!(obj instanceof OvertimeBalance)) {
			return false;
		}

		OvertimeBalance overtimeBalance = (OvertimeBalance)obj;

		long primaryKey = overtimeBalance.getPrimaryKey();

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
	public CacheModel<OvertimeBalance> toCacheModel() {
		OvertimeBalanceCacheModel overtimeBalanceCacheModel = new OvertimeBalanceCacheModel();

		overtimeBalanceCacheModel.overtimeMonthCurrRif = getOvertimeMonthCurrRif();

		String overtimeMonthCurrRif = overtimeBalanceCacheModel.overtimeMonthCurrRif;

		if ((overtimeMonthCurrRif != null) &&
				(overtimeMonthCurrRif.length() == 0)) {
			overtimeBalanceCacheModel.overtimeMonthCurrRif = null;
		}

		overtimeBalanceCacheModel.personId = getPersonId();

		overtimeBalanceCacheModel.overtimeBalHourCurMonth = getOvertimeBalHourCurMonth();

		overtimeBalanceCacheModel.overtimeBalacePrevMonth = getOvertimeBalacePrevMonth();

		return overtimeBalanceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{overtimeMonthCurrRif=");
		sb.append(getOvertimeMonthCurrRif());
		sb.append(", personId=");
		sb.append(getPersonId());
		sb.append(", overtimeBalHourCurMonth=");
		sb.append(getOvertimeBalHourCurMonth());
		sb.append(", overtimeBalacePrevMonth=");
		sb.append(getOvertimeBalacePrevMonth());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.intranet.mef.job.siap.model.OvertimeBalance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>overtimeMonthCurrRif</column-name><column-value><![CDATA[");
		sb.append(getOvertimeMonthCurrRif());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personId</column-name><column-value><![CDATA[");
		sb.append(getPersonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>overtimeBalHourCurMonth</column-name><column-value><![CDATA[");
		sb.append(getOvertimeBalHourCurMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>overtimeBalacePrevMonth</column-name><column-value><![CDATA[");
		sb.append(getOvertimeBalacePrevMonth());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = OvertimeBalance.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			OvertimeBalance.class
		};
	private String _overtimeMonthCurrRif;
	private long _personId;
	private int _overtimeBalHourCurMonth;
	private int _overtimeBalacePrevMonth;
	private OvertimeBalance _escapedModel;
}