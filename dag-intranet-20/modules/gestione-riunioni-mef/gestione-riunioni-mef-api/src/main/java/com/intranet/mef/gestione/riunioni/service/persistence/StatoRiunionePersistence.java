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

import com.intranet.mef.gestione.riunioni.exception.NoSuchStatoRiunioneException;
import com.intranet.mef.gestione.riunioni.model.StatoRiunione;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the stato riunione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.StatoRiunionePersistenceImpl
 * @see StatoRiunioneUtil
 * @generated
 */
@ProviderType
public interface StatoRiunionePersistence extends BasePersistence<StatoRiunione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatoRiunioneUtil} to access the stato riunione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stato riuniones where label = &#63;.
	*
	* @param label the label
	* @return the matching stato riuniones
	*/
	public java.util.List<StatoRiunione> findByStatoRiunione(
		java.lang.String label);

	/**
	* Returns a range of all the stato riuniones where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @return the range of matching stato riuniones
	*/
	public java.util.List<StatoRiunione> findByStatoRiunione(
		java.lang.String label, int start, int end);

	/**
	* Returns an ordered range of all the stato riuniones where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stato riuniones
	*/
	public java.util.List<StatoRiunione> findByStatoRiunione(
		java.lang.String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator);

	/**
	* Returns an ordered range of all the stato riuniones where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stato riuniones
	*/
	public java.util.List<StatoRiunione> findByStatoRiunione(
		java.lang.String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato riunione
	* @throws NoSuchStatoRiunioneException if a matching stato riunione could not be found
	*/
	public StatoRiunione findByStatoRiunione_First(java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator)
		throws NoSuchStatoRiunioneException;

	/**
	* Returns the first stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato riunione, or <code>null</code> if a matching stato riunione could not be found
	*/
	public StatoRiunione fetchByStatoRiunione_First(java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator);

	/**
	* Returns the last stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato riunione
	* @throws NoSuchStatoRiunioneException if a matching stato riunione could not be found
	*/
	public StatoRiunione findByStatoRiunione_Last(java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator)
		throws NoSuchStatoRiunioneException;

	/**
	* Returns the last stato riunione in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato riunione, or <code>null</code> if a matching stato riunione could not be found
	*/
	public StatoRiunione fetchByStatoRiunione_Last(java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator);

	/**
	* Returns the stato riuniones before and after the current stato riunione in the ordered set where label = &#63;.
	*
	* @param id_stato_riunione the primary key of the current stato riunione
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stato riunione
	* @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	*/
	public StatoRiunione[] findByStatoRiunione_PrevAndNext(
		long id_stato_riunione, java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator)
		throws NoSuchStatoRiunioneException;

	/**
	* Removes all the stato riuniones where label = &#63; from the database.
	*
	* @param label the label
	*/
	public void removeByStatoRiunione(java.lang.String label);

	/**
	* Returns the number of stato riuniones where label = &#63;.
	*
	* @param label the label
	* @return the number of matching stato riuniones
	*/
	public int countByStatoRiunione(java.lang.String label);

	/**
	* Caches the stato riunione in the entity cache if it is enabled.
	*
	* @param statoRiunione the stato riunione
	*/
	public void cacheResult(StatoRiunione statoRiunione);

	/**
	* Caches the stato riuniones in the entity cache if it is enabled.
	*
	* @param statoRiuniones the stato riuniones
	*/
	public void cacheResult(java.util.List<StatoRiunione> statoRiuniones);

	/**
	* Creates a new stato riunione with the primary key. Does not add the stato riunione to the database.
	*
	* @param id_stato_riunione the primary key for the new stato riunione
	* @return the new stato riunione
	*/
	public StatoRiunione create(long id_stato_riunione);

	/**
	* Removes the stato riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_riunione the primary key of the stato riunione
	* @return the stato riunione that was removed
	* @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	*/
	public StatoRiunione remove(long id_stato_riunione)
		throws NoSuchStatoRiunioneException;

	public StatoRiunione updateImpl(StatoRiunione statoRiunione);

	/**
	* Returns the stato riunione with the primary key or throws a {@link NoSuchStatoRiunioneException} if it could not be found.
	*
	* @param id_stato_riunione the primary key of the stato riunione
	* @return the stato riunione
	* @throws NoSuchStatoRiunioneException if a stato riunione with the primary key could not be found
	*/
	public StatoRiunione findByPrimaryKey(long id_stato_riunione)
		throws NoSuchStatoRiunioneException;

	/**
	* Returns the stato riunione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_stato_riunione the primary key of the stato riunione
	* @return the stato riunione, or <code>null</code> if a stato riunione with the primary key could not be found
	*/
	public StatoRiunione fetchByPrimaryKey(long id_stato_riunione);

	@Override
	public java.util.Map<java.io.Serializable, StatoRiunione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the stato riuniones.
	*
	* @return the stato riuniones
	*/
	public java.util.List<StatoRiunione> findAll();

	/**
	* Returns a range of all the stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @return the range of stato riuniones
	*/
	public java.util.List<StatoRiunione> findAll(int start, int end);

	/**
	* Returns an ordered range of all the stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato riuniones
	*/
	public java.util.List<StatoRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator);

	/**
	* Returns an ordered range of all the stato riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato riuniones
	* @param end the upper bound of the range of stato riuniones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato riuniones
	*/
	public java.util.List<StatoRiunione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRiunione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the stato riuniones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of stato riuniones.
	*
	* @return the number of stato riuniones
	*/
	public int countAll();
}