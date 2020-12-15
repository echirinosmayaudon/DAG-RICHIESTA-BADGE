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

import com.accenture.lavoro.agile.istanza.mef.exception.NoSuchEmailException;
import com.accenture.lavoro.agile.istanza.mef.model.Email;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.EmailPersistenceImpl
 * @see EmailUtil
 * @generated
 */
@ProviderType
public interface EmailPersistence extends BasePersistence<Email> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailUtil} to access the email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the emails where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @return the matching emails
	*/
	public java.util.List<Email> findByIdStruttura(long idStruttura);

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
	public java.util.List<Email> findByIdStruttura(long idStruttura, int start,
		int end);

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
	public java.util.List<Email> findByIdStruttura(long idStruttura, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator);

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
	public java.util.List<Email> findByIdStruttura(long idStruttura, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email
	* @throws NoSuchEmailException if a matching email could not be found
	*/
	public Email findByIdStruttura_First(long idStruttura,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException;

	/**
	* Returns the first email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching email, or <code>null</code> if a matching email could not be found
	*/
	public Email fetchByIdStruttura_First(long idStruttura,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator);

	/**
	* Returns the last email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email
	* @throws NoSuchEmailException if a matching email could not be found
	*/
	public Email findByIdStruttura_Last(long idStruttura,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException;

	/**
	* Returns the last email in the ordered set where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching email, or <code>null</code> if a matching email could not be found
	*/
	public Email fetchByIdStruttura_Last(long idStruttura,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator);

	/**
	* Returns the emails before and after the current email in the ordered set where idStruttura = &#63;.
	*
	* @param id the primary key of the current email
	* @param idStruttura the id struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next email
	* @throws NoSuchEmailException if a email with the primary key could not be found
	*/
	public Email[] findByIdStruttura_PrevAndNext(long id, long idStruttura,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator)
		throws NoSuchEmailException;

	/**
	* Removes all the emails where idStruttura = &#63; from the database.
	*
	* @param idStruttura the id struttura
	*/
	public void removeByIdStruttura(long idStruttura);

	/**
	* Returns the number of emails where idStruttura = &#63;.
	*
	* @param idStruttura the id struttura
	* @return the number of matching emails
	*/
	public int countByIdStruttura(long idStruttura);

	/**
	* Caches the email in the entity cache if it is enabled.
	*
	* @param email the email
	*/
	public void cacheResult(Email email);

	/**
	* Caches the emails in the entity cache if it is enabled.
	*
	* @param emails the emails
	*/
	public void cacheResult(java.util.List<Email> emails);

	/**
	* Creates a new email with the primary key. Does not add the email to the database.
	*
	* @param id the primary key for the new email
	* @return the new email
	*/
	public Email create(long id);

	/**
	* Removes the email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email
	* @return the email that was removed
	* @throws NoSuchEmailException if a email with the primary key could not be found
	*/
	public Email remove(long id) throws NoSuchEmailException;

	public Email updateImpl(Email email);

	/**
	* Returns the email with the primary key or throws a {@link NoSuchEmailException} if it could not be found.
	*
	* @param id the primary key of the email
	* @return the email
	* @throws NoSuchEmailException if a email with the primary key could not be found
	*/
	public Email findByPrimaryKey(long id) throws NoSuchEmailException;

	/**
	* Returns the email with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email
	* @return the email, or <code>null</code> if a email with the primary key could not be found
	*/
	public Email fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Email> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the emails.
	*
	* @return the emails
	*/
	public java.util.List<Email> findAll();

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
	public java.util.List<Email> findAll(int start, int end);

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
	public java.util.List<Email> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator);

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
	public java.util.List<Email> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Email> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the emails from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of emails.
	*
	* @return the number of emails
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}