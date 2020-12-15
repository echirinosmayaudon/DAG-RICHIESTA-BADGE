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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Riunione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Riunione
 * @generated
 */
@ProviderType
public class RiunioneWrapper implements Riunione, ModelWrapper<Riunione> {
	public RiunioneWrapper(Riunione riunione) {
		_riunione = riunione;
	}

	@Override
	public Class<?> getModelClass() {
		return Riunione.class;
	}

	@Override
	public String getModelClassName() {
		return Riunione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_riunione", getId_riunione());
		attributes.put("oggetto", getOggetto());
		attributes.put("data_inizio", getData_inizio());
		attributes.put("data_fine", getData_fine());
		attributes.put("note", getNote());
		attributes.put("data_modifica", getData_modifica());
		attributes.put("data_creazione", getData_creazione());
		attributes.put("protocollo", getProtocollo());
		attributes.put("id_stato_riunione", getId_stato_riunione());
		attributes.put("id_tipo", getId_tipo());
		attributes.put("id_luogo", getId_luogo());
		attributes.put("id_amministrazione_convocante",
			getId_amministrazione_convocante());
		attributes.put("data_ultimo_sollecito", getData_ultimo_sollecito());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_riunione = (Long)attributes.get("id_riunione");

		if (id_riunione != null) {
			setId_riunione(id_riunione);
		}

		String oggetto = (String)attributes.get("oggetto");

		if (oggetto != null) {
			setOggetto(oggetto);
		}

		Date data_inizio = (Date)attributes.get("data_inizio");

		if (data_inizio != null) {
			setData_inizio(data_inizio);
		}

		Date data_fine = (Date)attributes.get("data_fine");

		if (data_fine != null) {
			setData_fine(data_fine);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Date data_modifica = (Date)attributes.get("data_modifica");

		if (data_modifica != null) {
			setData_modifica(data_modifica);
		}

		Date data_creazione = (Date)attributes.get("data_creazione");

		if (data_creazione != null) {
			setData_creazione(data_creazione);
		}

		String protocollo = (String)attributes.get("protocollo");

		if (protocollo != null) {
			setProtocollo(protocollo);
		}

		Long id_stato_riunione = (Long)attributes.get("id_stato_riunione");

		if (id_stato_riunione != null) {
			setId_stato_riunione(id_stato_riunione);
		}

		Long id_tipo = (Long)attributes.get("id_tipo");

		if (id_tipo != null) {
			setId_tipo(id_tipo);
		}

		Long id_luogo = (Long)attributes.get("id_luogo");

		if (id_luogo != null) {
			setId_luogo(id_luogo);
		}

		Long id_amministrazione_convocante = (Long)attributes.get(
				"id_amministrazione_convocante");

		if (id_amministrazione_convocante != null) {
			setId_amministrazione_convocante(id_amministrazione_convocante);
		}

		Date data_ultimo_sollecito = (Date)attributes.get(
				"data_ultimo_sollecito");

		if (data_ultimo_sollecito != null) {
			setData_ultimo_sollecito(data_ultimo_sollecito);
		}
	}

	@Override
	public Riunione toEscapedModel() {
		return new RiunioneWrapper(_riunione.toEscapedModel());
	}

	@Override
	public Riunione toUnescapedModel() {
		return new RiunioneWrapper(_riunione.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _riunione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _riunione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _riunione.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _riunione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Riunione> toCacheModel() {
		return _riunione.toCacheModel();
	}

	@Override
	public int compareTo(Riunione riunione) {
		return _riunione.compareTo(riunione);
	}

	@Override
	public int hashCode() {
		return _riunione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _riunione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RiunioneWrapper((Riunione)_riunione.clone());
	}

	/**
	* Returns the note of this riunione.
	*
	* @return the note of this riunione
	*/
	@Override
	public java.lang.String getNote() {
		return _riunione.getNote();
	}

	/**
	* Returns the oggetto of this riunione.
	*
	* @return the oggetto of this riunione
	*/
	@Override
	public java.lang.String getOggetto() {
		return _riunione.getOggetto();
	}

	/**
	* Returns the protocollo of this riunione.
	*
	* @return the protocollo of this riunione
	*/
	@Override
	public java.lang.String getProtocollo() {
		return _riunione.getProtocollo();
	}

	@Override
	public java.lang.String toString() {
		return _riunione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _riunione.toXmlString();
	}

	/**
	* Returns the data_creazione of this riunione.
	*
	* @return the data_creazione of this riunione
	*/
	@Override
	public Date getData_creazione() {
		return _riunione.getData_creazione();
	}

	/**
	* Returns the data_fine of this riunione.
	*
	* @return the data_fine of this riunione
	*/
	@Override
	public Date getData_fine() {
		return _riunione.getData_fine();
	}

	/**
	* Returns the data_inizio of this riunione.
	*
	* @return the data_inizio of this riunione
	*/
	@Override
	public Date getData_inizio() {
		return _riunione.getData_inizio();
	}

	/**
	* Returns the data_modifica of this riunione.
	*
	* @return the data_modifica of this riunione
	*/
	@Override
	public Date getData_modifica() {
		return _riunione.getData_modifica();
	}

	/**
	* Returns the data_ultimo_sollecito of this riunione.
	*
	* @return the data_ultimo_sollecito of this riunione
	*/
	@Override
	public Date getData_ultimo_sollecito() {
		return _riunione.getData_ultimo_sollecito();
	}

	/**
	* Returns the id_amministrazione_convocante of this riunione.
	*
	* @return the id_amministrazione_convocante of this riunione
	*/
	@Override
	public long getId_amministrazione_convocante() {
		return _riunione.getId_amministrazione_convocante();
	}

	/**
	* Returns the id_luogo of this riunione.
	*
	* @return the id_luogo of this riunione
	*/
	@Override
	public long getId_luogo() {
		return _riunione.getId_luogo();
	}

	/**
	* Returns the id_riunione of this riunione.
	*
	* @return the id_riunione of this riunione
	*/
	@Override
	public long getId_riunione() {
		return _riunione.getId_riunione();
	}

	/**
	* Returns the id_stato_riunione of this riunione.
	*
	* @return the id_stato_riunione of this riunione
	*/
	@Override
	public long getId_stato_riunione() {
		return _riunione.getId_stato_riunione();
	}

	/**
	* Returns the id_tipo of this riunione.
	*
	* @return the id_tipo of this riunione
	*/
	@Override
	public long getId_tipo() {
		return _riunione.getId_tipo();
	}

	/**
	* Returns the primary key of this riunione.
	*
	* @return the primary key of this riunione
	*/
	@Override
	public long getPrimaryKey() {
		return _riunione.getPrimaryKey();
	}

	@Override
	public void persist() {
		_riunione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_riunione.setCachedModel(cachedModel);
	}

	/**
	* Sets the data_creazione of this riunione.
	*
	* @param data_creazione the data_creazione of this riunione
	*/
	@Override
	public void setData_creazione(Date data_creazione) {
		_riunione.setData_creazione(data_creazione);
	}

	/**
	* Sets the data_fine of this riunione.
	*
	* @param data_fine the data_fine of this riunione
	*/
	@Override
	public void setData_fine(Date data_fine) {
		_riunione.setData_fine(data_fine);
	}

	/**
	* Sets the data_inizio of this riunione.
	*
	* @param data_inizio the data_inizio of this riunione
	*/
	@Override
	public void setData_inizio(Date data_inizio) {
		_riunione.setData_inizio(data_inizio);
	}

	/**
	* Sets the data_modifica of this riunione.
	*
	* @param data_modifica the data_modifica of this riunione
	*/
	@Override
	public void setData_modifica(Date data_modifica) {
		_riunione.setData_modifica(data_modifica);
	}

	/**
	* Sets the data_ultimo_sollecito of this riunione.
	*
	* @param data_ultimo_sollecito the data_ultimo_sollecito of this riunione
	*/
	@Override
	public void setData_ultimo_sollecito(Date data_ultimo_sollecito) {
		_riunione.setData_ultimo_sollecito(data_ultimo_sollecito);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_riunione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_riunione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_riunione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_amministrazione_convocante of this riunione.
	*
	* @param id_amministrazione_convocante the id_amministrazione_convocante of this riunione
	*/
	@Override
	public void setId_amministrazione_convocante(
		long id_amministrazione_convocante) {
		_riunione.setId_amministrazione_convocante(id_amministrazione_convocante);
	}

	/**
	* Sets the id_luogo of this riunione.
	*
	* @param id_luogo the id_luogo of this riunione
	*/
	@Override
	public void setId_luogo(long id_luogo) {
		_riunione.setId_luogo(id_luogo);
	}

	/**
	* Sets the id_riunione of this riunione.
	*
	* @param id_riunione the id_riunione of this riunione
	*/
	@Override
	public void setId_riunione(long id_riunione) {
		_riunione.setId_riunione(id_riunione);
	}

	/**
	* Sets the id_stato_riunione of this riunione.
	*
	* @param id_stato_riunione the id_stato_riunione of this riunione
	*/
	@Override
	public void setId_stato_riunione(long id_stato_riunione) {
		_riunione.setId_stato_riunione(id_stato_riunione);
	}

	/**
	* Sets the id_tipo of this riunione.
	*
	* @param id_tipo the id_tipo of this riunione
	*/
	@Override
	public void setId_tipo(long id_tipo) {
		_riunione.setId_tipo(id_tipo);
	}

	@Override
	public void setNew(boolean n) {
		_riunione.setNew(n);
	}

	/**
	* Sets the note of this riunione.
	*
	* @param note the note of this riunione
	*/
	@Override
	public void setNote(java.lang.String note) {
		_riunione.setNote(note);
	}

	/**
	* Sets the oggetto of this riunione.
	*
	* @param oggetto the oggetto of this riunione
	*/
	@Override
	public void setOggetto(java.lang.String oggetto) {
		_riunione.setOggetto(oggetto);
	}

	/**
	* Sets the primary key of this riunione.
	*
	* @param primaryKey the primary key of this riunione
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_riunione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_riunione.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the protocollo of this riunione.
	*
	* @param protocollo the protocollo of this riunione
	*/
	@Override
	public void setProtocollo(java.lang.String protocollo) {
		_riunione.setProtocollo(protocollo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RiunioneWrapper)) {
			return false;
		}

		RiunioneWrapper riunioneWrapper = (RiunioneWrapper)obj;

		if (Objects.equals(_riunione, riunioneWrapper._riunione)) {
			return true;
		}

		return false;
	}

	@Override
	public Riunione getWrappedModel() {
		return _riunione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _riunione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _riunione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_riunione.resetOriginalValues();
	}

	private final Riunione _riunione;
}