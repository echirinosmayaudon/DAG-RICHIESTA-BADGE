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

import autorizzazione.dir.mef.model.Scrivania;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the scrivania service. This utility wraps {@link autorizzazione.dir.mef.service.persistence.impl.ScrivaniaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScrivaniaPersistence
 * @see autorizzazione.dir.mef.service.persistence.impl.ScrivaniaPersistenceImpl
 * @generated
 */
@ProviderType
public class ScrivaniaUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Scrivania scrivania) {
		getPersistence().clearCache(scrivania);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Scrivania> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Scrivania> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Scrivania> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Scrivania update(Scrivania scrivania) {
		return getPersistence().update(scrivania);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Scrivania update(Scrivania scrivania,
		ServiceContext serviceContext) {
		return getPersistence().update(scrivania, serviceContext);
	}

	/**
	* Returns all the scrivanias where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @return the matching scrivanias
	*/
	public static List<Scrivania> findByU_H(long userId, boolean homeFlag) {
		return getPersistence().findByU_H(userId, homeFlag);
	}

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
	public static List<Scrivania> findByU_H(long userId, boolean homeFlag,
		int start, int end) {
		return getPersistence().findByU_H(userId, homeFlag, start, end);
	}

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
	public static List<Scrivania> findByU_H(long userId, boolean homeFlag,
		int start, int end, OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .findByU_H(userId, homeFlag, start, end, orderByComparator);
	}

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
	public static List<Scrivania> findByU_H(long userId, boolean homeFlag,
		int start, int end, OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_H(userId, homeFlag, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public static Scrivania findByU_H_First(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_H_First(userId, homeFlag, orderByComparator);
	}

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public static Scrivania fetchByU_H_First(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_First(userId, homeFlag, orderByComparator);
	}

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public static Scrivania findByU_H_Last(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_H_Last(userId, homeFlag, orderByComparator);
	}

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public static Scrivania fetchByU_H_Last(long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_Last(userId, homeFlag, orderByComparator);
	}

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
	public static Scrivania[] findByU_H_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK,
		long userId, boolean homeFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_H_PrevAndNext(scrivaniaPK, userId, homeFlag,
			orderByComparator);
	}

	/**
	* Removes all the scrivanias where userId = &#63; and homeFlag = &#63; from the database.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	*/
	public static void removeByU_H(long userId, boolean homeFlag) {
		getPersistence().removeByU_H(userId, homeFlag);
	}

	/**
	* Returns the number of scrivanias where userId = &#63; and homeFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @return the number of matching scrivanias
	*/
	public static int countByU_H(long userId, boolean homeFlag) {
		return getPersistence().countByU_H(userId, homeFlag);
	}

	/**
	* Returns all the scrivanias where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @return the matching scrivanias
	*/
	public static List<Scrivania> findByU_P(long userId, boolean profileFlag) {
		return getPersistence().findByU_P(userId, profileFlag);
	}

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
	public static List<Scrivania> findByU_P(long userId, boolean profileFlag,
		int start, int end) {
		return getPersistence().findByU_P(userId, profileFlag, start, end);
	}

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
	public static List<Scrivania> findByU_P(long userId, boolean profileFlag,
		int start, int end, OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .findByU_P(userId, profileFlag, start, end, orderByComparator);
	}

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
	public static List<Scrivania> findByU_P(long userId, boolean profileFlag,
		int start, int end, OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_P(userId, profileFlag, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public static Scrivania findByU_P_First(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_P_First(userId, profileFlag, orderByComparator);
	}

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public static Scrivania fetchByU_P_First(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .fetchByU_P_First(userId, profileFlag, orderByComparator);
	}

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania
	* @throws NoSuchScrivaniaException if a matching scrivania could not be found
	*/
	public static Scrivania findByU_P_Last(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_P_Last(userId, profileFlag, orderByComparator);
	}

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public static Scrivania fetchByU_P_Last(long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .fetchByU_P_Last(userId, profileFlag, orderByComparator);
	}

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
	public static Scrivania[] findByU_P_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK,
		long userId, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_P_PrevAndNext(scrivaniaPK, userId, profileFlag,
			orderByComparator);
	}

	/**
	* Removes all the scrivanias where userId = &#63; and profileFlag = &#63; from the database.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	*/
	public static void removeByU_P(long userId, boolean profileFlag) {
		getPersistence().removeByU_P(userId, profileFlag);
	}

	/**
	* Returns the number of scrivanias where userId = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param profileFlag the profile flag
	* @return the number of matching scrivanias
	*/
	public static int countByU_P(long userId, boolean profileFlag) {
		return getPersistence().countByU_P(userId, profileFlag);
	}

	/**
	* Returns all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @return the matching scrivanias
	*/
	public static List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag) {
		return getPersistence().findByU_H_P(userId, homeFlag, profileFlag);
	}

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
	public static List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end) {
		return getPersistence()
				   .findByU_H_P(userId, homeFlag, profileFlag, start, end);
	}

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
	public static List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end,
		OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .findByU_H_P(userId, homeFlag, profileFlag, start, end,
			orderByComparator);
	}

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
	public static List<Scrivania> findByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag, int start, int end,
		OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_H_P(userId, homeFlag, profileFlag, start, end,
			orderByComparator, retrieveFromCache);
	}

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
	public static Scrivania findByU_H_P_First(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_H_P_First(userId, homeFlag, profileFlag,
			orderByComparator);
	}

	/**
	* Returns the first scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public static Scrivania fetchByU_H_P_First(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_P_First(userId, homeFlag, profileFlag,
			orderByComparator);
	}

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
	public static Scrivania findByU_H_P_Last(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_H_P_Last(userId, homeFlag, profileFlag,
			orderByComparator);
	}

	/**
	* Returns the last scrivania in the ordered set where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching scrivania, or <code>null</code> if a matching scrivania could not be found
	*/
	public static Scrivania fetchByU_H_P_Last(long userId, boolean homeFlag,
		boolean profileFlag, OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_P_Last(userId, homeFlag, profileFlag,
			orderByComparator);
	}

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
	public static Scrivania[] findByU_H_P_PrevAndNext(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK,
		long userId, boolean homeFlag, boolean profileFlag,
		OrderByComparator<Scrivania> orderByComparator)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence()
				   .findByU_H_P_PrevAndNext(scrivaniaPK, userId, homeFlag,
			profileFlag, orderByComparator);
	}

	/**
	* Removes all the scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63; from the database.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	*/
	public static void removeByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag) {
		getPersistence().removeByU_H_P(userId, homeFlag, profileFlag);
	}

	/**
	* Returns the number of scrivanias where userId = &#63; and homeFlag = &#63; and profileFlag = &#63;.
	*
	* @param userId the user ID
	* @param homeFlag the home flag
	* @param profileFlag the profile flag
	* @return the number of matching scrivanias
	*/
	public static int countByU_H_P(long userId, boolean homeFlag,
		boolean profileFlag) {
		return getPersistence().countByU_H_P(userId, homeFlag, profileFlag);
	}

	/**
	* Caches the scrivania in the entity cache if it is enabled.
	*
	* @param scrivania the scrivania
	*/
	public static void cacheResult(Scrivania scrivania) {
		getPersistence().cacheResult(scrivania);
	}

	/**
	* Caches the scrivanias in the entity cache if it is enabled.
	*
	* @param scrivanias the scrivanias
	*/
	public static void cacheResult(List<Scrivania> scrivanias) {
		getPersistence().cacheResult(scrivanias);
	}

	/**
	* Creates a new scrivania with the primary key. Does not add the scrivania to the database.
	*
	* @param scrivaniaPK the primary key for the new scrivania
	* @return the new scrivania
	*/
	public static Scrivania create(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK) {
		return getPersistence().create(scrivaniaPK);
	}

	/**
	* Removes the scrivania with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania that was removed
	* @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	*/
	public static Scrivania remove(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence().remove(scrivaniaPK);
	}

	public static Scrivania updateImpl(Scrivania scrivania) {
		return getPersistence().updateImpl(scrivania);
	}

	/**
	* Returns the scrivania with the primary key or throws a {@link NoSuchScrivaniaException} if it could not be found.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania
	* @throws NoSuchScrivaniaException if a scrivania with the primary key could not be found
	*/
	public static Scrivania findByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK)
		throws autorizzazione.dir.mef.exception.NoSuchScrivaniaException {
		return getPersistence().findByPrimaryKey(scrivaniaPK);
	}

	/**
	* Returns the scrivania with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scrivaniaPK the primary key of the scrivania
	* @return the scrivania, or <code>null</code> if a scrivania with the primary key could not be found
	*/
	public static Scrivania fetchByPrimaryKey(
		autorizzazione.dir.mef.service.persistence.ScrivaniaPK scrivaniaPK) {
		return getPersistence().fetchByPrimaryKey(scrivaniaPK);
	}

	public static java.util.Map<java.io.Serializable, Scrivania> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the scrivanias.
	*
	* @return the scrivanias
	*/
	public static List<Scrivania> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Scrivania> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Scrivania> findAll(int start, int end,
		OrderByComparator<Scrivania> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Scrivania> findAll(int start, int end,
		OrderByComparator<Scrivania> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the scrivanias from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of scrivanias.
	*
	* @return the number of scrivanias
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ScrivaniaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ScrivaniaPersistence, ScrivaniaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ScrivaniaPersistence.class);
}