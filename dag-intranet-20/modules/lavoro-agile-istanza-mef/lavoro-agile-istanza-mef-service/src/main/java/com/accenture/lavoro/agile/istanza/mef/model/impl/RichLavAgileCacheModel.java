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

import com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichLavAgile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichLavAgile
 * @generated
 */
@ProviderType
public class RichLavAgileCacheModel implements CacheModel<RichLavAgile>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichLavAgileCacheModel)) {
			return false;
		}

		RichLavAgileCacheModel richLavAgileCacheModel = (RichLavAgileCacheModel)obj;

		if (id == richLavAgileCacheModel.id) {
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
		StringBundler sb = new StringBundler(33);

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
		sb.append(", peso_tot=");
		sb.append(peso_tot);
		sb.append(", peso_plus=");
		sb.append(peso_plus);
		sb.append(", bando=");
		sb.append(bando);
		sb.append(", data_richiesta=");
		sb.append(data_richiesta);
		sb.append(", allegato=");
		sb.append(allegato);
		sb.append(", pdf=");
		sb.append(pdf);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichLavAgile toEntityModel() {
		RichLavAgileImpl richLavAgileImpl = new RichLavAgileImpl();

		richLavAgileImpl.setId(id);
		richLavAgileImpl.setId_richiesta(id_richiesta);

		if (cognome == null) {
			richLavAgileImpl.setCognome("");
		}
		else {
			richLavAgileImpl.setCognome(cognome);
		}

		if (nome == null) {
			richLavAgileImpl.setNome("");
		}
		else {
			richLavAgileImpl.setNome(nome);
		}

		richLavAgileImpl.setDipartimento(dipartimento);
		richLavAgileImpl.setDirezione(direzione);
		richLavAgileImpl.setUfficio(ufficio);

		if (screename == null) {
			richLavAgileImpl.setScreename("");
		}
		else {
			richLavAgileImpl.setScreename(screename);
		}

		if (json_richiedente == null) {
			richLavAgileImpl.setJson_richiedente("");
		}
		else {
			richLavAgileImpl.setJson_richiedente(json_richiedente);
		}

		if (json_richiesta == null) {
			richLavAgileImpl.setJson_richiesta("");
		}
		else {
			richLavAgileImpl.setJson_richiesta(json_richiesta);
		}

		richLavAgileImpl.setPeso_tot(peso_tot);

		if (peso_plus == null) {
			richLavAgileImpl.setPeso_plus("");
		}
		else {
			richLavAgileImpl.setPeso_plus(peso_plus);
		}

		if (bando == null) {
			richLavAgileImpl.setBando("");
		}
		else {
			richLavAgileImpl.setBando(bando);
		}

		if (data_richiesta == Long.MIN_VALUE) {
			richLavAgileImpl.setData_richiesta(null);
		}
		else {
			richLavAgileImpl.setData_richiesta(new Date(data_richiesta));
		}

		if (allegato == null) {
			richLavAgileImpl.setAllegato("");
		}
		else {
			richLavAgileImpl.setAllegato(allegato);
		}

		if (pdf == null) {
			richLavAgileImpl.setPdf("");
		}
		else {
			richLavAgileImpl.setPdf(pdf);
		}

		richLavAgileImpl.resetOriginalValues();

		return richLavAgileImpl;
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

		peso_tot = objectInput.readInt();
		peso_plus = objectInput.readUTF();
		bando = objectInput.readUTF();
		data_richiesta = objectInput.readLong();
		allegato = objectInput.readUTF();
		pdf = objectInput.readUTF();
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

		objectOutput.writeInt(peso_tot);

		if (peso_plus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(peso_plus);
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
	public int peso_tot;
	public String peso_plus;
	public String bando;
	public long data_richiesta;
	public String allegato;
	public String pdf;
}