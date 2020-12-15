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

import mef.richiesta.gest.pos.exception.NoSuchFuoriPortaException;
import mef.richiesta.gest.pos.model.FuoriPorta;

/**
 * The persistence interface for the fuori porta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FuoriPortaUtil
 * @generated
 */
@ProviderType
public interface FuoriPortaPersistence extends BasePersistence<FuoriPorta> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FuoriPortaUtil} to access the fuori porta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, FuoriPorta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the fuori porta in the entity cache if it is enabled.
	 *
	 * @param fuoriPorta the fuori porta
	 */
	public void cacheResult(FuoriPorta fuoriPorta);

	/**
	 * Caches the fuori portas in the entity cache if it is enabled.
	 *
	 * @param fuoriPortas the fuori portas
	 */
	public void cacheResult(java.util.List<FuoriPorta> fuoriPortas);

	/**
	 * Creates a new fuori porta with the primary key. Does not add the fuori porta to the database.
	 *
	 * @param id_pk_fuoriPorta the primary key for the new fuori porta
	 * @return the new fuori porta
	 */
	public FuoriPorta create(long id_pk_fuoriPorta);

	/**
	 * Removes the fuori porta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta that was removed
	 * @throws NoSuchFuoriPortaException if a fuori porta with the primary key could not be found
	 */
	public FuoriPorta remove(long id_pk_fuoriPorta)
		throws NoSuchFuoriPortaException;

	public FuoriPorta updateImpl(FuoriPorta fuoriPorta);

	/**
	 * Returns the fuori porta with the primary key or throws a <code>NoSuchFuoriPortaException</code> if it could not be found.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta
	 * @throws NoSuchFuoriPortaException if a fuori porta with the primary key could not be found
	 */
	public FuoriPorta findByPrimaryKey(long id_pk_fuoriPorta)
		throws NoSuchFuoriPortaException;

	/**
	 * Returns the fuori porta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta, or <code>null</code> if a fuori porta with the primary key could not be found
	 */
	public FuoriPorta fetchByPrimaryKey(long id_pk_fuoriPorta);

	/**
	 * Returns all the fuori portas.
	 *
	 * @return the fuori portas
	 */
	public java.util.List<FuoriPorta> findAll();

	/**
	 * Returns a range of all the fuori portas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fuori portas
	 * @param end the upper bound of the range of fuori portas (not inclusive)
	 * @return the range of fuori portas
	 */
	public java.util.List<FuoriPorta> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the fuori portas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fuori portas
	 * @param end the upper bound of the range of fuori portas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fuori portas
	 */
	public java.util.List<FuoriPorta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FuoriPorta>
			orderByComparator);

	/**
	 * Returns an ordered range of all the fuori portas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fuori portas
	 * @param end the upper bound of the range of fuori portas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fuori portas
	 */
	public java.util.List<FuoriPorta> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FuoriPorta>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the fuori portas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fuori portas.
	 *
	 * @return the number of fuori portas
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}