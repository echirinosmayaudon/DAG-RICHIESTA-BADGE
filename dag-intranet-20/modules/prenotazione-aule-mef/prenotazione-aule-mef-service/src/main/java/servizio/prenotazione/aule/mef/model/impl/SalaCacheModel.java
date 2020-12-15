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

import servizio.prenotazione.aule.mef.model.Sala;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Sala in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Sala
 * @generated
 */
@ProviderType
public class SalaCacheModel implements CacheModel<Sala>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SalaCacheModel)) {
			return false;
		}

		SalaCacheModel salaCacheModel = (SalaCacheModel)obj;

		if (id_sala == salaCacheModel.id_sala) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_sala);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id_sala=");
		sb.append(id_sala);
		sb.append(", desc_sala=");
		sb.append(desc_sala);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", citta=");
		sb.append(citta);
		sb.append(", cap=");
		sb.append(cap);
		sb.append(", cod_prov=");
		sb.append(cod_prov);
		sb.append(", piano=");
		sb.append(piano);
		sb.append(", stanza=");
		sb.append(stanza);
		sb.append(", posti=");
		sb.append(posti);
		sb.append(", video_conferenza=");
		sb.append(video_conferenza);
		sb.append(", proiettore=");
		sb.append(proiettore);
		sb.append(", postazione_rete=");
		sb.append(postazione_rete);
		sb.append(", autorizzazione=");
		sb.append(autorizzazione);
		sb.append(", email_ref=");
		sb.append(email_ref);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sala toEntityModel() {
		SalaImpl salaImpl = new SalaImpl();

		salaImpl.setId_sala(id_sala);

		if (desc_sala == null) {
			salaImpl.setDesc_sala(StringPool.BLANK);
		}
		else {
			salaImpl.setDesc_sala(desc_sala);
		}

		if (indirizzo == null) {
			salaImpl.setIndirizzo(StringPool.BLANK);
		}
		else {
			salaImpl.setIndirizzo(indirizzo);
		}

		if (citta == null) {
			salaImpl.setCitta(StringPool.BLANK);
		}
		else {
			salaImpl.setCitta(citta);
		}

		if (cap == null) {
			salaImpl.setCap(StringPool.BLANK);
		}
		else {
			salaImpl.setCap(cap);
		}

		if (cod_prov == null) {
			salaImpl.setCod_prov(StringPool.BLANK);
		}
		else {
			salaImpl.setCod_prov(cod_prov);
		}

		if (piano == null) {
			salaImpl.setPiano(StringPool.BLANK);
		}
		else {
			salaImpl.setPiano(piano);
		}

		if (stanza == null) {
			salaImpl.setStanza(StringPool.BLANK);
		}
		else {
			salaImpl.setStanza(stanza);
		}

		salaImpl.setPosti(posti);
		salaImpl.setVideo_conferenza(video_conferenza);
		salaImpl.setProiettore(proiettore);
		salaImpl.setPostazione_rete(postazione_rete);
		salaImpl.setAutorizzazione(autorizzazione);

		if (email_ref == null) {
			salaImpl.setEmail_ref(StringPool.BLANK);
		}
		else {
			salaImpl.setEmail_ref(email_ref);
		}

		salaImpl.resetOriginalValues();

		return salaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_sala = objectInput.readLong();
		desc_sala = objectInput.readUTF();
		indirizzo = objectInput.readUTF();
		citta = objectInput.readUTF();
		cap = objectInput.readUTF();
		cod_prov = objectInput.readUTF();
		piano = objectInput.readUTF();
		stanza = objectInput.readUTF();

		posti = objectInput.readInt();

		video_conferenza = objectInput.readBoolean();

		proiettore = objectInput.readBoolean();

		postazione_rete = objectInput.readBoolean();

		autorizzazione = objectInput.readBoolean();
		email_ref = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_sala);

		if (desc_sala == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc_sala);
		}

		if (indirizzo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indirizzo);
		}

		if (citta == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(citta);
		}

		if (cap == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cap);
		}

		if (cod_prov == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cod_prov);
		}

		if (piano == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(piano);
		}

		if (stanza == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stanza);
		}

		objectOutput.writeInt(posti);

		objectOutput.writeBoolean(video_conferenza);

		objectOutput.writeBoolean(proiettore);

		objectOutput.writeBoolean(postazione_rete);

		objectOutput.writeBoolean(autorizzazione);

		if (email_ref == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email_ref);
		}
	}

	public long id_sala;
	public String desc_sala;
	public String indirizzo;
	public String citta;
	public String cap;
	public String cod_prov;
	public String piano;
	public String stanza;
	public int posti;
	public boolean video_conferenza;
	public boolean proiettore;
	public boolean postazione_rete;
	public boolean autorizzazione;
	public String email_ref;
}