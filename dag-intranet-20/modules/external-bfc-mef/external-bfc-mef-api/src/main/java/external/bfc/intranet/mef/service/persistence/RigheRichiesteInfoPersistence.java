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

import external.bfc.intranet.mef.exception.NoSuchRigheRichiesteInfoException;
import external.bfc.intranet.mef.model.RigheRichiesteInfo;

/**
 * The persistence interface for the righe richieste info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.persistence.impl.RigheRichiesteInfoPersistenceImpl
 * @see RigheRichiesteInfoUtil
 * @generated
 */
@ProviderType
public interface RigheRichiesteInfoPersistence extends BasePersistence<RigheRichiesteInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RigheRichiesteInfoUtil} to access the righe richieste info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the righe richieste infos where id = &#63;.
	*
	* @param id the ID
	* @return the matching righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findByrichiesteInfoId(long id);

	/**
	* Returns a range of all the righe richieste infos where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @return the range of matching righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findByrichiesteInfoId(long id,
		int start, int end);

	/**
	* Returns an ordered range of all the righe richieste infos where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findByrichiesteInfoId(long id,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator);

	/**
	* Returns an ordered range of all the righe richieste infos where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findByrichiesteInfoId(long id,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a matching righe richieste info could not be found
	*/
	public RigheRichiesteInfo findByrichiesteInfoId_First(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws NoSuchRigheRichiesteInfoException;

	/**
	* Returns the first righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste info, or <code>null</code> if a matching righe richieste info could not be found
	*/
	public RigheRichiesteInfo fetchByrichiesteInfoId_First(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator);

	/**
	* Returns the last righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a matching righe richieste info could not be found
	*/
	public RigheRichiesteInfo findByrichiesteInfoId_Last(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws NoSuchRigheRichiesteInfoException;

	/**
	* Returns the last righe richieste info in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste info, or <code>null</code> if a matching righe richieste info could not be found
	*/
	public RigheRichiesteInfo fetchByrichiesteInfoId_Last(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator);

	/**
	* Returns the righe richieste infos before and after the current righe richieste info in the ordered set where id = &#63;.
	*
	* @param righeRichiesteInfoPK the primary key of the current righe richieste info
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	*/
	public RigheRichiesteInfo[] findByrichiesteInfoId_PrevAndNext(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK,
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws NoSuchRigheRichiesteInfoException;

	/**
	* Removes all the righe richieste infos where id = &#63; from the database.
	*
	* @param id the ID
	*/
	public void removeByrichiesteInfoId(long id);

	/**
	* Returns the number of righe richieste infos where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching righe richieste infos
	*/
	public int countByrichiesteInfoId(long id);

	/**
	* Caches the righe richieste info in the entity cache if it is enabled.
	*
	* @param righeRichiesteInfo the righe richieste info
	*/
	public void cacheResult(RigheRichiesteInfo righeRichiesteInfo);

	/**
	* Caches the righe richieste infos in the entity cache if it is enabled.
	*
	* @param righeRichiesteInfos the righe richieste infos
	*/
	public void cacheResult(
		java.util.List<RigheRichiesteInfo> righeRichiesteInfos);

	/**
	* Creates a new righe richieste info with the primary key. Does not add the righe richieste info to the database.
	*
	* @param righeRichiesteInfoPK the primary key for the new righe richieste info
	* @return the new righe richieste info
	*/
	public RigheRichiesteInfo create(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK);

	/**
	* Removes the righe richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info that was removed
	* @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	*/
	public RigheRichiesteInfo remove(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws NoSuchRigheRichiesteInfoException;

	public RigheRichiesteInfo updateImpl(RigheRichiesteInfo righeRichiesteInfo);

	/**
	* Returns the righe richieste info with the primary key or throws a {@link NoSuchRigheRichiesteInfoException} if it could not be found.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info
	* @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	*/
	public RigheRichiesteInfo findByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws NoSuchRigheRichiesteInfoException;

	/**
	* Returns the righe richieste info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info, or <code>null</code> if a righe richieste info with the primary key could not be found
	*/
	public RigheRichiesteInfo fetchByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK);

	@Override
	public java.util.Map<java.io.Serializable, RigheRichiesteInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the righe richieste infos.
	*
	* @return the righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findAll();

	/**
	* Returns a range of all the righe richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @return the range of righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findAll(int start, int end);

	/**
	* Returns an ordered range of all the righe richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator);

	/**
	* Returns an ordered range of all the righe richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe richieste infos
	*/
	public java.util.List<RigheRichiesteInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichiesteInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the righe richieste infos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of righe richieste infos.
	*
	* @return the number of righe richieste infos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}