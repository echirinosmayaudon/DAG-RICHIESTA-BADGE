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

package servizio.local.bfc.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import servizio.local.bfc.model.LocalRichInfo;
import servizio.local.bfc.service.persistence.LocalRichInfoPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LocalRichInfoFinderBaseImpl extends BasePersistenceImpl<LocalRichInfo> {
	@Override
	public Set<String> getBadColumnNames() {
		return getLocalRichInfoPersistence().getBadColumnNames();
	}

	/**
	 * Returns the local rich info persistence.
	 *
	 * @return the local rich info persistence
	 */
	public LocalRichInfoPersistence getLocalRichInfoPersistence() {
		return localRichInfoPersistence;
	}

	/**
	 * Sets the local rich info persistence.
	 *
	 * @param localRichInfoPersistence the local rich info persistence
	 */
	public void setLocalRichInfoPersistence(
		LocalRichInfoPersistence localRichInfoPersistence) {
		this.localRichInfoPersistence = localRichInfoPersistence;
	}

	@BeanReference(type = LocalRichInfoPersistence.class)
	protected LocalRichInfoPersistence localRichInfoPersistence;
}