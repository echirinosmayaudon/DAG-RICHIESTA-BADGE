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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import service.intranet.mef.exception.NoSuchRichiesteHWException;
import service.intranet.mef.model.RichiesteHW;
import service.intranet.mef.model.impl.RichiesteHWImpl;
import service.intranet.mef.model.impl.RichiesteHWModelImpl;
import service.intranet.mef.service.persistence.RichiesteHWPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the richieste h w service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteHWPersistence
 * @see service.intranet.mef.service.persistence.RichiesteHWUtil
 * @generated
 */
@ProviderType
public class RichiesteHWPersistenceImpl extends BasePersistenceImpl<RichiesteHW>
	implements RichiesteHWPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiesteHWUtil} to access the richieste h w persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiesteHWImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteHWModelImpl.FINDER_CACHE_ENABLED, RichiesteHWImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteHWModelImpl.FINDER_CACHE_ENABLED, RichiesteHWImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteHWModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RichiesteHWPersistenceImpl() {
		setModelClass(RichiesteHW.class);
	}

	/**
	 * Caches the richieste h w in the entity cache if it is enabled.
	 *
	 * @param richiesteHW the richieste h w
	 */
	@Override
	public void cacheResult(RichiesteHW richiesteHW) {
		entityCache.putResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteHWImpl.class, richiesteHW.getPrimaryKey(), richiesteHW);

		richiesteHW.resetOriginalValues();
	}

	/**
	 * Caches the richieste h ws in the entity cache if it is enabled.
	 *
	 * @param richiesteHWs the richieste h ws
	 */
	@Override
	public void cacheResult(List<RichiesteHW> richiesteHWs) {
		for (RichiesteHW richiesteHW : richiesteHWs) {
			if (entityCache.getResult(
						RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteHWImpl.class, richiesteHW.getPrimaryKey()) == null) {
				cacheResult(richiesteHW);
			}
			else {
				richiesteHW.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richieste h ws.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiesteHWImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richieste h w.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiesteHW richiesteHW) {
		entityCache.removeResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteHWImpl.class, richiesteHW.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichiesteHW> richiesteHWs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichiesteHW richiesteHW : richiesteHWs) {
			entityCache.removeResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteHWImpl.class, richiesteHW.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richieste h w with the primary key. Does not add the richieste h w to the database.
	 *
	 * @param id_richieste_hw the primary key for the new richieste h w
	 * @return the new richieste h w
	 */
	@Override
	public RichiesteHW create(long id_richieste_hw) {
		RichiesteHW richiesteHW = new RichiesteHWImpl();

		richiesteHW.setNew(true);
		richiesteHW.setPrimaryKey(id_richieste_hw);

		return richiesteHW;
	}

	/**
	 * Removes the richieste h w with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_richieste_hw the primary key of the richieste h w
	 * @return the richieste h w that was removed
	 * @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	 */
	@Override
	public RichiesteHW remove(long id_richieste_hw)
		throws NoSuchRichiesteHWException {
		return remove((Serializable)id_richieste_hw);
	}

	/**
	 * Removes the richieste h w with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richieste h w
	 * @return the richieste h w that was removed
	 * @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	 */
	@Override
	public RichiesteHW remove(Serializable primaryKey)
		throws NoSuchRichiesteHWException {
		Session session = null;

		try {
			session = openSession();

			RichiesteHW richiesteHW = (RichiesteHW)session.get(RichiesteHWImpl.class,
					primaryKey);

			if (richiesteHW == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiesteHWException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richiesteHW);
		}
		catch (NoSuchRichiesteHWException nsee) {
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
	protected RichiesteHW removeImpl(RichiesteHW richiesteHW) {
		richiesteHW = toUnwrappedModel(richiesteHW);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiesteHW)) {
				richiesteHW = (RichiesteHW)session.get(RichiesteHWImpl.class,
						richiesteHW.getPrimaryKeyObj());
			}

			if (richiesteHW != null) {
				session.delete(richiesteHW);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiesteHW != null) {
			clearCache(richiesteHW);
		}

		return richiesteHW;
	}

	@Override
	public RichiesteHW updateImpl(RichiesteHW richiesteHW) {
		richiesteHW = toUnwrappedModel(richiesteHW);

		boolean isNew = richiesteHW.isNew();

		Session session = null;

		try {
			session = openSession();

			if (richiesteHW.isNew()) {
				session.save(richiesteHW);

				richiesteHW.setNew(false);
			}
			else {
				richiesteHW = (RichiesteHW)session.merge(richiesteHW);
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

		entityCache.putResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteHWImpl.class, richiesteHW.getPrimaryKey(), richiesteHW,
			false);

		richiesteHW.resetOriginalValues();

		return richiesteHW;
	}

	protected RichiesteHW toUnwrappedModel(RichiesteHW richiesteHW) {
		if (richiesteHW instanceof RichiesteHWImpl) {
			return richiesteHW;
		}

		RichiesteHWImpl richiesteHWImpl = new RichiesteHWImpl();

		richiesteHWImpl.setNew(richiesteHW.isNew());
		richiesteHWImpl.setPrimaryKey(richiesteHW.getPrimaryKey());

		richiesteHWImpl.setId_richieste_hw(richiesteHW.getId_richieste_hw());
		richiesteHWImpl.setUtente(richiesteHW.getUtente());
		richiesteHWImpl.setDettaglio(richiesteHW.getDettaglio());
		richiesteHWImpl.setData_richiesta(richiesteHW.getData_richiesta());

		return richiesteHWImpl;
	}

	/**
	 * Returns the richieste h w with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste h w
	 * @return the richieste h w
	 * @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	 */
	@Override
	public RichiesteHW findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiesteHWException {
		RichiesteHW richiesteHW = fetchByPrimaryKey(primaryKey);

		if (richiesteHW == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiesteHWException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richiesteHW;
	}

	/**
	 * Returns the richieste h w with the primary key or throws a {@link NoSuchRichiesteHWException} if it could not be found.
	 *
	 * @param id_richieste_hw the primary key of the richieste h w
	 * @return the richieste h w
	 * @throws NoSuchRichiesteHWException if a richieste h w with the primary key could not be found
	 */
	@Override
	public RichiesteHW findByPrimaryKey(long id_richieste_hw)
		throws NoSuchRichiesteHWException {
		return findByPrimaryKey((Serializable)id_richieste_hw);
	}

	/**
	 * Returns the richieste h w with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste h w
	 * @return the richieste h w, or <code>null</code> if a richieste h w with the primary key could not be found
	 */
	@Override
	public RichiesteHW fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteHWImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichiesteHW richiesteHW = (RichiesteHW)serializable;

		if (richiesteHW == null) {
			Session session = null;

			try {
				session = openSession();

				richiesteHW = (RichiesteHW)session.get(RichiesteHWImpl.class,
						primaryKey);

				if (richiesteHW != null) {
					cacheResult(richiesteHW);
				}
				else {
					entityCache.putResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteHWImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteHWImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiesteHW;
	}

	/**
	 * Returns the richieste h w with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_richieste_hw the primary key of the richieste h w
	 * @return the richieste h w, or <code>null</code> if a richieste h w with the primary key could not be found
	 */
	@Override
	public RichiesteHW fetchByPrimaryKey(long id_richieste_hw) {
		return fetchByPrimaryKey((Serializable)id_richieste_hw);
	}

	@Override
	public Map<Serializable, RichiesteHW> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichiesteHW> map = new HashMap<Serializable, RichiesteHW>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichiesteHW richiesteHW = fetchByPrimaryKey(primaryKey);

			if (richiesteHW != null) {
				map.put(primaryKey, richiesteHW);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteHWImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichiesteHW)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTEHW_WHERE_PKS_IN);

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

			for (RichiesteHW richiesteHW : (List<RichiesteHW>)q.list()) {
				map.put(richiesteHW.getPrimaryKeyObj(), richiesteHW);

				cacheResult(richiesteHW);

				uncachedPrimaryKeys.remove(richiesteHW.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiesteHWModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteHWImpl.class, primaryKey, nullModel);
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
	 * Returns all the richieste h ws.
	 *
	 * @return the richieste h ws
	 */
	@Override
	public List<RichiesteHW> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richieste h ws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste h ws
	 * @param end the upper bound of the range of richieste h ws (not inclusive)
	 * @return the range of richieste h ws
	 */
	@Override
	public List<RichiesteHW> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richieste h ws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste h ws
	 * @param end the upper bound of the range of richieste h ws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richieste h ws
	 */
	@Override
	public List<RichiesteHW> findAll(int start, int end,
		OrderByComparator<RichiesteHW> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richieste h ws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste h ws
	 * @param end the upper bound of the range of richieste h ws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richieste h ws
	 */
	@Override
	public List<RichiesteHW> findAll(int start, int end,
		OrderByComparator<RichiesteHW> orderByComparator,
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

		List<RichiesteHW> list = null;

		if (retrieveFromCache) {
			list = (List<RichiesteHW>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTEHW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTEHW;

				if (pagination) {
					sql = sql.concat(RichiesteHWModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichiesteHW>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiesteHW>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the richieste h ws from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiesteHW richiesteHW : findAll()) {
			remove(richiesteHW);
		}
	}

	/**
	 * Returns the number of richieste h ws.
	 *
	 * @return the number of richieste h ws
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTEHW);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return RichiesteHWModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richieste h w persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiesteHWImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTEHW = "SELECT richiesteHW FROM RichiesteHW richiesteHW";
	private static final String _SQL_SELECT_RICHIESTEHW_WHERE_PKS_IN = "SELECT richiesteHW FROM RichiesteHW richiesteHW WHERE id_richieste_hw IN (";
	private static final String _SQL_COUNT_RICHIESTEHW = "SELECT COUNT(richiesteHW) FROM RichiesteHW richiesteHW";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richiesteHW.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichiesteHW exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RichiesteHWPersistenceImpl.class);
}