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

import service.intranet.mef.exception.NoSuchHardwareTecniciException;
import service.intranet.mef.model.HardwareTecnici;

/**
 * The persistence interface for the hardware tecnici service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.HardwareTecniciPersistenceImpl
 * @see HardwareTecniciUtil
 * @generated
 */
@ProviderType
public interface HardwareTecniciPersistence extends BasePersistence<HardwareTecnici> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HardwareTecniciUtil} to access the hardware tecnici persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the hardware tecnici in the entity cache if it is enabled.
	*
	* @param hardwareTecnici the hardware tecnici
	*/
	public void cacheResult(HardwareTecnici hardwareTecnici);

	/**
	* Caches the hardware tecnicis in the entity cache if it is enabled.
	*
	* @param hardwareTecnicis the hardware tecnicis
	*/
	public void cacheResult(java.util.List<HardwareTecnici> hardwareTecnicis);

	/**
	* Creates a new hardware tecnici with the primary key. Does not add the hardware tecnici to the database.
	*
	* @param id the primary key for the new hardware tecnici
	* @return the new hardware tecnici
	*/
	public HardwareTecnici create(long id);

	/**
	* Removes the hardware tecnici with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the hardware tecnici
	* @return the hardware tecnici that was removed
	* @throws NoSuchHardwareTecniciException if a hardware tecnici with the primary key could not be found
	*/
	public HardwareTecnici remove(long id)
		throws NoSuchHardwareTecniciException;

	public HardwareTecnici updateImpl(HardwareTecnici hardwareTecnici);

	/**
	* Returns the hardware tecnici with the primary key or throws a {@link NoSuchHardwareTecniciException} if it could not be found.
	*
	* @param id the primary key of the hardware tecnici
	* @return the hardware tecnici
	* @throws NoSuchHardwareTecniciException if a hardware tecnici with the primary key could not be found
	*/
	public HardwareTecnici findByPrimaryKey(long id)
		throws NoSuchHardwareTecniciException;

	/**
	* Returns the hardware tecnici with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the hardware tecnici
	* @return the hardware tecnici, or <code>null</code> if a hardware tecnici with the primary key could not be found
	*/
	public HardwareTecnici fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, HardwareTecnici> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the hardware tecnicis.
	*
	* @return the hardware tecnicis
	*/
	public java.util.List<HardwareTecnici> findAll();

	/**
	* Returns a range of all the hardware tecnicis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HardwareTecniciModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hardware tecnicis
	* @param end the upper bound of the range of hardware tecnicis (not inclusive)
	* @return the range of hardware tecnicis
	*/
	public java.util.List<HardwareTecnici> findAll(int start, int end);

	/**
	* Returns an ordered range of all the hardware tecnicis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HardwareTecniciModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hardware tecnicis
	* @param end the upper bound of the range of hardware tecnicis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hardware tecnicis
	*/
	public java.util.List<HardwareTecnici> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HardwareTecnici> orderByComparator);

	/**
	* Returns an ordered range of all the hardware tecnicis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HardwareTecniciModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hardware tecnicis
	* @param end the upper bound of the range of hardware tecnicis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of hardware tecnicis
	*/
	public java.util.List<HardwareTecnici> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HardwareTecnici> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the hardware tecnicis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of hardware tecnicis.
	*
	* @return the number of hardware tecnicis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}