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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Vacation service. Represents a row in the &quot;LF_VIEW_FERIE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.job.siap.model.impl.VacationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.job.siap.model.impl.VacationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vacation
 * @see com.intranet.mef.job.siap.model.impl.VacationImpl
 * @see com.intranet.mef.job.siap.model.impl.VacationModelImpl
 * @generated
 */
@ProviderType
public interface VacationModel extends BaseModel<Vacation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vacation model instance should use the {@link Vacation} interface instead.
	 */

	/**
	 * Returns the primary key of this vacation.
	 *
	 * @return the primary key of this vacation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vacation.
	 *
	 * @param primaryKey the primary key of this vacation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the person ID of this vacation.
	 *
	 * @return the person ID of this vacation
	 */
	public long getPersonId();

	/**
	 * Sets the person ID of this vacation.
	 *
	 * @param personId the person ID of this vacation
	 */
	public void setPersonId(long personId);

	/**
	 * Returns the vacation curr year of this vacation.
	 *
	 * @return the vacation curr year of this vacation
	 */
	public int getVacationCurrYear();

	/**
	 * Sets the vacation curr year of this vacation.
	 *
	 * @param vacationCurrYear the vacation curr year of this vacation
	 */
	public void setVacationCurrYear(int vacationCurrYear);

	/**
	 * Returns the vacation prev year of this vacation.
	 *
	 * @return the vacation prev year of this vacation
	 */
	public int getVacationPrevYear();

	/**
	 * Sets the vacation prev year of this vacation.
	 *
	 * @param vacationPrevYear the vacation prev year of this vacation
	 */
	public void setVacationPrevYear(int vacationPrevYear);

	/**
	 * Returns the vacation spent of this vacation.
	 *
	 * @return the vacation spent of this vacation
	 */
	public int getVacationSpent();

	/**
	 * Sets the vacation spent of this vacation.
	 *
	 * @param vacationSpent the vacation spent of this vacation
	 */
	public void setVacationSpent(int vacationSpent);

	/**
	 * Returns the vacation remaining of this vacation.
	 *
	 * @return the vacation remaining of this vacation
	 */
	public int getVacationRemaining();

	/**
	 * Sets the vacation remaining of this vacation.
	 *
	 * @param vacationRemaining the vacation remaining of this vacation
	 */
	public void setVacationRemaining(int vacationRemaining);

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
	public int compareTo(Vacation vacation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Vacation> toCacheModel();

	@Override
	public Vacation toEscapedModel();

	@Override
	public Vacation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}