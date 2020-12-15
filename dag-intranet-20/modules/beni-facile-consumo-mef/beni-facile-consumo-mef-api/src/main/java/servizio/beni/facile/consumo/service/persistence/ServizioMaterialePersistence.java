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

import servizio.beni.facile.consumo.exception.NoSuchServizioMaterialeException;
import servizio.beni.facile.consumo.model.ServizioMateriale;

/**
 * The persistence interface for the servizio materiale service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.service.persistence.impl.ServizioMaterialePersistenceImpl
 * @see ServizioMaterialeUtil
 * @generated
 */
@ProviderType
public interface ServizioMaterialePersistence extends BasePersistence<ServizioMateriale> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServizioMaterialeUtil} to access the servizio materiale persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the servizio materiales where categoria = &#63;.
	*
	* @param categoria the categoria
	* @return the matching servizio materiales
	*/
	public java.util.List<ServizioMateriale> findByCategoria(
		java.lang.String categoria);

	/**
	* Returns a range of all the servizio materiales where categoria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoria the categoria
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @return the range of matching servizio materiales
	*/
	public java.util.List<ServizioMateriale> findByCategoria(
		java.lang.String categoria, int start, int end);

	/**
	* Returns an ordered range of all the servizio materiales where categoria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoria the categoria
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servizio materiales
	*/
	public java.util.List<ServizioMateriale> findByCategoria(
		java.lang.String categoria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator);

	/**
	* Returns an ordered range of all the servizio materiales where categoria = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoria the categoria
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servizio materiales
	*/
	public java.util.List<ServizioMateriale> findByCategoria(
		java.lang.String categoria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio materiale
	* @throws NoSuchServizioMaterialeException if a matching servizio materiale could not be found
	*/
	public ServizioMateriale findByCategoria_First(java.lang.String categoria,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator)
		throws NoSuchServizioMaterialeException;

	/**
	* Returns the first servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching servizio materiale, or <code>null</code> if a matching servizio materiale could not be found
	*/
	public ServizioMateriale fetchByCategoria_First(
		java.lang.String categoria,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator);

	/**
	* Returns the last servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio materiale
	* @throws NoSuchServizioMaterialeException if a matching servizio materiale could not be found
	*/
	public ServizioMateriale findByCategoria_Last(java.lang.String categoria,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator)
		throws NoSuchServizioMaterialeException;

	/**
	* Returns the last servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching servizio materiale, or <code>null</code> if a matching servizio materiale could not be found
	*/
	public ServizioMateriale fetchByCategoria_Last(java.lang.String categoria,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator);

	/**
	* Returns the servizio materiales before and after the current servizio materiale in the ordered set where categoria = &#63;.
	*
	* @param gruppo the primary key of the current servizio materiale
	* @param categoria the categoria
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next servizio materiale
	* @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	*/
	public ServizioMateriale[] findByCategoria_PrevAndNext(
		java.lang.String gruppo, java.lang.String categoria,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator)
		throws NoSuchServizioMaterialeException;

	/**
	* Removes all the servizio materiales where categoria = &#63; from the database.
	*
	* @param categoria the categoria
	*/
	public void removeByCategoria(java.lang.String categoria);

	/**
	* Returns the number of servizio materiales where categoria = &#63;.
	*
	* @param categoria the categoria
	* @return the number of matching servizio materiales
	*/
	public int countByCategoria(java.lang.String categoria);

	/**
	* Caches the servizio materiale in the entity cache if it is enabled.
	*
	* @param servizioMateriale the servizio materiale
	*/
	public void cacheResult(ServizioMateriale servizioMateriale);

	/**
	* Caches the servizio materiales in the entity cache if it is enabled.
	*
	* @param servizioMateriales the servizio materiales
	*/
	public void cacheResult(
		java.util.List<ServizioMateriale> servizioMateriales);

	/**
	* Creates a new servizio materiale with the primary key. Does not add the servizio materiale to the database.
	*
	* @param gruppo the primary key for the new servizio materiale
	* @return the new servizio materiale
	*/
	public ServizioMateriale create(java.lang.String gruppo);

	/**
	* Removes the servizio materiale with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale that was removed
	* @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	*/
	public ServizioMateriale remove(java.lang.String gruppo)
		throws NoSuchServizioMaterialeException;

	public ServizioMateriale updateImpl(ServizioMateriale servizioMateriale);

	/**
	* Returns the servizio materiale with the primary key or throws a {@link NoSuchServizioMaterialeException} if it could not be found.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale
	* @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	*/
	public ServizioMateriale findByPrimaryKey(java.lang.String gruppo)
		throws NoSuchServizioMaterialeException;

	/**
	* Returns the servizio materiale with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale, or <code>null</code> if a servizio materiale with the primary key could not be found
	*/
	public ServizioMateriale fetchByPrimaryKey(java.lang.String gruppo);

	@Override
	public java.util.Map<java.io.Serializable, ServizioMateriale> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the servizio materiales.
	*
	* @return the servizio materiales
	*/
	public java.util.List<ServizioMateriale> findAll();

	/**
	* Returns a range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @return the range of servizio materiales
	*/
	public java.util.List<ServizioMateriale> findAll(int start, int end);

	/**
	* Returns an ordered range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of servizio materiales
	*/
	public java.util.List<ServizioMateriale> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator);

	/**
	* Returns an ordered range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of servizio materiales
	*/
	public java.util.List<ServizioMateriale> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServizioMateriale> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the servizio materiales from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of servizio materiales.
	*
	* @return the number of servizio materiales
	*/
	public int countAll();
}