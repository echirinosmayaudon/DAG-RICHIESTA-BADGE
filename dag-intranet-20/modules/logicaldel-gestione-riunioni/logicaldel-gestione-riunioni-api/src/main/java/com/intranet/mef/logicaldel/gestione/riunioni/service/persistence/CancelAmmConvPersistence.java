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

package com.intranet.mef.logicaldel.gestione.riunioni.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelAmmConvException;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the cancel amm conv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.impl.CancelAmmConvPersistenceImpl
 * @see CancelAmmConvUtil
 * @generated
 */
@ProviderType
public interface CancelAmmConvPersistence extends BasePersistence<CancelAmmConv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CancelAmmConvUtil} to access the cancel amm conv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cancel amm convs where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the matching cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findByAmmConvList(boolean cancellato);

	/**
	* Returns a range of all the cancel amm convs where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @return the range of matching cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findByAmmConvList(boolean cancellato,
		int start, int end);

	/**
	* Returns an ordered range of all the cancel amm convs where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findByAmmConvList(boolean cancellato,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator);

	/**
	* Returns an ordered range of all the cancel amm convs where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findByAmmConvList(boolean cancellato,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel amm conv
	* @throws NoSuchCancelAmmConvException if a matching cancel amm conv could not be found
	*/
	public CancelAmmConv findByAmmConvList_First(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator)
		throws NoSuchCancelAmmConvException;

	/**
	* Returns the first cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel amm conv, or <code>null</code> if a matching cancel amm conv could not be found
	*/
	public CancelAmmConv fetchByAmmConvList_First(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator);

	/**
	* Returns the last cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel amm conv
	* @throws NoSuchCancelAmmConvException if a matching cancel amm conv could not be found
	*/
	public CancelAmmConv findByAmmConvList_Last(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator)
		throws NoSuchCancelAmmConvException;

	/**
	* Returns the last cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel amm conv, or <code>null</code> if a matching cancel amm conv could not be found
	*/
	public CancelAmmConv fetchByAmmConvList_Last(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator);

	/**
	* Returns the cancel amm convs before and after the current cancel amm conv in the ordered set where cancellato = &#63;.
	*
	* @param id_amministrazione_convocante the primary key of the current cancel amm conv
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cancel amm conv
	* @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	*/
	public CancelAmmConv[] findByAmmConvList_PrevAndNext(
		long id_amministrazione_convocante, boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator)
		throws NoSuchCancelAmmConvException;

	/**
	* Removes all the cancel amm convs where cancellato = &#63; from the database.
	*
	* @param cancellato the cancellato
	*/
	public void removeByAmmConvList(boolean cancellato);

	/**
	* Returns the number of cancel amm convs where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the number of matching cancel amm convs
	*/
	public int countByAmmConvList(boolean cancellato);

	/**
	* Caches the cancel amm conv in the entity cache if it is enabled.
	*
	* @param cancelAmmConv the cancel amm conv
	*/
	public void cacheResult(CancelAmmConv cancelAmmConv);

	/**
	* Caches the cancel amm convs in the entity cache if it is enabled.
	*
	* @param cancelAmmConvs the cancel amm convs
	*/
	public void cacheResult(java.util.List<CancelAmmConv> cancelAmmConvs);

	/**
	* Creates a new cancel amm conv with the primary key. Does not add the cancel amm conv to the database.
	*
	* @param id_amministrazione_convocante the primary key for the new cancel amm conv
	* @return the new cancel amm conv
	*/
	public CancelAmmConv create(long id_amministrazione_convocante);

	/**
	* Removes the cancel amm conv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv that was removed
	* @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	*/
	public CancelAmmConv remove(long id_amministrazione_convocante)
		throws NoSuchCancelAmmConvException;

	public CancelAmmConv updateImpl(CancelAmmConv cancelAmmConv);

	/**
	* Returns the cancel amm conv with the primary key or throws a {@link NoSuchCancelAmmConvException} if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv
	* @throws NoSuchCancelAmmConvException if a cancel amm conv with the primary key could not be found
	*/
	public CancelAmmConv findByPrimaryKey(long id_amministrazione_convocante)
		throws NoSuchCancelAmmConvException;

	/**
	* Returns the cancel amm conv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv, or <code>null</code> if a cancel amm conv with the primary key could not be found
	*/
	public CancelAmmConv fetchByPrimaryKey(long id_amministrazione_convocante);

	@Override
	public java.util.Map<java.io.Serializable, CancelAmmConv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the cancel amm convs.
	*
	* @return the cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findAll();

	/**
	* Returns a range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @return the range of cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findAll(int start, int end);

	/**
	* Returns an ordered range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator);

	/**
	* Returns an ordered range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cancel amm convs
	*/
	public java.util.List<CancelAmmConv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelAmmConv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the cancel amm convs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of cancel amm convs.
	*
	* @return the number of cancel amm convs
	*/
	public int countAll();
}