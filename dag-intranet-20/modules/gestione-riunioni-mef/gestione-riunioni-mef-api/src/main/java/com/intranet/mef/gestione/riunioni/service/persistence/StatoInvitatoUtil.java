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

package com.intranet.mef.gestione.riunioni.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.StatoInvitato;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the stato invitato service. This utility wraps {@link com.intranet.mef.gestione.riunioni.service.persistence.impl.StatoInvitatoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoInvitatoPersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.StatoInvitatoPersistenceImpl
 * @generated
 */
@ProviderType
public class StatoInvitatoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StatoInvitato statoInvitato) {
		getPersistence().clearCache(statoInvitato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StatoInvitato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatoInvitato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatoInvitato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatoInvitato> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatoInvitato update(StatoInvitato statoInvitato) {
		return getPersistence().update(statoInvitato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatoInvitato update(StatoInvitato statoInvitato,
		ServiceContext serviceContext) {
		return getPersistence().update(statoInvitato, serviceContext);
	}

	/**
	* Caches the stato invitato in the entity cache if it is enabled.
	*
	* @param statoInvitato the stato invitato
	*/
	public static void cacheResult(StatoInvitato statoInvitato) {
		getPersistence().cacheResult(statoInvitato);
	}

	/**
	* Caches the stato invitatos in the entity cache if it is enabled.
	*
	* @param statoInvitatos the stato invitatos
	*/
	public static void cacheResult(List<StatoInvitato> statoInvitatos) {
		getPersistence().cacheResult(statoInvitatos);
	}

	/**
	* Creates a new stato invitato with the primary key. Does not add the stato invitato to the database.
	*
	* @param id_stato_invitato the primary key for the new stato invitato
	* @return the new stato invitato
	*/
	public static StatoInvitato create(long id_stato_invitato) {
		return getPersistence().create(id_stato_invitato);
	}

	/**
	* Removes the stato invitato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato that was removed
	* @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	*/
	public static StatoInvitato remove(long id_stato_invitato)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStatoInvitatoException {
		return getPersistence().remove(id_stato_invitato);
	}

	public static StatoInvitato updateImpl(StatoInvitato statoInvitato) {
		return getPersistence().updateImpl(statoInvitato);
	}

	/**
	* Returns the stato invitato with the primary key or throws a {@link NoSuchStatoInvitatoException} if it could not be found.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato
	* @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	*/
	public static StatoInvitato findByPrimaryKey(long id_stato_invitato)
		throws com.intranet.mef.gestione.riunioni.exception.NoSuchStatoInvitatoException {
		return getPersistence().findByPrimaryKey(id_stato_invitato);
	}

	/**
	* Returns the stato invitato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_stato_invitato the primary key of the stato invitato
	* @return the stato invitato, or <code>null</code> if a stato invitato with the primary key could not be found
	*/
	public static StatoInvitato fetchByPrimaryKey(long id_stato_invitato) {
		return getPersistence().fetchByPrimaryKey(id_stato_invitato);
	}

	public static java.util.Map<java.io.Serializable, StatoInvitato> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the stato invitatos.
	*
	* @return the stato invitatos
	*/
	public static List<StatoInvitato> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stato invitatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato invitatos
	* @param end the upper bound of the range of stato invitatos (not inclusive)
	* @return the range of stato invitatos
	*/
	public static List<StatoInvitato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stato invitatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato invitatos
	* @param end the upper bound of the range of stato invitatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato invitatos
	*/
	public static List<StatoInvitato> findAll(int start, int end,
		OrderByComparator<StatoInvitato> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the stato invitatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato invitatos
	* @param end the upper bound of the range of stato invitatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato invitatos
	*/
	public static List<StatoInvitato> findAll(int start, int end,
		OrderByComparator<StatoInvitato> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the stato invitatos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stato invitatos.
	*
	* @return the number of stato invitatos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatoInvitatoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StatoInvitatoPersistence, StatoInvitatoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(StatoInvitatoPersistence.class);
}