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

package service.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import service.intranet.mef.exception.NoSuchLogisticaValutazioneException;
import service.intranet.mef.model.LogisticaValutazione;

/**
 * The persistence interface for the logistica valutazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.LogisticaValutazionePersistenceImpl
 * @see LogisticaValutazioneUtil
 * @generated
 */
@ProviderType
public interface LogisticaValutazionePersistence extends BasePersistence<LogisticaValutazione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogisticaValutazioneUtil} to access the logistica valutazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the logistica valutazione in the entity cache if it is enabled.
	*
	* @param logisticaValutazione the logistica valutazione
	*/
	public void cacheResult(LogisticaValutazione logisticaValutazione);

	/**
	* Caches the logistica valutaziones in the entity cache if it is enabled.
	*
	* @param logisticaValutaziones the logistica valutaziones
	*/
	public void cacheResult(
		java.util.List<LogisticaValutazione> logisticaValutaziones);

	/**
	* Creates a new logistica valutazione with the primary key. Does not add the logistica valutazione to the database.
	*
	* @param id the primary key for the new logistica valutazione
	* @return the new logistica valutazione
	*/
	public LogisticaValutazione create(long id);

	/**
	* Removes the logistica valutazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione that was removed
	* @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	*/
	public LogisticaValutazione remove(long id)
		throws NoSuchLogisticaValutazioneException;

	public LogisticaValutazione updateImpl(
		LogisticaValutazione logisticaValutazione);

	/**
	* Returns the logistica valutazione with the primary key or throws a {@link NoSuchLogisticaValutazioneException} if it could not be found.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione
	* @throws NoSuchLogisticaValutazioneException if a logistica valutazione with the primary key could not be found
	*/
	public LogisticaValutazione findByPrimaryKey(long id)
		throws NoSuchLogisticaValutazioneException;

	/**
	* Returns the logistica valutazione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the logistica valutazione
	* @return the logistica valutazione, or <code>null</code> if a logistica valutazione with the primary key could not be found
	*/
	public LogisticaValutazione fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, LogisticaValutazione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the logistica valutaziones.
	*
	* @return the logistica valutaziones
	*/
	public java.util.List<LogisticaValutazione> findAll();

	/**
	* Returns a range of all the logistica valutaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica valutaziones
	* @param end the upper bound of the range of logistica valutaziones (not inclusive)
	* @return the range of logistica valutaziones
	*/
	public java.util.List<LogisticaValutazione> findAll(int start, int end);

	/**
	* Returns an ordered range of all the logistica valutaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica valutaziones
	* @param end the upper bound of the range of logistica valutaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of logistica valutaziones
	*/
	public java.util.List<LogisticaValutazione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaValutazione> orderByComparator);

	/**
	* Returns an ordered range of all the logistica valutaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LogisticaValutazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logistica valutaziones
	* @param end the upper bound of the range of logistica valutaziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of logistica valutaziones
	*/
	public java.util.List<LogisticaValutazione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LogisticaValutazione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the logistica valutaziones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of logistica valutaziones.
	*
	* @return the number of logistica valutaziones
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}