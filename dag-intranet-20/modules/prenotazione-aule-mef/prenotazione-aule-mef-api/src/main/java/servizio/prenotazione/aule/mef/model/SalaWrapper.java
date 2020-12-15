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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Sala}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Sala
 * @generated
 */
@ProviderType
public class SalaWrapper implements Sala, ModelWrapper<Sala> {
	public SalaWrapper(Sala sala) {
		_sala = sala;
	}

	@Override
	public Class<?> getModelClass() {
		return Sala.class;
	}

	@Override
	public String getModelClassName() {
		return Sala.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_sala", getId_sala());
		attributes.put("desc_sala", getDesc_sala());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("citta", getCitta());
		attributes.put("cap", getCap());
		attributes.put("cod_prov", getCod_prov());
		attributes.put("piano", getPiano());
		attributes.put("stanza", getStanza());
		attributes.put("posti", getPosti());
		attributes.put("video_conferenza", getVideo_conferenza());
		attributes.put("proiettore", getProiettore());
		attributes.put("postazione_rete", getPostazione_rete());
		attributes.put("autorizzazione", getAutorizzazione());
		attributes.put("email_ref", getEmail_ref());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_sala = (Long)attributes.get("id_sala");

		if (id_sala != null) {
			setId_sala(id_sala);
		}

		String desc_sala = (String)attributes.get("desc_sala");

		if (desc_sala != null) {
			setDesc_sala(desc_sala);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String citta = (String)attributes.get("citta");

		if (citta != null) {
			setCitta(citta);
		}

		String cap = (String)attributes.get("cap");

		if (cap != null) {
			setCap(cap);
		}

		String cod_prov = (String)attributes.get("cod_prov");

		if (cod_prov != null) {
			setCod_prov(cod_prov);
		}

		String piano = (String)attributes.get("piano");

		if (piano != null) {
			setPiano(piano);
		}

		String stanza = (String)attributes.get("stanza");

		if (stanza != null) {
			setStanza(stanza);
		}

		Integer posti = (Integer)attributes.get("posti");

		if (posti != null) {
			setPosti(posti);
		}

		Boolean video_conferenza = (Boolean)attributes.get("video_conferenza");

		if (video_conferenza != null) {
			setVideo_conferenza(video_conferenza);
		}

		Boolean proiettore = (Boolean)attributes.get("proiettore");

		if (proiettore != null) {
			setProiettore(proiettore);
		}

		Boolean postazione_rete = (Boolean)attributes.get("postazione_rete");

		if (postazione_rete != null) {
			setPostazione_rete(postazione_rete);
		}

		Boolean autorizzazione = (Boolean)attributes.get("autorizzazione");

		if (autorizzazione != null) {
			setAutorizzazione(autorizzazione);
		}

		String email_ref = (String)attributes.get("email_ref");

		if (email_ref != null) {
			setEmail_ref(email_ref);
		}
	}

	/**
	* Returns the autorizzazione of this sala.
	*
	* @return the autorizzazione of this sala
	*/
	@Override
	public boolean getAutorizzazione() {
		return _sala.getAutorizzazione();
	}

	/**
	* Returns the postazione_rete of this sala.
	*
	* @return the postazione_rete of this sala
	*/
	@Override
	public boolean getPostazione_rete() {
		return _sala.getPostazione_rete();
	}

	/**
	* Returns the proiettore of this sala.
	*
	* @return the proiettore of this sala
	*/
	@Override
	public boolean getProiettore() {
		return _sala.getProiettore();
	}

	/**
	* Returns the video_conferenza of this sala.
	*
	* @return the video_conferenza of this sala
	*/
	@Override
	public boolean getVideo_conferenza() {
		return _sala.getVideo_conferenza();
	}

	/**
	* Returns <code>true</code> if this sala is autorizzazione.
	*
	* @return <code>true</code> if this sala is autorizzazione; <code>false</code> otherwise
	*/
	@Override
	public boolean isAutorizzazione() {
		return _sala.isAutorizzazione();
	}

	@Override
	public boolean isCachedModel() {
		return _sala.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _sala.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _sala.isNew();
	}

	/**
	* Returns <code>true</code> if this sala is postazione_rete.
	*
	* @return <code>true</code> if this sala is postazione_rete; <code>false</code> otherwise
	*/
	@Override
	public boolean isPostazione_rete() {
		return _sala.isPostazione_rete();
	}

	/**
	* Returns <code>true</code> if this sala is proiettore.
	*
	* @return <code>true</code> if this sala is proiettore; <code>false</code> otherwise
	*/
	@Override
	public boolean isProiettore() {
		return _sala.isProiettore();
	}

	/**
	* Returns <code>true</code> if this sala is video_conferenza.
	*
	* @return <code>true</code> if this sala is video_conferenza; <code>false</code> otherwise
	*/
	@Override
	public boolean isVideo_conferenza() {
		return _sala.isVideo_conferenza();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sala.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.prenotazione.aule.mef.model.Sala> toCacheModel() {
		return _sala.toCacheModel();
	}

	@Override
	public int compareTo(servizio.prenotazione.aule.mef.model.Sala sala) {
		return _sala.compareTo(sala);
	}

	/**
	* Returns the posti of this sala.
	*
	* @return the posti of this sala
	*/
	@Override
	public int getPosti() {
		return _sala.getPosti();
	}

	@Override
	public int hashCode() {
		return _sala.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sala.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SalaWrapper((Sala)_sala.clone());
	}

	/**
	* Returns the cap of this sala.
	*
	* @return the cap of this sala
	*/
	@Override
	public java.lang.String getCap() {
		return _sala.getCap();
	}

	/**
	* Returns the citta of this sala.
	*
	* @return the citta of this sala
	*/
	@Override
	public java.lang.String getCitta() {
		return _sala.getCitta();
	}

	/**
	* Returns the cod_prov of this sala.
	*
	* @return the cod_prov of this sala
	*/
	@Override
	public java.lang.String getCod_prov() {
		return _sala.getCod_prov();
	}

	/**
	* Returns the desc_sala of this sala.
	*
	* @return the desc_sala of this sala
	*/
	@Override
	public java.lang.String getDesc_sala() {
		return _sala.getDesc_sala();
	}

	/**
	* Returns the email_ref of this sala.
	*
	* @return the email_ref of this sala
	*/
	@Override
	public java.lang.String getEmail_ref() {
		return _sala.getEmail_ref();
	}

	/**
	* Returns the indirizzo of this sala.
	*
	* @return the indirizzo of this sala
	*/
	@Override
	public java.lang.String getIndirizzo() {
		return _sala.getIndirizzo();
	}

	/**
	* Returns the piano of this sala.
	*
	* @return the piano of this sala
	*/
	@Override
	public java.lang.String getPiano() {
		return _sala.getPiano();
	}

	/**
	* Returns the stanza of this sala.
	*
	* @return the stanza of this sala
	*/
	@Override
	public java.lang.String getStanza() {
		return _sala.getStanza();
	}

	@Override
	public java.lang.String toString() {
		return _sala.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sala.toXmlString();
	}

	/**
	* Returns the id_sala of this sala.
	*
	* @return the id_sala of this sala
	*/
	@Override
	public long getId_sala() {
		return _sala.getId_sala();
	}

	/**
	* Returns the primary key of this sala.
	*
	* @return the primary key of this sala
	*/
	@Override
	public long getPrimaryKey() {
		return _sala.getPrimaryKey();
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Sala toEscapedModel() {
		return new SalaWrapper(_sala.toEscapedModel());
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Sala toUnescapedModel() {
		return new SalaWrapper(_sala.toUnescapedModel());
	}

	@Override
	public void persist() {
		_sala.persist();
	}

	/**
	* Sets whether this sala is autorizzazione.
	*
	* @param autorizzazione the autorizzazione of this sala
	*/
	@Override
	public void setAutorizzazione(boolean autorizzazione) {
		_sala.setAutorizzazione(autorizzazione);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sala.setCachedModel(cachedModel);
	}

	/**
	* Sets the cap of this sala.
	*
	* @param cap the cap of this sala
	*/
	@Override
	public void setCap(java.lang.String cap) {
		_sala.setCap(cap);
	}

	/**
	* Sets the citta of this sala.
	*
	* @param citta the citta of this sala
	*/
	@Override
	public void setCitta(java.lang.String citta) {
		_sala.setCitta(citta);
	}

	/**
	* Sets the cod_prov of this sala.
	*
	* @param cod_prov the cod_prov of this sala
	*/
	@Override
	public void setCod_prov(java.lang.String cod_prov) {
		_sala.setCod_prov(cod_prov);
	}

	/**
	* Sets the desc_sala of this sala.
	*
	* @param desc_sala the desc_sala of this sala
	*/
	@Override
	public void setDesc_sala(java.lang.String desc_sala) {
		_sala.setDesc_sala(desc_sala);
	}

	/**
	* Sets the email_ref of this sala.
	*
	* @param email_ref the email_ref of this sala
	*/
	@Override
	public void setEmail_ref(java.lang.String email_ref) {
		_sala.setEmail_ref(email_ref);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sala.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_sala.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sala.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_sala of this sala.
	*
	* @param id_sala the id_sala of this sala
	*/
	@Override
	public void setId_sala(long id_sala) {
		_sala.setId_sala(id_sala);
	}

	/**
	* Sets the indirizzo of this sala.
	*
	* @param indirizzo the indirizzo of this sala
	*/
	@Override
	public void setIndirizzo(java.lang.String indirizzo) {
		_sala.setIndirizzo(indirizzo);
	}

	@Override
	public void setNew(boolean n) {
		_sala.setNew(n);
	}

	/**
	* Sets the piano of this sala.
	*
	* @param piano the piano of this sala
	*/
	@Override
	public void setPiano(java.lang.String piano) {
		_sala.setPiano(piano);
	}

	/**
	* Sets whether this sala is postazione_rete.
	*
	* @param postazione_rete the postazione_rete of this sala
	*/
	@Override
	public void setPostazione_rete(boolean postazione_rete) {
		_sala.setPostazione_rete(postazione_rete);
	}

	/**
	* Sets the posti of this sala.
	*
	* @param posti the posti of this sala
	*/
	@Override
	public void setPosti(int posti) {
		_sala.setPosti(posti);
	}

	/**
	* Sets the primary key of this sala.
	*
	* @param primaryKey the primary key of this sala
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sala.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sala.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this sala is proiettore.
	*
	* @param proiettore the proiettore of this sala
	*/
	@Override
	public void setProiettore(boolean proiettore) {
		_sala.setProiettore(proiettore);
	}

	/**
	* Sets the stanza of this sala.
	*
	* @param stanza the stanza of this sala
	*/
	@Override
	public void setStanza(java.lang.String stanza) {
		_sala.setStanza(stanza);
	}

	/**
	* Sets whether this sala is video_conferenza.
	*
	* @param video_conferenza the video_conferenza of this sala
	*/
	@Override
	public void setVideo_conferenza(boolean video_conferenza) {
		_sala.setVideo_conferenza(video_conferenza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SalaWrapper)) {
			return false;
		}

		SalaWrapper salaWrapper = (SalaWrapper)obj;

		if (Objects.equals(_sala, salaWrapper._sala)) {
			return true;
		}

		return false;
	}

	@Override
	public Sala getWrappedModel() {
		return _sala;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sala.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sala.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sala.resetOriginalValues();
	}

	private final Sala _sala;
}