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

import service.intranet.mef.exception.NoSuchBadgeRichiesteException;
import service.intranet.mef.model.BadgeRichieste;

/**
 * The persistence interface for the badge richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.BadgeRichiestePersistenceImpl
 * @see BadgeRichiesteUtil
 * @generated
 */
@ProviderType
public interface BadgeRichiestePersistence extends BasePersistence<BadgeRichieste> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BadgeRichiesteUtil} to access the badge richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the badge richieste in the entity cache if it is enabled.
	*
	* @param badgeRichieste the badge richieste
	*/
	public void cacheResult(BadgeRichieste badgeRichieste);

	/**
	* Caches the badge richiestes in the entity cache if it is enabled.
	*
	* @param badgeRichiestes the badge richiestes
	*/
	public void cacheResult(java.util.List<BadgeRichieste> badgeRichiestes);

	/**
	* Creates a new badge richieste with the primary key. Does not add the badge richieste to the database.
	*
	* @param id the primary key for the new badge richieste
	* @return the new badge richieste
	*/
	public BadgeRichieste create(long id);

	/**
	* Removes the badge richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the badge richieste
	* @return the badge richieste that was removed
	* @throws NoSuchBadgeRichiesteException if a badge richieste with the primary key could not be found
	*/
	public BadgeRichieste remove(long id) throws NoSuchBadgeRichiesteException;

	public BadgeRichieste updateImpl(BadgeRichieste badgeRichieste);

	/**
	* Returns the badge richieste with the primary key or throws a {@link NoSuchBadgeRichiesteException} if it could not be found.
	*
	* @param id the primary key of the badge richieste
	* @return the badge richieste
	* @throws NoSuchBadgeRichiesteException if a badge richieste with the primary key could not be found
	*/
	public BadgeRichieste findByPrimaryKey(long id)
		throws NoSuchBadgeRichiesteException;

	/**
	* Returns the badge richieste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the badge richieste
	* @return the badge richieste, or <code>null</code> if a badge richieste with the primary key could not be found
	*/
	public BadgeRichieste fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, BadgeRichieste> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the badge richiestes.
	*
	* @return the badge richiestes
	*/
	public java.util.List<BadgeRichieste> findAll();

	/**
	* Returns a range of all the badge richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge richiestes
	* @param end the upper bound of the range of badge richiestes (not inclusive)
	* @return the range of badge richiestes
	*/
	public java.util.List<BadgeRichieste> findAll(int start, int end);

	/**
	* Returns an ordered range of all the badge richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge richiestes
	* @param end the upper bound of the range of badge richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of badge richiestes
	*/
	public java.util.List<BadgeRichieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeRichieste> orderByComparator);

	/**
	* Returns an ordered range of all the badge richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge richiestes
	* @param end the upper bound of the range of badge richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of badge richiestes
	*/
	public java.util.List<BadgeRichieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeRichieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the badge richiestes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of badge richiestes.
	*
	* @return the number of badge richiestes
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}