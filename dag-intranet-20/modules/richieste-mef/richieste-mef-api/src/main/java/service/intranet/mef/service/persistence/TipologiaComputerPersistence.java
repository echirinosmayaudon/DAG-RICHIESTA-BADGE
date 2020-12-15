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

import service.intranet.mef.exception.NoSuchTipologiaComputerException;
import service.intranet.mef.model.TipologiaComputer;

/**
 * The persistence interface for the tipologia computer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.TipologiaComputerPersistenceImpl
 * @see TipologiaComputerUtil
 * @generated
 */
@ProviderType
public interface TipologiaComputerPersistence extends BasePersistence<TipologiaComputer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipologiaComputerUtil} to access the tipologia computer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipologia computer in the entity cache if it is enabled.
	*
	* @param tipologiaComputer the tipologia computer
	*/
	public void cacheResult(TipologiaComputer tipologiaComputer);

	/**
	* Caches the tipologia computers in the entity cache if it is enabled.
	*
	* @param tipologiaComputers the tipologia computers
	*/
	public void cacheResult(
		java.util.List<TipologiaComputer> tipologiaComputers);

	/**
	* Creates a new tipologia computer with the primary key. Does not add the tipologia computer to the database.
	*
	* @param id_tipologia_computer the primary key for the new tipologia computer
	* @return the new tipologia computer
	*/
	public TipologiaComputer create(long id_tipologia_computer);

	/**
	* Removes the tipologia computer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer that was removed
	* @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	*/
	public TipologiaComputer remove(long id_tipologia_computer)
		throws NoSuchTipologiaComputerException;

	public TipologiaComputer updateImpl(TipologiaComputer tipologiaComputer);

	/**
	* Returns the tipologia computer with the primary key or throws a {@link NoSuchTipologiaComputerException} if it could not be found.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer
	* @throws NoSuchTipologiaComputerException if a tipologia computer with the primary key could not be found
	*/
	public TipologiaComputer findByPrimaryKey(long id_tipologia_computer)
		throws NoSuchTipologiaComputerException;

	/**
	* Returns the tipologia computer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer, or <code>null</code> if a tipologia computer with the primary key could not be found
	*/
	public TipologiaComputer fetchByPrimaryKey(long id_tipologia_computer);

	@Override
	public java.util.Map<java.io.Serializable, TipologiaComputer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tipologia computers.
	*
	* @return the tipologia computers
	*/
	public java.util.List<TipologiaComputer> findAll();

	/**
	* Returns a range of all the tipologia computers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia computers
	* @param end the upper bound of the range of tipologia computers (not inclusive)
	* @return the range of tipologia computers
	*/
	public java.util.List<TipologiaComputer> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tipologia computers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia computers
	* @param end the upper bound of the range of tipologia computers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipologia computers
	*/
	public java.util.List<TipologiaComputer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaComputer> orderByComparator);

	/**
	* Returns an ordered range of all the tipologia computers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia computers
	* @param end the upper bound of the range of tipologia computers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipologia computers
	*/
	public java.util.List<TipologiaComputer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaComputer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tipologia computers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tipologia computers.
	*
	* @return the number of tipologia computers
	*/
	public int countAll();
}