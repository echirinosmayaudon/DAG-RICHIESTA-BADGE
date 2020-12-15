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

import servizio.local.bfc.exception.NoSuchLocalRichInfoException;
import servizio.local.bfc.model.LocalRichInfo;

/**
 * The persistence interface for the local rich info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.local.bfc.service.persistence.impl.LocalRichInfoPersistenceImpl
 * @see LocalRichInfoUtil
 * @generated
 */
@ProviderType
public interface LocalRichInfoPersistence extends BasePersistence<LocalRichInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocalRichInfoUtil} to access the local rich info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByemailReqBfcInfo(
		boolean inStage, java.lang.String email);

	/**
	* Returns a range of all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @return the range of matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByemailReqBfcInfo(
		boolean inStage, java.lang.String email, int start, int end);

	/**
	* Returns an ordered range of all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByemailReqBfcInfo(
		boolean inStage, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator);

	/**
	* Returns an ordered range of all the local rich infos where inStage = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param inStage the in stage
	* @param email the email
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByemailReqBfcInfo(
		boolean inStage, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public LocalRichInfo findByemailReqBfcInfo_First(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException;

	/**
	* Returns the first local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public LocalRichInfo fetchByemailReqBfcInfo_First(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator);

	/**
	* Returns the last local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public LocalRichInfo findByemailReqBfcInfo_Last(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException;

	/**
	* Returns the last local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public LocalRichInfo fetchByemailReqBfcInfo_Last(boolean inStage,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator);

	/**
	* Returns the local rich infos before and after the current local rich info in the ordered set where inStage = &#63; and email = &#63;.
	*
	* @param id the primary key of the current local rich info
	* @param inStage the in stage
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich info
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public LocalRichInfo[] findByemailReqBfcInfo_PrevAndNext(long id,
		boolean inStage, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException;

	/**
	* Removes all the local rich infos where inStage = &#63; and email = &#63; from the database.
	*
	* @param inStage the in stage
	* @param email the email
	*/
	public void removeByemailReqBfcInfo(boolean inStage, java.lang.String email);

	/**
	* Returns the number of local rich infos where inStage = &#63; and email = &#63;.
	*
	* @param inStage the in stage
	* @param email the email
	* @return the number of matching local rich infos
	*/
	public int countByemailReqBfcInfo(boolean inStage, java.lang.String email);

	/**
	* Returns all the local rich infos where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByIdRichiesta(long id_richiesta);

	/**
	* Returns a range of all the local rich infos where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @return the range of matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByIdRichiesta(long id_richiesta,
		int start, int end);

	/**
	* Returns an ordered range of all the local rich infos where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByIdRichiesta(long id_richiesta,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator);

	/**
	* Returns an ordered range of all the local rich infos where id_richiesta = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_richiesta the id_richiesta
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching local rich infos
	*/
	public java.util.List<LocalRichInfo> findByIdRichiesta(long id_richiesta,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public LocalRichInfo findByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException;

	/**
	* Returns the first local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public LocalRichInfo fetchByIdRichiesta_First(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator);

	/**
	* Returns the last local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info
	* @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	*/
	public LocalRichInfo findByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException;

	/**
	* Returns the last local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching local rich info, or <code>null</code> if a matching local rich info could not be found
	*/
	public LocalRichInfo fetchByIdRichiesta_Last(long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator);

	/**
	* Returns the local rich infos before and after the current local rich info in the ordered set where id_richiesta = &#63;.
	*
	* @param id the primary key of the current local rich info
	* @param id_richiesta the id_richiesta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next local rich info
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public LocalRichInfo[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException;

	/**
	* Removes all the local rich infos where id_richiesta = &#63; from the database.
	*
	* @param id_richiesta the id_richiesta
	*/
	public void removeByIdRichiesta(long id_richiesta);

	/**
	* Returns the number of local rich infos where id_richiesta = &#63;.
	*
	* @param id_richiesta the id_richiesta
	* @return the number of matching local rich infos
	*/
	public int countByIdRichiesta(long id_richiesta);

	/**
	* Caches the local rich info in the entity cache if it is enabled.
	*
	* @param localRichInfo the local rich info
	*/
	public void cacheResult(LocalRichInfo localRichInfo);

	/**
	* Caches the local rich infos in the entity cache if it is enabled.
	*
	* @param localRichInfos the local rich infos
	*/
	public void cacheResult(java.util.List<LocalRichInfo> localRichInfos);

	/**
	* Creates a new local rich info with the primary key. Does not add the local rich info to the database.
	*
	* @param id the primary key for the new local rich info
	* @return the new local rich info
	*/
	public LocalRichInfo create(long id);

	/**
	* Removes the local rich info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info that was removed
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public LocalRichInfo remove(long id) throws NoSuchLocalRichInfoException;

	public LocalRichInfo updateImpl(LocalRichInfo localRichInfo);

	/**
	* Returns the local rich info with the primary key or throws a {@link NoSuchLocalRichInfoException} if it could not be found.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info
	* @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	*/
	public LocalRichInfo findByPrimaryKey(long id)
		throws NoSuchLocalRichInfoException;

	/**
	* Returns the local rich info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info, or <code>null</code> if a local rich info with the primary key could not be found
	*/
	public LocalRichInfo fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, LocalRichInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the local rich infos.
	*
	* @return the local rich infos
	*/
	public java.util.List<LocalRichInfo> findAll();

	/**
	* Returns a range of all the local rich infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @return the range of local rich infos
	*/
	public java.util.List<LocalRichInfo> findAll(int start, int end);

	/**
	* Returns an ordered range of all the local rich infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of local rich infos
	*/
	public java.util.List<LocalRichInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator);

	/**
	* Returns an ordered range of all the local rich infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of local rich infos
	*/
	public java.util.List<LocalRichInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the local rich infos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of local rich infos.
	*
	* @return the number of local rich infos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}