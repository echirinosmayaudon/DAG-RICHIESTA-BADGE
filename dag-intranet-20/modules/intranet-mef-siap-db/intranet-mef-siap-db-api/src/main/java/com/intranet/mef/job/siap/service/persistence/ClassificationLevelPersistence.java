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

package com.intranet.mef.job.siap.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.exception.NoSuchClassificationLevelException;
import com.intranet.mef.job.siap.model.ClassificationLevel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the classification level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.job.siap.service.persistence.impl.ClassificationLevelPersistenceImpl
 * @see ClassificationLevelUtil
 * @generated
 */
@ProviderType
public interface ClassificationLevelPersistence extends BasePersistence<ClassificationLevel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClassificationLevelUtil} to access the classification level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the classification level in the entity cache if it is enabled.
	*
	* @param classificationLevel the classification level
	*/
	public void cacheResult(ClassificationLevel classificationLevel);

	/**
	* Caches the classification levels in the entity cache if it is enabled.
	*
	* @param classificationLevels the classification levels
	*/
	public void cacheResult(
		java.util.List<ClassificationLevel> classificationLevels);

	/**
	* Creates a new classification level with the primary key. Does not add the classification level to the database.
	*
	* @param levelID the primary key for the new classification level
	* @return the new classification level
	*/
	public ClassificationLevel create(long levelID);

	/**
	* Removes the classification level with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param levelID the primary key of the classification level
	* @return the classification level that was removed
	* @throws NoSuchClassificationLevelException if a classification level with the primary key could not be found
	*/
	public ClassificationLevel remove(long levelID)
		throws NoSuchClassificationLevelException;

	public ClassificationLevel updateImpl(
		ClassificationLevel classificationLevel);

	/**
	* Returns the classification level with the primary key or throws a {@link NoSuchClassificationLevelException} if it could not be found.
	*
	* @param levelID the primary key of the classification level
	* @return the classification level
	* @throws NoSuchClassificationLevelException if a classification level with the primary key could not be found
	*/
	public ClassificationLevel findByPrimaryKey(long levelID)
		throws NoSuchClassificationLevelException;

	/**
	* Returns the classification level with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param levelID the primary key of the classification level
	* @return the classification level, or <code>null</code> if a classification level with the primary key could not be found
	*/
	public ClassificationLevel fetchByPrimaryKey(long levelID);

	@Override
	public java.util.Map<java.io.Serializable, ClassificationLevel> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the classification levels.
	*
	* @return the classification levels
	*/
	public java.util.List<ClassificationLevel> findAll();

	/**
	* Returns a range of all the classification levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClassificationLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of classification levels
	* @param end the upper bound of the range of classification levels (not inclusive)
	* @return the range of classification levels
	*/
	public java.util.List<ClassificationLevel> findAll(int start, int end);

	/**
	* Returns an ordered range of all the classification levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClassificationLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of classification levels
	* @param end the upper bound of the range of classification levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of classification levels
	*/
	public java.util.List<ClassificationLevel> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClassificationLevel> orderByComparator);

	/**
	* Returns an ordered range of all the classification levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClassificationLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of classification levels
	* @param end the upper bound of the range of classification levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of classification levels
	*/
	public java.util.List<ClassificationLevel> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ClassificationLevel> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the classification levels from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of classification levels.
	*
	* @return the number of classification levels
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}