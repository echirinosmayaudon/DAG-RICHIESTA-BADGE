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

import com.intranet.mef.job.siap.exception.NoSuchProfilePictureException;
import com.intranet.mef.job.siap.model.ProfilePicture;
import com.intranet.mef.job.siap.model.impl.ProfilePictureImpl;
import com.intranet.mef.job.siap.model.impl.ProfilePictureModelImpl;
import com.intranet.mef.job.siap.service.persistence.ProfilePicturePersistence;

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
 * The persistence implementation for the profile picture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfilePicturePersistence
 * @see com.intranet.mef.job.siap.service.persistence.ProfilePictureUtil
 * @generated
 */
@ProviderType
public class ProfilePicturePersistenceImpl extends BasePersistenceImpl<ProfilePicture>
	implements ProfilePicturePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProfilePictureUtil} to access the profile picture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProfilePictureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePictureModelImpl.FINDER_CACHE_ENABLED,
			ProfilePictureImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePictureModelImpl.FINDER_CACHE_ENABLED,
			ProfilePictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePictureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProfilePicturePersistenceImpl() {
		setModelClass(ProfilePicture.class);
	}

	/**
	 * Caches the profile picture in the entity cache if it is enabled.
	 *
	 * @param profilePicture the profile picture
	 */
	@Override
	public void cacheResult(ProfilePicture profilePicture) {
		entityCache.putResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePictureImpl.class, profilePicture.getPrimaryKey(),
			profilePicture);

		profilePicture.resetOriginalValues();
	}

	/**
	 * Caches the profile pictures in the entity cache if it is enabled.
	 *
	 * @param profilePictures the profile pictures
	 */
	@Override
	public void cacheResult(List<ProfilePicture> profilePictures) {
		for (ProfilePicture profilePicture : profilePictures) {
			if (entityCache.getResult(
						ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
						ProfilePictureImpl.class, profilePicture.getPrimaryKey()) == null) {
				cacheResult(profilePicture);
			}
			else {
				profilePicture.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all profile pictures.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProfilePictureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the profile picture.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProfilePicture profilePicture) {
		entityCache.removeResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePictureImpl.class, profilePicture.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProfilePicture> profilePictures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProfilePicture profilePicture : profilePictures) {
			entityCache.removeResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
				ProfilePictureImpl.class, profilePicture.getPrimaryKey());
		}
	}

	/**
	 * Creates a new profile picture with the primary key. Does not add the profile picture to the database.
	 *
	 * @param personID the primary key for the new profile picture
	 * @return the new profile picture
	 */
	@Override
	public ProfilePicture create(long personID) {
		ProfilePicture profilePicture = new ProfilePictureImpl();

		profilePicture.setNew(true);
		profilePicture.setPrimaryKey(personID);

		return profilePicture;
	}

	/**
	 * Removes the profile picture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personID the primary key of the profile picture
	 * @return the profile picture that was removed
	 * @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	 */
	@Override
	public ProfilePicture remove(long personID)
		throws NoSuchProfilePictureException {
		return remove((Serializable)personID);
	}

	/**
	 * Removes the profile picture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile picture
	 * @return the profile picture that was removed
	 * @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	 */
	@Override
	public ProfilePicture remove(Serializable primaryKey)
		throws NoSuchProfilePictureException {
		Session session = null;

		try {
			session = openSession();

			ProfilePicture profilePicture = (ProfilePicture)session.get(ProfilePictureImpl.class,
					primaryKey);

			if (profilePicture == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfilePictureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(profilePicture);
		}
		catch (NoSuchProfilePictureException nsee) {
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
	protected ProfilePicture removeImpl(ProfilePicture profilePicture) {
		profilePicture = toUnwrappedModel(profilePicture);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(profilePicture)) {
				profilePicture = (ProfilePicture)session.get(ProfilePictureImpl.class,
						profilePicture.getPrimaryKeyObj());
			}

			if (profilePicture != null) {
				session.delete(profilePicture);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (profilePicture != null) {
			clearCache(profilePicture);
		}

		return profilePicture;
	}

	@Override
	public ProfilePicture updateImpl(ProfilePicture profilePicture) {
		profilePicture = toUnwrappedModel(profilePicture);

		boolean isNew = profilePicture.isNew();

		Session session = null;

		try {
			session = openSession();

			if (profilePicture.isNew()) {
				session.save(profilePicture);

				profilePicture.setNew(false);
			}
			else {
				session.evict(profilePicture);
				session.saveOrUpdate(profilePicture);
			}

			session.flush();
			session.clear();
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

		entityCache.putResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePictureImpl.class, profilePicture.getPrimaryKey(),
			profilePicture, false);

		profilePicture.resetOriginalValues();

		return profilePicture;
	}

	protected ProfilePicture toUnwrappedModel(ProfilePicture profilePicture) {
		if (profilePicture instanceof ProfilePictureImpl) {
			return profilePicture;
		}

		ProfilePictureImpl profilePictureImpl = new ProfilePictureImpl();

		profilePictureImpl.setNew(profilePicture.isNew());
		profilePictureImpl.setPrimaryKey(profilePicture.getPrimaryKey());

		profilePictureImpl.setPersonID(profilePicture.getPersonID());
		profilePictureImpl.setFile(profilePicture.getFile());

		return profilePictureImpl;
	}

	/**
	 * Returns the profile picture with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile picture
	 * @return the profile picture
	 * @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	 */
	@Override
	public ProfilePicture findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProfilePictureException {
		ProfilePicture profilePicture = fetchByPrimaryKey(primaryKey);

		if (profilePicture == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProfilePictureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return profilePicture;
	}

	/**
	 * Returns the profile picture with the primary key or throws a {@link NoSuchProfilePictureException} if it could not be found.
	 *
	 * @param personID the primary key of the profile picture
	 * @return the profile picture
	 * @throws NoSuchProfilePictureException if a profile picture with the primary key could not be found
	 */
	@Override
	public ProfilePicture findByPrimaryKey(long personID)
		throws NoSuchProfilePictureException {
		return findByPrimaryKey((Serializable)personID);
	}

	/**
	 * Returns the profile picture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile picture
	 * @return the profile picture, or <code>null</code> if a profile picture with the primary key could not be found
	 */
	@Override
	public ProfilePicture fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
				ProfilePictureImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProfilePicture profilePicture = (ProfilePicture)serializable;

		if (profilePicture == null) {
			Session session = null;

			try {
				session = openSession();

				profilePicture = (ProfilePicture)session.get(ProfilePictureImpl.class,
						primaryKey);

				if (profilePicture != null) {
					cacheResult(profilePicture);
				}
				else {
					entityCache.putResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
						ProfilePictureImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
					ProfilePictureImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return profilePicture;
	}

	/**
	 * Returns the profile picture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personID the primary key of the profile picture
	 * @return the profile picture, or <code>null</code> if a profile picture with the primary key could not be found
	 */
	@Override
	public ProfilePicture fetchByPrimaryKey(long personID) {
		return fetchByPrimaryKey((Serializable)personID);
	}

	@Override
	public Map<Serializable, ProfilePicture> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProfilePicture> map = new HashMap<Serializable, ProfilePicture>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProfilePicture profilePicture = fetchByPrimaryKey(primaryKey);

			if (profilePicture != null) {
				map.put(primaryKey, profilePicture);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
					ProfilePictureImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProfilePicture)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROFILEPICTURE_WHERE_PKS_IN);

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

			for (ProfilePicture profilePicture : (List<ProfilePicture>)q.list()) {
				map.put(profilePicture.getPrimaryKeyObj(), profilePicture);

				cacheResult(profilePicture);

				uncachedPrimaryKeys.remove(profilePicture.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProfilePictureModelImpl.ENTITY_CACHE_ENABLED,
					ProfilePictureImpl.class, primaryKey, nullModel);
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
	 * Returns all the profile pictures.
	 *
	 * @return the profile pictures
	 */
	@Override
	public List<ProfilePicture> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile pictures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile pictures
	 * @param end the upper bound of the range of profile pictures (not inclusive)
	 * @return the range of profile pictures
	 */
	@Override
	public List<ProfilePicture> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile pictures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile pictures
	 * @param end the upper bound of the range of profile pictures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile pictures
	 */
	@Override
	public List<ProfilePicture> findAll(int start, int end,
		OrderByComparator<ProfilePicture> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the profile pictures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProfilePictureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile pictures
	 * @param end the upper bound of the range of profile pictures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of profile pictures
	 */
	@Override
	public List<ProfilePicture> findAll(int start, int end,
		OrderByComparator<ProfilePicture> orderByComparator,
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

		List<ProfilePicture> list = null;

		if (retrieveFromCache) {
			list = (List<ProfilePicture>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROFILEPICTURE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILEPICTURE;

				if (pagination) {
					sql = sql.concat(ProfilePictureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProfilePicture>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProfilePicture>)QueryUtil.list(q,
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
	 * Removes all the profile pictures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProfilePicture profilePicture : findAll()) {
			remove(profilePicture);
		}
	}

	/**
	 * Returns the number of profile pictures.
	 *
	 * @return the number of profile pictures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROFILEPICTURE);

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
		return ProfilePictureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the profile picture persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProfilePictureImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROFILEPICTURE = "SELECT profilePicture FROM ProfilePicture profilePicture";
	private static final String _SQL_SELECT_PROFILEPICTURE_WHERE_PKS_IN = "SELECT profilePicture FROM ProfilePicture profilePicture WHERE PERSON_ID IN (";
	private static final String _SQL_COUNT_PROFILEPICTURE = "SELECT COUNT(profilePicture) FROM ProfilePicture profilePicture";
	private static final String _ORDER_BY_ENTITY_ALIAS = "profilePicture.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProfilePicture exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ProfilePicturePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"personID", "file"
			});
}