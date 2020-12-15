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

package external.bfc.intranet.mef.service.persistence.impl;

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

import external.bfc.intranet.mef.exception.NoSuchRichiesteSequenceException;
import external.bfc.intranet.mef.model.RichiesteSequence;
import external.bfc.intranet.mef.model.impl.RichiesteSequenceImpl;
import external.bfc.intranet.mef.model.impl.RichiesteSequenceModelImpl;
import external.bfc.intranet.mef.service.persistence.RichiesteSequencePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the richieste sequence service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequencePersistence
 * @see external.bfc.intranet.mef.service.persistence.RichiesteSequenceUtil
 * @generated
 */
@ProviderType
public class RichiesteSequencePersistenceImpl extends BasePersistenceImpl<RichiesteSequence>
	implements RichiesteSequencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiesteSequenceUtil} to access the richieste sequence persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiesteSequenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteSequenceModelImpl.FINDER_CACHE_ENABLED,
			RichiesteSequenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteSequenceModelImpl.FINDER_CACHE_ENABLED,
			RichiesteSequenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteSequenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RichiesteSequencePersistenceImpl() {
		setModelClass(RichiesteSequence.class);
	}

	/**
	 * Caches the richieste sequence in the entity cache if it is enabled.
	 *
	 * @param richiesteSequence the richieste sequence
	 */
	@Override
	public void cacheResult(RichiesteSequence richiesteSequence) {
		entityCache.putResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteSequenceImpl.class, richiesteSequence.getPrimaryKey(),
			richiesteSequence);

		richiesteSequence.resetOriginalValues();
	}

	/**
	 * Caches the richieste sequences in the entity cache if it is enabled.
	 *
	 * @param richiesteSequences the richieste sequences
	 */
	@Override
	public void cacheResult(List<RichiesteSequence> richiesteSequences) {
		for (RichiesteSequence richiesteSequence : richiesteSequences) {
			if (entityCache.getResult(
						RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteSequenceImpl.class,
						richiesteSequence.getPrimaryKey()) == null) {
				cacheResult(richiesteSequence);
			}
			else {
				richiesteSequence.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richieste sequences.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiesteSequenceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richieste sequence.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiesteSequence richiesteSequence) {
		entityCache.removeResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteSequenceImpl.class, richiesteSequence.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichiesteSequence> richiesteSequences) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichiesteSequence richiesteSequence : richiesteSequences) {
			entityCache.removeResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteSequenceImpl.class, richiesteSequence.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richieste sequence with the primary key. Does not add the richieste sequence to the database.
	 *
	 * @param idSeq the primary key for the new richieste sequence
	 * @return the new richieste sequence
	 */
	@Override
	public RichiesteSequence create(long idSeq) {
		RichiesteSequence richiesteSequence = new RichiesteSequenceImpl();

		richiesteSequence.setNew(true);
		richiesteSequence.setPrimaryKey(idSeq);

		return richiesteSequence;
	}

	/**
	 * Removes the richieste sequence with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idSeq the primary key of the richieste sequence
	 * @return the richieste sequence that was removed
	 * @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	 */
	@Override
	public RichiesteSequence remove(long idSeq)
		throws NoSuchRichiesteSequenceException {
		return remove((Serializable)idSeq);
	}

	/**
	 * Removes the richieste sequence with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richieste sequence
	 * @return the richieste sequence that was removed
	 * @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	 */
	@Override
	public RichiesteSequence remove(Serializable primaryKey)
		throws NoSuchRichiesteSequenceException {
		Session session = null;

		try {
			session = openSession();

			RichiesteSequence richiesteSequence = (RichiesteSequence)session.get(RichiesteSequenceImpl.class,
					primaryKey);

			if (richiesteSequence == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiesteSequenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richiesteSequence);
		}
		catch (NoSuchRichiesteSequenceException nsee) {
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
	protected RichiesteSequence removeImpl(RichiesteSequence richiesteSequence) {
		richiesteSequence = toUnwrappedModel(richiesteSequence);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiesteSequence)) {
				richiesteSequence = (RichiesteSequence)session.get(RichiesteSequenceImpl.class,
						richiesteSequence.getPrimaryKeyObj());
			}

			if (richiesteSequence != null) {
				session.delete(richiesteSequence);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiesteSequence != null) {
			clearCache(richiesteSequence);
		}

		return richiesteSequence;
	}

	@Override
	public RichiesteSequence updateImpl(RichiesteSequence richiesteSequence) {
		richiesteSequence = toUnwrappedModel(richiesteSequence);

		boolean isNew = richiesteSequence.isNew();

		Session session = null;

		try {
			session = openSession();

			if (richiesteSequence.isNew()) {
				session.save(richiesteSequence);

				richiesteSequence.setNew(false);
			}
			else {
				richiesteSequence = (RichiesteSequence)session.merge(richiesteSequence);
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

		entityCache.putResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteSequenceImpl.class, richiesteSequence.getPrimaryKey(),
			richiesteSequence, false);

		richiesteSequence.resetOriginalValues();

		return richiesteSequence;
	}

	protected RichiesteSequence toUnwrappedModel(
		RichiesteSequence richiesteSequence) {
		if (richiesteSequence instanceof RichiesteSequenceImpl) {
			return richiesteSequence;
		}

		RichiesteSequenceImpl richiesteSequenceImpl = new RichiesteSequenceImpl();

		richiesteSequenceImpl.setNew(richiesteSequence.isNew());
		richiesteSequenceImpl.setPrimaryKey(richiesteSequence.getPrimaryKey());

		richiesteSequenceImpl.setIdSeq(richiesteSequence.getIdSeq());

		return richiesteSequenceImpl;
	}

	/**
	 * Returns the richieste sequence with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste sequence
	 * @return the richieste sequence
	 * @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	 */
	@Override
	public RichiesteSequence findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiesteSequenceException {
		RichiesteSequence richiesteSequence = fetchByPrimaryKey(primaryKey);

		if (richiesteSequence == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiesteSequenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richiesteSequence;
	}

	/**
	 * Returns the richieste sequence with the primary key or throws a {@link NoSuchRichiesteSequenceException} if it could not be found.
	 *
	 * @param idSeq the primary key of the richieste sequence
	 * @return the richieste sequence
	 * @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	 */
	@Override
	public RichiesteSequence findByPrimaryKey(long idSeq)
		throws NoSuchRichiesteSequenceException {
		return findByPrimaryKey((Serializable)idSeq);
	}

	/**
	 * Returns the richieste sequence with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste sequence
	 * @return the richieste sequence, or <code>null</code> if a richieste sequence with the primary key could not be found
	 */
	@Override
	public RichiesteSequence fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteSequenceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichiesteSequence richiesteSequence = (RichiesteSequence)serializable;

		if (richiesteSequence == null) {
			Session session = null;

			try {
				session = openSession();

				richiesteSequence = (RichiesteSequence)session.get(RichiesteSequenceImpl.class,
						primaryKey);

				if (richiesteSequence != null) {
					cacheResult(richiesteSequence);
				}
				else {
					entityCache.putResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteSequenceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteSequenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiesteSequence;
	}

	/**
	 * Returns the richieste sequence with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idSeq the primary key of the richieste sequence
	 * @return the richieste sequence, or <code>null</code> if a richieste sequence with the primary key could not be found
	 */
	@Override
	public RichiesteSequence fetchByPrimaryKey(long idSeq) {
		return fetchByPrimaryKey((Serializable)idSeq);
	}

	@Override
	public Map<Serializable, RichiesteSequence> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichiesteSequence> map = new HashMap<Serializable, RichiesteSequence>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichiesteSequence richiesteSequence = fetchByPrimaryKey(primaryKey);

			if (richiesteSequence != null) {
				map.put(primaryKey, richiesteSequence);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteSequenceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichiesteSequence)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTESEQUENCE_WHERE_PKS_IN);

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

			for (RichiesteSequence richiesteSequence : (List<RichiesteSequence>)q.list()) {
				map.put(richiesteSequence.getPrimaryKeyObj(), richiesteSequence);

				cacheResult(richiesteSequence);

				uncachedPrimaryKeys.remove(richiesteSequence.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiesteSequenceModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteSequenceImpl.class, primaryKey, nullModel);
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
	 * Returns all the richieste sequences.
	 *
	 * @return the richieste sequences
	 */
	@Override
	public List<RichiesteSequence> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richieste sequences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste sequences
	 * @param end the upper bound of the range of richieste sequences (not inclusive)
	 * @return the range of richieste sequences
	 */
	@Override
	public List<RichiesteSequence> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richieste sequences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste sequences
	 * @param end the upper bound of the range of richieste sequences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richieste sequences
	 */
	@Override
	public List<RichiesteSequence> findAll(int start, int end,
		OrderByComparator<RichiesteSequence> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richieste sequences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richieste sequences
	 * @param end the upper bound of the range of richieste sequences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richieste sequences
	 */
	@Override
	public List<RichiesteSequence> findAll(int start, int end,
		OrderByComparator<RichiesteSequence> orderByComparator,
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

		List<RichiesteSequence> list = null;

		if (retrieveFromCache) {
			list = (List<RichiesteSequence>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTESEQUENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTESEQUENCE;

				if (pagination) {
					sql = sql.concat(RichiesteSequenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichiesteSequence>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiesteSequence>)QueryUtil.list(q,
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
	 * Removes all the richieste sequences from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiesteSequence richiesteSequence : findAll()) {
			remove(richiesteSequence);
		}
	}

	/**
	 * Returns the number of richieste sequences.
	 *
	 * @return the number of richieste sequences
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTESEQUENCE);

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
		return RichiesteSequenceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richieste sequence persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiesteSequenceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTESEQUENCE = "SELECT richiesteSequence FROM RichiesteSequence richiesteSequence";
	private static final String _SQL_SELECT_RICHIESTESEQUENCE_WHERE_PKS_IN = "SELECT richiesteSequence FROM RichiesteSequence richiesteSequence WHERE READ_SEQ_BFC IN (";
	private static final String _SQL_COUNT_RICHIESTESEQUENCE = "SELECT COUNT(richiesteSequence) FROM RichiesteSequence richiesteSequence";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richiesteSequence.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichiesteSequence exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RichiesteSequencePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"idSeq"
			});
}