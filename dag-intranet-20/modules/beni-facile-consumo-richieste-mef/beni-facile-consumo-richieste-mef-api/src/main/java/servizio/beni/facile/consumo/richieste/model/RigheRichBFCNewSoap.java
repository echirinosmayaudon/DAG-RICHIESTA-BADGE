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

package servizio.beni.facile.consumo.richieste.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.beni.facile.consumo.richieste.service.http.RigheRichBFCNewServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.richieste.service.http.RigheRichBFCNewServiceSoap
 * @generated
 */
@ProviderType
public class RigheRichBFCNewSoap implements Serializable {
	public static RigheRichBFCNewSoap toSoapModel(RigheRichBFCNew model) {
		RigheRichBFCNewSoap soapModel = new RigheRichBFCNewSoap();

		soapModel.setId(model.getId());
		soapModel.setId_rich(model.getId_rich());
		soapModel.setDipartimento(model.getDipartimento());
		soapModel.setDati1(model.getDati1());
		soapModel.setDati2(model.getDati2());
		soapModel.setDati3(model.getDati3());
		soapModel.setDati4(model.getDati4());

		return soapModel;
	}

	public static RigheRichBFCNewSoap[] toSoapModels(RigheRichBFCNew[] models) {
		RigheRichBFCNewSoap[] soapModels = new RigheRichBFCNewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RigheRichBFCNewSoap[][] toSoapModels(
		RigheRichBFCNew[][] models) {
		RigheRichBFCNewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RigheRichBFCNewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RigheRichBFCNewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RigheRichBFCNewSoap[] toSoapModels(
		List<RigheRichBFCNew> models) {
		List<RigheRichBFCNewSoap> soapModels = new ArrayList<RigheRichBFCNewSoap>(models.size());

		for (RigheRichBFCNew model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RigheRichBFCNewSoap[soapModels.size()]);
	}

	public RigheRichBFCNewSoap() {
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

	public long getId_rich() {
		return _id_rich;
	}

	public void setId_rich(long id_rich) {
		_id_rich = id_rich;
	}

	public String getDipartimento() {
		return _dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		_dipartimento = dipartimento;
	}

	public String getDati1() {
		return _dati1;
	}

	public void setDati1(String dati1) {
		_dati1 = dati1;
	}

	public String getDati2() {
		return _dati2;
	}

	public void setDati2(String dati2) {
		_dati2 = dati2;
	}

	public String getDati3() {
		return _dati3;
	}

	public void setDati3(String dati3) {
		_dati3 = dati3;
	}

	public String getDati4() {
		return _dati4;
	}

	public void setDati4(String dati4) {
		_dati4 = dati4;
	}

	private long _id;
	private long _id_rich;
	private String _dipartimento;
	private String _dati1;
	private String _dati2;
	private String _dati3;
	private String _dati4;
}