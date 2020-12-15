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

package com.intranet.mef.gestione.riunioni.service.persistence.impl;

import com.intranet.mef.gestione.riunioni.model.Riunione;
import com.intranet.mef.gestione.riunioni.service.persistence.RiunionePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RiunioneFinderBaseImpl extends BasePersistenceImpl<Riunione> {
	/**
	 * Returns the riunione persistence.
	 *
	 * @return the riunione persistence
	 */
	public RiunionePersistence getRiunionePersistence() {
		return riunionePersistence;
	}

	/**
	 * Sets the riunione persistence.
	 *
	 * @param riunionePersistence the riunione persistence
	 */
	public void setRiunionePersistence(RiunionePersistence riunionePersistence) {
		this.riunionePersistence = riunionePersistence;
	}

	@BeanReference(type = RiunionePersistence.class)
	protected RiunionePersistence riunionePersistence;
}