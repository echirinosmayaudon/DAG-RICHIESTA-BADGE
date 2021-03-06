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

import com.intranet.mef.gestione.riunioni.service.persistence.StoricoStatoRiunionePK;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the StoricoStatoRiunione service. Represents a row in the &quot;MEF_StoricoStatoRiunione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoStatoRiunione
 * @see com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneImpl
 * @see com.intranet.mef.gestione.riunioni.model.impl.StoricoStatoRiunioneModelImpl
 * @generated
 */
@ProviderType
public interface StoricoStatoRiunioneModel extends BaseModel<StoricoStatoRiunione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a storico stato riunione model instance should use the {@link StoricoStatoRiunione} interface instead.
	 */

	/**
	 * Returns the primary key of this storico stato riunione.
	 *
	 * @return the primary key of this storico stato riunione
	 */
	public StoricoStatoRiunionePK getPrimaryKey();

	/**
	 * Sets the primary key of this storico stato riunione.
	 *
	 * @param primaryKey the primary key of this storico stato riunione
	 */
	public void setPrimaryKey(StoricoStatoRiunionePK primaryKey);

	/**
	 * Returns the id_riunione of this storico stato riunione.
	 *
	 * @return the id_riunione of this storico stato riunione
	 */
	public long getId_riunione();

	/**
	 * Sets the id_riunione of this storico stato riunione.
	 *
	 * @param id_riunione the id_riunione of this storico stato riunione
	 */
	public void setId_riunione(long id_riunione);

	/**
	 * Returns the id_storico of this storico stato riunione.
	 *
	 * @return the id_storico of this storico stato riunione
	 */
	public long getId_storico();

	/**
	 * Sets the id_storico of this storico stato riunione.
	 *
	 * @param id_storico the id_storico of this storico stato riunione
	 */
	public void setId_storico(long id_storico);

	/**
	 * Returns the data of this storico stato riunione.
	 *
	 * @return the data of this storico stato riunione
	 */
	public Date getData();

	/**
	 * Sets the data of this storico stato riunione.
	 *
	 * @param data the data of this storico stato riunione
	 */
	public void setData(Date data);

	/**
	 * Returns the id_stato_riunione of this storico stato riunione.
	 *
	 * @return the id_stato_riunione of this storico stato riunione
	 */
	public long getId_stato_riunione();

	/**
	 * Sets the id_stato_riunione of this storico stato riunione.
	 *
	 * @param id_stato_riunione the id_stato_riunione of this storico stato riunione
	 */
	public void setId_stato_riunione(long id_stato_riunione);

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
	public int compareTo(StoricoStatoRiunione storicoStatoRiunione);

	@Override
	public int hashCode();

	@Override
	public CacheModel<StoricoStatoRiunione> toCacheModel();

	@Override
	public StoricoStatoRiunione toEscapedModel();

	@Override
	public StoricoStatoRiunione toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}