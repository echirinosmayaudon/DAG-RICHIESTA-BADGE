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

package servizio.whistleblowing.mef.model;

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
 * This class is a wrapper for {@link Segnalazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Segnalazione
 * @generated
 */
@ProviderType
public class SegnalazioneWrapper implements Segnalazione,
	ModelWrapper<Segnalazione> {
	public SegnalazioneWrapper(Segnalazione segnalazione) {
		_segnalazione = segnalazione;
	}

	@Override
	public Class<?> getModelClass() {
		return Segnalazione.class;
	}

	@Override
	public String getModelClassName() {
		return Segnalazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_segnalazione", getId_segnalazione());
		attributes.put("json_dati_personali", getJson_dati_personali());
		attributes.put("luogo", getLuogo());
		attributes.put("azioni_omissioni", getAzioni_omissioni());
		attributes.put("descrizione", getDescrizione());
		attributes.put("autore", getAutore());
		attributes.put("altri_testimoni", getAltri_testimoni());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_segnalazione = (Long)attributes.get("id_segnalazione");

		if (id_segnalazione != null) {
			setId_segnalazione(id_segnalazione);
		}

		String json_dati_personali = (String)attributes.get(
				"json_dati_personali");

		if (json_dati_personali != null) {
			setJson_dati_personali(json_dati_personali);
		}

		String luogo = (String)attributes.get("luogo");

		if (luogo != null) {
			setLuogo(luogo);
		}

		String azioni_omissioni = (String)attributes.get("azioni_omissioni");

		if (azioni_omissioni != null) {
			setAzioni_omissioni(azioni_omissioni);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String autore = (String)attributes.get("autore");

		if (autore != null) {
			setAutore(autore);
		}

		String altri_testimoni = (String)attributes.get("altri_testimoni");

		if (altri_testimoni != null) {
			setAltri_testimoni(altri_testimoni);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _segnalazione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _segnalazione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _segnalazione.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _segnalazione.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.whistleblowing.mef.model.Segnalazione> toCacheModel() {
		return _segnalazione.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.whistleblowing.mef.model.Segnalazione segnalazione) {
		return _segnalazione.compareTo(segnalazione);
	}

	@Override
	public int hashCode() {
		return _segnalazione.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _segnalazione.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SegnalazioneWrapper((Segnalazione)_segnalazione.clone());
	}

	/**
	* Returns the altri_testimoni of this segnalazione.
	*
	* @return the altri_testimoni of this segnalazione
	*/
	@Override
	public java.lang.String getAltri_testimoni() {
		return _segnalazione.getAltri_testimoni();
	}

	/**
	* Returns the autore of this segnalazione.
	*
	* @return the autore of this segnalazione
	*/
	@Override
	public java.lang.String getAutore() {
		return _segnalazione.getAutore();
	}

	/**
	* Returns the azioni_omissioni of this segnalazione.
	*
	* @return the azioni_omissioni of this segnalazione
	*/
	@Override
	public java.lang.String getAzioni_omissioni() {
		return _segnalazione.getAzioni_omissioni();
	}

	/**
	* Returns the descrizione of this segnalazione.
	*
	* @return the descrizione of this segnalazione
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _segnalazione.getDescrizione();
	}

	/**
	* Returns the json_dati_personali of this segnalazione.
	*
	* @return the json_dati_personali of this segnalazione
	*/
	@Override
	public java.lang.String getJson_dati_personali() {
		return _segnalazione.getJson_dati_personali();
	}

	/**
	* Returns the luogo of this segnalazione.
	*
	* @return the luogo of this segnalazione
	*/
	@Override
	public java.lang.String getLuogo() {
		return _segnalazione.getLuogo();
	}

	@Override
	public java.lang.String toString() {
		return _segnalazione.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _segnalazione.toXmlString();
	}

	/**
	* Returns the id_segnalazione of this segnalazione.
	*
	* @return the id_segnalazione of this segnalazione
	*/
	@Override
	public long getId_segnalazione() {
		return _segnalazione.getId_segnalazione();
	}

	/**
	* Returns the primary key of this segnalazione.
	*
	* @return the primary key of this segnalazione
	*/
	@Override
	public long getPrimaryKey() {
		return _segnalazione.getPrimaryKey();
	}

	@Override
	public servizio.whistleblowing.mef.model.Segnalazione toEscapedModel() {
		return new SegnalazioneWrapper(_segnalazione.toEscapedModel());
	}

	@Override
	public servizio.whistleblowing.mef.model.Segnalazione toUnescapedModel() {
		return new SegnalazioneWrapper(_segnalazione.toUnescapedModel());
	}

	@Override
	public void persist() {
		_segnalazione.persist();
	}

	/**
	* Sets the altri_testimoni of this segnalazione.
	*
	* @param altri_testimoni the altri_testimoni of this segnalazione
	*/
	@Override
	public void setAltri_testimoni(java.lang.String altri_testimoni) {
		_segnalazione.setAltri_testimoni(altri_testimoni);
	}

	/**
	* Sets the autore of this segnalazione.
	*
	* @param autore the autore of this segnalazione
	*/
	@Override
	public void setAutore(java.lang.String autore) {
		_segnalazione.setAutore(autore);
	}

	/**
	* Sets the azioni_omissioni of this segnalazione.
	*
	* @param azioni_omissioni the azioni_omissioni of this segnalazione
	*/
	@Override
	public void setAzioni_omissioni(java.lang.String azioni_omissioni) {
		_segnalazione.setAzioni_omissioni(azioni_omissioni);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_segnalazione.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this segnalazione.
	*
	* @param descrizione the descrizione of this segnalazione
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_segnalazione.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_segnalazione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_segnalazione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_segnalazione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_segnalazione of this segnalazione.
	*
	* @param id_segnalazione the id_segnalazione of this segnalazione
	*/
	@Override
	public void setId_segnalazione(long id_segnalazione) {
		_segnalazione.setId_segnalazione(id_segnalazione);
	}

	/**
	* Sets the json_dati_personali of this segnalazione.
	*
	* @param json_dati_personali the json_dati_personali of this segnalazione
	*/
	@Override
	public void setJson_dati_personali(java.lang.String json_dati_personali) {
		_segnalazione.setJson_dati_personali(json_dati_personali);
	}

	/**
	* Sets the luogo of this segnalazione.
	*
	* @param luogo the luogo of this segnalazione
	*/
	@Override
	public void setLuogo(java.lang.String luogo) {
		_segnalazione.setLuogo(luogo);
	}

	@Override
	public void setNew(boolean n) {
		_segnalazione.setNew(n);
	}

	/**
	* Sets the primary key of this segnalazione.
	*
	* @param primaryKey the primary key of this segnalazione
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_segnalazione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_segnalazione.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegnalazioneWrapper)) {
			return false;
		}

		SegnalazioneWrapper segnalazioneWrapper = (SegnalazioneWrapper)obj;

		if (Objects.equals(_segnalazione, segnalazioneWrapper._segnalazione)) {
			return true;
		}

		return false;
	}

	@Override
	public Segnalazione getWrappedModel() {
		return _segnalazione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _segnalazione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _segnalazione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_segnalazione.resetOriginalValues();
	}

	private final Segnalazione _segnalazione;
}