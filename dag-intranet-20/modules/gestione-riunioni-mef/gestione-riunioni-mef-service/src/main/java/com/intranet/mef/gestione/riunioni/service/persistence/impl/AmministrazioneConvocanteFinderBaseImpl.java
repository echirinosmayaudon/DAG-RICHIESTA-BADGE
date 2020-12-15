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

import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocantePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AmministrazioneConvocanteFinderBaseImpl extends BasePersistenceImpl<AmministrazioneConvocante> {
	/**
	 * Returns the amministrazione convocante persistence.
	 *
	 * @return the amministrazione convocante persistence
	 */
	public AmministrazioneConvocantePersistence getAmministrazioneConvocantePersistence() {
		return amministrazioneConvocantePersistence;
	}

	/**
	 * Sets the amministrazione convocante persistence.
	 *
	 * @param amministrazioneConvocantePersistence the amministrazione convocante persistence
	 */
	public void setAmministrazioneConvocantePersistence(
		AmministrazioneConvocantePersistence amministrazioneConvocantePersistence) {
		this.amministrazioneConvocantePersistence = amministrazioneConvocantePersistence;
	}

	@BeanReference(type = AmministrazioneConvocantePersistence.class)
	protected AmministrazioneConvocantePersistence amministrazioneConvocantePersistence;
}