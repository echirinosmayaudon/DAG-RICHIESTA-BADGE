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

package service.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RichiestaInterventi service. Represents a row in the &quot;MFORM_RichiestaInterventi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link service.intranet.mef.model.impl.RichiestaInterventiModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link service.intranet.mef.model.impl.RichiestaInterventiImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaInterventi
 * @see service.intranet.mef.model.impl.RichiestaInterventiImpl
 * @see service.intranet.mef.model.impl.RichiestaInterventiModelImpl
 * @generated
 */
@ProviderType
public interface RichiestaInterventiModel extends BaseModel<RichiestaInterventi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a richiesta interventi model instance should use the {@link RichiestaInterventi} interface instead.
	 */

	/**
	 * Returns the primary key of this richiesta interventi.
	 *
	 * @return the primary key of this richiesta interventi
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this richiesta interventi.
	 *
	 * @param primaryKey the primary key of this richiesta interventi
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this richiesta interventi.
	 *
	 * @return the ID of this richiesta interventi
	 */
	public long getId();

	/**
	 * Sets the ID of this richiesta interventi.
	 *
	 * @param id the ID of this richiesta interventi
	 */
	public void setId(long id);

	/**
	 * Returns the utente of this richiesta interventi.
	 *
	 * @return the utente of this richiesta interventi
	 */
	@AutoEscape
	public String getUtente();

	/**
	 * Sets the utente of this richiesta interventi.
	 *
	 * @param utente the utente of this richiesta interventi
	 */
	public void setUtente(String utente);

	/**
	 * Returns the dettaglio of this richiesta interventi.
	 *
	 * @return the dettaglio of this richiesta interventi
	 */
	@AutoEscape
	public String getDettaglio();

	/**
	 * Sets the dettaglio of this richiesta interventi.
	 *
	 * @param dettaglio the dettaglio of this richiesta interventi
	 */
	public void setDettaglio(String dettaglio);

	/**
	 * Returns the data_interventi of this richiesta interventi.
	 *
	 * @return the data_interventi of this richiesta interventi
	 */
	public Date getData_interventi();

	/**
	 * Sets the data_interventi of this richiesta interventi.
	 *
	 * @param data_interventi the data_interventi of this richiesta interventi
	 */
	public void setData_interventi(Date data_interventi);

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
		service.intranet.mef.model.RichiestaInterventi richiestaInterventi);

	@Override
	public int hashCode();

	@Override
	public CacheModel<service.intranet.mef.model.RichiestaInterventi> toCacheModel();

	@Override
	public service.intranet.mef.model.RichiestaInterventi toEscapedModel();

	@Override
	public service.intranet.mef.model.RichiestaInterventi toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}