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

package com.intranet.mef.daily.punching.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the DailyPunching service. Represents a row in the &quot;LF_TIMBRATURE_GIORNO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.daily.punching.model.impl.DailyPunchingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.daily.punching.model.impl.DailyPunchingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DailyPunching
 * @see com.intranet.mef.daily.punching.model.impl.DailyPunchingImpl
 * @see com.intranet.mef.daily.punching.model.impl.DailyPunchingModelImpl
 * @generated
 */
@ProviderType
public interface DailyPunchingModel extends BaseModel<DailyPunching> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a daily punching model instance should use the {@link DailyPunching} interface instead.
	 */

	/**
	 * Returns the primary key of this daily punching.
	 *
	 * @return the primary key of this daily punching
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this daily punching.
	 *
	 * @param primaryKey the primary key of this daily punching
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the custom_key of this daily punching.
	 *
	 * @return the custom_key of this daily punching
	 */
	@AutoEscape
	public String getCustom_key();

	/**
	 * Sets the custom_key of this daily punching.
	 *
	 * @param custom_key the custom_key of this daily punching
	 */
	public void setCustom_key(String custom_key);

	/**
	 * Returns the person ID of this daily punching.
	 *
	 * @return the person ID of this daily punching
	 */
	public long getPersonId();

	/**
	 * Sets the person ID of this daily punching.
	 *
	 * @param personId the person ID of this daily punching
	 */
	public void setPersonId(long personId);

	/**
	 * Returns the punching ID of this daily punching.
	 *
	 * @return the punching ID of this daily punching
	 */
	public int getPunchingId();

	/**
	 * Sets the punching ID of this daily punching.
	 *
	 * @param punchingId the punching ID of this daily punching
	 */
	public void setPunchingId(int punchingId);

	/**
	 * Returns the direction of this daily punching.
	 *
	 * @return the direction of this daily punching
	 */
	@AutoEscape
	public String getDirection();

	/**
	 * Sets the direction of this daily punching.
	 *
	 * @param direction the direction of this daily punching
	 */
	public void setDirection(String direction);

	/**
	 * Returns the voucher of this daily punching.
	 *
	 * @return the voucher of this daily punching
	 */
	@AutoEscape
	public String getVoucher();

	/**
	 * Sets the voucher of this daily punching.
	 *
	 * @param voucher the voucher of this daily punching
	 */
	public void setVoucher(String voucher);

	/**
	 * Returns the terminal of this daily punching.
	 *
	 * @return the terminal of this daily punching
	 */
	@AutoEscape
	public String getTerminal();

	/**
	 * Sets the terminal of this daily punching.
	 *
	 * @param terminal the terminal of this daily punching
	 */
	public void setTerminal(String terminal);

	/**
	 * Returns the hours of this daily punching.
	 *
	 * @return the hours of this daily punching
	 */
	public int getHours();

	/**
	 * Sets the hours of this daily punching.
	 *
	 * @param hours the hours of this daily punching
	 */
	public void setHours(int hours);

	/**
	 * Returns the minute of this daily punching.
	 *
	 * @return the minute of this daily punching
	 */
	@AutoEscape
	public String getMinute();

	/**
	 * Sets the minute of this daily punching.
	 *
	 * @param minute the minute of this daily punching
	 */
	public void setMinute(String minute);

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
	public int compareTo(DailyPunching dailyPunching);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DailyPunching> toCacheModel();

	@Override
	public DailyPunching toEscapedModel();

	@Override
	public DailyPunching toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}