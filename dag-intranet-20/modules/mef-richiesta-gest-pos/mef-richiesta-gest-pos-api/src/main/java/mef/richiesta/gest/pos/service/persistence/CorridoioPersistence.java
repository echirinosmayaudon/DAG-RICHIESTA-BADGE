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

package mef.richiesta.gest.pos.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import mef.richiesta.gest.pos.exception.NoSuchCorridoioException;
import mef.richiesta.gest.pos.model.Corridoio;

/**
 * The persistence interface for the corridoio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CorridoioUtil
 * @generated
 */
@ProviderType
public interface CorridoioPersistence extends BasePersistence<Corridoio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CorridoioUtil} to access the corridoio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Corridoio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the corridoio in the entity cache if it is enabled.
	 *
	 * @param corridoio the corridoio
	 */
	public void cacheResult(Corridoio corridoio);

	/**
	 * Caches the corridoios in the entity cache if it is enabled.
	 *
	 * @param corridoios the corridoios
	 */
	public void cacheResult(java.util.List<Corridoio> corridoios);

	/**
	 * Creates a new corridoio with the primary key. Does not add the corridoio to the database.
	 *
	 * @param id_pk_corridoio the primary key for the new corridoio
	 * @return the new corridoio
	 */
	public Corridoio create(long id_pk_corridoio);

	/**
	 * Removes the corridoio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio that was removed
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	public Corridoio remove(long id_pk_corridoio)
		throws NoSuchCorridoioException;

	public Corridoio updateImpl(Corridoio corridoio);

	/**
	 * Returns the corridoio with the primary key or throws a <code>NoSuchCorridoioException</code> if it could not be found.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio
	 * @throws NoSuchCorridoioException if a corridoio with the primary key could not be found
	 */
	public Corridoio findByPrimaryKey(long id_pk_corridoio)
		throws NoSuchCorridoioException;

	/**
	 * Returns the corridoio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio, or <code>null</code> if a corridoio with the primary key could not be found
	 */
	public Corridoio fetchByPrimaryKey(long id_pk_corridoio);

	/**
	 * Returns all the corridoios.
	 *
	 * @return the corridoios
	 */
	public java.util.List<Corridoio> findAll();

	/**
	 * Returns a range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @return the range of corridoios
	 */
	public java.util.List<Corridoio> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of corridoios
	 */
	public java.util.List<Corridoio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Corridoio>
			orderByComparator);

	/**
	 * Returns an ordered range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of corridoios
	 */
	public java.util.List<Corridoio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Corridoio>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the corridoios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of corridoios.
	 *
	 * @return the number of corridoios
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}