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

import service.intranet.mef.model.RichiesteHW;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RichiesteHW in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteHW
 * @generated
 */
@ProviderType
public class RichiesteHWCacheModel implements CacheModel<RichiesteHW>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RichiesteHWCacheModel)) {
			return false;
		}

		RichiesteHWCacheModel richiesteHWCacheModel = (RichiesteHWCacheModel)obj;

		if (id_richieste_hw == richiesteHWCacheModel.id_richieste_hw) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_richieste_hw);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_richieste_hw=");
		sb.append(id_richieste_hw);
		sb.append(", utente=");
		sb.append(utente);
		sb.append(", dettaglio=");
		sb.append(dettaglio);
		sb.append(", data_richiesta=");
		sb.append(data_richiesta);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RichiesteHW toEntityModel() {
		RichiesteHWImpl richiesteHWImpl = new RichiesteHWImpl();

		richiesteHWImpl.setId_richieste_hw(id_richieste_hw);

		if (utente == null) {
			richiesteHWImpl.setUtente(StringPool.BLANK);
		}
		else {
			richiesteHWImpl.setUtente(utente);
		}

		if (dettaglio == null) {
			richiesteHWImpl.setDettaglio(StringPool.BLANK);
		}
		else {
			richiesteHWImpl.setDettaglio(dettaglio);
		}

		if (data_richiesta == Long.MIN_VALUE) {
			richiesteHWImpl.setData_richiesta(null);
		}
		else {
			richiesteHWImpl.setData_richiesta(new Date(data_richiesta));
		}

		richiesteHWImpl.resetOriginalValues();

		return richiesteHWImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_richieste_hw = objectInput.readLong();
		utente = objectInput.readUTF();
		dettaglio = objectInput.readUTF();
		data_richiesta = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_richieste_hw);

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

		objectOutput.writeLong(data_richiesta);
	}

	public long id_richieste_hw;
	public String utente;
	public String dettaglio;
	public long data_richiesta;
}