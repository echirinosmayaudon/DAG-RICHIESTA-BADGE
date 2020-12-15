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

package service.intranet.mef.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import service.intranet.mef.model.RichiestaBeneInv;
import service.intranet.mef.service.persistence.RichiestaBeneInvPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RichiestaBeneInvFinderBaseImpl extends BasePersistenceImpl<RichiestaBeneInv> {
	@Override
	public Set<String> getBadColumnNames() {
		return getRichiestaBeneInvPersistence().getBadColumnNames();
	}

	/**
	 * Returns the richiesta bene inv persistence.
	 *
	 * @return the richiesta bene inv persistence
	 */
	public RichiestaBeneInvPersistence getRichiestaBeneInvPersistence() {
		return richiestaBeneInvPersistence;
	}

	/**
	 * Sets the richiesta bene inv persistence.
	 *
	 * @param richiestaBeneInvPersistence the richiesta bene inv persistence
	 */
	public void setRichiestaBeneInvPersistence(
		RichiestaBeneInvPersistence richiestaBeneInvPersistence) {
		this.richiestaBeneInvPersistence = richiestaBeneInvPersistence;
	}

	@BeanReference(type = RichiestaBeneInvPersistence.class)
	protected RichiestaBeneInvPersistence richiestaBeneInvPersistence;
}