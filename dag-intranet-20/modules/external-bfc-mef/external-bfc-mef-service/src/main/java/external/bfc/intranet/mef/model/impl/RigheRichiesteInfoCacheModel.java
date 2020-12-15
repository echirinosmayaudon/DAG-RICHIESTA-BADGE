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

package external.bfc.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import external.bfc.intranet.mef.model.RigheRichiesteInfo;
import external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RigheRichiesteInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiesteInfo
 * @generated
 */
@ProviderType
public class RigheRichiesteInfoCacheModel implements CacheModel<RigheRichiesteInfo>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichiesteInfoCacheModel)) {
			return false;
		}

		RigheRichiesteInfoCacheModel righeRichiesteInfoCacheModel = (RigheRichiesteInfoCacheModel)obj;

		if (righeRichiesteInfoPK.equals(
					righeRichiesteInfoCacheModel.righeRichiesteInfoPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, righeRichiesteInfoPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idMateriale=");
		sb.append(idMateriale);
		sb.append(", numeroRiga=");
		sb.append(numeroRiga);
		sb.append(", quantitaRichiesta=");
		sb.append(quantitaRichiesta);
		sb.append(", quantitaDisponibile=");
		sb.append(quantitaDisponibile);
		sb.append(", uidIns=");
		sb.append(uidIns);
		sb.append(", dataIns=");
		sb.append(dataIns);
		sb.append(", uidUpd=");
		sb.append(uidUpd);
		sb.append(", dataUpd=");
		sb.append(dataUpd);
		sb.append(", importo=");
		sb.append(importo);
		sb.append(", sottogruppo=");
		sb.append(sottogruppo);
		sb.append(", gruppo=");
		sb.append(gruppo);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RigheRichiesteInfo toEntityModel() {
		RigheRichiesteInfoImpl righeRichiesteInfoImpl = new RigheRichiesteInfoImpl();

		righeRichiesteInfoImpl.setId(id);
		righeRichiesteInfoImpl.setIdMateriale(idMateriale);
		righeRichiesteInfoImpl.setNumeroRiga(numeroRiga);
		righeRichiesteInfoImpl.setQuantitaRichiesta(quantitaRichiesta);
		righeRichiesteInfoImpl.setQuantitaDisponibile(quantitaDisponibile);
		righeRichiesteInfoImpl.setUidIns(uidIns);

		if (dataIns == Long.MIN_VALUE) {
			righeRichiesteInfoImpl.setDataIns(null);
		}
		else {
			righeRichiesteInfoImpl.setDataIns(new Date(dataIns));
		}

		righeRichiesteInfoImpl.setUidUpd(uidUpd);

		if (dataUpd == Long.MIN_VALUE) {
			righeRichiesteInfoImpl.setDataUpd(null);
		}
		else {
			righeRichiesteInfoImpl.setDataUpd(new Date(dataUpd));
		}

		righeRichiesteInfoImpl.setImporto(importo);

		if (sottogruppo == null) {
			righeRichiesteInfoImpl.setSottogruppo(StringPool.BLANK);
		}
		else {
			righeRichiesteInfoImpl.setSottogruppo(sottogruppo);
		}

		if (gruppo == null) {
			righeRichiesteInfoImpl.setGruppo(StringPool.BLANK);
		}
		else {
			righeRichiesteInfoImpl.setGruppo(gruppo);
		}

		if (descrizione == null) {
			righeRichiesteInfoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			righeRichiesteInfoImpl.setDescrizione(descrizione);
		}

		righeRichiesteInfoImpl.resetOriginalValues();

		return righeRichiesteInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		idMateriale = objectInput.readLong();

		numeroRiga = objectInput.readLong();

		quantitaRichiesta = objectInput.readLong();

		quantitaDisponibile = objectInput.readLong();

		uidIns = objectInput.readLong();
		dataIns = objectInput.readLong();

		uidUpd = objectInput.readLong();
		dataUpd = objectInput.readLong();

		importo = objectInput.readFloat();
		sottogruppo = objectInput.readUTF();
		gruppo = objectInput.readUTF();
		descrizione = objectInput.readUTF();

		righeRichiesteInfoPK = new RigheRichiesteInfoPK(id, idMateriale,
				sottogruppo, gruppo);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(idMateriale);

		objectOutput.writeLong(numeroRiga);

		objectOutput.writeLong(quantitaRichiesta);

		objectOutput.writeLong(quantitaDisponibile);

		objectOutput.writeLong(uidIns);
		objectOutput.writeLong(dataIns);

		objectOutput.writeLong(uidUpd);
		objectOutput.writeLong(dataUpd);

		objectOutput.writeFloat(importo);

		if (sottogruppo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sottogruppo);
		}

		if (gruppo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gruppo);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id;
	public long idMateriale;
	public long numeroRiga;
	public long quantitaRichiesta;
	public long quantitaDisponibile;
	public long uidIns;
	public long dataIns;
	public long uidUpd;
	public long dataUpd;
	public float importo;
	public String sottogruppo;
	public String gruppo;
	public String descrizione;
	public transient RigheRichiesteInfoPK righeRichiesteInfoPK;
}