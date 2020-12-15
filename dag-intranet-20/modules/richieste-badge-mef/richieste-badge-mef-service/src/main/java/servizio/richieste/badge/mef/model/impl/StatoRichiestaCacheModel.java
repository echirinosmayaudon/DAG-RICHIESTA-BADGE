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

import servizio.richieste.badge.mef.model.StatoRichiesta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatoRichiesta in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichiesta
 * @generated
 */
@ProviderType
public class StatoRichiestaCacheModel implements CacheModel<StatoRichiesta>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoRichiestaCacheModel)) {
			return false;
		}

		StatoRichiestaCacheModel statoRichiestaCacheModel = (StatoRichiestaCacheModel)obj;

		if (id_stato == statoRichiestaCacheModel.id_stato) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_stato);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_stato=");
		sb.append(id_stato);
		sb.append(", descrizione_stato=");
		sb.append(descrizione_stato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatoRichiesta toEntityModel() {
		StatoRichiestaImpl statoRichiestaImpl = new StatoRichiestaImpl();

		statoRichiestaImpl.setId_stato(id_stato);

		if (descrizione_stato == null) {
			statoRichiestaImpl.setDescrizione_stato(StringPool.BLANK);
		}
		else {
			statoRichiestaImpl.setDescrizione_stato(descrizione_stato);
		}

		statoRichiestaImpl.resetOriginalValues();

		return statoRichiestaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_stato = objectInput.readLong();
		descrizione_stato = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_stato);

		if (descrizione_stato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione_stato);
		}
	}

	public long id_stato;
	public String descrizione_stato;
}