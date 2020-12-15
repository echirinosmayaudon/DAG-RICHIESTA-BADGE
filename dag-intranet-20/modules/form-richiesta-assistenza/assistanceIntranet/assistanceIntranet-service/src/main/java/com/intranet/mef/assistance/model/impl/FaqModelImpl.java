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

package com.intranet.mef.assistance.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.model.Faq;
import com.intranet.mef.assistance.model.FaqModel;
import com.intranet.mef.assistance.service.persistence.FaqPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Faq service. Represents a row in the &quot;Assistance_Faq&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link FaqModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FaqImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FaqImpl
 * @see Faq
 * @see FaqModel
 * @generated
 */
@ProviderType
public class FaqModelImpl extends BaseModelImpl<Faq> implements FaqModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a faq model instance should use the {@link Faq} interface instead.
	 */
	public static final String TABLE_NAME = "Assistance_Faq";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "faqId", Types.VARCHAR },
			{ "siebelId", Types.VARCHAR },
			{ "questions", Types.CLOB },
			{ "response", Types.CLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("faqId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("siebelId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("questions", Types.CLOB);
		TABLE_COLUMNS_MAP.put("response", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table Assistance_Faq (uuid_ VARCHAR(75) null,faqId VARCHAR(75) not null,siebelId VARCHAR(75) not null,questions TEXT null,response TEXT null,primary key (faqId, siebelId))";
	public static final String TABLE_SQL_DROP = "drop table Assistance_Faq";
	public static final String ORDER_BY_JPQL = " ORDER BY faq.id.faqId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Assistance_Faq.faqId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.intranet.mef.assistance.model.Faq"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.intranet.mef.assistance.model.Faq"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.intranet.mef.assistance.model.Faq"),
			true);
	public static final long FAQID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.intranet.mef.assistance.service.util.ServiceProps.get(
				"lock.expiration.time.com.intranet.mef.assistance.model.Faq"));

	public FaqModelImpl() {
	}

	@Override
	public FaqPK getPrimaryKey() {
		return new FaqPK(_faqId, _siebelId);
	}

	@Override
	public void setPrimaryKey(FaqPK primaryKey) {
		setFaqId(primaryKey.faqId);
		setSiebelId(primaryKey.siebelId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new FaqPK(_faqId, _siebelId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((FaqPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Faq.class;
	}

	@Override
	public String getModelClassName() {
		return Faq.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("faqId", getFaqId());
		attributes.put("siebelId", getSiebelId());
		attributes.put("questions", getQuestions());
		attributes.put("response", getResponse());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String faqId = (String)attributes.get("faqId");

		if (faqId != null) {
			setFaqId(faqId);
		}

		String siebelId = (String)attributes.get("siebelId");

		if (siebelId != null) {
			setSiebelId(siebelId);
		}

		String questions = (String)attributes.get("questions");

		if (questions != null) {
			setQuestions(questions);
		}

		String response = (String)attributes.get("response");

		if (response != null) {
			setResponse(response);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public String getFaqId() {
		if (_faqId == null) {
			return StringPool.BLANK;
		}
		else {
			return _faqId;
		}
	}

	@Override
	public void setFaqId(String faqId) {
		_columnBitmask = -1L;

		if (_originalFaqId == null) {
			_originalFaqId = _faqId;
		}

		_faqId = faqId;
	}

	public String getOriginalFaqId() {
		return GetterUtil.getString(_originalFaqId);
	}

	@Override
	public String getSiebelId() {
		if (_siebelId == null) {
			return StringPool.BLANK;
		}
		else {
			return _siebelId;
		}
	}

	@Override
	public void setSiebelId(String siebelId) {
		_siebelId = siebelId;
	}

	@Override
	public String getQuestions() {
		if (_questions == null) {
			return StringPool.BLANK;
		}
		else {
			return _questions;
		}
	}

	@Override
	public void setQuestions(String questions) {
		_questions = questions;
	}

	@Override
	public String getResponse() {
		if (_response == null) {
			return StringPool.BLANK;
		}
		else {
			return _response;
		}
	}

	@Override
	public void setResponse(String response) {
		_response = response;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Faq toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Faq)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FaqImpl faqImpl = new FaqImpl();

		faqImpl.setUuid(getUuid());
		faqImpl.setFaqId(getFaqId());
		faqImpl.setSiebelId(getSiebelId());
		faqImpl.setQuestions(getQuestions());
		faqImpl.setResponse(getResponse());

		faqImpl.resetOriginalValues();

		return faqImpl;
	}

	@Override
	public int compareTo(Faq faq) {
		int value = 0;

		value = getFaqId().compareTo(faq.getFaqId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Faq)) {
			return false;
		}

		Faq faq = (Faq)obj;

		FaqPK primaryKey = faq.getPrimaryKey();

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
		FaqModelImpl faqModelImpl = this;

		faqModelImpl._originalUuid = faqModelImpl._uuid;

		faqModelImpl._originalFaqId = faqModelImpl._faqId;

		faqModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Faq> toCacheModel() {
		FaqCacheModel faqCacheModel = new FaqCacheModel();

		faqCacheModel.faqPK = getPrimaryKey();

		faqCacheModel.uuid = getUuid();

		String uuid = faqCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			faqCacheModel.uuid = null;
		}

		faqCacheModel.faqId = getFaqId();

		String faqId = faqCacheModel.faqId;

		if ((faqId != null) && (faqId.length() == 0)) {
			faqCacheModel.faqId = null;
		}

		faqCacheModel.siebelId = getSiebelId();

		String siebelId = faqCacheModel.siebelId;

		if ((siebelId != null) && (siebelId.length() == 0)) {
			faqCacheModel.siebelId = null;
		}

		faqCacheModel.questions = getQuestions();

		String questions = faqCacheModel.questions;

		if ((questions != null) && (questions.length() == 0)) {
			faqCacheModel.questions = null;
		}

		faqCacheModel.response = getResponse();

		String response = faqCacheModel.response;

		if ((response != null) && (response.length() == 0)) {
			faqCacheModel.response = null;
		}

		return faqCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", faqId=");
		sb.append(getFaqId());
		sb.append(", siebelId=");
		sb.append(getSiebelId());
		sb.append(", questions=");
		sb.append(getQuestions());
		sb.append(", response=");
		sb.append(getResponse());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.intranet.mef.assistance.model.Faq");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>faqId</column-name><column-value><![CDATA[");
		sb.append(getFaqId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siebelId</column-name><column-value><![CDATA[");
		sb.append(getSiebelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questions</column-name><column-value><![CDATA[");
		sb.append(getQuestions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>response</column-name><column-value><![CDATA[");
		sb.append(getResponse());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Faq.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Faq.class
		};
	private String _uuid;
	private String _originalUuid;
	private String _faqId;
	private String _originalFaqId;
	private String _siebelId;
	private String _questions;
	private String _response;
	private long _columnBitmask;
	private Faq _escapedModel;
}