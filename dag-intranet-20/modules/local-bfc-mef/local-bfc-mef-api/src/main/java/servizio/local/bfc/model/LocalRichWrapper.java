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

package servizio.local.bfc.model;

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
 * This class is a wrapper for {@link LocalRich}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRich
 * @generated
 */
@ProviderType
public class LocalRichWrapper implements LocalRich, ModelWrapper<LocalRich> {
	public LocalRichWrapper(LocalRich localRich) {
		_localRich = localRich;
	}

	@Override
	public Class<?> getModelClass() {
		return LocalRich.class;
	}

	@Override
	public String getModelClassName() {
		return LocalRich.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idStatoAttuale", getIdStatoAttuale());
		attributes.put("id", getId());
		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("dataRichiesta", getDataRichiesta());
		attributes.put("idPeriodicita", getIdPeriodicita());
		attributes.put("email", getEmail());
		attributes.put("rifStanza", getRifStanza());
		attributes.put("ispettorato", getIspettorato());
		attributes.put("noteRich", getNoteRich());
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
		attributes.put("telRich", getTelRich());
		attributes.put("costoReale", getCostoReale());
		attributes.put("preventivo", getPreventivo());
		attributes.put("flagInvio", getFlagInvio());
		attributes.put("inStage", getInStage());

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

		Long id_richiesta = (Long)attributes.get("id_richiesta");

		if (id_richiesta != null) {
			setId_richiesta(id_richiesta);
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

		String rifStanza = (String)attributes.get("rifStanza");

		if (rifStanza != null) {
			setRifStanza(rifStanza);
		}

		String ispettorato = (String)attributes.get("ispettorato");

		if (ispettorato != null) {
			setIspettorato(ispettorato);
		}

		String noteRich = (String)attributes.get("noteRich");

		if (noteRich != null) {
			setNoteRich(noteRich);
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

		String telRich = (String)attributes.get("telRich");

		if (telRich != null) {
			setTelRich(telRich);
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

		Boolean inStage = (Boolean)attributes.get("inStage");

		if (inStage != null) {
			setInStage(inStage);
		}
	}

	/**
	* Returns the in stage of this local rich.
	*
	* @return the in stage of this local rich
	*/
	@Override
	public boolean getInStage() {
		return _localRich.getInStage();
	}

	@Override
	public boolean isCachedModel() {
		return _localRich.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _localRich.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this local rich is in stage.
	*
	* @return <code>true</code> if this local rich is in stage; <code>false</code> otherwise
	*/
	@Override
	public boolean isInStage() {
		return _localRich.isInStage();
	}

	@Override
	public boolean isNew() {
		return _localRich.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _localRich.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.local.bfc.model.LocalRich> toCacheModel() {
		return _localRich.toCacheModel();
	}

	/**
	* Returns the costo reale of this local rich.
	*
	* @return the costo reale of this local rich
	*/
	@Override
	public float getCostoReale() {
		return _localRich.getCostoReale();
	}

	@Override
	public int compareTo(servizio.local.bfc.model.LocalRich localRich) {
		return _localRich.compareTo(localRich);
	}

	/**
	* Returns the flag invio of this local rich.
	*
	* @return the flag invio of this local rich
	*/
	@Override
	public int getFlagInvio() {
		return _localRich.getFlagInvio();
	}

	/**
	* Returns the preventivo of this local rich.
	*
	* @return the preventivo of this local rich
	*/
	@Override
	public int getPreventivo() {
		return _localRich.getPreventivo();
	}

	@Override
	public int hashCode() {
		return _localRich.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localRich.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LocalRichWrapper((LocalRich)_localRich.clone());
	}

	/**
	* Returns the email of this local rich.
	*
	* @return the email of this local rich
	*/
	@Override
	public java.lang.String getEmail() {
		return _localRich.getEmail();
	}

	/**
	* Returns the id sede of this local rich.
	*
	* @return the id sede of this local rich
	*/
	@Override
	public java.lang.String getIdSede() {
		return _localRich.getIdSede();
	}

	/**
	* Returns the ispettorato of this local rich.
	*
	* @return the ispettorato of this local rich
	*/
	@Override
	public java.lang.String getIspettorato() {
		return _localRich.getIspettorato();
	}

	/**
	* Returns the note of this local rich.
	*
	* @return the note of this local rich
	*/
	@Override
	public java.lang.String getNote() {
		return _localRich.getNote();
	}

	/**
	* Returns the note rich of this local rich.
	*
	* @return the note rich of this local rich
	*/
	@Override
	public java.lang.String getNoteRich() {
		return _localRich.getNoteRich();
	}

	/**
	* Returns the oggetto of this local rich.
	*
	* @return the oggetto of this local rich
	*/
	@Override
	public java.lang.String getOggetto() {
		return _localRich.getOggetto();
	}

	/**
	* Returns the rif stanza of this local rich.
	*
	* @return the rif stanza of this local rich
	*/
	@Override
	public java.lang.String getRifStanza() {
		return _localRich.getRifStanza();
	}

	/**
	* Returns the strut isp of this local rich.
	*
	* @return the strut isp of this local rich
	*/
	@Override
	public java.lang.String getStrutIsp() {
		return _localRich.getStrutIsp();
	}

	/**
	* Returns the strut isp2 of this local rich.
	*
	* @return the strut isp2 of this local rich
	*/
	@Override
	public java.lang.String getStrutIsp2() {
		return _localRich.getStrutIsp2();
	}

	/**
	* Returns the strut uff of this local rich.
	*
	* @return the strut uff of this local rich
	*/
	@Override
	public java.lang.String getStrutUff() {
		return _localRich.getStrutUff();
	}

	/**
	* Returns the tel rich of this local rich.
	*
	* @return the tel rich of this local rich
	*/
	@Override
	public java.lang.String getTelRich() {
		return _localRich.getTelRich();
	}

	/**
	* Returns the ufficio of this local rich.
	*
	* @return the ufficio of this local rich
	*/
	@Override
	public java.lang.String getUfficio() {
		return _localRich.getUfficio();
	}

	@Override
	public java.lang.String toString() {
		return _localRich.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _localRich.toXmlString();
	}

	/**
	* Returns the data ins of this local rich.
	*
	* @return the data ins of this local rich
	*/
	@Override
	public Date getDataIns() {
		return _localRich.getDataIns();
	}

	/**
	* Returns the data richiesta of this local rich.
	*
	* @return the data richiesta of this local rich
	*/
	@Override
	public Date getDataRichiesta() {
		return _localRich.getDataRichiesta();
	}

	/**
	* Returns the data upd of this local rich.
	*
	* @return the data upd of this local rich
	*/
	@Override
	public Date getDataUpd() {
		return _localRich.getDataUpd();
	}

	/**
	* Returns the ID of this local rich.
	*
	* @return the ID of this local rich
	*/
	@Override
	public long getId() {
		return _localRich.getId();
	}

	/**
	* Returns the id periodicita of this local rich.
	*
	* @return the id periodicita of this local rich
	*/
	@Override
	public long getIdPeriodicita() {
		return _localRich.getIdPeriodicita();
	}

	/**
	* Returns the id stato attuale of this local rich.
	*
	* @return the id stato attuale of this local rich
	*/
	@Override
	public long getIdStatoAttuale() {
		return _localRich.getIdStatoAttuale();
	}

	/**
	* Returns the id_richiesta of this local rich.
	*
	* @return the id_richiesta of this local rich
	*/
	@Override
	public long getId_richiesta() {
		return _localRich.getId_richiesta();
	}

	/**
	* Returns the primary key of this local rich.
	*
	* @return the primary key of this local rich
	*/
	@Override
	public long getPrimaryKey() {
		return _localRich.getPrimaryKey();
	}

	/**
	* Returns the uid ins of this local rich.
	*
	* @return the uid ins of this local rich
	*/
	@Override
	public long getUidIns() {
		return _localRich.getUidIns();
	}

	/**
	* Returns the uid upd of this local rich.
	*
	* @return the uid upd of this local rich
	*/
	@Override
	public long getUidUpd() {
		return _localRich.getUidUpd();
	}

	@Override
	public servizio.local.bfc.model.LocalRich toEscapedModel() {
		return new LocalRichWrapper(_localRich.toEscapedModel());
	}

	@Override
	public servizio.local.bfc.model.LocalRich toUnescapedModel() {
		return new LocalRichWrapper(_localRich.toUnescapedModel());
	}

	@Override
	public void persist() {
		_localRich.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_localRich.setCachedModel(cachedModel);
	}

	/**
	* Sets the costo reale of this local rich.
	*
	* @param costoReale the costo reale of this local rich
	*/
	@Override
	public void setCostoReale(float costoReale) {
		_localRich.setCostoReale(costoReale);
	}

	/**
	* Sets the data ins of this local rich.
	*
	* @param dataIns the data ins of this local rich
	*/
	@Override
	public void setDataIns(Date dataIns) {
		_localRich.setDataIns(dataIns);
	}

	/**
	* Sets the data richiesta of this local rich.
	*
	* @param dataRichiesta the data richiesta of this local rich
	*/
	@Override
	public void setDataRichiesta(Date dataRichiesta) {
		_localRich.setDataRichiesta(dataRichiesta);
	}

	/**
	* Sets the data upd of this local rich.
	*
	* @param dataUpd the data upd of this local rich
	*/
	@Override
	public void setDataUpd(Date dataUpd) {
		_localRich.setDataUpd(dataUpd);
	}

	/**
	* Sets the email of this local rich.
	*
	* @param email the email of this local rich
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_localRich.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_localRich.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_localRich.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_localRich.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flag invio of this local rich.
	*
	* @param flagInvio the flag invio of this local rich
	*/
	@Override
	public void setFlagInvio(int flagInvio) {
		_localRich.setFlagInvio(flagInvio);
	}

	/**
	* Sets the ID of this local rich.
	*
	* @param id the ID of this local rich
	*/
	@Override
	public void setId(long id) {
		_localRich.setId(id);
	}

	/**
	* Sets the id periodicita of this local rich.
	*
	* @param idPeriodicita the id periodicita of this local rich
	*/
	@Override
	public void setIdPeriodicita(long idPeriodicita) {
		_localRich.setIdPeriodicita(idPeriodicita);
	}

	/**
	* Sets the id sede of this local rich.
	*
	* @param idSede the id sede of this local rich
	*/
	@Override
	public void setIdSede(java.lang.String idSede) {
		_localRich.setIdSede(idSede);
	}

	/**
	* Sets the id stato attuale of this local rich.
	*
	* @param idStatoAttuale the id stato attuale of this local rich
	*/
	@Override
	public void setIdStatoAttuale(long idStatoAttuale) {
		_localRich.setIdStatoAttuale(idStatoAttuale);
	}

	/**
	* Sets the id_richiesta of this local rich.
	*
	* @param id_richiesta the id_richiesta of this local rich
	*/
	@Override
	public void setId_richiesta(long id_richiesta) {
		_localRich.setId_richiesta(id_richiesta);
	}

	/**
	* Sets whether this local rich is in stage.
	*
	* @param inStage the in stage of this local rich
	*/
	@Override
	public void setInStage(boolean inStage) {
		_localRich.setInStage(inStage);
	}

	/**
	* Sets the ispettorato of this local rich.
	*
	* @param ispettorato the ispettorato of this local rich
	*/
	@Override
	public void setIspettorato(java.lang.String ispettorato) {
		_localRich.setIspettorato(ispettorato);
	}

	@Override
	public void setNew(boolean n) {
		_localRich.setNew(n);
	}

	/**
	* Sets the note of this local rich.
	*
	* @param note the note of this local rich
	*/
	@Override
	public void setNote(java.lang.String note) {
		_localRich.setNote(note);
	}

	/**
	* Sets the note rich of this local rich.
	*
	* @param noteRich the note rich of this local rich
	*/
	@Override
	public void setNoteRich(java.lang.String noteRich) {
		_localRich.setNoteRich(noteRich);
	}

	/**
	* Sets the oggetto of this local rich.
	*
	* @param oggetto the oggetto of this local rich
	*/
	@Override
	public void setOggetto(java.lang.String oggetto) {
		_localRich.setOggetto(oggetto);
	}

	/**
	* Sets the preventivo of this local rich.
	*
	* @param preventivo the preventivo of this local rich
	*/
	@Override
	public void setPreventivo(int preventivo) {
		_localRich.setPreventivo(preventivo);
	}

	/**
	* Sets the primary key of this local rich.
	*
	* @param primaryKey the primary key of this local rich
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_localRich.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_localRich.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rif stanza of this local rich.
	*
	* @param rifStanza the rif stanza of this local rich
	*/
	@Override
	public void setRifStanza(java.lang.String rifStanza) {
		_localRich.setRifStanza(rifStanza);
	}

	/**
	* Sets the strut isp of this local rich.
	*
	* @param strutIsp the strut isp of this local rich
	*/
	@Override
	public void setStrutIsp(java.lang.String strutIsp) {
		_localRich.setStrutIsp(strutIsp);
	}

	/**
	* Sets the strut isp2 of this local rich.
	*
	* @param strutIsp2 the strut isp2 of this local rich
	*/
	@Override
	public void setStrutIsp2(java.lang.String strutIsp2) {
		_localRich.setStrutIsp2(strutIsp2);
	}

	/**
	* Sets the strut uff of this local rich.
	*
	* @param strutUff the strut uff of this local rich
	*/
	@Override
	public void setStrutUff(java.lang.String strutUff) {
		_localRich.setStrutUff(strutUff);
	}

	/**
	* Sets the tel rich of this local rich.
	*
	* @param telRich the tel rich of this local rich
	*/
	@Override
	public void setTelRich(java.lang.String telRich) {
		_localRich.setTelRich(telRich);
	}

	/**
	* Sets the ufficio of this local rich.
	*
	* @param ufficio the ufficio of this local rich
	*/
	@Override
	public void setUfficio(java.lang.String ufficio) {
		_localRich.setUfficio(ufficio);
	}

	/**
	* Sets the uid ins of this local rich.
	*
	* @param uidIns the uid ins of this local rich
	*/
	@Override
	public void setUidIns(long uidIns) {
		_localRich.setUidIns(uidIns);
	}

	/**
	* Sets the uid upd of this local rich.
	*
	* @param uidUpd the uid upd of this local rich
	*/
	@Override
	public void setUidUpd(long uidUpd) {
		_localRich.setUidUpd(uidUpd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocalRichWrapper)) {
			return false;
		}

		LocalRichWrapper localRichWrapper = (LocalRichWrapper)obj;

		if (Objects.equals(_localRich, localRichWrapper._localRich)) {
			return true;
		}

		return false;
	}

	@Override
	public LocalRich getWrappedModel() {
		return _localRich;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _localRich.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _localRich.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_localRich.resetOriginalValues();
	}

	private final LocalRich _localRich;
}