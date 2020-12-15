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

package servizio.prenotazione.aule.servizi.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumTecException;
import servizio.prenotazione.aule.servizi.mef.model.StrumTec;

/**
 * The persistence interface for the strum tec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.impl.StrumTecPersistenceImpl
 * @see StrumTecUtil
 * @generated
 */
@ProviderType
public interface StrumTecPersistence extends BasePersistence<StrumTec> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StrumTecUtil} to access the strum tec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the strum tec in the entity cache if it is enabled.
	*
	* @param strumTec the strum tec
	*/
	public void cacheResult(StrumTec strumTec);

	/**
	* Caches the strum tecs in the entity cache if it is enabled.
	*
	* @param strumTecs the strum tecs
	*/
	public void cacheResult(java.util.List<StrumTec> strumTecs);

	/**
	* Creates a new strum tec with the primary key. Does not add the strum tec to the database.
	*
	* @param strumTecPK the primary key for the new strum tec
	* @return the new strum tec
	*/
	public StrumTec create(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK);

	/**
	* Removes the strum tec with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param strumTecPK the primary key of the strum tec
	* @return the strum tec that was removed
	* @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	*/
	public StrumTec remove(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK)
		throws NoSuchStrumTecException;

	public StrumTec updateImpl(StrumTec strumTec);

	/**
	* Returns the strum tec with the primary key or throws a {@link NoSuchStrumTecException} if it could not be found.
	*
	* @param strumTecPK the primary key of the strum tec
	* @return the strum tec
	* @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	*/
	public StrumTec findByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK)
		throws NoSuchStrumTecException;

	/**
	* Returns the strum tec with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param strumTecPK the primary key of the strum tec
	* @return the strum tec, or <code>null</code> if a strum tec with the primary key could not be found
	*/
	public StrumTec fetchByPrimaryKey(
		servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK strumTecPK);

	@Override
	public java.util.Map<java.io.Serializable, StrumTec> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the strum tecs.
	*
	* @return the strum tecs
	*/
	public java.util.List<StrumTec> findAll();

	/**
	* Returns a range of all the strum tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum tecs
	* @param end the upper bound of the range of strum tecs (not inclusive)
	* @return the range of strum tecs
	*/
	public java.util.List<StrumTec> findAll(int start, int end);

	/**
	* Returns an ordered range of all the strum tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum tecs
	* @param end the upper bound of the range of strum tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of strum tecs
	*/
	public java.util.List<StrumTec> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumTec> orderByComparator);

	/**
	* Returns an ordered range of all the strum tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strum tecs
	* @param end the upper bound of the range of strum tecs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of strum tecs
	*/
	public java.util.List<StrumTec> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StrumTec> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the strum tecs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of strum tecs.
	*
	* @return the number of strum tecs
	*/
	public int countAll();
}