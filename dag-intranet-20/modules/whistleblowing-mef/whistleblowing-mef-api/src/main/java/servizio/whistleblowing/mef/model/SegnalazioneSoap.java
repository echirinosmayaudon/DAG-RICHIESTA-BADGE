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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.whistleblowing.mef.service.http.SegnalazioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.whistleblowing.mef.service.http.SegnalazioneServiceSoap
 * @generated
 */
@ProviderType
public class SegnalazioneSoap implements Serializable {
	public static SegnalazioneSoap toSoapModel(Segnalazione model) {
		SegnalazioneSoap soapModel = new SegnalazioneSoap();

		soapModel.setId_segnalazione(model.getId_segnalazione());
		soapModel.setJson_dati_personali(model.getJson_dati_personali());
		soapModel.setLuogo(model.getLuogo());
		soapModel.setAzioni_omissioni(model.getAzioni_omissioni());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setAutore(model.getAutore());
		soapModel.setAltri_testimoni(model.getAltri_testimoni());

		return soapModel;
	}

	public static SegnalazioneSoap[] toSoapModels(Segnalazione[] models) {
		SegnalazioneSoap[] soapModels = new SegnalazioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SegnalazioneSoap[][] toSoapModels(Segnalazione[][] models) {
		SegnalazioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SegnalazioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SegnalazioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SegnalazioneSoap[] toSoapModels(List<Segnalazione> models) {
		List<SegnalazioneSoap> soapModels = new ArrayList<SegnalazioneSoap>(models.size());

		for (Segnalazione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SegnalazioneSoap[soapModels.size()]);
	}

	public SegnalazioneSoap() {
	}

	public long getPrimaryKey() {
		return _id_segnalazione;
	}

	public void setPrimaryKey(long pk) {
		setId_segnalazione(pk);
	}

	public long getId_segnalazione() {
		return _id_segnalazione;
	}

	public void setId_segnalazione(long id_segnalazione) {
		_id_segnalazione = id_segnalazione;
	}

	public String getJson_dati_personali() {
		return _json_dati_personali;
	}

	public void setJson_dati_personali(String json_dati_personali) {
		_json_dati_personali = json_dati_personali;
	}

	public String getLuogo() {
		return _luogo;
	}

	public void setLuogo(String luogo) {
		_luogo = luogo;
	}

	public String getAzioni_omissioni() {
		return _azioni_omissioni;
	}

	public void setAzioni_omissioni(String azioni_omissioni) {
		_azioni_omissioni = azioni_omissioni;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getAutore() {
		return _autore;
	}

	public void setAutore(String autore) {
		_autore = autore;
	}

	public String getAltri_testimoni() {
		return _altri_testimoni;
	}

	public void setAltri_testimoni(String altri_testimoni) {
		_altri_testimoni = altri_testimoni;
	}

	private long _id_segnalazione;
	private String _json_dati_personali;
	private String _luogo;
	private String _azioni_omissioni;
	private String _descrizione;
	private String _autore;
	private String _altri_testimoni;
}