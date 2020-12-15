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

package com.accenture.lavoro.agile.istanza.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.accenture.lavoro.agile.istanza.mef.model.Email;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the email service. This utility wraps {@link com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.EmailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailPersistence
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.EmailPersistenceImpl
 * @generated
 */
@ProviderType
public class EmailUtil {
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
	public static void clearCache(Email email) {
		getPersistence().clearCache(email);
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
	public static List<Email> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Email> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Email> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Email> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Email update(Email email) {
		return getPersistence().update(email);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Email update(Email email, ServiceContext serviceContext) {
		return getPersistence().update(email, serviceContext);
	}

	/**
	* Returns all the emails where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @return the matching emails
	*/
	public static List<Email> findByIdStruttura(long idStruttura) {
		return getPersistence().findByIdStruttura(idStruttura);
	}

	/**
	* Returns a range of all the emails where idStruttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idStruttura the id struttura
	* @param start the lower bound of the range of emails
	* @param end the upper bound of the range of emails (not inclusive)
	* @return the range of matching emails
	*/
	public static List<Email> findByIdStruttura(long idStruttura, int start,
		int end) {
		return getPersistence().findByIdStruttura(idStruttura, start, end);
	}

	/**
	* Returns an ordered range of all the emails where idStruttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idStruttura the id struttura
	* @param start the lower bound of the range of emails
	* @param end the upper bound of the range of emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emails
	*/
	public static List<Email> findByIdStruttura(long idStruttura, int start,
		int end, OrderByComparator<Email> orderByComparator) {
		return getPersistence()
				   .findByIdStruttura(idStruttura, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the emails where idStruttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idStruttura the id struttura
	* @param start the lower bound of the range of emails
	* @param end the upper bound of the range of emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching emails
	*/
	public static List<Email> findByIdStruttura(long idStruttura, int start,
		int end, OrderByComparator<Email> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIdStruttura(idStruttura, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email
	* @throws NoSuchEmailException if a matching email could not be found
	*/
	public static Email findByIdStruttura_First(long idStruttura,
		OrderByComparator<Email> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchEmailException {
		return getPersistence()
				   .findByIdStruttura_First(idStruttura, orderByComparator);
	}

	/**
	* Returns the first email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email, or <code>null</code> if a matching email could not be found
	*/
	public static Email fetchByIdStruttura_First(long idStruttura,
		OrderByComparator<Email> orderByComparator) {
		return getPersistence()
				   .fetchByIdStruttura_First(idStruttura, orderByComparator);
	}

	/**
	* Returns the last email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email
	* @throws NoSuchEmailException if a matching email could not be found
	*/
	public static Email findByIdStruttura_Last(long idStruttura,
		OrderByComparator<Email> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchEmailException {
		return getPersistence()
				   .findByIdStruttura_Last(idStruttura, orderByComparator);
	}

	/**
	* Returns the last email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email, or <code>null</code> if a matching email could not be found
	*/
	public static Email fetchByIdStruttura_Last(long idStruttura,
		OrderByComparator<Email> orderByComparator) {
		return getPersistence()
				   .fetchByIdStruttura_Last(idStruttura, orderByComparator);
	}

	/**
	* Returns the emails before and after the current email in the ordered set where idStruttura = &#63;.
	*
	* @param id the primary key of the current email
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email
	* @throws NoSuchEmailException if a email with the primary key could not be found
	*/
	public static Email[] findByIdStruttura_PrevAndNext(long id,
		long idStruttura, OrderByComparator<Email> orderByComparator)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchEmailException {
		return getPersistence()
				   .findByIdStruttura_PrevAndNext(id, idStruttura,
			orderByComparator);
	}

	/**
	* Removes all the emails where idStruttura = &#63; from the database.
	*
	* @param idStruttura the id struttura
	*/
	public static void removeByIdStruttura(long idStruttura) {
		getPersistence().removeByIdStruttura(idStruttura);
	}

	/**
	* Returns the number of emails where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @return the number of matching emails
	*/
	public static int countByIdStruttura(long idStruttura) {
		return getPersistence().countByIdStruttura(idStruttura);
	}

	/**
	* Caches the email in the entity cache if it is enabled.
	*
	* @param email the email
	*/
	public static void cacheResult(Email email) {
		getPersistence().cacheResult(email);
	}

	/**
	* Caches the emails in the entity cache if it is enabled.
	*
	* @param emails the emails
	*/
	public static void cacheResult(List<Email> emails) {
		getPersistence().cacheResult(emails);
	}

	/**
	* Creates a new email with the primary key. Does not add the email to the database.
	*
	* @param id the primary key for the new email
	* @return the new email
	*/
	public static Email create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email
	* @return the email that was removed
	* @throws NoSuchEmailException if a email with the primary key could not be found
	*/
	public static Email remove(long id)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchEmailException {
		return getPersistence().remove(id);
	}

	public static Email updateImpl(Email email) {
		return getPersistence().updateImpl(email);
	}

	/**
	* Returns the email with the primary key or throws a {@link NoSuchEmailException} if it could not be found.
	*
	* @param id the primary key of the email
	* @return the email
	* @throws NoSuchEmailException if a email with the primary key could not be found
	*/
	public static Email findByPrimaryKey(long id)
		throws com.accenture.lavoro.agile.istanza.mef.exception.NoSuchEmailException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the email with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email
	* @return the email, or <code>null</code> if a email with the primary key could not be found
	*/
	public static Email fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Email> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the emails.
	*
	* @return the emails
	*/
	public static List<Email> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emails
	* @param end the upper bound of the range of emails (not inclusive)
	* @return the range of emails
	*/
	public static List<Email> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emails
	* @param end the upper bound of the range of emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emails
	*/
	public static List<Email> findAll(int start, int end,
		OrderByComparator<Email> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emails
	* @param end the upper bound of the range of emails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of emails
	*/
	public static List<Email> findAll(int start, int end,
		OrderByComparator<Email> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the emails from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emails.
	*
	* @return the number of emails
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmailPersistence, EmailPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmailPersistence.class);

		ServiceTracker<EmailPersistence, EmailPersistence> serviceTracker = new ServiceTracker<EmailPersistence, EmailPersistence>(bundle.getBundleContext(),
				EmailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}