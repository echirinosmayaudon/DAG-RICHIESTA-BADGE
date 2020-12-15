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

package mef.richieste.figli.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import mef.richieste.figli.exception.NoSuchRICHIESTA_RIMBORSOException;
import mef.richieste.figli.model.RICHIESTA_RIMBORSO;

/**
 * The persistence interface for the richiesta_rimborso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RICHIESTA_RIMBORSOUtil
 * @generated
 */
@ProviderType
public interface RICHIESTA_RIMBORSOPersistence
	extends BasePersistence<RICHIESTA_RIMBORSO> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RICHIESTA_RIMBORSOUtil} to access the richiesta_rimborso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RICHIESTA_RIMBORSO> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the richiesta_rimborso in the entity cache if it is enabled.
	 *
	 * @param richiesta_rimborso the richiesta_rimborso
	 */
	public void cacheResult(RICHIESTA_RIMBORSO richiesta_rimborso);

	/**
	 * Caches the richiesta_rimborsos in the entity cache if it is enabled.
	 *
	 * @param richiesta_rimborsos the richiesta_rimborsos
	 */
	public void cacheResult(
		java.util.List<RICHIESTA_RIMBORSO> richiesta_rimborsos);

	/**
	 * Creates a new richiesta_rimborso with the primary key. Does not add the richiesta_rimborso to the database.
	 *
	 * @param Id the primary key for the new richiesta_rimborso
	 * @return the new richiesta_rimborso
	 */
	public RICHIESTA_RIMBORSO create(long Id);

	/**
	 * Removes the richiesta_rimborso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso that was removed
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	public RICHIESTA_RIMBORSO remove(long Id)
		throws NoSuchRICHIESTA_RIMBORSOException;

	public RICHIESTA_RIMBORSO updateImpl(RICHIESTA_RIMBORSO richiesta_rimborso);

	/**
	 * Returns the richiesta_rimborso with the primary key or throws a <code>NoSuchRICHIESTA_RIMBORSOException</code> if it could not be found.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso
	 * @throws NoSuchRICHIESTA_RIMBORSOException if a richiesta_rimborso with the primary key could not be found
	 */
	public RICHIESTA_RIMBORSO findByPrimaryKey(long Id)
		throws NoSuchRICHIESTA_RIMBORSOException;

	/**
	 * Returns the richiesta_rimborso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso, or <code>null</code> if a richiesta_rimborso with the primary key could not be found
	 */
	public RICHIESTA_RIMBORSO fetchByPrimaryKey(long Id);

	/**
	 * Returns all the richiesta_rimborsos.
	 *
	 * @return the richiesta_rimborsos
	 */
	public java.util.List<RICHIESTA_RIMBORSO> findAll();

	/**
	 * Returns a range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @return the range of richiesta_rimborsos
	 */
	public java.util.List<RICHIESTA_RIMBORSO> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta_rimborsos
	 */
	public java.util.List<RICHIESTA_RIMBORSO> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RICHIESTA_RIMBORSO>
			orderByComparator);

	/**
	 * Returns an ordered range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiesta_rimborsos
	 */
	public java.util.List<RICHIESTA_RIMBORSO> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RICHIESTA_RIMBORSO>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the richiesta_rimborsos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of richiesta_rimborsos.
	 *
	 * @return the number of richiesta_rimborsos
	 */
	public int countAll();

}