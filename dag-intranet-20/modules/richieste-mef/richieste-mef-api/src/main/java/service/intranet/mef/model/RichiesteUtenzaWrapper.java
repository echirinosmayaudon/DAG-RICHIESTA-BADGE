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
 * This class is a wrapper for {@link RichiesteUtenza}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteUtenza
 * @generated
 */
@ProviderType
public class RichiesteUtenzaWrapper implements RichiesteUtenza,
	ModelWrapper<RichiesteUtenza> {
	public RichiesteUtenzaWrapper(RichiesteUtenza richiesteUtenza) {
		_richiesteUtenza = richiesteUtenza;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiesteUtenza.class;
	}

	@Override
	public String getModelClassName() {
		return RichiesteUtenza.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_richieste_utenza", getId_richieste_utenza());
		attributes.put("utente", getUtente());
		attributes.put("destinatario", getDestinatario());
		attributes.put("dettaglio", getDettaglio());
		attributes.put("data_richiesta", getData_richiesta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_richieste_utenza = (Long)attributes.get("id_richieste_utenza");

		if (id_richieste_utenza != null) {
			setId_richieste_utenza(id_richieste_utenza);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		String destinatario = (String)attributes.get("destinatario");

		if (destinatario != null) {
			setDestinatario(destinatario);
		}

		String dettaglio = (String)attributes.get("dettaglio");

		if (dettaglio != null) {
			setDettaglio(dettaglio);
		}

		Date data_richiesta = (Date)attributes.get("data_richiesta");

		if (data_richiesta != null) {
			setData_richiesta(data_richiesta);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _richiesteUtenza.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiesteUtenza.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiesteUtenza.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiesteUtenza.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.RichiesteUtenza> toCacheModel() {
		return _richiesteUtenza.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.RichiesteUtenza richiesteUtenza) {
		return _richiesteUtenza.compareTo(richiesteUtenza);
	}

	@Override
	public int hashCode() {
		return _richiesteUtenza.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiesteUtenza.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiesteUtenzaWrapper((RichiesteUtenza)_richiesteUtenza.clone());
	}

	/**
	* Returns the destinatario of this richieste utenza.
	*
	* @return the destinatario of this richieste utenza
	*/
	@Override
	public java.lang.String getDestinatario() {
		return _richiesteUtenza.getDestinatario();
	}

	/**
	* Returns the dettaglio of this richieste utenza.
	*
	* @return the dettaglio of this richieste utenza
	*/
	@Override
	public java.lang.String getDettaglio() {
		return _richiesteUtenza.getDettaglio();
	}

	/**
	* Returns the utente of this richieste utenza.
	*
	* @return the utente of this richieste utenza
	*/
	@Override
	public java.lang.String getUtente() {
		return _richiesteUtenza.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _richiesteUtenza.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiesteUtenza.toXmlString();
	}

	/**
	* Returns the data_richiesta of this richieste utenza.
	*
	* @return the data_richiesta of this richieste utenza
	*/
	@Override
	public Date getData_richiesta() {
		return _richiesteUtenza.getData_richiesta();
	}

	/**
	* Returns the id_richieste_utenza of this richieste utenza.
	*
	* @return the id_richieste_utenza of this richieste utenza
	*/
	@Override
	public long getId_richieste_utenza() {
		return _richiesteUtenza.getId_richieste_utenza();
	}

	/**
	* Returns the primary key of this richieste utenza.
	*
	* @return the primary key of this richieste utenza
	*/
	@Override
	public long getPrimaryKey() {
		return _richiesteUtenza.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.RichiesteUtenza toEscapedModel() {
		return new RichiesteUtenzaWrapper(_richiesteUtenza.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.RichiesteUtenza toUnescapedModel() {
		return new RichiesteUtenzaWrapper(_richiesteUtenza.toUnescapedModel());
	}

	@Override
	public void persist() {
		_richiesteUtenza.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiesteUtenza.setCachedModel(cachedModel);
	}

	/**
	* Sets the data_richiesta of this richieste utenza.
	*
	* @param data_richiesta the data_richiesta of this richieste utenza
	*/
	@Override
	public void setData_richiesta(Date data_richiesta) {
		_richiesteUtenza.setData_richiesta(data_richiesta);
	}

	/**
	* Sets the destinatario of this richieste utenza.
	*
	* @param destinatario the destinatario of this richieste utenza
	*/
	@Override
	public void setDestinatario(java.lang.String destinatario) {
		_richiesteUtenza.setDestinatario(destinatario);
	}

	/**
	* Sets the dettaglio of this richieste utenza.
	*
	* @param dettaglio the dettaglio of this richieste utenza
	*/
	@Override
	public void setDettaglio(java.lang.String dettaglio) {
		_richiesteUtenza.setDettaglio(dettaglio);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiesteUtenza.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiesteUtenza.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiesteUtenza.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_richieste_utenza of this richieste utenza.
	*
	* @param id_richieste_utenza the id_richieste_utenza of this richieste utenza
	*/
	@Override
	public void setId_richieste_utenza(long id_richieste_utenza) {
		_richiesteUtenza.setId_richieste_utenza(id_richieste_utenza);
	}

	@Override
	public void setNew(boolean n) {
		_richiesteUtenza.setNew(n);
	}

	/**
	* Sets the primary key of this richieste utenza.
	*
	* @param primaryKey the primary key of this richieste utenza
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiesteUtenza.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiesteUtenza.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the utente of this richieste utenza.
	*
	* @param utente the utente of this richieste utenza
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_richiesteUtenza.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteUtenzaWrapper)) {
			return false;
		}

		RichiesteUtenzaWrapper richiesteUtenzaWrapper = (RichiesteUtenzaWrapper)obj;

		if (Objects.equals(_richiesteUtenza,
					richiesteUtenzaWrapper._richiesteUtenza)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiesteUtenza getWrappedModel() {
		return _richiesteUtenza;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiesteUtenza.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiesteUtenza.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiesteUtenza.resetOriginalValues();
	}

	private final RichiesteUtenza _richiesteUtenza;
}