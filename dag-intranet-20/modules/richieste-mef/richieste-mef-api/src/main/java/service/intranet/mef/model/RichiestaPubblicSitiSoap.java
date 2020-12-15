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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link service.intranet.mef.service.http.RichiestaPubblicSitiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.http.RichiestaPubblicSitiServiceSoap
 * @generated
 */
@ProviderType
public class RichiestaPubblicSitiSoap implements Serializable {
	public static RichiestaPubblicSitiSoap toSoapModel(
		RichiestaPubblicSiti model) {
		RichiestaPubblicSitiSoap soapModel = new RichiestaPubblicSitiSoap();

		soapModel.setId_rich_pubblic(model.getId_rich_pubblic());
		soapModel.setDati_richiedente(model.getDati_richiedente());
		soapModel.setDati_docum(model.getDati_docum());
		soapModel.setTitolo(model.getTitolo());
		soapModel.setSottotitolo(model.getSottotitolo());
		soapModel.setNovita_abstract(model.getNovita_abstract());
		soapModel.setNote_riferim(model.getNote_riferim());
		soapModel.setDati_stampa_carta(model.getDati_stampa_carta());
		soapModel.setDati_altro(model.getDati_altro());
		soapModel.setDati_autorizzaz(model.getDati_autorizzaz());
		soapModel.setNote_autorizzaz(model.getNote_autorizzaz());
		soapModel.setLista_allegati(model.getLista_allegati());

		return soapModel;
	}

	public static RichiestaPubblicSitiSoap[] toSoapModels(
		RichiestaPubblicSiti[] models) {
		RichiestaPubblicSitiSoap[] soapModels = new RichiestaPubblicSitiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RichiestaPubblicSitiSoap[][] toSoapModels(
		RichiestaPubblicSiti[][] models) {
		RichiestaPubblicSitiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RichiestaPubblicSitiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RichiestaPubblicSitiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RichiestaPubblicSitiSoap[] toSoapModels(
		List<RichiestaPubblicSiti> models) {
		List<RichiestaPubblicSitiSoap> soapModels = new ArrayList<RichiestaPubblicSitiSoap>(models.size());

		for (RichiestaPubblicSiti model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RichiestaPubblicSitiSoap[soapModels.size()]);
	}

	public RichiestaPubblicSitiSoap() {
	}

	public long getPrimaryKey() {
		return _id_rich_pubblic;
	}

	public void setPrimaryKey(long pk) {
		setId_rich_pubblic(pk);
	}

	public long getId_rich_pubblic() {
		return _id_rich_pubblic;
	}

	public void setId_rich_pubblic(long id_rich_pubblic) {
		_id_rich_pubblic = id_rich_pubblic;
	}

	public String getDati_richiedente() {
		return _dati_richiedente;
	}

	public void setDati_richiedente(String dati_richiedente) {
		_dati_richiedente = dati_richiedente;
	}

	public String getDati_docum() {
		return _dati_docum;
	}

	public void setDati_docum(String dati_docum) {
		_dati_docum = dati_docum;
	}

	public String getTitolo() {
		return _titolo;
	}

	public void setTitolo(String titolo) {
		_titolo = titolo;
	}

	public String getSottotitolo() {
		return _sottotitolo;
	}

	public void setSottotitolo(String sottotitolo) {
		_sottotitolo = sottotitolo;
	}

	public String getNovita_abstract() {
		return _novita_abstract;
	}

	public void setNovita_abstract(String novita_abstract) {
		_novita_abstract = novita_abstract;
	}

	public String getNote_riferim() {
		return _note_riferim;
	}

	public void setNote_riferim(String note_riferim) {
		_note_riferim = note_riferim;
	}

	public String getDati_stampa_carta() {
		return _dati_stampa_carta;
	}

	public void setDati_stampa_carta(String dati_stampa_carta) {
		_dati_stampa_carta = dati_stampa_carta;
	}

	public String getDati_altro() {
		return _dati_altro;
	}

	public void setDati_altro(String dati_altro) {
		_dati_altro = dati_altro;
	}

	public String getDati_autorizzaz() {
		return _dati_autorizzaz;
	}

	public void setDati_autorizzaz(String dati_autorizzaz) {
		_dati_autorizzaz = dati_autorizzaz;
	}

	public String getNote_autorizzaz() {
		return _note_autorizzaz;
	}

	public void setNote_autorizzaz(String note_autorizzaz) {
		_note_autorizzaz = note_autorizzaz;
	}

	public String getLista_allegati() {
		return _lista_allegati;
	}

	public void setLista_allegati(String lista_allegati) {
		_lista_allegati = lista_allegati;
	}

	private long _id_rich_pubblic;
	private String _dati_richiedente;
	private String _dati_docum;
	private String _titolo;
	private String _sottotitolo;
	private String _novita_abstract;
	private String _note_riferim;
	private String _dati_stampa_carta;
	private String _dati_altro;
	private String _dati_autorizzaz;
	private String _note_autorizzaz;
	private String _lista_allegati;
}