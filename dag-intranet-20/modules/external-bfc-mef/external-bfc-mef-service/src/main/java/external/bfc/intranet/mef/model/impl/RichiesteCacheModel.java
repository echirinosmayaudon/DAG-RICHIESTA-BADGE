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

package external.bfc.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import external.bfc.intranet.mef.model.Richieste;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Richieste in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Richieste
 * @generated
 */
@ProviderType
public class RichiesteCacheModel implements CacheModel<Richieste>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteCacheModel)) {
			return false;
		}

		RichiesteCacheModel richiesteCacheModel = (RichiesteCacheModel)obj;

		if (id == richiesteCacheModel.id) {
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
		StringBundler sb = new StringBundler(47);

		sb.append("{idStatoAttuale=");
		sb.append(idStatoAttuale);
		sb.append(", id=");
		sb.append(id);
		sb.append(", dataRichiesta=");
		sb.append(dataRichiesta);
		sb.append(", idPeriodicita=");
		sb.append(idPeriodicita);
		sb.append(", email=");
		sb.append(email);
		sb.append(", riferimentoStanza=");
		sb.append(riferimentoStanza);
		sb.append(", ispettorato=");
		sb.append(ispettorato);
		sb.append(", noteRichiedente=");
		sb.append(noteRichiedente);
		sb.append(", ufficio=");
		sb.append(ufficio);
		sb.append(", note=");
		sb.append(note);
		sb.append(", uidIns=");
		sb.append(uidIns);
		sb.append(", dataIns=");
		sb.append(dataIns);
		sb.append(", uidUpd=");
		sb.append(uidUpd);
		sb.append(", dataUpd=");
		sb.append(dataUpd);
		sb.append(", oggetto=");
		sb.append(oggetto);
		sb.append(", idSede=");
		sb.append(idSede);
		sb.append(", strutIsp=");
		sb.append(strutIsp);
		sb.append(", strutUff=");
		sb.append(strutUff);
		sb.append(", strutIsp2=");
		sb.append(strutIsp2);
		sb.append(", telRichiedente=");
		sb.append(telRichiedente);
		sb.append(", costoReale=");
		sb.append(costoReale);
		sb.append(", preventivo=");
		sb.append(preventivo);
		sb.append(", flagInvio=");
		sb.append(flagInvio);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Richieste toEntityModel() {
		RichiesteImpl richiesteImpl = new RichiesteImpl();

		richiesteImpl.setIdStatoAttuale(idStatoAttuale);
		richiesteImpl.setId(id);

		if (dataRichiesta == Long.MIN_VALUE) {
			richiesteImpl.setDataRichiesta(null);
		}
		else {
			richiesteImpl.setDataRichiesta(new Date(dataRichiesta));
		}

		richiesteImpl.setIdPeriodicita(idPeriodicita);

		if (email == null) {
			richiesteImpl.setEmail(StringPool.BLANK);
		}
		else {
			richiesteImpl.setEmail(email);
		}

		if (riferimentoStanza == null) {
			richiesteImpl.setRiferimentoStanza(StringPool.BLANK);
		}
		else {
			richiesteImpl.setRiferimentoStanza(riferimentoStanza);
		}

		if (ispettorato == null) {
			richiesteImpl.setIspettorato(StringPool.BLANK);
		}
		else {
			richiesteImpl.setIspettorato(ispettorato);
		}

		if (noteRichiedente == null) {
			richiesteImpl.setNoteRichiedente(StringPool.BLANK);
		}
		else {
			richiesteImpl.setNoteRichiedente(noteRichiedente);
		}

		if (ufficio == null) {
			richiesteImpl.setUfficio(StringPool.BLANK);
		}
		else {
			richiesteImpl.setUfficio(ufficio);
		}

		if (note == null) {
			richiesteImpl.setNote(StringPool.BLANK);
		}
		else {
			richiesteImpl.setNote(note);
		}

		richiesteImpl.setUidIns(uidIns);

		if (dataIns == Long.MIN_VALUE) {
			richiesteImpl.setDataIns(null);
		}
		else {
			richiesteImpl.setDataIns(new Date(dataIns));
		}

		richiesteImpl.setUidUpd(uidUpd);

		if (dataUpd == Long.MIN_VALUE) {
			richiesteImpl.setDataUpd(null);
		}
		else {
			richiesteImpl.setDataUpd(new Date(dataUpd));
		}

		if (oggetto == null) {
			richiesteImpl.setOggetto(StringPool.BLANK);
		}
		else {
			richiesteImpl.setOggetto(oggetto);
		}

		if (idSede == null) {
			richiesteImpl.setIdSede(StringPool.BLANK);
		}
		else {
			richiesteImpl.setIdSede(idSede);
		}

		if (strutIsp == null) {
			richiesteImpl.setStrutIsp(StringPool.BLANK);
		}
		else {
			richiesteImpl.setStrutIsp(strutIsp);
		}

		if (strutUff == null) {
			richiesteImpl.setStrutUff(StringPool.BLANK);
		}
		else {
			richiesteImpl.setStrutUff(strutUff);
		}

		if (strutIsp2 == null) {
			richiesteImpl.setStrutIsp2(StringPool.BLANK);
		}
		else {
			richiesteImpl.setStrutIsp2(strutIsp2);
		}

		if (telRichiedente == null) {
			richiesteImpl.setTelRichiedente(StringPool.BLANK);
		}
		else {
			richiesteImpl.setTelRichiedente(telRichiedente);
		}

		richiesteImpl.setCostoReale(costoReale);
		richiesteImpl.setPreventivo(preventivo);
		richiesteImpl.setFlagInvio(flagInvio);

		richiesteImpl.resetOriginalValues();

		return richiesteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idStatoAttuale = objectInput.readLong();

		id = objectInput.readLong();
		dataRichiesta = objectInput.readLong();

		idPeriodicita = objectInput.readLong();
		email = objectInput.readUTF();
		riferimentoStanza = objectInput.readUTF();
		ispettorato = objectInput.readUTF();
		noteRichiedente = objectInput.readUTF();
		ufficio = objectInput.readUTF();
		note = objectInput.readUTF();

		uidIns = objectInput.readLong();
		dataIns = objectInput.readLong();

		uidUpd = objectInput.readLong();
		dataUpd = objectInput.readLong();
		oggetto = objectInput.readUTF();
		idSede = objectInput.readUTF();
		strutIsp = objectInput.readUTF();
		strutUff = objectInput.readUTF();
		strutIsp2 = objectInput.readUTF();
		telRichiedente = objectInput.readUTF();

		costoReale = objectInput.readFloat();

		preventivo = objectInput.readInt();

		flagInvio = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idStatoAttuale);

		objectOutput.writeLong(id);
		objectOutput.writeLong(dataRichiesta);

		objectOutput.writeLong(idPeriodicita);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (riferimentoStanza == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(riferimentoStanza);
		}

		if (ispettorato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ispettorato);
		}

		if (noteRichiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noteRichiedente);
		}

		if (ufficio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ufficio);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(uidIns);
		objectOutput.writeLong(dataIns);

		objectOutput.writeLong(uidUpd);
		objectOutput.writeLong(dataUpd);

		if (oggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(oggetto);
		}

		if (idSede == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idSede);
		}

		if (strutIsp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(strutIsp);
		}

		if (strutUff == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(strutUff);
		}

		if (strutIsp2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(strutIsp2);
		}

		if (telRichiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telRichiedente);
		}

		objectOutput.writeFloat(costoReale);

		objectOutput.writeInt(preventivo);

		objectOutput.writeInt(flagInvio);
	}

	public long idStatoAttuale;
	public long id;
	public long dataRichiesta;
	public long idPeriodicita;
	public String email;
	public String riferimentoStanza;
	public String ispettorato;
	public String noteRichiedente;
	public String ufficio;
	public String note;
	public long uidIns;
	public long dataIns;
	public long uidUpd;
	public long dataUpd;
	public String oggetto;
	public String idSede;
	public String strutIsp;
	public String strutUff;
	public String strutIsp2;
	public String telRichiedente;
	public float costoReale;
	public int preventivo;
	public int flagInvio;
}