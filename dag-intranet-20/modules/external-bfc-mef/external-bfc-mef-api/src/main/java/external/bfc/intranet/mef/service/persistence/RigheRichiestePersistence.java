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

import external.bfc.intranet.mef.exception.NoSuchRigheRichiesteException;
import external.bfc.intranet.mef.model.RigheRichieste;

/**
 * The persistence interface for the righe richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.persistence.impl.RigheRichiestePersistenceImpl
 * @see RigheRichiesteUtil
 * @generated
 */
@ProviderType
public interface RigheRichiestePersistence extends BasePersistence<RigheRichieste> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RigheRichiesteUtil} to access the righe richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the righe richiestes where id = &#63;.
	*
	* @param id the ID
	* @return the matching righe richiestes
	*/
	public java.util.List<RigheRichieste> findByrichiesteId(long id);

	/**
	* Returns a range of all the righe richiestes where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @return the range of matching righe richiestes
	*/
	public java.util.List<RigheRichieste> findByrichiesteId(long id, int start,
		int end);

	/**
	* Returns an ordered range of all the righe richiestes where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe richiestes
	*/
	public java.util.List<RigheRichieste> findByrichiesteId(long id, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator);

	/**
	* Returns an ordered range of all the righe richiestes where id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id the ID
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe richiestes
	*/
	public java.util.List<RigheRichieste> findByrichiesteId(long id, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste
	* @throws NoSuchRigheRichiesteException if a matching righe richieste could not be found
	*/
	public RigheRichieste findByrichiesteId_First(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator)
		throws NoSuchRigheRichiesteException;

	/**
	* Returns the first righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe richieste, or <code>null</code> if a matching righe richieste could not be found
	*/
	public RigheRichieste fetchByrichiesteId_First(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator);

	/**
	* Returns the last righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste
	* @throws NoSuchRigheRichiesteException if a matching righe richieste could not be found
	*/
	public RigheRichieste findByrichiesteId_Last(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator)
		throws NoSuchRigheRichiesteException;

	/**
	* Returns the last righe richieste in the ordered set where id = &#63;.
	*
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe richieste, or <code>null</code> if a matching righe richieste could not be found
	*/
	public RigheRichieste fetchByrichiesteId_Last(long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator);

	/**
	* Returns the righe richiestes before and after the current righe richieste in the ordered set where id = &#63;.
	*
	* @param righeRichiestePK the primary key of the current righe richieste
	* @param id the ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe richieste
	* @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	*/
	public RigheRichieste[] findByrichiesteId_PrevAndNext(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK,
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator)
		throws NoSuchRigheRichiesteException;

	/**
	* Removes all the righe richiestes where id = &#63; from the database.
	*
	* @param id the ID
	*/
	public void removeByrichiesteId(long id);

	/**
	* Returns the number of righe richiestes where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching righe richiestes
	*/
	public int countByrichiesteId(long id);

	/**
	* Caches the righe richieste in the entity cache if it is enabled.
	*
	* @param righeRichieste the righe richieste
	*/
	public void cacheResult(RigheRichieste righeRichieste);

	/**
	* Caches the righe richiestes in the entity cache if it is enabled.
	*
	* @param righeRichiestes the righe richiestes
	*/
	public void cacheResult(java.util.List<RigheRichieste> righeRichiestes);

	/**
	* Creates a new righe richieste with the primary key. Does not add the righe richieste to the database.
	*
	* @param righeRichiestePK the primary key for the new righe richieste
	* @return the new righe richieste
	*/
	public RigheRichieste create(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK);

	/**
	* Removes the righe richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste that was removed
	* @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	*/
	public RigheRichieste remove(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK)
		throws NoSuchRigheRichiesteException;

	public RigheRichieste updateImpl(RigheRichieste righeRichieste);

	/**
	* Returns the righe richieste with the primary key or throws a {@link NoSuchRigheRichiesteException} if it could not be found.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste
	* @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	*/
	public RigheRichieste findByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK)
		throws NoSuchRigheRichiesteException;

	/**
	* Returns the righe richieste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste, or <code>null</code> if a righe richieste with the primary key could not be found
	*/
	public RigheRichieste fetchByPrimaryKey(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK);

	@Override
	public java.util.Map<java.io.Serializable, RigheRichieste> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the righe richiestes.
	*
	* @return the righe richiestes
	*/
	public java.util.List<RigheRichieste> findAll();

	/**
	* Returns a range of all the righe richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @return the range of righe richiestes
	*/
	public java.util.List<RigheRichieste> findAll(int start, int end);

	/**
	* Returns an ordered range of all the righe richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe richiestes
	*/
	public java.util.List<RigheRichieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator);

	/**
	* Returns an ordered range of all the righe richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe richiestes
	*/
	public java.util.List<RigheRichieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the righe richiestes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of righe richiestes.
	*
	* @return the number of righe richiestes
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}