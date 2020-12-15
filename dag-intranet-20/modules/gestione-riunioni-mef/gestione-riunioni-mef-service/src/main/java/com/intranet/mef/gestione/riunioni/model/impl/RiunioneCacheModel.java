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

import com.intranet.mef.gestione.riunioni.model.Riunione;

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
 * The cache model class for representing Riunione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Riunione
 * @generated
 */
@ProviderType
public class RiunioneCacheModel implements CacheModel<Riunione>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RiunioneCacheModel)) {
			return false;
		}

		RiunioneCacheModel riunioneCacheModel = (RiunioneCacheModel)obj;

		if (id_riunione == riunioneCacheModel.id_riunione) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_riunione);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id_riunione=");
		sb.append(id_riunione);
		sb.append(", oggetto=");
		sb.append(oggetto);
		sb.append(", data_inizio=");
		sb.append(data_inizio);
		sb.append(", data_fine=");
		sb.append(data_fine);
		sb.append(", note=");
		sb.append(note);
		sb.append(", data_modifica=");
		sb.append(data_modifica);
		sb.append(", data_creazione=");
		sb.append(data_creazione);
		sb.append(", protocollo=");
		sb.append(protocollo);
		sb.append(", id_stato_riunione=");
		sb.append(id_stato_riunione);
		sb.append(", id_tipo=");
		sb.append(id_tipo);
		sb.append(", id_luogo=");
		sb.append(id_luogo);
		sb.append(", id_amministrazione_convocante=");
		sb.append(id_amministrazione_convocante);
		sb.append(", data_ultimo_sollecito=");
		sb.append(data_ultimo_sollecito);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Riunione toEntityModel() {
		RiunioneImpl riunioneImpl = new RiunioneImpl();

		riunioneImpl.setId_riunione(id_riunione);

		if (oggetto == null) {
			riunioneImpl.setOggetto(StringPool.BLANK);
		}
		else {
			riunioneImpl.setOggetto(oggetto);
		}

		if (data_inizio == Long.MIN_VALUE) {
			riunioneImpl.setData_inizio(null);
		}
		else {
			riunioneImpl.setData_inizio(new Date(data_inizio));
		}

		if (data_fine == Long.MIN_VALUE) {
			riunioneImpl.setData_fine(null);
		}
		else {
			riunioneImpl.setData_fine(new Date(data_fine));
		}

		if (note == null) {
			riunioneImpl.setNote(StringPool.BLANK);
		}
		else {
			riunioneImpl.setNote(note);
		}

		if (data_modifica == Long.MIN_VALUE) {
			riunioneImpl.setData_modifica(null);
		}
		else {
			riunioneImpl.setData_modifica(new Date(data_modifica));
		}

		if (data_creazione == Long.MIN_VALUE) {
			riunioneImpl.setData_creazione(null);
		}
		else {
			riunioneImpl.setData_creazione(new Date(data_creazione));
		}

		if (protocollo == null) {
			riunioneImpl.setProtocollo(StringPool.BLANK);
		}
		else {
			riunioneImpl.setProtocollo(protocollo);
		}

		riunioneImpl.setId_stato_riunione(id_stato_riunione);
		riunioneImpl.setId_tipo(id_tipo);
		riunioneImpl.setId_luogo(id_luogo);
		riunioneImpl.setId_amministrazione_convocante(id_amministrazione_convocante);

		if (data_ultimo_sollecito == Long.MIN_VALUE) {
			riunioneImpl.setData_ultimo_sollecito(null);
		}
		else {
			riunioneImpl.setData_ultimo_sollecito(new Date(
					data_ultimo_sollecito));
		}

		riunioneImpl.resetOriginalValues();

		return riunioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_riunione = objectInput.readLong();
		oggetto = objectInput.readUTF();
		data_inizio = objectInput.readLong();
		data_fine = objectInput.readLong();
		note = objectInput.readUTF();
		data_modifica = objectInput.readLong();
		data_creazione = objectInput.readLong();
		protocollo = objectInput.readUTF();

		id_stato_riunione = objectInput.readLong();

		id_tipo = objectInput.readLong();

		id_luogo = objectInput.readLong();

		id_amministrazione_convocante = objectInput.readLong();
		data_ultimo_sollecito = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_riunione);

		if (oggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(oggetto);
		}

		objectOutput.writeLong(data_inizio);
		objectOutput.writeLong(data_fine);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(data_modifica);
		objectOutput.writeLong(data_creazione);

		if (protocollo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(protocollo);
		}

		objectOutput.writeLong(id_stato_riunione);

		objectOutput.writeLong(id_tipo);

		objectOutput.writeLong(id_luogo);

		objectOutput.writeLong(id_amministrazione_convocante);
		objectOutput.writeLong(data_ultimo_sollecito);
	}

	public long id_riunione;
	public String oggetto;
	public long data_inizio;
	public long data_fine;
	public String note;
	public long data_modifica;
	public long data_creazione;
	public String protocollo;
	public long id_stato_riunione;
	public long id_tipo;
	public long id_luogo;
	public long id_amministrazione_convocante;
	public long data_ultimo_sollecito;
}