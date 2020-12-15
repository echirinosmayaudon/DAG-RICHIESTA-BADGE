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

import service.intranet.mef.exception.NoSuchLogisticaStatoException;
import service.intranet.mef.model.LogisticaStato;

/**
 * The persistence interface for the logistica stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.LogisticaStatoPersistenceImpl
 * @see LogisticaStatoUtil
 * @generated
 */
@ProviderType
public interface LogisticaStatoPersistence extends BasePersistence<LogisticaStato> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogisticaStatoUtil} to access the logistica stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the logistica statos where utente = &#63;.
	*
	* @param utente the utente
	* @return the matching logistica statos
	*/
	public java.util.List<LogisticaStato> findByUtente(java.lang.String utente);

	/**
	* Returns a range of all the logistica statos where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @return the range of matching logistica statos
	*/
	public java.util.List<LogisticaStato> findByUtente(
		java.lang.String utente, int start, int end);

	/**
	* Returns an ordered range of all the logistica statos where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching logistica statos
	*/
	public java.util.List<LogisticaStato> findByUtente(
		java.lang.String utente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator);

	/**
	* Returns an ordered range of all the logistica statos where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching logistica statos
	*/
	public java.util.List<LogisticaStato> findByUtente(
		java.lang.String utente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica stato
	* @throws NoSuchLogisticaStatoException if a matching logistica stato could not be found
	*/
	public LogisticaStato findByUtente_First(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator)
		throws NoSuchLogisticaStatoException;

	/**
	* Returns the first logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica stato, or <code>null</code> if a matching logistica stato could not be found
	*/
	public LogisticaStato fetchByUtente_First(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator);

	/**
	* Returns the last logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica stato
	* @throws NoSuchLogisticaStatoException if a matching logistica stato could not be found
	*/
	public LogisticaStato findByUtente_Last(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator)
		throws NoSuchLogisticaStatoException;

	/**
	* Returns the last logistica stato in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica stato, or <code>null</code> if a matching logistica stato could not be found
	*/
	public LogisticaStato fetchByUtente_Last(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator);

	/**
	* Returns the logistica statos before and after the current logistica stato in the ordered set where utente = &#63;.
	*
	* @param id the primary key of the current logistica stato
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next logistica stato
	* @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	*/
	public LogisticaStato[] findByUtente_PrevAndNext(long id,
		java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator)
		throws NoSuchLogisticaStatoException;

	/**
	* Removes all the logistica statos where utente = &#63; from the database.
	*
	* @param utente the utente
	*/
	public void removeByUtente(java.lang.String utente);

	/**
	* Returns the number of logistica statos where utente = &#63;.
	*
	* @param utente the utente
	* @return the number of matching logistica statos
	*/
	public int countByUtente(java.lang.String utente);

	/**
	* Caches the logistica stato in the entity cache if it is enabled.
	*
	* @param logisticaStato the logistica stato
	*/
	public void cacheResult(LogisticaStato logisticaStato);

	/**
	* Caches the logistica statos in the entity cache if it is enabled.
	*
	* @param logisticaStatos the logistica statos
	*/
	public void cacheResult(java.util.List<LogisticaStato> logisticaStatos);

	/**
	* Creates a new logistica stato with the primary key. Does not add the logistica stato to the database.
	*
	* @param id the primary key for the new logistica stato
	* @return the new logistica stato
	*/
	public LogisticaStato create(long id);

	/**
	* Removes the logistica stato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica stato
	* @return the logistica stato that was removed
	* @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	*/
	public LogisticaStato remove(long id) throws NoSuchLogisticaStatoException;

	public LogisticaStato updateImpl(LogisticaStato logisticaStato);

	/**
	* Returns the logistica stato with the primary key or throws a {@link NoSuchLogisticaStatoException} if it could not be found.
	*
	* @param id the primary key of the logistica stato
	* @return the logistica stato
	* @throws NoSuchLogisticaStatoException if a logistica stato with the primary key could not be found
	*/
	public LogisticaStato findByPrimaryKey(long id)
		throws NoSuchLogisticaStatoException;

	/**
	* Returns the logistica stato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the logistica stato
	* @return the logistica stato, or <code>null</code> if a logistica stato with the primary key could not be found
	*/
	public LogisticaStato fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, LogisticaStato> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the logistica statos.
	*
	* @return the logistica statos
	*/
	public java.util.List<LogisticaStato> findAll();

	/**
	* Returns a range of all the logistica statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @return the range of logistica statos
	*/
	public java.util.List<LogisticaStato> findAll(int start, int end);

	/**
	* Returns an ordered range of all the logistica statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of logistica statos
	*/
	public java.util.List<LogisticaStato> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator);

	/**
	* Returns an ordered range of all the logistica statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaStatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica statos
	* @param end the upper bound of the range of logistica statos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of logistica statos
	*/
	public java.util.List<LogisticaStato> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaStato> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the logistica statos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of logistica statos.
	*
	* @return the number of logistica statos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}