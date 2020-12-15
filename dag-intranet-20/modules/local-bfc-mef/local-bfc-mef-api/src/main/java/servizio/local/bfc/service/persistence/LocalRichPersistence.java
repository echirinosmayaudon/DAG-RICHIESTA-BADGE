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

package servizio.local.bfc.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.local.bfc.exception.NoSuchLocalRichException;
import servizio.local.bfc.model.LocalRich;

/**
 * The persistence interface for the local rich service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.local.bfc.service.persistence.impl.LocalRichPersistenceImpl
 * @see LocalRichUtil
 * @generated
 */
@ProviderType
public interface LocalRichPersistence extends BasePersistence<LocalRich> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocalRichUtil} to access the local rich persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the local richs where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the matching local richs
	*/
	public java.util.List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email);

	/**
	* Returns a range of all the local richs where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of matching local richs
	*/
	public java.util.List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email, int start, int end);

	/**
	* Returns an ordered range of all the local richs where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local richs
	*/
	public java.util.List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator);

	/**
	* Returns an ordered range of all the local richs where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local richs
	*/
	public java.util.List<LocalRich> findByemailReqBfc(boolean inStage,
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public LocalRich findByemailReqBfc_First(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException;

	/**
	* Returns the first local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public LocalRich fetchByemailReqBfc_First(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator);

	/**
	* Returns the last local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public LocalRich findByemailReqBfc_Last(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException;

	/**
	* Returns the last local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public LocalRich fetchByemailReqBfc_Last(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator);

	/**
	* Returns the local richs before and after the current local rich in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param id the primary key of the current local rich
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public LocalRich[] findByemailReqBfc_PrevAndNext(long id, boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException;

	/**
	* Removes all the local richs where inStage = &#63; and email = &#63; from the database.
	*
	* @param inStage the in stage
	* @param email the email
	*/
	public void removeByemailReqBfc(boolean inStage, java.lang.String email);

	/**
	* Returns the number of local richs where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the number of matching local richs
	*/
	public int countByemailReqBfc(boolean inStage, java.lang.String email);

	/**
	* Returns all the local richs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching local richs
	*/
	public java.util.List<LocalRich> findByIdRichiesta(long id_richiesta);

	/**
	* Returns a range of all the local richs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of matching local richs
	*/
	public java.util.List<LocalRich> findByIdRichiesta(long id_richiesta,
		int start, int end);

	/**
	* Returns an ordered range of all the local richs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local richs
	*/
	public java.util.List<LocalRich> findByIdRichiesta(long id_richiesta,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator);

	/**
	* Returns an ordered range of all the local richs where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local richs
	*/
	public java.util.List<LocalRich> findByIdRichiesta(long id_richiesta,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public LocalRich findByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException;

	/**
	* Returns the first local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public LocalRich fetchByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator);

	/**
	* Returns the last local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich
	* @throws NoSuchLocalRichException if a matching local rich could not be found
	*/
	public LocalRich findByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException;

	/**
	* Returns the last local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich, or <code>null</code> if a matching local rich could not be found
	*/
	public LocalRich fetchByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator);

	/**
	* Returns the local richs before and after the current local rich in the ordered set where id_richiesta = &#63;.
	*
	* @param id the primary key of the current local rich
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public LocalRich[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException;

	/**
	* Removes all the local richs where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public void removeByIdRichiesta(long id_richiesta);

	/**
	* Returns the number of local richs where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching local richs
	*/
	public int countByIdRichiesta(long id_richiesta);

	/**
	* Caches the local rich in the entity cache if it is enabled.
	*
	* @param localRich the local rich
	*/
	public void cacheResult(LocalRich localRich);

	/**
	* Caches the local richs in the entity cache if it is enabled.
	*
	* @param localRichs the local richs
	*/
	public void cacheResult(java.util.List<LocalRich> localRichs);

	/**
	* Creates a new local rich with the primary key. Does not add the local rich to the database.
	*
	* @param id the primary key for the new local rich
	* @return the new local rich
	*/
	public LocalRich create(long id);

	/**
	* Removes the local rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the local rich
	* @return the local rich that was removed
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public LocalRich remove(long id) throws NoSuchLocalRichException;

	public LocalRich updateImpl(LocalRich localRich);

	/**
	* Returns the local rich with the primary key or throws a {@link NoSuchLocalRichException} if it could not be found.
	*
	* @param id the primary key of the local rich
	* @return the local rich
	* @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	*/
	public LocalRich findByPrimaryKey(long id) throws NoSuchLocalRichException;

	/**
	* Returns the local rich with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the local rich
	* @return the local rich, or <code>null</code> if a local rich with the primary key could not be found
	*/
	public LocalRich fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, LocalRich> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the local richs.
	*
	* @return the local richs
	*/
	public java.util.List<LocalRich> findAll();

	/**
	* Returns a range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of local richs
	*/
	public java.util.List<LocalRich> findAll(int start, int end);

	/**
	* Returns an ordered range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of local richs
	*/
	public java.util.List<LocalRich> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator);

	/**
	* Returns an ordered range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of local richs
	*/
	public java.util.List<LocalRich> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRich> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the local richs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of local richs.
	*
	* @return the number of local richs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}