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

package bookmarks.service.persistence;

import aQute.bnd.annotation.ProviderType;

import bookmarks.exception.NoSuchFavouritesException;

import bookmarks.model.Favourites;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the favourites service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bookmarks.service.persistence.impl.FavouritesPersistenceImpl
 * @see FavouritesUtil
 * @generated
 */
@ProviderType
public interface FavouritesPersistence extends BasePersistence<Favourites> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FavouritesUtil} to access the favourites persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the favouriteses where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the matching favouriteses
	*/
	public java.util.List<Favourites> findByFavourites(long user_id);

	/**
	* Returns a range of all the favouriteses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @return the range of matching favouriteses
	*/
	public java.util.List<Favourites> findByFavourites(long user_id, int start,
		int end);

	/**
	* Returns an ordered range of all the favouriteses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching favouriteses
	*/
	public java.util.List<Favourites> findByFavourites(long user_id, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator);

	/**
	* Returns an ordered range of all the favouriteses where user_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param user_id the user_id
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching favouriteses
	*/
	public java.util.List<Favourites> findByFavourites(long user_id, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favourites
	* @throws NoSuchFavouritesException if a matching favourites could not be found
	*/
	public Favourites findByFavourites_First(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator)
		throws NoSuchFavouritesException;

	/**
	* Returns the first favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favourites, or <code>null</code> if a matching favourites could not be found
	*/
	public Favourites fetchByFavourites_First(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator);

	/**
	* Returns the last favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favourites
	* @throws NoSuchFavouritesException if a matching favourites could not be found
	*/
	public Favourites findByFavourites_Last(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator)
		throws NoSuchFavouritesException;

	/**
	* Returns the last favourites in the ordered set where user_id = &#63;.
	*
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favourites, or <code>null</code> if a matching favourites could not be found
	*/
	public Favourites fetchByFavourites_Last(long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator);

	/**
	* Returns the favouriteses before and after the current favourites in the ordered set where user_id = &#63;.
	*
	* @param favourite_id the primary key of the current favourites
	* @param user_id the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next favourites
	* @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	*/
	public Favourites[] findByFavourites_PrevAndNext(long favourite_id,
		long user_id,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator)
		throws NoSuchFavouritesException;

	/**
	* Removes all the favouriteses where user_id = &#63; from the database.
	*
	* @param user_id the user_id
	*/
	public void removeByFavourites(long user_id);

	/**
	* Returns the number of favouriteses where user_id = &#63;.
	*
	* @param user_id the user_id
	* @return the number of matching favouriteses
	*/
	public int countByFavourites(long user_id);

	/**
	* Caches the favourites in the entity cache if it is enabled.
	*
	* @param favourites the favourites
	*/
	public void cacheResult(Favourites favourites);

	/**
	* Caches the favouriteses in the entity cache if it is enabled.
	*
	* @param favouriteses the favouriteses
	*/
	public void cacheResult(java.util.List<Favourites> favouriteses);

	/**
	* Creates a new favourites with the primary key. Does not add the favourites to the database.
	*
	* @param favourite_id the primary key for the new favourites
	* @return the new favourites
	*/
	public Favourites create(long favourite_id);

	/**
	* Removes the favourites with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites that was removed
	* @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	*/
	public Favourites remove(long favourite_id)
		throws NoSuchFavouritesException;

	public Favourites updateImpl(Favourites favourites);

	/**
	* Returns the favourites with the primary key or throws a {@link NoSuchFavouritesException} if it could not be found.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites
	* @throws NoSuchFavouritesException if a favourites with the primary key could not be found
	*/
	public Favourites findByPrimaryKey(long favourite_id)
		throws NoSuchFavouritesException;

	/**
	* Returns the favourites with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param favourite_id the primary key of the favourites
	* @return the favourites, or <code>null</code> if a favourites with the primary key could not be found
	*/
	public Favourites fetchByPrimaryKey(long favourite_id);

	@Override
	public java.util.Map<java.io.Serializable, Favourites> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the favouriteses.
	*
	* @return the favouriteses
	*/
	public java.util.List<Favourites> findAll();

	/**
	* Returns a range of all the favouriteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @return the range of favouriteses
	*/
	public java.util.List<Favourites> findAll(int start, int end);

	/**
	* Returns an ordered range of all the favouriteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of favouriteses
	*/
	public java.util.List<Favourites> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator);

	/**
	* Returns an ordered range of all the favouriteses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavouritesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favouriteses
	* @param end the upper bound of the range of favouriteses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of favouriteses
	*/
	public java.util.List<Favourites> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favourites> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the favouriteses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of favouriteses.
	*
	* @return the number of favouriteses
	*/
	public int countAll();
}