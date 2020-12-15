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

import service.intranet.mef.exception.NoSuchRichiesteHWException;
import service.intranet.mef.model.RichiesteHW;

/**
 * The persistence interface for the richieste h w service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.RichiesteHWPersistenceImpl
 * @see RichiesteHWUtil
 * @generated
 */
@ProviderType
public interface RichiesteHWPersistence extends BasePersistence<RichiesteHW> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiesteHWUtil} to access the richieste h w persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the richieste h w in the entity cache if it is enabled.
	*
	* @param richiesteHW the richieste h w
	*/
	public void cacheResult(RichiesteHW richiesteHW);

	/**
	* Caches the richieste h ws in the entity cache if it is enabled.
	*
	* @param richiesteHWs the richieste h ws
	*/
	public void cacheResult(java.util.List<RichiesteHW> richiesteHWs);

	/**
	* Creates a new richieste h w with the primary key. Does not add the richieste h w to the database.
	*
	* @param id_richieste_hw the primary key for the new richieste h w
	* @return the new richieste h w
	*/
	public RichiesteHW create(long id_richieste_hw);

	/**
	* Removes the richieste h w with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w that was removed
	* @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	*/
	public RichiesteHW remove(long id_richieste_hw)
		throws NoSuchRichiesteHWException;

	public RichiesteHW updateImpl(RichiesteHW richiesteHW);

	/**
	* Returns the richieste h w with the primary key or throws a {@link NoSuchRichiesteHWException} if it could not be found.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w
	* @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	*/
	public RichiesteHW findByPrimaryKey(long id_richieste_hw)
		throws NoSuchRichiesteHWException;

	/**
	* Returns the richieste h w with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w, or <code>null</code> if a richieste h w with the primary key could not be found
	*/
	public RichiesteHW fetchByPrimaryKey(long id_richieste_hw);

	@Override
	public java.util.Map<java.io.Serializable, RichiesteHW> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richieste h ws.
	*
	* @return the richieste h ws
	*/
	public java.util.List<RichiesteHW> findAll();

	/**
	* Returns a range of all the richieste h ws.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste h ws
	* @param end the upper bound of the range of richieste h ws (not inclusive)
	* @return the range of richieste h ws
	*/
	public java.util.List<RichiesteHW> findAll(int start, int end);

	/**
	* Returns an ordered range of all the richieste h ws.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste h ws
	* @param end the upper bound of the range of richieste h ws (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste h ws
	*/
	public java.util.List<RichiesteHW> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteHW> orderByComparator);

	/**
	* Returns an ordered range of all the richieste h ws.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste h ws
	* @param end the upper bound of the range of richieste h ws (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste h ws
	*/
	public java.util.List<RichiesteHW> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteHW> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richieste h ws from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richieste h ws.
	*
	* @return the number of richieste h ws
	*/
	public int countAll();
}