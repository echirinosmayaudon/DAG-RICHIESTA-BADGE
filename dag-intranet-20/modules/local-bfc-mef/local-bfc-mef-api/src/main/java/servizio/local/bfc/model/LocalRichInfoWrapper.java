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
 * This class is a wrapper for {@link LocalRichInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichInfo
 * @generated
 */
@ProviderType
public class LocalRichInfoWrapper implements LocalRichInfo,
	ModelWrapper<LocalRichInfo> {
	public LocalRichInfoWrapper(LocalRichInfo localRichInfo) {
		_localRichInfo = localRichInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return LocalRichInfo.class;
	}

	@Override
	public String getModelClassName() {
		return LocalRichInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idStatoAttuale", getIdStatoAttuale());
		attributes.put("id", getId());
		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("dataRichiesta", getDataRichiesta());
		attributes.put("email", getEmail());
		attributes.put("rifStanza", getRifStanza());
		attributes.put("ispettorato", getIspettorato());
		attributes.put("nomeRef", getNomeRef());
		attributes.put("telRef", getTelRef());
		attributes.put("nMacchina", getNMacchina());
		attributes.put("noteRich", getNoteRich());
		attributes.put("ufficio", getUfficio());
		attributes.put("note", getNote());
		attributes.put("uidIns", getUidIns());
		attributes.put("dataIns", getDataIns());
		attributes.put("uidUpd", getUidUpd());
		attributes.put("dataUpd", getDataUpd());
		attributes.put("oggetto", getOggetto());
		attributes.put("idSede", getIdSede());
		attributes.put("telRich", getTelRich());
		attributes.put("strutUff", getStrutUff());
		attributes.put("strutIsp", getStrutIsp());
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

		String nomeRef = (String)attributes.get("nomeRef");

		if (nomeRef != null) {
			setNomeRef(nomeRef);
		}

		String telRef = (String)attributes.get("telRef");

		if (telRef != null) {
			setTelRef(telRef);
		}

		String nMacchina = (String)attributes.get("nMacchina");

		if (nMacchina != null) {
			setNMacchina(nMacchina);
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

		String telRich = (String)attributes.get("telRich");

		if (telRich != null) {
			setTelRich(telRich);
		}

		String strutUff = (String)attributes.get("strutUff");

		if (strutUff != null) {
			setStrutUff(strutUff);
		}

		String strutIsp = (String)attributes.get("strutIsp");

		if (strutIsp != null) {
			setStrutIsp(strutIsp);
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
	* Returns the in stage of this local rich info.
	*
	* @return the in stage of this local rich info
	*/
	@Override
	public boolean getInStage() {
		return _localRichInfo.getInStage();
	}

	@Override
	public boolean isCachedModel() {
		return _localRichInfo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _localRichInfo.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this local rich info is in stage.
	*
	* @return <code>true</code> if this local rich info is in stage; <code>false</code> otherwise
	*/
	@Override
	public boolean isInStage() {
		return _localRichInfo.isInStage();
	}

	@Override
	public boolean isNew() {
		return _localRichInfo.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _localRichInfo.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.local.bfc.model.LocalRichInfo> toCacheModel() {
		return _localRichInfo.toCacheModel();
	}

	/**
	* Returns the costo reale of this local rich info.
	*
	* @return the costo reale of this local rich info
	*/
	@Override
	public float getCostoReale() {
		return _localRichInfo.getCostoReale();
	}

	@Override
	public int compareTo(servizio.local.bfc.model.LocalRichInfo localRichInfo) {
		return _localRichInfo.compareTo(localRichInfo);
	}

	/**
	* Returns the flag invio of this local rich info.
	*
	* @return the flag invio of this local rich info
	*/
	@Override
	public int getFlagInvio() {
		return _localRichInfo.getFlagInvio();
	}

	/**
	* Returns the preventivo of this local rich info.
	*
	* @return the preventivo of this local rich info
	*/
	@Override
	public int getPreventivo() {
		return _localRichInfo.getPreventivo();
	}

	@Override
	public int hashCode() {
		return _localRichInfo.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localRichInfo.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LocalRichInfoWrapper((LocalRichInfo)_localRichInfo.clone());
	}

	/**
	* Returns the email of this local rich info.
	*
	* @return the email of this local rich info
	*/
	@Override
	public java.lang.String getEmail() {
		return _localRichInfo.getEmail();
	}

	/**
	* Returns the id sede of this local rich info.
	*
	* @return the id sede of this local rich info
	*/
	@Override
	public java.lang.String getIdSede() {
		return _localRichInfo.getIdSede();
	}

	/**
	* Returns the ispettorato of this local rich info.
	*
	* @return the ispettorato of this local rich info
	*/
	@Override
	public java.lang.String getIspettorato() {
		return _localRichInfo.getIspettorato();
	}

	/**
	* Returns the n macchina of this local rich info.
	*
	* @return the n macchina of this local rich info
	*/
	@Override
	public java.lang.String getNMacchina() {
		return _localRichInfo.getNMacchina();
	}

	/**
	* Returns the nome ref of this local rich info.
	*
	* @return the nome ref of this local rich info
	*/
	@Override
	public java.lang.String getNomeRef() {
		return _localRichInfo.getNomeRef();
	}

	/**
	* Returns the note of this local rich info.
	*
	* @return the note of this local rich info
	*/
	@Override
	public java.lang.String getNote() {
		return _localRichInfo.getNote();
	}

	/**
	* Returns the note rich of this local rich info.
	*
	* @return the note rich of this local rich info
	*/
	@Override
	public java.lang.String getNoteRich() {
		return _localRichInfo.getNoteRich();
	}

	/**
	* Returns the oggetto of this local rich info.
	*
	* @return the oggetto of this local rich info
	*/
	@Override
	public java.lang.String getOggetto() {
		return _localRichInfo.getOggetto();
	}

	/**
	* Returns the rif stanza of this local rich info.
	*
	* @return the rif stanza of this local rich info
	*/
	@Override
	public java.lang.String getRifStanza() {
		return _localRichInfo.getRifStanza();
	}

	/**
	* Returns the strut isp of this local rich info.
	*
	* @return the strut isp of this local rich info
	*/
	@Override
	public java.lang.String getStrutIsp() {
		return _localRichInfo.getStrutIsp();
	}

	/**
	* Returns the strut uff of this local rich info.
	*
	* @return the strut uff of this local rich info
	*/
	@Override
	public java.lang.String getStrutUff() {
		return _localRichInfo.getStrutUff();
	}

	/**
	* Returns the tel ref of this local rich info.
	*
	* @return the tel ref of this local rich info
	*/
	@Override
	public java.lang.String getTelRef() {
		return _localRichInfo.getTelRef();
	}

	/**
	* Returns the tel rich of this local rich info.
	*
	* @return the tel rich of this local rich info
	*/
	@Override
	public java.lang.String getTelRich() {
		return _localRichInfo.getTelRich();
	}

	/**
	* Returns the ufficio of this local rich info.
	*
	* @return the ufficio of this local rich info
	*/
	@Override
	public java.lang.String getUfficio() {
		return _localRichInfo.getUfficio();
	}

	@Override
	public java.lang.String toString() {
		return _localRichInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _localRichInfo.toXmlString();
	}

	/**
	* Returns the data ins of this local rich info.
	*
	* @return the data ins of this local rich info
	*/
	@Override
	public Date getDataIns() {
		return _localRichInfo.getDataIns();
	}

	/**
	* Returns the data richiesta of this local rich info.
	*
	* @return the data richiesta of this local rich info
	*/
	@Override
	public Date getDataRichiesta() {
		return _localRichInfo.getDataRichiesta();
	}

	/**
	* Returns the data upd of this local rich info.
	*
	* @return the data upd of this local rich info
	*/
	@Override
	public Date getDataUpd() {
		return _localRichInfo.getDataUpd();
	}

	/**
	* Returns the ID of this local rich info.
	*
	* @return the ID of this local rich info
	*/
	@Override
	public long getId() {
		return _localRichInfo.getId();
	}

	/**
	* Returns the id stato attuale of this local rich info.
	*
	* @return the id stato attuale of this local rich info
	*/
	@Override
	public long getIdStatoAttuale() {
		return _localRichInfo.getIdStatoAttuale();
	}

	/**
	* Returns the id_richiesta of this local rich info.
	*
	* @return the id_richiesta of this local rich info
	*/
	@Override
	public long getId_richiesta() {
		return _localRichInfo.getId_richiesta();
	}

	/**
	* Returns the primary key of this local rich info.
	*
	* @return the primary key of this local rich info
	*/
	@Override
	public long getPrimaryKey() {
		return _localRichInfo.getPrimaryKey();
	}

	/**
	* Returns the uid ins of this local rich info.
	*
	* @return the uid ins of this local rich info
	*/
	@Override
	public long getUidIns() {
		return _localRichInfo.getUidIns();
	}

	/**
	* Returns the uid upd of this local rich info.
	*
	* @return the uid upd of this local rich info
	*/
	@Override
	public long getUidUpd() {
		return _localRichInfo.getUidUpd();
	}

	@Override
	public servizio.local.bfc.model.LocalRichInfo toEscapedModel() {
		return new LocalRichInfoWrapper(_localRichInfo.toEscapedModel());
	}

	@Override
	public servizio.local.bfc.model.LocalRichInfo toUnescapedModel() {
		return new LocalRichInfoWrapper(_localRichInfo.toUnescapedModel());
	}

	@Override
	public void persist() {
		_localRichInfo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_localRichInfo.setCachedModel(cachedModel);
	}

	/**
	* Sets the costo reale of this local rich info.
	*
	* @param costoReale the costo reale of this local rich info
	*/
	@Override
	public void setCostoReale(float costoReale) {
		_localRichInfo.setCostoReale(costoReale);
	}

	/**
	* Sets the data ins of this local rich info.
	*
	* @param dataIns the data ins of this local rich info
	*/
	@Override
	public void setDataIns(Date dataIns) {
		_localRichInfo.setDataIns(dataIns);
	}

	/**
	* Sets the data richiesta of this local rich info.
	*
	* @param dataRichiesta the data richiesta of this local rich info
	*/
	@Override
	public void setDataRichiesta(Date dataRichiesta) {
		_localRichInfo.setDataRichiesta(dataRichiesta);
	}

	/**
	* Sets the data upd of this local rich info.
	*
	* @param dataUpd the data upd of this local rich info
	*/
	@Override
	public void setDataUpd(Date dataUpd) {
		_localRichInfo.setDataUpd(dataUpd);
	}

	/**
	* Sets the email of this local rich info.
	*
	* @param email the email of this local rich info
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_localRichInfo.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_localRichInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_localRichInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_localRichInfo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flag invio of this local rich info.
	*
	* @param flagInvio the flag invio of this local rich info
	*/
	@Override
	public void setFlagInvio(int flagInvio) {
		_localRichInfo.setFlagInvio(flagInvio);
	}

	/**
	* Sets the ID of this local rich info.
	*
	* @param id the ID of this local rich info
	*/
	@Override
	public void setId(long id) {
		_localRichInfo.setId(id);
	}

	/**
	* Sets the id sede of this local rich info.
	*
	* @param idSede the id sede of this local rich info
	*/
	@Override
	public void setIdSede(java.lang.String idSede) {
		_localRichInfo.setIdSede(idSede);
	}

	/**
	* Sets the id stato attuale of this local rich info.
	*
	* @param idStatoAttuale the id stato attuale of this local rich info
	*/
	@Override
	public void setIdStatoAttuale(long idStatoAttuale) {
		_localRichInfo.setIdStatoAttuale(idStatoAttuale);
	}

	/**
	* Sets the id_richiesta of this local rich info.
	*
	* @param id_richiesta the id_richiesta of this local rich info
	*/
	@Override
	public void setId_richiesta(long id_richiesta) {
		_localRichInfo.setId_richiesta(id_richiesta);
	}

	/**
	* Sets whether this local rich info is in stage.
	*
	* @param inStage the in stage of this local rich info
	*/
	@Override
	public void setInStage(boolean inStage) {
		_localRichInfo.setInStage(inStage);
	}

	/**
	* Sets the ispettorato of this local rich info.
	*
	* @param ispettorato the ispettorato of this local rich info
	*/
	@Override
	public void setIspettorato(java.lang.String ispettorato) {
		_localRichInfo.setIspettorato(ispettorato);
	}

	/**
	* Sets the n macchina of this local rich info.
	*
	* @param nMacchina the n macchina of this local rich info
	*/
	@Override
	public void setNMacchina(java.lang.String nMacchina) {
		_localRichInfo.setNMacchina(nMacchina);
	}

	@Override
	public void setNew(boolean n) {
		_localRichInfo.setNew(n);
	}

	/**
	* Sets the nome ref of this local rich info.
	*
	* @param nomeRef the nome ref of this local rich info
	*/
	@Override
	public void setNomeRef(java.lang.String nomeRef) {
		_localRichInfo.setNomeRef(nomeRef);
	}

	/**
	* Sets the note of this local rich info.
	*
	* @param note the note of this local rich info
	*/
	@Override
	public void setNote(java.lang.String note) {
		_localRichInfo.setNote(note);
	}

	/**
	* Sets the note rich of this local rich info.
	*
	* @param noteRich the note rich of this local rich info
	*/
	@Override
	public void setNoteRich(java.lang.String noteRich) {
		_localRichInfo.setNoteRich(noteRich);
	}

	/**
	* Sets the oggetto of this local rich info.
	*
	* @param oggetto the oggetto of this local rich info
	*/
	@Override
	public void setOggetto(java.lang.String oggetto) {
		_localRichInfo.setOggetto(oggetto);
	}

	/**
	* Sets the preventivo of this local rich info.
	*
	* @param preventivo the preventivo of this local rich info
	*/
	@Override
	public void setPreventivo(int preventivo) {
		_localRichInfo.setPreventivo(preventivo);
	}

	/**
	* Sets the primary key of this local rich info.
	*
	* @param primaryKey the primary key of this local rich info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_localRichInfo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_localRichInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rif stanza of this local rich info.
	*
	* @param rifStanza the rif stanza of this local rich info
	*/
	@Override
	public void setRifStanza(java.lang.String rifStanza) {
		_localRichInfo.setRifStanza(rifStanza);
	}

	/**
	* Sets the strut isp of this local rich info.
	*
	* @param strutIsp the strut isp of this local rich info
	*/
	@Override
	public void setStrutIsp(java.lang.String strutIsp) {
		_localRichInfo.setStrutIsp(strutIsp);
	}

	/**
	* Sets the strut uff of this local rich info.
	*
	* @param strutUff the strut uff of this local rich info
	*/
	@Override
	public void setStrutUff(java.lang.String strutUff) {
		_localRichInfo.setStrutUff(strutUff);
	}

	/**
	* Sets the tel ref of this local rich info.
	*
	* @param telRef the tel ref of this local rich info
	*/
	@Override
	public void setTelRef(java.lang.String telRef) {
		_localRichInfo.setTelRef(telRef);
	}

	/**
	* Sets the tel rich of this local rich info.
	*
	* @param telRich the tel rich of this local rich info
	*/
	@Override
	public void setTelRich(java.lang.String telRich) {
		_localRichInfo.setTelRich(telRich);
	}

	/**
	* Sets the ufficio of this local rich info.
	*
	* @param ufficio the ufficio of this local rich info
	*/
	@Override
	public void setUfficio(java.lang.String ufficio) {
		_localRichInfo.setUfficio(ufficio);
	}

	/**
	* Sets the uid ins of this local rich info.
	*
	* @param uidIns the uid ins of this local rich info
	*/
	@Override
	public void setUidIns(long uidIns) {
		_localRichInfo.setUidIns(uidIns);
	}

	/**
	* Sets the uid upd of this local rich info.
	*
	* @param uidUpd the uid upd of this local rich info
	*/
	@Override
	public void setUidUpd(long uidUpd) {
		_localRichInfo.setUidUpd(uidUpd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocalRichInfoWrapper)) {
			return false;
		}

		LocalRichInfoWrapper localRichInfoWrapper = (LocalRichInfoWrapper)obj;

		if (Objects.equals(_localRichInfo, localRichInfoWrapper._localRichInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public LocalRichInfo getWrappedModel() {
		return _localRichInfo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _localRichInfo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _localRichInfo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_localRichInfo.resetOriginalValues();
	}

	private final LocalRichInfo _localRichInfo;
}