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

package external.bfc.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RigheRichiesteInfoPK implements Comparable<RigheRichiesteInfoPK>,
	Serializable {
	public long id;
	public long idMateriale;
	public String sottogruppo;
	public String gruppo;

	public RigheRichiesteInfoPK() {
	}

	public RigheRichiesteInfoPK(long id, long idMateriale, String sottogruppo,
		String gruppo) {
		this.id = id;
		this.idMateriale = idMateriale;
		this.sottogruppo = sottogruppo;
		this.gruppo = gruppo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdMateriale() {
		return idMateriale;
	}

	public void setIdMateriale(long idMateriale) {
		this.idMateriale = idMateriale;
	}

	public String getSottogruppo() {
		return sottogruppo;
	}

	public void setSottogruppo(String sottogruppo) {
		this.sottogruppo = sottogruppo;
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	@Override
	public int compareTo(RigheRichiesteInfoPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (id < pk.id) {
			value = -1;
		}
		else if (id > pk.id) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (idMateriale < pk.idMateriale) {
			value = -1;
		}
		else if (idMateriale > pk.idMateriale) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = sottogruppo.compareTo(pk.sottogruppo);

		if (value != 0) {
			return value;
		}

		value = gruppo.compareTo(pk.gruppo);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigheRichiesteInfoPK)) {
			return false;
		}

		RigheRichiesteInfoPK pk = (RigheRichiesteInfoPK)obj;

		if ((id == pk.id) && (idMateriale == pk.idMateriale) &&
				(sottogruppo.equals(pk.sottogruppo)) &&
				(gruppo.equals(pk.gruppo))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, id);
		hashCode = HashUtil.hash(hashCode, idMateriale);
		hashCode = HashUtil.hash(hashCode, sottogruppo);
		hashCode = HashUtil.hash(hashCode, gruppo);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("id");
		sb.append(StringPool.EQUAL);
		sb.append(id);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("idMateriale");
		sb.append(StringPool.EQUAL);
		sb.append(idMateriale);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("sottogruppo");
		sb.append(StringPool.EQUAL);
		sb.append(sottogruppo);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("gruppo");
		sb.append(StringPool.EQUAL);
		sb.append(gruppo);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}