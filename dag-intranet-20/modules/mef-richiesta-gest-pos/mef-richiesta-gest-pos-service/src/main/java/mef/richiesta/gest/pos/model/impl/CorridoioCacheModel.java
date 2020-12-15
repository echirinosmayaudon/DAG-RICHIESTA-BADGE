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

import mef.richiesta.gest.pos.model.Corridoio;

/**
 * The cache model class for representing Corridoio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CorridoioCacheModel
	implements CacheModel<Corridoio>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CorridoioCacheModel)) {
			return false;
		}

		CorridoioCacheModel corridoioCacheModel = (CorridoioCacheModel)obj;

		if (id_pk_corridoio == corridoioCacheModel.id_pk_corridoio) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_pk_corridoio);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id_pk_corridoio=");
		sb.append(id_pk_corridoio);
		sb.append(", id_corridoio=");
		sb.append(id_corridoio);
		sb.append(", id_piano=");
		sb.append(id_piano);
		sb.append(", cod_corridoio=");
		sb.append(cod_corridoio);
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
	public Corridoio toEntityModel() {
		CorridoioImpl corridoioImpl = new CorridoioImpl();

		corridoioImpl.setId_pk_corridoio(id_pk_corridoio);
		corridoioImpl.setId_corridoio(id_corridoio);
		corridoioImpl.setId_piano(id_piano);

		if (cod_corridoio == null) {
			corridoioImpl.setCod_corridoio("");
		}
		else {
			corridoioImpl.setCod_corridoio(cod_corridoio);
		}

		if (desc == null) {
			corridoioImpl.setDesc("");
		}
		else {
			corridoioImpl.setDesc(desc);
		}

		if (data_ins == null) {
			corridoioImpl.setData_ins("");
		}
		else {
			corridoioImpl.setData_ins(data_ins);
		}

		if (data_agg == null) {
			corridoioImpl.setData_agg("");
		}
		else {
			corridoioImpl.setData_agg(data_agg);
		}

		if (user_ins == null) {
			corridoioImpl.setUser_ins("");
		}
		else {
			corridoioImpl.setUser_ins(user_ins);
		}

		if (user_agg == null) {
			corridoioImpl.setUser_agg("");
		}
		else {
			corridoioImpl.setUser_agg(user_agg);
		}

		corridoioImpl.resetOriginalValues();

		return corridoioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_pk_corridoio = objectInput.readLong();

		id_corridoio = objectInput.readLong();

		id_piano = objectInput.readLong();
		cod_corridoio = objectInput.readUTF();
		desc = objectInput.readUTF();
		data_ins = objectInput.readUTF();
		data_agg = objectInput.readUTF();
		user_ins = objectInput.readUTF();
		user_agg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id_pk_corridoio);

		objectOutput.writeLong(id_corridoio);

		objectOutput.writeLong(id_piano);

		if (cod_corridoio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cod_corridoio);
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

	public long id_pk_corridoio;
	public long id_corridoio;
	public long id_piano;
	public String cod_corridoio;
	public String desc;
	public String data_ins;
	public String data_agg;
	public String user_ins;
	public String user_agg;

}