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

import servizio.richieste.badge.mef.model.GestioneUtenti;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GestioneUtenti in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtenti
 * @generated
 */
@ProviderType
public class GestioneUtentiCacheModel implements CacheModel<GestioneUtenti>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GestioneUtentiCacheModel)) {
			return false;
		}

		GestioneUtentiCacheModel gestioneUtentiCacheModel = (GestioneUtentiCacheModel)obj;

		if (id_gest_utenti == gestioneUtentiCacheModel.id_gest_utenti) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_gest_utenti);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id_gest_utenti=");
		sb.append(id_gest_utenti);
		sb.append(", data=");
		sb.append(data);
		sb.append(", screename_dirigente=");
		sb.append(screename_dirigente);
		sb.append(", screename_utente=");
		sb.append(screename_utente);
		sb.append(", id_ufficio=");
		sb.append(id_ufficio);
		sb.append(", abilitazione=");
		sb.append(abilitazione);
		sb.append(", delega=");
		sb.append(delega);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GestioneUtenti toEntityModel() {
		GestioneUtentiImpl gestioneUtentiImpl = new GestioneUtentiImpl();

		gestioneUtentiImpl.setId_gest_utenti(id_gest_utenti);

		if (data == Long.MIN_VALUE) {
			gestioneUtentiImpl.setData(null);
		}
		else {
			gestioneUtentiImpl.setData(new Date(data));
		}

		if (screename_dirigente == null) {
			gestioneUtentiImpl.setScreename_dirigente(StringPool.BLANK);
		}
		else {
			gestioneUtentiImpl.setScreename_dirigente(screename_dirigente);
		}

		if (screename_utente == null) {
			gestioneUtentiImpl.setScreename_utente(StringPool.BLANK);
		}
		else {
			gestioneUtentiImpl.setScreename_utente(screename_utente);
		}

		gestioneUtentiImpl.setId_ufficio(id_ufficio);
		gestioneUtentiImpl.setAbilitazione(abilitazione);
		gestioneUtentiImpl.setDelega(delega);

		gestioneUtentiImpl.resetOriginalValues();

		return gestioneUtentiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_gest_utenti = objectInput.readLong();
		data = objectInput.readLong();
		screename_dirigente = objectInput.readUTF();
		screename_utente = objectInput.readUTF();

		id_ufficio = objectInput.readLong();

		abilitazione = objectInput.readBoolean();

		delega = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_gest_utenti);
		objectOutput.writeLong(data);

		if (screename_dirigente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screename_dirigente);
		}

		if (screename_utente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screename_utente);
		}

		objectOutput.writeLong(id_ufficio);

		objectOutput.writeBoolean(abilitazione);

		objectOutput.writeBoolean(delega);
	}

	public long id_gest_utenti;
	public long data;
	public String screename_dirigente;
	public String screename_utente;
	public long id_ufficio;
	public boolean abilitazione;
	public boolean delega;
}