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

import service.intranet.mef.exception.NoSuchBeneInvException;
import service.intranet.mef.model.BeneInv;

/**
 * The persistence interface for the bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.BeneInvPersistenceImpl
 * @see BeneInvUtil
 * @generated
 */
@ProviderType
public interface BeneInvPersistence extends BasePersistence<BeneInv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BeneInvUtil} to access the bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bene invs where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @return the matching bene invs
	*/
	public java.util.List<BeneInv> findByTipoBeneInv(long id_tipo);

	/**
	* Returns a range of all the bene invs where id_tipo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_tipo the id_tipo
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @return the range of matching bene invs
	*/
	public java.util.List<BeneInv> findByTipoBeneInv(long id_tipo, int start,
		int end);

	/**
	* Returns an ordered range of all the bene invs where id_tipo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_tipo the id_tipo
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bene invs
	*/
	public java.util.List<BeneInv> findByTipoBeneInv(long id_tipo, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator);

	/**
	* Returns an ordered range of all the bene invs where id_tipo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_tipo the id_tipo
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bene invs
	*/
	public java.util.List<BeneInv> findByTipoBeneInv(long id_tipo, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bene inv
	* @throws NoSuchBeneInvException if a matching bene inv could not be found
	*/
	public BeneInv findByTipoBeneInv_First(long id_tipo,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator)
		throws NoSuchBeneInvException;

	/**
	* Returns the first bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bene inv, or <code>null</code> if a matching bene inv could not be found
	*/
	public BeneInv fetchByTipoBeneInv_First(long id_tipo,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator);

	/**
	* Returns the last bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bene inv
	* @throws NoSuchBeneInvException if a matching bene inv could not be found
	*/
	public BeneInv findByTipoBeneInv_Last(long id_tipo,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator)
		throws NoSuchBeneInvException;

	/**
	* Returns the last bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bene inv, or <code>null</code> if a matching bene inv could not be found
	*/
	public BeneInv fetchByTipoBeneInv_Last(long id_tipo,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator);

	/**
	* Returns the bene invs before and after the current bene inv in the ordered set where id_tipo = &#63;.
	*
	* @param id the primary key of the current bene inv
	* @param id_tipo the id_tipo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bene inv
	* @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	*/
	public BeneInv[] findByTipoBeneInv_PrevAndNext(long id, long id_tipo,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator)
		throws NoSuchBeneInvException;

	/**
	* Removes all the bene invs where id_tipo = &#63; from the database.
	*
	* @param id_tipo the id_tipo
	*/
	public void removeByTipoBeneInv(long id_tipo);

	/**
	* Returns the number of bene invs where id_tipo = &#63;.
	*
	* @param id_tipo the id_tipo
	* @return the number of matching bene invs
	*/
	public int countByTipoBeneInv(long id_tipo);

	/**
	* Caches the bene inv in the entity cache if it is enabled.
	*
	* @param beneInv the bene inv
	*/
	public void cacheResult(BeneInv beneInv);

	/**
	* Caches the bene invs in the entity cache if it is enabled.
	*
	* @param beneInvs the bene invs
	*/
	public void cacheResult(java.util.List<BeneInv> beneInvs);

	/**
	* Creates a new bene inv with the primary key. Does not add the bene inv to the database.
	*
	* @param id the primary key for the new bene inv
	* @return the new bene inv
	*/
	public BeneInv create(long id);

	/**
	* Removes the bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv that was removed
	* @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	*/
	public BeneInv remove(long id) throws NoSuchBeneInvException;

	public BeneInv updateImpl(BeneInv beneInv);

	/**
	* Returns the bene inv with the primary key or throws a {@link NoSuchBeneInvException} if it could not be found.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv
	* @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	*/
	public BeneInv findByPrimaryKey(long id) throws NoSuchBeneInvException;

	/**
	* Returns the bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv, or <code>null</code> if a bene inv with the primary key could not be found
	*/
	public BeneInv fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, BeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the bene invs.
	*
	* @return the bene invs
	*/
	public java.util.List<BeneInv> findAll();

	/**
	* Returns a range of all the bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @return the range of bene invs
	*/
	public java.util.List<BeneInv> findAll(int start, int end);

	/**
	* Returns an ordered range of all the bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bene invs
	*/
	public java.util.List<BeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator);

	/**
	* Returns an ordered range of all the bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bene invs
	*/
	public java.util.List<BeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the bene invs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of bene invs.
	*
	* @return the number of bene invs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}