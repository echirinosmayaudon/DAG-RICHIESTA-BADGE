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

package com.accenture.lavoro.agile.istanza.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OpzioneRich in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRich
 * @generated
 */
@ProviderType
public class OpzioneRichCacheModel implements CacheModel<OpzioneRich>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OpzioneRichCacheModel)) {
			return false;
		}

		OpzioneRichCacheModel opzioneRichCacheModel = (OpzioneRichCacheModel)obj;

		if (id_opt == opzioneRichCacheModel.id_opt) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_opt);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id_opt=");
		sb.append(id_opt);
		sb.append(", label_opt=");
		sb.append(label_opt);
		sb.append(", testo_opt=");
		sb.append(testo_opt);
		sb.append(", peso_opt=");
		sb.append(peso_opt);
		sb.append(", data_in=");
		sb.append(data_in);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OpzioneRich toEntityModel() {
		OpzioneRichImpl opzioneRichImpl = new OpzioneRichImpl();

		opzioneRichImpl.setId_opt(id_opt);

		if (label_opt == null) {
			opzioneRichImpl.setLabel_opt("");
		}
		else {
			opzioneRichImpl.setLabel_opt(label_opt);
		}

		if (testo_opt == null) {
			opzioneRichImpl.setTesto_opt("");
		}
		else {
			opzioneRichImpl.setTesto_opt(testo_opt);
		}

		opzioneRichImpl.setPeso_opt(peso_opt);

		if (data_in == Long.MIN_VALUE) {
			opzioneRichImpl.setData_in(null);
		}
		else {
			opzioneRichImpl.setData_in(new Date(data_in));
		}

		opzioneRichImpl.resetOriginalValues();

		return opzioneRichImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_opt = objectInput.readLong();
		label_opt = objectInput.readUTF();
		testo_opt = objectInput.readUTF();

		peso_opt = objectInput.readInt();
		data_in = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_opt);

		if (label_opt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(label_opt);
		}

		if (testo_opt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testo_opt);
		}

		objectOutput.writeInt(peso_opt);
		objectOutput.writeLong(data_in);
	}

	public long id_opt;
	public String label_opt;
	public String testo_opt;
	public int peso_opt;
	public long data_in;
}