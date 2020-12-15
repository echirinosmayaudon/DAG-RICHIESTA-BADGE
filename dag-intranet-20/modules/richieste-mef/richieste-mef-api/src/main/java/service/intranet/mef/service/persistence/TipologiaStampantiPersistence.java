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

import service.intranet.mef.exception.NoSuchTipologiaStampantiException;
import service.intranet.mef.model.TipologiaStampanti;

/**
 * The persistence interface for the tipologia stampanti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see service.intranet.mef.service.persistence.impl.TipologiaStampantiPersistenceImpl
 * @see TipologiaStampantiUtil
 * @generated
 */
@ProviderType
public interface TipologiaStampantiPersistence extends BasePersistence<TipologiaStampanti> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipologiaStampantiUtil} to access the tipologia stampanti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipologia stampanti in the entity cache if it is enabled.
	*
	* @param tipologiaStampanti the tipologia stampanti
	*/
	public void cacheResult(TipologiaStampanti tipologiaStampanti);

	/**
	* Caches the tipologia stampantis in the entity cache if it is enabled.
	*
	* @param tipologiaStampantis the tipologia stampantis
	*/
	public void cacheResult(
		java.util.List<TipologiaStampanti> tipologiaStampantis);

	/**
	* Creates a new tipologia stampanti with the primary key. Does not add the tipologia stampanti to the database.
	*
	* @param id_tipologia_stampanti the primary key for the new tipologia stampanti
	* @return the new tipologia stampanti
	*/
	public TipologiaStampanti create(long id_tipologia_stampanti);

	/**
	* Removes the tipologia stampanti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti that was removed
	* @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	*/
	public TipologiaStampanti remove(long id_tipologia_stampanti)
		throws NoSuchTipologiaStampantiException;

	public TipologiaStampanti updateImpl(TipologiaStampanti tipologiaStampanti);

	/**
	* Returns the tipologia stampanti with the primary key or throws a {@link NoSuchTipologiaStampantiException} if it could not be found.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti
	* @throws NoSuchTipologiaStampantiException if a tipologia stampanti with the primary key could not be found
	*/
	public TipologiaStampanti findByPrimaryKey(long id_tipologia_stampanti)
		throws NoSuchTipologiaStampantiException;

	/**
	* Returns the tipologia stampanti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti, or <code>null</code> if a tipologia stampanti with the primary key could not be found
	*/
	public TipologiaStampanti fetchByPrimaryKey(long id_tipologia_stampanti);

	@Override
	public java.util.Map<java.io.Serializable, TipologiaStampanti> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tipologia stampantis.
	*
	* @return the tipologia stampantis
	*/
	public java.util.List<TipologiaStampanti> findAll();

	/**
	* Returns a range of all the tipologia stampantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia stampantis
	* @param end the upper bound of the range of tipologia stampantis (not inclusive)
	* @return the range of tipologia stampantis
	*/
	public java.util.List<TipologiaStampanti> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tipologia stampantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia stampantis
	* @param end the upper bound of the range of tipologia stampantis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipologia stampantis
	*/
	public java.util.List<TipologiaStampanti> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaStampanti> orderByComparator);

	/**
	* Returns an ordered range of all the tipologia stampantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia stampantis
	* @param end the upper bound of the range of tipologia stampantis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipologia stampantis
	*/
	public java.util.List<TipologiaStampanti> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipologiaStampanti> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tipologia stampantis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tipologia stampantis.
	*
	* @return the number of tipologia stampantis
	*/
	public int countAll();
}