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

import servizio.prenotazione.aule.mef.exception.NoSuchStatoAulaException;
import servizio.prenotazione.aule.mef.model.StatoAula;

/**
 * The persistence interface for the stato aula service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.StatoAulaPersistenceImpl
 * @see StatoAulaUtil
 * @generated
 */
@ProviderType
public interface StatoAulaPersistence extends BasePersistence<StatoAula> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatoAulaUtil} to access the stato aula persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the stato aula in the entity cache if it is enabled.
	*
	* @param statoAula the stato aula
	*/
	public void cacheResult(StatoAula statoAula);

	/**
	* Caches the stato aulas in the entity cache if it is enabled.
	*
	* @param statoAulas the stato aulas
	*/
	public void cacheResult(java.util.List<StatoAula> statoAulas);

	/**
	* Creates a new stato aula with the primary key. Does not add the stato aula to the database.
	*
	* @param id_stato_aula the primary key for the new stato aula
	* @return the new stato aula
	*/
	public StatoAula create(long id_stato_aula);

	/**
	* Removes the stato aula with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula that was removed
	* @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	*/
	public StatoAula remove(long id_stato_aula) throws NoSuchStatoAulaException;

	public StatoAula updateImpl(StatoAula statoAula);

	/**
	* Returns the stato aula with the primary key or throws a {@link NoSuchStatoAulaException} if it could not be found.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula
	* @throws NoSuchStatoAulaException if a stato aula with the primary key could not be found
	*/
	public StatoAula findByPrimaryKey(long id_stato_aula)
		throws NoSuchStatoAulaException;

	/**
	* Returns the stato aula with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula, or <code>null</code> if a stato aula with the primary key could not be found
	*/
	public StatoAula fetchByPrimaryKey(long id_stato_aula);

	@Override
	public java.util.Map<java.io.Serializable, StatoAula> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the stato aulas.
	*
	* @return the stato aulas
	*/
	public java.util.List<StatoAula> findAll();

	/**
	* Returns a range of all the stato aulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato aulas
	* @param end the upper bound of the range of stato aulas (not inclusive)
	* @return the range of stato aulas
	*/
	public java.util.List<StatoAula> findAll(int start, int end);

	/**
	* Returns an ordered range of all the stato aulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato aulas
	* @param end the upper bound of the range of stato aulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato aulas
	*/
	public java.util.List<StatoAula> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAula> orderByComparator);

	/**
	* Returns an ordered range of all the stato aulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato aulas
	* @param end the upper bound of the range of stato aulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato aulas
	*/
	public java.util.List<StatoAula> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAula> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the stato aulas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of stato aulas.
	*
	* @return the number of stato aulas
	*/
	public int countAll();
}