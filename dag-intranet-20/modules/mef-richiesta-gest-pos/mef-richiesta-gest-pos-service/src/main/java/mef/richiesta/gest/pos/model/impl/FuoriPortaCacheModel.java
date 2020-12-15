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

import mef.richiesta.gest.pos.model.FuoriPorta;

/**
 * The cache model class for representing FuoriPorta in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FuoriPortaCacheModel
	implements CacheModel<FuoriPorta>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FuoriPortaCacheModel)) {
			return false;
		}

		FuoriPortaCacheModel fuoriPortaCacheModel = (FuoriPortaCacheModel)obj;

		if (id_pk_fuoriPorta == fuoriPortaCacheModel.id_pk_fuoriPorta) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_pk_fuoriPorta);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id_pk_fuoriPorta=");
		sb.append(id_pk_fuoriPorta);
		sb.append(", id_fuoriPorta=");
		sb.append(id_fuoriPorta);
		sb.append(", id_corridoio=");
		sb.append(id_corridoio);
		sb.append(", cod_fuoriPorta=");
		sb.append(cod_fuoriPorta);
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
	public FuoriPorta toEntityModel() {
		FuoriPortaImpl fuoriPortaImpl = new FuoriPortaImpl();

		fuoriPortaImpl.setId_pk_fuoriPorta(id_pk_fuoriPorta);
		fuoriPortaImpl.setId_fuoriPorta(id_fuoriPorta);
		fuoriPortaImpl.setId_corridoio(id_corridoio);

		if (cod_fuoriPorta == null) {
			fuoriPortaImpl.setCod_fuoriPorta("");
		}
		else {
			fuoriPortaImpl.setCod_fuoriPorta(cod_fuoriPorta);
		}

		if (desc == null) {
			fuoriPortaImpl.setDesc("");
		}
		else {
			fuoriPortaImpl.setDesc(desc);
		}

		if (data_ins == null) {
			fuoriPortaImpl.setData_ins("");
		}
		else {
			fuoriPortaImpl.setData_ins(data_ins);
		}

		if (data_agg == null) {
			fuoriPortaImpl.setData_agg("");
		}
		else {
			fuoriPortaImpl.setData_agg(data_agg);
		}

		if (user_ins == null) {
			fuoriPortaImpl.setUser_ins("");
		}
		else {
			fuoriPortaImpl.setUser_ins(user_ins);
		}

		if (user_agg == null) {
			fuoriPortaImpl.setUser_agg("");
		}
		else {
			fuoriPortaImpl.setUser_agg(user_agg);
		}

		fuoriPortaImpl.resetOriginalValues();

		return fuoriPortaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_pk_fuoriPorta = objectInput.readLong();

		id_fuoriPorta = objectInput.readLong();

		id_corridoio = objectInput.readLong();
		cod_fuoriPorta = objectInput.readUTF();
		desc = objectInput.readUTF();
		data_ins = objectInput.readUTF();
		data_agg = objectInput.readUTF();
		user_ins = objectInput.readUTF();
		user_agg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id_pk_fuoriPorta);

		objectOutput.writeLong(id_fuoriPorta);

		objectOutput.writeLong(id_corridoio);

		if (cod_fuoriPorta == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cod_fuoriPorta);
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

	public long id_pk_fuoriPorta;
	public long id_fuoriPorta;
	public long id_corridoio;
	public String cod_fuoriPorta;
	public String desc;
	public String data_ins;
	public String data_agg;
	public String user_ins;
	public String user_agg;

}