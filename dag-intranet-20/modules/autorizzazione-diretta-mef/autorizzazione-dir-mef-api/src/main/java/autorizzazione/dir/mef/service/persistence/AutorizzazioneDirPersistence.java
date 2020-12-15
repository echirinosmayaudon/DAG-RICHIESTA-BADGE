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

package autorizzazione.dir.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import autorizzazione.dir.mef.exception.NoSuchAutorizzazioneDirException;
import autorizzazione.dir.mef.model.AutorizzazioneDir;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the autorizzazione dir service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see autorizzazione.dir.mef.service.persistence.impl.AutorizzazioneDirPersistenceImpl
 * @see AutorizzazioneDirUtil
 * @generated
 */
@ProviderType
public interface AutorizzazioneDirPersistence extends BasePersistence<AutorizzazioneDir> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AutorizzazioneDirUtil} to access the autorizzazione dir persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the autorizzazione dir in the entity cache if it is enabled.
	*
	* @param autorizzazioneDir the autorizzazione dir
	*/
	public void cacheResult(AutorizzazioneDir autorizzazioneDir);

	/**
	* Caches the autorizzazione dirs in the entity cache if it is enabled.
	*
	* @param autorizzazioneDirs the autorizzazione dirs
	*/
	public void cacheResult(
		java.util.List<AutorizzazioneDir> autorizzazioneDirs);

	/**
	* Creates a new autorizzazione dir with the primary key. Does not add the autorizzazione dir to the database.
	*
	* @param id_autorizzazione the primary key for the new autorizzazione dir
	* @return the new autorizzazione dir
	*/
	public AutorizzazioneDir create(long id_autorizzazione);

	/**
	* Removes the autorizzazione dir with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir that was removed
	* @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	*/
	public AutorizzazioneDir remove(long id_autorizzazione)
		throws NoSuchAutorizzazioneDirException;

	public AutorizzazioneDir updateImpl(AutorizzazioneDir autorizzazioneDir);

	/**
	* Returns the autorizzazione dir with the primary key or throws a {@link NoSuchAutorizzazioneDirException} if it could not be found.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir
	* @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	*/
	public AutorizzazioneDir findByPrimaryKey(long id_autorizzazione)
		throws NoSuchAutorizzazioneDirException;

	/**
	* Returns the autorizzazione dir with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir, or <code>null</code> if a autorizzazione dir with the primary key could not be found
	*/
	public AutorizzazioneDir fetchByPrimaryKey(long id_autorizzazione);

	@Override
	public java.util.Map<java.io.Serializable, AutorizzazioneDir> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the autorizzazione dirs.
	*
	* @return the autorizzazione dirs
	*/
	public java.util.List<AutorizzazioneDir> findAll();

	/**
	* Returns a range of all the autorizzazione dirs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of autorizzazione dirs
	* @param end the upper bound of the range of autorizzazione dirs (not inclusive)
	* @return the range of autorizzazione dirs
	*/
	public java.util.List<AutorizzazioneDir> findAll(int start, int end);

	/**
	* Returns an ordered range of all the autorizzazione dirs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of autorizzazione dirs
	* @param end the upper bound of the range of autorizzazione dirs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of autorizzazione dirs
	*/
	public java.util.List<AutorizzazioneDir> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutorizzazioneDir> orderByComparator);

	/**
	* Returns an ordered range of all the autorizzazione dirs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of autorizzazione dirs
	* @param end the upper bound of the range of autorizzazione dirs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of autorizzazione dirs
	*/
	public java.util.List<AutorizzazioneDir> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AutorizzazioneDir> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the autorizzazione dirs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of autorizzazione dirs.
	*
	* @return the number of autorizzazione dirs
	*/
	public int countAll();
}