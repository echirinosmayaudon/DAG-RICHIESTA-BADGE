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

import servizio.prenotazione.aule.mef.exception.NoSuchTipoEventoException;
import servizio.prenotazione.aule.mef.model.TipoEvento;

/**
 * The persistence interface for the tipo evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.mef.service.persistence.impl.TipoEventoPersistenceImpl
 * @see TipoEventoUtil
 * @generated
 */
@ProviderType
public interface TipoEventoPersistence extends BasePersistence<TipoEvento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipoEventoUtil} to access the tipo evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipo evento in the entity cache if it is enabled.
	*
	* @param tipoEvento the tipo evento
	*/
	public void cacheResult(TipoEvento tipoEvento);

	/**
	* Caches the tipo eventos in the entity cache if it is enabled.
	*
	* @param tipoEventos the tipo eventos
	*/
	public void cacheResult(java.util.List<TipoEvento> tipoEventos);

	/**
	* Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	*
	* @param id_evento the primary key for the new tipo evento
	* @return the new tipo evento
	*/
	public TipoEvento create(long id_evento);

	/**
	* Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento that was removed
	* @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	*/
	public TipoEvento remove(long id_evento) throws NoSuchTipoEventoException;

	public TipoEvento updateImpl(TipoEvento tipoEvento);

	/**
	* Returns the tipo evento with the primary key or throws a {@link NoSuchTipoEventoException} if it could not be found.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento
	* @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	*/
	public TipoEvento findByPrimaryKey(long id_evento)
		throws NoSuchTipoEventoException;

	/**
	* Returns the tipo evento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento, or <code>null</code> if a tipo evento with the primary key could not be found
	*/
	public TipoEvento fetchByPrimaryKey(long id_evento);

	@Override
	public java.util.Map<java.io.Serializable, TipoEvento> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tipo eventos.
	*
	* @return the tipo eventos
	*/
	public java.util.List<TipoEvento> findAll();

	/**
	* Returns a range of all the tipo eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo eventos
	* @param end the upper bound of the range of tipo eventos (not inclusive)
	* @return the range of tipo eventos
	*/
	public java.util.List<TipoEvento> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tipo eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo eventos
	* @param end the upper bound of the range of tipo eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo eventos
	*/
	public java.util.List<TipoEvento> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento> orderByComparator);

	/**
	* Returns an ordered range of all the tipo eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo eventos
	* @param end the upper bound of the range of tipo eventos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipo eventos
	*/
	public java.util.List<TipoEvento> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tipo eventos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tipo eventos.
	*
	* @return the number of tipo eventos
	*/
	public int countAll();
}