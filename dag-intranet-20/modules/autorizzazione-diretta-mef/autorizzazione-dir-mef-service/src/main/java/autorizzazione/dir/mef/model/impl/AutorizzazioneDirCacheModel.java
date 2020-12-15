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




package autorizzazione.dir.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.model.AutorizzazioneDir;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AutorizzazioneDir in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AutorizzazioneDir
 * @generated
 */
@ProviderType
public class AutorizzazioneDirCacheModel implements CacheModel<AutorizzazioneDir>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AutorizzazioneDirCacheModel)) {
			return false;
		}

		AutorizzazioneDirCacheModel autorizzazioneDirCacheModel = (AutorizzazioneDirCacheModel)obj;

		if (id_autorizzazione == autorizzazioneDirCacheModel.id_autorizzazione) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_autorizzazione);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id_autorizzazione=");
		sb.append(id_autorizzazione);
		sb.append(", id_applicazione=");
		sb.append(id_applicazione);
		sb.append(", mef=");
		sb.append(mef);
		sb.append(", dipartimento=");
		sb.append(dipartimento);
		sb.append(", direzione=");
		sb.append(direzione);
		sb.append(", ufficio=");
		sb.append(ufficio);
		sb.append(", codice_fiscale=");
		sb.append(codice_fiscale);
		sb.append(", nega=");
		sb.append(nega);
		sb.append(", tag=");
		sb.append(tag);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AutorizzazioneDir toEntityModel() {
		AutorizzazioneDirImpl autorizzazioneDirImpl = new AutorizzazioneDirImpl();

		autorizzazioneDirImpl.setId_autorizzazione(id_autorizzazione);
		autorizzazioneDirImpl.setId_applicazione(id_applicazione);
		autorizzazioneDirImpl.setMef(mef);
		autorizzazioneDirImpl.setDipartimento(dipartimento);
		autorizzazioneDirImpl.setDirezione(direzione);
		autorizzazioneDirImpl.setUfficio(ufficio);

		if (codice_fiscale == null) {
			autorizzazioneDirImpl.setCodice_fiscale(StringPool.BLANK);
		}
		else {
			autorizzazioneDirImpl.setCodice_fiscale(codice_fiscale);
		}

		autorizzazioneDirImpl.setNega(nega);

		if (tag == null) {
			autorizzazioneDirImpl.setTag(StringPool.BLANK);
		}
		else {
			autorizzazioneDirImpl.setTag(tag);
		}

		autorizzazioneDirImpl.resetOriginalValues();

		return autorizzazioneDirImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_autorizzazione = objectInput.readLong();

		id_applicazione = objectInput.readLong();

		mef = objectInput.readLong();

		dipartimento = objectInput.readLong();

		direzione = objectInput.readLong();

		ufficio = objectInput.readLong();
		codice_fiscale = objectInput.readUTF();

		nega = objectInput.readBoolean();
		tag = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_autorizzazione);

		objectOutput.writeLong(id_applicazione);

		objectOutput.writeLong(mef);

		objectOutput.writeLong(dipartimento);

		objectOutput.writeLong(direzione);

		objectOutput.writeLong(ufficio);

		if (codice_fiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codice_fiscale);
		}

		objectOutput.writeBoolean(nega);

		if (tag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag);
		}
	}

	public long id_autorizzazione;
	public long id_applicazione;
	public long mef;
	public long dipartimento;
	public long direzione;
	public long ufficio;
	public String codice_fiscale;
	public boolean nega;
	public String tag;
}