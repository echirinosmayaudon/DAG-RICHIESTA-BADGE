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

package com.intranet.mef.gestione.riunioni.service.persistence;

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
public class StoricoStatoRiunionePK implements Comparable<StoricoStatoRiunionePK>,
	Serializable {
	public long id_riunione;
	public long id_storico;

	public StoricoStatoRiunionePK() {
	}

	public StoricoStatoRiunionePK(long id_riunione, long id_storico) {
		this.id_riunione = id_riunione;
		this.id_storico = id_storico;
	}

	public long getId_riunione() {
		return id_riunione;
	}

	public void setId_riunione(long id_riunione) {
		this.id_riunione = id_riunione;
	}

	public long getId_storico() {
		return id_storico;
	}

	public void setId_storico(long id_storico) {
		this.id_storico = id_storico;
	}

	@Override
	public int compareTo(StoricoStatoRiunionePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (id_riunione < pk.id_riunione) {
			value = -1;
		}
		else if (id_riunione > pk.id_riunione) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (id_storico < pk.id_storico) {
			value = -1;
		}
		else if (id_storico > pk.id_storico) {
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

		if (!(obj instanceof StoricoStatoRiunionePK)) {
			return false;
		}

		StoricoStatoRiunionePK pk = (StoricoStatoRiunionePK)obj;

		if ((id_riunione == pk.id_riunione) && (id_storico == pk.id_storico)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, id_riunione);
		hashCode = HashUtil.hash(hashCode, id_storico);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("id_riunione");
		sb.append(StringPool.EQUAL);
		sb.append(id_riunione);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("id_storico");
		sb.append(StringPool.EQUAL);
		sb.append(id_storico);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}