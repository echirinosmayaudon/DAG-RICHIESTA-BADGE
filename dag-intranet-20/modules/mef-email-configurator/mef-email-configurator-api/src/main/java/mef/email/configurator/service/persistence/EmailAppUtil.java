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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import mef.email.configurator.model.EmailApp;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the email app service. This utility wraps {@link mef.email.configurator.service.persistence.impl.EmailAppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailAppPersistence
 * @see mef.email.configurator.service.persistence.impl.EmailAppPersistenceImpl
 * @generated
 */
@ProviderType
public class EmailAppUtil {
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
	public static void clearCache(EmailApp emailApp) {
		getPersistence().clearCache(emailApp);
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
	public static List<EmailApp> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmailApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmailApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmailApp> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmailApp update(EmailApp emailApp) {
		return getPersistence().update(emailApp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmailApp update(EmailApp emailApp,
		ServiceContext serviceContext) {
		return getPersistence().update(emailApp, serviceContext);
	}

	/**
	* Returns all the email apps where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @return the matching email apps
	*/
	public static List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura) {
		return getPersistence().findByApplicazione_Struttura(appid, struttura);
	}

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
	public static List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end) {
		return getPersistence()
				   .findByApplicazione_Struttura(appid, struttura, start, end);
	}

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
	public static List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end,
		OrderByComparator<EmailApp> orderByComparator) {
		return getPersistence()
				   .findByApplicazione_Struttura(appid, struttura, start, end,
			orderByComparator);
	}

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
	public static List<EmailApp> findByApplicazione_Struttura(long appid,
		long struttura, int start, int end,
		OrderByComparator<EmailApp> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByApplicazione_Struttura(appid, struttura, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email app
	* @throws NoSuchEmailAppException if a matching email app could not be found
	*/
	public static EmailApp findByApplicazione_Struttura_First(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator)
		throws mef.email.configurator.exception.NoSuchEmailAppException {
		return getPersistence()
				   .findByApplicazione_Struttura_First(appid, struttura,
			orderByComparator);
	}

	/**
	* Returns the first email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email app, or <code>null</code> if a matching email app could not be found
	*/
	public static EmailApp fetchByApplicazione_Struttura_First(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator) {
		return getPersistence()
				   .fetchByApplicazione_Struttura_First(appid, struttura,
			orderByComparator);
	}

	/**
	* Returns the last email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email app
	* @throws NoSuchEmailAppException if a matching email app could not be found
	*/
	public static EmailApp findByApplicazione_Struttura_Last(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator)
		throws mef.email.configurator.exception.NoSuchEmailAppException {
		return getPersistence()
				   .findByApplicazione_Struttura_Last(appid, struttura,
			orderByComparator);
	}

	/**
	* Returns the last email app in the ordered set where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email app, or <code>null</code> if a matching email app could not be found
	*/
	public static EmailApp fetchByApplicazione_Struttura_Last(long appid,
		long struttura, OrderByComparator<EmailApp> orderByComparator) {
		return getPersistence()
				   .fetchByApplicazione_Struttura_Last(appid, struttura,
			orderByComparator);
	}

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
	public static EmailApp[] findByApplicazione_Struttura_PrevAndNext(long id,
		long appid, long struttura,
		OrderByComparator<EmailApp> orderByComparator)
		throws mef.email.configurator.exception.NoSuchEmailAppException {
		return getPersistence()
				   .findByApplicazione_Struttura_PrevAndNext(id, appid,
			struttura, orderByComparator);
	}

	/**
	* Removes all the email apps where appid = &#63; and struttura = &#63; from the database.
	*
	* @param appid the appid
	* @param struttura the struttura
	*/
	public static void removeByApplicazione_Struttura(long appid, long struttura) {
		getPersistence().removeByApplicazione_Struttura(appid, struttura);
	}

	/**
	* Returns the number of email apps where appid = &#63; and struttura = &#63;.
	*
	* @param appid the appid
	* @param struttura the struttura
	* @return the number of matching email apps
	*/
	public static int countByApplicazione_Struttura(long appid, long struttura) {
		return getPersistence().countByApplicazione_Struttura(appid, struttura);
	}

	/**
	* Caches the email app in the entity cache if it is enabled.
	*
	* @param emailApp the email app
	*/
	public static void cacheResult(EmailApp emailApp) {
		getPersistence().cacheResult(emailApp);
	}

	/**
	* Caches the email apps in the entity cache if it is enabled.
	*
	* @param emailApps the email apps
	*/
	public static void cacheResult(List<EmailApp> emailApps) {
		getPersistence().cacheResult(emailApps);
	}

	/**
	* Creates a new email app with the primary key. Does not add the email app to the database.
	*
	* @param id the primary key for the new email app
	* @return the new email app
	*/
	public static EmailApp create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the email app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email app
	* @return the email app that was removed
	* @throws NoSuchEmailAppException if a email app with the primary key could not be found
	*/
	public static EmailApp remove(long id)
		throws mef.email.configurator.exception.NoSuchEmailAppException {
		return getPersistence().remove(id);
	}

	public static EmailApp updateImpl(EmailApp emailApp) {
		return getPersistence().updateImpl(emailApp);
	}

	/**
	* Returns the email app with the primary key or throws a {@link NoSuchEmailAppException} if it could not be found.
	*
	* @param id the primary key of the email app
	* @return the email app
	* @throws NoSuchEmailAppException if a email app with the primary key could not be found
	*/
	public static EmailApp findByPrimaryKey(long id)
		throws mef.email.configurator.exception.NoSuchEmailAppException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the email app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email app
	* @return the email app, or <code>null</code> if a email app with the primary key could not be found
	*/
	public static EmailApp fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, EmailApp> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the email apps.
	*
	* @return the email apps
	*/
	public static List<EmailApp> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmailApp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmailApp> findAll(int start, int end,
		OrderByComparator<EmailApp> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmailApp> findAll(int start, int end,
		OrderByComparator<EmailApp> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the email apps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of email apps.
	*
	* @return the number of email apps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmailAppPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmailAppPersistence, EmailAppPersistence> _serviceTracker =
		ServiceTrackerFactory.open(EmailAppPersistence.class);
}