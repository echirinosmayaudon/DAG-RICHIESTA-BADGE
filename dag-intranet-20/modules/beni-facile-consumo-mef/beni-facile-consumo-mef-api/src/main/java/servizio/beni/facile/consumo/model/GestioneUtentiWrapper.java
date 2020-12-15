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
 * This class is a wrapper for {@link GestioneUtenti}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtenti
 * @generated
 */
@ProviderType
public class GestioneUtentiWrapper implements GestioneUtenti,
	ModelWrapper<GestioneUtenti> {
	public GestioneUtentiWrapper(GestioneUtenti gestioneUtenti) {
		_gestioneUtenti = gestioneUtenti;
	}

	@Override
	public Class<?> getModelClass() {
		return GestioneUtenti.class;
	}

	@Override
	public String getModelClassName() {
		return GestioneUtenti.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("data", getData());
		attributes.put("cod_fiscale", getCod_fiscale());
		attributes.put("nome", getNome());
		attributes.put("cognome", getCognome());
		attributes.put("ufficio", getUfficio());
		attributes.put("abilitazione", getAbilitazione());
		attributes.put("delega", getDelega());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String cod_fiscale = (String)attributes.get("cod_fiscale");

		if (cod_fiscale != null) {
			setCod_fiscale(cod_fiscale);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String cognome = (String)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		String ufficio = (String)attributes.get("ufficio");

		if (ufficio != null) {
			setUfficio(ufficio);
		}

		Boolean abilitazione = (Boolean)attributes.get("abilitazione");

		if (abilitazione != null) {
			setAbilitazione(abilitazione);
		}

		Boolean delega = (Boolean)attributes.get("delega");

		if (delega != null) {
			setDelega(delega);
		}
	}

	/**
	* Returns the abilitazione of this gestione utenti.
	*
	* @return the abilitazione of this gestione utenti
	*/
	@Override
	public boolean getAbilitazione() {
		return _gestioneUtenti.getAbilitazione();
	}

	/**
	* Returns the delega of this gestione utenti.
	*
	* @return the delega of this gestione utenti
	*/
	@Override
	public boolean getDelega() {
		return _gestioneUtenti.getDelega();
	}

	/**
	* Returns <code>true</code> if this gestione utenti is abilitazione.
	*
	* @return <code>true</code> if this gestione utenti is abilitazione; <code>false</code> otherwise
	*/
	@Override
	public boolean isAbilitazione() {
		return _gestioneUtenti.isAbilitazione();
	}

	@Override
	public boolean isCachedModel() {
		return _gestioneUtenti.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this gestione utenti is delega.
	*
	* @return <code>true</code> if this gestione utenti is delega; <code>false</code> otherwise
	*/
	@Override
	public boolean isDelega() {
		return _gestioneUtenti.isDelega();
	}

	@Override
	public boolean isEscapedModel() {
		return _gestioneUtenti.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _gestioneUtenti.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _gestioneUtenti.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.beni.facile.consumo.model.GestioneUtenti> toCacheModel() {
		return _gestioneUtenti.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.beni.facile.consumo.model.GestioneUtenti gestioneUtenti) {
		return _gestioneUtenti.compareTo(gestioneUtenti);
	}

	@Override
	public int hashCode() {
		return _gestioneUtenti.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gestioneUtenti.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new GestioneUtentiWrapper((GestioneUtenti)_gestioneUtenti.clone());
	}

	/**
	* Returns the cod_fiscale of this gestione utenti.
	*
	* @return the cod_fiscale of this gestione utenti
	*/
	@Override
	public java.lang.String getCod_fiscale() {
		return _gestioneUtenti.getCod_fiscale();
	}

	/**
	* Returns the cognome of this gestione utenti.
	*
	* @return the cognome of this gestione utenti
	*/
	@Override
	public java.lang.String getCognome() {
		return _gestioneUtenti.getCognome();
	}

	/**
	* Returns the nome of this gestione utenti.
	*
	* @return the nome of this gestione utenti
	*/
	@Override
	public java.lang.String getNome() {
		return _gestioneUtenti.getNome();
	}

	/**
	* Returns the ufficio of this gestione utenti.
	*
	* @return the ufficio of this gestione utenti
	*/
	@Override
	public java.lang.String getUfficio() {
		return _gestioneUtenti.getUfficio();
	}

	@Override
	public java.lang.String toString() {
		return _gestioneUtenti.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gestioneUtenti.toXmlString();
	}

	/**
	* Returns the data of this gestione utenti.
	*
	* @return the data of this gestione utenti
	*/
	@Override
	public Date getData() {
		return _gestioneUtenti.getData();
	}

	/**
	* Returns the ID of this gestione utenti.
	*
	* @return the ID of this gestione utenti
	*/
	@Override
	public long getId() {
		return _gestioneUtenti.getId();
	}

	/**
	* Returns the primary key of this gestione utenti.
	*
	* @return the primary key of this gestione utenti
	*/
	@Override
	public long getPrimaryKey() {
		return _gestioneUtenti.getPrimaryKey();
	}

	@Override
	public servizio.beni.facile.consumo.model.GestioneUtenti toEscapedModel() {
		return new GestioneUtentiWrapper(_gestioneUtenti.toEscapedModel());
	}

	@Override
	public servizio.beni.facile.consumo.model.GestioneUtenti toUnescapedModel() {
		return new GestioneUtentiWrapper(_gestioneUtenti.toUnescapedModel());
	}

	@Override
	public void persist() {
		_gestioneUtenti.persist();
	}

	/**
	* Sets whether this gestione utenti is abilitazione.
	*
	* @param abilitazione the abilitazione of this gestione utenti
	*/
	@Override
	public void setAbilitazione(boolean abilitazione) {
		_gestioneUtenti.setAbilitazione(abilitazione);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gestioneUtenti.setCachedModel(cachedModel);
	}

	/**
	* Sets the cod_fiscale of this gestione utenti.
	*
	* @param cod_fiscale the cod_fiscale of this gestione utenti
	*/
	@Override
	public void setCod_fiscale(java.lang.String cod_fiscale) {
		_gestioneUtenti.setCod_fiscale(cod_fiscale);
	}

	/**
	* Sets the cognome of this gestione utenti.
	*
	* @param cognome the cognome of this gestione utenti
	*/
	@Override
	public void setCognome(java.lang.String cognome) {
		_gestioneUtenti.setCognome(cognome);
	}

	/**
	* Sets the data of this gestione utenti.
	*
	* @param data the data of this gestione utenti
	*/
	@Override
	public void setData(Date data) {
		_gestioneUtenti.setData(data);
	}

	/**
	* Sets whether this gestione utenti is delega.
	*
	* @param delega the delega of this gestione utenti
	*/
	@Override
	public void setDelega(boolean delega) {
		_gestioneUtenti.setDelega(delega);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_gestioneUtenti.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_gestioneUtenti.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_gestioneUtenti.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this gestione utenti.
	*
	* @param id the ID of this gestione utenti
	*/
	@Override
	public void setId(long id) {
		_gestioneUtenti.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_gestioneUtenti.setNew(n);
	}

	/**
	* Sets the nome of this gestione utenti.
	*
	* @param nome the nome of this gestione utenti
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_gestioneUtenti.setNome(nome);
	}

	/**
	* Sets the primary key of this gestione utenti.
	*
	* @param primaryKey the primary key of this gestione utenti
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gestioneUtenti.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_gestioneUtenti.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the ufficio of this gestione utenti.
	*
	* @param ufficio the ufficio of this gestione utenti
	*/
	@Override
	public void setUfficio(java.lang.String ufficio) {
		_gestioneUtenti.setUfficio(ufficio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GestioneUtentiWrapper)) {
			return false;
		}

		GestioneUtentiWrapper gestioneUtentiWrapper = (GestioneUtentiWrapper)obj;

		if (Objects.equals(_gestioneUtenti,
					gestioneUtentiWrapper._gestioneUtenti)) {
			return true;
		}

		return false;
	}

	@Override
	public GestioneUtenti getWrappedModel() {
		return _gestioneUtenti;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _gestioneUtenti.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _gestioneUtenti.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_gestioneUtenti.resetOriginalValues();
	}

	private final GestioneUtenti _gestioneUtenti;
}