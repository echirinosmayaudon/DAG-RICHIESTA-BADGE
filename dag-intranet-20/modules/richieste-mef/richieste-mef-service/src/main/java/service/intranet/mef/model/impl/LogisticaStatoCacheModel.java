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

import service.intranet.mef.model.LogisticaStato;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LogisticaStato in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaStato
 * @generated
 */
@ProviderType
public class LogisticaStatoCacheModel implements CacheModel<LogisticaStato>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogisticaStatoCacheModel)) {
			return false;
		}

		LogisticaStatoCacheModel logisticaStatoCacheModel = (LogisticaStatoCacheModel)obj;

		if (id == logisticaStatoCacheModel.id) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", utente=");
		sb.append(utente);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LogisticaStato toEntityModel() {
		LogisticaStatoImpl logisticaStatoImpl = new LogisticaStatoImpl();

		logisticaStatoImpl.setId(id);

		if (descrizione == null) {
			logisticaStatoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			logisticaStatoImpl.setDescrizione(descrizione);
		}

		if (utente == null) {
			logisticaStatoImpl.setUtente(StringPool.BLANK);
		}
		else {
			logisticaStatoImpl.setUtente(utente);
		}

		logisticaStatoImpl.resetOriginalValues();

		return logisticaStatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		descrizione = objectInput.readUTF();
		utente = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (utente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(utente);
		}
	}

	public long id;
	public String descrizione;
	public String utente;
}