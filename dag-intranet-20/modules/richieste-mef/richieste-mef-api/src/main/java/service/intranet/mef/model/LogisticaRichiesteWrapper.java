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
 * This class is a wrapper for {@link LogisticaRichieste}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichieste
 * @generated
 */
@ProviderType
public class LogisticaRichiesteWrapper implements LogisticaRichieste,
	ModelWrapper<LogisticaRichieste> {
	public LogisticaRichiesteWrapper(LogisticaRichieste logisticaRichieste) {
		_logisticaRichieste = logisticaRichieste;
	}

	@Override
	public Class<?> getModelClass() {
		return LogisticaRichieste.class;
	}

	@Override
	public String getModelClassName() {
		return LogisticaRichieste.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("oggetto", getOggetto());
		attributes.put("utente", getUtente());
		attributes.put("dipartimento", getDipartimento());
		attributes.put("data_richiesta", getData_richiesta());
		attributes.put("dettaglio_richiedente", getDettaglio_richiedente());
		attributes.put("dettaglio_richieste", getDettaglio_richieste());
		attributes.put("note_gestore", getNote_gestore());
		attributes.put("id_valutazione", getId_valutazione());
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

		String oggetto = (String)attributes.get("oggetto");

		if (oggetto != null) {
			setOggetto(oggetto);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		String dipartimento = (String)attributes.get("dipartimento");

		if (dipartimento != null) {
			setDipartimento(dipartimento);
		}

		Date data_richiesta = (Date)attributes.get("data_richiesta");

		if (data_richiesta != null) {
			setData_richiesta(data_richiesta);
		}

		String dettaglio_richiedente = (String)attributes.get(
				"dettaglio_richiedente");

		if (dettaglio_richiedente != null) {
			setDettaglio_richiedente(dettaglio_richiedente);
		}

		String dettaglio_richieste = (String)attributes.get(
				"dettaglio_richieste");

		if (dettaglio_richieste != null) {
			setDettaglio_richieste(dettaglio_richieste);
		}

		String note_gestore = (String)attributes.get("note_gestore");

		if (note_gestore != null) {
			setNote_gestore(note_gestore);
		}

		Long id_valutazione = (Long)attributes.get("id_valutazione");

		if (id_valutazione != null) {
			setId_valutazione(id_valutazione);
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
		return _logisticaRichieste.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _logisticaRichieste.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _logisticaRichieste.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _logisticaRichieste.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.LogisticaRichieste> toCacheModel() {
		return _logisticaRichieste.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.LogisticaRichieste logisticaRichieste) {
		return _logisticaRichieste.compareTo(logisticaRichieste);
	}

	@Override
	public int hashCode() {
		return _logisticaRichieste.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logisticaRichieste.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LogisticaRichiesteWrapper((LogisticaRichieste)_logisticaRichieste.clone());
	}

	/**
	* Returns the dettaglio_richiedente of this logistica richieste.
	*
	* @return the dettaglio_richiedente of this logistica richieste
	*/
	@Override
	public java.lang.String getDettaglio_richiedente() {
		return _logisticaRichieste.getDettaglio_richiedente();
	}

	/**
	* Returns the dettaglio_richieste of this logistica richieste.
	*
	* @return the dettaglio_richieste of this logistica richieste
	*/
	@Override
	public java.lang.String getDettaglio_richieste() {
		return _logisticaRichieste.getDettaglio_richieste();
	}

	/**
	* Returns the dipartimento of this logistica richieste.
	*
	* @return the dipartimento of this logistica richieste
	*/
	@Override
	public java.lang.String getDipartimento() {
		return _logisticaRichieste.getDipartimento();
	}

	/**
	* Returns the note of this logistica richieste.
	*
	* @return the note of this logistica richieste
	*/
	@Override
	public java.lang.String getNote() {
		return _logisticaRichieste.getNote();
	}

	/**
	* Returns the note_gestore of this logistica richieste.
	*
	* @return the note_gestore of this logistica richieste
	*/
	@Override
	public java.lang.String getNote_gestore() {
		return _logisticaRichieste.getNote_gestore();
	}

	/**
	* Returns the oggetto of this logistica richieste.
	*
	* @return the oggetto of this logistica richieste
	*/
	@Override
	public java.lang.String getOggetto() {
		return _logisticaRichieste.getOggetto();
	}

	/**
	* Returns the utente of this logistica richieste.
	*
	* @return the utente of this logistica richieste
	*/
	@Override
	public java.lang.String getUtente() {
		return _logisticaRichieste.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _logisticaRichieste.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logisticaRichieste.toXmlString();
	}

	/**
	* Returns the data_richiesta of this logistica richieste.
	*
	* @return the data_richiesta of this logistica richieste
	*/
	@Override
	public Date getData_richiesta() {
		return _logisticaRichieste.getData_richiesta();
	}

	/**
	* Returns the ID of this logistica richieste.
	*
	* @return the ID of this logistica richieste
	*/
	@Override
	public long getId() {
		return _logisticaRichieste.getId();
	}

	/**
	* Returns the id_stato of this logistica richieste.
	*
	* @return the id_stato of this logistica richieste
	*/
	@Override
	public long getId_stato() {
		return _logisticaRichieste.getId_stato();
	}

	/**
	* Returns the id_valutazione of this logistica richieste.
	*
	* @return the id_valutazione of this logistica richieste
	*/
	@Override
	public long getId_valutazione() {
		return _logisticaRichieste.getId_valutazione();
	}

	/**
	* Returns the primary key of this logistica richieste.
	*
	* @return the primary key of this logistica richieste
	*/
	@Override
	public long getPrimaryKey() {
		return _logisticaRichieste.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.LogisticaRichieste toEscapedModel() {
		return new LogisticaRichiesteWrapper(_logisticaRichieste.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.LogisticaRichieste toUnescapedModel() {
		return new LogisticaRichiesteWrapper(_logisticaRichieste.toUnescapedModel());
	}

	@Override
	public void persist() {
		_logisticaRichieste.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logisticaRichieste.setCachedModel(cachedModel);
	}

	/**
	* Sets the data_richiesta of this logistica richieste.
	*
	* @param data_richiesta the data_richiesta of this logistica richieste
	*/
	@Override
	public void setData_richiesta(Date data_richiesta) {
		_logisticaRichieste.setData_richiesta(data_richiesta);
	}

	/**
	* Sets the dettaglio_richiedente of this logistica richieste.
	*
	* @param dettaglio_richiedente the dettaglio_richiedente of this logistica richieste
	*/
	@Override
	public void setDettaglio_richiedente(java.lang.String dettaglio_richiedente) {
		_logisticaRichieste.setDettaglio_richiedente(dettaglio_richiedente);
	}

	/**
	* Sets the dettaglio_richieste of this logistica richieste.
	*
	* @param dettaglio_richieste the dettaglio_richieste of this logistica richieste
	*/
	@Override
	public void setDettaglio_richieste(java.lang.String dettaglio_richieste) {
		_logisticaRichieste.setDettaglio_richieste(dettaglio_richieste);
	}

	/**
	* Sets the dipartimento of this logistica richieste.
	*
	* @param dipartimento the dipartimento of this logistica richieste
	*/
	@Override
	public void setDipartimento(java.lang.String dipartimento) {
		_logisticaRichieste.setDipartimento(dipartimento);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_logisticaRichieste.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_logisticaRichieste.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_logisticaRichieste.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this logistica richieste.
	*
	* @param id the ID of this logistica richieste
	*/
	@Override
	public void setId(long id) {
		_logisticaRichieste.setId(id);
	}

	/**
	* Sets the id_stato of this logistica richieste.
	*
	* @param id_stato the id_stato of this logistica richieste
	*/
	@Override
	public void setId_stato(long id_stato) {
		_logisticaRichieste.setId_stato(id_stato);
	}

	/**
	* Sets the id_valutazione of this logistica richieste.
	*
	* @param id_valutazione the id_valutazione of this logistica richieste
	*/
	@Override
	public void setId_valutazione(long id_valutazione) {
		_logisticaRichieste.setId_valutazione(id_valutazione);
	}

	@Override
	public void setNew(boolean n) {
		_logisticaRichieste.setNew(n);
	}

	/**
	* Sets the note of this logistica richieste.
	*
	* @param note the note of this logistica richieste
	*/
	@Override
	public void setNote(java.lang.String note) {
		_logisticaRichieste.setNote(note);
	}

	/**
	* Sets the note_gestore of this logistica richieste.
	*
	* @param note_gestore the note_gestore of this logistica richieste
	*/
	@Override
	public void setNote_gestore(java.lang.String note_gestore) {
		_logisticaRichieste.setNote_gestore(note_gestore);
	}

	/**
	* Sets the oggetto of this logistica richieste.
	*
	* @param oggetto the oggetto of this logistica richieste
	*/
	@Override
	public void setOggetto(java.lang.String oggetto) {
		_logisticaRichieste.setOggetto(oggetto);
	}

	/**
	* Sets the primary key of this logistica richieste.
	*
	* @param primaryKey the primary key of this logistica richieste
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logisticaRichieste.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_logisticaRichieste.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the utente of this logistica richieste.
	*
	* @param utente the utente of this logistica richieste
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_logisticaRichieste.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogisticaRichiesteWrapper)) {
			return false;
		}

		LogisticaRichiesteWrapper logisticaRichiesteWrapper = (LogisticaRichiesteWrapper)obj;

		if (Objects.equals(_logisticaRichieste,
					logisticaRichiesteWrapper._logisticaRichieste)) {
			return true;
		}

		return false;
	}

	@Override
	public LogisticaRichieste getWrappedModel() {
		return _logisticaRichieste;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _logisticaRichieste.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _logisticaRichieste.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_logisticaRichieste.resetOriginalValues();
	}

	private final LogisticaRichieste _logisticaRichieste;
}