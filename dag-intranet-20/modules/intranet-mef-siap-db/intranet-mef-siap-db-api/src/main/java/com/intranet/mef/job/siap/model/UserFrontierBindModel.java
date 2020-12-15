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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserFrontierBind service. Represents a row in the &quot;LF_FRONTIERA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.job.siap.model.impl.UserFrontierBindModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.job.siap.model.impl.UserFrontierBindImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFrontierBind
 * @see com.intranet.mef.job.siap.model.impl.UserFrontierBindImpl
 * @see com.intranet.mef.job.siap.model.impl.UserFrontierBindModelImpl
 * @generated
 */
@ProviderType
public interface UserFrontierBindModel extends BaseModel<UserFrontierBind> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user frontier bind model instance should use the {@link UserFrontierBind} interface instead.
	 */

	/**
	 * Returns the primary key of this user frontier bind.
	 *
	 * @return the primary key of this user frontier bind
	 */
	public UserFrontierBindPK getPrimaryKey();

	/**
	 * Sets the primary key of this user frontier bind.
	 *
	 * @param primaryKey the primary key of this user frontier bind
	 */
	public void setPrimaryKey(UserFrontierBindPK primaryKey);

	/**
	 * Returns the personal ID of this user frontier bind.
	 *
	 * @return the personal ID of this user frontier bind
	 */
	public long getPersonalId();

	/**
	 * Sets the personal ID of this user frontier bind.
	 *
	 * @param personalId the personal ID of this user frontier bind
	 */
	public void setPersonalId(long personalId);

	/**
	 * Returns the id org chart of this user frontier bind.
	 *
	 * @return the id org chart of this user frontier bind
	 */
	public long getIdOrgChart();

	/**
	 * Sets the id org chart of this user frontier bind.
	 *
	 * @param idOrgChart the id org chart of this user frontier bind
	 */
	public void setIdOrgChart(long idOrgChart);

	/**
	 * Returns the id director of this user frontier bind.
	 *
	 * @return the id director of this user frontier bind
	 */
	public long getIdDirector();

	/**
	 * Sets the id director of this user frontier bind.
	 *
	 * @param idDirector the id director of this user frontier bind
	 */
	public void setIdDirector(long idDirector);

	/**
	 * Returns the date recruitment of this user frontier bind.
	 *
	 * @return the date recruitment of this user frontier bind
	 */
	public Date getDateRecruitment();

	/**
	 * Sets the date recruitment of this user frontier bind.
	 *
	 * @param dateRecruitment the date recruitment of this user frontier bind
	 */
	public void setDateRecruitment(Date dateRecruitment);

	/**
	 * Returns the date start assign office of this user frontier bind.
	 *
	 * @return the date start assign office of this user frontier bind
	 */
	public Date getDateStartAssignOffice();

	/**
	 * Sets the date start assign office of this user frontier bind.
	 *
	 * @param dateStartAssignOffice the date start assign office of this user frontier bind
	 */
	public void setDateStartAssignOffice(Date dateStartAssignOffice);

	/**
	 * Returns the date start inquadramento of this user frontier bind.
	 *
	 * @return the date start inquadramento of this user frontier bind
	 */
	public Date getDateStartInquadramento();

	/**
	 * Sets the date start inquadramento of this user frontier bind.
	 *
	 * @param dateStartInquadramento the date start inquadramento of this user frontier bind
	 */
	public void setDateStartInquadramento(Date dateStartInquadramento);

	/**
	 * Returns the date start function of this user frontier bind.
	 *
	 * @return the date start function of this user frontier bind
	 */
	public Date getDateStartFunction();

	/**
	 * Sets the date start function of this user frontier bind.
	 *
	 * @param dateStartFunction the date start function of this user frontier bind
	 */
	public void setDateStartFunction(Date dateStartFunction);

	/**
	 * Returns the level ID of this user frontier bind.
	 *
	 * @return the level ID of this user frontier bind
	 */
	public long getLevelId();

	/**
	 * Sets the level ID of this user frontier bind.
	 *
	 * @param levelId the level ID of this user frontier bind
	 */
	public void setLevelId(long levelId);

	/**
	 * Returns the screen name of this user frontier bind.
	 *
	 * @return the screen name of this user frontier bind
	 */
	@AutoEscape
	public String getScreenName();

	/**
	 * Sets the screen name of this user frontier bind.
	 *
	 * @param screenName the screen name of this user frontier bind
	 */
	public void setScreenName(String screenName);

	/**
	 * Returns the name of this user frontier bind.
	 *
	 * @return the name of this user frontier bind
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this user frontier bind.
	 *
	 * @param name the name of this user frontier bind
	 */
	public void setName(String name);

	/**
	 * Returns the sur name of this user frontier bind.
	 *
	 * @return the sur name of this user frontier bind
	 */
	@AutoEscape
	public String getSurName();

	/**
	 * Sets the sur name of this user frontier bind.
	 *
	 * @param surName the sur name of this user frontier bind
	 */
	public void setSurName(String surName);

	/**
	 * Returns the gender of this user frontier bind.
	 *
	 * @return the gender of this user frontier bind
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this user frontier bind.
	 *
	 * @param gender the gender of this user frontier bind
	 */
	public void setGender(String gender);

	/**
	 * Returns the email of this user frontier bind.
	 *
	 * @return the email of this user frontier bind
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this user frontier bind.
	 *
	 * @param email the email of this user frontier bind
	 */
	public void setEmail(String email);

	/**
	 * Returns the cod istat birth of this user frontier bind.
	 *
	 * @return the cod istat birth of this user frontier bind
	 */
	@AutoEscape
	public String getCodIstatBirth();

	/**
	 * Sets the cod istat birth of this user frontier bind.
	 *
	 * @param codIstatBirth the cod istat birth of this user frontier bind
	 */
	public void setCodIstatBirth(String codIstatBirth);

	/**
	 * Returns the date birth of this user frontier bind.
	 *
	 * @return the date birth of this user frontier bind
	 */
	public Date getDateBirth();

	/**
	 * Sets the date birth of this user frontier bind.
	 *
	 * @param dateBirth the date birth of this user frontier bind
	 */
	public void setDateBirth(Date dateBirth);

	/**
	 * Returns the personal phone of this user frontier bind.
	 *
	 * @return the personal phone of this user frontier bind
	 */
	@AutoEscape
	public String getPersonalPhone();

	/**
	 * Sets the personal phone of this user frontier bind.
	 *
	 * @param personalPhone the personal phone of this user frontier bind
	 */
	public void setPersonalPhone(String personalPhone);

	/**
	 * Returns the work phone of this user frontier bind.
	 *
	 * @return the work phone of this user frontier bind
	 */
	@AutoEscape
	public String getWorkPhone();

	/**
	 * Sets the work phone of this user frontier bind.
	 *
	 * @param workPhone the work phone of this user frontier bind
	 */
	public void setWorkPhone(String workPhone);

	/**
	 * Returns the work fax of this user frontier bind.
	 *
	 * @return the work fax of this user frontier bind
	 */
	@AutoEscape
	public String getWorkFax();

	/**
	 * Sets the work fax of this user frontier bind.
	 *
	 * @param workFax the work fax of this user frontier bind
	 */
	public void setWorkFax(String workFax);

	/**
	 * Returns the personal street of this user frontier bind.
	 *
	 * @return the personal street of this user frontier bind
	 */
	@AutoEscape
	public String getPersonalStreet();

	/**
	 * Sets the personal street of this user frontier bind.
	 *
	 * @param personalStreet the personal street of this user frontier bind
	 */
	public void setPersonalStreet(String personalStreet);

	/**
	 * Returns the personal postal code of this user frontier bind.
	 *
	 * @return the personal postal code of this user frontier bind
	 */
	@AutoEscape
	public String getPersonalPostalCode();

	/**
	 * Sets the personal postal code of this user frontier bind.
	 *
	 * @param personalPostalCode the personal postal code of this user frontier bind
	 */
	public void setPersonalPostalCode(String personalPostalCode);

	/**
	 * Returns the personal city of this user frontier bind.
	 *
	 * @return the personal city of this user frontier bind
	 */
	@AutoEscape
	public String getPersonalCity();

	/**
	 * Sets the personal city of this user frontier bind.
	 *
	 * @param personalCity the personal city of this user frontier bind
	 */
	public void setPersonalCity(String personalCity);

	/**
	 * Returns the office street1 of this user frontier bind.
	 *
	 * @return the office street1 of this user frontier bind
	 */
	@AutoEscape
	public String getOfficeStreet1();

	/**
	 * Sets the office street1 of this user frontier bind.
	 *
	 * @param officeStreet1 the office street1 of this user frontier bind
	 */
	public void setOfficeStreet1(String officeStreet1);

	/**
	 * Returns the office street2 of this user frontier bind.
	 *
	 * @return the office street2 of this user frontier bind
	 */
	@AutoEscape
	public String getOfficeStreet2();

	/**
	 * Sets the office street2 of this user frontier bind.
	 *
	 * @param officeStreet2 the office street2 of this user frontier bind
	 */
	public void setOfficeStreet2(String officeStreet2);

	/**
	 * Returns the office street3 of this user frontier bind.
	 *
	 * @return the office street3 of this user frontier bind
	 */
	@AutoEscape
	public String getOfficeStreet3();

	/**
	 * Sets the office street3 of this user frontier bind.
	 *
	 * @param officeStreet3 the office street3 of this user frontier bind
	 */
	public void setOfficeStreet3(String officeStreet3);

	/**
	 * Returns the office postal code of this user frontier bind.
	 *
	 * @return the office postal code of this user frontier bind
	 */
	@AutoEscape
	public String getOfficePostalCode();

	/**
	 * Sets the office postal code of this user frontier bind.
	 *
	 * @param officePostalCode the office postal code of this user frontier bind
	 */
	public void setOfficePostalCode(String officePostalCode);

	/**
	 * Returns the office city of this user frontier bind.
	 *
	 * @return the office city of this user frontier bind
	 */
	@AutoEscape
	public String getOfficeCity();

	/**
	 * Sets the office city of this user frontier bind.
	 *
	 * @param officeCity the office city of this user frontier bind
	 */
	public void setOfficeCity(String officeCity);

	/**
	 * Returns the giuridic pos of this user frontier bind.
	 *
	 * @return the giuridic pos of this user frontier bind
	 */
	@AutoEscape
	public String getGiuridicPos();

	/**
	 * Sets the giuridic pos of this user frontier bind.
	 *
	 * @param giuridicPos the giuridic pos of this user frontier bind
	 */
	public void setGiuridicPos(String giuridicPos);

	/**
	 * Returns the economic pos of this user frontier bind.
	 *
	 * @return the economic pos of this user frontier bind
	 */
	@AutoEscape
	public String getEconomicPos();

	/**
	 * Sets the economic pos of this user frontier bind.
	 *
	 * @param economicPos the economic pos of this user frontier bind
	 */
	public void setEconomicPos(String economicPos);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(UserFrontierBind userFrontierBind);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserFrontierBind> toCacheModel();

	@Override
	public UserFrontierBind toEscapedModel();

	@Override
	public UserFrontierBind toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}