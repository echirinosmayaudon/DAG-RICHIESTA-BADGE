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

import com.intranet.mef.gestione.riunioni.exception.NoSuchStoricoStatoRiunioneException;
import com.intranet.mef.gestione.riunioni.model.StoricoStatoRiunione;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the storico stato riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.StoricoStatoRiunionePersistenceImpl
 * @see StoricoStatoRiunioneUtil
 * @generated
 */
@ProviderType
public interface StoricoStatoRiunionePersistence extends BasePersistence<StoricoStatoRiunione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StoricoStatoRiunioneUtil} to access the storico stato riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the storico stato riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the matching storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione);

	/**
	* Returns a range of all the storico stato riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @return the range of matching storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione, int start, int end);

	/**
	* Returns an ordered range of all the storico stato riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator);

	/**
	* Returns an ordered range of all the storico stato riuniones where id_riunione = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_riunione the id_riunione
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findByStoricoRiunione(
		long id_riunione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a matching storico stato riunione could not be found
	*/
	public StoricoStatoRiunione findByStoricoRiunione_First(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws NoSuchStoricoStatoRiunioneException;

	/**
	* Returns the first storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching storico stato riunione, or <code>null</code> if a matching storico stato riunione could not be found
	*/
	public StoricoStatoRiunione fetchByStoricoRiunione_First(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator);

	/**
	* Returns the last storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a matching storico stato riunione could not be found
	*/
	public StoricoStatoRiunione findByStoricoRiunione_Last(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws NoSuchStoricoStatoRiunioneException;

	/**
	* Returns the last storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching storico stato riunione, or <code>null</code> if a matching storico stato riunione could not be found
	*/
	public StoricoStatoRiunione fetchByStoricoRiunione_Last(long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator);

	/**
	* Returns the storico stato riuniones before and after the current storico stato riunione in the ordered set where id_riunione = &#63;.
	*
	* @param storicoStatoRiunionePK the primary key of the current storico stato riunione
	* @param id_riunione the id_riunione
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	*/
	public StoricoStatoRiunione[] findByStoricoRiunione_PrevAndNext(
		StoricoStatoRiunionePK storicoStatoRiunionePK, long id_riunione,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator)
		throws NoSuchStoricoStatoRiunioneException;

	/**
	* Removes all the storico stato riuniones where id_riunione = &#63; from the database.
	*
	* @param id_riunione the id_riunione
	*/
	public void removeByStoricoRiunione(long id_riunione);

	/**
	* Returns the number of storico stato riuniones where id_riunione = &#63;.
	*
	* @param id_riunione the id_riunione
	* @return the number of matching storico stato riuniones
	*/
	public int countByStoricoRiunione(long id_riunione);

	/**
	* Caches the storico stato riunione in the entity cache if it is enabled.
	*
	* @param storicoStatoRiunione the storico stato riunione
	*/
	public void cacheResult(StoricoStatoRiunione storicoStatoRiunione);

	/**
	* Caches the storico stato riuniones in the entity cache if it is enabled.
	*
	* @param storicoStatoRiuniones the storico stato riuniones
	*/
	public void cacheResult(
		java.util.List<StoricoStatoRiunione> storicoStatoRiuniones);

	/**
	* Creates a new storico stato riunione with the primary key. Does not add the storico stato riunione to the database.
	*
	* @param storicoStatoRiunionePK the primary key for the new storico stato riunione
	* @return the new storico stato riunione
	*/
	public StoricoStatoRiunione create(
		StoricoStatoRiunionePK storicoStatoRiunionePK);

	/**
	* Removes the storico stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione that was removed
	* @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	*/
	public StoricoStatoRiunione remove(
		StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws NoSuchStoricoStatoRiunioneException;

	public StoricoStatoRiunione updateImpl(
		StoricoStatoRiunione storicoStatoRiunione);

	/**
	* Returns the storico stato riunione with the primary key or throws a {@link NoSuchStoricoStatoRiunioneException} if it could not be found.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione
	* @throws NoSuchStoricoStatoRiunioneException if a storico stato riunione with the primary key could not be found
	*/
	public StoricoStatoRiunione findByPrimaryKey(
		StoricoStatoRiunionePK storicoStatoRiunionePK)
		throws NoSuchStoricoStatoRiunioneException;

	/**
	* Returns the storico stato riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param storicoStatoRiunionePK the primary key of the storico stato riunione
	* @return the storico stato riunione, or <code>null</code> if a storico stato riunione with the primary key could not be found
	*/
	public StoricoStatoRiunione fetchByPrimaryKey(
		StoricoStatoRiunionePK storicoStatoRiunionePK);

	@Override
	public java.util.Map<java.io.Serializable, StoricoStatoRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the storico stato riuniones.
	*
	* @return the storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findAll();

	/**
	* Returns a range of all the storico stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @return the range of storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findAll(int start, int end);

	/**
	* Returns an ordered range of all the storico stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator);

	/**
	* Returns an ordered range of all the storico stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoricoStatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of storico stato riuniones
	* @param end the upper bound of the range of storico stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of storico stato riuniones
	*/
	public java.util.List<StoricoStatoRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoricoStatoRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the storico stato riuniones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of storico stato riuniones.
	*
	* @return the number of storico stato riuniones
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}