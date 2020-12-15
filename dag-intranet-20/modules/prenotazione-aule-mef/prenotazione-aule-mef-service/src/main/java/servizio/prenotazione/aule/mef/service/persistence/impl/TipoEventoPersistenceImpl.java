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

package servizio.prenotazione.aule.mef.service.persistence.impl;

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

import servizio.prenotazione.aule.mef.exception.NoSuchTipoEventoException;
import servizio.prenotazione.aule.mef.model.TipoEvento;
import servizio.prenotazione.aule.mef.model.impl.TipoEventoImpl;
import servizio.prenotazione.aule.mef.model.impl.TipoEventoModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.TipoEventoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tipo evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoEventoPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.TipoEventoUtil
 * @generated
 */
@ProviderType
public class TipoEventoPersistenceImpl extends BasePersistenceImpl<TipoEvento>
	implements TipoEventoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipoEventoUtil} to access the tipo evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipoEventoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
			TipoEventoModelImpl.FINDER_CACHE_ENABLED, TipoEventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
			TipoEventoModelImpl.FINDER_CACHE_ENABLED, TipoEventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
			TipoEventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TipoEventoPersistenceImpl() {
		setModelClass(TipoEvento.class);
	}

	/**
	 * Caches the tipo evento in the entity cache if it is enabled.
	 *
	 * @param tipoEvento the tipo evento
	 */
	@Override
	public void cacheResult(TipoEvento tipoEvento) {
		entityCache.putResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
			TipoEventoImpl.class, tipoEvento.getPrimaryKey(), tipoEvento);

		tipoEvento.resetOriginalValues();
	}

	/**
	 * Caches the tipo eventos in the entity cache if it is enabled.
	 *
	 * @param tipoEventos the tipo eventos
	 */
	@Override
	public void cacheResult(List<TipoEvento> tipoEventos) {
		for (TipoEvento tipoEvento : tipoEventos) {
			if (entityCache.getResult(
						TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
						TipoEventoImpl.class, tipoEvento.getPrimaryKey()) == null) {
				cacheResult(tipoEvento);
			}
			else {
				tipoEvento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipo eventos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipoEventoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipo evento.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipoEvento tipoEvento) {
		entityCache.removeResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
			TipoEventoImpl.class, tipoEvento.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipoEvento> tipoEventos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipoEvento tipoEvento : tipoEventos) {
			entityCache.removeResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
				TipoEventoImpl.class, tipoEvento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	 *
	 * @param id_evento the primary key for the new tipo evento
	 * @return the new tipo evento
	 */
	@Override
	public TipoEvento create(long id_evento) {
		TipoEvento tipoEvento = new TipoEventoImpl();

		tipoEvento.setNew(true);
		tipoEvento.setPrimaryKey(id_evento);

		return tipoEvento;
	}

	/**
	 * Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_evento the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento remove(long id_evento) throws NoSuchTipoEventoException {
		return remove((Serializable)id_evento);
	}

	/**
	 * Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento remove(Serializable primaryKey)
		throws NoSuchTipoEventoException {
		Session session = null;

		try {
			session = openSession();

			TipoEvento tipoEvento = (TipoEvento)session.get(TipoEventoImpl.class,
					primaryKey);

			if (tipoEvento == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipoEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipoEvento);
		}
		catch (NoSuchTipoEventoException nsee) {
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
	protected TipoEvento removeImpl(TipoEvento tipoEvento) {
		tipoEvento = toUnwrappedModel(tipoEvento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipoEvento)) {
				tipoEvento = (TipoEvento)session.get(TipoEventoImpl.class,
						tipoEvento.getPrimaryKeyObj());
			}

			if (tipoEvento != null) {
				session.delete(tipoEvento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipoEvento != null) {
			clearCache(tipoEvento);
		}

		return tipoEvento;
	}

	@Override
	public TipoEvento updateImpl(TipoEvento tipoEvento) {
		tipoEvento = toUnwrappedModel(tipoEvento);

		boolean isNew = tipoEvento.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tipoEvento.isNew()) {
				session.save(tipoEvento);

				tipoEvento.setNew(false);
			}
			else {
				tipoEvento = (TipoEvento)session.merge(tipoEvento);
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

		entityCache.putResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
			TipoEventoImpl.class, tipoEvento.getPrimaryKey(), tipoEvento, false);

		tipoEvento.resetOriginalValues();

		return tipoEvento;
	}

	protected TipoEvento toUnwrappedModel(TipoEvento tipoEvento) {
		if (tipoEvento instanceof TipoEventoImpl) {
			return tipoEvento;
		}

		TipoEventoImpl tipoEventoImpl = new TipoEventoImpl();

		tipoEventoImpl.setNew(tipoEvento.isNew());
		tipoEventoImpl.setPrimaryKey(tipoEvento.getPrimaryKey());

		tipoEventoImpl.setId_evento(tipoEvento.getId_evento());
		tipoEventoImpl.setDesc_evento(tipoEvento.getDesc_evento());

		return tipoEventoImpl;
	}

	/**
	 * Returns the tipo evento with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipoEventoException {
		TipoEvento tipoEvento = fetchByPrimaryKey(primaryKey);

		if (tipoEvento == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipoEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipoEvento;
	}

	/**
	 * Returns the tipo evento with the primary key or throws a {@link NoSuchTipoEventoException} if it could not be found.
	 *
	 * @param id_evento the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento findByPrimaryKey(long id_evento)
		throws NoSuchTipoEventoException {
		return findByPrimaryKey((Serializable)id_evento);
	}

	/**
	 * Returns the tipo evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo evento
	 * @return the tipo evento, or <code>null</code> if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
				TipoEventoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipoEvento tipoEvento = (TipoEvento)serializable;

		if (tipoEvento == null) {
			Session session = null;

			try {
				session = openSession();

				tipoEvento = (TipoEvento)session.get(TipoEventoImpl.class,
						primaryKey);

				if (tipoEvento != null) {
					cacheResult(tipoEvento);
				}
				else {
					entityCache.putResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
						TipoEventoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
					TipoEventoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipoEvento;
	}

	/**
	 * Returns the tipo evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_evento the primary key of the tipo evento
	 * @return the tipo evento, or <code>null</code> if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento fetchByPrimaryKey(long id_evento) {
		return fetchByPrimaryKey((Serializable)id_evento);
	}

	@Override
	public Map<Serializable, TipoEvento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipoEvento> map = new HashMap<Serializable, TipoEvento>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipoEvento tipoEvento = fetchByPrimaryKey(primaryKey);

			if (tipoEvento != null) {
				map.put(primaryKey, tipoEvento);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
					TipoEventoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipoEvento)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPOEVENTO_WHERE_PKS_IN);

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

			for (TipoEvento tipoEvento : (List<TipoEvento>)q.list()) {
				map.put(tipoEvento.getPrimaryKeyObj(), tipoEvento);

				cacheResult(tipoEvento);

				uncachedPrimaryKeys.remove(tipoEvento.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipoEventoModelImpl.ENTITY_CACHE_ENABLED,
					TipoEventoImpl.class, primaryKey, nullModel);
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
	 * Returns all the tipo eventos.
	 *
	 * @return the tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll(int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tipo eventos
	 */
	@Override
	public List<TipoEvento> findAll(int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
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

		List<TipoEvento> list = null;

		if (retrieveFromCache) {
			list = (List<TipoEvento>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPOEVENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOEVENTO;

				if (pagination) {
					sql = sql.concat(TipoEventoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipoEvento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipoEvento>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tipo eventos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipoEvento tipoEvento : findAll()) {
			remove(tipoEvento);
		}
	}

	/**
	 * Returns the number of tipo eventos.
	 *
	 * @return the number of tipo eventos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPOEVENTO);

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
		return TipoEventoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipo evento persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipoEventoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPOEVENTO = "SELECT tipoEvento FROM TipoEvento tipoEvento";
	private static final String _SQL_SELECT_TIPOEVENTO_WHERE_PKS_IN = "SELECT tipoEvento FROM TipoEvento tipoEvento WHERE id_evento IN (";
	private static final String _SQL_COUNT_TIPOEVENTO = "SELECT COUNT(tipoEvento) FROM TipoEvento tipoEvento";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipoEvento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipoEvento exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TipoEventoPersistenceImpl.class);
}