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
 * This class is a wrapper for {@link BadgeRichieste}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BadgeRichieste
 * @generated
 */
@ProviderType
public class BadgeRichiesteWrapper implements BadgeRichieste,
	ModelWrapper<BadgeRichieste> {
	public BadgeRichiesteWrapper(BadgeRichieste badgeRichieste) {
		_badgeRichieste = badgeRichieste;
	}

	@Override
	public Class<?> getModelClass() {
		return BadgeRichieste.class;
	}

	@Override
	public String getModelClassName() {
		return BadgeRichieste.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("utente", getUtente());
		attributes.put("dettaglio_richiedente", getDettaglio_richiedente());
		attributes.put("cognome", getCognome());
		attributes.put("nome", getNome());
		attributes.put("luogo_nascita", getLuogo_nascita());
		attributes.put("data_nascita", getData_nascita());
		attributes.put("codice_fiscale", getCodice_fiscale());
		attributes.put("numerobadge", getNumerobadge());
		attributes.put("allegatoUuid", getAllegatoUuid());
		attributes.put("operazione", getOperazione());
		attributes.put("data_richiesta", getData_richiesta());
		attributes.put("procedura", getProcedura());
		attributes.put("disattivazione", getDisattivazione());

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

		String dettaglio_richiedente = (String)attributes.get(
				"dettaglio_richiedente");

		if (dettaglio_richiedente != null) {
			setDettaglio_richiedente(dettaglio_richiedente);
		}

		String cognome = (String)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String luogo_nascita = (String)attributes.get("luogo_nascita");

		if (luogo_nascita != null) {
			setLuogo_nascita(luogo_nascita);
		}

		Date data_nascita = (Date)attributes.get("data_nascita");

		if (data_nascita != null) {
			setData_nascita(data_nascita);
		}

		String codice_fiscale = (String)attributes.get("codice_fiscale");

		if (codice_fiscale != null) {
			setCodice_fiscale(codice_fiscale);
		}

		String numerobadge = (String)attributes.get("numerobadge");

		if (numerobadge != null) {
			setNumerobadge(numerobadge);
		}

		String allegatoUuid = (String)attributes.get("allegatoUuid");

		if (allegatoUuid != null) {
			setAllegatoUuid(allegatoUuid);
		}

		String operazione = (String)attributes.get("operazione");

		if (operazione != null) {
			setOperazione(operazione);
		}

		Date data_richiesta = (Date)attributes.get("data_richiesta");

		if (data_richiesta != null) {
			setData_richiesta(data_richiesta);
		}

		String procedura = (String)attributes.get("procedura");

		if (procedura != null) {
			setProcedura(procedura);
		}

		Date disattivazione = (Date)attributes.get("disattivazione");

		if (disattivazione != null) {
			setDisattivazione(disattivazione);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _badgeRichieste.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _badgeRichieste.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _badgeRichieste.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _badgeRichieste.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.BadgeRichieste> toCacheModel() {
		return _badgeRichieste.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.BadgeRichieste badgeRichieste) {
		return _badgeRichieste.compareTo(badgeRichieste);
	}

	@Override
	public int hashCode() {
		return _badgeRichieste.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _badgeRichieste.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BadgeRichiesteWrapper((BadgeRichieste)_badgeRichieste.clone());
	}

	/**
	* Returns the allegato uuid of this badge richieste.
	*
	* @return the allegato uuid of this badge richieste
	*/
	@Override
	public java.lang.String getAllegatoUuid() {
		return _badgeRichieste.getAllegatoUuid();
	}

	/**
	* Returns the codice_fiscale of this badge richieste.
	*
	* @return the codice_fiscale of this badge richieste
	*/
	@Override
	public java.lang.String getCodice_fiscale() {
		return _badgeRichieste.getCodice_fiscale();
	}

	/**
	* Returns the cognome of this badge richieste.
	*
	* @return the cognome of this badge richieste
	*/
	@Override
	public java.lang.String getCognome() {
		return _badgeRichieste.getCognome();
	}

	/**
	* Returns the dettaglio_richiedente of this badge richieste.
	*
	* @return the dettaglio_richiedente of this badge richieste
	*/
	@Override
	public java.lang.String getDettaglio_richiedente() {
		return _badgeRichieste.getDettaglio_richiedente();
	}

	/**
	* Returns the luogo_nascita of this badge richieste.
	*
	* @return the luogo_nascita of this badge richieste
	*/
	@Override
	public java.lang.String getLuogo_nascita() {
		return _badgeRichieste.getLuogo_nascita();
	}

	/**
	* Returns the nome of this badge richieste.
	*
	* @return the nome of this badge richieste
	*/
	@Override
	public java.lang.String getNome() {
		return _badgeRichieste.getNome();
	}

	/**
	* Returns the numerobadge of this badge richieste.
	*
	* @return the numerobadge of this badge richieste
	*/
	@Override
	public java.lang.String getNumerobadge() {
		return _badgeRichieste.getNumerobadge();
	}

	/**
	* Returns the operazione of this badge richieste.
	*
	* @return the operazione of this badge richieste
	*/
	@Override
	public java.lang.String getOperazione() {
		return _badgeRichieste.getOperazione();
	}

	/**
	* Returns the procedura of this badge richieste.
	*
	* @return the procedura of this badge richieste
	*/
	@Override
	public java.lang.String getProcedura() {
		return _badgeRichieste.getProcedura();
	}

	/**
	* Returns the utente of this badge richieste.
	*
	* @return the utente of this badge richieste
	*/
	@Override
	public java.lang.String getUtente() {
		return _badgeRichieste.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _badgeRichieste.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _badgeRichieste.toXmlString();
	}

	/**
	* Returns the data_nascita of this badge richieste.
	*
	* @return the data_nascita of this badge richieste
	*/
	@Override
	public Date getData_nascita() {
		return _badgeRichieste.getData_nascita();
	}

	/**
	* Returns the data_richiesta of this badge richieste.
	*
	* @return the data_richiesta of this badge richieste
	*/
	@Override
	public Date getData_richiesta() {
		return _badgeRichieste.getData_richiesta();
	}

	/**
	* Returns the disattivazione of this badge richieste.
	*
	* @return the disattivazione of this badge richieste
	*/
	@Override
	public Date getDisattivazione() {
		return _badgeRichieste.getDisattivazione();
	}

	/**
	* Returns the ID of this badge richieste.
	*
	* @return the ID of this badge richieste
	*/
	@Override
	public long getId() {
		return _badgeRichieste.getId();
	}

	/**
	* Returns the primary key of this badge richieste.
	*
	* @return the primary key of this badge richieste
	*/
	@Override
	public long getPrimaryKey() {
		return _badgeRichieste.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.BadgeRichieste toEscapedModel() {
		return new BadgeRichiesteWrapper(_badgeRichieste.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.BadgeRichieste toUnescapedModel() {
		return new BadgeRichiesteWrapper(_badgeRichieste.toUnescapedModel());
	}

	@Override
	public void persist() {
		_badgeRichieste.persist();
	}

	/**
	* Sets the allegato uuid of this badge richieste.
	*
	* @param allegatoUuid the allegato uuid of this badge richieste
	*/
	@Override
	public void setAllegatoUuid(java.lang.String allegatoUuid) {
		_badgeRichieste.setAllegatoUuid(allegatoUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_badgeRichieste.setCachedModel(cachedModel);
	}

	/**
	* Sets the codice_fiscale of this badge richieste.
	*
	* @param codice_fiscale the codice_fiscale of this badge richieste
	*/
	@Override
	public void setCodice_fiscale(java.lang.String codice_fiscale) {
		_badgeRichieste.setCodice_fiscale(codice_fiscale);
	}

	/**
	* Sets the cognome of this badge richieste.
	*
	* @param cognome the cognome of this badge richieste
	*/
	@Override
	public void setCognome(java.lang.String cognome) {
		_badgeRichieste.setCognome(cognome);
	}

	/**
	* Sets the data_nascita of this badge richieste.
	*
	* @param data_nascita the data_nascita of this badge richieste
	*/
	@Override
	public void setData_nascita(Date data_nascita) {
		_badgeRichieste.setData_nascita(data_nascita);
	}

	/**
	* Sets the data_richiesta of this badge richieste.
	*
	* @param data_richiesta the data_richiesta of this badge richieste
	*/
	@Override
	public void setData_richiesta(Date data_richiesta) {
		_badgeRichieste.setData_richiesta(data_richiesta);
	}

	/**
	* Sets the dettaglio_richiedente of this badge richieste.
	*
	* @param dettaglio_richiedente the dettaglio_richiedente of this badge richieste
	*/
	@Override
	public void setDettaglio_richiedente(java.lang.String dettaglio_richiedente) {
		_badgeRichieste.setDettaglio_richiedente(dettaglio_richiedente);
	}

	/**
	* Sets the disattivazione of this badge richieste.
	*
	* @param disattivazione the disattivazione of this badge richieste
	*/
	@Override
	public void setDisattivazione(Date disattivazione) {
		_badgeRichieste.setDisattivazione(disattivazione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_badgeRichieste.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_badgeRichieste.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_badgeRichieste.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this badge richieste.
	*
	* @param id the ID of this badge richieste
	*/
	@Override
	public void setId(long id) {
		_badgeRichieste.setId(id);
	}

	/**
	* Sets the luogo_nascita of this badge richieste.
	*
	* @param luogo_nascita the luogo_nascita of this badge richieste
	*/
	@Override
	public void setLuogo_nascita(java.lang.String luogo_nascita) {
		_badgeRichieste.setLuogo_nascita(luogo_nascita);
	}

	@Override
	public void setNew(boolean n) {
		_badgeRichieste.setNew(n);
	}

	/**
	* Sets the nome of this badge richieste.
	*
	* @param nome the nome of this badge richieste
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_badgeRichieste.setNome(nome);
	}

	/**
	* Sets the numerobadge of this badge richieste.
	*
	* @param numerobadge the numerobadge of this badge richieste
	*/
	@Override
	public void setNumerobadge(java.lang.String numerobadge) {
		_badgeRichieste.setNumerobadge(numerobadge);
	}

	/**
	* Sets the operazione of this badge richieste.
	*
	* @param operazione the operazione of this badge richieste
	*/
	@Override
	public void setOperazione(java.lang.String operazione) {
		_badgeRichieste.setOperazione(operazione);
	}

	/**
	* Sets the primary key of this badge richieste.
	*
	* @param primaryKey the primary key of this badge richieste
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_badgeRichieste.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_badgeRichieste.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the procedura of this badge richieste.
	*
	* @param procedura the procedura of this badge richieste
	*/
	@Override
	public void setProcedura(java.lang.String procedura) {
		_badgeRichieste.setProcedura(procedura);
	}

	/**
	* Sets the utente of this badge richieste.
	*
	* @param utente the utente of this badge richieste
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_badgeRichieste.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeRichiesteWrapper)) {
			return false;
		}

		BadgeRichiesteWrapper badgeRichiesteWrapper = (BadgeRichiesteWrapper)obj;

		if (Objects.equals(_badgeRichieste,
					badgeRichiesteWrapper._badgeRichieste)) {
			return true;
		}

		return false;
	}

	@Override
	public BadgeRichieste getWrappedModel() {
		return _badgeRichieste;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _badgeRichieste.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _badgeRichieste.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_badgeRichieste.resetOriginalValues();
	}

	private final BadgeRichieste _badgeRichieste;
}