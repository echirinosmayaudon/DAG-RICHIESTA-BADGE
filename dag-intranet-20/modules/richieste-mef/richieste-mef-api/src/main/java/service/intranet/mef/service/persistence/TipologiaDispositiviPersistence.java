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

import service.intranet.mef.exception.NoSuchTipologiaDispositiviException;
import service.intranet.mef.model.TipologiaDispositivi;

/**
 * The persistence interface for the tipologia dispositivi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.TipologiaDispositiviPersistenceImpl
 * @see TipologiaDispositiviUtil
 * @generated
 */
@ProviderType
public interface TipologiaDispositiviPersistence extends BasePersistence<TipologiaDispositivi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipologiaDispositiviUtil} to access the tipologia dispositivi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipologia dispositivi in the entity cache if it is enabled.
	*
	* @param tipologiaDispositivi the tipologia dispositivi
	*/
	public void cacheResult(TipologiaDispositivi tipologiaDispositivi);

	/**
	* Caches the tipologia dispositivis in the entity cache if it is enabled.
	*
	* @param tipologiaDispositivis the tipologia dispositivis
	*/
	public void cacheResult(
		java.util.List<TipologiaDispositivi> tipologiaDispositivis);

	/**
	* Creates a new tipologia dispositivi with the primary key. Does not add the tipologia dispositivi to the database.
	*
	* @param id_tipologia_dispositivi the primary key for the new tipologia dispositivi
	* @return the new tipologia dispositivi
	*/
	public TipologiaDispositivi create(long id_tipologia_dispositivi);

	/**
	* Removes the tipologia dispositivi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_dispositivi the primary key of the tipologia dispositivi
	* @return the tipologia dispositivi that was removed
	* @throws NoSuchTipologiaDispositiviException if a tipologia dispositivi with the primary key could not be found
	*/
	public TipologiaDispositivi remove(long id_tipologia_dispositivi)
		throws NoSuchTipologiaDispositiviException;

	public TipologiaDispositivi updateImpl(
		TipologiaDispositivi tipologiaDispositivi);

	/**
	* Returns the tipologia dispositivi with the primary key or throws a {@link NoSuchTipologiaDispositiviException} if it could not be found.
	*
	* @param id_tipologia_dispositivi the primary key of the tipologia dispositivi
	* @return the tipologia dispositivi
	* @throws NoSuchTipologiaDispositiviException if a tipologia dispositivi with the primary key could not be found
	*/
	public TipologiaDispositivi findByPrimaryKey(long id_tipologia_dispositivi)
		throws NoSuchTipologiaDispositiviException;

	/**
	* Returns the tipologia dispositivi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipologia_dispositivi the primary key of the tipologia dispositivi
	* @return the tipologia dispositivi, or <code>null</code> if a tipologia dispositivi with the primary key could not be found
	*/
	public TipologiaDispositivi fetchByPrimaryKey(long id_tipologia_dispositivi);

	@Override
	public java.util.Map<java.io.Serializable, TipologiaDispositivi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tipologia dispositivis.
	*
	* @return the tipologia dispositivis
	*/
	public java.util.List<TipologiaDispositivi> findAll();

	/**
	* Returns a range of all the tipologia dispositivis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaDispositiviModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia dispositivis
	* @param end the upper bound of the range of tipologia dispositivis (not inclusive)
	* @return the range of tipologia dispositivis
	*/
	public java.util.List<TipologiaDispositivi> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tipologia dispositivis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaDispositiviModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia dispositivis
	* @param end the upper bound of the range of tipologia dispositivis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipologia dispositivis
	*/
	public java.util.List<TipologiaDispositivi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaDispositivi> orderByComparator);

	/**
	* Returns an ordered range of all the tipologia dispositivis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaDispositiviModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia dispositivis
	* @param end the upper bound of the range of tipologia dispositivis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipologia dispositivis
	*/
	public java.util.List<TipologiaDispositivi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaDispositivi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tipologia dispositivis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tipologia dispositivis.
	*
	* @return the number of tipologia dispositivis
	*/
	public int countAll();
}