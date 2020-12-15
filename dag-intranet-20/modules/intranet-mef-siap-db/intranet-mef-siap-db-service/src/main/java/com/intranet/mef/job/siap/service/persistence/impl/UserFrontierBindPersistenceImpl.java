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

import com.intranet.mef.job.siap.exception.NoSuchUserFrontierBindException;
import com.intranet.mef.job.siap.model.UserFrontierBind;
import com.intranet.mef.job.siap.model.impl.UserFrontierBindImpl;
import com.intranet.mef.job.siap.model.impl.UserFrontierBindModelImpl;
import com.intranet.mef.job.siap.service.persistence.UserFrontierBindPK;
import com.intranet.mef.job.siap.service.persistence.UserFrontierBindPersistence;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the user frontier bind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFrontierBindPersistence
 * @see com.intranet.mef.job.siap.service.persistence.UserFrontierBindUtil
 * @generated
 */
@ProviderType
public class UserFrontierBindPersistenceImpl extends BasePersistenceImpl<UserFrontierBind>
	implements UserFrontierBindPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserFrontierBindUtil} to access the user frontier bind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserFrontierBindImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
			UserFrontierBindModelImpl.FINDER_CACHE_ENABLED,
			UserFrontierBindImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
			UserFrontierBindModelImpl.FINDER_CACHE_ENABLED,
			UserFrontierBindImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
			UserFrontierBindModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UserFrontierBindPersistenceImpl() {
		setModelClass(UserFrontierBind.class);
	}

	/**
	 * Caches the user frontier bind in the entity cache if it is enabled.
	 *
	 * @param userFrontierBind the user frontier bind
	 */
	@Override
	public void cacheResult(UserFrontierBind userFrontierBind) {
		entityCache.putResult(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
			UserFrontierBindImpl.class, userFrontierBind.getPrimaryKey(),
			userFrontierBind);

		userFrontierBind.resetOriginalValues();
	}

	/**
	 * Caches the user frontier binds in the entity cache if it is enabled.
	 *
	 * @param userFrontierBinds the user frontier binds
	 */
	@Override
	public void cacheResult(List<UserFrontierBind> userFrontierBinds) {
		for (UserFrontierBind userFrontierBind : userFrontierBinds) {
			if (entityCache.getResult(
						UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
						UserFrontierBindImpl.class,
						userFrontierBind.getPrimaryKey()) == null) {
				cacheResult(userFrontierBind);
			}
			else {
				userFrontierBind.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user frontier binds.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserFrontierBindImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user frontier bind.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserFrontierBind userFrontierBind) {
		entityCache.removeResult(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
			UserFrontierBindImpl.class, userFrontierBind.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserFrontierBind> userFrontierBinds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserFrontierBind userFrontierBind : userFrontierBinds) {
			entityCache.removeResult(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
				UserFrontierBindImpl.class, userFrontierBind.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user frontier bind with the primary key. Does not add the user frontier bind to the database.
	 *
	 * @param userFrontierBindPK the primary key for the new user frontier bind
	 * @return the new user frontier bind
	 */
	@Override
	public UserFrontierBind create(UserFrontierBindPK userFrontierBindPK) {
		UserFrontierBind userFrontierBind = new UserFrontierBindImpl();

		userFrontierBind.setNew(true);
		userFrontierBind.setPrimaryKey(userFrontierBindPK);

		return userFrontierBind;
	}

	/**
	 * Removes the user frontier bind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userFrontierBindPK the primary key of the user frontier bind
	 * @return the user frontier bind that was removed
	 * @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	 */
	@Override
	public UserFrontierBind remove(UserFrontierBindPK userFrontierBindPK)
		throws NoSuchUserFrontierBindException {
		return remove((Serializable)userFrontierBindPK);
	}

	/**
	 * Removes the user frontier bind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user frontier bind
	 * @return the user frontier bind that was removed
	 * @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	 */
	@Override
	public UserFrontierBind remove(Serializable primaryKey)
		throws NoSuchUserFrontierBindException {
		Session session = null;

		try {
			session = openSession();

			UserFrontierBind userFrontierBind = (UserFrontierBind)session.get(UserFrontierBindImpl.class,
					primaryKey);

			if (userFrontierBind == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserFrontierBindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userFrontierBind);
		}
		catch (NoSuchUserFrontierBindException nsee) {
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
	protected UserFrontierBind removeImpl(UserFrontierBind userFrontierBind) {
		userFrontierBind = toUnwrappedModel(userFrontierBind);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userFrontierBind)) {
				userFrontierBind = (UserFrontierBind)session.get(UserFrontierBindImpl.class,
						userFrontierBind.getPrimaryKeyObj());
			}

			if (userFrontierBind != null) {
				session.delete(userFrontierBind);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userFrontierBind != null) {
			clearCache(userFrontierBind);
		}

		return userFrontierBind;
	}

	@Override
	public UserFrontierBind updateImpl(UserFrontierBind userFrontierBind) {
		userFrontierBind = toUnwrappedModel(userFrontierBind);

		boolean isNew = userFrontierBind.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userFrontierBind.isNew()) {
				session.save(userFrontierBind);

				userFrontierBind.setNew(false);
			}
			else {
				userFrontierBind = (UserFrontierBind)session.merge(userFrontierBind);
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

		entityCache.putResult(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
			UserFrontierBindImpl.class, userFrontierBind.getPrimaryKey(),
			userFrontierBind, false);

		userFrontierBind.resetOriginalValues();

		return userFrontierBind;
	}

	protected UserFrontierBind toUnwrappedModel(
		UserFrontierBind userFrontierBind) {
		if (userFrontierBind instanceof UserFrontierBindImpl) {
			return userFrontierBind;
		}

		UserFrontierBindImpl userFrontierBindImpl = new UserFrontierBindImpl();

		userFrontierBindImpl.setNew(userFrontierBind.isNew());
		userFrontierBindImpl.setPrimaryKey(userFrontierBind.getPrimaryKey());

		userFrontierBindImpl.setPersonalId(userFrontierBind.getPersonalId());
		userFrontierBindImpl.setIdOrgChart(userFrontierBind.getIdOrgChart());
		userFrontierBindImpl.setIdDirector(userFrontierBind.getIdDirector());
		userFrontierBindImpl.setDateRecruitment(userFrontierBind.getDateRecruitment());
		userFrontierBindImpl.setDateStartAssignOffice(userFrontierBind.getDateStartAssignOffice());
		userFrontierBindImpl.setDateStartInquadramento(userFrontierBind.getDateStartInquadramento());
		userFrontierBindImpl.setDateStartFunction(userFrontierBind.getDateStartFunction());
		userFrontierBindImpl.setLevelId(userFrontierBind.getLevelId());
		userFrontierBindImpl.setScreenName(userFrontierBind.getScreenName());
		userFrontierBindImpl.setName(userFrontierBind.getName());
		userFrontierBindImpl.setSurName(userFrontierBind.getSurName());
		userFrontierBindImpl.setGender(userFrontierBind.getGender());
		userFrontierBindImpl.setEmail(userFrontierBind.getEmail());
		userFrontierBindImpl.setCodIstatBirth(userFrontierBind.getCodIstatBirth());
		userFrontierBindImpl.setDateBirth(userFrontierBind.getDateBirth());
		userFrontierBindImpl.setPersonalPhone(userFrontierBind.getPersonalPhone());
		userFrontierBindImpl.setWorkPhone(userFrontierBind.getWorkPhone());
		userFrontierBindImpl.setWorkFax(userFrontierBind.getWorkFax());
		userFrontierBindImpl.setPersonalStreet(userFrontierBind.getPersonalStreet());
		userFrontierBindImpl.setPersonalPostalCode(userFrontierBind.getPersonalPostalCode());
		userFrontierBindImpl.setPersonalCity(userFrontierBind.getPersonalCity());
		userFrontierBindImpl.setOfficeStreet1(userFrontierBind.getOfficeStreet1());
		userFrontierBindImpl.setOfficeStreet2(userFrontierBind.getOfficeStreet2());
		userFrontierBindImpl.setOfficeStreet3(userFrontierBind.getOfficeStreet3());
		userFrontierBindImpl.setOfficePostalCode(userFrontierBind.getOfficePostalCode());
		userFrontierBindImpl.setOfficeCity(userFrontierBind.getOfficeCity());
		userFrontierBindImpl.setGiuridicPos(userFrontierBind.getGiuridicPos());
		userFrontierBindImpl.setEconomicPos(userFrontierBind.getEconomicPos());

		return userFrontierBindImpl;
	}

	/**
	 * Returns the user frontier bind with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user frontier bind
	 * @return the user frontier bind
	 * @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	 */
	@Override
	public UserFrontierBind findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserFrontierBindException {
		UserFrontierBind userFrontierBind = fetchByPrimaryKey(primaryKey);

		if (userFrontierBind == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserFrontierBindException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userFrontierBind;
	}

	/**
	 * Returns the user frontier bind with the primary key or throws a {@link NoSuchUserFrontierBindException} if it could not be found.
	 *
	 * @param userFrontierBindPK the primary key of the user frontier bind
	 * @return the user frontier bind
	 * @throws NoSuchUserFrontierBindException if a user frontier bind with the primary key could not be found
	 */
	@Override
	public UserFrontierBind findByPrimaryKey(
		UserFrontierBindPK userFrontierBindPK)
		throws NoSuchUserFrontierBindException {
		return findByPrimaryKey((Serializable)userFrontierBindPK);
	}

	/**
	 * Returns the user frontier bind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user frontier bind
	 * @return the user frontier bind, or <code>null</code> if a user frontier bind with the primary key could not be found
	 */
	@Override
	public UserFrontierBind fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
				UserFrontierBindImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserFrontierBind userFrontierBind = (UserFrontierBind)serializable;

		if (userFrontierBind == null) {
			Session session = null;

			try {
				session = openSession();

				userFrontierBind = (UserFrontierBind)session.get(UserFrontierBindImpl.class,
						primaryKey);

				if (userFrontierBind != null) {
					cacheResult(userFrontierBind);
				}
				else {
					entityCache.putResult(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
						UserFrontierBindImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserFrontierBindModelImpl.ENTITY_CACHE_ENABLED,
					UserFrontierBindImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userFrontierBind;
	}

	/**
	 * Returns the user frontier bind with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userFrontierBindPK the primary key of the user frontier bind
	 * @return the user frontier bind, or <code>null</code> if a user frontier bind with the primary key could not be found
	 */
	@Override
	public UserFrontierBind fetchByPrimaryKey(
		UserFrontierBindPK userFrontierBindPK) {
		return fetchByPrimaryKey((Serializable)userFrontierBindPK);
	}

	@Override
	public Map<Serializable, UserFrontierBind> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserFrontierBind> map = new HashMap<Serializable, UserFrontierBind>();

		for (Serializable primaryKey : primaryKeys) {
			UserFrontierBind userFrontierBind = fetchByPrimaryKey(primaryKey);

			if (userFrontierBind != null) {
				map.put(primaryKey, userFrontierBind);
			}
		}

		return map;
	}

	/**
	 * Returns all the user frontier binds.
	 *
	 * @return the user frontier binds
	 */
	@Override
	public List<UserFrontierBind> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user frontier binds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user frontier binds
	 * @param end the upper bound of the range of user frontier binds (not inclusive)
	 * @return the range of user frontier binds
	 */
	@Override
	public List<UserFrontierBind> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user frontier binds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user frontier binds
	 * @param end the upper bound of the range of user frontier binds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user frontier binds
	 */
	@Override
	public List<UserFrontierBind> findAll(int start, int end,
		OrderByComparator<UserFrontierBind> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user frontier binds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFrontierBindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user frontier binds
	 * @param end the upper bound of the range of user frontier binds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user frontier binds
	 */
	@Override
	public List<UserFrontierBind> findAll(int start, int end,
		OrderByComparator<UserFrontierBind> orderByComparator,
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

		List<UserFrontierBind> list = null;

		if (retrieveFromCache) {
			list = (List<UserFrontierBind>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERFRONTIERBIND);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERFRONTIERBIND;

				if (pagination) {
					sql = sql.concat(UserFrontierBindModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserFrontierBind>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserFrontierBind>)QueryUtil.list(q,
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
	 * Removes all the user frontier binds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserFrontierBind userFrontierBind : findAll()) {
			remove(userFrontierBind);
		}
	}

	/**
	 * Returns the number of user frontier binds.
	 *
	 * @return the number of user frontier binds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERFRONTIERBIND);

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
		return UserFrontierBindModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user frontier bind persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserFrontierBindImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERFRONTIERBIND = "SELECT userFrontierBind FROM UserFrontierBind userFrontierBind";
	private static final String _SQL_COUNT_USERFRONTIERBIND = "SELECT COUNT(userFrontierBind) FROM UserFrontierBind userFrontierBind";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userFrontierBind.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserFrontierBind exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(UserFrontierBindPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personalId", "idOrgChart", "idDirector", "dateRecruitment",
				"dateStartAssignOffice", "dateStartInquadramento",
				"dateStartFunction", "levelId", "screenName", "name", "surName",
				"gender", "email", "codIstatBirth", "dateBirth", "personalPhone",
				"workPhone", "workFax", "personalStreet", "personalPostalCode",
				"personalCity", "officeStreet1", "officeStreet2",
				"officeStreet3", "officePostalCode", "officeCity", "giuridicPos",
				"economicPos"
			});
}