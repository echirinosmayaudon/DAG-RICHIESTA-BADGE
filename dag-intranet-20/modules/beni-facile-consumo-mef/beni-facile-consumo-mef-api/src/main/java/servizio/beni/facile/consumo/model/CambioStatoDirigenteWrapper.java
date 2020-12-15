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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CambioStatoDirigente}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CambioStatoDirigente
 * @generated
 */
@ProviderType
public class CambioStatoDirigenteWrapper implements CambioStatoDirigente,
	ModelWrapper<CambioStatoDirigente> {
	public CambioStatoDirigenteWrapper(
		CambioStatoDirigente cambioStatoDirigente) {
		_cambioStatoDirigente = cambioStatoDirigente;
	}

	@Override
	public Class<?> getModelClass() {
		return CambioStatoDirigente.class;
	}

	@Override
	public String getModelClassName() {
		return CambioStatoDirigente.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("id_rich", getId_rich());
		attributes.put("data", getData());
		attributes.put("utente", getUtente());
		attributes.put("id_stato", getId_stato());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long id_rich = (Long)attributes.get("id_rich");

		if (id_rich != null) {
			setId_rich(id_rich);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		Long id_stato = (Long)attributes.get("id_stato");

		if (id_stato != null) {
			setId_stato(id_stato);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _cambioStatoDirigente.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cambioStatoDirigente.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cambioStatoDirigente.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cambioStatoDirigente.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.beni.facile.consumo.model.CambioStatoDirigente> toCacheModel() {
		return _cambioStatoDirigente.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.beni.facile.consumo.model.CambioStatoDirigente cambioStatoDirigente) {
		return _cambioStatoDirigente.compareTo(cambioStatoDirigente);
	}

	@Override
	public int hashCode() {
		return _cambioStatoDirigente.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cambioStatoDirigente.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CambioStatoDirigenteWrapper((CambioStatoDirigente)_cambioStatoDirigente.clone());
	}

	/**
	* Returns the note of this cambio stato dirigente.
	*
	* @return the note of this cambio stato dirigente
	*/
	@Override
	public java.lang.String getNote() {
		return _cambioStatoDirigente.getNote();
	}

	/**
	* Returns the utente of this cambio stato dirigente.
	*
	* @return the utente of this cambio stato dirigente
	*/
	@Override
	public java.lang.String getUtente() {
		return _cambioStatoDirigente.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _cambioStatoDirigente.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cambioStatoDirigente.toXmlString();
	}

	/**
	* Returns the data of this cambio stato dirigente.
	*
	* @return the data of this cambio stato dirigente
	*/
	@Override
	public Date getData() {
		return _cambioStatoDirigente.getData();
	}

	/**
	* Returns the ID of this cambio stato dirigente.
	*
	* @return the ID of this cambio stato dirigente
	*/
	@Override
	public long getId() {
		return _cambioStatoDirigente.getId();
	}

	/**
	* Returns the id_rich of this cambio stato dirigente.
	*
	* @return the id_rich of this cambio stato dirigente
	*/
	@Override
	public long getId_rich() {
		return _cambioStatoDirigente.getId_rich();
	}

	/**
	* Returns the id_stato of this cambio stato dirigente.
	*
	* @return the id_stato of this cambio stato dirigente
	*/
	@Override
	public long getId_stato() {
		return _cambioStatoDirigente.getId_stato();
	}

	/**
	* Returns the primary key of this cambio stato dirigente.
	*
	* @return the primary key of this cambio stato dirigente
	*/
	@Override
	public long getPrimaryKey() {
		return _cambioStatoDirigente.getPrimaryKey();
	}

	@Override
	public servizio.beni.facile.consumo.model.CambioStatoDirigente toEscapedModel() {
		return new CambioStatoDirigenteWrapper(_cambioStatoDirigente.toEscapedModel());
	}

	@Override
	public servizio.beni.facile.consumo.model.CambioStatoDirigente toUnescapedModel() {
		return new CambioStatoDirigenteWrapper(_cambioStatoDirigente.toUnescapedModel());
	}

	@Override
	public void persist() {
		_cambioStatoDirigente.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cambioStatoDirigente.setCachedModel(cachedModel);
	}

	/**
	* Sets the data of this cambio stato dirigente.
	*
	* @param data the data of this cambio stato dirigente
	*/
	@Override
	public void setData(Date data) {
		_cambioStatoDirigente.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cambioStatoDirigente.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cambioStatoDirigente.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cambioStatoDirigente.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this cambio stato dirigente.
	*
	* @param id the ID of this cambio stato dirigente
	*/
	@Override
	public void setId(long id) {
		_cambioStatoDirigente.setId(id);
	}

	/**
	* Sets the id_rich of this cambio stato dirigente.
	*
	* @param id_rich the id_rich of this cambio stato dirigente
	*/
	@Override
	public void setId_rich(long id_rich) {
		_cambioStatoDirigente.setId_rich(id_rich);
	}

	/**
	* Sets the id_stato of this cambio stato dirigente.
	*
	* @param id_stato the id_stato of this cambio stato dirigente
	*/
	@Override
	public void setId_stato(long id_stato) {
		_cambioStatoDirigente.setId_stato(id_stato);
	}

	@Override
	public void setNew(boolean n) {
		_cambioStatoDirigente.setNew(n);
	}

	/**
	* Sets the note of this cambio stato dirigente.
	*
	* @param note the note of this cambio stato dirigente
	*/
	@Override
	public void setNote(java.lang.String note) {
		_cambioStatoDirigente.setNote(note);
	}

	/**
	* Sets the primary key of this cambio stato dirigente.
	*
	* @param primaryKey the primary key of this cambio stato dirigente
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cambioStatoDirigente.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cambioStatoDirigente.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the utente of this cambio stato dirigente.
	*
	* @param utente the utente of this cambio stato dirigente
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_cambioStatoDirigente.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CambioStatoDirigenteWrapper)) {
			return false;
		}

		CambioStatoDirigenteWrapper cambioStatoDirigenteWrapper = (CambioStatoDirigenteWrapper)obj;

		if (Objects.equals(_cambioStatoDirigente,
					cambioStatoDirigenteWrapper._cambioStatoDirigente)) {
			return true;
		}

		return false;
	}

	@Override
	public CambioStatoDirigente getWrappedModel() {
		return _cambioStatoDirigente;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cambioStatoDirigente.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cambioStatoDirigente.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cambioStatoDirigente.resetOriginalValues();
	}

	private final CambioStatoDirigente _cambioStatoDirigente;
}