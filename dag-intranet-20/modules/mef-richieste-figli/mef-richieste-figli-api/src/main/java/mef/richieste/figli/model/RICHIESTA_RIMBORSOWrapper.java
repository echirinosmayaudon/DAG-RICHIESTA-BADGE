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

package mef.richieste.figli.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link RICHIESTA_RIMBORSO}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RICHIESTA_RIMBORSO
 * @generated
 */
@ProviderType
public class RICHIESTA_RIMBORSOWrapper
	implements RICHIESTA_RIMBORSO, ModelWrapper<RICHIESTA_RIMBORSO> {

	public RICHIESTA_RIMBORSOWrapper(RICHIESTA_RIMBORSO richiesta_rimborso) {
		_richiesta_rimborso = richiesta_rimborso;
	}

	@Override
	public Class<?> getModelClass() {
		return RICHIESTA_RIMBORSO.class;
	}

	@Override
	public String getModelClassName() {
		return RICHIESTA_RIMBORSO.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("Nome_Richiedente", getNome_Richiedente());
		attributes.put("Cognome_Richiedente", getCognome_Richiedente());
		attributes.put(
			"Codice_Fiscale_Richiedente", getCodice_Fiscale_Richiedente());
		attributes.put("Utente_Inserimento", getUtente_Inserimento());
		attributes.put("Data_Inserimento", getData_Inserimento());
		attributes.put("Iban", getIban());
		attributes.put("Importo", getImporto());
		attributes.put("Figlio_Nome", getFiglio_Nome());
		attributes.put("Figlio_Cognome", getFiglio_Cognome());
		attributes.put("Figlio_Data_Nascita", getFiglio_Data_Nascita());
		attributes.put("Figlio_Luogo_Nascita", getFiglio_Luogo_Nascita());
		attributes.put("Figlio_Codice_Fiscale", getFiglio_Codice_Fiscale());
		attributes.put("Note", getNote());
		attributes.put("Flag_Inviato", getFlag_Inviato());
		attributes.put("Telefono", getTelefono());
		attributes.put("Allegato_UUID", getAllegato_UUID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String Nome_Richiedente = (String)attributes.get("Nome_Richiedente");

		if (Nome_Richiedente != null) {
			setNome_Richiedente(Nome_Richiedente);
		}

		String Cognome_Richiedente = (String)attributes.get(
			"Cognome_Richiedente");

		if (Cognome_Richiedente != null) {
			setCognome_Richiedente(Cognome_Richiedente);
		}

		String Codice_Fiscale_Richiedente = (String)attributes.get(
			"Codice_Fiscale_Richiedente");

		if (Codice_Fiscale_Richiedente != null) {
			setCodice_Fiscale_Richiedente(Codice_Fiscale_Richiedente);
		}

		String Utente_Inserimento = (String)attributes.get(
			"Utente_Inserimento");

		if (Utente_Inserimento != null) {
			setUtente_Inserimento(Utente_Inserimento);
		}

		String Data_Inserimento = (String)attributes.get("Data_Inserimento");

		if (Data_Inserimento != null) {
			setData_Inserimento(Data_Inserimento);
		}

		String Iban = (String)attributes.get("Iban");

		if (Iban != null) {
			setIban(Iban);
		}

		String Importo = (String)attributes.get("Importo");

		if (Importo != null) {
			setImporto(Importo);
		}

		String Figlio_Nome = (String)attributes.get("Figlio_Nome");

		if (Figlio_Nome != null) {
			setFiglio_Nome(Figlio_Nome);
		}

		String Figlio_Cognome = (String)attributes.get("Figlio_Cognome");

		if (Figlio_Cognome != null) {
			setFiglio_Cognome(Figlio_Cognome);
		}

		String Figlio_Data_Nascita = (String)attributes.get(
			"Figlio_Data_Nascita");

		if (Figlio_Data_Nascita != null) {
			setFiglio_Data_Nascita(Figlio_Data_Nascita);
		}

		String Figlio_Luogo_Nascita = (String)attributes.get(
			"Figlio_Luogo_Nascita");

		if (Figlio_Luogo_Nascita != null) {
			setFiglio_Luogo_Nascita(Figlio_Luogo_Nascita);
		}

		String Figlio_Codice_Fiscale = (String)attributes.get(
			"Figlio_Codice_Fiscale");

		if (Figlio_Codice_Fiscale != null) {
			setFiglio_Codice_Fiscale(Figlio_Codice_Fiscale);
		}

		String Note = (String)attributes.get("Note");

		if (Note != null) {
			setNote(Note);
		}

		Boolean Flag_Inviato = (Boolean)attributes.get("Flag_Inviato");

		if (Flag_Inviato != null) {
			setFlag_Inviato(Flag_Inviato);
		}

		String Telefono = (String)attributes.get("Telefono");

		if (Telefono != null) {
			setTelefono(Telefono);
		}

		String Allegato_UUID = (String)attributes.get("Allegato_UUID");

		if (Allegato_UUID != null) {
			setAllegato_UUID(Allegato_UUID);
		}
	}

	@Override
	public Object clone() {
		return new RICHIESTA_RIMBORSOWrapper(
			(RICHIESTA_RIMBORSO)_richiesta_rimborso.clone());
	}

	@Override
	public int compareTo(
		mef.richieste.figli.model.RICHIESTA_RIMBORSO richiesta_rimborso) {

		return _richiesta_rimborso.compareTo(richiesta_rimborso);
	}

	/**
	 * Returns the allegato_uuid of this richiesta_rimborso.
	 *
	 * @return the allegato_uuid of this richiesta_rimborso
	 */
	@Override
	public String getAllegato_UUID() {
		return _richiesta_rimborso.getAllegato_UUID();
	}

	/**
	 * Returns the codice_ fiscale_ richiedente of this richiesta_rimborso.
	 *
	 * @return the codice_ fiscale_ richiedente of this richiesta_rimborso
	 */
	@Override
	public String getCodice_Fiscale_Richiedente() {
		return _richiesta_rimborso.getCodice_Fiscale_Richiedente();
	}

	/**
	 * Returns the cognome_ richiedente of this richiesta_rimborso.
	 *
	 * @return the cognome_ richiedente of this richiesta_rimborso
	 */
	@Override
	public String getCognome_Richiedente() {
		return _richiesta_rimborso.getCognome_Richiedente();
	}

	/**
	 * Returns the data_ inserimento of this richiesta_rimborso.
	 *
	 * @return the data_ inserimento of this richiesta_rimborso
	 */
	@Override
	public String getData_Inserimento() {
		return _richiesta_rimborso.getData_Inserimento();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiesta_rimborso.getExpandoBridge();
	}

	/**
	 * Returns the figlio_ codice_ fiscale of this richiesta_rimborso.
	 *
	 * @return the figlio_ codice_ fiscale of this richiesta_rimborso
	 */
	@Override
	public String getFiglio_Codice_Fiscale() {
		return _richiesta_rimborso.getFiglio_Codice_Fiscale();
	}

	/**
	 * Returns the figlio_ cognome of this richiesta_rimborso.
	 *
	 * @return the figlio_ cognome of this richiesta_rimborso
	 */
	@Override
	public String getFiglio_Cognome() {
		return _richiesta_rimborso.getFiglio_Cognome();
	}

	/**
	 * Returns the figlio_ data_ nascita of this richiesta_rimborso.
	 *
	 * @return the figlio_ data_ nascita of this richiesta_rimborso
	 */
	@Override
	public String getFiglio_Data_Nascita() {
		return _richiesta_rimborso.getFiglio_Data_Nascita();
	}

	/**
	 * Returns the figlio_ luogo_ nascita of this richiesta_rimborso.
	 *
	 * @return the figlio_ luogo_ nascita of this richiesta_rimborso
	 */
	@Override
	public String getFiglio_Luogo_Nascita() {
		return _richiesta_rimborso.getFiglio_Luogo_Nascita();
	}

	/**
	 * Returns the figlio_ nome of this richiesta_rimborso.
	 *
	 * @return the figlio_ nome of this richiesta_rimborso
	 */
	@Override
	public String getFiglio_Nome() {
		return _richiesta_rimborso.getFiglio_Nome();
	}

	/**
	 * Returns the flag_ inviato of this richiesta_rimborso.
	 *
	 * @return the flag_ inviato of this richiesta_rimborso
	 */
	@Override
	public Boolean getFlag_Inviato() {
		return _richiesta_rimborso.getFlag_Inviato();
	}

	/**
	 * Returns the iban of this richiesta_rimborso.
	 *
	 * @return the iban of this richiesta_rimborso
	 */
	@Override
	public String getIban() {
		return _richiesta_rimborso.getIban();
	}

	/**
	 * Returns the ID of this richiesta_rimborso.
	 *
	 * @return the ID of this richiesta_rimborso
	 */
	@Override
	public long getId() {
		return _richiesta_rimborso.getId();
	}

	/**
	 * Returns the importo of this richiesta_rimborso.
	 *
	 * @return the importo of this richiesta_rimborso
	 */
	@Override
	public String getImporto() {
		return _richiesta_rimborso.getImporto();
	}

	/**
	 * Returns the nome_ richiedente of this richiesta_rimborso.
	 *
	 * @return the nome_ richiedente of this richiesta_rimborso
	 */
	@Override
	public String getNome_Richiedente() {
		return _richiesta_rimborso.getNome_Richiedente();
	}

	/**
	 * Returns the note of this richiesta_rimborso.
	 *
	 * @return the note of this richiesta_rimborso
	 */
	@Override
	public String getNote() {
		return _richiesta_rimborso.getNote();
	}

	/**
	 * Returns the primary key of this richiesta_rimborso.
	 *
	 * @return the primary key of this richiesta_rimborso
	 */
	@Override
	public long getPrimaryKey() {
		return _richiesta_rimborso.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiesta_rimborso.getPrimaryKeyObj();
	}

	/**
	 * Returns the telefono of this richiesta_rimborso.
	 *
	 * @return the telefono of this richiesta_rimborso
	 */
	@Override
	public String getTelefono() {
		return _richiesta_rimborso.getTelefono();
	}

	/**
	 * Returns the utente_ inserimento of this richiesta_rimborso.
	 *
	 * @return the utente_ inserimento of this richiesta_rimborso
	 */
	@Override
	public String getUtente_Inserimento() {
		return _richiesta_rimborso.getUtente_Inserimento();
	}

	@Override
	public int hashCode() {
		return _richiesta_rimborso.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _richiesta_rimborso.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiesta_rimborso.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiesta_rimborso.isNew();
	}

	@Override
	public void persist() {
		_richiesta_rimborso.persist();
	}

	/**
	 * Sets the allegato_uuid of this richiesta_rimborso.
	 *
	 * @param Allegato_UUID the allegato_uuid of this richiesta_rimborso
	 */
	@Override
	public void setAllegato_UUID(String Allegato_UUID) {
		_richiesta_rimborso.setAllegato_UUID(Allegato_UUID);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiesta_rimborso.setCachedModel(cachedModel);
	}

	/**
	 * Sets the codice_ fiscale_ richiedente of this richiesta_rimborso.
	 *
	 * @param Codice_Fiscale_Richiedente the codice_ fiscale_ richiedente of this richiesta_rimborso
	 */
	@Override
	public void setCodice_Fiscale_Richiedente(
		String Codice_Fiscale_Richiedente) {

		_richiesta_rimborso.setCodice_Fiscale_Richiedente(
			Codice_Fiscale_Richiedente);
	}

	/**
	 * Sets the cognome_ richiedente of this richiesta_rimborso.
	 *
	 * @param Cognome_Richiedente the cognome_ richiedente of this richiesta_rimborso
	 */
	@Override
	public void setCognome_Richiedente(String Cognome_Richiedente) {
		_richiesta_rimborso.setCognome_Richiedente(Cognome_Richiedente);
	}

	/**
	 * Sets the data_ inserimento of this richiesta_rimborso.
	 *
	 * @param Data_Inserimento the data_ inserimento of this richiesta_rimborso
	 */
	@Override
	public void setData_Inserimento(String Data_Inserimento) {
		_richiesta_rimborso.setData_Inserimento(Data_Inserimento);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_richiesta_rimborso.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiesta_rimborso.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiesta_rimborso.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the figlio_ codice_ fiscale of this richiesta_rimborso.
	 *
	 * @param Figlio_Codice_Fiscale the figlio_ codice_ fiscale of this richiesta_rimborso
	 */
	@Override
	public void setFiglio_Codice_Fiscale(String Figlio_Codice_Fiscale) {
		_richiesta_rimborso.setFiglio_Codice_Fiscale(Figlio_Codice_Fiscale);
	}

	/**
	 * Sets the figlio_ cognome of this richiesta_rimborso.
	 *
	 * @param Figlio_Cognome the figlio_ cognome of this richiesta_rimborso
	 */
	@Override
	public void setFiglio_Cognome(String Figlio_Cognome) {
		_richiesta_rimborso.setFiglio_Cognome(Figlio_Cognome);
	}

	/**
	 * Sets the figlio_ data_ nascita of this richiesta_rimborso.
	 *
	 * @param Figlio_Data_Nascita the figlio_ data_ nascita of this richiesta_rimborso
	 */
	@Override
	public void setFiglio_Data_Nascita(String Figlio_Data_Nascita) {
		_richiesta_rimborso.setFiglio_Data_Nascita(Figlio_Data_Nascita);
	}

	/**
	 * Sets the figlio_ luogo_ nascita of this richiesta_rimborso.
	 *
	 * @param Figlio_Luogo_Nascita the figlio_ luogo_ nascita of this richiesta_rimborso
	 */
	@Override
	public void setFiglio_Luogo_Nascita(String Figlio_Luogo_Nascita) {
		_richiesta_rimborso.setFiglio_Luogo_Nascita(Figlio_Luogo_Nascita);
	}

	/**
	 * Sets the figlio_ nome of this richiesta_rimborso.
	 *
	 * @param Figlio_Nome the figlio_ nome of this richiesta_rimborso
	 */
	@Override
	public void setFiglio_Nome(String Figlio_Nome) {
		_richiesta_rimborso.setFiglio_Nome(Figlio_Nome);
	}

	/**
	 * Sets the flag_ inviato of this richiesta_rimborso.
	 *
	 * @param Flag_Inviato the flag_ inviato of this richiesta_rimborso
	 */
	@Override
	public void setFlag_Inviato(Boolean Flag_Inviato) {
		_richiesta_rimborso.setFlag_Inviato(Flag_Inviato);
	}

	/**
	 * Sets the iban of this richiesta_rimborso.
	 *
	 * @param Iban the iban of this richiesta_rimborso
	 */
	@Override
	public void setIban(String Iban) {
		_richiesta_rimborso.setIban(Iban);
	}

	/**
	 * Sets the ID of this richiesta_rimborso.
	 *
	 * @param Id the ID of this richiesta_rimborso
	 */
	@Override
	public void setId(long Id) {
		_richiesta_rimborso.setId(Id);
	}

	/**
	 * Sets the importo of this richiesta_rimborso.
	 *
	 * @param Importo the importo of this richiesta_rimborso
	 */
	@Override
	public void setImporto(String Importo) {
		_richiesta_rimborso.setImporto(Importo);
	}

	@Override
	public void setNew(boolean n) {
		_richiesta_rimborso.setNew(n);
	}

	/**
	 * Sets the nome_ richiedente of this richiesta_rimborso.
	 *
	 * @param Nome_Richiedente the nome_ richiedente of this richiesta_rimborso
	 */
	@Override
	public void setNome_Richiedente(String Nome_Richiedente) {
		_richiesta_rimborso.setNome_Richiedente(Nome_Richiedente);
	}

	/**
	 * Sets the note of this richiesta_rimborso.
	 *
	 * @param Note the note of this richiesta_rimborso
	 */
	@Override
	public void setNote(String Note) {
		_richiesta_rimborso.setNote(Note);
	}

	/**
	 * Sets the primary key of this richiesta_rimborso.
	 *
	 * @param primaryKey the primary key of this richiesta_rimborso
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiesta_rimborso.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiesta_rimborso.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the telefono of this richiesta_rimborso.
	 *
	 * @param Telefono the telefono of this richiesta_rimborso
	 */
	@Override
	public void setTelefono(String Telefono) {
		_richiesta_rimborso.setTelefono(Telefono);
	}

	/**
	 * Sets the utente_ inserimento of this richiesta_rimborso.
	 *
	 * @param Utente_Inserimento the utente_ inserimento of this richiesta_rimborso
	 */
	@Override
	public void setUtente_Inserimento(String Utente_Inserimento) {
		_richiesta_rimborso.setUtente_Inserimento(Utente_Inserimento);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<mef.richieste.figli.model.RICHIESTA_RIMBORSO> toCacheModel() {

		return _richiesta_rimborso.toCacheModel();
	}

	@Override
	public mef.richieste.figli.model.RICHIESTA_RIMBORSO toEscapedModel() {
		return new RICHIESTA_RIMBORSOWrapper(
			_richiesta_rimborso.toEscapedModel());
	}

	@Override
	public String toString() {
		return _richiesta_rimborso.toString();
	}

	@Override
	public mef.richieste.figli.model.RICHIESTA_RIMBORSO toUnescapedModel() {
		return new RICHIESTA_RIMBORSOWrapper(
			_richiesta_rimborso.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _richiesta_rimborso.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RICHIESTA_RIMBORSOWrapper)) {
			return false;
		}

		RICHIESTA_RIMBORSOWrapper richiesta_rimborsoWrapper =
			(RICHIESTA_RIMBORSOWrapper)obj;

		if (Objects.equals(
				_richiesta_rimborso,
				richiesta_rimborsoWrapper._richiesta_rimborso)) {

			return true;
		}

		return false;
	}

	@Override
	public RICHIESTA_RIMBORSO getWrappedModel() {
		return _richiesta_rimborso;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiesta_rimborso.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiesta_rimborso.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiesta_rimborso.resetOriginalValues();
	}

	private final RICHIESTA_RIMBORSO _richiesta_rimborso;

}