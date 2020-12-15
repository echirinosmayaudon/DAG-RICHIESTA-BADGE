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

import service.intranet.mef.exception.NoSuchStatoRichBeneInvException;
import service.intranet.mef.model.StatoRichBeneInv;

/**
 * The persistence interface for the stato rich bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.StatoRichBeneInvPersistenceImpl
 * @see StatoRichBeneInvUtil
 * @generated
 */
@ProviderType
public interface StatoRichBeneInvPersistence extends BasePersistence<StatoRichBeneInv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatoRichBeneInvUtil} to access the stato rich bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stato rich bene invs where stato = &#63;.
	*
	* @param stato the stato
	* @return the matching stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findByNomeStato(
		java.lang.String stato);

	/**
	* Returns a range of all the stato rich bene invs where stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stato the stato
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @return the range of matching stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findByNomeStato(
		java.lang.String stato, int start, int end);

	/**
	* Returns an ordered range of all the stato rich bene invs where stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stato the stato
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findByNomeStato(
		java.lang.String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator);

	/**
	* Returns an ordered range of all the stato rich bene invs where stato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stato the stato
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findByNomeStato(
		java.lang.String stato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a matching stato rich bene inv could not be found
	*/
	public StatoRichBeneInv findByNomeStato_First(java.lang.String stato,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws NoSuchStatoRichBeneInvException;

	/**
	* Returns the first stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stato rich bene inv, or <code>null</code> if a matching stato rich bene inv could not be found
	*/
	public StatoRichBeneInv fetchByNomeStato_First(java.lang.String stato,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator);

	/**
	* Returns the last stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a matching stato rich bene inv could not be found
	*/
	public StatoRichBeneInv findByNomeStato_Last(java.lang.String stato,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws NoSuchStatoRichBeneInvException;

	/**
	* Returns the last stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stato rich bene inv, or <code>null</code> if a matching stato rich bene inv could not be found
	*/
	public StatoRichBeneInv fetchByNomeStato_Last(java.lang.String stato,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator);

	/**
	* Returns the stato rich bene invs before and after the current stato rich bene inv in the ordered set where stato = &#63;.
	*
	* @param id the primary key of the current stato rich bene inv
	* @param stato the stato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	*/
	public StatoRichBeneInv[] findByNomeStato_PrevAndNext(long id,
		java.lang.String stato,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator)
		throws NoSuchStatoRichBeneInvException;

	/**
	* Removes all the stato rich bene invs where stato = &#63; from the database.
	*
	* @param stato the stato
	*/
	public void removeByNomeStato(java.lang.String stato);

	/**
	* Returns the number of stato rich bene invs where stato = &#63;.
	*
	* @param stato the stato
	* @return the number of matching stato rich bene invs
	*/
	public int countByNomeStato(java.lang.String stato);

	/**
	* Caches the stato rich bene inv in the entity cache if it is enabled.
	*
	* @param statoRichBeneInv the stato rich bene inv
	*/
	public void cacheResult(StatoRichBeneInv statoRichBeneInv);

	/**
	* Caches the stato rich bene invs in the entity cache if it is enabled.
	*
	* @param statoRichBeneInvs the stato rich bene invs
	*/
	public void cacheResult(java.util.List<StatoRichBeneInv> statoRichBeneInvs);

	/**
	* Creates a new stato rich bene inv with the primary key. Does not add the stato rich bene inv to the database.
	*
	* @param id the primary key for the new stato rich bene inv
	* @return the new stato rich bene inv
	*/
	public StatoRichBeneInv create(long id);

	/**
	* Removes the stato rich bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stato rich bene inv
	* @return the stato rich bene inv that was removed
	* @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	*/
	public StatoRichBeneInv remove(long id)
		throws NoSuchStatoRichBeneInvException;

	public StatoRichBeneInv updateImpl(StatoRichBeneInv statoRichBeneInv);

	/**
	* Returns the stato rich bene inv with the primary key or throws a {@link NoSuchStatoRichBeneInvException} if it could not be found.
	*
	* @param id the primary key of the stato rich bene inv
	* @return the stato rich bene inv
	* @throws NoSuchStatoRichBeneInvException if a stato rich bene inv with the primary key could not be found
	*/
	public StatoRichBeneInv findByPrimaryKey(long id)
		throws NoSuchStatoRichBeneInvException;

	/**
	* Returns the stato rich bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stato rich bene inv
	* @return the stato rich bene inv, or <code>null</code> if a stato rich bene inv with the primary key could not be found
	*/
	public StatoRichBeneInv fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, StatoRichBeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the stato rich bene invs.
	*
	* @return the stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findAll();

	/**
	* Returns a range of all the stato rich bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @return the range of stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findAll(int start, int end);

	/**
	* Returns an ordered range of all the stato rich bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator);

	/**
	* Returns an ordered range of all the stato rich bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoRichBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato rich bene invs
	* @param end the upper bound of the range of stato rich bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of stato rich bene invs
	*/
	public java.util.List<StatoRichBeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoRichBeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the stato rich bene invs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of stato rich bene invs.
	*
	* @return the number of stato rich bene invs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}