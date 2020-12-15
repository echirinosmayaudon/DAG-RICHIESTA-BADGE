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

import servizio.richieste.badge.mef.exception.NoSuchSediEsterneException;
import servizio.richieste.badge.mef.model.SediEsterne;
import servizio.richieste.badge.mef.model.impl.SediEsterneImpl;
import servizio.richieste.badge.mef.model.impl.SediEsterneModelImpl;
import servizio.richieste.badge.mef.service.persistence.SediEsternePersistence;

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
 * The persistence implementation for the sedi esterne service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediEsternePersistence
 * @see servizio.richieste.badge.mef.service.persistence.SediEsterneUtil
 * @generated
 */
@ProviderType
public class SediEsternePersistenceImpl extends BasePersistenceImpl<SediEsterne>
	implements SediEsternePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SediEsterneUtil} to access the sedi esterne persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SediEsterneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, SediEsterneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, SediEsterneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSEDESIAP =
		new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, SediEsterneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdSedeSiap",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSEDESIAP =
		new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, SediEsterneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdSedeSiap",
			new String[] { Long.class.getName() },
			SediEsterneModelImpl.ID_SEDESIAP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDSEDESIAP = new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdSedeSiap",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sedi esternes where id_sedesiap = &#63;.
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @return the matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByIdSedeSiap(long id_sedesiap) {
		return findByIdSedeSiap(id_sedesiap, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sedi esternes where id_sedesiap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @return the range of matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByIdSedeSiap(long id_sedesiap, int start,
		int end) {
		return findByIdSedeSiap(id_sedesiap, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sedi esternes where id_sedesiap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByIdSedeSiap(long id_sedesiap, int start,
		int end, OrderByComparator<SediEsterne> orderByComparator) {
		return findByIdSedeSiap(id_sedesiap, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sedi esternes where id_sedesiap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByIdSedeSiap(long id_sedesiap, int start,
		int end, OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSEDESIAP;
			finderArgs = new Object[] { id_sedesiap };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSEDESIAP;
			finderArgs = new Object[] { id_sedesiap, start, end, orderByComparator };
		}

		List<SediEsterne> list = null;

		if (retrieveFromCache) {
			list = (List<SediEsterne>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SediEsterne sediEsterne : list) {
					if ((id_sedesiap != sediEsterne.getId_sedesiap())) {
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

			query.append(_SQL_SELECT_SEDIESTERNE_WHERE);

			query.append(_FINDER_COLUMN_IDSEDESIAP_ID_SEDESIAP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SediEsterneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_sedesiap);

				if (!pagination) {
					list = (List<SediEsterne>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SediEsterne>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sedi esterne in the ordered set where id_sedesiap = &#63;.
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi esterne
	 * @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne findByIdSedeSiap_First(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException {
		SediEsterne sediEsterne = fetchByIdSedeSiap_First(id_sedesiap,
				orderByComparator);

		if (sediEsterne != null) {
			return sediEsterne;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_sedesiap=");
		msg.append(id_sedesiap);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediEsterneException(msg.toString());
	}

	/**
	 * Returns the first sedi esterne in the ordered set where id_sedesiap = &#63;.
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne fetchByIdSedeSiap_First(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator) {
		List<SediEsterne> list = findByIdSedeSiap(id_sedesiap, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sedi esterne in the ordered set where id_sedesiap = &#63;.
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi esterne
	 * @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne findByIdSedeSiap_Last(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException {
		SediEsterne sediEsterne = fetchByIdSedeSiap_Last(id_sedesiap,
				orderByComparator);

		if (sediEsterne != null) {
			return sediEsterne;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_sedesiap=");
		msg.append(id_sedesiap);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediEsterneException(msg.toString());
	}

	/**
	 * Returns the last sedi esterne in the ordered set where id_sedesiap = &#63;.
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne fetchByIdSedeSiap_Last(long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator) {
		int count = countByIdSedeSiap(id_sedesiap);

		if (count == 0) {
			return null;
		}

		List<SediEsterne> list = findByIdSedeSiap(id_sedesiap, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sedi esternes before and after the current sedi esterne in the ordered set where id_sedesiap = &#63;.
	 *
	 * @param id_sede_esterna the primary key of the current sedi esterne
	 * @param id_sedesiap the id_sedesiap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sedi esterne
	 * @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne[] findByIdSedeSiap_PrevAndNext(long id_sede_esterna,
		long id_sedesiap, OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException {
		SediEsterne sediEsterne = findByPrimaryKey(id_sede_esterna);

		Session session = null;

		try {
			session = openSession();

			SediEsterne[] array = new SediEsterneImpl[3];

			array[0] = getByIdSedeSiap_PrevAndNext(session, sediEsterne,
					id_sedesiap, orderByComparator, true);

			array[1] = sediEsterne;

			array[2] = getByIdSedeSiap_PrevAndNext(session, sediEsterne,
					id_sedesiap, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SediEsterne getByIdSedeSiap_PrevAndNext(Session session,
		SediEsterne sediEsterne, long id_sedesiap,
		OrderByComparator<SediEsterne> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEDIESTERNE_WHERE);

		query.append(_FINDER_COLUMN_IDSEDESIAP_ID_SEDESIAP_2);

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
			query.append(SediEsterneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_sedesiap);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sediEsterne);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SediEsterne> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sedi esternes where id_sedesiap = &#63; from the database.
	 *
	 * @param id_sedesiap the id_sedesiap
	 */
	@Override
	public void removeByIdSedeSiap(long id_sedesiap) {
		for (SediEsterne sediEsterne : findByIdSedeSiap(id_sedesiap,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sediEsterne);
		}
	}

	/**
	 * Returns the number of sedi esternes where id_sedesiap = &#63;.
	 *
	 * @param id_sedesiap the id_sedesiap
	 * @return the number of matching sedi esternes
	 */
	@Override
	public int countByIdSedeSiap(long id_sedesiap) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDSEDESIAP;

		Object[] finderArgs = new Object[] { id_sedesiap };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEDIESTERNE_WHERE);

			query.append(_FINDER_COLUMN_IDSEDESIAP_ID_SEDESIAP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_IDSEDESIAP_ID_SEDESIAP_2 = "sediEsterne.id_sedesiap = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACRONIMOSEDE =
		new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, SediEsterneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAcronimoSede",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACRONIMOSEDE =
		new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, SediEsterneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAcronimoSede",
			new String[] { String.class.getName() },
			SediEsterneModelImpl.ACRONIMO_SEDE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACRONIMOSEDE = new FinderPath(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAcronimoSede",
			new String[] { String.class.getName() });

	/**
	 * Returns all the sedi esternes where acronimo_sede = &#63;.
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @return the matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByAcronimoSede(String acronimo_sede) {
		return findByAcronimoSede(acronimo_sede, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sedi esternes where acronimo_sede = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @return the range of matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByAcronimoSede(String acronimo_sede,
		int start, int end) {
		return findByAcronimoSede(acronimo_sede, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sedi esternes where acronimo_sede = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByAcronimoSede(String acronimo_sede,
		int start, int end, OrderByComparator<SediEsterne> orderByComparator) {
		return findByAcronimoSede(acronimo_sede, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the sedi esternes where acronimo_sede = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sedi esternes
	 */
	@Override
	public List<SediEsterne> findByAcronimoSede(String acronimo_sede,
		int start, int end, OrderByComparator<SediEsterne> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACRONIMOSEDE;
			finderArgs = new Object[] { acronimo_sede };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACRONIMOSEDE;
			finderArgs = new Object[] {
					acronimo_sede,
					
					start, end, orderByComparator
				};
		}

		List<SediEsterne> list = null;

		if (retrieveFromCache) {
			list = (List<SediEsterne>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SediEsterne sediEsterne : list) {
					if (!Objects.equals(acronimo_sede,
								sediEsterne.getAcronimo_sede())) {
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

			query.append(_SQL_SELECT_SEDIESTERNE_WHERE);

			boolean bindAcronimo_sede = false;

			if (acronimo_sede == null) {
				query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_1);
			}
			else if (acronimo_sede.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_3);
			}
			else {
				bindAcronimo_sede = true;

				query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SediEsterneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAcronimo_sede) {
					qPos.add(acronimo_sede);
				}

				if (!pagination) {
					list = (List<SediEsterne>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SediEsterne>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sedi esterne in the ordered set where acronimo_sede = &#63;.
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi esterne
	 * @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne findByAcronimoSede_First(String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException {
		SediEsterne sediEsterne = fetchByAcronimoSede_First(acronimo_sede,
				orderByComparator);

		if (sediEsterne != null) {
			return sediEsterne;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("acronimo_sede=");
		msg.append(acronimo_sede);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediEsterneException(msg.toString());
	}

	/**
	 * Returns the first sedi esterne in the ordered set where acronimo_sede = &#63;.
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne fetchByAcronimoSede_First(String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator) {
		List<SediEsterne> list = findByAcronimoSede(acronimo_sede, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sedi esterne in the ordered set where acronimo_sede = &#63;.
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi esterne
	 * @throws NoSuchSediEsterneException if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne findByAcronimoSede_Last(String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException {
		SediEsterne sediEsterne = fetchByAcronimoSede_Last(acronimo_sede,
				orderByComparator);

		if (sediEsterne != null) {
			return sediEsterne;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("acronimo_sede=");
		msg.append(acronimo_sede);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediEsterneException(msg.toString());
	}

	/**
	 * Returns the last sedi esterne in the ordered set where acronimo_sede = &#63;.
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi esterne, or <code>null</code> if a matching sedi esterne could not be found
	 */
	@Override
	public SediEsterne fetchByAcronimoSede_Last(String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator) {
		int count = countByAcronimoSede(acronimo_sede);

		if (count == 0) {
			return null;
		}

		List<SediEsterne> list = findByAcronimoSede(acronimo_sede, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sedi esternes before and after the current sedi esterne in the ordered set where acronimo_sede = &#63;.
	 *
	 * @param id_sede_esterna the primary key of the current sedi esterne
	 * @param acronimo_sede the acronimo_sede
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sedi esterne
	 * @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne[] findByAcronimoSede_PrevAndNext(long id_sede_esterna,
		String acronimo_sede, OrderByComparator<SediEsterne> orderByComparator)
		throws NoSuchSediEsterneException {
		SediEsterne sediEsterne = findByPrimaryKey(id_sede_esterna);

		Session session = null;

		try {
			session = openSession();

			SediEsterne[] array = new SediEsterneImpl[3];

			array[0] = getByAcronimoSede_PrevAndNext(session, sediEsterne,
					acronimo_sede, orderByComparator, true);

			array[1] = sediEsterne;

			array[2] = getByAcronimoSede_PrevAndNext(session, sediEsterne,
					acronimo_sede, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SediEsterne getByAcronimoSede_PrevAndNext(Session session,
		SediEsterne sediEsterne, String acronimo_sede,
		OrderByComparator<SediEsterne> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEDIESTERNE_WHERE);

		boolean bindAcronimo_sede = false;

		if (acronimo_sede == null) {
			query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_1);
		}
		else if (acronimo_sede.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_3);
		}
		else {
			bindAcronimo_sede = true;

			query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_2);
		}

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
			query.append(SediEsterneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAcronimo_sede) {
			qPos.add(acronimo_sede);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sediEsterne);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SediEsterne> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sedi esternes where acronimo_sede = &#63; from the database.
	 *
	 * @param acronimo_sede the acronimo_sede
	 */
	@Override
	public void removeByAcronimoSede(String acronimo_sede) {
		for (SediEsterne sediEsterne : findByAcronimoSede(acronimo_sede,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sediEsterne);
		}
	}

	/**
	 * Returns the number of sedi esternes where acronimo_sede = &#63;.
	 *
	 * @param acronimo_sede the acronimo_sede
	 * @return the number of matching sedi esternes
	 */
	@Override
	public int countByAcronimoSede(String acronimo_sede) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACRONIMOSEDE;

		Object[] finderArgs = new Object[] { acronimo_sede };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEDIESTERNE_WHERE);

			boolean bindAcronimo_sede = false;

			if (acronimo_sede == null) {
				query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_1);
			}
			else if (acronimo_sede.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_3);
			}
			else {
				bindAcronimo_sede = true;

				query.append(_FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAcronimo_sede) {
					qPos.add(acronimo_sede);
				}

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

	private static final String _FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_1 = "sediEsterne.acronimo_sede IS NULL";
	private static final String _FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_2 = "sediEsterne.acronimo_sede = ?";
	private static final String _FINDER_COLUMN_ACRONIMOSEDE_ACRONIMO_SEDE_3 = "(sediEsterne.acronimo_sede IS NULL OR sediEsterne.acronimo_sede = '')";

	public SediEsternePersistenceImpl() {
		setModelClass(SediEsterne.class);
	}

	/**
	 * Caches the sedi esterne in the entity cache if it is enabled.
	 *
	 * @param sediEsterne the sedi esterne
	 */
	@Override
	public void cacheResult(SediEsterne sediEsterne) {
		entityCache.putResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneImpl.class, sediEsterne.getPrimaryKey(), sediEsterne);

		sediEsterne.resetOriginalValues();
	}

	/**
	 * Caches the sedi esternes in the entity cache if it is enabled.
	 *
	 * @param sediEsternes the sedi esternes
	 */
	@Override
	public void cacheResult(List<SediEsterne> sediEsternes) {
		for (SediEsterne sediEsterne : sediEsternes) {
			if (entityCache.getResult(
						SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
						SediEsterneImpl.class, sediEsterne.getPrimaryKey()) == null) {
				cacheResult(sediEsterne);
			}
			else {
				sediEsterne.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sedi esternes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SediEsterneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sedi esterne.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SediEsterne sediEsterne) {
		entityCache.removeResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneImpl.class, sediEsterne.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SediEsterne> sediEsternes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SediEsterne sediEsterne : sediEsternes) {
			entityCache.removeResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
				SediEsterneImpl.class, sediEsterne.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sedi esterne with the primary key. Does not add the sedi esterne to the database.
	 *
	 * @param id_sede_esterna the primary key for the new sedi esterne
	 * @return the new sedi esterne
	 */
	@Override
	public SediEsterne create(long id_sede_esterna) {
		SediEsterne sediEsterne = new SediEsterneImpl();

		sediEsterne.setNew(true);
		sediEsterne.setPrimaryKey(id_sede_esterna);

		return sediEsterne;
	}

	/**
	 * Removes the sedi esterne with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_sede_esterna the primary key of the sedi esterne
	 * @return the sedi esterne that was removed
	 * @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne remove(long id_sede_esterna)
		throws NoSuchSediEsterneException {
		return remove((Serializable)id_sede_esterna);
	}

	/**
	 * Removes the sedi esterne with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sedi esterne
	 * @return the sedi esterne that was removed
	 * @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne remove(Serializable primaryKey)
		throws NoSuchSediEsterneException {
		Session session = null;

		try {
			session = openSession();

			SediEsterne sediEsterne = (SediEsterne)session.get(SediEsterneImpl.class,
					primaryKey);

			if (sediEsterne == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSediEsterneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sediEsterne);
		}
		catch (NoSuchSediEsterneException nsee) {
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
	protected SediEsterne removeImpl(SediEsterne sediEsterne) {
		sediEsterne = toUnwrappedModel(sediEsterne);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sediEsterne)) {
				sediEsterne = (SediEsterne)session.get(SediEsterneImpl.class,
						sediEsterne.getPrimaryKeyObj());
			}

			if (sediEsterne != null) {
				session.delete(sediEsterne);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sediEsterne != null) {
			clearCache(sediEsterne);
		}

		return sediEsterne;
	}

	@Override
	public SediEsterne updateImpl(SediEsterne sediEsterne) {
		sediEsterne = toUnwrappedModel(sediEsterne);

		boolean isNew = sediEsterne.isNew();

		SediEsterneModelImpl sediEsterneModelImpl = (SediEsterneModelImpl)sediEsterne;

		Session session = null;

		try {
			session = openSession();

			if (sediEsterne.isNew()) {
				session.save(sediEsterne);

				sediEsterne.setNew(false);
			}
			else {
				sediEsterne = (SediEsterne)session.merge(sediEsterne);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SediEsterneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sediEsterneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSEDESIAP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sediEsterneModelImpl.getOriginalId_sedesiap()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSEDESIAP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSEDESIAP,
					args);

				args = new Object[] { sediEsterneModelImpl.getId_sedesiap() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSEDESIAP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSEDESIAP,
					args);
			}

			if ((sediEsterneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACRONIMOSEDE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sediEsterneModelImpl.getOriginalAcronimo_sede()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACRONIMOSEDE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACRONIMOSEDE,
					args);

				args = new Object[] { sediEsterneModelImpl.getAcronimo_sede() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACRONIMOSEDE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACRONIMOSEDE,
					args);
			}
		}

		entityCache.putResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
			SediEsterneImpl.class, sediEsterne.getPrimaryKey(), sediEsterne,
			false);

		sediEsterne.resetOriginalValues();

		return sediEsterne;
	}

	protected SediEsterne toUnwrappedModel(SediEsterne sediEsterne) {
		if (sediEsterne instanceof SediEsterneImpl) {
			return sediEsterne;
		}

		SediEsterneImpl sediEsterneImpl = new SediEsterneImpl();

		sediEsterneImpl.setNew(sediEsterne.isNew());
		sediEsterneImpl.setPrimaryKey(sediEsterne.getPrimaryKey());

		sediEsterneImpl.setId_sede_esterna(sediEsterne.getId_sede_esterna());
		sediEsterneImpl.setNome_sede_esterna(sediEsterne.getNome_sede_esterna());
		sediEsterneImpl.setId_sedesiap(sediEsterne.getId_sedesiap());
		sediEsterneImpl.setAcronimo_sede(sediEsterne.getAcronimo_sede());

		return sediEsterneImpl;
	}

	/**
	 * Returns the sedi esterne with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sedi esterne
	 * @return the sedi esterne
	 * @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSediEsterneException {
		SediEsterne sediEsterne = fetchByPrimaryKey(primaryKey);

		if (sediEsterne == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSediEsterneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sediEsterne;
	}

	/**
	 * Returns the sedi esterne with the primary key or throws a {@link NoSuchSediEsterneException} if it could not be found.
	 *
	 * @param id_sede_esterna the primary key of the sedi esterne
	 * @return the sedi esterne
	 * @throws NoSuchSediEsterneException if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne findByPrimaryKey(long id_sede_esterna)
		throws NoSuchSediEsterneException {
		return findByPrimaryKey((Serializable)id_sede_esterna);
	}

	/**
	 * Returns the sedi esterne with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sedi esterne
	 * @return the sedi esterne, or <code>null</code> if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
				SediEsterneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SediEsterne sediEsterne = (SediEsterne)serializable;

		if (sediEsterne == null) {
			Session session = null;

			try {
				session = openSession();

				sediEsterne = (SediEsterne)session.get(SediEsterneImpl.class,
						primaryKey);

				if (sediEsterne != null) {
					cacheResult(sediEsterne);
				}
				else {
					entityCache.putResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
						SediEsterneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
					SediEsterneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sediEsterne;
	}

	/**
	 * Returns the sedi esterne with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_sede_esterna the primary key of the sedi esterne
	 * @return the sedi esterne, or <code>null</code> if a sedi esterne with the primary key could not be found
	 */
	@Override
	public SediEsterne fetchByPrimaryKey(long id_sede_esterna) {
		return fetchByPrimaryKey((Serializable)id_sede_esterna);
	}

	@Override
	public Map<Serializable, SediEsterne> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SediEsterne> map = new HashMap<Serializable, SediEsterne>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SediEsterne sediEsterne = fetchByPrimaryKey(primaryKey);

			if (sediEsterne != null) {
				map.put(primaryKey, sediEsterne);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
					SediEsterneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SediEsterne)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SEDIESTERNE_WHERE_PKS_IN);

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

			for (SediEsterne sediEsterne : (List<SediEsterne>)q.list()) {
				map.put(sediEsterne.getPrimaryKeyObj(), sediEsterne);

				cacheResult(sediEsterne);

				uncachedPrimaryKeys.remove(sediEsterne.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SediEsterneModelImpl.ENTITY_CACHE_ENABLED,
					SediEsterneImpl.class, primaryKey, nullModel);
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
	 * Returns all the sedi esternes.
	 *
	 * @return the sedi esternes
	 */
	@Override
	public List<SediEsterne> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sedi esternes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @return the range of sedi esternes
	 */
	@Override
	public List<SediEsterne> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sedi esternes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sedi esternes
	 */
	@Override
	public List<SediEsterne> findAll(int start, int end,
		OrderByComparator<SediEsterne> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sedi esternes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediEsterneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedi esternes
	 * @param end the upper bound of the range of sedi esternes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sedi esternes
	 */
	@Override
	public List<SediEsterne> findAll(int start, int end,
		OrderByComparator<SediEsterne> orderByComparator,
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

		List<SediEsterne> list = null;

		if (retrieveFromCache) {
			list = (List<SediEsterne>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEDIESTERNE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEDIESTERNE;

				if (pagination) {
					sql = sql.concat(SediEsterneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SediEsterne>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SediEsterne>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sedi esternes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SediEsterne sediEsterne : findAll()) {
			remove(sediEsterne);
		}
	}

	/**
	 * Returns the number of sedi esternes.
	 *
	 * @return the number of sedi esternes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEDIESTERNE);

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
		return SediEsterneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sedi esterne persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SediEsterneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SEDIESTERNE = "SELECT sediEsterne FROM SediEsterne sediEsterne";
	private static final String _SQL_SELECT_SEDIESTERNE_WHERE_PKS_IN = "SELECT sediEsterne FROM SediEsterne sediEsterne WHERE id_sede_esterna IN (";
	private static final String _SQL_SELECT_SEDIESTERNE_WHERE = "SELECT sediEsterne FROM SediEsterne sediEsterne WHERE ";
	private static final String _SQL_COUNT_SEDIESTERNE = "SELECT COUNT(sediEsterne) FROM SediEsterne sediEsterne";
	private static final String _SQL_COUNT_SEDIESTERNE_WHERE = "SELECT COUNT(sediEsterne) FROM SediEsterne sediEsterne WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sediEsterne.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SediEsterne exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SediEsterne exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SediEsternePersistenceImpl.class);
}