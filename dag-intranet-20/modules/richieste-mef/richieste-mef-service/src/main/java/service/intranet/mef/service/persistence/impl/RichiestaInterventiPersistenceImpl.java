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

import service.intranet.mef.exception.NoSuchRichiestaInterventiException;
import service.intranet.mef.model.RichiestaInterventi;
import service.intranet.mef.model.impl.RichiestaInterventiImpl;
import service.intranet.mef.model.impl.RichiestaInterventiModelImpl;
import service.intranet.mef.service.persistence.RichiestaInterventiPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the richiesta interventi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaInterventiPersistence
 * @see service.intranet.mef.service.persistence.RichiestaInterventiUtil
 * @generated
 */
@ProviderType
public class RichiestaInterventiPersistenceImpl extends BasePersistenceImpl<RichiestaInterventi>
	implements RichiestaInterventiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiestaInterventiUtil} to access the richiesta interventi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiestaInterventiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaInterventiModelImpl.FINDER_CACHE_ENABLED,
			RichiestaInterventiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaInterventiModelImpl.FINDER_CACHE_ENABLED,
			RichiestaInterventiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaInterventiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RichiestaInterventiPersistenceImpl() {
		setModelClass(RichiestaInterventi.class);
	}

	/**
	 * Caches the richiesta interventi in the entity cache if it is enabled.
	 *
	 * @param richiestaInterventi the richiesta interventi
	 */
	@Override
	public void cacheResult(RichiestaInterventi richiestaInterventi) {
		entityCache.putResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaInterventiImpl.class, richiestaInterventi.getPrimaryKey(),
			richiestaInterventi);

		richiestaInterventi.resetOriginalValues();
	}

	/**
	 * Caches the richiesta interventis in the entity cache if it is enabled.
	 *
	 * @param richiestaInterventis the richiesta interventis
	 */
	@Override
	public void cacheResult(List<RichiestaInterventi> richiestaInterventis) {
		for (RichiestaInterventi richiestaInterventi : richiestaInterventis) {
			if (entityCache.getResult(
						RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaInterventiImpl.class,
						richiestaInterventi.getPrimaryKey()) == null) {
				cacheResult(richiestaInterventi);
			}
			else {
				richiestaInterventi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richiesta interventis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiestaInterventiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richiesta interventi.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiestaInterventi richiestaInterventi) {
		entityCache.removeResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaInterventiImpl.class, richiestaInterventi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichiestaInterventi> richiestaInterventis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichiestaInterventi richiestaInterventi : richiestaInterventis) {
			entityCache.removeResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaInterventiImpl.class,
				richiestaInterventi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richiesta interventi with the primary key. Does not add the richiesta interventi to the database.
	 *
	 * @param id the primary key for the new richiesta interventi
	 * @return the new richiesta interventi
	 */
	@Override
	public RichiestaInterventi create(long id) {
		RichiestaInterventi richiestaInterventi = new RichiestaInterventiImpl();

		richiestaInterventi.setNew(true);
		richiestaInterventi.setPrimaryKey(id);

		return richiestaInterventi;
	}

	/**
	 * Removes the richiesta interventi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the richiesta interventi
	 * @return the richiesta interventi that was removed
	 * @throws NoSuchRichiestaInterventiException if a richiesta interventi with the primary key could not be found
	 */
	@Override
	public RichiestaInterventi remove(long id)
		throws NoSuchRichiestaInterventiException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the richiesta interventi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richiesta interventi
	 * @return the richiesta interventi that was removed
	 * @throws NoSuchRichiestaInterventiException if a richiesta interventi with the primary key could not be found
	 */
	@Override
	public RichiestaInterventi remove(Serializable primaryKey)
		throws NoSuchRichiestaInterventiException {
		Session session = null;

		try {
			session = openSession();

			RichiestaInterventi richiestaInterventi = (RichiestaInterventi)session.get(RichiestaInterventiImpl.class,
					primaryKey);

			if (richiestaInterventi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiestaInterventiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richiestaInterventi);
		}
		catch (NoSuchRichiestaInterventiException nsee) {
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
	protected RichiestaInterventi removeImpl(
		RichiestaInterventi richiestaInterventi) {
		richiestaInterventi = toUnwrappedModel(richiestaInterventi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiestaInterventi)) {
				richiestaInterventi = (RichiestaInterventi)session.get(RichiestaInterventiImpl.class,
						richiestaInterventi.getPrimaryKeyObj());
			}

			if (richiestaInterventi != null) {
				session.delete(richiestaInterventi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiestaInterventi != null) {
			clearCache(richiestaInterventi);
		}

		return richiestaInterventi;
	}

	@Override
	public RichiestaInterventi updateImpl(
		RichiestaInterventi richiestaInterventi) {
		richiestaInterventi = toUnwrappedModel(richiestaInterventi);

		boolean isNew = richiestaInterventi.isNew();

		Session session = null;

		try {
			session = openSession();

			if (richiestaInterventi.isNew()) {
				session.save(richiestaInterventi);

				richiestaInterventi.setNew(false);
			}
			else {
				richiestaInterventi = (RichiestaInterventi)session.merge(richiestaInterventi);
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

		entityCache.putResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaInterventiImpl.class, richiestaInterventi.getPrimaryKey(),
			richiestaInterventi, false);

		richiestaInterventi.resetOriginalValues();

		return richiestaInterventi;
	}

	protected RichiestaInterventi toUnwrappedModel(
		RichiestaInterventi richiestaInterventi) {
		if (richiestaInterventi instanceof RichiestaInterventiImpl) {
			return richiestaInterventi;
		}

		RichiestaInterventiImpl richiestaInterventiImpl = new RichiestaInterventiImpl();

		richiestaInterventiImpl.setNew(richiestaInterventi.isNew());
		richiestaInterventiImpl.setPrimaryKey(richiestaInterventi.getPrimaryKey());

		richiestaInterventiImpl.setId(richiestaInterventi.getId());
		richiestaInterventiImpl.setUtente(richiestaInterventi.getUtente());
		richiestaInterventiImpl.setDettaglio(richiestaInterventi.getDettaglio());
		richiestaInterventiImpl.setData_interventi(richiestaInterventi.getData_interventi());

		return richiestaInterventiImpl;
	}

	/**
	 * Returns the richiesta interventi with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta interventi
	 * @return the richiesta interventi
	 * @throws NoSuchRichiestaInterventiException if a richiesta interventi with the primary key could not be found
	 */
	@Override
	public RichiestaInterventi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiestaInterventiException {
		RichiestaInterventi richiestaInterventi = fetchByPrimaryKey(primaryKey);

		if (richiestaInterventi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiestaInterventiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richiestaInterventi;
	}

	/**
	 * Returns the richiesta interventi with the primary key or throws a {@link NoSuchRichiestaInterventiException} if it could not be found.
	 *
	 * @param id the primary key of the richiesta interventi
	 * @return the richiesta interventi
	 * @throws NoSuchRichiestaInterventiException if a richiesta interventi with the primary key could not be found
	 */
	@Override
	public RichiestaInterventi findByPrimaryKey(long id)
		throws NoSuchRichiestaInterventiException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the richiesta interventi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta interventi
	 * @return the richiesta interventi, or <code>null</code> if a richiesta interventi with the primary key could not be found
	 */
	@Override
	public RichiestaInterventi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaInterventiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichiestaInterventi richiestaInterventi = (RichiestaInterventi)serializable;

		if (richiestaInterventi == null) {
			Session session = null;

			try {
				session = openSession();

				richiestaInterventi = (RichiestaInterventi)session.get(RichiestaInterventiImpl.class,
						primaryKey);

				if (richiestaInterventi != null) {
					cacheResult(richiestaInterventi);
				}
				else {
					entityCache.putResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaInterventiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaInterventiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiestaInterventi;
	}

	/**
	 * Returns the richiesta interventi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the richiesta interventi
	 * @return the richiesta interventi, or <code>null</code> if a richiesta interventi with the primary key could not be found
	 */
	@Override
	public RichiestaInterventi fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, RichiestaInterventi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichiestaInterventi> map = new HashMap<Serializable, RichiestaInterventi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichiestaInterventi richiestaInterventi = fetchByPrimaryKey(primaryKey);

			if (richiestaInterventi != null) {
				map.put(primaryKey, richiestaInterventi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaInterventiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichiestaInterventi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTAINTERVENTI_WHERE_PKS_IN);

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

			for (RichiestaInterventi richiestaInterventi : (List<RichiestaInterventi>)q.list()) {
				map.put(richiestaInterventi.getPrimaryKeyObj(),
					richiestaInterventi);

				cacheResult(richiestaInterventi);

				uncachedPrimaryKeys.remove(richiestaInterventi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiestaInterventiModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaInterventiImpl.class, primaryKey, nullModel);
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
	 * Returns all the richiesta interventis.
	 *
	 * @return the richiesta interventis
	 */
	@Override
	public List<RichiestaInterventi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta interventis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaInterventiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta interventis
	 * @param end the upper bound of the range of richiesta interventis (not inclusive)
	 * @return the range of richiesta interventis
	 */
	@Override
	public List<RichiestaInterventi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta interventis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaInterventiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta interventis
	 * @param end the upper bound of the range of richiesta interventis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta interventis
	 */
	@Override
	public List<RichiestaInterventi> findAll(int start, int end,
		OrderByComparator<RichiestaInterventi> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta interventis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaInterventiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta interventis
	 * @param end the upper bound of the range of richiesta interventis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiesta interventis
	 */
	@Override
	public List<RichiestaInterventi> findAll(int start, int end,
		OrderByComparator<RichiestaInterventi> orderByComparator,
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

		List<RichiestaInterventi> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaInterventi>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTAINTERVENTI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTAINTERVENTI;

				if (pagination) {
					sql = sql.concat(RichiestaInterventiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichiestaInterventi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaInterventi>)QueryUtil.list(q,
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
	 * Removes all the richiesta interventis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiestaInterventi richiestaInterventi : findAll()) {
			remove(richiestaInterventi);
		}
	}

	/**
	 * Returns the number of richiesta interventis.
	 *
	 * @return the number of richiesta interventis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTAINTERVENTI);

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
		return RichiestaInterventiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richiesta interventi persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiestaInterventiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTAINTERVENTI = "SELECT richiestaInterventi FROM RichiestaInterventi richiestaInterventi";
	private static final String _SQL_SELECT_RICHIESTAINTERVENTI_WHERE_PKS_IN = "SELECT richiestaInterventi FROM RichiestaInterventi richiestaInterventi WHERE id_ IN (";
	private static final String _SQL_COUNT_RICHIESTAINTERVENTI = "SELECT COUNT(richiestaInterventi) FROM RichiestaInterventi richiestaInterventi";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richiestaInterventi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichiestaInterventi exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RichiestaInterventiPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}