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

import service.intranet.mef.exception.NoSuchLogisticaServizioException;
import service.intranet.mef.model.LogisticaServizio;

/**
 * The persistence interface for the logistica servizio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.LogisticaServizioPersistenceImpl
 * @see LogisticaServizioUtil
 * @generated
 */
@ProviderType
public interface LogisticaServizioPersistence extends BasePersistence<LogisticaServizio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogisticaServizioUtil} to access the logistica servizio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the logistica servizio in the entity cache if it is enabled.
	*
	* @param logisticaServizio the logistica servizio
	*/
	public void cacheResult(LogisticaServizio logisticaServizio);

	/**
	* Caches the logistica servizios in the entity cache if it is enabled.
	*
	* @param logisticaServizios the logistica servizios
	*/
	public void cacheResult(
		java.util.List<LogisticaServizio> logisticaServizios);

	/**
	* Creates a new logistica servizio with the primary key. Does not add the logistica servizio to the database.
	*
	* @param id the primary key for the new logistica servizio
	* @return the new logistica servizio
	*/
	public LogisticaServizio create(long id);

	/**
	* Removes the logistica servizio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica servizio
	* @return the logistica servizio that was removed
	* @throws NoSuchLogisticaServizioException if a logistica servizio with the primary key could not be found
	*/
	public LogisticaServizio remove(long id)
		throws NoSuchLogisticaServizioException;

	public LogisticaServizio updateImpl(LogisticaServizio logisticaServizio);

	/**
	* Returns the logistica servizio with the primary key or throws a {@link NoSuchLogisticaServizioException} if it could not be found.
	*
	* @param id the primary key of the logistica servizio
	* @return the logistica servizio
	* @throws NoSuchLogisticaServizioException if a logistica servizio with the primary key could not be found
	*/
	public LogisticaServizio findByPrimaryKey(long id)
		throws NoSuchLogisticaServizioException;

	/**
	* Returns the logistica servizio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the logistica servizio
	* @return the logistica servizio, or <code>null</code> if a logistica servizio with the primary key could not be found
	*/
	public LogisticaServizio fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, LogisticaServizio> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the logistica servizios.
	*
	* @return the logistica servizios
	*/
	public java.util.List<LogisticaServizio> findAll();

	/**
	* Returns a range of all the logistica servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica servizios
	* @param end the upper bound of the range of logistica servizios (not inclusive)
	* @return the range of logistica servizios
	*/
	public java.util.List<LogisticaServizio> findAll(int start, int end);

	/**
	* Returns an ordered range of all the logistica servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica servizios
	* @param end the upper bound of the range of logistica servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of logistica servizios
	*/
	public java.util.List<LogisticaServizio> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaServizio> orderByComparator);

	/**
	* Returns an ordered range of all the logistica servizios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaServizioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica servizios
	* @param end the upper bound of the range of logistica servizios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of logistica servizios
	*/
	public java.util.List<LogisticaServizio> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaServizio> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the logistica servizios from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of logistica servizios.
	*
	* @return the number of logistica servizios
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}