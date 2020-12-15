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

import com.intranet.mef.gestione.riunioni.exception.NoSuchRiunioneException;
import com.intranet.mef.gestione.riunioni.model.Riunione;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.RiunionePersistenceImpl
 * @see RiunioneUtil
 * @generated
 */
@ProviderType
public interface RiunionePersistence extends BasePersistence<Riunione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RiunioneUtil} to access the riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the riunione in the entity cache if it is enabled.
	*
	* @param riunione the riunione
	*/
	public void cacheResult(Riunione riunione);

	/**
	* Caches the riuniones in the entity cache if it is enabled.
	*
	* @param riuniones the riuniones
	*/
	public void cacheResult(java.util.List<Riunione> riuniones);

	/**
	* Creates a new riunione with the primary key. Does not add the riunione to the database.
	*
	* @param id_riunione the primary key for the new riunione
	* @return the new riunione
	*/
	public Riunione create(long id_riunione);

	/**
	* Removes the riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione that was removed
	* @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	*/
	public Riunione remove(long id_riunione) throws NoSuchRiunioneException;

	public Riunione updateImpl(Riunione riunione);

	/**
	* Returns the riunione with the primary key or throws a {@link NoSuchRiunioneException} if it could not be found.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione
	* @throws NoSuchRiunioneException if a riunione with the primary key could not be found
	*/
	public Riunione findByPrimaryKey(long id_riunione)
		throws NoSuchRiunioneException;

	/**
	* Returns the riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione, or <code>null</code> if a riunione with the primary key could not be found
	*/
	public Riunione fetchByPrimaryKey(long id_riunione);

	@Override
	public java.util.Map<java.io.Serializable, Riunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the riuniones.
	*
	* @return the riuniones
	*/
	public java.util.List<Riunione> findAll();

	/**
	* Returns a range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @return the range of riuniones
	*/
	public java.util.List<Riunione> findAll(int start, int end);

	/**
	* Returns an ordered range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of riuniones
	*/
	public java.util.List<Riunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Riunione> orderByComparator);

	/**
	* Returns an ordered range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of riuniones
	*/
	public java.util.List<Riunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Riunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the riuniones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of riuniones.
	*
	* @return the number of riuniones
	*/
	public int countAll();
}