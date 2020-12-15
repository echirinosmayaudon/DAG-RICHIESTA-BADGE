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

import service.intranet.mef.model.RichiestaInterventi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichiestaInterventi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaInterventi
 * @generated
 */
@ProviderType
public class RichiestaInterventiCacheModel implements CacheModel<RichiestaInterventi>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiestaInterventiCacheModel)) {
			return false;
		}

		RichiestaInterventiCacheModel richiestaInterventiCacheModel = (RichiestaInterventiCacheModel)obj;

		if (id == richiestaInterventiCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", dettaglio=");
		sb.append(dettaglio);
		sb.append(", data_interventi=");
		sb.append(data_interventi);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiestaInterventi toEntityModel() {
		RichiestaInterventiImpl richiestaInterventiImpl = new RichiestaInterventiImpl();

		richiestaInterventiImpl.setId(id);

		if (utente == null) {
			richiestaInterventiImpl.setUtente(StringPool.BLANK);
		}
		else {
			richiestaInterventiImpl.setUtente(utente);
		}

		if (dettaglio == null) {
			richiestaInterventiImpl.setDettaglio(StringPool.BLANK);
		}
		else {
			richiestaInterventiImpl.setDettaglio(dettaglio);
		}

		if (data_interventi == Long.MIN_VALUE) {
			richiestaInterventiImpl.setData_interventi(null);
		}
		else {
			richiestaInterventiImpl.setData_interventi(new Date(data_interventi));
		}

		richiestaInterventiImpl.resetOriginalValues();

		return richiestaInterventiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		utente = objectInput.readUTF();
		dettaglio = objectInput.readUTF();
		data_interventi = objectInput.readLong();
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

		if (dettaglio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dettaglio);
		}

		objectOutput.writeLong(data_interventi);
	}

	public long id;
	public String utente;
	public String dettaglio;
	public long data_interventi;
}