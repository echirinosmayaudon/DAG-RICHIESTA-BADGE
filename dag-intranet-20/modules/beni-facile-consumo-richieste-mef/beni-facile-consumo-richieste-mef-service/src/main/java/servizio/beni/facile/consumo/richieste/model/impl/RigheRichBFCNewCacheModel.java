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

package servizio.beni.facile.consumo.richieste.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RigheRichBFCNew in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichBFCNew
 * @generated
 */
@ProviderType
public class RigheRichBFCNewCacheModel implements CacheModel<RigheRichBFCNew>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichBFCNewCacheModel)) {
			return false;
		}

		RigheRichBFCNewCacheModel righeRichBFCNewCacheModel = (RigheRichBFCNewCacheModel)obj;

		if (id == righeRichBFCNewCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", id_rich=");
		sb.append(id_rich);
		sb.append(", dipartimento=");
		sb.append(dipartimento);
		sb.append(", dati1=");
		sb.append(dati1);
		sb.append(", dati2=");
		sb.append(dati2);
		sb.append(", dati3=");
		sb.append(dati3);
		sb.append(", dati4=");
		sb.append(dati4);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RigheRichBFCNew toEntityModel() {
		RigheRichBFCNewImpl righeRichBFCNewImpl = new RigheRichBFCNewImpl();

		righeRichBFCNewImpl.setId(id);
		righeRichBFCNewImpl.setId_rich(id_rich);

		if (dipartimento == null) {
			righeRichBFCNewImpl.setDipartimento(StringPool.BLANK);
		}
		else {
			righeRichBFCNewImpl.setDipartimento(dipartimento);
		}

		if (dati1 == null) {
			righeRichBFCNewImpl.setDati1(StringPool.BLANK);
		}
		else {
			righeRichBFCNewImpl.setDati1(dati1);
		}

		if (dati2 == null) {
			righeRichBFCNewImpl.setDati2(StringPool.BLANK);
		}
		else {
			righeRichBFCNewImpl.setDati2(dati2);
		}

		if (dati3 == null) {
			righeRichBFCNewImpl.setDati3(StringPool.BLANK);
		}
		else {
			righeRichBFCNewImpl.setDati3(dati3);
		}

		if (dati4 == null) {
			righeRichBFCNewImpl.setDati4(StringPool.BLANK);
		}
		else {
			righeRichBFCNewImpl.setDati4(dati4);
		}

		righeRichBFCNewImpl.resetOriginalValues();

		return righeRichBFCNewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		id_rich = objectInput.readLong();
		dipartimento = objectInput.readUTF();
		dati1 = objectInput.readUTF();
		dati2 = objectInput.readUTF();
		dati3 = objectInput.readUTF();
		dati4 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(id_rich);

		if (dipartimento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dipartimento);
		}

		if (dati1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati1);
		}

		if (dati2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati2);
		}

		if (dati3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati3);
		}

		if (dati4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati4);
		}
	}

	public long id;
	public long id_rich;
	public String dipartimento;
	public String dati1;
	public String dati2;
	public String dati3;
	public String dati4;
}