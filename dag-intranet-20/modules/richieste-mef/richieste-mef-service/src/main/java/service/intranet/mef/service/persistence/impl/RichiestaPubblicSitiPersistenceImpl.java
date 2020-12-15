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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import service.intranet.mef.exception.NoSuchRichiestaPubblicSitiException;
import service.intranet.mef.model.RichiestaPubblicSiti;
import service.intranet.mef.model.impl.RichiestaPubblicSitiImpl;
import service.intranet.mef.model.impl.RichiestaPubblicSitiModelImpl;
import service.intranet.mef.service.persistence.RichiestaPubblicSitiPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the richiesta pubblic siti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPubblicSitiPersistence
 * @see service.intranet.mef.service.persistence.RichiestaPubblicSitiUtil
 * @generated
 */
@ProviderType
public class RichiestaPubblicSitiPersistenceImpl extends BasePersistenceImpl<RichiestaPubblicSiti>
	implements RichiestaPubblicSitiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiestaPubblicSitiUtil} to access the richiesta pubblic siti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiestaPubblicSitiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaPubblicSitiModelImpl.FINDER_CACHE_ENABLED,
			RichiestaPubblicSitiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaPubblicSitiModelImpl.FINDER_CACHE_ENABLED,
			RichiestaPubblicSitiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaPubblicSitiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RichiestaPubblicSitiPersistenceImpl() {
		setModelClass(RichiestaPubblicSiti.class);
	}

	/**
	 * Caches the richiesta pubblic siti in the entity cache if it is enabled.
	 *
	 * @param richiestaPubblicSiti the richiesta pubblic siti
	 */
	@Override
	public void cacheResult(RichiestaPubblicSiti richiestaPubblicSiti) {
		entityCache.putResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaPubblicSitiImpl.class,
			richiestaPubblicSiti.getPrimaryKey(), richiestaPubblicSiti);

		richiestaPubblicSiti.resetOriginalValues();
	}

	/**
	 * Caches the richiesta pubblic sitis in the entity cache if it is enabled.
	 *
	 * @param richiestaPubblicSitis the richiesta pubblic sitis
	 */
	@Override
	public void cacheResult(List<RichiestaPubblicSiti> richiestaPubblicSitis) {
		for (RichiestaPubblicSiti richiestaPubblicSiti : richiestaPubblicSitis) {
			if (entityCache.getResult(
						RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaPubblicSitiImpl.class,
						richiestaPubblicSiti.getPrimaryKey()) == null) {
				cacheResult(richiestaPubblicSiti);
			}
			else {
				richiestaPubblicSiti.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richiesta pubblic sitis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiestaPubblicSitiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richiesta pubblic siti.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiestaPubblicSiti richiestaPubblicSiti) {
		entityCache.removeResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaPubblicSitiImpl.class, richiestaPubblicSiti.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichiestaPubblicSiti> richiestaPubblicSitis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichiestaPubblicSiti richiestaPubblicSiti : richiestaPubblicSitis) {
			entityCache.removeResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaPubblicSitiImpl.class,
				richiestaPubblicSiti.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richiesta pubblic siti with the primary key. Does not add the richiesta pubblic siti to the database.
	 *
	 * @param id_rich_pubblic the primary key for the new richiesta pubblic siti
	 * @return the new richiesta pubblic siti
	 */
	@Override
	public RichiestaPubblicSiti create(long id_rich_pubblic) {
		RichiestaPubblicSiti richiestaPubblicSiti = new RichiestaPubblicSitiImpl();

		richiestaPubblicSiti.setNew(true);
		richiestaPubblicSiti.setPrimaryKey(id_rich_pubblic);

		return richiestaPubblicSiti;
	}

	/**
	 * Removes the richiesta pubblic siti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_rich_pubblic the primary key of the richiesta pubblic siti
	 * @return the richiesta pubblic siti that was removed
	 * @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	 */
	@Override
	public RichiestaPubblicSiti remove(long id_rich_pubblic)
		throws NoSuchRichiestaPubblicSitiException {
		return remove((Serializable)id_rich_pubblic);
	}

	/**
	 * Removes the richiesta pubblic siti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richiesta pubblic siti
	 * @return the richiesta pubblic siti that was removed
	 * @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	 */
	@Override
	public RichiestaPubblicSiti remove(Serializable primaryKey)
		throws NoSuchRichiestaPubblicSitiException {
		Session session = null;

		try {
			session = openSession();

			RichiestaPubblicSiti richiestaPubblicSiti = (RichiestaPubblicSiti)session.get(RichiestaPubblicSitiImpl.class,
					primaryKey);

			if (richiestaPubblicSiti == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiestaPubblicSitiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richiestaPubblicSiti);
		}
		catch (NoSuchRichiestaPubblicSitiException nsee) {
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
	protected RichiestaPubblicSiti removeImpl(
		RichiestaPubblicSiti richiestaPubblicSiti) {
		richiestaPubblicSiti = toUnwrappedModel(richiestaPubblicSiti);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiestaPubblicSiti)) {
				richiestaPubblicSiti = (RichiestaPubblicSiti)session.get(RichiestaPubblicSitiImpl.class,
						richiestaPubblicSiti.getPrimaryKeyObj());
			}

			if (richiestaPubblicSiti != null) {
				session.delete(richiestaPubblicSiti);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiestaPubblicSiti != null) {
			clearCache(richiestaPubblicSiti);
		}

		return richiestaPubblicSiti;
	}

	@Override
	public RichiestaPubblicSiti updateImpl(
		RichiestaPubblicSiti richiestaPubblicSiti) {
		richiestaPubblicSiti = toUnwrappedModel(richiestaPubblicSiti);

		boolean isNew = richiestaPubblicSiti.isNew();

		Session session = null;

		try {
			session = openSession();

			if (richiestaPubblicSiti.isNew()) {
				session.save(richiestaPubblicSiti);

				richiestaPubblicSiti.setNew(false);
			}
			else {
				richiestaPubblicSiti = (RichiestaPubblicSiti)session.merge(richiestaPubblicSiti);
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

		entityCache.putResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaPubblicSitiImpl.class,
			richiestaPubblicSiti.getPrimaryKey(), richiestaPubblicSiti, false);

		richiestaPubblicSiti.resetOriginalValues();

		return richiestaPubblicSiti;
	}

	protected RichiestaPubblicSiti toUnwrappedModel(
		RichiestaPubblicSiti richiestaPubblicSiti) {
		if (richiestaPubblicSiti instanceof RichiestaPubblicSitiImpl) {
			return richiestaPubblicSiti;
		}

		RichiestaPubblicSitiImpl richiestaPubblicSitiImpl = new RichiestaPubblicSitiImpl();

		richiestaPubblicSitiImpl.setNew(richiestaPubblicSiti.isNew());
		richiestaPubblicSitiImpl.setPrimaryKey(richiestaPubblicSiti.getPrimaryKey());

		richiestaPubblicSitiImpl.setId_rich_pubblic(richiestaPubblicSiti.getId_rich_pubblic());
		richiestaPubblicSitiImpl.setDati_richiedente(richiestaPubblicSiti.getDati_richiedente());
		richiestaPubblicSitiImpl.setDati_docum(richiestaPubblicSiti.getDati_docum());
		richiestaPubblicSitiImpl.setTitolo(richiestaPubblicSiti.getTitolo());
		richiestaPubblicSitiImpl.setSottotitolo(richiestaPubblicSiti.getSottotitolo());
		richiestaPubblicSitiImpl.setNovita_abstract(richiestaPubblicSiti.getNovita_abstract());
		richiestaPubblicSitiImpl.setNote_riferim(richiestaPubblicSiti.getNote_riferim());
		richiestaPubblicSitiImpl.setDati_stampa_carta(richiestaPubblicSiti.getDati_stampa_carta());
		richiestaPubblicSitiImpl.setDati_altro(richiestaPubblicSiti.getDati_altro());
		richiestaPubblicSitiImpl.setDati_autorizzaz(richiestaPubblicSiti.getDati_autorizzaz());
		richiestaPubblicSitiImpl.setNote_autorizzaz(richiestaPubblicSiti.getNote_autorizzaz());
		richiestaPubblicSitiImpl.setLista_allegati(richiestaPubblicSiti.getLista_allegati());

		return richiestaPubblicSitiImpl;
	}

	/**
	 * Returns the richiesta pubblic siti with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta pubblic siti
	 * @return the richiesta pubblic siti
	 * @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	 */
	@Override
	public RichiestaPubblicSiti findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiestaPubblicSitiException {
		RichiestaPubblicSiti richiestaPubblicSiti = fetchByPrimaryKey(primaryKey);

		if (richiestaPubblicSiti == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiestaPubblicSitiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richiestaPubblicSiti;
	}

	/**
	 * Returns the richiesta pubblic siti with the primary key or throws a {@link NoSuchRichiestaPubblicSitiException} if it could not be found.
	 *
	 * @param id_rich_pubblic the primary key of the richiesta pubblic siti
	 * @return the richiesta pubblic siti
	 * @throws NoSuchRichiestaPubblicSitiException if a richiesta pubblic siti with the primary key could not be found
	 */
	@Override
	public RichiestaPubblicSiti findByPrimaryKey(long id_rich_pubblic)
		throws NoSuchRichiestaPubblicSitiException {
		return findByPrimaryKey((Serializable)id_rich_pubblic);
	}

	/**
	 * Returns the richiesta pubblic siti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta pubblic siti
	 * @return the richiesta pubblic siti, or <code>null</code> if a richiesta pubblic siti with the primary key could not be found
	 */
	@Override
	public RichiestaPubblicSiti fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaPubblicSitiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichiestaPubblicSiti richiestaPubblicSiti = (RichiestaPubblicSiti)serializable;

		if (richiestaPubblicSiti == null) {
			Session session = null;

			try {
				session = openSession();

				richiestaPubblicSiti = (RichiestaPubblicSiti)session.get(RichiestaPubblicSitiImpl.class,
						primaryKey);

				if (richiestaPubblicSiti != null) {
					cacheResult(richiestaPubblicSiti);
				}
				else {
					entityCache.putResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaPubblicSitiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaPubblicSitiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiestaPubblicSiti;
	}

	/**
	 * Returns the richiesta pubblic siti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_rich_pubblic the primary key of the richiesta pubblic siti
	 * @return the richiesta pubblic siti, or <code>null</code> if a richiesta pubblic siti with the primary key could not be found
	 */
	@Override
	public RichiestaPubblicSiti fetchByPrimaryKey(long id_rich_pubblic) {
		return fetchByPrimaryKey((Serializable)id_rich_pubblic);
	}

	@Override
	public Map<Serializable, RichiestaPubblicSiti> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichiestaPubblicSiti> map = new HashMap<Serializable, RichiestaPubblicSiti>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichiestaPubblicSiti richiestaPubblicSiti = fetchByPrimaryKey(primaryKey);

			if (richiestaPubblicSiti != null) {
				map.put(primaryKey, richiestaPubblicSiti);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaPubblicSitiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichiestaPubblicSiti)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTAPUBBLICSITI_WHERE_PKS_IN);

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

			for (RichiestaPubblicSiti richiestaPubblicSiti : (List<RichiestaPubblicSiti>)q.list()) {
				map.put(richiestaPubblicSiti.getPrimaryKeyObj(),
					richiestaPubblicSiti);

				cacheResult(richiestaPubblicSiti);

				uncachedPrimaryKeys.remove(richiestaPubblicSiti.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiestaPubblicSitiModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaPubblicSitiImpl.class, primaryKey, nullModel);
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
	 * Returns all the richiesta pubblic sitis.
	 *
	 * @return the richiesta pubblic sitis
	 */
	@Override
	public List<RichiestaPubblicSiti> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta pubblic sitis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta pubblic sitis
	 * @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	 * @return the range of richiesta pubblic sitis
	 */
	@Override
	public List<RichiestaPubblicSiti> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta pubblic sitis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta pubblic sitis
	 * @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta pubblic sitis
	 */
	@Override
	public List<RichiestaPubblicSiti> findAll(int start, int end,
		OrderByComparator<RichiestaPubblicSiti> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta pubblic sitis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta pubblic sitis
	 * @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiesta pubblic sitis
	 */
	@Override
	public List<RichiestaPubblicSiti> findAll(int start, int end,
		OrderByComparator<RichiestaPubblicSiti> orderByComparator,
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

		List<RichiestaPubblicSiti> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaPubblicSiti>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTAPUBBLICSITI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTAPUBBLICSITI;

				if (pagination) {
					sql = sql.concat(RichiestaPubblicSitiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichiestaPubblicSiti>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaPubblicSiti>)QueryUtil.list(q,
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
	 * Removes all the richiesta pubblic sitis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiestaPubblicSiti richiestaPubblicSiti : findAll()) {
			remove(richiestaPubblicSiti);
		}
	}

	/**
	 * Returns the number of richiesta pubblic sitis.
	 *
	 * @return the number of richiesta pubblic sitis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTAPUBBLICSITI);

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
		return RichiestaPubblicSitiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richiesta pubblic siti persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiestaPubblicSitiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTAPUBBLICSITI = "SELECT richiestaPubblicSiti FROM RichiestaPubblicSiti richiestaPubblicSiti";
	private static final String _SQL_SELECT_RICHIESTAPUBBLICSITI_WHERE_PKS_IN = "SELECT richiestaPubblicSiti FROM RichiestaPubblicSiti richiestaPubblicSiti WHERE id_rich_pubblic IN (";
	private static final String _SQL_COUNT_RICHIESTAPUBBLICSITI = "SELECT COUNT(richiestaPubblicSiti) FROM RichiestaPubblicSiti richiestaPubblicSiti";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richiestaPubblicSiti.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichiestaPubblicSiti exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RichiestaPubblicSitiPersistenceImpl.class);
}