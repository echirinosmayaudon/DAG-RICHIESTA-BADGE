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

import com.intranet.mef.gestione.riunioni.exception.NoSuchAmministrazioneConvocanteException;
import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.model.impl.AmministrazioneConvocanteImpl;
import com.intranet.mef.gestione.riunioni.model.impl.AmministrazioneConvocanteModelImpl;
import com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocantePersistence;

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
 * The persistence implementation for the amministrazione convocante service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmministrazioneConvocantePersistence
 * @see com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocanteUtil
 * @generated
 */
@ProviderType
public class AmministrazioneConvocantePersistenceImpl
	extends BasePersistenceImpl<AmministrazioneConvocante>
	implements AmministrazioneConvocantePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AmministrazioneConvocanteUtil} to access the amministrazione convocante persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AmministrazioneConvocanteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
			AmministrazioneConvocanteModelImpl.FINDER_CACHE_ENABLED,
			AmministrazioneConvocanteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
			AmministrazioneConvocanteModelImpl.FINDER_CACHE_ENABLED,
			AmministrazioneConvocanteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
			AmministrazioneConvocanteModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public AmministrazioneConvocantePersistenceImpl() {
		setModelClass(AmministrazioneConvocante.class);
	}

	/**
	 * Caches the amministrazione convocante in the entity cache if it is enabled.
	 *
	 * @param amministrazioneConvocante the amministrazione convocante
	 */
	@Override
	public void cacheResult(AmministrazioneConvocante amministrazioneConvocante) {
		entityCache.putResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
			AmministrazioneConvocanteImpl.class,
			amministrazioneConvocante.getPrimaryKey(), amministrazioneConvocante);

		amministrazioneConvocante.resetOriginalValues();
	}

	/**
	 * Caches the amministrazione convocantes in the entity cache if it is enabled.
	 *
	 * @param amministrazioneConvocantes the amministrazione convocantes
	 */
	@Override
	public void cacheResult(
		List<AmministrazioneConvocante> amministrazioneConvocantes) {
		for (AmministrazioneConvocante amministrazioneConvocante : amministrazioneConvocantes) {
			if (entityCache.getResult(
						AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
						AmministrazioneConvocanteImpl.class,
						amministrazioneConvocante.getPrimaryKey()) == null) {
				cacheResult(amministrazioneConvocante);
			}
			else {
				amministrazioneConvocante.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all amministrazione convocantes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmministrazioneConvocanteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amministrazione convocante.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AmministrazioneConvocante amministrazioneConvocante) {
		entityCache.removeResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
			AmministrazioneConvocanteImpl.class,
			amministrazioneConvocante.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<AmministrazioneConvocante> amministrazioneConvocantes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AmministrazioneConvocante amministrazioneConvocante : amministrazioneConvocantes) {
			entityCache.removeResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
				AmministrazioneConvocanteImpl.class,
				amministrazioneConvocante.getPrimaryKey());
		}
	}

	/**
	 * Creates a new amministrazione convocante with the primary key. Does not add the amministrazione convocante to the database.
	 *
	 * @param id_amministrazione_convocante the primary key for the new amministrazione convocante
	 * @return the new amministrazione convocante
	 */
	@Override
	public AmministrazioneConvocante create(long id_amministrazione_convocante) {
		AmministrazioneConvocante amministrazioneConvocante = new AmministrazioneConvocanteImpl();

		amministrazioneConvocante.setNew(true);
		amministrazioneConvocante.setPrimaryKey(id_amministrazione_convocante);

		return amministrazioneConvocante;
	}

	/**
	 * Removes the amministrazione convocante with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_amministrazione_convocante the primary key of the amministrazione convocante
	 * @return the amministrazione convocante that was removed
	 * @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	 */
	@Override
	public AmministrazioneConvocante remove(long id_amministrazione_convocante)
		throws NoSuchAmministrazioneConvocanteException {
		return remove((Serializable)id_amministrazione_convocante);
	}

	/**
	 * Removes the amministrazione convocante with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amministrazione convocante
	 * @return the amministrazione convocante that was removed
	 * @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	 */
	@Override
	public AmministrazioneConvocante remove(Serializable primaryKey)
		throws NoSuchAmministrazioneConvocanteException {
		Session session = null;

		try {
			session = openSession();

			AmministrazioneConvocante amministrazioneConvocante = (AmministrazioneConvocante)session.get(AmministrazioneConvocanteImpl.class,
					primaryKey);

			if (amministrazioneConvocante == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmministrazioneConvocanteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(amministrazioneConvocante);
		}
		catch (NoSuchAmministrazioneConvocanteException nsee) {
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
	protected AmministrazioneConvocante removeImpl(
		AmministrazioneConvocante amministrazioneConvocante) {
		amministrazioneConvocante = toUnwrappedModel(amministrazioneConvocante);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amministrazioneConvocante)) {
				amministrazioneConvocante = (AmministrazioneConvocante)session.get(AmministrazioneConvocanteImpl.class,
						amministrazioneConvocante.getPrimaryKeyObj());
			}

			if (amministrazioneConvocante != null) {
				session.delete(amministrazioneConvocante);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (amministrazioneConvocante != null) {
			clearCache(amministrazioneConvocante);
		}

		return amministrazioneConvocante;
	}

	@Override
	public AmministrazioneConvocante updateImpl(
		AmministrazioneConvocante amministrazioneConvocante) {
		amministrazioneConvocante = toUnwrappedModel(amministrazioneConvocante);

		boolean isNew = amministrazioneConvocante.isNew();

		Session session = null;

		try {
			session = openSession();

			if (amministrazioneConvocante.isNew()) {
				session.save(amministrazioneConvocante);

				amministrazioneConvocante.setNew(false);
			}
			else {
				amministrazioneConvocante = (AmministrazioneConvocante)session.merge(amministrazioneConvocante);
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

		entityCache.putResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
			AmministrazioneConvocanteImpl.class,
			amministrazioneConvocante.getPrimaryKey(),
			amministrazioneConvocante, false);

		amministrazioneConvocante.resetOriginalValues();

		return amministrazioneConvocante;
	}

	protected AmministrazioneConvocante toUnwrappedModel(
		AmministrazioneConvocante amministrazioneConvocante) {
		if (amministrazioneConvocante instanceof AmministrazioneConvocanteImpl) {
			return amministrazioneConvocante;
		}

		AmministrazioneConvocanteImpl amministrazioneConvocanteImpl = new AmministrazioneConvocanteImpl();

		amministrazioneConvocanteImpl.setNew(amministrazioneConvocante.isNew());
		amministrazioneConvocanteImpl.setPrimaryKey(amministrazioneConvocante.getPrimaryKey());

		amministrazioneConvocanteImpl.setId_amministrazione_convocante(amministrazioneConvocante.getId_amministrazione_convocante());
		amministrazioneConvocanteImpl.setNome_amministrazione(amministrazioneConvocante.getNome_amministrazione());

		return amministrazioneConvocanteImpl;
	}

	/**
	 * Returns the amministrazione convocante with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the amministrazione convocante
	 * @return the amministrazione convocante
	 * @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	 */
	@Override
	public AmministrazioneConvocante findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmministrazioneConvocanteException {
		AmministrazioneConvocante amministrazioneConvocante = fetchByPrimaryKey(primaryKey);

		if (amministrazioneConvocante == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmministrazioneConvocanteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return amministrazioneConvocante;
	}

	/**
	 * Returns the amministrazione convocante with the primary key or throws a {@link NoSuchAmministrazioneConvocanteException} if it could not be found.
	 *
	 * @param id_amministrazione_convocante the primary key of the amministrazione convocante
	 * @return the amministrazione convocante
	 * @throws NoSuchAmministrazioneConvocanteException if a amministrazione convocante with the primary key could not be found
	 */
	@Override
	public AmministrazioneConvocante findByPrimaryKey(
		long id_amministrazione_convocante)
		throws NoSuchAmministrazioneConvocanteException {
		return findByPrimaryKey((Serializable)id_amministrazione_convocante);
	}

	/**
	 * Returns the amministrazione convocante with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amministrazione convocante
	 * @return the amministrazione convocante, or <code>null</code> if a amministrazione convocante with the primary key could not be found
	 */
	@Override
	public AmministrazioneConvocante fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
				AmministrazioneConvocanteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AmministrazioneConvocante amministrazioneConvocante = (AmministrazioneConvocante)serializable;

		if (amministrazioneConvocante == null) {
			Session session = null;

			try {
				session = openSession();

				amministrazioneConvocante = (AmministrazioneConvocante)session.get(AmministrazioneConvocanteImpl.class,
						primaryKey);

				if (amministrazioneConvocante != null) {
					cacheResult(amministrazioneConvocante);
				}
				else {
					entityCache.putResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
						AmministrazioneConvocanteImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
					AmministrazioneConvocanteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return amministrazioneConvocante;
	}

	/**
	 * Returns the amministrazione convocante with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_amministrazione_convocante the primary key of the amministrazione convocante
	 * @return the amministrazione convocante, or <code>null</code> if a amministrazione convocante with the primary key could not be found
	 */
	@Override
	public AmministrazioneConvocante fetchByPrimaryKey(
		long id_amministrazione_convocante) {
		return fetchByPrimaryKey((Serializable)id_amministrazione_convocante);
	}

	@Override
	public Map<Serializable, AmministrazioneConvocante> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AmministrazioneConvocante> map = new HashMap<Serializable, AmministrazioneConvocante>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AmministrazioneConvocante amministrazioneConvocante = fetchByPrimaryKey(primaryKey);

			if (amministrazioneConvocante != null) {
				map.put(primaryKey, amministrazioneConvocante);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
					AmministrazioneConvocanteImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AmministrazioneConvocante)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AMMINISTRAZIONECONVOCANTE_WHERE_PKS_IN);

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

			for (AmministrazioneConvocante amministrazioneConvocante : (List<AmministrazioneConvocante>)q.list()) {
				map.put(amministrazioneConvocante.getPrimaryKeyObj(),
					amministrazioneConvocante);

				cacheResult(amministrazioneConvocante);

				uncachedPrimaryKeys.remove(amministrazioneConvocante.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AmministrazioneConvocanteModelImpl.ENTITY_CACHE_ENABLED,
					AmministrazioneConvocanteImpl.class, primaryKey, nullModel);
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
	 * Returns all the amministrazione convocantes.
	 *
	 * @return the amministrazione convocantes
	 */
	@Override
	public List<AmministrazioneConvocante> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amministrazione convocantes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amministrazione convocantes
	 * @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	 * @return the range of amministrazione convocantes
	 */
	@Override
	public List<AmministrazioneConvocante> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the amministrazione convocantes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amministrazione convocantes
	 * @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amministrazione convocantes
	 */
	@Override
	public List<AmministrazioneConvocante> findAll(int start, int end,
		OrderByComparator<AmministrazioneConvocante> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amministrazione convocantes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmministrazioneConvocanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amministrazione convocantes
	 * @param end the upper bound of the range of amministrazione convocantes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of amministrazione convocantes
	 */
	@Override
	public List<AmministrazioneConvocante> findAll(int start, int end,
		OrderByComparator<AmministrazioneConvocante> orderByComparator,
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

		List<AmministrazioneConvocante> list = null;

		if (retrieveFromCache) {
			list = (List<AmministrazioneConvocante>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AMMINISTRAZIONECONVOCANTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMMINISTRAZIONECONVOCANTE;

				if (pagination) {
					sql = sql.concat(AmministrazioneConvocanteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AmministrazioneConvocante>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmministrazioneConvocante>)QueryUtil.list(q,
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
	 * Removes all the amministrazione convocantes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AmministrazioneConvocante amministrazioneConvocante : findAll()) {
			remove(amministrazioneConvocante);
		}
	}

	/**
	 * Returns the number of amministrazione convocantes.
	 *
	 * @return the number of amministrazione convocantes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMMINISTRAZIONECONVOCANTE);

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
		return AmministrazioneConvocanteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amministrazione convocante persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AmministrazioneConvocanteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AMMINISTRAZIONECONVOCANTE = "SELECT amministrazioneConvocante FROM AmministrazioneConvocante amministrazioneConvocante";
	private static final String _SQL_SELECT_AMMINISTRAZIONECONVOCANTE_WHERE_PKS_IN =
		"SELECT amministrazioneConvocante FROM AmministrazioneConvocante amministrazioneConvocante WHERE id_amministrazione_convocante IN (";
	private static final String _SQL_COUNT_AMMINISTRAZIONECONVOCANTE = "SELECT COUNT(amministrazioneConvocante) FROM AmministrazioneConvocante amministrazioneConvocante";
	private static final String _ORDER_BY_ENTITY_ALIAS = "amministrazioneConvocante.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AmministrazioneConvocante exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(AmministrazioneConvocantePersistenceImpl.class);
}