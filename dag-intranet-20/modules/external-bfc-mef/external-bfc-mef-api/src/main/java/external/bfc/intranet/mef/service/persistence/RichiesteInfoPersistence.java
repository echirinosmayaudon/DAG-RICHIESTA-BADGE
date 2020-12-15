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

package external.bfc.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import external.bfc.intranet.mef.exception.NoSuchRichiesteInfoException;
import external.bfc.intranet.mef.model.RichiesteInfo;

/**
 * The persistence interface for the richieste info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.persistence.impl.RichiesteInfoPersistenceImpl
 * @see RichiesteInfoUtil
 * @generated
 */
@ProviderType
public interface RichiesteInfoPersistence extends BasePersistence<RichiesteInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiesteInfoUtil} to access the richieste info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the richieste infos where email = &#63;.
	*
	* @param email the email
	* @return the matching richieste infos
	*/
	public java.util.List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email);

	/**
	* Returns a range of all the richieste infos where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @return the range of matching richieste infos
	*/
	public java.util.List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email, int start, int end);

	/**
	* Returns an ordered range of all the richieste infos where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richieste infos
	*/
	public java.util.List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator);

	/**
	* Returns an ordered range of all the richieste infos where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richieste infos
	*/
	public java.util.List<RichiesteInfo> findByemailReqBfcInfo(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste info
	* @throws NoSuchRichiesteInfoException if a matching richieste info could not be found
	*/
	public RichiesteInfo findByemailReqBfcInfo_First(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator)
		throws NoSuchRichiesteInfoException;

	/**
	* Returns the first richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste info, or <code>null</code> if a matching richieste info could not be found
	*/
	public RichiesteInfo fetchByemailReqBfcInfo_First(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator);

	/**
	* Returns the last richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste info
	* @throws NoSuchRichiesteInfoException if a matching richieste info could not be found
	*/
	public RichiesteInfo findByemailReqBfcInfo_Last(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator)
		throws NoSuchRichiesteInfoException;

	/**
	* Returns the last richieste info in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste info, or <code>null</code> if a matching richieste info could not be found
	*/
	public RichiesteInfo fetchByemailReqBfcInfo_Last(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator);

	/**
	* Returns the richieste infos before and after the current richieste info in the ordered set where email = &#63;.
	*
	* @param id the primary key of the current richieste info
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richieste info
	* @throws NoSuchRichiesteInfoException if a richieste info with the primary key could not be found
	*/
	public RichiesteInfo[] findByemailReqBfcInfo_PrevAndNext(long id,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator)
		throws NoSuchRichiesteInfoException;

	/**
	* Removes all the richieste infos where email = &#63; from the database.
	*
	* @param email the email
	*/
	public void removeByemailReqBfcInfo(java.lang.String email);

	/**
	* Returns the number of richieste infos where email = &#63;.
	*
	* @param email the email
	* @return the number of matching richieste infos
	*/
	public int countByemailReqBfcInfo(java.lang.String email);

	/**
	* Caches the richieste info in the entity cache if it is enabled.
	*
	* @param richiesteInfo the richieste info
	*/
	public void cacheResult(RichiesteInfo richiesteInfo);

	/**
	* Caches the richieste infos in the entity cache if it is enabled.
	*
	* @param richiesteInfos the richieste infos
	*/
	public void cacheResult(java.util.List<RichiesteInfo> richiesteInfos);

	/**
	* Creates a new richieste info with the primary key. Does not add the richieste info to the database.
	*
	* @param id the primary key for the new richieste info
	* @return the new richieste info
	*/
	public RichiesteInfo create(long id);

	/**
	* Removes the richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info that was removed
	* @throws NoSuchRichiesteInfoException if a richieste info with the primary key could not be found
	*/
	public RichiesteInfo remove(long id) throws NoSuchRichiesteInfoException;

	public RichiesteInfo updateImpl(RichiesteInfo richiesteInfo);

	/**
	* Returns the richieste info with the primary key or throws a {@link NoSuchRichiesteInfoException} if it could not be found.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info
	* @throws NoSuchRichiesteInfoException if a richieste info with the primary key could not be found
	*/
	public RichiesteInfo findByPrimaryKey(long id)
		throws NoSuchRichiesteInfoException;

	/**
	* Returns the richieste info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info, or <code>null</code> if a richieste info with the primary key could not be found
	*/
	public RichiesteInfo fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, RichiesteInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richieste infos.
	*
	* @return the richieste infos
	*/
	public java.util.List<RichiesteInfo> findAll();

	/**
	* Returns a range of all the richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @return the range of richieste infos
	*/
	public java.util.List<RichiesteInfo> findAll(int start, int end);

	/**
	* Returns an ordered range of all the richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste infos
	*/
	public java.util.List<RichiesteInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator);

	/**
	* Returns an ordered range of all the richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste infos
	*/
	public java.util.List<RichiesteInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richieste infos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richieste infos.
	*
	* @return the number of richieste infos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}