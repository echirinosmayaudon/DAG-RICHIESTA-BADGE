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

package form.service.contributo.solidarieta.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Donatore}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Donatore
 * @generated
 */
public class DonatoreWrapper implements Donatore, ModelWrapper<Donatore> {

	public DonatoreWrapper(Donatore donatore) {
		_donatore = donatore;
	}

	@Override
	public Class<?> getModelClass() {
		return Donatore.class;
	}

	@Override
	public String getModelClassName() {
		return Donatore.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("cognome", getCognome());
		attributes.put("cod_fiscale", getCod_fiscale());
		attributes.put("email", getEmail());
		attributes.put("importo", getImporto());
		attributes.put("data_inserimento", getData_inserimento());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String cognome = (String)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		String cod_fiscale = (String)attributes.get("cod_fiscale");

		if (cod_fiscale != null) {
			setCod_fiscale(cod_fiscale);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String importo = (String)attributes.get("importo");

		if (importo != null) {
			setImporto(importo);
		}

		String data_inserimento = (String)attributes.get("data_inserimento");

		if (data_inserimento != null) {
			setData_inserimento(data_inserimento);
		}
	}

	@Override
	public Object clone() {
		return new DonatoreWrapper((Donatore)_donatore.clone());
	}

	@Override
	public int compareTo(
		form.service.contributo.solidarieta.model.Donatore donatore) {

		return _donatore.compareTo(donatore);
	}

	/**
	 * Returns the cod_fiscale of this donatore.
	 *
	 * @return the cod_fiscale of this donatore
	 */
	@Override
	public String getCod_fiscale() {
		return _donatore.getCod_fiscale();
	}

	/**
	 * Returns the cognome of this donatore.
	 *
	 * @return the cognome of this donatore
	 */
	@Override
	public String getCognome() {
		return _donatore.getCognome();
	}

	/**
	 * Returns the data_inserimento of this donatore.
	 *
	 * @return the data_inserimento of this donatore
	 */
	@Override
	public String getData_inserimento() {
		return _donatore.getData_inserimento();
	}

	/**
	 * Returns the email of this donatore.
	 *
	 * @return the email of this donatore
	 */
	@Override
	public String getEmail() {
		return _donatore.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _donatore.getExpandoBridge();
	}

	/**
	 * Returns the ID of this donatore.
	 *
	 * @return the ID of this donatore
	 */
	@Override
	public long getId() {
		return _donatore.getId();
	}

	/**
	 * Returns the importo of this donatore.
	 *
	 * @return the importo of this donatore
	 */
	@Override
	public String getImporto() {
		return _donatore.getImporto();
	}

	/**
	 * Returns the nome of this donatore.
	 *
	 * @return the nome of this donatore
	 */
	@Override
	public String getNome() {
		return _donatore.getNome();
	}

	/**
	 * Returns the primary key of this donatore.
	 *
	 * @return the primary key of this donatore
	 */
	@Override
	public long getPrimaryKey() {
		return _donatore.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _donatore.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _donatore.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _donatore.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _donatore.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _donatore.isNew();
	}

	@Override
	public void persist() {
		_donatore.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_donatore.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cod_fiscale of this donatore.
	 *
	 * @param cod_fiscale the cod_fiscale of this donatore
	 */
	@Override
	public void setCod_fiscale(String cod_fiscale) {
		_donatore.setCod_fiscale(cod_fiscale);
	}

	/**
	 * Sets the cognome of this donatore.
	 *
	 * @param cognome the cognome of this donatore
	 */
	@Override
	public void setCognome(String cognome) {
		_donatore.setCognome(cognome);
	}

	/**
	 * Sets the data_inserimento of this donatore.
	 *
	 * @param data_inserimento the data_inserimento of this donatore
	 */
	@Override
	public void setData_inserimento(String data_inserimento) {
		_donatore.setData_inserimento(data_inserimento);
	}

	/**
	 * Sets the email of this donatore.
	 *
	 * @param email the email of this donatore
	 */
	@Override
	public void setEmail(String email) {
		_donatore.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_donatore.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_donatore.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_donatore.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this donatore.
	 *
	 * @param id the ID of this donatore
	 */
	@Override
	public void setId(long id) {
		_donatore.setId(id);
	}

	/**
	 * Sets the importo of this donatore.
	 *
	 * @param importo the importo of this donatore
	 */
	@Override
	public void setImporto(String importo) {
		_donatore.setImporto(importo);
	}

	@Override
	public void setNew(boolean n) {
		_donatore.setNew(n);
	}

	/**
	 * Sets the nome of this donatore.
	 *
	 * @param nome the nome of this donatore
	 */
	@Override
	public void setNome(String nome) {
		_donatore.setNome(nome);
	}

	/**
	 * Sets the primary key of this donatore.
	 *
	 * @param primaryKey the primary key of this donatore
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_donatore.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_donatore.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<form.service.contributo.solidarieta.model.Donatore> toCacheModel() {

		return _donatore.toCacheModel();
	}

	@Override
	public form.service.contributo.solidarieta.model.Donatore toEscapedModel() {
		return new DonatoreWrapper(_donatore.toEscapedModel());
	}

	@Override
	public String toString() {
		return _donatore.toString();
	}

	@Override
	public form.service.contributo.solidarieta.model.Donatore
		toUnescapedModel() {

		return new DonatoreWrapper(_donatore.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _donatore.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DonatoreWrapper)) {
			return false;
		}

		DonatoreWrapper donatoreWrapper = (DonatoreWrapper)obj;

		if (Objects.equals(_donatore, donatoreWrapper._donatore)) {
			return true;
		}

		return false;
	}

	@Override
	public Donatore getWrappedModel() {
		return _donatore;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _donatore.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _donatore.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_donatore.resetOriginalValues();
	}

	private final Donatore _donatore;

}