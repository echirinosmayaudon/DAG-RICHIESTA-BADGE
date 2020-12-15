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

package servizio.prenotazione.aule.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.prenotazione.aule.mef.exception.NoSuchSalaException;
import servizio.prenotazione.aule.mef.model.Sala;

/**
 * The persistence interface for the sala service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.SalaPersistenceImpl
 * @see SalaUtil
 * @generated
 */
@ProviderType
public interface SalaPersistence extends BasePersistence<Sala> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalaUtil} to access the sala persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the sala in the entity cache if it is enabled.
	*
	* @param sala the sala
	*/
	public void cacheResult(Sala sala);

	/**
	* Caches the salas in the entity cache if it is enabled.
	*
	* @param salas the salas
	*/
	public void cacheResult(java.util.List<Sala> salas);

	/**
	* Creates a new sala with the primary key. Does not add the sala to the database.
	*
	* @param id_sala the primary key for the new sala
	* @return the new sala
	*/
	public Sala create(long id_sala);

	/**
	* Removes the sala with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_sala the primary key of the sala
	* @return the sala that was removed
	* @throws NoSuchSalaException if a sala with the primary key could not be found
	*/
	public Sala remove(long id_sala) throws NoSuchSalaException;

	public Sala updateImpl(Sala sala);

	/**
	* Returns the sala with the primary key or throws a {@link NoSuchSalaException} if it could not be found.
	*
	* @param id_sala the primary key of the sala
	* @return the sala
	* @throws NoSuchSalaException if a sala with the primary key could not be found
	*/
	public Sala findByPrimaryKey(long id_sala) throws NoSuchSalaException;

	/**
	* Returns the sala with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_sala the primary key of the sala
	* @return the sala, or <code>null</code> if a sala with the primary key could not be found
	*/
	public Sala fetchByPrimaryKey(long id_sala);

	@Override
	public java.util.Map<java.io.Serializable, Sala> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the salas.
	*
	* @return the salas
	*/
	public java.util.List<Sala> findAll();

	/**
	* Returns a range of all the salas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salas
	* @param end the upper bound of the range of salas (not inclusive)
	* @return the range of salas
	*/
	public java.util.List<Sala> findAll(int start, int end);

	/**
	* Returns an ordered range of all the salas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salas
	* @param end the upper bound of the range of salas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of salas
	*/
	public java.util.List<Sala> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sala> orderByComparator);

	/**
	* Returns an ordered range of all the salas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of salas
	* @param end the upper bound of the range of salas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of salas
	*/
	public java.util.List<Sala> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sala> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the salas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of salas.
	*
	* @return the number of salas
	*/
	public int countAll();
}