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

package com.intranet.mef.assistance.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Ambito service. Represents a row in the &quot;Assistance_Ambito&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.assistance.model.impl.AmbitoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.assistance.model.impl.AmbitoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ambito
 * @see com.intranet.mef.assistance.model.impl.AmbitoImpl
 * @see com.intranet.mef.assistance.model.impl.AmbitoModelImpl
 * @generated
 */
@ProviderType
public interface AmbitoModel extends BaseModel<Ambito> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ambito model instance should use the {@link Ambito} interface instead.
	 */

	/**
	 * Returns the primary key of this ambito.
	 *
	 * @return the primary key of this ambito
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this ambito.
	 *
	 * @param primaryKey the primary key of this ambito
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the uuid of this ambito.
	 *
	 * @return the uuid of this ambito
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this ambito.
	 *
	 * @param uuid the uuid of this ambito
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ass scope ID of this ambito.
	 *
	 * @return the ass scope ID of this ambito
	 */
	@AutoEscape
	public String getAssScopeId();

	/**
	 * Sets the ass scope ID of this ambito.
	 *
	 * @param assScopeId the ass scope ID of this ambito
	 */
	public void setAssScopeId(String assScopeId);

	/**
	 * Returns the scope name of this ambito.
	 *
	 * @return the scope name of this ambito
	 */
	@AutoEscape
	public String getScopeName();

	/**
	 * Sets the scope name of this ambito.
	 *
	 * @param scopeName the scope name of this ambito
	 */
	public void setScopeName(String scopeName);

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
	public int compareTo(Ambito ambito);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Ambito> toCacheModel();

	@Override
	public Ambito toEscapedModel();

	@Override
	public Ambito toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}