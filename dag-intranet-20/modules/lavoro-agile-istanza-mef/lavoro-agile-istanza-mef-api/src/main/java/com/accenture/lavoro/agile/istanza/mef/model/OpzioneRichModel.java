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

package com.accenture.lavoro.agile.istanza.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OpzioneRich service. Represents a row in the &quot;MEFISTAGILE_OpzioneRich&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRich
 * @see com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichImpl
 * @see com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichModelImpl
 * @generated
 */
@ProviderType
public interface OpzioneRichModel extends BaseModel<OpzioneRich> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a opzione rich model instance should use the {@link OpzioneRich} interface instead.
	 */

	/**
	 * Returns the primary key of this opzione rich.
	 *
	 * @return the primary key of this opzione rich
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this opzione rich.
	 *
	 * @param primaryKey the primary key of this opzione rich
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_opt of this opzione rich.
	 *
	 * @return the id_opt of this opzione rich
	 */
	public long getId_opt();

	/**
	 * Sets the id_opt of this opzione rich.
	 *
	 * @param id_opt the id_opt of this opzione rich
	 */
	public void setId_opt(long id_opt);

	/**
	 * Returns the label_opt of this opzione rich.
	 *
	 * @return the label_opt of this opzione rich
	 */
	@AutoEscape
	public String getLabel_opt();

	/**
	 * Sets the label_opt of this opzione rich.
	 *
	 * @param label_opt the label_opt of this opzione rich
	 */
	public void setLabel_opt(String label_opt);

	/**
	 * Returns the testo_opt of this opzione rich.
	 *
	 * @return the testo_opt of this opzione rich
	 */
	@AutoEscape
	public String getTesto_opt();

	/**
	 * Sets the testo_opt of this opzione rich.
	 *
	 * @param testo_opt the testo_opt of this opzione rich
	 */
	public void setTesto_opt(String testo_opt);

	/**
	 * Returns the peso_opt of this opzione rich.
	 *
	 * @return the peso_opt of this opzione rich
	 */
	public int getPeso_opt();

	/**
	 * Sets the peso_opt of this opzione rich.
	 *
	 * @param peso_opt the peso_opt of this opzione rich
	 */
	public void setPeso_opt(int peso_opt);

	/**
	 * Returns the data_in of this opzione rich.
	 *
	 * @return the data_in of this opzione rich
	 */
	public Date getData_in();

	/**
	 * Sets the data_in of this opzione rich.
	 *
	 * @param data_in the data_in of this opzione rich
	 */
	public void setData_in(Date data_in);

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
	public int compareTo(OpzioneRich opzioneRich);

	@Override
	public int hashCode();

	@Override
	public CacheModel<OpzioneRich> toCacheModel();

	@Override
	public OpzioneRich toEscapedModel();

	@Override
	public OpzioneRich toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}