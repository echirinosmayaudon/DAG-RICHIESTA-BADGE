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

package servizio.whistleblowing.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.whistleblowing.mef.model.Segnalazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Segnalazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Segnalazione
 * @generated
 */
@ProviderType
public class SegnalazioneCacheModel implements CacheModel<Segnalazione>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegnalazioneCacheModel)) {
			return false;
		}

		SegnalazioneCacheModel segnalazioneCacheModel = (SegnalazioneCacheModel)obj;

		if (id_segnalazione == segnalazioneCacheModel.id_segnalazione) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_segnalazione);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id_segnalazione=");
		sb.append(id_segnalazione);
		sb.append(", json_dati_personali=");
		sb.append(json_dati_personali);
		sb.append(", luogo=");
		sb.append(luogo);
		sb.append(", azioni_omissioni=");
		sb.append(azioni_omissioni);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", autore=");
		sb.append(autore);
		sb.append(", altri_testimoni=");
		sb.append(altri_testimoni);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Segnalazione toEntityModel() {
		SegnalazioneImpl segnalazioneImpl = new SegnalazioneImpl();

		segnalazioneImpl.setId_segnalazione(id_segnalazione);

		if (json_dati_personali == null) {
			segnalazioneImpl.setJson_dati_personali(StringPool.BLANK);
		}
		else {
			segnalazioneImpl.setJson_dati_personali(json_dati_personali);
		}

		if (luogo == null) {
			segnalazioneImpl.setLuogo(StringPool.BLANK);
		}
		else {
			segnalazioneImpl.setLuogo(luogo);
		}

		if (azioni_omissioni == null) {
			segnalazioneImpl.setAzioni_omissioni(StringPool.BLANK);
		}
		else {
			segnalazioneImpl.setAzioni_omissioni(azioni_omissioni);
		}

		if (descrizione == null) {
			segnalazioneImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			segnalazioneImpl.setDescrizione(descrizione);
		}

		if (autore == null) {
			segnalazioneImpl.setAutore(StringPool.BLANK);
		}
		else {
			segnalazioneImpl.setAutore(autore);
		}

		if (altri_testimoni == null) {
			segnalazioneImpl.setAltri_testimoni(StringPool.BLANK);
		}
		else {
			segnalazioneImpl.setAltri_testimoni(altri_testimoni);
		}

		segnalazioneImpl.resetOriginalValues();

		return segnalazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_segnalazione = objectInput.readLong();
		json_dati_personali = objectInput.readUTF();
		luogo = objectInput.readUTF();
		azioni_omissioni = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		autore = objectInput.readUTF();
		altri_testimoni = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_segnalazione);

		if (json_dati_personali == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(json_dati_personali);
		}

		if (luogo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(luogo);
		}

		if (azioni_omissioni == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(azioni_omissioni);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (autore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(autore);
		}

		if (altri_testimoni == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(altri_testimoni);
		}
	}

	public long id_segnalazione;
	public String json_dati_personali;
	public String luogo;
	public String azioni_omissioni;
	public String descrizione;
	public String autore;
	public String altri_testimoni;
}