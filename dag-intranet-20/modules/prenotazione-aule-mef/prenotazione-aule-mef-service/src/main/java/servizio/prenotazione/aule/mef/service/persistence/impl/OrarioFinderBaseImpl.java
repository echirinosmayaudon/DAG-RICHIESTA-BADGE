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

package servizio.prenotazione.aule.mef.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import servizio.prenotazione.aule.mef.model.Orario;
import servizio.prenotazione.aule.mef.service.persistence.OrarioPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrarioFinderBaseImpl extends BasePersistenceImpl<Orario> {
	/**
	 * Returns the orario persistence.
	 *
	 * @return the orario persistence
	 */
	public OrarioPersistence getOrarioPersistence() {
		return orarioPersistence;
	}

	/**
	 * Sets the orario persistence.
	 *
	 * @param orarioPersistence the orario persistence
	 */
	public void setOrarioPersistence(OrarioPersistence orarioPersistence) {
		this.orarioPersistence = orarioPersistence;
	}

	@BeanReference(type = OrarioPersistence.class)
	protected OrarioPersistence orarioPersistence;
}