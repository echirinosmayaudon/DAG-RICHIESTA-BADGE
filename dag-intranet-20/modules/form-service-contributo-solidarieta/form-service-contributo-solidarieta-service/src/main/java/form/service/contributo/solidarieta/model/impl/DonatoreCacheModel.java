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

package form.service.contributo.solidarieta.model.impl;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import form.service.contributo.solidarieta.model.Donatore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Donatore in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DonatoreCacheModel
	implements CacheModel<Donatore>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DonatoreCacheModel)) {
			return false;
		}

		DonatoreCacheModel donatoreCacheModel = (DonatoreCacheModel)obj;

		if (id == donatoreCacheModel.id) {
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
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", cognome=");
		sb.append(cognome);
		sb.append(", cod_fiscale=");
		sb.append(cod_fiscale);
		sb.append(", email=");
		sb.append(email);
		sb.append(", importo=");
		sb.append(importo);
		sb.append(", data_inserimento=");
		sb.append(data_inserimento);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Donatore toEntityModel() {
		DonatoreImpl donatoreImpl = new DonatoreImpl();

		donatoreImpl.setId(id);

		if (nome == null) {
			donatoreImpl.setNome("");
		}
		else {
			donatoreImpl.setNome(nome);
		}

		if (cognome == null) {
			donatoreImpl.setCognome("");
		}
		else {
			donatoreImpl.setCognome(cognome);
		}

		if (cod_fiscale == null) {
			donatoreImpl.setCod_fiscale("");
		}
		else {
			donatoreImpl.setCod_fiscale(cod_fiscale);
		}

		if (email == null) {
			donatoreImpl.setEmail("");
		}
		else {
			donatoreImpl.setEmail(email);
		}

		if (importo == null) {
			donatoreImpl.setImporto("");
		}
		else {
			donatoreImpl.setImporto(importo);
		}

		if (data_inserimento == null) {
			donatoreImpl.setData_inserimento("");
		}
		else {
			donatoreImpl.setData_inserimento(data_inserimento);
		}

		donatoreImpl.resetOriginalValues();

		return donatoreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		nome = objectInput.readUTF();
		cognome = objectInput.readUTF();
		cod_fiscale = objectInput.readUTF();
		email = objectInput.readUTF();
		importo = objectInput.readUTF();
		data_inserimento = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (cognome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cognome);
		}

		if (cod_fiscale == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cod_fiscale);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (importo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(importo);
		}

		if (data_inserimento == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(data_inserimento);
		}
	}

	public long id;
	public String nome;
	public String cognome;
	public String cod_fiscale;
	public String email;
	public String importo;
	public String data_inserimento;

}