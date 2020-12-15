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

import external.bfc.intranet.mef.model.SediBfc;
import external.bfc.intranet.mef.service.persistence.SediBfcPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SediBfcFinderBaseImpl extends BasePersistenceImpl<SediBfc> {
	@Override
	public Set<String> getBadColumnNames() {
		return getSediBfcPersistence().getBadColumnNames();
	}

	/**
	 * Returns the sedi bfc persistence.
	 *
	 * @return the sedi bfc persistence
	 */
	public SediBfcPersistence getSediBfcPersistence() {
		return sediBfcPersistence;
	}

	/**
	 * Sets the sedi bfc persistence.
	 *
	 * @param sediBfcPersistence the sedi bfc persistence
	 */
	public void setSediBfcPersistence(SediBfcPersistence sediBfcPersistence) {
		this.sediBfcPersistence = sediBfcPersistence;
	}

	@BeanReference(type = SediBfcPersistence.class)
	protected SediBfcPersistence sediBfcPersistence;
}