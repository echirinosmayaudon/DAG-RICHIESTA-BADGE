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

import service.intranet.mef.exception.NoSuchLogisticaRichiesteException;
import service.intranet.mef.model.LogisticaRichieste;

/**
 * The persistence interface for the logistica richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.LogisticaRichiestePersistenceImpl
 * @see LogisticaRichiesteUtil
 * @generated
 */
@ProviderType
public interface LogisticaRichiestePersistence extends BasePersistence<LogisticaRichieste> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogisticaRichiesteUtil} to access the logistica richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the logistica richiestes where utente = &#63;.
	*
	* @param utente the utente
	* @return the matching logistica richiestes
	*/
	public java.util.List<LogisticaRichieste> findByUtente(
		java.lang.String utente);

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
	public java.util.List<LogisticaRichieste> findByUtente(
		java.lang.String utente, int start, int end);

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
	public java.util.List<LogisticaRichieste> findByUtente(
		java.lang.String utente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator);

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
	public java.util.List<LogisticaRichieste> findByUtente(
		java.lang.String utente, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste findByUtente_First(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException;

	/**
	* Returns the first logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste fetchByUtente_First(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator);

	/**
	* Returns the last logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste findByUtente_Last(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException;

	/**
	* Returns the last logistica richieste in the ordered set where utente = &#63;.
	*
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste fetchByUtente_Last(java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator);

	/**
	* Returns the logistica richiestes before and after the current logistica richieste in the ordered set where utente = &#63;.
	*
	* @param id the primary key of the current logistica richieste
	* @param utente the utente
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public LogisticaRichieste[] findByUtente_PrevAndNext(long id,
		java.lang.String utente,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException;

	/**
	* Removes all the logistica richiestes where utente = &#63; from the database.
	*
	* @param utente the utente
	*/
	public void removeByUtente(java.lang.String utente);

	/**
	* Returns the number of logistica richiestes where utente = &#63;.
	*
	* @param utente the utente
	* @return the number of matching logistica richiestes
	*/
	public int countByUtente(java.lang.String utente);

	/**
	* Returns all the logistica richiestes where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the matching logistica richiestes
	*/
	public java.util.List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento);

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
	public java.util.List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento, int start, int end);

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
	public java.util.List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator);

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
	public java.util.List<LogisticaRichieste> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste findByDipartimento_First(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException;

	/**
	* Returns the first logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste fetchByDipartimento_First(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator);

	/**
	* Returns the last logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste findByDipartimento_Last(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException;

	/**
	* Returns the last logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching logistica richieste, or <code>null</code> if a matching logistica richieste could not be found
	*/
	public LogisticaRichieste fetchByDipartimento_Last(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator);

	/**
	* Returns the logistica richiestes before and after the current logistica richieste in the ordered set where dipartimento = &#63;.
	*
	* @param id the primary key of the current logistica richieste
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public LogisticaRichieste[] findByDipartimento_PrevAndNext(long id,
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator)
		throws NoSuchLogisticaRichiesteException;

	/**
	* Removes all the logistica richiestes where dipartimento = &#63; from the database.
	*
	* @param dipartimento the dipartimento
	*/
	public void removeByDipartimento(java.lang.String dipartimento);

	/**
	* Returns the number of logistica richiestes where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the number of matching logistica richiestes
	*/
	public int countByDipartimento(java.lang.String dipartimento);

	/**
	* Caches the logistica richieste in the entity cache if it is enabled.
	*
	* @param logisticaRichieste the logistica richieste
	*/
	public void cacheResult(LogisticaRichieste logisticaRichieste);

	/**
	* Caches the logistica richiestes in the entity cache if it is enabled.
	*
	* @param logisticaRichiestes the logistica richiestes
	*/
	public void cacheResult(
		java.util.List<LogisticaRichieste> logisticaRichiestes);

	/**
	* Creates a new logistica richieste with the primary key. Does not add the logistica richieste to the database.
	*
	* @param id the primary key for the new logistica richieste
	* @return the new logistica richieste
	*/
	public LogisticaRichieste create(long id);

	/**
	* Removes the logistica richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste that was removed
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public LogisticaRichieste remove(long id)
		throws NoSuchLogisticaRichiesteException;

	public LogisticaRichieste updateImpl(LogisticaRichieste logisticaRichieste);

	/**
	* Returns the logistica richieste with the primary key or throws a {@link NoSuchLogisticaRichiesteException} if it could not be found.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste
	* @throws NoSuchLogisticaRichiesteException if a logistica richieste with the primary key could not be found
	*/
	public LogisticaRichieste findByPrimaryKey(long id)
		throws NoSuchLogisticaRichiesteException;

	/**
	* Returns the logistica richieste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the logistica richieste
	* @return the logistica richieste, or <code>null</code> if a logistica richieste with the primary key could not be found
	*/
	public LogisticaRichieste fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, LogisticaRichieste> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the logistica richiestes.
	*
	* @return the logistica richiestes
	*/
	public java.util.List<LogisticaRichieste> findAll();

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
	public java.util.List<LogisticaRichieste> findAll(int start, int end);

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
	public java.util.List<LogisticaRichieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator);

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
	public java.util.List<LogisticaRichieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaRichieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the logistica richiestes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of logistica richiestes.
	*
	* @return the number of logistica richiestes
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}