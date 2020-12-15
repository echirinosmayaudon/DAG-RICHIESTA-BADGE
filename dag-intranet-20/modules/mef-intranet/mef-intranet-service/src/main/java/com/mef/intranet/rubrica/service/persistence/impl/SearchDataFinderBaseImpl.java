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

package com.mef.intranet.rubrica.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import com.mef.intranet.rubrica.model.SearchData;
import com.mef.intranet.rubrica.service.persistence.SearchDataPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SearchDataFinderBaseImpl extends BasePersistenceImpl<SearchData> {
	@Override
	public Set<String> getBadColumnNames() {
		return getSearchDataPersistence().getBadColumnNames();
	}

	/**
	 * Returns the search data persistence.
	 *
	 * @return the search data persistence
	 */
	public SearchDataPersistence getSearchDataPersistence() {
		return searchDataPersistence;
	}

	/**
	 * Sets the search data persistence.
	 *
	 * @param searchDataPersistence the search data persistence
	 */
	public void setSearchDataPersistence(
		SearchDataPersistence searchDataPersistence) {
		this.searchDataPersistence = searchDataPersistence;
	}

	@BeanReference(type = SearchDataPersistence.class)
	protected SearchDataPersistence searchDataPersistence;
}