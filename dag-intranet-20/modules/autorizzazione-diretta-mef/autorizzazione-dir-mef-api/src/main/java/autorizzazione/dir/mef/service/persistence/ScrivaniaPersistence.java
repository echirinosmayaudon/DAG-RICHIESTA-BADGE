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

import autorizzazione.dir.mef.exception.NoSuchScrivaniaException;
import autorizzazione.dir.mef.model.Scrivania;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the scrivania service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see autorizzazione.dir.mef.service.persistence.impl.ScrivaniaPersistenceImpl
 * @see ScrivaniaUtil
 * @generated
 */
@ProviderType
public interface ScrivaniaPersistence extends BasePersistence<Scrivania> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScrivaniaUtil} to access the scrivania persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the scrivanias where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @return the matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H(long userId, boolean homeFlag);

	/**
	* Returns a range of all the scrivanias where userId = &#63; and homeFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @return the range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H(long userId, boolean homeFlag,
		int start, int end);

	/**
	* Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H(long userId, boolean homeFlag,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H(long userId, boolean homeFlag,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public Scrivania findByU_H_First(long userId, boolean homeFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public Scrivania fetchByU_H_First(long userId, boolean homeFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public Scrivania findByU_H_Last(long userId, boolean homeFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public Scrivania fetchByU_H_Last(long userId, boolean homeFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns the scrivanias before and after the current scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param scrivaniaPK the primary key of the current scrivania
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next scrivania
	* @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	*/
	public Scrivania[] findByU_H_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK,
		long userId, boolean homeFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Removes all the scrivanias where userId = &#63; and homeFlag = &#63; from the database.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	*/
	public void removeByU_H(long userId, boolean homeFlag);

	/**
	* Returns the number of scrivanias where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @return the number of matching scrivanias
	*/
	public int countByU_H(long userId, boolean homeFlag);

	/**
	* Returns all the scrivanias where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @return the matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_P(long userId, boolean profileFlag);

	/**
	* Returns a range of all the scrivanias where userId = &#63; and profileFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @return the range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_P(long userId,
		boolean profileFlag, int start, int end);

	/**
	* Returns an ordered range of all the scrivanias where userId = &#63; and profileFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_P(long userId,
		boolean profileFlag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns an ordered range of all the scrivanias where userId = &#63; and profileFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_P(long userId,
		boolean profileFlag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public Scrivania findByU_P_First(long userId, boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public Scrivania fetchByU_P_First(long userId, boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public Scrivania findByU_P_Last(long userId, boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public Scrivania fetchByU_P_Last(long userId, boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns the scrivanias before and after the current scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param scrivaniaPK the primary key of the current scrivania
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next scrivania
	* @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	*/
	public Scrivania[] findByU_P_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK,
		long userId, boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Removes all the scrivanias where userId = &#63; and profileFlag = &#63; from the database.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	*/
	public void removeByU_P(long userId, boolean profileFlag);

	/**
	* Returns the number of scrivanias where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @return the number of matching scrivanias
	*/
	public int countByU_P(long userId, boolean profileFlag);

	/**
	* Returns all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @return the matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag);

	/**
	* Returns a range of all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @return the range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end);

	/**
	* Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns an ordered range of all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching scrivanias
	*/
	public java.util.List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public Scrivania findByU_H_P_First(long userId, boolean homeFlag,
		boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public Scrivania fetchByU_H_P_First(long userId, boolean homeFlag,
		boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public Scrivania findByU_H_P_Last(long userId, boolean homeFlag,
		boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public Scrivania fetchByU_H_P_Last(long userId, boolean homeFlag,
		boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns the scrivanias before and after the current scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param scrivaniaPK the primary key of the current scrivania
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next scrivania
	* @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	*/
	public Scrivania[] findByU_H_P_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK,
		long userId, boolean homeFlag, boolean profileFlag,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator)
		throws NoSuchScrivaniaException;

	/**
	* Removes all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63; from the database.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	*/
	public void removeByU_H_P(long userId, boolean homeFlag, boolean profileFlag);

	/**
	* Returns the number of scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @return the number of matching scrivanias
	*/
	public int countByU_H_P(long userId, boolean homeFlag, boolean profileFlag);

	/**
	* Caches the scrivania in the entity cache if it is enabled.
	*
	* @param scrivania the scrivania
	*/
	public void cacheResult(Scrivania scrivania);

	/**
	* Caches the scrivanias in the entity cache if it is enabled.
	*
	* @param scrivanias the scrivanias
	*/
	public void cacheResult(java.util.List<Scrivania> scrivanias);

	/**
	* Creates a new scrivania with the primary key. Does not add the scrivania to the database.
	*
	* @param scrivaniaPK the primary key for the new scrivania
	* @return the new scrivania
	*/
	public Scrivania create(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK);

	/**
	* Removes the scrivania with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania that was removed
	* @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	*/
	public Scrivania remove(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK)
		throws NoSuchScrivaniaException;

	public Scrivania updateImpl(Scrivania scrivania);

	/**
	* Returns the scrivania with the primary key or throws a {@link NoSuchScrivaniaException} if it could not be found.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania
	* @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	*/
	public Scrivania findByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK)
		throws NoSuchScrivaniaException;

	/**
	* Returns the scrivania with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania, or <code>null</code> if a scrivania with the primary key could not be found
	*/
	public Scrivania fetchByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK);

	@Override
	public java.util.Map<java.io.Serializable, Scrivania> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the scrivanias.
	*
	* @return the scrivanias
	*/
	public java.util.List<Scrivania> findAll();

	/**
	* Returns a range of all the scrivanias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @return the range of scrivanias
	*/
	public java.util.List<Scrivania> findAll(int start, int end);

	/**
	* Returns an ordered range of all the scrivanias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of scrivanias
	*/
	public java.util.List<Scrivania> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator);

	/**
	* Returns an ordered range of all the scrivanias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScrivaniaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scrivanias
	* @param end the upper bound of the range of scrivanias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of scrivanias
	*/
	public java.util.List<Scrivania> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the scrivanias from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of scrivanias.
	*
	* @return the number of scrivanias
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}