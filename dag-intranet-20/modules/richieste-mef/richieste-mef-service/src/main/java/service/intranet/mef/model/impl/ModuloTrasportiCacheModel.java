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

import service.intranet.mef.model.ModuloTrasporti;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ModuloTrasporti in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ModuloTrasporti
 * @generated
 */
@ProviderType
public class ModuloTrasportiCacheModel implements CacheModel<ModuloTrasporti>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ModuloTrasportiCacheModel)) {
			return false;
		}

		ModuloTrasportiCacheModel moduloTrasportiCacheModel = (ModuloTrasportiCacheModel)obj;

		if (id_modulo_trasporti == moduloTrasportiCacheModel.id_modulo_trasporti) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_modulo_trasporti);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{id_modulo_trasporti=");
		sb.append(id_modulo_trasporti);
		sb.append(", cognome=");
		sb.append(cognome);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", codice_fiscale=");
		sb.append(codice_fiscale);
		sb.append(", utente_inserimento=");
		sb.append(utente_inserimento);
		sb.append(", data_inserimento=");
		sb.append(data_inserimento);
		sb.append(", flag_tipospesa=");
		sb.append(flag_tipospesa);
		sb.append(", iban=");
		sb.append(iban);
		sb.append(", importo=");
		sb.append(importo);
		sb.append(", data_titolo_annuale=");
		sb.append(data_titolo_annuale);
		sb.append(", nr_titoli_mensili=");
		sb.append(nr_titoli_mensili);
		sb.append(", figlio_nome=");
		sb.append(figlio_nome);
		sb.append(", figlio_cognome=");
		sb.append(figlio_cognome);
		sb.append(", figlio_data_nascita=");
		sb.append(figlio_data_nascita);
		sb.append(", figlio_luogo_data=");
		sb.append(figlio_luogo_data);
		sb.append(", figlio_codicefiscale=");
		sb.append(figlio_codicefiscale);
		sb.append(", note=");
		sb.append(note);
		sb.append(", flag_inviato=");
		sb.append(flag_inviato);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", allegatoUuid=");
		sb.append(allegatoUuid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ModuloTrasporti toEntityModel() {
		ModuloTrasportiImpl moduloTrasportiImpl = new ModuloTrasportiImpl();

		moduloTrasportiImpl.setId_modulo_trasporti(id_modulo_trasporti);

		if (cognome == null) {
			moduloTrasportiImpl.setCognome(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setCognome(cognome);
		}

		if (nome == null) {
			moduloTrasportiImpl.setNome(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setNome(nome);
		}

		if (codice_fiscale == null) {
			moduloTrasportiImpl.setCodice_fiscale(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setCodice_fiscale(codice_fiscale);
		}

		if (utente_inserimento == null) {
			moduloTrasportiImpl.setUtente_inserimento(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setUtente_inserimento(utente_inserimento);
		}

		if (data_inserimento == Long.MIN_VALUE) {
			moduloTrasportiImpl.setData_inserimento(null);
		}
		else {
			moduloTrasportiImpl.setData_inserimento(new Date(data_inserimento));
		}

		if (flag_tipospesa == null) {
			moduloTrasportiImpl.setFlag_tipospesa(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setFlag_tipospesa(flag_tipospesa);
		}

		if (iban == null) {
			moduloTrasportiImpl.setIban(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setIban(iban);
		}

		if (importo == null) {
			moduloTrasportiImpl.setImporto(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setImporto(importo);
		}

		if (data_titolo_annuale == Long.MIN_VALUE) {
			moduloTrasportiImpl.setData_titolo_annuale(null);
		}
		else {
			moduloTrasportiImpl.setData_titolo_annuale(new Date(
					data_titolo_annuale));
		}

		if (nr_titoli_mensili == null) {
			moduloTrasportiImpl.setNr_titoli_mensili(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setNr_titoli_mensili(nr_titoli_mensili);
		}

		if (figlio_nome == null) {
			moduloTrasportiImpl.setFiglio_nome(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setFiglio_nome(figlio_nome);
		}

		if (figlio_cognome == null) {
			moduloTrasportiImpl.setFiglio_cognome(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setFiglio_cognome(figlio_cognome);
		}

		if (figlio_data_nascita == Long.MIN_VALUE) {
			moduloTrasportiImpl.setFiglio_data_nascita(null);
		}
		else {
			moduloTrasportiImpl.setFiglio_data_nascita(new Date(
					figlio_data_nascita));
		}

		if (figlio_luogo_data == null) {
			moduloTrasportiImpl.setFiglio_luogo_data(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setFiglio_luogo_data(figlio_luogo_data);
		}

		if (figlio_codicefiscale == null) {
			moduloTrasportiImpl.setFiglio_codicefiscale(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setFiglio_codicefiscale(figlio_codicefiscale);
		}

		if (note == null) {
			moduloTrasportiImpl.setNote(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setNote(note);
		}

		if (flag_inviato == null) {
			moduloTrasportiImpl.setFlag_inviato(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setFlag_inviato(flag_inviato);
		}

		if (telefono == null) {
			moduloTrasportiImpl.setTelefono(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setTelefono(telefono);
		}

		if (allegatoUuid == null) {
			moduloTrasportiImpl.setAllegatoUuid(StringPool.BLANK);
		}
		else {
			moduloTrasportiImpl.setAllegatoUuid(allegatoUuid);
		}

		moduloTrasportiImpl.resetOriginalValues();

		return moduloTrasportiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_modulo_trasporti = objectInput.readLong();
		cognome = objectInput.readUTF();
		nome = objectInput.readUTF();
		codice_fiscale = objectInput.readUTF();
		utente_inserimento = objectInput.readUTF();
		data_inserimento = objectInput.readLong();
		flag_tipospesa = objectInput.readUTF();
		iban = objectInput.readUTF();
		importo = objectInput.readUTF();
		data_titolo_annuale = objectInput.readLong();
		nr_titoli_mensili = objectInput.readUTF();
		figlio_nome = objectInput.readUTF();
		figlio_cognome = objectInput.readUTF();
		figlio_data_nascita = objectInput.readLong();
		figlio_luogo_data = objectInput.readUTF();
		figlio_codicefiscale = objectInput.readUTF();
		note = objectInput.readUTF();
		flag_inviato = objectInput.readUTF();
		telefono = objectInput.readUTF();
		allegatoUuid = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_modulo_trasporti);

		if (cognome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cognome);
		}

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (codice_fiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codice_fiscale);
		}

		if (utente_inserimento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente_inserimento);
		}

		objectOutput.writeLong(data_inserimento);

		if (flag_tipospesa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flag_tipospesa);
		}

		if (iban == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(iban);
		}

		if (importo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(importo);
		}

		objectOutput.writeLong(data_titolo_annuale);

		if (nr_titoli_mensili == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nr_titoli_mensili);
		}

		if (figlio_nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(figlio_nome);
		}

		if (figlio_cognome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(figlio_cognome);
		}

		objectOutput.writeLong(figlio_data_nascita);

		if (figlio_luogo_data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(figlio_luogo_data);
		}

		if (figlio_codicefiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(figlio_codicefiscale);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (flag_inviato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flag_inviato);
		}

		if (telefono == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefono);
		}

		if (allegatoUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(allegatoUuid);
		}
	}

	public long id_modulo_trasporti;
	public String cognome;
	public String nome;
	public String codice_fiscale;
	public String utente_inserimento;
	public long data_inserimento;
	public String flag_tipospesa;
	public String iban;
	public String importo;
	public long data_titolo_annuale;
	public String nr_titoli_mensili;
	public String figlio_nome;
	public String figlio_cognome;
	public long figlio_data_nascita;
	public String figlio_luogo_data;
	public String figlio_codicefiscale;
	public String note;
	public String flag_inviato;
	public String telefono;
	public String allegatoUuid;
}