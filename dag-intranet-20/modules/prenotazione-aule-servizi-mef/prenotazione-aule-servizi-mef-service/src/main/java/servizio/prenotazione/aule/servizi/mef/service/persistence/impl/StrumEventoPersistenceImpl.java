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

package servizio.prenotazione.aule.servizi.mef.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumEventoException;
import servizio.prenotazione.aule.servizi.mef.model.StrumEvento;
import servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoImpl;
import servizio.prenotazione.aule.servizi.mef.model.impl.StrumEventoModelImpl;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPK;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the strum evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumEventoPersistence
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.StrumEventoUtil
 * @generated
 */
@ProviderType
public class StrumEventoPersistenceImpl extends BasePersistenceImpl<StrumEvento>
	implements StrumEventoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StrumEventoUtil} to access the strum evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StrumEventoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumEventoModelImpl.FINDER_CACHE_ENABLED, StrumEventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumEventoModelImpl.FINDER_CACHE_ENABLED, StrumEventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumEventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StrumEventoPersistenceImpl() {
		setModelClass(StrumEvento.class);
	}

	/**
	 * Caches the strum evento in the entity cache if it is enabled.
	 *
	 * @param strumEvento the strum evento
	 */
	@Override
	public void cacheResult(StrumEvento strumEvento) {
		entityCache.putResult(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumEventoImpl.class, strumEvento.getPrimaryKey(), strumEvento);

		strumEvento.resetOriginalValues();
	}

	/**
	 * Caches the strum eventos in the entity cache if it is enabled.
	 *
	 * @param strumEventos the strum eventos
	 */
	@Override
	public void cacheResult(List<StrumEvento> strumEventos) {
		for (StrumEvento strumEvento : strumEventos) {
			if (entityCache.getResult(
						StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
						StrumEventoImpl.class, strumEvento.getPrimaryKey()) == null) {
				cacheResult(strumEvento);
			}
			else {
				strumEvento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all strum eventos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StrumEventoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the strum evento.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StrumEvento strumEvento) {
		entityCache.removeResult(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumEventoImpl.class, strumEvento.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StrumEvento> strumEventos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StrumEvento strumEvento : strumEventos) {
			entityCache.removeResult(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
				StrumEventoImpl.class, strumEvento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new strum evento with the primary key. Does not add the strum evento to the database.
	 *
	 * @param strumEventoPK the primary key for the new strum evento
	 * @return the new strum evento
	 */
	@Override
	public StrumEvento create(StrumEventoPK strumEventoPK) {
		StrumEvento strumEvento = new StrumEventoImpl();

		strumEvento.setNew(true);
		strumEvento.setPrimaryKey(strumEventoPK);

		return strumEvento;
	}

	/**
	 * Removes the strum evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param strumEventoPK the primary key of the strum evento
	 * @return the strum evento that was removed
	 * @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	 */
	@Override
	public StrumEvento remove(StrumEventoPK strumEventoPK)
		throws NoSuchStrumEventoException {
		return remove((Serializable)strumEventoPK);
	}

	/**
	 * Removes the strum evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the strum evento
	 * @return the strum evento that was removed
	 * @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	 */
	@Override
	public StrumEvento remove(Serializable primaryKey)
		throws NoSuchStrumEventoException {
		Session session = null;

		try {
			session = openSession();

			StrumEvento strumEvento = (StrumEvento)session.get(StrumEventoImpl.class,
					primaryKey);

			if (strumEvento == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStrumEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(strumEvento);
		}
		catch (NoSuchStrumEventoException nsee) {
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
	protected StrumEvento removeImpl(StrumEvento strumEvento) {
		strumEvento = toUnwrappedModel(strumEvento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(strumEvento)) {
				strumEvento = (StrumEvento)session.get(StrumEventoImpl.class,
						strumEvento.getPrimaryKeyObj());
			}

			if (strumEvento != null) {
				session.delete(strumEvento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (strumEvento != null) {
			clearCache(strumEvento);
		}

		return strumEvento;
	}

	@Override
	public StrumEvento updateImpl(StrumEvento strumEvento) {
		strumEvento = toUnwrappedModel(strumEvento);

		boolean isNew = strumEvento.isNew();

		Session session = null;

		try {
			session = openSession();

			if (strumEvento.isNew()) {
				session.save(strumEvento);

				strumEvento.setNew(false);
			}
			else {
				strumEvento = (StrumEvento)session.merge(strumEvento);
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

		entityCache.putResult(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumEventoImpl.class, strumEvento.getPrimaryKey(), strumEvento,
			false);

		strumEvento.resetOriginalValues();

		return strumEvento;
	}

	protected StrumEvento toUnwrappedModel(StrumEvento strumEvento) {
		if (strumEvento instanceof StrumEventoImpl) {
			return strumEvento;
		}

		StrumEventoImpl strumEventoImpl = new StrumEventoImpl();

		strumEventoImpl.setNew(strumEvento.isNew());
		strumEventoImpl.setPrimaryKey(strumEvento.getPrimaryKey());

		strumEventoImpl.setId_strum(strumEvento.getId_strum());
		strumEventoImpl.setId_sala(strumEvento.getId_sala());
		strumEventoImpl.setEmail_ref(strumEvento.getEmail_ref());

		return strumEventoImpl;
	}

	/**
	 * Returns the strum evento with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the strum evento
	 * @return the strum evento
	 * @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	 */
	@Override
	public StrumEvento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStrumEventoException {
		StrumEvento strumEvento = fetchByPrimaryKey(primaryKey);

		if (strumEvento == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStrumEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return strumEvento;
	}

	/**
	 * Returns the strum evento with the primary key or throws a {@link NoSuchStrumEventoException} if it could not be found.
	 *
	 * @param strumEventoPK the primary key of the strum evento
	 * @return the strum evento
	 * @throws NoSuchStrumEventoException if a strum evento with the primary key could not be found
	 */
	@Override
	public StrumEvento findByPrimaryKey(StrumEventoPK strumEventoPK)
		throws NoSuchStrumEventoException {
		return findByPrimaryKey((Serializable)strumEventoPK);
	}

	/**
	 * Returns the strum evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the strum evento
	 * @return the strum evento, or <code>null</code> if a strum evento with the primary key could not be found
	 */
	@Override
	public StrumEvento fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
				StrumEventoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StrumEvento strumEvento = (StrumEvento)serializable;

		if (strumEvento == null) {
			Session session = null;

			try {
				session = openSession();

				strumEvento = (StrumEvento)session.get(StrumEventoImpl.class,
						primaryKey);

				if (strumEvento != null) {
					cacheResult(strumEvento);
				}
				else {
					entityCache.putResult(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
						StrumEventoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StrumEventoModelImpl.ENTITY_CACHE_ENABLED,
					StrumEventoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return strumEvento;
	}

	/**
	 * Returns the strum evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param strumEventoPK the primary key of the strum evento
	 * @return the strum evento, or <code>null</code> if a strum evento with the primary key could not be found
	 */
	@Override
	public StrumEvento fetchByPrimaryKey(StrumEventoPK strumEventoPK) {
		return fetchByPrimaryKey((Serializable)strumEventoPK);
	}

	@Override
	public Map<Serializable, StrumEvento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StrumEvento> map = new HashMap<Serializable, StrumEvento>();

		for (Serializable primaryKey : primaryKeys) {
			StrumEvento strumEvento = fetchByPrimaryKey(primaryKey);

			if (strumEvento != null) {
				map.put(primaryKey, strumEvento);
			}
		}

		return map;
	}

	/**
	 * Returns all the strum eventos.
	 *
	 * @return the strum eventos
	 */
	@Override
	public List<StrumEvento> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strum eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strum eventos
	 * @param end the upper bound of the range of strum eventos (not inclusive)
	 * @return the range of strum eventos
	 */
	@Override
	public List<StrumEvento> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the strum eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strum eventos
	 * @param end the upper bound of the range of strum eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of strum eventos
	 */
	@Override
	public List<StrumEvento> findAll(int start, int end,
		OrderByComparator<StrumEvento> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strum eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strum eventos
	 * @param end the upper bound of the range of strum eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of strum eventos
	 */
	@Override
	public List<StrumEvento> findAll(int start, int end,
		OrderByComparator<StrumEvento> orderByComparator,
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

		List<StrumEvento> list = null;

		if (retrieveFromCache) {
			list = (List<StrumEvento>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STRUMEVENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STRUMEVENTO;

				if (pagination) {
					sql = sql.concat(StrumEventoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StrumEvento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StrumEvento>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the strum eventos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StrumEvento strumEvento : findAll()) {
			remove(strumEvento);
		}
	}

	/**
	 * Returns the number of strum eventos.
	 *
	 * @return the number of strum eventos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STRUMEVENTO);

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
		return StrumEventoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the strum evento persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StrumEventoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STRUMEVENTO = "SELECT strumEvento FROM StrumEvento strumEvento";
	private static final String _SQL_COUNT_STRUMEVENTO = "SELECT COUNT(strumEvento) FROM StrumEvento strumEvento";
	private static final String _ORDER_BY_ENTITY_ALIAS = "strumEvento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StrumEvento exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(StrumEventoPersistenceImpl.class);
}