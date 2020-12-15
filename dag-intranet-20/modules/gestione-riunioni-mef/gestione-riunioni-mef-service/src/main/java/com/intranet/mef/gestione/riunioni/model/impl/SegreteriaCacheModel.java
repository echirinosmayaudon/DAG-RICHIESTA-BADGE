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

package com.intranet.mef.gestione.riunioni.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.Segreteria;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Segreteria in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Segreteria
 * @generated
 */
@ProviderType
public class SegreteriaCacheModel implements CacheModel<Segreteria>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegreteriaCacheModel)) {
			return false;
		}

		SegreteriaCacheModel segreteriaCacheModel = (SegreteriaCacheModel)obj;

		if (id_segreteria == segreteriaCacheModel.id_segreteria) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_segreteria);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id_segreteria=");
		sb.append(id_segreteria);
		sb.append(", email=");
		sb.append(email);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", acronimo=");
		sb.append(acronimo);
		sb.append(", livello_gerarchia=");
		sb.append(livello_gerarchia);
		sb.append(", cod_padre=");
		sb.append(cod_padre);
		sb.append(", data_fine_esistenza=");
		sb.append(data_fine_esistenza);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", cap=");
		sb.append(cap);
		sb.append(", cod_istat_citta=");
		sb.append(cod_istat_citta);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Segreteria toEntityModel() {
		SegreteriaImpl segreteriaImpl = new SegreteriaImpl();

		segreteriaImpl.setId_segreteria(id_segreteria);

		if (email == null) {
			segreteriaImpl.setEmail(StringPool.BLANK);
		}
		else {
			segreteriaImpl.setEmail(email);
		}

		if (descrizione == null) {
			segreteriaImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			segreteriaImpl.setDescrizione(descrizione);
		}

		if (acronimo == null) {
			segreteriaImpl.setAcronimo(StringPool.BLANK);
		}
		else {
			segreteriaImpl.setAcronimo(acronimo);
		}

		segreteriaImpl.setLivello_gerarchia(livello_gerarchia);
		segreteriaImpl.setCod_padre(cod_padre);

		if (data_fine_esistenza == Long.MIN_VALUE) {
			segreteriaImpl.setData_fine_esistenza(null);
		}
		else {
			segreteriaImpl.setData_fine_esistenza(new Date(data_fine_esistenza));
		}

		if (indirizzo == null) {
			segreteriaImpl.setIndirizzo(StringPool.BLANK);
		}
		else {
			segreteriaImpl.setIndirizzo(indirizzo);
		}

		if (cap == null) {
			segreteriaImpl.setCap(StringPool.BLANK);
		}
		else {
			segreteriaImpl.setCap(cap);
		}

		segreteriaImpl.setCod_istat_citta(cod_istat_citta);

		segreteriaImpl.resetOriginalValues();

		return segreteriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_segreteria = objectInput.readLong();
		email = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		acronimo = objectInput.readUTF();

		livello_gerarchia = objectInput.readLong();

		cod_padre = objectInput.readLong();
		data_fine_esistenza = objectInput.readLong();
		indirizzo = objectInput.readUTF();
		cap = objectInput.readUTF();

		cod_istat_citta = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_segreteria);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (acronimo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acronimo);
		}

		objectOutput.writeLong(livello_gerarchia);

		objectOutput.writeLong(cod_padre);
		objectOutput.writeLong(data_fine_esistenza);

		if (indirizzo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indirizzo);
		}

		if (cap == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cap);
		}

		objectOutput.writeLong(cod_istat_citta);
	}

	public long id_segreteria;
	public String email;
	public String descrizione;
	public String acronimo;
	public long livello_gerarchia;
	public long cod_padre;
	public long data_fine_esistenza;
	public String indirizzo;
	public String cap;
	public long cod_istat_citta;
}