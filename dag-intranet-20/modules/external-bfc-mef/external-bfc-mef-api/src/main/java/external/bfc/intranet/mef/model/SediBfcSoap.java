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

package external.bfc.intranet.mef.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link external.bfc.intranet.mef.service.http.SediBfcServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.http.SediBfcServiceSoap
 * @generated
 */
@ProviderType
public class SediBfcSoap implements Serializable {
	public static SediBfcSoap toSoapModel(SediBfc model) {
		SediBfcSoap soapModel = new SediBfcSoap();

		soapModel.setId(model.getId());
		soapModel.setCodice_geco(model.getCodice_geco());
		soapModel.setId_sede_geco(model.getId_sede_geco());
		soapModel.setId_sede_siap(model.getId_sede_siap());
		soapModel.setId_org_liv2(model.getId_org_liv2());
		soapModel.setId_org_liv3(model.getId_org_liv3());
		soapModel.setNomeLoc(model.getNomeLoc());
		soapModel.setFlag_app(model.getFlag_app());

		return soapModel;
	}

	public static SediBfcSoap[] toSoapModels(SediBfc[] models) {
		SediBfcSoap[] soapModels = new SediBfcSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SediBfcSoap[][] toSoapModels(SediBfc[][] models) {
		SediBfcSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SediBfcSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SediBfcSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SediBfcSoap[] toSoapModels(List<SediBfc> models) {
		List<SediBfcSoap> soapModels = new ArrayList<SediBfcSoap>(models.size());

		for (SediBfc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SediBfcSoap[soapModels.size()]);
	}

	public SediBfcSoap() {
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

	public String getCodice_geco() {
		return _codice_geco;
	}

	public void setCodice_geco(String codice_geco) {
		_codice_geco = codice_geco;
	}

	public String getId_sede_geco() {
		return _id_sede_geco;
	}

	public void setId_sede_geco(String id_sede_geco) {
		_id_sede_geco = id_sede_geco;
	}

	public long getId_sede_siap() {
		return _id_sede_siap;
	}

	public void setId_sede_siap(long id_sede_siap) {
		_id_sede_siap = id_sede_siap;
	}

	public long getId_org_liv2() {
		return _id_org_liv2;
	}

	public void setId_org_liv2(long id_org_liv2) {
		_id_org_liv2 = id_org_liv2;
	}

	public long getId_org_liv3() {
		return _id_org_liv3;
	}

	public void setId_org_liv3(long id_org_liv3) {
		_id_org_liv3 = id_org_liv3;
	}

	public String getNomeLoc() {
		return _nomeLoc;
	}

	public void setNomeLoc(String nomeLoc) {
		_nomeLoc = nomeLoc;
	}

	public boolean getFlag_app() {
		return _flag_app;
	}

	public boolean isFlag_app() {
		return _flag_app;
	}

	public void setFlag_app(boolean flag_app) {
		_flag_app = flag_app;
	}

	private long _id;
	private String _codice_geco;
	private String _id_sede_geco;
	private long _id_sede_siap;
	private long _id_org_liv2;
	private long _id_org_liv3;
	private String _nomeLoc;
	private boolean _flag_app;
}