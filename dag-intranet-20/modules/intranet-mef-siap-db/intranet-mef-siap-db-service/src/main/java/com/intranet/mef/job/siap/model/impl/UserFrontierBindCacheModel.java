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
import com.intranet.mef.job.siap.service.persistence.UserFrontierBindPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserFrontierBind in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserFrontierBind
 * @generated
 */
@ProviderType
public class UserFrontierBindCacheModel implements CacheModel<UserFrontierBind>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserFrontierBindCacheModel)) {
			return false;
		}

		UserFrontierBindCacheModel userFrontierBindCacheModel = (UserFrontierBindCacheModel)obj;

		if (userFrontierBindPK.equals(
					userFrontierBindCacheModel.userFrontierBindPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userFrontierBindPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{personalId=");
		sb.append(personalId);
		sb.append(", idOrgChart=");
		sb.append(idOrgChart);
		sb.append(", idDirector=");
		sb.append(idDirector);
		sb.append(", dateRecruitment=");
		sb.append(dateRecruitment);
		sb.append(", dateStartAssignOffice=");
		sb.append(dateStartAssignOffice);
		sb.append(", dateStartInquadramento=");
		sb.append(dateStartInquadramento);
		sb.append(", dateStartFunction=");
		sb.append(dateStartFunction);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", name=");
		sb.append(name);
		sb.append(", surName=");
		sb.append(surName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", email=");
		sb.append(email);
		sb.append(", codIstatBirth=");
		sb.append(codIstatBirth);
		sb.append(", dateBirth=");
		sb.append(dateBirth);
		sb.append(", personalPhone=");
		sb.append(personalPhone);
		sb.append(", workPhone=");
		sb.append(workPhone);
		sb.append(", workFax=");
		sb.append(workFax);
		sb.append(", personalStreet=");
		sb.append(personalStreet);
		sb.append(", personalPostalCode=");
		sb.append(personalPostalCode);
		sb.append(", personalCity=");
		sb.append(personalCity);
		sb.append(", officeStreet1=");
		sb.append(officeStreet1);
		sb.append(", officeStreet2=");
		sb.append(officeStreet2);
		sb.append(", officeStreet3=");
		sb.append(officeStreet3);
		sb.append(", officePostalCode=");
		sb.append(officePostalCode);
		sb.append(", officeCity=");
		sb.append(officeCity);
		sb.append(", giuridicPos=");
		sb.append(giuridicPos);
		sb.append(", economicPos=");
		sb.append(economicPos);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserFrontierBind toEntityModel() {
		UserFrontierBindImpl userFrontierBindImpl = new UserFrontierBindImpl();

		userFrontierBindImpl.setPersonalId(personalId);
		userFrontierBindImpl.setIdOrgChart(idOrgChart);
		userFrontierBindImpl.setIdDirector(idDirector);

		if (dateRecruitment == Long.MIN_VALUE) {
			userFrontierBindImpl.setDateRecruitment(null);
		}
		else {
			userFrontierBindImpl.setDateRecruitment(new Date(dateRecruitment));
		}

		if (dateStartAssignOffice == Long.MIN_VALUE) {
			userFrontierBindImpl.setDateStartAssignOffice(null);
		}
		else {
			userFrontierBindImpl.setDateStartAssignOffice(new Date(
					dateStartAssignOffice));
		}

		if (dateStartInquadramento == Long.MIN_VALUE) {
			userFrontierBindImpl.setDateStartInquadramento(null);
		}
		else {
			userFrontierBindImpl.setDateStartInquadramento(new Date(
					dateStartInquadramento));
		}

		if (dateStartFunction == Long.MIN_VALUE) {
			userFrontierBindImpl.setDateStartFunction(null);
		}
		else {
			userFrontierBindImpl.setDateStartFunction(new Date(
					dateStartFunction));
		}

		userFrontierBindImpl.setLevelId(levelId);

		if (screenName == null) {
			userFrontierBindImpl.setScreenName(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setScreenName(screenName);
		}

		if (name == null) {
			userFrontierBindImpl.setName(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setName(name);
		}

		if (surName == null) {
			userFrontierBindImpl.setSurName(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setSurName(surName);
		}

		if (gender == null) {
			userFrontierBindImpl.setGender(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setGender(gender);
		}

		if (email == null) {
			userFrontierBindImpl.setEmail(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setEmail(email);
		}

		if (codIstatBirth == null) {
			userFrontierBindImpl.setCodIstatBirth(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setCodIstatBirth(codIstatBirth);
		}

		if (dateBirth == Long.MIN_VALUE) {
			userFrontierBindImpl.setDateBirth(null);
		}
		else {
			userFrontierBindImpl.setDateBirth(new Date(dateBirth));
		}

		if (personalPhone == null) {
			userFrontierBindImpl.setPersonalPhone(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setPersonalPhone(personalPhone);
		}

		if (workPhone == null) {
			userFrontierBindImpl.setWorkPhone(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setWorkPhone(workPhone);
		}

		if (workFax == null) {
			userFrontierBindImpl.setWorkFax(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setWorkFax(workFax);
		}

		if (personalStreet == null) {
			userFrontierBindImpl.setPersonalStreet(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setPersonalStreet(personalStreet);
		}

		if (personalPostalCode == null) {
			userFrontierBindImpl.setPersonalPostalCode(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setPersonalPostalCode(personalPostalCode);
		}

		if (personalCity == null) {
			userFrontierBindImpl.setPersonalCity(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setPersonalCity(personalCity);
		}

		if (officeStreet1 == null) {
			userFrontierBindImpl.setOfficeStreet1(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setOfficeStreet1(officeStreet1);
		}

		if (officeStreet2 == null) {
			userFrontierBindImpl.setOfficeStreet2(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setOfficeStreet2(officeStreet2);
		}

		if (officeStreet3 == null) {
			userFrontierBindImpl.setOfficeStreet3(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setOfficeStreet3(officeStreet3);
		}

		if (officePostalCode == null) {
			userFrontierBindImpl.setOfficePostalCode(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setOfficePostalCode(officePostalCode);
		}

		if (officeCity == null) {
			userFrontierBindImpl.setOfficeCity(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setOfficeCity(officeCity);
		}

		if (giuridicPos == null) {
			userFrontierBindImpl.setGiuridicPos(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setGiuridicPos(giuridicPos);
		}

		if (economicPos == null) {
			userFrontierBindImpl.setEconomicPos(StringPool.BLANK);
		}
		else {
			userFrontierBindImpl.setEconomicPos(economicPos);
		}

		userFrontierBindImpl.resetOriginalValues();

		return userFrontierBindImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personalId = objectInput.readLong();

		idOrgChart = objectInput.readLong();

		idDirector = objectInput.readLong();
		dateRecruitment = objectInput.readLong();
		dateStartAssignOffice = objectInput.readLong();
		dateStartInquadramento = objectInput.readLong();
		dateStartFunction = objectInput.readLong();

		levelId = objectInput.readLong();
		screenName = objectInput.readUTF();
		name = objectInput.readUTF();
		surName = objectInput.readUTF();
		gender = objectInput.readUTF();
		email = objectInput.readUTF();
		codIstatBirth = objectInput.readUTF();
		dateBirth = objectInput.readLong();
		personalPhone = objectInput.readUTF();
		workPhone = objectInput.readUTF();
		workFax = objectInput.readUTF();
		personalStreet = objectInput.readUTF();
		personalPostalCode = objectInput.readUTF();
		personalCity = objectInput.readUTF();
		officeStreet1 = objectInput.readUTF();
		officeStreet2 = objectInput.readUTF();
		officeStreet3 = objectInput.readUTF();
		officePostalCode = objectInput.readUTF();
		officeCity = objectInput.readUTF();
		giuridicPos = objectInput.readUTF();
		economicPos = objectInput.readUTF();

		userFrontierBindPK = new UserFrontierBindPK(personalId, screenName);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personalId);

		objectOutput.writeLong(idOrgChart);

		objectOutput.writeLong(idDirector);
		objectOutput.writeLong(dateRecruitment);
		objectOutput.writeLong(dateStartAssignOffice);
		objectOutput.writeLong(dateStartInquadramento);
		objectOutput.writeLong(dateStartFunction);

		objectOutput.writeLong(levelId);

		if (screenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (surName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surName);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (codIstatBirth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codIstatBirth);
		}

		objectOutput.writeLong(dateBirth);

		if (personalPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalPhone);
		}

		if (workPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workPhone);
		}

		if (workFax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workFax);
		}

		if (personalStreet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalStreet);
		}

		if (personalPostalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalPostalCode);
		}

		if (personalCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalCity);
		}

		if (officeStreet1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeStreet1);
		}

		if (officeStreet2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeStreet2);
		}

		if (officeStreet3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeStreet3);
		}

		if (officePostalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officePostalCode);
		}

		if (officeCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeCity);
		}

		if (giuridicPos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(giuridicPos);
		}

		if (economicPos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(economicPos);
		}
	}

	public long personalId;
	public long idOrgChart;
	public long idDirector;
	public long dateRecruitment;
	public long dateStartAssignOffice;
	public long dateStartInquadramento;
	public long dateStartFunction;
	public long levelId;
	public String screenName;
	public String name;
	public String surName;
	public String gender;
	public String email;
	public String codIstatBirth;
	public long dateBirth;
	public String personalPhone;
	public String workPhone;
	public String workFax;
	public String personalStreet;
	public String personalPostalCode;
	public String personalCity;
	public String officeStreet1;
	public String officeStreet2;
	public String officeStreet3;
	public String officePostalCode;
	public String officeCity;
	public String giuridicPos;
	public String economicPos;
	public transient UserFrontierBindPK userFrontierBindPK;
}