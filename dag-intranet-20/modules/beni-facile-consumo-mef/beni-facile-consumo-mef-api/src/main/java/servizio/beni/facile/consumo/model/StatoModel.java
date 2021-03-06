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

package servizio.beni.facile.consumo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Stato service. Represents a row in the &quot;MEFBFC_Stato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.beni.facile.consumo.model.impl.StatoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.beni.facile.consumo.model.impl.StatoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Stato
 * @see servizio.beni.facile.consumo.model.impl.StatoImpl
 * @see servizio.beni.facile.consumo.model.impl.StatoModelImpl
 * @generated
 */
@ProviderType
public interface StatoModel extends BaseModel<Stato> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a stato model instance should use the {@link Stato} interface instead.
	 */

	/**
	 * Returns the primary key of this stato.
	 *
	 * @return the primary key of this stato
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this stato.
	 *
	 * @param primaryKey the primary key of this stato
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this stato.
	 *
	 * @return the ID of this stato
	 */
	public long getId();

	/**
	 * Sets the ID of this stato.
	 *
	 * @param id the ID of this stato
	 */
	public void setId(long id);

	/**
	 * Returns the descrizione of this stato.
	 *
	 * @return the descrizione of this stato
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this stato.
	 *
	 * @param descrizione the descrizione of this stato
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
	public int compareTo(servizio.beni.facile.consumo.model.Stato stato);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.beni.facile.consumo.model.Stato> toCacheModel();

	@Override
	public servizio.beni.facile.consumo.model.Stato toEscapedModel();

	@Override
	public servizio.beni.facile.consumo.model.Stato toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}