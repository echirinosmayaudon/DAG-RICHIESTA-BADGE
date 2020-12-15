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

import service.intranet.mef.exception.NoSuchTipoBeneInvException;
import service.intranet.mef.model.TipoBeneInv;
import service.intranet.mef.model.impl.TipoBeneInvImpl;
import service.intranet.mef.model.impl.TipoBeneInvModelImpl;
import service.intranet.mef.service.persistence.TipoBeneInvPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tipo bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoBeneInvPersistence
 * @see service.intranet.mef.service.persistence.TipoBeneInvUtil
 * @generated
 */
@ProviderType
public class TipoBeneInvPersistenceImpl extends BasePersistenceImpl<TipoBeneInv>
	implements TipoBeneInvPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipoBeneInvUtil} to access the tipo bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipoBeneInvImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			TipoBeneInvModelImpl.FINDER_CACHE_ENABLED, TipoBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			TipoBeneInvModelImpl.FINDER_CACHE_ENABLED, TipoBeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			TipoBeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TipoBeneInvPersistenceImpl() {
		setModelClass(TipoBeneInv.class);
	}

	/**
	 * Caches the tipo bene inv in the entity cache if it is enabled.
	 *
	 * @param tipoBeneInv the tipo bene inv
	 */
	@Override
	public void cacheResult(TipoBeneInv tipoBeneInv) {
		entityCache.putResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			TipoBeneInvImpl.class, tipoBeneInv.getPrimaryKey(), tipoBeneInv);

		tipoBeneInv.resetOriginalValues();
	}

	/**
	 * Caches the tipo bene invs in the entity cache if it is enabled.
	 *
	 * @param tipoBeneInvs the tipo bene invs
	 */
	@Override
	public void cacheResult(List<TipoBeneInv> tipoBeneInvs) {
		for (TipoBeneInv tipoBeneInv : tipoBeneInvs) {
			if (entityCache.getResult(
						TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
						TipoBeneInvImpl.class, tipoBeneInv.getPrimaryKey()) == null) {
				cacheResult(tipoBeneInv);
			}
			else {
				tipoBeneInv.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipo bene invs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipoBeneInvImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipo bene inv.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipoBeneInv tipoBeneInv) {
		entityCache.removeResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			TipoBeneInvImpl.class, tipoBeneInv.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipoBeneInv> tipoBeneInvs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipoBeneInv tipoBeneInv : tipoBeneInvs) {
			entityCache.removeResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
				TipoBeneInvImpl.class, tipoBeneInv.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipo bene inv with the primary key. Does not add the tipo bene inv to the database.
	 *
	 * @param id the primary key for the new tipo bene inv
	 * @return the new tipo bene inv
	 */
	@Override
	public TipoBeneInv create(long id) {
		TipoBeneInv tipoBeneInv = new TipoBeneInvImpl();

		tipoBeneInv.setNew(true);
		tipoBeneInv.setPrimaryKey(id);

		return tipoBeneInv;
	}

	/**
	 * Removes the tipo bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tipo bene inv
	 * @return the tipo bene inv that was removed
	 * @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	 */
	@Override
	public TipoBeneInv remove(long id) throws NoSuchTipoBeneInvException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tipo bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo bene inv
	 * @return the tipo bene inv that was removed
	 * @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	 */
	@Override
	public TipoBeneInv remove(Serializable primaryKey)
		throws NoSuchTipoBeneInvException {
		Session session = null;

		try {
			session = openSession();

			TipoBeneInv tipoBeneInv = (TipoBeneInv)session.get(TipoBeneInvImpl.class,
					primaryKey);

			if (tipoBeneInv == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipoBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipoBeneInv);
		}
		catch (NoSuchTipoBeneInvException nsee) {
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
	protected TipoBeneInv removeImpl(TipoBeneInv tipoBeneInv) {
		tipoBeneInv = toUnwrappedModel(tipoBeneInv);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipoBeneInv)) {
				tipoBeneInv = (TipoBeneInv)session.get(TipoBeneInvImpl.class,
						tipoBeneInv.getPrimaryKeyObj());
			}

			if (tipoBeneInv != null) {
				session.delete(tipoBeneInv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipoBeneInv != null) {
			clearCache(tipoBeneInv);
		}

		return tipoBeneInv;
	}

	@Override
	public TipoBeneInv updateImpl(TipoBeneInv tipoBeneInv) {
		tipoBeneInv = toUnwrappedModel(tipoBeneInv);

		boolean isNew = tipoBeneInv.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipoBeneInv.isNew()) {
				session.save(tipoBeneInv);

				tipoBeneInv.setNew(false);
			}
			else {
				tipoBeneInv = (TipoBeneInv)session.merge(tipoBeneInv);
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

		entityCache.putResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
			TipoBeneInvImpl.class, tipoBeneInv.getPrimaryKey(), tipoBeneInv,
			false);

		tipoBeneInv.resetOriginalValues();

		return tipoBeneInv;
	}

	protected TipoBeneInv toUnwrappedModel(TipoBeneInv tipoBeneInv) {
		if (tipoBeneInv instanceof TipoBeneInvImpl) {
			return tipoBeneInv;
		}

		TipoBeneInvImpl tipoBeneInvImpl = new TipoBeneInvImpl();

		tipoBeneInvImpl.setNew(tipoBeneInv.isNew());
		tipoBeneInvImpl.setPrimaryKey(tipoBeneInv.getPrimaryKey());

		tipoBeneInvImpl.setId(tipoBeneInv.getId());
		tipoBeneInvImpl.setTipo(tipoBeneInv.getTipo());

		return tipoBeneInvImpl;
	}

	/**
	 * Returns the tipo bene inv with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo bene inv
	 * @return the tipo bene inv
	 * @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	 */
	@Override
	public TipoBeneInv findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipoBeneInvException {
		TipoBeneInv tipoBeneInv = fetchByPrimaryKey(primaryKey);

		if (tipoBeneInv == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipoBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipoBeneInv;
	}

	/**
	 * Returns the tipo bene inv with the primary key or throws a {@link NoSuchTipoBeneInvException} if it could not be found.
	 *
	 * @param id the primary key of the tipo bene inv
	 * @return the tipo bene inv
	 * @throws NoSuchTipoBeneInvException if a tipo bene inv with the primary key could not be found
	 */
	@Override
	public TipoBeneInv findByPrimaryKey(long id)
		throws NoSuchTipoBeneInvException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tipo bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo bene inv
	 * @return the tipo bene inv, or <code>null</code> if a tipo bene inv with the primary key could not be found
	 */
	@Override
	public TipoBeneInv fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
				TipoBeneInvImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipoBeneInv tipoBeneInv = (TipoBeneInv)serializable;

		if (tipoBeneInv == null) {
			Session session = null;

			try {
				session = openSession();

				tipoBeneInv = (TipoBeneInv)session.get(TipoBeneInvImpl.class,
						primaryKey);

				if (tipoBeneInv != null) {
					cacheResult(tipoBeneInv);
				}
				else {
					entityCache.putResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
						TipoBeneInvImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					TipoBeneInvImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipoBeneInv;
	}

	/**
	 * Returns the tipo bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tipo bene inv
	 * @return the tipo bene inv, or <code>null</code> if a tipo bene inv with the primary key could not be found
	 */
	@Override
	public TipoBeneInv fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, TipoBeneInv> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipoBeneInv> map = new HashMap<Serializable, TipoBeneInv>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipoBeneInv tipoBeneInv = fetchByPrimaryKey(primaryKey);

			if (tipoBeneInv != null) {
				map.put(primaryKey, tipoBeneInv);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					TipoBeneInvImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipoBeneInv)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPOBENEINV_WHERE_PKS_IN);

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

			for (TipoBeneInv tipoBeneInv : (List<TipoBeneInv>)q.list()) {
				map.put(tipoBeneInv.getPrimaryKeyObj(), tipoBeneInv);

				cacheResult(tipoBeneInv);

				uncachedPrimaryKeys.remove(tipoBeneInv.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipoBeneInvModelImpl.ENTITY_CACHE_ENABLED,
					TipoBeneInvImpl.class, primaryKey, nullModel);
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
	 * Returns all the tipo bene invs.
	 *
	 * @return the tipo bene invs
	 */
	@Override
	public List<TipoBeneInv> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TipoBeneInv> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<TipoBeneInv> findAll(int start, int end,
		OrderByComparator<TipoBeneInv> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<TipoBeneInv> findAll(int start, int end,
		OrderByComparator<TipoBeneInv> orderByComparator,
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

		List<TipoBeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<TipoBeneInv>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPOBENEINV);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOBENEINV;

				if (pagination) {
					sql = sql.concat(TipoBeneInvModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipoBeneInv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipoBeneInv>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tipo bene invs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipoBeneInv tipoBeneInv : findAll()) {
			remove(tipoBeneInv);
		}
	}

	/**
	 * Returns the number of tipo bene invs.
	 *
	 * @return the number of tipo bene invs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPOBENEINV);

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
		return TipoBeneInvModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipo bene inv persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipoBeneInvImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPOBENEINV = "SELECT tipoBeneInv FROM TipoBeneInv tipoBeneInv";
	private static final String _SQL_SELECT_TIPOBENEINV_WHERE_PKS_IN = "SELECT tipoBeneInv FROM TipoBeneInv tipoBeneInv WHERE id_ IN (";
	private static final String _SQL_COUNT_TIPOBENEINV = "SELECT COUNT(tipoBeneInv) FROM TipoBeneInv tipoBeneInv";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipoBeneInv.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipoBeneInv exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TipoBeneInvPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}