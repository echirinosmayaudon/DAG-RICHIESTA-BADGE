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

package service.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import service.intranet.mef.exception.NoSuchRichiesteUtenzaException;
import service.intranet.mef.model.RichiesteUtenza;

/**
 * The persistence interface for the richieste utenza service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.RichiesteUtenzaPersistenceImpl
 * @see RichiesteUtenzaUtil
 * @generated
 */
@ProviderType
public interface RichiesteUtenzaPersistence extends BasePersistence<RichiesteUtenza> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiesteUtenzaUtil} to access the richieste utenza persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the richieste utenza in the entity cache if it is enabled.
	*
	* @param richiesteUtenza the richieste utenza
	*/
	public void cacheResult(RichiesteUtenza richiesteUtenza);

	/**
	* Caches the richieste utenzas in the entity cache if it is enabled.
	*
	* @param richiesteUtenzas the richieste utenzas
	*/
	public void cacheResult(java.util.List<RichiesteUtenza> richiesteUtenzas);

	/**
	* Creates a new richieste utenza with the primary key. Does not add the richieste utenza to the database.
	*
	* @param id_richieste_utenza the primary key for the new richieste utenza
	* @return the new richieste utenza
	*/
	public RichiesteUtenza create(long id_richieste_utenza);

	/**
	* Removes the richieste utenza with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richieste_utenza the primary key of the richieste utenza
	* @return the richieste utenza that was removed
	* @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	*/
	public RichiesteUtenza remove(long id_richieste_utenza)
		throws NoSuchRichiesteUtenzaException;

	public RichiesteUtenza updateImpl(RichiesteUtenza richiesteUtenza);

	/**
	* Returns the richieste utenza with the primary key or throws a {@link NoSuchRichiesteUtenzaException} if it could not be found.
	*
	* @param id_richieste_utenza the primary key of the richieste utenza
	* @return the richieste utenza
	* @throws NoSuchRichiesteUtenzaException if a richieste utenza with the primary key could not be found
	*/
	public RichiesteUtenza findByPrimaryKey(long id_richieste_utenza)
		throws NoSuchRichiesteUtenzaException;

	/**
	* Returns the richieste utenza with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_richieste_utenza the primary key of the richieste utenza
	* @return the richieste utenza, or <code>null</code> if a richieste utenza with the primary key could not be found
	*/
	public RichiesteUtenza fetchByPrimaryKey(long id_richieste_utenza);

	@Override
	public java.util.Map<java.io.Serializable, RichiesteUtenza> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richieste utenzas.
	*
	* @return the richieste utenzas
	*/
	public java.util.List<RichiesteUtenza> findAll();

	/**
	* Returns a range of all the richieste utenzas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste utenzas
	* @param end the upper bound of the range of richieste utenzas (not inclusive)
	* @return the range of richieste utenzas
	*/
	public java.util.List<RichiesteUtenza> findAll(int start, int end);

	/**
	* Returns an ordered range of all the richieste utenzas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste utenzas
	* @param end the upper bound of the range of richieste utenzas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste utenzas
	*/
	public java.util.List<RichiesteUtenza> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteUtenza> orderByComparator);

	/**
	* Returns an ordered range of all the richieste utenzas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteUtenzaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste utenzas
	* @param end the upper bound of the range of richieste utenzas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste utenzas
	*/
	public java.util.List<RichiesteUtenza> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteUtenza> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richieste utenzas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richieste utenzas.
	*
	* @return the number of richieste utenzas
	*/
	public int countAll();
}