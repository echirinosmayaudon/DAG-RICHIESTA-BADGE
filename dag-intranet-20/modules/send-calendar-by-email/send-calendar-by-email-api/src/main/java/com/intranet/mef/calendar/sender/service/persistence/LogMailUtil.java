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

package com.intranet.mef.calendar.sender.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.calendar.sender.model.LogMail;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the log mail service. This utility wraps {@link com.intranet.mef.calendar.sender.service.persistence.impl.LogMailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogMailPersistence
 * @see com.intranet.mef.calendar.sender.service.persistence.impl.LogMailPersistenceImpl
 * @generated
 */
@ProviderType
public class LogMailUtil {
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
	public static void clearCache(LogMail logMail) {
		getPersistence().clearCache(logMail);
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
	public static List<LogMail> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogMail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogMail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LogMail> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LogMail update(LogMail logMail) {
		return getPersistence().update(logMail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LogMail update(LogMail logMail, ServiceContext serviceContext) {
		return getPersistence().update(logMail, serviceContext);
	}

	/**
	* Returns all the log mails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching log mails
	*/
	public static List<LogMail> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the log mails where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @return the range of matching log mails
	*/
	public static List<LogMail> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the log mails where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log mails
	*/
	public static List<LogMail> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<LogMail> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the log mails where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching log mails
	*/
	public static List<LogMail> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<LogMail> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log mail
	* @throws NoSuchLogMailException if a matching log mail could not be found
	*/
	public static LogMail findByUuid_First(java.lang.String uuid,
		OrderByComparator<LogMail> orderByComparator)
		throws com.intranet.mef.calendar.sender.exception.NoSuchLogMailException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log mail, or <code>null</code> if a matching log mail could not be found
	*/
	public static LogMail fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<LogMail> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log mail
	* @throws NoSuchLogMailException if a matching log mail could not be found
	*/
	public static LogMail findByUuid_Last(java.lang.String uuid,
		OrderByComparator<LogMail> orderByComparator)
		throws com.intranet.mef.calendar.sender.exception.NoSuchLogMailException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log mail, or <code>null</code> if a matching log mail could not be found
	*/
	public static LogMail fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<LogMail> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the log mails before and after the current log mail in the ordered set where uuid = &#63;.
	*
	* @param logMailId the primary key of the current log mail
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log mail
	* @throws NoSuchLogMailException if a log mail with the primary key could not be found
	*/
	public static LogMail[] findByUuid_PrevAndNext(long logMailId,
		java.lang.String uuid, OrderByComparator<LogMail> orderByComparator)
		throws com.intranet.mef.calendar.sender.exception.NoSuchLogMailException {
		return getPersistence()
				   .findByUuid_PrevAndNext(logMailId, uuid, orderByComparator);
	}

	/**
	* Removes all the log mails where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of log mails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching log mails
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the log mail in the entity cache if it is enabled.
	*
	* @param logMail the log mail
	*/
	public static void cacheResult(LogMail logMail) {
		getPersistence().cacheResult(logMail);
	}

	/**
	* Caches the log mails in the entity cache if it is enabled.
	*
	* @param logMails the log mails
	*/
	public static void cacheResult(List<LogMail> logMails) {
		getPersistence().cacheResult(logMails);
	}

	/**
	* Creates a new log mail with the primary key. Does not add the log mail to the database.
	*
	* @param logMailId the primary key for the new log mail
	* @return the new log mail
	*/
	public static LogMail create(long logMailId) {
		return getPersistence().create(logMailId);
	}

	/**
	* Removes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail that was removed
	* @throws NoSuchLogMailException if a log mail with the primary key could not be found
	*/
	public static LogMail remove(long logMailId)
		throws com.intranet.mef.calendar.sender.exception.NoSuchLogMailException {
		return getPersistence().remove(logMailId);
	}

	public static LogMail updateImpl(LogMail logMail) {
		return getPersistence().updateImpl(logMail);
	}

	/**
	* Returns the log mail with the primary key or throws a {@link NoSuchLogMailException} if it could not be found.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail
	* @throws NoSuchLogMailException if a log mail with the primary key could not be found
	*/
	public static LogMail findByPrimaryKey(long logMailId)
		throws com.intranet.mef.calendar.sender.exception.NoSuchLogMailException {
		return getPersistence().findByPrimaryKey(logMailId);
	}

	/**
	* Returns the log mail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail, or <code>null</code> if a log mail with the primary key could not be found
	*/
	public static LogMail fetchByPrimaryKey(long logMailId) {
		return getPersistence().fetchByPrimaryKey(logMailId);
	}

	public static java.util.Map<java.io.Serializable, LogMail> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the log mails.
	*
	* @return the log mails
	*/
	public static List<LogMail> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the log mails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @return the range of log mails
	*/
	public static List<LogMail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the log mails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of log mails
	*/
	public static List<LogMail> findAll(int start, int end,
		OrderByComparator<LogMail> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the log mails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogMailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of log mails
	*/
	public static List<LogMail> findAll(int start, int end,
		OrderByComparator<LogMail> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the log mails from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of log mails.
	*
	* @return the number of log mails
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LogMailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LogMailPersistence, LogMailPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LogMailPersistence.class);
}