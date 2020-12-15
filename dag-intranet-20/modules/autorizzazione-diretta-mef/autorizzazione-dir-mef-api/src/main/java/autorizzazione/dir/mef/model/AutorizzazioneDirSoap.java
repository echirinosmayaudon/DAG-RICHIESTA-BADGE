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

package autorizzazione.dir.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link autorizzazione.dir.mef.service.http.AutorizzazioneDirServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see autorizzazione.dir.mef.service.http.AutorizzazioneDirServiceSoap
 * @generated
 */
@ProviderType
public class AutorizzazioneDirSoap implements Serializable {
	public static AutorizzazioneDirSoap toSoapModel(AutorizzazioneDir model) {
		AutorizzazioneDirSoap soapModel = new AutorizzazioneDirSoap();

		soapModel.setId_autorizzazione(model.getId_autorizzazione());
		soapModel.setId_applicazione(model.getId_applicazione());
		soapModel.setMef(model.getMef());
		soapModel.setDipartimento(model.getDipartimento());
		soapModel.setDirezione(model.getDirezione());
		soapModel.setUfficio(model.getUfficio());
		soapModel.setCodice_fiscale(model.getCodice_fiscale());
		soapModel.setNega(model.getNega());
		soapModel.setTag(model.getTag());

		return soapModel;
	}

	public static AutorizzazioneDirSoap[] toSoapModels(
		AutorizzazioneDir[] models) {
		AutorizzazioneDirSoap[] soapModels = new AutorizzazioneDirSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AutorizzazioneDirSoap[][] toSoapModels(
		AutorizzazioneDir[][] models) {
		AutorizzazioneDirSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AutorizzazioneDirSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AutorizzazioneDirSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AutorizzazioneDirSoap[] toSoapModels(
		List<AutorizzazioneDir> models) {
		List<AutorizzazioneDirSoap> soapModels = new ArrayList<AutorizzazioneDirSoap>(models.size());

		for (AutorizzazioneDir model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AutorizzazioneDirSoap[soapModels.size()]);
	}

	public AutorizzazioneDirSoap() {
	}

	public long getPrimaryKey() {
		return _id_autorizzazione;
	}

	public void setPrimaryKey(long pk) {
		setId_autorizzazione(pk);
	}

	public long getId_autorizzazione() {
		return _id_autorizzazione;
	}

	public void setId_autorizzazione(long id_autorizzazione) {
		_id_autorizzazione = id_autorizzazione;
	}

	public long getId_applicazione() {
		return _id_applicazione;
	}

	public void setId_applicazione(long id_applicazione) {
		_id_applicazione = id_applicazione;
	}

	public long getMef() {
		return _mef;
	}

	public void setMef(long mef) {
		_mef = mef;
	}

	public long getDipartimento() {
		return _dipartimento;
	}

	public void setDipartimento(long dipartimento) {
		_dipartimento = dipartimento;
	}

	public long getDirezione() {
		return _direzione;
	}

	public void setDirezione(long direzione) {
		_direzione = direzione;
	}

	public long getUfficio() {
		return _ufficio;
	}

	public void setUfficio(long ufficio) {
		_ufficio = ufficio;
	}

	public String getCodice_fiscale() {
		return _codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		_codice_fiscale = codice_fiscale;
	}

	public boolean getNega() {
		return _nega;
	}

	public boolean isNega() {
		return _nega;
	}

	public void setNega(boolean nega) {
		_nega = nega;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	private long _id_autorizzazione;
	private long _id_applicazione;
	private long _mef;
	private long _dipartimento;
	private long _direzione;
	private long _ufficio;
	private String _codice_fiscale;
	private boolean _nega;
	private String _tag;
}