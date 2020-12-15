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

import com.accenture.lavoro.agile.istanza.mef.exception.NoSuchOpzioneRichException;
import com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the opzione rich service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.lavoro.agile.istanza.mef.service.persistence.impl.OpzioneRichPersistenceImpl
 * @see OpzioneRichUtil
 * @generated
 */
@ProviderType
public interface OpzioneRichPersistence extends BasePersistence<OpzioneRich> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OpzioneRichUtil} to access the opzione rich persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the opzione richs where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @return the matching opzione richs
	*/
	public java.util.List<OpzioneRich> findBylabel_opt(String label_opt);

	/**
	* Returns a range of all the opzione richs where label_opt = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_opt the label_opt
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @return the range of matching opzione richs
	*/
	public java.util.List<OpzioneRich> findBylabel_opt(String label_opt,
		int start, int end);

	/**
	* Returns an ordered range of all the opzione richs where label_opt = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_opt the label_opt
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching opzione richs
	*/
	public java.util.List<OpzioneRich> findBylabel_opt(String label_opt,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator);

	/**
	* Returns an ordered range of all the opzione richs where label_opt = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_opt the label_opt
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching opzione richs
	*/
	public java.util.List<OpzioneRich> findBylabel_opt(String label_opt,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching opzione rich
	* @throws NoSuchOpzioneRichException if a matching opzione rich could not be found
	*/
	public OpzioneRich findBylabel_opt_First(String label_opt,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator)
		throws NoSuchOpzioneRichException;

	/**
	* Returns the first opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching opzione rich, or <code>null</code> if a matching opzione rich could not be found
	*/
	public OpzioneRich fetchBylabel_opt_First(String label_opt,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator);

	/**
	* Returns the last opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching opzione rich
	* @throws NoSuchOpzioneRichException if a matching opzione rich could not be found
	*/
	public OpzioneRich findBylabel_opt_Last(String label_opt,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator)
		throws NoSuchOpzioneRichException;

	/**
	* Returns the last opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching opzione rich, or <code>null</code> if a matching opzione rich could not be found
	*/
	public OpzioneRich fetchBylabel_opt_Last(String label_opt,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator);

	/**
	* Returns the opzione richs before and after the current opzione rich in the ordered set where label_opt = &#63;.
	*
	* @param id_opt the primary key of the current opzione rich
	* @param label_opt the label_opt
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next opzione rich
	* @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	*/
	public OpzioneRich[] findBylabel_opt_PrevAndNext(long id_opt,
		String label_opt,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator)
		throws NoSuchOpzioneRichException;

	/**
	* Removes all the opzione richs where label_opt = &#63; from the database.
	*
	* @param label_opt the label_opt
	*/
	public void removeBylabel_opt(String label_opt);

	/**
	* Returns the number of opzione richs where label_opt = &#63;.
	*
	* @param label_opt the label_opt
	* @return the number of matching opzione richs
	*/
	public int countBylabel_opt(String label_opt);

	/**
	* Caches the opzione rich in the entity cache if it is enabled.
	*
	* @param opzioneRich the opzione rich
	*/
	public void cacheResult(OpzioneRich opzioneRich);

	/**
	* Caches the opzione richs in the entity cache if it is enabled.
	*
	* @param opzioneRichs the opzione richs
	*/
	public void cacheResult(java.util.List<OpzioneRich> opzioneRichs);

	/**
	* Creates a new opzione rich with the primary key. Does not add the opzione rich to the database.
	*
	* @param id_opt the primary key for the new opzione rich
	* @return the new opzione rich
	*/
	public OpzioneRich create(long id_opt);

	/**
	* Removes the opzione rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich that was removed
	* @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	*/
	public OpzioneRich remove(long id_opt) throws NoSuchOpzioneRichException;

	public OpzioneRich updateImpl(OpzioneRich opzioneRich);

	/**
	* Returns the opzione rich with the primary key or throws a {@link NoSuchOpzioneRichException} if it could not be found.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich
	* @throws NoSuchOpzioneRichException if a opzione rich with the primary key could not be found
	*/
	public OpzioneRich findByPrimaryKey(long id_opt)
		throws NoSuchOpzioneRichException;

	/**
	* Returns the opzione rich with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich, or <code>null</code> if a opzione rich with the primary key could not be found
	*/
	public OpzioneRich fetchByPrimaryKey(long id_opt);

	@Override
	public java.util.Map<java.io.Serializable, OpzioneRich> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the opzione richs.
	*
	* @return the opzione richs
	*/
	public java.util.List<OpzioneRich> findAll();

	/**
	* Returns a range of all the opzione richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @return the range of opzione richs
	*/
	public java.util.List<OpzioneRich> findAll(int start, int end);

	/**
	* Returns an ordered range of all the opzione richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of opzione richs
	*/
	public java.util.List<OpzioneRich> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator);

	/**
	* Returns an ordered range of all the opzione richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of opzione richs
	*/
	public java.util.List<OpzioneRich> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OpzioneRich> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the opzione richs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of opzione richs.
	*
	* @return the number of opzione richs
	*/
	public int countAll();
}