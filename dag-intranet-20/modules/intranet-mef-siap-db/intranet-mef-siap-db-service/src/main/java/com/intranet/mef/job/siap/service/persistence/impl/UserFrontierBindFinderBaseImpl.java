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

package com.intranet.mef.job.siap.service.persistence.impl;

import com.intranet.mef.job.siap.model.UserFrontierBind;
import com.intranet.mef.job.siap.service.persistence.UserFrontierBindPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserFrontierBindFinderBaseImpl extends BasePersistenceImpl<UserFrontierBind> {
	@Override
	public Set<String> getBadColumnNames() {
		return getUserFrontierBindPersistence().getBadColumnNames();
	}

	/**
	 * Returns the user frontier bind persistence.
	 *
	 * @return the user frontier bind persistence
	 */
	public UserFrontierBindPersistence getUserFrontierBindPersistence() {
		return userFrontierBindPersistence;
	}

	/**
	 * Sets the user frontier bind persistence.
	 *
	 * @param userFrontierBindPersistence the user frontier bind persistence
	 */
	public void setUserFrontierBindPersistence(
		UserFrontierBindPersistence userFrontierBindPersistence) {
		this.userFrontierBindPersistence = userFrontierBindPersistence;
	}

	@BeanReference(type = UserFrontierBindPersistence.class)
	protected UserFrontierBindPersistence userFrontierBindPersistence;
}