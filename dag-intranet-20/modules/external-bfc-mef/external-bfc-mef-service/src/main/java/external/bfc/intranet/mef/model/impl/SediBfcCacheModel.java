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

package external.bfc.intranet.mef.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import external.bfc.intranet.mef.model.SediBfc;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SediBfc in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SediBfc
 * @generated
 */
@ProviderType
public class SediBfcCacheModel implements CacheModel<SediBfc>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SediBfcCacheModel)) {
			return false;
		}

		SediBfcCacheModel sediBfcCacheModel = (SediBfcCacheModel)obj;

		if (id == sediBfcCacheModel.id) {
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
		sb.append(", codice_geco=");
		sb.append(codice_geco);
		sb.append(", id_sede_geco=");
		sb.append(id_sede_geco);
		sb.append(", id_sede_siap=");
		sb.append(id_sede_siap);
		sb.append(", id_org_liv2=");
		sb.append(id_org_liv2);
		sb.append(", id_org_liv3=");
		sb.append(id_org_liv3);
		sb.append(", nomeLoc=");
		sb.append(nomeLoc);
		sb.append(", flag_app=");
		sb.append(flag_app);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SediBfc toEntityModel() {
		SediBfcImpl sediBfcImpl = new SediBfcImpl();

		sediBfcImpl.setId(id);

		if (codice_geco == null) {
			sediBfcImpl.setCodice_geco(StringPool.BLANK);
		}
		else {
			sediBfcImpl.setCodice_geco(codice_geco);
		}

		if (id_sede_geco == null) {
			sediBfcImpl.setId_sede_geco(StringPool.BLANK);
		}
		else {
			sediBfcImpl.setId_sede_geco(id_sede_geco);
		}

		sediBfcImpl.setId_sede_siap(id_sede_siap);
		sediBfcImpl.setId_org_liv2(id_org_liv2);
		sediBfcImpl.setId_org_liv3(id_org_liv3);

		if (nomeLoc == null) {
			sediBfcImpl.setNomeLoc(StringPool.BLANK);
		}
		else {
			sediBfcImpl.setNomeLoc(nomeLoc);
		}

		sediBfcImpl.setFlag_app(flag_app);

		sediBfcImpl.resetOriginalValues();

		return sediBfcImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		codice_geco = objectInput.readUTF();
		id_sede_geco = objectInput.readUTF();

		id_sede_siap = objectInput.readLong();

		id_org_liv2 = objectInput.readLong();

		id_org_liv3 = objectInput.readLong();
		nomeLoc = objectInput.readUTF();

		flag_app = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (codice_geco == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codice_geco);
		}

		if (id_sede_geco == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(id_sede_geco);
		}

		objectOutput.writeLong(id_sede_siap);

		objectOutput.writeLong(id_org_liv2);

		objectOutput.writeLong(id_org_liv3);

		if (nomeLoc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeLoc);
		}

		objectOutput.writeBoolean(flag_app);
	}

	public long id;
	public String codice_geco;
	public String id_sede_geco;
	public long id_sede_siap;
	public long id_org_liv2;
	public long id_org_liv3;
	public String nomeLoc;
	public boolean flag_app;
}