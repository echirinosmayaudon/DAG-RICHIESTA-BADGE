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

package servizio.richieste.badge.mef.model;

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

		attributes.put("id_gest_utenti", getId_gest_utenti());
		attributes.put("data", getData());
		attributes.put("screename_dirigente", getScreename_dirigente());
		attributes.put("screename_utente", getScreename_utente());
		attributes.put("id_ufficio", getId_ufficio());
		attributes.put("abilitazione", getAbilitazione());
		attributes.put("delega", getDelega());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_gest_utenti = (Long)attributes.get("id_gest_utenti");

		if (id_gest_utenti != null) {
			setId_gest_utenti(id_gest_utenti);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String screename_dirigente = (String)attributes.get(
				"screename_dirigente");

		if (screename_dirigente != null) {
			setScreename_dirigente(screename_dirigente);
		}

		String screename_utente = (String)attributes.get("screename_utente");

		if (screename_utente != null) {
			setScreename_utente(screename_utente);
		}

		Long id_ufficio = (Long)attributes.get("id_ufficio");

		if (id_ufficio != null) {
			setId_ufficio(id_ufficio);
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
	public com.liferay.portal.kernel.model.CacheModel<servizio.richieste.badge.mef.model.GestioneUtenti> toCacheModel() {
		return _gestioneUtenti.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.richieste.badge.mef.model.GestioneUtenti gestioneUtenti) {
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
	* Returns the screename_dirigente of this gestione utenti.
	*
	* @return the screename_dirigente of this gestione utenti
	*/
	@Override
	public java.lang.String getScreename_dirigente() {
		return _gestioneUtenti.getScreename_dirigente();
	}

	/**
	* Returns the screename_utente of this gestione utenti.
	*
	* @return the screename_utente of this gestione utenti
	*/
	@Override
	public java.lang.String getScreename_utente() {
		return _gestioneUtenti.getScreename_utente();
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
	* Returns the id_gest_utenti of this gestione utenti.
	*
	* @return the id_gest_utenti of this gestione utenti
	*/
	@Override
	public long getId_gest_utenti() {
		return _gestioneUtenti.getId_gest_utenti();
	}

	/**
	* Returns the id_ufficio of this gestione utenti.
	*
	* @return the id_ufficio of this gestione utenti
	*/
	@Override
	public long getId_ufficio() {
		return _gestioneUtenti.getId_ufficio();
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
	public servizio.richieste.badge.mef.model.GestioneUtenti toEscapedModel() {
		return new GestioneUtentiWrapper(_gestioneUtenti.toEscapedModel());
	}

	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti toUnescapedModel() {
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
	* Sets the id_gest_utenti of this gestione utenti.
	*
	* @param id_gest_utenti the id_gest_utenti of this gestione utenti
	*/
	@Override
	public void setId_gest_utenti(long id_gest_utenti) {
		_gestioneUtenti.setId_gest_utenti(id_gest_utenti);
	}

	/**
	* Sets the id_ufficio of this gestione utenti.
	*
	* @param id_ufficio the id_ufficio of this gestione utenti
	*/
	@Override
	public void setId_ufficio(long id_ufficio) {
		_gestioneUtenti.setId_ufficio(id_ufficio);
	}

	@Override
	public void setNew(boolean n) {
		_gestioneUtenti.setNew(n);
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
	* Sets the screename_dirigente of this gestione utenti.
	*
	* @param screename_dirigente the screename_dirigente of this gestione utenti
	*/
	@Override
	public void setScreename_dirigente(java.lang.String screename_dirigente) {
		_gestioneUtenti.setScreename_dirigente(screename_dirigente);
	}

	/**
	* Sets the screename_utente of this gestione utenti.
	*
	* @param screename_utente the screename_utente of this gestione utenti
	*/
	@Override
	public void setScreename_utente(java.lang.String screename_utente) {
		_gestioneUtenti.setScreename_utente(screename_utente);
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