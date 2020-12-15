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

import service.intranet.mef.model.BadgeRichieste;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BadgeRichieste in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BadgeRichieste
 * @generated
 */
@ProviderType
public class BadgeRichiesteCacheModel implements CacheModel<BadgeRichieste>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeRichiesteCacheModel)) {
			return false;
		}

		BadgeRichiesteCacheModel badgeRichiesteCacheModel = (BadgeRichiesteCacheModel)obj;

		if (id == badgeRichiesteCacheModel.id) {
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
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", dettaglio_richiedente=");
		sb.append(dettaglio_richiedente);
		sb.append(", cognome=");
		sb.append(cognome);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", luogo_nascita=");
		sb.append(luogo_nascita);
		sb.append(", data_nascita=");
		sb.append(data_nascita);
		sb.append(", codice_fiscale=");
		sb.append(codice_fiscale);
		sb.append(", numerobadge=");
		sb.append(numerobadge);
		sb.append(", allegatoUuid=");
		sb.append(allegatoUuid);
		sb.append(", operazione=");
		sb.append(operazione);
		sb.append(", data_richiesta=");
		sb.append(data_richiesta);
		sb.append(", procedura=");
		sb.append(procedura);
		sb.append(", disattivazione=");
		sb.append(disattivazione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BadgeRichieste toEntityModel() {
		BadgeRichiesteImpl badgeRichiesteImpl = new BadgeRichiesteImpl();

		badgeRichiesteImpl.setId(id);

		if (utente == null) {
			badgeRichiesteImpl.setUtente(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setUtente(utente);
		}

		if (dettaglio_richiedente == null) {
			badgeRichiesteImpl.setDettaglio_richiedente(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setDettaglio_richiedente(dettaglio_richiedente);
		}

		if (cognome == null) {
			badgeRichiesteImpl.setCognome(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setCognome(cognome);
		}

		if (nome == null) {
			badgeRichiesteImpl.setNome(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setNome(nome);
		}

		if (luogo_nascita == null) {
			badgeRichiesteImpl.setLuogo_nascita(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setLuogo_nascita(luogo_nascita);
		}

		if (data_nascita == Long.MIN_VALUE) {
			badgeRichiesteImpl.setData_nascita(null);
		}
		else {
			badgeRichiesteImpl.setData_nascita(new Date(data_nascita));
		}

		if (codice_fiscale == null) {
			badgeRichiesteImpl.setCodice_fiscale(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setCodice_fiscale(codice_fiscale);
		}

		if (numerobadge == null) {
			badgeRichiesteImpl.setNumerobadge(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setNumerobadge(numerobadge);
		}

		if (allegatoUuid == null) {
			badgeRichiesteImpl.setAllegatoUuid(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setAllegatoUuid(allegatoUuid);
		}

		if (operazione == null) {
			badgeRichiesteImpl.setOperazione(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setOperazione(operazione);
		}

		if (data_richiesta == Long.MIN_VALUE) {
			badgeRichiesteImpl.setData_richiesta(null);
		}
		else {
			badgeRichiesteImpl.setData_richiesta(new Date(data_richiesta));
		}

		if (procedura == null) {
			badgeRichiesteImpl.setProcedura(StringPool.BLANK);
		}
		else {
			badgeRichiesteImpl.setProcedura(procedura);
		}

		if (disattivazione == Long.MIN_VALUE) {
			badgeRichiesteImpl.setDisattivazione(null);
		}
		else {
			badgeRichiesteImpl.setDisattivazione(new Date(disattivazione));
		}

		badgeRichiesteImpl.resetOriginalValues();

		return badgeRichiesteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		utente = objectInput.readUTF();
		dettaglio_richiedente = objectInput.readUTF();
		cognome = objectInput.readUTF();
		nome = objectInput.readUTF();
		luogo_nascita = objectInput.readUTF();
		data_nascita = objectInput.readLong();
		codice_fiscale = objectInput.readUTF();
		numerobadge = objectInput.readUTF();
		allegatoUuid = objectInput.readUTF();
		operazione = objectInput.readUTF();
		data_richiesta = objectInput.readLong();
		procedura = objectInput.readUTF();
		disattivazione = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (utente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente);
		}

		if (dettaglio_richiedente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dettaglio_richiedente);
		}

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

		if (luogo_nascita == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(luogo_nascita);
		}

		objectOutput.writeLong(data_nascita);

		if (codice_fiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codice_fiscale);
		}

		if (numerobadge == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(numerobadge);
		}

		if (allegatoUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(allegatoUuid);
		}

		if (operazione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(operazione);
		}

		objectOutput.writeLong(data_richiesta);

		if (procedura == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(procedura);
		}

		objectOutput.writeLong(disattivazione);
	}

	public long id;
	public String utente;
	public String dettaglio_richiedente;
	public String cognome;
	public String nome;
	public String luogo_nascita;
	public long data_nascita;
	public String codice_fiscale;
	public String numerobadge;
	public String allegatoUuid;
	public String operazione;
	public long data_richiesta;
	public String procedura;
	public long disattivazione;
}