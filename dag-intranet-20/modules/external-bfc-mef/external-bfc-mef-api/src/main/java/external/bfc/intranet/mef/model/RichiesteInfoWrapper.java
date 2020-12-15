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
 * This class is a wrapper for {@link RichiesteInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteInfo
 * @generated
 */
@ProviderType
public class RichiesteInfoWrapper implements RichiesteInfo,
	ModelWrapper<RichiesteInfo> {
	public RichiesteInfoWrapper(RichiesteInfo richiesteInfo) {
		_richiesteInfo = richiesteInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiesteInfo.class;
	}

	@Override
	public String getModelClassName() {
		return RichiesteInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idStatoAttuale", getIdStatoAttuale());
		attributes.put("id", getId());
		attributes.put("dataRichiesta", getDataRichiesta());
		attributes.put("email", getEmail());
		attributes.put("riferimentoStanza", getRiferimentoStanza());
		attributes.put("ispettorato", getIspettorato());
		attributes.put("nomeReferente", getNomeReferente());
		attributes.put("telefonoReferente", getTelefonoReferente());
		attributes.put("nMacchina", getNMacchina());
		attributes.put("noteRichiedente", getNoteRichiedente());
		attributes.put("ufficio", getUfficio());
		attributes.put("note", getNote());
		attributes.put("uidIns", getUidIns());
		attributes.put("dataIns", getDataIns());
		attributes.put("uidUpd", getUidUpd());
		attributes.put("dataUpd", getDataUpd());
		attributes.put("oggetto", getOggetto());
		attributes.put("idSede", getIdSede());
		attributes.put("telRichiedente", getTelRichiedente());
		attributes.put("strutUff", getStrutUff());
		attributes.put("strutIsp", getStrutIsp());
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

		String nomeReferente = (String)attributes.get("nomeReferente");

		if (nomeReferente != null) {
			setNomeReferente(nomeReferente);
		}

		String telefonoReferente = (String)attributes.get("telefonoReferente");

		if (telefonoReferente != null) {
			setTelefonoReferente(telefonoReferente);
		}

		String nMacchina = (String)attributes.get("nMacchina");

		if (nMacchina != null) {
			setNMacchina(nMacchina);
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

		String telRichiedente = (String)attributes.get("telRichiedente");

		if (telRichiedente != null) {
			setTelRichiedente(telRichiedente);
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
	}

	@Override
	public boolean isCachedModel() {
		return _richiesteInfo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiesteInfo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiesteInfo.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiesteInfo.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<external.bfc.intranet.mef.model.RichiesteInfo> toCacheModel() {
		return _richiesteInfo.toCacheModel();
	}

	@Override
	public external.bfc.intranet.mef.model.RichiesteInfo toEscapedModel() {
		return new RichiesteInfoWrapper(_richiesteInfo.toEscapedModel());
	}

	@Override
	public external.bfc.intranet.mef.model.RichiesteInfo toUnescapedModel() {
		return new RichiesteInfoWrapper(_richiesteInfo.toUnescapedModel());
	}

	/**
	* Returns the costo reale of this richieste info.
	*
	* @return the costo reale of this richieste info
	*/
	@Override
	public float getCostoReale() {
		return _richiesteInfo.getCostoReale();
	}

	@Override
	public int compareTo(
		external.bfc.intranet.mef.model.RichiesteInfo richiesteInfo) {
		return _richiesteInfo.compareTo(richiesteInfo);
	}

	/**
	* Returns the flag invio of this richieste info.
	*
	* @return the flag invio of this richieste info
	*/
	@Override
	public int getFlagInvio() {
		return _richiesteInfo.getFlagInvio();
	}

	/**
	* Returns the preventivo of this richieste info.
	*
	* @return the preventivo of this richieste info
	*/
	@Override
	public int getPreventivo() {
		return _richiesteInfo.getPreventivo();
	}

	@Override
	public int hashCode() {
		return _richiesteInfo.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiesteInfo.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiesteInfoWrapper((RichiesteInfo)_richiesteInfo.clone());
	}

	/**
	* Returns the email of this richieste info.
	*
	* @return the email of this richieste info
	*/
	@Override
	public java.lang.String getEmail() {
		return _richiesteInfo.getEmail();
	}

	/**
	* Returns the id sede of this richieste info.
	*
	* @return the id sede of this richieste info
	*/
	@Override
	public java.lang.String getIdSede() {
		return _richiesteInfo.getIdSede();
	}

	/**
	* Returns the ispettorato of this richieste info.
	*
	* @return the ispettorato of this richieste info
	*/
	@Override
	public java.lang.String getIspettorato() {
		return _richiesteInfo.getIspettorato();
	}

	/**
	* Returns the n macchina of this richieste info.
	*
	* @return the n macchina of this richieste info
	*/
	@Override
	public java.lang.String getNMacchina() {
		return _richiesteInfo.getNMacchina();
	}

	/**
	* Returns the nome referente of this richieste info.
	*
	* @return the nome referente of this richieste info
	*/
	@Override
	public java.lang.String getNomeReferente() {
		return _richiesteInfo.getNomeReferente();
	}

	/**
	* Returns the note of this richieste info.
	*
	* @return the note of this richieste info
	*/
	@Override
	public java.lang.String getNote() {
		return _richiesteInfo.getNote();
	}

	/**
	* Returns the note richiedente of this richieste info.
	*
	* @return the note richiedente of this richieste info
	*/
	@Override
	public java.lang.String getNoteRichiedente() {
		return _richiesteInfo.getNoteRichiedente();
	}

	/**
	* Returns the oggetto of this richieste info.
	*
	* @return the oggetto of this richieste info
	*/
	@Override
	public java.lang.String getOggetto() {
		return _richiesteInfo.getOggetto();
	}

	/**
	* Returns the riferimento stanza of this richieste info.
	*
	* @return the riferimento stanza of this richieste info
	*/
	@Override
	public java.lang.String getRiferimentoStanza() {
		return _richiesteInfo.getRiferimentoStanza();
	}

	/**
	* Returns the strut isp of this richieste info.
	*
	* @return the strut isp of this richieste info
	*/
	@Override
	public java.lang.String getStrutIsp() {
		return _richiesteInfo.getStrutIsp();
	}

	/**
	* Returns the strut uff of this richieste info.
	*
	* @return the strut uff of this richieste info
	*/
	@Override
	public java.lang.String getStrutUff() {
		return _richiesteInfo.getStrutUff();
	}

	/**
	* Returns the tel richiedente of this richieste info.
	*
	* @return the tel richiedente of this richieste info
	*/
	@Override
	public java.lang.String getTelRichiedente() {
		return _richiesteInfo.getTelRichiedente();
	}

	/**
	* Returns the telefono referente of this richieste info.
	*
	* @return the telefono referente of this richieste info
	*/
	@Override
	public java.lang.String getTelefonoReferente() {
		return _richiesteInfo.getTelefonoReferente();
	}

	/**
	* Returns the ufficio of this richieste info.
	*
	* @return the ufficio of this richieste info
	*/
	@Override
	public java.lang.String getUfficio() {
		return _richiesteInfo.getUfficio();
	}

	@Override
	public java.lang.String toString() {
		return _richiesteInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiesteInfo.toXmlString();
	}

	/**
	* Returns the data ins of this richieste info.
	*
	* @return the data ins of this richieste info
	*/
	@Override
	public Date getDataIns() {
		return _richiesteInfo.getDataIns();
	}

	/**
	* Returns the data richiesta of this richieste info.
	*
	* @return the data richiesta of this richieste info
	*/
	@Override
	public Date getDataRichiesta() {
		return _richiesteInfo.getDataRichiesta();
	}

	/**
	* Returns the data upd of this richieste info.
	*
	* @return the data upd of this richieste info
	*/
	@Override
	public Date getDataUpd() {
		return _richiesteInfo.getDataUpd();
	}

	/**
	* Returns the ID of this richieste info.
	*
	* @return the ID of this richieste info
	*/
	@Override
	public long getId() {
		return _richiesteInfo.getId();
	}

	/**
	* Returns the id stato attuale of this richieste info.
	*
	* @return the id stato attuale of this richieste info
	*/
	@Override
	public long getIdStatoAttuale() {
		return _richiesteInfo.getIdStatoAttuale();
	}

	/**
	* Returns the primary key of this richieste info.
	*
	* @return the primary key of this richieste info
	*/
	@Override
	public long getPrimaryKey() {
		return _richiesteInfo.getPrimaryKey();
	}

	/**
	* Returns the uid ins of this richieste info.
	*
	* @return the uid ins of this richieste info
	*/
	@Override
	public long getUidIns() {
		return _richiesteInfo.getUidIns();
	}

	/**
	* Returns the uid upd of this richieste info.
	*
	* @return the uid upd of this richieste info
	*/
	@Override
	public long getUidUpd() {
		return _richiesteInfo.getUidUpd();
	}

	@Override
	public void persist() {
		_richiesteInfo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiesteInfo.setCachedModel(cachedModel);
	}

	/**
	* Sets the costo reale of this richieste info.
	*
	* @param costoReale the costo reale of this richieste info
	*/
	@Override
	public void setCostoReale(float costoReale) {
		_richiesteInfo.setCostoReale(costoReale);
	}

	/**
	* Sets the data ins of this richieste info.
	*
	* @param dataIns the data ins of this richieste info
	*/
	@Override
	public void setDataIns(Date dataIns) {
		_richiesteInfo.setDataIns(dataIns);
	}

	/**
	* Sets the data richiesta of this richieste info.
	*
	* @param dataRichiesta the data richiesta of this richieste info
	*/
	@Override
	public void setDataRichiesta(Date dataRichiesta) {
		_richiesteInfo.setDataRichiesta(dataRichiesta);
	}

	/**
	* Sets the data upd of this richieste info.
	*
	* @param dataUpd the data upd of this richieste info
	*/
	@Override
	public void setDataUpd(Date dataUpd) {
		_richiesteInfo.setDataUpd(dataUpd);
	}

	/**
	* Sets the email of this richieste info.
	*
	* @param email the email of this richieste info
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_richiesteInfo.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiesteInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiesteInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiesteInfo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flag invio of this richieste info.
	*
	* @param flagInvio the flag invio of this richieste info
	*/
	@Override
	public void setFlagInvio(int flagInvio) {
		_richiesteInfo.setFlagInvio(flagInvio);
	}

	/**
	* Sets the ID of this richieste info.
	*
	* @param id the ID of this richieste info
	*/
	@Override
	public void setId(long id) {
		_richiesteInfo.setId(id);
	}

	/**
	* Sets the id sede of this richieste info.
	*
	* @param idSede the id sede of this richieste info
	*/
	@Override
	public void setIdSede(java.lang.String idSede) {
		_richiesteInfo.setIdSede(idSede);
	}

	/**
	* Sets the id stato attuale of this richieste info.
	*
	* @param idStatoAttuale the id stato attuale of this richieste info
	*/
	@Override
	public void setIdStatoAttuale(long idStatoAttuale) {
		_richiesteInfo.setIdStatoAttuale(idStatoAttuale);
	}

	/**
	* Sets the ispettorato of this richieste info.
	*
	* @param ispettorato the ispettorato of this richieste info
	*/
	@Override
	public void setIspettorato(java.lang.String ispettorato) {
		_richiesteInfo.setIspettorato(ispettorato);
	}

	/**
	* Sets the n macchina of this richieste info.
	*
	* @param nMacchina the n macchina of this richieste info
	*/
	@Override
	public void setNMacchina(java.lang.String nMacchina) {
		_richiesteInfo.setNMacchina(nMacchina);
	}

	@Override
	public void setNew(boolean n) {
		_richiesteInfo.setNew(n);
	}

	/**
	* Sets the nome referente of this richieste info.
	*
	* @param nomeReferente the nome referente of this richieste info
	*/
	@Override
	public void setNomeReferente(java.lang.String nomeReferente) {
		_richiesteInfo.setNomeReferente(nomeReferente);
	}

	/**
	* Sets the note of this richieste info.
	*
	* @param note the note of this richieste info
	*/
	@Override
	public void setNote(java.lang.String note) {
		_richiesteInfo.setNote(note);
	}

	/**
	* Sets the note richiedente of this richieste info.
	*
	* @param noteRichiedente the note richiedente of this richieste info
	*/
	@Override
	public void setNoteRichiedente(java.lang.String noteRichiedente) {
		_richiesteInfo.setNoteRichiedente(noteRichiedente);
	}

	/**
	* Sets the oggetto of this richieste info.
	*
	* @param oggetto the oggetto of this richieste info
	*/
	@Override
	public void setOggetto(java.lang.String oggetto) {
		_richiesteInfo.setOggetto(oggetto);
	}

	/**
	* Sets the preventivo of this richieste info.
	*
	* @param preventivo the preventivo of this richieste info
	*/
	@Override
	public void setPreventivo(int preventivo) {
		_richiesteInfo.setPreventivo(preventivo);
	}

	/**
	* Sets the primary key of this richieste info.
	*
	* @param primaryKey the primary key of this richieste info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiesteInfo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiesteInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the riferimento stanza of this richieste info.
	*
	* @param riferimentoStanza the riferimento stanza of this richieste info
	*/
	@Override
	public void setRiferimentoStanza(java.lang.String riferimentoStanza) {
		_richiesteInfo.setRiferimentoStanza(riferimentoStanza);
	}

	/**
	* Sets the strut isp of this richieste info.
	*
	* @param strutIsp the strut isp of this richieste info
	*/
	@Override
	public void setStrutIsp(java.lang.String strutIsp) {
		_richiesteInfo.setStrutIsp(strutIsp);
	}

	/**
	* Sets the strut uff of this richieste info.
	*
	* @param strutUff the strut uff of this richieste info
	*/
	@Override
	public void setStrutUff(java.lang.String strutUff) {
		_richiesteInfo.setStrutUff(strutUff);
	}

	/**
	* Sets the tel richiedente of this richieste info.
	*
	* @param telRichiedente the tel richiedente of this richieste info
	*/
	@Override
	public void setTelRichiedente(java.lang.String telRichiedente) {
		_richiesteInfo.setTelRichiedente(telRichiedente);
	}

	/**
	* Sets the telefono referente of this richieste info.
	*
	* @param telefonoReferente the telefono referente of this richieste info
	*/
	@Override
	public void setTelefonoReferente(java.lang.String telefonoReferente) {
		_richiesteInfo.setTelefonoReferente(telefonoReferente);
	}

	/**
	* Sets the ufficio of this richieste info.
	*
	* @param ufficio the ufficio of this richieste info
	*/
	@Override
	public void setUfficio(java.lang.String ufficio) {
		_richiesteInfo.setUfficio(ufficio);
	}

	/**
	* Sets the uid ins of this richieste info.
	*
	* @param uidIns the uid ins of this richieste info
	*/
	@Override
	public void setUidIns(long uidIns) {
		_richiesteInfo.setUidIns(uidIns);
	}

	/**
	* Sets the uid upd of this richieste info.
	*
	* @param uidUpd the uid upd of this richieste info
	*/
	@Override
	public void setUidUpd(long uidUpd) {
		_richiesteInfo.setUidUpd(uidUpd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteInfoWrapper)) {
			return false;
		}

		RichiesteInfoWrapper richiesteInfoWrapper = (RichiesteInfoWrapper)obj;

		if (Objects.equals(_richiesteInfo, richiesteInfoWrapper._richiesteInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiesteInfo getWrappedModel() {
		return _richiesteInfo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiesteInfo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiesteInfo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiesteInfo.resetOriginalValues();
	}

	private final RichiesteInfo _richiesteInfo;
}