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

package form.service.contributo.solidarieta.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import form.service.contributo.solidarieta.exception.NoSuchDonatoreException;
import form.service.contributo.solidarieta.model.Donatore;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the donatore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonatoreUtil
 * @generated
 */
@ProviderType
public interface DonatorePersistence extends BasePersistence<Donatore> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DonatoreUtil} to access the donatore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Donatore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the donatore in the entity cache if it is enabled.
	 *
	 * @param donatore the donatore
	 */
	public void cacheResult(Donatore donatore);

	/**
	 * Caches the donatores in the entity cache if it is enabled.
	 *
	 * @param donatores the donatores
	 */
	public void cacheResult(java.util.List<Donatore> donatores);

	/**
	 * Creates a new donatore with the primary key. Does not add the donatore to the database.
	 *
	 * @param id the primary key for the new donatore
	 * @return the new donatore
	 */
	public Donatore create(long id);

	/**
	 * Removes the donatore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore that was removed
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	public Donatore remove(long id) throws NoSuchDonatoreException;

	public Donatore updateImpl(Donatore donatore);

	/**
	 * Returns the donatore with the primary key or throws a <code>NoSuchDonatoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore
	 * @throws NoSuchDonatoreException if a donatore with the primary key could not be found
	 */
	public Donatore findByPrimaryKey(long id) throws NoSuchDonatoreException;

	/**
	 * Returns the donatore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore, or <code>null</code> if a donatore with the primary key could not be found
	 */
	public Donatore fetchByPrimaryKey(long id);

	/**
	 * Returns all the donatores.
	 *
	 * @return the donatores
	 */
	public java.util.List<Donatore> findAll();

	/**
	 * Returns a range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @return the range of donatores
	 */
	public java.util.List<Donatore> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of donatores
	 */
	public java.util.List<Donatore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Donatore>
			orderByComparator);

	/**
	 * Returns an ordered range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of donatores
	 */
	public java.util.List<Donatore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Donatore>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the donatores from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of donatores.
	 *
	 * @return the number of donatores
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}