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

package com.intranet.mef.gestione.riunioni.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the TipoRiunione service. Represents a row in the &quot;MEF_TipoRiunione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoRiunione
 * @see com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneImpl
 * @see com.intranet.mef.gestione.riunioni.model.impl.TipoRiunioneModelImpl
 * @generated
 */
@ProviderType
public interface TipoRiunioneModel extends BaseModel<TipoRiunione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tipo riunione model instance should use the {@link TipoRiunione} interface instead.
	 */

	/**
	 * Returns the primary key of this tipo riunione.
	 *
	 * @return the primary key of this tipo riunione
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tipo riunione.
	 *
	 * @param primaryKey the primary key of this tipo riunione
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_tipo of this tipo riunione.
	 *
	 * @return the id_tipo of this tipo riunione
	 */
	public long getId_tipo();

	/**
	 * Sets the id_tipo of this tipo riunione.
	 *
	 * @param id_tipo the id_tipo of this tipo riunione
	 */
	public void setId_tipo(long id_tipo);

	/**
	 * Returns the descrizione of this tipo riunione.
	 *
	 * @return the descrizione of this tipo riunione
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this tipo riunione.
	 *
	 * @param descrizione the descrizione of this tipo riunione
	 */
	public void setDescrizione(String descrizione);

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
	public int compareTo(TipoRiunione tipoRiunione);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TipoRiunione> toCacheModel();

	@Override
	public TipoRiunione toEscapedModel();

	@Override
	public TipoRiunione toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}