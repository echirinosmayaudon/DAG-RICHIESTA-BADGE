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

import servizio.prenotazione.aule.mef.exception.NoSuchStrumentoEventoException;
import servizio.prenotazione.aule.mef.model.StrumentoEvento;

/**
 * The persistence interface for the strumento evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.StrumentoEventoPersistenceImpl
 * @see StrumentoEventoUtil
 * @generated
 */
@ProviderType
public interface StrumentoEventoPersistence extends BasePersistence<StrumentoEvento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StrumentoEventoUtil} to access the strumento evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the strumento eventos where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the matching strumento eventos
	*/
	public java.util.List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento);

	/**
	* Returns a range of all the strumento eventos where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @return the range of matching strumento eventos
	*/
	public java.util.List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end);

	/**
	* Returns an ordered range of all the strumento eventos where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching strumento eventos
	*/
	public java.util.List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator);

	/**
	* Returns an ordered range of all the strumento eventos where desc_strumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param desc_strumento the desc_strumento
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching strumento eventos
	*/
	public java.util.List<StrumentoEvento> findByDescStrumento(
		java.lang.String desc_strumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento evento
	* @throws NoSuchStrumentoEventoException if a matching strumento evento could not be found
	*/
	public StrumentoEvento findByDescStrumento_First(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator)
		throws NoSuchStrumentoEventoException;

	/**
	* Returns the first strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching strumento evento, or <code>null</code> if a matching strumento evento could not be found
	*/
	public StrumentoEvento fetchByDescStrumento_First(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator);

	/**
	* Returns the last strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento evento
	* @throws NoSuchStrumentoEventoException if a matching strumento evento could not be found
	*/
	public StrumentoEvento findByDescStrumento_Last(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator)
		throws NoSuchStrumentoEventoException;

	/**
	* Returns the last strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching strumento evento, or <code>null</code> if a matching strumento evento could not be found
	*/
	public StrumentoEvento fetchByDescStrumento_Last(
		java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator);

	/**
	* Returns the strumento eventos before and after the current strumento evento in the ordered set where desc_strumento = &#63;.
	*
	* @param id_strumento the primary key of the current strumento evento
	* @param desc_strumento the desc_strumento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next strumento evento
	* @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	*/
	public StrumentoEvento[] findByDescStrumento_PrevAndNext(
		long id_strumento, java.lang.String desc_strumento,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator)
		throws NoSuchStrumentoEventoException;

	/**
	* Removes all the strumento eventos where desc_strumento = &#63; from the database.
	*
	* @param desc_strumento the desc_strumento
	*/
	public void removeByDescStrumento(java.lang.String desc_strumento);

	/**
	* Returns the number of strumento eventos where desc_strumento = &#63;.
	*
	* @param desc_strumento the desc_strumento
	* @return the number of matching strumento eventos
	*/
	public int countByDescStrumento(java.lang.String desc_strumento);

	/**
	* Caches the strumento evento in the entity cache if it is enabled.
	*
	* @param strumentoEvento the strumento evento
	*/
	public void cacheResult(StrumentoEvento strumentoEvento);

	/**
	* Caches the strumento eventos in the entity cache if it is enabled.
	*
	* @param strumentoEventos the strumento eventos
	*/
	public void cacheResult(java.util.List<StrumentoEvento> strumentoEventos);

	/**
	* Creates a new strumento evento with the primary key. Does not add the strumento evento to the database.
	*
	* @param id_strumento the primary key for the new strumento evento
	* @return the new strumento evento
	*/
	public StrumentoEvento create(long id_strumento);

	/**
	* Removes the strumento evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento that was removed
	* @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	*/
	public StrumentoEvento remove(long id_strumento)
		throws NoSuchStrumentoEventoException;

	public StrumentoEvento updateImpl(StrumentoEvento strumentoEvento);

	/**
	* Returns the strumento evento with the primary key or throws a {@link NoSuchStrumentoEventoException} if it could not be found.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento
	* @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	*/
	public StrumentoEvento findByPrimaryKey(long id_strumento)
		throws NoSuchStrumentoEventoException;

	/**
	* Returns the strumento evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento, or <code>null</code> if a strumento evento with the primary key could not be found
	*/
	public StrumentoEvento fetchByPrimaryKey(long id_strumento);

	@Override
	public java.util.Map<java.io.Serializable, StrumentoEvento> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the strumento eventos.
	*
	* @return the strumento eventos
	*/
	public java.util.List<StrumentoEvento> findAll();

	/**
	* Returns a range of all the strumento eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @return the range of strumento eventos
	*/
	public java.util.List<StrumentoEvento> findAll(int start, int end);

	/**
	* Returns an ordered range of all the strumento eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strumento eventos
	*/
	public java.util.List<StrumentoEvento> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator);

	/**
	* Returns an ordered range of all the strumento eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strumento eventos
	*/
	public java.util.List<StrumentoEvento> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumentoEvento> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the strumento eventos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of strumento eventos.
	*
	* @return the number of strumento eventos
	*/
	public int countAll();
}