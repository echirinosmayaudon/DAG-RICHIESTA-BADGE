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

package service.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import service.intranet.mef.model.LogisticaRichieste;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LogisticaRichieste in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichieste
 * @generated
 */
@ProviderType
public class LogisticaRichiesteCacheModel implements CacheModel<LogisticaRichieste>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogisticaRichiesteCacheModel)) {
			return false;
		}

		LogisticaRichiesteCacheModel logisticaRichiesteCacheModel = (LogisticaRichiesteCacheModel)obj;

		if (id == logisticaRichiesteCacheModel.id) {
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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", oggetto=");
		sb.append(oggetto);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", dipartimento=");
		sb.append(dipartimento);
		sb.append(", data_richiesta=");
		sb.append(data_richiesta);
		sb.append(", dettaglio_richiedente=");
		sb.append(dettaglio_richiedente);
		sb.append(", dettaglio_richieste=");
		sb.append(dettaglio_richieste);
		sb.append(", note_gestore=");
		sb.append(note_gestore);
		sb.append(", id_valutazione=");
		sb.append(id_valutazione);
		sb.append(", id_stato=");
		sb.append(id_stato);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LogisticaRichieste toEntityModel() {
		LogisticaRichiesteImpl logisticaRichiesteImpl = new LogisticaRichiesteImpl();

		logisticaRichiesteImpl.setId(id);

		if (oggetto == null) {
			logisticaRichiesteImpl.setOggetto(StringPool.BLANK);
		}
		else {
			logisticaRichiesteImpl.setOggetto(oggetto);
		}

		if (utente == null) {
			logisticaRichiesteImpl.setUtente(StringPool.BLANK);
		}
		else {
			logisticaRichiesteImpl.setUtente(utente);
		}

		if (dipartimento == null) {
			logisticaRichiesteImpl.setDipartimento(StringPool.BLANK);
		}
		else {
			logisticaRichiesteImpl.setDipartimento(dipartimento);
		}

		if (data_richiesta == Long.MIN_VALUE) {
			logisticaRichiesteImpl.setData_richiesta(null);
		}
		else {
			logisticaRichiesteImpl.setData_richiesta(new Date(data_richiesta));
		}

		if (dettaglio_richiedente == null) {
			logisticaRichiesteImpl.setDettaglio_richiedente(StringPool.BLANK);
		}
		else {
			logisticaRichiesteImpl.setDettaglio_richiedente(dettaglio_richiedente);
		}

		if (dettaglio_richieste == null) {
			logisticaRichiesteImpl.setDettaglio_richieste(StringPool.BLANK);
		}
		else {
			logisticaRichiesteImpl.setDettaglio_richieste(dettaglio_richieste);
		}

		if (note_gestore == null) {
			logisticaRichiesteImpl.setNote_gestore(StringPool.BLANK);
		}
		else {
			logisticaRichiesteImpl.setNote_gestore(note_gestore);
		}

		logisticaRichiesteImpl.setId_valutazione(id_valutazione);
		logisticaRichiesteImpl.setId_stato(id_stato);

		if (note == null) {
			logisticaRichiesteImpl.setNote(StringPool.BLANK);
		}
		else {
			logisticaRichiesteImpl.setNote(note);
		}

		logisticaRichiesteImpl.resetOriginalValues();

		return logisticaRichiesteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		oggetto = objectInput.readUTF();
		utente = objectInput.readUTF();
		dipartimento = objectInput.readUTF();
		data_richiesta = objectInput.readLong();
		dettaglio_richiedente = objectInput.readUTF();
		dettaglio_richieste = objectInput.readUTF();
		note_gestore = objectInput.readUTF();

		id_valutazione = objectInput.readLong();

		id_stato = objectInput.readLong();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (oggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(oggetto);
		}

		if (utente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente);
		}

		if (dipartimento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dipartimento);
		}

		objectOutput.writeLong(data_richiesta);

		if (dettaglio_richiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dettaglio_richiedente);
		}

		if (dettaglio_richieste == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dettaglio_richieste);
		}

		if (note_gestore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note_gestore);
		}

		objectOutput.writeLong(id_valutazione);

		objectOutput.writeLong(id_stato);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long id;
	public String oggetto;
	public String utente;
	public String dipartimento;
	public long data_richiesta;
	public String dettaglio_richiedente;
	public String dettaglio_richieste;
	public String note_gestore;
	public long id_valutazione;
	public long id_stato;
	public String note;
}