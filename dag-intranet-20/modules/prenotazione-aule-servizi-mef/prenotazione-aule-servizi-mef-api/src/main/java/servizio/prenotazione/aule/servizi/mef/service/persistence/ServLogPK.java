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

package servizio.prenotazione.aule.servizi.mef.service.persistence;

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
public class ServLogPK implements Comparable<ServLogPK>, Serializable {
	public long id_serv;
	public long id_sala;

	public ServLogPK() {
	}

	public ServLogPK(long id_serv, long id_sala) {
		this.id_serv = id_serv;
		this.id_sala = id_sala;
	}

	public long getId_serv() {
		return id_serv;
	}

	public void setId_serv(long id_serv) {
		this.id_serv = id_serv;
	}

	public long getId_sala() {
		return id_sala;
	}

	public void setId_sala(long id_sala) {
		this.id_sala = id_sala;
	}

	@Override
	public int compareTo(ServLogPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (id_serv < pk.id_serv) {
			value = -1;
		}
		else if (id_serv > pk.id_serv) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (id_sala < pk.id_sala) {
			value = -1;
		}
		else if (id_sala > pk.id_sala) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ServLogPK)) {
			return false;
		}

		ServLogPK pk = (ServLogPK)obj;

		if ((id_serv == pk.id_serv) && (id_sala == pk.id_sala)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, id_serv);
		hashCode = HashUtil.hash(hashCode, id_sala);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("id_serv");
		sb.append(StringPool.EQUAL);
		sb.append(id_serv);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("id_sala");
		sb.append(StringPool.EQUAL);
		sb.append(id_sala);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}