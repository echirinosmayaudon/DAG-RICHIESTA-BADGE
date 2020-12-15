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

import servizio.prenotazione.aule.mef.exception.NoSuchSalaStrutturaException;
import servizio.prenotazione.aule.mef.model.SalaStruttura;

/**
 * The persistence interface for the sala struttura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.SalaStrutturaPersistenceImpl
 * @see SalaStrutturaUtil
 * @generated
 */
@ProviderType
public interface SalaStrutturaPersistence extends BasePersistence<SalaStruttura> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalaStrutturaUtil} to access the sala struttura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sala strutturas where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @return the matching sala strutturas
	*/
	public java.util.List<SalaStruttura> findByIdStruttura(long id_struttura);

	/**
	* Returns a range of all the sala strutturas where id_struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_struttura the id_struttura
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @return the range of matching sala strutturas
	*/
	public java.util.List<SalaStruttura> findByIdStruttura(long id_struttura,
		int start, int end);

	/**
	* Returns an ordered range of all the sala strutturas where id_struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_struttura the id_struttura
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sala strutturas
	*/
	public java.util.List<SalaStruttura> findByIdStruttura(long id_struttura,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator);

	/**
	* Returns an ordered range of all the sala strutturas where id_struttura = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_struttura the id_struttura
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sala strutturas
	*/
	public java.util.List<SalaStruttura> findByIdStruttura(long id_struttura,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sala struttura
	* @throws NoSuchSalaStrutturaException if a matching sala struttura could not be found
	*/
	public SalaStruttura findByIdStruttura_First(long id_struttura,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator)
		throws NoSuchSalaStrutturaException;

	/**
	* Returns the first sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sala struttura, or <code>null</code> if a matching sala struttura could not be found
	*/
	public SalaStruttura fetchByIdStruttura_First(long id_struttura,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator);

	/**
	* Returns the last sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sala struttura
	* @throws NoSuchSalaStrutturaException if a matching sala struttura could not be found
	*/
	public SalaStruttura findByIdStruttura_Last(long id_struttura,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator)
		throws NoSuchSalaStrutturaException;

	/**
	* Returns the last sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sala struttura, or <code>null</code> if a matching sala struttura could not be found
	*/
	public SalaStruttura fetchByIdStruttura_Last(long id_struttura,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator);

	/**
	* Returns the sala strutturas before and after the current sala struttura in the ordered set where id_struttura = &#63;.
	*
	* @param id the primary key of the current sala struttura
	* @param id_struttura the id_struttura
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sala struttura
	* @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	*/
	public SalaStruttura[] findByIdStruttura_PrevAndNext(long id,
		long id_struttura,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator)
		throws NoSuchSalaStrutturaException;

	/**
	* Removes all the sala strutturas where id_struttura = &#63; from the database.
	*
	* @param id_struttura the id_struttura
	*/
	public void removeByIdStruttura(long id_struttura);

	/**
	* Returns the number of sala strutturas where id_struttura = &#63;.
	*
	* @param id_struttura the id_struttura
	* @return the number of matching sala strutturas
	*/
	public int countByIdStruttura(long id_struttura);

	/**
	* Caches the sala struttura in the entity cache if it is enabled.
	*
	* @param salaStruttura the sala struttura
	*/
	public void cacheResult(SalaStruttura salaStruttura);

	/**
	* Caches the sala strutturas in the entity cache if it is enabled.
	*
	* @param salaStrutturas the sala strutturas
	*/
	public void cacheResult(java.util.List<SalaStruttura> salaStrutturas);

	/**
	* Creates a new sala struttura with the primary key. Does not add the sala struttura to the database.
	*
	* @param id the primary key for the new sala struttura
	* @return the new sala struttura
	*/
	public SalaStruttura create(long id);

	/**
	* Removes the sala struttura with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura that was removed
	* @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	*/
	public SalaStruttura remove(long id) throws NoSuchSalaStrutturaException;

	public SalaStruttura updateImpl(SalaStruttura salaStruttura);

	/**
	* Returns the sala struttura with the primary key or throws a {@link NoSuchSalaStrutturaException} if it could not be found.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura
	* @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	*/
	public SalaStruttura findByPrimaryKey(long id)
		throws NoSuchSalaStrutturaException;

	/**
	* Returns the sala struttura with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura, or <code>null</code> if a sala struttura with the primary key could not be found
	*/
	public SalaStruttura fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, SalaStruttura> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the sala strutturas.
	*
	* @return the sala strutturas
	*/
	public java.util.List<SalaStruttura> findAll();

	/**
	* Returns a range of all the sala strutturas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @return the range of sala strutturas
	*/
	public java.util.List<SalaStruttura> findAll(int start, int end);

	/**
	* Returns an ordered range of all the sala strutturas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sala strutturas
	*/
	public java.util.List<SalaStruttura> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator);

	/**
	* Returns an ordered range of all the sala strutturas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sala strutturas
	*/
	public java.util.List<SalaStruttura> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaStruttura> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sala strutturas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of sala strutturas.
	*
	* @return the number of sala strutturas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}