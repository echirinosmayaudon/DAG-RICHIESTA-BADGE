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

package servizio.beni.facile.consumo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.beni.facile.consumo.model.GestioneUtenti;

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

		if (id == gestioneUtentiCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", data=");
		sb.append(data);
		sb.append(", cod_fiscale=");
		sb.append(cod_fiscale);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", cognome=");
		sb.append(cognome);
		sb.append(", ufficio=");
		sb.append(ufficio);
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

		gestioneUtentiImpl.setId(id);

		if (data == Long.MIN_VALUE) {
			gestioneUtentiImpl.setData(null);
		}
		else {
			gestioneUtentiImpl.setData(new Date(data));
		}

		if (cod_fiscale == null) {
			gestioneUtentiImpl.setCod_fiscale(StringPool.BLANK);
		}
		else {
			gestioneUtentiImpl.setCod_fiscale(cod_fiscale);
		}

		if (nome == null) {
			gestioneUtentiImpl.setNome(StringPool.BLANK);
		}
		else {
			gestioneUtentiImpl.setNome(nome);
		}

		if (cognome == null) {
			gestioneUtentiImpl.setCognome(StringPool.BLANK);
		}
		else {
			gestioneUtentiImpl.setCognome(cognome);
		}

		if (ufficio == null) {
			gestioneUtentiImpl.setUfficio(StringPool.BLANK);
		}
		else {
			gestioneUtentiImpl.setUfficio(ufficio);
		}

		gestioneUtentiImpl.setAbilitazione(abilitazione);
		gestioneUtentiImpl.setDelega(delega);

		gestioneUtentiImpl.resetOriginalValues();

		return gestioneUtentiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		data = objectInput.readLong();
		cod_fiscale = objectInput.readUTF();
		nome = objectInput.readUTF();
		cognome = objectInput.readUTF();
		ufficio = objectInput.readUTF();

		abilitazione = objectInput.readBoolean();

		delega = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(data);

		if (cod_fiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cod_fiscale);
		}

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (cognome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cognome);
		}

		if (ufficio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ufficio);
		}

		objectOutput.writeBoolean(abilitazione);

		objectOutput.writeBoolean(delega);
	}

	public long id;
	public long data;
	public String cod_fiscale;
	public String nome;
	public String cognome;
	public String ufficio;
	public boolean abilitazione;
	public boolean delega;
}