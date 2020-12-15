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

import external.bfc.intranet.mef.exception.NoSuchRigheRichiesteException;
import external.bfc.intranet.mef.model.RigheRichieste;
import external.bfc.intranet.mef.model.impl.RigheRichiesteImpl;
import external.bfc.intranet.mef.model.impl.RigheRichiesteModelImpl;
import external.bfc.intranet.mef.service.persistence.RigheRichiestePK;
import external.bfc.intranet.mef.service.persistence.RigheRichiestePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the righe richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestePersistence
 * @see external.bfc.intranet.mef.service.persistence.RigheRichiesteUtil
 * @generated
 */
@ProviderType
public class RigheRichiestePersistenceImpl extends BasePersistenceImpl<RigheRichieste>
	implements RigheRichiestePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RigheRichiesteUtil} to access the righe richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RigheRichiesteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RICHIESTEID =
		new FinderPath(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrichiesteId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEID =
		new FinderPath(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrichiesteId",
			new String[] { Long.class.getName() },
			RigheRichiesteModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RICHIESTEID = new FinderPath(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrichiesteId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the righe richiestes where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching righe richiestes
	 */
	@Override
	public List<RigheRichieste> findByrichiesteId(long id) {
		return findByrichiesteId(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the righe richiestes where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of righe richiestes
	 * @param end the upper bound of the range of righe richiestes (not inclusive)
	 * @return the range of matching righe richiestes
	 */
	@Override
	public List<RigheRichieste> findByrichiesteId(long id, int start, int end) {
		return findByrichiesteId(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the righe richiestes where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of righe richiestes
	 * @param end the upper bound of the range of righe richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching righe richiestes
	 */
	@Override
	public List<RigheRichieste> findByrichiesteId(long id, int start, int end,
		OrderByComparator<RigheRichieste> orderByComparator) {
		return findByrichiesteId(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the righe richiestes where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of righe richiestes
	 * @param end the upper bound of the range of righe richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching righe richiestes
	 */
	@Override
	public List<RigheRichieste> findByrichiesteId(long id, int start, int end,
		OrderByComparator<RigheRichieste> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEID;
			finderArgs = new Object[] { id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RICHIESTEID;
			finderArgs = new Object[] { id, start, end, orderByComparator };
		}

		List<RigheRichieste> list = null;

		if (retrieveFromCache) {
			list = (List<RigheRichieste>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RigheRichieste righeRichieste : list) {
					if ((id != righeRichieste.getId())) {
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

			query.append(_SQL_SELECT_RIGHERICHIESTE_WHERE);

			query.append(_FINDER_COLUMN_RICHIESTEID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RigheRichiesteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				if (!pagination) {
					list = (List<RigheRichieste>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RigheRichieste>)QueryUtil.list(q,
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
	 * Returns the first righe richieste in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe richieste
	 * @throws NoSuchRigheRichiesteException if a matching righe richieste could not be found
	 */
	@Override
	public RigheRichieste findByrichiesteId_First(long id,
		OrderByComparator<RigheRichieste> orderByComparator)
		throws NoSuchRigheRichiesteException {
		RigheRichieste righeRichieste = fetchByrichiesteId_First(id,
				orderByComparator);

		if (righeRichieste != null) {
			return righeRichieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichiesteException(msg.toString());
	}

	/**
	 * Returns the first righe richieste in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe richieste, or <code>null</code> if a matching righe richieste could not be found
	 */
	@Override
	public RigheRichieste fetchByrichiesteId_First(long id,
		OrderByComparator<RigheRichieste> orderByComparator) {
		List<RigheRichieste> list = findByrichiesteId(id, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last righe richieste in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe richieste
	 * @throws NoSuchRigheRichiesteException if a matching righe richieste could not be found
	 */
	@Override
	public RigheRichieste findByrichiesteId_Last(long id,
		OrderByComparator<RigheRichieste> orderByComparator)
		throws NoSuchRigheRichiesteException {
		RigheRichieste righeRichieste = fetchByrichiesteId_Last(id,
				orderByComparator);

		if (righeRichieste != null) {
			return righeRichieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichiesteException(msg.toString());
	}

	/**
	 * Returns the last righe richieste in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe richieste, or <code>null</code> if a matching righe richieste could not be found
	 */
	@Override
	public RigheRichieste fetchByrichiesteId_Last(long id,
		OrderByComparator<RigheRichieste> orderByComparator) {
		int count = countByrichiesteId(id);

		if (count == 0) {
			return null;
		}

		List<RigheRichieste> list = findByrichiesteId(id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the righe richiestes before and after the current righe richieste in the ordered set where id = &#63;.
	 *
	 * @param righeRichiestePK the primary key of the current righe richieste
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next righe richieste
	 * @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	 */
	@Override
	public RigheRichieste[] findByrichiesteId_PrevAndNext(
		RigheRichiestePK righeRichiestePK, long id,
		OrderByComparator<RigheRichieste> orderByComparator)
		throws NoSuchRigheRichiesteException {
		RigheRichieste righeRichieste = findByPrimaryKey(righeRichiestePK);

		Session session = null;

		try {
			session = openSession();

			RigheRichieste[] array = new RigheRichiesteImpl[3];

			array[0] = getByrichiesteId_PrevAndNext(session, righeRichieste,
					id, orderByComparator, true);

			array[1] = righeRichieste;

			array[2] = getByrichiesteId_PrevAndNext(session, righeRichieste,
					id, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RigheRichieste getByrichiesteId_PrevAndNext(Session session,
		RigheRichieste righeRichieste, long id,
		OrderByComparator<RigheRichieste> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RIGHERICHIESTE_WHERE);

		query.append(_FINDER_COLUMN_RICHIESTEID_ID_2);

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
			query.append(RigheRichiesteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(righeRichieste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RigheRichieste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the righe richiestes where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByrichiesteId(long id) {
		for (RigheRichieste righeRichieste : findByrichiesteId(id,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(righeRichieste);
		}
	}

	/**
	 * Returns the number of righe richiestes where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching righe richiestes
	 */
	@Override
	public int countByrichiesteId(long id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RICHIESTEID;

		Object[] finderArgs = new Object[] { id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RIGHERICHIESTE_WHERE);

			query.append(_FINDER_COLUMN_RICHIESTEID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

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

	private static final String _FINDER_COLUMN_RICHIESTEID_ID_2 = "righeRichieste.id.id = ?";

	public RigheRichiestePersistenceImpl() {
		setModelClass(RigheRichieste.class);
	}

	/**
	 * Caches the righe richieste in the entity cache if it is enabled.
	 *
	 * @param righeRichieste the righe richieste
	 */
	@Override
	public void cacheResult(RigheRichieste righeRichieste) {
		entityCache.putResult(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteImpl.class, righeRichieste.getPrimaryKey(),
			righeRichieste);

		righeRichieste.resetOriginalValues();
	}

	/**
	 * Caches the righe richiestes in the entity cache if it is enabled.
	 *
	 * @param righeRichiestes the righe richiestes
	 */
	@Override
	public void cacheResult(List<RigheRichieste> righeRichiestes) {
		for (RigheRichieste righeRichieste : righeRichiestes) {
			if (entityCache.getResult(
						RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
						RigheRichiesteImpl.class, righeRichieste.getPrimaryKey()) == null) {
				cacheResult(righeRichieste);
			}
			else {
				righeRichieste.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all righe richiestes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RigheRichiesteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the righe richieste.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RigheRichieste righeRichieste) {
		entityCache.removeResult(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteImpl.class, righeRichieste.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RigheRichieste> righeRichiestes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RigheRichieste righeRichieste : righeRichiestes) {
			entityCache.removeResult(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
				RigheRichiesteImpl.class, righeRichieste.getPrimaryKey());
		}
	}

	/**
	 * Creates a new righe richieste with the primary key. Does not add the righe richieste to the database.
	 *
	 * @param righeRichiestePK the primary key for the new righe richieste
	 * @return the new righe richieste
	 */
	@Override
	public RigheRichieste create(RigheRichiestePK righeRichiestePK) {
		RigheRichieste righeRichieste = new RigheRichiesteImpl();

		righeRichieste.setNew(true);
		righeRichieste.setPrimaryKey(righeRichiestePK);

		return righeRichieste;
	}

	/**
	 * Removes the righe richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param righeRichiestePK the primary key of the righe richieste
	 * @return the righe richieste that was removed
	 * @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	 */
	@Override
	public RigheRichieste remove(RigheRichiestePK righeRichiestePK)
		throws NoSuchRigheRichiesteException {
		return remove((Serializable)righeRichiestePK);
	}

	/**
	 * Removes the righe richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the righe richieste
	 * @return the righe richieste that was removed
	 * @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	 */
	@Override
	public RigheRichieste remove(Serializable primaryKey)
		throws NoSuchRigheRichiesteException {
		Session session = null;

		try {
			session = openSession();

			RigheRichieste righeRichieste = (RigheRichieste)session.get(RigheRichiesteImpl.class,
					primaryKey);

			if (righeRichieste == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRigheRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(righeRichieste);
		}
		catch (NoSuchRigheRichiesteException nsee) {
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
	protected RigheRichieste removeImpl(RigheRichieste righeRichieste) {
		righeRichieste = toUnwrappedModel(righeRichieste);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(righeRichieste)) {
				righeRichieste = (RigheRichieste)session.get(RigheRichiesteImpl.class,
						righeRichieste.getPrimaryKeyObj());
			}

			if (righeRichieste != null) {
				session.delete(righeRichieste);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (righeRichieste != null) {
			clearCache(righeRichieste);
		}

		return righeRichieste;
	}

	@Override
	public RigheRichieste updateImpl(RigheRichieste righeRichieste) {
		righeRichieste = toUnwrappedModel(righeRichieste);

		boolean isNew = righeRichieste.isNew();

		RigheRichiesteModelImpl righeRichiesteModelImpl = (RigheRichiesteModelImpl)righeRichieste;

		Session session = null;

		try {
			session = openSession();

			if (righeRichieste.isNew()) {
				session.save(righeRichieste);

				righeRichieste.setNew(false);
			}
			else {
				righeRichieste = (RigheRichieste)session.merge(righeRichieste);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RigheRichiesteModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((righeRichiesteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						righeRichiesteModelImpl.getOriginalId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RICHIESTEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEID,
					args);

				args = new Object[] { righeRichiesteModelImpl.getId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RICHIESTEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEID,
					args);
			}
		}

		entityCache.putResult(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteImpl.class, righeRichieste.getPrimaryKey(),
			righeRichieste, false);

		righeRichieste.resetOriginalValues();

		return righeRichieste;
	}

	protected RigheRichieste toUnwrappedModel(RigheRichieste righeRichieste) {
		if (righeRichieste instanceof RigheRichiesteImpl) {
			return righeRichieste;
		}

		RigheRichiesteImpl righeRichiesteImpl = new RigheRichiesteImpl();

		righeRichiesteImpl.setNew(righeRichieste.isNew());
		righeRichiesteImpl.setPrimaryKey(righeRichieste.getPrimaryKey());

		righeRichiesteImpl.setId(righeRichieste.getId());
		righeRichiesteImpl.setIdMateriale(righeRichieste.getIdMateriale());
		righeRichiesteImpl.setNumeroRiga(righeRichieste.getNumeroRiga());
		righeRichiesteImpl.setQuantitaRichiesta(righeRichieste.getQuantitaRichiesta());
		righeRichiesteImpl.setQuantitaDisponibile(righeRichieste.getQuantitaDisponibile());
		righeRichiesteImpl.setUidIns(righeRichieste.getUidIns());
		righeRichiesteImpl.setDataIns(righeRichieste.getDataIns());
		righeRichiesteImpl.setUidUpd(righeRichieste.getUidUpd());
		righeRichiesteImpl.setDataUpd(righeRichieste.getDataUpd());
		righeRichiesteImpl.setImporto(righeRichieste.getImporto());
		righeRichiesteImpl.setSottogruppo(righeRichieste.getSottogruppo());
		righeRichiesteImpl.setGruppo(righeRichieste.getGruppo());
		righeRichiesteImpl.setDescrizione(righeRichieste.getDescrizione());

		return righeRichiesteImpl;
	}

	/**
	 * Returns the righe richieste with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the righe richieste
	 * @return the righe richieste
	 * @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	 */
	@Override
	public RigheRichieste findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRigheRichiesteException {
		RigheRichieste righeRichieste = fetchByPrimaryKey(primaryKey);

		if (righeRichieste == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRigheRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return righeRichieste;
	}

	/**
	 * Returns the righe richieste with the primary key or throws a {@link NoSuchRigheRichiesteException} if it could not be found.
	 *
	 * @param righeRichiestePK the primary key of the righe richieste
	 * @return the righe richieste
	 * @throws NoSuchRigheRichiesteException if a righe richieste with the primary key could not be found
	 */
	@Override
	public RigheRichieste findByPrimaryKey(RigheRichiestePK righeRichiestePK)
		throws NoSuchRigheRichiesteException {
		return findByPrimaryKey((Serializable)righeRichiestePK);
	}

	/**
	 * Returns the righe richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the righe richieste
	 * @return the righe richieste, or <code>null</code> if a righe richieste with the primary key could not be found
	 */
	@Override
	public RigheRichieste fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
				RigheRichiesteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RigheRichieste righeRichieste = (RigheRichieste)serializable;

		if (righeRichieste == null) {
			Session session = null;

			try {
				session = openSession();

				righeRichieste = (RigheRichieste)session.get(RigheRichiesteImpl.class,
						primaryKey);

				if (righeRichieste != null) {
					cacheResult(righeRichieste);
				}
				else {
					entityCache.putResult(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
						RigheRichiesteImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RigheRichiesteModelImpl.ENTITY_CACHE_ENABLED,
					RigheRichiesteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return righeRichieste;
	}

	/**
	 * Returns the righe richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param righeRichiestePK the primary key of the righe richieste
	 * @return the righe richieste, or <code>null</code> if a righe richieste with the primary key could not be found
	 */
	@Override
	public RigheRichieste fetchByPrimaryKey(RigheRichiestePK righeRichiestePK) {
		return fetchByPrimaryKey((Serializable)righeRichiestePK);
	}

	@Override
	public Map<Serializable, RigheRichieste> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RigheRichieste> map = new HashMap<Serializable, RigheRichieste>();

		for (Serializable primaryKey : primaryKeys) {
			RigheRichieste righeRichieste = fetchByPrimaryKey(primaryKey);

			if (righeRichieste != null) {
				map.put(primaryKey, righeRichieste);
			}
		}

		return map;
	}

	/**
	 * Returns all the righe richiestes.
	 *
	 * @return the righe richiestes
	 */
	@Override
	public List<RigheRichieste> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the righe richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe richiestes
	 * @param end the upper bound of the range of righe richiestes (not inclusive)
	 * @return the range of righe richiestes
	 */
	@Override
	public List<RigheRichieste> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the righe richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe richiestes
	 * @param end the upper bound of the range of righe richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of righe richiestes
	 */
	@Override
	public List<RigheRichieste> findAll(int start, int end,
		OrderByComparator<RigheRichieste> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the righe richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe richiestes
	 * @param end the upper bound of the range of righe richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of righe richiestes
	 */
	@Override
	public List<RigheRichieste> findAll(int start, int end,
		OrderByComparator<RigheRichieste> orderByComparator,
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

		List<RigheRichieste> list = null;

		if (retrieveFromCache) {
			list = (List<RigheRichieste>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RIGHERICHIESTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RIGHERICHIESTE;

				if (pagination) {
					sql = sql.concat(RigheRichiesteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RigheRichieste>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RigheRichieste>)QueryUtil.list(q,
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
	 * Removes all the righe richiestes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RigheRichieste righeRichieste : findAll()) {
			remove(righeRichieste);
		}
	}

	/**
	 * Returns the number of righe richiestes.
	 *
	 * @return the number of righe richiestes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RIGHERICHIESTE);

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
		return RigheRichiesteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the righe richieste persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RigheRichiesteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RIGHERICHIESTE = "SELECT righeRichieste FROM RigheRichieste righeRichieste";
	private static final String _SQL_SELECT_RIGHERICHIESTE_WHERE = "SELECT righeRichieste FROM RigheRichieste righeRichieste WHERE ";
	private static final String _SQL_COUNT_RIGHERICHIESTE = "SELECT COUNT(righeRichieste) FROM RigheRichieste righeRichieste";
	private static final String _SQL_COUNT_RIGHERICHIESTE_WHERE = "SELECT COUNT(righeRichieste) FROM RigheRichieste righeRichieste WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "righeRichieste.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RigheRichieste exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RigheRichieste exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RigheRichiestePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "idMateriale", "numeroRiga", "quantitaRichiesta",
				"quantitaDisponibile", "uidIns", "dataIns", "uidUpd", "dataUpd",
				"importo", "sottogruppo", "gruppo", "descrizione"
			});
}