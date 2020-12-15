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

package external.bfc.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import external.bfc.intranet.mef.model.RichiesteSequence;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the richieste sequence service. This utility wraps {@link external.bfc.intranet.mef.service.persistence.impl.RichiesteSequencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequencePersistence
 * @see external.bfc.intranet.mef.service.persistence.impl.RichiesteSequencePersistenceImpl
 * @generated
 */
@ProviderType
public class RichiesteSequenceUtil {
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
	public static void clearCache(RichiesteSequence richiesteSequence) {
		getPersistence().clearCache(richiesteSequence);
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
	public static List<RichiesteSequence> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RichiesteSequence> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RichiesteSequence> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RichiesteSequence> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RichiesteSequence update(RichiesteSequence richiesteSequence) {
		return getPersistence().update(richiesteSequence);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RichiesteSequence update(
		RichiesteSequence richiesteSequence, ServiceContext serviceContext) {
		return getPersistence().update(richiesteSequence, serviceContext);
	}

	/**
	* Caches the richieste sequence in the entity cache if it is enabled.
	*
	* @param richiesteSequence the richieste sequence
	*/
	public static void cacheResult(RichiesteSequence richiesteSequence) {
		getPersistence().cacheResult(richiesteSequence);
	}

	/**
	* Caches the richieste sequences in the entity cache if it is enabled.
	*
	* @param richiesteSequences the richieste sequences
	*/
	public static void cacheResult(List<RichiesteSequence> richiesteSequences) {
		getPersistence().cacheResult(richiesteSequences);
	}

	/**
	* Creates a new richieste sequence with the primary key. Does not add the richieste sequence to the database.
	*
	* @param idSeq the primary key for the new richieste sequence
	* @return the new richieste sequence
	*/
	public static RichiesteSequence create(long idSeq) {
		return getPersistence().create(idSeq);
	}

	/**
	* Removes the richieste sequence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence that was removed
	* @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	*/
	public static RichiesteSequence remove(long idSeq)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteSequenceException {
		return getPersistence().remove(idSeq);
	}

	public static RichiesteSequence updateImpl(
		RichiesteSequence richiesteSequence) {
		return getPersistence().updateImpl(richiesteSequence);
	}

	/**
	* Returns the richieste sequence with the primary key or throws a {@link NoSuchRichiesteSequenceException} if it could not be found.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence
	* @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	*/
	public static RichiesteSequence findByPrimaryKey(long idSeq)
		throws external.bfc.intranet.mef.exception.NoSuchRichiesteSequenceException {
		return getPersistence().findByPrimaryKey(idSeq);
	}

	/**
	* Returns the richieste sequence with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence, or <code>null</code> if a richieste sequence with the primary key could not be found
	*/
	public static RichiesteSequence fetchByPrimaryKey(long idSeq) {
		return getPersistence().fetchByPrimaryKey(idSeq);
	}

	public static java.util.Map<java.io.Serializable, RichiesteSequence> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the richieste sequences.
	*
	* @return the richieste sequences
	*/
	public static List<RichiesteSequence> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the richieste sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste sequences
	* @param end the upper bound of the range of richieste sequences (not inclusive)
	* @return the range of richieste sequences
	*/
	public static List<RichiesteSequence> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the richieste sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste sequences
	* @param end the upper bound of the range of richieste sequences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste sequences
	*/
	public static List<RichiesteSequence> findAll(int start, int end,
		OrderByComparator<RichiesteSequence> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the richieste sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste sequences
	* @param end the upper bound of the range of richieste sequences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste sequences
	*/
	public static List<RichiesteSequence> findAll(int start, int end,
		OrderByComparator<RichiesteSequence> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the richieste sequences from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of richieste sequences.
	*
	* @return the number of richieste sequences
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RichiesteSequencePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiesteSequencePersistence, RichiesteSequencePersistence> _serviceTracker =
		ServiceTrackerFactory.open(RichiesteSequencePersistence.class);
}