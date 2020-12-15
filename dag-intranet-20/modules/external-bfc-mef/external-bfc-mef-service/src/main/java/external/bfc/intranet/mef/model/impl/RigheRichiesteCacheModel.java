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

import external.bfc.intranet.mef.model.RigheRichieste;
import external.bfc.intranet.mef.service.persistence.RigheRichiestePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RigheRichieste in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichieste
 * @generated
 */
@ProviderType
public class RigheRichiesteCacheModel implements CacheModel<RigheRichieste>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichiesteCacheModel)) {
			return false;
		}

		RigheRichiesteCacheModel righeRichiesteCacheModel = (RigheRichiesteCacheModel)obj;

		if (righeRichiestePK.equals(righeRichiesteCacheModel.righeRichiestePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, righeRichiestePK);
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
	public RigheRichieste toEntityModel() {
		RigheRichiesteImpl righeRichiesteImpl = new RigheRichiesteImpl();

		righeRichiesteImpl.setId(id);
		righeRichiesteImpl.setIdMateriale(idMateriale);
		righeRichiesteImpl.setNumeroRiga(numeroRiga);
		righeRichiesteImpl.setQuantitaRichiesta(quantitaRichiesta);
		righeRichiesteImpl.setQuantitaDisponibile(quantitaDisponibile);
		righeRichiesteImpl.setUidIns(uidIns);

		if (dataIns == Long.MIN_VALUE) {
			righeRichiesteImpl.setDataIns(null);
		}
		else {
			righeRichiesteImpl.setDataIns(new Date(dataIns));
		}

		righeRichiesteImpl.setUidUpd(uidUpd);

		if (dataUpd == Long.MIN_VALUE) {
			righeRichiesteImpl.setDataUpd(null);
		}
		else {
			righeRichiesteImpl.setDataUpd(new Date(dataUpd));
		}

		righeRichiesteImpl.setImporto(importo);

		if (sottogruppo == null) {
			righeRichiesteImpl.setSottogruppo(StringPool.BLANK);
		}
		else {
			righeRichiesteImpl.setSottogruppo(sottogruppo);
		}

		if (gruppo == null) {
			righeRichiesteImpl.setGruppo(StringPool.BLANK);
		}
		else {
			righeRichiesteImpl.setGruppo(gruppo);
		}

		if (descrizione == null) {
			righeRichiesteImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			righeRichiesteImpl.setDescrizione(descrizione);
		}

		righeRichiesteImpl.resetOriginalValues();

		return righeRichiesteImpl;
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

		righeRichiestePK = new RigheRichiestePK(id, idMateriale, sottogruppo,
				gruppo);
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
	public transient RigheRichiestePK righeRichiestePK;
}