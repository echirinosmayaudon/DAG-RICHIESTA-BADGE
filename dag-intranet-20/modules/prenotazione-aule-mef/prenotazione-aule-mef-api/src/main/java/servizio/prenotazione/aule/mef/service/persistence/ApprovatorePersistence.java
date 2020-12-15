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

package servizio.prenotazione.aule.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.prenotazione.aule.mef.exception.NoSuchApprovatoreException;
import servizio.prenotazione.aule.mef.model.Approvatore;

/**
 * The persistence interface for the approvatore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.ApprovatorePersistenceImpl
 * @see ApprovatoreUtil
 * @generated
 */
@ProviderType
public interface ApprovatorePersistence extends BasePersistence<Approvatore> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApprovatoreUtil} to access the approvatore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the approvatores where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @return the matching approvatores
	*/
	public java.util.List<Approvatore> findByIdSala(long id_sala);

	/**
	* Returns a range of all the approvatores where id_sala = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sala the id_sala
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @return the range of matching approvatores
	*/
	public java.util.List<Approvatore> findByIdSala(long id_sala, int start,
		int end);

	/**
	* Returns an ordered range of all the approvatores where id_sala = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sala the id_sala
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching approvatores
	*/
	public java.util.List<Approvatore> findByIdSala(long id_sala, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator);

	/**
	* Returns an ordered range of all the approvatores where id_sala = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sala the id_sala
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching approvatores
	*/
	public java.util.List<Approvatore> findByIdSala(long id_sala, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approvatore
	* @throws NoSuchApprovatoreException if a matching approvatore could not be found
	*/
	public Approvatore findByIdSala_First(long id_sala,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator)
		throws NoSuchApprovatoreException;

	/**
	* Returns the first approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching approvatore, or <code>null</code> if a matching approvatore could not be found
	*/
	public Approvatore fetchByIdSala_First(long id_sala,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator);

	/**
	* Returns the last approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approvatore
	* @throws NoSuchApprovatoreException if a matching approvatore could not be found
	*/
	public Approvatore findByIdSala_Last(long id_sala,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator)
		throws NoSuchApprovatoreException;

	/**
	* Returns the last approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching approvatore, or <code>null</code> if a matching approvatore could not be found
	*/
	public Approvatore fetchByIdSala_Last(long id_sala,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator);

	/**
	* Returns the approvatores before and after the current approvatore in the ordered set where id_sala = &#63;.
	*
	* @param id_approvatore the primary key of the current approvatore
	* @param id_sala the id_sala
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next approvatore
	* @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	*/
	public Approvatore[] findByIdSala_PrevAndNext(long id_approvatore,
		long id_sala,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator)
		throws NoSuchApprovatoreException;

	/**
	* Removes all the approvatores where id_sala = &#63; from the database.
	*
	* @param id_sala the id_sala
	*/
	public void removeByIdSala(long id_sala);

	/**
	* Returns the number of approvatores where id_sala = &#63;.
	*
	* @param id_sala the id_sala
	* @return the number of matching approvatores
	*/
	public int countByIdSala(long id_sala);

	/**
	* Caches the approvatore in the entity cache if it is enabled.
	*
	* @param approvatore the approvatore
	*/
	public void cacheResult(Approvatore approvatore);

	/**
	* Caches the approvatores in the entity cache if it is enabled.
	*
	* @param approvatores the approvatores
	*/
	public void cacheResult(java.util.List<Approvatore> approvatores);

	/**
	* Creates a new approvatore with the primary key. Does not add the approvatore to the database.
	*
	* @param id_approvatore the primary key for the new approvatore
	* @return the new approvatore
	*/
	public Approvatore create(long id_approvatore);

	/**
	* Removes the approvatore with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore that was removed
	* @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	*/
	public Approvatore remove(long id_approvatore)
		throws NoSuchApprovatoreException;

	public Approvatore updateImpl(Approvatore approvatore);

	/**
	* Returns the approvatore with the primary key or throws a {@link NoSuchApprovatoreException} if it could not be found.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore
	* @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	*/
	public Approvatore findByPrimaryKey(long id_approvatore)
		throws NoSuchApprovatoreException;

	/**
	* Returns the approvatore with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore, or <code>null</code> if a approvatore with the primary key could not be found
	*/
	public Approvatore fetchByPrimaryKey(long id_approvatore);

	@Override
	public java.util.Map<java.io.Serializable, Approvatore> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the approvatores.
	*
	* @return the approvatores
	*/
	public java.util.List<Approvatore> findAll();

	/**
	* Returns a range of all the approvatores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @return the range of approvatores
	*/
	public java.util.List<Approvatore> findAll(int start, int end);

	/**
	* Returns an ordered range of all the approvatores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of approvatores
	*/
	public java.util.List<Approvatore> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator);

	/**
	* Returns an ordered range of all the approvatores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of approvatores
	*/
	public java.util.List<Approvatore> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Approvatore> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the approvatores from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of approvatores.
	*
	* @return the number of approvatores
	*/
	public int countAll();
}