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

package servizio.richieste.badge.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.richieste.badge.mef.model.RichiestaBadge;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichiestaBadge in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadge
 * @generated
 */
@ProviderType
public class RichiestaBadgeCacheModel implements CacheModel<RichiestaBadge>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaBadgeCacheModel)) {
			return false;
		}

		RichiestaBadgeCacheModel richiestaBadgeCacheModel = (RichiestaBadgeCacheModel)obj;

		if (id_pk == richiestaBadgeCacheModel.id_pk) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_pk);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{id_pk=");
		sb.append(id_pk);
		sb.append(", id_richiesta=");
		sb.append(id_richiesta);
		sb.append(", screename_richiedente=");
		sb.append(screename_richiedente);
		sb.append(", id_ufficio=");
		sb.append(id_ufficio);
		sb.append(", id_sedesiap=");
		sb.append(id_sedesiap);
		sb.append(", json_richiedente=");
		sb.append(json_richiedente);
		sb.append(", is_internal=");
		sb.append(is_internal);
		sb.append(", nome_intestatario=");
		sb.append(nome_intestatario);
		sb.append(", cognome_intestatario=");
		sb.append(cognome_intestatario);
		sb.append(", cf_intestatario=");
		sb.append(cf_intestatario);
		sb.append(", luogonascita_intestatario=");
		sb.append(luogonascita_intestatario);
		sb.append(", datanascita_intestatario=");
		sb.append(datanascita_intestatario);
		sb.append(", id_oggetto=");
		sb.append(id_oggetto);
		sb.append(", numero_badge=");
		sb.append(numero_badge);
		sb.append(", uuid_foto=");
		sb.append(uuid_foto);
		sb.append(", uuid_modulosostituzione=");
		sb.append(uuid_modulosostituzione);
		sb.append(", societa=");
		sb.append(societa);
		sb.append(", referente_societa=");
		sb.append(referente_societa);
		sb.append(", progetto=");
		sb.append(progetto);
		sb.append(", json_richiesta_external=");
		sb.append(json_richiesta_external);
		sb.append(", array_sedi_abilitate=");
		sb.append(array_sedi_abilitate);
		sb.append(", motivazione=");
		sb.append(motivazione);
		sb.append(", data_scadenza=");
		sb.append(data_scadenza);
		sb.append(", uuid_modulopdf=");
		sb.append(uuid_modulopdf);
		sb.append(", data_richiesta=");
		sb.append(data_richiesta);
		sb.append(", data_modifica=");
		sb.append(data_modifica);
		sb.append(", id_stato=");
		sb.append(id_stato);
		sb.append(", utente_cambio_stato=");
		sb.append(utente_cambio_stato);
		sb.append(", note=");
		sb.append(note);
		sb.append(", is_last=");
		sb.append(is_last);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiestaBadge toEntityModel() {
		RichiestaBadgeImpl richiestaBadgeImpl = new RichiestaBadgeImpl();

		richiestaBadgeImpl.setId_pk(id_pk);
		richiestaBadgeImpl.setId_richiesta(id_richiesta);

		if (screename_richiedente == null) {
			richiestaBadgeImpl.setScreename_richiedente(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setScreename_richiedente(screename_richiedente);
		}

		richiestaBadgeImpl.setId_ufficio(id_ufficio);
		richiestaBadgeImpl.setId_sedesiap(id_sedesiap);

		if (json_richiedente == null) {
			richiestaBadgeImpl.setJson_richiedente(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setJson_richiedente(json_richiedente);
		}

		richiestaBadgeImpl.setIs_internal(is_internal);

		if (nome_intestatario == null) {
			richiestaBadgeImpl.setNome_intestatario(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setNome_intestatario(nome_intestatario);
		}

		if (cognome_intestatario == null) {
			richiestaBadgeImpl.setCognome_intestatario(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setCognome_intestatario(cognome_intestatario);
		}

		if (cf_intestatario == null) {
			richiestaBadgeImpl.setCf_intestatario(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setCf_intestatario(cf_intestatario);
		}

		if (luogonascita_intestatario == null) {
			richiestaBadgeImpl.setLuogonascita_intestatario(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setLuogonascita_intestatario(luogonascita_intestatario);
		}

		if (datanascita_intestatario == Long.MIN_VALUE) {
			richiestaBadgeImpl.setDatanascita_intestatario(null);
		}
		else {
			richiestaBadgeImpl.setDatanascita_intestatario(new Date(
					datanascita_intestatario));
		}

		richiestaBadgeImpl.setId_oggetto(id_oggetto);

		if (numero_badge == null) {
			richiestaBadgeImpl.setNumero_badge(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setNumero_badge(numero_badge);
		}

		if (uuid_foto == null) {
			richiestaBadgeImpl.setUuid_foto(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setUuid_foto(uuid_foto);
		}

		if (uuid_modulosostituzione == null) {
			richiestaBadgeImpl.setUuid_modulosostituzione(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setUuid_modulosostituzione(uuid_modulosostituzione);
		}

		if (societa == null) {
			richiestaBadgeImpl.setSocieta(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setSocieta(societa);
		}

		if (referente_societa == null) {
			richiestaBadgeImpl.setReferente_societa(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setReferente_societa(referente_societa);
		}

		if (progetto == null) {
			richiestaBadgeImpl.setProgetto(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setProgetto(progetto);
		}

		if (json_richiesta_external == null) {
			richiestaBadgeImpl.setJson_richiesta_external(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setJson_richiesta_external(json_richiesta_external);
		}

		if (array_sedi_abilitate == null) {
			richiestaBadgeImpl.setArray_sedi_abilitate(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setArray_sedi_abilitate(array_sedi_abilitate);
		}

		if (motivazione == null) {
			richiestaBadgeImpl.setMotivazione(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setMotivazione(motivazione);
		}

		if (data_scadenza == Long.MIN_VALUE) {
			richiestaBadgeImpl.setData_scadenza(null);
		}
		else {
			richiestaBadgeImpl.setData_scadenza(new Date(data_scadenza));
		}

		if (uuid_modulopdf == null) {
			richiestaBadgeImpl.setUuid_modulopdf(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setUuid_modulopdf(uuid_modulopdf);
		}

		if (data_richiesta == Long.MIN_VALUE) {
			richiestaBadgeImpl.setData_richiesta(null);
		}
		else {
			richiestaBadgeImpl.setData_richiesta(new Date(data_richiesta));
		}

		if (data_modifica == Long.MIN_VALUE) {
			richiestaBadgeImpl.setData_modifica(null);
		}
		else {
			richiestaBadgeImpl.setData_modifica(new Date(data_modifica));
		}

		richiestaBadgeImpl.setId_stato(id_stato);

		if (utente_cambio_stato == null) {
			richiestaBadgeImpl.setUtente_cambio_stato(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setUtente_cambio_stato(utente_cambio_stato);
		}

		if (note == null) {
			richiestaBadgeImpl.setNote(StringPool.BLANK);
		}
		else {
			richiestaBadgeImpl.setNote(note);
		}

		richiestaBadgeImpl.setIs_last(is_last);

		richiestaBadgeImpl.resetOriginalValues();

		return richiestaBadgeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_pk = objectInput.readLong();

		id_richiesta = objectInput.readLong();
		screename_richiedente = objectInput.readUTF();

		id_ufficio = objectInput.readLong();

		id_sedesiap = objectInput.readLong();
		json_richiedente = objectInput.readUTF();

		is_internal = objectInput.readBoolean();
		nome_intestatario = objectInput.readUTF();
		cognome_intestatario = objectInput.readUTF();
		cf_intestatario = objectInput.readUTF();
		luogonascita_intestatario = objectInput.readUTF();
		datanascita_intestatario = objectInput.readLong();

		id_oggetto = objectInput.readLong();
		numero_badge = objectInput.readUTF();
		uuid_foto = objectInput.readUTF();
		uuid_modulosostituzione = objectInput.readUTF();
		societa = objectInput.readUTF();
		referente_societa = objectInput.readUTF();
		progetto = objectInput.readUTF();
		json_richiesta_external = objectInput.readUTF();
		array_sedi_abilitate = objectInput.readUTF();
		motivazione = objectInput.readUTF();
		data_scadenza = objectInput.readLong();
		uuid_modulopdf = objectInput.readUTF();
		data_richiesta = objectInput.readLong();
		data_modifica = objectInput.readLong();

		id_stato = objectInput.readLong();
		utente_cambio_stato = objectInput.readUTF();
		note = objectInput.readUTF();

		is_last = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_pk);

		objectOutput.writeLong(id_richiesta);

		if (screename_richiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screename_richiedente);
		}

		objectOutput.writeLong(id_ufficio);

		objectOutput.writeLong(id_sedesiap);

		if (json_richiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(json_richiedente);
		}

		objectOutput.writeBoolean(is_internal);

		if (nome_intestatario == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome_intestatario);
		}

		if (cognome_intestatario == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cognome_intestatario);
		}

		if (cf_intestatario == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cf_intestatario);
		}

		if (luogonascita_intestatario == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(luogonascita_intestatario);
		}

		objectOutput.writeLong(datanascita_intestatario);

		objectOutput.writeLong(id_oggetto);

		if (numero_badge == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(numero_badge);
		}

		if (uuid_foto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid_foto);
		}

		if (uuid_modulosostituzione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid_modulosostituzione);
		}

		if (societa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(societa);
		}

		if (referente_societa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(referente_societa);
		}

		if (progetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(progetto);
		}

		if (json_richiesta_external == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(json_richiesta_external);
		}

		if (array_sedi_abilitate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(array_sedi_abilitate);
		}

		if (motivazione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(motivazione);
		}

		objectOutput.writeLong(data_scadenza);

		if (uuid_modulopdf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid_modulopdf);
		}

		objectOutput.writeLong(data_richiesta);
		objectOutput.writeLong(data_modifica);

		objectOutput.writeLong(id_stato);

		if (utente_cambio_stato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente_cambio_stato);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeBoolean(is_last);
	}

	public long id_pk;
	public long id_richiesta;
	public String screename_richiedente;
	public long id_ufficio;
	public long id_sedesiap;
	public String json_richiedente;
	public boolean is_internal;
	public String nome_intestatario;
	public String cognome_intestatario;
	public String cf_intestatario;
	public String luogonascita_intestatario;
	public long datanascita_intestatario;
	public long id_oggetto;
	public String numero_badge;
	public String uuid_foto;
	public String uuid_modulosostituzione;
	public String societa;
	public String referente_societa;
	public String progetto;
	public String json_richiesta_external;
	public String array_sedi_abilitate;
	public String motivazione;
	public long data_scadenza;
	public String uuid_modulopdf;
	public long data_richiesta;
	public long data_modifica;
	public long id_stato;
	public String utente_cambio_stato;
	public String note;
	public boolean is_last;
}