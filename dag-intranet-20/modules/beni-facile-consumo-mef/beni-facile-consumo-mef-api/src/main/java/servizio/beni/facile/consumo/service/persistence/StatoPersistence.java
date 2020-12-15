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

package servizio.beni.facile.consumo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.beni.facile.consumo.exception.NoSuchStatoException;
import servizio.beni.facile.consumo.model.Stato;

/**
 * The persistence interface for the stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.persistence.impl.StatoPersistenceImpl
 * @see StatoUtil
 * @generated
 */
@ProviderType
public interface StatoPersistence extends BasePersistence<Stato> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatoUtil} to access the stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the stato in the entity cache if it is enabled.
	*
	* @param stato the stato
	*/
	public void cacheResult(Stato stato);

	/**
	* Caches the statos in the entity cache if it is enabled.
	*
	* @param statos the statos
	*/
	public void cacheResult(java.util.List<Stato> statos);

	/**
	* Creates a new stato with the primary key. Does not add the stato to the database.
	*
	* @param id the primary key for the new stato
	* @return the new stato
	*/
	public Stato create(long id);

	/**
	* Removes the stato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stato
	* @return the stato that was removed
	* @throws NoSuchStatoException if a stato with the primary key could not be found
	*/
	public Stato remove(long id) throws NoSuchStatoException;

	public Stato updateImpl(Stato stato);

	/**
	* Returns the stato with the primary key or throws a {@link NoSuchStatoException} if it could not be found.
	*
	* @param id the primary key of the stato
	* @return the stato
	* @throws NoSuchStatoException if a stato with the primary key could not be found
	*/
	public Stato findByPrimaryKey(long id) throws NoSuchStatoException;

	/**
	* Returns the stato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stato
	* @return the stato, or <code>null</code> if a stato with the primary key could not be found
	*/
	public Stato fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Stato> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the statos.
	*
	* @return the statos
	*/
	public java.util.List<Stato> findAll();

	/**
	* Returns a range of all the statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statos
	* @param end the upper bound of the range of statos (not inclusive)
	* @return the range of statos
	*/
	public java.util.List<Stato> findAll(int start, int end);

	/**
	* Returns an ordered range of all the statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statos
	* @param end the upper bound of the range of statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of statos
	*/
	public java.util.List<Stato> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stato> orderByComparator);

	/**
	* Returns an ordered range of all the statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statos
	* @param end the upper bound of the range of statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of statos
	*/
	public java.util.List<Stato> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stato> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the statos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of statos.
	*
	* @return the number of statos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}