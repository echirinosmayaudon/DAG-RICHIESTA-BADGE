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

package servizio.local.bfc.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.local.bfc.model.LocalRich;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LocalRich in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LocalRich
 * @generated
 */
@ProviderType
public class LocalRichCacheModel implements CacheModel<LocalRich>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocalRichCacheModel)) {
			return false;
		}

		LocalRichCacheModel localRichCacheModel = (LocalRichCacheModel)obj;

		if (id == localRichCacheModel.id) {
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
		StringBundler sb = new StringBundler(51);

		sb.append("{idStatoAttuale=");
		sb.append(idStatoAttuale);
		sb.append(", id=");
		sb.append(id);
		sb.append(", id_richiesta=");
		sb.append(id_richiesta);
		sb.append(", dataRichiesta=");
		sb.append(dataRichiesta);
		sb.append(", idPeriodicita=");
		sb.append(idPeriodicita);
		sb.append(", email=");
		sb.append(email);
		sb.append(", rifStanza=");
		sb.append(rifStanza);
		sb.append(", ispettorato=");
		sb.append(ispettorato);
		sb.append(", noteRich=");
		sb.append(noteRich);
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
		sb.append(", telRich=");
		sb.append(telRich);
		sb.append(", costoReale=");
		sb.append(costoReale);
		sb.append(", preventivo=");
		sb.append(preventivo);
		sb.append(", flagInvio=");
		sb.append(flagInvio);
		sb.append(", inStage=");
		sb.append(inStage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LocalRich toEntityModel() {
		LocalRichImpl localRichImpl = new LocalRichImpl();

		localRichImpl.setIdStatoAttuale(idStatoAttuale);
		localRichImpl.setId(id);
		localRichImpl.setId_richiesta(id_richiesta);

		if (dataRichiesta == Long.MIN_VALUE) {
			localRichImpl.setDataRichiesta(null);
		}
		else {
			localRichImpl.setDataRichiesta(new Date(dataRichiesta));
		}

		localRichImpl.setIdPeriodicita(idPeriodicita);

		if (email == null) {
			localRichImpl.setEmail(StringPool.BLANK);
		}
		else {
			localRichImpl.setEmail(email);
		}

		if (rifStanza == null) {
			localRichImpl.setRifStanza(StringPool.BLANK);
		}
		else {
			localRichImpl.setRifStanza(rifStanza);
		}

		if (ispettorato == null) {
			localRichImpl.setIspettorato(StringPool.BLANK);
		}
		else {
			localRichImpl.setIspettorato(ispettorato);
		}

		if (noteRich == null) {
			localRichImpl.setNoteRich(StringPool.BLANK);
		}
		else {
			localRichImpl.setNoteRich(noteRich);
		}

		if (ufficio == null) {
			localRichImpl.setUfficio(StringPool.BLANK);
		}
		else {
			localRichImpl.setUfficio(ufficio);
		}

		if (note == null) {
			localRichImpl.setNote(StringPool.BLANK);
		}
		else {
			localRichImpl.setNote(note);
		}

		localRichImpl.setUidIns(uidIns);

		if (dataIns == Long.MIN_VALUE) {
			localRichImpl.setDataIns(null);
		}
		else {
			localRichImpl.setDataIns(new Date(dataIns));
		}

		localRichImpl.setUidUpd(uidUpd);

		if (dataUpd == Long.MIN_VALUE) {
			localRichImpl.setDataUpd(null);
		}
		else {
			localRichImpl.setDataUpd(new Date(dataUpd));
		}

		if (oggetto == null) {
			localRichImpl.setOggetto(StringPool.BLANK);
		}
		else {
			localRichImpl.setOggetto(oggetto);
		}

		if (idSede == null) {
			localRichImpl.setIdSede(StringPool.BLANK);
		}
		else {
			localRichImpl.setIdSede(idSede);
		}

		if (strutIsp == null) {
			localRichImpl.setStrutIsp(StringPool.BLANK);
		}
		else {
			localRichImpl.setStrutIsp(strutIsp);
		}

		if (strutUff == null) {
			localRichImpl.setStrutUff(StringPool.BLANK);
		}
		else {
			localRichImpl.setStrutUff(strutUff);
		}

		if (strutIsp2 == null) {
			localRichImpl.setStrutIsp2(StringPool.BLANK);
		}
		else {
			localRichImpl.setStrutIsp2(strutIsp2);
		}

		if (telRich == null) {
			localRichImpl.setTelRich(StringPool.BLANK);
		}
		else {
			localRichImpl.setTelRich(telRich);
		}

		localRichImpl.setCostoReale(costoReale);
		localRichImpl.setPreventivo(preventivo);
		localRichImpl.setFlagInvio(flagInvio);
		localRichImpl.setInStage(inStage);

		localRichImpl.resetOriginalValues();

		return localRichImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idStatoAttuale = objectInput.readLong();

		id = objectInput.readLong();

		id_richiesta = objectInput.readLong();
		dataRichiesta = objectInput.readLong();

		idPeriodicita = objectInput.readLong();
		email = objectInput.readUTF();
		rifStanza = objectInput.readUTF();
		ispettorato = objectInput.readUTF();
		noteRich = objectInput.readUTF();
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
		telRich = objectInput.readUTF();

		costoReale = objectInput.readFloat();

		preventivo = objectInput.readInt();

		flagInvio = objectInput.readInt();

		inStage = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idStatoAttuale);

		objectOutput.writeLong(id);

		objectOutput.writeLong(id_richiesta);
		objectOutput.writeLong(dataRichiesta);

		objectOutput.writeLong(idPeriodicita);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (rifStanza == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rifStanza);
		}

		if (ispettorato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ispettorato);
		}

		if (noteRich == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noteRich);
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

		if (telRich == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telRich);
		}

		objectOutput.writeFloat(costoReale);

		objectOutput.writeInt(preventivo);

		objectOutput.writeInt(flagInvio);

		objectOutput.writeBoolean(inStage);
	}

	public long idStatoAttuale;
	public long id;
	public long id_richiesta;
	public long dataRichiesta;
	public long idPeriodicita;
	public String email;
	public String rifStanza;
	public String ispettorato;
	public String noteRich;
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
	public String telRich;
	public float costoReale;
	public int preventivo;
	public int flagInvio;
	public boolean inStage;
}