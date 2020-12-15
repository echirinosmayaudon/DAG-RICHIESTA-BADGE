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
 * This class is a wrapper for {@link RichiestaPubblicSiti}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPubblicSiti
 * @generated
 */
@ProviderType
public class RichiestaPubblicSitiWrapper implements RichiestaPubblicSiti,
	ModelWrapper<RichiestaPubblicSiti> {
	public RichiestaPubblicSitiWrapper(
		RichiestaPubblicSiti richiestaPubblicSiti) {
		_richiestaPubblicSiti = richiestaPubblicSiti;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiestaPubblicSiti.class;
	}

	@Override
	public String getModelClassName() {
		return RichiestaPubblicSiti.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_rich_pubblic", getId_rich_pubblic());
		attributes.put("dati_richiedente", getDati_richiedente());
		attributes.put("dati_docum", getDati_docum());
		attributes.put("titolo", getTitolo());
		attributes.put("sottotitolo", getSottotitolo());
		attributes.put("novita_abstract", getNovita_abstract());
		attributes.put("note_riferim", getNote_riferim());
		attributes.put("dati_stampa_carta", getDati_stampa_carta());
		attributes.put("dati_altro", getDati_altro());
		attributes.put("dati_autorizzaz", getDati_autorizzaz());
		attributes.put("note_autorizzaz", getNote_autorizzaz());
		attributes.put("lista_allegati", getLista_allegati());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_rich_pubblic = (Long)attributes.get("id_rich_pubblic");

		if (id_rich_pubblic != null) {
			setId_rich_pubblic(id_rich_pubblic);
		}

		String dati_richiedente = (String)attributes.get("dati_richiedente");

		if (dati_richiedente != null) {
			setDati_richiedente(dati_richiedente);
		}

		String dati_docum = (String)attributes.get("dati_docum");

		if (dati_docum != null) {
			setDati_docum(dati_docum);
		}

		String titolo = (String)attributes.get("titolo");

		if (titolo != null) {
			setTitolo(titolo);
		}

		String sottotitolo = (String)attributes.get("sottotitolo");

		if (sottotitolo != null) {
			setSottotitolo(sottotitolo);
		}

		String novita_abstract = (String)attributes.get("novita_abstract");

		if (novita_abstract != null) {
			setNovita_abstract(novita_abstract);
		}

		String note_riferim = (String)attributes.get("note_riferim");

		if (note_riferim != null) {
			setNote_riferim(note_riferim);
		}

		String dati_stampa_carta = (String)attributes.get("dati_stampa_carta");

		if (dati_stampa_carta != null) {
			setDati_stampa_carta(dati_stampa_carta);
		}

		String dati_altro = (String)attributes.get("dati_altro");

		if (dati_altro != null) {
			setDati_altro(dati_altro);
		}

		String dati_autorizzaz = (String)attributes.get("dati_autorizzaz");

		if (dati_autorizzaz != null) {
			setDati_autorizzaz(dati_autorizzaz);
		}

		String note_autorizzaz = (String)attributes.get("note_autorizzaz");

		if (note_autorizzaz != null) {
			setNote_autorizzaz(note_autorizzaz);
		}

		String lista_allegati = (String)attributes.get("lista_allegati");

		if (lista_allegati != null) {
			setLista_allegati(lista_allegati);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _richiestaPubblicSiti.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiestaPubblicSiti.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _richiestaPubblicSiti.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiestaPubblicSiti.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.RichiestaPubblicSiti> toCacheModel() {
		return _richiestaPubblicSiti.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.RichiestaPubblicSiti richiestaPubblicSiti) {
		return _richiestaPubblicSiti.compareTo(richiestaPubblicSiti);
	}

	@Override
	public int hashCode() {
		return _richiestaPubblicSiti.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiestaPubblicSiti.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiestaPubblicSitiWrapper((RichiestaPubblicSiti)_richiestaPubblicSiti.clone());
	}

	/**
	* Returns the dati_altro of this richiesta pubblic siti.
	*
	* @return the dati_altro of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getDati_altro() {
		return _richiestaPubblicSiti.getDati_altro();
	}

	/**
	* Returns the dati_autorizzaz of this richiesta pubblic siti.
	*
	* @return the dati_autorizzaz of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getDati_autorizzaz() {
		return _richiestaPubblicSiti.getDati_autorizzaz();
	}

	/**
	* Returns the dati_docum of this richiesta pubblic siti.
	*
	* @return the dati_docum of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getDati_docum() {
		return _richiestaPubblicSiti.getDati_docum();
	}

	/**
	* Returns the dati_richiedente of this richiesta pubblic siti.
	*
	* @return the dati_richiedente of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getDati_richiedente() {
		return _richiestaPubblicSiti.getDati_richiedente();
	}

	/**
	* Returns the dati_stampa_carta of this richiesta pubblic siti.
	*
	* @return the dati_stampa_carta of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getDati_stampa_carta() {
		return _richiestaPubblicSiti.getDati_stampa_carta();
	}

	/**
	* Returns the lista_allegati of this richiesta pubblic siti.
	*
	* @return the lista_allegati of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getLista_allegati() {
		return _richiestaPubblicSiti.getLista_allegati();
	}

	/**
	* Returns the note_autorizzaz of this richiesta pubblic siti.
	*
	* @return the note_autorizzaz of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getNote_autorizzaz() {
		return _richiestaPubblicSiti.getNote_autorizzaz();
	}

	/**
	* Returns the note_riferim of this richiesta pubblic siti.
	*
	* @return the note_riferim of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getNote_riferim() {
		return _richiestaPubblicSiti.getNote_riferim();
	}

	/**
	* Returns the novita_abstract of this richiesta pubblic siti.
	*
	* @return the novita_abstract of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getNovita_abstract() {
		return _richiestaPubblicSiti.getNovita_abstract();
	}

	/**
	* Returns the sottotitolo of this richiesta pubblic siti.
	*
	* @return the sottotitolo of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getSottotitolo() {
		return _richiestaPubblicSiti.getSottotitolo();
	}

	/**
	* Returns the titolo of this richiesta pubblic siti.
	*
	* @return the titolo of this richiesta pubblic siti
	*/
	@Override
	public java.lang.String getTitolo() {
		return _richiestaPubblicSiti.getTitolo();
	}

	@Override
	public java.lang.String toString() {
		return _richiestaPubblicSiti.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiestaPubblicSiti.toXmlString();
	}

	/**
	* Returns the id_rich_pubblic of this richiesta pubblic siti.
	*
	* @return the id_rich_pubblic of this richiesta pubblic siti
	*/
	@Override
	public long getId_rich_pubblic() {
		return _richiestaPubblicSiti.getId_rich_pubblic();
	}

	/**
	* Returns the primary key of this richiesta pubblic siti.
	*
	* @return the primary key of this richiesta pubblic siti
	*/
	@Override
	public long getPrimaryKey() {
		return _richiestaPubblicSiti.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.RichiestaPubblicSiti toEscapedModel() {
		return new RichiestaPubblicSitiWrapper(_richiestaPubblicSiti.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.RichiestaPubblicSiti toUnescapedModel() {
		return new RichiestaPubblicSitiWrapper(_richiestaPubblicSiti.toUnescapedModel());
	}

	@Override
	public void persist() {
		_richiestaPubblicSiti.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiestaPubblicSiti.setCachedModel(cachedModel);
	}

	/**
	* Sets the dati_altro of this richiesta pubblic siti.
	*
	* @param dati_altro the dati_altro of this richiesta pubblic siti
	*/
	@Override
	public void setDati_altro(java.lang.String dati_altro) {
		_richiestaPubblicSiti.setDati_altro(dati_altro);
	}

	/**
	* Sets the dati_autorizzaz of this richiesta pubblic siti.
	*
	* @param dati_autorizzaz the dati_autorizzaz of this richiesta pubblic siti
	*/
	@Override
	public void setDati_autorizzaz(java.lang.String dati_autorizzaz) {
		_richiestaPubblicSiti.setDati_autorizzaz(dati_autorizzaz);
	}

	/**
	* Sets the dati_docum of this richiesta pubblic siti.
	*
	* @param dati_docum the dati_docum of this richiesta pubblic siti
	*/
	@Override
	public void setDati_docum(java.lang.String dati_docum) {
		_richiestaPubblicSiti.setDati_docum(dati_docum);
	}

	/**
	* Sets the dati_richiedente of this richiesta pubblic siti.
	*
	* @param dati_richiedente the dati_richiedente of this richiesta pubblic siti
	*/
	@Override
	public void setDati_richiedente(java.lang.String dati_richiedente) {
		_richiestaPubblicSiti.setDati_richiedente(dati_richiedente);
	}

	/**
	* Sets the dati_stampa_carta of this richiesta pubblic siti.
	*
	* @param dati_stampa_carta the dati_stampa_carta of this richiesta pubblic siti
	*/
	@Override
	public void setDati_stampa_carta(java.lang.String dati_stampa_carta) {
		_richiestaPubblicSiti.setDati_stampa_carta(dati_stampa_carta);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiestaPubblicSiti.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiestaPubblicSiti.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiestaPubblicSiti.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_rich_pubblic of this richiesta pubblic siti.
	*
	* @param id_rich_pubblic the id_rich_pubblic of this richiesta pubblic siti
	*/
	@Override
	public void setId_rich_pubblic(long id_rich_pubblic) {
		_richiestaPubblicSiti.setId_rich_pubblic(id_rich_pubblic);
	}

	/**
	* Sets the lista_allegati of this richiesta pubblic siti.
	*
	* @param lista_allegati the lista_allegati of this richiesta pubblic siti
	*/
	@Override
	public void setLista_allegati(java.lang.String lista_allegati) {
		_richiestaPubblicSiti.setLista_allegati(lista_allegati);
	}

	@Override
	public void setNew(boolean n) {
		_richiestaPubblicSiti.setNew(n);
	}

	/**
	* Sets the note_autorizzaz of this richiesta pubblic siti.
	*
	* @param note_autorizzaz the note_autorizzaz of this richiesta pubblic siti
	*/
	@Override
	public void setNote_autorizzaz(java.lang.String note_autorizzaz) {
		_richiestaPubblicSiti.setNote_autorizzaz(note_autorizzaz);
	}

	/**
	* Sets the note_riferim of this richiesta pubblic siti.
	*
	* @param note_riferim the note_riferim of this richiesta pubblic siti
	*/
	@Override
	public void setNote_riferim(java.lang.String note_riferim) {
		_richiestaPubblicSiti.setNote_riferim(note_riferim);
	}

	/**
	* Sets the novita_abstract of this richiesta pubblic siti.
	*
	* @param novita_abstract the novita_abstract of this richiesta pubblic siti
	*/
	@Override
	public void setNovita_abstract(java.lang.String novita_abstract) {
		_richiestaPubblicSiti.setNovita_abstract(novita_abstract);
	}

	/**
	* Sets the primary key of this richiesta pubblic siti.
	*
	* @param primaryKey the primary key of this richiesta pubblic siti
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiestaPubblicSiti.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiestaPubblicSiti.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sottotitolo of this richiesta pubblic siti.
	*
	* @param sottotitolo the sottotitolo of this richiesta pubblic siti
	*/
	@Override
	public void setSottotitolo(java.lang.String sottotitolo) {
		_richiestaPubblicSiti.setSottotitolo(sottotitolo);
	}

	/**
	* Sets the titolo of this richiesta pubblic siti.
	*
	* @param titolo the titolo of this richiesta pubblic siti
	*/
	@Override
	public void setTitolo(java.lang.String titolo) {
		_richiestaPubblicSiti.setTitolo(titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaPubblicSitiWrapper)) {
			return false;
		}

		RichiestaPubblicSitiWrapper richiestaPubblicSitiWrapper = (RichiestaPubblicSitiWrapper)obj;

		if (Objects.equals(_richiestaPubblicSiti,
					richiestaPubblicSitiWrapper._richiestaPubblicSiti)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiestaPubblicSiti getWrappedModel() {
		return _richiestaPubblicSiti;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiestaPubblicSiti.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiestaPubblicSiti.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiestaPubblicSiti.resetOriginalValues();
	}

	private final RichiestaPubblicSiti _richiestaPubblicSiti;
}