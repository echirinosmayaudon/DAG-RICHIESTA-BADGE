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

import java.util.Date;

/**
 * The base model interface for the CambioStatoDirigente service. Represents a row in the &quot;MEFBFC_CambioStatoDirigente&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CambioStatoDirigente
 * @see servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteImpl
 * @see servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteModelImpl
 * @generated
 */
@ProviderType
public interface CambioStatoDirigenteModel extends BaseModel<CambioStatoDirigente> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cambio stato dirigente model instance should use the {@link CambioStatoDirigente} interface instead.
	 */

	/**
	 * Returns the primary key of this cambio stato dirigente.
	 *
	 * @return the primary key of this cambio stato dirigente
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cambio stato dirigente.
	 *
	 * @param primaryKey the primary key of this cambio stato dirigente
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this cambio stato dirigente.
	 *
	 * @return the ID of this cambio stato dirigente
	 */
	public long getId();

	/**
	 * Sets the ID of this cambio stato dirigente.
	 *
	 * @param id the ID of this cambio stato dirigente
	 */
	public void setId(long id);

	/**
	 * Returns the id_rich of this cambio stato dirigente.
	 *
	 * @return the id_rich of this cambio stato dirigente
	 */
	public long getId_rich();

	/**
	 * Sets the id_rich of this cambio stato dirigente.
	 *
	 * @param id_rich the id_rich of this cambio stato dirigente
	 */
	public void setId_rich(long id_rich);

	/**
	 * Returns the data of this cambio stato dirigente.
	 *
	 * @return the data of this cambio stato dirigente
	 */
	public Date getData();

	/**
	 * Sets the data of this cambio stato dirigente.
	 *
	 * @param data the data of this cambio stato dirigente
	 */
	public void setData(Date data);

	/**
	 * Returns the utente of this cambio stato dirigente.
	 *
	 * @return the utente of this cambio stato dirigente
	 */
	@AutoEscape
	public String getUtente();

	/**
	 * Sets the utente of this cambio stato dirigente.
	 *
	 * @param utente the utente of this cambio stato dirigente
	 */
	public void setUtente(String utente);

	/**
	 * Returns the id_stato of this cambio stato dirigente.
	 *
	 * @return the id_stato of this cambio stato dirigente
	 */
	public long getId_stato();

	/**
	 * Sets the id_stato of this cambio stato dirigente.
	 *
	 * @param id_stato the id_stato of this cambio stato dirigente
	 */
	public void setId_stato(long id_stato);

	/**
	 * Returns the note of this cambio stato dirigente.
	 *
	 * @return the note of this cambio stato dirigente
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this cambio stato dirigente.
	 *
	 * @param note the note of this cambio stato dirigente
	 */
	public void setNote(String note);

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
		servizio.beni.facile.consumo.model.CambioStatoDirigente cambioStatoDirigente);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.beni.facile.consumo.model.CambioStatoDirigente> toCacheModel();

	@Override
	public servizio.beni.facile.consumo.model.CambioStatoDirigente toEscapedModel();

	@Override
	public servizio.beni.facile.consumo.model.CambioStatoDirigente toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}