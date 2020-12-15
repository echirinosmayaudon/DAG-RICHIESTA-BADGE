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

package servizio.richieste.badge.mef.model;

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
 * This class is a wrapper for {@link RichiestaBadge}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadge
 * @generated
 */
@ProviderType
public class RichiestaBadgeWrapper implements RichiestaBadge,
	ModelWrapper<RichiestaBadge> {
	public RichiestaBadgeWrapper(RichiestaBadge richiestaBadge) {
		_richiestaBadge = richiestaBadge;
	}

	@Override
	public Class<?> getModelClass() {
		return RichiestaBadge.class;
	}

	@Override
	public String getModelClassName() {
		return RichiestaBadge.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_pk", getId_pk());
		attributes.put("id_richiesta", getId_richiesta());
		attributes.put("screename_richiedente", getScreename_richiedente());
		attributes.put("id_ufficio", getId_ufficio());
		attributes.put("id_sedesiap", getId_sedesiap());
		attributes.put("json_richiedente", getJson_richiedente());
		attributes.put("is_internal", getIs_internal());
		attributes.put("nome_intestatario", getNome_intestatario());
		attributes.put("cognome_intestatario", getCognome_intestatario());
		attributes.put("cf_intestatario", getCf_intestatario());
		attributes.put("luogonascita_intestatario",
			getLuogonascita_intestatario());
		attributes.put("datanascita_intestatario", getDatanascita_intestatario());
		attributes.put("id_oggetto", getId_oggetto());
		attributes.put("numero_badge", getNumero_badge());
		attributes.put("uuid_foto", getUuid_foto());
		attributes.put("uuid_modulosostituzione", getUuid_modulosostituzione());
		attributes.put("societa", getSocieta());
		attributes.put("referente_societa", getReferente_societa());
		attributes.put("progetto", getProgetto());
		attributes.put("json_richiesta_external", getJson_richiesta_external());
		attributes.put("array_sedi_abilitate", getArray_sedi_abilitate());
		attributes.put("motivazione", getMotivazione());
		attributes.put("data_scadenza", getData_scadenza());
		attributes.put("uuid_modulopdf", getUuid_modulopdf());
		attributes.put("data_richiesta", getData_richiesta());
		attributes.put("data_modifica", getData_modifica());
		attributes.put("id_stato", getId_stato());
		attributes.put("utente_cambio_stato", getUtente_cambio_stato());
		attributes.put("note", getNote());
		attributes.put("is_last", getIs_last());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_pk = (Long)attributes.get("id_pk");

		if (id_pk != null) {
			setId_pk(id_pk);
		}

		Long id_richiesta = (Long)attributes.get("id_richiesta");

		if (id_richiesta != null) {
			setId_richiesta(id_richiesta);
		}

		String screename_richiedente = (String)attributes.get(
				"screename_richiedente");

		if (screename_richiedente != null) {
			setScreename_richiedente(screename_richiedente);
		}

		Long id_ufficio = (Long)attributes.get("id_ufficio");

		if (id_ufficio != null) {
			setId_ufficio(id_ufficio);
		}

		Long id_sedesiap = (Long)attributes.get("id_sedesiap");

		if (id_sedesiap != null) {
			setId_sedesiap(id_sedesiap);
		}

		String json_richiedente = (String)attributes.get("json_richiedente");

		if (json_richiedente != null) {
			setJson_richiedente(json_richiedente);
		}

		Boolean is_internal = (Boolean)attributes.get("is_internal");

		if (is_internal != null) {
			setIs_internal(is_internal);
		}

		String nome_intestatario = (String)attributes.get("nome_intestatario");

		if (nome_intestatario != null) {
			setNome_intestatario(nome_intestatario);
		}

		String cognome_intestatario = (String)attributes.get(
				"cognome_intestatario");

		if (cognome_intestatario != null) {
			setCognome_intestatario(cognome_intestatario);
		}

		String cf_intestatario = (String)attributes.get("cf_intestatario");

		if (cf_intestatario != null) {
			setCf_intestatario(cf_intestatario);
		}

		String luogonascita_intestatario = (String)attributes.get(
				"luogonascita_intestatario");

		if (luogonascita_intestatario != null) {
			setLuogonascita_intestatario(luogonascita_intestatario);
		}

		Date datanascita_intestatario = (Date)attributes.get(
				"datanascita_intestatario");

		if (datanascita_intestatario != null) {
			setDatanascita_intestatario(datanascita_intestatario);
		}

		Long id_oggetto = (Long)attributes.get("id_oggetto");

		if (id_oggetto != null) {
			setId_oggetto(id_oggetto);
		}

		String numero_badge = (String)attributes.get("numero_badge");

		if (numero_badge != null) {
			setNumero_badge(numero_badge);
		}

		String uuid_foto = (String)attributes.get("uuid_foto");

		if (uuid_foto != null) {
			setUuid_foto(uuid_foto);
		}

		String uuid_modulosostituzione = (String)attributes.get(
				"uuid_modulosostituzione");

		if (uuid_modulosostituzione != null) {
			setUuid_modulosostituzione(uuid_modulosostituzione);
		}

		String societa = (String)attributes.get("societa");

		if (societa != null) {
			setSocieta(societa);
		}

		String referente_societa = (String)attributes.get("referente_societa");

		if (referente_societa != null) {
			setReferente_societa(referente_societa);
		}

		String progetto = (String)attributes.get("progetto");

		if (progetto != null) {
			setProgetto(progetto);
		}

		String json_richiesta_external = (String)attributes.get(
				"json_richiesta_external");

		if (json_richiesta_external != null) {
			setJson_richiesta_external(json_richiesta_external);
		}

		String array_sedi_abilitate = (String)attributes.get(
				"array_sedi_abilitate");

		if (array_sedi_abilitate != null) {
			setArray_sedi_abilitate(array_sedi_abilitate);
		}

		String motivazione = (String)attributes.get("motivazione");

		if (motivazione != null) {
			setMotivazione(motivazione);
		}

		Date data_scadenza = (Date)attributes.get("data_scadenza");

		if (data_scadenza != null) {
			setData_scadenza(data_scadenza);
		}

		String uuid_modulopdf = (String)attributes.get("uuid_modulopdf");

		if (uuid_modulopdf != null) {
			setUuid_modulopdf(uuid_modulopdf);
		}

		Date data_richiesta = (Date)attributes.get("data_richiesta");

		if (data_richiesta != null) {
			setData_richiesta(data_richiesta);
		}

		Date data_modifica = (Date)attributes.get("data_modifica");

		if (data_modifica != null) {
			setData_modifica(data_modifica);
		}

		Long id_stato = (Long)attributes.get("id_stato");

		if (id_stato != null) {
			setId_stato(id_stato);
		}

		String utente_cambio_stato = (String)attributes.get(
				"utente_cambio_stato");

		if (utente_cambio_stato != null) {
			setUtente_cambio_stato(utente_cambio_stato);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Boolean is_last = (Boolean)attributes.get("is_last");

		if (is_last != null) {
			setIs_last(is_last);
		}
	}

	/**
	* Returns the is_internal of this richiesta badge.
	*
	* @return the is_internal of this richiesta badge
	*/
	@Override
	public boolean getIs_internal() {
		return _richiestaBadge.getIs_internal();
	}

	/**
	* Returns the is_last of this richiesta badge.
	*
	* @return the is_last of this richiesta badge
	*/
	@Override
	public boolean getIs_last() {
		return _richiestaBadge.getIs_last();
	}

	@Override
	public boolean isCachedModel() {
		return _richiestaBadge.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _richiestaBadge.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this richiesta badge is is_internal.
	*
	* @return <code>true</code> if this richiesta badge is is_internal; <code>false</code> otherwise
	*/
	@Override
	public boolean isIs_internal() {
		return _richiestaBadge.isIs_internal();
	}

	/**
	* Returns <code>true</code> if this richiesta badge is is_last.
	*
	* @return <code>true</code> if this richiesta badge is is_last; <code>false</code> otherwise
	*/
	@Override
	public boolean isIs_last() {
		return _richiestaBadge.isIs_last();
	}

	@Override
	public boolean isNew() {
		return _richiestaBadge.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _richiestaBadge.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<servizio.richieste.badge.mef.model.RichiestaBadge> toCacheModel() {
		return _richiestaBadge.toCacheModel();
	}

	@Override
	public int compareTo(
		servizio.richieste.badge.mef.model.RichiestaBadge richiestaBadge) {
		return _richiestaBadge.compareTo(richiestaBadge);
	}

	@Override
	public int hashCode() {
		return _richiestaBadge.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _richiestaBadge.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RichiestaBadgeWrapper((RichiestaBadge)_richiestaBadge.clone());
	}

	/**
	* Returns the array_sedi_abilitate of this richiesta badge.
	*
	* @return the array_sedi_abilitate of this richiesta badge
	*/
	@Override
	public java.lang.String getArray_sedi_abilitate() {
		return _richiestaBadge.getArray_sedi_abilitate();
	}

	/**
	* Returns the cf_intestatario of this richiesta badge.
	*
	* @return the cf_intestatario of this richiesta badge
	*/
	@Override
	public java.lang.String getCf_intestatario() {
		return _richiestaBadge.getCf_intestatario();
	}

	/**
	* Returns the cognome_intestatario of this richiesta badge.
	*
	* @return the cognome_intestatario of this richiesta badge
	*/
	@Override
	public java.lang.String getCognome_intestatario() {
		return _richiestaBadge.getCognome_intestatario();
	}

	/**
	* Returns the json_richiedente of this richiesta badge.
	*
	* @return the json_richiedente of this richiesta badge
	*/
	@Override
	public java.lang.String getJson_richiedente() {
		return _richiestaBadge.getJson_richiedente();
	}

	/**
	* Returns the json_richiesta_external of this richiesta badge.
	*
	* @return the json_richiesta_external of this richiesta badge
	*/
	@Override
	public java.lang.String getJson_richiesta_external() {
		return _richiestaBadge.getJson_richiesta_external();
	}

	/**
	* Returns the luogonascita_intestatario of this richiesta badge.
	*
	* @return the luogonascita_intestatario of this richiesta badge
	*/
	@Override
	public java.lang.String getLuogonascita_intestatario() {
		return _richiestaBadge.getLuogonascita_intestatario();
	}

	/**
	* Returns the motivazione of this richiesta badge.
	*
	* @return the motivazione of this richiesta badge
	*/
	@Override
	public java.lang.String getMotivazione() {
		return _richiestaBadge.getMotivazione();
	}

	/**
	* Returns the nome_intestatario of this richiesta badge.
	*
	* @return the nome_intestatario of this richiesta badge
	*/
	@Override
	public java.lang.String getNome_intestatario() {
		return _richiestaBadge.getNome_intestatario();
	}

	/**
	* Returns the note of this richiesta badge.
	*
	* @return the note of this richiesta badge
	*/
	@Override
	public java.lang.String getNote() {
		return _richiestaBadge.getNote();
	}

	/**
	* Returns the numero_badge of this richiesta badge.
	*
	* @return the numero_badge of this richiesta badge
	*/
	@Override
	public java.lang.String getNumero_badge() {
		return _richiestaBadge.getNumero_badge();
	}

	/**
	* Returns the progetto of this richiesta badge.
	*
	* @return the progetto of this richiesta badge
	*/
	@Override
	public java.lang.String getProgetto() {
		return _richiestaBadge.getProgetto();
	}

	/**
	* Returns the referente_societa of this richiesta badge.
	*
	* @return the referente_societa of this richiesta badge
	*/
	@Override
	public java.lang.String getReferente_societa() {
		return _richiestaBadge.getReferente_societa();
	}

	/**
	* Returns the screename_richiedente of this richiesta badge.
	*
	* @return the screename_richiedente of this richiesta badge
	*/
	@Override
	public java.lang.String getScreename_richiedente() {
		return _richiestaBadge.getScreename_richiedente();
	}

	/**
	* Returns the societa of this richiesta badge.
	*
	* @return the societa of this richiesta badge
	*/
	@Override
	public java.lang.String getSocieta() {
		return _richiestaBadge.getSocieta();
	}

	/**
	* Returns the utente_cambio_stato of this richiesta badge.
	*
	* @return the utente_cambio_stato of this richiesta badge
	*/
	@Override
	public java.lang.String getUtente_cambio_stato() {
		return _richiestaBadge.getUtente_cambio_stato();
	}

	/**
	* Returns the uuid_foto of this richiesta badge.
	*
	* @return the uuid_foto of this richiesta badge
	*/
	@Override
	public java.lang.String getUuid_foto() {
		return _richiestaBadge.getUuid_foto();
	}

	/**
	* Returns the uuid_modulopdf of this richiesta badge.
	*
	* @return the uuid_modulopdf of this richiesta badge
	*/
	@Override
	public java.lang.String getUuid_modulopdf() {
		return _richiestaBadge.getUuid_modulopdf();
	}

	/**
	* Returns the uuid_modulosostituzione of this richiesta badge.
	*
	* @return the uuid_modulosostituzione of this richiesta badge
	*/
	@Override
	public java.lang.String getUuid_modulosostituzione() {
		return _richiestaBadge.getUuid_modulosostituzione();
	}

	@Override
	public java.lang.String toString() {
		return _richiestaBadge.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _richiestaBadge.toXmlString();
	}

	/**
	* Returns the data_modifica of this richiesta badge.
	*
	* @return the data_modifica of this richiesta badge
	*/
	@Override
	public Date getData_modifica() {
		return _richiestaBadge.getData_modifica();
	}

	/**
	* Returns the data_richiesta of this richiesta badge.
	*
	* @return the data_richiesta of this richiesta badge
	*/
	@Override
	public Date getData_richiesta() {
		return _richiestaBadge.getData_richiesta();
	}

	/**
	* Returns the data_scadenza of this richiesta badge.
	*
	* @return the data_scadenza of this richiesta badge
	*/
	@Override
	public Date getData_scadenza() {
		return _richiestaBadge.getData_scadenza();
	}

	/**
	* Returns the datanascita_intestatario of this richiesta badge.
	*
	* @return the datanascita_intestatario of this richiesta badge
	*/
	@Override
	public Date getDatanascita_intestatario() {
		return _richiestaBadge.getDatanascita_intestatario();
	}

	/**
	* Returns the id_oggetto of this richiesta badge.
	*
	* @return the id_oggetto of this richiesta badge
	*/
	@Override
	public long getId_oggetto() {
		return _richiestaBadge.getId_oggetto();
	}

	/**
	* Returns the id_pk of this richiesta badge.
	*
	* @return the id_pk of this richiesta badge
	*/
	@Override
	public long getId_pk() {
		return _richiestaBadge.getId_pk();
	}

	/**
	* Returns the id_richiesta of this richiesta badge.
	*
	* @return the id_richiesta of this richiesta badge
	*/
	@Override
	public long getId_richiesta() {
		return _richiestaBadge.getId_richiesta();
	}

	/**
	* Returns the id_sedesiap of this richiesta badge.
	*
	* @return the id_sedesiap of this richiesta badge
	*/
	@Override
	public long getId_sedesiap() {
		return _richiestaBadge.getId_sedesiap();
	}

	/**
	* Returns the id_stato of this richiesta badge.
	*
	* @return the id_stato of this richiesta badge
	*/
	@Override
	public long getId_stato() {
		return _richiestaBadge.getId_stato();
	}

	/**
	* Returns the id_ufficio of this richiesta badge.
	*
	* @return the id_ufficio of this richiesta badge
	*/
	@Override
	public long getId_ufficio() {
		return _richiestaBadge.getId_ufficio();
	}

	/**
	* Returns the primary key of this richiesta badge.
	*
	* @return the primary key of this richiesta badge
	*/
	@Override
	public long getPrimaryKey() {
		return _richiestaBadge.getPrimaryKey();
	}

	@Override
	public servizio.richieste.badge.mef.model.RichiestaBadge toEscapedModel() {
		return new RichiestaBadgeWrapper(_richiestaBadge.toEscapedModel());
	}

	@Override
	public servizio.richieste.badge.mef.model.RichiestaBadge toUnescapedModel() {
		return new RichiestaBadgeWrapper(_richiestaBadge.toUnescapedModel());
	}

	@Override
	public void persist() {
		_richiestaBadge.persist();
	}

	/**
	* Sets the array_sedi_abilitate of this richiesta badge.
	*
	* @param array_sedi_abilitate the array_sedi_abilitate of this richiesta badge
	*/
	@Override
	public void setArray_sedi_abilitate(java.lang.String array_sedi_abilitate) {
		_richiestaBadge.setArray_sedi_abilitate(array_sedi_abilitate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_richiestaBadge.setCachedModel(cachedModel);
	}

	/**
	* Sets the cf_intestatario of this richiesta badge.
	*
	* @param cf_intestatario the cf_intestatario of this richiesta badge
	*/
	@Override
	public void setCf_intestatario(java.lang.String cf_intestatario) {
		_richiestaBadge.setCf_intestatario(cf_intestatario);
	}

	/**
	* Sets the cognome_intestatario of this richiesta badge.
	*
	* @param cognome_intestatario the cognome_intestatario of this richiesta badge
	*/
	@Override
	public void setCognome_intestatario(java.lang.String cognome_intestatario) {
		_richiestaBadge.setCognome_intestatario(cognome_intestatario);
	}

	/**
	* Sets the data_modifica of this richiesta badge.
	*
	* @param data_modifica the data_modifica of this richiesta badge
	*/
	@Override
	public void setData_modifica(Date data_modifica) {
		_richiestaBadge.setData_modifica(data_modifica);
	}

	/**
	* Sets the data_richiesta of this richiesta badge.
	*
	* @param data_richiesta the data_richiesta of this richiesta badge
	*/
	@Override
	public void setData_richiesta(Date data_richiesta) {
		_richiestaBadge.setData_richiesta(data_richiesta);
	}

	/**
	* Sets the data_scadenza of this richiesta badge.
	*
	* @param data_scadenza the data_scadenza of this richiesta badge
	*/
	@Override
	public void setData_scadenza(Date data_scadenza) {
		_richiestaBadge.setData_scadenza(data_scadenza);
	}

	/**
	* Sets the datanascita_intestatario of this richiesta badge.
	*
	* @param datanascita_intestatario the datanascita_intestatario of this richiesta badge
	*/
	@Override
	public void setDatanascita_intestatario(Date datanascita_intestatario) {
		_richiestaBadge.setDatanascita_intestatario(datanascita_intestatario);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_richiestaBadge.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_richiestaBadge.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_richiestaBadge.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the id_oggetto of this richiesta badge.
	*
	* @param id_oggetto the id_oggetto of this richiesta badge
	*/
	@Override
	public void setId_oggetto(long id_oggetto) {
		_richiestaBadge.setId_oggetto(id_oggetto);
	}

	/**
	* Sets the id_pk of this richiesta badge.
	*
	* @param id_pk the id_pk of this richiesta badge
	*/
	@Override
	public void setId_pk(long id_pk) {
		_richiestaBadge.setId_pk(id_pk);
	}

	/**
	* Sets the id_richiesta of this richiesta badge.
	*
	* @param id_richiesta the id_richiesta of this richiesta badge
	*/
	@Override
	public void setId_richiesta(long id_richiesta) {
		_richiestaBadge.setId_richiesta(id_richiesta);
	}

	/**
	* Sets the id_sedesiap of this richiesta badge.
	*
	* @param id_sedesiap the id_sedesiap of this richiesta badge
	*/
	@Override
	public void setId_sedesiap(long id_sedesiap) {
		_richiestaBadge.setId_sedesiap(id_sedesiap);
	}

	/**
	* Sets the id_stato of this richiesta badge.
	*
	* @param id_stato the id_stato of this richiesta badge
	*/
	@Override
	public void setId_stato(long id_stato) {
		_richiestaBadge.setId_stato(id_stato);
	}

	/**
	* Sets the id_ufficio of this richiesta badge.
	*
	* @param id_ufficio the id_ufficio of this richiesta badge
	*/
	@Override
	public void setId_ufficio(long id_ufficio) {
		_richiestaBadge.setId_ufficio(id_ufficio);
	}

	/**
	* Sets whether this richiesta badge is is_internal.
	*
	* @param is_internal the is_internal of this richiesta badge
	*/
	@Override
	public void setIs_internal(boolean is_internal) {
		_richiestaBadge.setIs_internal(is_internal);
	}

	/**
	* Sets whether this richiesta badge is is_last.
	*
	* @param is_last the is_last of this richiesta badge
	*/
	@Override
	public void setIs_last(boolean is_last) {
		_richiestaBadge.setIs_last(is_last);
	}

	/**
	* Sets the json_richiedente of this richiesta badge.
	*
	* @param json_richiedente the json_richiedente of this richiesta badge
	*/
	@Override
	public void setJson_richiedente(java.lang.String json_richiedente) {
		_richiestaBadge.setJson_richiedente(json_richiedente);
	}

	/**
	* Sets the json_richiesta_external of this richiesta badge.
	*
	* @param json_richiesta_external the json_richiesta_external of this richiesta badge
	*/
	@Override
	public void setJson_richiesta_external(
		java.lang.String json_richiesta_external) {
		_richiestaBadge.setJson_richiesta_external(json_richiesta_external);
	}

	/**
	* Sets the luogonascita_intestatario of this richiesta badge.
	*
	* @param luogonascita_intestatario the luogonascita_intestatario of this richiesta badge
	*/
	@Override
	public void setLuogonascita_intestatario(
		java.lang.String luogonascita_intestatario) {
		_richiestaBadge.setLuogonascita_intestatario(luogonascita_intestatario);
	}

	/**
	* Sets the motivazione of this richiesta badge.
	*
	* @param motivazione the motivazione of this richiesta badge
	*/
	@Override
	public void setMotivazione(java.lang.String motivazione) {
		_richiestaBadge.setMotivazione(motivazione);
	}

	@Override
	public void setNew(boolean n) {
		_richiestaBadge.setNew(n);
	}

	/**
	* Sets the nome_intestatario of this richiesta badge.
	*
	* @param nome_intestatario the nome_intestatario of this richiesta badge
	*/
	@Override
	public void setNome_intestatario(java.lang.String nome_intestatario) {
		_richiestaBadge.setNome_intestatario(nome_intestatario);
	}

	/**
	* Sets the note of this richiesta badge.
	*
	* @param note the note of this richiesta badge
	*/
	@Override
	public void setNote(java.lang.String note) {
		_richiestaBadge.setNote(note);
	}

	/**
	* Sets the numero_badge of this richiesta badge.
	*
	* @param numero_badge the numero_badge of this richiesta badge
	*/
	@Override
	public void setNumero_badge(java.lang.String numero_badge) {
		_richiestaBadge.setNumero_badge(numero_badge);
	}

	/**
	* Sets the primary key of this richiesta badge.
	*
	* @param primaryKey the primary key of this richiesta badge
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_richiestaBadge.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_richiestaBadge.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the progetto of this richiesta badge.
	*
	* @param progetto the progetto of this richiesta badge
	*/
	@Override
	public void setProgetto(java.lang.String progetto) {
		_richiestaBadge.setProgetto(progetto);
	}

	/**
	* Sets the referente_societa of this richiesta badge.
	*
	* @param referente_societa the referente_societa of this richiesta badge
	*/
	@Override
	public void setReferente_societa(java.lang.String referente_societa) {
		_richiestaBadge.setReferente_societa(referente_societa);
	}

	/**
	* Sets the screename_richiedente of this richiesta badge.
	*
	* @param screename_richiedente the screename_richiedente of this richiesta badge
	*/
	@Override
	public void setScreename_richiedente(java.lang.String screename_richiedente) {
		_richiestaBadge.setScreename_richiedente(screename_richiedente);
	}

	/**
	* Sets the societa of this richiesta badge.
	*
	* @param societa the societa of this richiesta badge
	*/
	@Override
	public void setSocieta(java.lang.String societa) {
		_richiestaBadge.setSocieta(societa);
	}

	/**
	* Sets the utente_cambio_stato of this richiesta badge.
	*
	* @param utente_cambio_stato the utente_cambio_stato of this richiesta badge
	*/
	@Override
	public void setUtente_cambio_stato(java.lang.String utente_cambio_stato) {
		_richiestaBadge.setUtente_cambio_stato(utente_cambio_stato);
	}

	/**
	* Sets the uuid_foto of this richiesta badge.
	*
	* @param uuid_foto the uuid_foto of this richiesta badge
	*/
	@Override
	public void setUuid_foto(java.lang.String uuid_foto) {
		_richiestaBadge.setUuid_foto(uuid_foto);
	}

	/**
	* Sets the uuid_modulopdf of this richiesta badge.
	*
	* @param uuid_modulopdf the uuid_modulopdf of this richiesta badge
	*/
	@Override
	public void setUuid_modulopdf(java.lang.String uuid_modulopdf) {
		_richiestaBadge.setUuid_modulopdf(uuid_modulopdf);
	}

	/**
	* Sets the uuid_modulosostituzione of this richiesta badge.
	*
	* @param uuid_modulosostituzione the uuid_modulosostituzione of this richiesta badge
	*/
	@Override
	public void setUuid_modulosostituzione(
		java.lang.String uuid_modulosostituzione) {
		_richiestaBadge.setUuid_modulosostituzione(uuid_modulosostituzione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaBadgeWrapper)) {
			return false;
		}

		RichiestaBadgeWrapper richiestaBadgeWrapper = (RichiestaBadgeWrapper)obj;

		if (Objects.equals(_richiestaBadge,
					richiestaBadgeWrapper._richiestaBadge)) {
			return true;
		}

		return false;
	}

	@Override
	public RichiestaBadge getWrappedModel() {
		return _richiestaBadge;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _richiestaBadge.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _richiestaBadge.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_richiestaBadge.resetOriginalValues();
	}

	private final RichiestaBadge _richiestaBadge;
}