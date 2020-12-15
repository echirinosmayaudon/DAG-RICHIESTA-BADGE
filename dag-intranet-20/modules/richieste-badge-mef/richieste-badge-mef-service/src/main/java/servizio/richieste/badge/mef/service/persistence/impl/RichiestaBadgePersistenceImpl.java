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

package servizio.richieste.badge.mef.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.richieste.badge.mef.exception.NoSuchRichiestaBadgeException;
import servizio.richieste.badge.mef.model.RichiestaBadge;
import servizio.richieste.badge.mef.model.impl.RichiestaBadgeImpl;
import servizio.richieste.badge.mef.model.impl.RichiestaBadgeModelImpl;
import servizio.richieste.badge.mef.service.persistence.RichiestaBadgePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the richiesta badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBadgePersistence
 * @see servizio.richieste.badge.mef.service.persistence.RichiestaBadgeUtil
 * @generated
 */
@ProviderType
public class RichiestaBadgePersistenceImpl extends BasePersistenceImpl<RichiestaBadge>
	implements RichiestaBadgePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiestaBadgeUtil} to access the richiesta badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiestaBadgeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdRichiesta",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdRichiesta",
			new String[] { Long.class.getName() },
			RichiestaBadgeModelImpl.ID_RICHIESTA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDRICHIESTA = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdRichiesta",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the richiesta badges where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @return the matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByIdRichiesta(long id_richiesta) {
		return findByIdRichiesta(id_richiesta, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta badges where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @return the range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByIdRichiesta(long id_richiesta, int start,
		int end) {
		return findByIdRichiesta(id_richiesta, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByIdRichiesta(long id_richiesta, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator) {
		return findByIdRichiesta(id_richiesta, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByIdRichiesta(long id_richiesta, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] { id_richiesta };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] {
					id_richiesta,
					
					start, end, orderByComparator
				};
		}

		List<RichiestaBadge> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBadge>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaBadge richiestaBadge : list) {
					if ((id_richiesta != richiestaBadge.getId_richiesta())) {
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

			query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_richiesta);

				if (!pagination) {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
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
	 * Returns the first richiesta badge in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByIdRichiesta_First(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByIdRichiesta_First(id_richiesta,
				orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the first richiesta badge in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByIdRichiesta_First(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		List<RichiestaBadge> list = findByIdRichiesta(id_richiesta, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta badge in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByIdRichiesta_Last(id_richiesta,
				orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the last richiesta badge in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		int count = countByIdRichiesta(id_richiesta);

		if (count == 0) {
			return null;
		}

		List<RichiestaBadge> list = findByIdRichiesta(id_richiesta, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta badges before and after the current richiesta badge in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_pk the primary key of the current richiesta badge
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge[] findByIdRichiesta_PrevAndNext(long id_pk,
		long id_richiesta, OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = findByPrimaryKey(id_pk);

		Session session = null;

		try {
			session = openSession();

			RichiestaBadge[] array = new RichiestaBadgeImpl[3];

			array[0] = getByIdRichiesta_PrevAndNext(session, richiestaBadge,
					id_richiesta, orderByComparator, true);

			array[1] = richiestaBadge;

			array[2] = getByIdRichiesta_PrevAndNext(session, richiestaBadge,
					id_richiesta, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaBadge getByIdRichiesta_PrevAndNext(Session session,
		RichiestaBadge richiestaBadge, long id_richiesta,
		OrderByComparator<RichiestaBadge> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

		query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2);

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
			query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_richiesta);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richiestaBadge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichiestaBadge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta badges where id_richiesta = &#63; from the database.
	 *
	 * @param id_richiesta the id_richiesta
	 */
	@Override
	public void removeByIdRichiesta(long id_richiesta) {
		for (RichiestaBadge richiestaBadge : findByIdRichiesta(id_richiesta,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(richiestaBadge);
		}
	}

	/**
	 * Returns the number of richiesta badges where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @return the number of matching richiesta badges
	 */
	@Override
	public int countByIdRichiesta(long id_richiesta) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDRICHIESTA;

		Object[] finderArgs = new Object[] { id_richiesta };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RICHIESTABADGE_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_richiesta);

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

	private static final String _FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2 = "richiestaBadge.id_richiesta = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RICHIEDENTE =
		new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRichiedente",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIEDENTE =
		new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRichiedente",
			new String[] { String.class.getName(), Boolean.class.getName() },
			RichiestaBadgeModelImpl.SCREENAME_RICHIEDENTE_COLUMN_BITMASK |
			RichiestaBadgeModelImpl.IS_LAST_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RICHIEDENTE = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRichiedente",
			new String[] { String.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @return the matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRichiedente(
		String screename_richiedente, boolean is_last) {
		return findByRichiedente(screename_richiedente, is_last,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @return the range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRichiedente(
		String screename_richiedente, boolean is_last, int start, int end) {
		return findByRichiedente(screename_richiedente, is_last, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRichiedente(
		String screename_richiedente, boolean is_last, int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return findByRichiedente(screename_richiedente, is_last, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRichiedente(
		String screename_richiedente, boolean is_last, int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIEDENTE;
			finderArgs = new Object[] { screename_richiedente, is_last };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RICHIEDENTE;
			finderArgs = new Object[] {
					screename_richiedente, is_last,
					
					start, end, orderByComparator
				};
		}

		List<RichiestaBadge> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBadge>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaBadge richiestaBadge : list) {
					if (!Objects.equals(screename_richiedente,
								richiestaBadge.getScreename_richiedente()) ||
							(is_last != richiestaBadge.getIs_last())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

			boolean bindScreename_richiedente = false;

			if (screename_richiedente == null) {
				query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_1);
			}
			else if (screename_richiedente.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_3);
			}
			else {
				bindScreename_richiedente = true;

				query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_2);
			}

			query.append(_FINDER_COLUMN_RICHIEDENTE_IS_LAST_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreename_richiedente) {
					qPos.add(screename_richiedente);
				}

				qPos.add(is_last);

				if (!pagination) {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
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
	 * Returns the first richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByRichiedente_First(
		String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByRichiedente_First(screename_richiedente,
				is_last, orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screename_richiedente=");
		msg.append(screename_richiedente);

		msg.append(", is_last=");
		msg.append(is_last);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the first richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByRichiedente_First(
		String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		List<RichiestaBadge> list = findByRichiedente(screename_richiedente,
				is_last, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByRichiedente_Last(String screename_richiedente,
		boolean is_last, OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByRichiedente_Last(screename_richiedente,
				is_last, orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screename_richiedente=");
		msg.append(screename_richiedente);

		msg.append(", is_last=");
		msg.append(is_last);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the last richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByRichiedente_Last(
		String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		int count = countByRichiedente(screename_richiedente, is_last);

		if (count == 0) {
			return null;
		}

		List<RichiestaBadge> list = findByRichiedente(screename_richiedente,
				is_last, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta badges before and after the current richiesta badge in the ordered set where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * @param id_pk the primary key of the current richiesta badge
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge[] findByRichiedente_PrevAndNext(long id_pk,
		String screename_richiedente, boolean is_last,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = findByPrimaryKey(id_pk);

		Session session = null;

		try {
			session = openSession();

			RichiestaBadge[] array = new RichiestaBadgeImpl[3];

			array[0] = getByRichiedente_PrevAndNext(session, richiestaBadge,
					screename_richiedente, is_last, orderByComparator, true);

			array[1] = richiestaBadge;

			array[2] = getByRichiedente_PrevAndNext(session, richiestaBadge,
					screename_richiedente, is_last, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaBadge getByRichiedente_PrevAndNext(Session session,
		RichiestaBadge richiestaBadge, String screename_richiedente,
		boolean is_last, OrderByComparator<RichiestaBadge> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

		boolean bindScreename_richiedente = false;

		if (screename_richiedente == null) {
			query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_1);
		}
		else if (screename_richiedente.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_3);
		}
		else {
			bindScreename_richiedente = true;

			query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_2);
		}

		query.append(_FINDER_COLUMN_RICHIEDENTE_IS_LAST_2);

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
			query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScreename_richiedente) {
			qPos.add(screename_richiedente);
		}

		qPos.add(is_last);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richiestaBadge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichiestaBadge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta badges where screename_richiedente = &#63; and is_last = &#63; from the database.
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 */
	@Override
	public void removeByRichiedente(String screename_richiedente,
		boolean is_last) {
		for (RichiestaBadge richiestaBadge : findByRichiedente(
				screename_richiedente, is_last, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(richiestaBadge);
		}
	}

	/**
	 * Returns the number of richiesta badges where screename_richiedente = &#63; and is_last = &#63;.
	 *
	 * @param screename_richiedente the screename_richiedente
	 * @param is_last the is_last
	 * @return the number of matching richiesta badges
	 */
	@Override
	public int countByRichiedente(String screename_richiedente, boolean is_last) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RICHIEDENTE;

		Object[] finderArgs = new Object[] { screename_richiedente, is_last };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RICHIESTABADGE_WHERE);

			boolean bindScreename_richiedente = false;

			if (screename_richiedente == null) {
				query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_1);
			}
			else if (screename_richiedente.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_3);
			}
			else {
				bindScreename_richiedente = true;

				query.append(_FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_2);
			}

			query.append(_FINDER_COLUMN_RICHIEDENTE_IS_LAST_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreename_richiedente) {
					qPos.add(screename_richiedente);
				}

				qPos.add(is_last);

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

	private static final String _FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_1 =
		"richiestaBadge.screename_richiedente IS NULL AND ";
	private static final String _FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_2 =
		"richiestaBadge.screename_richiedente = ? AND ";
	private static final String _FINDER_COLUMN_RICHIEDENTE_SCREENAME_RICHIEDENTE_3 =
		"(richiestaBadge.screename_richiedente IS NULL OR richiestaBadge.screename_richiedente = '') AND ";
	private static final String _FINDER_COLUMN_RICHIEDENTE_IS_LAST_2 = "richiestaBadge.is_last = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RUOLO = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRuolo",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLO = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuolo",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			RichiestaBadgeModelImpl.IS_LAST_COLUMN_BITMASK |
			RichiestaBadgeModelImpl.IS_INTERNAL_COLUMN_BITMASK |
			RichiestaBadgeModelImpl.ID_STATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RUOLO = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuolo",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @return the matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato) {
		return findByRuolo(is_last, is_internal, id_stato, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @return the range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end) {
		return findByRuolo(is_last, is_internal, id_stato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return findByRuolo(is_last, is_internal, id_stato, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuolo(boolean is_last,
		boolean is_internal, long id_stato, int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLO;
			finderArgs = new Object[] { is_last, is_internal, id_stato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RUOLO;
			finderArgs = new Object[] {
					is_last, is_internal, id_stato,
					
					start, end, orderByComparator
				};
		}

		List<RichiestaBadge> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBadge>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaBadge richiestaBadge : list) {
					if ((is_last != richiestaBadge.getIs_last()) ||
							(is_internal != richiestaBadge.getIs_internal()) ||
							(id_stato != richiestaBadge.getId_stato())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

			query.append(_FINDER_COLUMN_RUOLO_IS_LAST_2);

			query.append(_FINDER_COLUMN_RUOLO_IS_INTERNAL_2);

			query.append(_FINDER_COLUMN_RUOLO_ID_STATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(is_last);

				qPos.add(is_internal);

				qPos.add(id_stato);

				if (!pagination) {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
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
	 * Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByRuolo_First(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByRuolo_First(is_last,
				is_internal, id_stato, orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("is_last=");
		msg.append(is_last);

		msg.append(", is_internal=");
		msg.append(is_internal);

		msg.append(", id_stato=");
		msg.append(id_stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByRuolo_First(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		List<RichiestaBadge> list = findByRuolo(is_last, is_internal, id_stato,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByRuolo_Last(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByRuolo_Last(is_last, is_internal,
				id_stato, orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("is_last=");
		msg.append(is_last);

		msg.append(", is_internal=");
		msg.append(is_internal);

		msg.append(", id_stato=");
		msg.append(id_stato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByRuolo_Last(boolean is_last,
		boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		int count = countByRuolo(is_last, is_internal, id_stato);

		if (count == 0) {
			return null;
		}

		List<RichiestaBadge> list = findByRuolo(is_last, is_internal, id_stato,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta badges before and after the current richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * @param id_pk the primary key of the current richiesta badge
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge[] findByRuolo_PrevAndNext(long id_pk,
		boolean is_last, boolean is_internal, long id_stato,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = findByPrimaryKey(id_pk);

		Session session = null;

		try {
			session = openSession();

			RichiestaBadge[] array = new RichiestaBadgeImpl[3];

			array[0] = getByRuolo_PrevAndNext(session, richiestaBadge, is_last,
					is_internal, id_stato, orderByComparator, true);

			array[1] = richiestaBadge;

			array[2] = getByRuolo_PrevAndNext(session, richiestaBadge, is_last,
					is_internal, id_stato, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RichiestaBadge getByRuolo_PrevAndNext(Session session,
		RichiestaBadge richiestaBadge, boolean is_last, boolean is_internal,
		long id_stato, OrderByComparator<RichiestaBadge> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

		query.append(_FINDER_COLUMN_RUOLO_IS_LAST_2);

		query.append(_FINDER_COLUMN_RUOLO_IS_INTERNAL_2);

		query.append(_FINDER_COLUMN_RUOLO_ID_STATO_2);

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
			query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(is_last);

		qPos.add(is_internal);

		qPos.add(id_stato);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richiestaBadge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichiestaBadge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; from the database.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 */
	@Override
	public void removeByRuolo(boolean is_last, boolean is_internal,
		long id_stato) {
		for (RichiestaBadge richiestaBadge : findByRuolo(is_last, is_internal,
				id_stato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(richiestaBadge);
		}
	}

	/**
	 * Returns the number of richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @return the number of matching richiesta badges
	 */
	@Override
	public int countByRuolo(boolean is_last, boolean is_internal, long id_stato) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RUOLO;

		Object[] finderArgs = new Object[] { is_last, is_internal, id_stato };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RICHIESTABADGE_WHERE);

			query.append(_FINDER_COLUMN_RUOLO_IS_LAST_2);

			query.append(_FINDER_COLUMN_RUOLO_IS_INTERNAL_2);

			query.append(_FINDER_COLUMN_RUOLO_ID_STATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(is_last);

				qPos.add(is_internal);

				qPos.add(id_stato);

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

	private static final String _FINDER_COLUMN_RUOLO_IS_LAST_2 = "richiestaBadge.is_last = ? AND ";
	private static final String _FINDER_COLUMN_RUOLO_IS_INTERNAL_2 = "richiestaBadge.is_internal = ? AND ";
	private static final String _FINDER_COLUMN_RUOLO_ID_STATO_2 = "richiestaBadge.id_stato = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RUOLOSEDE =
		new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRuoloSede",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLOSEDE =
		new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED,
			RichiestaBadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuoloSede",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			RichiestaBadgeModelImpl.IS_LAST_COLUMN_BITMASK |
			RichiestaBadgeModelImpl.IS_INTERNAL_COLUMN_BITMASK |
			RichiestaBadgeModelImpl.ID_STATO_COLUMN_BITMASK |
			RichiestaBadgeModelImpl.ID_SEDESIAP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RUOLOSEDE = new FinderPath(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuoloSede",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @return the matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap) {
		return findByRuoloSede(is_last, is_internal, id_stato, id_sedesiap,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @return the range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start, int end) {
		return findByRuoloSede(is_last, is_internal, id_stato, id_sedesiap,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator) {
		return findByRuoloSede(is_last, is_internal, id_stato, id_sedesiap,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findByRuoloSede(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap, int start,
		int end, OrderByComparator<RichiestaBadge> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLOSEDE;
			finderArgs = new Object[] {
					is_last, is_internal, id_stato, id_sedesiap
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RUOLOSEDE;
			finderArgs = new Object[] {
					is_last, is_internal, id_stato, id_sedesiap,
					
					start, end, orderByComparator
				};
		}

		List<RichiestaBadge> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBadge>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RichiestaBadge richiestaBadge : list) {
					if ((is_last != richiestaBadge.getIs_last()) ||
							(is_internal != richiestaBadge.getIs_internal()) ||
							(id_stato != richiestaBadge.getId_stato()) ||
							(id_sedesiap != richiestaBadge.getId_sedesiap())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

			query.append(_FINDER_COLUMN_RUOLOSEDE_IS_LAST_2);

			query.append(_FINDER_COLUMN_RUOLOSEDE_IS_INTERNAL_2);

			query.append(_FINDER_COLUMN_RUOLOSEDE_ID_STATO_2);

			query.append(_FINDER_COLUMN_RUOLOSEDE_ID_SEDESIAP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(is_last);

				qPos.add(is_internal);

				qPos.add(id_stato);

				qPos.add(id_sedesiap);

				if (!pagination) {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
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
	 * Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByRuoloSede_First(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByRuoloSede_First(is_last,
				is_internal, id_stato, id_sedesiap, orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("is_last=");
		msg.append(is_last);

		msg.append(", is_internal=");
		msg.append(is_internal);

		msg.append(", id_stato=");
		msg.append(id_stato);

		msg.append(", id_sedesiap=");
		msg.append(id_sedesiap);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the first richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByRuoloSede_First(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		List<RichiestaBadge> list = findByRuoloSede(is_last, is_internal,
				id_stato, id_sedesiap, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge findByRuoloSede_Last(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByRuoloSede_Last(is_last,
				is_internal, id_stato, id_sedesiap, orderByComparator);

		if (richiestaBadge != null) {
			return richiestaBadge;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("is_last=");
		msg.append(is_last);

		msg.append(", is_internal=");
		msg.append(is_internal);

		msg.append(", id_stato=");
		msg.append(id_stato);

		msg.append(", id_sedesiap=");
		msg.append(id_sedesiap);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiestaBadgeException(msg.toString());
	}

	/**
	 * Returns the last richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richiesta badge, or <code>null</code> if a matching richiesta badge could not be found
	 */
	@Override
	public RichiestaBadge fetchByRuoloSede_Last(boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		int count = countByRuoloSede(is_last, is_internal, id_stato, id_sedesiap);

		if (count == 0) {
			return null;
		}

		List<RichiestaBadge> list = findByRuoloSede(is_last, is_internal,
				id_stato, id_sedesiap, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiesta badges before and after the current richiesta badge in the ordered set where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * @param id_pk the primary key of the current richiesta badge
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge[] findByRuoloSede_PrevAndNext(long id_pk,
		boolean is_last, boolean is_internal, long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = findByPrimaryKey(id_pk);

		Session session = null;

		try {
			session = openSession();

			RichiestaBadge[] array = new RichiestaBadgeImpl[3];

			array[0] = getByRuoloSede_PrevAndNext(session, richiestaBadge,
					is_last, is_internal, id_stato, id_sedesiap,
					orderByComparator, true);

			array[1] = richiestaBadge;

			array[2] = getByRuoloSede_PrevAndNext(session, richiestaBadge,
					is_last, is_internal, id_stato, id_sedesiap,
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

	protected RichiestaBadge getByRuoloSede_PrevAndNext(Session session,
		RichiestaBadge richiestaBadge, boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap,
		OrderByComparator<RichiestaBadge> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_RICHIESTABADGE_WHERE);

		query.append(_FINDER_COLUMN_RUOLOSEDE_IS_LAST_2);

		query.append(_FINDER_COLUMN_RUOLOSEDE_IS_INTERNAL_2);

		query.append(_FINDER_COLUMN_RUOLOSEDE_ID_STATO_2);

		query.append(_FINDER_COLUMN_RUOLOSEDE_ID_SEDESIAP_2);

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
			query.append(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(is_last);

		qPos.add(is_internal);

		qPos.add(id_stato);

		qPos.add(id_sedesiap);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richiestaBadge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RichiestaBadge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63; from the database.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 */
	@Override
	public void removeByRuoloSede(boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap) {
		for (RichiestaBadge richiestaBadge : findByRuoloSede(is_last,
				is_internal, id_stato, id_sedesiap, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(richiestaBadge);
		}
	}

	/**
	 * Returns the number of richiesta badges where is_last = &#63; and is_internal = &#63; and id_stato = &#63; and id_sedesiap = &#63;.
	 *
	 * @param is_last the is_last
	 * @param is_internal the is_internal
	 * @param id_stato the id_stato
	 * @param id_sedesiap the id_sedesiap
	 * @return the number of matching richiesta badges
	 */
	@Override
	public int countByRuoloSede(boolean is_last, boolean is_internal,
		long id_stato, long id_sedesiap) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RUOLOSEDE;

		Object[] finderArgs = new Object[] {
				is_last, is_internal, id_stato, id_sedesiap
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_RICHIESTABADGE_WHERE);

			query.append(_FINDER_COLUMN_RUOLOSEDE_IS_LAST_2);

			query.append(_FINDER_COLUMN_RUOLOSEDE_IS_INTERNAL_2);

			query.append(_FINDER_COLUMN_RUOLOSEDE_ID_STATO_2);

			query.append(_FINDER_COLUMN_RUOLOSEDE_ID_SEDESIAP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(is_last);

				qPos.add(is_internal);

				qPos.add(id_stato);

				qPos.add(id_sedesiap);

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

	private static final String _FINDER_COLUMN_RUOLOSEDE_IS_LAST_2 = "richiestaBadge.is_last = ? AND ";
	private static final String _FINDER_COLUMN_RUOLOSEDE_IS_INTERNAL_2 = "richiestaBadge.is_internal = ? AND ";
	private static final String _FINDER_COLUMN_RUOLOSEDE_ID_STATO_2 = "richiestaBadge.id_stato = ? AND ";
	private static final String _FINDER_COLUMN_RUOLOSEDE_ID_SEDESIAP_2 = "richiestaBadge.id_sedesiap = ?";

	public RichiestaBadgePersistenceImpl() {
		setModelClass(RichiestaBadge.class);
	}

	/**
	 * Caches the richiesta badge in the entity cache if it is enabled.
	 *
	 * @param richiestaBadge the richiesta badge
	 */
	@Override
	public void cacheResult(RichiestaBadge richiestaBadge) {
		entityCache.putResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeImpl.class, richiestaBadge.getPrimaryKey(),
			richiestaBadge);

		richiestaBadge.resetOriginalValues();
	}

	/**
	 * Caches the richiesta badges in the entity cache if it is enabled.
	 *
	 * @param richiestaBadges the richiesta badges
	 */
	@Override
	public void cacheResult(List<RichiestaBadge> richiestaBadges) {
		for (RichiestaBadge richiestaBadge : richiestaBadges) {
			if (entityCache.getResult(
						RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaBadgeImpl.class, richiestaBadge.getPrimaryKey()) == null) {
				cacheResult(richiestaBadge);
			}
			else {
				richiestaBadge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richiesta badges.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiestaBadgeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richiesta badge.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RichiestaBadge richiestaBadge) {
		entityCache.removeResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeImpl.class, richiestaBadge.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RichiestaBadge> richiestaBadges) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RichiestaBadge richiestaBadge : richiestaBadges) {
			entityCache.removeResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaBadgeImpl.class, richiestaBadge.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richiesta badge with the primary key. Does not add the richiesta badge to the database.
	 *
	 * @param id_pk the primary key for the new richiesta badge
	 * @return the new richiesta badge
	 */
	@Override
	public RichiestaBadge create(long id_pk) {
		RichiestaBadge richiestaBadge = new RichiestaBadgeImpl();

		richiestaBadge.setNew(true);
		richiestaBadge.setPrimaryKey(id_pk);

		return richiestaBadge;
	}

	/**
	 * Removes the richiesta badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk the primary key of the richiesta badge
	 * @return the richiesta badge that was removed
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge remove(long id_pk)
		throws NoSuchRichiestaBadgeException {
		return remove((Serializable)id_pk);
	}

	/**
	 * Removes the richiesta badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richiesta badge
	 * @return the richiesta badge that was removed
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge remove(Serializable primaryKey)
		throws NoSuchRichiestaBadgeException {
		Session session = null;

		try {
			session = openSession();

			RichiestaBadge richiestaBadge = (RichiestaBadge)session.get(RichiestaBadgeImpl.class,
					primaryKey);

			if (richiestaBadge == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiestaBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richiestaBadge);
		}
		catch (NoSuchRichiestaBadgeException nsee) {
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
	protected RichiestaBadge removeImpl(RichiestaBadge richiestaBadge) {
		richiestaBadge = toUnwrappedModel(richiestaBadge);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richiestaBadge)) {
				richiestaBadge = (RichiestaBadge)session.get(RichiestaBadgeImpl.class,
						richiestaBadge.getPrimaryKeyObj());
			}

			if (richiestaBadge != null) {
				session.delete(richiestaBadge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richiestaBadge != null) {
			clearCache(richiestaBadge);
		}

		return richiestaBadge;
	}

	@Override
	public RichiestaBadge updateImpl(RichiestaBadge richiestaBadge) {
		richiestaBadge = toUnwrappedModel(richiestaBadge);

		boolean isNew = richiestaBadge.isNew();

		RichiestaBadgeModelImpl richiestaBadgeModelImpl = (RichiestaBadgeModelImpl)richiestaBadge;

		Session session = null;

		try {
			session = openSession();

			if (richiestaBadge.isNew()) {
				session.save(richiestaBadge);

				richiestaBadge.setNew(false);
			}
			else {
				richiestaBadge = (RichiestaBadge)session.merge(richiestaBadge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RichiestaBadgeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((richiestaBadgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiestaBadgeModelImpl.getOriginalId_richiesta()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);

				args = new Object[] { richiestaBadgeModelImpl.getId_richiesta() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);
			}

			if ((richiestaBadgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIEDENTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiestaBadgeModelImpl.getOriginalScreename_richiedente(),
						richiestaBadgeModelImpl.getOriginalIs_last()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RICHIEDENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIEDENTE,
					args);

				args = new Object[] {
						richiestaBadgeModelImpl.getScreename_richiedente(),
						richiestaBadgeModelImpl.getIs_last()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RICHIEDENTE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RICHIEDENTE,
					args);
			}

			if ((richiestaBadgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiestaBadgeModelImpl.getOriginalIs_last(),
						richiestaBadgeModelImpl.getOriginalIs_internal(),
						richiestaBadgeModelImpl.getOriginalId_stato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RUOLO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLO,
					args);

				args = new Object[] {
						richiestaBadgeModelImpl.getIs_last(),
						richiestaBadgeModelImpl.getIs_internal(),
						richiestaBadgeModelImpl.getId_stato()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RUOLO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLO,
					args);
			}

			if ((richiestaBadgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLOSEDE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiestaBadgeModelImpl.getOriginalIs_last(),
						richiestaBadgeModelImpl.getOriginalIs_internal(),
						richiestaBadgeModelImpl.getOriginalId_stato(),
						richiestaBadgeModelImpl.getOriginalId_sedesiap()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RUOLOSEDE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLOSEDE,
					args);

				args = new Object[] {
						richiestaBadgeModelImpl.getIs_last(),
						richiestaBadgeModelImpl.getIs_internal(),
						richiestaBadgeModelImpl.getId_stato(),
						richiestaBadgeModelImpl.getId_sedesiap()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RUOLOSEDE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RUOLOSEDE,
					args);
			}
		}

		entityCache.putResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
			RichiestaBadgeImpl.class, richiestaBadge.getPrimaryKey(),
			richiestaBadge, false);

		richiestaBadge.resetOriginalValues();

		return richiestaBadge;
	}

	protected RichiestaBadge toUnwrappedModel(RichiestaBadge richiestaBadge) {
		if (richiestaBadge instanceof RichiestaBadgeImpl) {
			return richiestaBadge;
		}

		RichiestaBadgeImpl richiestaBadgeImpl = new RichiestaBadgeImpl();

		richiestaBadgeImpl.setNew(richiestaBadge.isNew());
		richiestaBadgeImpl.setPrimaryKey(richiestaBadge.getPrimaryKey());

		richiestaBadgeImpl.setId_pk(richiestaBadge.getId_pk());
		richiestaBadgeImpl.setId_richiesta(richiestaBadge.getId_richiesta());
		richiestaBadgeImpl.setScreename_richiedente(richiestaBadge.getScreename_richiedente());
		richiestaBadgeImpl.setId_ufficio(richiestaBadge.getId_ufficio());
		richiestaBadgeImpl.setId_sedesiap(richiestaBadge.getId_sedesiap());
		richiestaBadgeImpl.setJson_richiedente(richiestaBadge.getJson_richiedente());
		richiestaBadgeImpl.setIs_internal(richiestaBadge.isIs_internal());
		richiestaBadgeImpl.setNome_intestatario(richiestaBadge.getNome_intestatario());
		richiestaBadgeImpl.setCognome_intestatario(richiestaBadge.getCognome_intestatario());
		richiestaBadgeImpl.setCf_intestatario(richiestaBadge.getCf_intestatario());
		richiestaBadgeImpl.setLuogonascita_intestatario(richiestaBadge.getLuogonascita_intestatario());
		richiestaBadgeImpl.setDatanascita_intestatario(richiestaBadge.getDatanascita_intestatario());
		richiestaBadgeImpl.setId_oggetto(richiestaBadge.getId_oggetto());
		richiestaBadgeImpl.setNumero_badge(richiestaBadge.getNumero_badge());
		richiestaBadgeImpl.setUuid_foto(richiestaBadge.getUuid_foto());
		richiestaBadgeImpl.setUuid_modulosostituzione(richiestaBadge.getUuid_modulosostituzione());
		richiestaBadgeImpl.setSocieta(richiestaBadge.getSocieta());
		richiestaBadgeImpl.setReferente_societa(richiestaBadge.getReferente_societa());
		richiestaBadgeImpl.setProgetto(richiestaBadge.getProgetto());
		richiestaBadgeImpl.setJson_richiesta_external(richiestaBadge.getJson_richiesta_external());
		richiestaBadgeImpl.setArray_sedi_abilitate(richiestaBadge.getArray_sedi_abilitate());
		richiestaBadgeImpl.setMotivazione(richiestaBadge.getMotivazione());
		richiestaBadgeImpl.setData_scadenza(richiestaBadge.getData_scadenza());
		richiestaBadgeImpl.setUuid_modulopdf(richiestaBadge.getUuid_modulopdf());
		richiestaBadgeImpl.setData_richiesta(richiestaBadge.getData_richiesta());
		richiestaBadgeImpl.setData_modifica(richiestaBadge.getData_modifica());
		richiestaBadgeImpl.setId_stato(richiestaBadge.getId_stato());
		richiestaBadgeImpl.setUtente_cambio_stato(richiestaBadge.getUtente_cambio_stato());
		richiestaBadgeImpl.setNote(richiestaBadge.getNote());
		richiestaBadgeImpl.setIs_last(richiestaBadge.isIs_last());

		return richiestaBadgeImpl;
	}

	/**
	 * Returns the richiesta badge with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta badge
	 * @return the richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiestaBadgeException {
		RichiestaBadge richiestaBadge = fetchByPrimaryKey(primaryKey);

		if (richiestaBadge == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiestaBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richiestaBadge;
	}

	/**
	 * Returns the richiesta badge with the primary key or throws a {@link NoSuchRichiestaBadgeException} if it could not be found.
	 *
	 * @param id_pk the primary key of the richiesta badge
	 * @return the richiesta badge
	 * @throws NoSuchRichiestaBadgeException if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge findByPrimaryKey(long id_pk)
		throws NoSuchRichiestaBadgeException {
		return findByPrimaryKey((Serializable)id_pk);
	}

	/**
	 * Returns the richiesta badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richiesta badge
	 * @return the richiesta badge, or <code>null</code> if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
				RichiestaBadgeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RichiestaBadge richiestaBadge = (RichiestaBadge)serializable;

		if (richiestaBadge == null) {
			Session session = null;

			try {
				session = openSession();

				richiestaBadge = (RichiestaBadge)session.get(RichiestaBadgeImpl.class,
						primaryKey);

				if (richiestaBadge != null) {
					cacheResult(richiestaBadge);
				}
				else {
					entityCache.putResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
						RichiestaBadgeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaBadgeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richiestaBadge;
	}

	/**
	 * Returns the richiesta badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_pk the primary key of the richiesta badge
	 * @return the richiesta badge, or <code>null</code> if a richiesta badge with the primary key could not be found
	 */
	@Override
	public RichiestaBadge fetchByPrimaryKey(long id_pk) {
		return fetchByPrimaryKey((Serializable)id_pk);
	}

	@Override
	public Map<Serializable, RichiestaBadge> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RichiestaBadge> map = new HashMap<Serializable, RichiestaBadge>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RichiestaBadge richiestaBadge = fetchByPrimaryKey(primaryKey);

			if (richiestaBadge != null) {
				map.put(primaryKey, richiestaBadge);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaBadgeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RichiestaBadge)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTABADGE_WHERE_PKS_IN);

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

			for (RichiestaBadge richiestaBadge : (List<RichiestaBadge>)q.list()) {
				map.put(richiestaBadge.getPrimaryKeyObj(), richiestaBadge);

				cacheResult(richiestaBadge);

				uncachedPrimaryKeys.remove(richiestaBadge.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiestaBadgeModelImpl.ENTITY_CACHE_ENABLED,
					RichiestaBadgeImpl.class, primaryKey, nullModel);
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
	 * Returns all the richiesta badges.
	 *
	 * @return the richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiesta badges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @return the range of richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiesta badges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findAll(int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiesta badges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiestaBadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta badges
	 * @param end the upper bound of the range of richiesta badges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiesta badges
	 */
	@Override
	public List<RichiestaBadge> findAll(int start, int end,
		OrderByComparator<RichiestaBadge> orderByComparator,
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

		List<RichiestaBadge> list = null;

		if (retrieveFromCache) {
			list = (List<RichiestaBadge>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTABADGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTABADGE;

				if (pagination) {
					sql = sql.concat(RichiestaBadgeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RichiestaBadge>)QueryUtil.list(q,
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
	 * Removes all the richiesta badges from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RichiestaBadge richiestaBadge : findAll()) {
			remove(richiestaBadge);
		}
	}

	/**
	 * Returns the number of richiesta badges.
	 *
	 * @return the number of richiesta badges
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTABADGE);

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
		return RichiestaBadgeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richiesta badge persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiestaBadgeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTABADGE = "SELECT richiestaBadge FROM RichiestaBadge richiestaBadge";
	private static final String _SQL_SELECT_RICHIESTABADGE_WHERE_PKS_IN = "SELECT richiestaBadge FROM RichiestaBadge richiestaBadge WHERE id_pk IN (";
	private static final String _SQL_SELECT_RICHIESTABADGE_WHERE = "SELECT richiestaBadge FROM RichiestaBadge richiestaBadge WHERE ";
	private static final String _SQL_COUNT_RICHIESTABADGE = "SELECT COUNT(richiestaBadge) FROM RichiestaBadge richiestaBadge";
	private static final String _SQL_COUNT_RICHIESTABADGE_WHERE = "SELECT COUNT(richiestaBadge) FROM RichiestaBadge richiestaBadge WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richiestaBadge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RichiestaBadge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RichiestaBadge exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RichiestaBadgePersistenceImpl.class);
}