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

import servizio.beni.facile.consumo.model.CambioStatoDirigente;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CambioStatoDirigente in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CambioStatoDirigente
 * @generated
 */
@ProviderType
public class CambioStatoDirigenteCacheModel implements CacheModel<CambioStatoDirigente>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CambioStatoDirigenteCacheModel)) {
			return false;
		}

		CambioStatoDirigenteCacheModel cambioStatoDirigenteCacheModel = (CambioStatoDirigenteCacheModel)obj;

		if (id == cambioStatoDirigenteCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", id_rich=");
		sb.append(id_rich);
		sb.append(", data=");
		sb.append(data);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", id_stato=");
		sb.append(id_stato);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CambioStatoDirigente toEntityModel() {
		CambioStatoDirigenteImpl cambioStatoDirigenteImpl = new CambioStatoDirigenteImpl();

		cambioStatoDirigenteImpl.setId(id);
		cambioStatoDirigenteImpl.setId_rich(id_rich);

		if (data == Long.MIN_VALUE) {
			cambioStatoDirigenteImpl.setData(null);
		}
		else {
			cambioStatoDirigenteImpl.setData(new Date(data));
		}

		if (utente == null) {
			cambioStatoDirigenteImpl.setUtente(StringPool.BLANK);
		}
		else {
			cambioStatoDirigenteImpl.setUtente(utente);
		}

		cambioStatoDirigenteImpl.setId_stato(id_stato);

		if (note == null) {
			cambioStatoDirigenteImpl.setNote(StringPool.BLANK);
		}
		else {
			cambioStatoDirigenteImpl.setNote(note);
		}

		cambioStatoDirigenteImpl.resetOriginalValues();

		return cambioStatoDirigenteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		id_rich = objectInput.readLong();
		data = objectInput.readLong();
		utente = objectInput.readUTF();

		id_stato = objectInput.readLong();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(id_rich);
		objectOutput.writeLong(data);

		if (utente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente);
		}

		objectOutput.writeLong(id_stato);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long id;
	public long id_rich;
	public long data;
	public String utente;
	public long id_stato;
	public String note;
}