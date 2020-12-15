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
 * This class is a wrapper for {@link Segreteria}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Segreteria
 * @generated
 */
@ProviderType
public class SegreteriaWrapper implements Segreteria, ModelWrapper<Segreteria> {
	public SegreteriaWrapper(Segreteria segreteria) {
		_segreteria = segreteria;
	}

	@Override
	public Class<?> getModelClass() {
		return Segreteria.class;
	}

	@Override
	public String getModelClassName() {
		return Segreteria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_segreteria", getId_segreteria());
		attributes.put("email", getEmail());
		attributes.put("descrizione", getDescrizione());
		attributes.put("acronimo", getAcronimo());
		attributes.put("livello_gerarchia", getLivello_gerarchia());
		attributes.put("cod_padre", getCod_padre());
		attributes.put("data_fine_esistenza", getData_fine_esistenza());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("cap", getCap());
		attributes.put("cod_istat_citta", getCod_istat_citta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_segreteria = (Long)attributes.get("id_segreteria");

		if (id_segreteria != null) {
			setId_segreteria(id_segreteria);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String acronimo = (String)attributes.get("acronimo");

		if (acronimo != null) {
			setAcronimo(acronimo);
		}

		Long livello_gerarchia = (Long)attributes.get("livello_gerarchia");

		if (livello_gerarchia != null) {
			setLivello_gerarchia(livello_gerarchia);
		}

		Long cod_padre = (Long)attributes.get("cod_padre");

		if (cod_padre != null) {
			setCod_padre(cod_padre);
		}

		Date data_fine_esistenza = (Date)attributes.get("data_fine_esistenza");

		if (data_fine_esistenza != null) {
			setData_fine_esistenza(data_fine_esistenza);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String cap = (String)attributes.get("cap");

		if (cap != null) {
			setCap(cap);
		}

		Long cod_istat_citta = (Long)attributes.get("cod_istat_citta");

		if (cod_istat_citta != null) {
			setCod_istat_citta(cod_istat_citta);
		}
	}

	@Override
	public Segreteria toEscapedModel() {
		return new SegreteriaWrapper(_segreteria.toEscapedModel());
	}

	@Override
	public Segreteria toUnescapedModel() {
		return new SegreteriaWrapper(_segreteria.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _segreteria.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _segreteria.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _segreteria.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _segreteria.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Segreteria> toCacheModel() {
		return _segreteria.toCacheModel();
	}

	@Override
	public int compareTo(Segreteria segreteria) {
		return _segreteria.compareTo(segreteria);
	}

	@Override
	public int hashCode() {
		return _segreteria.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _segreteria.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SegreteriaWrapper((Segreteria)_segreteria.clone());
	}

	/**
	* Returns the acronimo of this segreteria.
	*
	* @return the acronimo of this segreteria
	*/
	@Override
	public java.lang.String getAcronimo() {
		return _segreteria.getAcronimo();
	}

	/**
	* Returns the cap of this segreteria.
	*
	* @return the cap of this segreteria
	*/
	@Override
	public java.lang.String getCap() {
		return _segreteria.getCap();
	}

	/**
	* Returns the descrizione of this segreteria.
	*
	* @return the descrizione of this segreteria
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _segreteria.getDescrizione();
	}

	/**
	* Returns the email of this segreteria.
	*
	* @return the email of this segreteria
	*/
	@Override
	public java.lang.String getEmail() {
		return _segreteria.getEmail();
	}

	/**
	* Returns the indirizzo of this segreteria.
	*
	* @return the indirizzo of this segreteria
	*/
	@Override
	public java.lang.String getIndirizzo() {
		return _segreteria.getIndirizzo();
	}

	@Override
	public java.lang.String toString() {
		return _segreteria.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _segreteria.toXmlString();
	}

	/**
	* Returns the data_fine_esistenza of this segreteria.
	*
	* @return the data_fine_esistenza of this segreteria
	*/
	@Override
	public Date getData_fine_esistenza() {
		return _segreteria.getData_fine_esistenza();
	}

	/**
	* Returns the cod_istat_citta of this segreteria.
	*
	* @return the cod_istat_citta of this segreteria
	*/
	@Override
	public long getCod_istat_citta() {
		return _segreteria.getCod_istat_citta();
	}

	/**
	* Returns the cod_padre of this segreteria.
	*
	* @return the cod_padre of this segreteria
	*/
	@Override
	public long getCod_padre() {
		return _segreteria.getCod_padre();
	}

	/**
	* Returns the id_segreteria of this segreteria.
	*
	* @return the id_segreteria of this segreteria
	*/
	@Override
	public long getId_segreteria() {
		return _segreteria.getId_segreteria();
	}

	/**
	* Returns the livello_gerarchia of this segreteria.
	*
	* @return the livello_gerarchia of this segreteria
	*/
	@Override
	public long getLivello_gerarchia() {
		return _segreteria.getLivello_gerarchia();
	}

	/**
	* Returns the primary key of this segreteria.
	*
	* @return the primary key of this segreteria
	*/
	@Override
	public long getPrimaryKey() {
		return _segreteria.getPrimaryKey();
	}

	@Override
	public void persist() {
		_segreteria.persist();
	}

	/**
	* Sets the acronimo of this segreteria.
	*
	* @param acronimo the acronimo of this segreteria
	*/
	@Override
	public void setAcronimo(java.lang.String acronimo) {
		_segreteria.setAcronimo(acronimo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_segreteria.setCachedModel(cachedModel);
	}

	/**
	* Sets the cap of this segreteria.
	*
	* @param cap the cap of this segreteria
	*/
	@Override
	public void setCap(java.lang.String cap) {
		_segreteria.setCap(cap);
	}

	/**
	* Sets the cod_istat_citta of this segreteria.
	*
	* @param cod_istat_citta the cod_istat_citta of this segreteria
	*/
	@Override
	public void setCod_istat_citta(long cod_istat_citta) {
		_segreteria.setCod_istat_citta(cod_istat_citta);
	}

	/**
	* Sets the cod_padre of this segreteria.
	*
	* @param cod_padre the cod_padre of this segreteria
	*/
	@Override
	public void setCod_padre(long cod_padre) {
		_segreteria.setCod_padre(cod_padre);
	}

	/**
	* Sets the data_fine_esistenza of this segreteria.
	*
	* @param data_fine_esistenza the data_fine_esistenza of this segreteria
	*/
	@Override
	public void setData_fine_esistenza(Date data_fine_esistenza) {
		_segreteria.setData_fine_esistenza(data_fine_esistenza);
	}

	/**
	* Sets the descrizione of this segreteria.
	*
	* @param descrizione the descrizione of this segreteria
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_segreteria.setDescrizione(descrizione);
	}

	/**
	* Sets the email of this segreteria.
	*
	* @param email the email of this segreteria
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_segreteria.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_segreteria.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_segreteria.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_segreteria.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_segreteria of this segreteria.
	*
	* @param id_segreteria the id_segreteria of this segreteria
	*/
	@Override
	public void setId_segreteria(long id_segreteria) {
		_segreteria.setId_segreteria(id_segreteria);
	}

	/**
	* Sets the indirizzo of this segreteria.
	*
	* @param indirizzo the indirizzo of this segreteria
	*/
	@Override
	public void setIndirizzo(java.lang.String indirizzo) {
		_segreteria.setIndirizzo(indirizzo);
	}

	/**
	* Sets the livello_gerarchia of this segreteria.
	*
	* @param livello_gerarchia the livello_gerarchia of this segreteria
	*/
	@Override
	public void setLivello_gerarchia(long livello_gerarchia) {
		_segreteria.setLivello_gerarchia(livello_gerarchia);
	}

	@Override
	public void setNew(boolean n) {
		_segreteria.setNew(n);
	}

	/**
	* Sets the primary key of this segreteria.
	*
	* @param primaryKey the primary key of this segreteria
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_segreteria.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_segreteria.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegreteriaWrapper)) {
			return false;
		}

		SegreteriaWrapper segreteriaWrapper = (SegreteriaWrapper)obj;

		if (Objects.equals(_segreteria, segreteriaWrapper._segreteria)) {
			return true;
		}

		return false;
	}

	@Override
	public Segreteria getWrappedModel() {
		return _segreteria;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _segreteria.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _segreteria.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_segreteria.resetOriginalValues();
	}

	private final Segreteria _segreteria;
}