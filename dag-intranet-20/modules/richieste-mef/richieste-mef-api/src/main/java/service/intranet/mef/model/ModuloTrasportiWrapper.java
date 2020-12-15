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
 * This class is a wrapper for {@link ModuloTrasporti}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModuloTrasporti
 * @generated
 */
@ProviderType
public class ModuloTrasportiWrapper implements ModuloTrasporti,
	ModelWrapper<ModuloTrasporti> {
	public ModuloTrasportiWrapper(ModuloTrasporti moduloTrasporti) {
		_moduloTrasporti = moduloTrasporti;
	}

	@Override
	public Class<?> getModelClass() {
		return ModuloTrasporti.class;
	}

	@Override
	public String getModelClassName() {
		return ModuloTrasporti.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_modulo_trasporti", getId_modulo_trasporti());
		attributes.put("cognome", getCognome());
		attributes.put("nome", getNome());
		attributes.put("codice_fiscale", getCodice_fiscale());
		attributes.put("utente_inserimento", getUtente_inserimento());
		attributes.put("data_inserimento", getData_inserimento());
		attributes.put("flag_tipospesa", getFlag_tipospesa());
		attributes.put("iban", getIban());
		attributes.put("importo", getImporto());
		attributes.put("data_titolo_annuale", getData_titolo_annuale());
		attributes.put("nr_titoli_mensili", getNr_titoli_mensili());
		attributes.put("figlio_nome", getFiglio_nome());
		attributes.put("figlio_cognome", getFiglio_cognome());
		attributes.put("figlio_data_nascita", getFiglio_data_nascita());
		attributes.put("figlio_luogo_data", getFiglio_luogo_data());
		attributes.put("figlio_codicefiscale", getFiglio_codicefiscale());
		attributes.put("note", getNote());
		attributes.put("flag_inviato", getFlag_inviato());
		attributes.put("telefono", getTelefono());
		attributes.put("allegatoUuid", getAllegatoUuid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_modulo_trasporti = (Long)attributes.get("id_modulo_trasporti");

		if (id_modulo_trasporti != null) {
			setId_modulo_trasporti(id_modulo_trasporti);
		}

		String cognome = (String)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String codice_fiscale = (String)attributes.get("codice_fiscale");

		if (codice_fiscale != null) {
			setCodice_fiscale(codice_fiscale);
		}

		String utente_inserimento = (String)attributes.get("utente_inserimento");

		if (utente_inserimento != null) {
			setUtente_inserimento(utente_inserimento);
		}

		Date data_inserimento = (Date)attributes.get("data_inserimento");

		if (data_inserimento != null) {
			setData_inserimento(data_inserimento);
		}

		String flag_tipospesa = (String)attributes.get("flag_tipospesa");

		if (flag_tipospesa != null) {
			setFlag_tipospesa(flag_tipospesa);
		}

		String iban = (String)attributes.get("iban");

		if (iban != null) {
			setIban(iban);
		}

		String importo = (String)attributes.get("importo");

		if (importo != null) {
			setImporto(importo);
		}

		Date data_titolo_annuale = (Date)attributes.get("data_titolo_annuale");

		if (data_titolo_annuale != null) {
			setData_titolo_annuale(data_titolo_annuale);
		}

		String nr_titoli_mensili = (String)attributes.get("nr_titoli_mensili");

		if (nr_titoli_mensili != null) {
			setNr_titoli_mensili(nr_titoli_mensili);
		}

		String figlio_nome = (String)attributes.get("figlio_nome");

		if (figlio_nome != null) {
			setFiglio_nome(figlio_nome);
		}

		String figlio_cognome = (String)attributes.get("figlio_cognome");

		if (figlio_cognome != null) {
			setFiglio_cognome(figlio_cognome);
		}

		Date figlio_data_nascita = (Date)attributes.get("figlio_data_nascita");

		if (figlio_data_nascita != null) {
			setFiglio_data_nascita(figlio_data_nascita);
		}

		String figlio_luogo_data = (String)attributes.get("figlio_luogo_data");

		if (figlio_luogo_data != null) {
			setFiglio_luogo_data(figlio_luogo_data);
		}

		String figlio_codicefiscale = (String)attributes.get(
				"figlio_codicefiscale");

		if (figlio_codicefiscale != null) {
			setFiglio_codicefiscale(figlio_codicefiscale);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String flag_inviato = (String)attributes.get("flag_inviato");

		if (flag_inviato != null) {
			setFlag_inviato(flag_inviato);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String allegatoUuid = (String)attributes.get("allegatoUuid");

		if (allegatoUuid != null) {
			setAllegatoUuid(allegatoUuid);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _moduloTrasporti.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _moduloTrasporti.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _moduloTrasporti.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _moduloTrasporti.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<service.intranet.mef.model.ModuloTrasporti> toCacheModel() {
		return _moduloTrasporti.toCacheModel();
	}

	@Override
	public int compareTo(
		service.intranet.mef.model.ModuloTrasporti moduloTrasporti) {
		return _moduloTrasporti.compareTo(moduloTrasporti);
	}

	@Override
	public int hashCode() {
		return _moduloTrasporti.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _moduloTrasporti.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ModuloTrasportiWrapper((ModuloTrasporti)_moduloTrasporti.clone());
	}

	/**
	* Returns the allegato uuid of this modulo trasporti.
	*
	* @return the allegato uuid of this modulo trasporti
	*/
	@Override
	public java.lang.String getAllegatoUuid() {
		return _moduloTrasporti.getAllegatoUuid();
	}

	/**
	* Returns the codice_fiscale of this modulo trasporti.
	*
	* @return the codice_fiscale of this modulo trasporti
	*/
	@Override
	public java.lang.String getCodice_fiscale() {
		return _moduloTrasporti.getCodice_fiscale();
	}

	/**
	* Returns the cognome of this modulo trasporti.
	*
	* @return the cognome of this modulo trasporti
	*/
	@Override
	public java.lang.String getCognome() {
		return _moduloTrasporti.getCognome();
	}

	/**
	* Returns the figlio_codicefiscale of this modulo trasporti.
	*
	* @return the figlio_codicefiscale of this modulo trasporti
	*/
	@Override
	public java.lang.String getFiglio_codicefiscale() {
		return _moduloTrasporti.getFiglio_codicefiscale();
	}

	/**
	* Returns the figlio_cognome of this modulo trasporti.
	*
	* @return the figlio_cognome of this modulo trasporti
	*/
	@Override
	public java.lang.String getFiglio_cognome() {
		return _moduloTrasporti.getFiglio_cognome();
	}

	/**
	* Returns the figlio_luogo_data of this modulo trasporti.
	*
	* @return the figlio_luogo_data of this modulo trasporti
	*/
	@Override
	public java.lang.String getFiglio_luogo_data() {
		return _moduloTrasporti.getFiglio_luogo_data();
	}

	/**
	* Returns the figlio_nome of this modulo trasporti.
	*
	* @return the figlio_nome of this modulo trasporti
	*/
	@Override
	public java.lang.String getFiglio_nome() {
		return _moduloTrasporti.getFiglio_nome();
	}

	/**
	* Returns the flag_inviato of this modulo trasporti.
	*
	* @return the flag_inviato of this modulo trasporti
	*/
	@Override
	public java.lang.String getFlag_inviato() {
		return _moduloTrasporti.getFlag_inviato();
	}

	/**
	* Returns the flag_tipospesa of this modulo trasporti.
	*
	* @return the flag_tipospesa of this modulo trasporti
	*/
	@Override
	public java.lang.String getFlag_tipospesa() {
		return _moduloTrasporti.getFlag_tipospesa();
	}

	/**
	* Returns the iban of this modulo trasporti.
	*
	* @return the iban of this modulo trasporti
	*/
	@Override
	public java.lang.String getIban() {
		return _moduloTrasporti.getIban();
	}

	/**
	* Returns the importo of this modulo trasporti.
	*
	* @return the importo of this modulo trasporti
	*/
	@Override
	public java.lang.String getImporto() {
		return _moduloTrasporti.getImporto();
	}

	/**
	* Returns the nome of this modulo trasporti.
	*
	* @return the nome of this modulo trasporti
	*/
	@Override
	public java.lang.String getNome() {
		return _moduloTrasporti.getNome();
	}

	/**
	* Returns the note of this modulo trasporti.
	*
	* @return the note of this modulo trasporti
	*/
	@Override
	public java.lang.String getNote() {
		return _moduloTrasporti.getNote();
	}

	/**
	* Returns the nr_titoli_mensili of this modulo trasporti.
	*
	* @return the nr_titoli_mensili of this modulo trasporti
	*/
	@Override
	public java.lang.String getNr_titoli_mensili() {
		return _moduloTrasporti.getNr_titoli_mensili();
	}

	/**
	* Returns the telefono of this modulo trasporti.
	*
	* @return the telefono of this modulo trasporti
	*/
	@Override
	public java.lang.String getTelefono() {
		return _moduloTrasporti.getTelefono();
	}

	/**
	* Returns the utente_inserimento of this modulo trasporti.
	*
	* @return the utente_inserimento of this modulo trasporti
	*/
	@Override
	public java.lang.String getUtente_inserimento() {
		return _moduloTrasporti.getUtente_inserimento();
	}

	@Override
	public java.lang.String toString() {
		return _moduloTrasporti.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _moduloTrasporti.toXmlString();
	}

	/**
	* Returns the data_inserimento of this modulo trasporti.
	*
	* @return the data_inserimento of this modulo trasporti
	*/
	@Override
	public Date getData_inserimento() {
		return _moduloTrasporti.getData_inserimento();
	}

	/**
	* Returns the data_titolo_annuale of this modulo trasporti.
	*
	* @return the data_titolo_annuale of this modulo trasporti
	*/
	@Override
	public Date getData_titolo_annuale() {
		return _moduloTrasporti.getData_titolo_annuale();
	}

	/**
	* Returns the figlio_data_nascita of this modulo trasporti.
	*
	* @return the figlio_data_nascita of this modulo trasporti
	*/
	@Override
	public Date getFiglio_data_nascita() {
		return _moduloTrasporti.getFiglio_data_nascita();
	}

	/**
	* Returns the id_modulo_trasporti of this modulo trasporti.
	*
	* @return the id_modulo_trasporti of this modulo trasporti
	*/
	@Override
	public long getId_modulo_trasporti() {
		return _moduloTrasporti.getId_modulo_trasporti();
	}

	/**
	* Returns the primary key of this modulo trasporti.
	*
	* @return the primary key of this modulo trasporti
	*/
	@Override
	public long getPrimaryKey() {
		return _moduloTrasporti.getPrimaryKey();
	}

	@Override
	public service.intranet.mef.model.ModuloTrasporti toEscapedModel() {
		return new ModuloTrasportiWrapper(_moduloTrasporti.toEscapedModel());
	}

	@Override
	public service.intranet.mef.model.ModuloTrasporti toUnescapedModel() {
		return new ModuloTrasportiWrapper(_moduloTrasporti.toUnescapedModel());
	}

	@Override
	public void persist() {
		_moduloTrasporti.persist();
	}

	/**
	* Sets the allegato uuid of this modulo trasporti.
	*
	* @param allegatoUuid the allegato uuid of this modulo trasporti
	*/
	@Override
	public void setAllegatoUuid(java.lang.String allegatoUuid) {
		_moduloTrasporti.setAllegatoUuid(allegatoUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_moduloTrasporti.setCachedModel(cachedModel);
	}

	/**
	* Sets the codice_fiscale of this modulo trasporti.
	*
	* @param codice_fiscale the codice_fiscale of this modulo trasporti
	*/
	@Override
	public void setCodice_fiscale(java.lang.String codice_fiscale) {
		_moduloTrasporti.setCodice_fiscale(codice_fiscale);
	}

	/**
	* Sets the cognome of this modulo trasporti.
	*
	* @param cognome the cognome of this modulo trasporti
	*/
	@Override
	public void setCognome(java.lang.String cognome) {
		_moduloTrasporti.setCognome(cognome);
	}

	/**
	* Sets the data_inserimento of this modulo trasporti.
	*
	* @param data_inserimento the data_inserimento of this modulo trasporti
	*/
	@Override
	public void setData_inserimento(Date data_inserimento) {
		_moduloTrasporti.setData_inserimento(data_inserimento);
	}

	/**
	* Sets the data_titolo_annuale of this modulo trasporti.
	*
	* @param data_titolo_annuale the data_titolo_annuale of this modulo trasporti
	*/
	@Override
	public void setData_titolo_annuale(Date data_titolo_annuale) {
		_moduloTrasporti.setData_titolo_annuale(data_titolo_annuale);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_moduloTrasporti.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_moduloTrasporti.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_moduloTrasporti.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the figlio_codicefiscale of this modulo trasporti.
	*
	* @param figlio_codicefiscale the figlio_codicefiscale of this modulo trasporti
	*/
	@Override
	public void setFiglio_codicefiscale(java.lang.String figlio_codicefiscale) {
		_moduloTrasporti.setFiglio_codicefiscale(figlio_codicefiscale);
	}

	/**
	* Sets the figlio_cognome of this modulo trasporti.
	*
	* @param figlio_cognome the figlio_cognome of this modulo trasporti
	*/
	@Override
	public void setFiglio_cognome(java.lang.String figlio_cognome) {
		_moduloTrasporti.setFiglio_cognome(figlio_cognome);
	}

	/**
	* Sets the figlio_data_nascita of this modulo trasporti.
	*
	* @param figlio_data_nascita the figlio_data_nascita of this modulo trasporti
	*/
	@Override
	public void setFiglio_data_nascita(Date figlio_data_nascita) {
		_moduloTrasporti.setFiglio_data_nascita(figlio_data_nascita);
	}

	/**
	* Sets the figlio_luogo_data of this modulo trasporti.
	*
	* @param figlio_luogo_data the figlio_luogo_data of this modulo trasporti
	*/
	@Override
	public void setFiglio_luogo_data(java.lang.String figlio_luogo_data) {
		_moduloTrasporti.setFiglio_luogo_data(figlio_luogo_data);
	}

	/**
	* Sets the figlio_nome of this modulo trasporti.
	*
	* @param figlio_nome the figlio_nome of this modulo trasporti
	*/
	@Override
	public void setFiglio_nome(java.lang.String figlio_nome) {
		_moduloTrasporti.setFiglio_nome(figlio_nome);
	}

	/**
	* Sets the flag_inviato of this modulo trasporti.
	*
	* @param flag_inviato the flag_inviato of this modulo trasporti
	*/
	@Override
	public void setFlag_inviato(java.lang.String flag_inviato) {
		_moduloTrasporti.setFlag_inviato(flag_inviato);
	}

	/**
	* Sets the flag_tipospesa of this modulo trasporti.
	*
	* @param flag_tipospesa the flag_tipospesa of this modulo trasporti
	*/
	@Override
	public void setFlag_tipospesa(java.lang.String flag_tipospesa) {
		_moduloTrasporti.setFlag_tipospesa(flag_tipospesa);
	}

	/**
	* Sets the iban of this modulo trasporti.
	*
	* @param iban the iban of this modulo trasporti
	*/
	@Override
	public void setIban(java.lang.String iban) {
		_moduloTrasporti.setIban(iban);
	}

	/**
	* Sets the id_modulo_trasporti of this modulo trasporti.
	*
	* @param id_modulo_trasporti the id_modulo_trasporti of this modulo trasporti
	*/
	@Override
	public void setId_modulo_trasporti(long id_modulo_trasporti) {
		_moduloTrasporti.setId_modulo_trasporti(id_modulo_trasporti);
	}

	/**
	* Sets the importo of this modulo trasporti.
	*
	* @param importo the importo of this modulo trasporti
	*/
	@Override
	public void setImporto(java.lang.String importo) {
		_moduloTrasporti.setImporto(importo);
	}

	@Override
	public void setNew(boolean n) {
		_moduloTrasporti.setNew(n);
	}

	/**
	* Sets the nome of this modulo trasporti.
	*
	* @param nome the nome of this modulo trasporti
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_moduloTrasporti.setNome(nome);
	}

	/**
	* Sets the note of this modulo trasporti.
	*
	* @param note the note of this modulo trasporti
	*/
	@Override
	public void setNote(java.lang.String note) {
		_moduloTrasporti.setNote(note);
	}

	/**
	* Sets the nr_titoli_mensili of this modulo trasporti.
	*
	* @param nr_titoli_mensili the nr_titoli_mensili of this modulo trasporti
	*/
	@Override
	public void setNr_titoli_mensili(java.lang.String nr_titoli_mensili) {
		_moduloTrasporti.setNr_titoli_mensili(nr_titoli_mensili);
	}

	/**
	* Sets the primary key of this modulo trasporti.
	*
	* @param primaryKey the primary key of this modulo trasporti
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_moduloTrasporti.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_moduloTrasporti.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the telefono of this modulo trasporti.
	*
	* @param telefono the telefono of this modulo trasporti
	*/
	@Override
	public void setTelefono(java.lang.String telefono) {
		_moduloTrasporti.setTelefono(telefono);
	}

	/**
	* Sets the utente_inserimento of this modulo trasporti.
	*
	* @param utente_inserimento the utente_inserimento of this modulo trasporti
	*/
	@Override
	public void setUtente_inserimento(java.lang.String utente_inserimento) {
		_moduloTrasporti.setUtente_inserimento(utente_inserimento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ModuloTrasportiWrapper)) {
			return false;
		}

		ModuloTrasportiWrapper moduloTrasportiWrapper = (ModuloTrasportiWrapper)obj;

		if (Objects.equals(_moduloTrasporti,
					moduloTrasportiWrapper._moduloTrasporti)) {
			return true;
		}

		return false;
	}

	@Override
	public ModuloTrasporti getWrappedModel() {
		return _moduloTrasporti;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _moduloTrasporti.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _moduloTrasporti.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_moduloTrasporti.resetOriginalValues();
	}

	private final ModuloTrasporti _moduloTrasporti;
}