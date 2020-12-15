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

import external.bfc.intranet.mef.model.RichiesteInfo;
import external.bfc.intranet.mef.service.persistence.RichiesteInfoPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RichiesteInfoFinderBaseImpl extends BasePersistenceImpl<RichiesteInfo> {
	@Override
	public Set<String> getBadColumnNames() {
		return getRichiesteInfoPersistence().getBadColumnNames();
	}

	/**
	 * Returns the richieste info persistence.
	 *
	 * @return the richieste info persistence
	 */
	public RichiesteInfoPersistence getRichiesteInfoPersistence() {
		return richiesteInfoPersistence;
	}

	/**
	 * Sets the richieste info persistence.
	 *
	 * @param richiesteInfoPersistence the richieste info persistence
	 */
	public void setRichiesteInfoPersistence(
		RichiesteInfoPersistence richiesteInfoPersistence) {
		this.richiesteInfoPersistence = richiesteInfoPersistence;
	}

	@BeanReference(type = RichiesteInfoPersistence.class)
	protected RichiesteInfoPersistence richiesteInfoPersistence;
}