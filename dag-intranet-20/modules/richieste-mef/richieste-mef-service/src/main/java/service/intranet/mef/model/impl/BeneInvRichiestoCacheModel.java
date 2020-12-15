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

package service.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import service.intranet.mef.model.BeneInvRichiesto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BeneInvRichiesto in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvRichiesto
 * @generated
 */
@ProviderType
public class BeneInvRichiestoCacheModel implements CacheModel<BeneInvRichiesto>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BeneInvRichiestoCacheModel)) {
			return false;
		}

		BeneInvRichiestoCacheModel beneInvRichiestoCacheModel = (BeneInvRichiestoCacheModel)obj;

		if (id_bene_rich == beneInvRichiestoCacheModel.id_bene_rich) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_bene_rich);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id_bene_rich=");
		sb.append(id_bene_rich);
		sb.append(", tipologia=");
		sb.append(tipologia);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", quantita=");
		sb.append(quantita);
		sb.append(", dettagli=");
		sb.append(dettagli);
		sb.append(", in_elenco=");
		sb.append(in_elenco);
		sb.append(", id_richiesta=");
		sb.append(id_richiesta);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BeneInvRichiesto toEntityModel() {
		BeneInvRichiestoImpl beneInvRichiestoImpl = new BeneInvRichiestoImpl();

		beneInvRichiestoImpl.setId_bene_rich(id_bene_rich);

		if (tipologia == null) {
			beneInvRichiestoImpl.setTipologia(StringPool.BLANK);
		}
		else {
			beneInvRichiestoImpl.setTipologia(tipologia);
		}

		if (descrizione == null) {
			beneInvRichiestoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			beneInvRichiestoImpl.setDescrizione(descrizione);
		}

		beneInvRichiestoImpl.setQuantita(quantita);

		if (dettagli == null) {
			beneInvRichiestoImpl.setDettagli(StringPool.BLANK);
		}
		else {
			beneInvRichiestoImpl.setDettagli(dettagli);
		}

		beneInvRichiestoImpl.setIn_elenco(in_elenco);
		beneInvRichiestoImpl.setId_richiesta(id_richiesta);

		beneInvRichiestoImpl.resetOriginalValues();

		return beneInvRichiestoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_bene_rich = objectInput.readLong();
		tipologia = objectInput.readUTF();
		descrizione = objectInput.readUTF();

		quantita = objectInput.readInt();
		dettagli = objectInput.readUTF();

		in_elenco = objectInput.readBoolean();

		id_richiesta = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_bene_rich);

		if (tipologia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipologia);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		objectOutput.writeInt(quantita);

		if (dettagli == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dettagli);
		}

		objectOutput.writeBoolean(in_elenco);

		objectOutput.writeLong(id_richiesta);
	}

	public long id_bene_rich;
	public String tipologia;
	public String descrizione;
	public int quantita;
	public String dettagli;
	public boolean in_elenco;
	public long id_richiesta;
}