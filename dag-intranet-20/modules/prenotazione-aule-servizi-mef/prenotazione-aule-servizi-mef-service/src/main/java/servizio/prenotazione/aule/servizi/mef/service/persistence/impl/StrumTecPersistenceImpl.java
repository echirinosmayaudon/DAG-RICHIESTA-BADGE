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

import servizio.prenotazione.aule.servizi.mef.exception.NoSuchStrumTecException;
import servizio.prenotazione.aule.servizi.mef.model.StrumTec;
import servizio.prenotazione.aule.servizi.mef.model.impl.StrumTecImpl;
import servizio.prenotazione.aule.servizi.mef.model.impl.StrumTecModelImpl;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPK;
import servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the strum tec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumTecPersistence
 * @see servizio.prenotazione.aule.servizi.mef.service.persistence.StrumTecUtil
 * @generated
 */
@ProviderType
public class StrumTecPersistenceImpl extends BasePersistenceImpl<StrumTec>
	implements StrumTecPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StrumTecUtil} to access the strum tec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StrumTecImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumTecModelImpl.FINDER_CACHE_ENABLED, StrumTecImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumTecModelImpl.FINDER_CACHE_ENABLED, StrumTecImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumTecModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StrumTecPersistenceImpl() {
		setModelClass(StrumTec.class);
	}

	/**
	 * Caches the strum tec in the entity cache if it is enabled.
	 *
	 * @param strumTec the strum tec
	 */
	@Override
	public void cacheResult(StrumTec strumTec) {
		entityCache.putResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumTecImpl.class, strumTec.getPrimaryKey(), strumTec);

		strumTec.resetOriginalValues();
	}

	/**
	 * Caches the strum tecs in the entity cache if it is enabled.
	 *
	 * @param strumTecs the strum tecs
	 */
	@Override
	public void cacheResult(List<StrumTec> strumTecs) {
		for (StrumTec strumTec : strumTecs) {
			if (entityCache.getResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
						StrumTecImpl.class, strumTec.getPrimaryKey()) == null) {
				cacheResult(strumTec);
			}
			else {
				strumTec.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all strum tecs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StrumTecImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the strum tec.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StrumTec strumTec) {
		entityCache.removeResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumTecImpl.class, strumTec.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StrumTec> strumTecs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StrumTec strumTec : strumTecs) {
			entityCache.removeResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
				StrumTecImpl.class, strumTec.getPrimaryKey());
		}
	}

	/**
	 * Creates a new strum tec with the primary key. Does not add the strum tec to the database.
	 *
	 * @param strumTecPK the primary key for the new strum tec
	 * @return the new strum tec
	 */
	@Override
	public StrumTec create(StrumTecPK strumTecPK) {
		StrumTec strumTec = new StrumTecImpl();

		strumTec.setNew(true);
		strumTec.setPrimaryKey(strumTecPK);

		return strumTec;
	}

	/**
	 * Removes the strum tec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param strumTecPK the primary key of the strum tec
	 * @return the strum tec that was removed
	 * @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	 */
	@Override
	public StrumTec remove(StrumTecPK strumTecPK)
		throws NoSuchStrumTecException {
		return remove((Serializable)strumTecPK);
	}

	/**
	 * Removes the strum tec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the strum tec
	 * @return the strum tec that was removed
	 * @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	 */
	@Override
	public StrumTec remove(Serializable primaryKey)
		throws NoSuchStrumTecException {
		Session session = null;

		try {
			session = openSession();

			StrumTec strumTec = (StrumTec)session.get(StrumTecImpl.class,
					primaryKey);

			if (strumTec == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStrumTecException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(strumTec);
		}
		catch (NoSuchStrumTecException nsee) {
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
	protected StrumTec removeImpl(StrumTec strumTec) {
		strumTec = toUnwrappedModel(strumTec);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(strumTec)) {
				strumTec = (StrumTec)session.get(StrumTecImpl.class,
						strumTec.getPrimaryKeyObj());
			}

			if (strumTec != null) {
				session.delete(strumTec);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (strumTec != null) {
			clearCache(strumTec);
		}

		return strumTec;
	}

	@Override
	public StrumTec updateImpl(StrumTec strumTec) {
		strumTec = toUnwrappedModel(strumTec);

		boolean isNew = strumTec.isNew();

		Session session = null;

		try {
			session = openSession();

			if (strumTec.isNew()) {
				session.save(strumTec);

				strumTec.setNew(false);
			}
			else {
				strumTec = (StrumTec)session.merge(strumTec);
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

		entityCache.putResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumTecImpl.class, strumTec.getPrimaryKey(), strumTec, false);

		strumTec.resetOriginalValues();

		return strumTec;
	}

	protected StrumTec toUnwrappedModel(StrumTec strumTec) {
		if (strumTec instanceof StrumTecImpl) {
			return strumTec;
		}

		StrumTecImpl strumTecImpl = new StrumTecImpl();

		strumTecImpl.setNew(strumTec.isNew());
		strumTecImpl.setPrimaryKey(strumTec.getPrimaryKey());

		strumTecImpl.setId_strum(strumTec.getId_strum());
		strumTecImpl.setId_sala(strumTec.getId_sala());
		strumTecImpl.setEmail_ref(strumTec.getEmail_ref());

		return strumTecImpl;
	}

	/**
	 * Returns the strum tec with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the strum tec
	 * @return the strum tec
	 * @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	 */
	@Override
	public StrumTec findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStrumTecException {
		StrumTec strumTec = fetchByPrimaryKey(primaryKey);

		if (strumTec == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStrumTecException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return strumTec;
	}

	/**
	 * Returns the strum tec with the primary key or throws a {@link NoSuchStrumTecException} if it could not be found.
	 *
	 * @param strumTecPK the primary key of the strum tec
	 * @return the strum tec
	 * @throws NoSuchStrumTecException if a strum tec with the primary key could not be found
	 */
	@Override
	public StrumTec findByPrimaryKey(StrumTecPK strumTecPK)
		throws NoSuchStrumTecException {
		return findByPrimaryKey((Serializable)strumTecPK);
	}

	/**
	 * Returns the strum tec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the strum tec
	 * @return the strum tec, or <code>null</code> if a strum tec with the primary key could not be found
	 */
	@Override
	public StrumTec fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
				StrumTecImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StrumTec strumTec = (StrumTec)serializable;

		if (strumTec == null) {
			Session session = null;

			try {
				session = openSession();

				strumTec = (StrumTec)session.get(StrumTecImpl.class, primaryKey);

				if (strumTec != null) {
					cacheResult(strumTec);
				}
				else {
					entityCache.putResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
						StrumTecImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StrumTecModelImpl.ENTITY_CACHE_ENABLED,
					StrumTecImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return strumTec;
	}

	/**
	 * Returns the strum tec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param strumTecPK the primary key of the strum tec
	 * @return the strum tec, or <code>null</code> if a strum tec with the primary key could not be found
	 */
	@Override
	public StrumTec fetchByPrimaryKey(StrumTecPK strumTecPK) {
		return fetchByPrimaryKey((Serializable)strumTecPK);
	}

	@Override
	public Map<Serializable, StrumTec> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StrumTec> map = new HashMap<Serializable, StrumTec>();

		for (Serializable primaryKey : primaryKeys) {
			StrumTec strumTec = fetchByPrimaryKey(primaryKey);

			if (strumTec != null) {
				map.put(primaryKey, strumTec);
			}
		}

		return map;
	}

	/**
	 * Returns all the strum tecs.
	 *
	 * @return the strum tecs
	 */
	@Override
	public List<StrumTec> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strum tecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strum tecs
	 * @param end the upper bound of the range of strum tecs (not inclusive)
	 * @return the range of strum tecs
	 */
	@Override
	public List<StrumTec> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the strum tecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strum tecs
	 * @param end the upper bound of the range of strum tecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of strum tecs
	 */
	@Override
	public List<StrumTec> findAll(int start, int end,
		OrderByComparator<StrumTec> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strum tecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strum tecs
	 * @param end the upper bound of the range of strum tecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of strum tecs
	 */
	@Override
	public List<StrumTec> findAll(int start, int end,
		OrderByComparator<StrumTec> orderByComparator, boolean retrieveFromCache) {
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

		List<StrumTec> list = null;

		if (retrieveFromCache) {
			list = (List<StrumTec>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STRUMTEC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STRUMTEC;

				if (pagination) {
					sql = sql.concat(StrumTecModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StrumTec>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StrumTec>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the strum tecs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StrumTec strumTec : findAll()) {
			remove(strumTec);
		}
	}

	/**
	 * Returns the number of strum tecs.
	 *
	 * @return the number of strum tecs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STRUMTEC);

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
		return StrumTecModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the strum tec persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StrumTecImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STRUMTEC = "SELECT strumTec FROM StrumTec strumTec";
	private static final String _SQL_COUNT_STRUMTEC = "SELECT COUNT(strumTec) FROM StrumTec strumTec";
	private static final String _ORDER_BY_ENTITY_ALIAS = "strumTec.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StrumTec exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(StrumTecPersistenceImpl.class);
}