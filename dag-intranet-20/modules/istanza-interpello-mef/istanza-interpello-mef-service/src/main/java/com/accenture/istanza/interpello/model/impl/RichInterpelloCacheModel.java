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

package com.accenture.istanza.interpello.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.istanza.interpello.model.RichInterpello;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichInterpello in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichInterpello
 * @generated
 */
@ProviderType
public class RichInterpelloCacheModel implements CacheModel<RichInterpello>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichInterpelloCacheModel)) {
			return false;
		}

		RichInterpelloCacheModel richInterpelloCacheModel = (RichInterpelloCacheModel)obj;

		if (id == richInterpelloCacheModel.id) {
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
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(id);
		sb.append(", id_richiesta=");
		sb.append(id_richiesta);
		sb.append(", cognome=");
		sb.append(cognome);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", dipartimento=");
		sb.append(dipartimento);
		sb.append(", direzione=");
		sb.append(direzione);
		sb.append(", ufficio=");
		sb.append(ufficio);
		sb.append(", screename=");
		sb.append(screename);
		sb.append(", json_richiedente=");
		sb.append(json_richiedente);
		sb.append(", json_richiesta=");
		sb.append(json_richiesta);
		sb.append(", bando=");
		sb.append(bando);
		sb.append(", data_richiesta=");
		sb.append(data_richiesta);
		sb.append(", allegato=");
		sb.append(allegato);
		sb.append(", pdf=");
		sb.append(pdf);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichInterpello toEntityModel() {
		RichInterpelloImpl richInterpelloImpl = new RichInterpelloImpl();

		richInterpelloImpl.setId(id);
		richInterpelloImpl.setId_richiesta(id_richiesta);

		if (cognome == null) {
			richInterpelloImpl.setCognome("");
		}
		else {
			richInterpelloImpl.setCognome(cognome);
		}

		if (nome == null) {
			richInterpelloImpl.setNome("");
		}
		else {
			richInterpelloImpl.setNome(nome);
		}

		richInterpelloImpl.setDipartimento(dipartimento);
		richInterpelloImpl.setDirezione(direzione);
		richInterpelloImpl.setUfficio(ufficio);

		if (screename == null) {
			richInterpelloImpl.setScreename("");
		}
		else {
			richInterpelloImpl.setScreename(screename);
		}

		if (json_richiedente == null) {
			richInterpelloImpl.setJson_richiedente("");
		}
		else {
			richInterpelloImpl.setJson_richiedente(json_richiedente);
		}

		if (json_richiesta == null) {
			richInterpelloImpl.setJson_richiesta("");
		}
		else {
			richInterpelloImpl.setJson_richiesta(json_richiesta);
		}

		if (bando == null) {
			richInterpelloImpl.setBando("");
		}
		else {
			richInterpelloImpl.setBando(bando);
		}

		if (data_richiesta == Long.MIN_VALUE) {
			richInterpelloImpl.setData_richiesta(null);
		}
		else {
			richInterpelloImpl.setData_richiesta(new Date(data_richiesta));
		}

		if (allegato == null) {
			richInterpelloImpl.setAllegato("");
		}
		else {
			richInterpelloImpl.setAllegato(allegato);
		}

		if (pdf == null) {
			richInterpelloImpl.setPdf("");
		}
		else {
			richInterpelloImpl.setPdf(pdf);
		}

		if (note == null) {
			richInterpelloImpl.setNote("");
		}
		else {
			richInterpelloImpl.setNote(note);
		}

		richInterpelloImpl.resetOriginalValues();

		return richInterpelloImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		id_richiesta = objectInput.readLong();
		cognome = objectInput.readUTF();
		nome = objectInput.readUTF();

		dipartimento = objectInput.readLong();

		direzione = objectInput.readLong();

		ufficio = objectInput.readLong();
		screename = objectInput.readUTF();
		json_richiedente = objectInput.readUTF();
		json_richiesta = objectInput.readUTF();
		bando = objectInput.readUTF();
		data_richiesta = objectInput.readLong();
		allegato = objectInput.readUTF();
		pdf = objectInput.readUTF();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(id_richiesta);

		if (cognome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cognome);
		}

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		objectOutput.writeLong(dipartimento);

		objectOutput.writeLong(direzione);

		objectOutput.writeLong(ufficio);

		if (screename == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(screename);
		}

		if (json_richiedente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(json_richiedente);
		}

		if (json_richiesta == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(json_richiesta);
		}

		if (bando == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bando);
		}

		objectOutput.writeLong(data_richiesta);

		if (allegato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(allegato);
		}

		if (pdf == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pdf);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long id;
	public long id_richiesta;
	public String cognome;
	public String nome;
	public long dipartimento;
	public long direzione;
	public long ufficio;
	public String screename;
	public String json_richiedente;
	public String json_richiesta;
	public String bando;
	public long data_richiesta;
	public String allegato;
	public String pdf;
	public String note;
}