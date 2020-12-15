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

package servizio.richieste.badge.mef.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.service.persistence.RichiestaBadgePersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RichiestaBadgeFinderBaseImpl extends BasePersistenceImpl<RichiestaBadge> {
	/**
	 * Returns the richiesta badge persistence.
	 *
	 * @return the richiesta badge persistence
	 */
	public RichiestaBadgePersistence getRichiestaBadgePersistence() {
		return richiestaBadgePersistence;
	}

	/**
	 * Sets the richiesta badge persistence.
	 *
	 * @param richiestaBadgePersistence the richiesta badge persistence
	 */
	public void setRichiestaBadgePersistence(
		RichiestaBadgePersistence richiestaBadgePersistence) {
		this.richiestaBadgePersistence = richiestaBadgePersistence;
	}

	@BeanReference(type = RichiestaBadgePersistence.class)
	protected RichiestaBadgePersistence richiestaBadgePersistence;
}