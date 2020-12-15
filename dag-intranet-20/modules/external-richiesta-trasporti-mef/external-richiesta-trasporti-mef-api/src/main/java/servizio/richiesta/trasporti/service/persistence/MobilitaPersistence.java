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

package servizio.richiesta.trasporti.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.richiesta.trasporti.exception.NoSuchMobilitaException;
import servizio.richiesta.trasporti.model.Mobilita;

/**
 * The persistence interface for the mobilita service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richiesta.trasporti.service.persistence.impl.MobilitaPersistenceImpl
 * @see MobilitaUtil
 * @generated
 */
@ProviderType
public interface MobilitaPersistence extends BasePersistence<Mobilita> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MobilitaUtil} to access the mobilita persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the mobilitas where person_id = &#63;.
	*
	* @param person_id the person_id
	* @return the matching mobilitas
	*/
	public java.util.List<Mobilita> findByPersonId(long person_id);

	/**
	* Returns a range of all the mobilitas where person_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param person_id the person_id
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @return the range of matching mobilitas
	*/
	public java.util.List<Mobilita> findByPersonId(long person_id, int start,
		int end);

	/**
	* Returns an ordered range of all the mobilitas where person_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param person_id the person_id
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching mobilitas
	*/
	public java.util.List<Mobilita> findByPersonId(long person_id, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator);

	/**
	* Returns an ordered range of all the mobilitas where person_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param person_id the person_id
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching mobilitas
	*/
	public java.util.List<Mobilita> findByPersonId(long person_id, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mobilita
	* @throws NoSuchMobilitaException if a matching mobilita could not be found
	*/
	public Mobilita findByPersonId_First(long person_id,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator)
		throws NoSuchMobilitaException;

	/**
	* Returns the first mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mobilita, or <code>null</code> if a matching mobilita could not be found
	*/
	public Mobilita fetchByPersonId_First(long person_id,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator);

	/**
	* Returns the last mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mobilita
	* @throws NoSuchMobilitaException if a matching mobilita could not be found
	*/
	public Mobilita findByPersonId_Last(long person_id,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator)
		throws NoSuchMobilitaException;

	/**
	* Returns the last mobilita in the ordered set where person_id = &#63;.
	*
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mobilita, or <code>null</code> if a matching mobilita could not be found
	*/
	public Mobilita fetchByPersonId_Last(long person_id,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator);

	/**
	* Returns the mobilitas before and after the current mobilita in the ordered set where person_id = &#63;.
	*
	* @param custom_key the primary key of the current mobilita
	* @param person_id the person_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next mobilita
	* @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	*/
	public Mobilita[] findByPersonId_PrevAndNext(java.lang.String custom_key,
		long person_id,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator)
		throws NoSuchMobilitaException;

	/**
	* Removes all the mobilitas where person_id = &#63; from the database.
	*
	* @param person_id the person_id
	*/
	public void removeByPersonId(long person_id);

	/**
	* Returns the number of mobilitas where person_id = &#63;.
	*
	* @param person_id the person_id
	* @return the number of matching mobilitas
	*/
	public int countByPersonId(long person_id);

	/**
	* Caches the mobilita in the entity cache if it is enabled.
	*
	* @param mobilita the mobilita
	*/
	public void cacheResult(Mobilita mobilita);

	/**
	* Caches the mobilitas in the entity cache if it is enabled.
	*
	* @param mobilitas the mobilitas
	*/
	public void cacheResult(java.util.List<Mobilita> mobilitas);

	/**
	* Creates a new mobilita with the primary key. Does not add the mobilita to the database.
	*
	* @param custom_key the primary key for the new mobilita
	* @return the new mobilita
	*/
	public Mobilita create(java.lang.String custom_key);

	/**
	* Removes the mobilita with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita that was removed
	* @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	*/
	public Mobilita remove(java.lang.String custom_key)
		throws NoSuchMobilitaException;

	public Mobilita updateImpl(Mobilita mobilita);

	/**
	* Returns the mobilita with the primary key or throws a {@link NoSuchMobilitaException} if it could not be found.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita
	* @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	*/
	public Mobilita findByPrimaryKey(java.lang.String custom_key)
		throws NoSuchMobilitaException;

	/**
	* Returns the mobilita with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita, or <code>null</code> if a mobilita with the primary key could not be found
	*/
	public Mobilita fetchByPrimaryKey(java.lang.String custom_key);

	@Override
	public java.util.Map<java.io.Serializable, Mobilita> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the mobilitas.
	*
	* @return the mobilitas
	*/
	public java.util.List<Mobilita> findAll();

	/**
	* Returns a range of all the mobilitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @return the range of mobilitas
	*/
	public java.util.List<Mobilita> findAll(int start, int end);

	/**
	* Returns an ordered range of all the mobilitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of mobilitas
	*/
	public java.util.List<Mobilita> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator);

	/**
	* Returns an ordered range of all the mobilitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of mobilitas
	*/
	public java.util.List<Mobilita> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mobilita> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the mobilitas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of mobilitas.
	*
	* @return the number of mobilitas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}