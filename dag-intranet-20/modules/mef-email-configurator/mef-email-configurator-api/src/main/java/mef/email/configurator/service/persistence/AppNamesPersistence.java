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

package mef.email.configurator.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import mef.email.configurator.exception.NoSuchAppNamesException;
import mef.email.configurator.model.AppNames;

/**
 * The persistence interface for the app names service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see mef.email.configurator.service.persistence.impl.AppNamesPersistenceImpl
 * @see AppNamesUtil
 * @generated
 */
@ProviderType
public interface AppNamesPersistence extends BasePersistence<AppNames> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppNamesUtil} to access the app names persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the app nameses where appname = &#63;.
	*
	* @param appname the appname
	* @return the matching app nameses
	*/
	public java.util.List<AppNames> findByAppname(java.lang.String appname);

	/**
	* Returns a range of all the app nameses where appname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appname the appname
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @return the range of matching app nameses
	*/
	public java.util.List<AppNames> findByAppname(java.lang.String appname,
		int start, int end);

	/**
	* Returns an ordered range of all the app nameses where appname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appname the appname
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching app nameses
	*/
	public java.util.List<AppNames> findByAppname(java.lang.String appname,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator);

	/**
	* Returns an ordered range of all the app nameses where appname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appname the appname
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching app nameses
	*/
	public java.util.List<AppNames> findByAppname(java.lang.String appname,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public AppNames findByAppname_First(java.lang.String appname,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException;

	/**
	* Returns the first app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public AppNames fetchByAppname_First(java.lang.String appname,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator);

	/**
	* Returns the last app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public AppNames findByAppname_Last(java.lang.String appname,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException;

	/**
	* Returns the last app names in the ordered set where appname = &#63;.
	*
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public AppNames fetchByAppname_Last(java.lang.String appname,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator);

	/**
	* Returns the app nameses before and after the current app names in the ordered set where appname = &#63;.
	*
	* @param id the primary key of the current app names
	* @param appname the appname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app names
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public AppNames[] findByAppname_PrevAndNext(long id,
		java.lang.String appname,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException;

	/**
	* Removes all the app nameses where appname = &#63; from the database.
	*
	* @param appname the appname
	*/
	public void removeByAppname(java.lang.String appname);

	/**
	* Returns the number of app nameses where appname = &#63;.
	*
	* @param appname the appname
	* @return the number of matching app nameses
	*/
	public int countByAppname(java.lang.String appname);

	/**
	* Returns all the app nameses where appid = &#63;.
	*
	* @param appid the appid
	* @return the matching app nameses
	*/
	public java.util.List<AppNames> findByAppId(long appid);

	/**
	* Returns a range of all the app nameses where appid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @return the range of matching app nameses
	*/
	public java.util.List<AppNames> findByAppId(long appid, int start, int end);

	/**
	* Returns an ordered range of all the app nameses where appid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching app nameses
	*/
	public java.util.List<AppNames> findByAppId(long appid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator);

	/**
	* Returns an ordered range of all the app nameses where appid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appid the appid
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching app nameses
	*/
	public java.util.List<AppNames> findByAppId(long appid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public AppNames findByAppId_First(long appid,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException;

	/**
	* Returns the first app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public AppNames fetchByAppId_First(long appid,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator);

	/**
	* Returns the last app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names
	* @throws NoSuchAppNamesException if a matching app names could not be found
	*/
	public AppNames findByAppId_Last(long appid,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException;

	/**
	* Returns the last app names in the ordered set where appid = &#63;.
	*
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app names, or <code>null</code> if a matching app names could not be found
	*/
	public AppNames fetchByAppId_Last(long appid,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator);

	/**
	* Returns the app nameses before and after the current app names in the ordered set where appid = &#63;.
	*
	* @param id the primary key of the current app names
	* @param appid the appid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app names
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public AppNames[] findByAppId_PrevAndNext(long id, long appid,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator)
		throws NoSuchAppNamesException;

	/**
	* Removes all the app nameses where appid = &#63; from the database.
	*
	* @param appid the appid
	*/
	public void removeByAppId(long appid);

	/**
	* Returns the number of app nameses where appid = &#63;.
	*
	* @param appid the appid
	* @return the number of matching app nameses
	*/
	public int countByAppId(long appid);

	/**
	* Caches the app names in the entity cache if it is enabled.
	*
	* @param appNames the app names
	*/
	public void cacheResult(AppNames appNames);

	/**
	* Caches the app nameses in the entity cache if it is enabled.
	*
	* @param appNameses the app nameses
	*/
	public void cacheResult(java.util.List<AppNames> appNameses);

	/**
	* Creates a new app names with the primary key. Does not add the app names to the database.
	*
	* @param id the primary key for the new app names
	* @return the new app names
	*/
	public AppNames create(long id);

	/**
	* Removes the app names with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the app names
	* @return the app names that was removed
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public AppNames remove(long id) throws NoSuchAppNamesException;

	public AppNames updateImpl(AppNames appNames);

	/**
	* Returns the app names with the primary key or throws a {@link NoSuchAppNamesException} if it could not be found.
	*
	* @param id the primary key of the app names
	* @return the app names
	* @throws NoSuchAppNamesException if a app names with the primary key could not be found
	*/
	public AppNames findByPrimaryKey(long id) throws NoSuchAppNamesException;

	/**
	* Returns the app names with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the app names
	* @return the app names, or <code>null</code> if a app names with the primary key could not be found
	*/
	public AppNames fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, AppNames> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the app nameses.
	*
	* @return the app nameses
	*/
	public java.util.List<AppNames> findAll();

	/**
	* Returns a range of all the app nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @return the range of app nameses
	*/
	public java.util.List<AppNames> findAll(int start, int end);

	/**
	* Returns an ordered range of all the app nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of app nameses
	*/
	public java.util.List<AppNames> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator);

	/**
	* Returns an ordered range of all the app nameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppNamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of app nameses
	* @param end the upper bound of the range of app nameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of app nameses
	*/
	public java.util.List<AppNames> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppNames> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the app nameses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of app nameses.
	*
	* @return the number of app nameses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}