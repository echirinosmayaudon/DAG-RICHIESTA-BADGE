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
 * This class is used by SOAP remote services, specifically {@link servizio.beni.facile.consumo.service.http.RigheRichiestaBFCServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.http.RigheRichiestaBFCServiceSoap
 * @generated
 */
@ProviderType
public class RigheRichiestaBFCSoap implements Serializable {
	public static RigheRichiestaBFCSoap toSoapModel(RigheRichiestaBFC model) {
		RigheRichiestaBFCSoap soapModel = new RigheRichiestaBFCSoap();

		soapModel.setId(model.getId());
		soapModel.setId_richiesta(model.getId_richiesta());
		soapModel.setDipartimento(model.getDipartimento());
		soapModel.setDati(model.getDati());

		return soapModel;
	}

	public static RigheRichiestaBFCSoap[] toSoapModels(
		RigheRichiestaBFC[] models) {
		RigheRichiestaBFCSoap[] soapModels = new RigheRichiestaBFCSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RigheRichiestaBFCSoap[][] toSoapModels(
		RigheRichiestaBFC[][] models) {
		RigheRichiestaBFCSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RigheRichiestaBFCSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RigheRichiestaBFCSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RigheRichiestaBFCSoap[] toSoapModels(
		List<RigheRichiestaBFC> models) {
		List<RigheRichiestaBFCSoap> soapModels = new ArrayList<RigheRichiestaBFCSoap>(models.size());

		for (RigheRichiestaBFC model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RigheRichiestaBFCSoap[soapModels.size()]);
	}

	public RigheRichiestaBFCSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getId_richiesta() {
		return _id_richiesta;
	}

	public void setId_richiesta(long id_richiesta) {
		_id_richiesta = id_richiesta;
	}

	public String getDipartimento() {
		return _dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		_dipartimento = dipartimento;
	}

	public String getDati() {
		return _dati;
	}

	public void setDati(String dati) {
		_dati = dati;
	}

	private long _id;
	private long _id_richiesta;
	private String _dipartimento;
	private String _dati;
}