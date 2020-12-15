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

package com.intranet.mef.gestione.riunioni.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.exception.NoSuchSegreteriaException;
import com.intranet.mef.gestione.riunioni.model.Segreteria;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the segreteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.SegreteriaPersistenceImpl
 * @see SegreteriaUtil
 * @generated
 */
@ProviderType
public interface SegreteriaPersistence extends BasePersistence<Segreteria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SegreteriaUtil} to access the segreteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the segreteria in the entity cache if it is enabled.
	*
	* @param segreteria the segreteria
	*/
	public void cacheResult(Segreteria segreteria);

	/**
	* Caches the segreterias in the entity cache if it is enabled.
	*
	* @param segreterias the segreterias
	*/
	public void cacheResult(java.util.List<Segreteria> segreterias);

	/**
	* Creates a new segreteria with the primary key. Does not add the segreteria to the database.
	*
	* @param id_segreteria the primary key for the new segreteria
	* @return the new segreteria
	*/
	public Segreteria create(long id_segreteria);

	/**
	* Removes the segreteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria that was removed
	* @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	*/
	public Segreteria remove(long id_segreteria)
		throws NoSuchSegreteriaException;

	public Segreteria updateImpl(Segreteria segreteria);

	/**
	* Returns the segreteria with the primary key or throws a {@link NoSuchSegreteriaException} if it could not be found.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria
	* @throws NoSuchSegreteriaException if a segreteria with the primary key could not be found
	*/
	public Segreteria findByPrimaryKey(long id_segreteria)
		throws NoSuchSegreteriaException;

	/**
	* Returns the segreteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria, or <code>null</code> if a segreteria with the primary key could not be found
	*/
	public Segreteria fetchByPrimaryKey(long id_segreteria);

	@Override
	public java.util.Map<java.io.Serializable, Segreteria> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the segreterias.
	*
	* @return the segreterias
	*/
	public java.util.List<Segreteria> findAll();

	/**
	* Returns a range of all the segreterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segreterias
	* @param end the upper bound of the range of segreterias (not inclusive)
	* @return the range of segreterias
	*/
	public java.util.List<Segreteria> findAll(int start, int end);

	/**
	* Returns an ordered range of all the segreterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segreterias
	* @param end the upper bound of the range of segreterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of segreterias
	*/
	public java.util.List<Segreteria> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segreteria> orderByComparator);

	/**
	* Returns an ordered range of all the segreterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segreterias
	* @param end the upper bound of the range of segreterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of segreterias
	*/
	public java.util.List<Segreteria> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Segreteria> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the segreterias from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of segreterias.
	*
	* @return the number of segreterias
	*/
	public int countAll();
}