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

package servizio.beni.facile.consumo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.beni.facile.consumo.model.RigheRichiestaBFC;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RigheRichiestaBFC in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFC
 * @generated
 */
@ProviderType
public class RigheRichiestaBFCCacheModel implements CacheModel<RigheRichiestaBFC>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichiestaBFCCacheModel)) {
			return false;
		}

		RigheRichiestaBFCCacheModel righeRichiestaBFCCacheModel = (RigheRichiestaBFCCacheModel)obj;

		if (id == righeRichiestaBFCCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", id_richiesta=");
		sb.append(id_richiesta);
		sb.append(", dipartimento=");
		sb.append(dipartimento);
		sb.append(", dati=");
		sb.append(dati);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RigheRichiestaBFC toEntityModel() {
		RigheRichiestaBFCImpl righeRichiestaBFCImpl = new RigheRichiestaBFCImpl();

		righeRichiestaBFCImpl.setId(id);
		righeRichiestaBFCImpl.setId_richiesta(id_richiesta);

		if (dipartimento == null) {
			righeRichiestaBFCImpl.setDipartimento(StringPool.BLANK);
		}
		else {
			righeRichiestaBFCImpl.setDipartimento(dipartimento);
		}

		if (dati == null) {
			righeRichiestaBFCImpl.setDati(StringPool.BLANK);
		}
		else {
			righeRichiestaBFCImpl.setDati(dati);
		}

		righeRichiestaBFCImpl.resetOriginalValues();

		return righeRichiestaBFCImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		id_richiesta = objectInput.readLong();
		dipartimento = objectInput.readUTF();
		dati = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(id_richiesta);

		if (dipartimento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dipartimento);
		}

		if (dati == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati);
		}
	}

	public long id;
	public long id_richiesta;
	public String dipartimento;
	public String dati;
}