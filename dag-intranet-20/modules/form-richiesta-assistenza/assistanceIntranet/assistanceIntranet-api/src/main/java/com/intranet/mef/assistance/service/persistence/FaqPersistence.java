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

package com.intranet.mef.assistance.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.exception.NoSuchFaqException;
import com.intranet.mef.assistance.model.Faq;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the faq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.assistance.service.persistence.impl.FaqPersistenceImpl
 * @see FaqUtil
 * @generated
 */
@ProviderType
public interface FaqPersistence extends BasePersistence<Faq> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FaqUtil} to access the faq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the faqs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching faqs
	*/
	public java.util.List<Faq> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the faqs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of matching faqs
	*/
	public java.util.List<Faq> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the faqs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching faqs
	*/
	public java.util.List<Faq> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator);

	/**
	* Returns an ordered range of all the faqs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching faqs
	*/
	public java.util.List<Faq> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public Faq findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	* Returns the first faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public Faq fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator);

	/**
	* Returns the last faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public Faq findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	* Returns the last faq in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public Faq fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator);

	/**
	* Returns the faqs before and after the current faq in the ordered set where uuid = &#63;.
	*
	* @param faqPK the primary key of the current faq
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next faq
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public Faq[] findByUuid_PrevAndNext(FaqPK faqPK, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	* Removes all the faqs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of faqs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching faqs
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the faqs where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @return the matching faqs
	*/
	public java.util.List<Faq> findByFaqId(java.lang.String faqId);

	/**
	* Returns a range of all the faqs where faqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param faqId the faq ID
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of matching faqs
	*/
	public java.util.List<Faq> findByFaqId(java.lang.String faqId, int start,
		int end);

	/**
	* Returns an ordered range of all the faqs where faqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param faqId the faq ID
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching faqs
	*/
	public java.util.List<Faq> findByFaqId(java.lang.String faqId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator);

	/**
	* Returns an ordered range of all the faqs where faqId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param faqId the faq ID
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching faqs
	*/
	public java.util.List<Faq> findByFaqId(java.lang.String faqId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public Faq findByFaqId_First(java.lang.String faqId,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	* Returns the first faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public Faq fetchByFaqId_First(java.lang.String faqId,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator);

	/**
	* Returns the last faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq
	* @throws NoSuchFaqException if a matching faq could not be found
	*/
	public Faq findByFaqId_Last(java.lang.String faqId,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	* Returns the last faq in the ordered set where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching faq, or <code>null</code> if a matching faq could not be found
	*/
	public Faq fetchByFaqId_Last(java.lang.String faqId,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator);

	/**
	* Returns the faqs before and after the current faq in the ordered set where faqId = &#63;.
	*
	* @param faqPK the primary key of the current faq
	* @param faqId the faq ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next faq
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public Faq[] findByFaqId_PrevAndNext(FaqPK faqPK, java.lang.String faqId,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	* Removes all the faqs where faqId = &#63; from the database.
	*
	* @param faqId the faq ID
	*/
	public void removeByFaqId(java.lang.String faqId);

	/**
	* Returns the number of faqs where faqId = &#63;.
	*
	* @param faqId the faq ID
	* @return the number of matching faqs
	*/
	public int countByFaqId(java.lang.String faqId);

	/**
	* Caches the faq in the entity cache if it is enabled.
	*
	* @param faq the faq
	*/
	public void cacheResult(Faq faq);

	/**
	* Caches the faqs in the entity cache if it is enabled.
	*
	* @param faqs the faqs
	*/
	public void cacheResult(java.util.List<Faq> faqs);

	/**
	* Creates a new faq with the primary key. Does not add the faq to the database.
	*
	* @param faqPK the primary key for the new faq
	* @return the new faq
	*/
	public Faq create(FaqPK faqPK);

	/**
	* Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param faqPK the primary key of the faq
	* @return the faq that was removed
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public Faq remove(FaqPK faqPK) throws NoSuchFaqException;

	public Faq updateImpl(Faq faq);

	/**
	* Returns the faq with the primary key or throws a {@link NoSuchFaqException} if it could not be found.
	*
	* @param faqPK the primary key of the faq
	* @return the faq
	* @throws NoSuchFaqException if a faq with the primary key could not be found
	*/
	public Faq findByPrimaryKey(FaqPK faqPK) throws NoSuchFaqException;

	/**
	* Returns the faq with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param faqPK the primary key of the faq
	* @return the faq, or <code>null</code> if a faq with the primary key could not be found
	*/
	public Faq fetchByPrimaryKey(FaqPK faqPK);

	@Override
	public java.util.Map<java.io.Serializable, Faq> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the faqs.
	*
	* @return the faqs
	*/
	public java.util.List<Faq> findAll();

	/**
	* Returns a range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @return the range of faqs
	*/
	public java.util.List<Faq> findAll(int start, int end);

	/**
	* Returns an ordered range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of faqs
	*/
	public java.util.List<Faq> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator);

	/**
	* Returns an ordered range of all the faqs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faqs
	* @param end the upper bound of the range of faqs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of faqs
	*/
	public java.util.List<Faq> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Faq> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the faqs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of faqs.
	*
	* @return the number of faqs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}