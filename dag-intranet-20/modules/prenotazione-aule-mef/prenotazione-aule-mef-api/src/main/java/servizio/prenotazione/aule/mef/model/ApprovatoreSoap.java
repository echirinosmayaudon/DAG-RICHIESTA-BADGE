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

package servizio.prenotazione.aule.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link servizio.prenotazione.aule.mef.service.http.ApprovatoreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.http.ApprovatoreServiceSoap
 * @generated
 */
@ProviderType
public class ApprovatoreSoap implements Serializable {
	public static ApprovatoreSoap toSoapModel(Approvatore model) {
		ApprovatoreSoap soapModel = new ApprovatoreSoap();

		soapModel.setId_approvatore(model.getId_approvatore());
		soapModel.setId_sala(model.getId_sala());
		soapModel.setEmail_approvatore(model.getEmail_approvatore());

		return soapModel;
	}

	public static ApprovatoreSoap[] toSoapModels(Approvatore[] models) {
		ApprovatoreSoap[] soapModels = new ApprovatoreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApprovatoreSoap[][] toSoapModels(Approvatore[][] models) {
		ApprovatoreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApprovatoreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApprovatoreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApprovatoreSoap[] toSoapModels(List<Approvatore> models) {
		List<ApprovatoreSoap> soapModels = new ArrayList<ApprovatoreSoap>(models.size());

		for (Approvatore model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApprovatoreSoap[soapModels.size()]);
	}

	public ApprovatoreSoap() {
	}

	public long getPrimaryKey() {
		return _id_approvatore;
	}

	public void setPrimaryKey(long pk) {
		setId_approvatore(pk);
	}

	public long getId_approvatore() {
		return _id_approvatore;
	}

	public void setId_approvatore(long id_approvatore) {
		_id_approvatore = id_approvatore;
	}

	public long getId_sala() {
		return _id_sala;
	}

	public void setId_sala(long id_sala) {
		_id_sala = id_sala;
	}

	public String getEmail_approvatore() {
		return _email_approvatore;
	}

	public void setEmail_approvatore(String email_approvatore) {
		_email_approvatore = email_approvatore;
	}

	private long _id_approvatore;
	private long _id_sala;
	private String _email_approvatore;
}