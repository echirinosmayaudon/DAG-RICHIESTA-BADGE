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

import servizio.beni.facile.consumo.exception.NoSuchPeriodicitaException;
import servizio.beni.facile.consumo.model.Periodicita;

/**
 * The persistence interface for the periodicita service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.persistence.impl.PeriodicitaPersistenceImpl
 * @see PeriodicitaUtil
 * @generated
 */
@ProviderType
public interface PeriodicitaPersistence extends BasePersistence<Periodicita> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PeriodicitaUtil} to access the periodicita persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the periodicita in the entity cache if it is enabled.
	*
	* @param periodicita the periodicita
	*/
	public void cacheResult(Periodicita periodicita);

	/**
	* Caches the periodicitas in the entity cache if it is enabled.
	*
	* @param periodicitas the periodicitas
	*/
	public void cacheResult(java.util.List<Periodicita> periodicitas);

	/**
	* Creates a new periodicita with the primary key. Does not add the periodicita to the database.
	*
	* @param id the primary key for the new periodicita
	* @return the new periodicita
	*/
	public Periodicita create(long id);

	/**
	* Removes the periodicita with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita that was removed
	* @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	*/
	public Periodicita remove(long id) throws NoSuchPeriodicitaException;

	public Periodicita updateImpl(Periodicita periodicita);

	/**
	* Returns the periodicita with the primary key or throws a {@link NoSuchPeriodicitaException} if it could not be found.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita
	* @throws NoSuchPeriodicitaException if a periodicita with the primary key could not be found
	*/
	public Periodicita findByPrimaryKey(long id)
		throws NoSuchPeriodicitaException;

	/**
	* Returns the periodicita with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita, or <code>null</code> if a periodicita with the primary key could not be found
	*/
	public Periodicita fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Periodicita> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the periodicitas.
	*
	* @return the periodicitas
	*/
	public java.util.List<Periodicita> findAll();

	/**
	* Returns a range of all the periodicitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periodicitas
	* @param end the upper bound of the range of periodicitas (not inclusive)
	* @return the range of periodicitas
	*/
	public java.util.List<Periodicita> findAll(int start, int end);

	/**
	* Returns an ordered range of all the periodicitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periodicitas
	* @param end the upper bound of the range of periodicitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of periodicitas
	*/
	public java.util.List<Periodicita> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Periodicita> orderByComparator);

	/**
	* Returns an ordered range of all the periodicitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periodicitas
	* @param end the upper bound of the range of periodicitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of periodicitas
	*/
	public java.util.List<Periodicita> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Periodicita> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the periodicitas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of periodicitas.
	*
	* @return the number of periodicitas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}