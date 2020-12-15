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

import service.intranet.mef.exception.NoSuchBadgeRichiesteException;
import service.intranet.mef.model.BadgeRichieste;
import service.intranet.mef.model.impl.BadgeRichiesteImpl;
import service.intranet.mef.model.impl.BadgeRichiesteModelImpl;
import service.intranet.mef.service.persistence.BadgeRichiestePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the badge richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BadgeRichiestePersistence
 * @see service.intranet.mef.service.persistence.BadgeRichiesteUtil
 * @generated
 */
@ProviderType
public class BadgeRichiestePersistenceImpl extends BasePersistenceImpl<BadgeRichieste>
	implements BadgeRichiestePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BadgeRichiesteUtil} to access the badge richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BadgeRichiesteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			BadgeRichiesteModelImpl.FINDER_CACHE_ENABLED,
			BadgeRichiesteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			BadgeRichiesteModelImpl.FINDER_CACHE_ENABLED,
			BadgeRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			BadgeRichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BadgeRichiestePersistenceImpl() {
		setModelClass(BadgeRichieste.class);
	}

	/**
	 * Caches the badge richieste in the entity cache if it is enabled.
	 *
	 * @param badgeRichieste the badge richieste
	 */
	@Override
	public void cacheResult(BadgeRichieste badgeRichieste) {
		entityCache.putResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			BadgeRichiesteImpl.class, badgeRichieste.getPrimaryKey(),
			badgeRichieste);

		badgeRichieste.resetOriginalValues();
	}

	/**
	 * Caches the badge richiestes in the entity cache if it is enabled.
	 *
	 * @param badgeRichiestes the badge richiestes
	 */
	@Override
	public void cacheResult(List<BadgeRichieste> badgeRichiestes) {
		for (BadgeRichieste badgeRichieste : badgeRichiestes) {
			if (entityCache.getResult(
						BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
						BadgeRichiesteImpl.class, badgeRichieste.getPrimaryKey()) == null) {
				cacheResult(badgeRichieste);
			}
			else {
				badgeRichieste.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all badge richiestes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BadgeRichiesteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the badge richieste.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BadgeRichieste badgeRichieste) {
		entityCache.removeResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			BadgeRichiesteImpl.class, badgeRichieste.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BadgeRichieste> badgeRichiestes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BadgeRichieste badgeRichieste : badgeRichiestes) {
			entityCache.removeResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
				BadgeRichiesteImpl.class, badgeRichieste.getPrimaryKey());
		}
	}

	/**
	 * Creates a new badge richieste with the primary key. Does not add the badge richieste to the database.
	 *
	 * @param id the primary key for the new badge richieste
	 * @return the new badge richieste
	 */
	@Override
	public BadgeRichieste create(long id) {
		BadgeRichieste badgeRichieste = new BadgeRichiesteImpl();

		badgeRichieste.setNew(true);
		badgeRichieste.setPrimaryKey(id);

		return badgeRichieste;
	}

	/**
	 * Removes the badge richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the badge richieste
	 * @return the badge richieste that was removed
	 * @throws NoSuchBadgeRichiesteException if a badge richieste with the primary key could not be found
	 */
	@Override
	public BadgeRichieste remove(long id) throws NoSuchBadgeRichiesteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the badge richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the badge richieste
	 * @return the badge richieste that was removed
	 * @throws NoSuchBadgeRichiesteException if a badge richieste with the primary key could not be found
	 */
	@Override
	public BadgeRichieste remove(Serializable primaryKey)
		throws NoSuchBadgeRichiesteException {
		Session session = null;

		try {
			session = openSession();

			BadgeRichieste badgeRichieste = (BadgeRichieste)session.get(BadgeRichiesteImpl.class,
					primaryKey);

			if (badgeRichieste == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBadgeRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(badgeRichieste);
		}
		catch (NoSuchBadgeRichiesteException nsee) {
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
	protected BadgeRichieste removeImpl(BadgeRichieste badgeRichieste) {
		badgeRichieste = toUnwrappedModel(badgeRichieste);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(badgeRichieste)) {
				badgeRichieste = (BadgeRichieste)session.get(BadgeRichiesteImpl.class,
						badgeRichieste.getPrimaryKeyObj());
			}

			if (badgeRichieste != null) {
				session.delete(badgeRichieste);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (badgeRichieste != null) {
			clearCache(badgeRichieste);
		}

		return badgeRichieste;
	}

	@Override
	public BadgeRichieste updateImpl(BadgeRichieste badgeRichieste) {
		badgeRichieste = toUnwrappedModel(badgeRichieste);

		boolean isNew = badgeRichieste.isNew();

		Session session = null;

		try {
			session = openSession();

			if (badgeRichieste.isNew()) {
				session.save(badgeRichieste);

				badgeRichieste.setNew(false);
			}
			else {
				badgeRichieste = (BadgeRichieste)session.merge(badgeRichieste);
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

		entityCache.putResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			BadgeRichiesteImpl.class, badgeRichieste.getPrimaryKey(),
			badgeRichieste, false);

		badgeRichieste.resetOriginalValues();

		return badgeRichieste;
	}

	protected BadgeRichieste toUnwrappedModel(BadgeRichieste badgeRichieste) {
		if (badgeRichieste instanceof BadgeRichiesteImpl) {
			return badgeRichieste;
		}

		BadgeRichiesteImpl badgeRichiesteImpl = new BadgeRichiesteImpl();

		badgeRichiesteImpl.setNew(badgeRichieste.isNew());
		badgeRichiesteImpl.setPrimaryKey(badgeRichieste.getPrimaryKey());

		badgeRichiesteImpl.setId(badgeRichieste.getId());
		badgeRichiesteImpl.setUtente(badgeRichieste.getUtente());
		badgeRichiesteImpl.setDettaglio_richiedente(badgeRichieste.getDettaglio_richiedente());
		badgeRichiesteImpl.setCognome(badgeRichieste.getCognome());
		badgeRichiesteImpl.setNome(badgeRichieste.getNome());
		badgeRichiesteImpl.setLuogo_nascita(badgeRichieste.getLuogo_nascita());
		badgeRichiesteImpl.setData_nascita(badgeRichieste.getData_nascita());
		badgeRichiesteImpl.setCodice_fiscale(badgeRichieste.getCodice_fiscale());
		badgeRichiesteImpl.setNumerobadge(badgeRichieste.getNumerobadge());
		badgeRichiesteImpl.setAllegatoUuid(badgeRichieste.getAllegatoUuid());
		badgeRichiesteImpl.setOperazione(badgeRichieste.getOperazione());
		badgeRichiesteImpl.setData_richiesta(badgeRichieste.getData_richiesta());
		badgeRichiesteImpl.setProcedura(badgeRichieste.getProcedura());
		badgeRichiesteImpl.setDisattivazione(badgeRichieste.getDisattivazione());

		return badgeRichiesteImpl;
	}

	/**
	 * Returns the badge richieste with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge richieste
	 * @return the badge richieste
	 * @throws NoSuchBadgeRichiesteException if a badge richieste with the primary key could not be found
	 */
	@Override
	public BadgeRichieste findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBadgeRichiesteException {
		BadgeRichieste badgeRichieste = fetchByPrimaryKey(primaryKey);

		if (badgeRichieste == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBadgeRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return badgeRichieste;
	}

	/**
	 * Returns the badge richieste with the primary key or throws a {@link NoSuchBadgeRichiesteException} if it could not be found.
	 *
	 * @param id the primary key of the badge richieste
	 * @return the badge richieste
	 * @throws NoSuchBadgeRichiesteException if a badge richieste with the primary key could not be found
	 */
	@Override
	public BadgeRichieste findByPrimaryKey(long id)
		throws NoSuchBadgeRichiesteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the badge richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge richieste
	 * @return the badge richieste, or <code>null</code> if a badge richieste with the primary key could not be found
	 */
	@Override
	public BadgeRichieste fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
				BadgeRichiesteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BadgeRichieste badgeRichieste = (BadgeRichieste)serializable;

		if (badgeRichieste == null) {
			Session session = null;

			try {
				session = openSession();

				badgeRichieste = (BadgeRichieste)session.get(BadgeRichiesteImpl.class,
						primaryKey);

				if (badgeRichieste != null) {
					cacheResult(badgeRichieste);
				}
				else {
					entityCache.putResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
						BadgeRichiesteImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
					BadgeRichiesteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return badgeRichieste;
	}

	/**
	 * Returns the badge richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the badge richieste
	 * @return the badge richieste, or <code>null</code> if a badge richieste with the primary key could not be found
	 */
	@Override
	public BadgeRichieste fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, BadgeRichieste> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BadgeRichieste> map = new HashMap<Serializable, BadgeRichieste>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BadgeRichieste badgeRichieste = fetchByPrimaryKey(primaryKey);

			if (badgeRichieste != null) {
				map.put(primaryKey, badgeRichieste);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
					BadgeRichiesteImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BadgeRichieste)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BADGERICHIESTE_WHERE_PKS_IN);

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

			for (BadgeRichieste badgeRichieste : (List<BadgeRichieste>)q.list()) {
				map.put(badgeRichieste.getPrimaryKeyObj(), badgeRichieste);

				cacheResult(badgeRichieste);

				uncachedPrimaryKeys.remove(badgeRichieste.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BadgeRichiesteModelImpl.ENTITY_CACHE_ENABLED,
					BadgeRichiesteImpl.class, primaryKey, nullModel);
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
	 * Returns all the badge richiestes.
	 *
	 * @return the badge richiestes
	 */
	@Override
	public List<BadgeRichieste> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the badge richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of badge richiestes
	 * @param end the upper bound of the range of badge richiestes (not inclusive)
	 * @return the range of badge richiestes
	 */
	@Override
	public List<BadgeRichieste> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the badge richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of badge richiestes
	 * @param end the upper bound of the range of badge richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of badge richiestes
	 */
	@Override
	public List<BadgeRichieste> findAll(int start, int end,
		OrderByComparator<BadgeRichieste> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the badge richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of badge richiestes
	 * @param end the upper bound of the range of badge richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of badge richiestes
	 */
	@Override
	public List<BadgeRichieste> findAll(int start, int end,
		OrderByComparator<BadgeRichieste> orderByComparator,
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

		List<BadgeRichieste> list = null;

		if (retrieveFromCache) {
			list = (List<BadgeRichieste>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BADGERICHIESTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BADGERICHIESTE;

				if (pagination) {
					sql = sql.concat(BadgeRichiesteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BadgeRichieste>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BadgeRichieste>)QueryUtil.list(q,
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
	 * Removes all the badge richiestes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BadgeRichieste badgeRichieste : findAll()) {
			remove(badgeRichieste);
		}
	}

	/**
	 * Returns the number of badge richiestes.
	 *
	 * @return the number of badge richiestes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BADGERICHIESTE);

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
		return BadgeRichiesteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the badge richieste persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BadgeRichiesteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BADGERICHIESTE = "SELECT badgeRichieste FROM BadgeRichieste badgeRichieste";
	private static final String _SQL_SELECT_BADGERICHIESTE_WHERE_PKS_IN = "SELECT badgeRichieste FROM BadgeRichieste badgeRichieste WHERE id_ IN (";
	private static final String _SQL_COUNT_BADGERICHIESTE = "SELECT COUNT(badgeRichieste) FROM BadgeRichieste badgeRichieste";
	private static final String _ORDER_BY_ENTITY_ALIAS = "badgeRichieste.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BadgeRichieste exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(BadgeRichiestePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}