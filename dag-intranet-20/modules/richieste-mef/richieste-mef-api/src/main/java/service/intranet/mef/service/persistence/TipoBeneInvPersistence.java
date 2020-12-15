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

import service.intranet.mef.exception.NoSuchTipoBeneInvException;
import service.intranet.mef.model.TipoBeneInv;

/**
 * The persistence interface for the tipo bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.TipoBeneInvPersistenceImpl
 * @see TipoBeneInvUtil
 * @generated
 */
@ProviderType
public interface TipoBeneInvPersistence extends BasePersistence<TipoBeneInv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipoBeneInvUtil} to access the tipo bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipo bene inv in the entity cache if it is enabled.
	*
	* @param tipoBeneInv the tipo bene inv
	*/
	public void cacheResult(TipoBeneInv tipoBeneInv);

	/**
	* Caches the tipo bene invs in the entity cache if it is enabled.
	*
	* @param tipoBeneInvs the tipo bene invs
	*/
	public void cacheResult(java.util.List<TipoBeneInv> tipoBeneInvs);

	/**
	* Creates a new tipo bene inv with the primary key. Does not add the tipo bene inv to the database.
	*
	* @param id the primary key for the new tipo bene inv
	* @return the new tipo bene inv
	*/
	public TipoBeneInv create(long id);

	/**
	* Removes the tipo bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tipo bene inv
	* @return the tipo bene inv that was removed
	* @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	*/
	public TipoBeneInv remove(long id) throws NoSuchTipoBeneInvException;

	public TipoBeneInv updateImpl(TipoBeneInv tipoBeneInv);

	/**
	* Returns the tipo bene inv with the primary key or throws a {@link NoSuchTipoBeneInvException} if it could not be found.
	*
	* @param id the primary key of the tipo bene inv
	* @return the tipo bene inv
	* @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	*/
	public TipoBeneInv findByPrimaryKey(long id)
		throws NoSuchTipoBeneInvException;

	/**
	* Returns the tipo bene inv with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tipo bene inv
	* @return the tipo bene inv, or <code>null</code> if a tipo bene inv with the primary key could not be found
	*/
	public TipoBeneInv fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, TipoBeneInv> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tipo bene invs.
	*
	* @return the tipo bene invs
	*/
	public java.util.List<TipoBeneInv> findAll();

	/**
	* Returns a range of all the tipo bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo bene invs
	* @param end the upper bound of the range of tipo bene invs (not inclusive)
	* @return the range of tipo bene invs
	*/
	public java.util.List<TipoBeneInv> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tipo bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo bene invs
	* @param end the upper bound of the range of tipo bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo bene invs
	*/
	public java.util.List<TipoBeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoBeneInv> orderByComparator);

	/**
	* Returns an ordered range of all the tipo bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo bene invs
	* @param end the upper bound of the range of tipo bene invs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipo bene invs
	*/
	public java.util.List<TipoBeneInv> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoBeneInv> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tipo bene invs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tipo bene invs.
	*
	* @return the number of tipo bene invs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}