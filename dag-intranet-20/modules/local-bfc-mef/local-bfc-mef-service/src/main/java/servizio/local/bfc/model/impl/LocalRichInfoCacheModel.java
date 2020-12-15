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

import servizio.local.bfc.model.LocalRichInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LocalRichInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichInfo
 * @generated
 */
@ProviderType
public class LocalRichInfoCacheModel implements CacheModel<LocalRichInfo>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocalRichInfoCacheModel)) {
			return false;
		}

		LocalRichInfoCacheModel localRichInfoCacheModel = (LocalRichInfoCacheModel)obj;

		if (id == localRichInfoCacheModel.id) {
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
		StringBundler sb = new StringBundler(53);

		sb.append("{idStatoAttuale=");
		sb.append(idStatoAttuale);
		sb.append(", id=");
		sb.append(id);
		sb.append(", id_richiesta=");
		sb.append(id_richiesta);
		sb.append(", dataRichiesta=");
		sb.append(dataRichiesta);
		sb.append(", email=");
		sb.append(email);
		sb.append(", rifStanza=");
		sb.append(rifStanza);
		sb.append(", ispettorato=");
		sb.append(ispettorato);
		sb.append(", nomeRef=");
		sb.append(nomeRef);
		sb.append(", telRef=");
		sb.append(telRef);
		sb.append(", nMacchina=");
		sb.append(nMacchina);
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
		sb.append(", telRich=");
		sb.append(telRich);
		sb.append(", strutUff=");
		sb.append(strutUff);
		sb.append(", strutIsp=");
		sb.append(strutIsp);
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
	public LocalRichInfo toEntityModel() {
		LocalRichInfoImpl localRichInfoImpl = new LocalRichInfoImpl();

		localRichInfoImpl.setIdStatoAttuale(idStatoAttuale);
		localRichInfoImpl.setId(id);
		localRichInfoImpl.setId_richiesta(id_richiesta);

		if (dataRichiesta == Long.MIN_VALUE) {
			localRichInfoImpl.setDataRichiesta(null);
		}
		else {
			localRichInfoImpl.setDataRichiesta(new Date(dataRichiesta));
		}

		if (email == null) {
			localRichInfoImpl.setEmail(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setEmail(email);
		}

		if (rifStanza == null) {
			localRichInfoImpl.setRifStanza(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setRifStanza(rifStanza);
		}

		if (ispettorato == null) {
			localRichInfoImpl.setIspettorato(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setIspettorato(ispettorato);
		}

		if (nomeRef == null) {
			localRichInfoImpl.setNomeRef(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setNomeRef(nomeRef);
		}

		if (telRef == null) {
			localRichInfoImpl.setTelRef(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setTelRef(telRef);
		}

		if (nMacchina == null) {
			localRichInfoImpl.setNMacchina(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setNMacchina(nMacchina);
		}

		if (noteRich == null) {
			localRichInfoImpl.setNoteRich(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setNoteRich(noteRich);
		}

		if (ufficio == null) {
			localRichInfoImpl.setUfficio(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setUfficio(ufficio);
		}

		if (note == null) {
			localRichInfoImpl.setNote(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setNote(note);
		}

		localRichInfoImpl.setUidIns(uidIns);

		if (dataIns == Long.MIN_VALUE) {
			localRichInfoImpl.setDataIns(null);
		}
		else {
			localRichInfoImpl.setDataIns(new Date(dataIns));
		}

		localRichInfoImpl.setUidUpd(uidUpd);

		if (dataUpd == Long.MIN_VALUE) {
			localRichInfoImpl.setDataUpd(null);
		}
		else {
			localRichInfoImpl.setDataUpd(new Date(dataUpd));
		}

		if (oggetto == null) {
			localRichInfoImpl.setOggetto(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setOggetto(oggetto);
		}

		if (idSede == null) {
			localRichInfoImpl.setIdSede(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setIdSede(idSede);
		}

		if (telRich == null) {
			localRichInfoImpl.setTelRich(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setTelRich(telRich);
		}

		if (strutUff == null) {
			localRichInfoImpl.setStrutUff(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setStrutUff(strutUff);
		}

		if (strutIsp == null) {
			localRichInfoImpl.setStrutIsp(StringPool.BLANK);
		}
		else {
			localRichInfoImpl.setStrutIsp(strutIsp);
		}

		localRichInfoImpl.setCostoReale(costoReale);
		localRichInfoImpl.setPreventivo(preventivo);
		localRichInfoImpl.setFlagInvio(flagInvio);
		localRichInfoImpl.setInStage(inStage);

		localRichInfoImpl.resetOriginalValues();

		return localRichInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idStatoAttuale = objectInput.readLong();

		id = objectInput.readLong();

		id_richiesta = objectInput.readLong();
		dataRichiesta = objectInput.readLong();
		email = objectInput.readUTF();
		rifStanza = objectInput.readUTF();
		ispettorato = objectInput.readUTF();
		nomeRef = objectInput.readUTF();
		telRef = objectInput.readUTF();
		nMacchina = objectInput.readUTF();
		noteRich = objectInput.readUTF();
		ufficio = objectInput.readUTF();
		note = objectInput.readUTF();

		uidIns = objectInput.readLong();
		dataIns = objectInput.readLong();

		uidUpd = objectInput.readLong();
		dataUpd = objectInput.readLong();
		oggetto = objectInput.readUTF();
		idSede = objectInput.readUTF();
		telRich = objectInput.readUTF();
		strutUff = objectInput.readUTF();
		strutIsp = objectInput.readUTF();

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

		if (nomeRef == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeRef);
		}

		if (telRef == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telRef);
		}

		if (nMacchina == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nMacchina);
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

		if (telRich == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telRich);
		}

		if (strutUff == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(strutUff);
		}

		if (strutIsp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(strutIsp);
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
	public String email;
	public String rifStanza;
	public String ispettorato;
	public String nomeRef;
	public String telRef;
	public String nMacchina;
	public String noteRich;
	public String ufficio;
	public String note;
	public long uidIns;
	public long dataIns;
	public long uidUpd;
	public long dataUpd;
	public String oggetto;
	public String idSede;
	public String telRich;
	public String strutUff;
	public String strutIsp;
	public float costoReale;
	public int preventivo;
	public int flagInvio;
	public boolean inStage;
}