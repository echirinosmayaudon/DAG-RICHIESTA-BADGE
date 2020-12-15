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

package mef.richiesta.gest.pos.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import mef.richiesta.gest.pos.model.Piano;

/**
 * The cache model class for representing Piano in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PianoCacheModel implements CacheModel<Piano>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PianoCacheModel)) {
			return false;
		}

		PianoCacheModel pianoCacheModel = (PianoCacheModel)obj;

		if (id_pk_piano == pianoCacheModel.id_pk_piano) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_pk_piano);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id_pk_piano=");
		sb.append(id_pk_piano);
		sb.append(", id_piano=");
		sb.append(id_piano);
		sb.append(", id_sede=");
		sb.append(id_sede);
		sb.append(", cod_piano=");
		sb.append(cod_piano);
		sb.append(", desc=");
		sb.append(desc);
		sb.append(", data_ins=");
		sb.append(data_ins);
		sb.append(", data_agg=");
		sb.append(data_agg);
		sb.append(", user_ins=");
		sb.append(user_ins);
		sb.append(", user_agg=");
		sb.append(user_agg);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Piano toEntityModel() {
		PianoImpl pianoImpl = new PianoImpl();

		pianoImpl.setId_pk_piano(id_pk_piano);
		pianoImpl.setId_piano(id_piano);
		pianoImpl.setId_sede(id_sede);

		if (cod_piano == null) {
			pianoImpl.setCod_piano("");
		}
		else {
			pianoImpl.setCod_piano(cod_piano);
		}

		if (desc == null) {
			pianoImpl.setDesc("");
		}
		else {
			pianoImpl.setDesc(desc);
		}

		if (data_ins == null) {
			pianoImpl.setData_ins("");
		}
		else {
			pianoImpl.setData_ins(data_ins);
		}

		if (data_agg == null) {
			pianoImpl.setData_agg("");
		}
		else {
			pianoImpl.setData_agg(data_agg);
		}

		if (user_ins == null) {
			pianoImpl.setUser_ins("");
		}
		else {
			pianoImpl.setUser_ins(user_ins);
		}

		if (user_agg == null) {
			pianoImpl.setUser_agg("");
		}
		else {
			pianoImpl.setUser_agg(user_agg);
		}

		pianoImpl.resetOriginalValues();

		return pianoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_pk_piano = objectInput.readLong();

		id_piano = objectInput.readLong();

		id_sede = objectInput.readLong();
		cod_piano = objectInput.readUTF();
		desc = objectInput.readUTF();
		data_ins = objectInput.readUTF();
		data_agg = objectInput.readUTF();
		user_ins = objectInput.readUTF();
		user_agg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id_pk_piano);

		objectOutput.writeLong(id_piano);

		objectOutput.writeLong(id_sede);

		if (cod_piano == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cod_piano);
		}

		if (desc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(desc);
		}

		if (data_ins == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(data_ins);
		}

		if (data_agg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(data_agg);
		}

		if (user_ins == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(user_ins);
		}

		if (user_agg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(user_agg);
		}
	}

	public long id_pk_piano;
	public long id_piano;
	public long id_sede;
	public String cod_piano;
	public String desc;
	public String data_ins;
	public String data_agg;
	public String user_ins;
	public String user_agg;

}