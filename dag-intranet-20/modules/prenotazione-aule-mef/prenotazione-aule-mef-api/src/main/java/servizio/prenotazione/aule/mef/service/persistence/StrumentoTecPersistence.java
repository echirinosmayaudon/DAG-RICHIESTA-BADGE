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

import servizio.prenotazione.aule.mef.exception.NoSuchStrumentoTecException;
import servizio.prenotazione.aule.mef.model.StrumentoTec;

/**
 * The persistence interface for the strumento tec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.StrumentoTecPersistenceImpl
 * @see StrumentoTecUtil
 * @generated
 */
@ProviderType
public interface StrumentoTecPersistence extends BasePersistence<StrumentoTec> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StrumentoTecUtil} to access the strumento tec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the strumento tecs where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the matching strumento tecs
	*/
	public java.util.List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento);

	/**
	* Returns a range of all the strumento tecs where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @return the range of matching strumento tecs
	*/
	public java.util.List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end);

	/**
	* Returns an ordered range of all the strumento tecs where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching strumento tecs
	*/
	public java.util.List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator);

	/**
	* Returns an ordered range of all the strumento tecs where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching strumento tecs
	*/
	public java.util.List<StrumentoTec> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento tec
	* @throws NoSuchStrumentoTecException if a matching strumento tec could not be found
	*/
	public StrumentoTec findByDescStrumento_First(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator)
		throws NoSuchStrumentoTecException;

	/**
	* Returns the first strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento tec, or <code>null</code> if a matching strumento tec could not be found
	*/
	public StrumentoTec fetchByDescStrumento_First(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator);

	/**
	* Returns the last strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento tec
	* @throws NoSuchStrumentoTecException if a matching strumento tec could not be found
	*/
	public StrumentoTec findByDescStrumento_Last(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator)
		throws NoSuchStrumentoTecException;

	/**
	* Returns the last strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento tec, or <code>null</code> if a matching strumento tec could not be found
	*/
	public StrumentoTec fetchByDescStrumento_Last(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator);

	/**
	* Returns the strumento tecs before and after the current strumento tec in the ordered set where desc_strumento = &#63;.
	*
	* @param id_strumento the primary key of the current strumento tec
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next strumento tec
	* @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	*/
	public StrumentoTec[] findByDescStrumento_PrevAndNext(long id_strumento,
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator)
		throws NoSuchStrumentoTecException;

	/**
	* Removes all the strumento tecs where desc_strumento = &#63; from the database.
	*
	* @param desc_strumento the desc_strumento
	*/
	public void removeByDescStrumento(java.lang.String desc_strumento);

	/**
	* Returns the number of strumento tecs where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the number of matching strumento tecs
	*/
	public int countByDescStrumento(java.lang.String desc_strumento);

	/**
	* Caches the strumento tec in the entity cache if it is enabled.
	*
	* @param strumentoTec the strumento tec
	*/
	public void cacheResult(StrumentoTec strumentoTec);

	/**
	* Caches the strumento tecs in the entity cache if it is enabled.
	*
	* @param strumentoTecs the strumento tecs
	*/
	public void cacheResult(java.util.List<StrumentoTec> strumentoTecs);

	/**
	* Creates a new strumento tec with the primary key. Does not add the strumento tec to the database.
	*
	* @param id_strumento the primary key for the new strumento tec
	* @return the new strumento tec
	*/
	public StrumentoTec create(long id_strumento);

	/**
	* Removes the strumento tec with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec that was removed
	* @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	*/
	public StrumentoTec remove(long id_strumento)
		throws NoSuchStrumentoTecException;

	public StrumentoTec updateImpl(StrumentoTec strumentoTec);

	/**
	* Returns the strumento tec with the primary key or throws a {@link NoSuchStrumentoTecException} if it could not be found.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec
	* @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	*/
	public StrumentoTec findByPrimaryKey(long id_strumento)
		throws NoSuchStrumentoTecException;

	/**
	* Returns the strumento tec with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec, or <code>null</code> if a strumento tec with the primary key could not be found
	*/
	public StrumentoTec fetchByPrimaryKey(long id_strumento);

	@Override
	public java.util.Map<java.io.Serializable, StrumentoTec> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the strumento tecs.
	*
	* @return the strumento tecs
	*/
	public java.util.List<StrumentoTec> findAll();

	/**
	* Returns a range of all the strumento tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @return the range of strumento tecs
	*/
	public java.util.List<StrumentoTec> findAll(int start, int end);

	/**
	* Returns an ordered range of all the strumento tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strumento tecs
	*/
	public java.util.List<StrumentoTec> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator);

	/**
	* Returns an ordered range of all the strumento tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strumento tecs
	*/
	public java.util.List<StrumentoTec> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoTec> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the strumento tecs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of strumento tecs.
	*
	* @return the number of strumento tecs
	*/
	public int countAll();
}