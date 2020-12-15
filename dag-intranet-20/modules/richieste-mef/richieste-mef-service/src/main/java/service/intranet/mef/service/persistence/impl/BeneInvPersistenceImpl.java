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

import service.intranet.mef.exception.NoSuchBeneInvException;
import service.intranet.mef.model.BeneInv;
import service.intranet.mef.model.impl.BeneInvImpl;
import service.intranet.mef.model.impl.BeneInvModelImpl;
import service.intranet.mef.service.persistence.BeneInvPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the bene inv service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvPersistence
 * @see service.intranet.mef.service.persistence.BeneInvUtil
 * @generated
 */
@ProviderType
public class BeneInvPersistenceImpl extends BasePersistenceImpl<BeneInv>
	implements BeneInvPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BeneInvUtil} to access the bene inv persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BeneInvImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvModelImpl.FINDER_CACHE_ENABLED, BeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvModelImpl.FINDER_CACHE_ENABLED, BeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIPOBENEINV =
		new FinderPath(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvModelImpl.FINDER_CACHE_ENABLED, BeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTipoBeneInv",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOBENEINV =
		new FinderPath(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvModelImpl.FINDER_CACHE_ENABLED, BeneInvImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTipoBeneInv",
			new String[] { Long.class.getName() },
			BeneInvModelImpl.ID_TIPO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIPOBENEINV = new FinderPath(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTipoBeneInv",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bene invs where id_tipo = &#63;.
	 *
	 * @param id_tipo the id_tipo
	 * @return the matching bene invs
	 */
	@Override
	public List<BeneInv> findByTipoBeneInv(long id_tipo) {
		return findByTipoBeneInv(id_tipo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bene invs where id_tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_tipo the id_tipo
	 * @param start the lower bound of the range of bene invs
	 * @param end the upper bound of the range of bene invs (not inclusive)
	 * @return the range of matching bene invs
	 */
	@Override
	public List<BeneInv> findByTipoBeneInv(long id_tipo, int start, int end) {
		return findByTipoBeneInv(id_tipo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bene invs where id_tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_tipo the id_tipo
	 * @param start the lower bound of the range of bene invs
	 * @param end the upper bound of the range of bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bene invs
	 */
	@Override
	public List<BeneInv> findByTipoBeneInv(long id_tipo, int start, int end,
		OrderByComparator<BeneInv> orderByComparator) {
		return findByTipoBeneInv(id_tipo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bene invs where id_tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_tipo the id_tipo
	 * @param start the lower bound of the range of bene invs
	 * @param end the upper bound of the range of bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bene invs
	 */
	@Override
	public List<BeneInv> findByTipoBeneInv(long id_tipo, int start, int end,
		OrderByComparator<BeneInv> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOBENEINV;
			finderArgs = new Object[] { id_tipo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TIPOBENEINV;
			finderArgs = new Object[] { id_tipo, start, end, orderByComparator };
		}

		List<BeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<BeneInv>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (BeneInv beneInv : list) {
					if ((id_tipo != beneInv.getId_tipo())) {
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

			query.append(_SQL_SELECT_BENEINV_WHERE);

			query.append(_FINDER_COLUMN_TIPOBENEINV_ID_TIPO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BeneInvModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_tipo);

				if (!pagination) {
					list = (List<BeneInv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BeneInv>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bene inv in the ordered set where id_tipo = &#63;.
	 *
	 * @param id_tipo the id_tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bene inv
	 * @throws NoSuchBeneInvException if a matching bene inv could not be found
	 */
	@Override
	public BeneInv findByTipoBeneInv_First(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator)
		throws NoSuchBeneInvException {
		BeneInv beneInv = fetchByTipoBeneInv_First(id_tipo, orderByComparator);

		if (beneInv != null) {
			return beneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_tipo=");
		msg.append(id_tipo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBeneInvException(msg.toString());
	}

	/**
	 * Returns the first bene inv in the ordered set where id_tipo = &#63;.
	 *
	 * @param id_tipo the id_tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bene inv, or <code>null</code> if a matching bene inv could not be found
	 */
	@Override
	public BeneInv fetchByTipoBeneInv_First(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator) {
		List<BeneInv> list = findByTipoBeneInv(id_tipo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bene inv in the ordered set where id_tipo = &#63;.
	 *
	 * @param id_tipo the id_tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bene inv
	 * @throws NoSuchBeneInvException if a matching bene inv could not be found
	 */
	@Override
	public BeneInv findByTipoBeneInv_Last(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator)
		throws NoSuchBeneInvException {
		BeneInv beneInv = fetchByTipoBeneInv_Last(id_tipo, orderByComparator);

		if (beneInv != null) {
			return beneInv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_tipo=");
		msg.append(id_tipo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBeneInvException(msg.toString());
	}

	/**
	 * Returns the last bene inv in the ordered set where id_tipo = &#63;.
	 *
	 * @param id_tipo the id_tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bene inv, or <code>null</code> if a matching bene inv could not be found
	 */
	@Override
	public BeneInv fetchByTipoBeneInv_Last(long id_tipo,
		OrderByComparator<BeneInv> orderByComparator) {
		int count = countByTipoBeneInv(id_tipo);

		if (count == 0) {
			return null;
		}

		List<BeneInv> list = findByTipoBeneInv(id_tipo, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bene invs before and after the current bene inv in the ordered set where id_tipo = &#63;.
	 *
	 * @param id the primary key of the current bene inv
	 * @param id_tipo the id_tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bene inv
	 * @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	 */
	@Override
	public BeneInv[] findByTipoBeneInv_PrevAndNext(long id, long id_tipo,
		OrderByComparator<BeneInv> orderByComparator)
		throws NoSuchBeneInvException {
		BeneInv beneInv = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BeneInv[] array = new BeneInvImpl[3];

			array[0] = getByTipoBeneInv_PrevAndNext(session, beneInv, id_tipo,
					orderByComparator, true);

			array[1] = beneInv;

			array[2] = getByTipoBeneInv_PrevAndNext(session, beneInv, id_tipo,
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

	protected BeneInv getByTipoBeneInv_PrevAndNext(Session session,
		BeneInv beneInv, long id_tipo,
		OrderByComparator<BeneInv> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BENEINV_WHERE);

		query.append(_FINDER_COLUMN_TIPOBENEINV_ID_TIPO_2);

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
			query.append(BeneInvModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_tipo);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(beneInv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BeneInv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bene invs where id_tipo = &#63; from the database.
	 *
	 * @param id_tipo the id_tipo
	 */
	@Override
	public void removeByTipoBeneInv(long id_tipo) {
		for (BeneInv beneInv : findByTipoBeneInv(id_tipo, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(beneInv);
		}
	}

	/**
	 * Returns the number of bene invs where id_tipo = &#63;.
	 *
	 * @param id_tipo the id_tipo
	 * @return the number of matching bene invs
	 */
	@Override
	public int countByTipoBeneInv(long id_tipo) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TIPOBENEINV;

		Object[] finderArgs = new Object[] { id_tipo };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BENEINV_WHERE);

			query.append(_FINDER_COLUMN_TIPOBENEINV_ID_TIPO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_tipo);

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

	private static final String _FINDER_COLUMN_TIPOBENEINV_ID_TIPO_2 = "beneInv.id_tipo = ?";

	public BeneInvPersistenceImpl() {
		setModelClass(BeneInv.class);
	}

	/**
	 * Caches the bene inv in the entity cache if it is enabled.
	 *
	 * @param beneInv the bene inv
	 */
	@Override
	public void cacheResult(BeneInv beneInv) {
		entityCache.putResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvImpl.class, beneInv.getPrimaryKey(), beneInv);

		beneInv.resetOriginalValues();
	}

	/**
	 * Caches the bene invs in the entity cache if it is enabled.
	 *
	 * @param beneInvs the bene invs
	 */
	@Override
	public void cacheResult(List<BeneInv> beneInvs) {
		for (BeneInv beneInv : beneInvs) {
			if (entityCache.getResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
						BeneInvImpl.class, beneInv.getPrimaryKey()) == null) {
				cacheResult(beneInv);
			}
			else {
				beneInv.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bene invs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BeneInvImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bene inv.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BeneInv beneInv) {
		entityCache.removeResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvImpl.class, beneInv.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BeneInv> beneInvs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BeneInv beneInv : beneInvs) {
			entityCache.removeResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
				BeneInvImpl.class, beneInv.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bene inv with the primary key. Does not add the bene inv to the database.
	 *
	 * @param id the primary key for the new bene inv
	 * @return the new bene inv
	 */
	@Override
	public BeneInv create(long id) {
		BeneInv beneInv = new BeneInvImpl();

		beneInv.setNew(true);
		beneInv.setPrimaryKey(id);

		return beneInv;
	}

	/**
	 * Removes the bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bene inv
	 * @return the bene inv that was removed
	 * @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	 */
	@Override
	public BeneInv remove(long id) throws NoSuchBeneInvException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bene inv
	 * @return the bene inv that was removed
	 * @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	 */
	@Override
	public BeneInv remove(Serializable primaryKey)
		throws NoSuchBeneInvException {
		Session session = null;

		try {
			session = openSession();

			BeneInv beneInv = (BeneInv)session.get(BeneInvImpl.class, primaryKey);

			if (beneInv == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(beneInv);
		}
		catch (NoSuchBeneInvException nsee) {
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
	protected BeneInv removeImpl(BeneInv beneInv) {
		beneInv = toUnwrappedModel(beneInv);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(beneInv)) {
				beneInv = (BeneInv)session.get(BeneInvImpl.class,
						beneInv.getPrimaryKeyObj());
			}

			if (beneInv != null) {
				session.delete(beneInv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (beneInv != null) {
			clearCache(beneInv);
		}

		return beneInv;
	}

	@Override
	public BeneInv updateImpl(BeneInv beneInv) {
		beneInv = toUnwrappedModel(beneInv);

		boolean isNew = beneInv.isNew();

		BeneInvModelImpl beneInvModelImpl = (BeneInvModelImpl)beneInv;

		Session session = null;

		try {
			session = openSession();

			if (beneInv.isNew()) {
				session.save(beneInv);

				beneInv.setNew(false);
			}
			else {
				beneInv = (BeneInv)session.merge(beneInv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BeneInvModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((beneInvModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOBENEINV.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						beneInvModelImpl.getOriginalId_tipo()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIPOBENEINV, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOBENEINV,
					args);

				args = new Object[] { beneInvModelImpl.getId_tipo() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIPOBENEINV, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOBENEINV,
					args);
			}
		}

		entityCache.putResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
			BeneInvImpl.class, beneInv.getPrimaryKey(), beneInv, false);

		beneInv.resetOriginalValues();

		return beneInv;
	}

	protected BeneInv toUnwrappedModel(BeneInv beneInv) {
		if (beneInv instanceof BeneInvImpl) {
			return beneInv;
		}

		BeneInvImpl beneInvImpl = new BeneInvImpl();

		beneInvImpl.setNew(beneInv.isNew());
		beneInvImpl.setPrimaryKey(beneInv.getPrimaryKey());

		beneInvImpl.setId(beneInv.getId());
		beneInvImpl.setBene(beneInv.getBene());
		beneInvImpl.setId_tipo(beneInv.getId_tipo());

		return beneInvImpl;
	}

	/**
	 * Returns the bene inv with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bene inv
	 * @return the bene inv
	 * @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	 */
	@Override
	public BeneInv findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBeneInvException {
		BeneInv beneInv = fetchByPrimaryKey(primaryKey);

		if (beneInv == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBeneInvException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return beneInv;
	}

	/**
	 * Returns the bene inv with the primary key or throws a {@link NoSuchBeneInvException} if it could not be found.
	 *
	 * @param id the primary key of the bene inv
	 * @return the bene inv
	 * @throws NoSuchBeneInvException if a bene inv with the primary key could not be found
	 */
	@Override
	public BeneInv findByPrimaryKey(long id) throws NoSuchBeneInvException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bene inv
	 * @return the bene inv, or <code>null</code> if a bene inv with the primary key could not be found
	 */
	@Override
	public BeneInv fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
				BeneInvImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BeneInv beneInv = (BeneInv)serializable;

		if (beneInv == null) {
			Session session = null;

			try {
				session = openSession();

				beneInv = (BeneInv)session.get(BeneInvImpl.class, primaryKey);

				if (beneInv != null) {
					cacheResult(beneInv);
				}
				else {
					entityCache.putResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
						BeneInvImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
					BeneInvImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return beneInv;
	}

	/**
	 * Returns the bene inv with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bene inv
	 * @return the bene inv, or <code>null</code> if a bene inv with the primary key could not be found
	 */
	@Override
	public BeneInv fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, BeneInv> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BeneInv> map = new HashMap<Serializable, BeneInv>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BeneInv beneInv = fetchByPrimaryKey(primaryKey);

			if (beneInv != null) {
				map.put(primaryKey, beneInv);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
					BeneInvImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BeneInv)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BENEINV_WHERE_PKS_IN);

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

			for (BeneInv beneInv : (List<BeneInv>)q.list()) {
				map.put(beneInv.getPrimaryKeyObj(), beneInv);

				cacheResult(beneInv);

				uncachedPrimaryKeys.remove(beneInv.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BeneInvModelImpl.ENTITY_CACHE_ENABLED,
					BeneInvImpl.class, primaryKey, nullModel);
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
	 * Returns all the bene invs.
	 *
	 * @return the bene invs
	 */
	@Override
	public List<BeneInv> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bene invs
	 * @param end the upper bound of the range of bene invs (not inclusive)
	 * @return the range of bene invs
	 */
	@Override
	public List<BeneInv> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bene invs
	 * @param end the upper bound of the range of bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bene invs
	 */
	@Override
	public List<BeneInv> findAll(int start, int end,
		OrderByComparator<BeneInv> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bene invs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bene invs
	 * @param end the upper bound of the range of bene invs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bene invs
	 */
	@Override
	public List<BeneInv> findAll(int start, int end,
		OrderByComparator<BeneInv> orderByComparator, boolean retrieveFromCache) {
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

		List<BeneInv> list = null;

		if (retrieveFromCache) {
			list = (List<BeneInv>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BENEINV);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BENEINV;

				if (pagination) {
					sql = sql.concat(BeneInvModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BeneInv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BeneInv>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bene invs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BeneInv beneInv : findAll()) {
			remove(beneInv);
		}
	}

	/**
	 * Returns the number of bene invs.
	 *
	 * @return the number of bene invs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BENEINV);

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
		return BeneInvModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bene inv persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BeneInvImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BENEINV = "SELECT beneInv FROM BeneInv beneInv";
	private static final String _SQL_SELECT_BENEINV_WHERE_PKS_IN = "SELECT beneInv FROM BeneInv beneInv WHERE id_ IN (";
	private static final String _SQL_SELECT_BENEINV_WHERE = "SELECT beneInv FROM BeneInv beneInv WHERE ";
	private static final String _SQL_COUNT_BENEINV = "SELECT COUNT(beneInv) FROM BeneInv beneInv";
	private static final String _SQL_COUNT_BENEINV_WHERE = "SELECT COUNT(beneInv) FROM BeneInv beneInv WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "beneInv.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BeneInv exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BeneInv exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BeneInvPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}