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

import com.intranet.mef.gestione.riunioni.exception.NoSuchLuogoException;
import com.intranet.mef.gestione.riunioni.model.Luogo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the luogo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.LuogoPersistenceImpl
 * @see LuogoUtil
 * @generated
 */
@ProviderType
public interface LuogoPersistence extends BasePersistence<Luogo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LuogoUtil} to access the luogo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the luogo in the entity cache if it is enabled.
	*
	* @param luogo the luogo
	*/
	public void cacheResult(Luogo luogo);

	/**
	* Caches the luogos in the entity cache if it is enabled.
	*
	* @param luogos the luogos
	*/
	public void cacheResult(java.util.List<Luogo> luogos);

	/**
	* Creates a new luogo with the primary key. Does not add the luogo to the database.
	*
	* @param id_luogo the primary key for the new luogo
	* @return the new luogo
	*/
	public Luogo create(long id_luogo);

	/**
	* Removes the luogo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo that was removed
	* @throws NoSuchLuogoException if a luogo with the primary key could not be found
	*/
	public Luogo remove(long id_luogo) throws NoSuchLuogoException;

	public Luogo updateImpl(Luogo luogo);

	/**
	* Returns the luogo with the primary key or throws a {@link NoSuchLuogoException} if it could not be found.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo
	* @throws NoSuchLuogoException if a luogo with the primary key could not be found
	*/
	public Luogo findByPrimaryKey(long id_luogo) throws NoSuchLuogoException;

	/**
	* Returns the luogo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo, or <code>null</code> if a luogo with the primary key could not be found
	*/
	public Luogo fetchByPrimaryKey(long id_luogo);

	@Override
	public java.util.Map<java.io.Serializable, Luogo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the luogos.
	*
	* @return the luogos
	*/
	public java.util.List<Luogo> findAll();

	/**
	* Returns a range of all the luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of luogos
	* @param end the upper bound of the range of luogos (not inclusive)
	* @return the range of luogos
	*/
	public java.util.List<Luogo> findAll(int start, int end);

	/**
	* Returns an ordered range of all the luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of luogos
	* @param end the upper bound of the range of luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of luogos
	*/
	public java.util.List<Luogo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Luogo> orderByComparator);

	/**
	* Returns an ordered range of all the luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of luogos
	* @param end the upper bound of the range of luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of luogos
	*/
	public java.util.List<Luogo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Luogo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the luogos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of luogos.
	*
	* @return the number of luogos
	*/
	public int countAll();
}