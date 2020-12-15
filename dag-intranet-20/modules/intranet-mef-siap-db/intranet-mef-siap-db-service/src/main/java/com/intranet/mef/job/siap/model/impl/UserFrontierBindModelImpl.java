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

import com.intranet.mef.job.siap.model.UserFrontierBind;
import com.intranet.mef.job.siap.model.UserFrontierBindModel;
import com.intranet.mef.job.siap.model.UserFrontierBindSoap;
import com.intranet.mef.job.siap.service.persistence.UserFrontierBindPK;

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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UserFrontierBind service. Represents a row in the &quot;LF_FRONTIERA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UserFrontierBindModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserFrontierBindImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFrontierBindImpl
 * @see UserFrontierBind
 * @see UserFrontierBindModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class UserFrontierBindModelImpl extends BaseModelImpl<UserFrontierBind>
	implements UserFrontierBindModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user frontier bind model instance should use the {@link UserFrontierBind} interface instead.
	 */
	public static final String TABLE_NAME = "LF_FRONTIERA";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PERSON_ID", Types.BIGINT },
			{ "ORGANIZATION_ID", Types.BIGINT },
			{ "ID_DIRIGENTE", Types.BIGINT },
			{ "DATA_ULTIMA_ASSUNZIONE", Types.TIMESTAMP },
			{ "DATA_START", Types.TIMESTAMP },
			{ "DATA_INIZIO_INQ", Types.TIMESTAMP },
			{ "DATA_IMM_FUNZIONE", Types.TIMESTAMP },
			{ "LEVEL_ID", Types.BIGINT },
			{ "CODICE_FISCALE", Types.VARCHAR },
			{ "NOME", Types.VARCHAR },
			{ "COGNOME", Types.VARCHAR },
			{ "SESSO", Types.VARCHAR },
			{ "EMAIL", Types.VARCHAR },
			{ "COMUNE_STATO_ESTERO_NASCITA", Types.VARCHAR },
			{ "DATA_NASCITA", Types.TIMESTAMP },
			{ "PHONE_MOBILE", Types.VARCHAR },
			{ "PHONE_WORK", Types.VARCHAR },
			{ "PHONE_FAX", Types.VARCHAR },
			{ "INDIRIZZO", Types.VARCHAR },
			{ "POSTAL_CODE", Types.VARCHAR },
			{ "TOWN_OR_CITY", Types.VARCHAR },
			{ "PIANO_ID", Types.VARCHAR },
			{ "STANZA_ID", Types.VARCHAR },
			{ "SCALA_CORPO_ID", Types.VARCHAR },
			{ "CORRIDOIO_ID", Types.VARCHAR },
			{ "SETTORE_ID", Types.VARCHAR },
			{ "POS_GIU", Types.VARCHAR },
			{ "POS_ECO", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PERSON_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ORGANIZATION_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ID_DIRIGENTE", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DATA_ULTIMA_ASSUNZIONE", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("DATA_START", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("DATA_INIZIO_INQ", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("DATA_IMM_FUNZIONE", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("LEVEL_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CODICE_FISCALE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NOME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("COGNOME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SESSO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("EMAIL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("COMUNE_STATO_ESTERO_NASCITA", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("DATA_NASCITA", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("PHONE_MOBILE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PHONE_WORK", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PHONE_FAX", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("INDIRIZZO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("POSTAL_CODE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("TOWN_OR_CITY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PIANO_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("STANZA_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SCALA_CORPO_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CORRIDOIO_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SETTORE_ID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("POS_GIU", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("POS_ECO", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table LF_FRONTIERA (PERSON_ID LONG not null,ORGANIZATION_ID LONG,ID_DIRIGENTE LONG,DATA_ULTIMA_ASSUNZIONE DATE null,DATA_START DATE null,DATA_INIZIO_INQ DATE null,DATA_IMM_FUNZIONE DATE null,LEVEL_ID LONG,CODICE_FISCALE VARCHAR(75) not null,NOME VARCHAR(75) null,COGNOME VARCHAR(75) null,SESSO VARCHAR(75) null,EMAIL VARCHAR(75) null,COMUNE_STATO_ESTERO_NASCITA VARCHAR(75) null,DATA_NASCITA DATE null,PHONE_MOBILE VARCHAR(75) null,PHONE_WORK VARCHAR(75) null,PHONE_FAX VARCHAR(75) null,INDIRIZZO VARCHAR(75) null,POSTAL_CODE VARCHAR(75) null,TOWN_OR_CITY VARCHAR(75) null,PIANO_ID VARCHAR(75) null,STANZA_ID VARCHAR(75) null,SCALA_CORPO_ID VARCHAR(75) null,CORRIDOIO_ID VARCHAR(75) null,SETTORE_ID VARCHAR(75) null,POS_GIU VARCHAR(75) null,POS_ECO VARCHAR(75) null,primary key (PERSON_ID, CODICE_FISCALE))";
	public static final String TABLE_SQL_DROP = "drop table LF_FRONTIERA";
	public static final String ORDER_BY_JPQL = " ORDER BY userFrontierBind.id.personalId ASC, userFrontierBind.id.screenName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LF_FRONTIERA.PERSON_ID ASC, LF_FRONTIERA.CODICE_FISCALE ASC";
	public static final String DATA_SOURCE = "stage";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.intranet.mef.job.siap.model.UserFrontierBind"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.intranet.mef.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.intranet.mef.job.siap.model.UserFrontierBind"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserFrontierBind toModel(UserFrontierBindSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserFrontierBind model = new UserFrontierBindImpl();

		model.setPersonalId(soapModel.getPersonalId());
		model.setIdOrgChart(soapModel.getIdOrgChart());
		model.setIdDirector(soapModel.getIdDirector());
		model.setDateRecruitment(soapModel.getDateRecruitment());
		model.setDateStartAssignOffice(soapModel.getDateStartAssignOffice());
		model.setDateStartInquadramento(soapModel.getDateStartInquadramento());
		model.setDateStartFunction(soapModel.getDateStartFunction());
		model.setLevelId(soapModel.getLevelId());
		model.setScreenName(soapModel.getScreenName());
		model.setName(soapModel.getName());
		model.setSurName(soapModel.getSurName());
		model.setGender(soapModel.getGender());
		model.setEmail(soapModel.getEmail());
		model.setCodIstatBirth(soapModel.getCodIstatBirth());
		model.setDateBirth(soapModel.getDateBirth());
		model.setPersonalPhone(soapModel.getPersonalPhone());
		model.setWorkPhone(soapModel.getWorkPhone());
		model.setWorkFax(soapModel.getWorkFax());
		model.setPersonalStreet(soapModel.getPersonalStreet());
		model.setPersonalPostalCode(soapModel.getPersonalPostalCode());
		model.setPersonalCity(soapModel.getPersonalCity());
		model.setOfficeStreet1(soapModel.getOfficeStreet1());
		model.setOfficeStreet2(soapModel.getOfficeStreet2());
		model.setOfficeStreet3(soapModel.getOfficeStreet3());
		model.setOfficePostalCode(soapModel.getOfficePostalCode());
		model.setOfficeCity(soapModel.getOfficeCity());
		model.setGiuridicPos(soapModel.getGiuridicPos());
		model.setEconomicPos(soapModel.getEconomicPos());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserFrontierBind> toModels(
		UserFrontierBindSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserFrontierBind> models = new ArrayList<UserFrontierBind>(soapModels.length);

		for (UserFrontierBindSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.intranet.mef.service.util.PropsUtil.get(
				"lock.expiration.time.com.intranet.mef.job.siap.model.UserFrontierBind"));

	public UserFrontierBindModelImpl() {
	}

	@Override
	public UserFrontierBindPK getPrimaryKey() {
		return new UserFrontierBindPK(_personalId, _screenName);
	}

	@Override
	public void setPrimaryKey(UserFrontierBindPK primaryKey) {
		setPersonalId(primaryKey.personalId);
		setScreenName(primaryKey.screenName);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserFrontierBindPK(_personalId, _screenName);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserFrontierBindPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserFrontierBind.class;
	}

	@Override
	public String getModelClassName() {
		return UserFrontierBind.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personalId", getPersonalId());
		attributes.put("idOrgChart", getIdOrgChart());
		attributes.put("idDirector", getIdDirector());
		attributes.put("dateRecruitment", getDateRecruitment());
		attributes.put("dateStartAssignOffice", getDateStartAssignOffice());
		attributes.put("dateStartInquadramento", getDateStartInquadramento());
		attributes.put("dateStartFunction", getDateStartFunction());
		attributes.put("levelId", getLevelId());
		attributes.put("screenName", getScreenName());
		attributes.put("name", getName());
		attributes.put("surName", getSurName());
		attributes.put("gender", getGender());
		attributes.put("email", getEmail());
		attributes.put("codIstatBirth", getCodIstatBirth());
		attributes.put("dateBirth", getDateBirth());
		attributes.put("personalPhone", getPersonalPhone());
		attributes.put("workPhone", getWorkPhone());
		attributes.put("workFax", getWorkFax());
		attributes.put("personalStreet", getPersonalStreet());
		attributes.put("personalPostalCode", getPersonalPostalCode());
		attributes.put("personalCity", getPersonalCity());
		attributes.put("officeStreet1", getOfficeStreet1());
		attributes.put("officeStreet2", getOfficeStreet2());
		attributes.put("officeStreet3", getOfficeStreet3());
		attributes.put("officePostalCode", getOfficePostalCode());
		attributes.put("officeCity", getOfficeCity());
		attributes.put("giuridicPos", getGiuridicPos());
		attributes.put("economicPos", getEconomicPos());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personalId = (Long)attributes.get("personalId");

		if (personalId != null) {
			setPersonalId(personalId);
		}

		Long idOrgChart = (Long)attributes.get("idOrgChart");

		if (idOrgChart != null) {
			setIdOrgChart(idOrgChart);
		}

		Long idDirector = (Long)attributes.get("idDirector");

		if (idDirector != null) {
			setIdDirector(idDirector);
		}

		Date dateRecruitment = (Date)attributes.get("dateRecruitment");

		if (dateRecruitment != null) {
			setDateRecruitment(dateRecruitment);
		}

		Date dateStartAssignOffice = (Date)attributes.get(
				"dateStartAssignOffice");

		if (dateStartAssignOffice != null) {
			setDateStartAssignOffice(dateStartAssignOffice);
		}

		Date dateStartInquadramento = (Date)attributes.get(
				"dateStartInquadramento");

		if (dateStartInquadramento != null) {
			setDateStartInquadramento(dateStartInquadramento);
		}

		Date dateStartFunction = (Date)attributes.get("dateStartFunction");

		if (dateStartFunction != null) {
			setDateStartFunction(dateStartFunction);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String surName = (String)attributes.get("surName");

		if (surName != null) {
			setSurName(surName);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String codIstatBirth = (String)attributes.get("codIstatBirth");

		if (codIstatBirth != null) {
			setCodIstatBirth(codIstatBirth);
		}

		Date dateBirth = (Date)attributes.get("dateBirth");

		if (dateBirth != null) {
			setDateBirth(dateBirth);
		}

		String personalPhone = (String)attributes.get("personalPhone");

		if (personalPhone != null) {
			setPersonalPhone(personalPhone);
		}

		String workPhone = (String)attributes.get("workPhone");

		if (workPhone != null) {
			setWorkPhone(workPhone);
		}

		String workFax = (String)attributes.get("workFax");

		if (workFax != null) {
			setWorkFax(workFax);
		}

		String personalStreet = (String)attributes.get("personalStreet");

		if (personalStreet != null) {
			setPersonalStreet(personalStreet);
		}

		String personalPostalCode = (String)attributes.get("personalPostalCode");

		if (personalPostalCode != null) {
			setPersonalPostalCode(personalPostalCode);
		}

		String personalCity = (String)attributes.get("personalCity");

		if (personalCity != null) {
			setPersonalCity(personalCity);
		}

		String officeStreet1 = (String)attributes.get("officeStreet1");

		if (officeStreet1 != null) {
			setOfficeStreet1(officeStreet1);
		}

		String officeStreet2 = (String)attributes.get("officeStreet2");

		if (officeStreet2 != null) {
			setOfficeStreet2(officeStreet2);
		}

		String officeStreet3 = (String)attributes.get("officeStreet3");

		if (officeStreet3 != null) {
			setOfficeStreet3(officeStreet3);
		}

		String officePostalCode = (String)attributes.get("officePostalCode");

		if (officePostalCode != null) {
			setOfficePostalCode(officePostalCode);
		}

		String officeCity = (String)attributes.get("officeCity");

		if (officeCity != null) {
			setOfficeCity(officeCity);
		}

		String giuridicPos = (String)attributes.get("giuridicPos");

		if (giuridicPos != null) {
			setGiuridicPos(giuridicPos);
		}

		String economicPos = (String)attributes.get("economicPos");

		if (economicPos != null) {
			setEconomicPos(economicPos);
		}
	}

	@JSON
	@Override
	public long getPersonalId() {
		return _personalId;
	}

	@Override
	public void setPersonalId(long personalId) {
		_personalId = personalId;
	}

	@JSON
	@Override
	public long getIdOrgChart() {
		return _idOrgChart;
	}

	@Override
	public void setIdOrgChart(long idOrgChart) {
		_idOrgChart = idOrgChart;
	}

	@JSON
	@Override
	public long getIdDirector() {
		return _idDirector;
	}

	@Override
	public void setIdDirector(long idDirector) {
		_idDirector = idDirector;
	}

	@JSON
	@Override
	public Date getDateRecruitment() {
		return _dateRecruitment;
	}

	@Override
	public void setDateRecruitment(Date dateRecruitment) {
		_dateRecruitment = dateRecruitment;
	}

	@JSON
	@Override
	public Date getDateStartAssignOffice() {
		return _dateStartAssignOffice;
	}

	@Override
	public void setDateStartAssignOffice(Date dateStartAssignOffice) {
		_dateStartAssignOffice = dateStartAssignOffice;
	}

	@JSON
	@Override
	public Date getDateStartInquadramento() {
		return _dateStartInquadramento;
	}

	@Override
	public void setDateStartInquadramento(Date dateStartInquadramento) {
		_dateStartInquadramento = dateStartInquadramento;
	}

	@JSON
	@Override
	public Date getDateStartFunction() {
		return _dateStartFunction;
	}

	@Override
	public void setDateStartFunction(Date dateStartFunction) {
		_dateStartFunction = dateStartFunction;
	}

	@JSON
	@Override
	public long getLevelId() {
		return _levelId;
	}

	@Override
	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	@JSON
	@Override
	public String getScreenName() {
		if (_screenName == null) {
			return StringPool.BLANK;
		}
		else {
			return _screenName;
		}
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getSurName() {
		if (_surName == null) {
			return StringPool.BLANK;
		}
		else {
			return _surName;
		}
	}

	@Override
	public void setSurName(String surName) {
		_surName = surName;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return StringPool.BLANK;
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;
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
		_email = email;
	}

	@JSON
	@Override
	public String getCodIstatBirth() {
		if (_codIstatBirth == null) {
			return StringPool.BLANK;
		}
		else {
			return _codIstatBirth;
		}
	}

	@Override
	public void setCodIstatBirth(String codIstatBirth) {
		_codIstatBirth = codIstatBirth;
	}

	@JSON
	@Override
	public Date getDateBirth() {
		return _dateBirth;
	}

	@Override
	public void setDateBirth(Date dateBirth) {
		_dateBirth = dateBirth;
	}

	@JSON
	@Override
	public String getPersonalPhone() {
		if (_personalPhone == null) {
			return StringPool.BLANK;
		}
		else {
			return _personalPhone;
		}
	}

	@Override
	public void setPersonalPhone(String personalPhone) {
		_personalPhone = personalPhone;
	}

	@JSON
	@Override
	public String getWorkPhone() {
		if (_workPhone == null) {
			return StringPool.BLANK;
		}
		else {
			return _workPhone;
		}
	}

	@Override
	public void setWorkPhone(String workPhone) {
		_workPhone = workPhone;
	}

	@JSON
	@Override
	public String getWorkFax() {
		if (_workFax == null) {
			return StringPool.BLANK;
		}
		else {
			return _workFax;
		}
	}

	@Override
	public void setWorkFax(String workFax) {
		_workFax = workFax;
	}

	@JSON
	@Override
	public String getPersonalStreet() {
		if (_personalStreet == null) {
			return StringPool.BLANK;
		}
		else {
			return _personalStreet;
		}
	}

	@Override
	public void setPersonalStreet(String personalStreet) {
		_personalStreet = personalStreet;
	}

	@JSON
	@Override
	public String getPersonalPostalCode() {
		if (_personalPostalCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _personalPostalCode;
		}
	}

	@Override
	public void setPersonalPostalCode(String personalPostalCode) {
		_personalPostalCode = personalPostalCode;
	}

	@JSON
	@Override
	public String getPersonalCity() {
		if (_personalCity == null) {
			return StringPool.BLANK;
		}
		else {
			return _personalCity;
		}
	}

	@Override
	public void setPersonalCity(String personalCity) {
		_personalCity = personalCity;
	}

	@JSON
	@Override
	public String getOfficeStreet1() {
		if (_officeStreet1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _officeStreet1;
		}
	}

	@Override
	public void setOfficeStreet1(String officeStreet1) {
		_officeStreet1 = officeStreet1;
	}

	@JSON
	@Override
	public String getOfficeStreet2() {
		if (_officeStreet2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _officeStreet2;
		}
	}

	@Override
	public void setOfficeStreet2(String officeStreet2) {
		_officeStreet2 = officeStreet2;
	}

	@JSON
	@Override
	public String getOfficeStreet3() {
		if (_officeStreet3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _officeStreet3;
		}
	}

	@Override
	public void setOfficeStreet3(String officeStreet3) {
		_officeStreet3 = officeStreet3;
	}

	@JSON
	@Override
	public String getOfficePostalCode() {
		if (_officePostalCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _officePostalCode;
		}
	}

	@Override
	public void setOfficePostalCode(String officePostalCode) {
		_officePostalCode = officePostalCode;
	}

	@JSON
	@Override
	public String getOfficeCity() {
		if (_officeCity == null) {
			return StringPool.BLANK;
		}
		else {
			return _officeCity;
		}
	}

	@Override
	public void setOfficeCity(String officeCity) {
		_officeCity = officeCity;
	}

	@JSON
	@Override
	public String getGiuridicPos() {
		if (_giuridicPos == null) {
			return StringPool.BLANK;
		}
		else {
			return _giuridicPos;
		}
	}

	@Override
	public void setGiuridicPos(String giuridicPos) {
		_giuridicPos = giuridicPos;
	}

	@JSON
	@Override
	public String getEconomicPos() {
		if (_economicPos == null) {
			return StringPool.BLANK;
		}
		else {
			return _economicPos;
		}
	}

	@Override
	public void setEconomicPos(String economicPos) {
		_economicPos = economicPos;
	}

	@Override
	public UserFrontierBind toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserFrontierBind)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserFrontierBindImpl userFrontierBindImpl = new UserFrontierBindImpl();

		userFrontierBindImpl.setPersonalId(getPersonalId());
		userFrontierBindImpl.setIdOrgChart(getIdOrgChart());
		userFrontierBindImpl.setIdDirector(getIdDirector());
		userFrontierBindImpl.setDateRecruitment(getDateRecruitment());
		userFrontierBindImpl.setDateStartAssignOffice(getDateStartAssignOffice());
		userFrontierBindImpl.setDateStartInquadramento(getDateStartInquadramento());
		userFrontierBindImpl.setDateStartFunction(getDateStartFunction());
		userFrontierBindImpl.setLevelId(getLevelId());
		userFrontierBindImpl.setScreenName(getScreenName());
		userFrontierBindImpl.setName(getName());
		userFrontierBindImpl.setSurName(getSurName());
		userFrontierBindImpl.setGender(getGender());
		userFrontierBindImpl.setEmail(getEmail());
		userFrontierBindImpl.setCodIstatBirth(getCodIstatBirth());
		userFrontierBindImpl.setDateBirth(getDateBirth());
		userFrontierBindImpl.setPersonalPhone(getPersonalPhone());
		userFrontierBindImpl.setWorkPhone(getWorkPhone());
		userFrontierBindImpl.setWorkFax(getWorkFax());
		userFrontierBindImpl.setPersonalStreet(getPersonalStreet());
		userFrontierBindImpl.setPersonalPostalCode(getPersonalPostalCode());
		userFrontierBindImpl.setPersonalCity(getPersonalCity());
		userFrontierBindImpl.setOfficeStreet1(getOfficeStreet1());
		userFrontierBindImpl.setOfficeStreet2(getOfficeStreet2());
		userFrontierBindImpl.setOfficeStreet3(getOfficeStreet3());
		userFrontierBindImpl.setOfficePostalCode(getOfficePostalCode());
		userFrontierBindImpl.setOfficeCity(getOfficeCity());
		userFrontierBindImpl.setGiuridicPos(getGiuridicPos());
		userFrontierBindImpl.setEconomicPos(getEconomicPos());

		userFrontierBindImpl.resetOriginalValues();

		return userFrontierBindImpl;
	}

	@Override
	public int compareTo(UserFrontierBind userFrontierBind) {
		UserFrontierBindPK primaryKey = userFrontierBind.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserFrontierBind)) {
			return false;
		}

		UserFrontierBind userFrontierBind = (UserFrontierBind)obj;

		UserFrontierBindPK primaryKey = userFrontierBind.getPrimaryKey();

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
	public CacheModel<UserFrontierBind> toCacheModel() {
		UserFrontierBindCacheModel userFrontierBindCacheModel = new UserFrontierBindCacheModel();

		userFrontierBindCacheModel.userFrontierBindPK = getPrimaryKey();

		userFrontierBindCacheModel.personalId = getPersonalId();

		userFrontierBindCacheModel.idOrgChart = getIdOrgChart();

		userFrontierBindCacheModel.idDirector = getIdDirector();

		Date dateRecruitment = getDateRecruitment();

		if (dateRecruitment != null) {
			userFrontierBindCacheModel.dateRecruitment = dateRecruitment.getTime();
		}
		else {
			userFrontierBindCacheModel.dateRecruitment = Long.MIN_VALUE;
		}

		Date dateStartAssignOffice = getDateStartAssignOffice();

		if (dateStartAssignOffice != null) {
			userFrontierBindCacheModel.dateStartAssignOffice = dateStartAssignOffice.getTime();
		}
		else {
			userFrontierBindCacheModel.dateStartAssignOffice = Long.MIN_VALUE;
		}

		Date dateStartInquadramento = getDateStartInquadramento();

		if (dateStartInquadramento != null) {
			userFrontierBindCacheModel.dateStartInquadramento = dateStartInquadramento.getTime();
		}
		else {
			userFrontierBindCacheModel.dateStartInquadramento = Long.MIN_VALUE;
		}

		Date dateStartFunction = getDateStartFunction();

		if (dateStartFunction != null) {
			userFrontierBindCacheModel.dateStartFunction = dateStartFunction.getTime();
		}
		else {
			userFrontierBindCacheModel.dateStartFunction = Long.MIN_VALUE;
		}

		userFrontierBindCacheModel.levelId = getLevelId();

		userFrontierBindCacheModel.screenName = getScreenName();

		String screenName = userFrontierBindCacheModel.screenName;

		if ((screenName != null) && (screenName.length() == 0)) {
			userFrontierBindCacheModel.screenName = null;
		}

		userFrontierBindCacheModel.name = getName();

		String name = userFrontierBindCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			userFrontierBindCacheModel.name = null;
		}

		userFrontierBindCacheModel.surName = getSurName();

		String surName = userFrontierBindCacheModel.surName;

		if ((surName != null) && (surName.length() == 0)) {
			userFrontierBindCacheModel.surName = null;
		}

		userFrontierBindCacheModel.gender = getGender();

		String gender = userFrontierBindCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			userFrontierBindCacheModel.gender = null;
		}

		userFrontierBindCacheModel.email = getEmail();

		String email = userFrontierBindCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			userFrontierBindCacheModel.email = null;
		}

		userFrontierBindCacheModel.codIstatBirth = getCodIstatBirth();

		String codIstatBirth = userFrontierBindCacheModel.codIstatBirth;

		if ((codIstatBirth != null) && (codIstatBirth.length() == 0)) {
			userFrontierBindCacheModel.codIstatBirth = null;
		}

		Date dateBirth = getDateBirth();

		if (dateBirth != null) {
			userFrontierBindCacheModel.dateBirth = dateBirth.getTime();
		}
		else {
			userFrontierBindCacheModel.dateBirth = Long.MIN_VALUE;
		}

		userFrontierBindCacheModel.personalPhone = getPersonalPhone();

		String personalPhone = userFrontierBindCacheModel.personalPhone;

		if ((personalPhone != null) && (personalPhone.length() == 0)) {
			userFrontierBindCacheModel.personalPhone = null;
		}

		userFrontierBindCacheModel.workPhone = getWorkPhone();

		String workPhone = userFrontierBindCacheModel.workPhone;

		if ((workPhone != null) && (workPhone.length() == 0)) {
			userFrontierBindCacheModel.workPhone = null;
		}

		userFrontierBindCacheModel.workFax = getWorkFax();

		String workFax = userFrontierBindCacheModel.workFax;

		if ((workFax != null) && (workFax.length() == 0)) {
			userFrontierBindCacheModel.workFax = null;
		}

		userFrontierBindCacheModel.personalStreet = getPersonalStreet();

		String personalStreet = userFrontierBindCacheModel.personalStreet;

		if ((personalStreet != null) && (personalStreet.length() == 0)) {
			userFrontierBindCacheModel.personalStreet = null;
		}

		userFrontierBindCacheModel.personalPostalCode = getPersonalPostalCode();

		String personalPostalCode = userFrontierBindCacheModel.personalPostalCode;

		if ((personalPostalCode != null) && (personalPostalCode.length() == 0)) {
			userFrontierBindCacheModel.personalPostalCode = null;
		}

		userFrontierBindCacheModel.personalCity = getPersonalCity();

		String personalCity = userFrontierBindCacheModel.personalCity;

		if ((personalCity != null) && (personalCity.length() == 0)) {
			userFrontierBindCacheModel.personalCity = null;
		}

		userFrontierBindCacheModel.officeStreet1 = getOfficeStreet1();

		String officeStreet1 = userFrontierBindCacheModel.officeStreet1;

		if ((officeStreet1 != null) && (officeStreet1.length() == 0)) {
			userFrontierBindCacheModel.officeStreet1 = null;
		}

		userFrontierBindCacheModel.officeStreet2 = getOfficeStreet2();

		String officeStreet2 = userFrontierBindCacheModel.officeStreet2;

		if ((officeStreet2 != null) && (officeStreet2.length() == 0)) {
			userFrontierBindCacheModel.officeStreet2 = null;
		}

		userFrontierBindCacheModel.officeStreet3 = getOfficeStreet3();

		String officeStreet3 = userFrontierBindCacheModel.officeStreet3;

		if ((officeStreet3 != null) && (officeStreet3.length() == 0)) {
			userFrontierBindCacheModel.officeStreet3 = null;
		}

		userFrontierBindCacheModel.officePostalCode = getOfficePostalCode();

		String officePostalCode = userFrontierBindCacheModel.officePostalCode;

		if ((officePostalCode != null) && (officePostalCode.length() == 0)) {
			userFrontierBindCacheModel.officePostalCode = null;
		}

		userFrontierBindCacheModel.officeCity = getOfficeCity();

		String officeCity = userFrontierBindCacheModel.officeCity;

		if ((officeCity != null) && (officeCity.length() == 0)) {
			userFrontierBindCacheModel.officeCity = null;
		}

		userFrontierBindCacheModel.giuridicPos = getGiuridicPos();

		String giuridicPos = userFrontierBindCacheModel.giuridicPos;

		if ((giuridicPos != null) && (giuridicPos.length() == 0)) {
			userFrontierBindCacheModel.giuridicPos = null;
		}

		userFrontierBindCacheModel.economicPos = getEconomicPos();

		String economicPos = userFrontierBindCacheModel.economicPos;

		if ((economicPos != null) && (economicPos.length() == 0)) {
			userFrontierBindCacheModel.economicPos = null;
		}

		return userFrontierBindCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{personalId=");
		sb.append(getPersonalId());
		sb.append(", idOrgChart=");
		sb.append(getIdOrgChart());
		sb.append(", idDirector=");
		sb.append(getIdDirector());
		sb.append(", dateRecruitment=");
		sb.append(getDateRecruitment());
		sb.append(", dateStartAssignOffice=");
		sb.append(getDateStartAssignOffice());
		sb.append(", dateStartInquadramento=");
		sb.append(getDateStartInquadramento());
		sb.append(", dateStartFunction=");
		sb.append(getDateStartFunction());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", surName=");
		sb.append(getSurName());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", codIstatBirth=");
		sb.append(getCodIstatBirth());
		sb.append(", dateBirth=");
		sb.append(getDateBirth());
		sb.append(", personalPhone=");
		sb.append(getPersonalPhone());
		sb.append(", workPhone=");
		sb.append(getWorkPhone());
		sb.append(", workFax=");
		sb.append(getWorkFax());
		sb.append(", personalStreet=");
		sb.append(getPersonalStreet());
		sb.append(", personalPostalCode=");
		sb.append(getPersonalPostalCode());
		sb.append(", personalCity=");
		sb.append(getPersonalCity());
		sb.append(", officeStreet1=");
		sb.append(getOfficeStreet1());
		sb.append(", officeStreet2=");
		sb.append(getOfficeStreet2());
		sb.append(", officeStreet3=");
		sb.append(getOfficeStreet3());
		sb.append(", officePostalCode=");
		sb.append(getOfficePostalCode());
		sb.append(", officeCity=");
		sb.append(getOfficeCity());
		sb.append(", giuridicPos=");
		sb.append(getGiuridicPos());
		sb.append(", economicPos=");
		sb.append(getEconomicPos());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("com.intranet.mef.job.siap.model.UserFrontierBind");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>personalId</column-name><column-value><![CDATA[");
		sb.append(getPersonalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOrgChart</column-name><column-value><![CDATA[");
		sb.append(getIdOrgChart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDirector</column-name><column-value><![CDATA[");
		sb.append(getIdDirector());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateRecruitment</column-name><column-value><![CDATA[");
		sb.append(getDateRecruitment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateStartAssignOffice</column-name><column-value><![CDATA[");
		sb.append(getDateStartAssignOffice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateStartInquadramento</column-name><column-value><![CDATA[");
		sb.append(getDateStartInquadramento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateStartFunction</column-name><column-value><![CDATA[");
		sb.append(getDateStartFunction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surName</column-name><column-value><![CDATA[");
		sb.append(getSurName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codIstatBirth</column-name><column-value><![CDATA[");
		sb.append(getCodIstatBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateBirth</column-name><column-value><![CDATA[");
		sb.append(getDateBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personalPhone</column-name><column-value><![CDATA[");
		sb.append(getPersonalPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workPhone</column-name><column-value><![CDATA[");
		sb.append(getWorkPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workFax</column-name><column-value><![CDATA[");
		sb.append(getWorkFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personalStreet</column-name><column-value><![CDATA[");
		sb.append(getPersonalStreet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personalPostalCode</column-name><column-value><![CDATA[");
		sb.append(getPersonalPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personalCity</column-name><column-value><![CDATA[");
		sb.append(getPersonalCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeStreet1</column-name><column-value><![CDATA[");
		sb.append(getOfficeStreet1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeStreet2</column-name><column-value><![CDATA[");
		sb.append(getOfficeStreet2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeStreet3</column-name><column-value><![CDATA[");
		sb.append(getOfficeStreet3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officePostalCode</column-name><column-value><![CDATA[");
		sb.append(getOfficePostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeCity</column-name><column-value><![CDATA[");
		sb.append(getOfficeCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>giuridicPos</column-name><column-value><![CDATA[");
		sb.append(getGiuridicPos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>economicPos</column-name><column-value><![CDATA[");
		sb.append(getEconomicPos());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = UserFrontierBind.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			UserFrontierBind.class
		};
	private long _personalId;
	private long _idOrgChart;
	private long _idDirector;
	private Date _dateRecruitment;
	private Date _dateStartAssignOffice;
	private Date _dateStartInquadramento;
	private Date _dateStartFunction;
	private long _levelId;
	private String _screenName;
	private String _name;
	private String _surName;
	private String _gender;
	private String _email;
	private String _codIstatBirth;
	private Date _dateBirth;
	private String _personalPhone;
	private String _workPhone;
	private String _workFax;
	private String _personalStreet;
	private String _personalPostalCode;
	private String _personalCity;
	private String _officeStreet1;
	private String _officeStreet2;
	private String _officeStreet3;
	private String _officePostalCode;
	private String _officeCity;
	private String _giuridicPos;
	private String _economicPos;
	private UserFrontierBind _escapedModel;
}