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

package servizio.beni.facile.consumo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.beni.facile.consumo.exception.NoSuchCambioStatoDirigenteException;
import servizio.beni.facile.consumo.model.CambioStatoDirigente;

/**
 * The persistence interface for the cambio stato dirigente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.persistence.impl.CambioStatoDirigentePersistenceImpl
 * @see CambioStatoDirigenteUtil
 * @generated
 */
@ProviderType
public interface CambioStatoDirigentePersistence extends BasePersistence<CambioStatoDirigente> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CambioStatoDirigenteUtil} to access the cambio stato dirigente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cambio stato dirigentes where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the matching cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findByIdRichiesta(long id_rich);

	/**
	* Returns a range of all the cambio stato dirigentes where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @return the range of matching cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findByIdRichiesta(
		long id_rich, int start, int end);

	/**
	* Returns an ordered range of all the cambio stato dirigentes where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findByIdRichiesta(
		long id_rich, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator);

	/**
	* Returns an ordered range of all the cambio stato dirigentes where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findByIdRichiesta(
		long id_rich, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a matching cambio stato dirigente could not be found
	*/
	public CambioStatoDirigente findByIdRichiesta_First(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws NoSuchCambioStatoDirigenteException;

	/**
	* Returns the first cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cambio stato dirigente, or <code>null</code> if a matching cambio stato dirigente could not be found
	*/
	public CambioStatoDirigente fetchByIdRichiesta_First(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator);

	/**
	* Returns the last cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a matching cambio stato dirigente could not be found
	*/
	public CambioStatoDirigente findByIdRichiesta_Last(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws NoSuchCambioStatoDirigenteException;

	/**
	* Returns the last cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cambio stato dirigente, or <code>null</code> if a matching cambio stato dirigente could not be found
	*/
	public CambioStatoDirigente fetchByIdRichiesta_Last(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator);

	/**
	* Returns the cambio stato dirigentes before and after the current cambio stato dirigente in the ordered set where id_rich = &#63;.
	*
	* @param id the primary key of the current cambio stato dirigente
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	*/
	public CambioStatoDirigente[] findByIdRichiesta_PrevAndNext(long id,
		long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws NoSuchCambioStatoDirigenteException;

	/**
	* Removes all the cambio stato dirigentes where id_rich = &#63; from the database.
	*
	* @param id_rich the id_rich
	*/
	public void removeByIdRichiesta(long id_rich);

	/**
	* Returns the number of cambio stato dirigentes where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the number of matching cambio stato dirigentes
	*/
	public int countByIdRichiesta(long id_rich);

	/**
	* Caches the cambio stato dirigente in the entity cache if it is enabled.
	*
	* @param cambioStatoDirigente the cambio stato dirigente
	*/
	public void cacheResult(CambioStatoDirigente cambioStatoDirigente);

	/**
	* Caches the cambio stato dirigentes in the entity cache if it is enabled.
	*
	* @param cambioStatoDirigentes the cambio stato dirigentes
	*/
	public void cacheResult(
		java.util.List<CambioStatoDirigente> cambioStatoDirigentes);

	/**
	* Creates a new cambio stato dirigente with the primary key. Does not add the cambio stato dirigente to the database.
	*
	* @param id the primary key for the new cambio stato dirigente
	* @return the new cambio stato dirigente
	*/
	public CambioStatoDirigente create(long id);

	/**
	* Removes the cambio stato dirigente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente that was removed
	* @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	*/
	public CambioStatoDirigente remove(long id)
		throws NoSuchCambioStatoDirigenteException;

	public CambioStatoDirigente updateImpl(
		CambioStatoDirigente cambioStatoDirigente);

	/**
	* Returns the cambio stato dirigente with the primary key or throws a {@link NoSuchCambioStatoDirigenteException} if it could not be found.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente
	* @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	*/
	public CambioStatoDirigente findByPrimaryKey(long id)
		throws NoSuchCambioStatoDirigenteException;

	/**
	* Returns the cambio stato dirigente with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente, or <code>null</code> if a cambio stato dirigente with the primary key could not be found
	*/
	public CambioStatoDirigente fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, CambioStatoDirigente> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the cambio stato dirigentes.
	*
	* @return the cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findAll();

	/**
	* Returns a range of all the cambio stato dirigentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @return the range of cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findAll(int start, int end);

	/**
	* Returns an ordered range of all the cambio stato dirigentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator);

	/**
	* Returns an ordered range of all the cambio stato dirigentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cambio stato dirigentes
	*/
	public java.util.List<CambioStatoDirigente> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CambioStatoDirigente> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the cambio stato dirigentes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of cambio stato dirigentes.
	*
	* @return the number of cambio stato dirigentes
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}