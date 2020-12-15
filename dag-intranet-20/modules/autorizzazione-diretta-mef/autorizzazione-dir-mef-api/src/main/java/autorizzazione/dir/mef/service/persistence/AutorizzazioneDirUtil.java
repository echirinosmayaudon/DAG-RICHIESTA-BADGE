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

import autorizzazione.dir.mef.model.AutorizzazioneDir;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the autorizzazione dir service. This utility wraps {@link autorizzazione.dir.mef.service.persistence.impl.AutorizzazioneDirPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AutorizzazioneDirPersistence
 * @see autorizzazione.dir.mef.service.persistence.impl.AutorizzazioneDirPersistenceImpl
 * @generated
 */
@ProviderType
public class AutorizzazioneDirUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AutorizzazioneDir autorizzazioneDir) {
		getPersistence().clearCache(autorizzazioneDir);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AutorizzazioneDir> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AutorizzazioneDir> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AutorizzazioneDir> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AutorizzazioneDir> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AutorizzazioneDir update(AutorizzazioneDir autorizzazioneDir) {
		return getPersistence().update(autorizzazioneDir);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AutorizzazioneDir update(
		AutorizzazioneDir autorizzazioneDir, ServiceContext serviceContext) {
		return getPersistence().update(autorizzazioneDir, serviceContext);
	}

	/**
	* Caches the autorizzazione dir in the entity cache if it is enabled.
	*
	* @param autorizzazioneDir the autorizzazione dir
	*/
	public static void cacheResult(AutorizzazioneDir autorizzazioneDir) {
		getPersistence().cacheResult(autorizzazioneDir);
	}

	/**
	* Caches the autorizzazione dirs in the entity cache if it is enabled.
	*
	* @param autorizzazioneDirs the autorizzazione dirs
	*/
	public static void cacheResult(List<AutorizzazioneDir> autorizzazioneDirs) {
		getPersistence().cacheResult(autorizzazioneDirs);
	}

	/**
	* Creates a new autorizzazione dir with the primary key. Does not add the autorizzazione dir to the database.
	*
	* @param id_autorizzazione the primary key for the new autorizzazione dir
	* @return the new autorizzazione dir
	*/
	public static AutorizzazioneDir create(long id_autorizzazione) {
		return getPersistence().create(id_autorizzazione);
	}

	/**
	* Removes the autorizzazione dir with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir that was removed
	* @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	*/
	public static AutorizzazioneDir remove(long id_autorizzazione)
		throws autorizzazione.dir.mef.exception.NoSuchAutorizzazioneDirException {
		return getPersistence().remove(id_autorizzazione);
	}

	public static AutorizzazioneDir updateImpl(
		AutorizzazioneDir autorizzazioneDir) {
		return getPersistence().updateImpl(autorizzazioneDir);
	}

	/**
	* Returns the autorizzazione dir with the primary key or throws a {@link NoSuchAutorizzazioneDirException} if it could not be found.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir
	* @throws NoSuchAutorizzazioneDirException if a autorizzazione dir with the primary key could not be found
	*/
	public static AutorizzazioneDir findByPrimaryKey(long id_autorizzazione)
		throws autorizzazione.dir.mef.exception.NoSuchAutorizzazioneDirException {
		return getPersistence().findByPrimaryKey(id_autorizzazione);
	}

	/**
	* Returns the autorizzazione dir with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir, or <code>null</code> if a autorizzazione dir with the primary key could not be found
	*/
	public static AutorizzazioneDir fetchByPrimaryKey(long id_autorizzazione) {
		return getPersistence().fetchByPrimaryKey(id_autorizzazione);
	}

	public static java.util.Map<java.io.Serializable, AutorizzazioneDir> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the autorizzazione dirs.
	*
	* @return the autorizzazione dirs
	*/
	public static List<AutorizzazioneDir> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AutorizzazioneDir> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AutorizzazioneDir> findAll(int start, int end,
		OrderByComparator<AutorizzazioneDir> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AutorizzazioneDir> findAll(int start, int end,
		OrderByComparator<AutorizzazioneDir> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the autorizzazione dirs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of autorizzazione dirs.
	*
	* @return the number of autorizzazione dirs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AutorizzazioneDirPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AutorizzazioneDirPersistence, AutorizzazioneDirPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AutorizzazioneDirPersistence.class);
}