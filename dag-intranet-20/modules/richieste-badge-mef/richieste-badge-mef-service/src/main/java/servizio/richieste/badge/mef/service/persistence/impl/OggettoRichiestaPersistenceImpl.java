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

package servizio.richieste.badge.mef.service.persistence.impl;

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

import servizio.richieste.badge.mef.exception.NoSuchOggettoRichiestaException;
import servizio.richieste.badge.mef.model.OggettoRichiesta;
import servizio.richieste.badge.mef.model.impl.OggettoRichiestaImpl;
import servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl;
import servizio.richieste.badge.mef.service.persistence.OggettoRichiestaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the oggetto richiesta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OggettoRichiestaPersistence
 * @see servizio.richieste.badge.mef.service.persistence.OggettoRichiestaUtil
 * @generated
 */
@ProviderType
public class OggettoRichiestaPersistenceImpl extends BasePersistenceImpl<OggettoRichiesta>
	implements OggettoRichiestaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OggettoRichiestaUtil} to access the oggetto richiesta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OggettoRichiestaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			OggettoRichiestaModelImpl.FINDER_CACHE_ENABLED,
			OggettoRichiestaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			OggettoRichiestaModelImpl.FINDER_CACHE_ENABLED,
			OggettoRichiestaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			OggettoRichiestaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OggettoRichiestaPersistenceImpl() {
		setModelClass(OggettoRichiesta.class);
	}

	/**
	 * Caches the oggetto richiesta in the entity cache if it is enabled.
	 *
	 * @param oggettoRichiesta the oggetto richiesta
	 */
	@Override
	public void cacheResult(OggettoRichiesta oggettoRichiesta) {
		entityCache.putResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			OggettoRichiestaImpl.class, oggettoRichiesta.getPrimaryKey(),
			oggettoRichiesta);

		oggettoRichiesta.resetOriginalValues();
	}

	/**
	 * Caches the oggetto richiestas in the entity cache if it is enabled.
	 *
	 * @param oggettoRichiestas the oggetto richiestas
	 */
	@Override
	public void cacheResult(List<OggettoRichiesta> oggettoRichiestas) {
		for (OggettoRichiesta oggettoRichiesta : oggettoRichiestas) {
			if (entityCache.getResult(
						OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
						OggettoRichiestaImpl.class,
						oggettoRichiesta.getPrimaryKey()) == null) {
				cacheResult(oggettoRichiesta);
			}
			else {
				oggettoRichiesta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all oggetto richiestas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OggettoRichiestaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the oggetto richiesta.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OggettoRichiesta oggettoRichiesta) {
		entityCache.removeResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			OggettoRichiestaImpl.class, oggettoRichiesta.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OggettoRichiesta> oggettoRichiestas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OggettoRichiesta oggettoRichiesta : oggettoRichiestas) {
			entityCache.removeResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
				OggettoRichiestaImpl.class, oggettoRichiesta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new oggetto richiesta with the primary key. Does not add the oggetto richiesta to the database.
	 *
	 * @param id_oggetto the primary key for the new oggetto richiesta
	 * @return the new oggetto richiesta
	 */
	@Override
	public OggettoRichiesta create(long id_oggetto) {
		OggettoRichiesta oggettoRichiesta = new OggettoRichiestaImpl();

		oggettoRichiesta.setNew(true);
		oggettoRichiesta.setPrimaryKey(id_oggetto);

		return oggettoRichiesta;
	}

	/**
	 * Removes the oggetto richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_oggetto the primary key of the oggetto richiesta
	 * @return the oggetto richiesta that was removed
	 * @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	 */
	@Override
	public OggettoRichiesta remove(long id_oggetto)
		throws NoSuchOggettoRichiestaException {
		return remove((Serializable)id_oggetto);
	}

	/**
	 * Removes the oggetto richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the oggetto richiesta
	 * @return the oggetto richiesta that was removed
	 * @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	 */
	@Override
	public OggettoRichiesta remove(Serializable primaryKey)
		throws NoSuchOggettoRichiestaException {
		Session session = null;

		try {
			session = openSession();

			OggettoRichiesta oggettoRichiesta = (OggettoRichiesta)session.get(OggettoRichiestaImpl.class,
					primaryKey);

			if (oggettoRichiesta == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOggettoRichiestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(oggettoRichiesta);
		}
		catch (NoSuchOggettoRichiestaException nsee) {
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
	protected OggettoRichiesta removeImpl(OggettoRichiesta oggettoRichiesta) {
		oggettoRichiesta = toUnwrappedModel(oggettoRichiesta);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oggettoRichiesta)) {
				oggettoRichiesta = (OggettoRichiesta)session.get(OggettoRichiestaImpl.class,
						oggettoRichiesta.getPrimaryKeyObj());
			}

			if (oggettoRichiesta != null) {
				session.delete(oggettoRichiesta);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (oggettoRichiesta != null) {
			clearCache(oggettoRichiesta);
		}

		return oggettoRichiesta;
	}

	@Override
	public OggettoRichiesta updateImpl(OggettoRichiesta oggettoRichiesta) {
		oggettoRichiesta = toUnwrappedModel(oggettoRichiesta);

		boolean isNew = oggettoRichiesta.isNew();

		Session session = null;

		try {
			session = openSession();

			if (oggettoRichiesta.isNew()) {
				session.save(oggettoRichiesta);

				oggettoRichiesta.setNew(false);
			}
			else {
				oggettoRichiesta = (OggettoRichiesta)session.merge(oggettoRichiesta);
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

		entityCache.putResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
			OggettoRichiestaImpl.class, oggettoRichiesta.getPrimaryKey(),
			oggettoRichiesta, false);

		oggettoRichiesta.resetOriginalValues();

		return oggettoRichiesta;
	}

	protected OggettoRichiesta toUnwrappedModel(
		OggettoRichiesta oggettoRichiesta) {
		if (oggettoRichiesta instanceof OggettoRichiestaImpl) {
			return oggettoRichiesta;
		}

		OggettoRichiestaImpl oggettoRichiestaImpl = new OggettoRichiestaImpl();

		oggettoRichiestaImpl.setNew(oggettoRichiesta.isNew());
		oggettoRichiestaImpl.setPrimaryKey(oggettoRichiesta.getPrimaryKey());

		oggettoRichiestaImpl.setId_oggetto(oggettoRichiesta.getId_oggetto());
		oggettoRichiestaImpl.setDescrizione_oggetto(oggettoRichiesta.getDescrizione_oggetto());

		return oggettoRichiestaImpl;
	}

	/**
	 * Returns the oggetto richiesta with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the oggetto richiesta
	 * @return the oggetto richiesta
	 * @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	 */
	@Override
	public OggettoRichiesta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOggettoRichiestaException {
		OggettoRichiesta oggettoRichiesta = fetchByPrimaryKey(primaryKey);

		if (oggettoRichiesta == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOggettoRichiestaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return oggettoRichiesta;
	}

	/**
	 * Returns the oggetto richiesta with the primary key or throws a {@link NoSuchOggettoRichiestaException} if it could not be found.
	 *
	 * @param id_oggetto the primary key of the oggetto richiesta
	 * @return the oggetto richiesta
	 * @throws NoSuchOggettoRichiestaException if a oggetto richiesta with the primary key could not be found
	 */
	@Override
	public OggettoRichiesta findByPrimaryKey(long id_oggetto)
		throws NoSuchOggettoRichiestaException {
		return findByPrimaryKey((Serializable)id_oggetto);
	}

	/**
	 * Returns the oggetto richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the oggetto richiesta
	 * @return the oggetto richiesta, or <code>null</code> if a oggetto richiesta with the primary key could not be found
	 */
	@Override
	public OggettoRichiesta fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
				OggettoRichiestaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		OggettoRichiesta oggettoRichiesta = (OggettoRichiesta)serializable;

		if (oggettoRichiesta == null) {
			Session session = null;

			try {
				session = openSession();

				oggettoRichiesta = (OggettoRichiesta)session.get(OggettoRichiestaImpl.class,
						primaryKey);

				if (oggettoRichiesta != null) {
					cacheResult(oggettoRichiesta);
				}
				else {
					entityCache.putResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
						OggettoRichiestaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
					OggettoRichiestaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return oggettoRichiesta;
	}

	/**
	 * Returns the oggetto richiesta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_oggetto the primary key of the oggetto richiesta
	 * @return the oggetto richiesta, or <code>null</code> if a oggetto richiesta with the primary key could not be found
	 */
	@Override
	public OggettoRichiesta fetchByPrimaryKey(long id_oggetto) {
		return fetchByPrimaryKey((Serializable)id_oggetto);
	}

	@Override
	public Map<Serializable, OggettoRichiesta> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, OggettoRichiesta> map = new HashMap<Serializable, OggettoRichiesta>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			OggettoRichiesta oggettoRichiesta = fetchByPrimaryKey(primaryKey);

			if (oggettoRichiesta != null) {
				map.put(primaryKey, oggettoRichiesta);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
					OggettoRichiestaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (OggettoRichiesta)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OGGETTORICHIESTA_WHERE_PKS_IN);

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

			for (OggettoRichiesta oggettoRichiesta : (List<OggettoRichiesta>)q.list()) {
				map.put(oggettoRichiesta.getPrimaryKeyObj(), oggettoRichiesta);

				cacheResult(oggettoRichiesta);

				uncachedPrimaryKeys.remove(oggettoRichiesta.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OggettoRichiestaModelImpl.ENTITY_CACHE_ENABLED,
					OggettoRichiestaImpl.class, primaryKey, nullModel);
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
	 * Returns all the oggetto richiestas.
	 *
	 * @return the oggetto richiestas
	 */
	@Override
	public List<OggettoRichiesta> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oggetto richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oggetto richiestas
	 * @param end the upper bound of the range of oggetto richiestas (not inclusive)
	 * @return the range of oggetto richiestas
	 */
	@Override
	public List<OggettoRichiesta> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the oggetto richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oggetto richiestas
	 * @param end the upper bound of the range of oggetto richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oggetto richiestas
	 */
	@Override
	public List<OggettoRichiesta> findAll(int start, int end,
		OrderByComparator<OggettoRichiesta> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the oggetto richiestas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of oggetto richiestas
	 * @param end the upper bound of the range of oggetto richiestas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of oggetto richiestas
	 */
	@Override
	public List<OggettoRichiesta> findAll(int start, int end,
		OrderByComparator<OggettoRichiesta> orderByComparator,
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

		List<OggettoRichiesta> list = null;

		if (retrieveFromCache) {
			list = (List<OggettoRichiesta>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OGGETTORICHIESTA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OGGETTORICHIESTA;

				if (pagination) {
					sql = sql.concat(OggettoRichiestaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OggettoRichiesta>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OggettoRichiesta>)QueryUtil.list(q,
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
	 * Removes all the oggetto richiestas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OggettoRichiesta oggettoRichiesta : findAll()) {
			remove(oggettoRichiesta);
		}
	}

	/**
	 * Returns the number of oggetto richiestas.
	 *
	 * @return the number of oggetto richiestas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OGGETTORICHIESTA);

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
		return OggettoRichiestaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the oggetto richiesta persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OggettoRichiestaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_OGGETTORICHIESTA = "SELECT oggettoRichiesta FROM OggettoRichiesta oggettoRichiesta";
	private static final String _SQL_SELECT_OGGETTORICHIESTA_WHERE_PKS_IN = "SELECT oggettoRichiesta FROM OggettoRichiesta oggettoRichiesta WHERE id_oggetto IN (";
	private static final String _SQL_COUNT_OGGETTORICHIESTA = "SELECT COUNT(oggettoRichiesta) FROM OggettoRichiesta oggettoRichiesta";
	private static final String _ORDER_BY_ENTITY_ALIAS = "oggettoRichiesta.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OggettoRichiesta exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(OggettoRichiestaPersistenceImpl.class);
}