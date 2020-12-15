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

package servizio.beni.facile.consumo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.beni.facile.consumo.service.http.ServizioMaterialeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.http.ServizioMaterialeServiceSoap
 * @generated
 */
@ProviderType
public class ServizioMaterialeSoap implements Serializable {
	public static ServizioMaterialeSoap toSoapModel(ServizioMateriale model) {
		ServizioMaterialeSoap soapModel = new ServizioMaterialeSoap();

		soapModel.setGruppo(model.getGruppo());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setCategoria(model.getCategoria());

		return soapModel;
	}

	public static ServizioMaterialeSoap[] toSoapModels(
		ServizioMateriale[] models) {
		ServizioMaterialeSoap[] soapModels = new ServizioMaterialeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServizioMaterialeSoap[][] toSoapModels(
		ServizioMateriale[][] models) {
		ServizioMaterialeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServizioMaterialeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServizioMaterialeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServizioMaterialeSoap[] toSoapModels(
		List<ServizioMateriale> models) {
		List<ServizioMaterialeSoap> soapModels = new ArrayList<ServizioMaterialeSoap>(models.size());

		for (ServizioMateriale model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServizioMaterialeSoap[soapModels.size()]);
	}

	public ServizioMaterialeSoap() {
	}

	public String getPrimaryKey() {
		return _gruppo;
	}

	public void setPrimaryKey(String pk) {
		setGruppo(pk);
	}

	public String getGruppo() {
		return _gruppo;
	}

	public void setGruppo(String gruppo) {
		_gruppo = gruppo;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getCategoria() {
		return _categoria;
	}

	public void setCategoria(String categoria) {
		_categoria = categoria;
	}

	private String _gruppo;
	private String _descrizione;
	private String _categoria;
}