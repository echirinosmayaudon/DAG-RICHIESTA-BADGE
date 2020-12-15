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

package external.bfc.intranet.mef.model;

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
 * This class is a wrapper for {@link Richieste}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Richieste
 * @generated
 */
@ProviderType
public class RichiesteWrapper implements Richieste, ModelWrapper<Richieste> {
	public RichiesteWrapper(Richieste richieste) {
		_richieste = richieste;
	}

	@Override
	public Class<?> getModelClass() {
		return Richieste.class;
	}

	@Override
	public String getModelClassName() {
		return Richieste.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idStatoAttuale", getIdStatoAttuale());
		attributes.put("id", getId());
		attributes.put("dataRichiesta", getDataRichiesta());
		attributes.put("idPeriodicita", getIdPeriodicita());
		attributes.put("email", getEmail());
		attributes.put("riferimentoStanza", getRiferimentoStanza());
		attributes.put("ispettorato", getIspettorato());
		attributes.put("noteRichiedente", getNoteRichiedente());
		attributes.put("ufficio", getUfficio());
		attributes.put("note", getNote());
		attributes.put("uidIns", getUidIns());
		attributes.put("dataIns", getDataIns());
		attributes.put("uidUpd", getUidUpd());
		attributes.put("dataUpd", getDataUpd());
		attributes.put("oggetto", getOggetto());
		attributes.put("idSede", getIdSede());
		attributes.put("strutIsp", getStrutIsp());
		attributes.put("strutUff", getStrutUff());
		attributes.put("strutIsp2", getStrutIsp2());
		attributes.put("telRichiedente", getTelRichiedente());
		attributes.put("costoReale", getCostoReale());
		attributes.put("preventivo", getPreventivo());
		attributes.put("flagInvio", getFlagInvio());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idStatoAttuale = (Long)attributes.get("idStatoAttuale");

		if (idStatoAttuale != null) {
			setIdStatoAttuale(idStatoAttuale);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date dataRichiesta = (Date)attributes.get("dataRichiesta");

		if (dataRichiesta != null) {
			setDataRichiesta(dataRichiesta);
		}

		Long idPeriodicita = (Long)attributes.get("idPeriodicita");

		if (idPeriodicita != null) {
			setIdPeriodicita(idPeriodicita);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String riferimentoStanza = (String)attributes.get("riferimentoStanza");

		if (riferimentoStanza != null) {
			setRiferimentoStanza(riferimentoStanza);
		}

		String ispettorato = (String)attributes.get("ispettorato");

		if (ispettorato != null) {
			setIspettorato(ispettorato);
		}

		String noteRichiedente = (String)attributes.get("noteRichiedente");

		if (noteRichiedente != null) {
			setNoteRichiedente(noteRichiedente);
		}

		String ufficio = (String)attributes.get("ufficio");

		if (ufficio != null) {
			setUfficio(ufficio);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long uidIns = (Long)attributes.get("uidIns");

		if (uidIns != null) {
			setUidIns(uidIns);
		}

		Date dataIns = (Date)attributes.get("dataIns");

		if (dataIns != null) {
			setDataIns(dataIns);
		}

		Long uidUpd = (Long)attributes.get("uidUpd");

		if (uidUpd != null) {
			setUidUpd(uidUpd);
		}

		Date dataUpd = (Date)attributes.get("dataUpd");

		if (dataUpd != null) {
			setDataUpd(dataUpd);
		}

		String oggetto = (String)attributes.get("oggetto");

		if (oggetto != null) {
			setOggetto(oggetto);
		}

		String idSede = (String)attributes.get("idSede");

		if (idSede != null) {
			setIdSede(idSede);
		}

		String strutIsp = (String)attributes.get("strutIsp");

		if (strutIsp != null) {
			setStrutIsp(strutIsp);
		}

		String strutUff = (String)attributes.get("strutUff");

		if (strutUff != null) {
			setStrutUff(strutUff);
		}

		String strutIsp2 = (String)attributes.get("strutIsp2");

		if (strutIsp2 != null) {
			setStrutIsp2(strutIsp2);
		}

		String telRichiedente = (String)attributes.get("telRichiedente");

		if (telRichiedente != null) {
			setTelRichiedente(telRichiedente);
		}

		Float costoReale = (Float)attributes.get("costoReale");

		if (costoReale != null) {
			setCostoReale(costoReale);
		}

		Integer preventivo = (Integer)attributes.get("preventivo");

		if (preventivo != null) {
			setPreventivo(preventivo);
		}

		Integer flagInvio = (Integer)attributes.get("flagInvio");

		if (flagInvio != null) {
			setFlagInvio(flagInvio);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _richieste.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richieste.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richieste.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richieste.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<external.bfc.intranet.mef.model.Richieste> toCacheModel() {
		return _richieste.toCacheModel();
	}

	@Override
	public external.bfc.intranet.mef.model.Richieste toEscapedModel() {
		return new RichiesteWrapper(_richieste.toEscapedModel());
	}

	@Override
	public external.bfc.intranet.mef.model.Richieste toUnescapedModel() {
		return new RichiesteWrapper(_richieste.toUnescapedModel());
	}

	/**
	* Returns the costo reale of this richieste.
	*
	* @return the costo reale of this richieste
	*/
	@Override
	public float getCostoReale() {
		return _richieste.getCostoReale();
	}

	@Override
	public int compareTo(external.bfc.intranet.mef.model.Richieste richieste) {
		return _richieste.compareTo(richieste);
	}

	/**
	* Returns the flag invio of this richieste.
	*
	* @return the flag invio of this richieste
	*/
	@Override
	public int getFlagInvio() {
		return _richieste.getFlagInvio();
	}

	/**
	* Returns the preventivo of this richieste.
	*
	* @return the preventivo of this richieste
	*/
	@Override
	public int getPreventivo() {
		return _richieste.getPreventivo();
	}

	@Override
	public int hashCode() {
		return _richieste.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richieste.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiesteWrapper((Richieste)_richieste.clone());
	}

	/**
	* Returns the email of this richieste.
	*
	* @return the email of this richieste
	*/
	@Override
	public java.lang.String getEmail() {
		return _richieste.getEmail();
	}

	/**
	* Returns the id sede of this richieste.
	*
	* @return the id sede of this richieste
	*/
	@Override
	public java.lang.String getIdSede() {
		return _richieste.getIdSede();
	}

	/**
	* Returns the ispettorato of this richieste.
	*
	* @return the ispettorato of this richieste
	*/
	@Override
	public java.lang.String getIspettorato() {
		return _richieste.getIspettorato();
	}

	/**
	* Returns the note of this richieste.
	*
	* @return the note of this richieste
	*/
	@Override
	public java.lang.String getNote() {
		return _richieste.getNote();
	}

	/**
	* Returns the note richiedente of this richieste.
	*
	* @return the note richiedente of this richieste
	*/
	@Override
	public java.lang.String getNoteRichiedente() {
		return _richieste.getNoteRichiedente();
	}

	/**
	* Returns the oggetto of this richieste.
	*
	* @return the oggetto of this richieste
	*/
	@Override
	public java.lang.String getOggetto() {
		return _richieste.getOggetto();
	}

	/**
	* Returns the riferimento stanza of this richieste.
	*
	* @return the riferimento stanza of this richieste
	*/
	@Override
	public java.lang.String getRiferimentoStanza() {
		return _richieste.getRiferimentoStanza();
	}

	/**
	* Returns the strut isp of this richieste.
	*
	* @return the strut isp of this richieste
	*/
	@Override
	public java.lang.String getStrutIsp() {
		return _richieste.getStrutIsp();
	}

	/**
	* Returns the strut isp2 of this richieste.
	*
	* @return the strut isp2 of this richieste
	*/
	@Override
	public java.lang.String getStrutIsp2() {
		return _richieste.getStrutIsp2();
	}

	/**
	* Returns the strut uff of this richieste.
	*
	* @return the strut uff of this richieste
	*/
	@Override
	public java.lang.String getStrutUff() {
		return _richieste.getStrutUff();
	}

	/**
	* Returns the tel richiedente of this richieste.
	*
	* @return the tel richiedente of this richieste
	*/
	@Override
	public java.lang.String getTelRichiedente() {
		return _richieste.getTelRichiedente();
	}

	/**
	* Returns the ufficio of this richieste.
	*
	* @return the ufficio of this richieste
	*/
	@Override
	public java.lang.String getUfficio() {
		return _richieste.getUfficio();
	}

	@Override
	public java.lang.String toString() {
		return _richieste.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richieste.toXmlString();
	}

	/**
	* Returns the data ins of this richieste.
	*
	* @return the data ins of this richieste
	*/
	@Override
	public Date getDataIns() {
		return _richieste.getDataIns();
	}

	/**
	* Returns the data richiesta of this richieste.
	*
	* @return the data richiesta of this richieste
	*/
	@Override
	public Date getDataRichiesta() {
		return _richieste.getDataRichiesta();
	}

	/**
	* Returns the data upd of this richieste.
	*
	* @return the data upd of this richieste
	*/
	@Override
	public Date getDataUpd() {
		return _richieste.getDataUpd();
	}

	/**
	* Returns the ID of this richieste.
	*
	* @return the ID of this richieste
	*/
	@Override
	public long getId() {
		return _richieste.getId();
	}

	/**
	* Returns the id periodicita of this richieste.
	*
	* @return the id periodicita of this richieste
	*/
	@Override
	public long getIdPeriodicita() {
		return _richieste.getIdPeriodicita();
	}

	/**
	* Returns the id stato attuale of this richieste.
	*
	* @return the id stato attuale of this richieste
	*/
	@Override
	public long getIdStatoAttuale() {
		return _richieste.getIdStatoAttuale();
	}

	/**
	* Returns the primary key of this richieste.
	*
	* @return the primary key of this richieste
	*/
	@Override
	public long getPrimaryKey() {
		return _richieste.getPrimaryKey();
	}

	/**
	* Returns the uid ins of this richieste.
	*
	* @return the uid ins of this richieste
	*/
	@Override
	public long getUidIns() {
		return _richieste.getUidIns();
	}

	/**
	* Returns the uid upd of this richieste.
	*
	* @return the uid upd of this richieste
	*/
	@Override
	public long getUidUpd() {
		return _richieste.getUidUpd();
	}

	@Override
	public void persist() {
		_richieste.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richieste.setCachedModel(cachedModel);
	}

	/**
	* Sets the costo reale of this richieste.
	*
	* @param costoReale the costo reale of this richieste
	*/
	@Override
	public void setCostoReale(float costoReale) {
		_richieste.setCostoReale(costoReale);
	}

	/**
	* Sets the data ins of this richieste.
	*
	* @param dataIns the data ins of this richieste
	*/
	@Override
	public void setDataIns(Date dataIns) {
		_richieste.setDataIns(dataIns);
	}

	/**
	* Sets the data richiesta of this richieste.
	*
	* @param dataRichiesta the data richiesta of this richieste
	*/
	@Override
	public void setDataRichiesta(Date dataRichiesta) {
		_richieste.setDataRichiesta(dataRichiesta);
	}

	/**
	* Sets the data upd of this richieste.
	*
	* @param dataUpd the data upd of this richieste
	*/
	@Override
	public void setDataUpd(Date dataUpd) {
		_richieste.setDataUpd(dataUpd);
	}

	/**
	* Sets the email of this richieste.
	*
	* @param email the email of this richieste
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_richieste.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richieste.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richieste.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richieste.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flag invio of this richieste.
	*
	* @param flagInvio the flag invio of this richieste
	*/
	@Override
	public void setFlagInvio(int flagInvio) {
		_richieste.setFlagInvio(flagInvio);
	}

	/**
	* Sets the ID of this richieste.
	*
	* @param id the ID of this richieste
	*/
	@Override
	public void setId(long id) {
		_richieste.setId(id);
	}

	/**
	* Sets the id periodicita of this richieste.
	*
	* @param idPeriodicita the id periodicita of this richieste
	*/
	@Override
	public void setIdPeriodicita(long idPeriodicita) {
		_richieste.setIdPeriodicita(idPeriodicita);
	}

	/**
	* Sets the id sede of this richieste.
	*
	* @param idSede the id sede of this richieste
	*/
	@Override
	public void setIdSede(java.lang.String idSede) {
		_richieste.setIdSede(idSede);
	}

	/**
	* Sets the id stato attuale of this richieste.
	*
	* @param idStatoAttuale the id stato attuale of this richieste
	*/
	@Override
	public void setIdStatoAttuale(long idStatoAttuale) {
		_richieste.setIdStatoAttuale(idStatoAttuale);
	}

	/**
	* Sets the ispettorato of this richieste.
	*
	* @param ispettorato the ispettorato of this richieste
	*/
	@Override
	public void setIspettorato(java.lang.String ispettorato) {
		_richieste.setIspettorato(ispettorato);
	}

	@Override
	public void setNew(boolean n) {
		_richieste.setNew(n);
	}

	/**
	* Sets the note of this richieste.
	*
	* @param note the note of this richieste
	*/
	@Override
	public void setNote(java.lang.String note) {
		_richieste.setNote(note);
	}

	/**
	* Sets the note richiedente of this richieste.
	*
	* @param noteRichiedente the note richiedente of this richieste
	*/
	@Override
	public void setNoteRichiedente(java.lang.String noteRichiedente) {
		_richieste.setNoteRichiedente(noteRichiedente);
	}

	/**
	* Sets the oggetto of this richieste.
	*
	* @param oggetto the oggetto of this richieste
	*/
	@Override
	public void setOggetto(java.lang.String oggetto) {
		_richieste.setOggetto(oggetto);
	}

	/**
	* Sets the preventivo of this richieste.
	*
	* @param preventivo the preventivo of this richieste
	*/
	@Override
	public void setPreventivo(int preventivo) {
		_richieste.setPreventivo(preventivo);
	}

	/**
	* Sets the primary key of this richieste.
	*
	* @param primaryKey the primary key of this richieste
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richieste.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richieste.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the riferimento stanza of this richieste.
	*
	* @param riferimentoStanza the riferimento stanza of this richieste
	*/
	@Override
	public void setRiferimentoStanza(java.lang.String riferimentoStanza) {
		_richieste.setRiferimentoStanza(riferimentoStanza);
	}

	/**
	* Sets the strut isp of this richieste.
	*
	* @param strutIsp the strut isp of this richieste
	*/
	@Override
	public void setStrutIsp(java.lang.String strutIsp) {
		_richieste.setStrutIsp(strutIsp);
	}

	/**
	* Sets the strut isp2 of this richieste.
	*
	* @param strutIsp2 the strut isp2 of this richieste
	*/
	@Override
	public void setStrutIsp2(java.lang.String strutIsp2) {
		_richieste.setStrutIsp2(strutIsp2);
	}

	/**
	* Sets the strut uff of this richieste.
	*
	* @param strutUff the strut uff of this richieste
	*/
	@Override
	public void setStrutUff(java.lang.String strutUff) {
		_richieste.setStrutUff(strutUff);
	}

	/**
	* Sets the tel richiedente of this richieste.
	*
	* @param telRichiedente the tel richiedente of this richieste
	*/
	@Override
	public void setTelRichiedente(java.lang.String telRichiedente) {
		_richieste.setTelRichiedente(telRichiedente);
	}

	/**
	* Sets the ufficio of this richieste.
	*
	* @param ufficio the ufficio of this richieste
	*/
	@Override
	public void setUfficio(java.lang.String ufficio) {
		_richieste.setUfficio(ufficio);
	}

	/**
	* Sets the uid ins of this richieste.
	*
	* @param uidIns the uid ins of this richieste
	*/
	@Override
	public void setUidIns(long uidIns) {
		_richieste.setUidIns(uidIns);
	}

	/**
	* Sets the uid upd of this richieste.
	*
	* @param uidUpd the uid upd of this richieste
	*/
	@Override
	public void setUidUpd(long uidUpd) {
		_richieste.setUidUpd(uidUpd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteWrapper)) {
			return false;
		}

		RichiesteWrapper richiesteWrapper = (RichiesteWrapper)obj;

		if (Objects.equals(_richieste, richiesteWrapper._richieste)) {
			return true;
		}

		return false;
	}

	@Override
	public Richieste getWrappedModel() {
		return _richieste;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richieste.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richieste.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richieste.resetOriginalValues();
	}

	private final Richieste _richieste;
}