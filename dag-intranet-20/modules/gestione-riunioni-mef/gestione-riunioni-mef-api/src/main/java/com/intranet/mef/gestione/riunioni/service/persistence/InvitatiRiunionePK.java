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
public class InvitatiRiunionePK implements Comparable<InvitatiRiunionePK>,
	Serializable {
	public long id_segreteria;
	public long id_riunione;

	public InvitatiRiunionePK() {
	}

	public InvitatiRiunionePK(long id_segreteria, long id_riunione) {
		this.id_segreteria = id_segreteria;
		this.id_riunione = id_riunione;
	}

	public long getId_segreteria() {
		return id_segreteria;
	}

	public void setId_segreteria(long id_segreteria) {
		this.id_segreteria = id_segreteria;
	}

	public long getId_riunione() {
		return id_riunione;
	}

	public void setId_riunione(long id_riunione) {
		this.id_riunione = id_riunione;
	}

	@Override
	public int compareTo(InvitatiRiunionePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (id_segreteria < pk.id_segreteria) {
			value = -1;
		}
		else if (id_segreteria > pk.id_segreteria) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InvitatiRiunionePK)) {
			return false;
		}

		InvitatiRiunionePK pk = (InvitatiRiunionePK)obj;

		if ((id_segreteria == pk.id_segreteria) &&
				(id_riunione == pk.id_riunione)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, id_segreteria);
		hashCode = HashUtil.hash(hashCode, id_riunione);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("id_segreteria");
		sb.append(StringPool.EQUAL);
		sb.append(id_segreteria);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("id_riunione");
		sb.append(StringPool.EQUAL);
		sb.append(id_riunione);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}