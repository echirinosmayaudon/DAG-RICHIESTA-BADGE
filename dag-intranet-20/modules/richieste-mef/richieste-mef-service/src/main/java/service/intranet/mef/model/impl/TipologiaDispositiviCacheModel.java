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

import service.intranet.mef.model.TipologiaDispositivi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipologiaDispositivi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaDispositivi
 * @generated
 */
@ProviderType
public class TipologiaDispositiviCacheModel implements CacheModel<TipologiaDispositivi>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipologiaDispositiviCacheModel)) {
			return false;
		}

		TipologiaDispositiviCacheModel tipologiaDispositiviCacheModel = (TipologiaDispositiviCacheModel)obj;

		if (id_tipologia_dispositivi == tipologiaDispositiviCacheModel.id_tipologia_dispositivi) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_tipologia_dispositivi);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_tipologia_dispositivi=");
		sb.append(id_tipologia_dispositivi);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipologiaDispositivi toEntityModel() {
		TipologiaDispositiviImpl tipologiaDispositiviImpl = new TipologiaDispositiviImpl();

		tipologiaDispositiviImpl.setId_tipologia_dispositivi(id_tipologia_dispositivi);

		if (descrizione == null) {
			tipologiaDispositiviImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			tipologiaDispositiviImpl.setDescrizione(descrizione);
		}

		tipologiaDispositiviImpl.resetOriginalValues();

		return tipologiaDispositiviImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_tipologia_dispositivi = objectInput.readLong();
		descrizione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_tipologia_dispositivi);

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id_tipologia_dispositivi;
	public String descrizione;
}