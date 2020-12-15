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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link BeneInvRichiesto}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvRichiesto
 * @generated
 */
@ProviderType
public class BeneInvRichiestoWrapper implements BeneInvRichiesto,
	ModelWrapper<BeneInvRichiesto> {
	public BeneInvRichiestoWrapper(BeneInvRichiesto beneInvRichiesto) {
		_beneInvRichiesto = beneInvRichiesto;
	}

	@Override
	public Class<?> getModelClass() {
		return BeneInvRichiesto.class;
	}

	@Override
	public String getModelClassName() {
		return BeneInvRichiesto.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_bene_rich", getId_bene_rich());
		attributes.put("tipologia", getTipologia());
		attributes.put("descrizione", getDescrizione());
		attributes.put("quantita", getQuantita());
		attributes.put("dettagli", getDettagli());
		attributes.put("in_elenco", getIn_elenco());
		attributes.put("id_richiesta", getId_richiesta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_bene_rich = (Long)attributes.get("id_bene_rich");

		if (id_bene_rich != null) {
			setId_bene_rich(id_bene_rich);
		}

		String tipologia = (String)attributes.get("tipologia");

		if (tipologia != null) {
			setTipologia(tipologia);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		Integer quantita = (Integer)attributes.get("quantita");

		if (quantita != null) {
			setQuantita(quantita);
		}

		String dettagli = (String)attributes.get("dettagli");

		if (dettagli != null) {
			setDettagli(dettagli);
		}

		Boolean in_elenco = (Boolean)attributes.get("in_elenco");

		if (in_elenco != null) {
			setIn_elenco(in_elenco);
		}

		Long id_richiesta = (Long)attributes.get("id_richiesta");

		if (id_richiesta != null) {
			setId_richiesta(id_richiesta);
		}
	}

	/**
	* Returns the in_elenco of this bene inv richiesto.
	*
	* @return the in_elenco of this bene inv richiesto
	*/
	@Override
	public boolean getIn_elenco() {
		return _beneInvRichiesto.getIn_elenco();
	}

	@Override
	public boolean isCachedModel() {
		return _beneInvRichiesto.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _beneInvRichiesto.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this bene inv richiesto is in_elenco.
	*
	* @return <code>true</code> if this bene inv richiesto is in_elenco; <code>false</code> otherwise
	*/
	@Override
	public boolean isIn_elenco() {
		return _beneInvRichiesto.isIn_elenco();
	}

	@Override
	public boolean isNew() {
		return _beneInvRichiesto.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _beneInvRichiesto.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.BeneInvRichiesto> toCacheModel() {
		return _beneInvRichiesto.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.BeneInvRichiesto beneInvRichiesto) {
		return _beneInvRichiesto.compareTo(beneInvRichiesto);
	}

	/**
	* Returns the quantita of this bene inv richiesto.
	*
	* @return the quantita of this bene inv richiesto
	*/
	@Override
	public int getQuantita() {
		return _beneInvRichiesto.getQuantita();
	}

	@Override
	public int hashCode() {
		return _beneInvRichiesto.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _beneInvRichiesto.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BeneInvRichiestoWrapper((BeneInvRichiesto)_beneInvRichiesto.clone());
	}

	/**
	* Returns the descrizione of this bene inv richiesto.
	*
	* @return the descrizione of this bene inv richiesto
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _beneInvRichiesto.getDescrizione();
	}

	/**
	* Returns the dettagli of this bene inv richiesto.
	*
	* @return the dettagli of this bene inv richiesto
	*/
	@Override
	public java.lang.String getDettagli() {
		return _beneInvRichiesto.getDettagli();
	}

	/**
	* Returns the tipologia of this bene inv richiesto.
	*
	* @return the tipologia of this bene inv richiesto
	*/
	@Override
	public java.lang.String getTipologia() {
		return _beneInvRichiesto.getTipologia();
	}

	@Override
	public java.lang.String toString() {
		return _beneInvRichiesto.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _beneInvRichiesto.toXmlString();
	}

	/**
	* Returns the id_bene_rich of this bene inv richiesto.
	*
	* @return the id_bene_rich of this bene inv richiesto
	*/
	@Override
	public long getId_bene_rich() {
		return _beneInvRichiesto.getId_bene_rich();
	}

	/**
	* Returns the id_richiesta of this bene inv richiesto.
	*
	* @return the id_richiesta of this bene inv richiesto
	*/
	@Override
	public long getId_richiesta() {
		return _beneInvRichiesto.getId_richiesta();
	}

	/**
	* Returns the primary key of this bene inv richiesto.
	*
	* @return the primary key of this bene inv richiesto
	*/
	@Override
	public long getPrimaryKey() {
		return _beneInvRichiesto.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.BeneInvRichiesto toEscapedModel() {
		return new BeneInvRichiestoWrapper(_beneInvRichiesto.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.BeneInvRichiesto toUnescapedModel() {
		return new BeneInvRichiestoWrapper(_beneInvRichiesto.toUnescapedModel());
	}

	@Override
	public void persist() {
		_beneInvRichiesto.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_beneInvRichiesto.setCachedModel(cachedModel);
	}

	/**
	* Sets the descrizione of this bene inv richiesto.
	*
	* @param descrizione the descrizione of this bene inv richiesto
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_beneInvRichiesto.setDescrizione(descrizione);
	}

	/**
	* Sets the dettagli of this bene inv richiesto.
	*
	* @param dettagli the dettagli of this bene inv richiesto
	*/
	@Override
	public void setDettagli(java.lang.String dettagli) {
		_beneInvRichiesto.setDettagli(dettagli);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_beneInvRichiesto.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_beneInvRichiesto.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_beneInvRichiesto.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_bene_rich of this bene inv richiesto.
	*
	* @param id_bene_rich the id_bene_rich of this bene inv richiesto
	*/
	@Override
	public void setId_bene_rich(long id_bene_rich) {
		_beneInvRichiesto.setId_bene_rich(id_bene_rich);
	}

	/**
	* Sets the id_richiesta of this bene inv richiesto.
	*
	* @param id_richiesta the id_richiesta of this bene inv richiesto
	*/
	@Override
	public void setId_richiesta(long id_richiesta) {
		_beneInvRichiesto.setId_richiesta(id_richiesta);
	}

	/**
	* Sets whether this bene inv richiesto is in_elenco.
	*
	* @param in_elenco the in_elenco of this bene inv richiesto
	*/
	@Override
	public void setIn_elenco(boolean in_elenco) {
		_beneInvRichiesto.setIn_elenco(in_elenco);
	}

	@Override
	public void setNew(boolean n) {
		_beneInvRichiesto.setNew(n);
	}

	/**
	* Sets the primary key of this bene inv richiesto.
	*
	* @param primaryKey the primary key of this bene inv richiesto
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_beneInvRichiesto.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_beneInvRichiesto.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the quantita of this bene inv richiesto.
	*
	* @param quantita the quantita of this bene inv richiesto
	*/
	@Override
	public void setQuantita(int quantita) {
		_beneInvRichiesto.setQuantita(quantita);
	}

	/**
	* Sets the tipologia of this bene inv richiesto.
	*
	* @param tipologia the tipologia of this bene inv richiesto
	*/
	@Override
	public void setTipologia(java.lang.String tipologia) {
		_beneInvRichiesto.setTipologia(tipologia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BeneInvRichiestoWrapper)) {
			return false;
		}

		BeneInvRichiestoWrapper beneInvRichiestoWrapper = (BeneInvRichiestoWrapper)obj;

		if (Objects.equals(_beneInvRichiesto,
					beneInvRichiestoWrapper._beneInvRichiesto)) {
			return true;
		}

		return false;
	}

	@Override
	public BeneInvRichiesto getWrappedModel() {
		return _beneInvRichiesto;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _beneInvRichiesto.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _beneInvRichiesto.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_beneInvRichiesto.resetOriginalValues();
	}

	private final BeneInvRichiesto _beneInvRichiesto;
}