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

import servizio.richieste.badge.mef.model.OggettoRichiesta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OggettoRichiesta in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OggettoRichiesta
 * @generated
 */
@ProviderType
public class OggettoRichiestaCacheModel implements CacheModel<OggettoRichiesta>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OggettoRichiestaCacheModel)) {
			return false;
		}

		OggettoRichiestaCacheModel oggettoRichiestaCacheModel = (OggettoRichiestaCacheModel)obj;

		if (id_oggetto == oggettoRichiestaCacheModel.id_oggetto) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_oggetto);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_oggetto=");
		sb.append(id_oggetto);
		sb.append(", descrizione_oggetto=");
		sb.append(descrizione_oggetto);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OggettoRichiesta toEntityModel() {
		OggettoRichiestaImpl oggettoRichiestaImpl = new OggettoRichiestaImpl();

		oggettoRichiestaImpl.setId_oggetto(id_oggetto);

		if (descrizione_oggetto == null) {
			oggettoRichiestaImpl.setDescrizione_oggetto(StringPool.BLANK);
		}
		else {
			oggettoRichiestaImpl.setDescrizione_oggetto(descrizione_oggetto);
		}

		oggettoRichiestaImpl.resetOriginalValues();

		return oggettoRichiestaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_oggetto = objectInput.readLong();
		descrizione_oggetto = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_oggetto);

		if (descrizione_oggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione_oggetto);
		}
	}

	public long id_oggetto;
	public String descrizione_oggetto;
}