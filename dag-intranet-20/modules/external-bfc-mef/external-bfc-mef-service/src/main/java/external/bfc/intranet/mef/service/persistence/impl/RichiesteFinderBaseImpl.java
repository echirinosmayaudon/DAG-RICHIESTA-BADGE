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

package external.bfc.intranet.mef.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import external.bfc.intranet.mef.model.Richieste;
import external.bfc.intranet.mef.service.persistence.RichiestePersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RichiesteFinderBaseImpl extends BasePersistenceImpl<Richieste> {
	@Override
	public Set<String> getBadColumnNames() {
		return getRichiestePersistence().getBadColumnNames();
	}

	/**
	 * Returns the richieste persistence.
	 *
	 * @return the richieste persistence
	 */
	public RichiestePersistence getRichiestePersistence() {
		return richiestePersistence;
	}

	/**
	 * Sets the richieste persistence.
	 *
	 * @param richiestePersistence the richieste persistence
	 */
	public void setRichiestePersistence(
		RichiestePersistence richiestePersistence) {
		this.richiestePersistence = richiestePersistence;
	}

	@BeanReference(type = RichiestePersistence.class)
	protected RichiestePersistence richiestePersistence;
}