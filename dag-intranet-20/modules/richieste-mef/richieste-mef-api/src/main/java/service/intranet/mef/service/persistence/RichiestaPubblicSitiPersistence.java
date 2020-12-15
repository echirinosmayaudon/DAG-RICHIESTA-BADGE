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

import service.intranet.mef.exception.NoSuchRichiestaPubblicSitiException;
import service.intranet.mef.model.RichiestaPubblicSiti;

/**
 * The persistence interface for the richiesta pubblic siti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.RichiestaPubblicSitiPersistenceImpl
 * @see RichiestaPubblicSitiUtil
 * @generated
 */
@ProviderType
public interface RichiestaPubblicSitiPersistence extends BasePersistence<RichiestaPubblicSiti> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaPubblicSitiUtil} to access the richiesta pubblic siti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the richiesta pubblic siti in the entity cache if it is enabled.
	*
	* @param richiestaPubblicSiti the richiesta pubblic siti
	*/
	public void cacheResult(RichiestaPubblicSiti richiestaPubblicSiti);

	/**
	* Caches the richiesta pubblic sitis in the entity cache if it is enabled.
	*
	* @param richiestaPubblicSitis the richiesta pubblic sitis
	*/
	public void cacheResult(
		java.util.List<RichiestaPubblicSiti> richiestaPubblicSitis);

	/**
	* Creates a new richiesta pubblic siti with the primary key. Does not add the richiesta pubblic siti to the database.
	*
	* @param id_rich_pubblic the primary key for the new richiesta pubblic siti
	* @return the new richiesta pubblic siti
	*/
	public RichiestaPubblicSiti create(long id_rich_pubblic);

	/**
	* Removes the richiesta pubblic siti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti that was removed
	* @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	*/
	public RichiestaPubblicSiti remove(long id_rich_pubblic)
		throws NoSuchRichiestaPubblicSitiException;

	public RichiestaPubblicSiti updateImpl(
		RichiestaPubblicSiti richiestaPubblicSiti);

	/**
	* Returns the richiesta pubblic siti with the primary key or throws a {@link NoSuchRichiestaPubblicSitiException} if it could not be found.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti
	* @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	*/
	public RichiestaPubblicSiti findByPrimaryKey(long id_rich_pubblic)
		throws NoSuchRichiestaPubblicSitiException;

	/**
	* Returns the richiesta pubblic siti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti, or <code>null</code> if a richiesta pubblic siti with the primary key could not be found
	*/
	public RichiestaPubblicSiti fetchByPrimaryKey(long id_rich_pubblic);

	@Override
	public java.util.Map<java.io.Serializable, RichiestaPubblicSiti> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richiesta pubblic sitis.
	*
	* @return the richiesta pubblic sitis
	*/
	public java.util.List<RichiestaPubblicSiti> findAll();

	/**
	* Returns a range of all the richiesta pubblic sitis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta pubblic sitis
	* @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	* @return the range of richiesta pubblic sitis
	*/
	public java.util.List<RichiestaPubblicSiti> findAll(int start, int end);

	/**
	* Returns an ordered range of all the richiesta pubblic sitis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta pubblic sitis
	* @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richiesta pubblic sitis
	*/
	public java.util.List<RichiestaPubblicSiti> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaPubblicSiti> orderByComparator);

	/**
	* Returns an ordered range of all the richiesta pubblic sitis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta pubblic sitis
	* @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richiesta pubblic sitis
	*/
	public java.util.List<RichiestaPubblicSiti> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiestaPubblicSiti> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richiesta pubblic sitis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richiesta pubblic sitis.
	*
	* @return the number of richiesta pubblic sitis
	*/
	public int countAll();
}