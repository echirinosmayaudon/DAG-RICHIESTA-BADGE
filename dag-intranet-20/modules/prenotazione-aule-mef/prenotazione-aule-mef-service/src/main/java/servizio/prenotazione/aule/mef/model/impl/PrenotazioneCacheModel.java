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

package servizio.prenotazione.aule.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.prenotazione.aule.mef.model.Prenotazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Prenotazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Prenotazione
 * @generated
 */
@ProviderType
public class PrenotazioneCacheModel implements CacheModel<Prenotazione>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PrenotazioneCacheModel)) {
			return false;
		}

		PrenotazioneCacheModel prenotazioneCacheModel = (PrenotazioneCacheModel)obj;

		if (id_prenota == prenotazioneCacheModel.id_prenota) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_prenota);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id_prenota=");
		sb.append(id_prenota);
		sb.append(", id_sala=");
		sb.append(id_sala);
		sb.append(", cod_fiscale=");
		sb.append(cod_fiscale);
		sb.append(", data_prenota=");
		sb.append(data_prenota);
		sb.append(", data_inizio=");
		sb.append(data_inizio);
		sb.append(", data_fine=");
		sb.append(data_fine);
		sb.append(", partecipanti=");
		sb.append(partecipanti);
		sb.append(", id_evento=");
		sb.append(id_evento);
		sb.append(", attivita=");
		sb.append(attivita);
		sb.append(", note=");
		sb.append(note);
		sb.append(", id_stato=");
		sb.append(id_stato);
		sb.append(", dati_rich=");
		sb.append(dati_rich);
		sb.append(", servizi=");
		sb.append(servizi);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Prenotazione toEntityModel() {
		PrenotazioneImpl prenotazioneImpl = new PrenotazioneImpl();

		prenotazioneImpl.setId_prenota(id_prenota);
		prenotazioneImpl.setId_sala(id_sala);

		if (cod_fiscale == null) {
			prenotazioneImpl.setCod_fiscale(StringPool.BLANK);
		}
		else {
			prenotazioneImpl.setCod_fiscale(cod_fiscale);
		}

		if (data_prenota == Long.MIN_VALUE) {
			prenotazioneImpl.setData_prenota(null);
		}
		else {
			prenotazioneImpl.setData_prenota(new Date(data_prenota));
		}

		if (data_inizio == Long.MIN_VALUE) {
			prenotazioneImpl.setData_inizio(null);
		}
		else {
			prenotazioneImpl.setData_inizio(new Date(data_inizio));
		}

		if (data_fine == Long.MIN_VALUE) {
			prenotazioneImpl.setData_fine(null);
		}
		else {
			prenotazioneImpl.setData_fine(new Date(data_fine));
		}

		prenotazioneImpl.setPartecipanti(partecipanti);
		prenotazioneImpl.setId_evento(id_evento);

		if (attivita == null) {
			prenotazioneImpl.setAttivita(StringPool.BLANK);
		}
		else {
			prenotazioneImpl.setAttivita(attivita);
		}

		if (note == null) {
			prenotazioneImpl.setNote(StringPool.BLANK);
		}
		else {
			prenotazioneImpl.setNote(note);
		}

		prenotazioneImpl.setId_stato(id_stato);

		if (dati_rich == null) {
			prenotazioneImpl.setDati_rich(StringPool.BLANK);
		}
		else {
			prenotazioneImpl.setDati_rich(dati_rich);
		}

		if (servizi == null) {
			prenotazioneImpl.setServizi(StringPool.BLANK);
		}
		else {
			prenotazioneImpl.setServizi(servizi);
		}

		prenotazioneImpl.resetOriginalValues();

		return prenotazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_prenota = objectInput.readLong();

		id_sala = objectInput.readLong();
		cod_fiscale = objectInput.readUTF();
		data_prenota = objectInput.readLong();
		data_inizio = objectInput.readLong();
		data_fine = objectInput.readLong();

		partecipanti = objectInput.readInt();

		id_evento = objectInput.readLong();
		attivita = objectInput.readUTF();
		note = objectInput.readUTF();

		id_stato = objectInput.readLong();
		dati_rich = objectInput.readUTF();
		servizi = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_prenota);

		objectOutput.writeLong(id_sala);

		if (cod_fiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cod_fiscale);
		}

		objectOutput.writeLong(data_prenota);
		objectOutput.writeLong(data_inizio);
		objectOutput.writeLong(data_fine);

		objectOutput.writeInt(partecipanti);

		objectOutput.writeLong(id_evento);

		if (attivita == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attivita);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(id_stato);

		if (dati_rich == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dati_rich);
		}

		if (servizi == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(servizi);
		}
	}

	public long id_prenota;
	public long id_sala;
	public String cod_fiscale;
	public long data_prenota;
	public long data_inizio;
	public long data_fine;
	public int partecipanti;
	public long id_evento;
	public String attivita;
	public String note;
	public long id_stato;
	public String dati_rich;
	public String servizi;
}