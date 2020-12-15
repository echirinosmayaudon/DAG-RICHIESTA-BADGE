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

package servizio.prenotazione.aule.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import servizio.prenotazione.aule.mef.model.StatoAula;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatoAula in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StatoAula
 * @generated
 */
@ProviderType
public class StatoAulaCacheModel implements CacheModel<StatoAula>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoAulaCacheModel)) {
			return false;
		}

		StatoAulaCacheModel statoAulaCacheModel = (StatoAulaCacheModel)obj;

		if (id_stato_aula == statoAulaCacheModel.id_stato_aula) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_stato_aula);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_stato_aula=");
		sb.append(id_stato_aula);
		sb.append(", desc_stato=");
		sb.append(desc_stato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatoAula toEntityModel() {
		StatoAulaImpl statoAulaImpl = new StatoAulaImpl();

		statoAulaImpl.setId_stato_aula(id_stato_aula);

		if (desc_stato == null) {
			statoAulaImpl.setDesc_stato(StringPool.BLANK);
		}
		else {
			statoAulaImpl.setDesc_stato(desc_stato);
		}

		statoAulaImpl.resetOriginalValues();

		return statoAulaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_stato_aula = objectInput.readLong();
		desc_stato = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_stato_aula);

		if (desc_stato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc_stato);
		}
	}

	public long id_stato_aula;
	public String desc_stato;
}