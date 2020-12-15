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

import com.intranet.mef.gestione.riunioni.exception.NoSuchTipoRiunioneException;
import com.intranet.mef.gestione.riunioni.model.TipoRiunione;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the tipo riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.TipoRiunionePersistenceImpl
 * @see TipoRiunioneUtil
 * @generated
 */
@ProviderType
public interface TipoRiunionePersistence extends BasePersistence<TipoRiunione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipoRiunioneUtil} to access the tipo riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipo riunione in the entity cache if it is enabled.
	*
	* @param tipoRiunione the tipo riunione
	*/
	public void cacheResult(TipoRiunione tipoRiunione);

	/**
	* Caches the tipo riuniones in the entity cache if it is enabled.
	*
	* @param tipoRiuniones the tipo riuniones
	*/
	public void cacheResult(java.util.List<TipoRiunione> tipoRiuniones);

	/**
	* Creates a new tipo riunione with the primary key. Does not add the tipo riunione to the database.
	*
	* @param id_tipo the primary key for the new tipo riunione
	* @return the new tipo riunione
	*/
	public TipoRiunione create(long id_tipo);

	/**
	* Removes the tipo riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione that was removed
	* @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	*/
	public TipoRiunione remove(long id_tipo) throws NoSuchTipoRiunioneException;

	public TipoRiunione updateImpl(TipoRiunione tipoRiunione);

	/**
	* Returns the tipo riunione with the primary key or throws a {@link NoSuchTipoRiunioneException} if it could not be found.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione
	* @throws NoSuchTipoRiunioneException if a tipo riunione with the primary key could not be found
	*/
	public TipoRiunione findByPrimaryKey(long id_tipo)
		throws NoSuchTipoRiunioneException;

	/**
	* Returns the tipo riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipo the primary key of the tipo riunione
	* @return the tipo riunione, or <code>null</code> if a tipo riunione with the primary key could not be found
	*/
	public TipoRiunione fetchByPrimaryKey(long id_tipo);

	@Override
	public java.util.Map<java.io.Serializable, TipoRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tipo riuniones.
	*
	* @return the tipo riuniones
	*/
	public java.util.List<TipoRiunione> findAll();

	/**
	* Returns a range of all the tipo riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo riuniones
	* @param end the upper bound of the range of tipo riuniones (not inclusive)
	* @return the range of tipo riuniones
	*/
	public java.util.List<TipoRiunione> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tipo riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo riuniones
	* @param end the upper bound of the range of tipo riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo riuniones
	*/
	public java.util.List<TipoRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoRiunione> orderByComparator);

	/**
	* Returns an ordered range of all the tipo riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo riuniones
	* @param end the upper bound of the range of tipo riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipo riuniones
	*/
	public java.util.List<TipoRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tipo riuniones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tipo riuniones.
	*
	* @return the number of tipo riuniones
	*/
	public int countAll();
}