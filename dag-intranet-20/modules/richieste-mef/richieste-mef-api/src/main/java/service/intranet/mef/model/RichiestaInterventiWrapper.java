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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link RichiestaInterventi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaInterventi
 * @generated
 */
@ProviderType
public class RichiestaInterventiWrapper implements RichiestaInterventi,
	ModelWrapper<RichiestaInterventi> {
	public RichiestaInterventiWrapper(RichiestaInterventi richiestaInterventi) {
		_richiestaInterventi = richiestaInterventi;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiestaInterventi.class;
	}

	@Override
	public String getModelClassName() {
		return RichiestaInterventi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("utente", getUtente());
		attributes.put("dettaglio", getDettaglio());
		attributes.put("data_interventi", getData_interventi());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		String dettaglio = (String)attributes.get("dettaglio");

		if (dettaglio != null) {
			setDettaglio(dettaglio);
		}

		Date data_interventi = (Date)attributes.get("data_interventi");

		if (data_interventi != null) {
			setData_interventi(data_interventi);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _richiestaInterventi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiestaInterventi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiestaInterventi.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiestaInterventi.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.RichiestaInterventi> toCacheModel() {
		return _richiestaInterventi.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.RichiestaInterventi richiestaInterventi) {
		return _richiestaInterventi.compareTo(richiestaInterventi);
	}

	@Override
	public int hashCode() {
		return _richiestaInterventi.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiestaInterventi.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiestaInterventiWrapper((RichiestaInterventi)_richiestaInterventi.clone());
	}

	/**
	* Returns the dettaglio of this richiesta interventi.
	*
	* @return the dettaglio of this richiesta interventi
	*/
	@Override
	public java.lang.String getDettaglio() {
		return _richiestaInterventi.getDettaglio();
	}

	/**
	* Returns the utente of this richiesta interventi.
	*
	* @return the utente of this richiesta interventi
	*/
	@Override
	public java.lang.String getUtente() {
		return _richiestaInterventi.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _richiestaInterventi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiestaInterventi.toXmlString();
	}

	/**
	* Returns the data_interventi of this richiesta interventi.
	*
	* @return the data_interventi of this richiesta interventi
	*/
	@Override
	public Date getData_interventi() {
		return _richiestaInterventi.getData_interventi();
	}

	/**
	* Returns the ID of this richiesta interventi.
	*
	* @return the ID of this richiesta interventi
	*/
	@Override
	public long getId() {
		return _richiestaInterventi.getId();
	}

	/**
	* Returns the primary key of this richiesta interventi.
	*
	* @return the primary key of this richiesta interventi
	*/
	@Override
	public long getPrimaryKey() {
		return _richiestaInterventi.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.RichiestaInterventi toEscapedModel() {
		return new RichiestaInterventiWrapper(_richiestaInterventi.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.RichiestaInterventi toUnescapedModel() {
		return new RichiestaInterventiWrapper(_richiestaInterventi.toUnescapedModel());
	}

	@Override
	public void persist() {
		_richiestaInterventi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiestaInterventi.setCachedModel(cachedModel);
	}

	/**
	* Sets the data_interventi of this richiesta interventi.
	*
	* @param data_interventi the data_interventi of this richiesta interventi
	*/
	@Override
	public void setData_interventi(Date data_interventi) {
		_richiestaInterventi.setData_interventi(data_interventi);
	}

	/**
	* Sets the dettaglio of this richiesta interventi.
	*
	* @param dettaglio the dettaglio of this richiesta interventi
	*/
	@Override
	public void setDettaglio(java.lang.String dettaglio) {
		_richiestaInterventi.setDettaglio(dettaglio);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiestaInterventi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiestaInterventi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiestaInterventi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this richiesta interventi.
	*
	* @param id the ID of this richiesta interventi
	*/
	@Override
	public void setId(long id) {
		_richiestaInterventi.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_richiestaInterventi.setNew(n);
	}

	/**
	* Sets the primary key of this richiesta interventi.
	*
	* @param primaryKey the primary key of this richiesta interventi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiestaInterventi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiestaInterventi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the utente of this richiesta interventi.
	*
	* @param utente the utente of this richiesta interventi
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_richiestaInterventi.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaInterventiWrapper)) {
			return false;
		}

		RichiestaInterventiWrapper richiestaInterventiWrapper = (RichiestaInterventiWrapper)obj;

		if (Objects.equals(_richiestaInterventi,
					richiestaInterventiWrapper._richiestaInterventi)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiestaInterventi getWrappedModel() {
		return _richiestaInterventi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiestaInterventi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiestaInterventi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiestaInterventi.resetOriginalValues();
	}

	private final RichiestaInterventi _richiestaInterventi;
}