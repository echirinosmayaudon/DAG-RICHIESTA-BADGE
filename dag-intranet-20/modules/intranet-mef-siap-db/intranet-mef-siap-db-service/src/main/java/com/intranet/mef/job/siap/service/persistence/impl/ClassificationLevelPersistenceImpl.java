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

package com.intranet.mef.job.siap.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.job.siap.exception.NoSuchClassificationLevelException;
import com.intranet.mef.job.siap.model.ClassificationLevel;
import com.intranet.mef.job.siap.model.impl.ClassificationLevelImpl;
import com.intranet.mef.job.siap.model.impl.ClassificationLevelModelImpl;
import com.intranet.mef.job.siap.service.persistence.ClassificationLevelPersistence;

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

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the classification level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClassificationLevelPersistence
 * @see com.intranet.mef.job.siap.service.persistence.ClassificationLevelUtil
 * @generated
 */
@ProviderType
public class ClassificationLevelPersistenceImpl extends BasePersistenceImpl<ClassificationLevel>
	implements ClassificationLevelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClassificationLevelUtil} to access the classification level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClassificationLevelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
			ClassificationLevelModelImpl.FINDER_CACHE_ENABLED,
			ClassificationLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
			ClassificationLevelModelImpl.FINDER_CACHE_ENABLED,
			ClassificationLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
			ClassificationLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ClassificationLevelPersistenceImpl() {
		setModelClass(ClassificationLevel.class);
	}

	/**
	 * Caches the classification level in the entity cache if it is enabled.
	 *
	 * @param classificationLevel the classification level
	 */
	@Override
	public void cacheResult(ClassificationLevel classificationLevel) {
		entityCache.putResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
			ClassificationLevelImpl.class, classificationLevel.getPrimaryKey(),
			classificationLevel);

		classificationLevel.resetOriginalValues();
	}

	/**
	 * Caches the classification levels in the entity cache if it is enabled.
	 *
	 * @param classificationLevels the classification levels
	 */
	@Override
	public void cacheResult(List<ClassificationLevel> classificationLevels) {
		for (ClassificationLevel classificationLevel : classificationLevels) {
			if (entityCache.getResult(
						ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
						ClassificationLevelImpl.class,
						classificationLevel.getPrimaryKey()) == null) {
				cacheResult(classificationLevel);
			}
			else {
				classificationLevel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all classification levels.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClassificationLevelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the classification level.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClassificationLevel classificationLevel) {
		entityCache.removeResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
			ClassificationLevelImpl.class, classificationLevel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ClassificationLevel> classificationLevels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClassificationLevel classificationLevel : classificationLevels) {
			entityCache.removeResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
				ClassificationLevelImpl.class,
				classificationLevel.getPrimaryKey());
		}
	}

	/**
	 * Creates a new classification level with the primary key. Does not add the classification level to the database.
	 *
	 * @param levelID the primary key for the new classification level
	 * @return the new classification level
	 */
	@Override
	public ClassificationLevel create(long levelID) {
		ClassificationLevel classificationLevel = new ClassificationLevelImpl();

		classificationLevel.setNew(true);
		classificationLevel.setPrimaryKey(levelID);

		return classificationLevel;
	}

	/**
	 * Removes the classification level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelID the primary key of the classification level
	 * @return the classification level that was removed
	 * @throws NoSuchClassificationLevelException if a classification level with the primary key could not be found
	 */
	@Override
	public ClassificationLevel remove(long levelID)
		throws NoSuchClassificationLevelException {
		return remove((Serializable)levelID);
	}

	/**
	 * Removes the classification level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the classification level
	 * @return the classification level that was removed
	 * @throws NoSuchClassificationLevelException if a classification level with the primary key could not be found
	 */
	@Override
	public ClassificationLevel remove(Serializable primaryKey)
		throws NoSuchClassificationLevelException {
		Session session = null;

		try {
			session = openSession();

			ClassificationLevel classificationLevel = (ClassificationLevel)session.get(ClassificationLevelImpl.class,
					primaryKey);

			if (classificationLevel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClassificationLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(classificationLevel);
		}
		catch (NoSuchClassificationLevelException nsee) {
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
	protected ClassificationLevel removeImpl(
		ClassificationLevel classificationLevel) {
		classificationLevel = toUnwrappedModel(classificationLevel);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(classificationLevel)) {
				classificationLevel = (ClassificationLevel)session.get(ClassificationLevelImpl.class,
						classificationLevel.getPrimaryKeyObj());
			}

			if (classificationLevel != null) {
				session.delete(classificationLevel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (classificationLevel != null) {
			clearCache(classificationLevel);
		}

		return classificationLevel;
	}

	@Override
	public ClassificationLevel updateImpl(
		ClassificationLevel classificationLevel) {
		classificationLevel = toUnwrappedModel(classificationLevel);

		boolean isNew = classificationLevel.isNew();

		Session session = null;

		try {
			session = openSession();

			if (classificationLevel.isNew()) {
				session.save(classificationLevel);

				classificationLevel.setNew(false);
			}
			else {
				classificationLevel = (ClassificationLevel)session.merge(classificationLevel);
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

		entityCache.putResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
			ClassificationLevelImpl.class, classificationLevel.getPrimaryKey(),
			classificationLevel, false);

		classificationLevel.resetOriginalValues();

		return classificationLevel;
	}

	protected ClassificationLevel toUnwrappedModel(
		ClassificationLevel classificationLevel) {
		if (classificationLevel instanceof ClassificationLevelImpl) {
			return classificationLevel;
		}

		ClassificationLevelImpl classificationLevelImpl = new ClassificationLevelImpl();

		classificationLevelImpl.setNew(classificationLevel.isNew());
		classificationLevelImpl.setPrimaryKey(classificationLevel.getPrimaryKey());

		classificationLevelImpl.setLevelID(classificationLevel.getLevelID());
		classificationLevelImpl.setCodLegalPos(classificationLevel.getCodLegalPos());
		classificationLevelImpl.setDescLegalPos(classificationLevel.getDescLegalPos());
		classificationLevelImpl.setCodEconomicPos(classificationLevel.getCodEconomicPos());
		classificationLevelImpl.setDescEconomicPos(classificationLevel.getDescEconomicPos());
		classificationLevelImpl.setArea(classificationLevel.getArea());

		return classificationLevelImpl;
	}

	/**
	 * Returns the classification level with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the classification level
	 * @return the classification level
	 * @throws NoSuchClassificationLevelException if a classification level with the primary key could not be found
	 */
	@Override
	public ClassificationLevel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClassificationLevelException {
		ClassificationLevel classificationLevel = fetchByPrimaryKey(primaryKey);

		if (classificationLevel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClassificationLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return classificationLevel;
	}

	/**
	 * Returns the classification level with the primary key or throws a {@link NoSuchClassificationLevelException} if it could not be found.
	 *
	 * @param levelID the primary key of the classification level
	 * @return the classification level
	 * @throws NoSuchClassificationLevelException if a classification level with the primary key could not be found
	 */
	@Override
	public ClassificationLevel findByPrimaryKey(long levelID)
		throws NoSuchClassificationLevelException {
		return findByPrimaryKey((Serializable)levelID);
	}

	/**
	 * Returns the classification level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the classification level
	 * @return the classification level, or <code>null</code> if a classification level with the primary key could not be found
	 */
	@Override
	public ClassificationLevel fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
				ClassificationLevelImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ClassificationLevel classificationLevel = (ClassificationLevel)serializable;

		if (classificationLevel == null) {
			Session session = null;

			try {
				session = openSession();

				classificationLevel = (ClassificationLevel)session.get(ClassificationLevelImpl.class,
						primaryKey);

				if (classificationLevel != null) {
					cacheResult(classificationLevel);
				}
				else {
					entityCache.putResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
						ClassificationLevelImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
					ClassificationLevelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return classificationLevel;
	}

	/**
	 * Returns the classification level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param levelID the primary key of the classification level
	 * @return the classification level, or <code>null</code> if a classification level with the primary key could not be found
	 */
	@Override
	public ClassificationLevel fetchByPrimaryKey(long levelID) {
		return fetchByPrimaryKey((Serializable)levelID);
	}

	@Override
	public Map<Serializable, ClassificationLevel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ClassificationLevel> map = new HashMap<Serializable, ClassificationLevel>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ClassificationLevel classificationLevel = fetchByPrimaryKey(primaryKey);

			if (classificationLevel != null) {
				map.put(primaryKey, classificationLevel);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
					ClassificationLevelImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ClassificationLevel)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CLASSIFICATIONLEVEL_WHERE_PKS_IN);

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

			for (ClassificationLevel classificationLevel : (List<ClassificationLevel>)q.list()) {
				map.put(classificationLevel.getPrimaryKeyObj(),
					classificationLevel);

				cacheResult(classificationLevel);

				uncachedPrimaryKeys.remove(classificationLevel.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ClassificationLevelModelImpl.ENTITY_CACHE_ENABLED,
					ClassificationLevelImpl.class, primaryKey, nullModel);
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
	 * Returns all the classification levels.
	 *
	 * @return the classification levels
	 */
	@Override
	public List<ClassificationLevel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the classification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClassificationLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of classification levels
	 * @param end the upper bound of the range of classification levels (not inclusive)
	 * @return the range of classification levels
	 */
	@Override
	public List<ClassificationLevel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the classification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClassificationLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of classification levels
	 * @param end the upper bound of the range of classification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of classification levels
	 */
	@Override
	public List<ClassificationLevel> findAll(int start, int end,
		OrderByComparator<ClassificationLevel> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the classification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClassificationLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of classification levels
	 * @param end the upper bound of the range of classification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of classification levels
	 */
	@Override
	public List<ClassificationLevel> findAll(int start, int end,
		OrderByComparator<ClassificationLevel> orderByComparator,
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

		List<ClassificationLevel> list = null;

		if (retrieveFromCache) {
			list = (List<ClassificationLevel>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CLASSIFICATIONLEVEL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLASSIFICATIONLEVEL;

				if (pagination) {
					sql = sql.concat(ClassificationLevelModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ClassificationLevel>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ClassificationLevel>)QueryUtil.list(q,
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
	 * Removes all the classification levels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClassificationLevel classificationLevel : findAll()) {
			remove(classificationLevel);
		}
	}

	/**
	 * Returns the number of classification levels.
	 *
	 * @return the number of classification levels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLASSIFICATIONLEVEL);

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
		return ClassificationLevelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the classification level persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ClassificationLevelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CLASSIFICATIONLEVEL = "SELECT classificationLevel FROM ClassificationLevel classificationLevel";
	private static final String _SQL_SELECT_CLASSIFICATIONLEVEL_WHERE_PKS_IN = "SELECT classificationLevel FROM ClassificationLevel classificationLevel WHERE LEVEL_ID IN (";
	private static final String _SQL_COUNT_CLASSIFICATIONLEVEL = "SELECT COUNT(classificationLevel) FROM ClassificationLevel classificationLevel";
	private static final String _ORDER_BY_ENTITY_ALIAS = "classificationLevel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ClassificationLevel exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ClassificationLevelPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"levelID", "codLegalPos", "descLegalPos", "codEconomicPos",
				"descEconomicPos", "area"
			});
}