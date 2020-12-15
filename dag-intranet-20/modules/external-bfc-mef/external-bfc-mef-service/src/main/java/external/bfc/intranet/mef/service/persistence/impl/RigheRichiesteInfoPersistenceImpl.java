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

import external.bfc.intranet.mef.exception.NoSuchRigheRichiesteInfoException;
import external.bfc.intranet.mef.model.RigheRichiesteInfo;
import external.bfc.intranet.mef.model.impl.RigheRichiesteInfoImpl;
import external.bfc.intranet.mef.model.impl.RigheRichiesteInfoModelImpl;
import external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK;
import external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the righe richieste info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiesteInfoPersistence
 * @see external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoUtil
 * @generated
 */
@ProviderType
public class RigheRichiesteInfoPersistenceImpl extends BasePersistenceImpl<RigheRichiesteInfo>
	implements RigheRichiesteInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RigheRichiesteInfoUtil} to access the righe richieste info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RigheRichiesteInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RICHIESTEINFOID =
		new FinderPath(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrichiesteInfoId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEINFOID =
		new FinderPath(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoModelImpl.FINDER_CACHE_ENABLED,
			RigheRichiesteInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrichiesteInfoId",
			new String[] { Long.class.getName() },
			RigheRichiesteInfoModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RICHIESTEINFOID = new FinderPath(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrichiesteInfoId", new String[] { Long.class.getName() });

	/**
	 * Returns all the righe richieste infos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findByrichiesteInfoId(long id) {
		return findByrichiesteInfoId(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the righe richieste infos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of righe richieste infos
	 * @param end the upper bound of the range of righe richieste infos (not inclusive)
	 * @return the range of matching righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findByrichiesteInfoId(long id, int start,
		int end) {
		return findByrichiesteInfoId(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the righe richieste infos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of righe richieste infos
	 * @param end the upper bound of the range of righe richieste infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findByrichiesteInfoId(long id, int start,
		int end, OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		return findByrichiesteInfoId(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the righe richieste infos where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of righe richieste infos
	 * @param end the upper bound of the range of righe richieste infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findByrichiesteInfoId(long id, int start,
		int end, OrderByComparator<RigheRichiesteInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEINFOID;
			finderArgs = new Object[] { id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RICHIESTEINFOID;
			finderArgs = new Object[] { id, start, end, orderByComparator };
		}

		List<RigheRichiesteInfo> list = null;

		if (retrieveFromCache) {
			list = (List<RigheRichiesteInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RigheRichiesteInfo righeRichiesteInfo : list) {
					if ((id != righeRichiesteInfo.getId())) {
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

			query.append(_SQL_SELECT_RIGHERICHIESTEINFO_WHERE);

			query.append(_FINDER_COLUMN_RICHIESTEINFOID_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RigheRichiesteInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				if (!pagination) {
					list = (List<RigheRichiesteInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RigheRichiesteInfo>)QueryUtil.list(q,
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
	 * Returns the first righe richieste info in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe richieste info
	 * @throws NoSuchRigheRichiesteInfoException if a matching righe richieste info could not be found
	 */
	@Override
	public RigheRichiesteInfo findByrichiesteInfoId_First(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws NoSuchRigheRichiesteInfoException {
		RigheRichiesteInfo righeRichiesteInfo = fetchByrichiesteInfoId_First(id,
				orderByComparator);

		if (righeRichiesteInfo != null) {
			return righeRichiesteInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichiesteInfoException(msg.toString());
	}

	/**
	 * Returns the first righe richieste info in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe richieste info, or <code>null</code> if a matching righe richieste info could not be found
	 */
	@Override
	public RigheRichiesteInfo fetchByrichiesteInfoId_First(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		List<RigheRichiesteInfo> list = findByrichiesteInfoId(id, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last righe richieste info in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe richieste info
	 * @throws NoSuchRigheRichiesteInfoException if a matching righe richieste info could not be found
	 */
	@Override
	public RigheRichiesteInfo findByrichiesteInfoId_Last(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws NoSuchRigheRichiesteInfoException {
		RigheRichiesteInfo righeRichiesteInfo = fetchByrichiesteInfoId_Last(id,
				orderByComparator);

		if (righeRichiesteInfo != null) {
			return righeRichiesteInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichiesteInfoException(msg.toString());
	}

	/**
	 * Returns the last righe richieste info in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe richieste info, or <code>null</code> if a matching righe richieste info could not be found
	 */
	@Override
	public RigheRichiesteInfo fetchByrichiesteInfoId_Last(long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		int count = countByrichiesteInfoId(id);

		if (count == 0) {
			return null;
		}

		List<RigheRichiesteInfo> list = findByrichiesteInfoId(id, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the righe richieste infos before and after the current righe richieste info in the ordered set where id = &#63;.
	 *
	 * @param righeRichiesteInfoPK the primary key of the current righe richieste info
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next righe richieste info
	 * @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	 */
	@Override
	public RigheRichiesteInfo[] findByrichiesteInfoId_PrevAndNext(
		RigheRichiesteInfoPK righeRichiesteInfoPK, long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator)
		throws NoSuchRigheRichiesteInfoException {
		RigheRichiesteInfo righeRichiesteInfo = findByPrimaryKey(righeRichiesteInfoPK);

		Session session = null;

		try {
			session = openSession();

			RigheRichiesteInfo[] array = new RigheRichiesteInfoImpl[3];

			array[0] = getByrichiesteInfoId_PrevAndNext(session,
					righeRichiesteInfo, id, orderByComparator, true);

			array[1] = righeRichiesteInfo;

			array[2] = getByrichiesteInfoId_PrevAndNext(session,
					righeRichiesteInfo, id, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RigheRichiesteInfo getByrichiesteInfoId_PrevAndNext(
		Session session, RigheRichiesteInfo righeRichiesteInfo, long id,
		OrderByComparator<RigheRichiesteInfo> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RIGHERICHIESTEINFO_WHERE);

		query.append(_FINDER_COLUMN_RICHIESTEINFOID_ID_2);

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
			query.append(RigheRichiesteInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(righeRichiesteInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RigheRichiesteInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the righe richieste infos where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByrichiesteInfoId(long id) {
		for (RigheRichiesteInfo righeRichiesteInfo : findByrichiesteInfoId(id,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(righeRichiesteInfo);
		}
	}

	/**
	 * Returns the number of righe richieste infos where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching righe richieste infos
	 */
	@Override
	public int countByrichiesteInfoId(long id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RICHIESTEINFOID;

		Object[] finderArgs = new Object[] { id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RIGHERICHIESTEINFO_WHERE);

			query.append(_FINDER_COLUMN_RICHIESTEINFOID_ID_2);

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

	private static final String _FINDER_COLUMN_RICHIESTEINFOID_ID_2 = "righeRichiesteInfo.id.id = ?";

	public RigheRichiesteInfoPersistenceImpl() {
		setModelClass(RigheRichiesteInfo.class);
	}

	/**
	 * Caches the righe richieste info in the entity cache if it is enabled.
	 *
	 * @param righeRichiesteInfo the righe richieste info
	 */
	@Override
	public void cacheResult(RigheRichiesteInfo righeRichiesteInfo) {
		entityCache.putResult(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoImpl.class, righeRichiesteInfo.getPrimaryKey(),
			righeRichiesteInfo);

		righeRichiesteInfo.resetOriginalValues();
	}

	/**
	 * Caches the righe richieste infos in the entity cache if it is enabled.
	 *
	 * @param righeRichiesteInfos the righe richieste infos
	 */
	@Override
	public void cacheResult(List<RigheRichiesteInfo> righeRichiesteInfos) {
		for (RigheRichiesteInfo righeRichiesteInfo : righeRichiesteInfos) {
			if (entityCache.getResult(
						RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
						RigheRichiesteInfoImpl.class,
						righeRichiesteInfo.getPrimaryKey()) == null) {
				cacheResult(righeRichiesteInfo);
			}
			else {
				righeRichiesteInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all righe richieste infos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RigheRichiesteInfoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the righe richieste info.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RigheRichiesteInfo righeRichiesteInfo) {
		entityCache.removeResult(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoImpl.class, righeRichiesteInfo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RigheRichiesteInfo> righeRichiesteInfos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RigheRichiesteInfo righeRichiesteInfo : righeRichiesteInfos) {
			entityCache.removeResult(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
				RigheRichiesteInfoImpl.class, righeRichiesteInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new righe richieste info with the primary key. Does not add the righe richieste info to the database.
	 *
	 * @param righeRichiesteInfoPK the primary key for the new righe richieste info
	 * @return the new righe richieste info
	 */
	@Override
	public RigheRichiesteInfo create(RigheRichiesteInfoPK righeRichiesteInfoPK) {
		RigheRichiesteInfo righeRichiesteInfo = new RigheRichiesteInfoImpl();

		righeRichiesteInfo.setNew(true);
		righeRichiesteInfo.setPrimaryKey(righeRichiesteInfoPK);

		return righeRichiesteInfo;
	}

	/**
	 * Removes the righe richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param righeRichiesteInfoPK the primary key of the righe richieste info
	 * @return the righe richieste info that was removed
	 * @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	 */
	@Override
	public RigheRichiesteInfo remove(RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws NoSuchRigheRichiesteInfoException {
		return remove((Serializable)righeRichiesteInfoPK);
	}

	/**
	 * Removes the righe richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the righe richieste info
	 * @return the righe richieste info that was removed
	 * @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	 */
	@Override
	public RigheRichiesteInfo remove(Serializable primaryKey)
		throws NoSuchRigheRichiesteInfoException {
		Session session = null;

		try {
			session = openSession();

			RigheRichiesteInfo righeRichiesteInfo = (RigheRichiesteInfo)session.get(RigheRichiesteInfoImpl.class,
					primaryKey);

			if (righeRichiesteInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRigheRichiesteInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(righeRichiesteInfo);
		}
		catch (NoSuchRigheRichiesteInfoException nsee) {
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
	protected RigheRichiesteInfo removeImpl(
		RigheRichiesteInfo righeRichiesteInfo) {
		righeRichiesteInfo = toUnwrappedModel(righeRichiesteInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(righeRichiesteInfo)) {
				righeRichiesteInfo = (RigheRichiesteInfo)session.get(RigheRichiesteInfoImpl.class,
						righeRichiesteInfo.getPrimaryKeyObj());
			}

			if (righeRichiesteInfo != null) {
				session.delete(righeRichiesteInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (righeRichiesteInfo != null) {
			clearCache(righeRichiesteInfo);
		}

		return righeRichiesteInfo;
	}

	@Override
	public RigheRichiesteInfo updateImpl(RigheRichiesteInfo righeRichiesteInfo) {
		righeRichiesteInfo = toUnwrappedModel(righeRichiesteInfo);

		boolean isNew = righeRichiesteInfo.isNew();

		RigheRichiesteInfoModelImpl righeRichiesteInfoModelImpl = (RigheRichiesteInfoModelImpl)righeRichiesteInfo;

		Session session = null;

		try {
			session = openSession();

			if (righeRichiesteInfo.isNew()) {
				session.save(righeRichiesteInfo);

				righeRichiesteInfo.setNew(false);
			}
			else {
				righeRichiesteInfo = (RigheRichiesteInfo)session.merge(righeRichiesteInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RigheRichiesteInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((righeRichiesteInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEINFOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						righeRichiesteInfoModelImpl.getOriginalId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RICHIESTEINFOID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEINFOID,
					args);

				args = new Object[] { righeRichiesteInfoModelImpl.getId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RICHIESTEINFOID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIESTEINFOID,
					args);
			}
		}

		entityCache.putResult(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichiesteInfoImpl.class, righeRichiesteInfo.getPrimaryKey(),
			righeRichiesteInfo, false);

		righeRichiesteInfo.resetOriginalValues();

		return righeRichiesteInfo;
	}

	protected RigheRichiesteInfo toUnwrappedModel(
		RigheRichiesteInfo righeRichiesteInfo) {
		if (righeRichiesteInfo instanceof RigheRichiesteInfoImpl) {
			return righeRichiesteInfo;
		}

		RigheRichiesteInfoImpl righeRichiesteInfoImpl = new RigheRichiesteInfoImpl();

		righeRichiesteInfoImpl.setNew(righeRichiesteInfo.isNew());
		righeRichiesteInfoImpl.setPrimaryKey(righeRichiesteInfo.getPrimaryKey());

		righeRichiesteInfoImpl.setId(righeRichiesteInfo.getId());
		righeRichiesteInfoImpl.setIdMateriale(righeRichiesteInfo.getIdMateriale());
		righeRichiesteInfoImpl.setNumeroRiga(righeRichiesteInfo.getNumeroRiga());
		righeRichiesteInfoImpl.setQuantitaRichiesta(righeRichiesteInfo.getQuantitaRichiesta());
		righeRichiesteInfoImpl.setQuantitaDisponibile(righeRichiesteInfo.getQuantitaDisponibile());
		righeRichiesteInfoImpl.setUidIns(righeRichiesteInfo.getUidIns());
		righeRichiesteInfoImpl.setDataIns(righeRichiesteInfo.getDataIns());
		righeRichiesteInfoImpl.setUidUpd(righeRichiesteInfo.getUidUpd());
		righeRichiesteInfoImpl.setDataUpd(righeRichiesteInfo.getDataUpd());
		righeRichiesteInfoImpl.setImporto(righeRichiesteInfo.getImporto());
		righeRichiesteInfoImpl.setSottogruppo(righeRichiesteInfo.getSottogruppo());
		righeRichiesteInfoImpl.setGruppo(righeRichiesteInfo.getGruppo());
		righeRichiesteInfoImpl.setDescrizione(righeRichiesteInfo.getDescrizione());

		return righeRichiesteInfoImpl;
	}

	/**
	 * Returns the righe richieste info with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the righe richieste info
	 * @return the righe richieste info
	 * @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	 */
	@Override
	public RigheRichiesteInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRigheRichiesteInfoException {
		RigheRichiesteInfo righeRichiesteInfo = fetchByPrimaryKey(primaryKey);

		if (righeRichiesteInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRigheRichiesteInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return righeRichiesteInfo;
	}

	/**
	 * Returns the righe richieste info with the primary key or throws a {@link NoSuchRigheRichiesteInfoException} if it could not be found.
	 *
	 * @param righeRichiesteInfoPK the primary key of the righe richieste info
	 * @return the righe richieste info
	 * @throws NoSuchRigheRichiesteInfoException if a righe richieste info with the primary key could not be found
	 */
	@Override
	public RigheRichiesteInfo findByPrimaryKey(
		RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws NoSuchRigheRichiesteInfoException {
		return findByPrimaryKey((Serializable)righeRichiesteInfoPK);
	}

	/**
	 * Returns the righe richieste info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the righe richieste info
	 * @return the righe richieste info, or <code>null</code> if a righe richieste info with the primary key could not be found
	 */
	@Override
	public RigheRichiesteInfo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
				RigheRichiesteInfoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RigheRichiesteInfo righeRichiesteInfo = (RigheRichiesteInfo)serializable;

		if (righeRichiesteInfo == null) {
			Session session = null;

			try {
				session = openSession();

				righeRichiesteInfo = (RigheRichiesteInfo)session.get(RigheRichiesteInfoImpl.class,
						primaryKey);

				if (righeRichiesteInfo != null) {
					cacheResult(righeRichiesteInfo);
				}
				else {
					entityCache.putResult(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
						RigheRichiesteInfoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RigheRichiesteInfoModelImpl.ENTITY_CACHE_ENABLED,
					RigheRichiesteInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return righeRichiesteInfo;
	}

	/**
	 * Returns the righe richieste info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param righeRichiesteInfoPK the primary key of the righe richieste info
	 * @return the righe richieste info, or <code>null</code> if a righe richieste info with the primary key could not be found
	 */
	@Override
	public RigheRichiesteInfo fetchByPrimaryKey(
		RigheRichiesteInfoPK righeRichiesteInfoPK) {
		return fetchByPrimaryKey((Serializable)righeRichiesteInfoPK);
	}

	@Override
	public Map<Serializable, RigheRichiesteInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RigheRichiesteInfo> map = new HashMap<Serializable, RigheRichiesteInfo>();

		for (Serializable primaryKey : primaryKeys) {
			RigheRichiesteInfo righeRichiesteInfo = fetchByPrimaryKey(primaryKey);

			if (righeRichiesteInfo != null) {
				map.put(primaryKey, righeRichiesteInfo);
			}
		}

		return map;
	}

	/**
	 * Returns all the righe richieste infos.
	 *
	 * @return the righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the righe richieste infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe richieste infos
	 * @param end the upper bound of the range of righe richieste infos (not inclusive)
	 * @return the range of righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the righe richieste infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe richieste infos
	 * @param end the upper bound of the range of righe richieste infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findAll(int start, int end,
		OrderByComparator<RigheRichiesteInfo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the righe richieste infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe richieste infos
	 * @param end the upper bound of the range of righe richieste infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of righe richieste infos
	 */
	@Override
	public List<RigheRichiesteInfo> findAll(int start, int end,
		OrderByComparator<RigheRichiesteInfo> orderByComparator,
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

		List<RigheRichiesteInfo> list = null;

		if (retrieveFromCache) {
			list = (List<RigheRichiesteInfo>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RIGHERICHIESTEINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RIGHERICHIESTEINFO;

				if (pagination) {
					sql = sql.concat(RigheRichiesteInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RigheRichiesteInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RigheRichiesteInfo>)QueryUtil.list(q,
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
	 * Removes all the righe richieste infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RigheRichiesteInfo righeRichiesteInfo : findAll()) {
			remove(righeRichiesteInfo);
		}
	}

	/**
	 * Returns the number of righe richieste infos.
	 *
	 * @return the number of righe richieste infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RIGHERICHIESTEINFO);

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
		return RigheRichiesteInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the righe richieste info persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RigheRichiesteInfoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RIGHERICHIESTEINFO = "SELECT righeRichiesteInfo FROM RigheRichiesteInfo righeRichiesteInfo";
	private static final String _SQL_SELECT_RIGHERICHIESTEINFO_WHERE = "SELECT righeRichiesteInfo FROM RigheRichiesteInfo righeRichiesteInfo WHERE ";
	private static final String _SQL_COUNT_RIGHERICHIESTEINFO = "SELECT COUNT(righeRichiesteInfo) FROM RigheRichiesteInfo righeRichiesteInfo";
	private static final String _SQL_COUNT_RIGHERICHIESTEINFO_WHERE = "SELECT COUNT(righeRichiesteInfo) FROM RigheRichiesteInfo righeRichiesteInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "righeRichiesteInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RigheRichiesteInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RigheRichiesteInfo exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RigheRichiesteInfoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "idMateriale", "numeroRiga", "quantitaRichiesta",
				"quantitaDisponibile", "uidIns", "dataIns", "uidUpd", "dataUpd",
				"importo", "sottogruppo", "gruppo", "descrizione"
			});
}