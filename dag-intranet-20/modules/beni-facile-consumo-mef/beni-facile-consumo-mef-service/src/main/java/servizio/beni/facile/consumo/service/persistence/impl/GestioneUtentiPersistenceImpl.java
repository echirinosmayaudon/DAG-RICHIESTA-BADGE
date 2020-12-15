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

package servizio.beni.facile.consumo.service.persistence.impl;

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

import servizio.beni.facile.consumo.exception.NoSuchGestioneUtentiException;
import servizio.beni.facile.consumo.model.GestioneUtenti;
import servizio.beni.facile.consumo.model.impl.GestioneUtentiImpl;
import servizio.beni.facile.consumo.model.impl.GestioneUtentiModelImpl;
import servizio.beni.facile.consumo.service.persistence.GestioneUtentiPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the gestione utenti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtentiPersistence
 * @see servizio.beni.facile.consumo.service.persistence.GestioneUtentiUtil
 * @generated
 */
@ProviderType
public class GestioneUtentiPersistenceImpl extends BasePersistenceImpl<GestioneUtenti>
	implements GestioneUtentiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GestioneUtentiUtil} to access the gestione utenti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GestioneUtentiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
			GestioneUtentiModelImpl.FINDER_CACHE_ENABLED,
			GestioneUtentiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
			GestioneUtentiModelImpl.FINDER_CACHE_ENABLED,
			GestioneUtentiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
			GestioneUtentiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GestioneUtentiPersistenceImpl() {
		setModelClass(GestioneUtenti.class);
	}

	/**
	 * Caches the gestione utenti in the entity cache if it is enabled.
	 *
	 * @param gestioneUtenti the gestione utenti
	 */
	@Override
	public void cacheResult(GestioneUtenti gestioneUtenti) {
		entityCache.putResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
			GestioneUtentiImpl.class, gestioneUtenti.getPrimaryKey(),
			gestioneUtenti);

		gestioneUtenti.resetOriginalValues();
	}

	/**
	 * Caches the gestione utentis in the entity cache if it is enabled.
	 *
	 * @param gestioneUtentis the gestione utentis
	 */
	@Override
	public void cacheResult(List<GestioneUtenti> gestioneUtentis) {
		for (GestioneUtenti gestioneUtenti : gestioneUtentis) {
			if (entityCache.getResult(
						GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
						GestioneUtentiImpl.class, gestioneUtenti.getPrimaryKey()) == null) {
				cacheResult(gestioneUtenti);
			}
			else {
				gestioneUtenti.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gestione utentis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GestioneUtentiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gestione utenti.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GestioneUtenti gestioneUtenti) {
		entityCache.removeResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
			GestioneUtentiImpl.class, gestioneUtenti.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GestioneUtenti> gestioneUtentis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GestioneUtenti gestioneUtenti : gestioneUtentis) {
			entityCache.removeResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
				GestioneUtentiImpl.class, gestioneUtenti.getPrimaryKey());
		}
	}

	/**
	 * Creates a new gestione utenti with the primary key. Does not add the gestione utenti to the database.
	 *
	 * @param id the primary key for the new gestione utenti
	 * @return the new gestione utenti
	 */
	@Override
	public GestioneUtenti create(long id) {
		GestioneUtenti gestioneUtenti = new GestioneUtentiImpl();

		gestioneUtenti.setNew(true);
		gestioneUtenti.setPrimaryKey(id);

		return gestioneUtenti;
	}

	/**
	 * Removes the gestione utenti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gestione utenti
	 * @return the gestione utenti that was removed
	 * @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	 */
	@Override
	public GestioneUtenti remove(long id) throws NoSuchGestioneUtentiException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the gestione utenti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gestione utenti
	 * @return the gestione utenti that was removed
	 * @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	 */
	@Override
	public GestioneUtenti remove(Serializable primaryKey)
		throws NoSuchGestioneUtentiException {
		Session session = null;

		try {
			session = openSession();

			GestioneUtenti gestioneUtenti = (GestioneUtenti)session.get(GestioneUtentiImpl.class,
					primaryKey);

			if (gestioneUtenti == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGestioneUtentiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gestioneUtenti);
		}
		catch (NoSuchGestioneUtentiException nsee) {
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
	protected GestioneUtenti removeImpl(GestioneUtenti gestioneUtenti) {
		gestioneUtenti = toUnwrappedModel(gestioneUtenti);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gestioneUtenti)) {
				gestioneUtenti = (GestioneUtenti)session.get(GestioneUtentiImpl.class,
						gestioneUtenti.getPrimaryKeyObj());
			}

			if (gestioneUtenti != null) {
				session.delete(gestioneUtenti);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gestioneUtenti != null) {
			clearCache(gestioneUtenti);
		}

		return gestioneUtenti;
	}

	@Override
	public GestioneUtenti updateImpl(GestioneUtenti gestioneUtenti) {
		gestioneUtenti = toUnwrappedModel(gestioneUtenti);

		boolean isNew = gestioneUtenti.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gestioneUtenti.isNew()) {
				session.save(gestioneUtenti);

				gestioneUtenti.setNew(false);
			}
			else {
				gestioneUtenti = (GestioneUtenti)session.merge(gestioneUtenti);
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

		entityCache.putResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
			GestioneUtentiImpl.class, gestioneUtenti.getPrimaryKey(),
			gestioneUtenti, false);

		gestioneUtenti.resetOriginalValues();

		return gestioneUtenti;
	}

	protected GestioneUtenti toUnwrappedModel(GestioneUtenti gestioneUtenti) {
		if (gestioneUtenti instanceof GestioneUtentiImpl) {
			return gestioneUtenti;
		}

		GestioneUtentiImpl gestioneUtentiImpl = new GestioneUtentiImpl();

		gestioneUtentiImpl.setNew(gestioneUtenti.isNew());
		gestioneUtentiImpl.setPrimaryKey(gestioneUtenti.getPrimaryKey());

		gestioneUtentiImpl.setId(gestioneUtenti.getId());
		gestioneUtentiImpl.setData(gestioneUtenti.getData());
		gestioneUtentiImpl.setCod_fiscale(gestioneUtenti.getCod_fiscale());
		gestioneUtentiImpl.setNome(gestioneUtenti.getNome());
		gestioneUtentiImpl.setCognome(gestioneUtenti.getCognome());
		gestioneUtentiImpl.setUfficio(gestioneUtenti.getUfficio());
		gestioneUtentiImpl.setAbilitazione(gestioneUtenti.isAbilitazione());
		gestioneUtentiImpl.setDelega(gestioneUtenti.isDelega());

		return gestioneUtentiImpl;
	}

	/**
	 * Returns the gestione utenti with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gestione utenti
	 * @return the gestione utenti
	 * @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	 */
	@Override
	public GestioneUtenti findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGestioneUtentiException {
		GestioneUtenti gestioneUtenti = fetchByPrimaryKey(primaryKey);

		if (gestioneUtenti == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGestioneUtentiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gestioneUtenti;
	}

	/**
	 * Returns the gestione utenti with the primary key or throws a {@link NoSuchGestioneUtentiException} if it could not be found.
	 *
	 * @param id the primary key of the gestione utenti
	 * @return the gestione utenti
	 * @throws NoSuchGestioneUtentiException if a gestione utenti with the primary key could not be found
	 */
	@Override
	public GestioneUtenti findByPrimaryKey(long id)
		throws NoSuchGestioneUtentiException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the gestione utenti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gestione utenti
	 * @return the gestione utenti, or <code>null</code> if a gestione utenti with the primary key could not be found
	 */
	@Override
	public GestioneUtenti fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
				GestioneUtentiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		GestioneUtenti gestioneUtenti = (GestioneUtenti)serializable;

		if (gestioneUtenti == null) {
			Session session = null;

			try {
				session = openSession();

				gestioneUtenti = (GestioneUtenti)session.get(GestioneUtentiImpl.class,
						primaryKey);

				if (gestioneUtenti != null) {
					cacheResult(gestioneUtenti);
				}
				else {
					entityCache.putResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
						GestioneUtentiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
					GestioneUtentiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gestioneUtenti;
	}

	/**
	 * Returns the gestione utenti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gestione utenti
	 * @return the gestione utenti, or <code>null</code> if a gestione utenti with the primary key could not be found
	 */
	@Override
	public GestioneUtenti fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, GestioneUtenti> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GestioneUtenti> map = new HashMap<Serializable, GestioneUtenti>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GestioneUtenti gestioneUtenti = fetchByPrimaryKey(primaryKey);

			if (gestioneUtenti != null) {
				map.put(primaryKey, gestioneUtenti);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
					GestioneUtentiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (GestioneUtenti)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GESTIONEUTENTI_WHERE_PKS_IN);

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

			for (GestioneUtenti gestioneUtenti : (List<GestioneUtenti>)q.list()) {
				map.put(gestioneUtenti.getPrimaryKeyObj(), gestioneUtenti);

				cacheResult(gestioneUtenti);

				uncachedPrimaryKeys.remove(gestioneUtenti.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GestioneUtentiModelImpl.ENTITY_CACHE_ENABLED,
					GestioneUtentiImpl.class, primaryKey, nullModel);
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
	 * Returns all the gestione utentis.
	 *
	 * @return the gestione utentis
	 */
	@Override
	public List<GestioneUtenti> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gestione utentis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gestione utentis
	 * @param end the upper bound of the range of gestione utentis (not inclusive)
	 * @return the range of gestione utentis
	 */
	@Override
	public List<GestioneUtenti> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gestione utentis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gestione utentis
	 * @param end the upper bound of the range of gestione utentis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gestione utentis
	 */
	@Override
	public List<GestioneUtenti> findAll(int start, int end,
		OrderByComparator<GestioneUtenti> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the gestione utentis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gestione utentis
	 * @param end the upper bound of the range of gestione utentis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of gestione utentis
	 */
	@Override
	public List<GestioneUtenti> findAll(int start, int end,
		OrderByComparator<GestioneUtenti> orderByComparator,
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

		List<GestioneUtenti> list = null;

		if (retrieveFromCache) {
			list = (List<GestioneUtenti>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GESTIONEUTENTI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GESTIONEUTENTI;

				if (pagination) {
					sql = sql.concat(GestioneUtentiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GestioneUtenti>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GestioneUtenti>)QueryUtil.list(q,
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
	 * Removes all the gestione utentis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GestioneUtenti gestioneUtenti : findAll()) {
			remove(gestioneUtenti);
		}
	}

	/**
	 * Returns the number of gestione utentis.
	 *
	 * @return the number of gestione utentis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GESTIONEUTENTI);

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
		return GestioneUtentiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gestione utenti persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GestioneUtentiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_GESTIONEUTENTI = "SELECT gestioneUtenti FROM GestioneUtenti gestioneUtenti";
	private static final String _SQL_SELECT_GESTIONEUTENTI_WHERE_PKS_IN = "SELECT gestioneUtenti FROM GestioneUtenti gestioneUtenti WHERE id_ IN (";
	private static final String _SQL_COUNT_GESTIONEUTENTI = "SELECT COUNT(gestioneUtenti) FROM GestioneUtenti gestioneUtenti";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gestioneUtenti.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GestioneUtenti exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(GestioneUtentiPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "data"
			});
}