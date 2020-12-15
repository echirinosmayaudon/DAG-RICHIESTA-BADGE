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
 * The base model interface for the Festivity service. Represents a row in the &quot;LF_VIEW_FESTIVITA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.job.siap.model.impl.FestivityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.job.siap.model.impl.FestivityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Festivity
 * @see com.intranet.mef.job.siap.model.impl.FestivityImpl
 * @see com.intranet.mef.job.siap.model.impl.FestivityModelImpl
 * @generated
 */
@ProviderType
public interface FestivityModel extends BaseModel<Festivity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a festivity model instance should use the {@link Festivity} interface instead.
	 */

	/**
	 * Returns the primary key of this festivity.
	 *
	 * @return the primary key of this festivity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this festivity.
	 *
	 * @param primaryKey the primary key of this festivity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the person ID of this festivity.
	 *
	 * @return the person ID of this festivity
	 */
	public long getPersonId();

	/**
	 * Sets the person ID of this festivity.
	 *
	 * @param personId the person ID of this festivity
	 */
	public void setPersonId(long personId);

	/**
	 * Returns the festivity due curr year of this festivity.
	 *
	 * @return the festivity due curr year of this festivity
	 */
	public int getFestivityDueCurrYear();

	/**
	 * Sets the festivity due curr year of this festivity.
	 *
	 * @param festivityDueCurrYear the festivity due curr year of this festivity
	 */
	public void setFestivityDueCurrYear(int festivityDueCurrYear);

	/**
	 * Returns the festivity spent curr year of this festivity.
	 *
	 * @return the festivity spent curr year of this festivity
	 */
	public int getFestivitySpentCurrYear();

	/**
	 * Sets the festivity spent curr year of this festivity.
	 *
	 * @param festivitySpentCurrYear the festivity spent curr year of this festivity
	 */
	public void setFestivitySpentCurrYear(int festivitySpentCurrYear);

	/**
	 * Returns the festivity remain curr year of this festivity.
	 *
	 * @return the festivity remain curr year of this festivity
	 */
	public int getFestivityRemainCurrYear();

	/**
	 * Sets the festivity remain curr year of this festivity.
	 *
	 * @param festivityRemainCurrYear the festivity remain curr year of this festivity
	 */
	public void setFestivityRemainCurrYear(int festivityRemainCurrYear);

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
	public int compareTo(Festivity festivity);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Festivity> toCacheModel();

	@Override
	public Festivity toEscapedModel();

	@Override
	public Festivity toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}