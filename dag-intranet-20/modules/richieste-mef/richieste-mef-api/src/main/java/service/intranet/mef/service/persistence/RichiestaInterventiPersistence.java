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

import service.intranet.mef.exception.NoSuchRichiestaInterventiException;
import service.intranet.mef.model.RichiestaInterventi;

/**
 * The persistence interface for the richiesta interventi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.RichiestaInterventiPersistenceImpl
 * @see RichiestaInterventiUtil
 * @generated
 */
@ProviderType
public interface RichiestaInterventiPersistence extends BasePersistence<RichiestaInterventi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaInterventiUtil} to access the richiesta interventi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the richiesta interventi in the entity cache if it is enabled.
	*
	* @param richiestaInterventi the richiesta interventi
	*/
	public void cacheResult(RichiestaInterventi richiestaInterventi);

	/**
	* Caches the richiesta interventis in the entity cache if it is enabled.
	*
	* @param richiestaInterventis the richiesta interventis
	*/
	public void cacheResult(
		java.util.List<RichiestaInterventi> richiestaInterventis);

	/**
	* Creates a new richiesta interventi with the primary key. Does not add the richiesta interventi to the database.
	*
	* @param id the primary key for the new richiesta interventi
	* @return the new richiesta interventi
	*/
	public RichiestaInterventi create(long id);

	/**
	* Removes the richiesta interventi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the richiesta interventi
	* @return the richiesta interventi that was removed
	* @throws NoSuchRichiestaInterventiException if a richiesta interventi with the primary key could not be found
	*/
	public RichiestaInterventi remove(long id)
		throws NoSuchRichiestaInterventiException;

	public RichiestaInterventi updateImpl(
		RichiestaInterventi richiestaInterventi);

	/**
	* Returns the richiesta interventi with the primary key or throws a {@link NoSuchRichiestaInterventiException} if it could not be found.
	*
	* @param id the primary key of the richiesta interventi
	* @return the richiesta interventi
	* @throws NoSuchRichiestaInterventiException if a richiesta interventi with the primary key could not be found
	*/
	public RichiestaInterventi findByPrimaryKey(long id)
		throws NoSuchRichiestaInterventiException;

	/**
	* Returns the richiesta interventi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the richiesta interventi
	* @return the richiesta interventi, or <code>null</code> if a richiesta interventi with the primary key could not be found
	*/
	public RichiestaInterventi fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, RichiestaInterventi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richiesta interventis.
	*
	* @return the richiesta interventis
	*/
	public java.util.List<RichiestaInterventi> findAll();

	/**
	* Returns a range of all the richiesta interventis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaInterventiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta interventis
	* @param end the upper bound of the range of richiesta interventis (not inclusive)
	* @return the range of richiesta interventis
	*/
	public java.util.List<RichiestaInterventi> findAll(int start, int end);

	/**
	* Returns an ordered range of all the richiesta interventis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaInterventiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta interventis
	* @param end the upper bound of the range of richiesta interventis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richiesta interventis
	*/
	public java.util.List<RichiestaInterventi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaInterventi> orderByComparator);

	/**
	* Returns an ordered range of all the richiesta interventis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaInterventiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta interventis
	* @param end the upper bound of the range of richiesta interventis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richiesta interventis
	*/
	public java.util.List<RichiestaInterventi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaInterventi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richiesta interventis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richiesta interventis.
	*
	* @return the number of richiesta interventis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}