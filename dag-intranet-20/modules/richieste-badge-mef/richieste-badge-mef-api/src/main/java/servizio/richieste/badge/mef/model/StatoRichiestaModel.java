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

package servizio.richieste.badge.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the StatoRichiesta service. Represents a row in the &quot;MBADGE_StatoRichiesta&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.richieste.badge.mef.model.impl.StatoRichiestaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.richieste.badge.mef.model.impl.StatoRichiestaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichiesta
 * @see servizio.richieste.badge.mef.model.impl.StatoRichiestaImpl
 * @see servizio.richieste.badge.mef.model.impl.StatoRichiestaModelImpl
 * @generated
 */
@ProviderType
public interface StatoRichiestaModel extends BaseModel<StatoRichiesta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a stato richiesta model instance should use the {@link StatoRichiesta} interface instead.
	 */

	/**
	 * Returns the primary key of this stato richiesta.
	 *
	 * @return the primary key of this stato richiesta
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this stato richiesta.
	 *
	 * @param primaryKey the primary key of this stato richiesta
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_stato of this stato richiesta.
	 *
	 * @return the id_stato of this stato richiesta
	 */
	public long getId_stato();

	/**
	 * Sets the id_stato of this stato richiesta.
	 *
	 * @param id_stato the id_stato of this stato richiesta
	 */
	public void setId_stato(long id_stato);

	/**
	 * Returns the descrizione_stato of this stato richiesta.
	 *
	 * @return the descrizione_stato of this stato richiesta
	 */
	@AutoEscape
	public String getDescrizione_stato();

	/**
	 * Sets the descrizione_stato of this stato richiesta.
	 *
	 * @param descrizione_stato the descrizione_stato of this stato richiesta
	 */
	public void setDescrizione_stato(String descrizione_stato);

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
	public int compareTo(
		servizio.richieste.badge.mef.model.StatoRichiesta statoRichiesta);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.richieste.badge.mef.model.StatoRichiesta> toCacheModel();

	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta toEscapedModel();

	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}