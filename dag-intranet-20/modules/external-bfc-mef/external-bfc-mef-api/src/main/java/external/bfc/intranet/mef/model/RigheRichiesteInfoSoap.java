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

import external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link external.bfc.intranet.mef.service.http.RigheRichiesteInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.http.RigheRichiesteInfoServiceSoap
 * @generated
 */
@ProviderType
public class RigheRichiesteInfoSoap implements Serializable {
	public static RigheRichiesteInfoSoap toSoapModel(RigheRichiesteInfo model) {
		RigheRichiesteInfoSoap soapModel = new RigheRichiesteInfoSoap();

		soapModel.setId(model.getId());
		soapModel.setIdMateriale(model.getIdMateriale());
		soapModel.setNumeroRiga(model.getNumeroRiga());
		soapModel.setQuantitaRichiesta(model.getQuantitaRichiesta());
		soapModel.setQuantitaDisponibile(model.getQuantitaDisponibile());
		soapModel.setUidIns(model.getUidIns());
		soapModel.setDataIns(model.getDataIns());
		soapModel.setUidUpd(model.getUidUpd());
		soapModel.setDataUpd(model.getDataUpd());
		soapModel.setImporto(model.getImporto());
		soapModel.setSottogruppo(model.getSottogruppo());
		soapModel.setGruppo(model.getGruppo());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static RigheRichiesteInfoSoap[] toSoapModels(
		RigheRichiesteInfo[] models) {
		RigheRichiesteInfoSoap[] soapModels = new RigheRichiesteInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RigheRichiesteInfoSoap[][] toSoapModels(
		RigheRichiesteInfo[][] models) {
		RigheRichiesteInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RigheRichiesteInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RigheRichiesteInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RigheRichiesteInfoSoap[] toSoapModels(
		List<RigheRichiesteInfo> models) {
		List<RigheRichiesteInfoSoap> soapModels = new ArrayList<RigheRichiesteInfoSoap>(models.size());

		for (RigheRichiesteInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RigheRichiesteInfoSoap[soapModels.size()]);
	}

	public RigheRichiesteInfoSoap() {
	}

	public RigheRichiesteInfoPK getPrimaryKey() {
		return new RigheRichiesteInfoPK(_id, _idMateriale, _sottogruppo, _gruppo);
	}

	public void setPrimaryKey(RigheRichiesteInfoPK pk) {
		setId(pk.id);
		setIdMateriale(pk.idMateriale);
		setSottogruppo(pk.sottogruppo);
		setGruppo(pk.gruppo);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getIdMateriale() {
		return _idMateriale;
	}

	public void setIdMateriale(long idMateriale) {
		_idMateriale = idMateriale;
	}

	public long getNumeroRiga() {
		return _numeroRiga;
	}

	public void setNumeroRiga(long numeroRiga) {
		_numeroRiga = numeroRiga;
	}

	public long getQuantitaRichiesta() {
		return _quantitaRichiesta;
	}

	public void setQuantitaRichiesta(long quantitaRichiesta) {
		_quantitaRichiesta = quantitaRichiesta;
	}

	public long getQuantitaDisponibile() {
		return _quantitaDisponibile;
	}

	public void setQuantitaDisponibile(long quantitaDisponibile) {
		_quantitaDisponibile = quantitaDisponibile;
	}

	public long getUidIns() {
		return _uidIns;
	}

	public void setUidIns(long uidIns) {
		_uidIns = uidIns;
	}

	public Date getDataIns() {
		return _dataIns;
	}

	public void setDataIns(Date dataIns) {
		_dataIns = dataIns;
	}

	public long getUidUpd() {
		return _uidUpd;
	}

	public void setUidUpd(long uidUpd) {
		_uidUpd = uidUpd;
	}

	public Date getDataUpd() {
		return _dataUpd;
	}

	public void setDataUpd(Date dataUpd) {
		_dataUpd = dataUpd;
	}

	public float getImporto() {
		return _importo;
	}

	public void setImporto(float importo) {
		_importo = importo;
	}

	public String getSottogruppo() {
		return _sottogruppo;
	}

	public void setSottogruppo(String sottogruppo) {
		_sottogruppo = sottogruppo;
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

	private long _id;
	private long _idMateriale;
	private long _numeroRiga;
	private long _quantitaRichiesta;
	private long _quantitaDisponibile;
	private long _uidIns;
	private Date _dataIns;
	private long _uidUpd;
	private Date _dataUpd;
	private float _importo;
	private String _sottogruppo;
	private String _gruppo;
	private String _descrizione;
}