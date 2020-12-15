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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import service.intranet.mef.model.LogisticaRichieste;

import java.util.List;

/**
 * The persistence utility for the logistica richieste service. This utility wraps {@link service.intranet.mef.service.persistence.impl.LogisticaRichiestePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogisticaRichiestePersistence
 * @see service.intranet.mef.service.persistence.impl.LogisticaRichiestePersistenceImpl
 * @generated
 */
@ProviderType
public class LogisticaRichiesteUtil {
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
	public static void clearCache(LogisticaRichieste logisticaRichieste) {
		getPersistence().clearCache(logisticaRichieste);
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
	public static List<LogisticaRichieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogisticaRichieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogisticaRichieste> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LogisticaRichieste update(
		LogisticaRichieste logisticaRichieste) {
		return getPersistence().update(logisticaRichieste);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LogisticaRichieste update(
		LogisticaRichieste logisticaRichieste, ServiceContext serviceContext) {
		return getPersistence().update(logisticaRichieste, serviceContext);
	}

	/**
	* Returns all the logistica richiestes where utente = &#63;.
	*
	* @param utente the utente
	* @return the matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByUtente(java.lang.String utente) {
		return getPersistence().findByUtente(utente);
	}

	/**
	* Returns a range of all the logistica richiestes where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @return the range of matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByUtente(
		java.lang.String utente, int start, int end) {
		return getPersistence().findByUtente(utente, start, end);
	}

	/**
	* Returns an ordered range of all the logistica richiestes where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByUtente(
		java.lang.String utente, int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence()
				   .findByUtente(utente, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the logistica richiestes where utente = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param utente the utente
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByUtente(
		java.lang.String utente, int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUtente(utente, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste findByUtente_First(
		java.lang.String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence().findByUtente_First(utente, orderByComparator);
	}

	/**
	* Returns the first logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste fetchByUtente_First(
		java.lang.String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence().fetchByUtente_First(utente, orderByComparator);
	}

	/**
	* Returns the last logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste findByUtente_Last(
		java.lang.String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence().findByUtente_Last(utente, orderByComparator);
	}

	/**
	* Returns the last logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste fetchByUtente_Last(
		java.lang.String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence().fetchByUtente_Last(utente, orderByComparator);
	}

	/**
	* Returns the logistica richiestes before and after the current logistica richieste in the ordered set where utente = &#63;.
	*
	* @param id the primary key of the current logistica richieste
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public static LogisticaRichieste[] findByUtente_PrevAndNext(long id,
		java.lang.String utente,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence()
				   .findByUtente_PrevAndNext(id, utente, orderByComparator);
	}

	/**
	* Removes all the logistica richiestes where utente = &#63; from the database.
	*
	* @param utente the utente
	*/
	public static void removeByUtente(java.lang.String utente) {
		getPersistence().removeByUtente(utente);
	}

	/**
	* Returns the number of logistica richiestes where utente = &#63;.
	*
	* @param utente the utente
	* @return the number of matching logistica richiestes
	*/
	public static int countByUtente(java.lang.String utente) {
		return getPersistence().countByUtente(utente);
	}

	/**
	* Returns all the logistica richiestes where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento) {
		return getPersistence().findByDipartimento(dipartimento);
	}

	/**
	* Returns a range of all the logistica richiestes where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @return the range of matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento, int start, int end) {
		return getPersistence().findByDipartimento(dipartimento, start, end);
	}

	/**
	* Returns an ordered range of all the logistica richiestes where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence()
				   .findByDipartimento(dipartimento, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the logistica richiestes where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching logistica richiestes
	*/
	public static List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDipartimento(dipartimento, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste findByDipartimento_First(
		java.lang.String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence()
				   .findByDipartimento_First(dipartimento, orderByComparator);
	}

	/**
	* Returns the first logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste fetchByDipartimento_First(
		java.lang.String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_First(dipartimento, orderByComparator);
	}

	/**
	* Returns the last logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste findByDipartimento_Last(
		java.lang.String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence()
				   .findByDipartimento_Last(dipartimento, orderByComparator);
	}

	/**
	* Returns the last logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public static LogisticaRichieste fetchByDipartimento_Last(
		java.lang.String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence()
				   .fetchByDipartimento_Last(dipartimento, orderByComparator);
	}

	/**
	* Returns the logistica richiestes before and after the current logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param id the primary key of the current logistica richieste
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public static LogisticaRichieste[] findByDipartimento_PrevAndNext(long id,
		java.lang.String dipartimento,
		OrderByComparator<LogisticaRichieste> orderByComparator)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence()
				   .findByDipartimento_PrevAndNext(id, dipartimento,
			orderByComparator);
	}

	/**
	* Removes all the logistica richiestes where dipartimento = &#63; from the database.
	*
	* @param dipartimento the dipartimento
	*/
	public static void removeByDipartimento(java.lang.String dipartimento) {
		getPersistence().removeByDipartimento(dipartimento);
	}

	/**
	* Returns the number of logistica richiestes where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the number of matching logistica richiestes
	*/
	public static int countByDipartimento(java.lang.String dipartimento) {
		return getPersistence().countByDipartimento(dipartimento);
	}

	/**
	* Caches the logistica richieste in the entity cache if it is enabled.
	*
	* @param logisticaRichieste the logistica richieste
	*/
	public static void cacheResult(LogisticaRichieste logisticaRichieste) {
		getPersistence().cacheResult(logisticaRichieste);
	}

	/**
	* Caches the logistica richiestes in the entity cache if it is enabled.
	*
	* @param logisticaRichiestes the logistica richiestes
	*/
	public static void cacheResult(List<LogisticaRichieste> logisticaRichiestes) {
		getPersistence().cacheResult(logisticaRichiestes);
	}

	/**
	* Creates a new logistica richieste with the primary key. Does not add the logistica richieste to the database.
	*
	* @param id the primary key for the new logistica richieste
	* @return the new logistica richieste
	*/
	public static LogisticaRichieste create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the logistica richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste that was removed
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public static LogisticaRichieste remove(long id)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence().remove(id);
	}

	public static LogisticaRichieste updateImpl(
		LogisticaRichieste logisticaRichieste) {
		return getPersistence().updateImpl(logisticaRichieste);
	}

	/**
	* Returns the logistica richieste with the primary key or throws a {@link NoSuchLogisticaRichiesteException} if it could not be found.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public static LogisticaRichieste findByPrimaryKey(long id)
		throws service.intranet.mef.exception.NoSuchLogisticaRichiesteException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the logistica richieste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste, or <code>null</code> if a logistica richieste with the primary key could not be found
	*/
	public static LogisticaRichieste fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, LogisticaRichieste> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the logistica richiestes.
	*
	* @return the logistica richiestes
	*/
	public static List<LogisticaRichieste> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the logistica richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @return the range of logistica richiestes
	*/
	public static List<LogisticaRichieste> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the logistica richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of logistica richiestes
	*/
	public static List<LogisticaRichieste> findAll(int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the logistica richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica richiestes
	* @param end the upper bound of the range of logistica richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of logistica richiestes
	*/
	public static List<LogisticaRichieste> findAll(int start, int end,
		OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the logistica richiestes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of logistica richiestes.
	*
	* @return the number of logistica richiestes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LogisticaRichiestePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LogisticaRichiestePersistence, LogisticaRichiestePersistence> _serviceTracker =
		ServiceTrackerFactory.open(LogisticaRichiestePersistence.class);
}