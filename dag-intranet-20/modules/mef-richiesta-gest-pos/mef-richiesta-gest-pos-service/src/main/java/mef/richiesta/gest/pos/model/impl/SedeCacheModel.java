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

import mef.richiesta.gest.pos.model.Sede;

/**
 * The cache model class for representing Sede in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SedeCacheModel implements CacheModel<Sede>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SedeCacheModel)) {
			return false;
		}

		SedeCacheModel sedeCacheModel = (SedeCacheModel)obj;

		if (id_pk_sede == sedeCacheModel.id_pk_sede) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_pk_sede);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id_pk_sede=");
		sb.append(id_pk_sede);
		sb.append(", id_sede=");
		sb.append(id_sede);
		sb.append(", cod_sede=");
		sb.append(cod_sede);
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
	public Sede toEntityModel() {
		SedeImpl sedeImpl = new SedeImpl();

		sedeImpl.setId_pk_sede(id_pk_sede);
		sedeImpl.setId_sede(id_sede);

		if (cod_sede == null) {
			sedeImpl.setCod_sede("");
		}
		else {
			sedeImpl.setCod_sede(cod_sede);
		}

		if (desc == null) {
			sedeImpl.setDesc("");
		}
		else {
			sedeImpl.setDesc(desc);
		}

		if (data_ins == null) {
			sedeImpl.setData_ins("");
		}
		else {
			sedeImpl.setData_ins(data_ins);
		}

		if (data_agg == null) {
			sedeImpl.setData_agg("");
		}
		else {
			sedeImpl.setData_agg(data_agg);
		}

		if (user_ins == null) {
			sedeImpl.setUser_ins("");
		}
		else {
			sedeImpl.setUser_ins(user_ins);
		}

		if (user_agg == null) {
			sedeImpl.setUser_agg("");
		}
		else {
			sedeImpl.setUser_agg(user_agg);
		}

		sedeImpl.resetOriginalValues();

		return sedeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_pk_sede = objectInput.readLong();

		id_sede = objectInput.readLong();
		cod_sede = objectInput.readUTF();
		desc = objectInput.readUTF();
		data_ins = objectInput.readUTF();
		data_agg = objectInput.readUTF();
		user_ins = objectInput.readUTF();
		user_agg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id_pk_sede);

		objectOutput.writeLong(id_sede);

		if (cod_sede == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cod_sede);
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

	public long id_pk_sede;
	public long id_sede;
	public String cod_sede;
	public String desc;
	public String data_ins;
	public String data_agg;
	public String user_ins;
	public String user_agg;

}