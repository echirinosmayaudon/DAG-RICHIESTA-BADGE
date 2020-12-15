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

package autorizzazione.dir.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.exception.NoSuchUtilizzoApplicazioniException;
import autorizzazione.dir.mef.model.UtilizzoApplicazioni;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the utilizzo applicazioni service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see autorizzazione.dir.mef.service.persistence.impl.UtilizzoApplicazioniPersistenceImpl
 * @see UtilizzoApplicazioniUtil
 * @generated
 */
@ProviderType
public interface UtilizzoApplicazioniPersistence extends BasePersistence<UtilizzoApplicazioni> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UtilizzoApplicazioniUtil} to access the utilizzo applicazioni persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the utilizzo applicazionis where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findByUserId(long userId);

	/**
	* Returns a range of all the utilizzo applicazionis where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @return the range of matching utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findByUserId(long userId,
		int start, int end);

	/**
	* Returns an ordered range of all the utilizzo applicazionis where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator);

	/**
	* Returns an ordered range of all the utilizzo applicazionis where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a matching utilizzo applicazioni could not be found
	*/
	public UtilizzoApplicazioni findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws NoSuchUtilizzoApplicazioniException;

	/**
	* Returns the first utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching utilizzo applicazioni, or <code>null</code> if a matching utilizzo applicazioni could not be found
	*/
	public UtilizzoApplicazioni fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator);

	/**
	* Returns the last utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a matching utilizzo applicazioni could not be found
	*/
	public UtilizzoApplicazioni findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws NoSuchUtilizzoApplicazioniException;

	/**
	* Returns the last utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching utilizzo applicazioni, or <code>null</code> if a matching utilizzo applicazioni could not be found
	*/
	public UtilizzoApplicazioni fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator);

	/**
	* Returns the utilizzo applicazionis before and after the current utilizzo applicazioni in the ordered set where userId = &#63;.
	*
	* @param utilizzoApplicazioniPK the primary key of the current utilizzo applicazioni
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	*/
	public UtilizzoApplicazioni[] findByUserId_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator)
		throws NoSuchUtilizzoApplicazioniException;

	/**
	* Removes all the utilizzo applicazionis where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of utilizzo applicazionis where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching utilizzo applicazionis
	*/
	public int countByUserId(long userId);

	/**
	* Caches the utilizzo applicazioni in the entity cache if it is enabled.
	*
	* @param utilizzoApplicazioni the utilizzo applicazioni
	*/
	public void cacheResult(UtilizzoApplicazioni utilizzoApplicazioni);

	/**
	* Caches the utilizzo applicazionis in the entity cache if it is enabled.
	*
	* @param utilizzoApplicazionis the utilizzo applicazionis
	*/
	public void cacheResult(
		java.util.List<UtilizzoApplicazioni> utilizzoApplicazionis);

	/**
	* Creates a new utilizzo applicazioni with the primary key. Does not add the utilizzo applicazioni to the database.
	*
	* @param utilizzoApplicazioniPK the primary key for the new utilizzo applicazioni
	* @return the new utilizzo applicazioni
	*/
	public UtilizzoApplicazioni create(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK);

	/**
	* Removes the utilizzo applicazioni with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni that was removed
	* @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	*/
	public UtilizzoApplicazioni remove(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws NoSuchUtilizzoApplicazioniException;

	public UtilizzoApplicazioni updateImpl(
		UtilizzoApplicazioni utilizzoApplicazioni);

	/**
	* Returns the utilizzo applicazioni with the primary key or throws a {@link NoSuchUtilizzoApplicazioniException} if it could not be found.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni
	* @throws NoSuchUtilizzoApplicazioniException if a utilizzo applicazioni with the primary key could not be found
	*/
	public UtilizzoApplicazioni findByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws NoSuchUtilizzoApplicazioniException;

	/**
	* Returns the utilizzo applicazioni with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni, or <code>null</code> if a utilizzo applicazioni with the primary key could not be found
	*/
	public UtilizzoApplicazioni fetchByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK);

	@Override
	public java.util.Map<java.io.Serializable, UtilizzoApplicazioni> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the utilizzo applicazionis.
	*
	* @return the utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findAll();

	/**
	* Returns a range of all the utilizzo applicazionis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @return the range of utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findAll(int start, int end);

	/**
	* Returns an ordered range of all the utilizzo applicazionis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator);

	/**
	* Returns an ordered range of all the utilizzo applicazionis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of utilizzo applicazionis
	*/
	public java.util.List<UtilizzoApplicazioni> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UtilizzoApplicazioni> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the utilizzo applicazionis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of utilizzo applicazionis.
	*
	* @return the number of utilizzo applicazionis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}