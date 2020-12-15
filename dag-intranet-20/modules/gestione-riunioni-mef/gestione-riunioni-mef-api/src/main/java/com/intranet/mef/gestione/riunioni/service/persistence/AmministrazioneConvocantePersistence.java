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

package com.intranet.mef.gestione.riunioni.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.exception.NoSuchAmministrazioneConvocanteException;
import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the amministrazione convocante service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.gestione.riunioni.service.persistence.impl.AmministrazioneConvocantePersistenceImpl
 * @see AmministrazioneConvocanteUtil
 * @generated
 */
@ProviderType
public interface AmministrazioneConvocantePersistence extends BasePersistence<AmministrazioneConvocante> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmministrazioneConvocanteUtil} to access the amministrazione convocante persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the amministrazione convocante in the entity cache if it is enabled.
	*
	* @param amministrazioneConvocante the amministrazione convocante
	*/
	public void cacheResult(AmministrazioneConvocante amministrazioneConvocante);

	/**
	* Caches the amministrazione convocantes in the entity cache if it is enabled.
	*
	* @param amministrazioneConvocantes the amministrazione convocantes
	*/
	public void cacheResult(
		java.util.List<AmministrazioneConvocante> amministrazioneConvocantes);

	/**
	* Creates a new amministrazione convocante with the primary key. Does not add the amministrazione convocante to the database.
	*
	* @param id_amministrazione_convocante the primary key for the new amministrazione convocante
	* @return the new amministrazione convocante
	*/
	public AmministrazioneConvocante create(long id_amministrazione_convocante);

	/**
	* Removes the amministrazione convocante with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante that was removed
	* @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	*/
	public AmministrazioneConvocante remove(long id_amministrazione_convocante)
		throws NoSuchAmministrazioneConvocanteException;

	public AmministrazioneConvocante updateImpl(
		AmministrazioneConvocante amministrazioneConvocante);

	/**
	* Returns the amministrazione convocante with the primary key or throws a {@link NoSuchAmministrazioneConvocanteException} if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante
	* @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	*/
	public AmministrazioneConvocante findByPrimaryKey(
		long id_amministrazione_convocante)
		throws NoSuchAmministrazioneConvocanteException;

	/**
	* Returns the amministrazione convocante with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_amministrazione_convocante the primary key of the amministrazione convocante
	* @return the amministrazione convocante, or <code>null</code> if a amministrazione convocante with the primary key could not be found
	*/
	public AmministrazioneConvocante fetchByPrimaryKey(
		long id_amministrazione_convocante);

	@Override
	public java.util.Map<java.io.Serializable, AmministrazioneConvocante> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the amministrazione convocantes.
	*
	* @return the amministrazione convocantes
	*/
	public java.util.List<AmministrazioneConvocante> findAll();

	/**
	* Returns a range of all the amministrazione convocantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amministrazione convocantes
	* @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	* @return the range of amministrazione convocantes
	*/
	public java.util.List<AmministrazioneConvocante> findAll(int start, int end);

	/**
	* Returns an ordered range of all the amministrazione convocantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amministrazione convocantes
	* @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of amministrazione convocantes
	*/
	public java.util.List<AmministrazioneConvocante> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmministrazioneConvocante> orderByComparator);

	/**
	* Returns an ordered range of all the amministrazione convocantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amministrazione convocantes
	* @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of amministrazione convocantes
	*/
	public java.util.List<AmministrazioneConvocante> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmministrazioneConvocante> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the amministrazione convocantes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of amministrazione convocantes.
	*
	* @return the number of amministrazione convocantes
	*/
	public int countAll();
}