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

package com.intranet.mef.gestione.riunioni.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.exception.NoSuchStatoInvitatoException;
import com.intranet.mef.gestione.riunioni.model.StatoInvitato;
import com.intranet.mef.gestione.riunioni.model.impl.StatoInvitatoImpl;
import com.intranet.mef.gestione.riunioni.model.impl.StatoInvitatoModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.StatoInvitatoPersistence;

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

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the stato invitato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoInvitatoPersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.StatoInvitatoUtil
 * @generated
 */
@ProviderType
public class StatoInvitatoPersistenceImpl extends BasePersistenceImpl<StatoInvitato>
	implements StatoInvitatoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatoInvitatoUtil} to access the stato invitato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatoInvitatoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoInvitatoModelImpl.FINDER_CACHE_ENABLED,
			StatoInvitatoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoInvitatoModelImpl.FINDER_CACHE_ENABLED,
			StatoInvitatoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoInvitatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StatoInvitatoPersistenceImpl() {
		setModelClass(StatoInvitato.class);
	}

	/**
	 * Caches the stato invitato in the entity cache if it is enabled.
	 *
	 * @param statoInvitato the stato invitato
	 */
	@Override
	public void cacheResult(StatoInvitato statoInvitato) {
		entityCache.putResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoInvitatoImpl.class, statoInvitato.getPrimaryKey(),
			statoInvitato);

		statoInvitato.resetOriginalValues();
	}

	/**
	 * Caches the stato invitatos in the entity cache if it is enabled.
	 *
	 * @param statoInvitatos the stato invitatos
	 */
	@Override
	public void cacheResult(List<StatoInvitato> statoInvitatos) {
		for (StatoInvitato statoInvitato : statoInvitatos) {
			if (entityCache.getResult(
						StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
						StatoInvitatoImpl.class, statoInvitato.getPrimaryKey()) == null) {
				cacheResult(statoInvitato);
			}
			else {
				statoInvitato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stato invitatos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatoInvitatoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stato invitato.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatoInvitato statoInvitato) {
		entityCache.removeResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoInvitatoImpl.class, statoInvitato.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StatoInvitato> statoInvitatos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatoInvitato statoInvitato : statoInvitatos) {
			entityCache.removeResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
				StatoInvitatoImpl.class, statoInvitato.getPrimaryKey());
		}
	}

	/**
	 * Creates a new stato invitato with the primary key. Does not add the stato invitato to the database.
	 *
	 * @param id_stato_invitato the primary key for the new stato invitato
	 * @return the new stato invitato
	 */
	@Override
	public StatoInvitato create(long id_stato_invitato) {
		StatoInvitato statoInvitato = new StatoInvitatoImpl();

		statoInvitato.setNew(true);
		statoInvitato.setPrimaryKey(id_stato_invitato);

		return statoInvitato;
	}

	/**
	 * Removes the stato invitato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_stato_invitato the primary key of the stato invitato
	 * @return the stato invitato that was removed
	 * @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	 */
	@Override
	public StatoInvitato remove(long id_stato_invitato)
		throws NoSuchStatoInvitatoException {
		return remove((Serializable)id_stato_invitato);
	}

	/**
	 * Removes the stato invitato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stato invitato
	 * @return the stato invitato that was removed
	 * @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	 */
	@Override
	public StatoInvitato remove(Serializable primaryKey)
		throws NoSuchStatoInvitatoException {
		Session session = null;

		try {
			session = openSession();

			StatoInvitato statoInvitato = (StatoInvitato)session.get(StatoInvitatoImpl.class,
					primaryKey);

			if (statoInvitato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatoInvitatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statoInvitato);
		}
		catch (NoSuchStatoInvitatoException nsee) {
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
	protected StatoInvitato removeImpl(StatoInvitato statoInvitato) {
		statoInvitato = toUnwrappedModel(statoInvitato);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statoInvitato)) {
				statoInvitato = (StatoInvitato)session.get(StatoInvitatoImpl.class,
						statoInvitato.getPrimaryKeyObj());
			}

			if (statoInvitato != null) {
				session.delete(statoInvitato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statoInvitato != null) {
			clearCache(statoInvitato);
		}

		return statoInvitato;
	}

	@Override
	public StatoInvitato updateImpl(StatoInvitato statoInvitato) {
		statoInvitato = toUnwrappedModel(statoInvitato);

		boolean isNew = statoInvitato.isNew();

		Session session = null;

		try {
			session = openSession();

			if (statoInvitato.isNew()) {
				session.save(statoInvitato);

				statoInvitato.setNew(false);
			}
			else {
				statoInvitato = (StatoInvitato)session.merge(statoInvitato);
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

		entityCache.putResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
			StatoInvitatoImpl.class, statoInvitato.getPrimaryKey(),
			statoInvitato, false);

		statoInvitato.resetOriginalValues();

		return statoInvitato;
	}

	protected StatoInvitato toUnwrappedModel(StatoInvitato statoInvitato) {
		if (statoInvitato instanceof StatoInvitatoImpl) {
			return statoInvitato;
		}

		StatoInvitatoImpl statoInvitatoImpl = new StatoInvitatoImpl();

		statoInvitatoImpl.setNew(statoInvitato.isNew());
		statoInvitatoImpl.setPrimaryKey(statoInvitato.getPrimaryKey());

		statoInvitatoImpl.setId_stato_invitato(statoInvitato.getId_stato_invitato());
		statoInvitatoImpl.setNome_stato(statoInvitato.getNome_stato());

		return statoInvitatoImpl;
	}

	/**
	 * Returns the stato invitato with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato invitato
	 * @return the stato invitato
	 * @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	 */
	@Override
	public StatoInvitato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatoInvitatoException {
		StatoInvitato statoInvitato = fetchByPrimaryKey(primaryKey);

		if (statoInvitato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatoInvitatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statoInvitato;
	}

	/**
	 * Returns the stato invitato with the primary key or throws a {@link NoSuchStatoInvitatoException} if it could not be found.
	 *
	 * @param id_stato_invitato the primary key of the stato invitato
	 * @return the stato invitato
	 * @throws NoSuchStatoInvitatoException if a stato invitato with the primary key could not be found
	 */
	@Override
	public StatoInvitato findByPrimaryKey(long id_stato_invitato)
		throws NoSuchStatoInvitatoException {
		return findByPrimaryKey((Serializable)id_stato_invitato);
	}

	/**
	 * Returns the stato invitato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stato invitato
	 * @return the stato invitato, or <code>null</code> if a stato invitato with the primary key could not be found
	 */
	@Override
	public StatoInvitato fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
				StatoInvitatoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StatoInvitato statoInvitato = (StatoInvitato)serializable;

		if (statoInvitato == null) {
			Session session = null;

			try {
				session = openSession();

				statoInvitato = (StatoInvitato)session.get(StatoInvitatoImpl.class,
						primaryKey);

				if (statoInvitato != null) {
					cacheResult(statoInvitato);
				}
				else {
					entityCache.putResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
						StatoInvitatoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
					StatoInvitatoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statoInvitato;
	}

	/**
	 * Returns the stato invitato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_stato_invitato the primary key of the stato invitato
	 * @return the stato invitato, or <code>null</code> if a stato invitato with the primary key could not be found
	 */
	@Override
	public StatoInvitato fetchByPrimaryKey(long id_stato_invitato) {
		return fetchByPrimaryKey((Serializable)id_stato_invitato);
	}

	@Override
	public Map<Serializable, StatoInvitato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StatoInvitato> map = new HashMap<Serializable, StatoInvitato>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StatoInvitato statoInvitato = fetchByPrimaryKey(primaryKey);

			if (statoInvitato != null) {
				map.put(primaryKey, statoInvitato);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
					StatoInvitatoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StatoInvitato)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STATOINVITATO_WHERE_PKS_IN);

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

			for (StatoInvitato statoInvitato : (List<StatoInvitato>)q.list()) {
				map.put(statoInvitato.getPrimaryKeyObj(), statoInvitato);

				cacheResult(statoInvitato);

				uncachedPrimaryKeys.remove(statoInvitato.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StatoInvitatoModelImpl.ENTITY_CACHE_ENABLED,
					StatoInvitatoImpl.class, primaryKey, nullModel);
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
	 * Returns all the stato invitatos.
	 *
	 * @return the stato invitatos
	 */
	@Override
	public List<StatoInvitato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stato invitatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato invitatos
	 * @param end the upper bound of the range of stato invitatos (not inclusive)
	 * @return the range of stato invitatos
	 */
	@Override
	public List<StatoInvitato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stato invitatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato invitatos
	 * @param end the upper bound of the range of stato invitatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato invitatos
	 */
	@Override
	public List<StatoInvitato> findAll(int start, int end,
		OrderByComparator<StatoInvitato> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stato invitatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StatoInvitatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato invitatos
	 * @param end the upper bound of the range of stato invitatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stato invitatos
	 */
	@Override
	public List<StatoInvitato> findAll(int start, int end,
		OrderByComparator<StatoInvitato> orderByComparator,
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

		List<StatoInvitato> list = null;

		if (retrieveFromCache) {
			list = (List<StatoInvitato>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STATOINVITATO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATOINVITATO;

				if (pagination) {
					sql = sql.concat(StatoInvitatoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatoInvitato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StatoInvitato>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the stato invitatos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StatoInvitato statoInvitato : findAll()) {
			remove(statoInvitato);
		}
	}

	/**
	 * Returns the number of stato invitatos.
	 *
	 * @return the number of stato invitatos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATOINVITATO);

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
		return StatoInvitatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stato invitato persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StatoInvitatoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STATOINVITATO = "SELECT statoInvitato FROM StatoInvitato statoInvitato";
	private static final String _SQL_SELECT_STATOINVITATO_WHERE_PKS_IN = "SELECT statoInvitato FROM StatoInvitato statoInvitato WHERE id_stato_invitato IN (";
	private static final String _SQL_COUNT_STATOINVITATO = "SELECT COUNT(statoInvitato) FROM StatoInvitato statoInvitato";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statoInvitato.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatoInvitato exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(StatoInvitatoPersistenceImpl.class);
}