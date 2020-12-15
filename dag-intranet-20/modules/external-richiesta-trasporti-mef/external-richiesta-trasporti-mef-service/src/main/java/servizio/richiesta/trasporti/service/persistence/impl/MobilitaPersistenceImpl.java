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

package servizio.richiesta.trasporti.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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

import servizio.richiesta.trasporti.exception.NoSuchMobilitaException;
import servizio.richiesta.trasporti.model.Mobilita;
import servizio.richiesta.trasporti.model.impl.MobilitaImpl;
import servizio.richiesta.trasporti.model.impl.MobilitaModelImpl;
import servizio.richiesta.trasporti.service.persistence.MobilitaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the mobilita service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MobilitaPersistence
 * @see servizio.richiesta.trasporti.service.persistence.MobilitaUtil
 * @generated
 */
@ProviderType
public class MobilitaPersistenceImpl extends BasePersistenceImpl<Mobilita>
	implements MobilitaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MobilitaUtil} to access the mobilita persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MobilitaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaModelImpl.FINDER_CACHE_ENABLED, MobilitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaModelImpl.FINDER_CACHE_ENABLED, MobilitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID = new FinderPath(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaModelImpl.FINDER_CACHE_ENABLED, MobilitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersonId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID =
		new FinderPath(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaModelImpl.FINDER_CACHE_ENABLED, MobilitaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPersonId",
			new String[] { Long.class.getName() },
			MobilitaModelImpl.PERSON_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSONID = new FinderPath(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the mobilitas where person_id = &#63;.
	 *
	 * @param person_id the person_id
	 * @return the matching mobilitas
	 */
	@Override
	public List<Mobilita> findByPersonId(long person_id) {
		return findByPersonId(person_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the mobilitas where person_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param person_id the person_id
	 * @param start the lower bound of the range of mobilitas
	 * @param end the upper bound of the range of mobilitas (not inclusive)
	 * @return the range of matching mobilitas
	 */
	@Override
	public List<Mobilita> findByPersonId(long person_id, int start, int end) {
		return findByPersonId(person_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the mobilitas where person_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param person_id the person_id
	 * @param start the lower bound of the range of mobilitas
	 * @param end the upper bound of the range of mobilitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mobilitas
	 */
	@Override
	public List<Mobilita> findByPersonId(long person_id, int start, int end,
		OrderByComparator<Mobilita> orderByComparator) {
		return findByPersonId(person_id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mobilitas where person_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param person_id the person_id
	 * @param start the lower bound of the range of mobilitas
	 * @param end the upper bound of the range of mobilitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching mobilitas
	 */
	@Override
	public List<Mobilita> findByPersonId(long person_id, int start, int end,
		OrderByComparator<Mobilita> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { person_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSONID;
			finderArgs = new Object[] { person_id, start, end, orderByComparator };
		}

		List<Mobilita> list = null;

		if (retrieveFromCache) {
			list = (List<Mobilita>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Mobilita mobilita : list) {
					if ((person_id != mobilita.getPerson_id())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MOBILITA_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSON_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MobilitaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(person_id);

				if (!pagination) {
					list = (List<Mobilita>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Mobilita>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first mobilita in the ordered set where person_id = &#63;.
	 *
	 * @param person_id the person_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mobilita
	 * @throws NoSuchMobilitaException if a matching mobilita could not be found
	 */
	@Override
	public Mobilita findByPersonId_First(long person_id,
		OrderByComparator<Mobilita> orderByComparator)
		throws NoSuchMobilitaException {
		Mobilita mobilita = fetchByPersonId_First(person_id, orderByComparator);

		if (mobilita != null) {
			return mobilita;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("person_id=");
		msg.append(person_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMobilitaException(msg.toString());
	}

	/**
	 * Returns the first mobilita in the ordered set where person_id = &#63;.
	 *
	 * @param person_id the person_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mobilita, or <code>null</code> if a matching mobilita could not be found
	 */
	@Override
	public Mobilita fetchByPersonId_First(long person_id,
		OrderByComparator<Mobilita> orderByComparator) {
		List<Mobilita> list = findByPersonId(person_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mobilita in the ordered set where person_id = &#63;.
	 *
	 * @param person_id the person_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mobilita
	 * @throws NoSuchMobilitaException if a matching mobilita could not be found
	 */
	@Override
	public Mobilita findByPersonId_Last(long person_id,
		OrderByComparator<Mobilita> orderByComparator)
		throws NoSuchMobilitaException {
		Mobilita mobilita = fetchByPersonId_Last(person_id, orderByComparator);

		if (mobilita != null) {
			return mobilita;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("person_id=");
		msg.append(person_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMobilitaException(msg.toString());
	}

	/**
	 * Returns the last mobilita in the ordered set where person_id = &#63;.
	 *
	 * @param person_id the person_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mobilita, or <code>null</code> if a matching mobilita could not be found
	 */
	@Override
	public Mobilita fetchByPersonId_Last(long person_id,
		OrderByComparator<Mobilita> orderByComparator) {
		int count = countByPersonId(person_id);

		if (count == 0) {
			return null;
		}

		List<Mobilita> list = findByPersonId(person_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the mobilitas before and after the current mobilita in the ordered set where person_id = &#63;.
	 *
	 * @param custom_key the primary key of the current mobilita
	 * @param person_id the person_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mobilita
	 * @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	 */
	@Override
	public Mobilita[] findByPersonId_PrevAndNext(String custom_key,
		long person_id, OrderByComparator<Mobilita> orderByComparator)
		throws NoSuchMobilitaException {
		Mobilita mobilita = findByPrimaryKey(custom_key);

		Session session = null;

		try {
			session = openSession();

			Mobilita[] array = new MobilitaImpl[3];

			array[0] = getByPersonId_PrevAndNext(session, mobilita, person_id,
					orderByComparator, true);

			array[1] = mobilita;

			array[2] = getByPersonId_PrevAndNext(session, mobilita, person_id,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Mobilita getByPersonId_PrevAndNext(Session session,
		Mobilita mobilita, long person_id,
		OrderByComparator<Mobilita> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MOBILITA_WHERE);

		query.append(_FINDER_COLUMN_PERSONID_PERSON_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MobilitaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(person_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(mobilita);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Mobilita> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the mobilitas where person_id = &#63; from the database.
	 *
	 * @param person_id the person_id
	 */
	@Override
	public void removeByPersonId(long person_id) {
		for (Mobilita mobilita : findByPersonId(person_id, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(mobilita);
		}
	}

	/**
	 * Returns the number of mobilitas where person_id = &#63;.
	 *
	 * @param person_id the person_id
	 * @return the number of matching mobilitas
	 */
	@Override
	public int countByPersonId(long person_id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSONID;

		Object[] finderArgs = new Object[] { person_id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MOBILITA_WHERE);

			query.append(_FINDER_COLUMN_PERSONID_PERSON_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(person_id);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PERSONID_PERSON_ID_2 = "mobilita.person_id = ?";

	public MobilitaPersistenceImpl() {
		setModelClass(Mobilita.class);
	}

	/**
	 * Caches the mobilita in the entity cache if it is enabled.
	 *
	 * @param mobilita the mobilita
	 */
	@Override
	public void cacheResult(Mobilita mobilita) {
		entityCache.putResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaImpl.class, mobilita.getPrimaryKey(), mobilita);

		mobilita.resetOriginalValues();
	}

	/**
	 * Caches the mobilitas in the entity cache if it is enabled.
	 *
	 * @param mobilitas the mobilitas
	 */
	@Override
	public void cacheResult(List<Mobilita> mobilitas) {
		for (Mobilita mobilita : mobilitas) {
			if (entityCache.getResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
						MobilitaImpl.class, mobilita.getPrimaryKey()) == null) {
				cacheResult(mobilita);
			}
			else {
				mobilita.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mobilitas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MobilitaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mobilita.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Mobilita mobilita) {
		entityCache.removeResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaImpl.class, mobilita.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Mobilita> mobilitas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Mobilita mobilita : mobilitas) {
			entityCache.removeResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
				MobilitaImpl.class, mobilita.getPrimaryKey());
		}
	}

	/**
	 * Creates a new mobilita with the primary key. Does not add the mobilita to the database.
	 *
	 * @param custom_key the primary key for the new mobilita
	 * @return the new mobilita
	 */
	@Override
	public Mobilita create(String custom_key) {
		Mobilita mobilita = new MobilitaImpl();

		mobilita.setNew(true);
		mobilita.setPrimaryKey(custom_key);

		return mobilita;
	}

	/**
	 * Removes the mobilita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param custom_key the primary key of the mobilita
	 * @return the mobilita that was removed
	 * @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	 */
	@Override
	public Mobilita remove(String custom_key) throws NoSuchMobilitaException {
		return remove((Serializable)custom_key);
	}

	/**
	 * Removes the mobilita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mobilita
	 * @return the mobilita that was removed
	 * @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	 */
	@Override
	public Mobilita remove(Serializable primaryKey)
		throws NoSuchMobilitaException {
		Session session = null;

		try {
			session = openSession();

			Mobilita mobilita = (Mobilita)session.get(MobilitaImpl.class,
					primaryKey);

			if (mobilita == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMobilitaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(mobilita);
		}
		catch (NoSuchMobilitaException nsee) {
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
	protected Mobilita removeImpl(Mobilita mobilita) {
		mobilita = toUnwrappedModel(mobilita);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mobilita)) {
				mobilita = (Mobilita)session.get(MobilitaImpl.class,
						mobilita.getPrimaryKeyObj());
			}

			if (mobilita != null) {
				session.delete(mobilita);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (mobilita != null) {
			clearCache(mobilita);
		}

		return mobilita;
	}

	@Override
	public Mobilita updateImpl(Mobilita mobilita) {
		mobilita = toUnwrappedModel(mobilita);

		boolean isNew = mobilita.isNew();

		MobilitaModelImpl mobilitaModelImpl = (MobilitaModelImpl)mobilita;

		Session session = null;

		try {
			session = openSession();

			if (mobilita.isNew()) {
				session.save(mobilita);

				mobilita.setNew(false);
			}
			else {
				mobilita = (Mobilita)session.merge(mobilita);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MobilitaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((mobilitaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						mobilitaModelImpl.getOriginalPerson_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);

				args = new Object[] { mobilitaModelImpl.getPerson_id() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PERSONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSONID,
					args);
			}
		}

		entityCache.putResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
			MobilitaImpl.class, mobilita.getPrimaryKey(), mobilita, false);

		mobilita.resetOriginalValues();

		return mobilita;
	}

	protected Mobilita toUnwrappedModel(Mobilita mobilita) {
		if (mobilita instanceof MobilitaImpl) {
			return mobilita;
		}

		MobilitaImpl mobilitaImpl = new MobilitaImpl();

		mobilitaImpl.setNew(mobilita.isNew());
		mobilitaImpl.setPrimaryKey(mobilita.getPrimaryKey());

		mobilitaImpl.setCustom_key(mobilita.getCustom_key());
		mobilitaImpl.setPerson_id(mobilita.getPerson_id());
		mobilitaImpl.setTipo_mobilita(mobilita.getTipo_mobilita());

		return mobilitaImpl;
	}

	/**
	 * Returns the mobilita with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the mobilita
	 * @return the mobilita
	 * @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	 */
	@Override
	public Mobilita findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMobilitaException {
		Mobilita mobilita = fetchByPrimaryKey(primaryKey);

		if (mobilita == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMobilitaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return mobilita;
	}

	/**
	 * Returns the mobilita with the primary key or throws a {@link NoSuchMobilitaException} if it could not be found.
	 *
	 * @param custom_key the primary key of the mobilita
	 * @return the mobilita
	 * @throws NoSuchMobilitaException if a mobilita with the primary key could not be found
	 */
	@Override
	public Mobilita findByPrimaryKey(String custom_key)
		throws NoSuchMobilitaException {
		return findByPrimaryKey((Serializable)custom_key);
	}

	/**
	 * Returns the mobilita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mobilita
	 * @return the mobilita, or <code>null</code> if a mobilita with the primary key could not be found
	 */
	@Override
	public Mobilita fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
				MobilitaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Mobilita mobilita = (Mobilita)serializable;

		if (mobilita == null) {
			Session session = null;

			try {
				session = openSession();

				mobilita = (Mobilita)session.get(MobilitaImpl.class, primaryKey);

				if (mobilita != null) {
					cacheResult(mobilita);
				}
				else {
					entityCache.putResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
						MobilitaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
					MobilitaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return mobilita;
	}

	/**
	 * Returns the mobilita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param custom_key the primary key of the mobilita
	 * @return the mobilita, or <code>null</code> if a mobilita with the primary key could not be found
	 */
	@Override
	public Mobilita fetchByPrimaryKey(String custom_key) {
		return fetchByPrimaryKey((Serializable)custom_key);
	}

	@Override
	public Map<Serializable, Mobilita> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Mobilita> map = new HashMap<Serializable, Mobilita>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Mobilita mobilita = fetchByPrimaryKey(primaryKey);

			if (mobilita != null) {
				map.put(primaryKey, mobilita);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
					MobilitaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Mobilita)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_MOBILITA_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Mobilita mobilita : (List<Mobilita>)q.list()) {
				map.put(mobilita.getPrimaryKeyObj(), mobilita);

				cacheResult(mobilita);

				uncachedPrimaryKeys.remove(mobilita.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MobilitaModelImpl.ENTITY_CACHE_ENABLED,
					MobilitaImpl.class, primaryKey, nullModel);
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
	 * Returns all the mobilitas.
	 *
	 * @return the mobilitas
	 */
	@Override
	public List<Mobilita> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mobilitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mobilitas
	 * @param end the upper bound of the range of mobilitas (not inclusive)
	 * @return the range of mobilitas
	 */
	@Override
	public List<Mobilita> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mobilitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mobilitas
	 * @param end the upper bound of the range of mobilitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mobilitas
	 */
	@Override
	public List<Mobilita> findAll(int start, int end,
		OrderByComparator<Mobilita> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mobilitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mobilitas
	 * @param end the upper bound of the range of mobilitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of mobilitas
	 */
	@Override
	public List<Mobilita> findAll(int start, int end,
		OrderByComparator<Mobilita> orderByComparator, boolean retrieveFromCache) {
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

		List<Mobilita> list = null;

		if (retrieveFromCache) {
			list = (List<Mobilita>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MOBILITA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MOBILITA;

				if (pagination) {
					sql = sql.concat(MobilitaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Mobilita>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Mobilita>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the mobilitas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Mobilita mobilita : findAll()) {
			remove(mobilita);
		}
	}

	/**
	 * Returns the number of mobilitas.
	 *
	 * @return the number of mobilitas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MOBILITA);

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
		return MobilitaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mobilita persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MobilitaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MOBILITA = "SELECT mobilita FROM Mobilita mobilita";
	private static final String _SQL_SELECT_MOBILITA_WHERE_PKS_IN = "SELECT mobilita FROM Mobilita mobilita WHERE CUSTOM_KEY IN (";
	private static final String _SQL_SELECT_MOBILITA_WHERE = "SELECT mobilita FROM Mobilita mobilita WHERE ";
	private static final String _SQL_COUNT_MOBILITA = "SELECT COUNT(mobilita) FROM Mobilita mobilita";
	private static final String _SQL_COUNT_MOBILITA_WHERE = "SELECT COUNT(mobilita) FROM Mobilita mobilita WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mobilita.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Mobilita exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Mobilita exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MobilitaPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"custom_key", "person_id", "tipo_mobilita"
			});
}