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

package servizio.richieste.badge.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.richieste.badge.mef.exception.NoSuchSediEsterneException;
import servizio.richieste.badge.mef.model.SediEsterne;

/**
 * The persistence interface for the sedi esterne service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.richieste.badge.mef.service.persistence.impl.SediEsternePersistenceImpl
 * @see SediEsterneUtil
 * @generated
 */
@ProviderType
public interface SediEsternePersistence extends BasePersistence<SediEsterne> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SediEsterneUtil} to access the sedi esterne persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sedi esternes where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @return the matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByIdSedeSiap(long id_sedesiap);

	/**
	* Returns a range of all the sedi esternes where id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @return the range of matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByIdSedeSiap(long id_sedesiap,
		int start, int end);

	/**
	* Returns an ordered range of all the sedi esternes where id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByIdSedeSiap(long id_sedesiap,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator);

	/**
	* Returns an ordered range of all the sedi esternes where id_sedesiap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_sedesiap the id_sedesiap
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByIdSedeSiap(long id_sedesiap,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public SediEsterne findByIdSedeSiap_First(long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException;

	/**
	* Returns the first sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public SediEsterne fetchByIdSedeSiap_First(long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator);

	/**
	* Returns the last sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public SediEsterne findByIdSedeSiap_Last(long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException;

	/**
	* Returns the last sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public SediEsterne fetchByIdSedeSiap_Last(long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator);

	/**
	* Returns the sedi esternes before and after the current sedi esterne in the ordered set where id_sedesiap = &#63;.
	*
	* @param id_sede_esterna the primary key of the current sedi esterne
	* @param id_sedesiap the id_sedesiap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi esterne
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public SediEsterne[] findByIdSedeSiap_PrevAndNext(long id_sede_esterna,
		long id_sedesiap,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException;

	/**
	* Removes all the sedi esternes where id_sedesiap = &#63; from the database.
	*
	* @param id_sedesiap the id_sedesiap
	*/
	public void removeByIdSedeSiap(long id_sedesiap);

	/**
	* Returns the number of sedi esternes where id_sedesiap = &#63;.
	*
	* @param id_sedesiap the id_sedesiap
	* @return the number of matching sedi esternes
	*/
	public int countByIdSedeSiap(long id_sedesiap);

	/**
	* Returns all the sedi esternes where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @return the matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede);

	/**
	* Returns a range of all the sedi esternes where acronimo_sede = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param acronimo_sede the acronimo_sede
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @return the range of matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede, int start, int end);

	/**
	* Returns an ordered range of all the sedi esternes where acronimo_sede = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param acronimo_sede the acronimo_sede
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator);

	/**
	* Returns an ordered range of all the sedi esternes where acronimo_sede = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param acronimo_sede the acronimo_sede
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi esternes
	*/
	public java.util.List<SediEsterne> findByAcronimoSede(
		java.lang.String acronimo_sede, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public SediEsterne findByAcronimoSede_First(
		java.lang.String acronimo_sede,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException;

	/**
	* Returns the first sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public SediEsterne fetchByAcronimoSede_First(
		java.lang.String acronimo_sede,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator);

	/**
	* Returns the last sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne
	* @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	*/
	public SediEsterne findByAcronimoSede_Last(java.lang.String acronimo_sede,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException;

	/**
	* Returns the last sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	*/
	public SediEsterne fetchByAcronimoSede_Last(
		java.lang.String acronimo_sede,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator);

	/**
	* Returns the sedi esternes before and after the current sedi esterne in the ordered set where acronimo_sede = &#63;.
	*
	* @param id_sede_esterna the primary key of the current sedi esterne
	* @param acronimo_sede the acronimo_sede
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi esterne
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public SediEsterne[] findByAcronimoSede_PrevAndNext(long id_sede_esterna,
		java.lang.String acronimo_sede,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException;

	/**
	* Removes all the sedi esternes where acronimo_sede = &#63; from the database.
	*
	* @param acronimo_sede the acronimo_sede
	*/
	public void removeByAcronimoSede(java.lang.String acronimo_sede);

	/**
	* Returns the number of sedi esternes where acronimo_sede = &#63;.
	*
	* @param acronimo_sede the acronimo_sede
	* @return the number of matching sedi esternes
	*/
	public int countByAcronimoSede(java.lang.String acronimo_sede);

	/**
	* Caches the sedi esterne in the entity cache if it is enabled.
	*
	* @param sediEsterne the sedi esterne
	*/
	public void cacheResult(SediEsterne sediEsterne);

	/**
	* Caches the sedi esternes in the entity cache if it is enabled.
	*
	* @param sediEsternes the sedi esternes
	*/
	public void cacheResult(java.util.List<SediEsterne> sediEsternes);

	/**
	* Creates a new sedi esterne with the primary key. Does not add the sedi esterne to the database.
	*
	* @param id_sede_esterna the primary key for the new sedi esterne
	* @return the new sedi esterne
	*/
	public SediEsterne create(long id_sede_esterna);

	/**
	* Removes the sedi esterne with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne that was removed
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public SediEsterne remove(long id_sede_esterna)
		throws NoSuchSediEsterneException;

	public SediEsterne updateImpl(SediEsterne sediEsterne);

	/**
	* Returns the sedi esterne with the primary key or throws a {@link NoSuchSediEsterneException} if it could not be found.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne
	* @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	*/
	public SediEsterne findByPrimaryKey(long id_sede_esterna)
		throws NoSuchSediEsterneException;

	/**
	* Returns the sedi esterne with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_sede_esterna the primary key of the sedi esterne
	* @return the sedi esterne, or <code>null</code> if a sedi esterne with the primary key could not be found
	*/
	public SediEsterne fetchByPrimaryKey(long id_sede_esterna);

	@Override
	public java.util.Map<java.io.Serializable, SediEsterne> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the sedi esternes.
	*
	* @return the sedi esternes
	*/
	public java.util.List<SediEsterne> findAll();

	/**
	* Returns a range of all the sedi esternes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @return the range of sedi esternes
	*/
	public java.util.List<SediEsterne> findAll(int start, int end);

	/**
	* Returns an ordered range of all the sedi esternes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sedi esternes
	*/
	public java.util.List<SediEsterne> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator);

	/**
	* Returns an ordered range of all the sedi esternes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi esternes
	* @param end the upper bound of the range of sedi esternes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sedi esternes
	*/
	public java.util.List<SediEsterne> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sedi esternes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of sedi esternes.
	*
	* @return the number of sedi esternes
	*/
	public int countAll();
}