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

package servizio.whistleblowing.mef.service.persistence.impl;

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

import servizio.whistleblowing.mef.exception.NoSuchSegnalazioneException;
import servizio.whistleblowing.mef.model.Segnalazione;
import servizio.whistleblowing.mef.model.impl.SegnalazioneImpl;
import servizio.whistleblowing.mef.model.impl.SegnalazioneModelImpl;
import servizio.whistleblowing.mef.service.persistence.SegnalazionePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the segnalazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazionePersistence
 * @see servizio.whistleblowing.mef.service.persistence.SegnalazioneUtil
 * @generated
 */
@ProviderType
public class SegnalazionePersistenceImpl extends BasePersistenceImpl<Segnalazione>
	implements SegnalazionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SegnalazioneUtil} to access the segnalazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SegnalazioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, SegnalazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, SegnalazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SegnalazionePersistenceImpl() {
		setModelClass(Segnalazione.class);
	}

	/**
	 * Caches the segnalazione in the entity cache if it is enabled.
	 *
	 * @param segnalazione the segnalazione
	 */
	@Override
	public void cacheResult(Segnalazione segnalazione) {
		entityCache.putResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneImpl.class, segnalazione.getPrimaryKey(), segnalazione);

		segnalazione.resetOriginalValues();
	}

	/**
	 * Caches the segnalaziones in the entity cache if it is enabled.
	 *
	 * @param segnalaziones the segnalaziones
	 */
	@Override
	public void cacheResult(List<Segnalazione> segnalaziones) {
		for (Segnalazione segnalazione : segnalaziones) {
			if (entityCache.getResult(
						SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
						SegnalazioneImpl.class, segnalazione.getPrimaryKey()) == null) {
				cacheResult(segnalazione);
			}
			else {
				segnalazione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all segnalaziones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SegnalazioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the segnalazione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Segnalazione segnalazione) {
		entityCache.removeResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneImpl.class, segnalazione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Segnalazione> segnalaziones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Segnalazione segnalazione : segnalaziones) {
			entityCache.removeResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
				SegnalazioneImpl.class, segnalazione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new segnalazione with the primary key. Does not add the segnalazione to the database.
	 *
	 * @param id_segnalazione the primary key for the new segnalazione
	 * @return the new segnalazione
	 */
	@Override
	public Segnalazione create(long id_segnalazione) {
		Segnalazione segnalazione = new SegnalazioneImpl();

		segnalazione.setNew(true);
		segnalazione.setPrimaryKey(id_segnalazione);

		return segnalazione;
	}

	/**
	 * Removes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_segnalazione the primary key of the segnalazione
	 * @return the segnalazione that was removed
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione remove(long id_segnalazione)
		throws NoSuchSegnalazioneException {
		return remove((Serializable)id_segnalazione);
	}

	/**
	 * Removes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the segnalazione
	 * @return the segnalazione that was removed
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione remove(Serializable primaryKey)
		throws NoSuchSegnalazioneException {
		Session session = null;

		try {
			session = openSession();

			Segnalazione segnalazione = (Segnalazione)session.get(SegnalazioneImpl.class,
					primaryKey);

			if (segnalazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSegnalazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(segnalazione);
		}
		catch (NoSuchSegnalazioneException nsee) {
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
	protected Segnalazione removeImpl(Segnalazione segnalazione) {
		segnalazione = toUnwrappedModel(segnalazione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(segnalazione)) {
				segnalazione = (Segnalazione)session.get(SegnalazioneImpl.class,
						segnalazione.getPrimaryKeyObj());
			}

			if (segnalazione != null) {
				session.delete(segnalazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (segnalazione != null) {
			clearCache(segnalazione);
		}

		return segnalazione;
	}

	@Override
	public Segnalazione updateImpl(Segnalazione segnalazione) {
		segnalazione = toUnwrappedModel(segnalazione);

		boolean isNew = segnalazione.isNew();

		Session session = null;

		try {
			session = openSession();

			if (segnalazione.isNew()) {
				session.save(segnalazione);

				segnalazione.setNew(false);
			}
			else {
				segnalazione = (Segnalazione)session.merge(segnalazione);
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

		entityCache.putResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
			SegnalazioneImpl.class, segnalazione.getPrimaryKey(), segnalazione,
			false);

		segnalazione.resetOriginalValues();

		return segnalazione;
	}

	protected Segnalazione toUnwrappedModel(Segnalazione segnalazione) {
		if (segnalazione instanceof SegnalazioneImpl) {
			return segnalazione;
		}

		SegnalazioneImpl segnalazioneImpl = new SegnalazioneImpl();

		segnalazioneImpl.setNew(segnalazione.isNew());
		segnalazioneImpl.setPrimaryKey(segnalazione.getPrimaryKey());

		segnalazioneImpl.setId_segnalazione(segnalazione.getId_segnalazione());
		segnalazioneImpl.setJson_dati_personali(segnalazione.getJson_dati_personali());
		segnalazioneImpl.setLuogo(segnalazione.getLuogo());
		segnalazioneImpl.setAzioni_omissioni(segnalazione.getAzioni_omissioni());
		segnalazioneImpl.setDescrizione(segnalazione.getDescrizione());
		segnalazioneImpl.setAutore(segnalazione.getAutore());
		segnalazioneImpl.setAltri_testimoni(segnalazione.getAltri_testimoni());

		return segnalazioneImpl;
	}

	/**
	 * Returns the segnalazione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the segnalazione
	 * @return the segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSegnalazioneException {
		Segnalazione segnalazione = fetchByPrimaryKey(primaryKey);

		if (segnalazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSegnalazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return segnalazione;
	}

	/**
	 * Returns the segnalazione with the primary key or throws a {@link NoSuchSegnalazioneException} if it could not be found.
	 *
	 * @param id_segnalazione the primary key of the segnalazione
	 * @return the segnalazione
	 * @throws NoSuchSegnalazioneException if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione findByPrimaryKey(long id_segnalazione)
		throws NoSuchSegnalazioneException {
		return findByPrimaryKey((Serializable)id_segnalazione);
	}

	/**
	 * Returns the segnalazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the segnalazione
	 * @return the segnalazione, or <code>null</code> if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
				SegnalazioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Segnalazione segnalazione = (Segnalazione)serializable;

		if (segnalazione == null) {
			Session session = null;

			try {
				session = openSession();

				segnalazione = (Segnalazione)session.get(SegnalazioneImpl.class,
						primaryKey);

				if (segnalazione != null) {
					cacheResult(segnalazione);
				}
				else {
					entityCache.putResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
						SegnalazioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
					SegnalazioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return segnalazione;
	}

	/**
	 * Returns the segnalazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_segnalazione the primary key of the segnalazione
	 * @return the segnalazione, or <code>null</code> if a segnalazione with the primary key could not be found
	 */
	@Override
	public Segnalazione fetchByPrimaryKey(long id_segnalazione) {
		return fetchByPrimaryKey((Serializable)id_segnalazione);
	}

	@Override
	public Map<Serializable, Segnalazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Segnalazione> map = new HashMap<Serializable, Segnalazione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Segnalazione segnalazione = fetchByPrimaryKey(primaryKey);

			if (segnalazione != null) {
				map.put(primaryKey, segnalazione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
					SegnalazioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Segnalazione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SEGNALAZIONE_WHERE_PKS_IN);

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

			for (Segnalazione segnalazione : (List<Segnalazione>)q.list()) {
				map.put(segnalazione.getPrimaryKeyObj(), segnalazione);

				cacheResult(segnalazione);

				uncachedPrimaryKeys.remove(segnalazione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SegnalazioneModelImpl.ENTITY_CACHE_ENABLED,
					SegnalazioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the segnalaziones.
	 *
	 * @return the segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @return the range of segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll(int start, int end,
		OrderByComparator<Segnalazione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the segnalaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of segnalaziones
	 * @param end the upper bound of the range of segnalaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of segnalaziones
	 */
	@Override
	public List<Segnalazione> findAll(int start, int end,
		OrderByComparator<Segnalazione> orderByComparator,
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

		List<Segnalazione> list = null;

		if (retrieveFromCache) {
			list = (List<Segnalazione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEGNALAZIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEGNALAZIONE;

				if (pagination) {
					sql = sql.concat(SegnalazioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Segnalazione>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Segnalazione>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the segnalaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Segnalazione segnalazione : findAll()) {
			remove(segnalazione);
		}
	}

	/**
	 * Returns the number of segnalaziones.
	 *
	 * @return the number of segnalaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEGNALAZIONE);

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
		return SegnalazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the segnalazione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SegnalazioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SEGNALAZIONE = "SELECT segnalazione FROM Segnalazione segnalazione";
	private static final String _SQL_SELECT_SEGNALAZIONE_WHERE_PKS_IN = "SELECT segnalazione FROM Segnalazione segnalazione WHERE id_segnalazione IN (";
	private static final String _SQL_COUNT_SEGNALAZIONE = "SELECT COUNT(segnalazione) FROM Segnalazione segnalazione";
	private static final String _ORDER_BY_ENTITY_ALIAS = "segnalazione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Segnalazione exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SegnalazionePersistenceImpl.class);
}