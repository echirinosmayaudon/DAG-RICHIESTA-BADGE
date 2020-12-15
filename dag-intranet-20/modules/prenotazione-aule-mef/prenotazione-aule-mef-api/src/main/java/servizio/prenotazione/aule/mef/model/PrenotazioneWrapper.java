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

package servizio.prenotazione.aule.mef.model;

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
 * This class is a wrapper for {@link Prenotazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Prenotazione
 * @generated
 */
@ProviderType
public class PrenotazioneWrapper implements Prenotazione,
	ModelWrapper<Prenotazione> {
	public PrenotazioneWrapper(Prenotazione prenotazione) {
		_prenotazione = prenotazione;
	}

	@Override
	public Class<?> getModelClass() {
		return Prenotazione.class;
	}

	@Override
	public String getModelClassName() {
		return Prenotazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_prenota", getId_prenota());
		attributes.put("id_sala", getId_sala());
		attributes.put("cod_fiscale", getCod_fiscale());
		attributes.put("data_prenota", getData_prenota());
		attributes.put("data_inizio", getData_inizio());
		attributes.put("data_fine", getData_fine());
		attributes.put("partecipanti", getPartecipanti());
		attributes.put("id_evento", getId_evento());
		attributes.put("attivita", getAttivita());
		attributes.put("note", getNote());
		attributes.put("id_stato", getId_stato());
		attributes.put("dati_rich", getDati_rich());
		attributes.put("servizi", getServizi());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_prenota = (Long)attributes.get("id_prenota");

		if (id_prenota != null) {
			setId_prenota(id_prenota);
		}

		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		String cod_fiscale = (String)attributes.get("cod_fiscale");

		if (cod_fiscale != null) {
			setCod_fiscale(cod_fiscale);
		}

		Date data_prenota = (Date)attributes.get("data_prenota");

		if (data_prenota != null) {
			setData_prenota(data_prenota);
		}

		Date data_inizio = (Date)attributes.get("data_inizio");

		if (data_inizio != null) {
			setData_inizio(data_inizio);
		}

		Date data_fine = (Date)attributes.get("data_fine");

		if (data_fine != null) {
			setData_fine(data_fine);
		}

		Integer partecipanti = (Integer)attributes.get("partecipanti");

		if (partecipanti != null) {
			setPartecipanti(partecipanti);
		}

		Long id_evento = (Long)attributes.get("id_evento");

		if (id_evento != null) {
			setId_evento(id_evento);
		}

		String attivita = (String)attributes.get("attivita");

		if (attivita != null) {
			setAttivita(attivita);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long id_stato = (Long)attributes.get("id_stato");

		if (id_stato != null) {
			setId_stato(id_stato);
		}

		String dati_rich = (String)attributes.get("dati_rich");

		if (dati_rich != null) {
			setDati_rich(dati_rich);
		}

		String servizi = (String)attributes.get("servizi");

		if (servizi != null) {
			setServizi(servizi);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _prenotazione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _prenotazione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _prenotazione.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _prenotazione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.Prenotazione> toCacheModel() {
		return _prenotazione.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.prenotazione.aule.mef.model.Prenotazione prenotazione) {
		return _prenotazione.compareTo(prenotazione);
	}

	/**
	* Returns the partecipanti of this prenotazione.
	*
	* @return the partecipanti of this prenotazione
	*/
	@Override
	public int getPartecipanti() {
		return _prenotazione.getPartecipanti();
	}

	@Override
	public int hashCode() {
		return _prenotazione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _prenotazione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PrenotazioneWrapper((Prenotazione)_prenotazione.clone());
	}

	/**
	* Returns the attivita of this prenotazione.
	*
	* @return the attivita of this prenotazione
	*/
	@Override
	public java.lang.String getAttivita() {
		return _prenotazione.getAttivita();
	}

	/**
	* Returns the cod_fiscale of this prenotazione.
	*
	* @return the cod_fiscale of this prenotazione
	*/
	@Override
	public java.lang.String getCod_fiscale() {
		return _prenotazione.getCod_fiscale();
	}

	/**
	* Returns the dati_rich of this prenotazione.
	*
	* @return the dati_rich of this prenotazione
	*/
	@Override
	public java.lang.String getDati_rich() {
		return _prenotazione.getDati_rich();
	}

	/**
	* Returns the note of this prenotazione.
	*
	* @return the note of this prenotazione
	*/
	@Override
	public java.lang.String getNote() {
		return _prenotazione.getNote();
	}

	/**
	* Returns the servizi of this prenotazione.
	*
	* @return the servizi of this prenotazione
	*/
	@Override
	public java.lang.String getServizi() {
		return _prenotazione.getServizi();
	}

	@Override
	public java.lang.String toString() {
		return _prenotazione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _prenotazione.toXmlString();
	}

	/**
	* Returns the data_fine of this prenotazione.
	*
	* @return the data_fine of this prenotazione
	*/
	@Override
	public Date getData_fine() {
		return _prenotazione.getData_fine();
	}

	/**
	* Returns the data_inizio of this prenotazione.
	*
	* @return the data_inizio of this prenotazione
	*/
	@Override
	public Date getData_inizio() {
		return _prenotazione.getData_inizio();
	}

	/**
	* Returns the data_prenota of this prenotazione.
	*
	* @return the data_prenota of this prenotazione
	*/
	@Override
	public Date getData_prenota() {
		return _prenotazione.getData_prenota();
	}

	/**
	* Returns the id_evento of this prenotazione.
	*
	* @return the id_evento of this prenotazione
	*/
	@Override
	public long getId_evento() {
		return _prenotazione.getId_evento();
	}

	/**
	* Returns the id_prenota of this prenotazione.
	*
	* @return the id_prenota of this prenotazione
	*/
	@Override
	public long getId_prenota() {
		return _prenotazione.getId_prenota();
	}

	/**
	* Returns the id_sala of this prenotazione.
	*
	* @return the id_sala of this prenotazione
	*/
	@Override
	public long getId_sala() {
		return _prenotazione.getId_sala();
	}

	/**
	* Returns the id_stato of this prenotazione.
	*
	* @return the id_stato of this prenotazione
	*/
	@Override
	public long getId_stato() {
		return _prenotazione.getId_stato();
	}

	/**
	* Returns the primary key of this prenotazione.
	*
	* @return the primary key of this prenotazione
	*/
	@Override
	public long getPrimaryKey() {
		return _prenotazione.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Prenotazione toEscapedModel() {
		return new PrenotazioneWrapper(_prenotazione.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Prenotazione toUnescapedModel() {
		return new PrenotazioneWrapper(_prenotazione.toUnescapedModel());
	}

	@Override
	public void persist() {
		_prenotazione.persist();
	}

	/**
	* Sets the attivita of this prenotazione.
	*
	* @param attivita the attivita of this prenotazione
	*/
	@Override
	public void setAttivita(java.lang.String attivita) {
		_prenotazione.setAttivita(attivita);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_prenotazione.setCachedModel(cachedModel);
	}

	/**
	* Sets the cod_fiscale of this prenotazione.
	*
	* @param cod_fiscale the cod_fiscale of this prenotazione
	*/
	@Override
	public void setCod_fiscale(java.lang.String cod_fiscale) {
		_prenotazione.setCod_fiscale(cod_fiscale);
	}

	/**
	* Sets the data_fine of this prenotazione.
	*
	* @param data_fine the data_fine of this prenotazione
	*/
	@Override
	public void setData_fine(Date data_fine) {
		_prenotazione.setData_fine(data_fine);
	}

	/**
	* Sets the data_inizio of this prenotazione.
	*
	* @param data_inizio the data_inizio of this prenotazione
	*/
	@Override
	public void setData_inizio(Date data_inizio) {
		_prenotazione.setData_inizio(data_inizio);
	}

	/**
	* Sets the data_prenota of this prenotazione.
	*
	* @param data_prenota the data_prenota of this prenotazione
	*/
	@Override
	public void setData_prenota(Date data_prenota) {
		_prenotazione.setData_prenota(data_prenota);
	}

	/**
	* Sets the dati_rich of this prenotazione.
	*
	* @param dati_rich the dati_rich of this prenotazione
	*/
	@Override
	public void setDati_rich(java.lang.String dati_rich) {
		_prenotazione.setDati_rich(dati_rich);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_prenotazione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_prenotazione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_prenotazione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_evento of this prenotazione.
	*
	* @param id_evento the id_evento of this prenotazione
	*/
	@Override
	public void setId_evento(long id_evento) {
		_prenotazione.setId_evento(id_evento);
	}

	/**
	* Sets the id_prenota of this prenotazione.
	*
	* @param id_prenota the id_prenota of this prenotazione
	*/
	@Override
	public void setId_prenota(long id_prenota) {
		_prenotazione.setId_prenota(id_prenota);
	}

	/**
	* Sets the id_sala of this prenotazione.
	*
	* @param id_sala the id_sala of this prenotazione
	*/
	@Override
	public void setId_sala(long id_sala) {
		_prenotazione.setId_sala(id_sala);
	}

	/**
	* Sets the id_stato of this prenotazione.
	*
	* @param id_stato the id_stato of this prenotazione
	*/
	@Override
	public void setId_stato(long id_stato) {
		_prenotazione.setId_stato(id_stato);
	}

	@Override
	public void setNew(boolean n) {
		_prenotazione.setNew(n);
	}

	/**
	* Sets the note of this prenotazione.
	*
	* @param note the note of this prenotazione
	*/
	@Override
	public void setNote(java.lang.String note) {
		_prenotazione.setNote(note);
	}

	/**
	* Sets the partecipanti of this prenotazione.
	*
	* @param partecipanti the partecipanti of this prenotazione
	*/
	@Override
	public void setPartecipanti(int partecipanti) {
		_prenotazione.setPartecipanti(partecipanti);
	}

	/**
	* Sets the primary key of this prenotazione.
	*
	* @param primaryKey the primary key of this prenotazione
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_prenotazione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_prenotazione.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the servizi of this prenotazione.
	*
	* @param servizi the servizi of this prenotazione
	*/
	@Override
	public void setServizi(java.lang.String servizi) {
		_prenotazione.setServizi(servizi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PrenotazioneWrapper)) {
			return false;
		}

		PrenotazioneWrapper prenotazioneWrapper = (PrenotazioneWrapper)obj;

		if (Objects.equals(_prenotazione, prenotazioneWrapper._prenotazione)) {
			return true;
		}

		return false;
	}

	@Override
	public Prenotazione getWrappedModel() {
		return _prenotazione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _prenotazione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _prenotazione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_prenotazione.resetOriginalValues();
	}

	private final Prenotazione _prenotazione;
}