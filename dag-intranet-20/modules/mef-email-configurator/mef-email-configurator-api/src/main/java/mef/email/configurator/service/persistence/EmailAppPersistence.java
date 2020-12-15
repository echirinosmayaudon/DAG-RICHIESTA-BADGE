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

package mef.email.configurator.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import mef.email.configurator.exception.NoSuchEmailAppException;
import mef.email.configurator.model.EmailApp;

/**
 * The persistence interface for the email app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see mef.email.configurator.service.persistence.impl.EmailAppPersistenceImpl
 * @see EmailAppUtil
 * @generated
 */
@ProviderType
public interface EmailAppPersistence extends BasePersistence<EmailApp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailAppUtil} to access the email app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the email apps where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @return the matching email apps
	*/
	public java.util.List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura);

	/**
	* Returns a range of all the email apps where appid = &#63; and struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param start the lower bound of the range of email apps
	* @param end the upper bound of the range of email apps (not inclusive)
	* @return the range of matching email apps
	*/
	public java.util.List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end);

	/**
	* Returns an ordered range of all the email apps where appid = &#63; and struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param start the lower bound of the range of email apps
	* @param end the upper bound of the range of email apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching email apps
	*/
	public java.util.List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator);

	/**
	* Returns an ordered range of all the email apps where appid = &#63; and struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param start the lower bound of the range of email apps
	* @param end the upper bound of the range of email apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching email apps
	*/
	public java.util.List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email app
	* @throws NoSuchEmailAppException if a matching email app could not be found
	*/
	public EmailApp findByApplicazione_Struttura_First(long appid,
		long struttura,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator)
		throws NoSuchEmailAppException;

	/**
	* Returns the first email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email app, or <code>null</code> if a matching email app could not be found
	*/
	public EmailApp fetchByApplicazione_Struttura_First(long appid,
		long struttura,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator);

	/**
	* Returns the last email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email app
	* @throws NoSuchEmailAppException if a matching email app could not be found
	*/
	public EmailApp findByApplicazione_Struttura_Last(long appid,
		long struttura,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator)
		throws NoSuchEmailAppException;

	/**
	* Returns the last email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email app, or <code>null</code> if a matching email app could not be found
	*/
	public EmailApp fetchByApplicazione_Struttura_Last(long appid,
		long struttura,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator);

	/**
	* Returns the email apps before and after the current email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param id the primary key of the current email app
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email app
	* @throws NoSuchEmailAppException if a email app with the primary key could not be found
	*/
	public EmailApp[] findByApplicazione_Struttura_PrevAndNext(long id,
		long appid, long struttura,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator)
		throws NoSuchEmailAppException;

	/**
	* Removes all the email apps where appid = &#63; and struttura = &#63; from the database.
	*
	* @param appid the appid
	* @param struttura the struttura
	*/
	public void removeByApplicazione_Struttura(long appid, long struttura);

	/**
	* Returns the number of email apps where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @return the number of matching email apps
	*/
	public int countByApplicazione_Struttura(long appid, long struttura);

	/**
	* Caches the email app in the entity cache if it is enabled.
	*
	* @param emailApp the email app
	*/
	public void cacheResult(EmailApp emailApp);

	/**
	* Caches the email apps in the entity cache if it is enabled.
	*
	* @param emailApps the email apps
	*/
	public void cacheResult(java.util.List<EmailApp> emailApps);

	/**
	* Creates a new email app with the primary key. Does not add the email app to the database.
	*
	* @param id the primary key for the new email app
	* @return the new email app
	*/
	public EmailApp create(long id);

	/**
	* Removes the email app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email app
	* @return the email app that was removed
	* @throws NoSuchEmailAppException if a email app with the primary key could not be found
	*/
	public EmailApp remove(long id) throws NoSuchEmailAppException;

	public EmailApp updateImpl(EmailApp emailApp);

	/**
	* Returns the email app with the primary key or throws a {@link NoSuchEmailAppException} if it could not be found.
	*
	* @param id the primary key of the email app
	* @return the email app
	* @throws NoSuchEmailAppException if a email app with the primary key could not be found
	*/
	public EmailApp findByPrimaryKey(long id) throws NoSuchEmailAppException;

	/**
	* Returns the email app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email app
	* @return the email app, or <code>null</code> if a email app with the primary key could not be found
	*/
	public EmailApp fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, EmailApp> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the email apps.
	*
	* @return the email apps
	*/
	public java.util.List<EmailApp> findAll();

	/**
	* Returns a range of all the email apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email apps
	* @param end the upper bound of the range of email apps (not inclusive)
	* @return the range of email apps
	*/
	public java.util.List<EmailApp> findAll(int start, int end);

	/**
	* Returns an ordered range of all the email apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email apps
	* @param end the upper bound of the range of email apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of email apps
	*/
	public java.util.List<EmailApp> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator);

	/**
	* Returns an ordered range of all the email apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email apps
	* @param end the upper bound of the range of email apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of email apps
	*/
	public java.util.List<EmailApp> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailApp> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the email apps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of email apps.
	*
	* @return the number of email apps
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}