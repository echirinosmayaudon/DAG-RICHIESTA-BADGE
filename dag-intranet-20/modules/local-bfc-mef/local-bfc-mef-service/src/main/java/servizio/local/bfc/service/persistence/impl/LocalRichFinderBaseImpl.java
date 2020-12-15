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

import servizio.local.bfc.model.LocalRich;
import servizio.local.bfc.service.persistence.LocalRichPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LocalRichFinderBaseImpl extends BasePersistenceImpl<LocalRich> {
	@Override
	public Set<String> getBadColumnNames() {
		return getLocalRichPersistence().getBadColumnNames();
	}

	/**
	 * Returns the local rich persistence.
	 *
	 * @return the local rich persistence
	 */
	public LocalRichPersistence getLocalRichPersistence() {
		return localRichPersistence;
	}

	/**
	 * Sets the local rich persistence.
	 *
	 * @param localRichPersistence the local rich persistence
	 */
	public void setLocalRichPersistence(
		LocalRichPersistence localRichPersistence) {
		this.localRichPersistence = localRichPersistence;
	}

	@BeanReference(type = LocalRichPersistence.class)
	protected LocalRichPersistence localRichPersistence;
}