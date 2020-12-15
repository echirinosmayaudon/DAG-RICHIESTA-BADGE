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

import external.bfc.intranet.mef.model.RichiesteInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichiesteInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteInfo
 * @generated
 */
@ProviderType
public class RichiesteInfoCacheModel implements CacheModel<RichiesteInfo>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteInfoCacheModel)) {
			return false;
		}

		RichiesteInfoCacheModel richiesteInfoCacheModel = (RichiesteInfoCacheModel)obj;

		if (id == richiesteInfoCacheModel.id) {
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
		StringBundler sb = new StringBundler(49);

		sb.append("{idStatoAttuale=");
		sb.append(idStatoAttuale);
		sb.append(", id=");
		sb.append(id);
		sb.append(", dataRichiesta=");
		sb.append(dataRichiesta);
		sb.append(", email=");
		sb.append(email);
		sb.append(", riferimentoStanza=");
		sb.append(riferimentoStanza);
		sb.append(", ispettorato=");
		sb.append(ispettorato);
		sb.append(", nomeReferente=");
		sb.append(nomeReferente);
		sb.append(", telefonoReferente=");
		sb.append(telefonoReferente);
		sb.append(", nMacchina=");
		sb.append(nMacchina);
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
		sb.append(", telRichiedente=");
		sb.append(telRichiedente);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiesteInfo toEntityModel() {
		RichiesteInfoImpl richiesteInfoImpl = new RichiesteInfoImpl();

		richiesteInfoImpl.setIdStatoAttuale(idStatoAttuale);
		richiesteInfoImpl.setId(id);

		if (dataRichiesta == Long.MIN_VALUE) {
			richiesteInfoImpl.setDataRichiesta(null);
		}
		else {
			richiesteInfoImpl.setDataRichiesta(new Date(dataRichiesta));
		}

		if (email == null) {
			richiesteInfoImpl.setEmail(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setEmail(email);
		}

		if (riferimentoStanza == null) {
			richiesteInfoImpl.setRiferimentoStanza(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setRiferimentoStanza(riferimentoStanza);
		}

		if (ispettorato == null) {
			richiesteInfoImpl.setIspettorato(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setIspettorato(ispettorato);
		}

		if (nomeReferente == null) {
			richiesteInfoImpl.setNomeReferente(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setNomeReferente(nomeReferente);
		}

		if (telefonoReferente == null) {
			richiesteInfoImpl.setTelefonoReferente(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setTelefonoReferente(telefonoReferente);
		}

		if (nMacchina == null) {
			richiesteInfoImpl.setNMacchina(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setNMacchina(nMacchina);
		}

		if (noteRichiedente == null) {
			richiesteInfoImpl.setNoteRichiedente(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setNoteRichiedente(noteRichiedente);
		}

		if (ufficio == null) {
			richiesteInfoImpl.setUfficio(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setUfficio(ufficio);
		}

		if (note == null) {
			richiesteInfoImpl.setNote(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setNote(note);
		}

		richiesteInfoImpl.setUidIns(uidIns);

		if (dataIns == Long.MIN_VALUE) {
			richiesteInfoImpl.setDataIns(null);
		}
		else {
			richiesteInfoImpl.setDataIns(new Date(dataIns));
		}

		richiesteInfoImpl.setUidUpd(uidUpd);

		if (dataUpd == Long.MIN_VALUE) {
			richiesteInfoImpl.setDataUpd(null);
		}
		else {
			richiesteInfoImpl.setDataUpd(new Date(dataUpd));
		}

		if (oggetto == null) {
			richiesteInfoImpl.setOggetto(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setOggetto(oggetto);
		}

		if (idSede == null) {
			richiesteInfoImpl.setIdSede(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setIdSede(idSede);
		}

		if (telRichiedente == null) {
			richiesteInfoImpl.setTelRichiedente(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setTelRichiedente(telRichiedente);
		}

		if (strutUff == null) {
			richiesteInfoImpl.setStrutUff(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setStrutUff(strutUff);
		}

		if (strutIsp == null) {
			richiesteInfoImpl.setStrutIsp(StringPool.BLANK);
		}
		else {
			richiesteInfoImpl.setStrutIsp(strutIsp);
		}

		richiesteInfoImpl.setCostoReale(costoReale);
		richiesteInfoImpl.setPreventivo(preventivo);
		richiesteInfoImpl.setFlagInvio(flagInvio);

		richiesteInfoImpl.resetOriginalValues();

		return richiesteInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idStatoAttuale = objectInput.readLong();

		id = objectInput.readLong();
		dataRichiesta = objectInput.readLong();
		email = objectInput.readUTF();
		riferimentoStanza = objectInput.readUTF();
		ispettorato = objectInput.readUTF();
		nomeReferente = objectInput.readUTF();
		telefonoReferente = objectInput.readUTF();
		nMacchina = objectInput.readUTF();
		noteRichiedente = objectInput.readUTF();
		ufficio = objectInput.readUTF();
		note = objectInput.readUTF();

		uidIns = objectInput.readLong();
		dataIns = objectInput.readLong();

		uidUpd = objectInput.readLong();
		dataUpd = objectInput.readLong();
		oggetto = objectInput.readUTF();
		idSede = objectInput.readUTF();
		telRichiedente = objectInput.readUTF();
		strutUff = objectInput.readUTF();
		strutIsp = objectInput.readUTF();

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

		if (nomeReferente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeReferente);
		}

		if (telefonoReferente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefonoReferente);
		}

		if (nMacchina == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nMacchina);
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

		if (telRichiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telRichiedente);
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
	}

	public long idStatoAttuale;
	public long id;
	public long dataRichiesta;
	public String email;
	public String riferimentoStanza;
	public String ispettorato;
	public String nomeReferente;
	public String telefonoReferente;
	public String nMacchina;
	public String noteRichiedente;
	public String ufficio;
	public String note;
	public long uidIns;
	public long dataIns;
	public long uidUpd;
	public long dataUpd;
	public String oggetto;
	public String idSede;
	public String telRichiedente;
	public String strutUff;
	public String strutIsp;
	public float costoReale;
	public int preventivo;
	public int flagInvio;
}