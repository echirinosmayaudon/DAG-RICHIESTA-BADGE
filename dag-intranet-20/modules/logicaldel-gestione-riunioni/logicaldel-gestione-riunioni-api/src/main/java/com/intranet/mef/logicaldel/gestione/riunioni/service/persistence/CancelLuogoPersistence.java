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

import com.intranet.mef.logicaldel.gestione.riunioni.exception.NoSuchCancelLuogoException;
import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelLuogo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the cancel luogo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.persistence.impl.CancelLuogoPersistenceImpl
 * @see CancelLuogoUtil
 * @generated
 */
@ProviderType
public interface CancelLuogoPersistence extends BasePersistence<CancelLuogo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CancelLuogoUtil} to access the cancel luogo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cancel luogos where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the matching cancel luogos
	*/
	public java.util.List<CancelLuogo> findByLuoghiList(boolean cancellato);

	/**
	* Returns a range of all the cancel luogos where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @return the range of matching cancel luogos
	*/
	public java.util.List<CancelLuogo> findByLuoghiList(boolean cancellato,
		int start, int end);

	/**
	* Returns an ordered range of all the cancel luogos where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cancel luogos
	*/
	public java.util.List<CancelLuogo> findByLuoghiList(boolean cancellato,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator);

	/**
	* Returns an ordered range of all the cancel luogos where cancellato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cancellato the cancellato
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cancel luogos
	*/
	public java.util.List<CancelLuogo> findByLuoghiList(boolean cancellato,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel luogo
	* @throws NoSuchCancelLuogoException if a matching cancel luogo could not be found
	*/
	public CancelLuogo findByLuoghiList_First(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator)
		throws NoSuchCancelLuogoException;

	/**
	* Returns the first cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cancel luogo, or <code>null</code> if a matching cancel luogo could not be found
	*/
	public CancelLuogo fetchByLuoghiList_First(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator);

	/**
	* Returns the last cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel luogo
	* @throws NoSuchCancelLuogoException if a matching cancel luogo could not be found
	*/
	public CancelLuogo findByLuoghiList_Last(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator)
		throws NoSuchCancelLuogoException;

	/**
	* Returns the last cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cancel luogo, or <code>null</code> if a matching cancel luogo could not be found
	*/
	public CancelLuogo fetchByLuoghiList_Last(boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator);

	/**
	* Returns the cancel luogos before and after the current cancel luogo in the ordered set where cancellato = &#63;.
	*
	* @param id_luogo the primary key of the current cancel luogo
	* @param cancellato the cancellato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cancel luogo
	* @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	*/
	public CancelLuogo[] findByLuoghiList_PrevAndNext(long id_luogo,
		boolean cancellato,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator)
		throws NoSuchCancelLuogoException;

	/**
	* Removes all the cancel luogos where cancellato = &#63; from the database.
	*
	* @param cancellato the cancellato
	*/
	public void removeByLuoghiList(boolean cancellato);

	/**
	* Returns the number of cancel luogos where cancellato = &#63;.
	*
	* @param cancellato the cancellato
	* @return the number of matching cancel luogos
	*/
	public int countByLuoghiList(boolean cancellato);

	/**
	* Caches the cancel luogo in the entity cache if it is enabled.
	*
	* @param cancelLuogo the cancel luogo
	*/
	public void cacheResult(CancelLuogo cancelLuogo);

	/**
	* Caches the cancel luogos in the entity cache if it is enabled.
	*
	* @param cancelLuogos the cancel luogos
	*/
	public void cacheResult(java.util.List<CancelLuogo> cancelLuogos);

	/**
	* Creates a new cancel luogo with the primary key. Does not add the cancel luogo to the database.
	*
	* @param id_luogo the primary key for the new cancel luogo
	* @return the new cancel luogo
	*/
	public CancelLuogo create(long id_luogo);

	/**
	* Removes the cancel luogo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_luogo the primary key of the cancel luogo
	* @return the cancel luogo that was removed
	* @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	*/
	public CancelLuogo remove(long id_luogo) throws NoSuchCancelLuogoException;

	public CancelLuogo updateImpl(CancelLuogo cancelLuogo);

	/**
	* Returns the cancel luogo with the primary key or throws a {@link NoSuchCancelLuogoException} if it could not be found.
	*
	* @param id_luogo the primary key of the cancel luogo
	* @return the cancel luogo
	* @throws NoSuchCancelLuogoException if a cancel luogo with the primary key could not be found
	*/
	public CancelLuogo findByPrimaryKey(long id_luogo)
		throws NoSuchCancelLuogoException;

	/**
	* Returns the cancel luogo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_luogo the primary key of the cancel luogo
	* @return the cancel luogo, or <code>null</code> if a cancel luogo with the primary key could not be found
	*/
	public CancelLuogo fetchByPrimaryKey(long id_luogo);

	@Override
	public java.util.Map<java.io.Serializable, CancelLuogo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the cancel luogos.
	*
	* @return the cancel luogos
	*/
	public java.util.List<CancelLuogo> findAll();

	/**
	* Returns a range of all the cancel luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @return the range of cancel luogos
	*/
	public java.util.List<CancelLuogo> findAll(int start, int end);

	/**
	* Returns an ordered range of all the cancel luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cancel luogos
	*/
	public java.util.List<CancelLuogo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator);

	/**
	* Returns an ordered range of all the cancel luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CancelLuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel luogos
	* @param end the upper bound of the range of cancel luogos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cancel luogos
	*/
	public java.util.List<CancelLuogo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CancelLuogo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the cancel luogos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of cancel luogos.
	*
	* @return the number of cancel luogos
	*/
	public int countAll();
}