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

package service.intranet.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import service.intranet.mef.exception.NoSuchHardwareTecniciException;
import service.intranet.mef.model.HardwareTecnici;
import service.intranet.mef.model.impl.HardwareTecniciImpl;
import service.intranet.mef.model.impl.HardwareTecniciModelImpl;
import service.intranet.mef.service.persistence.HardwareTecniciPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the hardware tecnici service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HardwareTecniciPersistence
 * @see service.intranet.mef.service.persistence.HardwareTecniciUtil
 * @generated
 */
@ProviderType
public class HardwareTecniciPersistenceImpl extends BasePersistenceImpl<HardwareTecnici>
	implements HardwareTecniciPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HardwareTecniciUtil} to access the hardware tecnici persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HardwareTecniciImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
			HardwareTecniciModelImpl.FINDER_CACHE_ENABLED,
			HardwareTecniciImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
			HardwareTecniciModelImpl.FINDER_CACHE_ENABLED,
			HardwareTecniciImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
			HardwareTecniciModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HardwareTecniciPersistenceImpl() {
		setModelClass(HardwareTecnici.class);
	}

	/**
	 * Caches the hardware tecnici in the entity cache if it is enabled.
	 *
	 * @param hardwareTecnici the hardware tecnici
	 */
	@Override
	public void cacheResult(HardwareTecnici hardwareTecnici) {
		entityCache.putResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
			HardwareTecniciImpl.class, hardwareTecnici.getPrimaryKey(),
			hardwareTecnici);

		hardwareTecnici.resetOriginalValues();
	}

	/**
	 * Caches the hardware tecnicis in the entity cache if it is enabled.
	 *
	 * @param hardwareTecnicis the hardware tecnicis
	 */
	@Override
	public void cacheResult(List<HardwareTecnici> hardwareTecnicis) {
		for (HardwareTecnici hardwareTecnici : hardwareTecnicis) {
			if (entityCache.getResult(
						HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
						HardwareTecniciImpl.class,
						hardwareTecnici.getPrimaryKey()) == null) {
				cacheResult(hardwareTecnici);
			}
			else {
				hardwareTecnici.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hardware tecnicis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HardwareTecniciImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hardware tecnici.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HardwareTecnici hardwareTecnici) {
		entityCache.removeResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
			HardwareTecniciImpl.class, hardwareTecnici.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HardwareTecnici> hardwareTecnicis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HardwareTecnici hardwareTecnici : hardwareTecnicis) {
			entityCache.removeResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
				HardwareTecniciImpl.class, hardwareTecnici.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hardware tecnici with the primary key. Does not add the hardware tecnici to the database.
	 *
	 * @param id the primary key for the new hardware tecnici
	 * @return the new hardware tecnici
	 */
	@Override
	public HardwareTecnici create(long id) {
		HardwareTecnici hardwareTecnici = new HardwareTecniciImpl();

		hardwareTecnici.setNew(true);
		hardwareTecnici.setPrimaryKey(id);

		return hardwareTecnici;
	}

	/**
	 * Removes the hardware tecnici with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hardware tecnici
	 * @return the hardware tecnici that was removed
	 * @throws NoSuchHardwareTecniciException if a hardware tecnici with the primary key could not be found
	 */
	@Override
	public HardwareTecnici remove(long id)
		throws NoSuchHardwareTecniciException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the hardware tecnici with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hardware tecnici
	 * @return the hardware tecnici that was removed
	 * @throws NoSuchHardwareTecniciException if a hardware tecnici with the primary key could not be found
	 */
	@Override
	public HardwareTecnici remove(Serializable primaryKey)
		throws NoSuchHardwareTecniciException {
		Session session = null;

		try {
			session = openSession();

			HardwareTecnici hardwareTecnici = (HardwareTecnici)session.get(HardwareTecniciImpl.class,
					primaryKey);

			if (hardwareTecnici == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHardwareTecniciException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hardwareTecnici);
		}
		catch (NoSuchHardwareTecniciException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected HardwareTecnici removeImpl(HardwareTecnici hardwareTecnici) {
		hardwareTecnici = toUnwrappedModel(hardwareTecnici);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hardwareTecnici)) {
				hardwareTecnici = (HardwareTecnici)session.get(HardwareTecniciImpl.class,
						hardwareTecnici.getPrimaryKeyObj());
			}

			if (hardwareTecnici != null) {
				session.delete(hardwareTecnici);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (hardwareTecnici != null) {
			clearCache(hardwareTecnici);
		}

		return hardwareTecnici;
	}

	@Override
	public HardwareTecnici updateImpl(HardwareTecnici hardwareTecnici) {
		hardwareTecnici = toUnwrappedModel(hardwareTecnici);

		boolean isNew = hardwareTecnici.isNew();

		Session session = null;

		try {
			session = openSession();

			if (hardwareTecnici.isNew()) {
				session.save(hardwareTecnici);

				hardwareTecnici.setNew(false);
			}
			else {
				hardwareTecnici = (HardwareTecnici)session.merge(hardwareTecnici);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
			HardwareTecniciImpl.class, hardwareTecnici.getPrimaryKey(),
			hardwareTecnici, false);

		hardwareTecnici.resetOriginalValues();

		return hardwareTecnici;
	}

	protected HardwareTecnici toUnwrappedModel(HardwareTecnici hardwareTecnici) {
		if (hardwareTecnici instanceof HardwareTecniciImpl) {
			return hardwareTecnici;
		}

		HardwareTecniciImpl hardwareTecniciImpl = new HardwareTecniciImpl();

		hardwareTecniciImpl.setNew(hardwareTecnici.isNew());
		hardwareTecniciImpl.setPrimaryKey(hardwareTecnici.getPrimaryKey());

		hardwareTecniciImpl.setId(hardwareTecnici.getId());
		hardwareTecniciImpl.setDescrizione(hardwareTecnici.getDescrizione());

		return hardwareTecniciImpl;
	}

	/**
	 * Returns the hardware tecnici with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hardware tecnici
	 * @return the hardware tecnici
	 * @throws NoSuchHardwareTecniciException if a hardware tecnici with the primary key could not be found
	 */
	@Override
	public HardwareTecnici findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHardwareTecniciException {
		HardwareTecnici hardwareTecnici = fetchByPrimaryKey(primaryKey);

		if (hardwareTecnici == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHardwareTecniciException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return hardwareTecnici;
	}

	/**
	 * Returns the hardware tecnici with the primary key or throws a {@link NoSuchHardwareTecniciException} if it could not be found.
	 *
	 * @param id the primary key of the hardware tecnici
	 * @return the hardware tecnici
	 * @throws NoSuchHardwareTecniciException if a hardware tecnici with the primary key could not be found
	 */
	@Override
	public HardwareTecnici findByPrimaryKey(long id)
		throws NoSuchHardwareTecniciException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the hardware tecnici with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hardware tecnici
	 * @return the hardware tecnici, or <code>null</code> if a hardware tecnici with the primary key could not be found
	 */
	@Override
	public HardwareTecnici fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
				HardwareTecniciImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		HardwareTecnici hardwareTecnici = (HardwareTecnici)serializable;

		if (hardwareTecnici == null) {
			Session session = null;

			try {
				session = openSession();

				hardwareTecnici = (HardwareTecnici)session.get(HardwareTecniciImpl.class,
						primaryKey);

				if (hardwareTecnici != null) {
					cacheResult(hardwareTecnici);
				}
				else {
					entityCache.putResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
						HardwareTecniciImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
					HardwareTecniciImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return hardwareTecnici;
	}

	/**
	 * Returns the hardware tecnici with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hardware tecnici
	 * @return the hardware tecnici, or <code>null</code> if a hardware tecnici with the primary key could not be found
	 */
	@Override
	public HardwareTecnici fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, HardwareTecnici> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, HardwareTecnici> map = new HashMap<Serializable, HardwareTecnici>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			HardwareTecnici hardwareTecnici = fetchByPrimaryKey(primaryKey);

			if (hardwareTecnici != null) {
				map.put(primaryKey, hardwareTecnici);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
					HardwareTecniciImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (HardwareTecnici)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_HARDWARETECNICI_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (HardwareTecnici hardwareTecnici : (List<HardwareTecnici>)q.list()) {
				map.put(hardwareTecnici.getPrimaryKeyObj(), hardwareTecnici);

				cacheResult(hardwareTecnici);

				uncachedPrimaryKeys.remove(hardwareTecnici.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(HardwareTecniciModelImpl.ENTITY_CACHE_ENABLED,
					HardwareTecniciImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the hardware tecnicis.
	 *
	 * @return the hardware tecnicis
	 */
	@Override
	public List<HardwareTecnici> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<HardwareTecnici> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<HardwareTecnici> findAll(int start, int end,
		OrderByComparator<HardwareTecnici> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<HardwareTecnici> findAll(int start, int end,
		OrderByComparator<HardwareTecnici> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<HardwareTecnici> list = null;

		if (retrieveFromCache) {
			list = (List<HardwareTecnici>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HARDWARETECNICI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HARDWARETECNICI;

				if (pagination) {
					sql = sql.concat(HardwareTecniciModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HardwareTecnici>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HardwareTecnici>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the hardware tecnicis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HardwareTecnici hardwareTecnici : findAll()) {
			remove(hardwareTecnici);
		}
	}

	/**
	 * Returns the number of hardware tecnicis.
	 *
	 * @return the number of hardware tecnicis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HARDWARETECNICI);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HardwareTecniciModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the hardware tecnici persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(HardwareTecniciImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_HARDWARETECNICI = "SELECT hardwareTecnici FROM HardwareTecnici hardwareTecnici";
	private static final String _SQL_SELECT_HARDWARETECNICI_WHERE_PKS_IN = "SELECT hardwareTecnici FROM HardwareTecnici hardwareTecnici WHERE id_ IN (";
	private static final String _SQL_COUNT_HARDWARETECNICI = "SELECT COUNT(hardwareTecnici) FROM HardwareTecnici hardwareTecnici";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hardwareTecnici.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HardwareTecnici exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(HardwareTecniciPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}