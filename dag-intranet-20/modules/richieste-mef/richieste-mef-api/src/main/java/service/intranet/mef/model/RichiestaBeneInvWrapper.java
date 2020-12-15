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
 * This class is a wrapper for {@link RichiestaBeneInv}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInv
 * @generated
 */
@ProviderType
public class RichiestaBeneInvWrapper implements RichiestaBeneInv,
	ModelWrapper<RichiestaBeneInv> {
	public RichiestaBeneInvWrapper(RichiestaBeneInv richiestaBeneInv) {
		_richiestaBeneInv = richiestaBeneInv;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiestaBeneInv.class;
	}

	@Override
	public String getModelClassName() {
		return RichiestaBeneInv.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("utente", getUtente());
		attributes.put("nome_rich", getNome_rich());
		attributes.put("cogn_rich", getCogn_rich());
		attributes.put("dip_dir", getDip_dir());
		attributes.put("dati_rich", getDati_rich());
		attributes.put("oggetto", getOggetto());
		attributes.put("data", getData());
		attributes.put("beneficiario", getBeneficiario());
		attributes.put("destinazione", getDestinazione());
		attributes.put("id_stato", getId_stato());
		attributes.put("note_consegn", getNote_consegn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_richiesta = (Long)attributes.get("id_richiesta");

		if (id_richiesta != null) {
			setId_richiesta(id_richiesta);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		String nome_rich = (String)attributes.get("nome_rich");

		if (nome_rich != null) {
			setNome_rich(nome_rich);
		}

		String cogn_rich = (String)attributes.get("cogn_rich");

		if (cogn_rich != null) {
			setCogn_rich(cogn_rich);
		}

		String dip_dir = (String)attributes.get("dip_dir");

		if (dip_dir != null) {
			setDip_dir(dip_dir);
		}

		String dati_rich = (String)attributes.get("dati_rich");

		if (dati_rich != null) {
			setDati_rich(dati_rich);
		}

		String oggetto = (String)attributes.get("oggetto");

		if (oggetto != null) {
			setOggetto(oggetto);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String beneficiario = (String)attributes.get("beneficiario");

		if (beneficiario != null) {
			setBeneficiario(beneficiario);
		}

		String destinazione = (String)attributes.get("destinazione");

		if (destinazione != null) {
			setDestinazione(destinazione);
		}

		Long id_stato = (Long)attributes.get("id_stato");

		if (id_stato != null) {
			setId_stato(id_stato);
		}

		String note_consegn = (String)attributes.get("note_consegn");

		if (note_consegn != null) {
			setNote_consegn(note_consegn);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _richiestaBeneInv.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiestaBeneInv.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiestaBeneInv.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiestaBeneInv.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.RichiestaBeneInv> toCacheModel() {
		return _richiestaBeneInv.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.RichiestaBeneInv richiestaBeneInv) {
		return _richiestaBeneInv.compareTo(richiestaBeneInv);
	}

	@Override
	public int hashCode() {
		return _richiestaBeneInv.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiestaBeneInv.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiestaBeneInvWrapper((RichiestaBeneInv)_richiestaBeneInv.clone());
	}

	/**
	* Returns the beneficiario of this richiesta bene inv.
	*
	* @return the beneficiario of this richiesta bene inv
	*/
	@Override
	public java.lang.String getBeneficiario() {
		return _richiestaBeneInv.getBeneficiario();
	}

	/**
	* Returns the cogn_rich of this richiesta bene inv.
	*
	* @return the cogn_rich of this richiesta bene inv
	*/
	@Override
	public java.lang.String getCogn_rich() {
		return _richiestaBeneInv.getCogn_rich();
	}

	/**
	* Returns the dati_rich of this richiesta bene inv.
	*
	* @return the dati_rich of this richiesta bene inv
	*/
	@Override
	public java.lang.String getDati_rich() {
		return _richiestaBeneInv.getDati_rich();
	}

	/**
	* Returns the destinazione of this richiesta bene inv.
	*
	* @return the destinazione of this richiesta bene inv
	*/
	@Override
	public java.lang.String getDestinazione() {
		return _richiestaBeneInv.getDestinazione();
	}

	/**
	* Returns the dip_dir of this richiesta bene inv.
	*
	* @return the dip_dir of this richiesta bene inv
	*/
	@Override
	public java.lang.String getDip_dir() {
		return _richiestaBeneInv.getDip_dir();
	}

	/**
	* Returns the nome_rich of this richiesta bene inv.
	*
	* @return the nome_rich of this richiesta bene inv
	*/
	@Override
	public java.lang.String getNome_rich() {
		return _richiestaBeneInv.getNome_rich();
	}

	/**
	* Returns the note_consegn of this richiesta bene inv.
	*
	* @return the note_consegn of this richiesta bene inv
	*/
	@Override
	public java.lang.String getNote_consegn() {
		return _richiestaBeneInv.getNote_consegn();
	}

	/**
	* Returns the oggetto of this richiesta bene inv.
	*
	* @return the oggetto of this richiesta bene inv
	*/
	@Override
	public java.lang.String getOggetto() {
		return _richiestaBeneInv.getOggetto();
	}

	/**
	* Returns the utente of this richiesta bene inv.
	*
	* @return the utente of this richiesta bene inv
	*/
	@Override
	public java.lang.String getUtente() {
		return _richiestaBeneInv.getUtente();
	}

	@Override
	public java.lang.String toString() {
		return _richiestaBeneInv.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiestaBeneInv.toXmlString();
	}

	/**
	* Returns the data of this richiesta bene inv.
	*
	* @return the data of this richiesta bene inv
	*/
	@Override
	public Date getData() {
		return _richiestaBeneInv.getData();
	}

	/**
	* Returns the id_richiesta of this richiesta bene inv.
	*
	* @return the id_richiesta of this richiesta bene inv
	*/
	@Override
	public long getId_richiesta() {
		return _richiestaBeneInv.getId_richiesta();
	}

	/**
	* Returns the id_stato of this richiesta bene inv.
	*
	* @return the id_stato of this richiesta bene inv
	*/
	@Override
	public long getId_stato() {
		return _richiestaBeneInv.getId_stato();
	}

	/**
	* Returns the primary key of this richiesta bene inv.
	*
	* @return the primary key of this richiesta bene inv
	*/
	@Override
	public long getPrimaryKey() {
		return _richiestaBeneInv.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.RichiestaBeneInv toEscapedModel() {
		return new RichiestaBeneInvWrapper(_richiestaBeneInv.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.RichiestaBeneInv toUnescapedModel() {
		return new RichiestaBeneInvWrapper(_richiestaBeneInv.toUnescapedModel());
	}

	@Override
	public void persist() {
		_richiestaBeneInv.persist();
	}

	/**
	* Sets the beneficiario of this richiesta bene inv.
	*
	* @param beneficiario the beneficiario of this richiesta bene inv
	*/
	@Override
	public void setBeneficiario(java.lang.String beneficiario) {
		_richiestaBeneInv.setBeneficiario(beneficiario);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiestaBeneInv.setCachedModel(cachedModel);
	}

	/**
	* Sets the cogn_rich of this richiesta bene inv.
	*
	* @param cogn_rich the cogn_rich of this richiesta bene inv
	*/
	@Override
	public void setCogn_rich(java.lang.String cogn_rich) {
		_richiestaBeneInv.setCogn_rich(cogn_rich);
	}

	/**
	* Sets the data of this richiesta bene inv.
	*
	* @param data the data of this richiesta bene inv
	*/
	@Override
	public void setData(Date data) {
		_richiestaBeneInv.setData(data);
	}

	/**
	* Sets the dati_rich of this richiesta bene inv.
	*
	* @param dati_rich the dati_rich of this richiesta bene inv
	*/
	@Override
	public void setDati_rich(java.lang.String dati_rich) {
		_richiestaBeneInv.setDati_rich(dati_rich);
	}

	/**
	* Sets the destinazione of this richiesta bene inv.
	*
	* @param destinazione the destinazione of this richiesta bene inv
	*/
	@Override
	public void setDestinazione(java.lang.String destinazione) {
		_richiestaBeneInv.setDestinazione(destinazione);
	}

	/**
	* Sets the dip_dir of this richiesta bene inv.
	*
	* @param dip_dir the dip_dir of this richiesta bene inv
	*/
	@Override
	public void setDip_dir(java.lang.String dip_dir) {
		_richiestaBeneInv.setDip_dir(dip_dir);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiestaBeneInv.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiestaBeneInv.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiestaBeneInv.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_richiesta of this richiesta bene inv.
	*
	* @param id_richiesta the id_richiesta of this richiesta bene inv
	*/
	@Override
	public void setId_richiesta(long id_richiesta) {
		_richiestaBeneInv.setId_richiesta(id_richiesta);
	}

	/**
	* Sets the id_stato of this richiesta bene inv.
	*
	* @param id_stato the id_stato of this richiesta bene inv
	*/
	@Override
	public void setId_stato(long id_stato) {
		_richiestaBeneInv.setId_stato(id_stato);
	}

	@Override
	public void setNew(boolean n) {
		_richiestaBeneInv.setNew(n);
	}

	/**
	* Sets the nome_rich of this richiesta bene inv.
	*
	* @param nome_rich the nome_rich of this richiesta bene inv
	*/
	@Override
	public void setNome_rich(java.lang.String nome_rich) {
		_richiestaBeneInv.setNome_rich(nome_rich);
	}

	/**
	* Sets the note_consegn of this richiesta bene inv.
	*
	* @param note_consegn the note_consegn of this richiesta bene inv
	*/
	@Override
	public void setNote_consegn(java.lang.String note_consegn) {
		_richiestaBeneInv.setNote_consegn(note_consegn);
	}

	/**
	* Sets the oggetto of this richiesta bene inv.
	*
	* @param oggetto the oggetto of this richiesta bene inv
	*/
	@Override
	public void setOggetto(java.lang.String oggetto) {
		_richiestaBeneInv.setOggetto(oggetto);
	}

	/**
	* Sets the primary key of this richiesta bene inv.
	*
	* @param primaryKey the primary key of this richiesta bene inv
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiestaBeneInv.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiestaBeneInv.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the utente of this richiesta bene inv.
	*
	* @param utente the utente of this richiesta bene inv
	*/
	@Override
	public void setUtente(java.lang.String utente) {
		_richiestaBeneInv.setUtente(utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaBeneInvWrapper)) {
			return false;
		}

		RichiestaBeneInvWrapper richiestaBeneInvWrapper = (RichiestaBeneInvWrapper)obj;

		if (Objects.equals(_richiestaBeneInv,
					richiestaBeneInvWrapper._richiestaBeneInv)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiestaBeneInv getWrappedModel() {
		return _richiestaBeneInv;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiestaBeneInv.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiestaBeneInv.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiestaBeneInv.resetOriginalValues();
	}

	private final RichiestaBeneInv _richiestaBeneInv;
}