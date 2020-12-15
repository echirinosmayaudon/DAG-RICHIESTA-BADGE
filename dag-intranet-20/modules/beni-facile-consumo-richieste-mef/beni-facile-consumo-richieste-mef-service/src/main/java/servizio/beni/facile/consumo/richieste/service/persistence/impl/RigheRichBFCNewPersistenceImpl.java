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

package servizio.beni.facile.consumo.richieste.service.persistence.impl;

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

import servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException;
import servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew;
import servizio.beni.facile.consumo.richieste.model.impl.RigheRichBFCNewImpl;
import servizio.beni.facile.consumo.richieste.model.impl.RigheRichBFCNewModelImpl;
import servizio.beni.facile.consumo.richieste.service.persistence.RigheRichBFCNewPersistence;

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
 * The persistence implementation for the righe rich b f c new service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichBFCNewPersistence
 * @see servizio.beni.facile.consumo.richieste.service.persistence.RigheRichBFCNewUtil
 * @generated
 */
@ProviderType
public class RigheRichBFCNewPersistenceImpl extends BasePersistenceImpl<RigheRichBFCNew>
	implements RigheRichBFCNewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RigheRichBFCNewUtil} to access the righe rich b f c new persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RigheRichBFCNewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED,
			RigheRichBFCNewImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED,
			RigheRichBFCNewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTO =
		new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED,
			RigheRichBFCNewImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDipartimento",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO =
		new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED,
			RigheRichBFCNewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDipartimento",
			new String[] { String.class.getName() },
			RigheRichBFCNewModelImpl.DIPARTIMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIPARTIMENTO = new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDipartimento",
			new String[] { String.class.getName() });

	/**
	 * Returns all the righe rich b f c news where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @return the matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByDipartimento(String dipartimento) {
		return findByDipartimento(dipartimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the righe rich b f c news where dipartimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dipartimento the dipartimento
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @return the range of matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByDipartimento(String dipartimento,
		int start, int end) {
		return findByDipartimento(dipartimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the righe rich b f c news where dipartimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dipartimento the dipartimento
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByDipartimento(String dipartimento,
		int start, int end, OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return findByDipartimento(dipartimento, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the righe rich b f c news where dipartimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dipartimento the dipartimento
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByDipartimento(String dipartimento,
		int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO;
			finderArgs = new Object[] { dipartimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DIPARTIMENTO;
			finderArgs = new Object[] {
					dipartimento,
					
					start, end, orderByComparator
				};
		}

		List<RigheRichBFCNew> list = null;

		if (retrieveFromCache) {
			list = (List<RigheRichBFCNew>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RigheRichBFCNew righeRichBFCNew : list) {
					if (!Objects.equals(dipartimento,
								righeRichBFCNew.getDipartimento())) {
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

			query.append(_SQL_SELECT_RIGHERICHBFCNEW_WHERE);

			boolean bindDipartimento = false;

			if (dipartimento == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1);
			}
			else if (dipartimento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3);
			}
			else {
				bindDipartimento = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RigheRichBFCNewModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDipartimento) {
					qPos.add(dipartimento);
				}

				if (!pagination) {
					list = (List<RigheRichBFCNew>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RigheRichBFCNew>)QueryUtil.list(q,
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
	 * Returns the first righe rich b f c new in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew findByDipartimento_First(String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException {
		RigheRichBFCNew righeRichBFCNew = fetchByDipartimento_First(dipartimento,
				orderByComparator);

		if (righeRichBFCNew != null) {
			return righeRichBFCNew;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dipartimento=");
		msg.append(dipartimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichBFCNewException(msg.toString());
	}

	/**
	 * Returns the first righe rich b f c new in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew fetchByDipartimento_First(String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		List<RigheRichBFCNew> list = findByDipartimento(dipartimento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last righe rich b f c new in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew findByDipartimento_Last(String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException {
		RigheRichBFCNew righeRichBFCNew = fetchByDipartimento_Last(dipartimento,
				orderByComparator);

		if (righeRichBFCNew != null) {
			return righeRichBFCNew;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dipartimento=");
		msg.append(dipartimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichBFCNewException(msg.toString());
	}

	/**
	 * Returns the last righe rich b f c new in the ordered set where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew fetchByDipartimento_Last(String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		int count = countByDipartimento(dipartimento);

		if (count == 0) {
			return null;
		}

		List<RigheRichBFCNew> list = findByDipartimento(dipartimento,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the righe rich b f c news before and after the current righe rich b f c new in the ordered set where dipartimento = &#63;.
	 *
	 * @param id the primary key of the current righe rich b f c new
	 * @param dipartimento the dipartimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew[] findByDipartimento_PrevAndNext(long id,
		String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException {
		RigheRichBFCNew righeRichBFCNew = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RigheRichBFCNew[] array = new RigheRichBFCNewImpl[3];

			array[0] = getByDipartimento_PrevAndNext(session, righeRichBFCNew,
					dipartimento, orderByComparator, true);

			array[1] = righeRichBFCNew;

			array[2] = getByDipartimento_PrevAndNext(session, righeRichBFCNew,
					dipartimento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RigheRichBFCNew getByDipartimento_PrevAndNext(Session session,
		RigheRichBFCNew righeRichBFCNew, String dipartimento,
		OrderByComparator<RigheRichBFCNew> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RIGHERICHBFCNEW_WHERE);

		boolean bindDipartimento = false;

		if (dipartimento == null) {
			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1);
		}
		else if (dipartimento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3);
		}
		else {
			bindDipartimento = true;

			query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2);
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
			query.append(RigheRichBFCNewModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDipartimento) {
			qPos.add(dipartimento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(righeRichBFCNew);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RigheRichBFCNew> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the righe rich b f c news where dipartimento = &#63; from the database.
	 *
	 * @param dipartimento the dipartimento
	 */
	@Override
	public void removeByDipartimento(String dipartimento) {
		for (RigheRichBFCNew righeRichBFCNew : findByDipartimento(
				dipartimento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(righeRichBFCNew);
		}
	}

	/**
	 * Returns the number of righe rich b f c news where dipartimento = &#63;.
	 *
	 * @param dipartimento the dipartimento
	 * @return the number of matching righe rich b f c news
	 */
	@Override
	public int countByDipartimento(String dipartimento) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIPARTIMENTO;

		Object[] finderArgs = new Object[] { dipartimento };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RIGHERICHBFCNEW_WHERE);

			boolean bindDipartimento = false;

			if (dipartimento == null) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1);
			}
			else if (dipartimento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3);
			}
			else {
				bindDipartimento = true;

				query.append(_FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDipartimento) {
					qPos.add(dipartimento);
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

	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_1 = "righeRichBFCNew.dipartimento IS NULL";
	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_2 = "righeRichBFCNew.dipartimento = ?";
	private static final String _FINDER_COLUMN_DIPARTIMENTO_DIPARTIMENTO_3 = "(righeRichBFCNew.dipartimento IS NULL OR righeRichBFCNew.dipartimento = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED,
			RigheRichBFCNewImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdRichiesta",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED,
			RigheRichBFCNewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdRichiesta",
			new String[] { Long.class.getName() },
			RigheRichBFCNewModelImpl.ID_RICH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDRICHIESTA = new FinderPath(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdRichiesta",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the righe rich b f c news where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @return the matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByIdRichiesta(long id_rich) {
		return findByIdRichiesta(id_rich, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the righe rich b f c news where id_rich = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_rich the id_rich
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @return the range of matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByIdRichiesta(long id_rich, int start,
		int end) {
		return findByIdRichiesta(id_rich, start, end, null);
	}

	/**
	 * Returns an ordered range of all the righe rich b f c news where id_rich = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_rich the id_rich
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByIdRichiesta(long id_rich, int start,
		int end, OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return findByIdRichiesta(id_rich, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the righe rich b f c news where id_rich = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_rich the id_rich
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findByIdRichiesta(long id_rich, int start,
		int end, OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] { id_rich };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] { id_rich, start, end, orderByComparator };
		}

		List<RigheRichBFCNew> list = null;

		if (retrieveFromCache) {
			list = (List<RigheRichBFCNew>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RigheRichBFCNew righeRichBFCNew : list) {
					if ((id_rich != righeRichBFCNew.getId_rich())) {
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

			query.append(_SQL_SELECT_RIGHERICHBFCNEW_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RigheRichBFCNewModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_rich);

				if (!pagination) {
					list = (List<RigheRichBFCNew>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RigheRichBFCNew>)QueryUtil.list(q,
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
	 * Returns the first righe rich b f c new in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew findByIdRichiesta_First(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException {
		RigheRichBFCNew righeRichBFCNew = fetchByIdRichiesta_First(id_rich,
				orderByComparator);

		if (righeRichBFCNew != null) {
			return righeRichBFCNew;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_rich=");
		msg.append(id_rich);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichBFCNewException(msg.toString());
	}

	/**
	 * Returns the first righe rich b f c new in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew fetchByIdRichiesta_First(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		List<RigheRichBFCNew> list = findByIdRichiesta(id_rich, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last righe rich b f c new in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew findByIdRichiesta_Last(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException {
		RigheRichBFCNew righeRichBFCNew = fetchByIdRichiesta_Last(id_rich,
				orderByComparator);

		if (righeRichBFCNew != null) {
			return righeRichBFCNew;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_rich=");
		msg.append(id_rich);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRigheRichBFCNewException(msg.toString());
	}

	/**
	 * Returns the last righe rich b f c new in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	 */
	@Override
	public RigheRichBFCNew fetchByIdRichiesta_Last(long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		int count = countByIdRichiesta(id_rich);

		if (count == 0) {
			return null;
		}

		List<RigheRichBFCNew> list = findByIdRichiesta(id_rich, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the righe rich b f c news before and after the current righe rich b f c new in the ordered set where id_rich = &#63;.
	 *
	 * @param id the primary key of the current righe rich b f c new
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew[] findByIdRichiesta_PrevAndNext(long id,
		long id_rich, OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException {
		RigheRichBFCNew righeRichBFCNew = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			RigheRichBFCNew[] array = new RigheRichBFCNewImpl[3];

			array[0] = getByIdRichiesta_PrevAndNext(session, righeRichBFCNew,
					id_rich, orderByComparator, true);

			array[1] = righeRichBFCNew;

			array[2] = getByIdRichiesta_PrevAndNext(session, righeRichBFCNew,
					id_rich, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RigheRichBFCNew getByIdRichiesta_PrevAndNext(Session session,
		RigheRichBFCNew righeRichBFCNew, long id_rich,
		OrderByComparator<RigheRichBFCNew> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RIGHERICHBFCNEW_WHERE);

		query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICH_2);

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
			query.append(RigheRichBFCNewModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_rich);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(righeRichBFCNew);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RigheRichBFCNew> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the righe rich b f c news where id_rich = &#63; from the database.
	 *
	 * @param id_rich the id_rich
	 */
	@Override
	public void removeByIdRichiesta(long id_rich) {
		for (RigheRichBFCNew righeRichBFCNew : findByIdRichiesta(id_rich,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(righeRichBFCNew);
		}
	}

	/**
	 * Returns the number of righe rich b f c news where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @return the number of matching righe rich b f c news
	 */
	@Override
	public int countByIdRichiesta(long id_rich) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDRICHIESTA;

		Object[] finderArgs = new Object[] { id_rich };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RIGHERICHBFCNEW_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_rich);

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

	private static final String _FINDER_COLUMN_IDRICHIESTA_ID_RICH_2 = "righeRichBFCNew.id_rich = ?";

	public RigheRichBFCNewPersistenceImpl() {
		setModelClass(RigheRichBFCNew.class);
	}

	/**
	 * Caches the righe rich b f c new in the entity cache if it is enabled.
	 *
	 * @param righeRichBFCNew the righe rich b f c new
	 */
	@Override
	public void cacheResult(RigheRichBFCNew righeRichBFCNew) {
		entityCache.putResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewImpl.class, righeRichBFCNew.getPrimaryKey(),
			righeRichBFCNew);

		righeRichBFCNew.resetOriginalValues();
	}

	/**
	 * Caches the righe rich b f c news in the entity cache if it is enabled.
	 *
	 * @param righeRichBFCNews the righe rich b f c news
	 */
	@Override
	public void cacheResult(List<RigheRichBFCNew> righeRichBFCNews) {
		for (RigheRichBFCNew righeRichBFCNew : righeRichBFCNews) {
			if (entityCache.getResult(
						RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
						RigheRichBFCNewImpl.class,
						righeRichBFCNew.getPrimaryKey()) == null) {
				cacheResult(righeRichBFCNew);
			}
			else {
				righeRichBFCNew.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all righe rich b f c news.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RigheRichBFCNewImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the righe rich b f c new.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RigheRichBFCNew righeRichBFCNew) {
		entityCache.removeResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewImpl.class, righeRichBFCNew.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RigheRichBFCNew> righeRichBFCNews) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RigheRichBFCNew righeRichBFCNew : righeRichBFCNews) {
			entityCache.removeResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
				RigheRichBFCNewImpl.class, righeRichBFCNew.getPrimaryKey());
		}
	}

	/**
	 * Creates a new righe rich b f c new with the primary key. Does not add the righe rich b f c new to the database.
	 *
	 * @param id the primary key for the new righe rich b f c new
	 * @return the new righe rich b f c new
	 */
	@Override
	public RigheRichBFCNew create(long id) {
		RigheRichBFCNew righeRichBFCNew = new RigheRichBFCNewImpl();

		righeRichBFCNew.setNew(true);
		righeRichBFCNew.setPrimaryKey(id);

		return righeRichBFCNew;
	}

	/**
	 * Removes the righe rich b f c new with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the righe rich b f c new
	 * @return the righe rich b f c new that was removed
	 * @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew remove(long id)
		throws NoSuchRigheRichBFCNewException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the righe rich b f c new with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the righe rich b f c new
	 * @return the righe rich b f c new that was removed
	 * @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew remove(Serializable primaryKey)
		throws NoSuchRigheRichBFCNewException {
		Session session = null;

		try {
			session = openSession();

			RigheRichBFCNew righeRichBFCNew = (RigheRichBFCNew)session.get(RigheRichBFCNewImpl.class,
					primaryKey);

			if (righeRichBFCNew == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRigheRichBFCNewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(righeRichBFCNew);
		}
		catch (NoSuchRigheRichBFCNewException nsee) {
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
	protected RigheRichBFCNew removeImpl(RigheRichBFCNew righeRichBFCNew) {
		righeRichBFCNew = toUnwrappedModel(righeRichBFCNew);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(righeRichBFCNew)) {
				righeRichBFCNew = (RigheRichBFCNew)session.get(RigheRichBFCNewImpl.class,
						righeRichBFCNew.getPrimaryKeyObj());
			}

			if (righeRichBFCNew != null) {
				session.delete(righeRichBFCNew);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (righeRichBFCNew != null) {
			clearCache(righeRichBFCNew);
		}

		return righeRichBFCNew;
	}

	@Override
	public RigheRichBFCNew updateImpl(RigheRichBFCNew righeRichBFCNew) {
		righeRichBFCNew = toUnwrappedModel(righeRichBFCNew);

		boolean isNew = righeRichBFCNew.isNew();

		RigheRichBFCNewModelImpl righeRichBFCNewModelImpl = (RigheRichBFCNewModelImpl)righeRichBFCNew;

		Session session = null;

		try {
			session = openSession();

			if (righeRichBFCNew.isNew()) {
				session.save(righeRichBFCNew);

				righeRichBFCNew.setNew(false);
			}
			else {
				righeRichBFCNew = (RigheRichBFCNew)session.merge(righeRichBFCNew);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RigheRichBFCNewModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((righeRichBFCNewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						righeRichBFCNewModelImpl.getOriginalDipartimento()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO,
					args);

				args = new Object[] { righeRichBFCNewModelImpl.getDipartimento() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIPARTIMENTO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIPARTIMENTO,
					args);
			}

			if ((righeRichBFCNewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						righeRichBFCNewModelImpl.getOriginalId_rich()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);

				args = new Object[] { righeRichBFCNewModelImpl.getId_rich() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);
			}
		}

		entityCache.putResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
			RigheRichBFCNewImpl.class, righeRichBFCNew.getPrimaryKey(),
			righeRichBFCNew, false);

		righeRichBFCNew.resetOriginalValues();

		return righeRichBFCNew;
	}

	protected RigheRichBFCNew toUnwrappedModel(RigheRichBFCNew righeRichBFCNew) {
		if (righeRichBFCNew instanceof RigheRichBFCNewImpl) {
			return righeRichBFCNew;
		}

		RigheRichBFCNewImpl righeRichBFCNewImpl = new RigheRichBFCNewImpl();

		righeRichBFCNewImpl.setNew(righeRichBFCNew.isNew());
		righeRichBFCNewImpl.setPrimaryKey(righeRichBFCNew.getPrimaryKey());

		righeRichBFCNewImpl.setId(righeRichBFCNew.getId());
		righeRichBFCNewImpl.setId_rich(righeRichBFCNew.getId_rich());
		righeRichBFCNewImpl.setDipartimento(righeRichBFCNew.getDipartimento());
		righeRichBFCNewImpl.setDati1(righeRichBFCNew.getDati1());
		righeRichBFCNewImpl.setDati2(righeRichBFCNew.getDati2());
		righeRichBFCNewImpl.setDati3(righeRichBFCNew.getDati3());
		righeRichBFCNewImpl.setDati4(righeRichBFCNew.getDati4());

		return righeRichBFCNewImpl;
	}

	/**
	 * Returns the righe rich b f c new with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the righe rich b f c new
	 * @return the righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRigheRichBFCNewException {
		RigheRichBFCNew righeRichBFCNew = fetchByPrimaryKey(primaryKey);

		if (righeRichBFCNew == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRigheRichBFCNewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return righeRichBFCNew;
	}

	/**
	 * Returns the righe rich b f c new with the primary key or throws a {@link NoSuchRigheRichBFCNewException} if it could not be found.
	 *
	 * @param id the primary key of the righe rich b f c new
	 * @return the righe rich b f c new
	 * @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew findByPrimaryKey(long id)
		throws NoSuchRigheRichBFCNewException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the righe rich b f c new with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the righe rich b f c new
	 * @return the righe rich b f c new, or <code>null</code> if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
				RigheRichBFCNewImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RigheRichBFCNew righeRichBFCNew = (RigheRichBFCNew)serializable;

		if (righeRichBFCNew == null) {
			Session session = null;

			try {
				session = openSession();

				righeRichBFCNew = (RigheRichBFCNew)session.get(RigheRichBFCNewImpl.class,
						primaryKey);

				if (righeRichBFCNew != null) {
					cacheResult(righeRichBFCNew);
				}
				else {
					entityCache.putResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
						RigheRichBFCNewImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
					RigheRichBFCNewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return righeRichBFCNew;
	}

	/**
	 * Returns the righe rich b f c new with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the righe rich b f c new
	 * @return the righe rich b f c new, or <code>null</code> if a righe rich b f c new with the primary key could not be found
	 */
	@Override
	public RigheRichBFCNew fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, RigheRichBFCNew> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RigheRichBFCNew> map = new HashMap<Serializable, RigheRichBFCNew>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RigheRichBFCNew righeRichBFCNew = fetchByPrimaryKey(primaryKey);

			if (righeRichBFCNew != null) {
				map.put(primaryKey, righeRichBFCNew);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
					RigheRichBFCNewImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RigheRichBFCNew)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RIGHERICHBFCNEW_WHERE_PKS_IN);

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

			for (RigheRichBFCNew righeRichBFCNew : (List<RigheRichBFCNew>)q.list()) {
				map.put(righeRichBFCNew.getPrimaryKeyObj(), righeRichBFCNew);

				cacheResult(righeRichBFCNew);

				uncachedPrimaryKeys.remove(righeRichBFCNew.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RigheRichBFCNewModelImpl.ENTITY_CACHE_ENABLED,
					RigheRichBFCNewImpl.class, primaryKey, nullModel);
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
	 * Returns all the righe rich b f c news.
	 *
	 * @return the righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the righe rich b f c news.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @return the range of righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the righe rich b f c news.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findAll(int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the righe rich b f c news.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of righe rich b f c news
	 * @param end the upper bound of the range of righe rich b f c news (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of righe rich b f c news
	 */
	@Override
	public List<RigheRichBFCNew> findAll(int start, int end,
		OrderByComparator<RigheRichBFCNew> orderByComparator,
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

		List<RigheRichBFCNew> list = null;

		if (retrieveFromCache) {
			list = (List<RigheRichBFCNew>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RIGHERICHBFCNEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RIGHERICHBFCNEW;

				if (pagination) {
					sql = sql.concat(RigheRichBFCNewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RigheRichBFCNew>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RigheRichBFCNew>)QueryUtil.list(q,
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
	 * Removes all the righe rich b f c news from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RigheRichBFCNew righeRichBFCNew : findAll()) {
			remove(righeRichBFCNew);
		}
	}

	/**
	 * Returns the number of righe rich b f c news.
	 *
	 * @return the number of righe rich b f c news
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RIGHERICHBFCNEW);

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
		return RigheRichBFCNewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the righe rich b f c new persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RigheRichBFCNewImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RIGHERICHBFCNEW = "SELECT righeRichBFCNew FROM RigheRichBFCNew righeRichBFCNew";
	private static final String _SQL_SELECT_RIGHERICHBFCNEW_WHERE_PKS_IN = "SELECT righeRichBFCNew FROM RigheRichBFCNew righeRichBFCNew WHERE id_ IN (";
	private static final String _SQL_SELECT_RIGHERICHBFCNEW_WHERE = "SELECT righeRichBFCNew FROM RigheRichBFCNew righeRichBFCNew WHERE ";
	private static final String _SQL_COUNT_RIGHERICHBFCNEW = "SELECT COUNT(righeRichBFCNew) FROM RigheRichBFCNew righeRichBFCNew";
	private static final String _SQL_COUNT_RIGHERICHBFCNEW_WHERE = "SELECT COUNT(righeRichBFCNew) FROM RigheRichBFCNew righeRichBFCNew WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "righeRichBFCNew.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RigheRichBFCNew exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RigheRichBFCNew exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RigheRichBFCNewPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}