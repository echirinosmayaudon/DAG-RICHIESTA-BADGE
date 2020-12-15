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

import com.intranet.mef.calendar.sender.exception.NoSuchLogMailException;
import com.intranet.mef.calendar.sender.model.LogMail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the log mail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.calendar.sender.service.persistence.impl.LogMailPersistenceImpl
 * @see LogMailUtil
 * @generated
 */
@ProviderType
public interface LogMailPersistence extends BasePersistence<LogMail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogMailUtil} to access the log mail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the log mails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching log mails
	*/
	public java.util.List<LogMail> findByUuid(java.lang.String uuid);

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
	public java.util.List<LogMail> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<LogMail> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator);

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
	public java.util.List<LogMail> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log mail
	* @throws NoSuchLogMailException if a matching log mail could not be found
	*/
	public LogMail findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator)
		throws NoSuchLogMailException;

	/**
	* Returns the first log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log mail, or <code>null</code> if a matching log mail could not be found
	*/
	public LogMail fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator);

	/**
	* Returns the last log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log mail
	* @throws NoSuchLogMailException if a matching log mail could not be found
	*/
	public LogMail findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator)
		throws NoSuchLogMailException;

	/**
	* Returns the last log mail in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log mail, or <code>null</code> if a matching log mail could not be found
	*/
	public LogMail fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator);

	/**
	* Returns the log mails before and after the current log mail in the ordered set where uuid = &#63;.
	*
	* @param logMailId the primary key of the current log mail
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log mail
	* @throws NoSuchLogMailException if a log mail with the primary key could not be found
	*/
	public LogMail[] findByUuid_PrevAndNext(long logMailId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator)
		throws NoSuchLogMailException;

	/**
	* Removes all the log mails where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of log mails where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching log mails
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the log mail in the entity cache if it is enabled.
	*
	* @param logMail the log mail
	*/
	public void cacheResult(LogMail logMail);

	/**
	* Caches the log mails in the entity cache if it is enabled.
	*
	* @param logMails the log mails
	*/
	public void cacheResult(java.util.List<LogMail> logMails);

	/**
	* Creates a new log mail with the primary key. Does not add the log mail to the database.
	*
	* @param logMailId the primary key for the new log mail
	* @return the new log mail
	*/
	public LogMail create(long logMailId);

	/**
	* Removes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail that was removed
	* @throws NoSuchLogMailException if a log mail with the primary key could not be found
	*/
	public LogMail remove(long logMailId) throws NoSuchLogMailException;

	public LogMail updateImpl(LogMail logMail);

	/**
	* Returns the log mail with the primary key or throws a {@link NoSuchLogMailException} if it could not be found.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail
	* @throws NoSuchLogMailException if a log mail with the primary key could not be found
	*/
	public LogMail findByPrimaryKey(long logMailId)
		throws NoSuchLogMailException;

	/**
	* Returns the log mail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param logMailId the primary key of the log mail
	* @return the log mail, or <code>null</code> if a log mail with the primary key could not be found
	*/
	public LogMail fetchByPrimaryKey(long logMailId);

	@Override
	public java.util.Map<java.io.Serializable, LogMail> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the log mails.
	*
	* @return the log mails
	*/
	public java.util.List<LogMail> findAll();

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
	public java.util.List<LogMail> findAll(int start, int end);

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
	public java.util.List<LogMail> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator);

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
	public java.util.List<LogMail> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogMail> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the log mails from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of log mails.
	*
	* @return the number of log mails
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}