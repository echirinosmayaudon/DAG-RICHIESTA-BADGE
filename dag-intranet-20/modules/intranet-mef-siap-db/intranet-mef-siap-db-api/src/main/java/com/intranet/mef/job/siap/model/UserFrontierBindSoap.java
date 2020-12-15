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

package com.intranet.mef.job.siap.model;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.service.persistence.UserFrontierBindPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.intranet.mef.job.siap.service.http.UserFrontierBindServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.http.UserFrontierBindServiceSoap
 * @generated
 */
@ProviderType
public class UserFrontierBindSoap implements Serializable {
	public static UserFrontierBindSoap toSoapModel(UserFrontierBind model) {
		UserFrontierBindSoap soapModel = new UserFrontierBindSoap();

		soapModel.setPersonalId(model.getPersonalId());
		soapModel.setIdOrgChart(model.getIdOrgChart());
		soapModel.setIdDirector(model.getIdDirector());
		soapModel.setDateRecruitment(model.getDateRecruitment());
		soapModel.setDateStartAssignOffice(model.getDateStartAssignOffice());
		soapModel.setDateStartInquadramento(model.getDateStartInquadramento());
		soapModel.setDateStartFunction(model.getDateStartFunction());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setName(model.getName());
		soapModel.setSurName(model.getSurName());
		soapModel.setGender(model.getGender());
		soapModel.setEmail(model.getEmail());
		soapModel.setCodIstatBirth(model.getCodIstatBirth());
		soapModel.setDateBirth(model.getDateBirth());
		soapModel.setPersonalPhone(model.getPersonalPhone());
		soapModel.setWorkPhone(model.getWorkPhone());
		soapModel.setWorkFax(model.getWorkFax());
		soapModel.setPersonalStreet(model.getPersonalStreet());
		soapModel.setPersonalPostalCode(model.getPersonalPostalCode());
		soapModel.setPersonalCity(model.getPersonalCity());
		soapModel.setOfficeStreet1(model.getOfficeStreet1());
		soapModel.setOfficeStreet2(model.getOfficeStreet2());
		soapModel.setOfficeStreet3(model.getOfficeStreet3());
		soapModel.setOfficePostalCode(model.getOfficePostalCode());
		soapModel.setOfficeCity(model.getOfficeCity());
		soapModel.setGiuridicPos(model.getGiuridicPos());
		soapModel.setEconomicPos(model.getEconomicPos());

		return soapModel;
	}

	public static UserFrontierBindSoap[] toSoapModels(UserFrontierBind[] models) {
		UserFrontierBindSoap[] soapModels = new UserFrontierBindSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserFrontierBindSoap[][] toSoapModels(
		UserFrontierBind[][] models) {
		UserFrontierBindSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserFrontierBindSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserFrontierBindSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserFrontierBindSoap[] toSoapModels(
		List<UserFrontierBind> models) {
		List<UserFrontierBindSoap> soapModels = new ArrayList<UserFrontierBindSoap>(models.size());

		for (UserFrontierBind model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserFrontierBindSoap[soapModels.size()]);
	}

	public UserFrontierBindSoap() {
	}

	public UserFrontierBindPK getPrimaryKey() {
		return new UserFrontierBindPK(_personalId, _screenName);
	}

	public void setPrimaryKey(UserFrontierBindPK pk) {
		setPersonalId(pk.personalId);
		setScreenName(pk.screenName);
	}

	public long getPersonalId() {
		return _personalId;
	}

	public void setPersonalId(long personalId) {
		_personalId = personalId;
	}

	public long getIdOrgChart() {
		return _idOrgChart;
	}

	public void setIdOrgChart(long idOrgChart) {
		_idOrgChart = idOrgChart;
	}

	public long getIdDirector() {
		return _idDirector;
	}

	public void setIdDirector(long idDirector) {
		_idDirector = idDirector;
	}

	public Date getDateRecruitment() {
		return _dateRecruitment;
	}

	public void setDateRecruitment(Date dateRecruitment) {
		_dateRecruitment = dateRecruitment;
	}

	public Date getDateStartAssignOffice() {
		return _dateStartAssignOffice;
	}

	public void setDateStartAssignOffice(Date dateStartAssignOffice) {
		_dateStartAssignOffice = dateStartAssignOffice;
	}

	public Date getDateStartInquadramento() {
		return _dateStartInquadramento;
	}

	public void setDateStartInquadramento(Date dateStartInquadramento) {
		_dateStartInquadramento = dateStartInquadramento;
	}

	public Date getDateStartFunction() {
		return _dateStartFunction;
	}

	public void setDateStartFunction(Date dateStartFunction) {
		_dateStartFunction = dateStartFunction;
	}

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSurName() {
		return _surName;
	}

	public void setSurName(String surName) {
		_surName = surName;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getCodIstatBirth() {
		return _codIstatBirth;
	}

	public void setCodIstatBirth(String codIstatBirth) {
		_codIstatBirth = codIstatBirth;
	}

	public Date getDateBirth() {
		return _dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		_dateBirth = dateBirth;
	}

	public String getPersonalPhone() {
		return _personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		_personalPhone = personalPhone;
	}

	public String getWorkPhone() {
		return _workPhone;
	}

	public void setWorkPhone(String workPhone) {
		_workPhone = workPhone;
	}

	public String getWorkFax() {
		return _workFax;
	}

	public void setWorkFax(String workFax) {
		_workFax = workFax;
	}

	public String getPersonalStreet() {
		return _personalStreet;
	}

	public void setPersonalStreet(String personalStreet) {
		_personalStreet = personalStreet;
	}

	public String getPersonalPostalCode() {
		return _personalPostalCode;
	}

	public void setPersonalPostalCode(String personalPostalCode) {
		_personalPostalCode = personalPostalCode;
	}

	public String getPersonalCity() {
		return _personalCity;
	}

	public void setPersonalCity(String personalCity) {
		_personalCity = personalCity;
	}

	public String getOfficeStreet1() {
		return _officeStreet1;
	}

	public void setOfficeStreet1(String officeStreet1) {
		_officeStreet1 = officeStreet1;
	}

	public String getOfficeStreet2() {
		return _officeStreet2;
	}

	public void setOfficeStreet2(String officeStreet2) {
		_officeStreet2 = officeStreet2;
	}

	public String getOfficeStreet3() {
		return _officeStreet3;
	}

	public void setOfficeStreet3(String officeStreet3) {
		_officeStreet3 = officeStreet3;
	}

	public String getOfficePostalCode() {
		return _officePostalCode;
	}

	public void setOfficePostalCode(String officePostalCode) {
		_officePostalCode = officePostalCode;
	}

	public String getOfficeCity() {
		return _officeCity;
	}

	public void setOfficeCity(String officeCity) {
		_officeCity = officeCity;
	}

	public String getGiuridicPos() {
		return _giuridicPos;
	}

	public void setGiuridicPos(String giuridicPos) {
		_giuridicPos = giuridicPos;
	}

	public String getEconomicPos() {
		return _economicPos;
	}

	public void setEconomicPos(String economicPos) {
		_economicPos = economicPos;
	}

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
}